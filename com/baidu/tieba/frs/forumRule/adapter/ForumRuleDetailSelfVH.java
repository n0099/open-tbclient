package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import d.a.c.e.p.l;
import d.a.j0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15457a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15458b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15459c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15460d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15461e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15462f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15463g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f15464h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f15465i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f15457a = view;
        b(view);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b(View view) {
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.f15458b = headImageView;
        headImageView.setRadius(R.dimen.tbds47);
        this.f15458b.setConrers(15);
        this.f15459c = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.f15460d = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.f15461e = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.f15462f = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.f15463g = (TextView) view.findViewById(R.id.forum_rules_revise);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.f15464h = tBSpecificationBtn;
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        EMTextView eMTextView = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.l = eMTextView;
        eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.f15465i = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.j = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.k = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void c(int i2) {
        if (i2 > 0) {
            SkinManager.setImageResource(this.f15461e, BitmapHelper.getGradeResourceIdInEnterForum(i2));
        }
    }

    public void d(String str) {
        if (this.k == null || this.f15465i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f15465i.setVisibility(8);
            return;
        }
        this.k.setText(str);
        this.f15465i.setVisibility(0);
    }

    public void e(int i2) {
        c d2 = c.d(this.f15459c);
        d2.v(R.string.F_X01);
        d2.q(R.color.CAM_X0105);
        c d3 = c.d(this.f15463g);
        d3.v(R.string.F_X01);
        d3.q(R.color.CAM_X0109);
        c d4 = c.d(this.l);
        d4.v(R.string.F_X01);
        d4.q(R.color.CAM_X0107);
        c.d(this.k).q(R.color.CAM_X0105);
        c d5 = c.d(this.j);
        d5.v(R.string.F_X02);
        d5.q(R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15462f, R.color.CAM_X0109);
        if (i2 != 1 && i2 != 4) {
            this.f15458b.setIsNight(false);
        } else {
            this.f15458b.setIsNight(true);
        }
        this.f15464h.setTextSize(R.dimen.T_X08);
    }

    public void f(int i2) {
        if (i2 == 1) {
            this.f15464h.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
        this.f15464h.setVisibility(0);
    }

    public void g(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15463g.setText(i(str));
        } else {
            this.f15463g.setVisibility(8);
        }
    }

    public void h(String str) {
        if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
            DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.m);
            int i2 = R.color.CAM_X0303;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i2, i2).build(), DrawableSelector.make().setShape(0).radius(this.m).defaultColor("#4D000000").build()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.f15460d.setBackgroundDrawable(layerDrawable);
            SkinManager.setViewTextColor(this.f15460d, R.color.CAM_X0101);
        }
    }

    public String i(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
