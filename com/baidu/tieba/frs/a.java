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
    private final ArrayList<bk> hmj;
    private boolean hmk;
    private b hml;
    private boolean hmm;

    /* loaded from: classes.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void bUf();

        void tF(int i);
    }

    private a() {
        this.hmk = false;
        this.hmj = new ArrayList<>();
    }

    public static a bTZ() {
        return C0611a.hmn;
    }

    public boolean bUa() {
        return this.hmk;
    }

    public void L(boolean z, boolean z2) {
        this.hmk = z;
        if (this.hml != null) {
            this.hml.M(this.hmk, z2);
        }
    }

    public boolean al(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        if (this.hmj.size() > 29) {
            if (this.hml != null) {
                this.hml.bUf();
                return false;
            }
            return false;
        }
        this.hmj.add(bkVar);
        if (this.hml != null) {
            this.hml.tF(this.hmj.size());
        }
        return true;
    }

    public List<bk> bUb() {
        return this.hmj;
    }

    public void am(bk bkVar) {
        this.hmj.remove(bkVar);
        if (this.hml != null) {
            this.hml.tF(this.hmj.size());
        }
    }

    public void clearData() {
        Iterator<bk> it = this.hmj.iterator();
        while (it.hasNext()) {
            bk next = it.next();
            if (next != null) {
                next.gS(false);
            }
        }
        this.hmj.clear();
        if (this.hml != null) {
            this.hml.tF(0);
        }
    }

    public void reset() {
        L(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.hml = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0611a {
        private static a hmn = new a();
    }

    public AntiData bUc() {
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
        this.hmm = z;
    }

    public void cl(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.hmj)) {
            Iterator<bk> it = this.hmj.iterator();
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
            if (this.hml != null) {
                this.hml.tF(this.hmj.size());
            }
        }
    }

    public boolean bUd() {
        return this.eaU != null && this.eaU.isMultiDeleteEnable() && this.hmm;
    }
}
