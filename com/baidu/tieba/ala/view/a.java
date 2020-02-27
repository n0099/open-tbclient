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
    private d.a eBp;
    private String ehM;
    private boolean ehN;
    private TextView fAd;
    private HeadImageView fAe;
    private TextView fAf;
    private TextView fAg;
    private TextView fAh;
    private TextView fAi;
    private TextView fwA;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.ehM = str;
        this.ehN = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.ehM) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehM) || "hour".equals(this.ehM) || "charm_day".equals(this.ehM)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            sm();
            this.fAd = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fAe = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fwA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fAf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fAg = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.fAi = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.fAh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fAh.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fAh.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.fAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBp != null) {
                        a.this.eBp.f(view, a.this.ehM);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ehM) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ehM) || "rich".equals(this.ehM)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.fAd = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fAe = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fwA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fAf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fAh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fAh.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fAh.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ehM) && this.ehN) {
                this.fAh.setVisibility(8);
            } else {
                this.fAh.setVisibility(0);
            }
            this.fAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBp != null) {
                        a.this.eBp.f(view, a.this.ehM);
                    }
                }
            });
        }
        if (this.fAe != null) {
            this.fAe.setIsRound(true);
            this.fAe.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.eBp = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.ehN) {
                this.fAh.setVisibility(8);
                if (nVar.eAm) {
                    this.fAi.setVisibility(0);
                    this.fAi.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAg)));
                    return;
                }
                this.fAi.setVisibility(8);
            } else if (nVar.eAm) {
                this.fAh.setVisibility(8);
                this.fAi.setVisibility(0);
                this.fAi.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAg)));
            } else {
                this.fAh.setVisibility(0);
                this.fAi.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.ehM, "hour")) {
                if (nVar.eAf <= 0) {
                    this.fAd.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fAd.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fAd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAd.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAd.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.fAd.setText(String.valueOf(nVar.eAf));
                    this.fAd.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fAd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAd.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAd.setLayoutParams(layoutParams2);
                    if (nVar.eAf == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAg - nVar.eAi) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.eAf >= 2 && nVar.eAf <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.eAh - nVar.eAg) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.eAf > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.eAk - nVar.eAg) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.ehM, "charm_day")) {
                if (nVar.eAf <= 0 || nVar.eAf > 100) {
                    this.fAd.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fAd.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fAd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fAd.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAd.setLayoutParams(layoutParams3);
                    if (nVar.eAg <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.eAk - nVar.eAg) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.fAd.setText(String.valueOf(nVar.eAf));
                    this.fAd.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fAd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fAd.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAd.setLayoutParams(layoutParams4);
                    if (nVar.eAf == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAg - nVar.eAi) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.eAh - nVar.eAg) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.fAg != null) {
                if ((nVar.eAf == 1 && nVar.beA()) || nVar.eAm) {
                    this.fAg.setVisibility(8);
                } else {
                    this.fAg.setVisibility(0);
                    this.fAg.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.eAj)) {
                this.fAe.startLoad(nVar.eAj, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.fAf == null || StringUtils.isNull(this.fAf.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.fwA.setText(nameShow);
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
