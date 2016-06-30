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
    private static x brZ = new x();
    private static BdAsyncTaskParallel bsc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bsa = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bsb = new ArrayList();

    public static x RA() {
        return brZ;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bsb) {
            if (!this.bsb.contains(aVar)) {
                this.bsb.add(aVar);
                Collections.sort(this.bsb);
            }
        }
    }

    public void RB() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bsd = new ArrayList<>();
        final a.InterfaceC0040a bse = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bsc);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bsb.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bsb.get(i2)).a(this.bse);
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
            x.this.bsa = this.bsd;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fr(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bsa.iterator();
        while (it.hasNext()) {
            if (it.next().fr(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean iu(String str) {
        if (str == null || !fr(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bsa.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fr(str)) {
                return next.BF() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String z(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a aD(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aE;
        com.baidu.adp.widget.a.a fS = com.baidu.tbadk.imageManager.c.CQ().fS(str2);
        if (fS != null) {
            return fS;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bsa.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fS;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fr(str2)) {
                aVar = next.fs(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aE = aE(str, z(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aE, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String y(String str, boolean z) {
        if (!v.Rz().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Rz().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fr(str)) {
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
                com.baidu.tbadk.imageManager.c.CQ().b(y(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.CQ().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> RC() {
        return this.bsa;
    }

    public Bitmap aE(String str, String str2) {
        return com.baidu.tbadk.core.util.m.X(".emotions/" + str, str2);
    }
}
