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
import d.b.c.e.p.l;
import d.b.i0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15936a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15937b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15938c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f15939d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f15940e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15941f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f15942g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f15943h;
    public View i;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.f15936a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f15937b = barImageView;
        barImageView.setShowOval(true);
        this.f15937b.setShowOuterBorder(false);
        this.f15937b.setShowInnerBorder(true);
        this.f15937b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f15937b.setStrokeColorResId(R.color.CAM_X0401);
        this.f15938c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f15939d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f15940e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f15941f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f15941f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15941f.setRadius(R.dimen.tbds42);
        this.f15941f.setConrers(15);
        this.f15942g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f15943h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15943h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            this.f15940e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            return;
        }
        this.f15943h.setVisibility(8);
        this.f15940e.setVisibility(8);
    }

    public void c(int i) {
        SkinManager.setBackgroundColor(this.f15936a, R.color.CAM_X0205);
        c d2 = c.d(this.f15939d);
        d2.v(R.string.F_X01);
        d2.q(R.color.CAM_X0105);
        c d3 = c.d(this.f15940e);
        d3.v(R.string.F_X01);
        d3.q(R.color.CAM_X0109);
        c d4 = c.d(this.f15942g);
        d4.v(R.string.F_X01);
        d4.q(R.color.CAM_X0105);
        c d5 = c.d(this.f15943h);
        d5.v(R.string.F_X01);
        d5.q(R.color.CAM_X0109);
        this.f15938c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i != 4 && i != 1) {
            this.f15941f.setIsNight(false);
        } else {
            this.f15941f.setIsNight(true);
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0111);
    }

    public String d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
