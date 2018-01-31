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
    private static g dlW = new g();
    private static BdAsyncTaskParallel dlZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dlX = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> dlY = new ArrayList();

    public static g app() {
        return dlW;
    }

    private g() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.dlY) {
            if (!this.dlY.contains(aVar)) {
                this.dlY.add(aVar);
                Collections.sort(this.dlY);
            }
        }
    }

    public void apq() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dma = new ArrayList<>();
        final a.InterfaceC0082a dmb = new a.InterfaceC0082a() { // from class: com.baidu.tieba.emotion.editortool.g.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0082a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.dma.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(g.dlZ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.dlY.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) g.this.dlY.get(i2)).a(this.dmb);
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
            g.this.dlX = this.dma;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean gd(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlX.iterator();
        while (it.hasNext()) {
            if (it.next().gd(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean kG(String str) {
        if (str == null || !gd(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlX.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gd(str)) {
                return next.KL() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean kH(String str) {
        return com.baidu.tbadk.imageManager.d.buB.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.buC);
    }

    public String kI(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean kJ(String str) {
        if (!com.baidu.tbadk.imageManager.d.buB.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String G(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.buB)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.amf + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.LW() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.a.a aN(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aO;
        com.baidu.adp.widget.a.a gF = com.baidu.tbadk.imageManager.c.LR().gF(str2);
        if (gF != null) {
            return gF;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlX.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gF;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.gd(str2)) {
                aVar = next.ge(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aO = aO(str, G(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aO, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String F(String str, boolean z) {
        if (!f.apo().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = f.apo().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.gd(str)) {
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
                com.baidu.tbadk.imageManager.c.LR().b(F(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.LR().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apr() {
        return this.dlX;
    }

    public Bitmap aO(String str, String str2) {
        return k.W(".emotions/" + str, str2);
    }
}
