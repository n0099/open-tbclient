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
    private static t aqK = new t();
    private static BdAsyncTaskParallel aqN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<v> aqL = new ArrayList<>();
    private final List<com.baidu.tbadk.editortools.emotiontool.a> aqM = new ArrayList();

    public static t Bc() {
        return aqK;
    }

    private t() {
    }

    public void b(com.baidu.tbadk.editortools.emotiontool.a aVar) {
        synchronized (this.aqM) {
            if (!this.aqM.contains(aVar)) {
                this.aqM.add(aVar);
                Collections.sort(this.aqM);
            }
        }
    }

    public void Bd() {
        new a().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        final ArrayList<v> aqO = new ArrayList<>();
        final a.InterfaceC0047a aqP = new u(this);

        public a() {
            setPriority(4);
            setParallel(t.aqN);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < t.this.aqM.size()) {
                    ((com.baidu.tbadk.editortools.emotiontool.a) t.this.aqM.get(i2)).a(this.aqP);
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
            t.this.aqL = this.aqO;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED));
        }
    }

    public boolean eC(String str) {
        Iterator<v> it = this.aqL.iterator();
        while (it.hasNext()) {
            if (it.next().eC(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a eF(String str) {
        return com.baidu.tbadk.imageManager.c.Ce().fb(str);
    }

    public String q(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a al(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap am;
        com.baidu.adp.widget.a.a fb = com.baidu.tbadk.imageManager.c.Ce().fb(str2);
        if (fb != null) {
            return fb;
        }
        Iterator<v> it = this.aqL.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = fb;
                break;
            }
            v next = it.next();
            if (next.eC(str2)) {
                aVar = next.eD(str2);
                break;
            }
        }
        if (aVar == null && str != null && (am = am(str, q(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(am, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public String m(String str, boolean z) {
        if (!r.Bb().isEmpty()) {
            List<v> groups = r.Bb().getGroups();
            if (z) {
                for (v vVar : groups) {
                    if (vVar.eC(str)) {
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
                com.baidu.tbadk.imageManager.c.Ce().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.c.Ce().c(str, aVar, false);
        }
    }

    public ArrayList<v> Be() {
        return this.aqL;
    }

    public v eG(String str) {
        Iterator<v> it = this.aqL.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap am(String str, String str2) {
        return com.baidu.tbadk.core.util.n.ab(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a an(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.n.xV + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap am = am(str, str2);
                if (am != null) {
                    return new com.baidu.adp.widget.a.a(am, false, str2);
                }
                return null;
            }
            return a.C0002a.fh().K(file.getAbsolutePath());
        }
        return null;
    }
}
