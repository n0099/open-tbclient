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
public class dp extends bn<com.baidu.tbadk.core.data.v, dt> implements View.OnClickListener {
    private View.OnClickListener aXd;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public dp(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXd = new dq(this);
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

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, dt dtVar) {
        if (dtVar == null || vVar == null || vVar.sg() == null) {
            return null;
        }
        if (dtVar.apR != this.mSkinType) {
            com.baidu.tbadk.core.util.am.i(dtVar.aYr, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.am.b(dtVar.aYs, i.c.cp_cont_d, 1);
        }
        if (vVar != null && !vVar.sy() && !TextUtils.isEmpty(vVar.getAddress()) && !TextUtils.isEmpty(vVar.getAddress().trim())) {
            dtVar.aXl.setVisibility(0);
            dtVar.aXm.setVisibility(0);
            dtVar.aXl.setText(vVar.getAddress());
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.j(dtVar.aXm, i.c.cp_bg_line_c);
                com.baidu.tbadk.core.util.am.b(dtVar.aXl, i.c.cp_cont_d, 1);
            }
        } else {
            dtVar.aXl.setVisibility(8);
            dtVar.aXm.setVisibility(8);
        }
        dtVar.aYs.setText(com.baidu.tbadk.core.util.ar.o(vVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qX().qZ()) {
            dtVar.aYw.setVisibility(0);
            String portrait = vVar.getAuthor().getPortrait();
            dtVar.aYw.setUserId(vVar.getAuthor().getUserId());
            dtVar.aYw.setImageDrawable(null);
            dtVar.aYw.d(portrait, 28, false);
        } else {
            dtVar.aYw.setVisibility(8);
        }
        dtVar.aYw.setOnClickListener(new dr(this, vVar));
        dtVar.aYA.setOnClickListener(new ds(this, vVar));
        ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dtVar.aYv.setVisibility(0);
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYt, i.c.cp_cont_h, 1);
            }
            dtVar.aYv.setTag(Integer.valueOf(i));
            dtVar.aYv.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            dtVar.aYv.setOnClickListener(this.aXd);
        } else {
            dtVar.aYv.setVisibility(8);
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYt, i.c.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            dtVar.aYu.setVisibility(0);
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYt, i.c.cp_cont_h, 1);
            }
            dtVar.aYu.setTag(Integer.valueOf(i));
            dtVar.aYu.setOnClickListener(this);
            dtVar.aYu.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            dtVar.aYu.setVisibility(8);
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYt, i.c.cp_cont_c, 1);
            }
        }
        dtVar.aYt.setText(vVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (vVar.sr() == 1) {
            dtVar.alt.setVisibility(8);
        } else {
            dtVar.alt.setVisibility(0);
            vVar.parser_title();
            dtVar.alt.setText(vVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                com.baidu.tbadk.core.util.am.b(dtVar.alt, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.am.b(dtVar.alt, i.c.cp_cont_b, 1);
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
                    dtVar.aSS.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dtVar.aSS.setText(stringBuffer.toString());
                }
                dtVar.aSS.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                    com.baidu.tbadk.core.util.am.b(dtVar.aSS, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.am.b(dtVar.aSS, i.c.cp_cont_b, 1);
                }
            } else {
                dtVar.aSS.setVisibility(8);
            }
        }
        int reply_num = vVar.getReply_num();
        dtVar.aYy.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            dtVar.aYy.setVisibility(0);
            dtVar.aYy.setText(com.baidu.tbadk.core.util.ar.q(reply_num));
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYy, i.c.cp_cont_d, 1);
            }
        } else {
            dtVar.aYy.setVisibility(8);
        }
        long longValue = vVar.sg().total_poll.longValue();
        dtVar.aYz.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            dtVar.aYz.setVisibility(0);
            dtVar.aYz.setText(com.baidu.tbadk.core.util.ar.q(vVar.sg().total_num.longValue()));
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYz, i.c.cp_cont_d, 1);
            }
        } else {
            dtVar.aYz.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = vVar.sg().options;
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
                dtVar.aYB.setWidth(this.maxWidth);
                dtVar.aYB.b(linkedList, false);
                dtVar.aYB.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                dtVar.aYB.setVisibility(0);
            } else {
                dtVar.aYB.setVisibility(8);
            }
        }
        if (vVar.sg().options_count.intValue() == 0) {
            dtVar.aYC.setVisibility(8);
            dtVar.aYD.setVisibility(8);
        } else {
            String string = this.aRT.getResources().getString(i.h.total_x_vote_option);
            dtVar.aYC.setVisibility(0);
            dtVar.aYC.setText(String.format(string, vVar.sg().options_count));
            if (dtVar.apR != this.mSkinType) {
                com.baidu.tbadk.core.util.am.b(dtVar.aYC, i.c.cp_cont_c, 1);
            }
            if (StringUtils.isNull(vVar.sg().tips, true)) {
                dtVar.aYD.setVisibility(8);
            } else {
                dtVar.aYD.setVisibility(0);
                dtVar.aYD.setText("(" + vVar.sg().tips + ")");
                if (dtVar.apR != this.mSkinType) {
                    com.baidu.tbadk.core.util.am.b(dtVar.aYD, i.c.cp_cont_d, 1);
                }
            }
        }
        dtVar.apR = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, dt dtVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) dtVar);
        return a(i, view, viewGroup, vVar, dtVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVV != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aA = aA(intValue);
                if (aA instanceof com.baidu.tbadk.core.data.v) {
                    View childAt = this.aSK.getChildAt(intValue - (this.aSK.getFirstVisiblePosition() - this.aSK.getHeaderViewsCount()));
                    this.aVV.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.v) aA);
                }
            }
        }
    }
}
