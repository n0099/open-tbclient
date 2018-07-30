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
    private static e cRA = new e();
    private static BdAsyncTaskParallel cRD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRB = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> cRC = new ArrayList();

    public static e aol() {
        return cRA;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.cRC) {
            if (!this.cRC.contains(aVar)) {
                this.cRC.add(aVar);
                Collections.sort(this.cRC);
            }
        }
    }

    public void aom() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRE = new ArrayList<>();
        final a.InterfaceC0110a cRF = new a.InterfaceC0110a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0110a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cRE.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.cRD);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.cRC.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.cRC.get(i2)).a(this.cRF);
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
            e.this.cRB = this.cRE;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean gD(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cRB.iterator();
        while (it.hasNext()) {
            if (it.next().gD(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean lv(String str) {
        if (str == null || !gD(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cRB.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gD(str)) {
                return next.HI() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean lw(String str) {
        return com.baidu.tbadk.imageManager.d.aQs.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aQt);
    }

    public String lx(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean ly(String str) {
        if (!com.baidu.tbadk.imageManager.d.aQs.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String z(String str, boolean z) {
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
                String str2 = l.CD + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.IV() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a aU(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap aV;
        com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.IQ().he(str2);
        if (he != null) {
            return he;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cRB.iterator();
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
        if (aVar == null && str != null && (aV = aV(str, z(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(aV, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String y(String str, boolean z) {
        if (!d.aok().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.aok().getGroups();
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
                com.baidu.tbadk.imageManager.c.IQ().b(y(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.IQ().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aon() {
        return this.cRB;
    }

    public Bitmap aV(String str, String str2) {
        return l.aa(".emotions/" + str, str2);
    }
}
