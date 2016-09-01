package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.EmptyMessage;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private static x bFB = new x();
    private static BdAsyncTaskParallel bFE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFC = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bFD = new ArrayList();

    public static x WT() {
        return bFB;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bFD) {
            if (!this.bFD.contains(aVar)) {
                this.bFD.add(aVar);
                Collections.sort(this.bFD);
            }
        }
    }

    public void WU() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFF = new ArrayList<>();
        final a.InterfaceC0041a bFG = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bFE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bFD.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bFD.get(i2)).a(this.bFG);
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
            x.this.bFC = this.bFF;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fs(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFC.iterator();
        while (it.hasNext()) {
            if (it.next().fs(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean jj(String str) {
        if (str == null || !fs(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFC.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fs(str)) {
                return next.Da() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String D(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a aF(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aG;
        com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.Ek().fT(str2);
        if (fT != null) {
            return fT;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFC.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fT;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fs(str2)) {
                aVar = next.ft(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aG = aG(str, D(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aG, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String C(String str, boolean z) {
        if (!v.WS().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.WS().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fs(str)) {
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
                com.baidu.tbadk.imageManager.c.Ek().b(C(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Ek().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> WV() {
        return this.bFC;
    }

    public Bitmap aG(String str, String str2) {
        return com.baidu.tbadk.core.util.m.X(".emotions/" + str, str2);
    }
}
