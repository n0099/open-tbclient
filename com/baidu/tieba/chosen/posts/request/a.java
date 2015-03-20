package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<d, ChosenPostActivity> {
    public a(TbPageContext<ChosenPostActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<d> zO() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String zR() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int zP() {
        return 2001319;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int zQ() {
        return 2001320;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean AJ() {
        return false;
    }
}
