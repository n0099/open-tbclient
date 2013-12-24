package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public class bk extends bz implements com.baidu.tieba.im.coder.f {
    private NearbyGroupsData a;

    public bk() {
        e(103009);
    }

    public NearbyGroupsData a() {
        return this.a;
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        this.a = nearbyGroupsData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl parseFrom = QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            NearbyGroupsData nearbyGroupsData = new NearbyGroupsData();
            nearbyGroupsData.setGeo(parseFrom.getData().getGeo());
            nearbyGroupsData.setOffset(parseFrom.getData().getOffset());
            nearbyGroupsData.setHasMore(parseFrom.getData().getHasMore() == 1);
            List<QueryGroupsByLocationRes.Business> groupsList = parseFrom.getData().getGroupsList();
            for (int i2 = 0; i2 < groupsList.size(); i2++) {
                QueryGroupsByLocationRes.Business business = groupsList.get(i2);
                com.baidu.tieba.im.data.g gVar = new com.baidu.tieba.im.data.g();
                gVar.a(business.getBusiness());
                nearbyGroupsData.add(gVar);
                List<Im.GroupInfo> groupsList2 = business.getGroupsList();
                int size = groupsList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Im.GroupInfo groupInfo = groupsList2.get(i3);
                    com.baidu.tieba.im.data.i iVar = new com.baidu.tieba.im.data.i();
                    iVar.d(groupInfo.getAuthorId());
                    iVar.f(groupInfo.getAuthorName());
                    iVar.h(groupInfo.getBusiness());
                    iVar.f(groupInfo.getDistance());
                    iVar.b(String.valueOf(groupInfo.getForumId()));
                    iVar.e(groupInfo.getGrade());
                    iVar.a(String.valueOf(groupInfo.getGroupId()));
                    iVar.d(groupInfo.getIntro());
                    iVar.j(String.valueOf(groupInfo.getLat()));
                    iVar.i(String.valueOf(groupInfo.getLng()));
                    iVar.b(groupInfo.getMaxMemberNum());
                    iVar.c(groupInfo.getMemberNum());
                    iVar.c(groupInfo.getName());
                    iVar.e(groupInfo.getPortrait());
                    iVar.g(groupInfo.getPosition());
                    iVar.a(groupInfo.getAuthorIsMeizhi() == 1);
                    nearbyGroupsData.add(iVar);
                }
            }
            a(nearbyGroupsData);
        }
    }
}
