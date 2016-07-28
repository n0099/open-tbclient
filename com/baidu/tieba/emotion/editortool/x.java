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
    private static x buo = new x();
    private static BdAsyncTaskParallel bur = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bup = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> buq = new ArrayList();

    public static x Sh() {
        return buo;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.buq) {
            if (!this.buq.contains(aVar)) {
                this.buq.add(aVar);
                Collections.sort(this.buq);
            }
        }
    }

    public void Si() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bus = new ArrayList<>();
        final a.InterfaceC0041a but = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bur);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.buq.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.buq.get(i2)).a(this.but);
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
            x.this.bup = this.bus;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fp(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bup.iterator();
        while (it.hasNext()) {
            if (it.next().fp(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean iA(String str) {
        if (str == null || !fp(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bup.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fp(str)) {
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

    public com.baidu.adp.widget.a.a aE(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aF;
        com.baidu.adp.widget.a.a fQ = com.baidu.tbadk.imageManager.c.CP().fQ(str2);
        if (fQ != null) {
            return fQ;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bup.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fQ;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fp(str2)) {
                aVar = next.fq(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aF = aF(str, z(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aF, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String y(String str, boolean z) {
        if (!v.Sg().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Sg().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fp(str)) {
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
                com.baidu.tbadk.imageManager.c.CP().b(y(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.CP().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Sj() {
        return this.bup;
    }

    public Bitmap aF(String str, String str2) {
        return com.baidu.tbadk.core.util.m.X(".emotions/" + str, str2);
    }
}
