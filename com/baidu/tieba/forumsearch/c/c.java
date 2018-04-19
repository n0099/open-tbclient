package com.baidu.tieba.forumsearch.c;

import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private NoDataView mNoDataView;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mNoDataView = NoDataViewFactory.a(this.mTbPageContext.getPageActivity(), getView(), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.mTbPageContext.getPageActivity(), d.e.ds160)), NoDataViewFactory.d.m16do(d.k.search_forum_no_result), null);
        this.mNoDataView.setVisibility(0);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.mTbPageContext, i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.forum_search_no_result;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
