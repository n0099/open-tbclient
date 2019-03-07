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
    private static e eAU = new e();
    private static BdAsyncTaskParallel eAX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAV = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> eAW = new ArrayList();

    public static e aVM() {
        return eAU;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.eAW) {
            if (!this.eAW.contains(aVar)) {
                this.eAW.add(aVar);
                Collections.sort(this.eAW);
            }
        }
    }

    public void aVN() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes2.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAY = new ArrayList<>();
        final a.InterfaceC0202a eAZ = new a.InterfaceC0202a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0202a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.eAY.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.eAX);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.eAW.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.eAW.get(i2)).a(this.eAZ);
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
            e.this.eAV = this.eAY;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean oJ(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAV.iterator();
        while (it.hasNext()) {
            if (it.next().oJ(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean tW(String str) {
        if (str == null || !oJ(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAV.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.oJ(str)) {
                return next.amj() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean tX(String str) {
        return com.baidu.tbadk.imageManager.d.cmF.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.cmG);
    }

    public String tY(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean tZ(String str) {
        if (!com.baidu.tbadk.imageManager.d.cmF.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String ac(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.cmF)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = m.FK + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.anv() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a cz(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap cA;
        com.baidu.adp.widget.ImageView.a pi = com.baidu.tbadk.imageManager.c.anq().pi(str2);
        if (pi != null) {
            return pi;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAV.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = pi;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.oJ(str2)) {
                aVar = next.oK(str2);
                break;
            }
        }
        if (aVar == null && str != null && (cA = cA(str, ac(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(cA, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ab(String str, boolean z) {
        if (!d.aVL().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.aVL().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.oJ(str)) {
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
                com.baidu.tbadk.imageManager.c.anq().b(ab(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.anq().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVO() {
        return this.eAV;
    }

    public Bitmap cA(String str, String str2) {
        return m.bF(".emotions/" + str, str2);
    }
}
