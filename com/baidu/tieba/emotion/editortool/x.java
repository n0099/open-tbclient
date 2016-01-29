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
    private static x aVG = new x();
    private static BdAsyncTaskParallel aVJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVH = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> aVI = new ArrayList();

    public static x Lz() {
        return aVG;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.aVI) {
            if (!this.aVI.contains(aVar)) {
                this.aVI.add(aVar);
                Collections.sort(this.aVI);
            }
        }
    }

    public void LA() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVK = new ArrayList<>();
        final a.InterfaceC0049a aVL = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.aVJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.aVI.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.aVI.get(i2)).a(this.aVL);
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
            x.this.aVH = this.aVK;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fg(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aVH.iterator();
        while (it.hasNext()) {
            if (it.next().fg(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean gV(String str) {
        if (str == null || !fg(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aVH.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fg(str)) {
                return next.CT() == EmotionGroupType.LOCAL;
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

    public com.baidu.adp.widget.a.a aq(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap ar;
        com.baidu.adp.widget.a.a fH = com.baidu.tbadk.imageManager.c.Ed().fH(str2);
        if (fH != null) {
            return fH;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aVH.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fH;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fg(str2)) {
                aVar = next.fh(str2);
                break;
            }
        }
        if (aVar == null && str != null && (ar = ar(str, w(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(ar, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String v(String str, boolean z) {
        if (!v.Ly().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Ly().getGroups();
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
                com.baidu.tbadk.imageManager.c.Ed().b(v(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Ed().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> LB() {
        return this.aVH;
    }

    public Bitmap ar(String str, String str2) {
        return com.baidu.tbadk.core.util.m.W(".emotions/" + str, str2);
    }
}
