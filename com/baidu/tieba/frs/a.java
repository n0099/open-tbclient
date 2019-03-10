package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData bWO;
    private final ArrayList<bg> eXT;
    private boolean eXU;
    private b eXV;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void C(boolean z, boolean z2);

        void bbM();

        void pR(int i);
    }

    private a() {
        this.eXU = false;
        this.eXT = new ArrayList<>();
    }

    public static a bbG() {
        return C0245a.eXW;
    }

    public boolean bbH() {
        return this.eXU;
    }

    public void B(boolean z, boolean z2) {
        this.eXU = z;
        if (this.eXV != null) {
            this.eXV.C(this.eXU, z2);
        }
    }

    public boolean aa(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.eXT.size() > 29) {
            if (this.eXV != null) {
                this.eXV.bbM();
                return false;
            }
            return false;
        }
        this.eXT.add(bgVar);
        if (this.eXV != null) {
            this.eXV.pR(this.eXT.size());
        }
        return true;
    }

    public List<bg> bbI() {
        return this.eXT;
    }

    public void ab(bg bgVar) {
        this.eXT.remove(bgVar);
        if (this.eXV != null) {
            this.eXV.pR(this.eXT.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.eXT.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dn(false);
            }
        }
        this.eXT.clear();
        if (this.eXV != null) {
            this.eXV.pR(0);
        }
    }

    public void reset() {
        B(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.eXV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0245a {
        private static a eXW = new a();
    }

    public AntiData bbJ() {
        return this.bWO;
    }

    public void b(AntiData antiData) {
        this.bWO = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bQ(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list) && !com.baidu.tbadk.core.util.v.T(this.eXT)) {
            Iterator<bg> it = this.eXT.iterator();
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
            if (this.eXV != null) {
                this.eXV.pR(this.eXT.size());
            }
        }
    }

    public boolean bbK() {
        return this.bWO != null && this.bWO.isMultiDeleteEnable();
    }
}
