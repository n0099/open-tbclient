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
/* loaded from: classes10.dex */
public class d {
    private View contentView;
    private g.a gWN;
    private String grA;
    private boolean grB;
    private TextView idX;
    private TextView ikA;
    private TextView ikB;
    private TextView ikC;
    private TextView ikx;
    private HeadImageView iky;
    private TextView ikz;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.grA = str;
        this.grB = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.grA) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grA) || "hour".equals(this.grA) || "charm_day".equals(this.grA)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            EN();
            this.ikx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.iky = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.idX = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.ikz = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.ikA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.ikC = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.ikB = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            this.ikB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gWN != null) {
                        d.this.gWN.h(view, d.this.grA);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.grA) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.grA) || "rich".equals(this.grA)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.ikx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.iky = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.idX = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.ikz = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.ikB = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.grA) && this.grB) {
                this.ikB.setVisibility(8);
            } else {
                this.ikB.setVisibility(0);
            }
            this.ikB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gWN != null) {
                        d.this.gWN.h(view, d.this.grA);
                    }
                }
            });
        }
        if (this.iky != null) {
            this.iky.setIsRound(true);
            this.iky.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gWN = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.grB) {
                this.ikB.setVisibility(8);
                if (rVar.gVd) {
                    this.ikC.setVisibility(0);
                    this.ikC.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aHZ)));
                    return;
                }
                this.ikC.setVisibility(8);
            } else if (rVar.gVd) {
                this.ikB.setVisibility(8);
                this.ikC.setVisibility(0);
                this.ikC.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aHZ)));
            } else {
                this.ikB.setVisibility(0);
                this.ikC.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.grA, "hour")) {
                if (rVar.aHY <= 0) {
                    this.ikx.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.ikx.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.ikx.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ikx.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.ikx.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.ikx.setText(String.valueOf(rVar.aHY));
                    this.ikx.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.ikx.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ikx.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.ikx.setLayoutParams(layoutParams2);
                    if (rVar.aHY == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aHZ - rVar.aIb) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aHY >= 2 && rVar.aHY <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aIa - rVar.aHZ) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aHY > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatForHourRankValue(rVar.aId - rVar.aHZ) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.grA, "charm_day")) {
                if (rVar.aHY <= 0 || rVar.aHY > 100) {
                    this.ikx.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.ikx.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.ikx.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ikx.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.ikx.setLayoutParams(layoutParams3);
                    if (rVar.aHZ <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue(rVar.aId - rVar.aHZ) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 4, format3.length(), 34);
                    }
                } else {
                    this.ikx.setText(String.valueOf(rVar.aHY));
                    this.ikx.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.ikx.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ikx.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.ikx.setLayoutParams(layoutParams4);
                    if (rVar.aHY == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aHZ - rVar.aIb) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aIa - rVar.aHZ) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.ikA != null) {
                if ((rVar.aHY == 1 && rVar.bUO()) || rVar.gVd) {
                    this.ikA.setVisibility(8);
                } else {
                    this.ikA.setVisibility(0);
                    this.ikA.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.iky.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.ikz == null || StringUtils.isNull(this.ikz.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.idX.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void EN() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
