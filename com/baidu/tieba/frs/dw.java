package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class dw extends bn<com.baidu.tbadk.core.data.w, dz> {
    private int aXn;

    /* JADX INFO: Access modifiers changed from: protected */
    public dw(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXn = 0;
        this.aXn = com.baidu.adp.lib.util.k.d(this.aSe.getPageContext().getPageActivity(), i.d.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public dz a(ViewGroup viewGroup) {
        return new dz(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dzVar);
        return a(i, view, wVar, dzVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        b(wVar, dzVar);
        c(wVar, dzVar);
        i(wVar, dzVar);
        h(wVar, dzVar);
        g(wVar, dzVar);
        b(wVar, dzVar, i);
        a(wVar, dzVar, i);
        f(wVar, dzVar);
        e(wVar, dzVar);
        d(wVar, dzVar);
        a(wVar, dzVar);
        A(view);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar != null && dzVar != null) {
            if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
                dzVar.aTm.setVisibility(0);
                dzVar.aTm.setText(com.baidu.tbadk.core.util.as.s(wVar.getPraise().getNum()));
            } else {
                dzVar.aTm.setVisibility(8);
            }
            int reply_num = wVar.getReply_num();
            if (reply_num > 0) {
                dzVar.aTo.setVisibility(0);
                dzVar.aTo.setText(com.baidu.tbadk.core.util.as.s(reply_num));
                return;
            }
            dzVar.aTo.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar != null && dzVar != null) {
            dzVar.aTg.setText(com.baidu.tbadk.core.util.as.o(wVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar != null && wVar.getAuthor() != null && dzVar != null) {
            dzVar.aYR.setText(wVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        MediaData st;
        if (wVar != null && dzVar != null && (st = wVar.st()) != null) {
            if (com.baidu.tbadk.core.m.qX().rb()) {
                dzVar.aYX.setVisibility(0);
                dzVar.aYV.d(st.getPicUrl(), 13, false);
                dzVar.aYV.setOnClickListener(new dx(this, st));
                return;
            }
            dzVar.aYX.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        String videoUrl;
        if (wVar != null && dzVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!StringUtils.isNull(wVar.sm())) {
                stringBuffer.append(wVar.sm());
            }
            ArrayList<MediaData> medias = wVar.getMedias();
            if (medias != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                Iterator<MediaData> it = medias.iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && (videoUrl = next.getVideoUrl()) != null && videoUrl.endsWith("swf")) {
                        stringBuffer2.append(videoUrl);
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (stringBuffer.length() > 0) {
                    if (stringBuffer.length() > 170) {
                        dzVar.aYS.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        dzVar.aYS.setText(stringBuffer.toString());
                    }
                    com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    dzVar.aYS.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                        com.baidu.tbadk.core.util.an.b(dzVar.aYS, i.c.cp_cont_c, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.an.b(dzVar.aYS, i.c.cp_cont_b, 1);
                        return;
                    }
                }
                dzVar.aYS.setVisibility(8);
            }
        }
    }

    private void f(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar != null && dzVar != null) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (wVar.sr() == 1) {
                dzVar.aPq.setVisibility(8);
                return;
            }
            dzVar.aPq.setVisibility(0);
            wVar.parser_title();
            dzVar.aPq.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(dzVar.aPq, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(dzVar.aPq, i.c.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.w wVar, dz dzVar, int i) {
        if (wVar != null && dzVar != null && i >= 0 && wVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                dzVar.aTi.setVisibility(0);
                com.baidu.tbadk.core.util.an.b(dzVar.aYR, i.c.cp_cont_h, 1);
                dzVar.aTi.setTag(Integer.valueOf(i));
                dzVar.aTi.setOnClickListener(null);
                dzVar.aTi.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                return;
            }
            dzVar.aTi.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(dzVar.aYR, i.c.cp_cont_c, 1);
        }
    }

    private void b(com.baidu.tbadk.core.data.w wVar, dz dzVar, int i) {
        if (wVar != null && wVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                dzVar.aXt.setVisibility(0);
                com.baidu.tbadk.core.util.an.b(dzVar.aYR, i.c.cp_cont_h, 1);
                dzVar.aXt.setTag(Integer.valueOf(i));
                dzVar.aXt.setOnClickListener(null);
                dzVar.aXt.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                dzVar.aXt.setOnClickListener(null);
                return;
            }
            dzVar.aXt.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(dzVar.aYR, i.c.cp_cont_c, 1);
        }
    }

    private void g(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar == null || wVar.getAuthor() == null || !com.baidu.tbadk.core.m.qX().qZ()) {
            dzVar.aTj.setVisibility(8);
            return;
        }
        dzVar.aTj.setVisibility(0);
        String portrait = wVar.getAuthor().getPortrait();
        dzVar.aTj.setUserId(wVar.getAuthor().getUserId());
        dzVar.aTj.setImageDrawable(null);
        dzVar.aTj.d(portrait, 28, false);
        dzVar.aYW.setOnClickListener(new dy(this, wVar));
    }

    private void h(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar != null && !wVar.sy() && !StringUtils.isNull(wVar.getAddress())) {
            dzVar.aYT.setVisibility(0);
            dzVar.aYT.setText(wVar.getAddress());
            dzVar.aYU.setVisibility(0);
            return;
        }
        dzVar.aYT.setVisibility(8);
        dzVar.aYU.setVisibility(8);
    }

    private void A(View view) {
        if (this.aSe != null && this.aSe.getLayoutMode() != null) {
            this.aSe.getLayoutMode().ad(this.mSkinType == 1);
            this.aSe.getLayoutMode().k(view);
        }
    }

    private void i(com.baidu.tbadk.core.data.w wVar, dz dzVar) {
        if (wVar == null || wVar.sF() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            dzVar.aTc.setLayoutParams(layoutParams);
            dzVar.aXs.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.aXn, 0, 0);
        layoutParams2.gravity = 1;
        dzVar.aTc.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.an.i(dzVar.aXs, i.e.yangnian2);
        dzVar.aXs.setVisibility(0);
    }
}
