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
    private BdTypeListView aVg;
    private View.OnClickListener aXo;
    private HotTopicActivity bod;
    private View.OnClickListener boe;
    private v bof;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aXo = new b(this);
        this.boe = new c(this);
        this.bof = new d(this);
        this.bod = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public com.baidu.tieba.hottopic.b.a a(ViewGroup viewGroup) {
        if (viewGroup instanceof BdTypeListView) {
            this.aVg = (BdTypeListView) viewGroup;
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
        if (this.bod != null && aVar.apS != this.mSkinType) {
            an.i(aVar.bpz, i.e.frs_item_control_btn_bg);
            an.i((View) aVar.aTq, i.e.frs_item_abstract_more_text_bg);
            this.bod.getLayoutMode().ad(this.mSkinType == 1);
            this.bod.getLayoutMode().k(view);
        }
    }

    private void a(int i, com.baidu.tieba.hottopic.b.a aVar, w wVar) {
        if (wVar != null) {
            if (wVar instanceof com.baidu.tieba.hottopic.data.a) {
                aVar.bpu.setVisibility(0);
                aVar.bpu.setEnabled(false);
                aVar.bpt.setEnabled(false);
                aVar.bpy.setVisibility(8);
                aVar.bpC.setVisibility(8);
                an.j(aVar.bpv, i.c.cp_bg_line_c);
                an.b(aVar.bpw, i.c.cp_cont_c, 1);
                an.j(aVar.bpx, i.c.cp_bg_line_b);
                aVar.bpw.setText(as.d(((com.baidu.tieba.hottopic.data.a) wVar).boQ, 14, "..."));
                return;
            }
            aVar.bpu.setVisibility(8);
            aVar.bpy.setVisibility(0);
            aVar.bpC.setVisibility(0);
            if (this.aVg != null && this.aVg.getData() != null && i == this.aVg.getData().size() - 1) {
                aVar.bpC.setVisibility(8);
            }
            aVar.aXu.setOnClickListener(this);
            aVar.aTq.setOnClickListener(this);
            aVar.aXu.setTag(Integer.valueOf(i));
            aVar.aTq.setTag(Integer.valueOf(i));
            if (wVar != null && !wVar.sv() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
                aVar.aXw.setVisibility(0);
                aVar.aXx.setVisibility(0);
                aVar.aXw.setText(wVar.getAddress());
            } else {
                aVar.aXw.setVisibility(8);
                aVar.aXx.setVisibility(8);
            }
            aVar.aTg.setText(as.m(wVar.getLast_time_int() * 1000));
            aVar.aTj.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            aVar.aTj.setUserId(wVar.getAuthor().getUserId());
            aVar.aTj.setImageDrawable(null);
            aVar.aTj.d(portrait, 12, false);
            aVar.aTj.setOnClickListener(new e(this, wVar));
            aVar.bpA.setOnClickListener(new f(this, wVar));
            ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                aVar.aXt.setVisibility(0);
                an.b(aVar.aTh, i.c.cp_cont_h, 1);
                aVar.aXt.setTag(Integer.valueOf(i));
                aVar.aXt.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
                aVar.aXt.setOnClickListener(this.aXo);
            } else {
                aVar.aXt.setVisibility(8);
                an.b(aVar.aTh, i.c.cp_cont_c, 1);
            }
            ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                aVar.aTi.setVisibility(0);
                an.b(aVar.aTh, i.c.cp_cont_h, 1);
                aVar.aTi.setTag(Integer.valueOf(i));
                aVar.aTi.setOnClickListener(this.boe);
                aVar.aTi.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
            } else {
                aVar.aTi.setVisibility(8);
                an.b(aVar.aTh, i.c.cp_cont_c, 1);
            }
            aVar.aTh.setText(wVar.getAuthor().getUserName());
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            aVar.aPq.setMaxLines(2);
            aVar.aPq.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.so() == 1) {
                aVar.aPq.setVisibility(8);
            } else {
                aVar.aPq.setVisibility(0);
                wVar.parser_title();
                aVar.aPq.setText(wVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                    an.b(aVar.aPq, i.c.cp_cont_c, 1);
                } else {
                    an.b(aVar.aPq, i.c.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (wVar.sj() != null && wVar.sj().trim().length() > 0) {
                stringBuffer.append(wVar.sj());
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
                        aVar.aTq.setVisibility(0);
                        aVar.aTd.setText(as.d(stringBuffer.toString(), 170, "..."));
                    } else {
                        aVar.aTq.setVisibility(8);
                        aVar.aTd.setText(stringBuffer.toString());
                    }
                    aVar.aTd.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                        an.b(aVar.aTd, i.c.cp_cont_c, 1);
                    } else {
                        an.b(aVar.aTd, i.c.cp_cont_b, 1);
                    }
                } else {
                    aVar.aTq.setVisibility(8);
                    aVar.aTd.setVisibility(8);
                }
            }
            if (com.baidu.tbadk.core.m.qU().qY() && medias != null && medias.size() > 0) {
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
                    aVar.bpB.setVisibility(0);
                    aVar.bpB.a(wVar, wVar.sg(), wVar.getId(), wVar.getTid());
                    aVar.bpB.setShowBig(com.baidu.adp.lib.util.i.iN());
                    aVar.bpB.setDrawNum(true);
                    aVar.bpB.setFromCDN(true);
                    aVar.bpB.a(this.bod.getPageContext(), mediaDataArr, i5);
                    aVar.bpB.setImageFrom("other");
                } else {
                    aVar.bpB.setVisibility(8);
                }
            } else {
                aVar.bpB.setVisibility(8);
            }
            if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
                aVar.aTm.setVisibility(0);
                aVar.aTm.setText(as.q(wVar.getPraise().getNum()));
            } else {
                aVar.aTm.setVisibility(8);
            }
            int reply_num = wVar.getReply_num();
            if (reply_num > 0) {
                aVar.aTo.setVisibility(0);
                aVar.aTo.setText(as.q(reply_num));
            } else {
                aVar.aTo.setVisibility(8);
            }
            an.j(aVar.bpC, i.c.cp_bg_line_c);
            a(this.bof);
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
                    this.bof.a(view, wVar, wVar.getType(), this.aVg, intValue, id);
                }
            }
        }
    }
}
