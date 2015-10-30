package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.discover.data.a, BaseFragmentActivity> {
    public r(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<com.baidu.tieba.discover.data.a> CL() {
        return com.baidu.tieba.discover.data.a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Cx() {
        return "FoundNewCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CM() {
        return CmdConfigCustom.CMD_FOUND_NEW_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CN() {
        return CmdConfigCustom.CMD_FOUND_NEW_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean CE() {
        return false;
    }
}
