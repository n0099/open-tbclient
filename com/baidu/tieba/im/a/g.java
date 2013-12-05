package com.baidu.tieba.im.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseNearbyGroupsMessage responseNearbyGroupsMessage = new ResponseNearbyGroupsMessage(103009);
        responseNearbyGroupsMessage.setErrorInfo(qVar);
        responseNearbyGroupsMessage.setCmd(i);
        linkedList.add(responseNearbyGroupsMessage);
        if (dVar != null && !responseNearbyGroupsMessage.hasError()) {
            NearbyGroupsData nearbyGroupsData = new NearbyGroupsData();
            com.baidu.tieba.im.b.a.c d = dVar.d("groups");
            nearbyGroupsData.setGeo(dVar.b("geo"));
            nearbyGroupsData.setOffset(dVar.b("offset"));
            nearbyGroupsData.setHasMore(dVar.b("hasMore") == 1);
            for (int i2 = 0; i2 < d.a(); i2++) {
                String a2 = d.a(i2);
                com.baidu.tieba.im.data.c cVar = new com.baidu.tieba.im.data.c();
                cVar.a(a2);
                nearbyGroupsData.add(cVar);
                com.baidu.tieba.im.b.a.a b = d.b(i2);
                int a3 = b.a();
                for (int i3 = 0; i3 < a3; i3++) {
                    com.baidu.tieba.im.b.a.d a4 = b.a(i3);
                    com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                    eVar.f(a4.a("authorId"));
                    eVar.g(a4.a("authorName"));
                    eVar.i(a4.a("business"));
                    eVar.e(a4.b("distance"));
                    eVar.b(a4.a("forumId"));
                    eVar.d(a4.b("grade"));
                    eVar.a(a4.a("groupId"));
                    eVar.d(a4.a("intro"));
                    eVar.k(a4.a("lat"));
                    eVar.j(a4.a("lng"));
                    eVar.b(a4.b("maxMemberNum"));
                    eVar.c(a4.b("memberNum"));
                    eVar.c(a4.a(SocialConstants.PARAM_MEDIA_UNAME));
                    eVar.e(a4.a("portrait"));
                    eVar.h(a4.a("position"));
                    eVar.a(a4.b("authorIsMeizhi") == 1);
                    nearbyGroupsData.add(eVar);
                }
            }
            responseNearbyGroupsMessage.setNearbyGroups(nearbyGroupsData);
        }
    }
}
