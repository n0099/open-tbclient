package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.data.h;
import com.baidu.tieba.im.data.j;
import com.squareup.wire.Wire;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.QueryGroupsByLocation.Business;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationResIdl;
/* loaded from: classes.dex */
public class ResponseNearbyGroupsLocalMessage extends CustomResponsedMessage<Object> {
    private NearbyGroupsData nearbyGroups;

    public ResponseNearbyGroupsLocalMessage() {
        super(2001115);
    }

    public NearbyGroupsData getNearbyGroups() {
        return this.nearbyGroups;
    }

    public void setNearbyGroups(NearbyGroupsData nearbyGroupsData) {
        this.nearbyGroups = nearbyGroupsData;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupsByLocationResIdl queryGroupsByLocationResIdl = (QueryGroupsByLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByLocationResIdl.class);
        setError(queryGroupsByLocationResIdl.error.errorno.intValue());
        setErrorString(queryGroupsByLocationResIdl.error.usermsg);
        if (getError() == 0) {
            NearbyGroupsData nearbyGroupsData = new NearbyGroupsData();
            nearbyGroupsData.setGeo(queryGroupsByLocationResIdl.data.geo.intValue());
            nearbyGroupsData.setOffset(queryGroupsByLocationResIdl.data.offset.intValue());
            nearbyGroupsData.setHasMore(queryGroupsByLocationResIdl.data.hasMore.intValue() == 1);
            List<Business> list = queryGroupsByLocationResIdl.data.groups;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Business business = list.get(i2);
                    h hVar = new h();
                    hVar.a(business.business);
                    nearbyGroupsData.add(hVar);
                    List<GroupInfo> list2 = business.groups;
                    if (list2 != null) {
                        int size = list2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            GroupInfo groupInfo = list2.get(i3);
                            j jVar = new j();
                            jVar.d(groupInfo.authorId.intValue());
                            jVar.f(groupInfo.authorName);
                            jVar.h(groupInfo.business);
                            jVar.f(groupInfo.distance.intValue());
                            jVar.b(String.valueOf(groupInfo.forumId));
                            jVar.e(groupInfo.grade.intValue());
                            jVar.a(String.valueOf(groupInfo.groupId));
                            jVar.d(groupInfo.intro);
                            jVar.j(String.valueOf(groupInfo.lat));
                            jVar.i(String.valueOf(groupInfo.lng));
                            jVar.b(groupInfo.maxMemberNum.intValue());
                            jVar.c(groupInfo.memberNum.intValue());
                            jVar.c(groupInfo.name);
                            jVar.e(groupInfo.portrait);
                            jVar.g(groupInfo.position);
                            jVar.a(groupInfo.authorIsMeizhi.intValue() == 1);
                            jVar.b(groupInfo.isNewlyCreate.intValue() != 0);
                            jVar.c(groupInfo.isRecentlyReply.intValue() != 0);
                            jVar.d(groupInfo.isMemberGroup.intValue() == 1);
                            nearbyGroupsData.add(jVar);
                        }
                    }
                }
            }
            setNearbyGroups(nearbyGroupsData);
        }
    }
}
