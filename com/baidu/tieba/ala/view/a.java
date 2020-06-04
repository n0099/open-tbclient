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
    private String eUU;
    private boolean eUV;
    private d.a fup;
    private TextView gre;
    private TextView guL;
    private HeadImageView guM;
    private TextView guN;
    private TextView guO;
    private TextView guP;
    private TextView guQ;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.eUU = str;
        this.eUV = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.eUU) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eUU) || "hour".equals(this.eUU) || "charm_day".equals(this.eUU)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            ya();
            this.guL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.guM = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gre = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.guN = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.guO = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.guQ = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.guP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.guP.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.guP.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.guP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fup != null) {
                        a.this.fup.g(view, a.this.eUU);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eUU) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eUU) || "rich".equals(this.eUU)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.guL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.guM = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gre = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.guN = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.guP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.guP.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.guP.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eUU) && this.eUV) {
                this.guP.setVisibility(8);
            } else {
                this.guP.setVisibility(0);
            }
            this.guP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fup != null) {
                        a.this.fup.g(view, a.this.eUU);
                    }
                }
            });
        }
        if (this.guM != null) {
            this.guM.setIsRound(true);
            this.guM.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.fup = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.eUV) {
                this.guP.setVisibility(8);
                if (nVar.ftk) {
                    this.guQ.setVisibility(0);
                    this.guQ.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.fte)));
                    return;
                }
                this.guQ.setVisibility(8);
            } else if (nVar.ftk) {
                this.guP.setVisibility(8);
                this.guQ.setVisibility(0);
                this.guQ.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.fte)));
            } else {
                this.guP.setVisibility(0);
                this.guQ.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.eUU, "hour")) {
                if (nVar.ftd <= 0) {
                    this.guL.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.guL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.guL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guL.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guL.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.guL.setText(String.valueOf(nVar.ftd));
                    this.guL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.guL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.guL.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guL.setLayoutParams(layoutParams2);
                    if (nVar.ftd == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.fte - nVar.ftg) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.ftd >= 2 && nVar.ftd <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.ftf - nVar.fte) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.ftd > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.fti - nVar.fte) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.eUU, "charm_day")) {
                if (nVar.ftd <= 0 || nVar.ftd > 100) {
                    this.guL.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.guL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.guL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.guL.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guL.setLayoutParams(layoutParams3);
                    if (nVar.fte <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.fti - nVar.fte) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.guL.setText(String.valueOf(nVar.ftd));
                    this.guL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.guL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.guL.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guL.setLayoutParams(layoutParams4);
                    if (nVar.ftd == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.fte - nVar.ftg) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.ftf - nVar.fte) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.guO != null) {
                if ((nVar.ftd == 1 && nVar.btQ()) || nVar.ftk) {
                    this.guO.setVisibility(8);
                } else {
                    this.guO.setVisibility(0);
                    this.guO.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.fth)) {
                this.guM.startLoad(nVar.fth, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.guN == null || StringUtils.isNull(this.guN.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.gre.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void ya() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
