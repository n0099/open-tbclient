package com.baidu.tieba.gamecategorydetail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.g;
import tbclient.GetGameCategoryDetail.DataReq;
import tbclient.GetGameCategoryDetail.GetGameCategoryDetailReqIdl;
/* loaded from: classes.dex */
public class GameCategoryDetailMessage extends NetMessage {
    private int categoryId;
    private int pageNum;
    private int platform;
    private int retrunNum;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setRn(int i) {
        this.retrunNum = i;
    }

    public void setPlatform(int i) {
        this.platform = i;
    }

    public GameCategoryDetailMessage() {
        super(CmdConfigHttp.MSG_GAME_CATEGORY_DETAIL, 303105);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.category_id = Integer.valueOf(this.categoryId);
        builder.pn = Integer.valueOf(this.pageNum);
        builder.rn = Integer.valueOf(this.retrunNum);
        builder.recommend_platform = Integer.valueOf(this.platform);
        if (z) {
            g.a(builder, true);
        }
        GetGameCategoryDetailReqIdl.Builder builder2 = new GetGameCategoryDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
