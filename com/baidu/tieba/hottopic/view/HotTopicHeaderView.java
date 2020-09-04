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
/* loaded from: classes15.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String Np;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fcM;
    private View hAr;
    private LinearLayout jbA;
    private LinearLayout jbB;
    private ImageView jbC;
    private TextView jbD;
    private TextView jbE;
    private PagerSlidingTabStrip jbF;
    private View jbG;
    private ImageView jbH;
    private boolean jbI;
    private int jbJ;
    private int jbK;
    private int jbL;
    private f jbM;
    private View.OnClickListener jbN;
    private ClickableSpan jbO;
    private ClickableSpan jbP;
    private TbImageView jbw;
    private TextView jbx;
    private TextView jby;
    private TextView jbz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jbI = false;
        this.Np = "";
        this.jbK = 0;
        this.jbL = 0;
        this.jbN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jbM != null && !StringUtils.isNull(HotTopicHeaderView.this.jbM.iZB)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jbM.iZB);
                }
            }
        };
        this.jbO = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Np);
                if (HotTopicHeaderView.this.Np.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jbP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jbz.setText(spannableString);
                HotTopicHeaderView.this.jbz.setHeight(HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jbz.getLineCount() * HotTopicHeaderView.this.jbz.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight()) {
                    HotTopicHeaderView.this.jbz.scrollTo(0, lineCount - (HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight()));
                }
                HotTopicHeaderView.this.jbz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbP = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jbz.setText(HotTopicHeaderView.this.Np);
                HotTopicHeaderView.this.cAt();
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
        this.jbI = false;
        this.Np = "";
        this.jbK = 0;
        this.jbL = 0;
        this.jbN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jbM != null && !StringUtils.isNull(HotTopicHeaderView.this.jbM.iZB)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jbM.iZB);
                }
            }
        };
        this.jbO = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Np);
                if (HotTopicHeaderView.this.Np.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jbP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jbz.setText(spannableString);
                HotTopicHeaderView.this.jbz.setHeight(HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jbz.getLineCount() * HotTopicHeaderView.this.jbz.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight()) {
                    HotTopicHeaderView.this.jbz.scrollTo(0, lineCount - (HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight()));
                }
                HotTopicHeaderView.this.jbz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbP = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jbz.setText(HotTopicHeaderView.this.Np);
                HotTopicHeaderView.this.cAt();
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
        this.jbI = false;
        this.Np = "";
        this.jbK = 0;
        this.jbL = 0;
        this.jbN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jbM != null && !StringUtils.isNull(HotTopicHeaderView.this.jbM.iZB)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jbM.iZB);
                }
            }
        };
        this.jbO = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Np);
                if (HotTopicHeaderView.this.Np.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jbP, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jbz.setText(spannableString);
                HotTopicHeaderView.this.jbz.setHeight(HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jbz.getLineCount() * HotTopicHeaderView.this.jbz.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight()) {
                    HotTopicHeaderView.this.jbz.scrollTo(0, lineCount - (HotTopicHeaderView.this.jbJ * HotTopicHeaderView.this.jbz.getLineHeight()));
                }
                HotTopicHeaderView.this.jbz.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbP = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jbz.setText(HotTopicHeaderView.this.Np);
                HotTopicHeaderView.this.cAt();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jbK = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hAr = findViewById(R.id.hot_topic_info_place_holder);
        this.jbw = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jbw.setOnClickListener(this.jbN);
        this.jbx = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jby = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jbz = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jbA = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jbB = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jbD = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jbC = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jbE = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jbF = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jbF.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jbG = findViewById(R.id.tab_divider_line);
        this.jbG.setVisibility(8);
        this.jbH = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fcM = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jbF != null) {
            this.jbF.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Np);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jbz.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jbO, length - 1, spannableString.length(), 33);
        this.jbz.setText(spannableString);
        this.jbz.setHeight(this.jbz.getLineHeight() * 3);
        this.jbz.scrollTo(0, 0);
        this.jbz.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eaf)) {
            this.jbM = fVar;
            this.jbI = true;
            this.jbw.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jbw.getLayoutParams();
            layoutParams.height = this.jbK;
            this.jbw.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.iZt) && StringUtils.isNull(fVar.videoUrl)) {
                this.jbw.startLoad(fVar.iZt, 10, false);
                this.hAr.setVisibility(8);
            } else {
                this.jbw.setVisibility(8);
                this.hAr.setVisibility(0);
            }
            this.jbx.setSingleLine();
            fVar.eaf = fVar.eaf.trim();
            if (!StringUtils.isNull(fVar.eaf)) {
                this.jbx.setText(com.baidu.tieba.hottopic.b.a.aR(fVar.eaf, 10));
            } else {
                this.jbx.setText("");
            }
            this.jbx.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jbL = HotTopicHeaderView.this.jbx.getMeasuredHeight();
                    HotTopicHeaderView.this.jbx.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jby.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.iZs)) {
                this.jbz.setVisibility(8);
            } else {
                if (k.byteLength(fVar.iZs) > 500) {
                    this.Np = at.cutChineseAndEnglishWithSuffix(fVar.iZs, 500, "");
                } else {
                    this.Np = fVar.iZs;
                }
                this.jbz.setText(this.Np);
                this.jbJ = this.jbz.getLineCount();
                if (this.jbJ > 3) {
                    this.jbz.setMovementMethod(LinkMovementMethod.getInstance());
                    cAt();
                }
                this.jbz.setVisibility(0);
                this.jbz.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.iZu > 0 && fVar.iZu <= 20) {
                this.jbA.setVisibility(0);
                this.jbD.setText(fVar.eaf.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.iZu);
                this.jbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new aq("c10813").dD("obj_name", fVar.eaf));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jbA.setVisibility(8);
            }
            this.jbF.notifyDataSetChanged();
            this.jbG.setVisibility(0);
        }
    }

    public boolean cAu() {
        return this.jbI;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jbF, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.jbx, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jby, R.color.cp_cont_h, 1);
            ap.setViewTextColor(this.jbz, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jbG, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.jbD, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jbE, R.color.cp_cont_j, 1);
            ap.setBackgroundResource(this.jbC, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jbB, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jbH, R.color.cp_bg_line_c);
            this.jbF.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jbH != null) {
            this.jbH.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fcM != null) {
            this.fcM.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jbM == null || StringUtils.isNull(this.jbM.iZt)) ? false : true;
        int i = this.jbL;
        if (this.hAr != null) {
            i += this.hAr.getMeasuredHeight();
        }
        return z ? this.jbL + this.jbK : i;
    }

    public void Av(int i) {
        ((LinearLayout.LayoutParams) this.hAr.getLayoutParams()).height = i;
        this.hAr.postInvalidate();
    }
}
