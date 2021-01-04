package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private static e iFB = new e();
    private static BdAsyncTaskParallel iFE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iFC = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> iFD = new ArrayList();

    public static e cxt() {
        return iFB;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.iFD) {
            if (!this.iFD.contains(aVar)) {
                this.iFD.add(aVar);
                Collections.sort(this.iFD);
            }
        }
    }

    public void cxu() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes8.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iFF = new ArrayList<>();
        final a.InterfaceC0593a iFG = new a.InterfaceC0593a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0593a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.iFF.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.iFE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.iFD.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.iFD.get(i2)).a(this.iFG);
                    i = i2 + 1;
                } else {
                    return null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r4) {
            super.onPostExecute((a) r4);
            e.this.iFC = this.iFF;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean DK(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iFC.iterator();
        while (it.hasNext()) {
            if (it.next().DK(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean JE(String str) {
        if (str == null || !DK(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iFC.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DK(str)) {
                return next.bFc() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean JF(String str) {
        return com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX);
    }

    public String JG(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                return substring.substring(0, substring.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
            }
        }
        return "";
    }

    public boolean JH(String str) {
        if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    public String aN(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(",")).contains("collect_")) {
                String str2 = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + substring.replace("collect_", "");
                if (z) {
                    return str2 + "_b.gif";
                }
                return str2 + "_s.jpg";
            }
            long hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            String str3 = (z ? "d_" : "s_") + hashCode;
            if (z) {
                return str3 + ".gif";
            }
            return str3 + ".jpg";
        }
        long hashCode2 = str.hashCode();
        if (hashCode2 < 0) {
            hashCode2 *= -1;
        }
        return (z ? "d_" : "s_") + hashCode2;
    }

    public com.baidu.adp.widget.ImageView.a eQ(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap eR;
        com.baidu.adp.widget.ImageView.a Ef = com.baidu.tbadk.imageManager.c.bGp().Ef(str2);
        if (Ef != null) {
            return Ef;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iFC.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = Ef;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DK(str2)) {
                aVar = next.DL(str2);
                break;
            }
        }
        if (aVar == null && str != null && (eR = eR(str, aN(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(eR, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String aM(String str, boolean z) {
        if (!d.cxs().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.cxs().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.DK(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return str;
    }

    public void c(String str, com.baidu.adp.widget.ImageView.a aVar, boolean z) {
        if (aVar != null) {
            if (z) {
                com.baidu.tbadk.imageManager.c.bGp().b(aM(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.bGp().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cxv() {
        return this.iFC;
    }

    public Bitmap eR(String str, String str2) {
        return n.getImage(".emotions/" + str, str2);
    }
}
