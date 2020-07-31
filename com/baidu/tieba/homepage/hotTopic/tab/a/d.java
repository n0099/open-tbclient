package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.hotTopic.tab.b.d, a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.iwY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public a b(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setPadding(l.getDimens(viewGroup.getContext(), R.dimen.tbds44), l.getDimens(viewGroup.getContext(), R.dimen.tbds27), l.getDimens(viewGroup.getContext(), R.dimen.tbds44), l.getDimens(viewGroup.getContext(), R.dimen.tbds27));
        textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.cp_cont_d));
        textView.setTextSize(0, l.getDimens(viewGroup.getContext(), R.dimen.tbds31));
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
        layoutParams.topMargin = l.getDimens(viewGroup.getContext(), R.dimen.tbds12);
        textView.setLayoutParams(layoutParams);
        a aVar = new a(textView);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.hotTopic.tab.b.d dVar, a aVar) {
        if (dVar == null || aVar == null) {
            return null;
        }
        aVar.a(dVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private TextView dJr;
        private int iwT;

        a(TextView textView) {
            super(textView);
            this.iwT = 3;
            this.dJr = textView;
        }

        void a(com.baidu.tieba.homepage.hotTopic.tab.b.d dVar) {
            if (dVar != null) {
                this.dJr.setText(dVar.getTitle());
            }
        }

        void onChangeSkinType(int i) {
            if (this.iwT != i) {
                ao.setBackgroundColor(this.dJr, R.color.cp_bg_line_g);
                ao.setViewTextColor(this.dJr, R.color.cp_cont_d);
                this.iwT = i;
            }
        }
    }
}
