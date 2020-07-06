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
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.d;
/* loaded from: classes3.dex */
public class a {
    private View contentView;
    private d.a fFz;
    private String fff;
    private boolean ffg;
    private TextView gDT;
    private HeadImageView gHA;
    private TextView gHB;
    private TextView gHC;
    private TextView gHD;
    private TextView gHE;
    private TextView gHz;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.fff = str;
        this.ffg = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fff) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fff) || "hour".equals(this.fff) || "charm_day".equals(this.fff)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            yA();
            this.gHz = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gHA = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gDT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gHB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gHC = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.gHE = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.gHD = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gHD.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gHD.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.gHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fFz != null) {
                        a.this.fFz.g(view, a.this.fff);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fff) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fff) || "rich".equals(this.fff)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.gHz = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gHA = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gDT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gHB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gHD = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gHD.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gHD.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fff) && this.ffg) {
                this.gHD.setVisibility(8);
            } else {
                this.gHD.setVisibility(0);
            }
            this.gHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fFz != null) {
                        a.this.fFz.g(view, a.this.fff);
                    }
                }
            });
        }
        if (this.gHA != null) {
            this.gHA.setIsRound(true);
            this.gHA.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.fFz = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.ffg) {
                this.gHD.setVisibility(8);
                if (nVar.fEv) {
                    this.gHE.setVisibility(0);
                    this.gHE.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.fEp)));
                    return;
                }
                this.gHE.setVisibility(8);
            } else if (nVar.fEv) {
                this.gHD.setVisibility(8);
                this.gHE.setVisibility(0);
                this.gHE.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.fEp)));
            } else {
                this.gHD.setVisibility(0);
                this.gHE.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fff, "hour")) {
                if (nVar.fEo <= 0) {
                    this.gHz.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gHz.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gHz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHz.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gHz.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.gHz.setText(String.valueOf(nVar.fEo));
                    this.gHz.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gHz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHz.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gHz.setLayoutParams(layoutParams2);
                    if (nVar.fEo == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.fEp - nVar.fEr) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.fEo >= 2 && nVar.fEo <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.fEq - nVar.fEp) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.fEo > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.fEt - nVar.fEp) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fff, "charm_day")) {
                if (nVar.fEo <= 0 || nVar.fEo > 100) {
                    this.gHz.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gHz.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gHz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gHz.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gHz.setLayoutParams(layoutParams3);
                    if (nVar.fEp <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.fEt - nVar.fEp) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.gHz.setText(String.valueOf(nVar.fEo));
                    this.gHz.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gHz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gHz.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gHz.setLayoutParams(layoutParams4);
                    if (nVar.fEo == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.fEp - nVar.fEr) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.fEq - nVar.fEp) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.gHC != null) {
                if ((nVar.fEo == 1 && nVar.bwM()) || nVar.fEv) {
                    this.gHC.setVisibility(8);
                } else {
                    this.gHC.setVisibility(0);
                    this.gHC.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.fEs)) {
                this.gHA.startLoad(nVar.fEs, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.gHB == null || StringUtils.isNull(this.gHB.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.gDT.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void yA() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
