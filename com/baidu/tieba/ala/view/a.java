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
import com.baidu.live.q.a;
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
    private String edB;
    private boolean edC;
    private d.a evU;
    private TextView fqP;
    private TextView fuu;
    private HeadImageView fuv;
    private TextView fuw;
    private TextView fux;
    private TextView fuy;
    private TextView fuz;
    private Context mContext;
    private View mRootView;

    public a(Context context, String str, boolean z) {
        this.mContext = context;
        this.edB = str;
        this.edC = z;
        initView();
    }

    public void initView() {
        if ("hot".equals(this.edB) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edB) || "hour".equals(this.edB) || "charm_day".equals(this.edB)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_hot_bottom_layout, (ViewGroup) null);
            this.contentView = this.mRootView.findViewById(a.g.content_view);
            qZ();
            this.fuu = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fuv = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fqP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fuw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fux = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
            this.fuz = (TextView) this.mRootView.findViewById(a.g.rank_list_charm_right);
            this.fuy = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fuy.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fuy.setBackgroundResource(a.f.qm_hour_rank_list_support_bg);
            }
            this.fuy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.evU != null) {
                        a.this.evU.f(view, a.this.edB);
                    }
                }
            });
        } else if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.edB) || SdkStaticKeys.RANK_TYPE_CHARM.equals(this.edB) || "rich".equals(this.edB)) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_bottom_view, (ViewGroup) null);
            this.fuu = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
            this.fuv = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
            this.fqP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
            this.fuw = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
            this.fuy = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.fuy.setBackgroundResource(a.f.hk_ala_rank_list_support_bg);
            } else {
                this.fuy.setBackgroundResource(a.f.qm_ala_rank_list_support_bg);
            }
            if (SdkStaticKeys.RANK_TYPE_CHARM.equals(this.edB) && this.edC) {
                this.fuy.setVisibility(8);
            } else {
                this.fuy.setVisibility(0);
            }
            this.fuy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.evU != null) {
                        a.this.evU.f(view, a.this.edB);
                    }
                }
            });
        } else if ("pk".equals(this.edB)) {
        }
        if (this.fuv != null) {
            this.fuv.setIsRound(true);
            this.fuv.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(d.a aVar) {
        this.evU = aVar;
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.edC) {
                this.fuy.setVisibility(8);
                if (nVar.euQ) {
                    this.fuz.setVisibility(0);
                    this.fuz.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.euK)));
                    return;
                }
                this.fuz.setVisibility(8);
            } else if (nVar.euQ) {
                this.fuy.setVisibility(8);
                this.fuz.setVisibility(0);
                this.fuz.setText(String.format(this.mContext.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatForHourRankValue(nVar.euK)));
            } else {
                this.fuy.setVisibility(0);
                this.fuz.setVisibility(8);
            }
        }
    }

    public void b(n nVar) {
        int i = 10;
        if (nVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.equals(this.edB, "hour")) {
                if (nVar.euJ <= 0) {
                    this.fuu.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fuu.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fuu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuu.getLayoutParams();
                    layoutParams.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fuu.setLayoutParams(layoutParams);
                    spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                } else {
                    this.fuu.setText(String.valueOf(nVar.euJ));
                    this.fuu.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fuu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fuu.getLayoutParams();
                    layoutParams2.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams2.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fuu.setLayoutParams(layoutParams2);
                    if (nVar.euJ == 1) {
                        String format = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.euK - nVar.euM) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                    } else if (nVar.euJ >= 2 && nVar.euJ <= 10) {
                        String str = StringHelper.formatForHourRankValue((nVar.euL - nVar.euK) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    } else if (nVar.euJ > 10) {
                        String format2 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "10", StringHelper.formatForHourRankValue(nVar.euO - nVar.euK) + "");
                        spannableStringBuilder.append((CharSequence) format2);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    }
                }
            } else if (TextUtils.equals(this.edB, "charm_day")) {
                if (nVar.euJ <= 0 || nVar.euJ > 100) {
                    this.fuu.setText(this.mContext.getString(a.i.ala_rank_list_no_level));
                    this.fuu.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize28));
                    this.fuu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fuu.getLayoutParams();
                    layoutParams3.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds30);
                    layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fuu.setLayoutParams(layoutParams3);
                    if (nVar.euK <= 0) {
                        spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.bottom_rank_list_no_money));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                    } else {
                        String format3 = String.format(this.mContext.getString(a.i.bottom_rank_list_out), "100", StringHelper.formatForHourRankValue(nVar.euO - nVar.euK) + "");
                        spannableStringBuilder.append((CharSequence) format3);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 4, format3.length(), 34);
                    }
                } else {
                    this.fuu.setText(String.valueOf(nVar.euJ));
                    this.fuu.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize34));
                    this.fuu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_d));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fuu.getLayoutParams();
                    layoutParams4.rightMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds28);
                    layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds34);
                    this.fuu.setLayoutParams(layoutParams4);
                    if (nVar.euJ == 1) {
                        String format4 = String.format(this.mContext.getString(a.i.bottom_rank_list_1), StringHelper.formatForHourRankValue(nVar.euK - nVar.euM) + "");
                        spannableStringBuilder.append((CharSequence) format4);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format4.length(), 34);
                    } else {
                        String str2 = StringHelper.formatForHourRankValue((nVar.euL - nVar.euK) + 1) + "";
                        spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.bottom_rank_list_in), str2));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str2.length() + 4, 34);
                    }
                }
            }
            if (this.fux != null) {
                if ((nVar.euJ == 1 && nVar.bbQ()) || nVar.euQ) {
                    this.fux.setVisibility(8);
                } else {
                    this.fux.setVisibility(0);
                    this.fux.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(nVar.euN)) {
                this.fuv.startLoad(nVar.euN, 12, false);
            }
            if (!StringUtils.isNull(nVar.getNameShow())) {
                String nameShow = nVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(nVar.getNameShow());
                i = (this.fuw == null || StringUtils.isNull(this.fuw.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.mContext.getString(a.i.ala_rank_list_user_name_limit), TextHelper.subStringWithEmoji(nVar.getNameShow(), i));
                }
                this.fqP.setText(nameShow);
            }
            a(nVar);
        }
    }

    public void qZ() {
        if (this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_rank_list_bottom_view_corner_bg);
            } else {
                this.contentView.setBackgroundColor(this.mContext.getResources().getColor(a.d.ala_rank_list_bottom_bg_color));
            }
        }
    }
}
