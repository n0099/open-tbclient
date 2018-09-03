package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aBN;
    private final ArrayList<bb> dlu;
    private boolean dlv;
    private b dlw;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void atH();

        void kn(int i);

        void t(boolean z, boolean z2);
    }

    private a() {
        this.dlv = false;
        this.dlu = new ArrayList<>();
    }

    public static a atC() {
        return C0149a.dlx;
    }

    public boolean atD() {
        return this.dlv;
    }

    public void s(boolean z, boolean z2) {
        this.dlv = z;
        if (this.dlw != null) {
            this.dlw.t(this.dlv, z2);
        }
    }

    public boolean U(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dlu.size() > 29) {
            if (this.dlw != null) {
                this.dlw.atH();
                return false;
            }
            return false;
        }
        this.dlu.add(bbVar);
        if (this.dlw != null) {
            this.dlw.kn(this.dlu.size());
        }
        return true;
    }

    public List<bb> atE() {
        return this.dlu;
    }

    public void V(bb bbVar) {
        this.dlu.remove(bbVar);
        if (this.dlw != null) {
            this.dlw.kn(this.dlu.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dlu.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.at(false);
            }
        }
        this.dlu.clear();
        if (this.dlw != null) {
            this.dlw.kn(0);
        }
    }

    public void reset() {
        s(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dlw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0149a {
        private static a dlx = new a();
    }

    public AntiData Cb() {
        return this.aBN;
    }

    public void b(AntiData antiData) {
        this.aBN = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bk(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.z(list) && !com.baidu.tbadk.core.util.w.z(this.dlu)) {
            Iterator<bb> it = this.dlu.iterator();
            while (it.hasNext()) {
                bb next = it.next();
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
            if (this.dlw != null) {
                this.dlw.kn(this.dlu.size());
            }
        }
    }

    public boolean atF() {
        return this.aBN != null && this.aBN.isMultiDeleteEnable();
    }
}
