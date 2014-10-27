package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.NearbyGroupsData;
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
                    com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                    bVar.setName(business.business);
                    nearbyGroupsData.add(bVar);
                    List<GroupInfo> list2 = business.groups;
                    if (list2 != null) {
                        int size = list2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            GroupInfo groupInfo = list2.get(i3);
                            com.baidu.tieba.im.data.d dVar = new com.baidu.tieba.im.data.d();
                            dVar.setAuthorId(groupInfo.authorId.intValue());
                            dVar.setAuthorName(groupInfo.authorName);
                            dVar.setBusiness(groupInfo.business);
                            dVar.fv(groupInfo.distance.intValue());
                            dVar.setForumId(String.valueOf(groupInfo.forumId));
                            dVar.setGrade(groupInfo.grade.intValue());
                            dVar.setGroupId(String.valueOf(groupInfo.groupId));
                            dVar.setIntro(groupInfo.intro);
                            dVar.setLat(String.valueOf(groupInfo.lat));
                            dVar.setLng(String.valueOf(groupInfo.lng));
                            dVar.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                            dVar.setMemberNum(groupInfo.memberNum.intValue());
                            dVar.setName(groupInfo.name);
                            dVar.setPortrait(groupInfo.portrait);
                            dVar.setPosition(groupInfo.position);
                            dVar.cS(groupInfo.authorIsMeizhi.intValue() == 1);
                            dVar.cT(groupInfo.isNewlyCreate.intValue() != 0);
                            dVar.cU(groupInfo.isRecentlyReply.intValue() != 0);
                            dVar.setMemGroup(groupInfo.isMemberGroup.intValue() == 1);
                            nearbyGroupsData.add(dVar);
                        }
                    }
                }
            }
            setNearbyGroups(nearbyGroupsData);
        }
    }
}
