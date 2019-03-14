package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData bWP;
    private final ArrayList<bg> eXS;
    private boolean eXT;
    private b eXU;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void C(boolean z, boolean z2);

        void bbL();

        void pR(int i);
    }

    private a() {
        this.eXT = false;
        this.eXS = new ArrayList<>();
    }

    public static a bbF() {
        return C0288a.eXV;
    }

    public boolean bbG() {
        return this.eXT;
    }

    public void B(boolean z, boolean z2) {
        this.eXT = z;
        if (this.eXU != null) {
            this.eXU.C(this.eXT, z2);
        }
    }

    public boolean aa(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.eXS.size() > 29) {
            if (this.eXU != null) {
                this.eXU.bbL();
                return false;
            }
            return false;
        }
        this.eXS.add(bgVar);
        if (this.eXU != null) {
            this.eXU.pR(this.eXS.size());
        }
        return true;
    }

    public List<bg> bbH() {
        return this.eXS;
    }

    public void ab(bg bgVar) {
        this.eXS.remove(bgVar);
        if (this.eXU != null) {
            this.eXU.pR(this.eXS.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.eXS.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dn(false);
            }
        }
        this.eXS.clear();
        if (this.eXU != null) {
            this.eXU.pR(0);
        }
    }

    public void reset() {
        B(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.eXU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0288a {
        private static a eXV = new a();
    }

    public AntiData bbI() {
        return this.bWP;
    }

    public void b(AntiData antiData) {
        this.bWP = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bQ(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list) && !com.baidu.tbadk.core.util.v.T(this.eXS)) {
            Iterator<bg> it = this.eXS.iterator();
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
            if (this.eXU != null) {
                this.eXU.pR(this.eXS.size());
            }
        }
    }

    public boolean bbJ() {
        return this.bWP != null && this.bWP.isMultiDeleteEnable();
    }
}
