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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.f;
/* loaded from: classes21.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String Ob;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fAq;
    private View iiO;
    private TextView jLA;
    private TextView jLB;
    private TextView jLC;
    private LinearLayout jLD;
    private LinearLayout jLE;
    private ImageView jLF;
    private TextView jLG;
    private TextView jLH;
    private PagerSlidingTabStrip jLI;
    private View jLJ;
    private ImageView jLK;
    private boolean jLL;
    private int jLM;
    private int jLN;
    private int jLO;
    private f jLP;
    private View.OnClickListener jLQ;
    private ClickableSpan jLR;
    private ClickableSpan jLS;
    private TbImageView jLz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jLL = false;
        this.Ob = "";
        this.jLN = 0;
        this.jLO = 0;
        this.jLQ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jLP != null && !StringUtils.isNull(HotTopicHeaderView.this.jLP.jJE)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jLP.jJE);
                }
            }
        };
        this.jLR = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Ob);
                if (HotTopicHeaderView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jLS, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jLC.setText(spannableString);
                HotTopicHeaderView.this.jLC.setHeight(HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jLC.getLineCount() * HotTopicHeaderView.this.jLC.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight()) {
                    HotTopicHeaderView.this.jLC.scrollTo(0, lineCount - (HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight()));
                }
                HotTopicHeaderView.this.jLC.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jLS = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jLC.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cKQ();
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
        this.jLL = false;
        this.Ob = "";
        this.jLN = 0;
        this.jLO = 0;
        this.jLQ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jLP != null && !StringUtils.isNull(HotTopicHeaderView.this.jLP.jJE)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jLP.jJE);
                }
            }
        };
        this.jLR = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Ob);
                if (HotTopicHeaderView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jLS, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jLC.setText(spannableString);
                HotTopicHeaderView.this.jLC.setHeight(HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jLC.getLineCount() * HotTopicHeaderView.this.jLC.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight()) {
                    HotTopicHeaderView.this.jLC.scrollTo(0, lineCount - (HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight()));
                }
                HotTopicHeaderView.this.jLC.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jLS = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jLC.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cKQ();
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
        this.jLL = false;
        this.Ob = "";
        this.jLN = 0;
        this.jLO = 0;
        this.jLQ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jLP != null && !StringUtils.isNull(HotTopicHeaderView.this.jLP.jJE)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jLP.jJE);
                }
            }
        };
        this.jLR = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Ob);
                if (HotTopicHeaderView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jLS, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jLC.setText(spannableString);
                HotTopicHeaderView.this.jLC.setHeight(HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jLC.getLineCount() * HotTopicHeaderView.this.jLC.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight()) {
                    HotTopicHeaderView.this.jLC.scrollTo(0, lineCount - (HotTopicHeaderView.this.jLM * HotTopicHeaderView.this.jLC.getLineHeight()));
                }
                HotTopicHeaderView.this.jLC.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jLS = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jLC.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cKQ();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jLN = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iiO = findViewById(R.id.hot_topic_info_place_holder);
        this.jLz = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jLz.setOnClickListener(this.jLQ);
        this.jLA = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jLB = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jLC = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jLD = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jLE = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jLG = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jLF = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jLH = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jLI = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jLI.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jLJ = findViewById(R.id.tab_divider_line);
        this.jLJ.setVisibility(8);
        this.jLK = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fAq = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jLI != null) {
            this.jLI.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKQ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Ob);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jLC.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jLR, length - 1, spannableString.length(), 33);
        this.jLC.setText(spannableString);
        this.jLC.setHeight(this.jLC.getLineHeight() * 3);
        this.jLC.scrollTo(0, 0);
        this.jLC.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.ewR)) {
            this.jLP = fVar;
            this.jLL = true;
            this.jLz.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jLz.getLayoutParams();
            layoutParams.height = this.jLN;
            this.jLz.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.jJw) && StringUtils.isNull(fVar.videoUrl)) {
                this.jLz.startLoad(fVar.jJw, 10, false);
                this.iiO.setVisibility(8);
            } else {
                this.jLz.setVisibility(8);
                this.iiO.setVisibility(0);
            }
            this.jLA.setSingleLine();
            fVar.ewR = fVar.ewR.trim();
            if (!StringUtils.isNull(fVar.ewR)) {
                this.jLA.setText(com.baidu.tieba.hottopic.b.a.aT(fVar.ewR, 10));
            } else {
                this.jLA.setText("");
            }
            this.jLA.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jLO = HotTopicHeaderView.this.jLA.getMeasuredHeight();
                    HotTopicHeaderView.this.jLA.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jLB.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.jJv)) {
                this.jLC.setVisibility(8);
            } else {
                if (k.byteLength(fVar.jJv) > 500) {
                    this.Ob = at.cutChineseAndEnglishWithSuffix(fVar.jJv, 500, "");
                } else {
                    this.Ob = fVar.jJv;
                }
                this.jLC.setText(this.Ob);
                this.jLM = this.jLC.getLineCount();
                if (this.jLM > 3) {
                    this.jLC.setMovementMethod(LinkMovementMethod.getInstance());
                    cKQ();
                }
                this.jLC.setVisibility(0);
                this.jLC.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.jJx > 0 && fVar.jJx <= 20) {
                this.jLD.setVisibility(0);
                this.jLG.setText(fVar.ewR.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.jJx);
                this.jLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new aq("c10813").dR("obj_name", fVar.ewR));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jLD.setVisibility(8);
            }
            this.jLI.notifyDataSetChanged();
            this.jLJ.setVisibility(0);
        }
    }

    public boolean cKR() {
        return this.jLL;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jLI, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.jLA, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jLB, R.color.cp_cont_h, 1);
            ap.setViewTextColor(this.jLC, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jLJ, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.jLG, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jLH, R.color.cp_cont_j, 1);
            ap.setBackgroundResource(this.jLF, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jLE, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jLK, R.color.cp_bg_line_c);
            this.jLI.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jLK != null) {
            this.jLK.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fAq != null) {
            this.fAq.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jLP == null || StringUtils.isNull(this.jLP.jJw)) ? false : true;
        int i = this.jLO;
        if (this.iiO != null) {
            i += this.iiO.getMeasuredHeight();
        }
        return z ? this.jLO + this.jLN : i;
    }

    public void BV(int i) {
        ((LinearLayout.LayoutParams) this.iiO.getLayoutParams()).height = i;
        this.iiO.postInvalidate();
    }
}
