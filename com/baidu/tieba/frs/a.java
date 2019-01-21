package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aOq;
    private final ArrayList<bb> dKC;
    private boolean dKD;
    private b dKE;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void aBm();

        void mg(int i);

        void y(boolean z, boolean z2);
    }

    private a() {
        this.dKD = false;
        this.dKC = new ArrayList<>();
    }

    public static a aBg() {
        return C0218a.dKF;
    }

    public boolean aBh() {
        return this.dKD;
    }

    public void x(boolean z, boolean z2) {
        this.dKD = z;
        if (this.dKE != null) {
            this.dKE.y(this.dKD, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dKC.size() > 29) {
            if (this.dKE != null) {
                this.dKE.aBm();
                return false;
            }
            return false;
        }
        this.dKC.add(bbVar);
        if (this.dKE != null) {
            this.dKE.mg(this.dKC.size());
        }
        return true;
    }

    public List<bb> aBi() {
        return this.dKC;
    }

    public void W(bb bbVar) {
        this.dKC.remove(bbVar);
        if (this.dKE != null) {
            this.dKE.mg(this.dKC.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dKC.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.be(false);
            }
        }
        this.dKC.clear();
        if (this.dKE != null) {
            this.dKE.mg(0);
        }
    }

    public void reset() {
        x(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dKE = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0218a {
        private static a dKF = new a();
    }

    public AntiData aBj() {
        return this.aOq;
    }

    public void b(AntiData antiData) {
        this.aOq = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bD(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list) && !com.baidu.tbadk.core.util.v.I(this.dKC)) {
            Iterator<bb> it = this.dKC.iterator();
            while (it.hasNext()) {
                bb next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.ao.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.dKE != null) {
                this.dKE.mg(this.dKC.size());
            }
        }
    }

    public boolean aBk() {
        return this.aOq != null && this.aOq.isMultiDeleteEnable();
    }
}
