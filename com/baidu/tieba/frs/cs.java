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
    private com.baidu.tbadk.core.data.t aGN;
    private int apr;
    private Drawable aps;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cs(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.apr = com.baidu.tieba.t.cp_cont_d;
        this.size = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds24);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_recommend_friend_item, null);
        cw cwVar = new cw();
        cwVar.aGQ = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_recommend_friend_item_root);
        cwVar.aGR = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_recommend_friend_item_top);
        cwVar.aHc = inflate.findViewById(com.baidu.tieba.w.line_3);
        cwVar.aGS = new cx();
        View findViewById = inflate.findViewById(com.baidu.tieba.w.recommend_similar_top);
        cwVar.aGS.aHd = (HeadImageView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_head);
        cwVar.aGS.aHe = (UserIconBox) findViewById.findViewById(com.baidu.tieba.w.recommend_new_crown);
        cwVar.aGS.aHf = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_user_name);
        cwVar.aGS.aHg = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_introduce);
        cwVar.aGS.apv = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommond_detail_info_distance);
        cwVar.aGS.aHh = (TextView) findViewById.findViewById(com.baidu.tieba.w.recommend_new_add_friend);
        cwVar.aGS.aHh.setOnClickListener(new ct(this));
        cwVar.aGS.aHi = (ImageView) inflate.findViewById(com.baidu.tieba.w.recommend_new_user_sex);
        cwVar.aGT = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_bar_names);
        cwVar.aGU = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_bar_desc);
        cwVar.aGX = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_one);
        cwVar.aGY = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_two);
        cwVar.aGZ = (TbImageView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_pic_thr);
        cwVar.aGV = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_forum);
        cwVar.aGW = (TextView) inflate.findViewById(com.baidu.tieba.w.recommend_similar_common_conern);
        cwVar.aHa = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.recommend_similar_forum_container);
        cwVar.aHb = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.recommend_similar_commom_conern_container);
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
        this.aGN = tVar;
        boolean z = this.mSkinType == 1;
        cw cwVar = (cw) view.getTag(com.baidu.tieba.w.tag_first);
        com.baidu.tbadk.core.util.bc.i(cwVar.aGR, com.baidu.tieba.v.frs_item_control_btn_bg);
        cwVar.aGQ.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.t.transparent));
        cwVar.aGQ.setPadding(0, this.aCd, 0, 0);
        cwVar.aGS.aHh.setTag(tVar.nh());
        view.setTag(com.baidu.tieba.w.tag_second, tVar.nh());
        this.aEd.getLayoutMode().ab(z);
        this.aEd.getLayoutMode().h(view);
        a(cwVar, tVar, z);
        return view;
    }

    private void a(cw cwVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (cwVar != null && tVar != null && tVar.nh() != null) {
            a(cwVar.aGS, tVar.nh(), z);
            if (tVar.ne() > 0) {
                if (!TextUtils.isEmpty(tVar.nf())) {
                    cwVar.aGT.setText(tVar.nf());
                }
                if (tVar.ne() < 3) {
                    cwVar.aGU.setVisibility(8);
                } else {
                    cwVar.aGU.setVisibility(0);
                    cwVar.aGU.setText(com.baidu.tieba.z.add_friend_forum_count);
                }
            } else {
                cwVar.aHb.setVisibility(8);
                cwVar.aHc.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.mc().mg() && tVar.ni() != null && tVar.ni().size() > 0) {
                cwVar.aHa.setVisibility(0);
                if (tVar.nh().no()) {
                    cwVar.aGV.setText(com.baidu.tieba.z.add_friend_her_posts);
                } else {
                    cwVar.aGV.setText(com.baidu.tieba.z.add_friend_his_posts);
                }
                switch (tVar.ni().size()) {
                    case 1:
                        cwVar.aGX.setVisibility(0);
                        cwVar.aGY.setVisibility(4);
                        cwVar.aGZ.setVisibility(4);
                        cwVar.aGX.d(tVar.ni().get(0), 10, false);
                        break;
                    case 2:
                        cwVar.aGX.setVisibility(0);
                        cwVar.aGY.setVisibility(0);
                        cwVar.aGZ.setVisibility(4);
                        cwVar.aGX.d(tVar.ni().get(0), 10, false);
                        cwVar.aGY.d(tVar.ni().get(1), 10, false);
                        break;
                    default:
                        cwVar.aGX.setVisibility(0);
                        cwVar.aGY.setVisibility(0);
                        cwVar.aGZ.setVisibility(0);
                        cwVar.aGX.d(tVar.ni().get(0), 10, false);
                        cwVar.aGY.d(tVar.ni().get(1), 10, false);
                        cwVar.aGZ.d(tVar.ni().get(2), 10, false);
                        break;
                }
            } else {
                cwVar.aHa.setVisibility(8);
                cwVar.aHc.setVisibility(8);
            }
            cv cvVar = new cv(this, tVar);
            cwVar.aGX.setTag(com.baidu.tieba.w.tag_first, tVar);
            cwVar.aGY.setTag(com.baidu.tieba.w.tag_first, tVar);
            cwVar.aGZ.setTag(com.baidu.tieba.w.tag_first, tVar);
            cwVar.aGX.setTag(com.baidu.tieba.w.tag_second, 0);
            cwVar.aGY.setTag(com.baidu.tieba.w.tag_second, 1);
            cwVar.aGZ.setTag(com.baidu.tieba.w.tag_second, 2);
            cwVar.aGX.setOnClickListener(cvVar);
            cwVar.aGY.setOnClickListener(cvVar);
            cwVar.aGZ.setOnClickListener(cvVar);
        }
    }

    private void a(cx cxVar, com.baidu.tbadk.core.data.u uVar, boolean z) {
        if (uVar != null && cxVar != null) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                cxVar.aHd.setVisibility(0);
                if (!TextUtils.isEmpty(uVar.nn())) {
                    cxVar.aHd.setUserId(String.valueOf(uVar.getUserId()));
                    cxVar.aHd.setImageDrawable(null);
                    cxVar.aHd.d(uVar.nn(), 12, false);
                }
            } else {
                cxVar.aHd.setVisibility(8);
            }
            if (uVar.nq() != null && !TextUtils.isEmpty(uVar.nq().getUrl())) {
                cxVar.aHe.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(uVar.nq());
                cxVar.aHe.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
            } else {
                cxVar.aHe.setVisibility(8);
            }
            cxVar.aHf.setText(uVar.getName());
            cxVar.aHg.setText(uVar.np());
            if (uVar.no()) {
                com.baidu.tbadk.core.util.bc.c(cxVar.aHi, com.baidu.tieba.v.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.bc.c(cxVar.aHi, com.baidu.tieba.v.icon_pop_qz_boy);
            }
            a(cxVar, this.aGN, z);
            if (uVar.nm()) {
                cxVar.aHh.setClickable(false);
                cxVar.aHh.setBackgroundResource(com.baidu.tieba.t.transparent);
                cxVar.aHh.setText(com.baidu.tieba.z.waiting);
                cxVar.aHh.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                return;
            }
            cxVar.aHh.setClickable(true);
            cxVar.aHh.setText(com.baidu.tieba.z.frs_recommend_friend_item_add);
        }
    }

    public void ap(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aGN != null && this.aGN.nh() != null && TextUtils.equals(this.aGN.nh().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aGN.nh().getUserId()))) {
            this.aGN.nh().nl();
            notifyDataSetChanged();
        }
    }

    public void a(cx cxVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && cxVar != null) {
            if (tVar.getLbsInfo() != null) {
                if (tVar.getLbsInfo().to() == 1) {
                    cxVar.apv.setVisibility(0);
                    com.baidu.tbadk.core.util.bc.b(cxVar.apv, this.apr, 1);
                    cxVar.apv.setText(this.mContext.getResources().getString(com.baidu.tieba.z.contact_yinshen));
                    cxVar.apv.setCompoundDrawables(null, null, null, null);
                    cxVar.aHg.setVisibility(8);
                } else if (tVar.getLbsInfo().to() == 0) {
                    if (StringUtils.isNull(tVar.getLbsInfo().getDistance())) {
                        cxVar.apv.setVisibility(8);
                        cxVar.aHg.setVisibility(0);
                    } else {
                        cxVar.aHg.setVisibility(8);
                        cxVar.apv.setVisibility(0);
                        cxVar.apv.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.distance_of_you)) + tVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.bc.b(cxVar.apv, this.apr, 1);
                        this.aps = com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_friend_pin);
                        this.aps.setBounds(0, 0, this.size, this.size);
                        cxVar.apv.setCompoundDrawables(this.aps, null, null, null);
                    }
                } else {
                    cxVar.apv.setVisibility(8);
                    cxVar.aHg.setVisibility(0);
                }
            } else {
                cxVar.apv.setVisibility(8);
                cxVar.aHg.setVisibility(0);
            }
            if (tVar.nh() != null && StringUtils.isNull(tVar.nh().np())) {
                cxVar.aHg.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cx);
    }
}
