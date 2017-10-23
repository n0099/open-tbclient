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
    private static g cbR = new g();
    private static BdAsyncTaskParallel cbU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbS = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> cbT = new ArrayList();

    public static g acs() {
        return cbR;
    }

    private g() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.cbT) {
            if (!this.cbT.contains(aVar)) {
                this.cbT.add(aVar);
                Collections.sort(this.cbT);
            }
        }
    }

    public void act() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbV = new ArrayList<>();
        final a.InterfaceC0055a cbW = new a.InterfaceC0055a() { // from class: com.baidu.tieba.emotion.editortool.g.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0055a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cbV.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(g.cbU);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.cbT.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) g.this.cbT.get(i2)).a(this.cbW);
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
            g.this.cbS = this.cbV;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fB(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbS.iterator();
        while (it.hasNext()) {
            if (it.next().fB(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean jG(String str) {
        if (str == null || !fB(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbS.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fB(str)) {
                return next.CI() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean jH(String str) {
        return com.baidu.tbadk.imageManager.d.aEP.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aEQ);
    }

    public String jI(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean jJ(String str) {
        if (!com.baidu.tbadk.imageManager.d.aEP.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String F(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.aEP)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.xT + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.DZ() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a aP(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap aQ;
        com.baidu.adp.widget.ImageView.a gh = com.baidu.tbadk.imageManager.c.DT().gh(str2);
        if (gh != null) {
            return gh;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbS.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gh;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fB(str2)) {
                aVar = next.fC(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aQ = aQ(str, F(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(aQ, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String E(String str, boolean z) {
        if (!f.acr().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = f.acr().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fB(str)) {
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
                com.baidu.tbadk.imageManager.c.DT().b(E(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.DT().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> acu() {
        return this.cbS;
    }

    public Bitmap aQ(String str, String str2) {
        return k.X(".emotions/" + str, str2);
    }
}
