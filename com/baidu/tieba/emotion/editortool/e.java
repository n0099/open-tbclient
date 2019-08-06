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
    private static e eVn = new e();
    private static BdAsyncTaskParallel eVq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eVo = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> eVp = new ArrayList();

    public static e beZ() {
        return eVn;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.eVp) {
            if (!this.eVp.contains(aVar)) {
                this.eVp.add(aVar);
                Collections.sort(this.eVp);
            }
        }
    }

    public void bfa() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes2.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eVr = new ArrayList<>();
        final a.InterfaceC0253a eVs = new a.InterfaceC0253a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0253a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.eVr.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.eVq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.eVp.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.eVp.get(i2)).a(this.eVs);
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
            e.this.eVo = this.eVr;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean qi(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVo.iterator();
        while (it.hasNext()) {
            if (it.next().qi(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean vT(String str) {
        if (str == null || !qi(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVo.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.qi(str)) {
                return next.asq() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean vU(String str) {
        return com.baidu.tbadk.imageManager.d.cwm.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.cwn);
    }

    public String vV(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean vW(String str) {
        if (!com.baidu.tbadk.imageManager.d.cwm.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String aj(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.cwm)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = m.Dz + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.atD() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a cN(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap cO;
        com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.aty().qH(str2);
        if (qH != null) {
            return qH;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVo.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = qH;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.qi(str2)) {
                aVar = next.qj(str2);
                break;
            }
        }
        if (aVar == null && str != null && (cO = cO(str, aj(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(cO, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ai(String str, boolean z) {
        if (!d.beY().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.beY().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.qi(str)) {
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
                com.baidu.tbadk.imageManager.c.aty().b(ai(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.aty().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bfb() {
        return this.eVo;
    }

    public Bitmap cO(String str, String str2) {
        return m.bP(".emotions/" + str, str2);
    }
}
