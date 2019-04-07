package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
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
    private static e eAB = new e();
    private static BdAsyncTaskParallel eAE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAC = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> eAD = new ArrayList();

    public static e aVK() {
        return eAB;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.eAD) {
            if (!this.eAD.contains(aVar)) {
                this.eAD.add(aVar);
                Collections.sort(this.eAD);
            }
        }
    }

    public void aVL() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes2.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAF = new ArrayList<>();
        final a.InterfaceC0236a eAG = new a.InterfaceC0236a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0236a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.eAF.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.eAE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.eAD.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.eAD.get(i2)).a(this.eAG);
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
            e.this.eAC = this.eAF;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean oK(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAC.iterator();
        while (it.hasNext()) {
            if (it.next().oK(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean tU(String str) {
        if (str == null || !oK(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAC.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.oK(str)) {
                return next.amf() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean tV(String str) {
        return com.baidu.tbadk.imageManager.d.cmH.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.cmI);
    }

    public String tW(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean tX(String str) {
        if (!com.baidu.tbadk.imageManager.d.cmH.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String ad(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.cmH)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = m.FK + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.anr() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a cA(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap cB;
        com.baidu.adp.widget.ImageView.a pj = com.baidu.tbadk.imageManager.c.anm().pj(str2);
        if (pj != null) {
            return pj;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAC.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = pj;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.oK(str2)) {
                aVar = next.oL(str2);
                break;
            }
        }
        if (aVar == null && str != null && (cB = cB(str, ad(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(cB, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ac(String str, boolean z) {
        if (!d.aVJ().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.aVJ().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.oK(str)) {
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
                com.baidu.tbadk.imageManager.c.anm().b(ac(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.anm().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVM() {
        return this.eAC;
    }

    public Bitmap cB(String str, String str2) {
        return m.bF(".emotions/" + str, str2);
    }
}
