package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.i0.b1.m.a;
import d.a.i0.r.u.c;
/* loaded from: classes4.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f16137a;

    /* renamed from: b  reason: collision with root package name */
    public View f16138b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f16139c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f16140d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16141e;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.f16137a = context;
        this.f16138b = view;
        b(view);
    }

    public final void b(View view) {
        this.f16139c = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.f16140d = tbRichTextView;
        tbRichTextView.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        a layoutStrategy = this.f16140d.getLayoutStrategy();
        layoutStrategy.o(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.f16140d.setLayoutStrategy(layoutStrategy);
        c();
    }

    public void c() {
        if (this.f16141e) {
            c d2 = c.d(this.f16139c);
            d2.v(R.string.F_X02);
            d2.q(R.color.CAM_X0301);
            this.f16140d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            return;
        }
        c d3 = c.d(this.f16139c);
        d3.v(R.string.F_X02);
        d3.q(R.color.CAM_X0105);
        this.f16140d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }

    public void d(boolean z) {
        this.f16141e = z;
        c();
    }
}
