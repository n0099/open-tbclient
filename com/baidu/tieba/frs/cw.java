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
    private boolean aSX;
    private BaseActivity aSm;
    private boolean aXt;
    private View.OnClickListener aXx;

    /* JADX INFO: Access modifiers changed from: protected */
    public cw(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aSX = false;
        this.aXt = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXx = new cx(this);
        this.aSm = baseActivity;
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, da daVar) {
        if (wVar == null || wVar.sg() == null) {
            return null;
        }
        if (daVar.arf != this.mSkinType) {
            daVar.aYj.setGrade(com.baidu.tbadk.core.util.an.getDrawable(i.e.pic_grade_vote_no1));
            daVar.aYk.setGrade(com.baidu.tbadk.core.util.an.getDrawable(i.e.pic_grade_vote_no2));
            daVar.aYl.setGrade(com.baidu.tbadk.core.util.an.getDrawable(i.e.pic_grade_vote_no3));
            daVar.aYj.onChangeSkinType(this.mSkinType);
            daVar.aYk.onChangeSkinType(this.mSkinType);
            daVar.aYl.onChangeSkinType(this.mSkinType);
            daVar.aYh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            daVar.aTw.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.an.h((View) daVar.aYh, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.h((View) daVar.aTw, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.h((View) daVar.aTo, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.j(daVar.aXG, i.c.cp_bg_line_c);
            com.baidu.tbadk.core.util.an.h((View) daVar.aXF, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.an.h((View) daVar.aYm, i.c.cp_cont_c);
            com.baidu.tbadk.core.util.an.h((View) daVar.aYn, i.c.cp_cont_c);
            com.baidu.tbadk.core.util.an.i(daVar.aTk, i.e.frs_item_control_btn_bg);
        }
        if (wVar != null && !wVar.sy() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            daVar.aXF.setVisibility(0);
            daVar.aXG.setVisibility(0);
            daVar.aXF.setText(wVar.getAddress());
        } else {
            daVar.aXF.setVisibility(8);
            daVar.aXG.setVisibility(8);
        }
        daVar.aTo.setText(com.baidu.tbadk.core.util.as.m(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qV().qX()) {
            daVar.aTr.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            daVar.aTr.setUserId(wVar.getAuthor().getUserId());
            daVar.aTr.setImageDrawable(null);
            daVar.aTr.d(portrait, 28, false);
        } else {
            daVar.aTr.setVisibility(8);
        }
        daVar.aTr.setOnClickListener(new cy(this, wVar));
        daVar.aTA.setOnClickListener(new cz(this, wVar));
        ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            daVar.aXC.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(daVar.aTp, i.c.cp_cont_h, 1);
            daVar.aXC.setTag(Integer.valueOf(i));
            daVar.aXC.setOnClickListener(this);
            daVar.aXC.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            daVar.aXC.setOnClickListener(this.aXx);
        } else {
            daVar.aXC.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(daVar.aTp, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            daVar.aTq.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(daVar.aTp, i.c.cp_cont_h, 1);
            daVar.aTq.setTag(Integer.valueOf(i));
            daVar.aTq.setOnClickListener(this);
            daVar.aTq.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            daVar.aTq.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(daVar.aTp, i.c.cp_cont_c, 1);
        }
        daVar.aTp.setText(wVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.sr() == 1) {
            daVar.aPy.setVisibility(8);
        } else {
            daVar.aPy.setVisibility(0);
            wVar.parser_title();
            daVar.aPy.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(daVar.aPy, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(daVar.aPy, i.c.cp_cont_b, 1);
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
                    daVar.aTl.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    daVar.aTl.setText(stringBuffer.toString());
                }
                daVar.aTl.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                    com.baidu.tbadk.core.util.an.b(daVar.aTl, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(daVar.aTl, i.c.cp_cont_b, 1);
                }
            } else {
                daVar.aTl.setVisibility(8);
            }
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            daVar.aTw.setVisibility(0);
            daVar.aTw.setText(com.baidu.tbadk.core.util.as.o(reply_num));
        } else {
            daVar.aTw.setVisibility(8);
        }
        long longValue = wVar.sg().total_num.longValue();
        if (longValue > 0) {
            daVar.aYh.setVisibility(0);
            daVar.aYh.setText(com.baidu.tbadk.core.util.as.o(longValue));
        } else {
            daVar.aYh.setVisibility(8);
        }
        List<PollOption> list = wVar.sg().options;
        if (com.baidu.tbadk.core.m.qV().qZ() && list != null && list.size() > 1) {
            daVar.aYi.setVisibility(0);
            daVar.aYj.setVisibility(0);
            daVar.aYk.setVisibility(0);
            if (list.size() > 2) {
                daVar.aYl.setVisibility(0);
            } else {
                daVar.aYl.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            daVar.aYj.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), wVar.sg().total_poll.longValue());
                            break;
                        case 1:
                            daVar.aYk.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), wVar.sg().total_poll.longValue());
                            break;
                        case 2:
                            daVar.aYl.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), wVar.sg().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            daVar.aYi.setVisibility(8);
        }
        if (wVar.sg().options_count.intValue() == 0) {
            daVar.aYm.setVisibility(8);
            daVar.aYn.setVisibility(8);
        } else {
            String string = this.aSm.getResources().getString(i.h.total_x_vote_option);
            daVar.aYm.setVisibility(0);
            daVar.aYm.setText(String.format(string, wVar.sg().options_count));
            if (StringUtils.isNull(wVar.sg().tips, true)) {
                daVar.aYn.setVisibility(8);
            } else {
                daVar.aYn.setVisibility(0);
                daVar.aYn.setText("(" + wVar.sg().tips + ")");
            }
        }
        daVar.arf = this.mSkinType;
        return view;
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
