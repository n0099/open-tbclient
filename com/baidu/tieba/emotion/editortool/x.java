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
    private static x bLI = new x();
    private static BdAsyncTaskParallel bLL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bLJ = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> bLK = new ArrayList();

    public static x WQ() {
        return bLI;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.bLK) {
            if (!this.bLK.contains(aVar)) {
                this.bLK.add(aVar);
                Collections.sort(this.bLK);
            }
        }
    }

    public void WR() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bLM = new ArrayList<>();
        final a.InterfaceC0043a bLN = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bLL);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.bLK.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.bLK.get(i2)).a(this.bLN);
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
            x.this.bLJ = this.bLM;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fg(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bLJ.iterator();
        while (it.hasNext()) {
            if (it.next().fg(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean iA(String str) {
        if (str == null || !fg(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bLJ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fg(str)) {
                return next.CA() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String C(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a aF(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aG;
        com.baidu.adp.widget.a.a fK = com.baidu.tbadk.imageManager.c.DH().fK(str2);
        if (fK != null) {
            return fK;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bLJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fK;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fg(str2)) {
                aVar = next.fh(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aG = aG(str, C(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aG, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String B(String str, boolean z) {
        if (!w.WP().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = w.WP().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fg(str)) {
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
                com.baidu.tbadk.imageManager.c.DH().b(B(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.DH().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> WS() {
        return this.bLJ;
    }

    public Bitmap aG(String str, String str2) {
        return com.baidu.tbadk.core.util.l.V(".emotions/" + str, str2);
    }
}
