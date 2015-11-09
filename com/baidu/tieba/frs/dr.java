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
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class dr extends bn<com.baidu.tbadk.core.data.w, dv> implements View.OnClickListener {
    private View.OnClickListener aXx;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public dr(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXx = new ds(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(i.d.ds30) * 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public dv a(ViewGroup viewGroup) {
        return new dv(LayoutInflater.from(this.mContext).inflate(i.g.frs_text_vote_item, (ViewGroup) null));
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dv dvVar) {
        if (dvVar == null || wVar == null || wVar.sg() == null) {
            return null;
        }
        if (dvVar.arf != this.mSkinType) {
            com.baidu.tbadk.core.util.an.i(dvVar.aYO, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.an.b(dvVar.aYP, i.c.cp_cont_d, 1);
        }
        if (wVar != null && !wVar.sy() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            dvVar.aXF.setVisibility(0);
            dvVar.aXG.setVisibility(0);
            dvVar.aXF.setText(wVar.getAddress());
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.j(dvVar.aXG, i.c.cp_bg_line_c);
                com.baidu.tbadk.core.util.an.b(dvVar.aXF, i.c.cp_cont_d, 1);
            }
        } else {
            dvVar.aXF.setVisibility(8);
            dvVar.aXG.setVisibility(8);
        }
        dvVar.aYP.setText(com.baidu.tbadk.core.util.as.m(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qV().qX()) {
            dvVar.aYT.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            dvVar.aYT.setUserId(wVar.getAuthor().getUserId());
            dvVar.aYT.setImageDrawable(null);
            dvVar.aYT.d(portrait, 28, false);
        } else {
            dvVar.aYT.setVisibility(8);
        }
        dvVar.aYT.setOnClickListener(new dt(this, wVar));
        dvVar.aYX.setOnClickListener(new du(this, wVar));
        ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dvVar.aYS.setVisibility(0);
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYQ, i.c.cp_cont_h, 1);
            }
            dvVar.aYS.setTag(Integer.valueOf(i));
            dvVar.aYS.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            dvVar.aYS.setOnClickListener(this.aXx);
        } else {
            dvVar.aYS.setVisibility(8);
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYQ, i.c.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            dvVar.aYR.setVisibility(0);
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYQ, i.c.cp_cont_h, 1);
            }
            dvVar.aYR.setTag(Integer.valueOf(i));
            dvVar.aYR.setOnClickListener(this);
            dvVar.aYR.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            dvVar.aYR.setVisibility(8);
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYQ, i.c.cp_cont_c, 1);
            }
        }
        dvVar.aYQ.setText(wVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.sr() == 1) {
            dvVar.alz.setVisibility(8);
        } else {
            dvVar.alz.setVisibility(0);
            wVar.parser_title();
            dvVar.alz.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(dvVar.alz, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(dvVar.alz, i.c.cp_cont_b, 1);
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
                    dvVar.aTl.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dvVar.aTl.setText(stringBuffer.toString());
                }
                dvVar.aTl.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                    com.baidu.tbadk.core.util.an.b(dvVar.aTl, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(dvVar.aTl, i.c.cp_cont_b, 1);
                }
            } else {
                dvVar.aTl.setVisibility(8);
            }
        }
        int reply_num = wVar.getReply_num();
        dvVar.aYV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            dvVar.aYV.setVisibility(0);
            dvVar.aYV.setText(com.baidu.tbadk.core.util.as.o(reply_num));
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYV, i.c.cp_cont_d, 1);
            }
        } else {
            dvVar.aYV.setVisibility(8);
        }
        long longValue = wVar.sg().total_poll.longValue();
        dvVar.aYW.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            dvVar.aYW.setVisibility(0);
            dvVar.aYW.setText(com.baidu.tbadk.core.util.as.o(wVar.sg().total_num.longValue()));
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYW, i.c.cp_cont_d, 1);
            }
        } else {
            dvVar.aYW.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = wVar.sg().options;
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            int i4 = 1;
            for (PollOption pollOption : list) {
                if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                    eo eoVar = new eo();
                    eoVar.a(i4, pollOption, j);
                    linkedList.add(eoVar);
                    int i5 = i4 + 1;
                    if (i5 > 3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            if (linkedList.size() > 0) {
                dvVar.aYY.setWidth(this.maxWidth);
                dvVar.aYY.b(linkedList, false);
                dvVar.aYY.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                dvVar.aYY.setVisibility(0);
            } else {
                dvVar.aYY.setVisibility(8);
            }
        }
        if (wVar.sg().options_count.intValue() == 0) {
            dvVar.aYZ.setVisibility(8);
            dvVar.aZa.setVisibility(8);
        } else {
            String string = this.aSm.getResources().getString(i.h.total_x_vote_option);
            dvVar.aYZ.setVisibility(0);
            dvVar.aYZ.setText(String.format(string, wVar.sg().options_count));
            if (dvVar.arf != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dvVar.aYZ, i.c.cp_cont_c, 1);
            }
            if (StringUtils.isNull(wVar.sg().tips, true)) {
                dvVar.aZa.setVisibility(8);
            } else {
                dvVar.aZa.setVisibility(0);
                dvVar.aZa.setText("(" + wVar.sg().tips + ")");
                if (dvVar.arf != this.mSkinType) {
                    com.baidu.tbadk.core.util.an.b(dvVar.aZa, i.c.cp_cont_d, 1);
                }
            }
        }
        dvVar.arf = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dv dvVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dvVar);
        return a(i, view, viewGroup, wVar, dvVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWo != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aA = aA(intValue);
                if (aA instanceof com.baidu.tbadk.core.data.w) {
                    View childAt = this.aTd.getChildAt(intValue - (this.aTd.getFirstVisiblePosition() - this.aTd.getHeaderViewsCount()));
                    this.aWo.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA);
                }
            }
        }
    }
}
