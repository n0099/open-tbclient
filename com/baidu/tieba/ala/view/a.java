package com.baidu.tieba.ala.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.d;
/* loaded from: classes3.dex */
public class a {
    private View contentView;
    private d.a eBq;
    private String ehN;
    private boolean ehO;
    private TextView fAf;
    private HeadImageView fAg;
    private TextView fAh;
    private TextView fAi;
    private TextView fAj;
    private TextView fAk;
    private TextView fwB;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.ehN = str;
        this.ehO = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.ehN) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehN) || "hour".equals(this.ehN) || "charm_day".equals(this.ehN)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            sm();
            this.fAf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fAg = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fwB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fAh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fAi = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.fAk = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.fAj = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fAj.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fAj.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.fAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBq != null) {
                        a.this.eBq.f(view, a.this.ehN);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ehN) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ehN) || "rich".equals(this.ehN)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.fAf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fAg = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fwB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fAh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fAj = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fAj.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fAj.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ehN) && this.ehO) {
                this.fAj.setVisibility(8);
            } else {
                this.fAj.setVisibility(0);
            }
            this.fAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBq != null) {
                        a.this.eBq.f(view, a.this.ehN);
                    }
                }
            });
        }
        if (this.fAg != null) {
            this.fAg.setIsRound(true);
            this.fAg.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.eBq = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.ehO) {
                this.fAj.setVisibility(8);
                if (nVar.eAn) {
                    this.fAk.setVisibility(0);
                    this.fAk.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAh)));
                    return;
                }
                this.fAk.setVisibility(8);
            } else if (nVar.eAn) {
                this.fAj.setVisibility(8);
                this.fAk.setVisibility(0);
                this.fAk.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAh)));
            } else {
                this.fAj.setVisibility(0);
                this.fAk.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.ehN, "hour")) {
                if (nVar.eAg <= 0) {
                    this.fAf.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fAf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fAf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAf.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAf.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.fAf.setText(String.valueOf(nVar.eAg));
                    this.fAf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fAf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAf.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAf.setLayoutParams(layoutParams2);
                    if (nVar.eAg == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAh - nVar.eAj) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.eAg >= 2 && nVar.eAg <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.eAi - nVar.eAh) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.eAg > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.eAl - nVar.eAh) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.ehN, "charm_day")) {
                if (nVar.eAg <= 0 || nVar.eAg > 100) {
                    this.fAf.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fAf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fAf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fAf.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAf.setLayoutParams(layoutParams3);
                    if (nVar.eAh <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.eAl - nVar.eAh) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.fAf.setText(String.valueOf(nVar.eAg));
                    this.fAf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fAf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fAf.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAf.setLayoutParams(layoutParams4);
                    if (nVar.eAg == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAh - nVar.eAj) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.eAi - nVar.eAh) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.fAi != null) {
                if ((nVar.eAg == 1 && nVar.beC()) || nVar.eAn) {
                    this.fAi.setVisibility(8);
                } else {
                    this.fAi.setVisibility(0);
                    this.fAi.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.eAk)) {
                this.fAg.startLoad(nVar.eAk, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.fAh == null || StringUtils.isNull(this.fAh.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.fwB.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void sm() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
