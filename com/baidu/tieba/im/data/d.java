package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends c implements at {
    private boolean aUP;
    private boolean aUQ;
    private boolean aUR;
    private int authorId;
    private String authorName;
    private String business;
    private int distance;
    private String forumId;
    private int grade;
    private String groupId;
    private String intro;
    private boolean isMemGroup;
    private String lat;
    private String lng;
    private int maxMemberNum;
    private int memberNum;
    private String name;
    private String portrait;
    private String position;

    public d() {
        setType(1);
    }

    public boolean Mj() {
        return this.aUP;
    }

    public void cS(boolean z) {
        this.aUP = z;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public void setMaxMemberNum(int i) {
        this.maxMemberNum = i;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public void setAuthorId(int i) {
        this.authorId = i;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public int Mk() {
        return this.distance;
    }

    public void fv(int i) {
        this.distance = i;
    }

    public boolean Ml() {
        return this.aUQ;
    }

    public void cT(boolean z) {
        this.aUQ = z;
    }

    public boolean Mm() {
        return this.aUR;
    }

    public void cU(boolean z) {
        this.aUR = z;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<as> getImages() {
        ArrayList<as> arrayList = new ArrayList<>();
        as asVar = new as();
        asVar.AI = this.portrait;
        asVar.ER = 10;
        arrayList.add(asVar);
        return arrayList;
    }
}
