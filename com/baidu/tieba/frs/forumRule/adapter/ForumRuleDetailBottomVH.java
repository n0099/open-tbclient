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
import d.a.c.e.p.l;
import d.a.m0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15346a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15347b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15348c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f15349d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f15350e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15351f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f15352g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f15353h;

    /* renamed from: i  reason: collision with root package name */
    public View f15354i;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.f15346a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f15347b = barImageView;
        barImageView.setShowOval(true);
        this.f15347b.setShowOuterBorder(false);
        this.f15347b.setShowInnerBorder(true);
        this.f15347b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f15347b.setStrokeColorResId(R.color.CAM_X0401);
        this.f15348c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f15349d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f15350e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f15351f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f15351f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15351f.setRadius(R.dimen.tbds42);
        this.f15351f.setConrers(15);
        this.f15352g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f15353h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.f15354i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15353h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            this.f15350e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            return;
        }
        this.f15353h.setVisibility(8);
        this.f15350e.setVisibility(8);
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f15346a, R.color.CAM_X0205);
        c d2 = c.d(this.f15349d);
        d2.x(R.string.F_X01);
        d2.s(R.color.CAM_X0105);
        c d3 = c.d(this.f15350e);
        d3.x(R.string.F_X01);
        d3.s(R.color.CAM_X0109);
        c d4 = c.d(this.f15352g);
        d4.x(R.string.F_X01);
        d4.s(R.color.CAM_X0105);
        c d5 = c.d(this.f15353h);
        d5.x(R.string.F_X01);
        d5.s(R.color.CAM_X0109);
        this.f15348c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i2 != 4 && i2 != 1) {
            this.f15351f.setIsNight(false);
        } else {
            this.f15351f.setIsNight(true);
        }
        SkinManager.setBackgroundColor(this.f15354i, R.color.CAM_X0111);
    }

    public String d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
