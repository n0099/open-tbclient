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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private static e iGE = new e();
    private static BdAsyncTaskParallel iGH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iGF = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> iGG = new ArrayList();

    public static e cuO() {
        return iGE;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.iGG) {
            if (!this.iGG.contains(aVar)) {
                this.iGG.add(aVar);
                Collections.sort(this.iGG);
            }
        }
    }

    public void cuP() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes8.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iGI = new ArrayList<>();
        final a.InterfaceC0573a iGJ = new a.InterfaceC0573a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0573a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.iGI.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.iGH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.iGG.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.iGG.get(i2)).a(this.iGJ);
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
            e.this.iGF = this.iGI;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean CP(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGF.iterator();
        while (it.hasNext()) {
            if (it.next().CP(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean Jd(String str) {
        if (str == null || !CP(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CP(str)) {
                return next.bBB() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean Je(String str) {
        return com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX);
    }

    public String Jf(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                return substring.substring(0, substring.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
            }
        }
        return "";
    }

    public boolean Jg(String str) {
        if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    public String aM(String str, boolean z) {
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
                String str2 = o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a eP(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap eQ;
        com.baidu.adp.widget.ImageView.a Dk = com.baidu.tbadk.imageManager.c.bCP().Dk(str2);
        if (Dk != null) {
            return Dk;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGF.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = Dk;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CP(str2)) {
                aVar = next.CQ(str2);
                break;
            }
        }
        if (aVar == null && str != null && (eQ = eQ(str, aM(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(eQ, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String aL(String str, boolean z) {
        if (!d.cuN().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.cuN().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.CP(str)) {
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
                com.baidu.tbadk.imageManager.c.bCP().b(aL(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.bCP().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cuQ() {
        return this.iGF;
    }

    public Bitmap eQ(String str, String str2) {
        return o.getImage(".emotions/" + str, str2);
    }
}
