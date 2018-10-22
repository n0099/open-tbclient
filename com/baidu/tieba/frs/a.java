package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aJw;
    private final ArrayList<bb> dzo;
    private boolean dzp;
    private b dzq;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void ayT();

        void lk(int i);

        void w(boolean z, boolean z2);
    }

    private a() {
        this.dzp = false;
        this.dzo = new ArrayList<>();
    }

    public static a ayN() {
        return C0183a.dzr;
    }

    public boolean ayO() {
        return this.dzp;
    }

    public void v(boolean z, boolean z2) {
        this.dzp = z;
        if (this.dzq != null) {
            this.dzq.w(this.dzp, z2);
        }
    }

    public boolean V(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        if (this.dzo.size() > 29) {
            if (this.dzq != null) {
                this.dzq.ayT();
                return false;
            }
            return false;
        }
        this.dzo.add(bbVar);
        if (this.dzq != null) {
            this.dzq.lk(this.dzo.size());
        }
        return true;
    }

    public List<bb> ayP() {
        return this.dzo;
    }

    public void W(bb bbVar) {
        this.dzo.remove(bbVar);
        if (this.dzq != null) {
            this.dzq.lk(this.dzo.size());
        }
    }

    public void clearData() {
        Iterator<bb> it = this.dzo.iterator();
        while (it.hasNext()) {
            bb next = it.next();
            if (next != null) {
                next.aM(false);
            }
        }
        this.dzo.clear();
        if (this.dzq != null) {
            this.dzq.lk(0);
        }
    }

    public void reset() {
        v(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.dzq = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0183a {
        private static a dzr = new a();
    }

    public AntiData ayQ() {
        return this.aJw;
    }

    public void b(AntiData antiData) {
        this.aJw = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bB(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.J(list) && !com.baidu.tbadk.core.util.v.J(this.dzo)) {
            Iterator<bb> it = this.dzo.iterator();
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
            if (this.dzq != null) {
                this.dzq.lk(this.dzo.size());
            }
        }
    }

    public boolean ayR() {
        return this.aJw != null && this.aJw.isMultiDeleteEnable();
    }
}
