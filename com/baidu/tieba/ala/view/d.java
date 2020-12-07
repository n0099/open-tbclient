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
    private g.a gKY;
    private String ghb;
    private boolean ghc;
    private TextView hPL;
    private TextView hVL;
    private HeadImageView hVM;
    private TextView hVN;
    private TextView hVO;
    private TextView hVP;
    private TextView hVQ;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.ghb = str;
        this.ghc = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.ghb) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ghb) || "hour".equals(this.ghb) || "charm_day".equals(this.ghb)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            HO();
            this.hVL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.hVM = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hPL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.hVN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.hVO = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.hVQ = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.hVP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hVP.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.hVP.setBackgroundResource(a.e.qm_hour_rank_list_support_bg);
            }
            this.hVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gKY != null) {
                        d.this.gKY.g(view, d.this.ghb);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ghb) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ghb) || "rich".equals(this.ghb)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.hVL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.hVM = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hPL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.hVN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.hVP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hVP.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.hVP.setBackgroundResource(a.e.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.ghb) && this.ghc) {
                this.hVP.setVisibility(8);
            } else {
                this.hVP.setVisibility(0);
            }
            this.hVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gKY != null) {
                        d.this.gKY.g(view, d.this.ghb);
                    }
                }
            });
        }
        if (this.hVM != null) {
            this.hVM.setIsRound(true);
            this.hVM.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gKY = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.ghc) {
                this.hVP.setVisibility(8);
                if (rVar.gJn) {
                    this.hVQ.setVisibility(0);
                    this.hVQ.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aJb)));
                    return;
                }
                this.hVQ.setVisibility(8);
            } else if (rVar.gJn) {
                this.hVP.setVisibility(8);
                this.hVQ.setVisibility(0);
                this.hVQ.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aJb)));
            } else {
                this.hVP.setVisibility(0);
                this.hVQ.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.ghb, "hour")) {
                if (rVar.aJa <= 0) {
                    this.hVL.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.hVL.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.hVL.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hVL.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hVL.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.hVL.setText(String.valueOf(rVar.aJa));
                    this.hVL.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.hVL.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hVL.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hVL.setLayoutParams(layoutParams2);
                    if (rVar.aJa == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aJb - rVar.aJd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aJa >= 2 && rVar.aJa <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aJc - rVar.aJb) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aJa > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(rVar.aJf - rVar.aJb) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.ghb, "charm_day")) {
                if (rVar.aJa <= 0 || rVar.aJa > 100) {
                    this.hVL.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.hVL.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.hVL.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hVL.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hVL.setLayoutParams(layoutParams3);
                    if (rVar.aJb <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(rVar.aJf - rVar.aJb) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.hVL.setText(String.valueOf(rVar.aJa));
                    this.hVL.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.hVL.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.hVL.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hVL.setLayoutParams(layoutParams4);
                    if (rVar.aJa == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aJb - rVar.aJd) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aJc - rVar.aJb) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.hVO != null) {
                if ((rVar.aJa == 1 && rVar.bVh()) || rVar.gJn) {
                    this.hVO.setVisibility(8);
                } else {
                    this.hVO.setVisibility(0);
                    this.hVO.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.hVM.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.hVN == null || StringUtils.isNull(this.hVN.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.hPL.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void HO() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
