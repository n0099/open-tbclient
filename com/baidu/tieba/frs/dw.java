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
public class dw extends bn<com.baidu.tbadk.core.data.v, dz> {
    private int aXc;

    /* JADX INFO: Access modifiers changed from: protected */
    public dw(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXc = 0;
        this.aXc = com.baidu.adp.lib.util.k.d(this.aRT.getPageContext().getPageActivity(), i.d.ds70);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) dzVar);
        return a(i, view, vVar, dzVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        b(vVar, dzVar);
        c(vVar, dzVar);
        i(vVar, dzVar);
        h(vVar, dzVar);
        g(vVar, dzVar);
        b(vVar, dzVar, i);
        a(vVar, dzVar, i);
        f(vVar, dzVar);
        e(vVar, dzVar);
        d(vVar, dzVar);
        a(vVar, dzVar);
        A(view);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar != null && dzVar != null) {
            if (vVar.getPraise() != null && vVar.getPraise().getNum() > 0) {
                dzVar.aTb.setVisibility(0);
                dzVar.aTb.setText(com.baidu.tbadk.core.util.ar.s(vVar.getPraise().getNum()));
            } else {
                dzVar.aTb.setVisibility(8);
            }
            int reply_num = vVar.getReply_num();
            if (reply_num > 0) {
                dzVar.aTd.setVisibility(0);
                dzVar.aTd.setText(com.baidu.tbadk.core.util.ar.s(reply_num));
                return;
            }
            dzVar.aTd.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar != null && dzVar != null) {
            dzVar.aSV.setText(com.baidu.tbadk.core.util.ar.o(vVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar != null && vVar.getAuthor() != null && dzVar != null) {
            dzVar.aYG.setText(vVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        MediaData st;
        if (vVar != null && dzVar != null && (st = vVar.st()) != null) {
            if (com.baidu.tbadk.core.m.qX().rb()) {
                dzVar.aYM.setVisibility(0);
                dzVar.aYK.d(st.getPicUrl(), 13, false);
                dzVar.aYK.setOnClickListener(new dx(this, st));
                return;
            }
            dzVar.aYM.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        String videoUrl;
        if (vVar != null && dzVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!StringUtils.isNull(vVar.sm())) {
                stringBuffer.append(vVar.sm());
            }
            ArrayList<MediaData> medias = vVar.getMedias();
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
                        dzVar.aYH.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        dzVar.aYH.setText(stringBuffer.toString());
                    }
                    com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    dzVar.aYH.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                        com.baidu.tbadk.core.util.am.b(dzVar.aYH, i.c.cp_cont_c, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.am.b(dzVar.aYH, i.c.cp_cont_b, 1);
                        return;
                    }
                }
                dzVar.aYH.setVisibility(8);
            }
        }
    }

    private void f(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar != null && dzVar != null) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (vVar.sr() == 1) {
                dzVar.aPf.setVisibility(8);
                return;
            }
            dzVar.aPf.setVisibility(0);
            vVar.parser_title();
            dzVar.aPf.setText(vVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                com.baidu.tbadk.core.util.am.b(dzVar.aPf, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.am.b(dzVar.aPf, i.c.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.v vVar, dz dzVar, int i) {
        if (vVar != null && dzVar != null && i >= 0 && vVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                dzVar.aSX.setVisibility(0);
                com.baidu.tbadk.core.util.am.b(dzVar.aYG, i.c.cp_cont_h, 1);
                dzVar.aSX.setTag(Integer.valueOf(i));
                dzVar.aSX.setOnClickListener(null);
                dzVar.aSX.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                return;
            }
            dzVar.aSX.setVisibility(8);
            com.baidu.tbadk.core.util.am.b(dzVar.aYG, i.c.cp_cont_c, 1);
        }
    }

    private void b(com.baidu.tbadk.core.data.v vVar, dz dzVar, int i) {
        if (vVar != null && vVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                dzVar.aXi.setVisibility(0);
                com.baidu.tbadk.core.util.am.b(dzVar.aYG, i.c.cp_cont_h, 1);
                dzVar.aXi.setTag(Integer.valueOf(i));
                dzVar.aXi.setOnClickListener(null);
                dzVar.aXi.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                dzVar.aXi.setOnClickListener(null);
                return;
            }
            dzVar.aXi.setVisibility(8);
            com.baidu.tbadk.core.util.am.b(dzVar.aYG, i.c.cp_cont_c, 1);
        }
    }

    private void g(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar == null || vVar.getAuthor() == null || !com.baidu.tbadk.core.m.qX().qZ()) {
            dzVar.aSY.setVisibility(8);
            return;
        }
        dzVar.aSY.setVisibility(0);
        String portrait = vVar.getAuthor().getPortrait();
        dzVar.aSY.setUserId(vVar.getAuthor().getUserId());
        dzVar.aSY.setImageDrawable(null);
        dzVar.aSY.d(portrait, 28, false);
        dzVar.aYL.setOnClickListener(new dy(this, vVar));
    }

    private void h(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar != null && !vVar.sy() && !StringUtils.isNull(vVar.getAddress())) {
            dzVar.aYI.setVisibility(0);
            dzVar.aYI.setText(vVar.getAddress());
            dzVar.aYJ.setVisibility(0);
            return;
        }
        dzVar.aYI.setVisibility(8);
        dzVar.aYJ.setVisibility(8);
    }

    private void A(View view) {
        if (this.aRT != null && this.aRT.getLayoutMode() != null) {
            this.aRT.getLayoutMode().ad(this.mSkinType == 1);
            this.aRT.getLayoutMode().k(view);
        }
    }

    private void i(com.baidu.tbadk.core.data.v vVar, dz dzVar) {
        if (vVar == null || vVar.sF() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            dzVar.aSR.setLayoutParams(layoutParams);
            dzVar.aXh.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.aXc, 0, 0);
        layoutParams2.gravity = 1;
        dzVar.aSR.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.am.i(dzVar.aXh, i.e.yangnian2);
        dzVar.aXh.setVisibility(0);
    }
}
