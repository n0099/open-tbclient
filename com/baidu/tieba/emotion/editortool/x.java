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
    private static x bFM = new x();
    private static BdAsyncTaskParallel bFP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFN = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bFO = new ArrayList();

    public static x Xm() {
        return bFM;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bFO) {
            if (!this.bFO.contains(aVar)) {
                this.bFO.add(aVar);
                Collections.sort(this.bFO);
            }
        }
    }

    public void Xn() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFQ = new ArrayList<>();
        final a.InterfaceC0041a bFR = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bFP);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bFO.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bFO.get(i2)).a(this.bFR);
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
            x.this.bFN = this.bFQ;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fu(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFN.iterator();
        while (it.hasNext()) {
            if (it.next().fu(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean jq(String str) {
        if (str == null || !fu(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFN.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fu(str)) {
                return next.Da() == EmotionGroupType.LOCAL;
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
        com.baidu.adp.widget.a.a fX = com.baidu.tbadk.imageManager.c.Ek().fX(str2);
        if (fX != null) {
            return fX;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFN.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fX;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fu(str2)) {
                aVar = next.fv(str2);
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
        if (!v.Xl().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Xl().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fu(str)) {
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
                com.baidu.tbadk.imageManager.c.Ek().b(D(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Ek().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Xo() {
        return this.bFN;
    }

    public Bitmap aH(String str, String str2) {
        return com.baidu.tbadk.core.util.m.X(".emotions/" + str, str2);
    }
}
