package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dmE;
    private String forumId;
    private final ArrayList<bj> goa;
    private boolean gob;
    private b goc;
    private boolean god;
    private boolean goe;

    /* loaded from: classes.dex */
    public interface b {
        void J(boolean z, boolean z2);

        void bDl();

        void sB(int i);
    }

    private a() {
        this.gob = false;
        this.goa = new ArrayList<>();
    }

    public static a bDd() {
        return C0503a.gof;
    }

    public boolean bDe() {
        return this.gob;
    }

    public void I(boolean z, boolean z2) {
        this.gob = z;
        if (this.goc != null) {
            this.goc.J(this.gob, z2);
        }
    }

    public boolean ai(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.goa.size() > 29) {
            if (this.goc != null) {
                this.goc.bDl();
                return false;
            }
            return false;
        }
        this.goa.add(bjVar);
        if (this.goc != null) {
            this.goc.sB(this.goa.size());
        }
        return true;
    }

    public List<bj> bDf() {
        return this.goa;
    }

    public void aj(bj bjVar) {
        this.goa.remove(bjVar);
        if (this.goc != null) {
            this.goc.sB(this.goa.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.goa.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.fD(false);
            }
        }
        this.goa.clear();
        if (this.goc != null) {
            this.goc.sB(0);
        }
    }

    public void reset() {
        I(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.goc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0503a {
        private static a gof = new a();
    }

    public AntiData bDg() {
        return this.dmE;
    }

    public void b(AntiData antiData) {
        this.dmE = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bDh() {
        return this.god;
    }

    public void lg(boolean z) {
        this.god = z;
    }

    public boolean bDi() {
        return this.goe;
    }

    public void lh(boolean z) {
        this.goe = z;
    }

    public void cc(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.goa)) {
            Iterator<bj> it = this.goa.iterator();
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
            if (this.goc != null) {
                this.goc.sB(this.goa.size());
            }
        }
    }

    public boolean bDj() {
        return this.dmE != null && this.dmE.isMultiDeleteEnable();
    }
}
