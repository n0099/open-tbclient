package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.bumptech.glide.load.engine.GlideException;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.d1.c.f;
/* loaded from: classes4.dex */
public class HotTopicHeaderView extends LinearLayout {
    public View.OnClickListener A;
    public ClickableSpan B;
    public ClickableSpan C;

    /* renamed from: e  reason: collision with root package name */
    public int f16995e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16996f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16997g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16998h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16999i;
    public View j;
    public LinearLayout k;
    public LinearLayout l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public PagerSlidingTabStrip p;
    public View q;
    public ImageView r;
    public View s;
    public boolean t;
    public d.a.n0.b1.j.e u;
    public int v;
    public String w;
    public int x;
    public int y;
    public f z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HotTopicHeaderView.this.z == null || StringUtils.isNull(HotTopicHeaderView.this.z.r)) {
                return;
            }
            d.a.n0.l.a.l(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.z.r);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            HotTopicHeaderView hotTopicHeaderView = HotTopicHeaderView.this;
            hotTopicHeaderView.y = hotTopicHeaderView.f16997g.getMeasuredHeight();
            HotTopicHeaderView.this.f16997g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f17002e;

        public c(f fVar) {
            this.f17002e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", this.f17002e.n)));
            TiebaStatic.log(new StatisticItem("c10813").param("obj_name", this.f17002e.f56388f));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.w);
            if (HotTopicHeaderView.this.w.length() > 500) {
                spannableStringBuilder.append((CharSequence) "...  ");
            }
            String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
            spannableStringBuilder.append((CharSequence) str);
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            spannableString.setSpan(HotTopicHeaderView.this.C, spannableString.length() - str.length(), spannableString.length(), 33);
            HotTopicHeaderView.this.f16999i.setText(spannableString);
            HotTopicHeaderView.this.f16999i.setHeight(HotTopicHeaderView.this.v * HotTopicHeaderView.this.f16999i.getLineHeight());
            int lineCount = HotTopicHeaderView.this.f16999i.getLineCount() * HotTopicHeaderView.this.f16999i.getLineHeight();
            if (lineCount > HotTopicHeaderView.this.v * HotTopicHeaderView.this.f16999i.getLineHeight()) {
                HotTopicHeaderView.this.f16999i.scrollTo(0, lineCount - (HotTopicHeaderView.this.v * HotTopicHeaderView.this.f16999i.getLineHeight()));
            }
            HotTopicHeaderView.this.f16999i.requestLayout();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ClickableSpan {
        public e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            HotTopicHeaderView.this.f16999i.setText(HotTopicHeaderView.this.w);
            HotTopicHeaderView.this.j();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
        }
    }

    public HotTopicHeaderView(Context context) {
        super(context);
        this.f16995e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a();
        this.B = new d();
        this.C = new e();
        k(context);
    }

    public int getNavigationBarSwitchHeight() {
        f fVar = this.z;
        boolean z = (fVar == null || StringUtils.isNull(fVar.f56391i)) ? false : true;
        int i2 = this.y;
        View view = this.s;
        if (view != null) {
            i2 += view.getMeasuredHeight();
        }
        return z ? this.y + this.x : i2;
    }

    public void i(int i2) {
        ((LinearLayout.LayoutParams) this.s.getLayoutParams()).height = i2;
        this.s.postInvalidate();
    }

    public final void j() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.w);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.f16999i.getLayout().getLineEnd(2) - string.length()) - 2);
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.B, length - 1, spannableString.length(), 33);
        this.f16999i.setText(spannableString);
        TextView textView = this.f16999i;
        textView.setHeight(textView.getLineHeight() * 3);
        this.f16999i.scrollTo(0, 0);
        this.f16999i.requestLayout();
    }

    public final void k(Context context) {
        this.x = l.g(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.s = findViewById(R.id.hot_topic_info_place_holder);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.f16996f = tbImageView;
        tbImageView.setOnClickListener(this.A);
        this.f16997g = (TextView) findViewById(R.id.hot_topic_info_title);
        this.f16998h = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.f16999i = (TextView) findViewById(R.id.hot_topic_info_abstract);
        View findViewById = findViewById(R.id.divider_line);
        this.j = findViewById;
        findViewById.setVisibility(8);
        this.k = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.l = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.n = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.m = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.o = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.p = pagerSlidingTabStrip;
        pagerSlidingTabStrip.k(l.g(context, R.dimen.ds32), l.g(context, R.dimen.ds1), l.g(context, R.dimen.ds4), true);
        View findViewById2 = findViewById(R.id.tab_divider_line);
        this.q = findViewById2;
        findViewById2.setVisibility(8);
        this.r = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        m();
    }

    public boolean l() {
        return this.t;
    }

    public void m() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.f16995e) {
            this.f16995e = skinType;
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f16997g, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f16998h, R.color.CAM_X0301, 1);
            SkinManager.setViewTextColor(this.f16999i, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundResource(this.m, R.drawable.icon_arrow_more_gray);
            SkinManager.setBackgroundResource(this.l, R.drawable.hot_topic_ranklist_bg);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            this.p.m();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d.a.n0.b1.j.e eVar = this.u;
        if (eVar != null) {
            eVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setData(f fVar) {
        if (fVar == null || StringUtils.isNull(fVar.f56388f)) {
            return;
        }
        this.z = fVar;
        this.t = true;
        this.f16996f.setDefaultBgResource(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16996f.getLayoutParams();
        layoutParams.height = this.x;
        this.f16996f.setLayoutParams(layoutParams);
        if (!StringUtils.isNull(fVar.f56391i) && StringUtils.isNull(fVar.m)) {
            this.f16996f.U(fVar.f56391i, 10, false);
            this.s.setVisibility(8);
        } else {
            this.f16996f.setVisibility(8);
            this.s.setVisibility(0);
        }
        this.f16997g.setSingleLine();
        String trim = fVar.f56388f.trim();
        fVar.f56388f = trim;
        if (!StringUtils.isNull(trim)) {
            this.f16997g.setText(d.a.o0.d1.e.a.a(fVar.f56388f, 10));
        } else {
            this.f16997g.setText("");
        }
        this.f16997g.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.f16998h.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", StringHelper.longNumFormatOver9999wan(fVar.f56390h)));
        if (StringUtils.isNull(fVar.f56389g)) {
            this.f16999i.setVisibility(8);
        } else {
            if (k.byteLength(fVar.f56389g) > 500) {
                this.w = StringHelper.cutChineseAndEnglishWithSuffix(fVar.f56389g, 500, "");
            } else {
                this.w = fVar.f56389g;
            }
            this.f16999i.setText(this.w);
            int lineCount = this.f16999i.getLineCount();
            this.v = lineCount;
            if (lineCount > 3) {
                this.f16999i.setMovementMethod(LinkMovementMethod.getInstance());
                j();
            }
            this.f16999i.setVisibility(0);
            this.f16999i.setHighlightColor(getResources().getColor(R.color.transparent));
        }
        long j = fVar.l;
        if (j > 0 && j <= 20) {
            this.k.setVisibility(0);
            TextView textView = this.n;
            textView.setText(fVar.f56388f.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.l);
            this.l.setOnClickListener(new c(fVar));
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        }
        this.p.l();
        this.q.setVisibility(0);
    }

    public void setHeaderBottomLineShow(boolean z) {
        ImageView imageView = this.r;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void setOnSizeChangeListener(d.a.n0.b1.j.e eVar) {
        this.u = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.p;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setViewPager(viewPager);
        }
    }

    public HotTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16995e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a();
        this.B = new d();
        this.C = new e();
        k(context);
    }

    public HotTopicHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16995e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a();
        this.B = new d();
        this.C = new e();
        k(context);
    }
}
