package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g bYo = new g();
    private static BdAsyncTaskParallel bYr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bYp = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bYq = new ArrayList();

    public static g aby() {
        return bYo;
    }

    private g() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bYq) {
            if (!this.bYq.contains(aVar)) {
                this.bYq.add(aVar);
                Collections.sort(this.bYq);
            }
        }
    }

    public void abz() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bYs = new ArrayList<>();
        final a.InterfaceC0054a bYt = new a.InterfaceC0054a() { // from class: com.baidu.tieba.emotion.editortool.g.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0054a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.bYs.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(g.bYr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.bYq.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) g.this.bYq.get(i2)).a(this.bYt);
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
            g.this.bYp = this.bYs;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fK(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bYp.iterator();
        while (it.hasNext()) {
            if (it.next().fK(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean jy(String str) {
        if (str == null || !fK(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bYp.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fK(str)) {
                return next.Dp() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean jz(String str) {
        return com.baidu.tbadk.imageManager.d.aGr.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aGs);
    }

    public String jA(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean jB(String str) {
        if (!com.baidu.tbadk.imageManager.d.aGr.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String I(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.aGr)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.zW + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.EC() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.a.a aL(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aM;
        com.baidu.adp.widget.a.a gp = com.baidu.tbadk.imageManager.c.Ex().gp(str2);
        if (gp != null) {
            return gp;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bYp.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gp;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fK(str2)) {
                aVar = next.fL(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aM = aM(str, I(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aM, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String H(String str, boolean z) {
        if (!f.abx().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = f.abx().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fK(str)) {
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
                com.baidu.tbadk.imageManager.c.Ex().b(H(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Ex().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> abA() {
        return this.bYp;
    }

    public Bitmap aM(String str, String str2) {
        return k.V(".emotions/" + str, str2);
    }
}
