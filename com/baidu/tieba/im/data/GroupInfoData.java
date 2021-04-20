package com.baidu.tieba.im.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import d.b.c.j.e.n;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GroupInfoData extends AbstractImageProvider implements n, Serializable, PreLoadImageProvider {
    public static final BdUniqueId TYPE_FRS_GROUP = BdUniqueId.gen();
    public static final int TYPE_USER_MEIZHI_TRUE = 1;
    public static final long serialVersionUID = 5616188082014345808L;
    public long authorId;
    public int authorIsMeizhi;
    public String authorName;
    public int forumId;
    public String forumName;
    public String forumShowName;
    public int from;
    public int grade;
    public long groupId;
    public String intro;
    public int isGroupManager;
    public boolean isMemGroup;
    public int maxMemberNum;
    public int memberNum;
    public String name;
    public String portrait;

    public boolean autorIsMeizhi() {
        return this.authorIsMeizhi == 1;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public int getAuthorIsMeizhi() {
        return this.authorIsMeizhi;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getForumShowName() {
        return this.forumShowName;
    }

    public int getFrom() {
        return this.from;
    }

    public int getGrade() {
        return this.grade;
    }

    public long getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.portrait);
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.portrait;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }

    public String getIntro() {
        return TextUtils.isEmpty(this.intro) ? "" : this.intro;
    }

    public int getIsGroupManager() {
        return this.isGroupManager;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getName() {
        return this.name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return TYPE_FRS_GROUP;
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public void setAuthorIsMeizhi(int i) {
        this.authorIsMeizhi = i;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumShowName(String str) {
        this.forumShowName = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsGroupManager(int i) {
        this.isGroupManager = i;
    }

    public void setMaxMemberNum(int i) {
        this.maxMemberNum = i;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }
}
