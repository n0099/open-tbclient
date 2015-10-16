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
public class dp extends bn<com.baidu.tbadk.core.data.w, dt> implements View.OnClickListener {
    private View.OnClickListener aXo;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public dp(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXo = new dq(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(i.d.ds30) * 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public dt a(ViewGroup viewGroup) {
        return new dt(LayoutInflater.from(this.mContext).inflate(i.g.frs_text_vote_item, (ViewGroup) null));
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dt dtVar) {
        if (dtVar == null || wVar == null || wVar.sg() == null) {
            return null;
        }
        if (dtVar.apS != this.mSkinType) {
            com.baidu.tbadk.core.util.an.i(dtVar.aYC, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.an.b(dtVar.aYD, i.c.cp_cont_d, 1);
        }
        if (wVar != null && !wVar.sy() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            dtVar.aXw.setVisibility(0);
            dtVar.aXx.setVisibility(0);
            dtVar.aXw.setText(wVar.getAddress());
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.j(dtVar.aXx, i.c.cp_bg_line_c);
                com.baidu.tbadk.core.util.an.b(dtVar.aXw, i.c.cp_cont_d, 1);
            }
        } else {
            dtVar.aXw.setVisibility(8);
            dtVar.aXx.setVisibility(8);
        }
        dtVar.aYD.setText(com.baidu.tbadk.core.util.as.o(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qX().qZ()) {
            dtVar.aYH.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            dtVar.aYH.setUserId(wVar.getAuthor().getUserId());
            dtVar.aYH.setImageDrawable(null);
            dtVar.aYH.d(portrait, 28, false);
        } else {
            dtVar.aYH.setVisibility(8);
        }
        dtVar.aYH.setOnClickListener(new dr(this, wVar));
        dtVar.aYL.setOnClickListener(new ds(this, wVar));
        ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dtVar.aYG.setVisibility(0);
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYE, i.c.cp_cont_h, 1);
            }
            dtVar.aYG.setTag(Integer.valueOf(i));
            dtVar.aYG.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            dtVar.aYG.setOnClickListener(this.aXo);
        } else {
            dtVar.aYG.setVisibility(8);
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYE, i.c.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            dtVar.aYF.setVisibility(0);
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYE, i.c.cp_cont_h, 1);
            }
            dtVar.aYF.setTag(Integer.valueOf(i));
            dtVar.aYF.setOnClickListener(this);
            dtVar.aYF.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            dtVar.aYF.setVisibility(8);
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYE, i.c.cp_cont_c, 1);
            }
        }
        dtVar.aYE.setText(wVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.sr() == 1) {
            dtVar.alu.setVisibility(8);
        } else {
            dtVar.alu.setVisibility(0);
            wVar.parser_title();
            dtVar.alu.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(dtVar.alu, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(dtVar.alu, i.c.cp_cont_b, 1);
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
                    dtVar.aTd.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dtVar.aTd.setText(stringBuffer.toString());
                }
                dtVar.aTd.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                    com.baidu.tbadk.core.util.an.b(dtVar.aTd, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(dtVar.aTd, i.c.cp_cont_b, 1);
                }
            } else {
                dtVar.aTd.setVisibility(8);
            }
        }
        int reply_num = wVar.getReply_num();
        dtVar.aYJ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            dtVar.aYJ.setVisibility(0);
            dtVar.aYJ.setText(com.baidu.tbadk.core.util.as.q(reply_num));
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYJ, i.c.cp_cont_d, 1);
            }
        } else {
            dtVar.aYJ.setVisibility(8);
        }
        long longValue = wVar.sg().total_poll.longValue();
        dtVar.aYK.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            dtVar.aYK.setVisibility(0);
            dtVar.aYK.setText(com.baidu.tbadk.core.util.as.q(wVar.sg().total_num.longValue()));
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYK, i.c.cp_cont_d, 1);
            }
        } else {
            dtVar.aYK.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = wVar.sg().options;
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            int i4 = 1;
            for (PollOption pollOption : list) {
                if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                    ei eiVar = new ei();
                    eiVar.a(i4, pollOption, j);
                    linkedList.add(eiVar);
                    int i5 = i4 + 1;
                    if (i5 > 3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            if (linkedList.size() > 0) {
                dtVar.aYM.setWidth(this.maxWidth);
                dtVar.aYM.b(linkedList, false);
                dtVar.aYM.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                dtVar.aYM.setVisibility(0);
            } else {
                dtVar.aYM.setVisibility(8);
            }
        }
        if (wVar.sg().options_count.intValue() == 0) {
            dtVar.aYN.setVisibility(8);
            dtVar.aYO.setVisibility(8);
        } else {
            String string = this.aSe.getResources().getString(i.h.total_x_vote_option);
            dtVar.aYN.setVisibility(0);
            dtVar.aYN.setText(String.format(string, wVar.sg().options_count));
            if (dtVar.apS != this.mSkinType) {
                com.baidu.tbadk.core.util.an.b(dtVar.aYN, i.c.cp_cont_c, 1);
            }
            if (StringUtils.isNull(wVar.sg().tips, true)) {
                dtVar.aYO.setVisibility(8);
            } else {
                dtVar.aYO.setVisibility(0);
                dtVar.aYO.setText("(" + wVar.sg().tips + ")");
                if (dtVar.apS != this.mSkinType) {
                    com.baidu.tbadk.core.util.an.b(dtVar.aYO, i.c.cp_cont_d, 1);
                }
            }
        }
        dtVar.apS = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dt dtVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dtVar);
        return a(i, view, viewGroup, wVar, dtVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWg != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aA = aA(intValue);
                if (aA instanceof com.baidu.tbadk.core.data.w) {
                    View childAt = this.aSV.getChildAt(intValue - (this.aSV.getFirstVisiblePosition() - this.aSV.getHeaderViewsCount()));
                    this.aWg.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA);
                }
            }
        }
    }
}
