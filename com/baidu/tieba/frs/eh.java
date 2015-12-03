package com.baidu.tieba.frs;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class eh extends bm<com.baidu.tbadk.core.data.z, el> implements View.OnClickListener {
    private View.OnClickListener bdv;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public eh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bdv = new ei(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(n.d.ds30) * 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public el a(ViewGroup viewGroup) {
        return new el(LayoutInflater.from(this.mContext).inflate(n.g.frs_text_vote_item, (ViewGroup) null));
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, el elVar) {
        if (elVar == null || zVar == null || zVar.sH() == null) {
            return null;
        }
        if (elVar.afY != this.mSkinType) {
            com.baidu.tbadk.core.util.as.i(elVar.beN, n.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.as.b(elVar.beO, n.c.cp_cont_d, 1);
        }
        if (zVar != null && !zVar.sZ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
            elVar.bck.setVisibility(0);
            elVar.bcl.setVisibility(0);
            elVar.bck.setText(zVar.getAddress());
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.j(elVar.bcl, n.c.cp_bg_line_c);
                com.baidu.tbadk.core.util.as.b(elVar.bck, n.c.cp_cont_d, 1);
            }
        } else {
            elVar.bck.setVisibility(8);
            elVar.bcl.setVisibility(8);
        }
        elVar.beO.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.rh().rj()) {
            elVar.beS.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            elVar.beS.setUserId(zVar.getAuthor().getUserId());
            elVar.beS.setImageDrawable(null);
            elVar.beS.d(portrait, 28, false);
        } else {
            elVar.beS.setVisibility(8);
        }
        elVar.beS.setOnClickListener(new ej(this, zVar));
        elVar.beW.setOnClickListener(new ek(this, zVar));
        ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            elVar.beR.setVisibility(0);
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beP, n.c.cp_cont_h, 1);
            }
            elVar.beR.setTag(Integer.valueOf(i));
            elVar.beR.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds10), true);
            elVar.beR.setOnClickListener(this.bdv);
        } else {
            elVar.beR.setVisibility(8);
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beP, n.c.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            elVar.beQ.setVisibility(0);
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beP, n.c.cp_cont_h, 1);
            }
            elVar.beQ.setTag(Integer.valueOf(i));
            elVar.beQ.setOnClickListener(this);
            elVar.beQ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
        } else {
            elVar.beQ.setVisibility(8);
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beP, n.c.cp_cont_c, 1);
            }
        }
        elVar.beP.setText(zVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (zVar.sS() == 1) {
            elVar.agd.setVisibility(8);
        } else {
            elVar.agd.setVisibility(0);
            zVar.parser_title();
            elVar.agd.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(elVar.agd, n.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(elVar.agd, n.c.cp_cont_b, 1);
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
                    elVar.aYz.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    elVar.aYz.setText(stringBuffer.toString());
                }
                elVar.aYz.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                    com.baidu.tbadk.core.util.as.b(elVar.aYz, n.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(elVar.aYz, n.c.cp_cont_b, 1);
                }
            } else {
                elVar.aYz.setVisibility(8);
            }
        }
        int reply_num = zVar.getReply_num();
        elVar.beU.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            elVar.beU.setVisibility(0);
            elVar.beU.setText(com.baidu.tbadk.core.util.ax.v(reply_num));
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beU, n.c.cp_cont_d, 1);
            }
        } else {
            elVar.beU.setVisibility(8);
        }
        long longValue = zVar.sH().total_poll.longValue();
        elVar.beV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            elVar.beV.setVisibility(0);
            elVar.beV.setText(com.baidu.tbadk.core.util.ax.v(zVar.sH().total_num.longValue()));
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beV, n.c.cp_cont_d, 1);
            }
        } else {
            elVar.beV.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = zVar.sH().options;
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            int i4 = 1;
            for (PollOption pollOption : list) {
                if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                    fg fgVar = new fg();
                    fgVar.a(i4, pollOption, j);
                    linkedList.add(fgVar);
                    int i5 = i4 + 1;
                    if (i5 > 3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            if (linkedList.size() > 0) {
                elVar.beX.setWidth(this.maxWidth);
                elVar.beX.setBoallotsForListView(linkedList);
                elVar.beX.onChangeSkinType(this.mSkinType);
                elVar.beX.setVisibility(0);
            } else {
                elVar.beX.setVisibility(8);
            }
        }
        if (zVar.sH().options_count.intValue() == 0) {
            elVar.beY.setVisibility(8);
            elVar.beZ.setVisibility(8);
        } else {
            String string = this.aXA.getResources().getString(n.i.total_x_vote_option);
            elVar.beY.setVisibility(0);
            elVar.beY.setText(String.format(string, zVar.sH().options_count));
            if (elVar.afY != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.beY, n.c.cp_cont_c, 1);
            }
            if (StringUtils.isNull(zVar.sH().tips, true)) {
                elVar.beZ.setVisibility(8);
            } else {
                elVar.beZ.setVisibility(0);
                elVar.beZ.setText("(" + zVar.sH().tips + ")");
                if (elVar.afY != this.mSkinType) {
                    com.baidu.tbadk.core.util.as.b(elVar.beZ, n.c.cp_cont_d, 1);
                }
            }
        }
        elVar.afY = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, el elVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) elVar);
        return a(i, view, viewGroup, zVar, elVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbF != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aB = aB(intValue);
                if (aB instanceof com.baidu.tbadk.core.data.z) {
                    View childAt = this.aYr.getChildAt(intValue - (this.aYr.getFirstVisiblePosition() - this.aYr.getHeaderViewsCount()));
                    this.bbF.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) aB);
                }
            }
        }
    }
}
