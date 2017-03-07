package com.baidu.tieba.homepage.mygod;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.homepage.mygod.data.d;
/* loaded from: classes.dex */
public class RecommendGodCacheModel extends CacheModel<d, BaseFragmentActivity> {
    public static final String TABLE_NAME = "RecommendGodCache";

    public RecommendGodCacheModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<d> EX() {
        return d.class;
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
        return true;
    }
}
