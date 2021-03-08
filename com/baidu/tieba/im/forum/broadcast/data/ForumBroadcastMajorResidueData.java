package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes7.dex */
public class ForumBroadcastMajorResidueData extends OrmObject {
    private int kHZ;
    private int kIa;
    private int kIb;

    public int cWq() {
        return this.kHZ;
    }

    public void CY(int i) {
        this.kHZ = i;
    }

    public int cWr() {
        return this.kIa;
    }

    public void CZ(int i) {
        this.kIa = i;
    }

    public void Da(int i) {
        this.kIb = i;
    }
}
