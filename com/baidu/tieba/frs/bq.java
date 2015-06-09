package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bq extends av<com.baidu.tbadk.core.data.w, bv> implements View.OnClickListener {
    private boolean aKi;
    private FrsActivity aMl;
    private HashMap<Integer, Long> aOr;
    private boolean aOs;
    private int aOt;
    private int aOu;
    private int aOv;
    private com.baidu.adp.lib.e.b<bu> aOw;
    private com.baidu.tbadk.coreExtra.view.ad mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public bq(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aKi = false;
        this.aOs = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aOt = 0;
        this.aOu = 0;
        this.aOv = 0;
        this.aOw = new com.baidu.adp.lib.e.b<>(new br(this), 5, 0);
        this.mCardOnClickDispatch = new bs(this);
        this.aMl = frsActivity;
        this.aOr = new HashMap<>();
        this.aOt = com.baidu.adp.lib.util.n.d(this.aMl.getPageContext().getPageActivity(), com.baidu.tieba.o.ds18);
        this.aOu = com.baidu.adp.lib.util.n.d(this.aMl.getPageContext().getPageActivity(), com.baidu.tieba.o.ds18);
        this.aOv = com.baidu.adp.lib.util.n.d(this.aMl.getPageContext().getPageActivity(), com.baidu.tieba.o.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, bv bvVar) {
        boolean z;
        int i2;
        if (wVar != null && wVar.rA() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aOt, 0, this.aOu, 0);
            layoutParams.gravity = 1;
            bvVar.aKs.setLayoutParams(layoutParams);
            bvVar.aOz.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aOt, this.aOv, this.aOu, 0);
            layoutParams2.gravity = 1;
            bvVar.aKs.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.ay.i(bvVar.aOz, com.baidu.tieba.p.yangnian2);
            bvVar.aOz.setVisibility(0);
        }
        if (bvVar.ajy != this.mSkinType) {
            com.baidu.tbadk.core.util.ay.i(bvVar.aKs, com.baidu.tieba.p.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.ay.i((View) bvVar.aKG, com.baidu.tieba.p.frs_item_abstract_more_text_bg);
            this.aMl.getLayoutMode().ab(this.mSkinType == 1);
            this.aMl.getLayoutMode().j(view);
        }
        bvVar.aOA.setOnClickListener(this);
        bvVar.aKG.setOnClickListener(this);
        bvVar.aOA.setTag(Integer.valueOf(i));
        bvVar.aKG.setTag(Integer.valueOf(i));
        if (wVar != null && !wVar.rw() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            bvVar.aOC.setVisibility(0);
            bvVar.aOD.setVisibility(0);
            bvVar.aOC.setText(wVar.getAddress());
        } else {
            bvVar.aOC.setVisibility(8);
            bvVar.aOD.setVisibility(8);
        }
        bvVar.aKw.setText(com.baidu.tbadk.core.util.bb.o(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.n.qc().qe()) {
            bvVar.aKz.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            bvVar.aKz.setUserId(wVar.getAuthor().getUserId());
            bvVar.aKz.setImageDrawable(null);
            bvVar.aKz.c(portrait, 28, false);
        } else {
            bvVar.aKz.setVisibility(8);
        }
        bvVar.aKI.setOnClickListener(new bt(this, wVar));
        wVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            bvVar.aKy.setVisibility(0);
            com.baidu.tbadk.core.util.ay.b(bvVar.aKx, com.baidu.tieba.n.cp_cont_h, 1);
            bvVar.aKy.setTag(Integer.valueOf(i));
            bvVar.aKy.setOnClickListener(this);
            bvVar.aKy.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin));
        } else {
            bvVar.aKy.setVisibility(8);
            com.baidu.tbadk.core.util.ay.b(bvVar.aKx, com.baidu.tieba.n.cp_cont_c, 1);
        }
        bvVar.aKx.setText(wVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.rr() == 1) {
            bvVar.mTitle.setVisibility(8);
        } else {
            bvVar.mTitle.setVisibility(0);
            wVar.parser_title();
            bvVar.mTitle.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.jL(wVar.getId())) {
                com.baidu.tbadk.core.util.ay.b(bvVar.mTitle, com.baidu.tieba.n.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ay.b(bvVar.mTitle, com.baidu.tieba.n.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (wVar.rm() != null && wVar.rm().trim().length() > 0) {
            stringBuffer.append(wVar.rm());
        }
        ArrayList<MediaData> medias = wVar.getMedias();
        if (medias != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= medias.size()) {
                    break;
                }
                if (medias.get(i4).getVideoUrl() != null && medias.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(medias.get(i4).getVideoUrl());
                }
                i3 = i4 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    bvVar.aKG.setVisibility(0);
                    bvVar.aKt.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    bvVar.aKG.setVisibility(8);
                    bvVar.aKt.setText(stringBuffer.toString());
                }
                bvVar.aKt.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.jL(wVar.getId())) {
                    com.baidu.tbadk.core.util.ay.b(bvVar.aKt, com.baidu.tieba.n.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.ay.b(bvVar.aKt, com.baidu.tieba.n.cp_cont_b, 1);
                }
            } else {
                bvVar.aKG.setVisibility(8);
                bvVar.aKt.setVisibility(8);
            }
        }
        if (wVar.getAnchorInfoData() == null || !this.aOs || wVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aOr, wVar.getAnchorInfoData().getGroup_id(), wVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (bvVar.aOB == null) {
                bvVar.aOB = this.aOw.hj();
                bvVar.aKs.addView(bvVar.aOB.aKJ, bvVar.aKs.indexOfChild(bvVar.aKv) + 1);
            }
            i2 = bvVar.aOB.ajy;
            if (i2 != this.mSkinType) {
                this.aMl.getLayoutMode().ab(this.mSkinType == 1);
                this.aMl.getLayoutMode().j(bvVar.aOB.aKJ);
                bvVar.aOB.ajy = this.mSkinType;
            }
            bvVar.aKv.setVisibility(8);
            bvVar.aOB.aKJ.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(wVar.getAnchorInfoData().getAuthorId());
            liveCardData.setPublisherName(wVar.getAnchorInfoData().getAuthorName());
            liveCardData.setPublisherPortrait(wVar.getAnchorInfoData().getPublisherPortrait());
            liveCardData.setGroupId(wVar.getAnchorInfoData().getGroup_id());
            liveCardData.setIntro(wVar.getAnchorInfoData().getIntro());
            liveCardData.setLikers(wVar.getAnchorInfoData().getLikers());
            liveCardData.setListeners(wVar.getAnchorInfoData().getListeners());
            liveCardData.setName(wVar.getAnchorInfoData().getName());
            liveCardData.setPortrait(wVar.getAnchorInfoData().getPortrait());
            liveCardData.setStatus(wVar.getAnchorInfoData().getStatus());
            liveCardData.setStartTime(wVar.getAnchorInfoData().getStartTime());
            liveCardData.setIsVip(wVar.getAnchorInfoData().getIsVip());
            bvVar.aOB.aKK.setData(liveCardData);
            bvVar.aOB.aKK.setStatisticsKey("notice_frs_live");
            if (!bvVar.aOB.aKK.hasCardOnClickDispatch()) {
                bvVar.aOB.aKK.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (bvVar.aOB != null) {
            this.aOw.j(bvVar.aOB);
            bvVar.aKs.removeView(bvVar.aOB.aKJ);
            bvVar.aOB = null;
        }
        if (com.baidu.tbadk.core.n.qc().qg() && medias != null && medias.size() > 0 && !z) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = i5;
                if (i8 >= medias.size()) {
                    break;
                }
                if (medias.get(i8) != null && (medias.get(i8).getType() == 3 || medias.get(i8).getType() == 5)) {
                    i6++;
                    i7++;
                }
                i5 = i8 + 1;
            }
            if (i6 > 0) {
                MediaData[] mediaDataArr = new MediaData[i6];
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    int i11 = i9;
                    int i12 = i10;
                    if (i11 >= medias.size() || i12 >= i6) {
                        break;
                    }
                    if (medias.get(i11).getType() == 3 || medias.get(i11).getType() == 5) {
                        mediaDataArr[i12] = medias.get(i11);
                        i10 = i12 + 1;
                    } else {
                        i10 = i12;
                    }
                    i9 = i11 + 1;
                }
                bvVar.aKv.setVisibility(0);
                bvVar.aKv.a(wVar, this.aLm.aas().getName(), this.aLm.aas().getId(), wVar.getTid());
                bvVar.aKv.setShowBig(this.aKi);
                bvVar.aKv.setDrawNum(true);
                bvVar.aKv.setFromCDN(this.mIsFromCDN);
                bvVar.aKv.a(this.aMl.getPageContext(), mediaDataArr, i7);
                bvVar.aKv.setImageFrom("other");
            } else {
                bvVar.aKv.setVisibility(8);
            }
        } else {
            bvVar.aKv.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> rq = wVar.rq();
        if (rq != null && rq.size() > 0) {
            bvVar.aKu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rq.get(0);
            bvVar.aKu.setVoiceModel(voiceModel);
            bvVar.aKu.setTag(voiceModel);
            bvVar.aKu.adB();
            if (voiceModel != null) {
                bvVar.aKu.gK(voiceModel.voice_status.intValue());
            }
        } else {
            bvVar.aKu.setVisibility(8);
        }
        if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
            bvVar.aKC.setVisibility(0);
            bvVar.aKC.setText(com.baidu.tbadk.core.util.bb.q(wVar.getPraise().getNum()));
        } else {
            bvVar.aKC.setVisibility(8);
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            bvVar.aKE.setVisibility(0);
            bvVar.aKE.setText(com.baidu.tbadk.core.util.bb.q(reply_num));
        } else {
            bvVar.aKE.setVisibility(8);
        }
        if (wVar.rw()) {
            bvVar.mTitle.setMaxLines(2);
            bvVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.rv() == 1) {
                if (wVar.rp().get(0).getStatus() == 1) {
                    bvVar.aOA.setText(this.mContext.getResources().getString(com.baidu.tieba.t.i_want_lottery));
                    bvVar.aOA.setVisibility(0);
                } else {
                    bvVar.aOA.setVisibility(8);
                }
            } else if (wVar.rv() == 2) {
                if (wVar.rp().get(0).getStatus() == 1) {
                    bvVar.aOA.setText(this.mContext.getResources().getString(com.baidu.tieba.t.i_want_share_picture));
                    bvVar.aOA.setVisibility(0);
                } else {
                    bvVar.aOA.setVisibility(8);
                }
            } else {
                bvVar.aOA.setVisibility(8);
                bvVar.mTitle.setMaxLines(Integer.MAX_VALUE);
                bvVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            bvVar.aOA.setVisibility(8);
        }
        bvVar.ajy = this.mSkinType;
        return view;
    }

    public void bP(boolean z) {
        if (this.aKi != z) {
            this.aKi = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMU != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.ai ay = ay(intValue);
                if (ay instanceof com.baidu.tbadk.core.data.w) {
                    View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
                    this.aMU.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) ay);
                }
            }
        }
    }

    public int Kh() {
        return com.baidu.tieba.q.frs_more_abstract;
    }

    public int KU() {
        return com.baidu.tieba.q.action_button;
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
    /* renamed from: h */
    public bv a(ViewGroup viewGroup) {
        this.mListView = (ListView) viewGroup;
        return new bv(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_item, null), this.aKl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, bv bvVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) bvVar);
        return a(i, view, wVar, bvVar);
    }

    public int KW() {
        return com.baidu.tieba.q.frs_user_tshow_icon_box;
    }
}
