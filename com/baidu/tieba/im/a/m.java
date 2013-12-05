package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.SettingsSyncMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseOnlineMessage responseOnlineMessage = new ResponseOnlineMessage();
        responseOnlineMessage.setErrorInfo(qVar);
        linkedList.add(responseOnlineMessage);
        if (dVar != null && !responseOnlineMessage.hasError()) {
            com.baidu.tieba.im.b.a.d f = dVar.f("userInfo");
            if (f != null) {
                SettingsSyncMessage settingsSyncMessage = new SettingsSyncMessage();
                if (f != null) {
                    settingsSyncMessage.setPortrait(f.a("portrait"));
                }
                linkedList.add(settingsSyncMessage);
            }
            responseOnlineMessage.setGroupInfos(new ArrayList());
            com.baidu.tieba.im.b.a.a e = dVar.e("groupInfo");
            if (e != null) {
                for (int i2 = 0; i2 < e.a(); i2++) {
                    com.baidu.tieba.im.b.a.d a2 = e.a(i2);
                    GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
                    groupUpdateMessage.setGroupId(a2.b("groupId"));
                    groupUpdateMessage.setGroupType(a2.b("groupType"));
                    groupUpdateMessage.setLastMsgId(a2.c("lastMsgId"));
                    groupUpdateMessage.setName(a2.a(SocialConstants.PARAM_MEDIA_UNAME));
                    groupUpdateMessage.setPortrait(a2.a("portrait"));
                    groupUpdateMessage.setGrade(a2.b("grade"));
                    groupUpdateMessage.setAuthorId(a2.a("authorId"));
                    groupUpdateMessage.setAuthorName(a2.a("authorName"));
                    groupUpdateMessage.setForumId(a2.a("forumId"));
                    responseOnlineMessage.getGroupInfos().add(groupUpdateMessage);
                }
            }
        }
    }
}
