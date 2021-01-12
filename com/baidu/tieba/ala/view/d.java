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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.data.r;
import com.baidu.tieba.ala.view.g;
import com.bytedance.sdk.openadsdk.preload.falconx.statistic.StatisticData;
import com.tencent.connect.common.Constants;
/* loaded from: classes10.dex */
public class d {
    private View contentView;
    private g.a gSg;
    private String gmU;
    private boolean gmV;
    private TextView hXC;
    private TextView idG;
    private HeadImageView idH;
    private TextView idI;
    private TextView idJ;
    private TextView idK;
    private TextView idL;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.gmU = str;
        this.gmV = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.gmU) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gmU) || "hour".equals(this.gmU) || "charm_day".equals(this.gmU)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            Du();
            this.idG = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.idH = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hXC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.idI = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.idJ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.idL = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.idK = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.idK.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.idK.setBackgroundResource(a.e.qm_hour_rank_list_support_bg);
            }
            this.idK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gSg != null) {
                        d.this.gSg.g(view, d.this.gmU);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.gmU) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.gmU) || "rich".equals(this.gmU)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.idG = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.idH = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hXC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.idI = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.idK = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.idK.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.idK.setBackgroundResource(a.e.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.gmU) && this.gmV) {
                this.idK.setVisibility(8);
            } else {
                this.idK.setVisibility(0);
            }
            this.idK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gSg != null) {
                        d.this.gSg.g(view, d.this.gmU);
                    }
                }
            });
        }
        if (this.idH != null) {
            this.idH.setIsRound(true);
            this.idH.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gSg = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.gmV) {
                this.idK.setVisibility(8);
                if (rVar.gQw) {
                    this.idL.setVisibility(0);
                    this.idL.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aEM)));
                    return;
                }
                this.idL.setVisibility(8);
            } else if (rVar.gQw) {
                this.idK.setVisibility(8);
                this.idL.setVisibility(0);
                this.idL.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aEM)));
            } else {
                this.idK.setVisibility(0);
                this.idL.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.gmU, "hour")) {
                if (rVar.aEL <= 0) {
                    this.idG.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.idG.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.idG.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.idG.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.idG.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.idG.setText(String.valueOf(rVar.aEL));
                    this.idG.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.idG.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.idG.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.idG.setLayoutParams(layoutParams2);
                    if (rVar.aEL == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aEM - rVar.aEO) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aEL >= 2 && rVar.aEL <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aEN - rVar.aEM) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aEL > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatForHourRankValue(rVar.aEQ - rVar.aEM) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.gmU, "charm_day")) {
                if (rVar.aEL <= 0 || rVar.aEL > 100) {
                    this.idG.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.idG.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.idG.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.idG.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.idG.setLayoutParams(layoutParams3);
                    if (rVar.aEM <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue(rVar.aEQ - rVar.aEM) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 4, format3.length(), 34);
                    }
                } else {
                    this.idG.setText(String.valueOf(rVar.aEL));
                    this.idG.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.idG.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.idG.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.idG.setLayoutParams(layoutParams4);
                    if (rVar.aEL == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aEM - rVar.aEO) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aEN - rVar.aEM) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.idJ != null) {
                if ((rVar.aEL == 1 && rVar.bTW()) || rVar.gQw) {
                    this.idJ.setVisibility(8);
                } else {
                    this.idJ.setVisibility(0);
                    this.idJ.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.idH.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.idI == null || StringUtils.isNull(this.idI.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.hXC.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void Du() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
