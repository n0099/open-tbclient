package com.baidu.tbadk.mvc.g.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.j.e;
/* loaded from: classes.dex */
public class d extends e<com.baidu.tbadk.mvc.b.a, com.baidu.tbadk.mvc.e.c> {
    protected NavigationBar anm;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        if (view instanceof NavigationBar) {
            this.anm = (NavigationBar) view;
        } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
            this.anm = (NavigationBar) view;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.anm.onChangeSkinType(tbPageContext, i);
        return true;
    }
}
