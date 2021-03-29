package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.b.h0.b1.m.a;
import d.b.h0.r.u.c;
/* loaded from: classes4.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f16275a;

    /* renamed from: b  reason: collision with root package name */
    public View f16276b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f16277c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f16278d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16279e;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.f16275a = context;
        this.f16276b = view;
        b(view);
    }

    public final void b(View view) {
        this.f16277c = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.f16278d = tbRichTextView;
        tbRichTextView.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        a layoutStrategy = this.f16278d.getLayoutStrategy();
        layoutStrategy.o(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.f16278d.setLayoutStrategy(layoutStrategy);
        c();
    }

    public void c() {
        if (this.f16279e) {
            c a2 = c.a(this.f16277c);
            a2.s(R.string.F_X02);
            a2.n(R.color.CAM_X0301);
            this.f16278d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            return;
        }
        c a3 = c.a(this.f16277c);
        a3.s(R.string.F_X02);
        a3.n(R.color.CAM_X0105);
        this.f16278d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }

    public void d(boolean z) {
        this.f16279e = z;
        c();
    }
}
