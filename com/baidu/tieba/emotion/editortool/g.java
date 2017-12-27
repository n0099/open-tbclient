package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g dgZ = new g();
    private static BdAsyncTaskParallel dhc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dha = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> dhb = new ArrayList();

    public static g aoh() {
        return dgZ;
    }

    private g() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.dhb) {
            if (!this.dhb.contains(aVar)) {
                this.dhb.add(aVar);
                Collections.sort(this.dhb);
            }
        }
    }

    public void aoi() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dhd = new ArrayList<>();
        final a.InterfaceC0082a dhe = new a.InterfaceC0082a() { // from class: com.baidu.tieba.emotion.editortool.g.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0082a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.dhd.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(g.dhc);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.dhb.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) g.this.dhb.get(i2)).a(this.dhe);
                    i = i2 + 1;
                } else {
                    return null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r4) {
            super.onPostExecute(r4);
            g.this.dha = this.dhd;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fV(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dha.iterator();
        while (it.hasNext()) {
            if (it.next().fV(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean kr(String str) {
        if (str == null || !fV(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dha.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fV(str)) {
                return next.KU() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean ks(String str) {
        return com.baidu.tbadk.imageManager.d.buj.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.buk);
    }

    public String kt(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean ku(String str) {
        if (!com.baidu.tbadk.imageManager.d.buj.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String G(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.buj)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.amc + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.Mg() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.a.a aO(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aP;
        com.baidu.adp.widget.a.a gx = com.baidu.tbadk.imageManager.c.Mb().gx(str2);
        if (gx != null) {
            return gx;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dha.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gx;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fV(str2)) {
                aVar = next.fW(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aP = aP(str, G(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aP, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String F(String str, boolean z) {
        if (!f.aog().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = f.aog().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fV(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return str;
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null) {
            if (z) {
                com.baidu.tbadk.imageManager.c.Mb().b(F(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Mb().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aoj() {
        return this.dha;
    }

    public Bitmap aP(String str, String str2) {
        return k.W(".emotions/" + str, str2);
    }
}
