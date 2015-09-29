package com.baidu.tbadk.editortools.emotiontool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.EmptyMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r aqQ = new r();
    private static BdAsyncTaskParallel aqT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<t> aqR = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> aqS = new ArrayList();

    public static r Bc() {
        return aqQ;
    }

    private r() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.aqS) {
            if (!this.aqS.contains(aVar)) {
                this.aqS.add(aVar);
                Collections.sort(this.aqS);
            }
        }
    }

    public void Bd() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<t> aqU = new ArrayList<>();
        final a.InterfaceC0046a aqV = new s(this);

        public a() {
            setPriority(4);
            setParallel(r.aqT);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < r.this.aqS.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) r.this.aqS.get(i2)).a(this.aqV);
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
            r.this.aqR = this.aqU;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean eP(String str) {
        Iterator<t> it = this.aqR.iterator();
        while (it.hasNext()) {
            if (it.next().eP(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a eS(String str) {
        return com.baidu.tbadk.imageManager.c.Cf().fo(str);
    }

    public String s(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a al(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap am;
        com.baidu.adp.widget.a.a fo = com.baidu.tbadk.imageManager.c.Cf().fo(str2);
        if (fo != null) {
            return fo;
        }
        Iterator<t> it = this.aqR.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fo;
                break;
            }
            t next = it.next();
            if (next.eP(str2)) {
                aVar = next.eQ(str2);
                break;
            }
        }
        if (aVar == null && str != null && (am = am(str, s(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(am, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public String m(String str, boolean z) {
        if (!q.Bb().isEmpty()) {
            List<t> groups = q.Bb().getGroups();
            if (z) {
                for (t tVar : groups) {
                    if (tVar.eP(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return str;
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null) {
            if (z) {
                com.baidu.tbadk.imageManager.c.Cf().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Cf().c(str, aVar, false);
        }
    }

    public ArrayList<t> Be() {
        return this.aqR;
    }

    public t eT(String str) {
        Iterator<t> it = this.aqR.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap am(String str, String str2) {
        return com.baidu.tbadk.core.util.n.aa(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a an(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.n.xU + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap am = am(str, str2);
                if (am != null) {
                    return new com.baidu.adp.widget.a.a(am, false, str2);
                }
                return null;
            }
            return a.C0002a.fe().K(file.getAbsolutePath());
        }
        return null;
    }
}
