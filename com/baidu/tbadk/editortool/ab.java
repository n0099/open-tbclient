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
public class ab {
    private static ab YV = new ab();
    private static BdAsyncTaskParallel YY = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<ae> YW = new ArrayList<>();
    private final List<e> YX = new ArrayList();

    public static ab vn() {
        return YV;
    }

    private ab() {
    }

    public void b(e eVar) {
        synchronized (this.YX) {
            if (!this.YX.contains(eVar)) {
                this.YX.add(eVar);
                Collections.sort(this.YX);
            }
        }
    }

    public void vo() {
        new ac(this).execute(new Void[0]);
    }

    public boolean dR(String str) {
        Iterator<ae> it = this.YW.iterator();
        while (it.hasNext()) {
            if (it.next().dR(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a dZ(String str) {
        return com.baidu.tbadk.imageManager.e.vY().ek(str);
    }

    public String p(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a ah(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap ai;
        com.baidu.adp.widget.a.a ek = com.baidu.tbadk.imageManager.e.vY().ek(str2);
        if (ek != null) {
            return ek;
        }
        Iterator<ae> it = this.YW.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = ek;
                break;
            }
            ae next = it.next();
            if (next.dR(str2)) {
                aVar = next.dS(str2);
                break;
            }
        }
        if (aVar == null && str != null && (ai = ai(str, p(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(ai, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public String m(String str, boolean z) {
        if (!z.vm().isEmpty()) {
            List<ae> groups = z.vm().getGroups();
            if (z) {
                for (ae aeVar : groups) {
                    if (aeVar.dR(str)) {
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
                com.baidu.tbadk.imageManager.e.vY().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.vY().c(str, aVar, false);
        }
    }

    public ArrayList<ae> vp() {
        return this.YW;
    }

    public ae ea(String str) {
        Iterator<ae> it = this.YW.iterator();
        while (it.hasNext()) {
            ae next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap ai(String str, String str2) {
        return com.baidu.tbadk.core.util.s.X(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a aj(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.s.mJ + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap ai = ai(str, str2);
                if (ai != null) {
                    return new com.baidu.adp.widget.a.a(ai, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.bH().B(file.getAbsolutePath());
        }
        return null;
    }
}
