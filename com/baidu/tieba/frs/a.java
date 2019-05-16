package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData ceN;
    private final ArrayList<bg> fnL;
    private boolean fnM;
    private b fnN;
    private boolean fnO;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void B(boolean z, boolean z2);

        void bja();

        void qT(int i);
    }

    private a() {
        this.fnM = false;
        this.fnL = new ArrayList<>();
    }

    public static a biT() {
        return C0306a.fnP;
    }

    public boolean biU() {
        return this.fnM;
    }

    public void A(boolean z, boolean z2) {
        this.fnM = z;
        if (this.fnN != null) {
            this.fnN.B(this.fnM, z2);
        }
    }

    public boolean Z(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.fnL.size() > 29) {
            if (this.fnN != null) {
                this.fnN.bja();
                return false;
            }
            return false;
        }
        this.fnL.add(bgVar);
        if (this.fnN != null) {
            this.fnN.qT(this.fnL.size());
        }
        return true;
    }

    public List<bg> biV() {
        return this.fnL;
    }

    public void aa(bg bgVar) {
        this.fnL.remove(bgVar);
        if (this.fnN != null) {
            this.fnN.qT(this.fnL.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.fnL.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dI(false);
            }
        }
        this.fnL.clear();
        if (this.fnN != null) {
            this.fnN.qT(0);
        }
    }

    public void reset() {
        A(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.fnN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0306a {
        private static a fnP = new a();
    }

    public AntiData biW() {
        return this.ceN;
    }

    public void b(AntiData antiData) {
        this.ceN = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean biX() {
        return this.fnO;
    }

    public void jz(boolean z) {
        this.fnO = z;
    }

    public void bW(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list) && !com.baidu.tbadk.core.util.v.aa(this.fnL)) {
            Iterator<bg> it = this.fnL.iterator();
            while (it.hasNext()) {
                bg next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.ap.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.fnN != null) {
                this.fnN.qT(this.fnL.size());
            }
        }
    }

    public boolean biY() {
        return this.ceN != null && this.ceN.isMultiDeleteEnable();
    }
}
