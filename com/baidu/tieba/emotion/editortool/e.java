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
/* loaded from: classes4.dex */
public class e {
    private static e fNw = new e();
    private static BdAsyncTaskParallel fNz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fNx = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> fNy = new ArrayList();

    public static e buR() {
        return fNw;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.fNy) {
            if (!this.fNy.contains(aVar)) {
                this.fNy.add(aVar);
                Collections.sort(this.fNy);
            }
        }
    }

    public void buS() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes4.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fNA = new ArrayList<>();
        final a.InterfaceC0377a fNB = new a.InterfaceC0377a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0377a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.fNA.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.fNz);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.fNy.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.fNy.get(i2)).a(this.fNB);
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
            e.this.fNx = this.fNA;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean uI(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fNx.iterator();
        while (it.hasNext()) {
            if (it.next().uI(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean zI(String str) {
        if (str == null || !uI(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fNx.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.uI(str)) {
                return next.aLR() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean zJ(String str) {
        return com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX);
    }

    public String zK(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                return substring.substring(0, substring.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
            }
        }
        return "";
    }

    public boolean zL(String str) {
        if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    public String aj(String str, boolean z) {
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

    public com.baidu.adp.widget.ImageView.a cW(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap cX;
        com.baidu.adp.widget.ImageView.a vb = com.baidu.tbadk.imageManager.c.aMZ().vb(str2);
        if (vb != null) {
            return vb;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fNx.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = vb;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.uI(str2)) {
                aVar = next.uJ(str2);
                break;
            }
        }
        if (aVar == null && str != null && (cX = cX(str, aj(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(cX, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ai(String str, boolean z) {
        if (!d.buQ().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.buQ().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.uI(str)) {
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
                com.baidu.tbadk.imageManager.c.aMZ().b(ai(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.aMZ().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> buT() {
        return this.fNx;
    }

    public Bitmap cX(String str, String str2) {
        return m.getImage(".emotions/" + str, str2);
    }
}
