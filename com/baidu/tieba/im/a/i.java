package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.SettingsSyncMessage;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseOnlineMessage responseOnlineMessage = new ResponseOnlineMessage();
        responseOnlineMessage.setErrorInfo(qVar);
        linkedList.add(responseOnlineMessage);
        if (cVar != null && !responseOnlineMessage.hasError()) {
            com.baidu.tieba.im.codec.a.c e = cVar.e("userInfo");
            if (e != null) {
                SettingsSyncMessage settingsSyncMessage = new SettingsSyncMessage();
                if (e != null) {
                    settingsSyncMessage.setPortrait(e.a("portrait"));
                }
                linkedList.add(settingsSyncMessage);
            }
            responseOnlineMessage.setGroupInfos(new ArrayList());
            com.baidu.tieba.im.codec.a.a d = cVar.d("groupInfo");
            if (d != null) {
                for (int i2 = 0; i2 < d.a(); i2++) {
                    com.baidu.tieba.im.codec.a.c a2 = d.a(i2);
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
