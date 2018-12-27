package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aNN;
    private final ArrayList<bb> dJS;
    private boolean dJT;
    private b dJU;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void aAP();

        void mf(int i);

        void y(boolean z, boolean z2);
    }

    private a() {
        this.dJT = false;
        this.dJS = new ArrayList<>();
    }

    public static a aAJ() {
        return C0218a.dJV;
    }

    public boolean aAK() {
        return this.dJT;
    }

    public void x(boolean z, boolean z2) {
        this.dJT = z;
        if (this.dJU != null) {
            this.dJU.y(this.dJT, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dJS.size() > 29) {
            if (this.dJU != null) {
                this.dJU.aAP();
                return false;
            }
            return false;
        }
        this.dJS.add(bbVar);
        if (this.dJU != null) {
            this.dJU.mf(this.dJS.size());
        }
        return true;
    }

    public List<bb> aAL() {
        return this.dJS;
    }

    public void W(bb bbVar) {
        this.dJS.remove(bbVar);
        if (this.dJU != null) {
            this.dJU.mf(this.dJS.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dJS.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.bd(false);
            }
        }
        this.dJS.clear();
        if (this.dJU != null) {
            this.dJU.mf(0);
        }
    }

    public void reset() {
        x(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dJU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0218a {
        private static a dJV = new a();
    }

    public AntiData aAM() {
        return this.aNN;
    }

    public void b(AntiData antiData) {
        this.aNN = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bC(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list) && !com.baidu.tbadk.core.util.v.I(this.dJS)) {
            Iterator<bb> it = this.dJS.iterator();
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
            if (this.dJU != null) {
                this.dJU.mf(this.dJS.size());
            }
        }
    }

    public boolean aAN() {
        return this.aNN != null && this.aNN.isMultiDeleteEnable();
    }
}
