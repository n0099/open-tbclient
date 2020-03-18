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
    private d.a eBZ;
    private String eiq;
    private boolean eir;
    private TextView fBa;
    private HeadImageView fBb;
    private TextView fBc;
    private TextView fBd;
    private TextView fBe;
    private TextView fBf;
    private TextView fxu;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.eiq = str;
        this.eir = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.eiq) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eiq) || "hour".equals(this.eiq) || "charm_day".equals(this.eiq)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            sr();
            this.fBa = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fBb = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fxu = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fBc = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fBd = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.fBf = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.fBe = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fBe.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fBe.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.fBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBZ != null) {
                        a.this.eBZ.f(view, a.this.eiq);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eiq) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eiq) || "rich".equals(this.eiq)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.fBa = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fBb = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fxu = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fBc = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fBe = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fBe.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fBe.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eiq) && this.eir) {
                this.fBe.setVisibility(8);
            } else {
                this.fBe.setVisibility(0);
            }
            this.fBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBZ != null) {
                        a.this.eBZ.f(view, a.this.eiq);
                    }
                }
            });
        }
        if (this.fBb != null) {
            this.fBb.setIsRound(true);
            this.fBb.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.eBZ = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.eir) {
                this.fBe.setVisibility(8);
                if (nVar.eAW) {
                    this.fBf.setVisibility(0);
                    this.fBf.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAQ)));
                    return;
                }
                this.fBf.setVisibility(8);
            } else if (nVar.eAW) {
                this.fBe.setVisibility(8);
                this.fBf.setVisibility(0);
                this.fBf.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAQ)));
            } else {
                this.fBe.setVisibility(0);
                this.fBf.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.eiq, "hour")) {
                if (nVar.eAP <= 0) {
                    this.fBa.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fBa.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fBa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBa.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fBa.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.fBa.setText(String.valueOf(nVar.eAP));
                    this.fBa.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fBa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fBa.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fBa.setLayoutParams(layoutParams2);
                    if (nVar.eAP == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAQ - nVar.eAS) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.eAP >= 2 && nVar.eAP <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.eAR - nVar.eAQ) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.eAP > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.eAU - nVar.eAQ) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.eiq, "charm_day")) {
                if (nVar.eAP <= 0 || nVar.eAP > 100) {
                    this.fBa.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fBa.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fBa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fBa.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fBa.setLayoutParams(layoutParams3);
                    if (nVar.eAQ <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.eAU - nVar.eAQ) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.fBa.setText(String.valueOf(nVar.eAP));
                    this.fBa.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fBa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fBa.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fBa.setLayoutParams(layoutParams4);
                    if (nVar.eAP == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAQ - nVar.eAS) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.eAR - nVar.eAQ) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.fBd != null) {
                if ((nVar.eAP == 1 && nVar.beI()) || nVar.eAW) {
                    this.fBd.setVisibility(8);
                } else {
                    this.fBd.setVisibility(0);
                    this.fBd.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.eAT)) {
                this.fBb.startLoad(nVar.eAT, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.fBc == null || StringUtils.isNull(this.fBc.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.fxu.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void sr() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
