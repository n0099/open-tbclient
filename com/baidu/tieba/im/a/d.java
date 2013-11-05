package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseGroupLevelMessage responseGroupLevelMessage = new ResponseGroupLevelMessage(103006);
        responseGroupLevelMessage.setErrorInfo(qVar);
        responseGroupLevelMessage.setCmd(i);
        linkedList.add(responseGroupLevelMessage);
        if (cVar != null && !responseGroupLevelMessage.hasError()) {
            GroupLevelInfo groupLevelInfo = new GroupLevelInfo();
            com.baidu.tieba.im.codec.a.c e = cVar.e("groupInfo");
            groupLevelInfo.setGroupId(e.c("groupId"));
            groupLevelInfo.setName(e.a(SocialConstants.PARAM_MEDIA_UNAME));
            groupLevelInfo.setGrade(e.b("grade"));
            groupLevelInfo.setActiveDay(e.b("activeDay"));
            com.baidu.tieba.im.codec.a.a d = cVar.d("gradeInfos");
            int a2 = d.a();
            ArrayList arrayList = new ArrayList();
            groupLevelInfo.setLevelInfos(arrayList);
            for (int i2 = 0; i2 < a2; i2++) {
                com.baidu.tieba.im.codec.a.c a3 = d.a(i2);
                GroupLevelInfo.LevelInfo levelInfo = new GroupLevelInfo.LevelInfo();
                levelInfo.setGrade(a3.b("grade"));
                levelInfo.setIntro(a3.a("intro"));
                levelInfo.setThresholdDay(a3.b("thresholdDay"));
                levelInfo.setMaxMemberNum(a3.b("maxMemberNum"));
                arrayList.add(levelInfo);
            }
            responseGroupLevelMessage.setGroupLevelInfo(groupLevelInfo);
        }
    }
}
