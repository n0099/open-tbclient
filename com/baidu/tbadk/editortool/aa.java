package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class aa {
    private static aa So = new aa();
    private static BdAsyncTaskParallel parallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<ad> Sp = new ArrayList<>();
    private final List<e> Sq = new ArrayList();

    public static aa rz() {
        return So;
    }

    private aa() {
    }

    public void b(e eVar) {
        synchronized (this.Sq) {
            if (!this.Sq.contains(eVar)) {
                this.Sq.add(eVar);
                Collections.sort(this.Sq);
            }
        }
    }

    public void rA() {
        new ab(this).execute(new Void[0]);
    }

    public boolean cY(String str) {
        Iterator<ad> it = this.Sp.iterator();
        while (it.hasNext()) {
            if (it.next().cY(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a dg(String str) {
        return com.baidu.tbadk.imageManager.e.sg().dt(str);
    }

    public String m(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a T(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap U;
        com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.sg().dt(str2);
        if (dt != null) {
            return dt;
        }
        Iterator<ad> it = this.Sp.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = dt;
                break;
            }
            ad next = it.next();
            if (next.cY(str2)) {
                aVar = next.cZ(str2);
                break;
            }
        }
        if (aVar == null && str != null && (U = U(str, m(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(U, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public String n(String str, boolean z) {
        if (!z.ry().isEmpty()) {
            List<ad> groups = z.ry().getGroups();
            if (z) {
                for (ad adVar : groups) {
                    if (adVar.cY(str)) {
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
                com.baidu.tbadk.imageManager.e.sg().c(n(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.sg().c(str, aVar, false);
        }
    }

    public ArrayList<ad> rB() {
        return this.Sp;
    }

    public ad dh(String str) {
        Iterator<ad> it = this.Sp.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap U(String str, String str2) {
        return com.baidu.tbadk.core.util.s.K(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a V(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.s.mI + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap U = U(str, str2);
                if (U != null) {
                    return new com.baidu.adp.widget.a.a(U, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.bi().m(file.getAbsolutePath());
        }
        return null;
    }
}
