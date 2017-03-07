package com.baidu.tieba.homepage.recommendfrs.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.homepage.recommendfrs.data.c;
/* loaded from: classes.dex */
public class RecommendFrsCacheModel extends CacheModel<c, BaseFragmentActivity> {
    public static final String TABLE_NAME = "RecommendFrsCache";

    public RecommendFrsCacheModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<c> EX() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String EI() {
        return TABLE_NAME;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EY() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EZ() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    protected boolean EQ() {
        return false;
    }
}
