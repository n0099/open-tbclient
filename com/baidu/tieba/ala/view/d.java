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
    private g.a gUQ;
    private String gpD;
    private boolean gpE;
    private TextView ibW;
    private TextView iiA;
    private HeadImageView iiB;
    private TextView iiC;
    private TextView iiD;
    private TextView iiE;
    private TextView iiF;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.gpD = str;
        this.gpE = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.gpD) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gpD) || "hour".equals(this.gpD) || "charm_day".equals(this.gpD)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            EK();
            this.iiA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.iiB = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.ibW = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.iiC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.iiD = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.iiF = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.iiE = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            this.iiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gUQ != null) {
                        d.this.gUQ.h(view, d.this.gpD);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.gpD) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.gpD) || "rich".equals(this.gpD)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.iiA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.iiB = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.ibW = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.iiC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.iiE = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.gpD) && this.gpE) {
                this.iiE.setVisibility(8);
            } else {
                this.iiE.setVisibility(0);
            }
            this.iiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gUQ != null) {
                        d.this.gUQ.h(view, d.this.gpD);
                    }
                }
            });
        }
        if (this.iiB != null) {
            this.iiB.setIsRound(true);
            this.iiB.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gUQ = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.gpE) {
                this.iiE.setVisibility(8);
                if (rVar.gTg) {
                    this.iiF.setVisibility(0);
                    this.iiF.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aGz)));
                    return;
                }
                this.iiF.setVisibility(8);
            } else if (rVar.gTg) {
                this.iiE.setVisibility(8);
                this.iiF.setVisibility(0);
                this.iiF.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aGz)));
            } else {
                this.iiE.setVisibility(0);
                this.iiF.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.gpD, "hour")) {
                if (rVar.aGy <= 0) {
                    this.iiA.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.iiA.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.iiA.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iiA.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iiA.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.iiA.setText(String.valueOf(rVar.aGy));
                    this.iiA.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.iiA.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iiA.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iiA.setLayoutParams(layoutParams2);
                    if (rVar.aGy == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aGz - rVar.aGB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aGy >= 2 && rVar.aGy <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aGA - rVar.aGz) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aGy > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatForHourRankValue(rVar.aGD - rVar.aGz) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.gpD, "charm_day")) {
                if (rVar.aGy <= 0 || rVar.aGy > 100) {
                    this.iiA.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.iiA.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.iiA.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.iiA.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iiA.setLayoutParams(layoutParams3);
                    if (rVar.aGz <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue(rVar.aGD - rVar.aGz) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 4, format3.length(), 34);
                    }
                } else {
                    this.iiA.setText(String.valueOf(rVar.aGy));
                    this.iiA.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.iiA.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iiA.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.iiA.setLayoutParams(layoutParams4);
                    if (rVar.aGy == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aGz - rVar.aGB) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aGA - rVar.aGz) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.iiD != null) {
                if ((rVar.aGy == 1 && rVar.bUB()) || rVar.gTg) {
                    this.iiD.setVisibility(8);
                } else {
                    this.iiD.setVisibility(0);
                    this.iiD.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.iiB.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.iiC == null || StringUtils.isNull(this.iiC.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.ibW.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void EK() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
