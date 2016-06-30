package com.baidu.tieba.homepage.mygod;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.homepage.mygod.data.c;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<c, BaseFragmentActivity> {
    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<c> DD() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dp() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DE() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DF() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean Dw() {
        return true;
    }
}
