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
import d.a.i0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f16128a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f16129b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f16130c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f16131d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f16132e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f16133f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f16134g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16135h;

    /* renamed from: i  reason: collision with root package name */
    public View f16136i;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.f16128a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f16129b = barImageView;
        barImageView.setShowOval(true);
        this.f16129b.setShowOuterBorder(false);
        this.f16129b.setShowInnerBorder(true);
        this.f16129b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f16129b.setStrokeColorResId(R.color.CAM_X0401);
        this.f16130c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f16131d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f16132e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f16133f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f16133f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16133f.setRadius(R.dimen.tbds42);
        this.f16133f.setConrers(15);
        this.f16134g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f16135h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.f16136i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f16135h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            this.f16132e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            return;
        }
        this.f16135h.setVisibility(8);
        this.f16132e.setVisibility(8);
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f16128a, R.color.CAM_X0205);
        c d2 = c.d(this.f16131d);
        d2.v(R.string.F_X01);
        d2.q(R.color.CAM_X0105);
        c d3 = c.d(this.f16132e);
        d3.v(R.string.F_X01);
        d3.q(R.color.CAM_X0109);
        c d4 = c.d(this.f16134g);
        d4.v(R.string.F_X01);
        d4.q(R.color.CAM_X0105);
        c d5 = c.d(this.f16135h);
        d5.v(R.string.F_X01);
        d5.q(R.color.CAM_X0109);
        this.f16130c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i2 != 4 && i2 != 1) {
            this.f16133f.setIsNight(false);
        } else {
            this.f16133f.setIsNight(true);
        }
        SkinManager.setBackgroundColor(this.f16136i, R.color.CAM_X0111);
    }

    public String d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
