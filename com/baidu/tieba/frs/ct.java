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
    private com.baidu.tbadk.core.data.o aDY;

    /* JADX INFO: Access modifiers changed from: protected */
    public ct(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_recommend_friend_item, null);
        cx cxVar = new cx(null);
        cxVar.aEb = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_root);
        cxVar.aEc = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_top);
        cxVar.aEn = inflate.findViewById(com.baidu.tieba.v.line_3);
        cxVar.aEd = new cy(null);
        View findViewById = inflate.findViewById(com.baidu.tieba.v.recommend_similar_top);
        cxVar.aEd.aEo = (HeadImageView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_head);
        cxVar.aEd.aEp = (UserIconBox) findViewById.findViewById(com.baidu.tieba.v.recommend_new_crown);
        cxVar.aEd.aEq = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_user_name);
        cxVar.aEd.aEr = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_introduce);
        cxVar.aEd.aEs = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
        cxVar.aEd.aEs.setOnClickListener(new cu(this));
        cxVar.aEd.aEt = (ImageView) inflate.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
        cxVar.aEe = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_bar_names);
        cxVar.aEf = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_bar_desc);
        cxVar.aEi = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_pic_one);
        cxVar.aEj = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_pic_two);
        cxVar.aEk = (TbImageView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_pic_thr);
        cxVar.aEg = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_forum);
        cxVar.aEh = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_similar_common_conern);
        cxVar.aEl = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.recommend_similar_forum_container);
        cxVar.aEm = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.recommend_similar_commom_conern_container);
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
        this.aDY = oVar;
        boolean z = this.mSkinType == 1;
        cx cxVar = (cx) view.getTag(com.baidu.tieba.v.tag_first);
        com.baidu.tbadk.core.util.aw.h(cxVar.aEc, com.baidu.tieba.u.frs_item_control_btn_bg);
        cxVar.aEb.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.s.transparent));
        cxVar.aEb.setPadding(0, this.azb, 0, 0);
        cxVar.aEd.aEs.setTag(oVar.km());
        view.setTag(com.baidu.tieba.v.tag_second, oVar.km());
        this.aBz.getLayoutMode().L(z);
        this.aBz.getLayoutMode().h(view);
        a(cxVar, oVar, z);
        return view;
    }

    private void a(cx cxVar, com.baidu.tbadk.core.data.o oVar, boolean z) {
        if (cxVar != null && oVar != null && oVar.km() != null) {
            a(cxVar.aEd, oVar.km(), z);
            if (oVar.kj() > 0) {
                if (!TextUtils.isEmpty(oVar.kk())) {
                    cxVar.aEe.setText(oVar.kk());
                }
                if (oVar.kj() < 3) {
                    cxVar.aEf.setVisibility(8);
                } else {
                    cxVar.aEf.setVisibility(0);
                    cxVar.aEf.setText(com.baidu.tieba.y.add_friend_forum_count);
                }
            } else {
                cxVar.aEm.setVisibility(8);
                cxVar.aEn.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.js().jw() && oVar.kn() != null && oVar.kn().size() > 0) {
                cxVar.aEl.setVisibility(0);
                if (oVar.km().kt()) {
                    cxVar.aEg.setText(com.baidu.tieba.y.add_friend_her_posts);
                } else {
                    cxVar.aEg.setText(com.baidu.tieba.y.add_friend_his_posts);
                }
                switch (oVar.kn().size()) {
                    case 1:
                        cxVar.aEi.setVisibility(0);
                        cxVar.aEj.setVisibility(4);
                        cxVar.aEk.setVisibility(4);
                        cxVar.aEi.c(oVar.kn().get(0), 10, false);
                        break;
                    case 2:
                        cxVar.aEi.setVisibility(0);
                        cxVar.aEj.setVisibility(0);
                        cxVar.aEk.setVisibility(4);
                        cxVar.aEi.c(oVar.kn().get(0), 10, false);
                        cxVar.aEj.c(oVar.kn().get(1), 10, false);
                        break;
                    default:
                        cxVar.aEi.setVisibility(0);
                        cxVar.aEj.setVisibility(0);
                        cxVar.aEk.setVisibility(0);
                        cxVar.aEi.c(oVar.kn().get(0), 10, false);
                        cxVar.aEj.c(oVar.kn().get(1), 10, false);
                        cxVar.aEk.c(oVar.kn().get(2), 10, false);
                        break;
                }
            } else {
                cxVar.aEl.setVisibility(8);
                cxVar.aEn.setVisibility(8);
            }
            cw cwVar = new cw(this, oVar);
            cxVar.aEi.setTag(com.baidu.tieba.v.tag_first, oVar);
            cxVar.aEj.setTag(com.baidu.tieba.v.tag_first, oVar);
            cxVar.aEk.setTag(com.baidu.tieba.v.tag_first, oVar);
            cxVar.aEi.setTag(com.baidu.tieba.v.tag_second, 0);
            cxVar.aEj.setTag(com.baidu.tieba.v.tag_second, 1);
            cxVar.aEk.setTag(com.baidu.tieba.v.tag_second, 2);
            cxVar.aEi.setOnClickListener(cwVar);
            cxVar.aEj.setOnClickListener(cwVar);
            cxVar.aEk.setOnClickListener(cwVar);
        }
    }

    private void a(cy cyVar, com.baidu.tbadk.core.data.p pVar, boolean z) {
        if (pVar != null && cyVar != null) {
            if (com.baidu.tbadk.core.l.js().ju()) {
                cyVar.aEo.setVisibility(0);
                if (!TextUtils.isEmpty(pVar.ks())) {
                    cyVar.aEo.setUserId(String.valueOf(pVar.getUserId()));
                    cyVar.aEo.setImageDrawable(null);
                    cyVar.aEo.c(pVar.ks(), 12, false);
                }
            } else {
                cyVar.aEo.setVisibility(8);
            }
            if (pVar.kv() != null && !TextUtils.isEmpty(pVar.kv().getUrl())) {
                cyVar.aEp.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(pVar.kv());
                cyVar.aEp.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                cyVar.aEp.setVisibility(8);
            }
            cyVar.aEq.setText(pVar.getName());
            cyVar.aEr.setText(pVar.ku());
            if (pVar.kt()) {
                com.baidu.tbadk.core.util.aw.c(cyVar.aEt, com.baidu.tieba.u.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.aw.c(cyVar.aEt, com.baidu.tieba.u.icon_pop_qz_boy);
            }
            if (pVar.kr()) {
                cyVar.aEs.setClickable(false);
                cyVar.aEs.setBackgroundResource(com.baidu.tieba.s.transparent);
                cyVar.aEs.setText(com.baidu.tieba.y.waiting);
                cyVar.aEs.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                return;
            }
            cyVar.aEs.setClickable(true);
            cyVar.aEs.setText(com.baidu.tieba.y.frs_recommend_friend_item_add);
        }
    }

    public void ae(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aDY != null && this.aDY.km() != null && TextUtils.equals(this.aDY.km().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aDY.km().getUserId()))) {
            this.aDY.km().kq();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cy);
    }
}
