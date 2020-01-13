package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData dhW;
    private String forumId;
    private final ArrayList<bj> glb;
    private boolean glc;
    private b gld;
    private boolean gle;

    /* loaded from: classes.dex */
    public interface b {
        void H(boolean z, boolean z2);

        void bBy();

        void st(int i);
    }

    private a() {
        this.glc = false;
        this.glb = new ArrayList<>();
    }

    public static a bBr() {
        return C0496a.glf;
    }

    public boolean bBs() {
        return this.glc;
    }

    public void G(boolean z, boolean z2) {
        this.glc = z;
        if (this.gld != null) {
            this.gld.H(this.glc, z2);
        }
    }

    public boolean ag(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        if (this.glb.size() > 29) {
            if (this.gld != null) {
                this.gld.bBy();
                return false;
            }
            return false;
        }
        this.glb.add(bjVar);
        if (this.gld != null) {
            this.gld.st(this.glb.size());
        }
        return true;
    }

    public List<bj> bBt() {
        return this.glb;
    }

    public void ah(bj bjVar) {
        this.glb.remove(bjVar);
        if (this.gld != null) {
            this.gld.st(this.glb.size());
        }
    }

    public void clearData() {
        Iterator<bj> it = this.glb.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                next.fv(false);
            }
        }
        this.glb.clear();
        if (this.gld != null) {
            this.gld.st(0);
        }
    }

    public void reset() {
        G(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.gld = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0496a {
        private static a glf = new a();
    }

    public AntiData bBu() {
        return this.dhW;
    }

    public void b(AntiData antiData) {
        this.dhW = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean bBv() {
        return this.gle;
    }

    public void kX(boolean z) {
        this.gle = z;
    }

    public void cg(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list) && !com.baidu.tbadk.core.util.v.isEmpty(this.glb)) {
            Iterator<bj> it = this.glb.iterator();
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
            if (this.gld != null) {
                this.gld.st(this.glb.size());
            }
        }
    }

    public boolean bBw() {
        return this.dhW != null && this.dhW.isMultiDeleteEnable();
    }
}
