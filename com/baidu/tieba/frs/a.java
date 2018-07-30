package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aBQ;
    private final ArrayList<bb> dlw;
    private boolean dlx;
    private b dly;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void atI();

        void ko(int i);

        void t(boolean z, boolean z2);
    }

    private a() {
        this.dlx = false;
        this.dlw = new ArrayList<>();
    }

    public static a atD() {
        return C0149a.dlz;
    }

    public boolean atE() {
        return this.dlx;
    }

    public void s(boolean z, boolean z2) {
        this.dlx = z;
        if (this.dly != null) {
            this.dly.t(this.dlx, z2);
        }
    }

    public boolean U(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dlw.size() > 29) {
            if (this.dly != null) {
                this.dly.atI();
                return false;
            }
            return false;
        }
        this.dlw.add(bbVar);
        if (this.dly != null) {
            this.dly.ko(this.dlw.size());
        }
        return true;
    }

    public List<bb> atF() {
        return this.dlw;
    }

    public void V(bb bbVar) {
        this.dlw.remove(bbVar);
        if (this.dly != null) {
            this.dly.ko(this.dlw.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dlw.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.as(false);
            }
        }
        this.dlw.clear();
        if (this.dly != null) {
            this.dly.ko(0);
        }
    }

    public void reset() {
        s(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dly = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0149a {
        private static a dlz = new a();
    }

    public AntiData Ce() {
        return this.aBQ;
    }

    public void b(AntiData antiData) {
        this.aBQ = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bk(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.z(list) && !com.baidu.tbadk.core.util.w.z(this.dlw)) {
            Iterator<bb> it = this.dlw.iterator();
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
            if (this.dly != null) {
                this.dly.ko(this.dlw.size());
            }
        }
    }

    public boolean atG() {
        return this.aBQ != null && this.aBQ.isMultiDeleteEnable();
    }
}
