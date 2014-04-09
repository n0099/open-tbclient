package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupLevelInfo;
import java.util.ArrayList;
import protobuf.Im;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public class ResponseGroupLevelMessage extends SocketResponsedMessage {
    private GroupLevelInfo a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupGradeRes.QueryGroupGradeResIdl parseFrom = QueryGroupGradeRes.QueryGroupGradeResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
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

    public ResponseGroupLevelMessage() {
        super(103006);
    }

    public ResponseGroupLevelMessage(int i) {
        super(i);
    }

    public final GroupLevelInfo d() {
        return this.a;
    }
}
