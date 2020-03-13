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
    private d.a eBD;
    private String eia;
    private boolean eib;
    private TextView fAs;
    private HeadImageView fAt;
    private TextView fAu;
    private TextView fAv;
    private TextView fAw;
    private TextView fAx;
    private TextView fwO;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.eia = str;
        this.eib = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.eia) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eia) || "hour".equals(this.eia) || "charm_day".equals(this.eia)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            sm();
            this.fAs = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fAt = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fwO = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fAu = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fAv = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.fAx = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.fAw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fAw.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fAw.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.fAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBD != null) {
                        a.this.eBD.f(view, a.this.eia);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eia) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eia) || "rich".equals(this.eia)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.fAs = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fAt = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fwO = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fAu = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fAw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fAw.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fAw.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eia) && this.eib) {
                this.fAw.setVisibility(8);
            } else {
                this.fAw.setVisibility(0);
            }
            this.fAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBD != null) {
                        a.this.eBD.f(view, a.this.eia);
                    }
                }
            });
        }
        if (this.fAt != null) {
            this.fAt.setIsRound(true);
            this.fAt.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.eBD = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.eib) {
                this.fAw.setVisibility(8);
                if (nVar.eAA) {
                    this.fAx.setVisibility(0);
                    this.fAx.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAu)));
                    return;
                }
                this.fAx.setVisibility(8);
            } else if (nVar.eAA) {
                this.fAw.setVisibility(8);
                this.fAx.setVisibility(0);
                this.fAx.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.eAu)));
            } else {
                this.fAw.setVisibility(0);
                this.fAx.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.eia, "hour")) {
                if (nVar.eAt <= 0) {
                    this.fAs.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fAs.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fAs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAs.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAs.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.fAs.setText(String.valueOf(nVar.eAt));
                    this.fAs.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fAs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAs.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAs.setLayoutParams(layoutParams2);
                    if (nVar.eAt == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAu - nVar.eAw) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.eAt >= 2 && nVar.eAt <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.eAv - nVar.eAu) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.eAt > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.eAy - nVar.eAu) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.eia, "charm_day")) {
                if (nVar.eAt <= 0 || nVar.eAt > 100) {
                    this.fAs.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fAs.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fAs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fAs.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAs.setLayoutParams(layoutParams3);
                    if (nVar.eAu <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.eAy - nVar.eAu) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.fAs.setText(String.valueOf(nVar.eAt));
                    this.fAs.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fAs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fAs.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fAs.setLayoutParams(layoutParams4);
                    if (nVar.eAt == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.eAu - nVar.eAw) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.eAv - nVar.eAu) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.fAv != null) {
                if ((nVar.eAt == 1 && nVar.beD()) || nVar.eAA) {
                    this.fAv.setVisibility(8);
                } else {
                    this.fAv.setVisibility(0);
                    this.fAv.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.eAx)) {
                this.fAt.startLoad(nVar.eAx, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.fAu == null || StringUtils.isNull(this.fAu.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.fwO.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void sm() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
