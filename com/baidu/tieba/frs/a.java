package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private AntiData aBW;
    private final ArrayList<bc> diG;
    private boolean diH;
    private b diI;
    private String forumId;

    /* loaded from: classes.dex */
    public interface b {
        void ate();

        void kd(int i);

        void t(boolean z, boolean z2);
    }

    private a() {
        this.diH = false;
        this.diG = new ArrayList<>();
    }

    public static a asZ() {
        return C0151a.diJ;
    }

    public boolean ata() {
        return this.diH;
    }

    public void s(boolean z, boolean z2) {
        this.diH = z;
        if (this.diI != null) {
            this.diI.t(this.diH, z2);
        }
    }

    public boolean S(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        if (this.diG.size() > 29) {
            if (this.diI != null) {
                this.diI.ate();
                return false;
            }
            return false;
        }
        this.diG.add(bcVar);
        if (this.diI != null) {
            this.diI.kd(this.diG.size());
        }
        return true;
    }

    public List<bc> atb() {
        return this.diG;
    }

    public void T(bc bcVar) {
        this.diG.remove(bcVar);
        if (this.diI != null) {
            this.diI.kd(this.diG.size());
        }
    }

    public void clearData() {
        Iterator<bc> it = this.diG.iterator();
        while (it.hasNext()) {
            bc next = it.next();
            if (next != null) {
                next.av(false);
            }
        }
        this.diG.clear();
        if (this.diI != null) {
            this.diI.kd(0);
        }
    }

    public void reset() {
        s(false, false);
        clearData();
    }

    public void a(b bVar) {
        this.diI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0151a {
        private static a diJ = new a();
    }

    public AntiData Cm() {
        return this.aBW;
    }

    public void b(AntiData antiData) {
        this.aBW = antiData;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void bl(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.A(list) && !com.baidu.tbadk.core.util.w.A(this.diG)) {
            Iterator<bc> it = this.diG.iterator();
            while (it.hasNext()) {
                bc next = it.next();
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
            if (this.diI != null) {
                this.diI.kd(this.diG.size());
            }
        }
    }

    public boolean atc() {
        return this.aBW != null && this.aBW.isMultiDeleteEnable();
    }
}
