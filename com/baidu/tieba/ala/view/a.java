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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.view.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class a {
    private View contentView;
    private d.a dIz;
    private String duF;
    private boolean duG;
    private TextView eAg;
    private TextView eDG;
    private HeadImageView eDH;
    private TextView eDI;
    private TextView eDJ;
    private TextView eDK;
    private TextView eDL;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.duF = str;
        this.duG = z;
        initView();
    }

    public void initView() {
        if ("hot".equals(this.duF) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.duF) || "hour".equals(this.duF) || "charm_day".equals(this.duF)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            pC();
            this.eDG = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.eDH = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.eAg = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.eDI = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.eDJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.eDL = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.eDK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            this.eDK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.eDK.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.eDK.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.eDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dIz != null) {
                        a.this.dIz.f(view, a.this.duF);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.duF) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.duF) || "rich".equals(this.duF)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.eDG = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.eDH = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.eAg = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.eDI = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.eDK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.eDK.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.eDK.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.duF) && this.duG) {
                this.eDK.setVisibility(8);
            } else {
                this.eDK.setVisibility(0);
            }
            this.eDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dIz != null) {
                        a.this.dIz.f(view, a.this.duF);
                    }
                }
            });
        } else if ("pk".equals(this.duF)) {
        }
        if (this.eDH != null) {
            this.eDH.setIsRound(true);
            this.eDH.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.dIz = aVar;
    }

    private void a(com.baidu.tieba.ala.data.f fVar) {
        if (fVar != null) {
            if (this.duG) {
                this.eDK.setVisibility(8);
                if (fVar.dHz) {
                    this.eDL.setVisibility(0);
                    this.eDL.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(fVar.dHt)));
                    return;
                }
                this.eDL.setVisibility(8);
            } else if (fVar.dHz) {
                this.eDK.setVisibility(8);
                this.eDL.setVisibility(0);
                this.eDL.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(fVar.dHt)));
            } else {
                this.eDK.setVisibility(0);
                this.eDL.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.ala.data.f fVar) {
        int i = 10;
        if (fVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.duF, "hour")) {
                if (fVar.dHs <= 0) {
                    this.eDG.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.eDG.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.eDG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eDG.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eDG.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.eDG.setText(String.valueOf(fVar.dHs));
                    this.eDG.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.eDG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eDG.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eDG.setLayoutParams(layoutParams2);
                    if (fVar.dHs == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(fVar.dHt - fVar.dHv) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (fVar.dHs >= 2 && fVar.dHs <= 10) {
                        String str = StringHelper.formatForHourRankValue((fVar.dHu - fVar.dHt) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (fVar.dHs > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatForHourRankValue(fVar.dHx - fVar.dHt) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.duF, "charm_day")) {
                if (fVar.dHs <= 0 || fVar.dHs > 100) {
                    this.eDG.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.eDG.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.eDG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eDG.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eDG.setLayoutParams(layoutParams3);
                    if (fVar.dHt <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(fVar.dHx - fVar.dHt) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.eDG.setText(String.valueOf(fVar.dHs));
                    this.eDG.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.eDG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eDG.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eDG.setLayoutParams(layoutParams4);
                    if (fVar.dHs == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(fVar.dHt - fVar.dHv) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((fVar.dHu - fVar.dHt) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.eDJ != null) {
                if ((fVar.dHs == 1 && fVar.aKG()) || fVar.dHz) {
                    this.eDJ.setVisibility(8);
                } else {
                    this.eDJ.setVisibility(0);
                    this.eDJ.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(fVar.dHw)) {
                this.eDH.startLoad(fVar.dHw, 12, false);
            }
            if (!StringUtils.isNull(fVar.getNameShow())) {
                String nameShow = fVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(fVar.getNameShow());
                i = (this.eDI == null || StringUtils.isNull(this.eDI.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(fVar.getNameShow(), i));
                }
                this.eAg.setText(nameShow);
            }
            a(fVar);
        }
    }

    public void pC() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
