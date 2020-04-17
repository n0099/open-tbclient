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
    private String eIf;
    private boolean eIg;
    private d.a fgs;
    private TextView gbU;
    private TextView gfB;
    private HeadImageView gfC;
    private TextView gfD;
    private TextView gfE;
    private TextView gfF;
    private TextView gfG;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.eIf = str;
        this.eIg = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.eIf) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eIf) || "hour".equals(this.eIf) || "charm_day".equals(this.eIf)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            wK();
            this.gfB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gfC = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gbU = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gfD = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gfE = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.gfG = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.gfF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gfF.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gfF.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.gfF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fgs != null) {
                        a.this.fgs.f(view, a.this.eIf);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eIf) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eIf) || "rich".equals(this.eIf)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.gfB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gfC = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gbU = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gfD = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gfF = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gfF.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gfF.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eIf) && this.eIg) {
                this.gfF.setVisibility(8);
            } else {
                this.gfF.setVisibility(0);
            }
            this.gfF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fgs != null) {
                        a.this.fgs.f(view, a.this.eIf);
                    }
                }
            });
        }
        if (this.gfC != null) {
            this.gfC.setIsRound(true);
            this.gfC.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.fgs = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.eIg) {
                this.gfF.setVisibility(8);
                if (nVar.ffp) {
                    this.gfG.setVisibility(0);
                    this.gfG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.ffj)));
                    return;
                }
                this.gfG.setVisibility(8);
            } else if (nVar.ffp) {
                this.gfF.setVisibility(8);
                this.gfG.setVisibility(0);
                this.gfG.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.ffj)));
            } else {
                this.gfF.setVisibility(0);
                this.gfG.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.eIf, "hour")) {
                if (nVar.ffi <= 0) {
                    this.gfB.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gfB.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gfB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfB.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfB.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.gfB.setText(String.valueOf(nVar.ffi));
                    this.gfB.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gfB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gfB.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfB.setLayoutParams(layoutParams2);
                    if (nVar.ffi == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.ffj - nVar.ffl) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.ffi >= 2 && nVar.ffi <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.ffk - nVar.ffj) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.ffi > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.ffn - nVar.ffj) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.eIf, "charm_day")) {
                if (nVar.ffi <= 0 || nVar.ffi > 100) {
                    this.gfB.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gfB.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gfB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gfB.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfB.setLayoutParams(layoutParams3);
                    if (nVar.ffj <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.ffn - nVar.ffj) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.gfB.setText(String.valueOf(nVar.ffi));
                    this.gfB.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gfB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gfB.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfB.setLayoutParams(layoutParams4);
                    if (nVar.ffi == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.ffj - nVar.ffl) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.ffk - nVar.ffj) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.gfE != null) {
                if ((nVar.ffi == 1 && nVar.bnY()) || nVar.ffp) {
                    this.gfE.setVisibility(8);
                } else {
                    this.gfE.setVisibility(0);
                    this.gfE.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.ffm)) {
                this.gfC.startLoad(nVar.ffm, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.gfD == null || StringUtils.isNull(this.gfD.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.gbU.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void wK() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
