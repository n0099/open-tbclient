package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BaseGroupData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.SearchGroup.SearchGroupRes;
/* loaded from: classes.dex */
public class ResponseSearchGroupMessage extends SocketResponsedMessage {
    private List<BaseGroupData> a;
    private List<com.baidu.adp.lib.cache.t<String>> b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        SearchGroupRes.SearchGroupResIdl parseFrom = SearchGroupRes.SearchGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            LinkedList linkedList = new LinkedList();
            Im.GroupInfo group = parseFrom.getData().getGroup();
            if (group != null) {
                BaseGroupData baseGroupData = new BaseGroupData();
                baseGroupData.setGroupId(group.getGroupId());
                baseGroupData.setName(group.getName());
                baseGroupData.setIntro(group.getIntro());
                baseGroupData.setPortrait(group.getPortrait());
                baseGroupData.setPosition(group.getPosition());
                baseGroupData.setLng(String.valueOf(group.getLng()));
                baseGroupData.setLat(String.valueOf(group.getLat()));
                baseGroupData.setNotice(group.getNotice());
                baseGroupData.setAlbum(group.getAlbum());
                baseGroupData.setStatus(group.getStatus());
                baseGroupData.setAuthorId(group.getAuthorId());
                baseGroupData.setAuthorName(group.getAuthorName());
                baseGroupData.setCreateTime(group.getCreateTime());
                baseGroupData.setMaxMemberNum(group.getMaxMemberNum());
                baseGroupData.setMemberNum(group.getMemberNum());
                baseGroupData.setGroupType(group.getGroupType());
                baseGroupData.setForumId(group.getForumId());
                linkedList.add(baseGroupData);
            }
            this.a = linkedList;
        }
    }

    public ResponseSearchGroupMessage() {
        super(103007);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public ResponseSearchGroupMessage(int i) {
        super(i);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final List<BaseGroupData> d() {
        return this.a;
    }
}
