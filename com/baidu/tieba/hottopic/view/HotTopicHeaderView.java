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
/* loaded from: classes20.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String NI;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e ffE;
    private View hHt;
    private TbImageView jkc;
    private TextView jkd;
    private TextView jke;
    private TextView jkf;
    private LinearLayout jkg;
    private LinearLayout jkh;
    private ImageView jki;
    private TextView jkj;
    private TextView jkk;
    private PagerSlidingTabStrip jkl;
    private View jkm;
    private ImageView jkn;
    private boolean jko;
    private int jkp;
    private int jkq;
    private int jkr;
    private f jks;
    private View.OnClickListener jkt;
    private ClickableSpan jku;
    private ClickableSpan jkv;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jko = false;
        this.NI = "";
        this.jkq = 0;
        this.jkr = 0;
        this.jkt = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jks != null && !StringUtils.isNull(HotTopicHeaderView.this.jks.jih)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jks.jih);
                }
            }
        };
        this.jku = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.NI);
                if (HotTopicHeaderView.this.NI.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jkv, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jkf.setText(spannableString);
                HotTopicHeaderView.this.jkf.setHeight(HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jkf.getLineCount() * HotTopicHeaderView.this.jkf.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight()) {
                    HotTopicHeaderView.this.jkf.scrollTo(0, lineCount - (HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight()));
                }
                HotTopicHeaderView.this.jkf.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jkv = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jkf.setText(HotTopicHeaderView.this.NI);
                HotTopicHeaderView.this.cEa();
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
        this.jko = false;
        this.NI = "";
        this.jkq = 0;
        this.jkr = 0;
        this.jkt = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jks != null && !StringUtils.isNull(HotTopicHeaderView.this.jks.jih)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jks.jih);
                }
            }
        };
        this.jku = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.NI);
                if (HotTopicHeaderView.this.NI.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jkv, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jkf.setText(spannableString);
                HotTopicHeaderView.this.jkf.setHeight(HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jkf.getLineCount() * HotTopicHeaderView.this.jkf.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight()) {
                    HotTopicHeaderView.this.jkf.scrollTo(0, lineCount - (HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight()));
                }
                HotTopicHeaderView.this.jkf.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jkv = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jkf.setText(HotTopicHeaderView.this.NI);
                HotTopicHeaderView.this.cEa();
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
        this.jko = false;
        this.NI = "";
        this.jkq = 0;
        this.jkr = 0;
        this.jkt = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jks != null && !StringUtils.isNull(HotTopicHeaderView.this.jks.jih)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jks.jih);
                }
            }
        };
        this.jku = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.NI);
                if (HotTopicHeaderView.this.NI.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jkv, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jkf.setText(spannableString);
                HotTopicHeaderView.this.jkf.setHeight(HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jkf.getLineCount() * HotTopicHeaderView.this.jkf.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight()) {
                    HotTopicHeaderView.this.jkf.scrollTo(0, lineCount - (HotTopicHeaderView.this.jkp * HotTopicHeaderView.this.jkf.getLineHeight()));
                }
                HotTopicHeaderView.this.jkf.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jkv = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jkf.setText(HotTopicHeaderView.this.NI);
                HotTopicHeaderView.this.cEa();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jkq = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hHt = findViewById(R.id.hot_topic_info_place_holder);
        this.jkc = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jkc.setOnClickListener(this.jkt);
        this.jkd = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jke = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jkf = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jkg = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jkh = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jkj = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jki = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jkk = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jkl = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jkl.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jkm = findViewById(R.id.tab_divider_line);
        this.jkm.setVisibility(8);
        this.jkn = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.ffE = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jkl != null) {
            this.jkl.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEa() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.NI);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jkf.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jku, length - 1, spannableString.length(), 33);
        this.jkf.setText(spannableString);
        this.jkf.setHeight(this.jkf.getLineHeight() * 3);
        this.jkf.scrollTo(0, 0);
        this.jkf.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.ecp)) {
            this.jks = fVar;
            this.jko = true;
            this.jkc.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jkc.getLayoutParams();
            layoutParams.height = this.jkq;
            this.jkc.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.jhY) && StringUtils.isNull(fVar.videoUrl)) {
                this.jkc.startLoad(fVar.jhY, 10, false);
                this.hHt.setVisibility(8);
            } else {
                this.jkc.setVisibility(8);
                this.hHt.setVisibility(0);
            }
            this.jkd.setSingleLine();
            fVar.ecp = fVar.ecp.trim();
            if (!StringUtils.isNull(fVar.ecp)) {
                this.jkd.setText(com.baidu.tieba.hottopic.b.a.aR(fVar.ecp, 10));
            } else {
                this.jkd.setText("");
            }
            this.jkd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jkr = HotTopicHeaderView.this.jkd.getMeasuredHeight();
                    HotTopicHeaderView.this.jkd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jke.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.jhX)) {
                this.jkf.setVisibility(8);
            } else {
                if (k.byteLength(fVar.jhX) > 500) {
                    this.NI = at.cutChineseAndEnglishWithSuffix(fVar.jhX, 500, "");
                } else {
                    this.NI = fVar.jhX;
                }
                this.jkf.setText(this.NI);
                this.jkp = this.jkf.getLineCount();
                if (this.jkp > 3) {
                    this.jkf.setMovementMethod(LinkMovementMethod.getInstance());
                    cEa();
                }
                this.jkf.setVisibility(0);
                this.jkf.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.jhZ > 0 && fVar.jhZ <= 20) {
                this.jkg.setVisibility(0);
                this.jkj.setText(fVar.ecp.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.jhZ);
                this.jkh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new aq("c10813").dF("obj_name", fVar.ecp));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jkg.setVisibility(8);
            }
            this.jkl.notifyDataSetChanged();
            this.jkm.setVisibility(0);
        }
    }

    public boolean cEb() {
        return this.jko;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jkl, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.jkd, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jke, R.color.cp_cont_h, 1);
            ap.setViewTextColor(this.jkf, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jkm, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.jkj, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jkk, R.color.cp_cont_j, 1);
            ap.setBackgroundResource(this.jki, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jkh, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jkn, R.color.cp_bg_line_c);
            this.jkl.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jkn != null) {
            this.jkn.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ffE != null) {
            this.ffE.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jks == null || StringUtils.isNull(this.jks.jhY)) ? false : true;
        int i = this.jkr;
        if (this.hHt != null) {
            i += this.hHt.getMeasuredHeight();
        }
        return z ? this.jkr + this.jkq : i;
    }

    public void AW(int i) {
        ((LinearLayout.LayoutParams) this.hHt.getLayoutParams()).height = i;
        this.hHt.postInvalidate();
    }
}
