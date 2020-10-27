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
    private String fTt;
    private boolean fTu;
    private g.a gwG;
    private TextView hAA;
    private TextView hFn;
    private HeadImageView hFo;
    private TextView hFp;
    private TextView hFq;
    private TextView hFr;
    private TextView hFs;
    private Context mContext;
    private View mRootView;

    public d(Context context, String str, boolean z) {
        this.mContext = context;
        this.fTt = str;
        this.fTu = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.fTt) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fTt) || "hour".equals(this.fTt) || "charm_day".equals(this.fTt)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            Gh();
            this.hFn = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.hFo = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.hAA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hFp = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.hFq = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.hFs = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.hFr = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hFr.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.hFr.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.hFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gwG != null) {
                        d.this.gwG.g(view, d.this.fTt);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fTt) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fTt) || "rich".equals(this.fTt)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.hFn = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.hFo = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.hAA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.hFp = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.hFr = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.hFr.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.hFr.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.fTt) && this.fTu) {
                this.hFr.setVisibility(8);
            } else {
                this.hFr.setVisibility(0);
            }
            this.hFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gwG != null) {
                        d.this.gwG.g(view, d.this.fTt);
                    }
                }
            });
        }
        if (this.hFo != null) {
            this.hFo.setIsRound(true);
            this.hFo.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(g.a aVar) {
        this.gwG = aVar;
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (this.fTu) {
                this.hFr.setVisibility(8);
                if (rVar.guV) {
                    this.hFs.setVisibility(0);
                    this.hFs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aHm)));
                    return;
                }
                this.hFs.setVisibility(8);
            } else if (rVar.guV) {
                this.hFr.setVisibility(8);
                this.hFs.setVisibility(0);
                this.hFs.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(rVar.aHm)));
            } else {
                this.hFr.setVisibility(0);
                this.hFs.setVisibility(8);
            }
        }
    }

    public void b(r rVar) {
        int i = 10;
        if (rVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.fTt, "hour")) {
                if (rVar.aHl <= 0) {
                    this.hFn.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.hFn.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.hFn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFn.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.hFn.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.hFn.setText(String.valueOf(rVar.aHl));
                    this.hFn.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.hFn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hFn.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.hFn.setLayoutParams(layoutParams2);
                    if (rVar.aHl == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aHm - rVar.aHo) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (rVar.aHl >= 2 && rVar.aHl <= 10) {
                        String str = StringHelper.formatForHourRankValue((rVar.aHn - rVar.aHm) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (rVar.aHl > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(rVar.aHq - rVar.aHm) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.fTt, "charm_day")) {
                if (rVar.aHl <= 0 || rVar.aHl > 100) {
                    this.hFn.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.hFn.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.hFn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hFn.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.hFn.setLayoutParams(layoutParams3);
                    if (rVar.aHm <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(rVar.aHq - rVar.aHm) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.hFn.setText(String.valueOf(rVar.aHl));
                    this.hFn.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.hFn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.hFn.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.hFn.setLayoutParams(layoutParams4);
                    if (rVar.aHl == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(rVar.aHm - rVar.aHo) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((rVar.aHn - rVar.aHm) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.hFq != null) {
                if ((rVar.aHl == 1 && rVar.bPE()) || rVar.guV) {
                    this.hFq.setVisibility(8);
                } else {
                    this.hFq.setVisibility(0);
                    this.hFq.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(rVar.bdPortrait)) {
                this.hFo.startLoad(rVar.bdPortrait, 12, false);
            }
            if (!StringUtils.isNull(rVar.getNameShow())) {
                String nameShow = rVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(rVar.getNameShow());
                i = (this.hFp == null || StringUtils.isNull(this.hFp.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(rVar.getNameShow(), i));
                }
                this.hAA.setText(nameShow);
            }
            a(rVar);
        }
    }

    public void Gh() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
