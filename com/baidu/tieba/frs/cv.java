package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class cv extends bm<com.baidu.tbadk.core.data.z, db> implements View.OnClickListener {
    private BaseActivity aXA;
    private boolean aYl;
    private HashMap<Integer, Long> bdq;
    private boolean bdr;
    private int bds;
    private int bdt;
    private int bdu;
    private View.OnClickListener bdv;
    private com.baidu.adp.lib.f.b<a> bdw;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public cv(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYl = false;
        this.bdr = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.bds = 0;
        this.bdt = 0;
        this.bdu = 0;
        this.bdv = new cw(this);
        this.bdw = new com.baidu.adp.lib.f.b<>(new cx(this), 5, 0);
        this.mCardOnClickDispatch = new cy(this);
        this.aXA = baseActivity;
        this.bdq = new HashMap<>();
        this.bds = 0;
        this.bdt = 0;
        this.bdu = com.baidu.adp.lib.util.k.d(this.aXA.getPageContext().getPageActivity(), n.d.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.z zVar, db dbVar) {
        boolean z;
        if (zVar == null) {
            return null;
        }
        if (zVar != null && zVar.tg() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.bds, 0, this.bdt, 0);
            layoutParams.gravity = 1;
            dbVar.aYy.setLayoutParams(layoutParams);
            dbVar.bdz.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.bds, this.bdu, this.bdt, 0);
            layoutParams2.gravity = 1;
            dbVar.aYy.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.as.i(dbVar.bdz, n.e.yangnian2);
            dbVar.bdz.setVisibility(0);
        }
        bx.a(this.aXA, dbVar.bdy, dbVar.aYF, dbVar.aYD, dbVar.bdD, dbVar.bdE, dbVar.bdC, view, zVar, this.mSkinType, new cz(this, zVar));
        if (dbVar.afY != this.mSkinType) {
            com.baidu.tbadk.core.util.as.i(dbVar.aYy, n.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.as.i((View) dbVar.aYM, n.e.frs_item_abstract_more_text_bg);
            this.aXA.getLayoutMode().af(this.mSkinType == 1);
            this.aXA.getLayoutMode().k(view);
        }
        dbVar.bdB.setOnClickListener(this);
        dbVar.aYM.setOnClickListener(this);
        dbVar.bdB.setTag(Integer.valueOf(i));
        dbVar.aYM.setTag(Integer.valueOf(i));
        if (zVar != null && !zVar.sZ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
            dbVar.bck.setVisibility(0);
            dbVar.bcl.setVisibility(0);
            dbVar.bck.setText(zVar.getAddress());
        } else {
            dbVar.bck.setVisibility(8);
            dbVar.bcl.setVisibility(8);
        }
        dbVar.aYC.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.rh().rj()) {
            dbVar.aYF.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            dbVar.aYF.setUserId(zVar.getAuthor().getUserId());
            dbVar.aYF.setImageDrawable(null);
            dbVar.aYF.d(portrait, 28, false);
        } else {
            dbVar.aYF.setVisibility(8);
        }
        dbVar.aYF.setOnClickListener(new da(this, zVar));
        ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dbVar.bdA.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(dbVar.aYD, n.c.cp_cont_h, 1);
            dbVar.bdA.setTag(Integer.valueOf(i));
            dbVar.bdA.setOnClickListener(this);
            dbVar.bdA.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds10), true);
            dbVar.bdA.setOnClickListener(this.bdv);
        } else {
            dbVar.bdA.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(dbVar.aYD, n.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dbVar.aYE.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(dbVar.aYD, n.c.cp_cont_h, 1);
            dbVar.aYE.setTag(Integer.valueOf(i));
            dbVar.aYE.setOnClickListener(this);
            dbVar.aYE.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.d.ds36), this.mContext.getResources().getDimensionPixelSize(n.d.ds36), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
        } else {
            dbVar.aYE.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(dbVar.aYD, n.c.cp_cont_c, 1);
        }
        dbVar.aYD.setText(zVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (zVar.sS() == 1) {
            dbVar.aUB.setVisibility(8);
        } else {
            dbVar.aUB.setVisibility(0);
            zVar.parser_title();
            dbVar.aUB.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(dbVar.aUB, n.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(dbVar.aUB, n.c.cp_cont_b, 1);
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
                    dbVar.aYM.setVisibility(0);
                    dbVar.aYz.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dbVar.aYM.setVisibility(8);
                    dbVar.aYz.setText(stringBuffer.toString());
                }
                dbVar.aYz.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                    com.baidu.tbadk.core.util.as.b(dbVar.aYz, n.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(dbVar.aYz, n.c.cp_cont_b, 1);
                }
            } else {
                dbVar.aYM.setVisibility(8);
                dbVar.aYz.setVisibility(8);
            }
        }
        if (zVar.getAnchorInfoData() == null || !this.bdr || zVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.bdq, zVar.getAnchorInfoData().getGroup_id(), zVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (dbVar.bdF == null) {
                dbVar.bdF = this.bdw.hb();
                dbVar.aYy.addView(dbVar.bdF.aYP, dbVar.aYy.indexOfChild(dbVar.aYB) + 1);
            }
            if (dbVar.bdF.afY != this.mSkinType) {
                this.aXA.getLayoutMode().af(this.mSkinType == 1);
                this.aXA.getLayoutMode().k(dbVar.bdF.aYP);
                dbVar.bdF.afY = this.mSkinType;
            }
            dbVar.aYB.setVisibility(8);
            dbVar.bdF.aYP.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(zVar.getAnchorInfoData().getAuthorId());
            liveCardData.setPublisherName(zVar.getAnchorInfoData().getAuthorName());
            liveCardData.setPublisherPortrait(zVar.getAnchorInfoData().getPublisherPortrait());
            liveCardData.setGroupId(zVar.getAnchorInfoData().getGroup_id());
            liveCardData.setIntro(zVar.getAnchorInfoData().getIntro());
            liveCardData.setLikers(zVar.getAnchorInfoData().getLikers());
            liveCardData.setListeners(zVar.getAnchorInfoData().getListeners());
            liveCardData.setName(zVar.getAnchorInfoData().getName());
            liveCardData.setPortrait(zVar.getAnchorInfoData().getPortrait());
            liveCardData.setStatus(zVar.getAnchorInfoData().getStatus());
            liveCardData.setStartTime(zVar.getAnchorInfoData().getStartTime());
            liveCardData.setIsVip(zVar.getAnchorInfoData().getIsVip());
            dbVar.bdF.aYQ.setData(liveCardData);
            dbVar.bdF.aYQ.setStatisticsKey("notice_frs_live");
            if (!dbVar.bdF.aYQ.hasCardOnClickDispatch()) {
                dbVar.bdF.aYQ.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (dbVar.bdF != null) {
            this.bdw.k(dbVar.bdF);
            dbVar.aYy.removeView(dbVar.bdF.aYP);
            dbVar.bdF = null;
        }
        if (com.baidu.tbadk.core.m.rh().rn() && medias != null && medias.size() > 0 && !z) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i4;
                if (i7 >= medias.size()) {
                    break;
                }
                if (medias.get(i7) != null && (medias.get(i7).getType() == 3 || medias.get(i7).getType() == 5)) {
                    i5++;
                    i6++;
                }
                i4 = i7 + 1;
            }
            if (i5 > 0) {
                MediaData[] mediaDataArr = new MediaData[i5];
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    int i10 = i8;
                    int i11 = i9;
                    if (i10 >= medias.size() || i11 >= i5) {
                        break;
                    }
                    if (medias.get(i10).getType() == 3 || medias.get(i10).getType() == 5) {
                        mediaDataArr[i11] = medias.get(i10);
                        i9 = i11 + 1;
                    } else {
                        i9 = i11;
                    }
                    i8 = i10 + 1;
                }
                dbVar.aYB.setVisibility(0);
                dbVar.aYB.a(zVar, this.aZs.ajy().getName(), this.aZs.ajy().getId(), zVar.getTid());
                dbVar.aYB.setShowBig(this.aYl);
                dbVar.aYB.setDrawNum(true);
                dbVar.aYB.setFromCDN(this.mIsFromCDN);
                dbVar.aYB.a(this.aXA.getPageContext(), mediaDataArr, i6);
                dbVar.aYB.setImageFrom("other");
            } else {
                dbVar.aYB.setVisibility(8);
            }
        } else {
            dbVar.aYB.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> sR = zVar.sR();
        if (sR != null && sR.size() > 0) {
            dbVar.aYA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sR.get(0);
            dbVar.aYA.setVoiceModel(voiceModel);
            dbVar.aYA.setTag(voiceModel);
            dbVar.aYA.aEj();
            if (voiceModel != null) {
                dbVar.aYA.iF(voiceModel.voice_status.intValue());
            }
        } else {
            dbVar.aYA.setVisibility(8);
        }
        if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
            dbVar.aYI.setVisibility(0);
            dbVar.aYI.setText(com.baidu.tbadk.core.util.ax.w(zVar.getPraise().getNum()));
        } else {
            dbVar.aYI.setVisibility(8);
        }
        int reply_num = zVar.getReply_num();
        if (reply_num > 0) {
            dbVar.aYK.setVisibility(0);
            dbVar.aYK.setText(com.baidu.tbadk.core.util.ax.w(reply_num));
        } else {
            dbVar.aYK.setVisibility(8);
        }
        if (zVar.sZ()) {
            dbVar.aUB.setMaxLines(2);
            dbVar.aUB.setEllipsize(TextUtils.TruncateAt.END);
            if (zVar.sY() == 1) {
                if (zVar.sQ().get(0).getStatus() == 1) {
                    dbVar.bdB.setText(this.mContext.getResources().getString(n.i.i_want_lottery));
                    dbVar.bdB.setVisibility(0);
                } else {
                    dbVar.bdB.setVisibility(8);
                }
            } else if (zVar.sY() == 2) {
                if (zVar.sQ().get(0).getStatus() == 1) {
                    dbVar.bdB.setText(this.mContext.getResources().getString(n.i.i_want_share_picture));
                    dbVar.bdB.setVisibility(0);
                } else {
                    dbVar.bdB.setVisibility(8);
                }
            } else {
                dbVar.bdB.setVisibility(8);
                dbVar.aUB.setMaxLines(Integer.MAX_VALUE);
                dbVar.aUB.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            dbVar.bdB.setVisibility(8);
        }
        dbVar.afY = this.mSkinType;
        return view;
    }

    public void ck(boolean z) {
        if (this.aYl != z) {
            this.aYl = z;
        }
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

    public int Mx() {
        return n.f.frs_more_abstract;
    }

    public int Ng() {
        return n.f.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout aYP;
        public LiveBroadcastCard aYQ;
        private int afY = 3;

        public a() {
        }
    }

    public boolean a(HashMap<Integer, Long> hashMap, int i, long j) {
        if (hashMap == null) {
            return true;
        }
        long j2 = 0;
        Long l = hashMap.get(Integer.valueOf(i));
        if (l != null) {
            j2 = l.longValue();
        }
        if (j >= j2) {
            hashMap.put(Integer.valueOf(i), Long.valueOf(j));
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public db a(ViewGroup viewGroup) {
        this.aYr = (ListView) viewGroup;
        return new db(LayoutInflater.from(this.mContext).inflate(n.g.frs_item, (ViewGroup) null), this.aYo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, db dbVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) dbVar);
        return a(i, view, zVar, dbVar);
    }

    public int Ni() {
        return n.f.frs_user_tshow_icon_box;
    }
}
