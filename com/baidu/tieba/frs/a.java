package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aNL;
    private final ArrayList<bb> dHe;
    private boolean dHf;
    private b dHg;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void aAa();

        void lS(int i);

        void y(boolean z, boolean z2);
    }

    private a() {
        this.dHf = false;
        this.dHe = new ArrayList<>();
    }

    public static a azU() {
        return C0218a.dHh;
    }

    public boolean azV() {
        return this.dHf;
    }

    public void x(boolean z, boolean z2) {
        this.dHf = z;
        if (this.dHg != null) {
            this.dHg.y(this.dHf, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dHe.size() > 29) {
            if (this.dHg != null) {
                this.dHg.aAa();
                return false;
            }
            return false;
        }
        this.dHe.add(bbVar);
        if (this.dHg != null) {
            this.dHg.lS(this.dHe.size());
        }
        return true;
    }

    public List<bb> azW() {
        return this.dHe;
    }

    public void W(bb bbVar) {
        this.dHe.remove(bbVar);
        if (this.dHg != null) {
            this.dHg.lS(this.dHe.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dHe.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.bd(false);
            }
        }
        this.dHe.clear();
        if (this.dHg != null) {
            this.dHg.lS(0);
        }
    }

    public void reset() {
        x(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dHg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0218a {
        private static a dHh = new a();
    }

    public AntiData azX() {
        return this.aNL;
    }

    public void b(AntiData antiData) {
        this.aNL = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bB(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list) && !com.baidu.tbadk.core.util.v.I(this.dHe)) {
            Iterator<bb> it = this.dHe.iterator();
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
            if (this.dHg != null) {
                this.dHg.lS(this.dHe.size());
            }
        }
    }

    public boolean azY() {
        return this.aNL != null && this.aNL.isMultiDeleteEnable();
    }
}
