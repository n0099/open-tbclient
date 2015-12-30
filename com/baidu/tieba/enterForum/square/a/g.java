package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.enterForum.square.a.a<m, a> {
    private w aVH;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext, m.aQc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public a a(ViewGroup viewGroup) {
        this.aVH = new w(this.mPageContext);
        this.aVH.setTag(getTag());
        this.aVr = true;
        this.aVH.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_TOP);
        this.aVH.n("c10569", "c10568", "c10567");
        return new a(this.aVH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, a aVar) {
        if (aVar.aVI == null) {
            return null;
        }
        TiebaStatic.log("c10570");
        if (this.aVr) {
            aVar.aVI.a(mVar);
            this.aVr = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cK(int i) {
        if (this.aVH != null) {
            this.aVH.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public w aVI;

        public a(w wVar) {
            super(wVar.getView());
            this.aVI = wVar;
        }
    }
}
