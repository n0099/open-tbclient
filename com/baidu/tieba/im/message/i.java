package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private GroupData bej;
    private List<MemberData> bek;
    private List<PhotoUrlData> bel;
    private int bem;
    private int ben;
    private boolean beo;
    private boolean bep;
    private boolean beq;
    private boolean ber;
    private GroupActivityData bes;
    private boolean isMemGroup;

    public GroupActivityData PX() {
        return this.bes;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bes = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bej;
    }

    public void setGroup(GroupData groupData) {
        this.bej = groupData;
    }

    public List<MemberData> PY() {
        return this.bek;
    }

    public void Y(List<MemberData> list) {
        this.bek = list;
    }

    public List<PhotoUrlData> PZ() {
        return this.bel;
    }

    public void Z(List<PhotoUrlData> list) {
        this.bel = list;
    }

    public int Qa() {
        return this.bem;
    }

    public void fV(int i) {
        this.bem = i;
    }

    public int Qb() {
        return this.ben;
    }

    public void fW(int i) {
        this.ben = i;
    }

    public boolean Qc() {
        return this.beo;
    }

    public void dj(boolean z) {
        this.beo = z;
    }

    public boolean Qd() {
        return this.bep;
    }

    public void dk(boolean z) {
        this.bep = z;
    }

    public boolean Qe() {
        return this.beq;
    }

    public void dl(boolean z) {
        this.beq = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean Qf() {
        return this.ber;
    }

    public void dm(boolean z) {
        this.ber = z;
    }
}
