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
    private static e cXo = new e();
    private static BdAsyncTaskParallel cXr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cXp = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> cXq = new ArrayList();

    public static e aqa() {
        return cXo;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.cXq) {
            if (!this.cXq.contains(aVar)) {
                this.cXq.add(aVar);
                Collections.sort(this.cXq);
            }
        }
    }

    public void aqb() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cXs = new ArrayList<>();
        final a.InterfaceC0110a cXt = new a.InterfaceC0110a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0110a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cXs.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.cXr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.cXq.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.cXq.get(i2)).a(this.cXt);
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
            e.this.cXp = this.cXs;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean gZ(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cXp.iterator();
        while (it.hasNext()) {
            if (it.next().gZ(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean lZ(String str) {
        if (str == null || !gZ(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cXp.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gZ(str)) {
                return next.IY() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean ma(String str) {
        return com.baidu.tbadk.imageManager.d.aTH.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aTI);
    }

    public String mb(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean mc(String str) {
        if (!com.baidu.tbadk.imageManager.d.aTH.equals(str) && str.startsWith("#(meme,")) {
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
            if (str.equals(com.baidu.tbadk.imageManager.d.aTH)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(",")).contains("collect_")) {
                String str2 = l.EZ + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.Kl() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a bc(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap bd;
        com.baidu.adp.widget.ImageView.a hA = com.baidu.tbadk.imageManager.c.Kg().hA(str2);
        if (hA != null) {
            return hA;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cXp.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = hA;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gZ(str2)) {
                aVar = next.ha(str2);
                break;
            }
        }
        if (aVar == null && str != null && (bd = bd(str, A(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(bd, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String z(String str, boolean z) {
        if (!d.apZ().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.apZ().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.gZ(str)) {
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
                com.baidu.tbadk.imageManager.c.Kg().b(z(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Kg().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aqc() {
        return this.cXp;
    }

    public Bitmap bd(String str, String str2) {
        return l.ah(".emotions/" + str, str2);
    }
}
