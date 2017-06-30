package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private static z bSi = new z();
    private static BdAsyncTaskParallel bSl = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bSj = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bSk = new ArrayList();

    public static z aam() {
        return bSi;
    }

    private z() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bSk) {
            if (!this.bSk.contains(aVar)) {
                this.bSk.add(aVar);
                Collections.sort(this.bSk);
            }
        }
    }

    public void aan() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bSm = new ArrayList<>();
        final a.InterfaceC0045a bSn = new aa(this);

        public a() {
            setPriority(4);
            setParallel(z.bSl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < z.this.bSk.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) z.this.bSk.get(i2)).a(this.bSn);
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
            z.this.bSj = this.bSm;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fA(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bSj.iterator();
        while (it.hasNext()) {
            if (it.next().fA(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean jm(String str) {
        if (str == null || !fA(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bSj.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fA(str)) {
                return next.CV() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean jn(String str) {
        return com.baidu.tbadk.imageManager.f.aDU.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.f.aDV);
    }

    public String jo(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean jp(String str) {
        if (!com.baidu.tbadk.imageManager.f.aDU.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String H(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.f.aDU)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = com.baidu.tbadk.core.util.n.yu + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.f.Ef() + "/" + substring.replace("collect_", "");
                if (z) {
                    return String.valueOf(str2) + "_b.gif";
                }
                return String.valueOf(str2) + "_s.jpg";
            }
            long hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            String str3 = String.valueOf(z ? "d_" : "s_") + hashCode;
            if (z) {
                return String.valueOf(str3) + ".gif";
            }
            return String.valueOf(str3) + ".jpg";
        }
        long hashCode2 = str.hashCode();
        if (hashCode2 < 0) {
            hashCode2 *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode2;
    }

    public com.baidu.adp.widget.a.a aK(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aL;
        com.baidu.adp.widget.a.a ge = com.baidu.tbadk.imageManager.c.Eb().ge(str2);
        if (ge != null) {
            return ge;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bSj.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = ge;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fA(str2)) {
                aVar = next.fB(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aL = aL(str, H(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aL, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String G(String str, boolean z) {
        if (!y.aal().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = y.aal().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fA(str)) {
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
                com.baidu.tbadk.imageManager.c.Eb().b(G(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Eb().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aao() {
        return this.bSj;
    }

    public Bitmap aL(String str, String str2) {
        return com.baidu.tbadk.core.util.n.V(".emotions/" + str, str2);
    }
}
