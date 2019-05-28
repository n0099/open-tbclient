package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData ceN;
    private final ArrayList<bg> fnM;
    private boolean fnN;
    private b fnO;
    private boolean fnP;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void B(boolean z, boolean z2);

        void bjd();

        void qT(int i);
    }

    private a() {
        this.fnN = false;
        this.fnM = new ArrayList<>();
    }

    public static a biW() {
        return C0306a.fnQ;
    }

    public boolean biX() {
        return this.fnN;
    }

    public void A(boolean z, boolean z2) {
        this.fnN = z;
        if (this.fnO != null) {
            this.fnO.B(this.fnN, z2);
        }
    }

    public boolean Z(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.fnM.size() > 29) {
            if (this.fnO != null) {
                this.fnO.bjd();
                return false;
            }
            return false;
        }
        this.fnM.add(bgVar);
        if (this.fnO != null) {
            this.fnO.qT(this.fnM.size());
        }
        return true;
    }

    public List<bg> biY() {
        return this.fnM;
    }

    public void aa(bg bgVar) {
        this.fnM.remove(bgVar);
        if (this.fnO != null) {
            this.fnO.qT(this.fnM.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.fnM.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dI(false);
            }
        }
        this.fnM.clear();
        if (this.fnO != null) {
            this.fnO.qT(0);
        }
    }

    public void reset() {
        A(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.fnO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0306a {
        private static a fnQ = new a();
    }

    public AntiData biZ() {
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

    public boolean bja() {
        return this.fnP;
    }

    public void jz(boolean z) {
        this.fnP = z;
    }

    public void bW(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list) && !com.baidu.tbadk.core.util.v.aa(this.fnM)) {
            Iterator<bg> it = this.fnM.iterator();
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
            if (this.fnO != null) {
                this.fnO.qT(this.fnM.size());
            }
        }
    }

    public boolean bjb() {
        return this.ceN != null && this.ceN.isMultiDeleteEnable();
    }
}
