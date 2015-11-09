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
public class dy extends bn<com.baidu.tbadk.core.data.w, eb> {
    private int aXw;

    /* JADX INFO: Access modifiers changed from: protected */
    public dy(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXw = 0;
        this.aXw = com.baidu.adp.lib.util.k.d(this.aSm.getPageContext().getPageActivity(), i.d.ds70);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public eb a(ViewGroup viewGroup) {
        return new eb(LayoutInflater.from(this.mContext).inflate(i.g.frs_item_xiaoying, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) ebVar);
        return a(i, view, wVar, ebVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        b(wVar, ebVar);
        c(wVar, ebVar);
        i(wVar, ebVar);
        h(wVar, ebVar);
        g(wVar, ebVar);
        b(wVar, ebVar, i);
        a(wVar, ebVar, i);
        f(wVar, ebVar);
        e(wVar, ebVar);
        d(wVar, ebVar);
        a(wVar, ebVar);
        B(view);
        return view;
    }

    private void a(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar != null && ebVar != null) {
            if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
                ebVar.aTu.setVisibility(0);
                ebVar.aTu.setText(com.baidu.tbadk.core.util.as.q(wVar.getPraise().getNum()));
            } else {
                ebVar.aTu.setVisibility(8);
            }
            int reply_num = wVar.getReply_num();
            if (reply_num > 0) {
                ebVar.aTw.setVisibility(0);
                ebVar.aTw.setText(com.baidu.tbadk.core.util.as.q(reply_num));
                return;
            }
            ebVar.aTw.setVisibility(8);
        }
    }

    private void b(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar != null && ebVar != null) {
            ebVar.aTo.setText(com.baidu.tbadk.core.util.as.m(wVar.getLast_time_int() * 1000));
        }
    }

    private void c(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar != null && wVar.getAuthor() != null && ebVar != null) {
            ebVar.aZd.setText(wVar.getAuthor().getUserName());
        }
    }

    private void d(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        MediaData st;
        if (wVar != null && ebVar != null && (st = wVar.st()) != null) {
            if (com.baidu.tbadk.core.m.qV().qZ()) {
                ebVar.aZj.setVisibility(0);
                ebVar.aZh.d(st.getPicUrl(), 13, false);
                ebVar.aZh.setOnClickListener(new dz(this, st));
                return;
            }
            ebVar.aZj.setVisibility(8);
        }
    }

    private void e(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        String videoUrl;
        if (wVar != null && ebVar != null) {
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
                        ebVar.aZe.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        ebVar.aZe.setText(stringBuffer.toString());
                    }
                    com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    ebVar.aZe.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                        com.baidu.tbadk.core.util.an.b(ebVar.aZe, i.c.cp_cont_c, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.an.b(ebVar.aZe, i.c.cp_cont_b, 1);
                        return;
                    }
                }
                ebVar.aZe.setVisibility(8);
            }
        }
    }

    private void f(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar != null && ebVar != null) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (wVar.sr() == 1) {
                ebVar.aPy.setVisibility(8);
                return;
            }
            ebVar.aPy.setVisibility(0);
            wVar.parser_title();
            ebVar.aPy.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(ebVar.aPy, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(ebVar.aPy, i.c.cp_cont_b, 1);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.w wVar, eb ebVar, int i) {
        if (wVar != null && ebVar != null && i >= 0 && wVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                ebVar.aTq.setVisibility(0);
                com.baidu.tbadk.core.util.an.b(ebVar.aZd, i.c.cp_cont_h, 1);
                ebVar.aTq.setTag(Integer.valueOf(i));
                ebVar.aTq.setOnClickListener(null);
                ebVar.aTq.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                return;
            }
            ebVar.aTq.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(ebVar.aZd, i.c.cp_cont_c, 1);
        }
    }

    private void b(com.baidu.tbadk.core.data.w wVar, eb ebVar, int i) {
        if (wVar != null && wVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                ebVar.aXC.setVisibility(0);
                com.baidu.tbadk.core.util.an.b(ebVar.aZd, i.c.cp_cont_h, 1);
                ebVar.aXC.setTag(Integer.valueOf(i));
                ebVar.aXC.setOnClickListener(null);
                ebVar.aXC.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                ebVar.aXC.setOnClickListener(null);
                return;
            }
            ebVar.aXC.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(ebVar.aZd, i.c.cp_cont_c, 1);
        }
    }

    private void g(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar == null || wVar.getAuthor() == null || !com.baidu.tbadk.core.m.qV().qX()) {
            ebVar.aTr.setVisibility(8);
            return;
        }
        ebVar.aTr.setVisibility(0);
        String portrait = wVar.getAuthor().getPortrait();
        ebVar.aTr.setUserId(wVar.getAuthor().getUserId());
        ebVar.aTr.setImageDrawable(null);
        ebVar.aTr.d(portrait, 28, false);
        ebVar.aZi.setOnClickListener(new ea(this, wVar));
    }

    private void h(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar != null && !wVar.sy() && !StringUtils.isNull(wVar.getAddress())) {
            ebVar.aZf.setVisibility(0);
            ebVar.aZf.setText(wVar.getAddress());
            ebVar.aZg.setVisibility(0);
            return;
        }
        ebVar.aZf.setVisibility(8);
        ebVar.aZg.setVisibility(8);
    }

    private void B(View view) {
        if (this.aSm != null && this.aSm.getLayoutMode() != null) {
            this.aSm.getLayoutMode().ad(this.mSkinType == 1);
            this.aSm.getLayoutMode().k(view);
        }
    }

    private void i(com.baidu.tbadk.core.data.w wVar, eb ebVar) {
        if (wVar == null || wVar.sF() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 1;
            ebVar.aTk.setLayoutParams(layoutParams);
            ebVar.aXB.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, this.aXw, 0, 0);
        layoutParams2.gravity = 1;
        ebVar.aTk.setLayoutParams(layoutParams2);
        com.baidu.tbadk.core.util.an.i(ebVar.aXB, i.e.yangnian2);
        ebVar.aXB.setVisibility(0);
    }
}
