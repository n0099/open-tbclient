package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData cga;
    private String forumId;
    private final ArrayList<bh> ftk;
    private boolean ftl;
    private b ftm;
    private boolean ftn;

    /* loaded from: classes.dex */
    public interface b {
        void E(boolean z, boolean z2);

        void blm();

        void rn(int i);
    }

    private a() {
        this.ftl = false;
        this.ftk = new ArrayList<>();
    }

    public static a blf() {
        return C0309a.fto;
    }

    public boolean blg() {
        return this.ftl;
    }

    public void D(boolean z, boolean z2) {
        this.ftl = z;
        if (this.ftm != null) {
            this.ftm.E(this.ftl, z2);
        }
    }

    public boolean aa(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        if (this.ftk.size() > 29) {
            if (this.ftm != null) {
                this.ftm.blm();
                return false;
            }
            return false;
        }
        this.ftk.add(bhVar);
        if (this.ftm != null) {
            this.ftm.rn(this.ftk.size());
        }
        return true;
    }

    public List<bh> blh() {
        return this.ftk;
    }

    public void ab(bh bhVar) {
        this.ftk.remove(bhVar);
        if (this.ftm != null) {
            this.ftm.rn(this.ftk.size());
        }
    }

    public void clearData() {
        Iterator<bh> it = this.ftk.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                next.dM(false);
            }
        }
        this.ftk.clear();
        if (this.ftm != null) {
            this.ftm.rn(0);
        }
    }

    public void reset() {
        D(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.ftm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0309a {
        private static a fto = new a();
    }

    public AntiData bli() {
        return this.cga;
    }

    public void b(AntiData antiData) {
        this.cga = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean blj() {
        return this.ftn;
    }

    public void jJ(boolean z) {
        this.ftn = z;
    }

    public void bX(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list) && !com.baidu.tbadk.core.util.v.aa(this.ftk)) {
            Iterator<bh> it = this.ftk.iterator();
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
            if (this.ftm != null) {
                this.ftm.rn(this.ftk.size());
            }
        }
    }

    public boolean blk() {
        return this.cga != null && this.cga.isMultiDeleteEnable();
    }
}
