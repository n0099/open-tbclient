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
public class t {
    private static t asu = new t();
    private static BdAsyncTaskParallel asx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<v> asv = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> asw = new ArrayList();

    public static t Bp() {
        return asu;
    }

    private t() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.asw) {
            if (!this.asw.contains(aVar)) {
                this.asw.add(aVar);
                Collections.sort(this.asw);
            }
        }
    }

    public void Bq() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<v> asy = new ArrayList<>();
        final a.InterfaceC0046a asz = new u(this);

        public a() {
            setPriority(4);
            setParallel(t.asx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < t.this.asw.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) t.this.asw.get(i2)).a(this.asz);
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
            t.this.asv = this.asy;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean eK(String str) {
        Iterator<v> it = this.asv.iterator();
        while (it.hasNext()) {
            if (it.next().eK(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a eN(String str) {
        return com.baidu.tbadk.imageManager.c.Cs().fj(str);
    }

    public String s(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a am(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap an;
        com.baidu.adp.widget.a.a fj = com.baidu.tbadk.imageManager.c.Cs().fj(str2);
        if (fj != null) {
            return fj;
        }
        Iterator<v> it = this.asv.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fj;
                break;
            }
            v next = it.next();
            if (next.eK(str2)) {
                aVar = next.eL(str2);
                break;
            }
        }
        if (aVar == null && str != null && (an = an(str, s(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(an, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public String m(String str, boolean z) {
        if (!r.Bo().isEmpty()) {
            List<v> groups = r.Bo().getGroups();
            if (z) {
                for (v vVar : groups) {
                    if (vVar.eK(str)) {
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
                com.baidu.tbadk.imageManager.c.Cs().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Cs().c(str, aVar, false);
        }
    }

    public ArrayList<v> Br() {
        return this.asv;
    }

    public v eO(String str) {
        Iterator<v> it = this.asv.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap an(String str, String str2) {
        return com.baidu.tbadk.core.util.n.ab(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a ao(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.n.xT + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap an = an(str, str2);
                if (an != null) {
                    return new com.baidu.adp.widget.a.a(an, false, str2);
                }
                return null;
            }
            return a.C0002a.fe().K(file.getAbsolutePath());
        }
        return null;
    }
}
