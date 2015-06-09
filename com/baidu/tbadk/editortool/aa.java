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
    private ArrayList<ad> akA = new ArrayList<>();
    private final List<a> akB = new ArrayList();
    private static aa akz = new aa();
    private static BdAsyncTaskParallel akC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    public static aa zF() {
        return akz;
    }

    private aa() {
    }

    public void b(a aVar) {
        synchronized (this.akB) {
            if (!this.akB.contains(aVar)) {
                this.akB.add(aVar);
                Collections.sort(this.akB);
            }
        }
    }

    public void zG() {
        new ab(this).execute(new Void[0]);
    }

    public boolean ex(String str) {
        Iterator<ad> it = this.akA.iterator();
        while (it.hasNext()) {
            if (it.next().ex(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a eA(String str) {
        return com.baidu.tbadk.imageManager.e.Am().eL(str);
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
        com.baidu.adp.widget.a.a eL = com.baidu.tbadk.imageManager.e.Am().eL(str2);
        if (eL != null) {
            return eL;
        }
        Iterator<ad> it = this.akA.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = eL;
                break;
            }
            ad next = it.next();
            if (next.ex(str2)) {
                aVar = next.ey(str2);
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
        if (!y.zE().isEmpty()) {
            List<ad> groups = y.zE().getGroups();
            if (z) {
                for (ad adVar : groups) {
                    if (adVar.ex(str)) {
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
                com.baidu.tbadk.imageManager.e.Am().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.Am().c(str, aVar, false);
        }
    }

    public ArrayList<ad> zH() {
        return this.akA;
    }

    public ad eB(String str) {
        Iterator<ad> it = this.akA.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap am(String str, String str2) {
        return com.baidu.tbadk.core.util.o.ac(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a an(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.o.ya + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap am = am(str, str2);
                if (am != null) {
                    return new com.baidu.adp.widget.a.a(am, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.fk().L(file.getAbsolutePath());
        }
        return null;
    }
}
