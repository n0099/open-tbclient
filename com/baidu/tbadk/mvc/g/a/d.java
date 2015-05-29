package com.baidu.tbadk.mvc.g.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.j.e;
/* loaded from: classes.dex */
public class d extends e<com.baidu.tbadk.mvc.b.a, com.baidu.tbadk.mvc.e.c> {
    protected NavigationBar aox;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        if (view instanceof NavigationBar) {
            this.aox = (NavigationBar) view;
        } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
            this.aox = (NavigationBar) view;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aox.onChangeSkinType(tbPageContext, i);
        return true;
    }
}
