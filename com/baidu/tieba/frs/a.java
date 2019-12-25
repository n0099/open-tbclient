package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dhK;
    private String forumId;
    private final ArrayList<bj> ghR;
    private boolean ghS;
    private b ghT;
    private boolean ghU;

    /* loaded from: classes.dex */
    public interface b {
        void H(boolean z, boolean z2);

        void bAw();

        void so(int i);
    }

    private a() {
        this.ghS = false;
        this.ghR = new ArrayList<>();
    }

    public static a bAp() {
        return C0492a.ghV;
    }

    public boolean bAq() {
        return this.ghS;
    }

    public void G(boolean z, boolean z2) {
        this.ghS = z;
        if (this.ghT != null) {
            this.ghT.H(this.ghS, z2);
        }
    }

    public boolean af(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.ghR.size() > 29) {
            if (this.ghT != null) {
                this.ghT.bAw();
                return false;
            }
            return false;
        }
        this.ghR.add(bjVar);
        if (this.ghT != null) {
            this.ghT.so(this.ghR.size());
        }
        return true;
    }

    public List<bj> bAr() {
        return this.ghR;
    }

    public void ag(bj bjVar) {
        this.ghR.remove(bjVar);
        if (this.ghT != null) {
            this.ghT.so(this.ghR.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.ghR.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.fq(false);
            }
        }
        this.ghR.clear();
        if (this.ghT != null) {
            this.ghT.so(0);
        }
    }

    public void reset() {
        G(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.ghT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0492a {
        private static a ghV = new a();
    }

    public AntiData bAs() {
        return this.dhK;
    }

    public void b(AntiData antiData) {
        this.dhK = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bAt() {
        return this.ghU;
    }

    public void kM(boolean z) {
        this.ghU = z;
    }

    public void cg(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.ghR)) {
            Iterator<bj> it = this.ghR.iterator();
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
            if (this.ghT != null) {
                this.ghT.so(this.ghR.size());
            }
        }
    }

    public boolean bAu() {
        return this.dhK != null && this.dhK.isMultiDeleteEnable();
    }
}
