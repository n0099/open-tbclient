package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aKm;
    private final ArrayList<bb> dAF;
    private boolean dAG;
    private b dAH;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void ayq();

        void lC(int i);

        void y(boolean z, boolean z2);
    }

    private a() {
        this.dAG = false;
        this.dAF = new ArrayList<>();
    }

    public static a ayk() {
        return C0208a.dAI;
    }

    public boolean ayl() {
        return this.dAG;
    }

    public void x(boolean z, boolean z2) {
        this.dAG = z;
        if (this.dAH != null) {
            this.dAH.y(this.dAG, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dAF.size() > 29) {
            if (this.dAH != null) {
                this.dAH.ayq();
                return false;
            }
            return false;
        }
        this.dAF.add(bbVar);
        if (this.dAH != null) {
            this.dAH.lC(this.dAF.size());
        }
        return true;
    }

    public List<bb> aym() {
        return this.dAF;
    }

    public void W(bb bbVar) {
        this.dAF.remove(bbVar);
        if (this.dAH != null) {
            this.dAH.lC(this.dAF.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dAF.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.bc(false);
            }
        }
        this.dAF.clear();
        if (this.dAH != null) {
            this.dAH.lC(0);
        }
    }

    public void reset() {
        x(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dAH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0208a {
        private static a dAI = new a();
    }

    public AntiData ayn() {
        return this.aKm;
    }

    public void b(AntiData antiData) {
        this.aKm = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bz(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list) && !com.baidu.tbadk.core.util.v.I(this.dAF)) {
            Iterator<bb> it = this.dAF.iterator();
            while (it.hasNext()) {
                bb next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.ao.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.dAH != null) {
                this.dAH.lC(this.dAF.size());
            }
        }
    }

    public boolean ayo() {
        return this.aKm != null && this.aKm.isMultiDeleteEnable();
    }
}
