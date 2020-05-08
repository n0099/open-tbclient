package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dMD;
    private String forumId;
    private final ArrayList<bj> gXm;
    private boolean gXn;
    private b gXo;
    private boolean gXp;

    /* loaded from: classes.dex */
    public interface b {
        void J(boolean z, boolean z2);

        void bNH();

        void sY(int i);
    }

    private a() {
        this.gXn = false;
        this.gXm = new ArrayList<>();
    }

    public static a bNB() {
        return C0561a.gXq;
    }

    public boolean bNC() {
        return this.gXn;
    }

    public void I(boolean z, boolean z2) {
        this.gXn = z;
        if (this.gXo != null) {
            this.gXo.J(this.gXn, z2);
        }
    }

    public boolean ak(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.gXm.size() > 29) {
            if (this.gXo != null) {
                this.gXo.bNH();
                return false;
            }
            return false;
        }
        this.gXm.add(bjVar);
        if (this.gXo != null) {
            this.gXo.sY(this.gXm.size());
        }
        return true;
    }

    public List<bj> bND() {
        return this.gXm;
    }

    public void al(bj bjVar) {
        this.gXm.remove(bjVar);
        if (this.gXo != null) {
            this.gXo.sY(this.gXm.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.gXm.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.gA(false);
            }
        }
        this.gXm.clear();
        if (this.gXo != null) {
            this.gXo.sY(0);
        }
    }

    public void reset() {
        I(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.gXo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0561a {
        private static a gXq = new a();
    }

    public AntiData bNE() {
        return this.dMD;
    }

    public void b(AntiData antiData) {
        this.dMD = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void ml(boolean z) {
        this.gXp = z;
    }

    public void co(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.gXm)) {
            Iterator<bj> it = this.gXm.iterator();
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
            if (this.gXo != null) {
                this.gXo.sY(this.gXm.size());
            }
        }
    }

    public boolean bNF() {
        return this.dMD != null && this.dMD.isMultiDeleteEnable() && this.gXp;
    }
}
