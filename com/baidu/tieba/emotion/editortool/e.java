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
    private static e eQg = new e();
    private static BdAsyncTaskParallel eQj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eQh = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> eQi = new ArrayList();

    public static e bcV() {
        return eQg;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.eQi) {
            if (!this.eQi.contains(aVar)) {
                this.eQi.add(aVar);
                Collections.sort(this.eQi);
            }
        }
    }

    public void bcW() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes2.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eQk = new ArrayList<>();
        final a.InterfaceC0251a eQl = new a.InterfaceC0251a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0251a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.eQk.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.eQj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.eQi.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.eQi.get(i2)).a(this.eQl);
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
            e.this.eQh = this.eQk;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean pR(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eQh.iterator();
        while (it.hasNext()) {
            if (it.next().pR(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean vn(String str) {
        if (str == null || !pR(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eQh.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.pR(str)) {
                return next.ari() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean vo(String str) {
        return com.baidu.tbadk.imageManager.d.cuR.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.cuS);
    }

    public String vp(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public boolean vq(String str) {
        if (!com.baidu.tbadk.imageManager.d.cuR.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP));
            return substring.contains("_") && !substring.contains("collect_");
        }
        return false;
    }

    public String af(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.cuR)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).contains("collect_")) {
                String str2 = m.Dt + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.asu() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a cM(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap cN;
        com.baidu.adp.widget.ImageView.a qq = com.baidu.tbadk.imageManager.c.asp().qq(str2);
        if (qq != null) {
            return qq;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eQh.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = qq;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.pR(str2)) {
                aVar = next.pS(str2);
                break;
            }
        }
        if (aVar == null && str != null && (cN = cN(str, af(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(cN, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String ae(String str, boolean z) {
        if (!d.bcU().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.bcU().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.pR(str)) {
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
                com.baidu.tbadk.imageManager.c.asp().b(ae(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.asp().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bcX() {
        return this.eQh;
    }

    public Bitmap cN(String str, String str2) {
        return m.bP(".emotions/" + str, str2);
    }
}
