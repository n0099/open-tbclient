package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dMz;
    private String forumId;
    private final ArrayList<bj> gXg;
    private boolean gXh;
    private b gXi;
    private boolean gXj;

    /* loaded from: classes.dex */
    public interface b {
        void J(boolean z, boolean z2);

        void bNJ();

        void sY(int i);
    }

    private a() {
        this.gXh = false;
        this.gXg = new ArrayList<>();
    }

    public static a bND() {
        return C0540a.gXk;
    }

    public boolean bNE() {
        return this.gXh;
    }

    public void I(boolean z, boolean z2) {
        this.gXh = z;
        if (this.gXi != null) {
            this.gXi.J(this.gXh, z2);
        }
    }

    public boolean ak(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.gXg.size() > 29) {
            if (this.gXi != null) {
                this.gXi.bNJ();
                return false;
            }
            return false;
        }
        this.gXg.add(bjVar);
        if (this.gXi != null) {
            this.gXi.sY(this.gXg.size());
        }
        return true;
    }

    public List<bj> bNF() {
        return this.gXg;
    }

    public void al(bj bjVar) {
        this.gXg.remove(bjVar);
        if (this.gXi != null) {
            this.gXi.sY(this.gXg.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.gXg.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.gA(false);
            }
        }
        this.gXg.clear();
        if (this.gXi != null) {
            this.gXi.sY(0);
        }
    }

    public void reset() {
        I(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.gXi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0540a {
        private static a gXk = new a();
    }

    public AntiData bNG() {
        return this.dMz;
    }

    public void b(AntiData antiData) {
        this.dMz = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void ml(boolean z) {
        this.gXj = z;
    }

    public void co(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.gXg)) {
            Iterator<bj> it = this.gXg.iterator();
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
            if (this.gXi != null) {
                this.gXi.sY(this.gXg.size());
            }
        }
    }

    public boolean bNH() {
        return this.dMz != null && this.dMz.isMultiDeleteEnable() && this.gXj;
    }
}
