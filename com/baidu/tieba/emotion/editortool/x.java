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
    private static x aWs = new x();
    private static BdAsyncTaskParallel aWv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aWt = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> aWu = new ArrayList();

    public static x LY() {
        return aWs;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.aWu) {
            if (!this.aWu.contains(aVar)) {
                this.aWu.add(aVar);
                Collections.sort(this.aWu);
            }
        }
    }

    public void LZ() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aWw = new ArrayList<>();
        final a.InterfaceC0040a aWx = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.aWv);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.aWu.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.aWu.get(i2)).a(this.aWx);
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
            x.this.aWt = this.aWw;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fl(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aWt.iterator();
        while (it.hasNext()) {
            if (it.next().fl(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hl(String str) {
        if (str == null || !fl(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aWt.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fl(str)) {
                return next.Bw() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String y(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a aB(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aC;
        com.baidu.adp.widget.a.a fM = com.baidu.tbadk.imageManager.c.CI().fM(str2);
        if (fM != null) {
            return fM;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aWt.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fM;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fl(str2)) {
                aVar = next.fm(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aC = aC(str, y(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aC, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String x(String str, boolean z) {
        if (!v.LX().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.LX().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fl(str)) {
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
                com.baidu.tbadk.imageManager.c.CI().b(x(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.CI().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Ma() {
        return this.aWt;
    }

    public Bitmap aC(String str, String str2) {
        return com.baidu.tbadk.core.util.m.Y(".emotions/" + str, str2);
    }
}
