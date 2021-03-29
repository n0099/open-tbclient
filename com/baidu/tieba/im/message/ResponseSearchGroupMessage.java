package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.SearchGroup.SearchGroupResIdl;
/* loaded from: classes3.dex */
public class ResponseSearchGroupMessage extends SocketResponsedMessage {
    public List<l.b<String>> cacheList;
    public long gid;
    public List<BaseGroupData> searchResult;

    public ResponseSearchGroupMessage() {
        super(103007);
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }

    public List<l.b<String>> getCacheList() {
        return this.cacheList;
    }

    public long getGid() {
        return this.gid;
    }

    public List<BaseGroupData> getSearchResult() {
        return this.searchResult;
    }

    public void setCacheList(List<l.b<String>> list) {
        this.cacheList = list;
    }

    public void setGid(long j) {
        this.gid = j;
    }

    public void setSearchResult(List<BaseGroupData> list) {
        this.searchResult = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchGroupResIdl searchGroupResIdl = (SearchGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchGroupResIdl.class);
        setError(searchGroupResIdl.error.errorno.intValue());
        setErrorString(searchGroupResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        GroupInfo groupInfo = searchGroupResIdl.data.group;
        if (groupInfo != null) {
            BaseGroupData baseGroupData = new BaseGroupData();
            baseGroupData.setGroupId(groupInfo.groupId.longValue());
            baseGroupData.setName(groupInfo.name);
            baseGroupData.setIntro(groupInfo.intro);
            baseGroupData.setPortrait(groupInfo.portrait);
            baseGroupData.setPosition(groupInfo.position);
            baseGroupData.setLng(String.valueOf(groupInfo.lng));
            baseGroupData.setLat(String.valueOf(groupInfo.lat));
            baseGroupData.setNotice(groupInfo.notice);
            baseGroupData.setAlbum(groupInfo.album);
            baseGroupData.setStatus(groupInfo.status.intValue());
            baseGroupData.setAuthorId(groupInfo.authorId.longValue());
            baseGroupData.setAuthorName(groupInfo.authorName);
            baseGroupData.setAuthorNameShow(groupInfo.authorNameShow);
            baseGroupData.setCreateTime(groupInfo.createTime.intValue());
            baseGroupData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
            baseGroupData.setMemberNum(groupInfo.memberNum.intValue());
            baseGroupData.setGroupType(groupInfo.groupType.intValue());
            baseGroupData.setForumId(groupInfo.forumId.intValue());
            linkedList.add(baseGroupData);
        }
        setSearchResult(linkedList);
    }

    public ResponseSearchGroupMessage(int i) {
        super(i);
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }
}
