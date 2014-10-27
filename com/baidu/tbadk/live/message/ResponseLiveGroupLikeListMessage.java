package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import protobuf.QueryLiveGroupLikeList.LikeUserInfo;
import protobuf.QueryLiveGroupLikeList.QueryLiveGroupLikeListResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupLikeListMessage extends SocketResponsedMessage {
    private boolean mHasMore;
    private List<LikeUserInfo> mLikeList;
    private int mlikers;

    public ResponseLiveGroupLikeListMessage() {
        super(107006);
    }

    public int getLikers() {
        return this.mlikers;
    }

    public List<LikeUserInfo> getLiveList() {
        return this.mLikeList;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryLiveGroupLikeListResIdl queryLiveGroupLikeListResIdl = (QueryLiveGroupLikeListResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupLikeListResIdl.class);
        setError(queryLiveGroupLikeListResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupLikeListResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLikeList = queryLiveGroupLikeListResIdl.data.likeUserList;
            this.mHasMore = queryLiveGroupLikeListResIdl.data.hasMore.intValue() == 1;
            this.mlikers = queryLiveGroupLikeListResIdl.data.likers.intValue() >= 0 ? queryLiveGroupLikeListResIdl.data.likers.intValue() : 0;
        }
    }
}
