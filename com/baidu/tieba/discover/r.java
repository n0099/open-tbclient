package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.discover.data.a, BaseFragmentActivity> {
    public r(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<com.baidu.tieba.discover.data.a> AH() {
        return com.baidu.tieba.discover.data.a.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String AK() {
        return "FoundNewCache";
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AI() {
        return 2016201;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AJ() {
        return 2016202;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean BC() {
        return false;
    }
}
