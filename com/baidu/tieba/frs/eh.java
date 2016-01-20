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
public class eh extends bp<com.baidu.tbadk.core.data.z, el> implements View.OnClickListener {
    private View.OnClickListener bhv;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public eh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bhv = new ei(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(n.e.ds30) * 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public el a(ViewGroup viewGroup) {
        return new el(LayoutInflater.from(this.mContext).inflate(n.h.frs_text_vote_item, (ViewGroup) null));
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, el elVar) {
        if (elVar == null || zVar == null || zVar.sr() == null) {
            return null;
        }
        if (elVar.ahf != this.mSkinType) {
            com.baidu.tbadk.core.util.as.i(elVar.biH, n.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.as.b(elVar.biI, n.d.cp_cont_d, 1);
        }
        if (zVar != null && !zVar.sJ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
            elVar.bgj.setVisibility(0);
            elVar.bgk.setVisibility(0);
            elVar.bgj.setText(zVar.getAddress());
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.j(elVar.bgk, n.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.as.b(elVar.bgj, n.d.cp_cont_d, 1);
            }
        } else {
            elVar.bgj.setVisibility(8);
            elVar.bgk.setVisibility(8);
        }
        elVar.biI.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qQ().qS()) {
            elVar.biM.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            elVar.biM.setUserId(zVar.getAuthor().getUserId());
            elVar.biM.setImageDrawable(null);
            elVar.biM.d(portrait, 28, false);
        } else {
            elVar.biM.setVisibility(8);
        }
        elVar.biM.setOnClickListener(new ej(this, zVar));
        elVar.biQ.setOnClickListener(new ek(this, zVar));
        ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            elVar.biL.setVisibility(0);
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biJ, n.d.cp_cont_h, 1);
            }
            elVar.biL.setTag(Integer.valueOf(i));
            elVar.biL.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds10), true);
            elVar.biL.setOnClickListener(this.bhv);
        } else {
            elVar.biL.setVisibility(8);
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biJ, n.d.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            elVar.biK.setVisibility(0);
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biJ, n.d.cp_cont_h, 1);
            }
            elVar.biK.setTag(Integer.valueOf(i));
            elVar.biK.setOnClickListener(this);
            elVar.biK.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
        } else {
            elVar.biK.setVisibility(8);
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biJ, n.d.cp_cont_c, 1);
            }
        }
        elVar.biJ.setText(zVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (zVar.sC() == 1) {
            elVar.ahk.setVisibility(8);
        } else {
            elVar.ahk.setVisibility(0);
            zVar.parser_title();
            elVar.ahk.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mD(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(elVar.ahk, n.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(elVar.ahk, n.d.cp_cont_b, 1);
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
                    elVar.bcy.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    elVar.bcy.setText(stringBuffer.toString());
                }
                elVar.bcy.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mD(zVar.getId())) {
                    com.baidu.tbadk.core.util.as.b(elVar.bcy, n.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(elVar.bcy, n.d.cp_cont_b, 1);
                }
            } else {
                elVar.bcy.setVisibility(8);
            }
        }
        int reply_num = zVar.getReply_num();
        elVar.biO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            elVar.biO.setVisibility(0);
            elVar.biO.setText(com.baidu.tbadk.core.util.ax.w(reply_num));
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biO, n.d.cp_cont_d, 1);
            }
        } else {
            elVar.biO.setVisibility(8);
        }
        long longValue = zVar.sr().total_poll.longValue();
        elVar.biP.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            elVar.biP.setVisibility(0);
            elVar.biP.setText(com.baidu.tbadk.core.util.ax.w(zVar.sr().total_num.longValue()));
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biP, n.d.cp_cont_d, 1);
            }
        } else {
            elVar.biP.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = zVar.sr().options;
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
                elVar.biR.setWidth(this.maxWidth);
                elVar.biR.setBoallotsForListView(linkedList);
                elVar.biR.onChangeSkinType(this.mSkinType);
                elVar.biR.setVisibility(0);
            } else {
                elVar.biR.setVisibility(8);
            }
        }
        if (zVar.sr().options_count.intValue() == 0) {
            elVar.biS.setVisibility(8);
            elVar.biT.setVisibility(8);
        } else {
            String string = this.bbA.getResources().getString(n.j.total_x_vote_option);
            elVar.biS.setVisibility(0);
            elVar.biS.setText(String.format(string, zVar.sr().options_count));
            if (elVar.ahf != this.mSkinType) {
                com.baidu.tbadk.core.util.as.b(elVar.biS, n.d.cp_cont_c, 1);
            }
            if (StringUtils.isNull(zVar.sr().tips, true)) {
                elVar.biT.setVisibility(8);
            } else {
                elVar.biT.setVisibility(0);
                elVar.biT.setText("(" + zVar.sr().tips + ")");
                if (elVar.ahf != this.mSkinType) {
                    com.baidu.tbadk.core.util.as.b(elVar.biT, n.d.cp_cont_d, 1);
                }
            }
        }
        elVar.ahf = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, el elVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) elVar);
        return a(i, view, viewGroup, zVar, elVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfE != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u au = au(intValue);
                if (au instanceof com.baidu.tbadk.core.data.z) {
                    View childAt = this.bcq.getChildAt(intValue - (this.bcq.getFirstVisiblePosition() - this.bcq.getHeaderViewsCount()));
                    this.bfE.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) au);
                }
            }
        }
    }
}
