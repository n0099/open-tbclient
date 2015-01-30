package com.baidu.tbadk.mvc.g.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.j.d<com.baidu.tbadk.mvc.b.a, com.baidu.tbadk.mvc.e.c> {
    protected NavigationBar aeV;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        if (view instanceof NavigationBar) {
            this.aeV = (NavigationBar) view;
        } else if (TbadkCoreApplication.m255getInst().isDebugMode()) {
            this.aeV = (NavigationBar) view;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aeV.onChangeSkinType(tbPageContext, i);
        return true;
    }
}
