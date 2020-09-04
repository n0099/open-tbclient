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
/* loaded from: classes7.dex */
public class c {
    private View contentView;
    private f.a fWW;
    private String fvI;
    private boolean fvJ;
    private TextView gVX;
    private TextView gZZ;
    private HeadImageView haa;
    private TextView hab;
    private TextView hac;
    private TextView had;
    private TextView hae;
    private Context mContext;
    private View mRootView;

    public c(Context context, String str, boolean z) {
        this.mContext = context;
        this.fvI = str;
        this.fvJ = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fvI) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvI) || "hour".equals(this.fvI) || "charm_day".equals(this.fvI)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            EF();
            this.gZZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.haa = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gVX = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hab = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.hac = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.hae = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.had = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.had.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.had.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.had.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fWW != null) {
                        c.this.fWW.g(view, c.this.fvI);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fvI) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fvI) || "rich".equals(this.fvI)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.gZZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.haa = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gVX = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hab = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.had = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.had.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.had.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fvI) && this.fvJ) {
                this.had.setVisibility(8);
            } else {
                this.had.setVisibility(0);
            }
            this.had.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fWW != null) {
                        c.this.fWW.g(view, c.this.fvI);
                    }
                }
            });
        }
        if (this.haa != null) {
            this.haa.setIsRound(true);
            this.haa.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(f.a aVar) {
        this.fWW = aVar;
    }

    private void a(o oVar) {
        if (oVar != null) {
            if (this.fvJ) {
                this.had.setVisibility(8);
                if (oVar.fVl) {
                    this.hae.setVisibility(0);
                    this.hae.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(oVar.fVf)));
                    return;
                }
                this.hae.setVisibility(8);
            } else if (oVar.fVl) {
                this.had.setVisibility(8);
                this.hae.setVisibility(0);
                this.hae.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(oVar.fVf)));
            } else {
                this.had.setVisibility(0);
                this.hae.setVisibility(8);
            }
        }
    }

    public void b(o oVar) {
        int i = 10;
        if (oVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fvI, "hour")) {
                if (oVar.fVe <= 0) {
                    this.gZZ.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gZZ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gZZ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZZ.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZZ.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.gZZ.setText(String.valueOf(oVar.fVe));
                    this.gZZ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gZZ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gZZ.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZZ.setLayoutParams(layoutParams2);
                    if (oVar.fVe == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(oVar.fVf - oVar.fVh) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (oVar.fVe >= 2 && oVar.fVe <= 10) {
                        String str = StringHelper.formatForHourRankValue((oVar.fVg - oVar.fVf) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (oVar.fVe > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(oVar.fVj - oVar.fVf) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fvI, "charm_day")) {
                if (oVar.fVe <= 0 || oVar.fVe > 100) {
                    this.gZZ.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gZZ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gZZ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gZZ.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZZ.setLayoutParams(layoutParams3);
                    if (oVar.fVf <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(oVar.fVj - oVar.fVf) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.gZZ.setText(String.valueOf(oVar.fVe));
                    this.gZZ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gZZ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gZZ.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZZ.setLayoutParams(layoutParams4);
                    if (oVar.fVe == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(oVar.fVf - oVar.fVh) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((oVar.fVg - oVar.fVf) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.hac != null) {
                if ((oVar.fVe == 1 && oVar.bJg()) || oVar.fVl) {
                    this.hac.setVisibility(8);
                } else {
                    this.hac.setVisibility(0);
                    this.hac.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(oVar.fVi)) {
                this.haa.startLoad(oVar.fVi, 12, false);
            }
            if (!StringUtils.isNull(oVar.getNameShow())) {
                String nameShow = oVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(oVar.getNameShow());
                i = (this.hab == null || StringUtils.isNull(this.hab.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(oVar.getNameShow(), i));
                }
                this.gVX.setText(nameShow);
            }
            a(oVar);
        }
    }

    public void EF() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
