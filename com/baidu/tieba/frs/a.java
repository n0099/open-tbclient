package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dmr;
    private String forumId;
    private final ArrayList<bj> gnr;
    private boolean gns;
    private b gnt;
    private boolean gnu;

    /* loaded from: classes.dex */
    public interface b {
        void J(boolean z, boolean z2);

        void bDd();

        void sz(int i);
    }

    private a() {
        this.gns = false;
        this.gnr = new ArrayList<>();
    }

    public static a bCW() {
        return C0503a.gnv;
    }

    public boolean bCX() {
        return this.gns;
    }

    public void I(boolean z, boolean z2) {
        this.gns = z;
        if (this.gnt != null) {
            this.gnt.J(this.gns, z2);
        }
    }

    public boolean ah(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.gnr.size() > 29) {
            if (this.gnt != null) {
                this.gnt.bDd();
                return false;
            }
            return false;
        }
        this.gnr.add(bjVar);
        if (this.gnt != null) {
            this.gnt.sz(this.gnr.size());
        }
        return true;
    }

    public List<bj> bCY() {
        return this.gnr;
    }

    public void ai(bj bjVar) {
        this.gnr.remove(bjVar);
        if (this.gnt != null) {
            this.gnt.sz(this.gnr.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.gnr.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.fC(false);
            }
        }
        this.gnr.clear();
        if (this.gnt != null) {
            this.gnt.sz(0);
        }
    }

    public void reset() {
        I(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.gnt = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0503a {
        private static a gnv = new a();
    }

    public AntiData bCZ() {
        return this.dmr;
    }

    public void b(AntiData antiData) {
        this.dmr = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bDa() {
        return this.gnu;
    }

    public void lb(boolean z) {
        this.gnu = z;
    }

    public void cc(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.gnr)) {
            Iterator<bj> it = this.gnr.iterator();
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
            if (this.gnt != null) {
                this.gnt.sz(this.gnr.size());
            }
        }
    }

    public boolean bDb() {
        return this.dmr != null && this.dmr.isMultiDeleteEnable();
    }
}
