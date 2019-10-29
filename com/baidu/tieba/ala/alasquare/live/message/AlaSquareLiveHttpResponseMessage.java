package com.baidu.tieba.ala.alasquare.live.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live.b.a;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.LiveSquare.LiveSquareResIdl;
/* loaded from: classes6.dex */
public class AlaSquareLiveHttpResponseMessage extends HttpResponsedMessage {
    private LinkedList<a> categoryList;
    private LinkedList<FunctionListInfo> functionList;
    private HeadLiveInfo headLiveInfo;
    private int isSmallFollow;
    private boolean mHasMore;
    private int mPn;

    public AlaSquareLiveHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_SQUARE_LIVE);
        this.mPn = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LiveSquareResIdl liveSquareResIdl = (LiveSquareResIdl) new Wire(new Class[0]).parseFrom(bArr, LiveSquareResIdl.class);
        setError(liveSquareResIdl.error.errorno.intValue());
        setErrorString(liveSquareResIdl.error.usermsg);
        if (!hasError()) {
            this.functionList = new LinkedList<>();
            this.categoryList = new LinkedList<>();
            this.categoryList.addAll(com.baidu.tieba.ala.alasquare.a.a.bf(liveSquareResIdl.data.live_with_category));
            this.functionList.addAll(liveSquareResIdl.data.function_list_info);
            this.headLiveInfo = liveSquareResIdl.data.head_live_info;
            this.isSmallFollow = liveSquareResIdl.data.is_small_follow.intValue();
            this.mHasMore = liveSquareResIdl.data.has_more.intValue() == 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        l<byte[]> b;
        if (!hasError() && !v.isEmpty(this.categoryList) && this.mPn == 1 && (b = BdCacheService.fe().b("ala_square_space", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20)) != null) {
            b.set("ala_square_live_key", bArr, 604800000L);
        }
    }

    public LinkedList<FunctionListInfo> getFunctionList() {
        return this.functionList;
    }

    public HeadLiveInfo getHeadLiveInfo() {
        return this.headLiveInfo;
    }

    public LinkedList<a> getCategoryList() {
        return this.categoryList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public int getIsSmallFollow() {
        return this.isSmallFollow;
    }

    public void setPn(int i) {
        this.mPn = i;
    }
}
