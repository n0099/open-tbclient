package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private GroupData bkL;
    private List<MemberData> bkM;
    private List<PhotoUrlData> bkN;
    private int bkO;
    private int bkP;
    private boolean bkQ;
    private boolean bkR;
    private boolean bkS;
    private boolean bkT;
    private GroupActivityData bkU;
    private boolean isMemGroup;

    public GroupActivityData SD() {
        return this.bkU;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bkU = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bkL;
    }

    public void setGroup(GroupData groupData) {
        this.bkL = groupData;
    }

    public List<MemberData> SE() {
        return this.bkM;
    }

    public void aH(List<MemberData> list) {
        this.bkM = list;
    }

    public List<PhotoUrlData> SF() {
        return this.bkN;
    }

    public void aI(List<PhotoUrlData> list) {
        this.bkN = list;
    }

    public int SG() {
        return this.bkO;
    }

    public void gc(int i) {
        this.bkO = i;
    }

    public int SH() {
        return this.bkP;
    }

    public void gd(int i) {
        this.bkP = i;
    }

    public boolean SI() {
        return this.bkQ;
    }

    public void cP(boolean z) {
        this.bkQ = z;
    }

    public boolean SJ() {
        return this.bkR;
    }

    public void cQ(boolean z) {
        this.bkR = z;
    }

    public boolean SK() {
        return this.bkS;
    }

    public void cR(boolean z) {
        this.bkS = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean SL() {
        return this.bkT;
    }

    public void cS(boolean z) {
        this.bkT = z;
    }
}
