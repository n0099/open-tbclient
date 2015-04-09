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
    private static aa ajA = new aa();
    private static BdAsyncTaskParallel ajD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private ArrayList<ad> ajB = new ArrayList<>();
    private final List<a> ajC = new ArrayList();

    public static aa yR() {
        return ajA;
    }

    private aa() {
    }

    public void b(a aVar) {
        synchronized (this.ajC) {
            if (!this.ajC.contains(aVar)) {
                this.ajC.add(aVar);
                Collections.sort(this.ajC);
            }
        }
    }

    public void yS() {
        new ab(this).execute(new Void[0]);
    }

    public boolean eg(String str) {
        Iterator<ad> it = this.ajB.iterator();
        while (it.hasNext()) {
            if (it.next().eg(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a ej(String str) {
        return com.baidu.tbadk.imageManager.e.zy().eu(str);
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
        com.baidu.adp.widget.a.a eu = com.baidu.tbadk.imageManager.e.zy().eu(str2);
        if (eu != null) {
            return eu;
        }
        Iterator<ad> it = this.ajB.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = eu;
                break;
            }
            ad next = it.next();
            if (next.eg(str2)) {
                aVar = next.eh(str2);
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
        if (!y.yQ().isEmpty()) {
            List<ad> groups = y.yQ().getGroups();
            if (z) {
                for (ad adVar : groups) {
                    if (adVar.eg(str)) {
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
                com.baidu.tbadk.imageManager.e.zy().c(m(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.zy().c(str, aVar, false);
        }
    }

    public ArrayList<ad> yT() {
        return this.ajB;
    }

    public ad ek(String str) {
        Iterator<ad> it = this.ajB.iterator();
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
