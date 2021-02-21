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
    private View iNW;
    private TbImageView kwO;
    private TextView kwP;
    private TextView kwQ;
    private TextView kwR;
    private LinearLayout kwS;
    private LinearLayout kwT;
    private ImageView kwU;
    private TextView kwV;
    private TextView kwW;
    private PagerSlidingTabStrip kwX;
    private View kwY;
    private ImageView kwZ;
    private boolean kxa;
    private int kxb;
    private int kxc;
    private int kxd;
    private f kxe;
    private View.OnClickListener kxf;
    private ClickableSpan kxg;
    private ClickableSpan kxh;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kxa = false;
        this.OV = "";
        this.kxc = 0;
        this.kxd = 0;
        this.kxf = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kxe != null && !StringUtils.isNull(HotTopicHeaderView.this.kxe.kuU)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kxe.kuU);
                }
            }
        };
        this.kxg = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.kxh, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kwR.setText(spannableString);
                HotTopicHeaderView.this.kwR.setHeight(HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kwR.getLineCount() * HotTopicHeaderView.this.kwR.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight()) {
                    HotTopicHeaderView.this.kwR.scrollTo(0, lineCount - (HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight()));
                }
                HotTopicHeaderView.this.kwR.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kxh = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kwR.setText(HotTopicHeaderView.this.OV);
                HotTopicHeaderView.this.cTH();
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
        this.kxa = false;
        this.OV = "";
        this.kxc = 0;
        this.kxd = 0;
        this.kxf = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kxe != null && !StringUtils.isNull(HotTopicHeaderView.this.kxe.kuU)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kxe.kuU);
                }
            }
        };
        this.kxg = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.kxh, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kwR.setText(spannableString);
                HotTopicHeaderView.this.kwR.setHeight(HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kwR.getLineCount() * HotTopicHeaderView.this.kwR.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight()) {
                    HotTopicHeaderView.this.kwR.scrollTo(0, lineCount - (HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight()));
                }
                HotTopicHeaderView.this.kwR.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kxh = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kwR.setText(HotTopicHeaderView.this.OV);
                HotTopicHeaderView.this.cTH();
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
        this.kxa = false;
        this.OV = "";
        this.kxc = 0;
        this.kxd = 0;
        this.kxf = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kxe != null && !StringUtils.isNull(HotTopicHeaderView.this.kxe.kuU)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kxe.kuU);
                }
            }
        };
        this.kxg = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.kxh, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kwR.setText(spannableString);
                HotTopicHeaderView.this.kwR.setHeight(HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kwR.getLineCount() * HotTopicHeaderView.this.kwR.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight()) {
                    HotTopicHeaderView.this.kwR.scrollTo(0, lineCount - (HotTopicHeaderView.this.kxb * HotTopicHeaderView.this.kwR.getLineHeight()));
                }
                HotTopicHeaderView.this.kwR.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kxh = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kwR.setText(HotTopicHeaderView.this.OV);
                HotTopicHeaderView.this.cTH();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kxc = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iNW = findViewById(R.id.hot_topic_info_place_holder);
        this.kwO = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.kwO.setOnClickListener(this.kxf);
        this.kwP = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kwQ = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.kwR = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.kwS = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.kwT = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.kwV = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.kwU = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.kwW = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.kwX = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.kwX.c(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.kwY = findViewById(R.id.tab_divider_line);
        this.kwY.setVisibility(8);
        this.kwZ = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fUG = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kwX != null) {
            this.kwX.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTH() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OV);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kwR.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kxg, length - 1, spannableString.length(), 33);
        this.kwR.setText(spannableString);
        this.kwR.setHeight(this.kwR.getLineHeight() * 3);
        this.kwR.scrollTo(0, 0);
        this.kwR.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.ePt)) {
            this.kxe = fVar;
            this.kxa = true;
            this.kwO.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kwO.getLayoutParams();
            layoutParams.height = this.kxc;
            this.kwO.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kuL) && StringUtils.isNull(fVar.videoUrl)) {
                this.kwO.startLoad(fVar.kuL, 10, false);
                this.iNW.setVisibility(8);
            } else {
                this.kwO.setVisibility(8);
                this.iNW.setVisibility(0);
            }
            this.kwP.setSingleLine();
            fVar.ePt = fVar.ePt.trim();
            if (!StringUtils.isNull(fVar.ePt)) {
                this.kwP.setText(com.baidu.tieba.hottopic.a.a.be(fVar.ePt, 10));
            } else {
                this.kwP.setText("");
            }
            this.kwP.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.kxd = HotTopicHeaderView.this.kwP.getMeasuredHeight();
                    HotTopicHeaderView.this.kwP.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kwQ.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", au.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kuK)) {
                this.kwR.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kuK) > 500) {
                    this.OV = au.cutChineseAndEnglishWithSuffix(fVar.kuK, 500, "");
                } else {
                    this.OV = fVar.kuK;
                }
                this.kwR.setText(this.OV);
                this.kxb = this.kwR.getLineCount();
                if (this.kxb > 3) {
                    this.kwR.setMovementMethod(LinkMovementMethod.getInstance());
                    cTH();
                }
                this.kwR.setVisibility(0);
                this.kwR.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kuM > 0 && fVar.kuM <= 20) {
                this.kwS.setVisibility(0);
                this.kwV.setText(fVar.ePt.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kuM);
                this.kwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", fVar.kuQ)));
                        TiebaStatic.log(new ar("c10813").dR("obj_name", fVar.ePt));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.kwS.setVisibility(8);
            }
            this.kwX.notifyDataSetChanged();
            this.kwY.setVisibility(0);
        }
    }

    public boolean cTI() {
        return this.kxa;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            ap.setBackgroundColor(this.kwX, R.color.CAM_X0201);
            ap.setViewTextColor(this.kwP, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kwQ, R.color.CAM_X0301, 1);
            ap.setViewTextColor(this.kwR, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ap.setBackgroundColor(this.kwY, R.color.CAM_X0205);
            ap.setViewTextColor(this.kwV, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kwW, R.color.CAM_X0107, 1);
            ap.setBackgroundResource(this.kwU, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.kwT, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.kwZ, R.color.CAM_X0204);
            this.kwX.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.kwZ != null) {
            this.kwZ.setVisibility(z ? 0 : 8);
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
        boolean z = (this.kxe == null || StringUtils.isNull(this.kxe.kuL)) ? false : true;
        int i = this.kxd;
        if (this.iNW != null) {
            i += this.iNW.getMeasuredHeight();
        }
        return z ? this.kxd + this.kxc : i;
    }

    public void Cu(int i) {
        ((LinearLayout.LayoutParams) this.iNW.getLayoutParams()).height = i;
        this.iNW.postInvalidate();
    }
}
