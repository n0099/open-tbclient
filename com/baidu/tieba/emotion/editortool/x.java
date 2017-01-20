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
    private static x bww = new x();
    private static BdAsyncTaskParallel bwz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bwx = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bwy = new ArrayList();

    public static x TV() {
        return bww;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bwy) {
            if (!this.bwy.contains(aVar)) {
                this.bwy.add(aVar);
                Collections.sort(this.bwy);
            }
        }
    }

    public void TW() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bwA = new ArrayList<>();
        final a.InterfaceC0041a bwB = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bwz);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bwy.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bwy.get(i2)).a(this.bwB);
                    i = i2 + 1;
                } else {
                    return null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r4) {
            super.onPostExecute(r4);
            x.this.bwx = this.bwA;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fq(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bwx.iterator();
        while (it.hasNext()) {
            if (it.next().fq(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean ip(String str) {
        if (str == null || !fq(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bwx.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fq(str)) {
                return next.CM() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String E(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a aG(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aH;
        com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.DS().fT(str2);
        if (fT != null) {
            return fT;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bwx.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fT;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fq(str2)) {
                aVar = next.fr(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aH = aH(str, E(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aH, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String D(String str, boolean z) {
        if (!v.TU().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.TU().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fq(str)) {
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
                com.baidu.tbadk.imageManager.c.DS().b(D(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.DS().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> TX() {
        return this.bwx;
    }

    public Bitmap aH(String str, String str2) {
        return com.baidu.tbadk.core.util.l.X(".emotions/" + str, str2);
    }
}
