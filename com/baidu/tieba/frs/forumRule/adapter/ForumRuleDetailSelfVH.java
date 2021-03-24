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
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f16279a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f16280b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16281c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16282d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16283e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16284f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16285g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f16286h;
    public LinearLayout i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    public ForumRuleDetailSelfVH(View view) {
        super(view);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f16279a = view;
        b(view);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b(View view) {
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
        this.f16280b = headImageView;
        headImageView.setRadius(R.dimen.tbds47);
        this.f16280b.setConrers(15);
        this.f16281c = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
        this.f16282d = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
        this.f16283e = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
        this.f16284f = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
        this.f16285g = (TextView) view.findViewById(R.id.forum_rules_revise);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
        this.f16286h = tBSpecificationBtn;
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
            SkinManager.setImageResource(this.f16283e, BitmapHelper.getGradeResourceIdInEnterForum(i));
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
        c a2 = c.a(this.f16281c);
        a2.s(R.string.F_X01);
        a2.n(R.color.CAM_X0105);
        c a3 = c.a(this.f16285g);
        a3.s(R.string.F_X01);
        a3.n(R.color.CAM_X0109);
        c a4 = c.a(this.l);
        a4.s(R.string.F_X01);
        a4.n(R.color.CAM_X0107);
        c.a(this.k).n(R.color.CAM_X0105);
        c a5 = c.a(this.j);
        a5.s(R.string.F_X02);
        a5.n(R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f16284f, R.color.CAM_X0109);
        if (i != 1 && i != 4) {
            this.f16280b.setIsNight(false);
        } else {
            this.f16280b.setIsNight(true);
        }
        this.f16286h.setTextSize(R.dimen.T_X08);
    }

    public void f(int i) {
        if (i == 1) {
            this.f16286h.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
        this.f16286h.setVisibility(0);
    }

    public void g(String str) {
        if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
            this.f16285g.setText(i(str));
        } else {
            this.f16285g.setVisibility(8);
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
            this.f16282d.setBackgroundDrawable(layerDrawable);
            SkinManager.setViewTextColor(this.f16282d, R.color.CAM_X0101);
        }
    }

    public String i(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
