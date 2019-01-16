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
    private static e dqW = new e();
    private static BdAsyncTaskParallel dqZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dqX = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> dqY = new ArrayList();

    public static e avV() {
        return dqW;
    }

    private e() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.dqY) {
            if (!this.dqY.contains(aVar)) {
                this.dqY.add(aVar);
                Collections.sort(this.dqY);
            }
        }
    }

    public void avW() {
        new a().execute(new Void[0]);
    }

    /* loaded from: classes5.dex */
    protected class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dra = new ArrayList<>();
        final a.InterfaceC0168a drb = new a.InterfaceC0168a() { // from class: com.baidu.tieba.emotion.editortool.e.a.1
            @Override // com.baidu.tbadk.editortools.emotiontool.a.InterfaceC0168a
            public void a(com.baidu.tbadk.editortools.emotiontool.c cVar) {
                a.this.dra.add(cVar);
            }
        };

        public a() {
            setPriority(4);
            setParallel(e.dqZ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < e.this.dqY.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) e.this.dqY.get(i2)).a(this.drb);
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
            e.this.dqX = this.dra;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }
    }

    public boolean hV(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqX.iterator();
        while (it.hasNext()) {
            if (it.next().hV(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean nu(String str) {
        if (str == null || !hV(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqX.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.hV(str)) {
                return next.ME() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean nv(String str) {
        return com.baidu.tbadk.imageManager.d.bdf.equals(str) || str.startsWith(com.baidu.tbadk.imageManager.d.bdg);
    }

    public String nw(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains(BaseRequestAction.SPLITE)) {
                return substring.substring(0, substring.indexOf(BaseRequestAction.SPLITE));
            }
        }
        return "";
    }

    public boolean nx(String str) {
        if (!com.baidu.tbadk.imageManager.d.bdf.equals(str) && str.startsWith("#(meme,")) {
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
            if (str.equals(com.baidu.tbadk.imageManager.d.bdf)) {
                return null;
            }
            String replace = str.replace("#(meme,", "");
            if (replace.substring(0, replace.indexOf(",")).contains("collect_")) {
                String str2 = l.FL + "/" + TbConfig.getTempDirName() + "/.collect/" + com.baidu.tbadk.imageManager.d.NR() + "/" + substring.replace("collect_", "");
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

    public com.baidu.adp.widget.ImageView.a bu(String str, String str2) {
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap bv;
        com.baidu.adp.widget.ImageView.a iw = com.baidu.tbadk.imageManager.c.NM().iw(str2);
        if (iw != null) {
            return iw;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqX.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = iw;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.hV(str2)) {
                aVar = next.hW(str2);
                break;
            }
        }
        if (aVar == null && str != null && (bv = bv(str, J(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(bv, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String I(String str, boolean z) {
        if (!d.avU().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = d.avU().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.hV(str)) {
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
                com.baidu.tbadk.imageManager.c.NM().b(I(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.NM().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> avX() {
        return this.dqX;
    }

    public Bitmap bv(String str, String str2) {
        return l.ay(".emotions/" + str, str2);
    }
}
