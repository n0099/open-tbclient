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
    private String eIk;
    private boolean eIl;
    private d.a fgx;
    private TextView gbZ;
    private TextView gfH;
    private HeadImageView gfI;
    private TextView gfJ;
    private TextView gfK;
    private TextView gfL;
    private TextView gfM;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.eIk = str;
        this.eIl = z;
        initView();
    }

    private void initView() {
        if ("hot".equals(this.eIk) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eIk) || "hour".equals(this.eIk) || "charm_day".equals(this.eIk)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            wJ();
            this.gfH = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gfI = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gbZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gfJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gfK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.gfM = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.gfL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gfL.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gfL.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.gfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fgx != null) {
                        a.this.fgx.f(view, a.this.eIk);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eIk) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eIk) || "rich".equals(this.eIk)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.gfH = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.gfI = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.gbZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.gfJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.gfL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.gfL.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.gfL.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.eIk) && this.eIl) {
                this.gfL.setVisibility(8);
            } else {
                this.gfL.setVisibility(0);
            }
            this.gfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fgx != null) {
                        a.this.fgx.f(view, a.this.eIk);
                    }
                }
            });
        }
        if (this.gfI != null) {
            this.gfI.setIsRound(true);
            this.gfI.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.fgx = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.eIl) {
                this.gfL.setVisibility(8);
                if (nVar.ffu) {
                    this.gfM.setVisibility(0);
                    this.gfM.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.ffo)));
                    return;
                }
                this.gfM.setVisibility(8);
            } else if (nVar.ffu) {
                this.gfL.setVisibility(8);
                this.gfM.setVisibility(0);
                this.gfM.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.ffo)));
            } else {
                this.gfL.setVisibility(0);
                this.gfM.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.eIk, "hour")) {
                if (nVar.ffn <= 0) {
                    this.gfH.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gfH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gfH.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfH.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfH.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.gfH.setText(String.valueOf(nVar.ffn));
                    this.gfH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gfH.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gfH.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfH.setLayoutParams(layoutParams2);
                    if (nVar.ffn == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.ffo - nVar.ffq) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.ffn >= 2 && nVar.ffn <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.ffp - nVar.ffo) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.ffn > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.ffs - nVar.ffo) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.eIk, "charm_day")) {
                if (nVar.ffn <= 0 || nVar.ffn > 100) {
                    this.gfH.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.gfH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.gfH.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gfH.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfH.setLayoutParams(layoutParams3);
                    if (nVar.ffo <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.ffs - nVar.ffo) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.gfH.setText(String.valueOf(nVar.ffn));
                    this.gfH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.gfH.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gfH.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.gfH.setLayoutParams(layoutParams4);
                    if (nVar.ffn == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.ffo - nVar.ffq) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.ffp - nVar.ffo) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.gfK != null) {
                if ((nVar.ffn == 1 && nVar.bnW()) || nVar.ffu) {
                    this.gfK.setVisibility(8);
                } else {
                    this.gfK.setVisibility(0);
                    this.gfK.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.ffr)) {
                this.gfI.startLoad(nVar.ffr, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.gfJ == null || StringUtils.isNull(this.gfJ.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.gbZ.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void wJ() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
