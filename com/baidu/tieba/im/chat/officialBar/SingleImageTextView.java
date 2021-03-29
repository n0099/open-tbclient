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
import d.b.b.e.p.l;
import d.b.h0.b1.m.f;
import d.b.i0.d1.g.d;
import d.b.i0.d1.l.c.a;
import d.b.i0.t3.i;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17888e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17889f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17890g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f17891h;
    public View i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public d.b.b.e.h.b m;
    public int n;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b extends f {
        public final /* synthetic */ a.C1203a l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, String str, a.C1203a c1203a) {
            super(i, str);
            this.l = c1203a;
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(SingleImageTextView.this.f17888e, SingleImageTextView.this.g(this.l.f53910d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1203a f17893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17895g;

        public c(a.C1203a c1203a, TbPageContext tbPageContext, int i) {
            this.f17893e = c1203a;
            this.f17894f = tbPageContext;
            this.f17895g = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:75:0x0240  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            String str2;
            int i;
            String str3;
            a.C1203a c1203a = this.f17893e;
            if (c1203a != null && (str3 = c1203a.f53910d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                try {
                    SingleImageTextView.this.f17888e.startActivity(Intent.parseUri(this.f17893e.f53910d, 1));
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
            UrlManager.getInstance().dealOneLink(this.f17894f, new String[]{this.f17893e.f53910d});
            String str4 = this.f17893e.f53910d;
            if (str4 != null && str4.contains("ForumGradePage")) {
                StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                try {
                    Uri parse = Uri.parse(this.f17893e.f53910d);
                    String queryParameter = parse.getQueryParameter("forum_id");
                    String queryParameter2 = parse.getQueryParameter("obj_type");
                    param.param("fid", queryParameter);
                    param.param("obj_type", queryParameter2);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                TiebaStatic.log(param);
            }
            String str5 = this.f17893e.f53910d;
            if (str5 != null && str5.contains("weeklygodview")) {
                TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
            }
            String str6 = this.f17893e.f53910d;
            if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
            if (this.f17895g == 1) {
                TiebaStatic.eventStat(SingleImageTextView.this.f17888e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17893e.f53911e);
                d j = d.b.i0.d1.w.c.j(this.f17893e.f53912f);
                if (j != null) {
                    TiebaStatic.eventStat(SingleImageTextView.this.f17888e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53771a, "task_id", j.f53772b, "loc", "0");
                    int i2 = this.f17893e.f53913g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f53772b)) {
                        d.b.i0.d1.u.a.c().a(j.f53772b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17893e.f53914h / 100);
                statisticItem.param("official_id", this.f17893e.i);
                statisticItem.param("official_type", this.f17893e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17893e.k);
                statisticItem.param("obj_params1", this.f17893e.f53910d);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("service_id", this.f17893e.l);
            statisticItem2.param("task_id", this.f17893e.k);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("fid", this.f17893e.f53911e);
            if (!TextUtils.isEmpty(this.f17893e.f53907a)) {
                if (!TextUtils.isEmpty(this.f17893e.f53910d)) {
                    String str7 = null;
                    String[] split = this.f17893e.f53910d.split("tid=");
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
                if (this.f17893e.f53907a.contains("互动量")) {
                    statisticItem2.param("obj_source", 2);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17893e.f53907a.contains("被加精")) {
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17893e.f53907a.contains("热贴榜")) {
                    statisticItem2.param("obj_type", 8);
                } else {
                    int i3 = this.f17893e.f53913g;
                    if (i3 == 4) {
                        statisticItem2.param("obj_type", 10);
                    } else if (i3 == 3) {
                        statisticItem2.param("obj_type", 5);
                        str = this.f17893e.i;
                        if (str != null && str.equals("4754917018")) {
                            statisticItem2.delete("obj_type");
                            statisticItem2.param("obj_type", 9);
                            str2 = this.f17893e.f53910d;
                            if (str2 != null) {
                                if (str2.contains("type=interaction")) {
                                    i = 2;
                                } else if (this.f17893e.f53910d.contains("type=recommend")) {
                                    i = 3;
                                } else if (this.f17893e.f53910d.contains("type=attention-bazhu")) {
                                    i = 4;
                                } else {
                                    i = this.f17893e.f53910d.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i != -1) {
                                    statisticItem2.delete("obj_source");
                                    statisticItem2.param("obj_source", i);
                                }
                            }
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
            str = this.f17893e.i;
            if (str != null) {
                statisticItem2.delete("obj_type");
                statisticItem2.param("obj_type", 9);
                str2 = this.f17893e.f53910d;
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
        LayoutInflater.from(this.f17888e).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.f17889f = (TextView) findViewById(R.id.single_title);
        this.f17890g = (TextView) findViewById(R.id.single_abstract);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.single_content_pic);
        this.f17891h = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17891h.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f17891h.setConrers(15);
        this.j = (TextView) findViewById(R.id.read_all);
        this.k = (ImageView) findViewById(R.id.arrow);
        this.i = findViewById(R.id.single_divider);
        this.l = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new a());
        int dimension = (int) this.f17888e.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.f17888e.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void f(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17891h.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17889f, R.color.CAM_X0105, 1, skinType);
        SkinManager.setViewTextColor(this.f17890g, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, skinType);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.l, R.color.common_color_10067, 1, skinType);
        SkinManager.setBackgroundResource(this.i, R.drawable.multi_single_divider_selector, skinType);
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
        this.f17889f.setText("");
        this.f17890g.setText("");
        this.f17891h.setBackgroundDrawable(null);
        this.f17891h.setImageDrawable(null);
        this.l.setText("");
        this.l.setVisibility(8);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1203a c1203a, View view, int i) {
        if (c1203a == null) {
            return;
        }
        this.f17889f.setText(!TextUtils.isEmpty(c1203a.f53907a) ? c1203a.f53907a : "");
        String str = TextUtils.isEmpty(c1203a.f53908b) ? "" : c1203a.f53908b;
        if (!TextUtils.isEmpty(c1203a.f53908b) && c1203a.f53908b.contains(this.f17888e.getResources().getString(R.string.inconformity_forum_rules))) {
            b bVar = new b(2, c1203a.f53910d, c1203a);
            int indexOf = c1203a.f53908b.indexOf(this.f17888e.getResources().getString(R.string.inconformity_forum_rules));
            SpannableString spannableString = new SpannableString(c1203a.f53908b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f17890g.setOnTouchListener(new i(spannableString));
            this.f17890g.setText(spannableString);
            this.j.setText(R.string.bar_tie_complain);
        } else {
            this.f17890g.setText(str);
        }
        if (!TextUtils.isEmpty(c1203a.f53910d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1203a.f53910d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(c1203a, tbPageContext, i));
        }
        if (!TextUtils.isEmpty(c1203a.f53909c)) {
            this.f17891h.setTag(c1203a.f53909c);
            this.f17891h.W(c1203a.f53909c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f17890g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f17890g.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnItemViewLongClickListener(d.b.b.e.h.b bVar) {
        this.m = bVar;
    }

    public void setPosition(int i) {
        this.n = i;
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

    public SingleImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = null;
        this.f17888e = context;
        e();
    }
}
