package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private GroupData bjk;
    private List<MemberData> bjl;
    private List<PhotoUrlData> bjm;
    private int bjn;
    private int bjo;
    private boolean bjp;
    private boolean bjq;
    private boolean bjr;
    private boolean bjs;
    private GroupActivityData bjt;
    private boolean isMemGroup;

    public GroupActivityData QW() {
        return this.bjt;
    }

    public void a(GroupActivityData groupActivityData) {
        this.bjt = groupActivityData;
    }

    public GroupData getGroup() {
        return this.bjk;
    }

    public void setGroup(GroupData groupData) {
        this.bjk = groupData;
    }

    public List<MemberData> QX() {
        return this.bjl;
    }

    public void ay(List<MemberData> list) {
        this.bjl = list;
    }

    public List<PhotoUrlData> QY() {
        return this.bjm;
    }

    public void az(List<PhotoUrlData> list) {
        this.bjm = list;
    }

    public int QZ() {
        return this.bjn;
    }

    public void gl(int i) {
        this.bjn = i;
    }

    public int Ra() {
        return this.bjo;
    }

    public void gm(int i) {
        this.bjo = i;
    }

    public boolean Rb() {
        return this.bjp;
    }

    public void dd(boolean z) {
        this.bjp = z;
    }

    public boolean Rc() {
        return this.bjq;
    }

    public void de(boolean z) {
        this.bjq = z;
    }

    public boolean Rd() {
        return this.bjr;
    }

    public void df(boolean z) {
        this.bjr = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean Re() {
        return this.bjs;
    }

    public void dg(boolean z) {
        this.bjs = z;
    }
}
