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
import d.a.n0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15490a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15491b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15492c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f15493d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f15494e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15495f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f15496g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f15497h;

    /* renamed from: i  reason: collision with root package name */
    public View f15498i;

    public ForumRuleDetailBottomVH(View view) {
        super(view);
        this.f15490a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f15491b = barImageView;
        barImageView.setShowOval(true);
        this.f15491b.setShowOuterBorder(false);
        this.f15491b.setShowInnerBorder(true);
        this.f15491b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f15491b.setStrokeColorResId(R.color.CAM_X0401);
        this.f15492c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f15493d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f15494e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f15495f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f15495f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15495f.setRadius(R.dimen.tbds42);
        this.f15495f.setConrers(15);
        this.f15496g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f15497h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.f15498i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15497h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            this.f15494e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
            return;
        }
        this.f15497h.setVisibility(8);
        this.f15494e.setVisibility(8);
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f15490a, R.color.CAM_X0205);
        c d2 = c.d(this.f15493d);
        d2.x(R.string.F_X01);
        d2.s(R.color.CAM_X0105);
        c d3 = c.d(this.f15494e);
        d3.x(R.string.F_X01);
        d3.s(R.color.CAM_X0109);
        c d4 = c.d(this.f15496g);
        d4.x(R.string.F_X01);
        d4.s(R.color.CAM_X0105);
        c d5 = c.d(this.f15497h);
        d5.x(R.string.F_X01);
        d5.s(R.color.CAM_X0109);
        this.f15492c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
        if (i2 != 4 && i2 != 1) {
            this.f15495f.setIsNight(false);
        } else {
            this.f15495f.setIsNight(true);
        }
        SkinManager.setBackgroundColor(this.f15498i, R.color.CAM_X0111);
    }

    public String d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
