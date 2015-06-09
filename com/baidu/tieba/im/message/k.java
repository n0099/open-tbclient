package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private GroupActivityData bnA;
    private GroupData bnr;
    private List<MemberData> bns;
    private List<PhotoUrlData> bnt;
    private int bnu;
    private int bnv;
    private boolean bnw;
    private boolean bnx;
    private boolean bny;
    private boolean bnz;
    private boolean isMemGroup;

    public GroupActivityData TR() {
        return this.bnA;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bnA = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bnr;
    }

    public void setGroup(GroupData groupData) {
        this.bnr = groupData;
    }

    public List<MemberData> TS() {
        return this.bns;
    }

    public void aG(List<MemberData> list) {
        this.bns = list;
    }

    public List<PhotoUrlData> TT() {
        return this.bnt;
    }

    public void aH(List<PhotoUrlData> list) {
        this.bnt = list;
    }

    public int TU() {
        return this.bnu;
    }

    public void gt(int i) {
        this.bnu = i;
    }

    public int TV() {
        return this.bnv;
    }

    public void gu(int i) {
        this.bnv = i;
    }

    public boolean TW() {
        return this.bnw;
    }

    public void da(boolean z) {
        this.bnw = z;
    }

    public boolean TX() {
        return this.bnx;
    }

    public void db(boolean z) {
        this.bnx = z;
    }

    public boolean TY() {
        return this.bny;
    }

    public void dc(boolean z) {
        this.bny = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean TZ() {
        return this.bnz;
    }

    public void dd(boolean z) {
        this.bnz = z;
    }
}
