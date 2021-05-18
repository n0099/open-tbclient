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
import d.a.j0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15443a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15444b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15445c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f15446d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f15447e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15448f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f15449g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f15450h;

    /* renamed from: i  reason: collision with root package name */
    public View f15451i;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.f15443a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f15444b = barImageView;
        barImageView.setShowOval(true);
        this.f15444b.setShowOuterBorder(false);
        this.f15444b.setShowInnerBorder(true);
        this.f15444b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f15444b.setStrokeColorResId(R.color.CAM_X0401);
        this.f15445c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f15446d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f15447e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f15448f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f15448f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15448f.setRadius(R.dimen.tbds42);
        this.f15448f.setConrers(15);
        this.f15449g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f15450h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.f15451i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15450h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            this.f15447e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            return;
        }
        this.f15450h.setVisibility(8);
        this.f15447e.setVisibility(8);
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f15443a, R.color.CAM_X0205);
        c d2 = c.d(this.f15446d);
        d2.v(R.string.F_X01);
        d2.q(R.color.CAM_X0105);
        c d3 = c.d(this.f15447e);
        d3.v(R.string.F_X01);
        d3.q(R.color.CAM_X0109);
        c d4 = c.d(this.f15449g);
        d4.v(R.string.F_X01);
        d4.q(R.color.CAM_X0105);
        c d5 = c.d(this.f15450h);
        d5.v(R.string.F_X01);
        d5.q(R.color.CAM_X0109);
        this.f15445c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i2 != 4 && i2 != 1) {
            this.f15448f.setIsNight(false);
        } else {
            this.f15448f.setIsNight(true);
        }
        SkinManager.setBackgroundColor(this.f15451i, R.color.CAM_X0111);
    }

    public String d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
