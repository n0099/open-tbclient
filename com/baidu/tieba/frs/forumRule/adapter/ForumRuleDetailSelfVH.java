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
import d.a.m0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15360a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15361b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15362c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15363d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15364e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15365f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15366g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f15367h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f15368i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f15360a = view;
        b(view);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b(View view) {
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.f15361b = headImageView;
        headImageView.setRadius(R.dimen.tbds47);
        this.f15361b.setConrers(15);
        this.f15362c = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.f15363d = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.f15364e = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.f15365f = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.f15366g = (TextView) view.findViewById(R.id.forum_rules_revise);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.f15367h = tBSpecificationBtn;
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        EMTextView eMTextView = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.l = eMTextView;
        eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.f15368i = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.j = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.k = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void c(int i2) {
        if (i2 > 0) {
            SkinManager.setImageResource(this.f15364e, BitmapHelper.getGradeResourceIdInEnterForum(i2));
        }
    }

    public void d(String str) {
        if (this.k == null || this.f15368i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f15368i.setVisibility(8);
            return;
        }
        this.k.setText(str);
        this.f15368i.setVisibility(0);
    }

    public void e(int i2) {
        c d2 = c.d(this.f15362c);
        d2.x(R.string.F_X01);
        d2.s(R.color.CAM_X0105);
        c d3 = c.d(this.f15366g);
        d3.x(R.string.F_X01);
        d3.s(R.color.CAM_X0109);
        c d4 = c.d(this.l);
        d4.x(R.string.F_X01);
        d4.s(R.color.CAM_X0107);
        c.d(this.k).s(R.color.CAM_X0105);
        c d5 = c.d(this.j);
        d5.x(R.string.F_X02);
        d5.s(R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15365f, R.color.CAM_X0109);
        if (i2 != 1 && i2 != 4) {
            this.f15361b.setIsNight(false);
        } else {
            this.f15361b.setIsNight(true);
        }
        this.f15367h.setTextSize(R.dimen.T_X08);
    }

    public void f(int i2) {
        if (i2 == 1) {
            this.f15367h.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
        this.f15367h.setVisibility(0);
    }

    public void g(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15366g.setText(i(str));
        } else {
            this.f15366g.setVisibility(8);
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
            this.f15363d.setBackgroundDrawable(layerDrawable);
            SkinManager.setViewTextColor(this.f15363d, R.color.CAM_X0101);
        }
    }

    public String i(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
