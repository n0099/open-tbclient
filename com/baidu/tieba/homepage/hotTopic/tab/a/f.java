package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.graphics.Typeface;
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
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.hotTopic.tab.b.f, a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.hotTopic.tab.b.a.iwZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public a b(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setPadding(l.getDimens(viewGroup.getContext(), R.dimen.tbds44), l.getDimens(viewGroup.getContext(), R.dimen.tbds54), l.getDimens(viewGroup.getContext(), R.dimen.tbds44), l.getDimens(viewGroup.getContext(), R.dimen.tbds18));
        textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.cp_cont_b));
        textView.setTextSize(0, l.getDimens(viewGroup.getContext(), R.dimen.tbds44));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(textView);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.hotTopic.tab.b.f fVar, a aVar) {
        if (fVar == null || aVar == null) {
            return null;
        }
        aVar.a(fVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private TextView dJr;
        private int iwV;

        a(TextView textView) {
            super(textView);
            this.iwV = 3;
            this.dJr = textView;
        }

        void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
            if (fVar != null) {
                this.dJr.setText(fVar.getTitle());
            }
        }

        void onChangeSkinType(int i) {
            if (this.iwV != i) {
                ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
                this.iwV = i;
            }
        }
    }
}
