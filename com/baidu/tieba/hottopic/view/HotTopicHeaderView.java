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
    private TextView iMA;
    private PagerSlidingTabStrip iMB;
    private View iMC;
    private ImageView iMD;
    private boolean iME;
    private int iMF;
    private int iMG;
    private int iMH;
    private f iMI;
    private View.OnClickListener iMJ;
    private ClickableSpan iMK;
    private ClickableSpan iML;
    private TbImageView iMs;
    private TextView iMt;
    private TextView iMu;
    private TextView iMv;
    private LinearLayout iMw;
    private LinearLayout iMx;
    private ImageView iMy;
    private TextView iMz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iME = false;
        this.MK = "";
        this.iMG = 0;
        this.iMH = 0;
        this.iMJ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iMI != null && !StringUtils.isNull(HotTopicHeaderView.this.iMI.iKx)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iMI.iKx);
                }
            }
        };
        this.iMK = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.iML, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iMv.setText(spannableString);
                HotTopicHeaderView.this.iMv.setHeight(HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iMv.getLineCount() * HotTopicHeaderView.this.iMv.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight()) {
                    HotTopicHeaderView.this.iMv.scrollTo(0, lineCount - (HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight()));
                }
                HotTopicHeaderView.this.iMv.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iML = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iMv.setText(HotTopicHeaderView.this.MK);
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
        this.iME = false;
        this.MK = "";
        this.iMG = 0;
        this.iMH = 0;
        this.iMJ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iMI != null && !StringUtils.isNull(HotTopicHeaderView.this.iMI.iKx)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iMI.iKx);
                }
            }
        };
        this.iMK = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.iML, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iMv.setText(spannableString);
                HotTopicHeaderView.this.iMv.setHeight(HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iMv.getLineCount() * HotTopicHeaderView.this.iMv.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight()) {
                    HotTopicHeaderView.this.iMv.scrollTo(0, lineCount - (HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight()));
                }
                HotTopicHeaderView.this.iMv.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iML = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iMv.setText(HotTopicHeaderView.this.MK);
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
        this.iME = false;
        this.MK = "";
        this.iMG = 0;
        this.iMH = 0;
        this.iMJ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iMI != null && !StringUtils.isNull(HotTopicHeaderView.this.iMI.iKx)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iMI.iKx);
                }
            }
        };
        this.iMK = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.iML, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iMv.setText(spannableString);
                HotTopicHeaderView.this.iMv.setHeight(HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iMv.getLineCount() * HotTopicHeaderView.this.iMv.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight()) {
                    HotTopicHeaderView.this.iMv.scrollTo(0, lineCount - (HotTopicHeaderView.this.iMF * HotTopicHeaderView.this.iMv.getLineHeight()));
                }
                HotTopicHeaderView.this.iMv.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iML = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iMv.setText(HotTopicHeaderView.this.MK);
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
        this.iMG = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hnu = findViewById(R.id.hot_topic_info_place_holder);
        this.iMs = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.iMs.setOnClickListener(this.iMJ);
        this.iMt = (TextView) findViewById(R.id.hot_topic_info_title);
        this.iMu = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.iMv = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.iMw = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.iMx = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.iMz = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.iMy = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.iMA = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.iMB = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.iMB.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.iMC = findViewById(R.id.tab_divider_line);
        this.iMC.setVisibility(8);
        this.iMD = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.eSb = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.iMB != null) {
            this.iMB.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.MK);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.iMv.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.iMK, length - 1, spannableString.length(), 33);
        this.iMv.setText(spannableString);
        this.iMv.setHeight(this.iMv.getLineHeight() * 3);
        this.iMv.scrollTo(0, 0);
        this.iMv.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.dQI)) {
            this.iMI = fVar;
            this.iME = true;
            this.iMs.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iMs.getLayoutParams();
            layoutParams.height = this.iMG;
            this.iMs.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.iKp) && StringUtils.isNull(fVar.videoUrl)) {
                this.iMs.startLoad(fVar.iKp, 10, false);
                this.hnu.setVisibility(8);
            } else {
                this.iMs.setVisibility(8);
                this.hnu.setVisibility(0);
            }
            this.iMt.setSingleLine();
            fVar.dQI = fVar.dQI.trim();
            if (!StringUtils.isNull(fVar.dQI)) {
                this.iMt.setText(com.baidu.tieba.hottopic.b.a.aO(fVar.dQI, 10));
            } else {
                this.iMt.setText("");
            }
            this.iMt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.iMH = HotTopicHeaderView.this.iMt.getMeasuredHeight();
                    HotTopicHeaderView.this.iMt.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.iMu.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", as.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.iKo)) {
                this.iMv.setVisibility(8);
            } else {
                if (k.byteLength(fVar.iKo) > 500) {
                    this.MK = as.cutChineseAndEnglishWithSuffix(fVar.iKo, 500, "");
                } else {
                    this.MK = fVar.iKo;
                }
                this.iMv.setText(this.MK);
                this.iMF = this.iMv.getLineCount();
                if (this.iMF > 3) {
                    this.iMv.setMovementMethod(LinkMovementMethod.getInstance());
                    cpA();
                }
                this.iMv.setVisibility(0);
                this.iMv.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.iKq > 0 && fVar.iKq <= 20) {
                this.iMw.setVisibility(0);
                this.iMz.setText(fVar.dQI.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.iKq);
                this.iMx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
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
                this.iMw.setVisibility(8);
            }
            this.iMB.notifyDataSetChanged();
            this.iMC.setVisibility(0);
        }
    }

    public boolean cpB() {
        return this.iME;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.iMB, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.iMt, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.iMu, R.color.cp_cont_h, 1);
            ao.setViewTextColor(this.iMv, R.color.cp_cont_c, 1);
            ao.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.iMC, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.iMz, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.iMA, R.color.cp_cont_j, 1);
            ao.setBackgroundResource(this.iMy, R.drawable.icon_arrow_more_gray);
            ao.setBackgroundResource(this.iMx, R.drawable.hot_topic_ranklist_bg);
            ao.setBackgroundColor(this.iMD, R.color.cp_bg_line_c);
            this.iMB.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.iMD != null) {
            this.iMD.setVisibility(z ? 0 : 8);
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
        boolean z = (this.iMI == null || StringUtils.isNull(this.iMI.iKp)) ? false : true;
        int i = this.iMH;
        if (this.hnu != null) {
            i += this.hnu.getMeasuredHeight();
        }
        return z ? this.iMH + this.iMG : i;
    }

    public void yb(int i) {
        ((LinearLayout.LayoutParams) this.hnu.getLayoutParams()).height = i;
        this.hnu.postInvalidate();
    }
}
