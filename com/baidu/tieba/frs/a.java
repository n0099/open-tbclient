package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData eaU;
    private String forumId;
    private final ArrayList<bk> hlY;
    private boolean hlZ;
    private b hma;
    private boolean hmb;

    /* loaded from: classes.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void bUd();

        void tD(int i);
    }

    private a() {
        this.hlZ = false;
        this.hlY = new ArrayList<>();
    }

    public static a bTX() {
        return C0611a.hmc;
    }

    public boolean bTY() {
        return this.hlZ;
    }

    public void L(boolean z, boolean z2) {
        this.hlZ = z;
        if (this.hma != null) {
            this.hma.M(this.hlZ, z2);
        }
    }

    public boolean al(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        if (this.hlY.size() > 29) {
            if (this.hma != null) {
                this.hma.bUd();
                return false;
            }
            return false;
        }
        this.hlY.add(bkVar);
        if (this.hma != null) {
            this.hma.tD(this.hlY.size());
        }
        return true;
    }

    public List<bk> bTZ() {
        return this.hlY;
    }

    public void am(bk bkVar) {
        this.hlY.remove(bkVar);
        if (this.hma != null) {
            this.hma.tD(this.hlY.size());
        }
    }

    public void clearData() {
        Iterator<bk> it = this.hlY.iterator();
        while (it.hasNext()) {
            bk next = it.next();
            if (next != null) {
                next.gS(false);
            }
        }
        this.hlY.clear();
        if (this.hma != null) {
            this.hma.tD(0);
        }
    }

    public void reset() {
        L(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.hma = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0611a {
        private static a hmc = new a();
    }

    public AntiData bUa() {
        return this.eaU;
    }

    public void b(AntiData antiData) {
        this.eaU = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void mG(boolean z) {
        this.hmb = z;
    }

    public void cl(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.hlY)) {
            Iterator<bk> it = this.hlY.iterator();
            while (it.hasNext()) {
                bk next = it.next();
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
            if (this.hma != null) {
                this.hma.tD(this.hlY.size());
            }
        }
    }

    public boolean bUb() {
        return this.eaU != null && this.eaU.isMultiDeleteEnable() && this.hmb;
    }
}
