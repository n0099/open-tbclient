package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cr extends bi<com.baidu.tbadk.core.data.s> {
    private com.baidu.tbadk.core.data.s aFD;
    private int aou;
    private Drawable aov;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cr(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aou = com.baidu.tieba.t.cp_cont_d;
        this.size = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds24);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_recommend_friend_item, null);
        cv cvVar = new cv();
        cvVar.aFG = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_recommend_friend_item_root);
        cvVar.aFH = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_recommend_friend_item_top);
        cvVar.aFS = inflate.findViewById(com.baidu.tieba.w.line_3);
        cvVar.aFI = new cw();
        View findViewById = inflate.findViewById(com.baidu.tieba.w.recommend_similar_top);
        cvVar.aFI.aFT = (HeadImageView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_head);
        cvVar.aFI.aFU = (UserIconBox) findViewById.findViewById(com.baidu.tieba.w.recommend_new_crown);
        cvVar.aFI.aFV = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_user_name);
        cvVar.aFI.aFW = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_introduce);
        cvVar.aFI.aoy = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommond_detail_info_distance);
        cvVar.aFI.aFX = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_add_friend);
        cvVar.aFI.aFX.setOnClickListener(new cs(this));
        cvVar.aFI.aFY = (ImageView) inflate.findViewById(com.baidu.tieba.w.recommend_new_user_sex);
        cvVar.aFJ = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_bar_names);
        cvVar.aFK = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_bar_desc);
        cvVar.aFN = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_one);
        cvVar.aFO = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_two);
        cvVar.aFP = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_thr);
        cvVar.aFL = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_forum);
        cvVar.aFM = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_common_conern);
        cvVar.aFQ = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.recommend_similar_forum_container);
        cvVar.aFR = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.recommend_similar_commom_conern_container);
        inflate.setOnClickListener(new ct(this));
        inflate.setTag(com.baidu.tieba.w.tag_first, cvVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bi, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.s sVar) {
        super.b(i, view, viewGroup, sVar);
        this.aFD = sVar;
        boolean z = this.mSkinType == 1;
        cv cvVar = (cv) view.getTag(com.baidu.tieba.w.tag_first);
        com.baidu.tbadk.core.util.ax.i(cvVar.aFH, com.baidu.tieba.v.frs_item_control_btn_bg);
        cvVar.aFG.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.t.transparent));
        cvVar.aFG.setPadding(0, this.aBc, 0, 0);
        cvVar.aFI.aFX.setTag(sVar.nf());
        view.setTag(com.baidu.tieba.w.tag_second, sVar.nf());
        this.aDc.getLayoutMode().ab(z);
        this.aDc.getLayoutMode().h(view);
        a(cvVar, sVar, z);
        return view;
    }

    private void a(cv cvVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (cvVar != null && sVar != null && sVar.nf() != null) {
            a(cvVar.aFI, sVar.nf(), z);
            if (sVar.nc() > 0) {
                if (!TextUtils.isEmpty(sVar.nd())) {
                    cvVar.aFJ.setText(sVar.nd());
                }
                if (sVar.nc() < 3) {
                    cvVar.aFK.setVisibility(8);
                } else {
                    cvVar.aFK.setVisibility(0);
                    cvVar.aFK.setText(com.baidu.tieba.z.add_friend_forum_count);
                }
            } else {
                cvVar.aFR.setVisibility(8);
                cvVar.aFS.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.mc().mg() && sVar.ng() != null && sVar.ng().size() > 0) {
                cvVar.aFQ.setVisibility(0);
                if (sVar.nf().nm()) {
                    cvVar.aFL.setText(com.baidu.tieba.z.add_friend_her_posts);
                } else {
                    cvVar.aFL.setText(com.baidu.tieba.z.add_friend_his_posts);
                }
                switch (sVar.ng().size()) {
                    case 1:
                        cvVar.aFN.setVisibility(0);
                        cvVar.aFO.setVisibility(4);
                        cvVar.aFP.setVisibility(4);
                        cvVar.aFN.d(sVar.ng().get(0), 10, false);
                        break;
                    case 2:
                        cvVar.aFN.setVisibility(0);
                        cvVar.aFO.setVisibility(0);
                        cvVar.aFP.setVisibility(4);
                        cvVar.aFN.d(sVar.ng().get(0), 10, false);
                        cvVar.aFO.d(sVar.ng().get(1), 10, false);
                        break;
                    default:
                        cvVar.aFN.setVisibility(0);
                        cvVar.aFO.setVisibility(0);
                        cvVar.aFP.setVisibility(0);
                        cvVar.aFN.d(sVar.ng().get(0), 10, false);
                        cvVar.aFO.d(sVar.ng().get(1), 10, false);
                        cvVar.aFP.d(sVar.ng().get(2), 10, false);
                        break;
                }
            } else {
                cvVar.aFQ.setVisibility(8);
                cvVar.aFS.setVisibility(8);
            }
            cu cuVar = new cu(this, sVar);
            cvVar.aFN.setTag(com.baidu.tieba.w.tag_first, sVar);
            cvVar.aFO.setTag(com.baidu.tieba.w.tag_first, sVar);
            cvVar.aFP.setTag(com.baidu.tieba.w.tag_first, sVar);
            cvVar.aFN.setTag(com.baidu.tieba.w.tag_second, 0);
            cvVar.aFO.setTag(com.baidu.tieba.w.tag_second, 1);
            cvVar.aFP.setTag(com.baidu.tieba.w.tag_second, 2);
            cvVar.aFN.setOnClickListener(cuVar);
            cvVar.aFO.setOnClickListener(cuVar);
            cvVar.aFP.setOnClickListener(cuVar);
        }
    }

    private void a(cw cwVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && cwVar != null) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                cwVar.aFT.setVisibility(0);
                if (!TextUtils.isEmpty(tVar.nl())) {
                    cwVar.aFT.setUserId(String.valueOf(tVar.getUserId()));
                    cwVar.aFT.setImageDrawable(null);
                    cwVar.aFT.d(tVar.nl(), 12, false);
                }
            } else {
                cwVar.aFT.setVisibility(8);
            }
            if (tVar.no() != null && !TextUtils.isEmpty(tVar.no().getUrl())) {
                cwVar.aFU.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(tVar.no());
                cwVar.aFU.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
            } else {
                cwVar.aFU.setVisibility(8);
            }
            cwVar.aFV.setText(tVar.getName());
            cwVar.aFW.setText(tVar.nn());
            if (tVar.nm()) {
                com.baidu.tbadk.core.util.ax.c(cwVar.aFY, com.baidu.tieba.v.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.ax.c(cwVar.aFY, com.baidu.tieba.v.icon_pop_qz_boy);
            }
            a(cwVar, this.aFD, z);
            if (tVar.nk()) {
                cwVar.aFX.setClickable(false);
                cwVar.aFX.setBackgroundResource(com.baidu.tieba.t.transparent);
                cwVar.aFX.setText(com.baidu.tieba.z.waiting);
                cwVar.aFX.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                return;
            }
            cwVar.aFX.setClickable(true);
            cwVar.aFX.setText(com.baidu.tieba.z.frs_recommend_friend_item_add);
        }
    }

    public void am(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aFD != null && this.aFD.nf() != null && TextUtils.equals(this.aFD.nf().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aFD.nf().getUserId()))) {
            this.aFD.nf().nj();
            notifyDataSetChanged();
        }
    }

    public void a(cw cwVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && cwVar != null) {
            if (sVar.getLbsInfo() != null) {
                if (sVar.getLbsInfo().sX() == 1) {
                    cwVar.aoy.setVisibility(0);
                    com.baidu.tbadk.core.util.ax.b(cwVar.aoy, this.aou, 1);
                    cwVar.aoy.setText(this.mContext.getResources().getString(com.baidu.tieba.z.contact_yinshen));
                    cwVar.aoy.setCompoundDrawables(null, null, null, null);
                    cwVar.aFW.setVisibility(8);
                } else if (sVar.getLbsInfo().sX() == 0) {
                    if (StringUtils.isNull(sVar.getLbsInfo().getDistance())) {
                        cwVar.aoy.setVisibility(8);
                        cwVar.aFW.setVisibility(0);
                    } else {
                        cwVar.aFW.setVisibility(8);
                        cwVar.aoy.setVisibility(0);
                        cwVar.aoy.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.distance_of_you)) + sVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.ax.b(cwVar.aoy, this.aou, 1);
                        this.aov = com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_friend_pin);
                        this.aov.setBounds(0, 0, this.size, this.size);
                        cwVar.aoy.setCompoundDrawables(this.aov, null, null, null);
                    }
                } else {
                    cwVar.aoy.setVisibility(8);
                    cwVar.aFW.setVisibility(0);
                }
            } else {
                cwVar.aoy.setVisibility(8);
                cwVar.aFW.setVisibility(0);
            }
            if (sVar.nf() != null && StringUtils.isNull(sVar.nf().nn())) {
                cwVar.aFW.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cw);
    }
}
