package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData cuS;
    private String forumId;
    private final ArrayList<bh> fuk;
    private boolean ful;
    private b fum;
    private boolean fun;

    /* loaded from: classes.dex */
    public interface b {
        void H(boolean z, boolean z2);

        void bjd();

        void qj(int i);
    }

    private a() {
        this.ful = false;
        this.fuk = new ArrayList<>();
    }

    public static a biW() {
        return C0409a.fuo;
    }

    public boolean biX() {
        return this.ful;
    }

    public void G(boolean z, boolean z2) {
        this.ful = z;
        if (this.fum != null) {
            this.fum.H(this.ful, z2);
        }
    }

    public boolean Z(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        if (this.fuk.size() > 29) {
            if (this.fum != null) {
                this.fum.bjd();
                return false;
            }
            return false;
        }
        this.fuk.add(bhVar);
        if (this.fum != null) {
            this.fum.qj(this.fuk.size());
        }
        return true;
    }

    public List<bh> biY() {
        return this.fuk;
    }

    public void aa(bh bhVar) {
        this.fuk.remove(bhVar);
        if (this.fum != null) {
            this.fum.qj(this.fuk.size());
        }
    }

    public void clearData() {
        Iterator<bh> it = this.fuk.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                next.ec(false);
            }
        }
        this.fuk.clear();
        if (this.fum != null) {
            this.fum.qj(0);
        }
    }

    public void reset() {
        G(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.fum = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0409a {
        private static a fuo = new a();
    }

    public AntiData biZ() {
        return this.cuS;
    }

    public void b(AntiData antiData) {
        this.cuS = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bja() {
        return this.fun;
    }

    public void jA(boolean z) {
        this.fun = z;
    }

    public void ck(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.fuk)) {
            Iterator<bh> it = this.fuk.iterator();
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
            if (this.fum != null) {
                this.fum.qj(this.fuk.size());
            }
        }
    }

    public boolean bjb() {
        return this.cuS != null && this.cuS.isMultiDeleteEnable();
    }
}
