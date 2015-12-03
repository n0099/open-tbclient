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
public class ep extends bm<com.baidu.tbadk.core.data.z, es> {
    private int bdu;

    /* JADX INFO: Access modifiers changed from: protected */
    public ep(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bdu = 0;
        this.bdu = com.baidu.adp.lib.util.k.d(this.aXA.getPageContext().getPageActivity(), n.d.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public es a(ViewGroup viewGroup) {
        return new es(LayoutInflater.from(this.mContext).inflate(n.g.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, es esVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) esVar);
        return a(i, view, zVar, esVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.z zVar, es esVar) {
        eq eqVar = new eq(this, zVar);
        b(zVar, esVar);
        c(zVar, esVar);
        g(zVar, esVar);
        f(zVar, esVar);
        a(zVar, esVar, eqVar);
        b(zVar, esVar, i);
        a(zVar, esVar, i);
        e(zVar, esVar);
        d(zVar, esVar);
        a(zVar, esVar);
        bx.a(this.aXA, esVar.bfe, esVar.aYF, esVar.bff, esVar.bdD, esVar.bdE, esVar.bfk, view, zVar, this.mSkinType, eqVar);
        a(view, esVar);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.z zVar, es esVar) {
        if (zVar != null && esVar != null) {
            if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
                esVar.aYI.setVisibility(0);
                esVar.aYI.setText(com.baidu.tbadk.core.util.ax.w(zVar.getPraise().getNum()));
            } else {
                esVar.aYI.setVisibility(8);
            }
            int reply_num = zVar.getReply_num();
            if (reply_num > 0) {
                esVar.aYK.setVisibility(0);
                esVar.aYK.setText(com.baidu.tbadk.core.util.ax.w(reply_num));
                return;
            }
            esVar.aYK.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.z zVar, es esVar) {
        if (zVar != null && esVar != null) {
            esVar.aYC.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.z zVar, es esVar) {
        if (zVar != null && zVar.getAuthor() != null && esVar != null) {
            esVar.bff.setText(zVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.z zVar, es esVar) {
        VideoInfo sU;
        if (zVar != null && esVar != null && (sU = zVar.sU()) != null) {
            if (com.baidu.tbadk.core.m.rh().rn() && !StringUtils.isNull(sU.video_url)) {
                esVar.bfl.setVisibility(0);
                esVar.bfi.d(sU.thumbnail_url, 13, false);
                esVar.bfl.setOnClickListener(new er(this, zVar, sU));
                com.baidu.tbadk.core.util.as.i(esVar.bfi, n.e.icon_play_video);
                return;
            }
            esVar.bfl.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.z zVar, es esVar) {
        if (zVar != null && esVar != null) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (zVar.sS() == 1) {
                esVar.aUB.setVisibility(8);
                return;
            }
            esVar.aUB.setVisibility(0);
            zVar.parser_title();
            esVar.aUB.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(esVar.aUB, n.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(esVar.aUB, n.c.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.z zVar, es esVar, int i) {
        if (zVar != null && esVar != null && i >= 0 && zVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                esVar.aYE.setVisibility(0);
                com.baidu.tbadk.core.util.as.b(esVar.bff, n.c.cp_cont_h, 1);
                esVar.aYE.setTag(Integer.valueOf(i));
                esVar.aYE.setOnClickListener(null);
                esVar.aYE.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
                return;
            }
            esVar.aYE.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(esVar.bff, n.c.cp_cont_c, 1);
        }
    }

    private void b(com.baidu.tbadk.core.data.z zVar, es esVar, int i) {
        if (zVar != null && zVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                esVar.bdA.setVisibility(0);
                com.baidu.tbadk.core.util.as.b(esVar.bff, n.c.cp_cont_h, 1);
                esVar.bdA.setTag(Integer.valueOf(i));
                esVar.bdA.setOnClickListener(null);
                esVar.bdA.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds10), true);
                esVar.bdA.setOnClickListener(null);
                return;
            }
            esVar.bdA.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(esVar.bff, n.c.cp_cont_c, 1);
        }
    }

    private void a(com.baidu.tbadk.core.data.z zVar, es esVar, View.OnClickListener onClickListener) {
        if (zVar == null || zVar.getAuthor() == null || !com.baidu.tbadk.core.m.rh().rj()) {
            esVar.aYF.setVisibility(8);
        } else {
            esVar.aYF.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            esVar.aYF.setUserId(zVar.getAuthor().getUserId());
            esVar.aYF.setImageDrawable(null);
            esVar.aYF.setOnClickListener(onClickListener);
            esVar.aYF.d(portrait, 28, false);
        }
        esVar.bfk.setOnClickListener(onClickListener);
    }

    private void f(com.baidu.tbadk.core.data.z zVar, es esVar) {
        if (zVar != null && !zVar.sZ() && !StringUtils.isNull(zVar.getAddress())) {
            esVar.bfg.setVisibility(0);
            esVar.bfg.setText(zVar.getAddress());
            esVar.bfh.setVisibility(0);
            return;
        }
        esVar.bfg.setVisibility(8);
        esVar.bfh.setVisibility(8);
    }

    private void a(View view, es esVar) {
        if (this.aXA != null && this.aXA.getLayoutMode() != null && esVar.afY != this.mSkinType) {
            esVar.afY = this.mSkinType;
            this.aXA.getLayoutMode().af(this.mSkinType == 1);
            this.aXA.getLayoutMode().k(view);
        }
    }

    private void g(com.baidu.tbadk.core.data.z zVar, es esVar) {
        if (zVar == null || zVar.tg() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            esVar.aYy.setLayoutParams(layoutParams);
            esVar.bdz.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.bdu, 0, 0);
        layoutParams2.gravity = 1;
        esVar.aYy.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.as.i(esVar.bdz, n.e.yangnian2);
        esVar.bdz.setVisibility(0);
    }
}
