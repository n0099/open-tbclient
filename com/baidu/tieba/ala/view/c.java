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
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.view.f;
/* loaded from: classes4.dex */
public class c {
    private View contentView;
    private f.a fKU;
    private String fki;
    private boolean fkj;
    private TextView gJq;
    private TextView gNf;
    private HeadImageView gNg;
    private TextView gNh;
    private TextView gNi;
    private TextView gNj;
    private TextView gNk;
    private Context mContext;
    private View mRootView;

    public c(Context context, String str, boolean z) {
        this.mContext = context;
        this.fki = str;
        this.fkj = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fki) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fki) || "hour".equals(this.fki) || "charm_day".equals(this.fki)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            zc();
            this.gNf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gNg = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gJq = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gNh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gNi = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.gNk = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.gNj = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gNj.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gNj.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.gNj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fKU != null) {
                        c.this.fKU.g(view, c.this.fki);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fki) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fki) || "rich".equals(this.fki)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.gNf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gNg = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gJq = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gNh = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gNj = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gNj.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gNj.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fki) && this.fkj) {
                this.gNj.setVisibility(8);
            } else {
                this.gNj.setVisibility(0);
            }
            this.gNj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fKU != null) {
                        c.this.fKU.g(view, c.this.fki);
                    }
                }
            });
        }
        if (this.gNg != null) {
            this.gNg.setIsRound(true);
            this.gNg.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(f.a aVar) {
        this.fKU = aVar;
    }

    private void a(o oVar) {
        if (oVar != null) {
            if (this.fkj) {
                this.gNj.setVisibility(8);
                if (oVar.fJQ) {
                    this.gNk.setVisibility(0);
                    this.gNk.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(oVar.fJK)));
                    return;
                }
                this.gNk.setVisibility(8);
            } else if (oVar.fJQ) {
                this.gNj.setVisibility(8);
                this.gNk.setVisibility(0);
                this.gNk.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(oVar.fJK)));
            } else {
                this.gNj.setVisibility(0);
                this.gNk.setVisibility(8);
            }
        }
    }

    public void b(o oVar) {
        int i = 10;
        if (oVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fki, "hour")) {
                if (oVar.fJJ <= 0) {
                    this.gNf.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gNf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gNf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gNf.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gNf.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.gNf.setText(String.valueOf(oVar.fJJ));
                    this.gNf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gNf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gNf.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gNf.setLayoutParams(layoutParams2);
                    if (oVar.fJJ == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(oVar.fJK - oVar.fJM) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (oVar.fJJ >= 2 && oVar.fJJ <= 10) {
                        String str = StringHelper.formatForHourRankValue((oVar.fJL - oVar.fJK) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (oVar.fJJ > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(oVar.fJO - oVar.fJK) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fki, "charm_day")) {
                if (oVar.fJJ <= 0 || oVar.fJJ > 100) {
                    this.gNf.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gNf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gNf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gNf.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gNf.setLayoutParams(layoutParams3);
                    if (oVar.fJK <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(oVar.fJO - oVar.fJK) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.gNf.setText(String.valueOf(oVar.fJJ));
                    this.gNf.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gNf.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gNf.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gNf.setLayoutParams(layoutParams4);
                    if (oVar.fJJ == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(oVar.fJK - oVar.fJM) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((oVar.fJL - oVar.fJK) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.gNi != null) {
                if ((oVar.fJJ == 1 && oVar.bAc()) || oVar.fJQ) {
                    this.gNi.setVisibility(8);
                } else {
                    this.gNi.setVisibility(0);
                    this.gNi.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(oVar.fJN)) {
                this.gNg.startLoad(oVar.fJN, 12, false);
            }
            if (!StringUtils.isNull(oVar.getNameShow())) {
                String nameShow = oVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(oVar.getNameShow());
                i = (this.gNh == null || StringUtils.isNull(this.gNh.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(oVar.getNameShow(), i));
                }
                this.gJq.setText(nameShow);
            }
            a(oVar);
        }
    }

    public void zc() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
