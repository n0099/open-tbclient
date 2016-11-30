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
    private static x bIG = new x();
    private static BdAsyncTaskParallel bIJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bIH = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bII = new ArrayList();

    public static x Yo() {
        return bIG;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bII) {
            if (!this.bII.contains(aVar)) {
                this.bII.add(aVar);
                Collections.sort(this.bII);
            }
        }
    }

    public void Yp() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bIK = new ArrayList<>();
        final a.InterfaceC0041a bIL = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bIJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bII.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bII.get(i2)).a(this.bIL);
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
            x.this.bIH = this.bIK;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fx(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bIH.iterator();
        while (it.hasNext()) {
            if (it.next().fx(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean ju(String str) {
        if (str == null || !fx(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bIH.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fx(str)) {
                return next.Di() == EmotionGroupType.LOCAL;
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

    public com.baidu.adp.widget.a.a aH(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aI;
        com.baidu.adp.widget.a.a ga = com.baidu.tbadk.imageManager.c.Ep().ga(str2);
        if (ga != null) {
            return ga;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bIH.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = ga;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fx(str2)) {
                aVar = next.fy(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aI = aI(str, E(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aI, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String D(String str, boolean z) {
        if (!v.Yn().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Yn().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fx(str)) {
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
                com.baidu.tbadk.imageManager.c.Ep().b(D(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Ep().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Yq() {
        return this.bIH;
    }

    public Bitmap aI(String str, String str2) {
        return com.baidu.tbadk.core.util.m.X(".emotions/" + str, str2);
    }
}
