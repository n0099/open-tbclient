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
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> csy = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> csz = new ArrayList();
    private static g csx = new g();
    private static BdAsyncTaskParallel csA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    public static g agH() {
        return csx;
    }

    private g() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.csz) {
            if (!this.csz.contains(aVar)) {
                this.csz.add(aVar);
                Collections.sort(this.csz);
            }
        }
    }

    public void agI() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> csB = new ArrayList<>();
        final a.InterfaceC0069a csC = new a.InterfaceC0069a() { // from class: com.baidu.tieba.emotion.editortool.g.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0069a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.csB.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(g.csA);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.csz.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) g.this.csz.get(i2)).a(this.csC);
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
            g.this.csy = this.csB;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fO(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csy.iterator();
        while (it.hasNext()) {
            if (it.next().fO(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean kl(String str) {
        if (str == null || !fO(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csy.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fO(str)) {
                return next.Dt() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean km(String str) {
        return com.baidu.tbadk.imageManager.d.aGm.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aGn);
    }

    public String kn(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean ko(String str) {
        if (!com.baidu.tbadk.imageManager.d.aGm.equals(str) && str.startsWith("#(meme,")) {
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
            if (str.equals(com.baidu.tbadk.imageManager.d.aGm)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.xQ + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.EG() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.a.a aP(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aQ;
        com.baidu.adp.widget.a.a gr = com.baidu.tbadk.imageManager.c.EA().gr(str2);
        if (gr != null) {
            return gr;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csy.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gr;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fO(str2)) {
                aVar = next.fP(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aQ = aQ(str, F(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aQ, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String k(String str, boolean z) {
        if (!f.agG().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = f.agG().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fO(str)) {
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
                com.baidu.tbadk.imageManager.c.EA().b(k(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.EA().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> agJ() {
        return this.csy;
    }

    public Bitmap aQ(String str, String str2) {
        return k.X(".emotions/" + str, str2);
    }
}
