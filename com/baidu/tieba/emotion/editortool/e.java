package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e cGG = new e();
    private static BdAsyncTaskParallel cGJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cGH = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> cGI = new ArrayList();

    public static e akm() {
        return cGG;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.cGI) {
            if (!this.cGI.contains(aVar)) {
                this.cGI.add(aVar);
                Collections.sort(this.cGI);
            }
        }
    }

    public void akn() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cGK = new ArrayList<>();
        final a.InterfaceC0095a cGL = new a.InterfaceC0095a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0095a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cGK.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.cGJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.cGI.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.cGI.get(i2)).a(this.cGL);
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
            e.this.cGH = this.cGK;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean ge(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGH.iterator();
        while (it.hasNext()) {
            if (it.next().ge(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean kR(String str) {
        if (str == null || !ge(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGH.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ge(str)) {
                return next.DU() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean kS(String str) {
        return com.baidu.tbadk.imageManager.d.aGY.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aGZ);
    }

    public String kT(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean kU(String str) {
        if (!com.baidu.tbadk.imageManager.d.aGY.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String A(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.aGY)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.wB + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.Ff() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a aN(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap aO;
        com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(str2);
        if (gG != null) {
            return gG;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGH.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gG;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ge(str2)) {
                aVar = next.gf(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aO = aO(str, A(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(aO, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String z(String str, boolean z) {
        if (!d.akl().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.akl().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.ge(str)) {
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
                com.baidu.tbadk.imageManager.c.Fa().b(z(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Fa().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ako() {
        return this.cGH;
    }

    public Bitmap aO(String str, String str2) {
        return k.Y(".emotions/" + str, str2);
    }
}
