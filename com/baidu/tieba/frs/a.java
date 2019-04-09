package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData bWS;
    private final ArrayList<bg> eXF;
    private boolean eXG;
    private b eXH;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void A(boolean z, boolean z2);

        void bbJ();

        void pN(int i);
    }

    private a() {
        this.eXG = false;
        this.eXF = new ArrayList<>();
    }

    public static a bbD() {
        return C0288a.eXI;
    }

    public boolean bbE() {
        return this.eXG;
    }

    public void z(boolean z, boolean z2) {
        this.eXG = z;
        if (this.eXH != null) {
            this.eXH.A(this.eXG, z2);
        }
    }

    public boolean Z(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.eXF.size() > 29) {
            if (this.eXH != null) {
                this.eXH.bbJ();
                return false;
            }
            return false;
        }
        this.eXF.add(bgVar);
        if (this.eXH != null) {
            this.eXH.pN(this.eXF.size());
        }
        return true;
    }

    public List<bg> bbF() {
        return this.eXF;
    }

    public void aa(bg bgVar) {
        this.eXF.remove(bgVar);
        if (this.eXH != null) {
            this.eXH.pN(this.eXF.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.eXF.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dn(false);
            }
        }
        this.eXF.clear();
        if (this.eXH != null) {
            this.eXH.pN(0);
        }
    }

    public void reset() {
        z(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.eXH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0288a {
        private static a eXI = new a();
    }

    public AntiData bbG() {
        return this.bWS;
    }

    public void b(AntiData antiData) {
        this.bWS = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bO(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list) && !com.baidu.tbadk.core.util.v.T(this.eXF)) {
            Iterator<bg> it = this.eXF.iterator();
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
            if (this.eXH != null) {
                this.eXH.pN(this.eXF.size());
            }
        }
    }

    public boolean bbH() {
        return this.bWS != null && this.bWS.isMultiDeleteEnable();
    }
}
