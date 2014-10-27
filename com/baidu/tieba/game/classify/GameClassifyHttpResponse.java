package com.baidu.tieba.game.classify;

import com.baidu.tieba.game.base.CachedHttpResponse;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GameCategory;
import tbclient.GetGameCategory.GetGameCategoryResIdl;
/* loaded from: classes.dex */
public class GameClassifyHttpResponse extends CachedHttpResponse {
    private List<GameCategory> list;

    public GameClassifyHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetGameCategoryResIdl getGameCategoryResIdl = (GetGameCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameCategoryResIdl.class);
        if (getGameCategoryResIdl != null) {
            if (getGameCategoryResIdl.error != null) {
                setError(getGameCategoryResIdl.error.errorno.intValue());
                setErrorString(getGameCategoryResIdl.error.usermsg);
            }
            if (getGameCategoryResIdl.data != null && getGameCategoryResIdl.data != null && getGameCategoryResIdl.data.category_list != null) {
                this.list = getGameCategoryResIdl.data.category_list;
            }
        }
    }

    public List<GameCategory> getCategoryList() {
        return this.list;
    }

    @Override // com.baidu.tieba.game.base.CachedHttpResponse
    protected String getCachedKey() {
        return "key_game_classify";
    }
}
