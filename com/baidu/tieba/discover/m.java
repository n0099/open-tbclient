package com.baidu.tieba.discover;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.discover.data.a, BaseFragmentActivity> {
    public m(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<com.baidu.tieba.discover.data.a> lg() {
        return com.baidu.tieba.discover.data.a.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String lj() {
        return "FoundNewCache";
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int lh() {
        return 2016201;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int li() {
        return 2016202;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean xv() {
        return false;
    }
}
