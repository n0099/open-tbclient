package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.data.j;
import com.baidu.tieba.im.data.l;
import com.squareup.wire.Wire;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.QueryGroupsByLocation.Business;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationResIdl;
/* loaded from: classes.dex */
public class ResponseNearbyGroupsMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "p_nearby_group_info";
    private NearbyGroupsData nearbyGroups;

    public ResponseNearbyGroupsMessage() {
        super(MessageTypes.CMD_NEARBY_GROUP);
    }

    public NearbyGroupsData getNearbyGroups() {
        return this.nearbyGroups;
    }

    public void setNearbyGroups(NearbyGroupsData nearbyGroupsData) {
        this.nearbyGroups = nearbyGroupsData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
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
                    j jVar = new j();
                    jVar.a(business.business);
                    nearbyGroupsData.add(jVar);
                    List<GroupInfo> list2 = business.groups;
                    if (list2 != null) {
                        int size = list2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            GroupInfo groupInfo = list2.get(i3);
                            l lVar = new l();
                            lVar.d(groupInfo.authorId.intValue());
                            lVar.f(groupInfo.authorName);
                            lVar.h(groupInfo.business);
                            lVar.f(groupInfo.distance.intValue());
                            lVar.b(String.valueOf(groupInfo.forumId));
                            lVar.e(groupInfo.grade.intValue());
                            lVar.a(String.valueOf(groupInfo.groupId));
                            lVar.d(groupInfo.intro);
                            lVar.j(String.valueOf(groupInfo.lat));
                            lVar.i(String.valueOf(groupInfo.lng));
                            lVar.b(groupInfo.maxMemberNum.intValue());
                            lVar.c(groupInfo.memberNum.intValue());
                            lVar.c(groupInfo.name);
                            lVar.e(groupInfo.portrait);
                            lVar.g(groupInfo.position);
                            lVar.a(groupInfo.authorIsMeizhi.intValue() == 1);
                            lVar.b(groupInfo.isNewlyCreate.intValue() != 0);
                            lVar.c(groupInfo.isRecentlyReply.intValue() != 0);
                            lVar.d(groupInfo.isMemberGroup.intValue() == 1);
                            nearbyGroupsData.add(lVar);
                        }
                    }
                }
            }
            setNearbyGroups(nearbyGroupsData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void processInBackGround(int i, byte[] bArr) {
        if (getError() == 0) {
            if (getNearbyGroups() == null || getNearbyGroups().getOffset() == 0) {
                String str = "";
                if (TbadkApplication.getCurrentAccountObj() != null) {
                    str = TbadkApplication.getCurrentAccountObj().getID();
                }
                saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.b.a().u(), CACHE_KEY_PREFIX + str, bArr);
            }
        }
    }
}
