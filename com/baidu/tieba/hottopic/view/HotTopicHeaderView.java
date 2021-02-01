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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.f;
/* loaded from: classes8.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String OV;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fUG;
    private View iNI;
    private TbImageView kwA;
    private TextView kwB;
    private TextView kwC;
    private TextView kwD;
    private LinearLayout kwE;
    private LinearLayout kwF;
    private ImageView kwG;
    private TextView kwH;
    private TextView kwI;
    private PagerSlidingTabStrip kwJ;
    private View kwK;
    private ImageView kwL;
    private boolean kwM;
    private int kwN;
    private int kwO;
    private int kwP;
    private f kwQ;
    private View.OnClickListener kwR;
    private ClickableSpan kwS;
    private ClickableSpan kwT;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kwM = false;
        this.OV = "";
        this.kwO = 0;
        this.kwP = 0;
        this.kwR = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kwQ != null && !StringUtils.isNull(HotTopicHeaderView.this.kwQ.kuG)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kwQ.kuG);
                }
            }
        };
        this.kwS = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OV);
                if (HotTopicHeaderView.this.OV.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kwT, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kwD.setText(spannableString);
                HotTopicHeaderView.this.kwD.setHeight(HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kwD.getLineCount() * HotTopicHeaderView.this.kwD.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight()) {
                    HotTopicHeaderView.this.kwD.scrollTo(0, lineCount - (HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight()));
                }
                HotTopicHeaderView.this.kwD.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kwT = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kwD.setText(HotTopicHeaderView.this.OV);
                HotTopicHeaderView.this.cTA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    public HotTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.kwM = false;
        this.OV = "";
        this.kwO = 0;
        this.kwP = 0;
        this.kwR = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kwQ != null && !StringUtils.isNull(HotTopicHeaderView.this.kwQ.kuG)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kwQ.kuG);
                }
            }
        };
        this.kwS = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OV);
                if (HotTopicHeaderView.this.OV.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kwT, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kwD.setText(spannableString);
                HotTopicHeaderView.this.kwD.setHeight(HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kwD.getLineCount() * HotTopicHeaderView.this.kwD.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight()) {
                    HotTopicHeaderView.this.kwD.scrollTo(0, lineCount - (HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight()));
                }
                HotTopicHeaderView.this.kwD.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kwT = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kwD.setText(HotTopicHeaderView.this.OV);
                HotTopicHeaderView.this.cTA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    public HotTopicHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.kwM = false;
        this.OV = "";
        this.kwO = 0;
        this.kwP = 0;
        this.kwR = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kwQ != null && !StringUtils.isNull(HotTopicHeaderView.this.kwQ.kuG)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kwQ.kuG);
                }
            }
        };
        this.kwS = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OV);
                if (HotTopicHeaderView.this.OV.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kwT, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kwD.setText(spannableString);
                HotTopicHeaderView.this.kwD.setHeight(HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kwD.getLineCount() * HotTopicHeaderView.this.kwD.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight()) {
                    HotTopicHeaderView.this.kwD.scrollTo(0, lineCount - (HotTopicHeaderView.this.kwN * HotTopicHeaderView.this.kwD.getLineHeight()));
                }
                HotTopicHeaderView.this.kwD.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kwT = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kwD.setText(HotTopicHeaderView.this.OV);
                HotTopicHeaderView.this.cTA();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kwO = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iNI = findViewById(R.id.hot_topic_info_place_holder);
        this.kwA = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.kwA.setOnClickListener(this.kwR);
        this.kwB = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kwC = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.kwD = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.kwE = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.kwF = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.kwH = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.kwG = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.kwI = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.kwJ = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.kwJ.c(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.kwK = findViewById(R.id.tab_divider_line);
        this.kwK.setVisibility(8);
        this.kwL = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fUG = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kwJ != null) {
            this.kwJ.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OV);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kwD.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kwS, length - 1, spannableString.length(), 33);
        this.kwD.setText(spannableString);
        this.kwD.setHeight(this.kwD.getLineHeight() * 3);
        this.kwD.scrollTo(0, 0);
        this.kwD.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.ePt)) {
            this.kwQ = fVar;
            this.kwM = true;
            this.kwA.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kwA.getLayoutParams();
            layoutParams.height = this.kwO;
            this.kwA.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kux) && StringUtils.isNull(fVar.videoUrl)) {
                this.kwA.startLoad(fVar.kux, 10, false);
                this.iNI.setVisibility(8);
            } else {
                this.kwA.setVisibility(8);
                this.iNI.setVisibility(0);
            }
            this.kwB.setSingleLine();
            fVar.ePt = fVar.ePt.trim();
            if (!StringUtils.isNull(fVar.ePt)) {
                this.kwB.setText(com.baidu.tieba.hottopic.a.a.be(fVar.ePt, 10));
            } else {
                this.kwB.setText("");
            }
            this.kwB.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.kwP = HotTopicHeaderView.this.kwB.getMeasuredHeight();
                    HotTopicHeaderView.this.kwB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kwC.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", au.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kuw)) {
                this.kwD.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kuw) > 500) {
                    this.OV = au.cutChineseAndEnglishWithSuffix(fVar.kuw, 500, "");
                } else {
                    this.OV = fVar.kuw;
                }
                this.kwD.setText(this.OV);
                this.kwN = this.kwD.getLineCount();
                if (this.kwN > 3) {
                    this.kwD.setMovementMethod(LinkMovementMethod.getInstance());
                    cTA();
                }
                this.kwD.setVisibility(0);
                this.kwD.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kuy > 0 && fVar.kuy <= 20) {
                this.kwE.setVisibility(0);
                this.kwH.setText(fVar.ePt.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kuy);
                this.kwF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", fVar.kuC)));
                        TiebaStatic.log(new ar("c10813").dR("obj_name", fVar.ePt));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.kwE.setVisibility(8);
            }
            this.kwJ.notifyDataSetChanged();
            this.kwK.setVisibility(0);
        }
    }

    public boolean cTB() {
        return this.kwM;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            ap.setBackgroundColor(this.kwJ, R.color.CAM_X0201);
            ap.setViewTextColor(this.kwB, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kwC, R.color.CAM_X0301, 1);
            ap.setViewTextColor(this.kwD, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ap.setBackgroundColor(this.kwK, R.color.CAM_X0205);
            ap.setViewTextColor(this.kwH, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kwI, R.color.CAM_X0107, 1);
            ap.setBackgroundResource(this.kwG, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.kwF, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.kwL, R.color.CAM_X0204);
            this.kwJ.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.kwL != null) {
            this.kwL.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fUG != null) {
            this.fUG.f(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.kwQ == null || StringUtils.isNull(this.kwQ.kux)) ? false : true;
        int i = this.kwP;
        if (this.iNI != null) {
            i += this.iNI.getMeasuredHeight();
        }
        return z ? this.kwP + this.kwO : i;
    }

    public void Cu(int i) {
        ((LinearLayout.LayoutParams) this.iNI.getLayoutParams()).height = i;
        this.iNI.postInvalidate();
    }
}
