package com.baidu.tieba.homepage.fragment.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.homepage.fragment.data.b, BaseFragmentActivity> {
    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<com.baidu.tieba.homepage.fragment.data.b> DF() {
        return com.baidu.tieba.homepage.fragment.data.b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dr() {
        return "HomePageCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DG() {
        return CmdConfigCustom.CMD_HOME_PAGE_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DH() {
        return CmdConfigCustom.CMD_HOME_PAGE_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean Dy() {
        return false;
    }
}
