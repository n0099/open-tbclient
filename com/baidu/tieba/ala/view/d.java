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
    private String fZj;
    private boolean fZk;
    private g.a gCu;
    private TextView hGx;
    private TextView hLk;
    private HeadImageView hLl;
    private TextView hLm;
    private TextView hLn;
    private TextView hLo;
    private TextView hLp;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.fZj = str;
        this.fZk = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fZj) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fZj) || "hour".equals(this.fZj) || "charm_day".equals(this.fZj)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.f.content_view);
            GI();
            this.hLk = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.hLl = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hGx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.hLm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.hLn = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
            this.hLp = (TextView) this.mRootView.findViewById(a.f.rank_list_charm_right);
            this.hLo = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hLo.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.hLo.setBackgroundResource(a.e.qm_hour_rank_list_support_bg);
            }
            this.hLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gCu != null) {
                        d.this.gCu.g(view, d.this.fZj);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fZj) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fZj) || "rich".equals(this.fZj)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_bottom_view, (ViewGroup) null);
            this.hLk = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
            this.hLl = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
            this.hGx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
            this.hLm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
            this.hLo = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hLo.setBackgroundResource(a.e.hk_ala_rank_list_support_bg);
            } else {
                this.hLo.setBackgroundResource(a.e.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fZj) && this.fZk) {
                this.hLo.setVisibility(8);
            } else {
                this.hLo.setVisibility(0);
            }
            this.hLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gCu != null) {
                        d.this.gCu.g(view, d.this.fZj);
                    }
                }
            });
        }
        if (this.hLl != null) {
            this.hLl.setIsRound(true);
            this.hLl.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gCu = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.fZk) {
                this.hLo.setVisibility(8);
                if (rVar.gAJ) {
                    this.hLp.setVisibility(0);
                    this.hLp.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aId)));
                    return;
                }
                this.hLp.setVisibility(8);
            } else if (rVar.gAJ) {
                this.hLo.setVisibility(8);
                this.hLp.setVisibility(0);
                this.hLp.setText(String.format(this.mContext.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aId)));
            } else {
                this.hLo.setVisibility(0);
                this.hLp.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fZj, "hour")) {
                if (rVar.aIc <= 0) {
                    this.hLk.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.hLk.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.hLk.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLk.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hLk.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.hLk.setText(String.valueOf(rVar.aIc));
                    this.hLk.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.hLk.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hLk.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hLk.setLayoutParams(layoutParams2);
                    if (rVar.aIc == 1) {
                        String format = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aId - rVar.aIf) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aIc >= 2 && rVar.aIc <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aIe - rVar.aId) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aIc > 10) {
                        String format2 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(rVar.aIh - rVar.aId) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fZj, "charm_day")) {
                if (rVar.aIc <= 0 || rVar.aIc > 100) {
                    this.hLk.setText(this.mContext.getString(a.h.ala_rank_list_no_level));
                    this.hLk.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize28));
                    this.hLk.setTextColor(this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hLk.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hLk.setLayoutParams(layoutParams3);
                    if (rVar.aId <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.h.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(rVar.aIh - rVar.aId) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.hLk.setText(String.valueOf(rVar.aIc));
                    this.hLk.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize34));
                    this.hLk.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.hLk.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds34);
                    this.hLk.setLayoutParams(layoutParams4);
                    if (rVar.aIc == 1) {
                        String format4 = String.format(this.mContext.getString(a.h.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aId - rVar.aIf) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aIe - rVar.aId) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.hLn != null) {
                if ((rVar.aIc == 1 && rVar.bSe()) || rVar.gAJ) {
                    this.hLn.setVisibility(8);
                } else {
                    this.hLn.setVisibility(0);
                    this.hLn.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.hLl.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.hLm == null || StringUtils.isNull(this.hLm.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.h.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.hGx.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void GI() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.c.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
