package com.baidu.tieba.game.hot;

import com.baidu.tieba.game.base.CachedHttpResponse;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetHotGameList.GetHotGameListResIdl;
/* loaded from: classes.dex */
public class HotGameHttpResponse extends CachedHttpResponse {
    private List<GameInfo> list;

    public HotGameHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetHotGameListResIdl getHotGameListResIdl = (GetHotGameListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGameListResIdl.class);
        if (getHotGameListResIdl != null) {
            if (getHotGameListResIdl.error != null) {
                setError(getHotGameListResIdl.error.errorno.intValue());
                setErrorString(getHotGameListResIdl.error.usermsg);
            }
            if (getHotGameListResIdl.data != null && getHotGameListResIdl.data.game_list != null) {
                this.list = getHotGameListResIdl.data.game_list;
            }
        }
    }

    public List<GameInfo> getGameList() {
        return this.list;
    }

    @Override // com.baidu.tieba.game.base.CachedHttpResponse
    protected String getCachedKey() {
        return "key_hot_game";
    }
}
