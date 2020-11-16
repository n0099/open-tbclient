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
/* loaded from: classes20.dex */
public class HotTopicHeaderView extends LinearLayout {
    private String Ob;
    private View dividerLine;
    private com.baidu.tbadk.widget.layout.e fFI;
    private View ipB;
    private TbImageView jSg;
    private TextView jSh;
    private TextView jSi;
    private TextView jSj;
    private LinearLayout jSk;
    private LinearLayout jSl;
    private ImageView jSm;
    private TextView jSn;
    private TextView jSo;
    private PagerSlidingTabStrip jSp;
    private View jSq;
    private ImageView jSr;
    private boolean jSs;
    private int jSt;
    private int jSu;
    private int jSv;
    private f jSw;
    private View.OnClickListener jSx;
    private ClickableSpan jSy;
    private ClickableSpan jSz;
    private int mSkinType;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jSs = false;
        this.Ob = "";
        this.jSu = 0;
        this.jSv = 0;
        this.jSx = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jSw != null && !StringUtils.isNull(HotTopicHeaderView.this.jSw.jQm)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jSw.jQm);
                }
            }
        };
        this.jSy = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Ob);
                if (HotTopicHeaderView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jSz, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jSj.setText(spannableString);
                HotTopicHeaderView.this.jSj.setHeight(HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jSj.getLineCount() * HotTopicHeaderView.this.jSj.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight()) {
                    HotTopicHeaderView.this.jSj.scrollTo(0, lineCount - (HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight()));
                }
                HotTopicHeaderView.this.jSj.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.jSz = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jSj.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cMX();
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
        this.jSs = false;
        this.Ob = "";
        this.jSu = 0;
        this.jSv = 0;
        this.jSx = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jSw != null && !StringUtils.isNull(HotTopicHeaderView.this.jSw.jQm)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jSw.jQm);
                }
            }
        };
        this.jSy = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Ob);
                if (HotTopicHeaderView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jSz, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jSj.setText(spannableString);
                HotTopicHeaderView.this.jSj.setHeight(HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jSj.getLineCount() * HotTopicHeaderView.this.jSj.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight()) {
                    HotTopicHeaderView.this.jSj.scrollTo(0, lineCount - (HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight()));
                }
                HotTopicHeaderView.this.jSj.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.jSz = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jSj.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cMX();
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
        this.jSs = false;
        this.Ob = "";
        this.jSu = 0;
        this.jSv = 0;
        this.jSx = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicHeaderView.this.jSw != null && !StringUtils.isNull(HotTopicHeaderView.this.jSw.jQm)) {
                    com.baidu.tbadk.browser.a.startWebActivity(HotTopicHeaderView.this.getContext(), HotTopicHeaderView.this.jSw.jQm);
                }
            }
        };
        this.jSy = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) HotTopicHeaderView.this.Ob);
                if (HotTopicHeaderView.this.Ob.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = HotTopicHeaderView.this.getResources().getString(R.string.hot_topic_coll) + "  ";
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(HotTopicHeaderView.this.jSz, spannableString.length() - str.length(), spannableString.length(), 33);
                HotTopicHeaderView.this.jSj.setText(spannableString);
                HotTopicHeaderView.this.jSj.setHeight(HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight());
                int lineCount = HotTopicHeaderView.this.jSj.getLineCount() * HotTopicHeaderView.this.jSj.getLineHeight();
                if (lineCount > HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight()) {
                    HotTopicHeaderView.this.jSj.scrollTo(0, lineCount - (HotTopicHeaderView.this.jSt * HotTopicHeaderView.this.jSj.getLineHeight()));
                }
                HotTopicHeaderView.this.jSj.requestLayout();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        this.jSz = new ClickableSpan() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                HotTopicHeaderView.this.jSj.setText(HotTopicHeaderView.this.Ob);
                HotTopicHeaderView.this.cMX();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(HotTopicHeaderView.this.getResources().getColor(R.color.CAM_X0304));
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jSu = l.getDimens(context, R.dimen.tbds418);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
        this.ipB = findViewById(R.id.hot_topic_info_place_holder);
        this.jSg = (TbImageView) findViewById(R.id.hot_topic_info_picture);
        this.jSg.setOnClickListener(this.jSx);
        this.jSh = (TextView) findViewById(R.id.hot_topic_info_title);
        this.jSi = (TextView) findViewById(R.id.hot_topic_info_threadcount);
        this.jSj = (TextView) findViewById(R.id.hot_topic_info_abstract);
        this.dividerLine = findViewById(R.id.divider_line);
        this.dividerLine.setVisibility(8);
        this.jSk = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
        this.jSl = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
        this.jSn = (TextView) findViewById(R.id.hot_topic_ranklist_title);
        this.jSm = (ImageView) findViewById(R.id.ranklist_pic_r);
        this.jSo = (TextView) findViewById(R.id.hot_topic_look_ranklist);
        this.jSp = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
        this.jSp.b(l.getDimens(context, R.dimen.ds32), l.getDimens(context, R.dimen.ds1), l.getDimens(context, R.dimen.ds4), true);
        this.jSq = findViewById(R.id.tab_divider_line);
        this.jSq.setVisibility(8);
        this.jSr = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
        onChangeSkinType();
    }

    public void setOnSizeChangeListener(com.baidu.tbadk.widget.layout.e eVar) {
        this.fFI = eVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jSp != null) {
            this.jSp.setViewPager(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMX() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Ob);
        String string = getResources().getString(R.string.hot_topic_detail);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.jSj.getLayout().getLineEnd(2) - string.length()) - ("...  ".length() / 2));
        spannableStringBuilder2.append((CharSequence) "...  ");
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append((CharSequence) string);
        SpannableString spannableString = new SpannableString(spannableStringBuilder2);
        spannableString.setSpan(this.jSy, length - 1, spannableString.length(), 33);
        this.jSj.setText(spannableString);
        this.jSj.setHeight(this.jSj.getLineHeight() * 3);
        this.jSj.scrollTo(0, 0);
        this.jSj.requestLayout();
    }

    public void setData(final f fVar) {
        if (fVar != null && !StringUtils.isNull(fVar.eBa)) {
            this.jSw = fVar;
            this.jSs = true;
            this.jSg.setDefaultBgResource(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jSg.getLayoutParams();
            layoutParams.height = this.jSu;
            this.jSg.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(fVar.jQe) && StringUtils.isNull(fVar.videoUrl)) {
                this.jSg.startLoad(fVar.jQe, 10, false);
                this.ipB.setVisibility(8);
            } else {
                this.jSg.setVisibility(8);
                this.ipB.setVisibility(0);
            }
            this.jSh.setSingleLine();
            fVar.eBa = fVar.eBa.trim();
            if (!StringUtils.isNull(fVar.eBa)) {
                this.jSh.setText(com.baidu.tieba.hottopic.b.a.aU(fVar.eBa, 10));
            } else {
                this.jSh.setText("");
            }
            this.jSh.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HotTopicHeaderView.this.jSv = HotTopicHeaderView.this.jSh.getMeasuredHeight();
                    HotTopicHeaderView.this.jSh.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            this.jSi.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", au.longNumFormatOver9999wan(fVar.postNum)));
            if (StringUtils.isNull(fVar.jQd)) {
                this.jSj.setVisibility(8);
            } else {
                if (k.byteLength(fVar.jQd) > 500) {
                    this.Ob = au.cutChineseAndEnglishWithSuffix(fVar.jQd, 500, "");
                } else {
                    this.Ob = fVar.jQd;
                }
                this.jSj.setText(this.Ob);
                this.jSt = this.jSj.getLineCount();
                if (this.jSt > 3) {
                    this.jSj.setMovementMethod(LinkMovementMethod.getInstance());
                    cMX();
                }
                this.jSj.setVisibility(0);
                this.jSj.setHighlightColor(getResources().getColor(R.color.transparent));
            }
            if (fVar.jQf > 0 && fVar.jQf <= 20) {
                this.jSk.setVisibility(0);
                this.jSn.setText(fVar.eBa.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.jQf);
                this.jSl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicHeaderView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(view.getContext()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, fVar.tagType)));
                        TiebaStatic.log(new ar("c10813").dR("obj_name", fVar.eBa));
                    }
                });
                this.dividerLine.setVisibility(0);
            } else {
                this.dividerLine.setVisibility(8);
                this.jSk.setVisibility(8);
            }
            this.jSp.notifyDataSetChanged();
            this.jSq.setVisibility(0);
        }
    }

    public boolean cMY() {
        return this.jSs;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0201);
            ap.setBackgroundColor(this.jSp, R.color.CAM_X0201);
            ap.setViewTextColor(this.jSh, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.jSi, R.color.CAM_X0301, 1);
            ap.setViewTextColor(this.jSj, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0205);
            ap.setBackgroundColor(this.jSq, R.color.CAM_X0205);
            ap.setViewTextColor(this.jSn, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.jSo, R.color.CAM_X0107, 1);
            ap.setBackgroundResource(this.jSm, R.drawable.icon_arrow_more_gray);
            ap.setBackgroundResource(this.jSl, R.drawable.hot_topic_ranklist_bg);
            ap.setBackgroundColor(this.jSr, R.color.CAM_X0204);
            this.jSp.onChangeSkinType();
        }
    }

    public void setHeaderBottomLineShow(boolean z) {
        if (this.jSr != null) {
            this.jSr.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fFI != null) {
            this.fFI.d(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNavigationBarSwitchHeight() {
        boolean z = (this.jSw == null || StringUtils.isNull(this.jSw.jQe)) ? false : true;
        int i = this.jSv;
        if (this.ipB != null) {
            i += this.ipB.getMeasuredHeight();
        }
        return z ? this.jSv + this.jSu : i;
    }

    public void CG(int i) {
        ((LinearLayout.LayoutParams) this.ipB.getLayoutParams()).height = i;
        this.ipB.postInvalidate();
    }
}
