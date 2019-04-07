package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData bWR;
    private final ArrayList<bg> eXE;
    private boolean eXF;
    private b eXG;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void A(boolean z, boolean z2);

        void bbJ();

        void pN(int i);
    }

    private a() {
        this.eXF = false;
        this.eXE = new ArrayList<>();
    }

    public static a bbD() {
        return C0288a.eXH;
    }

    public boolean bbE() {
        return this.eXF;
    }

    public void z(boolean z, boolean z2) {
        this.eXF = z;
        if (this.eXG != null) {
            this.eXG.A(this.eXF, z2);
        }
    }

    public boolean Z(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.eXE.size() > 29) {
            if (this.eXG != null) {
                this.eXG.bbJ();
                return false;
            }
            return false;
        }
        this.eXE.add(bgVar);
        if (this.eXG != null) {
            this.eXG.pN(this.eXE.size());
        }
        return true;
    }

    public List<bg> bbF() {
        return this.eXE;
    }

    public void aa(bg bgVar) {
        this.eXE.remove(bgVar);
        if (this.eXG != null) {
            this.eXG.pN(this.eXE.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.eXE.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dn(false);
            }
        }
        this.eXE.clear();
        if (this.eXG != null) {
            this.eXG.pN(0);
        }
    }

    public void reset() {
        z(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.eXG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0288a {
        private static a eXH = new a();
    }

    public AntiData bbG() {
        return this.bWR;
    }

    public void b(AntiData antiData) {
        this.bWR = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bO(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list) && !com.baidu.tbadk.core.util.v.T(this.eXE)) {
            Iterator<bg> it = this.eXE.iterator();
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
            if (this.eXG != null) {
                this.eXG.pN(this.eXE.size());
            }
        }
    }

    public boolean bbH() {
        return this.bWR != null && this.bWR.isMultiDeleteEnable();
    }
}
