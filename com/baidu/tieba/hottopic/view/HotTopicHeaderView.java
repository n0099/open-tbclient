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
    private com.baidu.tbadk.widget.layout.e fcI;
    private View hAl;
    private View jbA;
    private ImageView jbB;
    private boolean jbC;
    private int jbD;
    private int jbE;
    private int jbF;
    private f jbG;
    private View.OnClickListener jbH;
    private ClickableSpan jbI;
    private ClickableSpan jbJ;
    private TbImageView jbq;
    private TextView jbr;
    private TextView jbs;
    private TextView jbt;
    private LinearLayout jbu;
    private LinearLayout jbv;
    private ImageView jbw;
    private TextView jbx;
    private TextView jby;
    private PagerSlidingTabStrip jbz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jbC = false;
        this.Np = "";
        this.jbE = 0;
        this.jbF = 0;
        this.jbH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jbG != null && !StringUtils.isNull(HotTopicHeaderView.this.jbG.iZv)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jbG.iZv);
                }
            }
        };
        this.jbI = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.jbJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jbt.setText(spannableString);
                HotTopicHeaderView.this.jbt.setHeight(HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jbt.getLineCount() * HotTopicHeaderView.this.jbt.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight()) {
                    HotTopicHeaderView.this.jbt.scrollTo(0, lineCount - (HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight()));
                }
                HotTopicHeaderView.this.jbt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbJ = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jbt.setText(HotTopicHeaderView.this.Np);
                HotTopicHeaderView.this.cAs();
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
        this.jbC = false;
        this.Np = "";
        this.jbE = 0;
        this.jbF = 0;
        this.jbH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jbG != null && !StringUtils.isNull(HotTopicHeaderView.this.jbG.iZv)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jbG.iZv);
                }
            }
        };
        this.jbI = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.jbJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jbt.setText(spannableString);
                HotTopicHeaderView.this.jbt.setHeight(HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jbt.getLineCount() * HotTopicHeaderView.this.jbt.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight()) {
                    HotTopicHeaderView.this.jbt.scrollTo(0, lineCount - (HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight()));
                }
                HotTopicHeaderView.this.jbt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbJ = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jbt.setText(HotTopicHeaderView.this.Np);
                HotTopicHeaderView.this.cAs();
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
        this.jbC = false;
        this.Np = "";
        this.jbE = 0;
        this.jbF = 0;
        this.jbH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jbG != null && !StringUtils.isNull(HotTopicHeaderView.this.jbG.iZv)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jbG.iZv);
                }
            }
        };
        this.jbI = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
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
                spannableString.setSpan(HotTopicHeaderView.this.jbJ, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jbt.setText(spannableString);
                HotTopicHeaderView.this.jbt.setHeight(HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jbt.getLineCount() * HotTopicHeaderView.this.jbt.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight()) {
                    HotTopicHeaderView.this.jbt.scrollTo(0, lineCount - (HotTopicHeaderView.this.jbD * HotTopicHeaderView.this.jbt.getLineHeight()));
                }
                HotTopicHeaderView.this.jbt.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jbJ = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jbt.setText(HotTopicHeaderView.this.Np);
                HotTopicHeaderView.this.cAs();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jbE = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hAl = findViewById(R.id.hot_topic_info_place_holder);
        this.jbq = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jbq.setOnClickListener(this.jbH);
        this.jbr = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jbs = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jbt = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jbu = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jbv = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jbx = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jbw = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jby = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jbz = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jbz.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jbA = findViewById(R.id.tab_divider_line);
        this.jbA.setVisibility(8);
        this.jbB = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fcI = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jbz != null) {
            this.jbz.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAs() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Np);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jbt.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jbI, length - 1, spannableString.length(), 33);
        this.jbt.setText(spannableString);
        this.jbt.setHeight(this.jbt.getLineHeight() * 3);
        this.jbt.scrollTo(0, 0);
        this.jbt.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eab)) {
            this.jbG = fVar;
            this.jbC = true;
            this.jbq.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jbq.getLayoutParams();
            layoutParams.height = this.jbE;
            this.jbq.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.iZn) && StringUtils.isNull(fVar.videoUrl)) {
                this.jbq.startLoad(fVar.iZn, 10, false);
                this.hAl.setVisibility(8);
            } else {
                this.jbq.setVisibility(8);
                this.hAl.setVisibility(0);
            }
            this.jbr.setSingleLine();
            fVar.eab = fVar.eab.trim();
            if (!StringUtils.isNull(fVar.eab)) {
                this.jbr.setText(com.baidu.tieba.hottopic.b.a.aR(fVar.eab, 10));
            } else {
                this.jbr.setText("");
            }
            this.jbr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jbF = HotTopicHeaderView.this.jbr.getMeasuredHeight();
                    HotTopicHeaderView.this.jbr.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jbs.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.iZm)) {
                this.jbt.setVisibility(8);
            } else {
                if (k.byteLength(fVar.iZm) > 500) {
                    this.Np = at.cutChineseAndEnglishWithSuffix(fVar.iZm, 500, "");
                } else {
                    this.Np = fVar.iZm;
                }
                this.jbt.setText(this.Np);
                this.jbD = this.jbt.getLineCount();
                if (this.jbD > 3) {
                    this.jbt.setMovementMethod(LinkMovementMethod.getInstance());
                    cAs();
                }
                this.jbt.setVisibility(0);
                this.jbt.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.iZo > 0 && fVar.iZo <= 20) {
                this.jbu.setVisibility(0);
                this.jbx.setText(fVar.eab.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.iZo);
                this.jbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new aq("c10813").dD("obj_name", fVar.eab));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jbu.setVisibility(8);
            }
            this.jbz.notifyDataSetChanged();
            this.jbA.setVisibility(0);
        }
    }

    public boolean cAt() {
        return this.jbC;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jbz, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.jbr, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jbs, R.color.cp_cont_h, 1);
            ap.setViewTextColor(this.jbt, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jbA, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.jbx, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jby, R.color.cp_cont_j, 1);
            ap.setBackgroundResource(this.jbw, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jbv, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jbB, R.color.cp_bg_line_c);
            this.jbz.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jbB != null) {
            this.jbB.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fcI != null) {
            this.fcI.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jbG == null || StringUtils.isNull(this.jbG.iZn)) ? false : true;
        int i = this.jbF;
        if (this.hAl != null) {
            i += this.hAl.getMeasuredHeight();
        }
        return z ? this.jbF + this.jbE : i;
    }

    public void Av(int i) {
        ((LinearLayout.LayoutParams) this.hAl.getLayoutParams()).height = i;
        this.hAl.postInvalidate();
    }
}
