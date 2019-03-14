package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GradeInfo;
import protobuf.QueryGroupGrade.QueryGroupGradeResIdl;
/* loaded from: classes5.dex */
public class ResponseGroupLevelMessage extends SocketResponsedMessage {
    private GroupLevelInfo groupLevelInfo;

    public ResponseGroupLevelMessage() {
        super(103006);
    }

    public ResponseGroupLevelMessage(int i) {
        super(i);
    }

    public GroupLevelInfo getGroupLevelInfo() {
        return this.groupLevelInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryGroupGradeResIdl queryGroupGradeResIdl = (QueryGroupGradeResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupGradeResIdl.class);
        setError(queryGroupGradeResIdl.error.errorno.intValue());
        setErrorString(queryGroupGradeResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupLevelInfo = new GroupLevelInfo();
            getGroupLevelInfo().setGroupId(queryGroupGradeResIdl.data.groupInfo.groupId.longValue());
            getGroupLevelInfo().setName(queryGroupGradeResIdl.data.groupInfo.name);
            getGroupLevelInfo().setGrade(queryGroupGradeResIdl.data.groupInfo.grade.intValue());
            getGroupLevelInfo().setActiveDay(queryGroupGradeResIdl.data.groupInfo.activeDay.intValue());
            getGroupLevelInfo().setLevelInfos(new ArrayList());
            getGroupLevelInfo().setVipLevelInfos(new ArrayList());
            getGroupLevelInfo().setMemGroup(queryGroupGradeResIdl.data.groupInfo.isMemberGroup.intValue() == 1);
            getGroupLevelInfo().setGroupAuthor(queryGroupGradeResIdl.data.memberPerm.isAuthor.intValue() == 1);
            getGroupLevelInfo().setCanCreateMember(queryGroupGradeResIdl.data.memberPerm.canCreateMember.intValue() == 1);
            getGroupLevelInfo().setAlreadyCreateMemGroup(queryGroupGradeResIdl.data.memberPerm.alreadyCreateNum.intValue());
            getGroupLevelInfo().setLeftCreateMemGroup(queryGroupGradeResIdl.data.memberPerm.leftCreateNum.intValue());
            List<GradeInfo> list = queryGroupGradeResIdl.data.gradeInfos;
            if (list != null) {
                for (GradeInfo gradeInfo : list) {
                    GroupLevelInfo.LevelInfo levelInfo = new GroupLevelInfo.LevelInfo();
                    getGroupLevelInfo().getLevelInfos().add(levelInfo);
                    levelInfo.setGrade(gradeInfo.grade.intValue());
                    levelInfo.setIntro(gradeInfo.intro);
                    levelInfo.setThresholdDay(gradeInfo.thresholdDay.intValue());
                    levelInfo.setMaxMemberNum(gradeInfo.maxMemberNum.intValue());
                }
            }
            if (queryGroupGradeResIdl.data.memberGradeInfos != null) {
                for (GradeInfo gradeInfo2 : queryGroupGradeResIdl.data.memberGradeInfos) {
                    GroupLevelInfo.LevelInfo levelInfo2 = new GroupLevelInfo.LevelInfo();
                    getGroupLevelInfo().getVipLevelInfos().add(levelInfo2);
                    levelInfo2.setGrade(gradeInfo2.grade.intValue());
                    levelInfo2.setIntro(gradeInfo2.intro);
                    levelInfo2.setThresholdDay(gradeInfo2.thresholdDay.intValue());
                    levelInfo2.setMaxMemberNum(gradeInfo2.maxMemberNum.intValue());
                }
            }
        }
    }
}
