package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private boolean bkA;
    private boolean bkB;
    private boolean bkC;
    private boolean bkD;
    private GroupActivityData bkE;
    private GroupData bkv;
    private List<MemberData> bkw;
    private List<PhotoUrlData> bkx;
    private int bky;
    private int bkz;
    private boolean isMemGroup;

    public GroupActivityData Sq() {
        return this.bkE;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bkE = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bkv;
    }

    public void setGroup(GroupData groupData) {
        this.bkv = groupData;
    }

    public List<MemberData> Sr() {
        return this.bkw;
    }

    public void aF(List<MemberData> list) {
        this.bkw = list;
    }

    public List<PhotoUrlData> Ss() {
        return this.bkx;
    }

    public void aG(List<PhotoUrlData> list) {
        this.bkx = list;
    }

    public int St() {
        return this.bky;
    }

    public void ga(int i) {
        this.bky = i;
    }

    public int Su() {
        return this.bkz;
    }

    public void gb(int i) {
        this.bkz = i;
    }

    public boolean Sv() {
        return this.bkA;
    }

    public void cR(boolean z) {
        this.bkA = z;
    }

    public boolean Sw() {
        return this.bkB;
    }

    public void cS(boolean z) {
        this.bkB = z;
    }

    public boolean Sx() {
        return this.bkC;
    }

    public void cT(boolean z) {
        this.bkC = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean Sy() {
        return this.bkD;
    }

    public void cU(boolean z) {
        this.bkD = z;
    }
}
