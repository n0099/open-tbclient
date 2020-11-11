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
    private com.baidu.tbadk.widget.layout.e fGg;
    private View ioN;
    private LinearLayout jRA;
    private LinearLayout jRB;
    private ImageView jRC;
    private TextView jRD;
    private TextView jRE;
    private PagerSlidingTabStrip jRF;
    private View jRG;
    private ImageView jRH;
    private boolean jRI;
    private int jRJ;
    private int jRK;
    private int jRL;
    private f jRM;
    private View.OnClickListener jRN;
    private ClickableSpan jRO;
    private ClickableSpan jRP;
    private TbImageView jRw;
    private TextView jRx;
    private TextView jRy;
    private TextView jRz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jRI = false;
        this.Ob = "";
        this.jRK = 0;
        this.jRL = 0;
        this.jRN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jRM != null && !StringUtils.isNull(HotTopicHeaderView.this.jRM.jPC)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jRM.jPC);
                }
            }
        };
        this.jRO = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.jRP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jRz.setText(spannableString);
                HotTopicHeaderView.this.jRz.setHeight(HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jRz.getLineCount() * HotTopicHeaderView.this.jRz.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight()) {
                    HotTopicHeaderView.this.jRz.scrollTo(0, lineCount - (HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight()));
                }
                HotTopicHeaderView.this.jRz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jRP = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jRz.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cNr();
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
        this.jRI = false;
        this.Ob = "";
        this.jRK = 0;
        this.jRL = 0;
        this.jRN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jRM != null && !StringUtils.isNull(HotTopicHeaderView.this.jRM.jPC)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jRM.jPC);
                }
            }
        };
        this.jRO = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.jRP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jRz.setText(spannableString);
                HotTopicHeaderView.this.jRz.setHeight(HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jRz.getLineCount() * HotTopicHeaderView.this.jRz.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight()) {
                    HotTopicHeaderView.this.jRz.scrollTo(0, lineCount - (HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight()));
                }
                HotTopicHeaderView.this.jRz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jRP = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jRz.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cNr();
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
        this.jRI = false;
        this.Ob = "";
        this.jRK = 0;
        this.jRL = 0;
        this.jRN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jRM != null && !StringUtils.isNull(HotTopicHeaderView.this.jRM.jPC)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jRM.jPC);
                }
            }
        };
        this.jRO = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.jRP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jRz.setText(spannableString);
                HotTopicHeaderView.this.jRz.setHeight(HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jRz.getLineCount() * HotTopicHeaderView.this.jRz.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight()) {
                    HotTopicHeaderView.this.jRz.scrollTo(0, lineCount - (HotTopicHeaderView.this.jRJ * HotTopicHeaderView.this.jRz.getLineHeight()));
                }
                HotTopicHeaderView.this.jRz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jRP = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jRz.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cNr();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jRK = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.ioN = findViewById(R.id.hot_topic_info_place_holder);
        this.jRw = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jRw.setOnClickListener(this.jRN);
        this.jRx = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jRy = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jRz = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jRA = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jRB = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jRD = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jRC = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jRE = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jRF = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jRF.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jRG = findViewById(R.id.tab_divider_line);
        this.jRG.setVisibility(8);
        this.jRH = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fGg = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jRF != null) {
            this.jRF.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNr() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Ob);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jRz.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jRO, length - 1, spannableString.length(), 33);
        this.jRz.setText(spannableString);
        this.jRz.setHeight(this.jRz.getLineHeight() * 3);
        this.jRz.scrollTo(0, 0);
        this.jRz.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eCJ)) {
            this.jRM = fVar;
            this.jRI = true;
            this.jRw.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jRw.getLayoutParams();
            layoutParams.height = this.jRK;
            this.jRw.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.jPu) && StringUtils.isNull(fVar.videoUrl)) {
                this.jRw.startLoad(fVar.jPu, 10, false);
                this.ioN.setVisibility(8);
            } else {
                this.jRw.setVisibility(8);
                this.ioN.setVisibility(0);
            }
            this.jRx.setSingleLine();
            fVar.eCJ = fVar.eCJ.trim();
            if (!StringUtils.isNull(fVar.eCJ)) {
                this.jRx.setText(com.baidu.tieba.hottopic.b.a.aV(fVar.eCJ, 10));
            } else {
                this.jRx.setText("");
            }
            this.jRx.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jRL = HotTopicHeaderView.this.jRx.getMeasuredHeight();
                    HotTopicHeaderView.this.jRx.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jRy.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.jPt)) {
                this.jRz.setVisibility(8);
            } else {
                if (k.byteLength(fVar.jPt) > 500) {
                    this.Ob = at.cutChineseAndEnglishWithSuffix(fVar.jPt, 500, "");
                } else {
                    this.Ob = fVar.jPt;
                }
                this.jRz.setText(this.Ob);
                this.jRJ = this.jRz.getLineCount();
                if (this.jRJ > 3) {
                    this.jRz.setMovementMethod(LinkMovementMethod.getInstance());
                    cNr();
                }
                this.jRz.setVisibility(0);
                this.jRz.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.jPv > 0 && fVar.jPv <= 20) {
                this.jRA.setVisibility(0);
                this.jRD.setText(fVar.eCJ.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.jPv);
                this.jRB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new aq("c10813").dR("obj_name", fVar.eCJ));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jRA.setVisibility(8);
            }
            this.jRF.notifyDataSetChanged();
            this.jRG.setVisibility(0);
        }
    }

    public boolean cNs() {
        return this.jRI;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jRF, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.jRx, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jRy, R.color.cp_cont_h, 1);
            ap.setViewTextColor(this.jRz, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jRG, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.jRD, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jRE, R.color.cp_cont_j, 1);
            ap.setBackgroundResource(this.jRC, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jRB, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jRH, R.color.cp_bg_line_c);
            this.jRF.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jRH != null) {
            this.jRH.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fGg != null) {
            this.fGg.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jRM == null || StringUtils.isNull(this.jRM.jPu)) ? false : true;
        int i = this.jRL;
        if (this.ioN != null) {
            i += this.ioN.getMeasuredHeight();
        }
        return z ? this.jRL + this.jRK : i;
    }

    public void Ci(int i) {
        ((LinearLayout.LayoutParams) this.ioN.getLayoutParams()).height = i;
        this.ioN.postInvalidate();
    }
}
