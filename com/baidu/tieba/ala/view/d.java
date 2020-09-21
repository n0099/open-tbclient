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
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.view.g;
/* loaded from: classes4.dex */
public class d {
    private View contentView;
    private String fyT;
    private boolean fyU;
    private TextView gZE;
    private g.a gaj;
    private TextView het;
    private HeadImageView heu;
    private TextView hev;
    private TextView hew;
    private TextView hex;
    private TextView hey;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.fyT = str;
        this.fyU = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fyT) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fyT) || "hour".equals(this.fyT) || "charm_day".equals(this.fyT)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            EW();
            this.het = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.heu = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gZE = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hev = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.hew = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.hey = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.hex = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hex.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.hex.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.hex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gaj != null) {
                        d.this.gaj.g(view, d.this.fyT);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fyT) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fyT) || "rich".equals(this.fyT)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.het = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.heu = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gZE = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hev = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.hex = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hex.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.hex.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fyT) && this.fyU) {
                this.hex.setVisibility(8);
            } else {
                this.hex.setVisibility(0);
            }
            this.hex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gaj != null) {
                        d.this.gaj.g(view, d.this.fyT);
                    }
                }
            });
        }
        if (this.heu != null) {
            this.heu.setIsRound(true);
            this.heu.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gaj = aVar;
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (this.fyU) {
                this.hex.setVisibility(8);
                if (pVar.fYy) {
                    this.hey.setVisibility(0);
                    this.hey.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(pVar.aDX)));
                    return;
                }
                this.hey.setVisibility(8);
            } else if (pVar.fYy) {
                this.hex.setVisibility(8);
                this.hey.setVisibility(0);
                this.hey.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(pVar.aDX)));
            } else {
                this.hex.setVisibility(0);
                this.hey.setVisibility(8);
            }
        }
    }

    public void b(p pVar) {
        int i = 10;
        if (pVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fyT, "hour")) {
                if (pVar.aDW <= 0) {
                    this.het.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.het.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.het.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.het.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.het.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.het.setText(String.valueOf(pVar.aDW));
                    this.het.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.het.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.het.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.het.setLayoutParams(layoutParams2);
                    if (pVar.aDW == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(pVar.aDX - pVar.aDZ) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (pVar.aDW >= 2 && pVar.aDW <= 10) {
                        String str = StringHelper.formatForHourRankValue((pVar.aDY - pVar.aDX) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (pVar.aDW > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(pVar.fYw - pVar.aDX) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fyT, "charm_day")) {
                if (pVar.aDW <= 0 || pVar.aDW > 100) {
                    this.het.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.het.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.het.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.het.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.het.setLayoutParams(layoutParams3);
                    if (pVar.aDX <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(pVar.fYw - pVar.aDX) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.het.setText(String.valueOf(pVar.aDW));
                    this.het.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.het.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.het.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.het.setLayoutParams(layoutParams4);
                    if (pVar.aDW == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(pVar.aDX - pVar.aDZ) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((pVar.aDY - pVar.aDX) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.hew != null) {
                if ((pVar.aDW == 1 && pVar.bKp()) || pVar.fYy) {
                    this.hew.setVisibility(8);
                } else {
                    this.hew.setVisibility(0);
                    this.hew.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(pVar.bdPortrait)) {
                this.heu.startLoad(pVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(pVar.getNameShow())) {
                String nameShow = pVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(pVar.getNameShow());
                i = (this.hev == null || StringUtils.isNull(this.hev.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(pVar.getNameShow(), i));
                }
                this.gZE.setText(nameShow);
            }
            a(pVar);
        }
    }

    public void EW() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
