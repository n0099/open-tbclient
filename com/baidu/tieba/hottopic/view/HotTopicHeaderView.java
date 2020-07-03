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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.f;
/* loaded from: classes8.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String MN;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e eLG;
    private View hhK;
    private int iGA;
    private f iGB;
    private View.OnClickListener iGC;
    private ClickableSpan iGD;
    private ClickableSpan iGE;
    private TbImageView iGl;
    private TextView iGm;
    private TextView iGn;
    private TextView iGo;
    private LinearLayout iGp;
    private LinearLayout iGq;
    private ImageView iGr;
    private TextView iGs;
    private TextView iGt;
    private PagerSlidingTabStrip iGu;
    private View iGv;
    private ImageView iGw;
    private boolean iGx;
    private int iGy;
    private int iGz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iGx = false;
        this.MN = "";
        this.iGz = 0;
        this.iGA = 0;
        this.iGC = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iGB != null && !StringUtils.isNull(HotTopicHeaderView.this.iGB.iEr)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iGB.iEr);
                }
            }
        };
        this.iGD = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.MN);
                if (HotTopicHeaderView.this.MN.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.iGE, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iGo.setText(spannableString);
                HotTopicHeaderView.this.iGo.setHeight(HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iGo.getLineCount() * HotTopicHeaderView.this.iGo.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight()) {
                    HotTopicHeaderView.this.iGo.scrollTo(0, lineCount - (HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight()));
                }
                HotTopicHeaderView.this.iGo.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iGE = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iGo.setText(HotTopicHeaderView.this.MN);
                HotTopicHeaderView.this.clZ();
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
        this.iGx = false;
        this.MN = "";
        this.iGz = 0;
        this.iGA = 0;
        this.iGC = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iGB != null && !StringUtils.isNull(HotTopicHeaderView.this.iGB.iEr)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iGB.iEr);
                }
            }
        };
        this.iGD = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.MN);
                if (HotTopicHeaderView.this.MN.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.iGE, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iGo.setText(spannableString);
                HotTopicHeaderView.this.iGo.setHeight(HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iGo.getLineCount() * HotTopicHeaderView.this.iGo.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight()) {
                    HotTopicHeaderView.this.iGo.scrollTo(0, lineCount - (HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight()));
                }
                HotTopicHeaderView.this.iGo.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iGE = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iGo.setText(HotTopicHeaderView.this.MN);
                HotTopicHeaderView.this.clZ();
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
        this.iGx = false;
        this.MN = "";
        this.iGz = 0;
        this.iGA = 0;
        this.iGC = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.iGB != null && !StringUtils.isNull(HotTopicHeaderView.this.iGB.iEr)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.iGB.iEr);
                }
            }
        };
        this.iGD = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.MN);
                if (HotTopicHeaderView.this.MN.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.iGE, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.iGo.setText(spannableString);
                HotTopicHeaderView.this.iGo.setHeight(HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight());
                int lineCount = HotTopicHeaderView.this.iGo.getLineCount() * HotTopicHeaderView.this.iGo.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight()) {
                    HotTopicHeaderView.this.iGo.scrollTo(0, lineCount - (HotTopicHeaderView.this.iGy * HotTopicHeaderView.this.iGo.getLineHeight()));
                }
                HotTopicHeaderView.this.iGo.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.iGE = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.iGo.setText(HotTopicHeaderView.this.MN);
                HotTopicHeaderView.this.clZ();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iGz = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hhK = findViewById(R.id.hot_topic_info_place_holder);
        this.iGl = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.iGl.setOnClickListener(this.iGC);
        this.iGm = (TextView) findViewById(R.id.hot_topic_info_title);
        this.iGn = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.iGo = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.iGp = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.iGq = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.iGs = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.iGr = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.iGt = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.iGu = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.iGu.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.iGv = findViewById(R.id.tab_divider_line);
        this.iGv.setVisibility(8);
        this.iGw = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.eLG = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.iGu != null) {
            this.iGu.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clZ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.MN);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.iGo.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.iGD, length - 1, spannableString.length(), 33);
        this.iGo.setText(spannableString);
        this.iGo.setHeight(this.iGo.getLineHeight() * 3);
        this.iGo.scrollTo(0, 0);
        this.iGo.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.dKw)) {
            this.iGB = fVar;
            this.iGx = true;
            this.iGl.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iGl.getLayoutParams();
            layoutParams.height = this.iGz;
            this.iGl.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.iEj) && StringUtils.isNull(fVar.videoUrl)) {
                this.iGl.startLoad(fVar.iEj, 10, false);
                this.hhK.setVisibility(8);
            } else {
                this.iGl.setVisibility(8);
                this.hhK.setVisibility(0);
            }
            this.iGm.setSingleLine();
            fVar.dKw = fVar.dKw.trim();
            if (!StringUtils.isNull(fVar.dKw)) {
                this.iGm.setText(com.baidu.tieba.hottopic.b.a.aP(fVar.dKw, 10));
            } else {
                this.iGm.setText("");
            }
            this.iGm.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.iGA = HotTopicHeaderView.this.iGm.getMeasuredHeight();
                    HotTopicHeaderView.this.iGm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.iGn.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", ar.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.iEi)) {
                this.iGo.setVisibility(8);
            } else {
                if (k.byteLength(fVar.iEi) > 500) {
                    this.MN = ar.cutChineseAndEnglishWithSuffix(fVar.iEi, 500, "");
                } else {
                    this.MN = fVar.iEi;
                }
                this.iGo.setText(this.MN);
                this.iGy = this.iGo.getLineCount();
                if (this.iGy > 3) {
                    this.iGo.setMovementMethod(LinkMovementMethod.getInstance());
                    clZ();
                }
                this.iGo.setVisibility(0);
                this.iGo.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.iEk > 0 && fVar.iEk <= 20) {
                this.iGp.setVisibility(0);
                this.iGs.setText(fVar.dKw.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.iEk);
                this.iGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new ao("c10813").dk("obj_name", fVar.dKw));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.iGp.setVisibility(8);
            }
            this.iGu.notifyDataSetChanged();
            this.iGv.setVisibility(0);
        }
    }

    public boolean cma() {
        return this.iGx;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            an.setBackgroundColor(this, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.iGu, R.color.cp_bg_line_d);
            an.setViewTextColor(this.iGm, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.iGn, R.color.cp_cont_h, 1);
            an.setViewTextColor(this.iGo, R.color.cp_cont_c, 1);
            an.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.iGv, R.color.cp_bg_line_e);
            an.setViewTextColor(this.iGs, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.iGt, R.color.cp_cont_j, 1);
            an.setBackgroundResource(this.iGr, R.drawable.icon_arrow_more_gray);
            an.setBackgroundResource(this.iGq, R.drawable.hot_topic_ranklist_bg);
            an.setBackgroundColor(this.iGw, R.color.cp_bg_line_c);
            this.iGu.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.iGw != null) {
            this.iGw.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.eLG != null) {
            this.eLG.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.iGB == null || StringUtils.isNull(this.iGB.iEj)) ? false : true;
        int i = this.iGA;
        if (this.hhK != null) {
            i += this.hhK.getMeasuredHeight();
        }
        return z ? this.iGA + this.iGz : i;
    }

    public void xJ(int i) {
        ((LinearLayout.LayoutParams) this.hhK.getLayoutParams()).height = i;
        this.hhK.postInvalidate();
    }
}
