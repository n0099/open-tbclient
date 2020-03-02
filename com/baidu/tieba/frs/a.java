package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dme;
    private String forumId;
    private final ArrayList<bj> gne;
    private boolean gnf;
    private b gng;
    private boolean gnh;

    /* loaded from: classes.dex */
    public interface b {
        void J(boolean z, boolean z2);

        void bDc();

        void sz(int i);
    }

    private a() {
        this.gnf = false;
        this.gne = new ArrayList<>();
    }

    public static a bCV() {
        return C0503a.gni;
    }

    public boolean bCW() {
        return this.gnf;
    }

    public void I(boolean z, boolean z2) {
        this.gnf = z;
        if (this.gng != null) {
            this.gng.J(this.gnf, z2);
        }
    }

    public boolean ah(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.gne.size() > 29) {
            if (this.gng != null) {
                this.gng.bDc();
                return false;
            }
            return false;
        }
        this.gne.add(bjVar);
        if (this.gng != null) {
            this.gng.sz(this.gne.size());
        }
        return true;
    }

    public List<bj> bCX() {
        return this.gne;
    }

    public void ai(bj bjVar) {
        this.gne.remove(bjVar);
        if (this.gng != null) {
            this.gng.sz(this.gne.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.gne.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.fC(false);
            }
        }
        this.gne.clear();
        if (this.gng != null) {
            this.gng.sz(0);
        }
    }

    public void reset() {
        I(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.gng = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0503a {
        private static a gni = new a();
    }

    public AntiData bCY() {
        return this.dme;
    }

    public void b(AntiData antiData) {
        this.dme = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bCZ() {
        return this.gnh;
    }

    public void lb(boolean z) {
        this.gnh = z;
    }

    public void cc(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.gne)) {
            Iterator<bj> it = this.gne.iterator();
            while (it.hasNext()) {
                bj next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.gng != null) {
                this.gng.sz(this.gne.size());
            }
        }
    }

    public boolean bDa() {
        return this.dme != null && this.dme.isMultiDeleteEnable();
    }
}
