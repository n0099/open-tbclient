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
import d.a.j0.b1.m.f;
import d.a.k0.e1.g.d;
import d.a.k0.e1.l.c.a;
import d.a.k0.u3.i;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public class SingleImageTextView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17206e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17207f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17208g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f17209h;

    /* renamed from: i  reason: collision with root package name */
    public View f17210i;
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
        public final /* synthetic */ a.C1300a l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, String str, a.C1300a c1300a) {
            super(i2, str);
            this.l = c1300a;
        }

        @Override // d.a.j0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(SingleImageTextView.this.f17206e, SingleImageTextView.this.g(this.l.f54420d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
        }

        @Override // d.a.j0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1300a f17212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17213f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17214g;

        public c(a.C1300a c1300a, TbPageContext tbPageContext, int i2) {
            this.f17212e = c1300a;
            this.f17213f = tbPageContext;
            this.f17214g = i2;
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
            a.C1300a c1300a = this.f17212e;
            if (c1300a != null && (str3 = c1300a.f54420d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                try {
                    SingleImageTextView.this.f17206e.startActivity(Intent.parseUri(this.f17212e.f54420d, 1));
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
            UrlManager.getInstance().dealOneLink(this.f17213f, new String[]{this.f17212e.f54420d});
            String str4 = this.f17212e.f54420d;
            if (str4 != null && str4.contains("ForumGradePage")) {
                StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                try {
                    Uri parse = Uri.parse(this.f17212e.f54420d);
                    String queryParameter = parse.getQueryParameter("forum_id");
                    String queryParameter2 = parse.getQueryParameter("obj_type");
                    param.param("fid", queryParameter);
                    param.param("obj_type", queryParameter2);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                TiebaStatic.log(param);
            }
            String str5 = this.f17212e.f54420d;
            if (str5 != null && str5.contains("weeklygodview")) {
                TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
            }
            String str6 = this.f17212e.f54420d;
            if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
            if (this.f17214g == 1) {
                TiebaStatic.eventStat(SingleImageTextView.this.f17206e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17212e.f54421e);
                d j = d.a.k0.e1.w.c.j(this.f17212e.f54422f);
                if (j != null) {
                    TiebaStatic.eventStat(SingleImageTextView.this.f17206e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f54276a, "task_id", j.f54277b, "loc", "0");
                    int i3 = this.f17212e.f54423g;
                    if ((i3 == 1 || i3 == 3) && !"0".equals(j.f54277b)) {
                        d.a.k0.e1.u.a.c().a(j.f54277b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17212e.f54424h / 100);
                statisticItem.param("official_id", this.f17212e.f54425i);
                statisticItem.param("official_type", this.f17212e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17212e.k);
                statisticItem.param("obj_params1", this.f17212e.f54420d);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("service_id", this.f17212e.l);
            statisticItem2.param("task_id", this.f17212e.k);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("fid", this.f17212e.f54421e);
            if (!TextUtils.isEmpty(this.f17212e.f54417a)) {
                if (!TextUtils.isEmpty(this.f17212e.f54420d)) {
                    String str7 = null;
                    String[] split = this.f17212e.f54420d.split("tid=");
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
                if (this.f17212e.f54417a.contains("互动量")) {
                    statisticItem2.param("obj_source", 2);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17212e.f54417a.contains("被加精")) {
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17212e.f54417a.contains("热贴榜")) {
                    statisticItem2.param("obj_type", 8);
                } else {
                    int i4 = this.f17212e.f54423g;
                    if (i4 == 4) {
                        statisticItem2.param("obj_type", 10);
                    } else if (i4 == 3) {
                        statisticItem2.param("obj_type", 5);
                        str = this.f17212e.f54425i;
                        if (str != null && str.equals("4754917018")) {
                            statisticItem2.delete("obj_type");
                            statisticItem2.param("obj_type", 9);
                            str2 = this.f17212e.f54420d;
                            if (str2 != null) {
                                if (str2.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (this.f17212e.f54420d.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (this.f17212e.f54420d.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = this.f17212e.f54420d.contains("type=attention-common") ? 5 : -1;
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
            str = this.f17212e.f54425i;
            if (str != null) {
                statisticItem2.delete("obj_type");
                statisticItem2.param("obj_type", 9);
                str2 = this.f17212e.f54420d;
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
        LayoutInflater.from(this.f17206e).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.f17207f = (TextView) findViewById(R.id.single_title);
        this.f17208g = (TextView) findViewById(R.id.single_abstract);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.single_content_pic);
        this.f17209h = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17209h.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f17209h.setConrers(15);
        this.j = (TextView) findViewById(R.id.read_all);
        this.k = (ImageView) findViewById(R.id.arrow);
        this.f17210i = findViewById(R.id.single_divider);
        this.l = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new a());
        int dimension = (int) this.f17206e.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.f17206e.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void f(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17209h.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17207f, R.color.CAM_X0105, 1, skinType);
        SkinManager.setViewTextColor(this.f17208g, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, skinType);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.l, R.color.common_color_10067, 1, skinType);
        SkinManager.setBackgroundResource(this.f17210i, R.drawable.multi_single_divider_selector, skinType);
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
        this.f17207f.setText("");
        this.f17208g.setText("");
        this.f17209h.setBackgroundDrawable(null);
        this.f17209h.setImageDrawable(null);
        this.l.setText("");
        this.l.setVisibility(8);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1300a c1300a, View view, int i2) {
        if (c1300a == null) {
            return;
        }
        this.f17207f.setText(!TextUtils.isEmpty(c1300a.f54417a) ? c1300a.f54417a : "");
        String str = TextUtils.isEmpty(c1300a.f54418b) ? "" : c1300a.f54418b;
        if (!TextUtils.isEmpty(c1300a.f54418b) && c1300a.f54418b.contains(this.f17206e.getResources().getString(R.string.inconformity_forum_rules))) {
            b bVar = new b(2, c1300a.f54420d, c1300a);
            int indexOf = c1300a.f54418b.indexOf(this.f17206e.getResources().getString(R.string.inconformity_forum_rules));
            SpannableString spannableString = new SpannableString(c1300a.f54418b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f17208g.setOnTouchListener(new i(spannableString));
            this.f17208g.setText(spannableString);
            this.j.setText(R.string.bar_tie_complain);
        } else {
            this.f17208g.setText(str);
        }
        if (!TextUtils.isEmpty(c1300a.f54420d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1300a.f54420d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(c1300a, tbPageContext, i2));
        }
        if (!TextUtils.isEmpty(c1300a.f54419c)) {
            this.f17209h.setTag(c1300a.f54419c);
            this.f17209h.V(c1300a.f54419c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f17208g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f17208g.setLayoutParams(marginLayoutParams);
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
        this.f17206e = context;
        e();
    }
}
