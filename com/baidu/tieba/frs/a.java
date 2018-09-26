package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aET;
    private final ArrayList<bb> drn;
    private boolean dro;
    private b drp;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void avw();

        void kM(int i);

        void v(boolean z, boolean z2);
    }

    private a() {
        this.dro = false;
        this.drn = new ArrayList<>();
    }

    public static a avq() {
        return C0149a.drq;
    }

    public boolean avr() {
        return this.dro;
    }

    public void u(boolean z, boolean z2) {
        this.dro = z;
        if (this.drp != null) {
            this.drp.v(this.dro, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.drn.size() > 29) {
            if (this.drp != null) {
                this.drp.avw();
                return false;
            }
            return false;
        }
        this.drn.add(bbVar);
        if (this.drp != null) {
            this.drp.kM(this.drn.size());
        }
        return true;
    }

    public List<bb> avs() {
        return this.drn;
    }

    public void W(bb bbVar) {
        this.drn.remove(bbVar);
        if (this.drp != null) {
            this.drp.kM(this.drn.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.drn.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.aC(false);
            }
        }
        this.drn.clear();
        if (this.drp != null) {
            this.drp.kM(0);
        }
    }

    public void reset() {
        u(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.drp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0149a {
        private static a drq = new a();
    }

    public AntiData avt() {
        return this.aET;
    }

    public void b(AntiData antiData) {
        this.aET = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bl(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.z(list) && !com.baidu.tbadk.core.util.v.z(this.drn)) {
            Iterator<bb> it = this.drn.iterator();
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
            if (this.drp != null) {
                this.drp.kM(this.drn.size());
            }
        }
    }

    public boolean avu() {
        return this.aET != null && this.aET.isMultiDeleteEnable();
    }
}
