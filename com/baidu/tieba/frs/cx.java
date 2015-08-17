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
public class cx extends bc<com.baidu.tbadk.core.data.v, da> {
    private int aXN;

    /* JADX INFO: Access modifiers changed from: protected */
    public cx(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXN = 0;
        this.aXN = com.baidu.adp.lib.util.k.d(this.aSJ.getPageContext().getPageActivity(), i.d.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public da a(ViewGroup viewGroup) {
        return new da(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, da daVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) daVar);
        return a(i, view, vVar, daVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.v vVar, da daVar) {
        b(vVar, daVar);
        c(vVar, daVar);
        i(vVar, daVar);
        h(vVar, daVar);
        g(vVar, daVar);
        b(vVar, daVar, i);
        a(vVar, daVar, i);
        f(vVar, daVar);
        e(vVar, daVar);
        d(vVar, daVar);
        a(vVar, daVar);
        A(view);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar != null && daVar != null) {
            if (vVar.getPraise() != null && vVar.getPraise().getNum() > 0) {
                daVar.aTR.setVisibility(0);
                daVar.aTR.setText(com.baidu.tbadk.core.util.aq.o(vVar.getPraise().getNum()));
            } else {
                daVar.aTR.setVisibility(8);
            }
            int reply_num = vVar.getReply_num();
            if (reply_num > 0) {
                daVar.aTT.setVisibility(0);
                daVar.aTT.setText(com.baidu.tbadk.core.util.aq.o(reply_num));
                return;
            }
            daVar.aTT.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar != null && daVar != null) {
            daVar.aTL.setText(com.baidu.tbadk.core.util.aq.m(vVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar != null && vVar.getAuthor() != null && daVar != null) {
            daVar.aYA.setText(vVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.v vVar, da daVar) {
        MediaData sw;
        if (vVar != null && daVar != null && (sw = vVar.sw()) != null) {
            if (com.baidu.tbadk.core.m.rd().rh()) {
                daVar.aYG.setVisibility(0);
                daVar.aYE.d(sw.getPicUrl(), 13, false);
                daVar.aYE.setOnClickListener(new cy(this, sw));
                return;
            }
            daVar.aYG.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.v vVar, da daVar) {
        String videoUrl;
        if (vVar != null && daVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!StringUtils.isNull(vVar.sq())) {
                stringBuffer.append(vVar.sq());
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
                        daVar.aYB.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        daVar.aYB.setText(stringBuffer.toString());
                    }
                    com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    daVar.aYB.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.kE(vVar.getId())) {
                        com.baidu.tbadk.core.util.al.b(daVar.aYB, i.c.cp_cont_c, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.al.b(daVar.aYB, i.c.cp_cont_b, 1);
                        return;
                    }
                }
                daVar.aYB.setVisibility(8);
            }
        }
    }

    private void f(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar != null && daVar != null) {
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (vVar.su() == 1) {
                daVar.aPV.setVisibility(8);
                return;
            }
            daVar.aPV.setVisibility(0);
            vVar.parser_title();
            daVar.aPV.setText(vVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.kE(vVar.getId())) {
                com.baidu.tbadk.core.util.al.b(daVar.aPV, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.al.b(daVar.aPV, i.c.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.v vVar, da daVar, int i) {
        if (vVar != null && daVar != null && i >= 0 && vVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                daVar.aTN.setVisibility(0);
                com.baidu.tbadk.core.util.al.b(daVar.aYA, i.c.cp_cont_h, 1);
                daVar.aTN.setTag(Integer.valueOf(i));
                daVar.aTN.setOnClickListener(null);
                daVar.aTN.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                return;
            }
            daVar.aTN.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(daVar.aYA, i.c.cp_cont_c, 1);
        }
    }

    private void b(com.baidu.tbadk.core.data.v vVar, da daVar, int i) {
        if (vVar != null && vVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                daVar.aXT.setVisibility(0);
                com.baidu.tbadk.core.util.al.b(daVar.aYA, i.c.cp_cont_h, 1);
                daVar.aXT.setTag(Integer.valueOf(i));
                daVar.aXT.setOnClickListener(null);
                daVar.aXT.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                daVar.aXT.setOnClickListener(null);
                return;
            }
            daVar.aXT.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(daVar.aYA, i.c.cp_cont_c, 1);
        }
    }

    private void g(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar == null || vVar.getAuthor() == null || !com.baidu.tbadk.core.m.rd().rf()) {
            daVar.aTO.setVisibility(8);
            return;
        }
        daVar.aTO.setVisibility(0);
        String portrait = vVar.getAuthor().getPortrait();
        daVar.aTO.setUserId(vVar.getAuthor().getUserId());
        daVar.aTO.setImageDrawable(null);
        daVar.aTO.d(portrait, 28, false);
        daVar.aYF.setOnClickListener(new cz(this, vVar));
    }

    private void h(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar != null && !vVar.sA() && !StringUtils.isNull(vVar.getAddress())) {
            daVar.aYC.setVisibility(0);
            daVar.aYC.setText(vVar.getAddress());
            daVar.aYD.setVisibility(0);
            return;
        }
        daVar.aYC.setVisibility(8);
        daVar.aYD.setVisibility(8);
    }

    private void A(View view) {
        if (this.aSJ != null && this.aSJ.getLayoutMode() != null) {
            this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
            this.aSJ.getLayoutMode().k(view);
        }
    }

    private void i(com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar == null || vVar.sE() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            daVar.aTH.setLayoutParams(layoutParams);
            daVar.aXS.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.aXN, 0, 0);
        layoutParams2.gravity = 1;
        daVar.aTH.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.al.i(daVar.aXS, i.e.yangnian2);
        daVar.aXS.setVisibility(0);
    }
}
