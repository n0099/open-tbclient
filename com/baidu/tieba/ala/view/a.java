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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.d;
/* loaded from: classes2.dex */
public class a {
    private View contentView;
    private String edJ;
    private boolean edK;
    private d.a exf;
    private TextView ftZ;
    private TextView fxF;
    private HeadImageView fxG;
    private TextView fxH;
    private TextView fxI;
    private TextView fxJ;
    private TextView fxK;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.edJ = str;
        this.edK = z;
        initView();
    }

    public void initView() {
        if ("hot".equals(this.edJ) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edJ) || "hour".equals(this.edJ) || "charm_day".equals(this.edJ)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            rl();
            this.fxF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fxG = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.ftZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fxH = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fxI = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.fxK = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.fxJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fxJ.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fxJ.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.fxJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.exf != null) {
                        a.this.exf.f(view, a.this.edJ);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.edJ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.edJ) || "rich".equals(this.edJ)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.fxF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fxG = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.ftZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fxH = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fxJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fxJ.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fxJ.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.edJ) && this.edK) {
                this.fxJ.setVisibility(8);
            } else {
                this.fxJ.setVisibility(0);
            }
            this.fxJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.exf != null) {
                        a.this.exf.f(view, a.this.edJ);
                    }
                }
            });
        } else if ("pk".equals(this.edJ)) {
        }
        if (this.fxG != null) {
            this.fxG.setIsRound(true);
            this.fxG.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.exf = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.edK) {
                this.fxJ.setVisibility(8);
                if (nVar.ewb) {
                    this.fxK.setVisibility(0);
                    this.fxK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.evV)));
                    return;
                }
                this.fxK.setVisibility(8);
            } else if (nVar.ewb) {
                this.fxJ.setVisibility(8);
                this.fxK.setVisibility(0);
                this.fxK.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.evV)));
            } else {
                this.fxJ.setVisibility(0);
                this.fxK.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.edJ, "hour")) {
                if (nVar.evU <= 0) {
                    this.fxF.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fxF.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fxF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxF.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fxF.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.fxF.setText(String.valueOf(nVar.evU));
                    this.fxF.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fxF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxF.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fxF.setLayoutParams(layoutParams2);
                    if (nVar.evU == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.evV - nVar.evX) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.evU >= 2 && nVar.evU <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.evW - nVar.evV) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.evU > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.evZ - nVar.evV) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.edJ, "charm_day")) {
                if (nVar.evU <= 0 || nVar.evU > 100) {
                    this.fxF.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fxF.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fxF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fxF.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fxF.setLayoutParams(layoutParams3);
                    if (nVar.evV <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.evZ - nVar.evV) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.fxF.setText(String.valueOf(nVar.evU));
                    this.fxF.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fxF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fxF.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fxF.setLayoutParams(layoutParams4);
                    if (nVar.evU == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.evV - nVar.evX) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.evW - nVar.evV) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.fxI != null) {
                if ((nVar.evU == 1 && nVar.bcl()) || nVar.ewb) {
                    this.fxI.setVisibility(8);
                } else {
                    this.fxI.setVisibility(0);
                    this.fxI.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.evY)) {
                this.fxG.startLoad(nVar.evY, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.fxH == null || StringUtils.isNull(this.fxH.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.ftZ.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void rl() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
