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
import d.a.n0.b1.m.f;
import d.a.o0.f1.g.d;
import d.a.o0.f1.l.c.a;
import d.a.o0.v3.i;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public class SingleImageTextView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17274e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17275f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17276g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f17277h;

    /* renamed from: i  reason: collision with root package name */
    public View f17278i;
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
        public final /* synthetic */ a.C1378a l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, String str, a.C1378a c1378a) {
            super(i2, str);
            this.l = c1378a;
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(SingleImageTextView.this.f17274e, SingleImageTextView.this.g(this.l.f58424d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1378a f17280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17281f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17282g;

        public c(a.C1378a c1378a, TbPageContext tbPageContext, int i2) {
            this.f17280e = c1378a;
            this.f17281f = tbPageContext;
            this.f17282g = i2;
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
            a.C1378a c1378a = this.f17280e;
            if (c1378a != null && (str3 = c1378a.f58424d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                try {
                    SingleImageTextView.this.f17274e.startActivity(Intent.parseUri(this.f17280e.f58424d, 1));
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
            UrlManager.getInstance().dealOneLink(this.f17281f, new String[]{this.f17280e.f58424d});
            String str4 = this.f17280e.f58424d;
            if (str4 != null && str4.contains("ForumGradePage")) {
                StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                try {
                    Uri parse = Uri.parse(this.f17280e.f58424d);
                    String queryParameter = parse.getQueryParameter("forum_id");
                    String queryParameter2 = parse.getQueryParameter("obj_type");
                    param.param("fid", queryParameter);
                    param.param("obj_type", queryParameter2);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                TiebaStatic.log(param);
            }
            String str5 = this.f17280e.f58424d;
            if (str5 != null && str5.contains("weeklygodview")) {
                TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
            }
            String str6 = this.f17280e.f58424d;
            if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
            if (this.f17282g == 1) {
                TiebaStatic.eventStat(SingleImageTextView.this.f17274e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17280e.f58425e);
                d j = d.a.o0.f1.w.c.j(this.f17280e.f58426f);
                if (j != null) {
                    TiebaStatic.eventStat(SingleImageTextView.this.f17274e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f58280a, "task_id", j.f58281b, "loc", "0");
                    int i3 = this.f17280e.f58427g;
                    if ((i3 == 1 || i3 == 3) && !"0".equals(j.f58281b)) {
                        d.a.o0.f1.u.a.c().a(j.f58281b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17280e.f58428h / 100);
                statisticItem.param("official_id", this.f17280e.f58429i);
                statisticItem.param("official_type", this.f17280e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17280e.k);
                statisticItem.param("obj_params1", this.f17280e.f58424d);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("service_id", this.f17280e.l);
            statisticItem2.param("task_id", this.f17280e.k);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("fid", this.f17280e.f58425e);
            if (!TextUtils.isEmpty(this.f17280e.f58421a)) {
                if (!TextUtils.isEmpty(this.f17280e.f58424d)) {
                    String str7 = null;
                    String[] split = this.f17280e.f58424d.split("tid=");
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
                if (this.f17280e.f58421a.contains("互动量")) {
                    statisticItem2.param("obj_source", 2);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17280e.f58421a.contains("被加精")) {
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 9);
                } else if (this.f17280e.f58421a.contains("热贴榜")) {
                    statisticItem2.param("obj_type", 8);
                } else {
                    int i4 = this.f17280e.f58427g;
                    if (i4 == 4) {
                        statisticItem2.param("obj_type", 10);
                    } else if (i4 == 3) {
                        statisticItem2.param("obj_type", 5);
                        str = this.f17280e.f58429i;
                        if (str != null && str.equals("4754917018")) {
                            statisticItem2.delete("obj_type");
                            statisticItem2.param("obj_type", 9);
                            str2 = this.f17280e.f58424d;
                            if (str2 != null) {
                                if (str2.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (this.f17280e.f58424d.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (this.f17280e.f58424d.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = this.f17280e.f58424d.contains("type=attention-common") ? 5 : -1;
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
            str = this.f17280e.f58429i;
            if (str != null) {
                statisticItem2.delete("obj_type");
                statisticItem2.param("obj_type", 9);
                str2 = this.f17280e.f58424d;
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
        LayoutInflater.from(this.f17274e).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.f17275f = (TextView) findViewById(R.id.single_title);
        this.f17276g = (TextView) findViewById(R.id.single_abstract);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.single_content_pic);
        this.f17277h = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17277h.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f17277h.setConrers(15);
        this.j = (TextView) findViewById(R.id.read_all);
        this.k = (ImageView) findViewById(R.id.arrow);
        this.f17278i = findViewById(R.id.single_divider);
        this.l = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new a());
        int dimension = (int) this.f17274e.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.f17274e.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void f(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17277h.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17275f, R.color.CAM_X0105, 1, skinType);
        SkinManager.setViewTextColor(this.f17276g, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, skinType);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.l, R.color.common_color_10067, 1, skinType);
        SkinManager.setBackgroundResource(this.f17278i, R.drawable.multi_single_divider_selector, skinType);
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
        this.f17275f.setText("");
        this.f17276g.setText("");
        this.f17277h.setBackgroundDrawable(null);
        this.f17277h.setImageDrawable(null);
        this.l.setText("");
        this.l.setVisibility(8);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1378a c1378a, View view, int i2) {
        if (c1378a == null) {
            return;
        }
        this.f17275f.setText(!TextUtils.isEmpty(c1378a.f58421a) ? c1378a.f58421a : "");
        String str = TextUtils.isEmpty(c1378a.f58422b) ? "" : c1378a.f58422b;
        if (!TextUtils.isEmpty(c1378a.f58422b) && c1378a.f58422b.contains(this.f17274e.getResources().getString(R.string.inconformity_forum_rules))) {
            b bVar = new b(2, c1378a.f58424d, c1378a);
            int indexOf = c1378a.f58422b.indexOf(this.f17274e.getResources().getString(R.string.inconformity_forum_rules));
            SpannableString spannableString = new SpannableString(c1378a.f58422b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f17276g.setOnTouchListener(new i(spannableString));
            this.f17276g.setText(spannableString);
            this.j.setText(R.string.bar_tie_complain);
        } else {
            this.f17276g.setText(str);
        }
        if (!TextUtils.isEmpty(c1378a.f58424d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1378a.f58424d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(c1378a, tbPageContext, i2));
        }
        if (!TextUtils.isEmpty(c1378a.f58423c)) {
            this.f17277h.setTag(c1378a.f58423c);
            this.f17277h.U(c1378a.f58423c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f17276g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f17276g.setLayoutParams(marginLayoutParams);
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
        this.f17274e = context;
        e();
    }
}
