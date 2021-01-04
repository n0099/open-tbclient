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
/* loaded from: classes11.dex */
public class d {
    private View contentView;
    private g.a gWM;
    private String grB;
    private boolean grC;
    private TextView icj;
    private TextView iin;
    private HeadImageView iio;
    private TextView iip;
    private TextView iiq;
    private TextView iir;
    private TextView iis;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.grB = str;
        this.grC = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.grB) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grB) || "hour".equals(this.grB) || "charm_day".equals(this.grB)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            Hp();
            this.iin = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.iio = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.icj = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.iip = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.iiq = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.iis = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.iir = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.iir.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.iir.setBackgroundResource(a.e.qm_hour_rank_list_support_bg);
            }
            this.iir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gWM != null) {
                        d.this.gWM.g(view, d.this.grB);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.grB) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.grB) || "rich".equals(this.grB)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.iin = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.iio = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.icj = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.iip = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.iir = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.iir.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.iir.setBackgroundResource(a.e.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.grB) && this.grC) {
                this.iir.setVisibility(8);
            } else {
                this.iir.setVisibility(0);
            }
            this.iir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gWM != null) {
                        d.this.gWM.g(view, d.this.grB);
                    }
                }
            });
        }
        if (this.iio != null) {
            this.iio.setIsRound(true);
            this.iio.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gWM = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.grC) {
                this.iir.setVisibility(8);
                if (rVar.gVc) {
                    this.iis.setVisibility(0);
                    this.iis.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aJz)));
                    return;
                }
                this.iis.setVisibility(8);
            } else if (rVar.gVc) {
                this.iir.setVisibility(8);
                this.iis.setVisibility(0);
                this.iis.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aJz)));
            } else {
                this.iir.setVisibility(0);
                this.iis.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.grB, "hour")) {
                if (rVar.aJy <= 0) {
                    this.iin.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.iin.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.iin.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iin.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iin.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.iin.setText(String.valueOf(rVar.aJy));
                    this.iin.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.iin.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iin.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iin.setLayoutParams(layoutParams2);
                    if (rVar.aJy == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aJz - rVar.aJB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aJy >= 2 && rVar.aJy <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aJA - rVar.aJz) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aJy > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatForHourRankValue(rVar.aJD - rVar.aJz) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.grB, "charm_day")) {
                if (rVar.aJy <= 0 || rVar.aJy > 100) {
                    this.iin.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.iin.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.iin.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iin.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iin.setLayoutParams(layoutParams3);
                    if (rVar.aJz <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue(rVar.aJD - rVar.aJz) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 4, format3.length(), 34);
                    }
                } else {
                    this.iin.setText(String.valueOf(rVar.aJy));
                    this.iin.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.iin.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iin.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iin.setLayoutParams(layoutParams4);
                    if (rVar.aJy == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aJz - rVar.aJB) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aJA - rVar.aJz) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.iiq != null) {
                if ((rVar.aJy == 1 && rVar.bXN()) || rVar.gVc) {
                    this.iiq.setVisibility(8);
                } else {
                    this.iiq.setVisibility(0);
                    this.iiq.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.iio.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.iip == null || StringUtils.isNull(this.iip.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.icj.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void Hp() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
