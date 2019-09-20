package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData cgT;
    private String forumId;
    private final ArrayList<bh> fuX;
    private boolean fuY;
    private b fuZ;
    private boolean fva;

    /* loaded from: classes.dex */
    public interface b {
        void E(boolean z, boolean z2);

        void blX();

        void rq(int i);
    }

    private a() {
        this.fuY = false;
        this.fuX = new ArrayList<>();
    }

    public static a blQ() {
        return C0320a.fvb;
    }

    public boolean blR() {
        return this.fuY;
    }

    public void D(boolean z, boolean z2) {
        this.fuY = z;
        if (this.fuZ != null) {
            this.fuZ.E(this.fuY, z2);
        }
    }

    public boolean ab(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        if (this.fuX.size() > 29) {
            if (this.fuZ != null) {
                this.fuZ.blX();
                return false;
            }
            return false;
        }
        this.fuX.add(bhVar);
        if (this.fuZ != null) {
            this.fuZ.rq(this.fuX.size());
        }
        return true;
    }

    public List<bh> blS() {
        return this.fuX;
    }

    public void ac(bh bhVar) {
        this.fuX.remove(bhVar);
        if (this.fuZ != null) {
            this.fuZ.rq(this.fuX.size());
        }
    }

    public void clearData() {
        Iterator<bh> it = this.fuX.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                next.dM(false);
            }
        }
        this.fuX.clear();
        if (this.fuZ != null) {
            this.fuZ.rq(0);
        }
    }

    public void reset() {
        D(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.fuZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0320a {
        private static a fvb = new a();
    }

    public AntiData blT() {
        return this.cgT;
    }

    public void b(AntiData antiData) {
        this.cgT = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean blU() {
        return this.fva;
    }

    public void jM(boolean z) {
        this.fva = z;
    }

    public void bX(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list) && !com.baidu.tbadk.core.util.v.aa(this.fuX)) {
            Iterator<bh> it = this.fuX.iterator();
            while (it.hasNext()) {
                bh next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.aq.bV(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.fuZ != null) {
                this.fuZ.rq(this.fuX.size());
            }
        }
    }

    public boolean blV() {
        return this.cgT != null && this.cgT.isMultiDeleteEnable();
    }
}
