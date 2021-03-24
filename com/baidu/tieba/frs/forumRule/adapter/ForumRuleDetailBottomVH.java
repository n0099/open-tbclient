package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f16266a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f16267b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f16268c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f16269d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f16270e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f16271f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f16272g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16273h;
    public View i;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.f16266a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f16267b = barImageView;
        barImageView.setShowOval(true);
        this.f16267b.setShowOuterBorder(false);
        this.f16267b.setShowInnerBorder(true);
        this.f16267b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f16267b.setStrokeColorResId(R.color.CAM_X0401);
        this.f16268c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f16269d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f16270e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f16271f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f16271f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16271f.setRadius(R.dimen.tbds42);
        this.f16271f.setConrers(15);
        this.f16272g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f16273h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f16273h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            this.f16270e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            return;
        }
        this.f16273h.setVisibility(8);
        this.f16270e.setVisibility(8);
    }

    public void c(int i) {
        SkinManager.setBackgroundColor(this.f16266a, R.color.CAM_X0205);
        c a2 = c.a(this.f16269d);
        a2.s(R.string.F_X01);
        a2.n(R.color.CAM_X0105);
        c a3 = c.a(this.f16270e);
        a3.s(R.string.F_X01);
        a3.n(R.color.CAM_X0109);
        c a4 = c.a(this.f16272g);
        a4.s(R.string.F_X01);
        a4.n(R.color.CAM_X0105);
        c a5 = c.a(this.f16273h);
        a5.s(R.string.F_X01);
        a5.n(R.color.CAM_X0109);
        this.f16268c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i != 4 && i != 1) {
            this.f16271f.setIsNight(false);
        } else {
            this.f16271f.setIsNight(true);
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0111);
    }

    public String d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
