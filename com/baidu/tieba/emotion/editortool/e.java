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
    private static e eVg = new e();
    private static BdAsyncTaskParallel eVj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eVh = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> eVi = new ArrayList();

    public static e beX() {
        return eVg;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.eVi) {
            if (!this.eVi.contains(aVar)) {
                this.eVi.add(aVar);
                Collections.sort(this.eVi);
            }
        }
    }

    public void beY() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes2.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eVk = new ArrayList<>();
        final a.InterfaceC0248a eVl = new a.InterfaceC0248a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0248a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.eVk.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.eVj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.eVi.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.eVi.get(i2)).a(this.eVl);
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
            e.this.eVh = this.eVk;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean qi(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVh.iterator();
        while (it.hasNext()) {
            if (it.next().qi(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean vS(String str) {
        if (str == null || !qi(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVh.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.qi(str)) {
                return next.aso() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean vT(String str) {
        return com.baidu.tbadk.imageManager.d.cwf.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.cwg);
    }

    public String vU(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean vV(String str) {
        if (!com.baidu.tbadk.imageManager.d.cwf.equals(str) && str.startsWith("#(meme,")) {
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
            if (str.equals(com.baidu.tbadk.imageManager.d.cwf)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = m.Dz + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.atB() + "/" + substring.replace("collect_", "");
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
        com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.atw().qH(str2);
        if (qH != null) {
            return qH;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVh.iterator();
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
        if (!d.beW().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.beW().getGroups();
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
                com.baidu.tbadk.imageManager.c.atw().b(ai(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.atw().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> beZ() {
        return this.eVh;
    }

    public Bitmap cO(String str, String str2) {
        return m.bP(".emotions/" + str, str2);
    }
}
