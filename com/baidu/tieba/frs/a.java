package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData cfT;
    private String forumId;
    private final ArrayList<bg> fsL;
    private boolean fsM;
    private b fsN;
    private boolean fsO;

    /* loaded from: classes.dex */
    public interface b {
        void E(boolean z, boolean z2);

        void blf();

        void rl(int i);
    }

    private a() {
        this.fsM = false;
        this.fsL = new ArrayList<>();
    }

    public static a bkY() {
        return C0309a.fsP;
    }

    public boolean bkZ() {
        return this.fsM;
    }

    public void D(boolean z, boolean z2) {
        this.fsM = z;
        if (this.fsN != null) {
            this.fsN.E(this.fsM, z2);
        }
    }

    public boolean Z(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (this.fsL.size() > 29) {
            if (this.fsN != null) {
                this.fsN.blf();
                return false;
            }
            return false;
        }
        this.fsL.add(bgVar);
        if (this.fsN != null) {
            this.fsN.rl(this.fsL.size());
        }
        return true;
    }

    public List<bg> bla() {
        return this.fsL;
    }

    public void aa(bg bgVar) {
        this.fsL.remove(bgVar);
        if (this.fsN != null) {
            this.fsN.rl(this.fsL.size());
        }
    }

    public void clearData() {
        Iterator<bg> it = this.fsL.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                next.dM(false);
            }
        }
        this.fsL.clear();
        if (this.fsN != null) {
            this.fsN.rl(0);
        }
    }

    public void reset() {
        D(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.fsN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0309a {
        private static a fsP = new a();
    }

    public AntiData blb() {
        return this.cfT;
    }

    public void b(AntiData antiData) {
        this.cfT = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean blc() {
        return this.fsO;
    }

    public void jJ(boolean z) {
        this.fsO = z;
    }

    public void bX(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list) && !com.baidu.tbadk.core.util.v.aa(this.fsL)) {
            Iterator<bg> it = this.fsL.iterator();
            while (it.hasNext()) {
                bg next = it.next();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    } else if (!com.baidu.tbadk.core.util.aq.bV(list.get(i2), next.getId())) {
                        i = i2 + 1;
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
            if (this.fsN != null) {
                this.fsN.rl(this.fsL.size());
            }
        }
    }

    public boolean bld() {
        return this.cfT != null && this.cfT.isMultiDeleteEnable();
    }
}
