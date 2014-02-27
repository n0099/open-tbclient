package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupLevelInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import protobuf.Im;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public class cb extends da implements com.baidu.tieba.im.coder.f {
    private GroupLevelInfo a;

    public cb() {
        super(103006);
    }

    public final GroupLevelInfo a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupGradeRes.QueryGroupGradeResIdl parseFrom = QueryGroupGradeRes.QueryGroupGradeResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = new GroupLevelInfo();
            this.a.setGroupId(parseFrom.getData().getGroupInfo().getGroupId());
            this.a.setName(parseFrom.getData().getGroupInfo().getName());
            this.a.setGrade(parseFrom.getData().getGroupInfo().getGrade());
            this.a.setActiveDay(parseFrom.getData().getGroupInfo().getActiveDay());
            this.a.setLevelInfos(new ArrayList());
            this.a.setVipLevelInfos(new ArrayList());
            this.a.setMemGroup(parseFrom.getData().getGroupInfo().getIsMemberGroup() == 1);
            this.a.setGroupAuthor(parseFrom.getData().getMemberPerm().getIsAuthor() == 1);
            this.a.setCanCreateMember(parseFrom.getData().getMemberPerm().getCanCreateMember() == 1);
            this.a.setAlreadyCreateMemGroup(parseFrom.getData().getMemberPerm().getAlreadyCreateNum());
            this.a.setLeftCreateMemGroup(parseFrom.getData().getMemberPerm().getLeftCreateNum());
            int gradeInfosCount = parseFrom.getData().getGradeInfosCount();
            for (int i2 = 0; i2 < gradeInfosCount; i2++) {
                GroupLevelInfo.LevelInfo levelInfo = new GroupLevelInfo.LevelInfo();
                this.a.getLevelInfos().add(levelInfo);
                Im.GradeInfo gradeInfos = parseFrom.getData().getGradeInfos(i2);
                levelInfo.setGrade(gradeInfos.getGrade());
                levelInfo.setIntro(gradeInfos.getIntro());
                levelInfo.setThresholdDay(gradeInfos.getThresholdDay());
                levelInfo.setMaxMemberNum(gradeInfos.getMaxMemberNum());
            }
            int memberGradeInfosCount = parseFrom.getData().getMemberGradeInfosCount();
            for (int i3 = 0; i3 < memberGradeInfosCount; i3++) {
                GroupLevelInfo.LevelInfo levelInfo2 = new GroupLevelInfo.LevelInfo();
                this.a.getVipLevelInfos().add(levelInfo2);
                Im.GradeInfo memberGradeInfos = parseFrom.getData().getMemberGradeInfos(i3);
                levelInfo2.setGrade(memberGradeInfos.getGrade());
                levelInfo2.setIntro(memberGradeInfos.getIntro());
                levelInfo2.setThresholdDay(memberGradeInfos.getThresholdDay());
                levelInfo2.setMaxMemberNum(memberGradeInfos.getMaxMemberNum());
            }
        }
    }
}
