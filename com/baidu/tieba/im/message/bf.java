package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupLevelInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import protobuf.Im;
import protobuf.QueryGroupGrade.QueryGroupGradeRes;
/* loaded from: classes.dex */
public class bf extends bz implements com.baidu.tieba.im.coder.f {
    private GroupLevelInfo a;

    public bf() {
        super(103006);
    }

    public GroupLevelInfo a() {
        return this.a;
    }

    public void a(GroupLevelInfo groupLevelInfo) {
        this.a = groupLevelInfo;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        QueryGroupGradeRes.QueryGroupGradeResIdl parseFrom = QueryGroupGradeRes.QueryGroupGradeResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            a(new GroupLevelInfo());
            a().setGroupId(parseFrom.getData().getGroupInfo().getGroupId());
            a().setName(parseFrom.getData().getGroupInfo().getName());
            a().setGrade(parseFrom.getData().getGroupInfo().getGrade());
            a().setActiveDay(parseFrom.getData().getGroupInfo().getActiveDay());
            a().setLevelInfos(new ArrayList());
            int gradeInfosCount = parseFrom.getData().getGradeInfosCount();
            for (int i2 = 0; i2 < gradeInfosCount; i2++) {
                GroupLevelInfo.LevelInfo levelInfo = new GroupLevelInfo.LevelInfo();
                a().getLevelInfos().add(levelInfo);
                Im.GradeInfo gradeInfos = parseFrom.getData().getGradeInfos(i2);
                levelInfo.setGrade(gradeInfos.getGrade());
                levelInfo.setIntro(gradeInfos.getIntro());
                levelInfo.setThresholdDay(gradeInfos.getThresholdDay());
                levelInfo.setMaxMemberNum(gradeInfos.getMaxMemberNum());
            }
        }
    }
}
