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
public class cs extends bh<com.baidu.tbadk.core.data.t> {
    private com.baidu.tbadk.core.data.t aGK;
    private int apn;
    private Drawable apo;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cs(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.apn = com.baidu.tieba.t.cp_cont_d;
        this.size = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds24);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_recommend_friend_item, null);
        cw cwVar = new cw();
        cwVar.aGN = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_recommend_friend_item_root);
        cwVar.aGO = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_recommend_friend_item_top);
        cwVar.aGZ = inflate.findViewById(com.baidu.tieba.w.line_3);
        cwVar.aGP = new cx();
        View findViewById = inflate.findViewById(com.baidu.tieba.w.recommend_similar_top);
        cwVar.aGP.aHa = (HeadImageView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_head);
        cwVar.aGP.aHb = (UserIconBox) findViewById.findViewById(com.baidu.tieba.w.recommend_new_crown);
        cwVar.aGP.aHc = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_user_name);
        cwVar.aGP.aHd = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_introduce);
        cwVar.aGP.aps = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommond_detail_info_distance);
        cwVar.aGP.aHe = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_add_friend);
        cwVar.aGP.aHe.setOnClickListener(new ct(this));
        cwVar.aGP.aHf = (ImageView) inflate.findViewById(com.baidu.tieba.w.recommend_new_user_sex);
        cwVar.aGQ = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_bar_names);
        cwVar.aGR = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_bar_desc);
        cwVar.aGU = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_one);
        cwVar.aGV = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_two);
        cwVar.aGW = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_thr);
        cwVar.aGS = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_forum);
        cwVar.aGT = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_common_conern);
        cwVar.aGX = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.recommend_similar_forum_container);
        cwVar.aGY = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.recommend_similar_commom_conern_container);
        inflate.setOnClickListener(new cu(this));
        inflate.setTag(com.baidu.tieba.w.tag_first, cwVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.t tVar) {
        super.b(i, view, viewGroup, tVar);
        this.aGK = tVar;
        boolean z = this.mSkinType == 1;
        cw cwVar = (cw) view.getTag(com.baidu.tieba.w.tag_first);
        com.baidu.tbadk.core.util.bc.i(cwVar.aGO, com.baidu.tieba.v.frs_item_control_btn_bg);
        cwVar.aGN.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.t.transparent));
        cwVar.aGN.setPadding(0, this.aCa, 0, 0);
        cwVar.aGP.aHe.setTag(tVar.na());
        view.setTag(com.baidu.tieba.w.tag_second, tVar.na());
        this.aEa.getLayoutMode().ab(z);
        this.aEa.getLayoutMode().h(view);
        a(cwVar, tVar, z);
        return view;
    }

    private void a(cw cwVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (cwVar != null && tVar != null && tVar.na() != null) {
            a(cwVar.aGP, tVar.na(), z);
            if (tVar.mX() > 0) {
                if (!TextUtils.isEmpty(tVar.mY())) {
                    cwVar.aGQ.setText(tVar.mY());
                }
                if (tVar.mX() < 3) {
                    cwVar.aGR.setVisibility(8);
                } else {
                    cwVar.aGR.setVisibility(0);
                    cwVar.aGR.setText(com.baidu.tieba.z.add_friend_forum_count);
                }
            } else {
                cwVar.aGY.setVisibility(8);
                cwVar.aGZ.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.lV().lZ() && tVar.nb() != null && tVar.nb().size() > 0) {
                cwVar.aGX.setVisibility(0);
                if (tVar.na().nh()) {
                    cwVar.aGS.setText(com.baidu.tieba.z.add_friend_her_posts);
                } else {
                    cwVar.aGS.setText(com.baidu.tieba.z.add_friend_his_posts);
                }
                switch (tVar.nb().size()) {
                    case 1:
                        cwVar.aGU.setVisibility(0);
                        cwVar.aGV.setVisibility(4);
                        cwVar.aGW.setVisibility(4);
                        cwVar.aGU.d(tVar.nb().get(0), 10, false);
                        break;
                    case 2:
                        cwVar.aGU.setVisibility(0);
                        cwVar.aGV.setVisibility(0);
                        cwVar.aGW.setVisibility(4);
                        cwVar.aGU.d(tVar.nb().get(0), 10, false);
                        cwVar.aGV.d(tVar.nb().get(1), 10, false);
                        break;
                    default:
                        cwVar.aGU.setVisibility(0);
                        cwVar.aGV.setVisibility(0);
                        cwVar.aGW.setVisibility(0);
                        cwVar.aGU.d(tVar.nb().get(0), 10, false);
                        cwVar.aGV.d(tVar.nb().get(1), 10, false);
                        cwVar.aGW.d(tVar.nb().get(2), 10, false);
                        break;
                }
            } else {
                cwVar.aGX.setVisibility(8);
                cwVar.aGZ.setVisibility(8);
            }
            cv cvVar = new cv(this, tVar);
            cwVar.aGU.setTag(com.baidu.tieba.w.tag_first, tVar);
            cwVar.aGV.setTag(com.baidu.tieba.w.tag_first, tVar);
            cwVar.aGW.setTag(com.baidu.tieba.w.tag_first, tVar);
            cwVar.aGU.setTag(com.baidu.tieba.w.tag_second, 0);
            cwVar.aGV.setTag(com.baidu.tieba.w.tag_second, 1);
            cwVar.aGW.setTag(com.baidu.tieba.w.tag_second, 2);
            cwVar.aGU.setOnClickListener(cvVar);
            cwVar.aGV.setOnClickListener(cvVar);
            cwVar.aGW.setOnClickListener(cvVar);
        }
    }

    private void a(cx cxVar, com.baidu.tbadk.core.data.u uVar, boolean z) {
        if (uVar != null && cxVar != null) {
            if (com.baidu.tbadk.core.l.lV().lX()) {
                cxVar.aHa.setVisibility(0);
                if (!TextUtils.isEmpty(uVar.ng())) {
                    cxVar.aHa.setUserId(String.valueOf(uVar.getUserId()));
                    cxVar.aHa.setImageDrawable(null);
                    cxVar.aHa.d(uVar.ng(), 12, false);
                }
            } else {
                cxVar.aHa.setVisibility(8);
            }
            if (uVar.nj() != null && !TextUtils.isEmpty(uVar.nj().getUrl())) {
                cxVar.aHb.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(uVar.nj());
                cxVar.aHb.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
            } else {
                cxVar.aHb.setVisibility(8);
            }
            cxVar.aHc.setText(uVar.getName());
            cxVar.aHd.setText(uVar.ni());
            if (uVar.nh()) {
                com.baidu.tbadk.core.util.bc.c(cxVar.aHf, com.baidu.tieba.v.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.bc.c(cxVar.aHf, com.baidu.tieba.v.icon_pop_qz_boy);
            }
            a(cxVar, this.aGK, z);
            if (uVar.nf()) {
                cxVar.aHe.setClickable(false);
                cxVar.aHe.setBackgroundResource(com.baidu.tieba.t.transparent);
                cxVar.aHe.setText(com.baidu.tieba.z.waiting);
                cxVar.aHe.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                return;
            }
            cxVar.aHe.setClickable(true);
            cxVar.aHe.setText(com.baidu.tieba.z.frs_recommend_friend_item_add);
        }
    }

    public void ap(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aGK != null && this.aGK.na() != null && TextUtils.equals(this.aGK.na().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aGK.na().getUserId()))) {
            this.aGK.na().ne();
            notifyDataSetChanged();
        }
    }

    public void a(cx cxVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && cxVar != null) {
            if (tVar.getLbsInfo() != null) {
                if (tVar.getLbsInfo().ti() == 1) {
                    cxVar.aps.setVisibility(0);
                    com.baidu.tbadk.core.util.bc.b(cxVar.aps, this.apn, 1);
                    cxVar.aps.setText(this.mContext.getResources().getString(com.baidu.tieba.z.contact_yinshen));
                    cxVar.aps.setCompoundDrawables(null, null, null, null);
                    cxVar.aHd.setVisibility(8);
                } else if (tVar.getLbsInfo().ti() == 0) {
                    if (StringUtils.isNull(tVar.getLbsInfo().getDistance())) {
                        cxVar.aps.setVisibility(8);
                        cxVar.aHd.setVisibility(0);
                    } else {
                        cxVar.aHd.setVisibility(8);
                        cxVar.aps.setVisibility(0);
                        cxVar.aps.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.distance_of_you)) + tVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.bc.b(cxVar.aps, this.apn, 1);
                        this.apo = com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_friend_pin);
                        this.apo.setBounds(0, 0, this.size, this.size);
                        cxVar.aps.setCompoundDrawables(this.apo, null, null, null);
                    }
                } else {
                    cxVar.aps.setVisibility(8);
                    cxVar.aHd.setVisibility(0);
                }
            } else {
                cxVar.aps.setVisibility(8);
                cxVar.aHd.setVisibility(0);
            }
            if (tVar.na() != null && StringUtils.isNull(tVar.na().ni())) {
                cxVar.aHd.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cx);
    }
}
