package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import d.a.c.e.p.l;
import d.a.i0.b1.m.f;
import d.a.j0.e1.g.d;
import d.a.j0.e1.l.c.a;
import d.a.j0.u3.i;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public class SingleImageTextView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17891e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17892f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17893g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f17894h;

    /* renamed from: i  reason: collision with root package name */
    public View f17895i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public d.a.c.e.h.b m;
    public int n;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (SingleImageTextView.this.m != null) {
                SingleImageTextView.this.m.onItemViewLongClick(view, 9, SingleImageTextView.this.n, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f {
        public final /* synthetic */ a.C1228a l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, String str, a.C1228a c1228a) {
            super(i2, str);
            this.l = c1228a;
        }

        @Override // d.a.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(SingleImageTextView.this.f17891e, SingleImageTextView.this.g(this.l.f53713d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
        }

        @Override // d.a.i0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1228a f17897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17899g;

        public c(a.C1228a c1228a, TbPageContext tbPageContext, int i2) {
            this.f17897e = c1228a;
            this.f17898f = tbPageContext;
            this.f17899g = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:75:0x0244  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            String str2;
            int i2;
            String str3;
            a.C1228a c1228a = this.f17897e;
            if (c1228a != null && (str3 = c1228a.f53713d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                try {
                    SingleImageTextView.this.f17891e.startActivity(Intent.parseUri(this.f17897e.f53713d, 1));
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
            UrlManager.getInstance().dealOneLink(this.f17898f, new String[]{this.f17897e.f53713d});
            String str4 = this.f17897e.f53713d;
            if (str4 != null && str4.contains("ForumGradePage")) {
                StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                try {
                    Uri parse = Uri.parse(this.f17897e.f53713d);
                    String queryParameter = parse.getQueryParameter("forum_id");
                    String queryParameter2 = parse.getQueryParameter("obj_type");
                    param.param("fid", queryParameter);
                    param.param("obj_type", queryParameter2);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                TiebaStatic.log(param);
            }
            String str5 = this.f17897e.f53713d;
            if (str5 != null && str5.contains("weeklygodview")) {
                TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
            }
            String str6 = this.f17897e.f53713d;
            if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
            if (this.f17899g == 1) {
                TiebaStatic.eventStat(SingleImageTextView.this.f17891e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17897e.f53714e);
                d j = d.a.j0.e1.w.c.j(this.f17897e.f53715f);
                if (j != null) {
                    TiebaStatic.eventStat(SingleImageTextView.this.f17891e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53569a, "task_id", j.f53570b, "loc", "0");
                    int i3 = this.f17897e.f53716g;
                    if ((i3 == 1 || i3 == 3) && !"0".equals(j.f53570b)) {
                        d.a.j0.e1.u.a.c().a(j.f53570b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17897e.f53717h / 100);
                statisticItem.param("official_id", this.f17897e.f53718i);
                statisticItem.param("official_type", this.f17897e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17897e.k);
                statisticItem.param("obj_params1", this.f17897e.f53713d);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("service_id", this.f17897e.l);
            statisticItem2.param("task_id", this.f17897e.k);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("fid", this.f17897e.f53714e);
            if (!TextUtils.isEmpty(this.f17897e.f53710a)) {
                if (!TextUtils.isEmpty(this.f17897e.f53713d)) {
                    String str7 = null;
                    String[] split = this.f17897e.f53713d.split("tid=");
                    if (split.length > 1) {
                        int indexOf = split[1].indexOf("&");
                        if (indexOf != -1) {
                            str7 = split[1].substring(0, indexOf);
                        } else {
                            str7 = split[1].substring(0);
                        }
                    }
                    statisticItem2.param("tid", str7);
                }
                if (this.f17897e.f53710a.contains("互动量")) {
                    statisticItem2.param("obj_source", 2);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17897e.f53710a.contains("被加精")) {
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17897e.f53710a.contains("热贴榜")) {
                    statisticItem2.param("obj_type", 8);
                } else {
                    int i4 = this.f17897e.f53716g;
                    if (i4 == 4) {
                        statisticItem2.param("obj_type", 10);
                    } else if (i4 == 3) {
                        statisticItem2.param("obj_type", 5);
                        str = this.f17897e.f53718i;
                        if (str != null && str.equals("4754917018")) {
                            statisticItem2.delete("obj_type");
                            statisticItem2.param("obj_type", 9);
                            str2 = this.f17897e.f53713d;
                            if (str2 != null) {
                                if (str2.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (this.f17897e.f53713d.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (this.f17897e.f53713d.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = this.f17897e.f53713d.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    statisticItem2.delete("obj_source");
                                    statisticItem2.param("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
            str = this.f17897e.f53718i;
            if (str != null) {
                statisticItem2.delete("obj_type");
                statisticItem2.param("obj_type", 9);
                str2 = this.f17897e.f53713d;
                if (str2 != null) {
                }
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    public SingleImageTextView(Context context) {
        this(context, null);
    }

    public final void e() {
        LayoutInflater.from(this.f17891e).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.f17892f = (TextView) findViewById(R.id.single_title);
        this.f17893g = (TextView) findViewById(R.id.single_abstract);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.single_content_pic);
        this.f17894h = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17894h.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f17894h.setConrers(15);
        this.j = (TextView) findViewById(R.id.read_all);
        this.k = (ImageView) findViewById(R.id.arrow);
        this.f17895i = findViewById(R.id.single_divider);
        this.l = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new a());
        int dimension = (int) this.f17891e.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.f17891e.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void f(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17894h.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17892f, R.color.CAM_X0105, 1, skinType);
        SkinManager.setViewTextColor(this.f17893g, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, skinType);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.l, R.color.common_color_10067, 1, skinType);
        SkinManager.setBackgroundResource(this.f17895i, R.drawable.multi_single_divider_selector, skinType);
    }

    public final String g(String str) {
        try {
            return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void h() {
        this.f17892f.setText("");
        this.f17893g.setText("");
        this.f17894h.setBackgroundDrawable(null);
        this.f17894h.setImageDrawable(null);
        this.l.setText("");
        this.l.setVisibility(8);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1228a c1228a, View view, int i2) {
        if (c1228a == null) {
            return;
        }
        this.f17892f.setText(!TextUtils.isEmpty(c1228a.f53710a) ? c1228a.f53710a : "");
        String str = TextUtils.isEmpty(c1228a.f53711b) ? "" : c1228a.f53711b;
        if (!TextUtils.isEmpty(c1228a.f53711b) && c1228a.f53711b.contains(this.f17891e.getResources().getString(R.string.inconformity_forum_rules))) {
            b bVar = new b(2, c1228a.f53713d, c1228a);
            int indexOf = c1228a.f53711b.indexOf(this.f17891e.getResources().getString(R.string.inconformity_forum_rules));
            SpannableString spannableString = new SpannableString(c1228a.f53711b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f17893g.setOnTouchListener(new i(spannableString));
            this.f17893g.setText(spannableString);
            this.j.setText(R.string.bar_tie_complain);
        } else {
            this.f17893g.setText(str);
        }
        if (!TextUtils.isEmpty(c1228a.f53713d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1228a.f53713d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(c1228a, tbPageContext, i2));
        }
        if (!TextUtils.isEmpty(c1228a.f53712c)) {
            this.f17894h.setTag(c1228a.f53712c);
            this.f17894h.V(c1228a.f53712c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f17893g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f17893g.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.m = bVar;
    }

    public void setPosition(int i2) {
        this.n = i2;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l.setVisibility(8);
            this.l.setText("");
            return;
        }
        this.l.setVisibility(0);
        this.l.setText(str);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = null;
        this.f17891e = context;
        e();
    }
}
