package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private GroupData bnq;
    private List<MemberData> bnr;
    private List<PhotoUrlData> bns;
    private int bnt;
    private int bnu;
    private boolean bnv;
    private boolean bnw;
    private boolean bnx;
    private boolean bny;
    private GroupActivityData bnz;
    private boolean isMemGroup;

    public GroupActivityData TQ() {
        return this.bnz;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bnz = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bnq;
    }

    public void setGroup(GroupData groupData) {
        this.bnq = groupData;
    }

    public List<MemberData> TR() {
        return this.bnr;
    }

    public void aG(List<MemberData> list) {
        this.bnr = list;
    }

    public List<PhotoUrlData> TS() {
        return this.bns;
    }

    public void aH(List<PhotoUrlData> list) {
        this.bns = list;
    }

    public int TT() {
        return this.bnt;
    }

    public void gt(int i) {
        this.bnt = i;
    }

    public int TU() {
        return this.bnu;
    }

    public void gu(int i) {
        this.bnu = i;
    }

    public boolean TV() {
        return this.bnv;
    }

    public void da(boolean z) {
        this.bnv = z;
    }

    public boolean TW() {
        return this.bnw;
    }

    public void db(boolean z) {
        this.bnw = z;
    }

    public boolean TX() {
        return this.bnx;
    }

    public void dc(boolean z) {
        this.bnx = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean TY() {
        return this.bny;
    }

    public void dd(boolean z) {
        this.bny = z;
    }
}
