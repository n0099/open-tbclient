package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ct extends bm<com.baidu.tbadk.core.data.o> {
    private com.baidu.tbadk.core.data.o aDO;

    /* JADX INFO: Access modifiers changed from: protected */
    public ct(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_recommend_friend_item, null);
        cx cxVar = new cx(null);
        cxVar.aDR = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_root);
        cxVar.aDS = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_top);
        cxVar.aEd = inflate.findViewById(com.baidu.tieba.v.line_3);
        cxVar.aDT = new cy(null);
        View findViewById = inflate.findViewById(com.baidu.tieba.v.recommend_similar_top);
        cxVar.aDT.aEe = (HeadImageView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_head);
        cxVar.aDT.aEf = (UserIconBox) findViewById.findViewById(com.baidu.tieba.v.recommend_new_crown);
        cxVar.aDT.aEg = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_user_name);
        cxVar.aDT.aEh = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_introduce);
        cxVar.aDT.aEi = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
        cxVar.aDT.aEi.setOnClickListener(new cu(this));
        cxVar.aDT.aEj = (ImageView) inflate.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
        cxVar.aDU = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_bar_names);
        cxVar.aDV = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_bar_desc);
        cxVar.aDY = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_pic_one);
        cxVar.aDZ = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_pic_two);
        cxVar.aEa = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_pic_thr);
        cxVar.aDW = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_forum);
        cxVar.aDX = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_common_conern);
        cxVar.aEb = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.recommend_similar_forum_container);
        cxVar.aEc = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.recommend_similar_commom_conern_container);
        inflate.setOnClickListener(new cv(this));
        inflate.setTag(com.baidu.tieba.v.tag_first, cxVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.o oVar) {
        super.b(i, view, viewGroup, oVar);
        this.aDO = oVar;
        boolean z = this.mSkinType == 1;
        cx cxVar = (cx) view.getTag(com.baidu.tieba.v.tag_first);
        com.baidu.tbadk.core.util.aw.h(cxVar.aDS, com.baidu.tieba.u.frs_item_control_btn_bg);
        cxVar.aDR.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.s.transparent));
        cxVar.aDR.setPadding(0, this.ayS, 0, 0);
        cxVar.aDT.aEi.setTag(oVar.km());
        view.setTag(com.baidu.tieba.v.tag_second, oVar.km());
        this.aBp.getLayoutMode().L(z);
        this.aBp.getLayoutMode().h(view);
        a(cxVar, oVar, z);
        return view;
    }

    private void a(cx cxVar, com.baidu.tbadk.core.data.o oVar, boolean z) {
        if (cxVar != null && oVar != null && oVar.km() != null) {
            a(cxVar.aDT, oVar.km(), z);
            if (oVar.kj() > 0) {
                if (!TextUtils.isEmpty(oVar.kk())) {
                    cxVar.aDU.setText(oVar.kk());
                }
                if (oVar.kj() < 3) {
                    cxVar.aDV.setVisibility(8);
                } else {
                    cxVar.aDV.setVisibility(0);
                    cxVar.aDV.setText(com.baidu.tieba.y.add_friend_forum_count);
                }
            } else {
                cxVar.aEc.setVisibility(8);
                cxVar.aEd.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.js().jw() && oVar.kn() != null && oVar.kn().size() > 0) {
                cxVar.aEb.setVisibility(0);
                if (oVar.km().kt()) {
                    cxVar.aDW.setText(com.baidu.tieba.y.add_friend_her_posts);
                } else {
                    cxVar.aDW.setText(com.baidu.tieba.y.add_friend_his_posts);
                }
                switch (oVar.kn().size()) {
                    case 1:
                        cxVar.aDY.setVisibility(0);
                        cxVar.aDZ.setVisibility(4);
                        cxVar.aEa.setVisibility(4);
                        cxVar.aDY.c(oVar.kn().get(0), 10, false);
                        break;
                    case 2:
                        cxVar.aDY.setVisibility(0);
                        cxVar.aDZ.setVisibility(0);
                        cxVar.aEa.setVisibility(4);
                        cxVar.aDY.c(oVar.kn().get(0), 10, false);
                        cxVar.aDZ.c(oVar.kn().get(1), 10, false);
                        break;
                    default:
                        cxVar.aDY.setVisibility(0);
                        cxVar.aDZ.setVisibility(0);
                        cxVar.aEa.setVisibility(0);
                        cxVar.aDY.c(oVar.kn().get(0), 10, false);
                        cxVar.aDZ.c(oVar.kn().get(1), 10, false);
                        cxVar.aEa.c(oVar.kn().get(2), 10, false);
                        break;
                }
            } else {
                cxVar.aEb.setVisibility(8);
                cxVar.aEd.setVisibility(8);
            }
            cw cwVar = new cw(this, oVar);
            cxVar.aDY.setTag(com.baidu.tieba.v.tag_first, oVar);
            cxVar.aDZ.setTag(com.baidu.tieba.v.tag_first, oVar);
            cxVar.aEa.setTag(com.baidu.tieba.v.tag_first, oVar);
            cxVar.aDY.setTag(com.baidu.tieba.v.tag_second, 0);
            cxVar.aDZ.setTag(com.baidu.tieba.v.tag_second, 1);
            cxVar.aEa.setTag(com.baidu.tieba.v.tag_second, 2);
            cxVar.aDY.setOnClickListener(cwVar);
            cxVar.aDZ.setOnClickListener(cwVar);
            cxVar.aEa.setOnClickListener(cwVar);
        }
    }

    private void a(cy cyVar, com.baidu.tbadk.core.data.p pVar, boolean z) {
        if (pVar != null && cyVar != null) {
            if (com.baidu.tbadk.core.k.js().ju()) {
                cyVar.aEe.setVisibility(0);
                if (!TextUtils.isEmpty(pVar.ks())) {
                    cyVar.aEe.setUserId(String.valueOf(pVar.getUserId()));
                    cyVar.aEe.setImageDrawable(null);
                    cyVar.aEe.c(pVar.ks(), 12, false);
                }
            } else {
                cyVar.aEe.setVisibility(8);
            }
            if (pVar.kv() != null && !TextUtils.isEmpty(pVar.kv().getUrl())) {
                cyVar.aEf.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(pVar.kv());
                cyVar.aEf.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                cyVar.aEf.setVisibility(8);
            }
            cyVar.aEg.setText(pVar.getName());
            cyVar.aEh.setText(pVar.ku());
            if (pVar.kt()) {
                com.baidu.tbadk.core.util.aw.c(cyVar.aEj, com.baidu.tieba.u.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.aw.c(cyVar.aEj, com.baidu.tieba.u.icon_pop_qz_boy);
            }
            if (pVar.kr()) {
                cyVar.aEi.setClickable(false);
                cyVar.aEi.setBackgroundResource(com.baidu.tieba.s.transparent);
                cyVar.aEi.setText(com.baidu.tieba.y.waiting);
                cyVar.aEi.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                return;
            }
            cyVar.aEi.setClickable(true);
            cyVar.aEi.setText(com.baidu.tieba.y.frs_recommend_friend_item_add);
        }
    }

    public void ae(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aDO != null && this.aDO.km() != null && TextUtils.equals(this.aDO.km().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aDO.km().getUserId()))) {
            this.aDO.km().kq();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cy);
    }
}
