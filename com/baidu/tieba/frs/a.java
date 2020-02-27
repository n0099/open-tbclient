package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dmd;
    private String forumId;
    private final ArrayList<bj> gnc;
    private boolean gnd;
    private b gne;
    private boolean gnf;

    /* loaded from: classes.dex */
    public interface b {
        void J(boolean z, boolean z2);

        void bDa();

        void sz(int i);
    }

    private a() {
        this.gnd = false;
        this.gnc = new ArrayList<>();
    }

    public static a bCT() {
        return C0503a.gng;
    }

    public boolean bCU() {
        return this.gnd;
    }

    public void I(boolean z, boolean z2) {
        this.gnd = z;
        if (this.gne != null) {
            this.gne.J(this.gnd, z2);
        }
    }

    public boolean ah(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.gnc.size() > 29) {
            if (this.gne != null) {
                this.gne.bDa();
                return false;
            }
            return false;
        }
        this.gnc.add(bjVar);
        if (this.gne != null) {
            this.gne.sz(this.gnc.size());
        }
        return true;
    }

    public List<bj> bCV() {
        return this.gnc;
    }

    public void ai(bj bjVar) {
        this.gnc.remove(bjVar);
        if (this.gne != null) {
            this.gne.sz(this.gnc.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.gnc.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.fC(false);
            }
        }
        this.gnc.clear();
        if (this.gne != null) {
            this.gne.sz(0);
        }
    }

    public void reset() {
        I(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.gne = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0503a {
        private static a gng = new a();
    }

    public AntiData bCW() {
        return this.dmd;
    }

    public void b(AntiData antiData) {
        this.dmd = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bCX() {
        return this.gnf;
    }

    public void lb(boolean z) {
        this.gnf = z;
    }

    public void cc(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.gnc)) {
            Iterator<bj> it = this.gnc.iterator();
            while (it.hasNext()) {
                bj next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.gne != null) {
                this.gne.sz(this.gnc.size());
            }
        }
    }

    public boolean bCY() {
        return this.dmd != null && this.dmd.isMultiDeleteEnable();
    }
}
