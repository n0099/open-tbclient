package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<z, com.baidu.tieba.hottopic.b.a> implements View.OnClickListener {
    private BdTypeListView aVi;
    private HotTopicActivity bFY;
    private View.OnClickListener bFZ;
    private com.baidu.adp.widget.ListView.v bGa;
    private View.OnClickListener bhv;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bhv = new b(this);
        this.bFZ = new c(this);
        this.bGa = new d(this);
        this.bFY = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public com.baidu.tieba.hottopic.b.a a(ViewGroup viewGroup) {
        if (viewGroup instanceof BdTypeListView) {
            this.aVi = (BdTypeListView) viewGroup;
        }
        return new com.baidu.tieba.hottopic.b.a(LayoutInflater.from(this.mContext).inflate(n.h.hot_topic_hotthread_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, z zVar, com.baidu.tieba.hottopic.b.a aVar) {
        a(aVar, view);
        a(i, aVar, zVar);
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.a aVar, View view) {
        as.i(aVar.getView(), n.f.list_item_selector);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bFY != null && aVar.ahf != this.mSkinType) {
            aVar.ahf = this.mSkinType;
            as.i(aVar.bIj, n.f.frs_item_control_btn_bg);
            as.i((View) aVar.bcI, n.f.frs_item_abstract_more_text_bg);
            this.bFY.getLayoutMode().ac(this.mSkinType == 1);
            this.bFY.getLayoutMode().k(view);
        }
    }

    private void a(int i, com.baidu.tieba.hottopic.b.a aVar, z zVar) {
        if (zVar != null) {
            if (zVar instanceof com.baidu.tieba.hottopic.data.b) {
                aVar.bIe.setVisibility(0);
                aVar.bIe.setEnabled(false);
                aVar.bId.setEnabled(false);
                aVar.bIi.setVisibility(8);
                aVar.bIm.setVisibility(8);
                as.j(aVar.bIf, n.d.cp_bg_line_c);
                as.b(aVar.bIg, n.d.cp_cont_c, 1);
                as.j(aVar.bIh, n.d.cp_bg_line_b);
                aVar.bIg.setText(ax.d(((com.baidu.tieba.hottopic.data.b) zVar).bHi, 14, "..."));
                return;
            }
            aVar.bIe.setVisibility(8);
            aVar.bIi.setVisibility(0);
            aVar.bIm.setVisibility(0);
            if (this.aVi != null && this.aVi.getData() != null && i == this.aVi.getData().size() - 1) {
                aVar.bIm.setVisibility(8);
            }
            aVar.bhA.setOnClickListener(this);
            aVar.bcI.setOnClickListener(this);
            aVar.bhA.setTag(Integer.valueOf(i));
            aVar.bcI.setTag(Integer.valueOf(i));
            if (zVar != null && !zVar.sJ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
                aVar.bgj.setVisibility(0);
                aVar.bgk.setVisibility(0);
                aVar.bgj.setText(zVar.getAddress());
            } else {
                aVar.bgj.setVisibility(8);
                aVar.bgk.setVisibility(8);
            }
            aVar.agy.setText(ax.s(zVar.getLast_time_int() * 1000));
            aVar.bcC.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            aVar.bcC.setUserId(zVar.getAuthor().getUserId());
            aVar.bcC.setImageDrawable(null);
            aVar.bcC.d(portrait, 12, false);
            aVar.bcC.setOnClickListener(new e(this, zVar));
            aVar.bIk.setOnClickListener(new f(this, zVar));
            ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                aVar.agU.setVisibility(0);
                as.b(aVar.bcB, n.d.cp_cont_h, 1);
                aVar.agU.setTag(Integer.valueOf(i));
                aVar.agU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds10), true);
                aVar.agU.setOnClickListener(this.bhv);
            } else {
                aVar.agU.setVisibility(8);
                as.b(aVar.bcB, n.d.cp_cont_c, 1);
            }
            ArrayList<IconData> tShowInfo = zVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                aVar.agT.setVisibility(0);
                as.b(aVar.bcB, n.d.cp_cont_h, 1);
                aVar.agT.setTag(Integer.valueOf(i));
                aVar.agT.setOnClickListener(this.bFZ);
                aVar.agT.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
            } else {
                aVar.agT.setVisibility(8);
                as.b(aVar.bcB, n.d.cp_cont_c, 1);
            }
            aVar.bcB.setText(zVar.getAuthor().getUserName());
            com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            aVar.aOn.setMaxLines(2);
            aVar.aOn.setEllipsize(TextUtils.TruncateAt.END);
            if (zVar.sC() == 1) {
                aVar.aOn.setVisibility(8);
            } else {
                aVar.aOn.setVisibility(0);
                zVar.parser_title();
                aVar.aOn.setText(zVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.mC(zVar.getId())) {
                    as.b(aVar.aOn, n.d.cp_cont_c, 1);
                } else {
                    as.b(aVar.aOn, n.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (zVar.sy() != null && zVar.sy().trim().length() > 0) {
                stringBuffer.append(zVar.sy());
            }
            ArrayList<MediaData> medias = zVar.getMedias();
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
                        aVar.bcI.setVisibility(0);
                        aVar.bcy.setText(ax.d(stringBuffer.toString(), 170, "..."));
                    } else {
                        aVar.bcI.setVisibility(8);
                        aVar.bcy.setText(stringBuffer.toString());
                    }
                    aVar.bcy.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.mC(zVar.getId())) {
                        as.b(aVar.bcy, n.d.cp_cont_c, 1);
                    } else {
                        as.b(aVar.bcy, n.d.cp_cont_b, 1);
                    }
                } else {
                    aVar.bcI.setVisibility(8);
                    aVar.bcy.setVisibility(8);
                }
            }
            if (com.baidu.tbadk.core.m.qQ().qW() && medias != null && medias.size() > 0) {
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
                    aVar.bIl.setVisibility(0);
                    aVar.bIl.a(zVar, zVar.sv(), zVar.getId(), zVar.getTid());
                    aVar.bIl.setShowBig(com.baidu.adp.lib.util.i.iR());
                    aVar.bIl.setDrawNum(true);
                    aVar.bIl.setFromCDN(true);
                    aVar.bIl.a(this.bFY.getPageContext(), mediaDataArr, i5);
                    aVar.bIl.setImageFrom("other");
                } else {
                    aVar.bIl.setVisibility(8);
                }
            } else {
                aVar.bIl.setVisibility(8);
            }
            if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
                aVar.agz.setVisibility(0);
                aVar.agz.setText(ax.x(zVar.getPraise().getNum()));
            } else {
                aVar.agz.setVisibility(8);
            }
            int reply_num = zVar.getReply_num();
            if (reply_num > 0) {
                aVar.bcG.setVisibility(0);
                aVar.bcG.setText(ax.x(reply_num));
            } else {
                aVar.bcG.setVisibility(8);
            }
            as.j(aVar.bIm, n.d.cp_bg_line_c);
            a(this.bGa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u au = au(intValue);
                if (au instanceof z) {
                    z zVar = (z) au;
                    this.bGa.a(view, zVar, zVar.getType(), this.aVi, intValue, id);
                }
            }
        }
    }
}
