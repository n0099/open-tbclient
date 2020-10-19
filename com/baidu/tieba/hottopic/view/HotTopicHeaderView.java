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
    private String Oa;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e frT;
    private View hWo;
    private TbImageView jza;
    private TextView jzb;
    private TextView jzc;
    private TextView jzd;
    private LinearLayout jze;
    private LinearLayout jzf;
    private ImageView jzg;
    private TextView jzh;
    private TextView jzi;
    private PagerSlidingTabStrip jzj;
    private View jzk;
    private ImageView jzl;
    private boolean jzm;
    private int jzn;
    private int jzo;
    private int jzp;
    private f jzq;
    private View.OnClickListener jzr;
    private ClickableSpan jzs;
    private ClickableSpan jzt;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jzm = false;
        this.Oa = "";
        this.jzo = 0;
        this.jzp = 0;
        this.jzr = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jzq != null && !StringUtils.isNull(HotTopicHeaderView.this.jzq.jxf)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jzq.jxf);
                }
            }
        };
        this.jzs = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Oa);
                if (HotTopicHeaderView.this.Oa.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jzt, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jzd.setText(spannableString);
                HotTopicHeaderView.this.jzd.setHeight(HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jzd.getLineCount() * HotTopicHeaderView.this.jzd.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight()) {
                    HotTopicHeaderView.this.jzd.scrollTo(0, lineCount - (HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight()));
                }
                HotTopicHeaderView.this.jzd.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jzt = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jzd.setText(HotTopicHeaderView.this.Oa);
                HotTopicHeaderView.this.cHJ();
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
        this.jzm = false;
        this.Oa = "";
        this.jzo = 0;
        this.jzp = 0;
        this.jzr = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jzq != null && !StringUtils.isNull(HotTopicHeaderView.this.jzq.jxf)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jzq.jxf);
                }
            }
        };
        this.jzs = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Oa);
                if (HotTopicHeaderView.this.Oa.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jzt, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jzd.setText(spannableString);
                HotTopicHeaderView.this.jzd.setHeight(HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jzd.getLineCount() * HotTopicHeaderView.this.jzd.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight()) {
                    HotTopicHeaderView.this.jzd.scrollTo(0, lineCount - (HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight()));
                }
                HotTopicHeaderView.this.jzd.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jzt = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jzd.setText(HotTopicHeaderView.this.Oa);
                HotTopicHeaderView.this.cHJ();
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
        this.jzm = false;
        this.Oa = "";
        this.jzo = 0;
        this.jzp = 0;
        this.jzr = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jzq != null && !StringUtils.isNull(HotTopicHeaderView.this.jzq.jxf)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jzq.jxf);
                }
            }
        };
        this.jzs = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Oa);
                if (HotTopicHeaderView.this.Oa.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jzt, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jzd.setText(spannableString);
                HotTopicHeaderView.this.jzd.setHeight(HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jzd.getLineCount() * HotTopicHeaderView.this.jzd.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight()) {
                    HotTopicHeaderView.this.jzd.scrollTo(0, lineCount - (HotTopicHeaderView.this.jzn * HotTopicHeaderView.this.jzd.getLineHeight()));
                }
                HotTopicHeaderView.this.jzd.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        this.jzt = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jzd.setText(HotTopicHeaderView.this.Oa);
                HotTopicHeaderView.this.cHJ();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.cp_link_tip_c));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jzo = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.hWo = findViewById(R.id.hot_topic_info_place_holder);
        this.jza = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jza.setOnClickListener(this.jzr);
        this.jzb = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jzc = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jzd = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jze = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jzf = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jzh = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jzg = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jzi = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jzj = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jzj.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jzk = findViewById(R.id.tab_divider_line);
        this.jzk.setVisibility(8);
        this.jzl = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.frT = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jzj != null) {
            this.jzj.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHJ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Oa);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jzd.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jzs, length - 1, spannableString.length(), 33);
        this.jzd.setText(spannableString);
        this.jzd.setHeight(this.jzd.getLineHeight() * 3);
        this.jzd.scrollTo(0, 0);
        this.jzd.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eou)) {
            this.jzq = fVar;
            this.jzm = true;
            this.jza.setDefaultBgResource(R.color.cp_bg_line_e);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jza.getLayoutParams();
            layoutParams.height = this.jzo;
            this.jza.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.jwX) && StringUtils.isNull(fVar.videoUrl)) {
                this.jza.startLoad(fVar.jwX, 10, false);
                this.hWo.setVisibility(8);
            } else {
                this.jza.setVisibility(8);
                this.hWo.setVisibility(0);
            }
            this.jzb.setSingleLine();
            fVar.eou = fVar.eou.trim();
            if (!StringUtils.isNull(fVar.eou)) {
                this.jzb.setText(com.baidu.tieba.hottopic.b.a.aS(fVar.eou, 10));
            } else {
                this.jzb.setText("");
            }
            this.jzb.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jzp = HotTopicHeaderView.this.jzb.getMeasuredHeight();
                    HotTopicHeaderView.this.jzb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jzc.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", at.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.jwW)) {
                this.jzd.setVisibility(8);
            } else {
                if (k.byteLength(fVar.jwW) > 500) {
                    this.Oa = at.cutChineseAndEnglishWithSuffix(fVar.jwW, 500, "");
                } else {
                    this.Oa = fVar.jwW;
                }
                this.jzd.setText(this.Oa);
                this.jzn = this.jzd.getLineCount();
                if (this.jzn > 3) {
                    this.jzd.setMovementMethod(LinkMovementMethod.getInstance());
                    cHJ();
                }
                this.jzd.setVisibility(0);
                this.jzd.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.jwY > 0 && fVar.jwY <= 20) {
                this.jze.setVisibility(0);
                this.jzh.setText(fVar.eou.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.jwY);
                this.jzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new aq("c10813").dK("obj_name", fVar.eou));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jze.setVisibility(8);
            }
            this.jzj.notifyDataSetChanged();
            this.jzk.setVisibility(0);
        }
    }

    public boolean cHK() {
        return this.jzm;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jzj, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.jzb, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jzc, R.color.cp_cont_h, 1);
            ap.setViewTextColor(this.jzd, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jzk, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.jzh, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.jzi, R.color.cp_cont_j, 1);
            ap.setBackgroundResource(this.jzg, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jzf, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jzl, R.color.cp_bg_line_c);
            this.jzj.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jzl != null) {
            this.jzl.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.frT != null) {
            this.frT.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jzq == null || StringUtils.isNull(this.jzq.jwX)) ? false : true;
        int i = this.jzp;
        if (this.hWo != null) {
            i += this.hWo.getMeasuredHeight();
        }
        return z ? this.jzp + this.jzo : i;
    }

    public void BC(int i) {
        ((LinearLayout.LayoutParams) this.hWo.getLayoutParams()).height = i;
        this.hWo.postInvalidate();
    }
}
