package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<v, com.baidu.tieba.hottopic.b.a> implements View.OnClickListener {
    private BdTypeListView aUV;
    private View.OnClickListener aXd;
    private HotTopicActivity bnS;
    private View.OnClickListener bnT;
    private com.baidu.adp.widget.ListView.v bnU;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aXd = new b(this);
        this.bnT = new c(this);
        this.bnU = new d(this);
        this.bnS = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public com.baidu.tieba.hottopic.b.a a(ViewGroup viewGroup) {
        if (viewGroup instanceof BdTypeListView) {
            this.aUV = (BdTypeListView) viewGroup;
        }
        return new com.baidu.tieba.hottopic.b.a(LayoutInflater.from(this.mContext).inflate(i.g.hot_topic_hotthread_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, v vVar, com.baidu.tieba.hottopic.b.a aVar) {
        a(aVar, view);
        a(i, aVar, vVar);
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.a aVar, View view) {
        am.i(aVar.getView(), i.e.list_item_selector);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bnS != null && aVar.apR != this.mSkinType) {
            am.i(aVar.bpo, i.e.frs_item_control_btn_bg);
            am.i((View) aVar.aTf, i.e.frs_item_abstract_more_text_bg);
            this.bnS.getLayoutMode().ad(this.mSkinType == 1);
            this.bnS.getLayoutMode().k(view);
        }
    }

    private void a(int i, com.baidu.tieba.hottopic.b.a aVar, v vVar) {
        if (vVar != null) {
            if (vVar instanceof com.baidu.tieba.hottopic.data.a) {
                aVar.bpj.setVisibility(0);
                aVar.bpj.setEnabled(false);
                aVar.bpi.setEnabled(false);
                aVar.bpn.setVisibility(8);
                aVar.bpr.setVisibility(8);
                am.j(aVar.bpk, i.c.cp_bg_line_c);
                am.b(aVar.bpl, i.c.cp_cont_c, 1);
                am.j(aVar.bpm, i.c.cp_bg_line_b);
                aVar.bpl.setText(ar.d(((com.baidu.tieba.hottopic.data.a) vVar).boF, 14, "..."));
                return;
            }
            aVar.bpj.setVisibility(8);
            aVar.bpn.setVisibility(0);
            aVar.bpr.setVisibility(0);
            if (this.aUV != null && this.aUV.getData() != null && i == this.aUV.getData().size() - 1) {
                aVar.bpr.setVisibility(8);
            }
            aVar.aXj.setOnClickListener(this);
            aVar.aTf.setOnClickListener(this);
            aVar.aXj.setTag(Integer.valueOf(i));
            aVar.aTf.setTag(Integer.valueOf(i));
            if (vVar != null && !vVar.sy() && !TextUtils.isEmpty(vVar.getAddress()) && !TextUtils.isEmpty(vVar.getAddress().trim())) {
                aVar.aXl.setVisibility(0);
                aVar.aXm.setVisibility(0);
                aVar.aXl.setText(vVar.getAddress());
            } else {
                aVar.aXl.setVisibility(8);
                aVar.aXm.setVisibility(8);
            }
            aVar.aSV.setText(ar.o(vVar.getLast_time_int() * 1000));
            aVar.aSY.setVisibility(0);
            String portrait = vVar.getAuthor().getPortrait();
            aVar.aSY.setUserId(vVar.getAuthor().getUserId());
            aVar.aSY.setImageDrawable(null);
            aVar.aSY.d(portrait, 12, false);
            aVar.aSY.setOnClickListener(new e(this, vVar));
            aVar.bpp.setOnClickListener(new f(this, vVar));
            ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                aVar.aXi.setVisibility(0);
                am.b(aVar.aSW, i.c.cp_cont_h, 1);
                aVar.aXi.setTag(Integer.valueOf(i));
                aVar.aXi.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                aVar.aXi.setOnClickListener(this.aXd);
            } else {
                aVar.aXi.setVisibility(8);
                am.b(aVar.aSW, i.c.cp_cont_c, 1);
            }
            ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                aVar.aSX.setVisibility(0);
                am.b(aVar.aSW, i.c.cp_cont_h, 1);
                aVar.aSX.setTag(Integer.valueOf(i));
                aVar.aSX.setOnClickListener(this.bnT);
                aVar.aSX.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
            } else {
                aVar.aSX.setVisibility(8);
                am.b(aVar.aSW, i.c.cp_cont_c, 1);
            }
            aVar.aSW.setText(vVar.getAuthor().getUserName());
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            aVar.aPf.setMaxLines(2);
            aVar.aPf.setEllipsize(TextUtils.TruncateAt.END);
            if (vVar.sr() == 1) {
                aVar.aPf.setVisibility(8);
            } else {
                aVar.aPf.setVisibility(0);
                vVar.parser_title();
                aVar.aPf.setText(vVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                    am.b(aVar.aPf, i.c.cp_cont_c, 1);
                } else {
                    am.b(aVar.aPf, i.c.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (vVar.sm() != null && vVar.sm().trim().length() > 0) {
                stringBuffer.append(vVar.sm());
            }
            ArrayList<MediaData> medias = vVar.getMedias();
            if (medias != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= medias.size()) {
                        break;
                    }
                    if (medias.get(i3).getVideoUrl() != null && medias.get(i3).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(medias.get(i3).getVideoUrl());
                    }
                    i2 = i3 + 1;
                }
                stringBuffer.append(stringBuffer2.toString());
                if (stringBuffer.length() > 0) {
                    if (stringBuffer.length() > 170) {
                        aVar.aTf.setVisibility(0);
                        aVar.aSS.setText(ar.d(stringBuffer.toString(), 170, "..."));
                    } else {
                        aVar.aTf.setVisibility(8);
                        aVar.aSS.setText(stringBuffer.toString());
                    }
                    aVar.aSS.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                        am.b(aVar.aSS, i.c.cp_cont_c, 1);
                    } else {
                        am.b(aVar.aSS, i.c.cp_cont_b, 1);
                    }
                } else {
                    aVar.aTf.setVisibility(8);
                    aVar.aSS.setVisibility(8);
                }
            }
            if (com.baidu.tbadk.core.m.qX().rb() && medias != null && medias.size() > 0) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int i6 = i4;
                    if (i6 >= medias.size()) {
                        break;
                    }
                    if (medias.get(i6) != null && medias.get(i6).getType() == 3) {
                        i5++;
                    }
                    i4 = i6 + 1;
                }
                if (i5 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i5];
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i7;
                        int i10 = i8;
                        if (i9 >= medias.size() || i10 >= i5) {
                            break;
                        }
                        if (medias.get(i9).getType() != 3) {
                            i8 = i10;
                        } else {
                            mediaDataArr[i10] = medias.get(i9);
                            i8 = i10 + 1;
                        }
                        i7 = i9 + 1;
                    }
                    aVar.bpq.setVisibility(0);
                    aVar.bpq.a(vVar, vVar.sj(), vVar.getId(), vVar.getTid());
                    aVar.bpq.setShowBig(com.baidu.adp.lib.util.i.iN());
                    aVar.bpq.setDrawNum(true);
                    aVar.bpq.setFromCDN(true);
                    aVar.bpq.a(this.bnS.getPageContext(), mediaDataArr, i5);
                    aVar.bpq.setImageFrom("other");
                } else {
                    aVar.bpq.setVisibility(8);
                }
            } else {
                aVar.bpq.setVisibility(8);
            }
            if (vVar.getPraise() != null && vVar.getPraise().getNum() > 0) {
                aVar.aTb.setVisibility(0);
                aVar.aTb.setText(ar.s(vVar.getPraise().getNum()));
            } else {
                aVar.aTb.setVisibility(8);
            }
            int reply_num = vVar.getReply_num();
            if (reply_num > 0) {
                aVar.aTd.setVisibility(0);
                aVar.aTd.setText(ar.s(reply_num));
            } else {
                aVar.aTd.setVisibility(8);
            }
            am.j(aVar.bpr, i.c.cp_bg_line_c);
            a(this.bnU);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                u aA = aA(intValue);
                if (aA instanceof v) {
                    v vVar = (v) aA;
                    this.bnU.a(view, vVar, vVar.getType(), this.aUV, intValue, id);
                }
            }
        }
    }
}
