package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<w, com.baidu.tieba.hottopic.b.a> implements View.OnClickListener {
    private BdTypeListView aVo;
    private View.OnClickListener aXx;
    private HotTopicActivity boH;
    private View.OnClickListener boI;
    private v boJ;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aXx = new b(this);
        this.boI = new c(this);
        this.boJ = new d(this);
        this.boH = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public com.baidu.tieba.hottopic.b.a a(ViewGroup viewGroup) {
        if (viewGroup instanceof BdTypeListView) {
            this.aVo = (BdTypeListView) viewGroup;
        }
        return new com.baidu.tieba.hottopic.b.a(LayoutInflater.from(this.mContext).inflate(i.g.hot_topic_hotthread_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, w wVar, com.baidu.tieba.hottopic.b.a aVar) {
        a(aVar, view);
        a(i, aVar, wVar);
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.a aVar, View view) {
        an.i(aVar.getView(), i.e.list_item_selector);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.boH != null && aVar.arf != this.mSkinType) {
            an.i(aVar.bqd, i.e.frs_item_control_btn_bg);
            an.i((View) aVar.aTy, i.e.frs_item_abstract_more_text_bg);
            this.boH.getLayoutMode().ad(this.mSkinType == 1);
            this.boH.getLayoutMode().k(view);
        }
    }

    private void a(int i, com.baidu.tieba.hottopic.b.a aVar, w wVar) {
        if (wVar != null) {
            if (wVar instanceof com.baidu.tieba.hottopic.data.a) {
                aVar.bpY.setVisibility(0);
                aVar.bpY.setEnabled(false);
                aVar.bpX.setEnabled(false);
                aVar.bqc.setVisibility(8);
                aVar.bqg.setVisibility(8);
                an.j(aVar.bpZ, i.c.cp_bg_line_c);
                an.b(aVar.bqa, i.c.cp_cont_c, 1);
                an.j(aVar.bqb, i.c.cp_bg_line_b);
                aVar.bqa.setText(as.d(((com.baidu.tieba.hottopic.data.a) wVar).bpu, 14, "..."));
                return;
            }
            aVar.bpY.setVisibility(8);
            aVar.bqc.setVisibility(0);
            aVar.bqg.setVisibility(0);
            if (this.aVo != null && this.aVo.getData() != null && i == this.aVo.getData().size() - 1) {
                aVar.bqg.setVisibility(8);
            }
            aVar.aXD.setOnClickListener(this);
            aVar.aTy.setOnClickListener(this);
            aVar.aXD.setTag(Integer.valueOf(i));
            aVar.aTy.setTag(Integer.valueOf(i));
            if (wVar != null && !wVar.sy() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
                aVar.aXF.setVisibility(0);
                aVar.aXG.setVisibility(0);
                aVar.aXF.setText(wVar.getAddress());
            } else {
                aVar.aXF.setVisibility(8);
                aVar.aXG.setVisibility(8);
            }
            aVar.aTo.setText(as.m(wVar.getLast_time_int() * 1000));
            aVar.aTr.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            aVar.aTr.setUserId(wVar.getAuthor().getUserId());
            aVar.aTr.setImageDrawable(null);
            aVar.aTr.d(portrait, 12, false);
            aVar.aTr.setOnClickListener(new e(this, wVar));
            aVar.bqe.setOnClickListener(new f(this, wVar));
            ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                aVar.aXC.setVisibility(0);
                an.b(aVar.aTp, i.c.cp_cont_h, 1);
                aVar.aXC.setTag(Integer.valueOf(i));
                aVar.aXC.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                aVar.aXC.setOnClickListener(this.aXx);
            } else {
                aVar.aXC.setVisibility(8);
                an.b(aVar.aTp, i.c.cp_cont_c, 1);
            }
            ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                aVar.aTq.setVisibility(0);
                an.b(aVar.aTp, i.c.cp_cont_h, 1);
                aVar.aTq.setTag(Integer.valueOf(i));
                aVar.aTq.setOnClickListener(this.boI);
                aVar.aTq.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
            } else {
                aVar.aTq.setVisibility(8);
                an.b(aVar.aTp, i.c.cp_cont_c, 1);
            }
            aVar.aTp.setText(wVar.getAuthor().getUserName());
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            aVar.aPy.setMaxLines(2);
            aVar.aPy.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.sr() == 1) {
                aVar.aPy.setVisibility(8);
            } else {
                aVar.aPy.setVisibility(0);
                wVar.parser_title();
                aVar.aPy.setText(wVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                    an.b(aVar.aPy, i.c.cp_cont_c, 1);
                } else {
                    an.b(aVar.aPy, i.c.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (wVar.sm() != null && wVar.sm().trim().length() > 0) {
                stringBuffer.append(wVar.sm());
            }
            ArrayList<MediaData> medias = wVar.getMedias();
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
                        aVar.aTy.setVisibility(0);
                        aVar.aTl.setText(as.d(stringBuffer.toString(), 170, "..."));
                    } else {
                        aVar.aTy.setVisibility(8);
                        aVar.aTl.setText(stringBuffer.toString());
                    }
                    aVar.aTl.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                        an.b(aVar.aTl, i.c.cp_cont_c, 1);
                    } else {
                        an.b(aVar.aTl, i.c.cp_cont_b, 1);
                    }
                } else {
                    aVar.aTy.setVisibility(8);
                    aVar.aTl.setVisibility(8);
                }
            }
            if (com.baidu.tbadk.core.m.qV().qZ() && medias != null && medias.size() > 0) {
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
                    aVar.bqf.setVisibility(0);
                    aVar.bqf.a(wVar, wVar.sj(), wVar.getId(), wVar.getTid());
                    aVar.bqf.setShowBig(com.baidu.adp.lib.util.i.iO());
                    aVar.bqf.setDrawNum(true);
                    aVar.bqf.setFromCDN(true);
                    aVar.bqf.a(this.boH.getPageContext(), mediaDataArr, i5);
                    aVar.bqf.setImageFrom("other");
                } else {
                    aVar.bqf.setVisibility(8);
                }
            } else {
                aVar.bqf.setVisibility(8);
            }
            if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
                aVar.aTu.setVisibility(0);
                aVar.aTu.setText(as.q(wVar.getPraise().getNum()));
            } else {
                aVar.aTu.setVisibility(8);
            }
            int reply_num = wVar.getReply_num();
            if (reply_num > 0) {
                aVar.aTw.setVisibility(0);
                aVar.aTw.setText(as.q(reply_num));
            } else {
                aVar.aTw.setVisibility(8);
            }
            an.j(aVar.bqg, i.c.cp_bg_line_c);
            a(this.boJ);
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
                if (aA instanceof w) {
                    w wVar = (w) aA;
                    this.boJ.a(view, wVar, wVar.getType(), this.aVo, intValue, id);
                }
            }
        }
    }
}
