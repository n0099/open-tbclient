package com.baidu.tieba.homepage.listview.card.discover;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.homepage.listview.a<h, m> {
    private HttpMessageListener aNX;
    protected m byV;
    protected TbPageContext<?> pageContext;

    private void Ub() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aNX = new b(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        this.pageContext = tbPageContext;
        Ub();
        this.pageContext.registerListener(this.aNX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public m a(ViewGroup viewGroup) {
        this.byV = new m(this.pageContext, com.baidu.tieba.homepage.fragment.a.b.h(this.mContext, com.baidu.tieba.homepage.fragment.a.b.a(this.mContext, h.class)));
        return this.byV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, m mVar) {
        if (mVar == null || mVar.TY() == null) {
            return null;
        }
        mVar.byI.setVisibility(0);
        mVar.c(hVar);
        mVar.cZ(TbadkCoreApplication.m411getInst().getSkinType());
        return mVar.TY();
    }
}
