package com.baidu.tieba.ala.alasquare.live.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.k0.t.d.a.b;
import d.a.k0.t.d.b.b.a;
import java.util.LinkedList;
import tbclient.LiveSquare.DataRes;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.LiveSquare.LiveSquareResIdl;
/* loaded from: classes4.dex */
public class AlaSquareLiveHttpResponseMessage extends HttpResponsedMessage {
    public LinkedList<a> categoryList;
    public LinkedList<FunctionListInfo> functionList;
    public HeadLiveInfo headLiveInfo;
    public int isSmallFollow;
    public boolean mHasMore;
    public int mPn;

    public AlaSquareLiveHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_SQUARE_LIVE);
        this.mPn = 0;
    }

    public LinkedList<a> getCategoryList() {
        return this.categoryList;
    }

    public LinkedList<FunctionListInfo> getFunctionList() {
        return this.functionList;
    }

    public HeadLiveInfo getHeadLiveInfo() {
        return this.headLiveInfo;
    }

    public int getIsSmallFollow() {
        return this.isSmallFollow;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public void setPn(int i2) {
        this.mPn = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        l<byte[]> a2;
        if (hasError() || ListUtils.isEmpty(this.categoryList) || this.mPn != 1 || (a2 = BdCacheService.l().a("ala_square_space", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20)) == null) {
            return;
        }
        a2.e("ala_square_live_key", bArr, 604800000L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        LiveSquareResIdl liveSquareResIdl = (LiveSquareResIdl) new Wire(new Class[0]).parseFrom(bArr, LiveSquareResIdl.class);
        setError(liveSquareResIdl.error.errorno.intValue());
        setErrorString(liveSquareResIdl.error.usermsg);
        if (hasError()) {
            return;
        }
        this.functionList = new LinkedList<>();
        LinkedList<a> linkedList = new LinkedList<>();
        this.categoryList = linkedList;
        linkedList.addAll(b.a(liveSquareResIdl.data.live_with_category));
        this.functionList.addAll(liveSquareResIdl.data.function_list_info);
        DataRes dataRes = liveSquareResIdl.data;
        this.headLiveInfo = dataRes.head_live_info;
        this.isSmallFollow = dataRes.is_small_follow.intValue();
        this.mHasMore = liveSquareResIdl.data.has_more.intValue() == 1;
    }
}
