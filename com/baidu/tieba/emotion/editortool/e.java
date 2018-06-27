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
    private static e cOR = new e();
    private static BdAsyncTaskParallel cOU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cOS = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> cOT = new ArrayList();

    public static e anM() {
        return cOR;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.cOT) {
            if (!this.cOT.contains(aVar)) {
                this.cOT.add(aVar);
                Collections.sort(this.cOT);
            }
        }
    }

    public void anN() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cOV = new ArrayList<>();
        final a.InterfaceC0113a cOW = new a.InterfaceC0113a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0113a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cOV.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.cOU);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.cOT.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.cOT.get(i2)).a(this.cOW);
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
            e.this.cOS = this.cOV;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean gH(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cOS.iterator();
        while (it.hasNext()) {
            if (it.next().gH(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean lw(String str) {
        if (str == null || !gH(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cOS.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gH(str)) {
                return next.HN() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean lx(String str) {
        return com.baidu.tbadk.imageManager.d.aQs.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aQt);
    }

    public String ly(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean lz(String str) {
        if (!com.baidu.tbadk.imageManager.d.aQs.equals(str) && str.startsWith("#(meme,")) {
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
            if (str.equals(com.baidu.tbadk.imageManager.d.aQs)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(",")).contains("collect_")) {
                String str2 = l.CH + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.Ja() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a aW(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap aX;
        com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(str2);
        if (hi != null) {
            return hi;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cOS.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = hi;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gH(str2)) {
                aVar = next.gI(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aX = aX(str, A(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(aX, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String z(String str, boolean z) {
        if (!d.anL().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.anL().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.gH(str)) {
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
                com.baidu.tbadk.imageManager.c.IV().b(z(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.IV().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> anO() {
        return this.cOS;
    }

    public Bitmap aX(String str, String str2) {
        return l.ab(".emotions/" + str, str2);
    }
}
