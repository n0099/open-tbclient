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
    private f.a fWS;
    private String fvE;
    private boolean fvF;
    private TextView gVT;
    private TextView gZV;
    private HeadImageView gZW;
    private TextView gZX;
    private TextView gZY;
    private TextView gZZ;
    private TextView haa;
    private Context mContext;
    private View mRootView;

    public c(Context context, String str, boolean z) {
        this.mContext = context;
        this.fvE = str;
        this.fvF = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fvE) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvE) || "hour".equals(this.fvE) || "charm_day".equals(this.fvE)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            EF();
            this.gZV = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gZW = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gVT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gZX = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gZY = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.haa = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.gZZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gZZ.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gZZ.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.gZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fWS != null) {
                        c.this.fWS.g(view, c.this.fvE);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fvE) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fvE) || "rich".equals(this.fvE)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.gZV = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gZW = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gVT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gZX = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gZZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gZZ.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gZZ.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fvE) && this.fvF) {
                this.gZZ.setVisibility(8);
            } else {
                this.gZZ.setVisibility(0);
            }
            this.gZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fWS != null) {
                        c.this.fWS.g(view, c.this.fvE);
                    }
                }
            });
        }
        if (this.gZW != null) {
            this.gZW.setIsRound(true);
            this.gZW.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(f.a aVar) {
        this.fWS = aVar;
    }

    private void a(o oVar) {
        if (oVar != null) {
            if (this.fvF) {
                this.gZZ.setVisibility(8);
                if (oVar.fVh) {
                    this.haa.setVisibility(0);
                    this.haa.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(oVar.fVb)));
                    return;
                }
                this.haa.setVisibility(8);
            } else if (oVar.fVh) {
                this.gZZ.setVisibility(8);
                this.haa.setVisibility(0);
                this.haa.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(oVar.fVb)));
            } else {
                this.gZZ.setVisibility(0);
                this.haa.setVisibility(8);
            }
        }
    }

    public void b(o oVar) {
        int i = 10;
        if (oVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fvE, "hour")) {
                if (oVar.fVa <= 0) {
                    this.gZV.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gZV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gZV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZV.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZV.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.gZV.setText(String.valueOf(oVar.fVa));
                    this.gZV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gZV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gZV.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZV.setLayoutParams(layoutParams2);
                    if (oVar.fVa == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(oVar.fVb - oVar.fVd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (oVar.fVa >= 2 && oVar.fVa <= 10) {
                        String str = StringHelper.formatForHourRankValue((oVar.fVc - oVar.fVb) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (oVar.fVa > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(oVar.fVf - oVar.fVb) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fvE, "charm_day")) {
                if (oVar.fVa <= 0 || oVar.fVa > 100) {
                    this.gZV.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gZV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gZV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gZV.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZV.setLayoutParams(layoutParams3);
                    if (oVar.fVb <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(oVar.fVf - oVar.fVb) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.gZV.setText(String.valueOf(oVar.fVa));
                    this.gZV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gZV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gZV.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gZV.setLayoutParams(layoutParams4);
                    if (oVar.fVa == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(oVar.fVb - oVar.fVd) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((oVar.fVc - oVar.fVb) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.gZY != null) {
                if ((oVar.fVa == 1 && oVar.bJf()) || oVar.fVh) {
                    this.gZY.setVisibility(8);
                } else {
                    this.gZY.setVisibility(0);
                    this.gZY.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(oVar.fVe)) {
                this.gZW.startLoad(oVar.fVe, 12, false);
            }
            if (!StringUtils.isNull(oVar.getNameShow())) {
                String nameShow = oVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(oVar.getNameShow());
                i = (this.gZX == null || StringUtils.isNull(this.gZX.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(oVar.getNameShow(), i));
                }
                this.gVT.setText(nameShow);
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
