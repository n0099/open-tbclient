package com.baidu.tieba.homepage.concern.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.card.b<AbsThreadDataSupport> {
    private NoDataView mNoDataView;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mNoDataView = NoDataViewFactory.a(pageActivity, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.m31do(null, pageActivity.getResources().getString(R.string.concern_no_data_title)), null);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        return this.mNoDataView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.mNoDataView.onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }
}
