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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.f;
/* loaded from: classes21.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String OW;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fNu;
    private View iAv;
    private TbImageView kfM;
    private TextView kfN;
    private TextView kfO;
    private TextView kfP;
    private LinearLayout kfQ;
    private LinearLayout kfR;
    private ImageView kfS;
    private TextView kfT;
    private TextView kfU;
    private PagerSlidingTabStrip kfV;
    private View kfW;
    private ImageView kfX;
    private boolean kfY;
    private int kfZ;
    private int kga;
    private int kgb;
    private f kgc;
    private View.OnClickListener kgd;
    private ClickableSpan kge;
    private ClickableSpan kgf;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kfY = false;
        this.OW = "";
        this.kga = 0;
        this.kgb = 0;
        this.kgd = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kgc != null && !StringUtils.isNull(HotTopicHeaderView.this.kgc.kdR)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kgc.kdR);
                }
            }
        };
        this.kge = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OW);
                if (HotTopicHeaderView.this.OW.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kgf, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kfP.setText(spannableString);
                HotTopicHeaderView.this.kfP.setHeight(HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kfP.getLineCount() * HotTopicHeaderView.this.kfP.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight()) {
                    HotTopicHeaderView.this.kfP.scrollTo(0, lineCount - (HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight()));
                }
                HotTopicHeaderView.this.kfP.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgf = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kfP.setText(HotTopicHeaderView.this.OW);
                HotTopicHeaderView.this.cSm();
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
        this.kfY = false;
        this.OW = "";
        this.kga = 0;
        this.kgb = 0;
        this.kgd = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kgc != null && !StringUtils.isNull(HotTopicHeaderView.this.kgc.kdR)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kgc.kdR);
                }
            }
        };
        this.kge = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OW);
                if (HotTopicHeaderView.this.OW.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kgf, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kfP.setText(spannableString);
                HotTopicHeaderView.this.kfP.setHeight(HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kfP.getLineCount() * HotTopicHeaderView.this.kfP.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight()) {
                    HotTopicHeaderView.this.kfP.scrollTo(0, lineCount - (HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight()));
                }
                HotTopicHeaderView.this.kfP.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgf = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kfP.setText(HotTopicHeaderView.this.OW);
                HotTopicHeaderView.this.cSm();
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
        this.kfY = false;
        this.OW = "";
        this.kga = 0;
        this.kgb = 0;
        this.kgd = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kgc != null && !StringUtils.isNull(HotTopicHeaderView.this.kgc.kdR)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kgc.kdR);
                }
            }
        };
        this.kge = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.OW);
                if (HotTopicHeaderView.this.OW.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kgf, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kfP.setText(spannableString);
                HotTopicHeaderView.this.kfP.setHeight(HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kfP.getLineCount() * HotTopicHeaderView.this.kfP.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight()) {
                    HotTopicHeaderView.this.kfP.scrollTo(0, lineCount - (HotTopicHeaderView.this.kfZ * HotTopicHeaderView.this.kfP.getLineHeight()));
                }
                HotTopicHeaderView.this.kfP.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgf = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kfP.setText(HotTopicHeaderView.this.OW);
                HotTopicHeaderView.this.cSm();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kga = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iAv = findViewById(R.id.hot_topic_info_place_holder);
        this.kfM = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.kfM.setOnClickListener(this.kgd);
        this.kfN = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kfO = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.kfP = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.kfQ = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.kfR = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.kfT = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.kfS = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.kfU = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.kfV = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.kfV.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.kfW = findViewById(R.id.tab_divider_line);
        this.kfW.setVisibility(8);
        this.kfX = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fNu = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kfV != null) {
            this.kfV.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSm() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OW);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kfP.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kge, length - 1, spannableString.length(), 33);
        this.kfP.setText(spannableString);
        this.kfP.setHeight(this.kfP.getLineHeight() * 3);
        this.kfP.scrollTo(0, 0);
        this.kfP.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eIa)) {
            this.kgc = fVar;
            this.kfY = true;
            this.kfM.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kfM.getLayoutParams();
            layoutParams.height = this.kga;
            this.kfM.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kdJ) && StringUtils.isNull(fVar.videoUrl)) {
                this.kfM.startLoad(fVar.kdJ, 10, false);
                this.iAv.setVisibility(8);
            } else {
                this.kfM.setVisibility(8);
                this.iAv.setVisibility(0);
            }
            this.kfN.setSingleLine();
            fVar.eIa = fVar.eIa.trim();
            if (!StringUtils.isNull(fVar.eIa)) {
                this.kfN.setText(com.baidu.tieba.hottopic.b.a.aV(fVar.eIa, 10));
            } else {
                this.kfN.setText("");
            }
            this.kfN.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.kgb = HotTopicHeaderView.this.kfN.getMeasuredHeight();
                    HotTopicHeaderView.this.kfN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kfO.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", au.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kdI)) {
                this.kfP.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kdI) > 500) {
                    this.OW = au.cutChineseAndEnglishWithSuffix(fVar.kdI, 500, "");
                } else {
                    this.OW = fVar.kdI;
                }
                this.kfP.setText(this.OW);
                this.kfZ = this.kfP.getLineCount();
                if (this.kfZ > 3) {
                    this.kfP.setMovementMethod(LinkMovementMethod.getInstance());
                    cSm();
                }
                this.kfP.setVisibility(0);
                this.kfP.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kdK > 0 && fVar.kdK <= 20) {
                this.kfQ.setVisibility(0);
                this.kfT.setText(fVar.eIa.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kdK);
                this.kfR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new ar("c10813").dY("obj_name", fVar.eIa));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.kfQ.setVisibility(8);
            }
            this.kfV.notifyDataSetChanged();
            this.kfW.setVisibility(0);
        }
    }

    public boolean cSn() {
        return this.kfY;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            ap.setBackgroundColor(this.kfV, R.color.CAM_X0201);
            ap.setViewTextColor(this.kfN, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kfO, R.color.CAM_X0301, 1);
            ap.setViewTextColor(this.kfP, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ap.setBackgroundColor(this.kfW, R.color.CAM_X0205);
            ap.setViewTextColor(this.kfT, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kfU, R.color.CAM_X0107, 1);
            ap.setBackgroundResource(this.kfS, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.kfR, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.kfX, R.color.CAM_X0204);
            this.kfV.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.kfX != null) {
            this.kfX.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fNu != null) {
            this.fNu.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.kgc == null || StringUtils.isNull(this.kgc.kdJ)) ? false : true;
        int i = this.kgb;
        if (this.iAv != null) {
            i += this.iAv.getMeasuredHeight();
        }
        return z ? this.kgb + this.kga : i;
    }

    public void Dv(int i) {
        ((LinearLayout.LayoutParams) this.iAv.getLayoutParams()).height = i;
        this.iAv.postInvalidate();
    }
}
