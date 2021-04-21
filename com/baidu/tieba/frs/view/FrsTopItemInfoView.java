package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.SerializableItemInfo;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import d.b.i0.r.u.c;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes4.dex */
public class FrsTopItemInfoView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f16431e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16432f;

    /* renamed from: g  reason: collision with root package name */
    public View f16433g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16434h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public ItemTableView l;
    public TextView m;
    public RelativeLayout n;
    public HeadImageView o;
    public TextView p;
    public RankStarView q;
    public ImageView r;
    public View s;
    public ItemInfo t;
    public double u;
    public double v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public static final String y = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    public static final String z = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    public static final int A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    public static final int B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    public static final int C = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    public static final int D = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ViewHelper.checkUpIsLogin(FrsTopItemInfoView.this.f16431e) || WriteActivityConfig.isAsyncWriting() || FrsTopItemInfoView.this.t == null) {
                return;
            }
            WriteActivityConfig.newInstance((Activity) FrsTopItemInfoView.this.f16431e).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.t)).setItemIsSchool(FrsTopItemInfoView.this.t.is_school.intValue() == 1).setStarCount(FrsTopItemInfoView.this.t.score != null ? FrsTopItemInfoView.this.t.score.comment_star.intValue() : 0).send();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.r.s.a f16437e;

            public a(b bVar, d.b.i0.r.s.a aVar) {
                this.f16437e = aVar;
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                this.f16437e.dismiss();
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsTopItemInfoView.this.f16431e instanceof FrsActivity) {
                d.b.i0.r.s.a aVar = new d.b.i0.r.s.a((FrsActivity) FrsTopItemInfoView.this.f16431e);
                aVar.setMessage(FrsTopItemInfoView.this.f16431e.getString(R.string.comment_tab_dialog_info));
                aVar.setPositiveButton(R.string.comment_tab_dialog_botton_text, new a(this, aVar));
                aVar.create(((FrsActivity) FrsTopItemInfoView.this.f16431e).getPageContext()).show();
            }
        }
    }

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public final SpannableStringBuilder c(double d2) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", z, Double.valueOf(d2), y));
    }

    public final void d(Context context) {
        this.f16431e = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.f16432f = (TextView) findViewById(R.id.item_title_name);
        this.f16433g = findViewById(R.id.item_split);
        this.f16434h = (TextView) findViewById(R.id.item_title_value);
        ImageView imageView = (ImageView) findViewById(R.id.icon_question);
        this.i = imageView;
        imageView.setOnClickListener(this.x);
        this.j = (TextView) findViewById(R.id.big_score);
        this.k = (TextView) findViewById(R.id.people_num);
        this.l = (ItemTableView) findViewById(R.id.item_table);
        this.m = (TextView) findViewById(R.id.time_score);
        this.n = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.o = (HeadImageView) findViewById(R.id.user_head);
        this.p = (TextView) findViewById(R.id.click_tip);
        this.q = (RankStarView) findViewById(R.id.star_view);
        this.r = (ImageView) findViewById(R.id.right_arrow);
        this.s = findViewById(R.id.bottom_line);
        this.f16432f.setText(R.string.frs_evaluate_item_title);
        this.p.setText(R.string.frs_evaluate_click_tip);
        this.j.setText(R.string.frs_evaluate_exception);
        if (DeviceInfoUtil.isXiaoMi()) {
            this.j.setPadding(0, -A, 0, 0);
        }
        this.o.setPlaceHolder(1);
        this.q.setStarSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.n.setOnClickListener(this.w);
    }

    public void e() {
        c d2 = c.d(this);
        d2.k(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        c d3 = c.d(this.f16432f);
        d3.v(R.string.F_X02);
        d3.q(R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f16433g, R.color.CAM_X0109);
        c d4 = c.d(this.f16434h);
        d4.v(R.string.F_X02);
        d4.q(R.color.CAM_X0105);
        c d5 = c.d(this.j);
        d5.v(R.string.F_X02);
        d5.q(R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
        c d6 = c.d(this.m);
        d6.q(R.color.CAM_X0109);
        d6.v(R.string.F_X01);
        c d7 = c.d(this.p);
        d7.v(R.string.F_X01);
        d7.q(R.color.CAM_X0105);
        this.l.d();
        this.q.f();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0210);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setData(ItemInfo itemInfo) {
        this.t = itemInfo;
        if (itemInfo == null || itemInfo.score == null) {
            return;
        }
        this.f16434h.setText(itemInfo.name);
        ItemTable itemTable = itemInfo.score;
        int intValue = itemTable.total_point_num.intValue();
        List<ItemPoint> list = itemTable.item_point;
        if (list != null) {
            for (ItemPoint itemPoint : list) {
                if (itemPoint != null) {
                    if ("all".equals(itemPoint.time_intval)) {
                        this.u = itemPoint.point.doubleValue();
                    } else if ("days".equals(itemPoint.time_intval)) {
                        this.v = itemPoint.point.doubleValue();
                    }
                }
            }
        }
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (currentPortrait != null) {
            this.o.W(currentPortrait, 12, false);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.k.getLayoutParams();
        double d2 = this.u;
        if (d2 > 0.0d && d2 <= 10.0d) {
            this.j.setText(String.valueOf(d2));
            this.k.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.q.setStarCount(itemTable.comment_star.intValue());
            }
            this.f16433g.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setText(c(this.v), TextView.BufferType.SPANNABLE);
            this.l.setData(itemTable.item_plot, intValue);
            return;
        }
        this.j.setText(R.string.frs_evaluate_exception);
        this.j.setTextSize(0, D);
        layoutParams.topMargin = C;
        layoutParams.height = D;
        this.j.setLayoutParams(layoutParams);
        layoutParams2.topMargin = B;
        this.k.setGravity(17);
        this.k.setLayoutParams(layoutParams2);
        this.k.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
        this.q.setStarCount(0.0f);
        this.m.setVisibility(8);
        this.f16433g.setVisibility(8);
        this.l.a();
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = new a();
        this.x = new b();
        d(context);
    }
}
