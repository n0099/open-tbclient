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
    private static g ccd = new g();
    private static BdAsyncTaskParallel ccg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cce = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> ccf = new ArrayList();

    public static g acw() {
        return ccd;
    }

    private g() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.ccf) {
            if (!this.ccf.contains(aVar)) {
                this.ccf.add(aVar);
                Collections.sort(this.ccf);
            }
        }
    }

    public void acx() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cch = new ArrayList<>();
        final a.InterfaceC0055a cci = new a.InterfaceC0055a() { // from class: com.baidu.tieba.emotion.editortool.g.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0055a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.cch.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(g.ccg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.ccf.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) g.this.ccf.get(i2)).a(this.cci);
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
            g.this.cce = this.cch;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fC(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cce.iterator();
        while (it.hasNext()) {
            if (it.next().fC(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean jH(String str) {
        if (str == null || !fC(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cce.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fC(str)) {
                return next.CO() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean jI(String str) {
        return com.baidu.tbadk.imageManager.d.aFc.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.aFd);
    }

    public String jJ(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean jK(String str) {
        if (!com.baidu.tbadk.imageManager.d.aFc.equals(str) && str.startsWith("#(meme,")) {
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
            if (str.equals(com.baidu.tbadk.imageManager.d.aFc)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = k.xS + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.Ef() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a aQ(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap aR;
        com.baidu.adp.widget.ImageView.a gi = com.baidu.tbadk.imageManager.c.DZ().gi(str2);
        if (gi != null) {
            return gi;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cce.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = gi;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fC(str2)) {
                aVar = next.fD(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aR = aR(str, F(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(aR, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String E(String str, boolean z) {
        if (!f.acv().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = f.acv().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fC(str)) {
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
                com.baidu.tbadk.imageManager.c.DZ().b(E(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.DZ().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> acy() {
        return this.cce;
    }

    public Bitmap aR(String str, String str2) {
        return k.Y(".emotions/" + str, str2);
    }
}
