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
public class cw extends bn<com.baidu.tbadk.core.data.v, da> implements View.OnClickListener {
    private BaseActivity aRT;
    private boolean aSE;
    private boolean aWZ;
    private View.OnClickListener aXd;

    /* JADX INFO: Access modifiers changed from: protected */
    public cw(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aSE = false;
        this.aWZ = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXd = new cx(this);
        this.aRT = baseActivity;
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.v vVar, da daVar) {
        if (vVar == null || vVar.sg() == null) {
            return null;
        }
        if (daVar.apR != this.mSkinType) {
            daVar.aXP.setGrade(com.baidu.tbadk.core.util.am.getDrawable(i.e.pic_grade_vote_no1));
            daVar.aXQ.setGrade(com.baidu.tbadk.core.util.am.getDrawable(i.e.pic_grade_vote_no2));
            daVar.aXR.setGrade(com.baidu.tbadk.core.util.am.getDrawable(i.e.pic_grade_vote_no3));
            daVar.aXP.onChangeSkinType(this.mSkinType);
            daVar.aXQ.onChangeSkinType(this.mSkinType);
            daVar.aXR.onChangeSkinType(this.mSkinType);
            daVar.aXN.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            daVar.aTd.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.am.h((View) daVar.aXN, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.am.h((View) daVar.aTd, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.am.h((View) daVar.aSV, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.am.j(daVar.aXm, i.c.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.h((View) daVar.aXl, i.c.cp_cont_d);
            com.baidu.tbadk.core.util.am.h((View) daVar.aXS, i.c.cp_cont_c);
            com.baidu.tbadk.core.util.am.h((View) daVar.aXT, i.c.cp_cont_c);
            com.baidu.tbadk.core.util.am.i(daVar.aSR, i.e.frs_item_control_btn_bg);
        }
        if (vVar != null && !vVar.sy() && !TextUtils.isEmpty(vVar.getAddress()) && !TextUtils.isEmpty(vVar.getAddress().trim())) {
            daVar.aXl.setVisibility(0);
            daVar.aXm.setVisibility(0);
            daVar.aXl.setText(vVar.getAddress());
        } else {
            daVar.aXl.setVisibility(8);
            daVar.aXm.setVisibility(8);
        }
        daVar.aSV.setText(com.baidu.tbadk.core.util.ar.o(vVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qX().qZ()) {
            daVar.aSY.setVisibility(0);
            String portrait = vVar.getAuthor().getPortrait();
            daVar.aSY.setUserId(vVar.getAuthor().getUserId());
            daVar.aSY.setImageDrawable(null);
            daVar.aSY.d(portrait, 28, false);
        } else {
            daVar.aSY.setVisibility(8);
        }
        daVar.aSY.setOnClickListener(new cy(this, vVar));
        daVar.aTh.setOnClickListener(new cz(this, vVar));
        ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            daVar.aXi.setVisibility(0);
            com.baidu.tbadk.core.util.am.b(daVar.aSW, i.c.cp_cont_h, 1);
            daVar.aXi.setTag(Integer.valueOf(i));
            daVar.aXi.setOnClickListener(this);
            daVar.aXi.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            daVar.aXi.setOnClickListener(this.aXd);
        } else {
            daVar.aXi.setVisibility(8);
            com.baidu.tbadk.core.util.am.b(daVar.aSW, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            daVar.aSX.setVisibility(0);
            com.baidu.tbadk.core.util.am.b(daVar.aSW, i.c.cp_cont_h, 1);
            daVar.aSX.setTag(Integer.valueOf(i));
            daVar.aSX.setOnClickListener(this);
            daVar.aSX.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            daVar.aSX.setVisibility(8);
            com.baidu.tbadk.core.util.am.b(daVar.aSW, i.c.cp_cont_c, 1);
        }
        daVar.aSW.setText(vVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (vVar.sr() == 1) {
            daVar.aPf.setVisibility(8);
        } else {
            daVar.aPf.setVisibility(0);
            vVar.parser_title();
            daVar.aPf.setText(vVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                com.baidu.tbadk.core.util.am.b(daVar.aPf, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.am.b(daVar.aPf, i.c.cp_cont_b, 1);
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
                    daVar.aSS.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    daVar.aSS.setText(stringBuffer.toString());
                }
                daVar.aSS.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                    com.baidu.tbadk.core.util.am.b(daVar.aSS, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.am.b(daVar.aSS, i.c.cp_cont_b, 1);
                }
            } else {
                daVar.aSS.setVisibility(8);
            }
        }
        int reply_num = vVar.getReply_num();
        if (reply_num > 0) {
            daVar.aTd.setVisibility(0);
            daVar.aTd.setText(com.baidu.tbadk.core.util.ar.q(reply_num));
        } else {
            daVar.aTd.setVisibility(8);
        }
        long longValue = vVar.sg().total_num.longValue();
        if (longValue > 0) {
            daVar.aXN.setVisibility(0);
            daVar.aXN.setText(com.baidu.tbadk.core.util.ar.q(longValue));
        } else {
            daVar.aXN.setVisibility(8);
        }
        List<PollOption> list = vVar.sg().options;
        if (com.baidu.tbadk.core.m.qX().rb() && list != null && list.size() > 1) {
            daVar.aXO.setVisibility(0);
            daVar.aXP.setVisibility(0);
            daVar.aXQ.setVisibility(0);
            if (list.size() > 2) {
                daVar.aXR.setVisibility(0);
            } else {
                daVar.aXR.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            daVar.aXP.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), vVar.sg().total_poll.longValue());
                            break;
                        case 1:
                            daVar.aXQ.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), vVar.sg().total_poll.longValue());
                            break;
                        case 2:
                            daVar.aXR.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), vVar.sg().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            daVar.aXO.setVisibility(8);
        }
        if (vVar.sg().options_count.intValue() == 0) {
            daVar.aXS.setVisibility(8);
            daVar.aXT.setVisibility(8);
        } else {
            String string = this.aRT.getResources().getString(i.h.total_x_vote_option);
            daVar.aXS.setVisibility(0);
            daVar.aXS.setText(String.format(string, vVar.sg().options_count));
            if (StringUtils.isNull(vVar.sg().tips, true)) {
                daVar.aXT.setVisibility(8);
            } else {
                daVar.aXT.setVisibility(0);
                daVar.aXT.setText("(" + vVar.sg().tips + ")");
            }
        }
        daVar.apR = this.mSkinType;
        return view;
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, da daVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) daVar);
        return a(i, view, vVar, daVar);
    }
}
