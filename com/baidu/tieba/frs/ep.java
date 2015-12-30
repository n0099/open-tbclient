package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class ep extends bp<com.baidu.tbadk.core.data.z, et> {
    private int bhu;

    /* JADX INFO: Access modifiers changed from: protected */
    public ep(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bhu = 0;
        this.bhu = com.baidu.adp.lib.util.k.d(this.bbA.getPageContext().getPageActivity(), n.e.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public et a(ViewGroup viewGroup) {
        return new et(LayoutInflater.from(this.mContext).inflate(n.h.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, et etVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) etVar);
        return a(i, view, zVar, etVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.z zVar, et etVar) {
        eq eqVar = new eq(this, zVar);
        er erVar = new er(this, zVar);
        b(zVar, etVar);
        c(zVar, etVar);
        g(zVar, etVar);
        f(zVar, etVar);
        a(zVar, etVar, eqVar);
        a(zVar, etVar, i);
        a(zVar, etVar, i, erVar);
        e(zVar, etVar);
        d(zVar, etVar);
        a(zVar, etVar);
        ca.a(this.bbA, etVar.biY, etVar.bcC, etVar.agS, etVar.bhC, etVar.bhD, etVar.bjd, view, zVar, this.mSkinType, eqVar);
        a(view, etVar);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.z zVar, et etVar) {
        if (zVar != null && etVar != null) {
            if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
                etVar.agz.setVisibility(0);
                etVar.agz.setText(com.baidu.tbadk.core.util.ax.x(zVar.getPraise().getNum()));
            } else {
                etVar.agz.setVisibility(8);
            }
            int reply_num = zVar.getReply_num();
            if (reply_num > 0) {
                etVar.bcG.setVisibility(0);
                etVar.bcG.setText(com.baidu.tbadk.core.util.ax.x(reply_num));
                return;
            }
            etVar.bcG.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.z zVar, et etVar) {
        if (zVar != null && etVar != null) {
            etVar.agy.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.z zVar, et etVar) {
        if (zVar != null && zVar.getAuthor() != null && etVar != null) {
            etVar.agS.setText(zVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.z zVar, et etVar) {
        VideoInfo sE;
        if (zVar != null && etVar != null && (sE = zVar.sE()) != null) {
            if (com.baidu.tbadk.core.m.qQ().qW() && !StringUtils.isNull(sE.video_url)) {
                etVar.bje.setVisibility(0);
                etVar.bjb.d(sE.thumbnail_url, 13, false);
                etVar.bje.setOnClickListener(new es(this, zVar, sE));
                com.baidu.tbadk.core.util.as.i(etVar.bjb, n.f.icon_play_video);
                return;
            }
            etVar.bje.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.z zVar, et etVar) {
        if (zVar != null && etVar != null) {
            com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (zVar.sC() == 1) {
                etVar.aOn.setVisibility(8);
                return;
            }
            etVar.aOn.setVisibility(0);
            zVar.parser_title();
            etVar.aOn.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mC(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(etVar.aOn, n.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(etVar.aOn, n.d.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.z zVar, et etVar, int i, View.OnClickListener onClickListener) {
        if (zVar != null && etVar != null && i >= 0 && zVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                etVar.agT.setVisibility(0);
                com.baidu.tbadk.core.util.as.b(etVar.agS, n.d.cp_cont_h, 1);
                etVar.agT.setTag(Integer.valueOf(i));
                etVar.agT.setOnClickListener(onClickListener);
                etVar.agT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
                return;
            }
            etVar.agT.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(etVar.agS, n.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.z zVar, et etVar, int i) {
        if (zVar != null && zVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                etVar.agU.setVisibility(0);
                com.baidu.tbadk.core.util.as.b(etVar.agS, n.d.cp_cont_h, 1);
                etVar.agU.setTag(Integer.valueOf(i));
                etVar.agU.setOnClickListener(null);
                etVar.agU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds10), true);
                etVar.agU.setOnClickListener(null);
                return;
            }
            etVar.agU.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(etVar.agS, n.d.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.z zVar, et etVar, View.OnClickListener onClickListener) {
        if (zVar == null || zVar.getAuthor() == null || !com.baidu.tbadk.core.m.qQ().qS()) {
            etVar.bcC.setVisibility(8);
        } else {
            etVar.bcC.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            etVar.bcC.setUserId(zVar.getAuthor().getUserId());
            etVar.bcC.setImageDrawable(null);
            etVar.bcC.setOnClickListener(onClickListener);
            etVar.bcC.d(portrait, 28, false);
        }
        etVar.bjd.setOnClickListener(onClickListener);
    }

    private void f(com.baidu.tbadk.core.data.z zVar, et etVar) {
        if (zVar != null && !zVar.sJ() && !StringUtils.isNull(zVar.getAddress())) {
            etVar.biZ.setVisibility(0);
            etVar.biZ.setText(zVar.getAddress());
            etVar.bja.setVisibility(0);
            return;
        }
        etVar.biZ.setVisibility(8);
        etVar.bja.setVisibility(8);
    }

    private void a(View view, et etVar) {
        if (this.bbA != null && this.bbA.getLayoutMode() != null && etVar.ahf != this.mSkinType) {
            etVar.ahf = this.mSkinType;
            this.bbA.getLayoutMode().ac(this.mSkinType == 1);
            this.bbA.getLayoutMode().k(view);
        }
    }

    private void g(com.baidu.tbadk.core.data.z zVar, et etVar) {
        if (zVar == null || zVar.sQ() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            etVar.bcx.setLayoutParams(layoutParams);
            etVar.bhz.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.bhu, 0, 0);
        layoutParams2.gravity = 1;
        etVar.bcx.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.as.i(etVar.bhz, n.f.yangnian2);
        etVar.bhz.setVisibility(0);
    }
}
