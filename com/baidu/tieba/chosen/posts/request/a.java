package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<d, ChosenPostActivity> {
    public a(TbPageContext<ChosenPostActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<d> Du() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dg() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dv() {
        return CmdConfigCustom.CMD_CHOSEN_POST_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dw() {
        return CmdConfigCustom.CMD_CHOSEN_POST_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean Dn() {
        return false;
    }
}
