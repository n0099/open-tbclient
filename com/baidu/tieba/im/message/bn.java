package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public class bn extends cc implements com.baidu.tieba.im.coder.f {
    private NearbyGroupsData a;

    public bn() {
        e(103009);
    }

    public NearbyGroupsData a() {
        return this.a;
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        this.a = nearbyGroupsData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl parseFrom = QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            NearbyGroupsData nearbyGroupsData = new NearbyGroupsData();
            nearbyGroupsData.setGeo(parseFrom.getData().getGeo());
            nearbyGroupsData.setOffset(parseFrom.getData().getOffset());
            nearbyGroupsData.setHasMore(parseFrom.getData().getHasMore() == 1);
            List<QueryGroupsByLocationRes.Business> groupsList = parseFrom.getData().getGroupsList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < groupsList.size()) {
                    QueryGroupsByLocationRes.Business business = groupsList.get(i3);
                    com.baidu.tieba.im.data.f fVar = new com.baidu.tieba.im.data.f();
                    fVar.a(business.getBusiness());
                    nearbyGroupsData.add(fVar);
                    List<Im.GroupInfo> groupsList2 = business.getGroupsList();
                    int size = groupsList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        Im.GroupInfo groupInfo = groupsList2.get(i4);
                        com.baidu.tieba.im.data.h hVar = new com.baidu.tieba.im.data.h();
                        hVar.d(groupInfo.getAuthorId());
                        hVar.f(groupInfo.getAuthorName());
                        hVar.h(groupInfo.getBusiness());
                        hVar.f(groupInfo.getDistance());
                        hVar.b(String.valueOf(groupInfo.getForumId()));
                        hVar.e(groupInfo.getGrade());
                        hVar.a(String.valueOf(groupInfo.getGroupId()));
                        hVar.d(groupInfo.getIntro());
                        hVar.j(String.valueOf(groupInfo.getLat()));
                        hVar.i(String.valueOf(groupInfo.getLng()));
                        hVar.b(groupInfo.getMaxMemberNum());
                        hVar.c(groupInfo.getMemberNum());
                        hVar.c(groupInfo.getName());
                        hVar.e(groupInfo.getPortrait());
                        hVar.g(groupInfo.getPosition());
                        hVar.a(groupInfo.getAuthorIsMeizhi() == 1);
                        hVar.b(groupInfo.getIsNewlyCreate() != 0);
                        hVar.c(groupInfo.getIsRecentlyReply() != 0);
                        nearbyGroupsData.add(hVar);
                    }
                    i2 = i3 + 1;
                } else {
                    a(nearbyGroupsData);
                    return;
                }
            }
        }
    }
}
