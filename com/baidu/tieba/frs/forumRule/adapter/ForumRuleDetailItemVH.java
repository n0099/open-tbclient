package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.n0.b1.m.a;
import d.a.n0.r.u.c;
/* loaded from: classes4.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f15499a;

    /* renamed from: b  reason: collision with root package name */
    public View f15500b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f15501c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f15502d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15503e;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.f15499a = context;
        this.f15500b = view;
        b(view);
    }

    public final void b(View view) {
        this.f15501c = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.f15502d = tbRichTextView;
        tbRichTextView.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        a layoutStrategy = this.f15502d.getLayoutStrategy();
        layoutStrategy.o(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.f15502d.setLayoutStrategy(layoutStrategy);
        c();
    }

    public void c() {
        if (this.f15503e) {
            c d2 = c.d(this.f15501c);
            d2.x(R.string.F_X02);
            d2.s(R.color.CAM_X0301);
            this.f15502d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            return;
        }
        c d3 = c.d(this.f15501c);
        d3.x(R.string.F_X02);
        d3.s(R.color.CAM_X0105);
        this.f15502d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }

    public void d(boolean z) {
        this.f15503e = z;
        c();
    }
}
