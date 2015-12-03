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
    private static x aPI = new x();
    private static BdAsyncTaskParallel aPL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aPJ = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> aPK = new ArrayList();

    public static x Ju() {
        return aPI;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.aPK) {
            if (!this.aPK.contains(aVar)) {
                this.aPK.add(aVar);
                Collections.sort(this.aPK);
            }
        }
    }

    public void Jv() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aPM = new ArrayList<>();
        final a.InterfaceC0048a aPN = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.aPL);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.aPK.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.aPK.get(i2)).a(this.aPN);
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
            x.this.aPJ = this.aPM;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fd(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aPJ.iterator();
        while (it.hasNext()) {
            if (it.next().fd(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean gK(String str) {
        if (str == null || !fd(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aPJ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fd(str)) {
                return next.BN() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String w(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a as(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap at;
        com.baidu.adp.widget.a.a fF = com.baidu.tbadk.imageManager.c.CX().fF(str2);
        if (fF != null) {
            return fF;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aPJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fF;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fd(str2)) {
                aVar = next.fe(str2);
                break;
            }
        }
        if (aVar == null && str != null && (at = at(str, w(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(at, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String v(String str, boolean z) {
        if (!v.Jt().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Jt().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fd(str)) {
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
                com.baidu.tbadk.imageManager.c.CX().b(v(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.CX().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Jw() {
        return this.aPJ;
    }

    public Bitmap at(String str, String str2) {
        return com.baidu.tbadk.core.util.n.X(".emotions/" + str, str2);
    }
}
