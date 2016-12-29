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
    private static x boJ = new x();
    private static BdAsyncTaskParallel boM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> boK = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> boL = new ArrayList();

    public static x Sz() {
        return boJ;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.boL) {
            if (!this.boL.contains(aVar)) {
                this.boL.add(aVar);
                Collections.sort(this.boL);
            }
        }
    }

    public void SA() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> boN = new ArrayList<>();
        final a.InterfaceC0041a boO = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.boM);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.boL.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.boL.get(i2)).a(this.boO);
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
            x.this.boK = this.boN;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean ft(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.boK.iterator();
        while (it.hasNext()) {
            if (it.next().ft(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hZ(String str) {
        if (str == null || !ft(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.boK.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ft(str)) {
                return next.CR() == EmotionGroupType.LOCAL;
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

    public com.baidu.adp.widget.a.a aB(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aC;
        com.baidu.adp.widget.a.a fW = com.baidu.tbadk.imageManager.c.DX().fW(str2);
        if (fW != null) {
            return fW;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.boK.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fW;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ft(str2)) {
                aVar = next.fu(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aC = aC(str, F(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aC, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String E(String str, boolean z) {
        if (!v.Sy().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Sy().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.ft(str)) {
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
                com.baidu.tbadk.imageManager.c.DX().b(E(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.DX().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> SB() {
        return this.boK;
    }

    public Bitmap aC(String str, String str2) {
        return com.baidu.tbadk.core.util.m.X(".emotions/" + str, str2);
    }
}
