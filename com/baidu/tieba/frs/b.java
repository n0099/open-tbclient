package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private AntiData fcN;
    private String forumId;
    private ay iFX;
    private final ArrayList<bw> iFZ;
    private boolean iGa;
    private boolean iGb;

    private b() {
        this.iGa = false;
        this.iFZ = new ArrayList<>();
    }

    public static b cxm() {
        return a.iGc;
    }

    public boolean cxg() {
        return this.iGa;
    }

    public void V(boolean z, boolean z2) {
        this.iGa = z;
        if (this.iFX != null) {
            this.iFX.d(this.iGa, z2, 1);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.iFZ.size() > 29) {
            if (this.iFX != null) {
                this.iFX.yH(1);
                return false;
            }
            return false;
        }
        this.iFZ.add(bwVar);
        if (this.iFX != null) {
            this.iFX.cm(this.iFZ.size(), 1);
        }
        return true;
    }

    public List<bw> cxj() {
        return this.iFZ;
    }

    public void ak(bw bwVar) {
        this.iFZ.remove(bwVar);
        if (this.iFX != null) {
            this.iFX.cm(this.iFZ.size(), 1);
        }
    }

    public void clearData() {
        Iterator<bw> it = this.iFZ.iterator();
        while (it.hasNext()) {
            bw next = it.next();
            if (next != null) {
                next.iQ(false);
            }
        }
        this.iFZ.clear();
        if (this.iFX != null) {
            this.iFX.cm(0, 1);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void a(ay ayVar) {
        this.iFX = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b iGc = new b();
    }

    public AntiData cxn() {
        return this.fcN;
    }

    public void b(AntiData antiData) {
        this.fcN = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void po(boolean z) {
        this.iGb = z;
    }

    public void dc(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !com.baidu.tbadk.core.util.y.isEmpty(this.iFZ)) {
            Iterator<bw> it = this.iFZ.iterator();
            while (it.hasNext()) {
                bw next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.iFX != null) {
                this.iFX.cm(this.iFZ.size(), 1);
            }
        }
    }

    public boolean cxo() {
        return this.iGb;
    }
}
