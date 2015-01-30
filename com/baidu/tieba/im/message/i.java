package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private GroupData bjl;
    private List<MemberData> bjm;
    private List<PhotoUrlData> bjn;
    private int bjo;
    private int bjp;
    private boolean bjq;
    private boolean bjr;
    private boolean bjs;
    private boolean bjt;
    private GroupActivityData bju;
    private boolean isMemGroup;

    public GroupActivityData Rb() {
        return this.bju;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bju = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bjl;
    }

    public void setGroup(GroupData groupData) {
        this.bjl = groupData;
    }

    public List<MemberData> Rc() {
        return this.bjm;
    }

    public void ay(List<MemberData> list) {
        this.bjm = list;
    }

    public List<PhotoUrlData> Rd() {
        return this.bjn;
    }

    public void az(List<PhotoUrlData> list) {
        this.bjn = list;
    }

    public int Re() {
        return this.bjo;
    }

    public void gl(int i) {
        this.bjo = i;
    }

    public int Rf() {
        return this.bjp;
    }

    public void gm(int i) {
        this.bjp = i;
    }

    public boolean Rg() {
        return this.bjq;
    }

    public void dd(boolean z) {
        this.bjq = z;
    }

    public boolean Rh() {
        return this.bjr;
    }

    public void de(boolean z) {
        this.bjr = z;
    }

    public boolean Ri() {
        return this.bjs;
    }

    public void df(boolean z) {
        this.bjs = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean Rj() {
        return this.bjt;
    }

    public void dg(boolean z) {
        this.bjt = z;
    }
}
