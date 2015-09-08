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
public class dd extends bd<com.baidu.tbadk.core.data.x, dg> {
    private int aXI;

    /* JADX INFO: Access modifiers changed from: protected */
    public dd(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXI = 0;
        this.aXI = com.baidu.adp.lib.util.k.d(this.aSX.getPageContext().getPageActivity(), i.d.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public dg a(ViewGroup viewGroup) {
        return new dg(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tbadk.core.data.x) dgVar);
        return a(i, view, xVar, dgVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        b(xVar, dgVar);
        c(xVar, dgVar);
        i(xVar, dgVar);
        h(xVar, dgVar);
        g(xVar, dgVar);
        b(xVar, dgVar, i);
        a(xVar, dgVar, i);
        f(xVar, dgVar);
        e(xVar, dgVar);
        d(xVar, dgVar);
        a(xVar, dgVar);
        A(view);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar != null && dgVar != null) {
            if (xVar.getPraise() != null && xVar.getPraise().getNum() > 0) {
                dgVar.aUf.setVisibility(0);
                dgVar.aUf.setText(com.baidu.tbadk.core.util.aq.o(xVar.getPraise().getNum()));
            } else {
                dgVar.aUf.setVisibility(8);
            }
            int reply_num = xVar.getReply_num();
            if (reply_num > 0) {
                dgVar.aUh.setVisibility(0);
                dgVar.aUh.setText(com.baidu.tbadk.core.util.aq.o(reply_num));
                return;
            }
            dgVar.aUh.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar != null && dgVar != null) {
            dgVar.aTZ.setText(com.baidu.tbadk.core.util.aq.m(xVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar != null && xVar.getAuthor() != null && dgVar != null) {
            dgVar.aYR.setText(xVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        MediaData sy;
        if (xVar != null && dgVar != null && (sy = xVar.sy()) != null) {
            if (com.baidu.tbadk.core.m.rb().rf()) {
                dgVar.aYX.setVisibility(0);
                dgVar.aYV.d(sy.getPicUrl(), 13, false);
                dgVar.aYV.setOnClickListener(new de(this, sy));
                return;
            }
            dgVar.aYX.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        String videoUrl;
        if (xVar != null && dgVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!StringUtils.isNull(xVar.sr())) {
                stringBuffer.append(xVar.sr());
            }
            ArrayList<MediaData> medias = xVar.getMedias();
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
                        dgVar.aYS.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        dgVar.aYS.setText(stringBuffer.toString());
                    }
                    com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    dgVar.aYS.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lj(xVar.getId())) {
                        com.baidu.tbadk.core.util.al.b(dgVar.aYS, i.c.cp_cont_c, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.al.b(dgVar.aYS, i.c.cp_cont_b, 1);
                        return;
                    }
                }
                dgVar.aYS.setVisibility(8);
            }
        }
    }

    private void f(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar != null && dgVar != null) {
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (xVar.sw() == 1) {
                dgVar.aQj.setVisibility(8);
                return;
            }
            dgVar.aQj.setVisibility(0);
            xVar.parser_title();
            dgVar.aQj.setText(xVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lj(xVar.getId())) {
                com.baidu.tbadk.core.util.al.b(dgVar.aQj, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.al.b(dgVar.aQj, i.c.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.x xVar, dg dgVar, int i) {
        if (xVar != null && dgVar != null && i >= 0 && xVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfo = xVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                dgVar.aUb.setVisibility(0);
                com.baidu.tbadk.core.util.al.b(dgVar.aYR, i.c.cp_cont_h, 1);
                dgVar.aUb.setTag(Integer.valueOf(i));
                dgVar.aUb.setOnClickListener(null);
                dgVar.aUb.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                return;
            }
            dgVar.aUb.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(dgVar.aYR, i.c.cp_cont_c, 1);
        }
    }

    private void b(com.baidu.tbadk.core.data.x xVar, dg dgVar, int i) {
        if (xVar != null && xVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = xVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                dgVar.aXO.setVisibility(0);
                com.baidu.tbadk.core.util.al.b(dgVar.aYR, i.c.cp_cont_h, 1);
                dgVar.aXO.setTag(Integer.valueOf(i));
                dgVar.aXO.setOnClickListener(null);
                dgVar.aXO.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                dgVar.aXO.setOnClickListener(null);
                return;
            }
            dgVar.aXO.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(dgVar.aYR, i.c.cp_cont_c, 1);
        }
    }

    private void g(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar == null || xVar.getAuthor() == null || !com.baidu.tbadk.core.m.rb().rd()) {
            dgVar.aUc.setVisibility(8);
            return;
        }
        dgVar.aUc.setVisibility(0);
        String portrait = xVar.getAuthor().getPortrait();
        dgVar.aUc.setUserId(xVar.getAuthor().getUserId());
        dgVar.aUc.setImageDrawable(null);
        dgVar.aUc.d(portrait, 28, false);
        dgVar.aYW.setOnClickListener(new df(this, xVar));
    }

    private void h(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar != null && !xVar.sD() && !StringUtils.isNull(xVar.getAddress())) {
            dgVar.aYT.setVisibility(0);
            dgVar.aYT.setText(xVar.getAddress());
            dgVar.aYU.setVisibility(0);
            return;
        }
        dgVar.aYT.setVisibility(8);
        dgVar.aYU.setVisibility(8);
    }

    private void A(View view) {
        if (this.aSX != null && this.aSX.getLayoutMode() != null) {
            this.aSX.getLayoutMode().ad(this.mSkinType == 1);
            this.aSX.getLayoutMode().k(view);
        }
    }

    private void i(com.baidu.tbadk.core.data.x xVar, dg dgVar) {
        if (xVar == null || xVar.sI() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            dgVar.aTV.setLayoutParams(layoutParams);
            dgVar.aXN.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.aXI, 0, 0);
        layoutParams2.gravity = 1;
        dgVar.aTV.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.al.h(dgVar.aXN, i.e.yangnian2);
        dgVar.aXN.setVisibility(0);
    }
}
