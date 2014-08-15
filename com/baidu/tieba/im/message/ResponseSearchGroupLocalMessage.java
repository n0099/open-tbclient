package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.v;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.SearchGroup.SearchGroupResIdl;
/* loaded from: classes.dex */
public class ResponseSearchGroupLocalMessage extends CustomResponsedMessage<Object> {
    private List<v<String>> cacheList;
    private long gid;
    private List<BaseGroupData> searchResult;

    public ResponseSearchGroupLocalMessage() {
        super(2001211);
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }

    public ResponseSearchGroupLocalMessage(int i) {
        super(i);
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }

    public List<BaseGroupData> getSearchResult() {
        return this.searchResult;
    }

    public void setSearchResult(List<BaseGroupData> list) {
        this.searchResult = list;
    }

    public List<v<String>> getCacheList() {
        return this.cacheList;
    }

    public void setCacheList(List<v<String>> list) {
        this.cacheList = list;
    }

    public long getGid() {
        return this.gid;
    }

    public void setGid(long j) {
        this.gid = j;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        SearchGroupResIdl searchGroupResIdl = (SearchGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchGroupResIdl.class);
        setError(searchGroupResIdl.error.errorno.intValue());
        setErrorString(searchGroupResIdl.error.usermsg);
        if (getError() == 0) {
            LinkedList linkedList = new LinkedList();
            GroupInfo groupInfo = searchGroupResIdl.data.group;
            if (groupInfo != null) {
                BaseGroupData baseGroupData = new BaseGroupData();
                baseGroupData.setGroupId(groupInfo.groupId.intValue());
                baseGroupData.setName(groupInfo.name);
                baseGroupData.setIntro(groupInfo.intro);
                baseGroupData.setPortrait(groupInfo.portrait);
                baseGroupData.setPosition(groupInfo.position);
                baseGroupData.setLng(String.valueOf(groupInfo.lng));
                baseGroupData.setLat(String.valueOf(groupInfo.lat));
                baseGroupData.setNotice(groupInfo.notice);
                baseGroupData.setAlbum(groupInfo.album);
                baseGroupData.setStatus(groupInfo.status.intValue());
                baseGroupData.setAuthorId(groupInfo.authorId.intValue());
                baseGroupData.setAuthorName(groupInfo.authorName);
                baseGroupData.setCreateTime(groupInfo.createTime.intValue());
                baseGroupData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                baseGroupData.setMemberNum(groupInfo.memberNum.intValue());
                baseGroupData.setGroupType(groupInfo.groupType.intValue());
                baseGroupData.setForumId(groupInfo.forumId.intValue());
                linkedList.add(baseGroupData);
            }
            setSearchResult(linkedList);
        }
    }
}
