package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aOp;
    private final ArrayList<bb> dKB;
    private boolean dKC;
    private b dKD;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void aBm();

        void mg(int i);

        void y(boolean z, boolean z2);
    }

    private a() {
        this.dKC = false;
        this.dKB = new ArrayList<>();
    }

    public static a aBg() {
        return C0218a.dKE;
    }

    public boolean aBh() {
        return this.dKC;
    }

    public void x(boolean z, boolean z2) {
        this.dKC = z;
        if (this.dKD != null) {
            this.dKD.y(this.dKC, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dKB.size() > 29) {
            if (this.dKD != null) {
                this.dKD.aBm();
                return false;
            }
            return false;
        }
        this.dKB.add(bbVar);
        if (this.dKD != null) {
            this.dKD.mg(this.dKB.size());
        }
        return true;
    }

    public List<bb> aBi() {
        return this.dKB;
    }

    public void W(bb bbVar) {
        this.dKB.remove(bbVar);
        if (this.dKD != null) {
            this.dKD.mg(this.dKB.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dKB.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.be(false);
            }
        }
        this.dKB.clear();
        if (this.dKD != null) {
            this.dKD.mg(0);
        }
    }

    public void reset() {
        x(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dKD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0218a {
        private static a dKE = new a();
    }

    public AntiData aBj() {
        return this.aOp;
    }

    public void b(AntiData antiData) {
        this.aOp = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bD(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list) && !com.baidu.tbadk.core.util.v.I(this.dKB)) {
            Iterator<bb> it = this.dKB.iterator();
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
            if (this.dKD != null) {
                this.dKD.mg(this.dKB.size());
            }
        }
    }

    public boolean aBk() {
        return this.aOp != null && this.aOp.isMultiDeleteEnable();
    }
}
