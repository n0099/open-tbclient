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
    private static x bao = new x();
    private static BdAsyncTaskParallel bas = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bap = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> baq = new ArrayList();

    public static x Nn() {
        return bao;
    }

    private x() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.baq) {
            if (!this.baq.contains(aVar)) {
                this.baq.add(aVar);
                Collections.sort(this.baq);
            }
        }
    }

    public void No() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bat = new ArrayList<>();
        final a.InterfaceC0049a bau = new y(this);

        public a() {
            setPriority(4);
            setParallel(x.bas);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < x.this.baq.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) x.this.baq.get(i2)).a(this.bau);
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
            x.this.bap = this.bat;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean fo(String str) {
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bap.iterator();
        while (it.hasNext()) {
            if (it.next().fo(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hl(String str) {
        if (str == null || !fo(str)) {
            return false;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bap.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fo(str)) {
                return next.DB() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public String x(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a az(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap aA;
        com.baidu.adp.widget.a.a fP = com.baidu.tbadk.imageManager.c.EO().fP(str2);
        if (fP != null) {
            return fP;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bap.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fP;
                break;
            }
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.fo(str2)) {
                aVar = next.fp(str2);
                break;
            }
        }
        if (aVar == null && str != null && (aA = aA(str, x(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(aA, false, str2);
        }
        c(str2, aVar, false);
        return aVar;
    }

    public String w(String str, boolean z) {
        if (!v.Nm().isEmpty()) {
            List<com.baidu.tbadk.editortools.emotiontool.c> groups = v.Nm().getGroups();
            if (z) {
                for (com.baidu.tbadk.editortools.emotiontool.c cVar : groups) {
                    if (cVar.fo(str)) {
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
                com.baidu.tbadk.imageManager.c.EO().b(w(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.EO().b(str, aVar, false);
        }
    }

    public ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Np() {
        return this.bap;
    }

    public Bitmap aA(String str, String str2) {
        return com.baidu.tbadk.core.util.m.Y(".emotions/" + str, str2);
    }
}
