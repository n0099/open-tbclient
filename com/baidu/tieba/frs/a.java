package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData cua;
    private String forumId;
    private final ArrayList<bh> ftt;
    private boolean ftu;
    private b ftv;
    private boolean ftw;

    /* loaded from: classes.dex */
    public interface b {
        void H(boolean z, boolean z2);

        void bjb();

        void qi(int i);
    }

    private a() {
        this.ftu = false;
        this.ftt = new ArrayList<>();
    }

    public static a biU() {
        return C0404a.ftx;
    }

    public boolean biV() {
        return this.ftu;
    }

    public void G(boolean z, boolean z2) {
        this.ftu = z;
        if (this.ftv != null) {
            this.ftv.H(this.ftu, z2);
        }
    }

    public boolean Z(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        if (this.ftt.size() > 29) {
            if (this.ftv != null) {
                this.ftv.bjb();
                return false;
            }
            return false;
        }
        this.ftt.add(bhVar);
        if (this.ftv != null) {
            this.ftv.qi(this.ftt.size());
        }
        return true;
    }

    public List<bh> biW() {
        return this.ftt;
    }

    public void aa(bh bhVar) {
        this.ftt.remove(bhVar);
        if (this.ftv != null) {
            this.ftv.qi(this.ftt.size());
        }
    }

    public void clearData() {
        Iterator<bh> it = this.ftt.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                next.ec(false);
            }
        }
        this.ftt.clear();
        if (this.ftv != null) {
            this.ftv.qi(0);
        }
    }

    public void reset() {
        G(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.ftv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0404a {
        private static a ftx = new a();
    }

    public AntiData biX() {
        return this.cua;
    }

    public void b(AntiData antiData) {
        this.cua = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean biY() {
        return this.ftw;
    }

    public void jA(boolean z) {
        this.ftw = z;
    }

    public void ck(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.ftt)) {
            Iterator<bh> it = this.ftt.iterator();
            while (it.hasNext()) {
                bh next = it.next();
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
            if (this.ftv != null) {
                this.ftv.qi(this.ftt.size());
            }
        }
    }

    public boolean biZ() {
        return this.cua != null && this.cua.isMultiDeleteEnable();
    }
}
