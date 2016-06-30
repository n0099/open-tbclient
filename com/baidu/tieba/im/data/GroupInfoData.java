package com.baidu.tieba.im.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GroupInfoData extends com.baidu.tbadk.core.util.a implements v, al, Serializable {
    public static final BdUniqueId TYPE_FRS_GROUP = BdUniqueId.gen();
    private static final long serialVersionUID = 5616188082014345808L;
    private long authorId;
    private int authorIsMeizhi;
    private String authorName;
    private int forumId;
    private String forumName;
    private String forumShowName;
    private int from;
    private int grade;
    private int groupId;
    private String intro;
    private int isGroupManager;
    private boolean isMemGroup;
    private int maxMemberNum;
    private int memberNum;
    private String name;
    private String portrait;

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public int getIsGroupManager() {
        return this.isGroupManager;
    }

    public void setIsGroupManager(int i) {
        this.isGroupManager = i;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return TextUtils.isEmpty(this.intro) ? "" : this.intro;
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

    public long getAuthorId() {
        return this.authorId;
    }

    public int getAuthorIsMeizhi() {
        return this.authorIsMeizhi;
    }

    public boolean autorIsMeizhi() {
        return this.authorIsMeizhi == 1;
    }

    public void setAuthorIsMeizhi(int i) {
        this.authorIsMeizhi = i;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getForumShowName() {
        return this.forumShowName;
    }

    public void setForumShowName(String str) {
        this.forumShowName = str;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.portrait);
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<ak> getImages() {
        ArrayList<ak> arrayList = new ArrayList<>();
        ak akVar = new ak();
        akVar.imgUrl = this.portrait;
        akVar.Xu = 10;
        arrayList.add(akVar);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE_FRS_GROUP;
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
