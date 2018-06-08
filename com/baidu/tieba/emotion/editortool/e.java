package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e cQW = new e();
    private static BdAsyncTaskParallel cQZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cQX = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> cQY = new ArrayList();

    public static e aos() {
        return cQW;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.cQY) {
            if (!this.cQY.contains(aVar)) {
                this.cQY.add(aVar);
                Collections.sort(this.cQY);
            }
        }
    }

    public void aot() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRa = new ArrayList<>();
        final a.InterfaceC0112a cRb = new a.InterfaceC0112a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0112a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cRa.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.cQZ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.cQY.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.cQY.get(i2)).a(this.cRb);
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
            e.this.cQX = this.cRa;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean gD(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cQX.iterator();
        while (it.hasNext()) {
            if (it.next().gD(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean lA(String str) {
        if (str == null || !gD(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cQX.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gD(str)) {
                return next.Hv() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean lB(String str) {
        return com.baidu.tbadk.imageManager.d.aPw.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aPx);
    }

    public String lC(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean lD(String str) {
        if (!com.baidu.tbadk.imageManager.d.aPw.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
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
            if (str.equals(com.baidu.tbadk.imageManager.d.aPw)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(",")).contains("collect_")) {
                String str2 = l.CF + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.II() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a aV(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap aW;
        com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.ID().he(str2);
        if (he != null) {
            return he;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cQX.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = he;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gD(str2)) {
                aVar = next.gE(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aW = aW(str, A(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(aW, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String z(String str, boolean z) {
        if (!d.aor().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.aor().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.gD(str)) {
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
                com.baidu.tbadk.imageManager.c.ID().b(z(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.ID().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aou() {
        return this.cQX;
    }

    public Bitmap aW(String str, String str2) {
        return l.ab(".emotions/" + str, str2);
    }
}
