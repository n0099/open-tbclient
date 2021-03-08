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
/* loaded from: classes7.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String Qu;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fWg;
    private View iPF;
    private TbImageView kyQ;
    private TextView kyR;
    private TextView kyS;
    private TextView kyT;
    private LinearLayout kyU;
    private LinearLayout kyV;
    private ImageView kyW;
    private TextView kyX;
    private TextView kyY;
    private PagerSlidingTabStrip kyZ;
    private View kza;
    private ImageView kzb;
    private boolean kzc;
    private int kzd;
    private int kze;
    private int kzf;
    private f kzg;
    private View.OnClickListener kzh;
    private ClickableSpan kzi;
    private ClickableSpan kzj;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kzc = false;
        this.Qu = "";
        this.kze = 0;
        this.kzf = 0;
        this.kzh = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kzg != null && !StringUtils.isNull(HotTopicHeaderView.this.kzg.kwW)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kzg.kwW);
                }
            }
        };
        this.kzi = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Qu);
                if (HotTopicHeaderView.this.Qu.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kzj, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kyT.setText(spannableString);
                HotTopicHeaderView.this.kyT.setHeight(HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kyT.getLineCount() * HotTopicHeaderView.this.kyT.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight()) {
                    HotTopicHeaderView.this.kyT.scrollTo(0, lineCount - (HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight()));
                }
                HotTopicHeaderView.this.kyT.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kzj = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kyT.setText(HotTopicHeaderView.this.Qu);
                HotTopicHeaderView.this.cTO();
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
        this.kzc = false;
        this.Qu = "";
        this.kze = 0;
        this.kzf = 0;
        this.kzh = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kzg != null && !StringUtils.isNull(HotTopicHeaderView.this.kzg.kwW)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kzg.kwW);
                }
            }
        };
        this.kzi = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Qu);
                if (HotTopicHeaderView.this.Qu.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kzj, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kyT.setText(spannableString);
                HotTopicHeaderView.this.kyT.setHeight(HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kyT.getLineCount() * HotTopicHeaderView.this.kyT.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight()) {
                    HotTopicHeaderView.this.kyT.scrollTo(0, lineCount - (HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight()));
                }
                HotTopicHeaderView.this.kyT.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kzj = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kyT.setText(HotTopicHeaderView.this.Qu);
                HotTopicHeaderView.this.cTO();
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
        this.kzc = false;
        this.Qu = "";
        this.kze = 0;
        this.kzf = 0;
        this.kzh = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.kzg != null && !StringUtils.isNull(HotTopicHeaderView.this.kzg.kwW)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.kzg.kwW);
                }
            }
        };
        this.kzi = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Qu);
                if (HotTopicHeaderView.this.Qu.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.kzj, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.kyT.setText(spannableString);
                HotTopicHeaderView.this.kyT.setHeight(HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight());
                int lineCount = HotTopicHeaderView.this.kyT.getLineCount() * HotTopicHeaderView.this.kyT.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight()) {
                    HotTopicHeaderView.this.kyT.scrollTo(0, lineCount - (HotTopicHeaderView.this.kzd * HotTopicHeaderView.this.kyT.getLineHeight()));
                }
                HotTopicHeaderView.this.kyT.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.kzj = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.kyT.setText(HotTopicHeaderView.this.Qu);
                HotTopicHeaderView.this.cTO();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kze = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.iPF = findViewById(R.id.hot_topic_info_place_holder);
        this.kyQ = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.kyQ.setOnClickListener(this.kzh);
        this.kyR = (TextView) findViewById(R.id.hot_topic_info_title);
        this.kyS = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.kyT = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.kyU = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.kyV = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.kyX = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.kyW = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.kyY = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.kyZ = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.kyZ.c(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.kza = findViewById(R.id.tab_divider_line);
        this.kza.setVisibility(8);
        this.kzb = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fWg = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kyZ != null) {
            this.kyZ.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTO() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Qu);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.kyT.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.kzi, length - 1, spannableString.length(), 33);
        this.kyT.setText(spannableString);
        this.kyT.setHeight(this.kyT.getLineHeight() * 3);
        this.kyT.scrollTo(0, 0);
        this.kyT.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eQU)) {
            this.kzg = fVar;
            this.kzc = true;
            this.kyQ.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kyQ.getLayoutParams();
            layoutParams.height = this.kze;
            this.kyQ.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.kwN) && StringUtils.isNull(fVar.videoUrl)) {
                this.kyQ.startLoad(fVar.kwN, 10, false);
                this.iPF.setVisibility(8);
            } else {
                this.kyQ.setVisibility(8);
                this.iPF.setVisibility(0);
            }
            this.kyR.setSingleLine();
            fVar.eQU = fVar.eQU.trim();
            if (!StringUtils.isNull(fVar.eQU)) {
                this.kyR.setText(com.baidu.tieba.hottopic.a.a.be(fVar.eQU, 10));
            } else {
                this.kyR.setText("");
            }
            this.kyR.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.kzf = HotTopicHeaderView.this.kyR.getMeasuredHeight();
                    HotTopicHeaderView.this.kyR.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.kyS.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", au.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.kwM)) {
                this.kyT.setVisibility(8);
            } else {
                if (k.byteLength(fVar.kwM) > 500) {
                    this.Qu = au.cutChineseAndEnglishWithSuffix(fVar.kwM, 500, "");
                } else {
                    this.Qu = fVar.kwM;
                }
                this.kyT.setText(this.Qu);
                this.kzd = this.kyT.getLineCount();
                if (this.kzd > 3) {
                    this.kyT.setMovementMethod(LinkMovementMethod.getInstance());
                    cTO();
                }
                this.kyT.setVisibility(0);
                this.kyT.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.kwO > 0 && fVar.kwO <= 20) {
                this.kyU.setVisibility(0);
                this.kyX.setText(fVar.eQU.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.kwO);
                this.kyV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", fVar.kwS)));
                        TiebaStatic.log(new ar("c10813").dR("obj_name", fVar.eQU));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.kyU.setVisibility(8);
            }
            this.kyZ.notifyDataSetChanged();
            this.kza.setVisibility(0);
        }
    }

    public boolean cTP() {
        return this.kzc;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            ap.setBackgroundColor(this.kyZ, R.color.CAM_X0201);
            ap.setViewTextColor(this.kyR, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kyS, R.color.CAM_X0301, 1);
            ap.setViewTextColor(this.kyT, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ap.setBackgroundColor(this.kza, R.color.CAM_X0205);
            ap.setViewTextColor(this.kyX, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.kyY, R.color.CAM_X0107, 1);
            ap.setBackgroundResource(this.kyW, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.kyV, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.kzb, R.color.CAM_X0204);
            this.kyZ.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.kzb != null) {
            this.kzb.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fWg != null) {
            this.fWg.f(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.kzg == null || StringUtils.isNull(this.kzg.kwN)) ? false : true;
        int i = this.kzf;
        if (this.iPF != null) {
            i += this.iPF.getMeasuredHeight();
        }
        return z ? this.kzf + this.kze : i;
    }

    public void Cx(int i) {
        ((LinearLayout.LayoutParams) this.iPF.getLayoutParams()).height = i;
        this.iPF.postInvalidate();
    }
}
