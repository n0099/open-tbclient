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
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.f;
/* loaded from: classes7.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String OX;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fSr;
    private View iIa;
    private TextView koA;
    private TextView koB;
    private PagerSlidingTabStrip koC;
    private View koD;
    private ImageView koE;
    private boolean koF;
    private int koG;
    private int koH;
    private int koI;
    private f koJ;
    private View.OnClickListener koK;
    private ClickableSpan koL;
    private ClickableSpan koM;
    private TbImageView kot;
    private TextView kou;
    private TextView kov;
    private TextView kow;
    private LinearLayout kox;
    private LinearLayout koy;
    private ImageView koz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.koF = false;
        this.OX = "";
        this.koH = 0;
        this.koI = 0;
        this.koK = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.koJ != null && !StringUtils.isNull(HotTopicHeaderView.this.koJ.kmz)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.koJ.kmz);
                }
            }
        };
        this.koL = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OX);
                if (HotTopicHeaderView.this.OX.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.koM, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kow.setText(spannableString);
                HotTopicHeaderView.this.kow.setHeight(HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kow.getLineCount() * HotTopicHeaderView.this.kow.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight()) {
                    HotTopicHeaderView.this.kow.scrollTo(0, lineCount - (HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight()));
                }
                HotTopicHeaderView.this.kow.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.koM = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kow.setText(HotTopicHeaderView.this.OX);
                HotTopicHeaderView.this.cRB();
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
        this.koF = false;
        this.OX = "";
        this.koH = 0;
        this.koI = 0;
        this.koK = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.koJ != null && !StringUtils.isNull(HotTopicHeaderView.this.koJ.kmz)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.koJ.kmz);
                }
            }
        };
        this.koL = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OX);
                if (HotTopicHeaderView.this.OX.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.koM, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kow.setText(spannableString);
                HotTopicHeaderView.this.kow.setHeight(HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kow.getLineCount() * HotTopicHeaderView.this.kow.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight()) {
                    HotTopicHeaderView.this.kow.scrollTo(0, lineCount - (HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight()));
                }
                HotTopicHeaderView.this.kow.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.koM = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kow.setText(HotTopicHeaderView.this.OX);
                HotTopicHeaderView.this.cRB();
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
        this.koF = false;
        this.OX = "";
        this.koH = 0;
        this.koI = 0;
        this.koK = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.koJ != null && !StringUtils.isNull(HotTopicHeaderView.this.koJ.kmz)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.koJ.kmz);
                }
            }
        };
        this.koL = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OX);
                if (HotTopicHeaderView.this.OX.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.koM, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kow.setText(spannableString);
                HotTopicHeaderView.this.kow.setHeight(HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kow.getLineCount() * HotTopicHeaderView.this.kow.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight()) {
                    HotTopicHeaderView.this.kow.scrollTo(0, lineCount - (HotTopicHeaderView.this.koG * HotTopicHeaderView.this.kow.getLineHeight()));
                }
                HotTopicHeaderView.this.kow.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.koM = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kow.setText(HotTopicHeaderView.this.OX);
                HotTopicHeaderView.this.cRB();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.koH = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iIa = findViewById(R.id.hot_topic_info_place_holder);
        this.kot = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.kot.setOnClickListener(this.koK);
        this.kou = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kov = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.kow = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.kox = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.koy = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.koA = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.koz = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.koB = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.koC = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.koC.c(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.koD = findViewById(R.id.tab_divider_line);
        this.koD.setVisibility(8);
        this.koE = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fSr = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.koC != null) {
            this.koC.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OX);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kow.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.koL, length - 1, spannableString.length(), 33);
        this.kow.setText(spannableString);
        this.kow.setHeight(this.kow.getLineHeight() * 3);
        this.kow.scrollTo(0, 0);
        this.kow.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eNh)) {
            this.koJ = fVar;
            this.koF = true;
            this.kot.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kot.getLayoutParams();
            layoutParams.height = this.koH;
            this.kot.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kmq) && StringUtils.isNull(fVar.videoUrl)) {
                this.kot.startLoad(fVar.kmq, 10, false);
                this.iIa.setVisibility(8);
            } else {
                this.kot.setVisibility(8);
                this.iIa.setVisibility(0);
            }
            this.kou.setSingleLine();
            fVar.eNh = fVar.eNh.trim();
            if (!StringUtils.isNull(fVar.eNh)) {
                this.kou.setText(com.baidu.tieba.hottopic.a.a.be(fVar.eNh, 10));
            } else {
                this.kou.setText("");
            }
            this.kou.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.koI = HotTopicHeaderView.this.kou.getMeasuredHeight();
                    HotTopicHeaderView.this.kou.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kov.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kmp)) {
                this.kow.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kmp) > 500) {
                    this.OX = at.cutChineseAndEnglishWithSuffix(fVar.kmp, 500, "");
                } else {
                    this.OX = fVar.kmp;
                }
                this.kow.setText(this.OX);
                this.koG = this.kow.getLineCount();
                if (this.koG > 3) {
                    this.kow.setMovementMethod(LinkMovementMethod.getInstance());
                    cRB();
                }
                this.kow.setVisibility(0);
                this.kow.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kmr > 0 && fVar.kmr <= 20) {
                this.kox.setVisibility(0);
                this.koA.setText(fVar.eNh.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kmr);
                this.koy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.kmv)));
                        TiebaStatic.log(new aq("c10813").dW("obj_name", fVar.eNh));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.kox.setVisibility(8);
            }
            this.koC.notifyDataSetChanged();
            this.koD.setVisibility(0);
        }
    }

    public boolean cRC() {
        return this.koF;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.CAM_X0201);
            ao.setBackgroundColor(this.koC, R.color.CAM_X0201);
            ao.setViewTextColor(this.kou, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.kov, R.color.CAM_X0301, 1);
            ao.setViewTextColor(this.kow, R.color.CAM_X0108, 1);
            ao.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ao.setBackgroundColor(this.koD, R.color.CAM_X0205);
            ao.setViewTextColor(this.koA, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.koB, R.color.CAM_X0107, 1);
            ao.setBackgroundResource(this.koz, R.drawable.icon_arrow_more_gray);
            ao.setBackgroundResource(this.koy, R.drawable.hot_topic_ranklist_bg);
            ao.setBackgroundColor(this.koE, R.color.CAM_X0204);
            this.koC.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.koE != null) {
            this.koE.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fSr != null) {
            this.fSr.f(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.koJ == null || StringUtils.isNull(this.koJ.kmq)) ? false : true;
        int i = this.koI;
        if (this.iIa != null) {
            i += this.iIa.getMeasuredHeight();
        }
        return z ? this.koI + this.koH : i;
    }

    public void Cc(int i) {
        ((LinearLayout.LayoutParams) this.iIa.getLayoutParams()).height = i;
        this.iIa.postInvalidate();
    }
}
