package com.baidu.tieba.homepage.mygod;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.homepage.mygod.data.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<d, BaseFragmentActivity> {
    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<d> EW() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String EI() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int EX() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int EY() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean EP() {
        return true;
    }
}
