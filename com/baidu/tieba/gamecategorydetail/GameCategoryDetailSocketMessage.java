package com.baidu.tieba.gamecategorydetail;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.game.base.CachedSocketResponse;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCategoryDetail.GetGameCategoryDetailResIdl;
/* loaded from: classes.dex */
public class GameCategoryDetailSocketMessage extends CachedSocketResponse {
    private int has_more;
    private List<GameInfo> list;

    public List<GameInfo> getGameInfoList() {
        return this.list;
    }

    public int getHasMore() {
        return this.has_more;
    }

    public GameCategoryDetailSocketMessage() {
        super(303105);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetGameCategoryDetailResIdl getGameCategoryDetailResIdl = (GetGameCategoryDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameCategoryDetailResIdl.class);
        if (getGameCategoryDetailResIdl != null) {
            if (getGameCategoryDetailResIdl.error != null) {
                setError(getGameCategoryDetailResIdl.error.errorno.intValue());
                setErrorString(getGameCategoryDetailResIdl.error.usermsg);
            }
            if (getGameCategoryDetailResIdl.data != null) {
                if (getGameCategoryDetailResIdl.data.game_list != null) {
                    this.list = getGameCategoryDetailResIdl.data.game_list;
                }
                if (getGameCategoryDetailResIdl.data.has_more != null) {
                    this.has_more = getGameCategoryDetailResIdl.data.has_more.intValue();
                }
            }
        }
    }

    @Override // com.baidu.tieba.game.base.CachedSocketResponse
    protected String getCacheKey() {
        if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof GameCategoryDetailMessage)) {
            return null;
        }
        return "key_prefix_categorydetail" + ((GameCategoryDetailMessage) getOrginalMessage().getExtra()).getCategoryId();
    }

    @Override // com.baidu.tieba.game.base.CachedSocketResponse
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof GameCategoryDetailMessage) && ((GameCategoryDetailMessage) getOrginalMessage().getExtra()).getPageNum() == 1) {
            String cacheKey = getCacheKey();
            if (bArr != null && !StringUtils.isNull(cacheKey)) {
                com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_list").b(cacheKey, bArr);
            }
        }
    }
}
