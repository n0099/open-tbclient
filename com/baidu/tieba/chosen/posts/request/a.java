package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<d, ChosenPostActivity> {
    public a(TbPageContext<ChosenPostActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<d> AG() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String AJ() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AH() {
        return 2001319;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AI() {
        return 2001320;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean BB() {
        return false;
    }
}
