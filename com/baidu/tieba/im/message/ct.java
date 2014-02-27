package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.BaseGroupData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.SearchGroup.SearchGroupRes;
/* loaded from: classes.dex */
public class ct extends da implements com.baidu.tieba.im.coder.f {
    private long a;
    private List<BaseGroupData> b;
    private List<com.baidu.adp.lib.cache.t<String>> c;

    public ct() {
        super(103007);
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final List<BaseGroupData> a() {
        return this.b;
    }

    public final void a(List<com.baidu.adp.lib.cache.t<String>> list) {
        this.c = list;
    }

    public final void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        SearchGroupRes.SearchGroupResIdl parseFrom = SearchGroupRes.SearchGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            LinkedList linkedList2 = new LinkedList();
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
                linkedList2.add(baseGroupData);
            }
            this.b = linkedList2;
        }
    }
}
