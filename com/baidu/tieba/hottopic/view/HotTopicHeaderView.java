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
/* loaded from: classes8.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String OZ;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fWY;
    private View iMH;
    private TbImageView ksY;
    private TextView ksZ;
    private TextView kta;
    private TextView ktb;
    private LinearLayout ktc;
    private LinearLayout ktd;
    private ImageView kte;
    private TextView ktf;
    private TextView ktg;
    private PagerSlidingTabStrip kth;
    private View kti;
    private ImageView ktj;
    private boolean ktk;
    private int ktl;
    private int ktm;
    private int ktn;
    private f kto;
    private View.OnClickListener ktp;
    private ClickableSpan ktq;
    private ClickableSpan ktr;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ktk = false;
        this.OZ = "";
        this.ktm = 0;
        this.ktn = 0;
        this.ktp = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kto != null && !StringUtils.isNull(HotTopicHeaderView.this.kto.kre)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kto.kre);
                }
            }
        };
        this.ktq = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OZ);
                if (HotTopicHeaderView.this.OZ.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.ktr, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.ktb.setText(spannableString);
                HotTopicHeaderView.this.ktb.setHeight(HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight());
                int lineCount = HotTopicHeaderView.this.ktb.getLineCount() * HotTopicHeaderView.this.ktb.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight()) {
                    HotTopicHeaderView.this.ktb.scrollTo(0, lineCount - (HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight()));
                }
                HotTopicHeaderView.this.ktb.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.ktr = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.ktb.setText(HotTopicHeaderView.this.OZ);
                HotTopicHeaderView.this.cVt();
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
        this.ktk = false;
        this.OZ = "";
        this.ktm = 0;
        this.ktn = 0;
        this.ktp = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kto != null && !StringUtils.isNull(HotTopicHeaderView.this.kto.kre)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kto.kre);
                }
            }
        };
        this.ktq = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OZ);
                if (HotTopicHeaderView.this.OZ.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.ktr, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.ktb.setText(spannableString);
                HotTopicHeaderView.this.ktb.setHeight(HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight());
                int lineCount = HotTopicHeaderView.this.ktb.getLineCount() * HotTopicHeaderView.this.ktb.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight()) {
                    HotTopicHeaderView.this.ktb.scrollTo(0, lineCount - (HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight()));
                }
                HotTopicHeaderView.this.ktb.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.ktr = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.ktb.setText(HotTopicHeaderView.this.OZ);
                HotTopicHeaderView.this.cVt();
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
        this.ktk = false;
        this.OZ = "";
        this.ktm = 0;
        this.ktn = 0;
        this.ktp = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kto != null && !StringUtils.isNull(HotTopicHeaderView.this.kto.kre)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kto.kre);
                }
            }
        };
        this.ktq = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OZ);
                if (HotTopicHeaderView.this.OZ.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.ktr, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.ktb.setText(spannableString);
                HotTopicHeaderView.this.ktb.setHeight(HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight());
                int lineCount = HotTopicHeaderView.this.ktb.getLineCount() * HotTopicHeaderView.this.ktb.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight()) {
                    HotTopicHeaderView.this.ktb.scrollTo(0, lineCount - (HotTopicHeaderView.this.ktl * HotTopicHeaderView.this.ktb.getLineHeight()));
                }
                HotTopicHeaderView.this.ktb.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.ktr = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.ktb.setText(HotTopicHeaderView.this.OZ);
                HotTopicHeaderView.this.cVt();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ktm = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iMH = findViewById(R.id.hot_topic_info_place_holder);
        this.ksY = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.ksY.setOnClickListener(this.ktp);
        this.ksZ = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kta = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.ktb = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.ktc = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.ktd = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.ktf = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.kte = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.ktg = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.kth = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.kth.c(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.kti = findViewById(R.id.tab_divider_line);
        this.kti.setVisibility(8);
        this.ktj = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fWY = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kth != null) {
            this.kth.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OZ);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.ktb.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.ktq, length - 1, spannableString.length(), 33);
        this.ktb.setText(spannableString);
        this.ktb.setHeight(this.ktb.getLineHeight() * 3);
        this.ktb.scrollTo(0, 0);
        this.ktb.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eRS)) {
            this.kto = fVar;
            this.ktk = true;
            this.ksY.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ksY.getLayoutParams();
            layoutParams.height = this.ktm;
            this.ksY.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kqV) && StringUtils.isNull(fVar.videoUrl)) {
                this.ksY.startLoad(fVar.kqV, 10, false);
                this.iMH.setVisibility(8);
            } else {
                this.ksY.setVisibility(8);
                this.iMH.setVisibility(0);
            }
            this.ksZ.setSingleLine();
            fVar.eRS = fVar.eRS.trim();
            if (!StringUtils.isNull(fVar.eRS)) {
                this.ksZ.setText(com.baidu.tieba.hottopic.a.a.bd(fVar.eRS, 10));
            } else {
                this.ksZ.setText("");
            }
            this.ksZ.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.ktn = HotTopicHeaderView.this.ksZ.getMeasuredHeight();
                    HotTopicHeaderView.this.ksZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kta.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kqU)) {
                this.ktb.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kqU) > 500) {
                    this.OZ = at.cutChineseAndEnglishWithSuffix(fVar.kqU, 500, "");
                } else {
                    this.OZ = fVar.kqU;
                }
                this.ktb.setText(this.OZ);
                this.ktl = this.ktb.getLineCount();
                if (this.ktl > 3) {
                    this.ktb.setMovementMethod(LinkMovementMethod.getInstance());
                    cVt();
                }
                this.ktb.setVisibility(0);
                this.ktb.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kqW > 0 && fVar.kqW <= 20) {
                this.ktc.setVisibility(0);
                this.ktf.setText(fVar.eRS.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kqW);
                this.ktd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.kra)));
                        TiebaStatic.log(new aq("c10813").dX("obj_name", fVar.eRS));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.ktc.setVisibility(8);
            }
            this.kth.notifyDataSetChanged();
            this.kti.setVisibility(0);
        }
    }

    public boolean cVu() {
        return this.ktk;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.CAM_X0201);
            ao.setBackgroundColor(this.kth, R.color.CAM_X0201);
            ao.setViewTextColor(this.ksZ, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.kta, R.color.CAM_X0301, 1);
            ao.setViewTextColor(this.ktb, R.color.CAM_X0108, 1);
            ao.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ao.setBackgroundColor(this.kti, R.color.CAM_X0205);
            ao.setViewTextColor(this.ktf, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.ktg, R.color.CAM_X0107, 1);
            ao.setBackgroundResource(this.kte, R.drawable.icon_arrow_more_gray);
            ao.setBackgroundResource(this.ktd, R.drawable.hot_topic_ranklist_bg);
            ao.setBackgroundColor(this.ktj, R.color.CAM_X0204);
            this.kth.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.ktj != null) {
            this.ktj.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fWY != null) {
            this.fWY.f(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.kto == null || StringUtils.isNull(this.kto.kqV)) ? false : true;
        int i = this.ktn;
        if (this.iMH != null) {
            i += this.iMH.getMeasuredHeight();
        }
        return z ? this.ktn + this.ktm : i;
    }

    public void DJ(int i) {
        ((LinearLayout.LayoutParams) this.iMH.getLayoutParams()).height = i;
        this.iMH.postInvalidate();
    }
}
