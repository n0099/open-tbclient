package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public class ResponseNearbyGroupsLocalMessage extends CustomResponsedMessage<Object> {
    private NearbyGroupsData a;

    public ResponseNearbyGroupsLocalMessage() {
        super(2001115);
    }

    public final NearbyGroupsData b() {
        return this.a;
    }

    public final void a(byte[] bArr) {
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl parseFrom = QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.parseFrom(bArr);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            NearbyGroupsData nearbyGroupsData = new NearbyGroupsData();
            nearbyGroupsData.setGeo(parseFrom.getData().getGeo());
            nearbyGroupsData.setOffset(parseFrom.getData().getOffset());
            nearbyGroupsData.setHasMore(parseFrom.getData().getHasMore() == 1);
            List<QueryGroupsByLocationRes.Business> groupsList = parseFrom.getData().getGroupsList();
            for (int i = 0; i < groupsList.size(); i++) {
                QueryGroupsByLocationRes.Business business = groupsList.get(i);
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                eVar.a(business.getBusiness());
                nearbyGroupsData.add(eVar);
                List<Im.GroupInfo> groupsList2 = business.getGroupsList();
                int size = groupsList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Im.GroupInfo groupInfo = groupsList2.get(i2);
                    com.baidu.tieba.im.data.g gVar = new com.baidu.tieba.im.data.g();
                    gVar.d(groupInfo.getAuthorId());
                    gVar.f(groupInfo.getAuthorName());
                    gVar.h(groupInfo.getBusiness());
                    gVar.f(groupInfo.getDistance());
                    gVar.b(String.valueOf(groupInfo.getForumId()));
                    gVar.e(groupInfo.getGrade());
                    gVar.a(String.valueOf(groupInfo.getGroupId()));
                    gVar.d(groupInfo.getIntro());
                    gVar.j(String.valueOf(groupInfo.getLat()));
                    gVar.i(String.valueOf(groupInfo.getLng()));
                    gVar.b(groupInfo.getMaxMemberNum());
                    gVar.c(groupInfo.getMemberNum());
                    gVar.c(groupInfo.getName());
                    gVar.e(groupInfo.getPortrait());
                    gVar.g(groupInfo.getPosition());
                    gVar.a(groupInfo.getAuthorIsMeizhi() == 1);
                    gVar.b(groupInfo.getIsNewlyCreate() != 0);
                    gVar.c(groupInfo.getIsRecentlyReply() != 0);
                    gVar.d(groupInfo.getIsMemberGroup() == 1);
                    nearbyGroupsData.add(gVar);
                }
            }
            this.a = nearbyGroupsData;
        }
    }
}
