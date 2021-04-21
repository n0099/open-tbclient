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
import d.b.c.e.p.l;
import d.b.i0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15949a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15950b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15951c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15952d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15953e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15954f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15955g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f15956h;
    public LinearLayout i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f15949a = view;
        b(view);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b(View view) {
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.f15950b = headImageView;
        headImageView.setRadius(R.dimen.tbds47);
        this.f15950b.setConrers(15);
        this.f15951c = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.f15952d = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.f15953e = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.f15954f = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.f15955g = (TextView) view.findViewById(R.id.forum_rules_revise);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.f15956h = tBSpecificationBtn;
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
        EMTextView eMTextView = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
        this.l = eMTextView;
        eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
        this.i = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
        this.j = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
        this.k = (EMTextView) view.findViewById(R.id.forum_rules_preface);
    }

    public void c(int i) {
        if (i > 0) {
            SkinManager.setImageResource(this.f15953e, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void d(String str) {
        if (this.k == null || this.i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.i.setVisibility(8);
            return;
        }
        this.k.setText(str);
        this.i.setVisibility(0);
    }

    public void e(int i) {
        c d2 = c.d(this.f15951c);
        d2.v(R.string.F_X01);
        d2.q(R.color.CAM_X0105);
        c d3 = c.d(this.f15955g);
        d3.v(R.string.F_X01);
        d3.q(R.color.CAM_X0109);
        c d4 = c.d(this.l);
        d4.v(R.string.F_X01);
        d4.q(R.color.CAM_X0107);
        c.d(this.k).q(R.color.CAM_X0105);
        c d5 = c.d(this.j);
        d5.v(R.string.F_X02);
        d5.q(R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15954f, R.color.CAM_X0109);
        if (i != 1 && i != 4) {
            this.f15950b.setIsNight(false);
        } else {
            this.f15950b.setIsNight(true);
        }
        this.f15956h.setTextSize(R.dimen.T_X08);
    }

    public void f(int i) {
        if (i == 1) {
            this.f15956h.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
        this.f15956h.setVisibility(0);
    }

    public void g(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f15955g.setText(i(str));
        } else {
            this.f15955g.setVisibility(8);
        }
    }

    public void h(String str) {
        if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
            DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.m);
            int i = R.color.CAM_X0303;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i, i).build(), DrawableSelector.make().setShape(0).radius(this.m).defaultColor("#4D000000").build()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.f15952d.setBackgroundDrawable(layerDrawable);
            SkinManager.setViewTextColor(this.f15952d, R.color.CAM_X0101);
        }
    }

    public String i(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
