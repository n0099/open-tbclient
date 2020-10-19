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
    private String fLc;
    private boolean fLd;
    private g.a gmB;
    private TextView hoF;
    private TextView htA;
    private TextView htB;
    private TextView htw;
    private HeadImageView htx;
    private TextView hty;
    private TextView htz;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.fLc = str;
        this.fLd = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fLc) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fLc) || "hour".equals(this.fLc) || "charm_day".equals(this.fLc)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            FS();
            this.htw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.htx = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.hoF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hty = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.htz = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.htB = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.htA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.htA.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.htA.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.htA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gmB != null) {
                        d.this.gmB.g(view, d.this.fLc);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fLc) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fLc) || "rich".equals(this.fLc)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.htw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.htx = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.hoF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hty = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.htA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.htA.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.htA.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fLc) && this.fLd) {
                this.htA.setVisibility(8);
            } else {
                this.htA.setVisibility(0);
            }
            this.htA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gmB != null) {
                        d.this.gmB.g(view, d.this.fLc);
                    }
                }
            });
        }
        if (this.htx != null) {
            this.htx.setIsRound(true);
            this.htx.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gmB = aVar;
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (this.fLd) {
                this.htA.setVisibility(8);
                if (pVar.gkQ) {
                    this.htB.setVisibility(0);
                    this.htB.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(pVar.aHb)));
                    return;
                }
                this.htB.setVisibility(8);
            } else if (pVar.gkQ) {
                this.htA.setVisibility(8);
                this.htB.setVisibility(0);
                this.htB.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(pVar.aHb)));
            } else {
                this.htA.setVisibility(0);
                this.htB.setVisibility(8);
            }
        }
    }

    public void b(p pVar) {
        int i = 10;
        if (pVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fLc, "hour")) {
                if (pVar.aHa <= 0) {
                    this.htw.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.htw.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.htw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.htw.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.htw.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.htw.setText(String.valueOf(pVar.aHa));
                    this.htw.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.htw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.htw.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.htw.setLayoutParams(layoutParams2);
                    if (pVar.aHa == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(pVar.aHb - pVar.aHd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (pVar.aHa >= 2 && pVar.aHa <= 10) {
                        String str = StringHelper.formatForHourRankValue((pVar.aHc - pVar.aHb) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (pVar.aHa > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(pVar.gkO - pVar.aHb) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fLc, "charm_day")) {
                if (pVar.aHa <= 0 || pVar.aHa > 100) {
                    this.htw.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.htw.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.htw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.htw.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.htw.setLayoutParams(layoutParams3);
                    if (pVar.aHb <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(pVar.gkO - pVar.aHb) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.htw.setText(String.valueOf(pVar.aHa));
                    this.htw.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.htw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.htw.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.htw.setLayoutParams(layoutParams4);
                    if (pVar.aHa == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(pVar.aHb - pVar.aHd) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((pVar.aHc - pVar.aHb) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.htz != null) {
                if ((pVar.aHa == 1 && pVar.bMZ()) || pVar.gkQ) {
                    this.htz.setVisibility(8);
                } else {
                    this.htz.setVisibility(0);
                    this.htz.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(pVar.bdPortrait)) {
                this.htx.startLoad(pVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(pVar.getNameShow())) {
                String nameShow = pVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(pVar.getNameShow());
                i = (this.hty == null || StringUtils.isNull(this.hty.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(pVar.getNameShow(), i));
                }
                this.hoF.setText(nameShow);
            }
            a(pVar);
        }
    }

    public void FS() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
