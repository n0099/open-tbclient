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
    private BdTypeListView aRs;
    private HotTopicActivity bCu;
    private View.OnClickListener bCv;
    private com.baidu.adp.widget.ListView.v bCw;
    private View.OnClickListener bdv;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bdv = new b(this);
        this.bCv = new c(this);
        this.bCw = new d(this);
        this.bCu = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public com.baidu.tieba.hottopic.b.a a(ViewGroup viewGroup) {
        if (viewGroup instanceof BdTypeListView) {
            this.aRs = (BdTypeListView) viewGroup;
        }
        return new com.baidu.tieba.hottopic.b.a(LayoutInflater.from(this.mContext).inflate(n.g.hot_topic_hotthread_item, (ViewGroup) null));
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
        as.i(aVar.getView(), n.e.list_item_selector);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bCu != null && aVar.afY != this.mSkinType) {
            aVar.afY = this.mSkinType;
            as.i(aVar.bEF, n.e.frs_item_control_btn_bg);
            as.i((View) aVar.aYM, n.e.frs_item_abstract_more_text_bg);
            this.bCu.getLayoutMode().af(this.mSkinType == 1);
            this.bCu.getLayoutMode().k(view);
        }
    }

    private void a(int i, com.baidu.tieba.hottopic.b.a aVar, z zVar) {
        if (zVar != null) {
            if (zVar instanceof com.baidu.tieba.hottopic.data.b) {
                aVar.bEA.setVisibility(0);
                aVar.bEA.setEnabled(false);
                aVar.bEz.setEnabled(false);
                aVar.bEE.setVisibility(8);
                aVar.bEI.setVisibility(8);
                as.j(aVar.bEB, n.c.cp_bg_line_c);
                as.b(aVar.bEC, n.c.cp_cont_c, 1);
                as.j(aVar.bED, n.c.cp_bg_line_b);
                aVar.bEC.setText(ax.d(((com.baidu.tieba.hottopic.data.b) zVar).bDE, 14, "..."));
                return;
            }
            aVar.bEA.setVisibility(8);
            aVar.bEE.setVisibility(0);
            aVar.bEI.setVisibility(0);
            if (this.aRs != null && this.aRs.getData() != null && i == this.aRs.getData().size() - 1) {
                aVar.bEI.setVisibility(8);
            }
            aVar.bdB.setOnClickListener(this);
            aVar.aYM.setOnClickListener(this);
            aVar.bdB.setTag(Integer.valueOf(i));
            aVar.aYM.setTag(Integer.valueOf(i));
            if (zVar != null && !zVar.sZ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
                aVar.bck.setVisibility(0);
                aVar.bcl.setVisibility(0);
                aVar.bck.setText(zVar.getAddress());
            } else {
                aVar.bck.setVisibility(8);
                aVar.bcl.setVisibility(8);
            }
            aVar.aYC.setText(ax.s(zVar.getLast_time_int() * 1000));
            aVar.aYF.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            aVar.aYF.setUserId(zVar.getAuthor().getUserId());
            aVar.aYF.setImageDrawable(null);
            aVar.aYF.d(portrait, 12, false);
            aVar.aYF.setOnClickListener(new e(this, zVar));
            aVar.bEG.setOnClickListener(new f(this, zVar));
            ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
            if (iconInfo != null && iconInfo.size() > 0) {
                aVar.bdA.setVisibility(0);
                as.b(aVar.aYD, n.c.cp_cont_h, 1);
                aVar.bdA.setTag(Integer.valueOf(i));
                aVar.bdA.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds10), true);
                aVar.bdA.setOnClickListener(this.bdv);
            } else {
                aVar.bdA.setVisibility(8);
                as.b(aVar.aYD, n.c.cp_cont_c, 1);
            }
            ArrayList<IconData> tShowInfo = zVar.getAuthor().getTShowInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                aVar.aYE.setVisibility(0);
                as.b(aVar.aYD, n.c.cp_cont_h, 1);
                aVar.aYE.setTag(Integer.valueOf(i));
                aVar.aYE.setOnClickListener(this.bCv);
                aVar.aYE.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
            } else {
                aVar.aYE.setVisibility(8);
                as.b(aVar.aYD, n.c.cp_cont_c, 1);
            }
            aVar.aYD.setText(zVar.getAuthor().getUserName());
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            aVar.aUB.setMaxLines(2);
            aVar.aUB.setEllipsize(TextUtils.TruncateAt.END);
            if (zVar.sS() == 1) {
                aVar.aUB.setVisibility(8);
            } else {
                aVar.aUB.setVisibility(0);
                zVar.parser_title();
                aVar.aUB.setText(zVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                    as.b(aVar.aUB, n.c.cp_cont_c, 1);
                } else {
                    as.b(aVar.aUB, n.c.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (zVar.sO() != null && zVar.sO().trim().length() > 0) {
                stringBuffer.append(zVar.sO());
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
                        aVar.aYM.setVisibility(0);
                        aVar.aYz.setText(ax.d(stringBuffer.toString(), 170, "..."));
                    } else {
                        aVar.aYM.setVisibility(8);
                        aVar.aYz.setText(stringBuffer.toString());
                    }
                    aVar.aYz.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                        as.b(aVar.aYz, n.c.cp_cont_c, 1);
                    } else {
                        as.b(aVar.aYz, n.c.cp_cont_b, 1);
                    }
                } else {
                    aVar.aYM.setVisibility(8);
                    aVar.aYz.setVisibility(8);
                }
            }
            if (com.baidu.tbadk.core.m.rh().rn() && medias != null && medias.size() > 0) {
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
                    aVar.bEH.setVisibility(0);
                    aVar.bEH.a(zVar, zVar.sL(), zVar.getId(), zVar.getTid());
                    aVar.bEH.setShowBig(com.baidu.adp.lib.util.i.iQ());
                    aVar.bEH.setDrawNum(true);
                    aVar.bEH.setFromCDN(true);
                    aVar.bEH.a(this.bCu.getPageContext(), mediaDataArr, i5);
                    aVar.bEH.setImageFrom("other");
                } else {
                    aVar.bEH.setVisibility(8);
                }
            } else {
                aVar.bEH.setVisibility(8);
            }
            if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
                aVar.aYI.setVisibility(0);
                aVar.aYI.setText(ax.w(zVar.getPraise().getNum()));
            } else {
                aVar.aYI.setVisibility(8);
            }
            int reply_num = zVar.getReply_num();
            if (reply_num > 0) {
                aVar.aYK.setVisibility(0);
                aVar.aYK.setText(ax.w(reply_num));
            } else {
                aVar.aYK.setVisibility(8);
            }
            as.j(aVar.bEI, n.c.cp_bg_line_c);
            a(this.bCw);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aB = aB(intValue);
                if (aB instanceof z) {
                    z zVar = (z) aB;
                    this.bCw.a(view, zVar, zVar.getType(), this.aRs, intValue, id);
                }
            }
        }
    }
}
