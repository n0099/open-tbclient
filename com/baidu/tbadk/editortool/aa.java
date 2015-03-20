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
    private static aa ajs = new aa();
    private static BdAsyncTaskParallel ajv = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<ad> ajt = new ArrayList<>();
    private final List<a> aju = new ArrayList();

    public static aa yL() {
        return ajs;
    }

    private aa() {
    }

    public void b(a aVar) {
        synchronized (this.aju) {
            if (!this.aju.contains(aVar)) {
                this.aju.add(aVar);
                Collections.sort(this.aju);
            }
        }
    }

    public void yM() {
        new ab(this).execute(new Void[0]);
    }

    public boolean ed(String str) {
        Iterator<ad> it = this.ajt.iterator();
        while (it.hasNext()) {
            if (it.next().ed(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a eg(String str) {
        return com.baidu.tbadk.imageManager.e.zs().er(str);
    }

    public String q(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a ag(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap ah;
        com.baidu.adp.widget.a.a er = com.baidu.tbadk.imageManager.e.zs().er(str2);
        if (er != null) {
            return er;
        }
        Iterator<ad> it = this.ajt.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = er;
                break;
            }
            ad next = it.next();
            if (next.ed(str2)) {
                aVar = next.ee(str2);
                break;
            }
        }
        if (aVar == null && str != null && (ah = ah(str, q(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(ah, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public String m(String str, boolean z) {
        if (!y.yK().isEmpty()) {
            List<ad> groups = y.yK().getGroups();
            if (z) {
                for (ad adVar : groups) {
                    if (adVar.ed(str)) {
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
                com.baidu.tbadk.imageManager.e.zs().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.zs().c(str, aVar, false);
        }
    }

    public ArrayList<ad> yN() {
        return this.ajt;
    }

    public ad eh(String str) {
        Iterator<ad> it = this.ajt.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (next.getGroupId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap ah(String str, String str2) {
        return com.baidu.tbadk.core.util.o.Y(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a ai(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.o.yl + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap ah = ah(str, str2);
                if (ah != null) {
                    return new com.baidu.adp.widget.a.a(ah, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.ff().J(file.getAbsolutePath());
        }
        return null;
    }
}
