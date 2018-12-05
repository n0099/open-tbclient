package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    private static e dnt = new e();
    private static BdAsyncTaskParallel dnw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dnu = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> dnv = new ArrayList();

    public static e auI() {
        return dnt;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.dnv) {
            if (!this.dnv.contains(aVar)) {
                this.dnv.add(aVar);
                Collections.sort(this.dnv);
            }
        }
    }

    public void auJ() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes5.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dnx = new ArrayList<>();
        final a.InterfaceC0168a dny = new a.InterfaceC0168a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0168a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.dnx.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.dnw);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.dnv.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.dnv.get(i2)).a(this.dny);
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
            e.this.dnu = this.dnx;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean hG(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dnu.iterator();
        while (it.hasNext()) {
            if (it.next().hG(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean nb(String str) {
        if (str == null || !hG(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dnu.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.hG(str)) {
                return next.Mm() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean nc(String str) {
        return com.baidu.tbadk.imageManager.d.bcs.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.bct);
    }

    public String nd(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains(BaseRequestAction.SPLITE)) {
                return substring.substring(0, substring.indexOf(BaseRequestAction.SPLITE));
            }
        }
        return "";
    }

    public boolean ne(String str) {
        if (!com.baidu.tbadk.imageManager.d.bcs.equals(str) && str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains(BaseRequestAction.SPLITE) && !substring.contains("collect_");
        }
        return false;
    }

    public String J(String str, boolean z) {
        String substring;
        if (str == null) {
            return null;
        }
        if (str.startsWith("#(meme,")) {
            if (str.equals(com.baidu.tbadk.imageManager.d.bcs)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(",")).contains("collect_")) {
                String str2 = l.FL + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.Nz() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a bt(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap bu;
        com.baidu.adp.widget.ImageView.a ih = com.baidu.tbadk.imageManager.c.Nu().ih(str2);
        if (ih != null) {
            return ih;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dnu.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = ih;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.hG(str2)) {
                aVar = next.hH(str2);
                break;
            }
        }
        if (aVar == null && str != null && (bu = bu(str, J(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(bu, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String I(String str, boolean z) {
        if (!d.auH().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.auH().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.hG(str)) {
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
                com.baidu.tbadk.imageManager.c.Nu().b(I(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Nu().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> auK() {
        return this.dnu;
    }

    public Bitmap bu(String str, String str2) {
        return l.ax(".emotions/" + str, str2);
    }
}
