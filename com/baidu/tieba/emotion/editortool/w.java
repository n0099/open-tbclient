package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.EmptyMessage;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w {
    private static w aLi = new w();
    private static BdAsyncTaskParallel aLl = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aLj = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> aLk = new ArrayList();

    public static w Ib() {
        return aLi;
    }

    private w() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.aLk) {
            if (!this.aLk.contains(aVar)) {
                this.aLk.add(aVar);
                Collections.sort(this.aLk);
            }
        }
    }

    public void Ic() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aLm = new ArrayList<>();
        final a.InterfaceC0046a aLn = new x(this);

        public a() {
            setPriority(4);
            setParallel(w.aLl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < w.this.aLk.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) w.this.aLk.get(i2)).a(this.aLn);
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
            w.this.aLj = this.aLm;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean eP(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aLj.iterator();
        while (it.hasNext()) {
            if (it.next().eP(str)) {
                return true;
            }
        }
        return false;
    }

    public String v(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a ap(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aq;
        com.baidu.adp.widget.a.a fq = com.baidu.tbadk.imageManager.c.BV().fq(str2);
        if (fq != null) {
            return fq;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aLj.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fq;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.eP(str2)) {
                aVar = next.eQ(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aq = aq(str, v(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aq, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String u(String str, boolean z) {
        if (!u.Ia().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = u.Ia().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.eP(str)) {
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
                com.baidu.tbadk.imageManager.c.BV().b(u(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.BV().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Id() {
        return this.aLj;
    }

    public Bitmap aq(String str, String str2) {
        return com.baidu.tbadk.core.util.n.aa(".emotions/" + str, str2);
    }
}
