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
    private View iAt;
    private TbImageView kfK;
    private TextView kfL;
    private TextView kfM;
    private TextView kfN;
    private LinearLayout kfO;
    private LinearLayout kfP;
    private ImageView kfQ;
    private TextView kfR;
    private TextView kfS;
    private PagerSlidingTabStrip kfT;
    private View kfU;
    private ImageView kfV;
    private boolean kfW;
    private int kfX;
    private int kfY;
    private int kfZ;
    private f kga;
    private View.OnClickListener kgb;
    private ClickableSpan kgc;
    private ClickableSpan kgd;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kfW = false;
        this.OW = "";
        this.kfY = 0;
        this.kfZ = 0;
        this.kgb = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kga != null && !StringUtils.isNull(HotTopicHeaderView.this.kga.kdP)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kga.kdP);
                }
            }
        };
        this.kgc = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.kgd, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kfN.setText(spannableString);
                HotTopicHeaderView.this.kfN.setHeight(HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kfN.getLineCount() * HotTopicHeaderView.this.kfN.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight()) {
                    HotTopicHeaderView.this.kfN.scrollTo(0, lineCount - (HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight()));
                }
                HotTopicHeaderView.this.kfN.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgd = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kfN.setText(HotTopicHeaderView.this.OW);
                HotTopicHeaderView.this.cSl();
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
        this.kfW = false;
        this.OW = "";
        this.kfY = 0;
        this.kfZ = 0;
        this.kgb = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kga != null && !StringUtils.isNull(HotTopicHeaderView.this.kga.kdP)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kga.kdP);
                }
            }
        };
        this.kgc = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.kgd, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kfN.setText(spannableString);
                HotTopicHeaderView.this.kfN.setHeight(HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kfN.getLineCount() * HotTopicHeaderView.this.kfN.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight()) {
                    HotTopicHeaderView.this.kfN.scrollTo(0, lineCount - (HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight()));
                }
                HotTopicHeaderView.this.kfN.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgd = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kfN.setText(HotTopicHeaderView.this.OW);
                HotTopicHeaderView.this.cSl();
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
        this.kfW = false;
        this.OW = "";
        this.kfY = 0;
        this.kfZ = 0;
        this.kgb = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kga != null && !StringUtils.isNull(HotTopicHeaderView.this.kga.kdP)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kga.kdP);
                }
            }
        };
        this.kgc = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.kgd, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kfN.setText(spannableString);
                HotTopicHeaderView.this.kfN.setHeight(HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kfN.getLineCount() * HotTopicHeaderView.this.kfN.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight()) {
                    HotTopicHeaderView.this.kfN.scrollTo(0, lineCount - (HotTopicHeaderView.this.kfX * HotTopicHeaderView.this.kfN.getLineHeight()));
                }
                HotTopicHeaderView.this.kfN.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kgd = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kfN.setText(HotTopicHeaderView.this.OW);
                HotTopicHeaderView.this.cSl();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kfY = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iAt = findViewById(R.id.hot_topic_info_place_holder);
        this.kfK = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.kfK.setOnClickListener(this.kgb);
        this.kfL = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kfM = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.kfN = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.kfO = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.kfP = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.kfR = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.kfQ = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.kfS = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.kfT = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.kfT.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.kfU = findViewById(R.id.tab_divider_line);
        this.kfU.setVisibility(8);
        this.kfV = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fNu = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kfT != null) {
            this.kfT.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSl() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OW);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kfN.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kgc, length - 1, spannableString.length(), 33);
        this.kfN.setText(spannableString);
        this.kfN.setHeight(this.kfN.getLineHeight() * 3);
        this.kfN.scrollTo(0, 0);
        this.kfN.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eIa)) {
            this.kga = fVar;
            this.kfW = true;
            this.kfK.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kfK.getLayoutParams();
            layoutParams.height = this.kfY;
            this.kfK.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kdH) && StringUtils.isNull(fVar.videoUrl)) {
                this.kfK.startLoad(fVar.kdH, 10, false);
                this.iAt.setVisibility(8);
            } else {
                this.kfK.setVisibility(8);
                this.iAt.setVisibility(0);
            }
            this.kfL.setSingleLine();
            fVar.eIa = fVar.eIa.trim();
            if (!StringUtils.isNull(fVar.eIa)) {
                this.kfL.setText(com.baidu.tieba.hottopic.b.a.aV(fVar.eIa, 10));
            } else {
                this.kfL.setText("");
            }
            this.kfL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.kfZ = HotTopicHeaderView.this.kfL.getMeasuredHeight();
                    HotTopicHeaderView.this.kfL.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kfM.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", au.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kdG)) {
                this.kfN.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kdG) > 500) {
                    this.OW = au.cutChineseAndEnglishWithSuffix(fVar.kdG, 500, "");
                } else {
                    this.OW = fVar.kdG;
                }
                this.kfN.setText(this.OW);
                this.kfX = this.kfN.getLineCount();
                if (this.kfX > 3) {
                    this.kfN.setMovementMethod(LinkMovementMethod.getInstance());
                    cSl();
                }
                this.kfN.setVisibility(0);
                this.kfN.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kdI > 0 && fVar.kdI <= 20) {
                this.kfO.setVisibility(0);
                this.kfR.setText(fVar.eIa.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kdI);
                this.kfP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
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
                this.kfO.setVisibility(8);
            }
            this.kfT.notifyDataSetChanged();
            this.kfU.setVisibility(0);
        }
    }

    public boolean cSm() {
        return this.kfW;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            ap.setBackgroundColor(this.kfT, R.color.CAM_X0201);
            ap.setViewTextColor(this.kfL, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kfM, R.color.CAM_X0301, 1);
            ap.setViewTextColor(this.kfN, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ap.setBackgroundColor(this.kfU, R.color.CAM_X0205);
            ap.setViewTextColor(this.kfR, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kfS, R.color.CAM_X0107, 1);
            ap.setBackgroundResource(this.kfQ, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.kfP, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.kfV, R.color.CAM_X0204);
            this.kfT.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.kfV != null) {
            this.kfV.setVisibility(z ? 0 : 8);
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
        boolean z = (this.kga == null || StringUtils.isNull(this.kga.kdH)) ? false : true;
        int i = this.kfZ;
        if (this.iAt != null) {
            i += this.iAt.getMeasuredHeight();
        }
        return z ? this.kfZ + this.kfY : i;
    }

    public void Dv(int i) {
        ((LinearLayout.LayoutParams) this.iAt.getLayoutParams()).height = i;
        this.iAt.postInvalidate();
    }
}
