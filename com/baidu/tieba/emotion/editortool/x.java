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
    private static x bDC = new x();
    private static BdAsyncTaskParallel bDF = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDD = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bDE = new ArrayList();

    public static x UT() {
        return bDC;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bDE) {
            if (!this.bDE.contains(aVar)) {
                this.bDE.add(aVar);
                Collections.sort(this.bDE);
            }
        }
    }

    public void UU() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDG = new ArrayList<>();
        final a.InterfaceC0040a bDH = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bDF);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bDE.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bDE.get(i2)).a(this.bDH);
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
            x.this.bDD = this.bDG;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean ff(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDD.iterator();
        while (it.hasNext()) {
            if (it.next().ff(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m13if(String str) {
        if (str == null || !ff(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDD.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ff(str)) {
                return next.De() == EmotionGroupType.LOCAL;
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

    public com.baidu.adp.widget.a.a aE(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aF;
        com.baidu.adp.widget.a.a fI = com.baidu.tbadk.imageManager.c.El().fI(str2);
        if (fI != null) {
            return fI;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDD.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fI;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ff(str2)) {
                aVar = next.fg(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aF = aF(str, F(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aF, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String E(String str, boolean z) {
        if (!v.US().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.US().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.ff(str)) {
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
                com.baidu.tbadk.imageManager.c.El().b(E(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.El().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> UV() {
        return this.bDD;
    }

    public Bitmap aF(String str, String str2) {
        return com.baidu.tbadk.core.util.l.V(".emotions/" + str, str2);
    }
}
