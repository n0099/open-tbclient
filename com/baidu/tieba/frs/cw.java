package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cw extends bn<com.baidu.tbadk.core.data.w, da> implements View.OnClickListener {
    private boolean aSP;
    private BaseActivity aSe;
    private boolean aXk;
    private View.OnClickListener aXo;

    /* JADX INFO: Access modifiers changed from: protected */
    public cw(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aSP = false;
        this.aXk = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXo = new cx(this);
        this.aSe = baseActivity;
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, da daVar) {
        if (wVar == null || wVar.sd() == null) {
            return null;
        }
        if (daVar.apS != this.mSkinType) {
            daVar.aYa.setGrade(com.baidu.tbadk.core.util.an.getDrawable(i.e.pic_grade_vote_no1));
            daVar.aYb.setGrade(com.baidu.tbadk.core.util.an.getDrawable(i.e.pic_grade_vote_no2));
            daVar.aYc.setGrade(com.baidu.tbadk.core.util.an.getDrawable(i.e.pic_grade_vote_no3));
            daVar.aYa.onChangeSkinType(this.mSkinType);
            daVar.aYb.onChangeSkinType(this.mSkinType);
            daVar.aYc.onChangeSkinType(this.mSkinType);
            daVar.aXY.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            daVar.aTo.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.an.h((View) daVar.aXY, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.h((View) daVar.aTo, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.h((View) daVar.aTg, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.j(daVar.aXx, i.c.cp_bg_line_c);
            com.baidu.tbadk.core.util.an.h((View) daVar.aXw, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.h((View) daVar.aYd, i.c.cp_cont_c);
            com.baidu.tbadk.core.util.an.h((View) daVar.aYe, i.c.cp_cont_c);
            com.baidu.tbadk.core.util.an.i(daVar.aTc, i.e.frs_item_control_btn_bg);
        }
        if (wVar != null && !wVar.sv() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            daVar.aXw.setVisibility(0);
            daVar.aXx.setVisibility(0);
            daVar.aXw.setText(wVar.getAddress());
        } else {
            daVar.aXw.setVisibility(8);
            daVar.aXx.setVisibility(8);
        }
        daVar.aTg.setText(com.baidu.tbadk.core.util.as.m(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qU().qW()) {
            daVar.aTj.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            daVar.aTj.setUserId(wVar.getAuthor().getUserId());
            daVar.aTj.setImageDrawable(null);
            daVar.aTj.d(portrait, 28, false);
        } else {
            daVar.aTj.setVisibility(8);
        }
        daVar.aTj.setOnClickListener(new cy(this, wVar));
        daVar.aTs.setOnClickListener(new cz(this, wVar));
        ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            daVar.aXt.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(daVar.aTh, i.c.cp_cont_h, 1);
            daVar.aXt.setTag(Integer.valueOf(i));
            daVar.aXt.setOnClickListener(this);
            daVar.aXt.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            daVar.aXt.setOnClickListener(this.aXo);
        } else {
            daVar.aXt.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(daVar.aTh, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            daVar.aTi.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(daVar.aTh, i.c.cp_cont_h, 1);
            daVar.aTi.setTag(Integer.valueOf(i));
            daVar.aTi.setOnClickListener(this);
            daVar.aTi.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            daVar.aTi.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(daVar.aTh, i.c.cp_cont_c, 1);
        }
        daVar.aTh.setText(wVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.so() == 1) {
            daVar.aPq.setVisibility(8);
        } else {
            daVar.aPq.setVisibility(0);
            wVar.parser_title();
            daVar.aPq.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(daVar.aPq, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(daVar.aPq, i.c.cp_cont_b, 1);
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
                    daVar.aTd.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    daVar.aTd.setText(stringBuffer.toString());
                }
                daVar.aTd.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                    com.baidu.tbadk.core.util.an.b(daVar.aTd, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(daVar.aTd, i.c.cp_cont_b, 1);
                }
            } else {
                daVar.aTd.setVisibility(8);
            }
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            daVar.aTo.setVisibility(0);
            daVar.aTo.setText(com.baidu.tbadk.core.util.as.o(reply_num));
        } else {
            daVar.aTo.setVisibility(8);
        }
        long longValue = wVar.sd().total_num.longValue();
        if (longValue > 0) {
            daVar.aXY.setVisibility(0);
            daVar.aXY.setText(com.baidu.tbadk.core.util.as.o(longValue));
        } else {
            daVar.aXY.setVisibility(8);
        }
        List<PollOption> list = wVar.sd().options;
        if (com.baidu.tbadk.core.m.qU().qY() && list != null && list.size() > 1) {
            daVar.aXZ.setVisibility(0);
            daVar.aYa.setVisibility(0);
            daVar.aYb.setVisibility(0);
            if (list.size() > 2) {
                daVar.aYc.setVisibility(0);
            } else {
                daVar.aYc.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            daVar.aYa.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), wVar.sd().total_poll.longValue());
                            break;
                        case 1:
                            daVar.aYb.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), wVar.sd().total_poll.longValue());
                            break;
                        case 2:
                            daVar.aYc.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), wVar.sd().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            daVar.aXZ.setVisibility(8);
        }
        if (wVar.sd().options_count.intValue() == 0) {
            daVar.aYd.setVisibility(8);
            daVar.aYe.setVisibility(8);
        } else {
            String string = this.aSe.getResources().getString(i.h.total_x_vote_option);
            daVar.aYd.setVisibility(0);
            daVar.aYd.setText(String.format(string, wVar.sd().options_count));
            if (StringUtils.isNull(wVar.sd().tips, true)) {
                daVar.aYe.setVisibility(8);
            } else {
                daVar.aYe.setVisibility(0);
                daVar.aYe.setText("(" + wVar.sd().tips + ")");
            }
        }
        daVar.apS = this.mSkinType;
        return view;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public da a(ViewGroup viewGroup) {
        return new da(LayoutInflater.from(this.mContext).inflate(i.g.frs_pic_vote_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, da daVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) daVar);
        return a(i, view, wVar, daVar);
    }
}
