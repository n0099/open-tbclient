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
    private String eUJ;
    private boolean eUK;
    private d.a fue;
    private TextView gqT;
    private TextView guA;
    private HeadImageView guB;
    private TextView guC;
    private TextView guD;
    private TextView guE;
    private TextView guF;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.eUJ = str;
        this.eUK = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.eUJ) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eUJ) || "hour".equals(this.eUJ) || "charm_day".equals(this.eUJ)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            ya();
            this.guA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.guB = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gqT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.guC = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.guD = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.guF = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.guE = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.guE.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.guE.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.guE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fue != null) {
                        a.this.fue.g(view, a.this.eUJ);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eUJ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eUJ) || "rich".equals(this.eUJ)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.guA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.guB = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gqT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.guC = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.guE = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.guE.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.guE.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eUJ) && this.eUK) {
                this.guE.setVisibility(8);
            } else {
                this.guE.setVisibility(0);
            }
            this.guE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fue != null) {
                        a.this.fue.g(view, a.this.eUJ);
                    }
                }
            });
        }
        if (this.guB != null) {
            this.guB.setIsRound(true);
            this.guB.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.fue = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.eUK) {
                this.guE.setVisibility(8);
                if (nVar.fsZ) {
                    this.guF.setVisibility(0);
                    this.guF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.fsT)));
                    return;
                }
                this.guF.setVisibility(8);
            } else if (nVar.fsZ) {
                this.guE.setVisibility(8);
                this.guF.setVisibility(0);
                this.guF.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.fsT)));
            } else {
                this.guE.setVisibility(0);
                this.guF.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.eUJ, "hour")) {
                if (nVar.fsS <= 0) {
                    this.guA.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.guA.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.guA.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guA.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.guA.setText(String.valueOf(nVar.fsS));
                    this.guA.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.guA.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guA.setLayoutParams(layoutParams2);
                    if (nVar.fsS == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.fsT - nVar.fsV) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.fsS >= 2 && nVar.fsS <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.fsU - nVar.fsT) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.fsS > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.fsX - nVar.fsT) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.eUJ, "charm_day")) {
                if (nVar.fsS <= 0 || nVar.fsS > 100) {
                    this.guA.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.guA.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.guA.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guA.setLayoutParams(layoutParams3);
                    if (nVar.fsT <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.fsX - nVar.fsT) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.guA.setText(String.valueOf(nVar.fsS));
                    this.guA.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.guA.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.guA.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.guA.setLayoutParams(layoutParams4);
                    if (nVar.fsS == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.fsT - nVar.fsV) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.fsU - nVar.fsT) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.guD != null) {
                if ((nVar.fsS == 1 && nVar.btO()) || nVar.fsZ) {
                    this.guD.setVisibility(8);
                } else {
                    this.guD.setVisibility(0);
                    this.guD.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.fsW)) {
                this.guB.startLoad(nVar.fsW, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.guC == null || StringUtils.isNull(this.guC.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.gqT.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void ya() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
