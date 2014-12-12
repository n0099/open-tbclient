package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private GroupData bhQ;
    private List<MemberData> bhR;
    private List<PhotoUrlData> bhS;
    private int bhT;
    private int bhU;
    private boolean bhV;
    private boolean bhW;
    private boolean bhX;
    private boolean bhY;
    private GroupActivityData bhZ;
    private boolean isMemGroup;

    public GroupActivityData QF() {
        return this.bhZ;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bhZ = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bhQ;
    }

    public void setGroup(GroupData groupData) {
        this.bhQ = groupData;
    }

    public List<MemberData> QG() {
        return this.bhR;
    }

    public void av(List<MemberData> list) {
        this.bhR = list;
    }

    public List<PhotoUrlData> QH() {
        return this.bhS;
    }

    public void aw(List<PhotoUrlData> list) {
        this.bhS = list;
    }

    public int QI() {
        return this.bhT;
    }

    public void ge(int i) {
        this.bhT = i;
    }

    public int QJ() {
        return this.bhU;
    }

    public void gf(int i) {
        this.bhU = i;
    }

    public boolean QK() {
        return this.bhV;
    }

    public void cY(boolean z) {
        this.bhV = z;
    }

    public boolean QL() {
        return this.bhW;
    }

    public void cZ(boolean z) {
        this.bhW = z;
    }

    public boolean QM() {
        return this.bhX;
    }

    public void da(boolean z) {
        this.bhX = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean QN() {
        return this.bhY;
    }

    public void db(boolean z) {
        this.bhY = z;
    }
}
