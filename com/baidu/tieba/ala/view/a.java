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
    private d.a dHI;
    private String dtO;
    private boolean dtP;
    private TextView eCP;
    private HeadImageView eCQ;
    private TextView eCR;
    private TextView eCS;
    private TextView eCT;
    private TextView eCU;
    private TextView ezp;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.dtO = str;
        this.dtP = z;
        initView();
    }

    public void initView() {
        if ("hot".equals(this.dtO) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.dtO) || "hour".equals(this.dtO) || "charm_day".equals(this.dtO)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            pC();
            this.eCP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.eCQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.ezp = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.eCR = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.eCS = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.eCU = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.eCT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            this.eCT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.eCT.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.eCT.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.eCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dHI != null) {
                        a.this.dHI.f(view, a.this.dtO);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.dtO) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.dtO) || "rich".equals(this.dtO)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.eCP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.eCQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.ezp = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.eCR = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.eCT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.eCT.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.eCT.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.dtO) && this.dtP) {
                this.eCT.setVisibility(8);
            } else {
                this.eCT.setVisibility(0);
            }
            this.eCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dHI != null) {
                        a.this.dHI.f(view, a.this.dtO);
                    }
                }
            });
        } else if ("pk".equals(this.dtO)) {
        }
        if (this.eCQ != null) {
            this.eCQ.setIsRound(true);
            this.eCQ.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.dHI = aVar;
    }

    private void a(com.baidu.tieba.ala.data.f fVar) {
        if (fVar != null) {
            if (this.dtP) {
                this.eCT.setVisibility(8);
                if (fVar.dGI) {
                    this.eCU.setVisibility(0);
                    this.eCU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(fVar.dGC)));
                    return;
                }
                this.eCU.setVisibility(8);
            } else if (fVar.dGI) {
                this.eCT.setVisibility(8);
                this.eCU.setVisibility(0);
                this.eCU.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(fVar.dGC)));
            } else {
                this.eCT.setVisibility(0);
                this.eCU.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.ala.data.f fVar) {
        int i = 10;
        if (fVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.dtO, "hour")) {
                if (fVar.dGB <= 0) {
                    this.eCP.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.eCP.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.eCP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eCP.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eCP.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.eCP.setText(String.valueOf(fVar.dGB));
                    this.eCP.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.eCP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eCP.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eCP.setLayoutParams(layoutParams2);
                    if (fVar.dGB == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(fVar.dGC - fVar.dGE) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (fVar.dGB >= 2 && fVar.dGB <= 10) {
                        String str = StringHelper.formatForHourRankValue((fVar.dGD - fVar.dGC) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (fVar.dGB > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatForHourRankValue(fVar.dGG - fVar.dGC) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.dtO, "charm_day")) {
                if (fVar.dGB <= 0 || fVar.dGB > 100) {
                    this.eCP.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.eCP.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.eCP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eCP.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eCP.setLayoutParams(layoutParams3);
                    if (fVar.dGC <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(fVar.dGG - fVar.dGC) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.eCP.setText(String.valueOf(fVar.dGB));
                    this.eCP.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.eCP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eCP.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.eCP.setLayoutParams(layoutParams4);
                    if (fVar.dGB == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(fVar.dGC - fVar.dGE) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((fVar.dGD - fVar.dGC) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.eCS != null) {
                if ((fVar.dGB == 1 && fVar.aKE()) || fVar.dGI) {
                    this.eCS.setVisibility(8);
                } else {
                    this.eCS.setVisibility(0);
                    this.eCS.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(fVar.dGF)) {
                this.eCQ.startLoad(fVar.dGF, 12, false);
            }
            if (!StringUtils.isNull(fVar.getNameShow())) {
                String nameShow = fVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(fVar.getNameShow());
                i = (this.eCR == null || StringUtils.isNull(this.eCR.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(fVar.getNameShow(), i));
                }
                this.ezp.setText(nameShow);
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
