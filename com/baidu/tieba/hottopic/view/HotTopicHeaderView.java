package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.f;
/* loaded from: classes15.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String MK;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e eSb;
    private View hnu;
    private View iMA;
    private ImageView iMB;
    private boolean iMC;
    private int iMD;
    private int iME;
    private int iMF;
    private f iMG;
    private View.OnClickListener iMH;
    private ClickableSpan iMI;
    private ClickableSpan iMJ;
    private TbImageView iMq;
    private TextView iMr;
    private TextView iMs;
    private TextView iMt;
    private LinearLayout iMu;
    private LinearLayout iMv;
    private ImageView iMw;
    private TextView iMx;
    private TextView iMy;
    private PagerSlidingTabStrip iMz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iMC = false;
        this.MK = "";
        this.iME = 0;
        this.iMF = 0;
        this.iMH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iMG != null && !StringUtils.isNull(HotTopicHeaderView.this.iMG.iKv)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iMG.iKv);
                }
            }
        };
        this.iMI = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.MK);
                if (HotTopicHeaderView.this.MK.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.iMJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iMt.setText(spannableString);
                HotTopicHeaderView.this.iMt.setHeight(HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iMt.getLineCount() * HotTopicHeaderView.this.iMt.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight()) {
                    HotTopicHeaderView.this.iMt.scrollTo(0, lineCount - (HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight()));
                }
                HotTopicHeaderView.this.iMt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iMJ = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iMt.setText(HotTopicHeaderView.this.MK);
                HotTopicHeaderView.this.cpA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    public HotTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iMC = false;
        this.MK = "";
        this.iME = 0;
        this.iMF = 0;
        this.iMH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iMG != null && !StringUtils.isNull(HotTopicHeaderView.this.iMG.iKv)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iMG.iKv);
                }
            }
        };
        this.iMI = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.MK);
                if (HotTopicHeaderView.this.MK.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.iMJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iMt.setText(spannableString);
                HotTopicHeaderView.this.iMt.setHeight(HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iMt.getLineCount() * HotTopicHeaderView.this.iMt.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight()) {
                    HotTopicHeaderView.this.iMt.scrollTo(0, lineCount - (HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight()));
                }
                HotTopicHeaderView.this.iMt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iMJ = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iMt.setText(HotTopicHeaderView.this.MK);
                HotTopicHeaderView.this.cpA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    public HotTopicHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iMC = false;
        this.MK = "";
        this.iME = 0;
        this.iMF = 0;
        this.iMH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iMG != null && !StringUtils.isNull(HotTopicHeaderView.this.iMG.iKv)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iMG.iKv);
                }
            }
        };
        this.iMI = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.MK);
                if (HotTopicHeaderView.this.MK.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.iMJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iMt.setText(spannableString);
                HotTopicHeaderView.this.iMt.setHeight(HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iMt.getLineCount() * HotTopicHeaderView.this.iMt.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight()) {
                    HotTopicHeaderView.this.iMt.scrollTo(0, lineCount - (HotTopicHeaderView.this.iMD * HotTopicHeaderView.this.iMt.getLineHeight()));
                }
                HotTopicHeaderView.this.iMt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iMJ = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iMt.setText(HotTopicHeaderView.this.MK);
                HotTopicHeaderView.this.cpA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iME = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hnu = findViewById(R.id.hot_topic_info_place_holder);
        this.iMq = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.iMq.setOnClickListener(this.iMH);
        this.iMr = (TextView) findViewById(R.id.hot_topic_info_title);
        this.iMs = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.iMt = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.iMu = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.iMv = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.iMx = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.iMw = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.iMy = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.iMz = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.iMz.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.iMA = findViewById(R.id.tab_divider_line);
        this.iMA.setVisibility(8);
        this.iMB = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.eSb = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.iMz != null) {
            this.iMz.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.MK);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.iMt.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.iMI, length - 1, spannableString.length(), 33);
        this.iMt.setText(spannableString);
        this.iMt.setHeight(this.iMt.getLineHeight() * 3);
        this.iMt.scrollTo(0, 0);
        this.iMt.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.dQI)) {
            this.iMG = fVar;
            this.iMC = true;
            this.iMq.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iMq.getLayoutParams();
            layoutParams.height = this.iME;
            this.iMq.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.iKn) && StringUtils.isNull(fVar.videoUrl)) {
                this.iMq.startLoad(fVar.iKn, 10, false);
                this.hnu.setVisibility(8);
            } else {
                this.iMq.setVisibility(8);
                this.hnu.setVisibility(0);
            }
            this.iMr.setSingleLine();
            fVar.dQI = fVar.dQI.trim();
            if (!StringUtils.isNull(fVar.dQI)) {
                this.iMr.setText(com.baidu.tieba.hottopic.b.a.aO(fVar.dQI, 10));
            } else {
                this.iMr.setText("");
            }
            this.iMr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.iMF = HotTopicHeaderView.this.iMr.getMeasuredHeight();
                    HotTopicHeaderView.this.iMr.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.iMs.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", as.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.iKm)) {
                this.iMt.setVisibility(8);
            } else {
                if (k.byteLength(fVar.iKm) > 500) {
                    this.MK = as.cutChineseAndEnglishWithSuffix(fVar.iKm, 500, "");
                } else {
                    this.MK = fVar.iKm;
                }
                this.iMt.setText(this.MK);
                this.iMD = this.iMt.getLineCount();
                if (this.iMD > 3) {
                    this.iMt.setMovementMethod(LinkMovementMethod.getInstance());
                    cpA();
                }
                this.iMt.setVisibility(0);
                this.iMt.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.iKo > 0 && fVar.iKo <= 20) {
                this.iMu.setVisibility(0);
                this.iMx.setText(fVar.dQI.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.iKo);
                this.iMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new ap("c10813").dn("obj_name", fVar.dQI));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.iMu.setVisibility(8);
            }
            this.iMz.notifyDataSetChanged();
            this.iMA.setVisibility(0);
        }
    }

    public boolean cpB() {
        return this.iMC;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.iMz, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.iMr, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.iMs, R.color.cp_cont_h, 1);
            ao.setViewTextColor(this.iMt, R.color.cp_cont_c, 1);
            ao.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.iMA, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.iMx, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.iMy, R.color.cp_cont_j, 1);
            ao.setBackgroundResource(this.iMw, R.drawable.icon_arrow_more_gray);
            ao.setBackgroundResource(this.iMv, R.drawable.hot_topic_ranklist_bg);
            ao.setBackgroundColor(this.iMB, R.color.cp_bg_line_c);
            this.iMz.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.iMB != null) {
            this.iMB.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.eSb != null) {
            this.eSb.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.iMG == null || StringUtils.isNull(this.iMG.iKn)) ? false : true;
        int i = this.iMF;
        if (this.hnu != null) {
            i += this.hnu.getMeasuredHeight();
        }
        return z ? this.iMF + this.iME : i;
    }

    public void yb(int i) {
        ((LinearLayout.LayoutParams) this.hnu.getLayoutParams()).height = i;
        this.hnu.postInvalidate();
    }
}
