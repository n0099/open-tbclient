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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static e eYO = new e();
    private static BdAsyncTaskParallel eYR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eYP = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> eYQ = new ArrayList();

    public static e bdv() {
        return eYO;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.eYQ) {
            if (!this.eYQ.contains(aVar)) {
                this.eYQ.add(aVar);
                Collections.sort(this.eYQ);
            }
        }
    }

    public void bdw() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes2.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eYS = new ArrayList<>();
        final a.InterfaceC0289a eYT = new a.InterfaceC0289a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0289a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.eYS.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.eYR);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.eYQ.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.eYQ.get(i2)).a(this.eYT);
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
            e.this.eYP = this.eYS;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean pC(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eYP.iterator();
        while (it.hasNext()) {
            if (it.next().pC(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean uQ(String str) {
        if (str == null || !pC(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eYP.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.pC(str)) {
                return next.aum() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean uR(String str) {
        return com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX);
    }

    public String uS(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                return substring.substring(0, substring.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
            }
        }
        return "";
    }

    public boolean uT(String str) {
        if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    public String af(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a cC(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap cD;
        com.baidu.adp.widget.ImageView.a pY = com.baidu.tbadk.imageManager.c.avs().pY(str2);
        if (pY != null) {
            return pY;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eYP.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = pY;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.pC(str2)) {
                aVar = next.pD(str2);
                break;
            }
        }
        if (aVar == null && str != null && (cD = cD(str, af(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(cD, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ae(String str, boolean z) {
        if (!d.bdu().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.bdu().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.pC(str)) {
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
                com.baidu.tbadk.imageManager.c.avs().b(ae(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.avs().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bdx() {
        return this.eYP;
    }

    public Bitmap cD(String str, String str2) {
        return m.getImage(".emotions/" + str, str2);
    }
}
