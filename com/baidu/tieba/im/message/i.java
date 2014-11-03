package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private int beA;
    private int beB;
    private boolean beC;
    private boolean beD;
    private boolean beE;
    private boolean beF;
    private GroupActivityData beG;
    private GroupData bex;
    private List<MemberData> bey;
    private List<PhotoUrlData> bez;
    private boolean isMemGroup;

    public GroupActivityData Qa() {
        return this.beG;
    }

    public void a(GroupActivityData groupActivityData) {
        this.beG = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bex;
    }

    public void setGroup(GroupData groupData) {
        this.bex = groupData;
    }

    public List<MemberData> Qb() {
        return this.bey;
    }

    public void Y(List<MemberData> list) {
        this.bey = list;
    }

    public List<PhotoUrlData> Qc() {
        return this.bez;
    }

    public void Z(List<PhotoUrlData> list) {
        this.bez = list;
    }

    public int Qd() {
        return this.beA;
    }

    public void fV(int i) {
        this.beA = i;
    }

    public int Qe() {
        return this.beB;
    }

    public void fW(int i) {
        this.beB = i;
    }

    public boolean Qf() {
        return this.beC;
    }

    public void dj(boolean z) {
        this.beC = z;
    }

    public boolean Qg() {
        return this.beD;
    }

    public void dk(boolean z) {
        this.beD = z;
    }

    public boolean Qh() {
        return this.beE;
    }

    public void dl(boolean z) {
        this.beE = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean Qi() {
        return this.beF;
    }

    public void dm(boolean z) {
        this.beF = z;
    }
}
