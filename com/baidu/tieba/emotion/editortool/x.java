package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private static x bDv = new x();
    private static BdAsyncTaskParallel bDy = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDw = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bDx = new ArrayList();

    public static x Vr() {
        return bDv;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bDx) {
            if (!this.bDx.contains(aVar)) {
                this.bDx.add(aVar);
                Collections.sort(this.bDx);
            }
        }
    }

    public void Vs() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDz = new ArrayList<>();
        final a.InterfaceC0039a bDA = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bDy);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bDx.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bDx.get(i2)).a(this.bDA);
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
            x.this.bDw = this.bDz;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fl(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDw.iterator();
        while (it.hasNext()) {
            if (it.next().fl(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean ij(String str) {
        if (str == null || !fl(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDw.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fl(str)) {
                return next.DC() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String F(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a aI(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aJ;
        com.baidu.adp.widget.a.a fO = com.baidu.tbadk.imageManager.c.EJ().fO(str2);
        if (fO != null) {
            return fO;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDw.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fO;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fl(str2)) {
                aVar = next.fm(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aJ = aJ(str, F(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aJ, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String E(String str, boolean z) {
        if (!w.Vq().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = w.Vq().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fl(str)) {
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
                com.baidu.tbadk.imageManager.c.EJ().b(E(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.EJ().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Vt() {
        return this.bDw;
    }

    public Bitmap aJ(String str, String str2) {
        return com.baidu.tbadk.core.util.l.W(".emotions/" + str, str2);
    }
}
