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
/* loaded from: classes4.dex */
public class d {
    private View contentView;
    private String fYQ;
    private boolean fYR;
    private g.a gCb;
    private TextView hGe;
    private TextView hKR;
    private HeadImageView hKS;
    private TextView hKT;
    private TextView hKU;
    private TextView hKV;
    private TextView hKW;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.fYQ = str;
        this.fYR = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fYQ) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fYQ) || "hour".equals(this.fYQ) || "charm_day".equals(this.fYQ)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            FZ();
            this.hKR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.hKS = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hGe = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.hKT = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.hKU = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.hKW = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.hKV = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hKV.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.hKV.setBackgroundResource(a.e.qm_hour_rank_list_support_bg);
            }
            this.hKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gCb != null) {
                        d.this.gCb.g(view, d.this.fYQ);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fYQ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fYQ) || "rich".equals(this.fYQ)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.hKR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.hKS = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hGe = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.hKT = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.hKV = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hKV.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.hKV.setBackgroundResource(a.e.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fYQ) && this.fYR) {
                this.hKV.setVisibility(8);
            } else {
                this.hKV.setVisibility(0);
            }
            this.hKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gCb != null) {
                        d.this.gCb.g(view, d.this.fYQ);
                    }
                }
            });
        }
        if (this.hKS != null) {
            this.hKS.setIsRound(true);
            this.hKS.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gCb = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.fYR) {
                this.hKV.setVisibility(8);
                if (rVar.gAq) {
                    this.hKW.setVisibility(0);
                    this.hKW.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aGs)));
                    return;
                }
                this.hKW.setVisibility(8);
            } else if (rVar.gAq) {
                this.hKV.setVisibility(8);
                this.hKW.setVisibility(0);
                this.hKW.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aGs)));
            } else {
                this.hKV.setVisibility(0);
                this.hKW.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fYQ, "hour")) {
                if (rVar.aGr <= 0) {
                    this.hKR.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.hKR.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.hKR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKR.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hKR.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.hKR.setText(String.valueOf(rVar.aGr));
                    this.hKR.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.hKR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hKR.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hKR.setLayoutParams(layoutParams2);
                    if (rVar.aGr == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aGs - rVar.aGu) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aGr >= 2 && rVar.aGr <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aGt - rVar.aGs) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aGr > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(rVar.aGw - rVar.aGs) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fYQ, "charm_day")) {
                if (rVar.aGr <= 0 || rVar.aGr > 100) {
                    this.hKR.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.hKR.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.hKR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hKR.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hKR.setLayoutParams(layoutParams3);
                    if (rVar.aGs <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(rVar.aGw - rVar.aGs) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.hKR.setText(String.valueOf(rVar.aGr));
                    this.hKR.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.hKR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.hKR.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hKR.setLayoutParams(layoutParams4);
                    if (rVar.aGr == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aGs - rVar.aGu) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aGt - rVar.aGs) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.hKU != null) {
                if ((rVar.aGr == 1 && rVar.bRx()) || rVar.gAq) {
                    this.hKU.setVisibility(8);
                } else {
                    this.hKU.setVisibility(0);
                    this.hKU.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.hKS.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.hKT == null || StringUtils.isNull(this.hKT.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.hGe.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void FZ() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
