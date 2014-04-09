package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public class ResponseNearbyGroupsMessage extends TbSocketReponsedMessage {
    private NearbyGroupsData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupsByLocationRes.QueryGroupsByLocationResIdl parseFrom = QueryGroupsByLocationRes.QueryGroupsByLocationResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            NearbyGroupsData nearbyGroupsData = new NearbyGroupsData();
            nearbyGroupsData.setGeo(parseFrom.getData().getGeo());
            nearbyGroupsData.setOffset(parseFrom.getData().getOffset());
            nearbyGroupsData.setHasMore(parseFrom.getData().getHasMore() == 1);
            List<QueryGroupsByLocationRes.Business> groupsList = parseFrom.getData().getGroupsList();
            for (int i2 = 0; i2 < groupsList.size(); i2++) {
                QueryGroupsByLocationRes.Business business = groupsList.get(i2);
                com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                eVar.a(business.getBusiness());
                nearbyGroupsData.add(eVar);
                List<Im.GroupInfo> groupsList2 = business.getGroupsList();
                int size = groupsList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Im.GroupInfo groupInfo = groupsList2.get(i3);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.baidu.adp.framework.message.f
    public final /* synthetic */ void b(int i, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (e() == 0) {
            if (this.a == null || this.a.getOffset() == 0) {
                a(com.baidu.tbadk.core.c.b.a().s(), "p_nearby_group_info" + (TbadkApplication.N() != null ? TbadkApplication.N().getID() : ""), bArr2);
            }
        }
    }

    public ResponseNearbyGroupsMessage() {
        super(103009);
    }

    public final NearbyGroupsData d() {
        return this.a;
    }
}
