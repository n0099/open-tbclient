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
/* loaded from: classes6.dex */
public class e {
    private static e gyG = new e();
    private static BdAsyncTaskParallel gyJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gyH = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> gyI = new ArrayList();

    public static e bHr() {
        return gyG;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.gyI) {
            if (!this.gyI.contains(aVar)) {
                this.gyI.add(aVar);
                Collections.sort(this.gyI);
            }
        }
    }

    public void bHs() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes6.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gyK = new ArrayList<>();
        final a.InterfaceC0420a gyL = new a.InterfaceC0420a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0420a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.gyK.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.gyJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.gyI.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.gyI.get(i2)).a(this.gyL);
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
            e.this.gyH = this.gyK;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean ws(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gyH.iterator();
        while (it.hasNext()) {
            if (it.next().ws(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean BR(String str) {
        if (str == null || !ws(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gyH.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ws(str)) {
                return next.aXe() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean BS(String str) {
        return com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.SHARP_TEXT_PREFIX);
    }

    public String BT(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                return substring.substring(0, substring.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
            }
        }
        return "";
    }

    public boolean BU(String str) {
        if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    public String ap(String str, boolean z) {
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

    public com.baidu.adp.widget.ImageView.a du(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap dv;
        com.baidu.adp.widget.ImageView.a wM = com.baidu.tbadk.imageManager.c.aYm().wM(str2);
        if (wM != null) {
            return wM;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gyH.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = wM;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ws(str2)) {
                aVar = next.wt(str2);
                break;
            }
        }
        if (aVar == null && str != null && (dv = dv(str, ap(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(dv, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ao(String str, boolean z) {
        if (!d.bHq().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.bHq().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.ws(str)) {
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
                com.baidu.tbadk.imageManager.c.aYm().b(ao(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.aYm().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bHt() {
        return this.gyH;
    }

    public Bitmap dv(String str, String str2) {
        return m.getImage(".emotions/" + str, str2);
    }
}
