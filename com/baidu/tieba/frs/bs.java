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
public class bs extends av<com.baidu.tbadk.core.data.w, bw> implements View.OnClickListener {
    private boolean aHR;
    private FrsActivity aJT;
    private HashMap<Integer, Long> aLV;
    private boolean aLW;
    private int aLX;
    private int aLY;
    private int aLZ;
    private com.baidu.adp.lib.e.b<bv> aMa;

    /* JADX INFO: Access modifiers changed from: protected */
    public bs(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aHR = false;
        this.aLW = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aLX = 0;
        this.aLY = 0;
        this.aLZ = 0;
        this.aMa = new com.baidu.adp.lib.e.b<>(new bt(this), 5, 0);
        this.aJT = frsActivity;
        this.aLV = new HashMap<>();
        this.aLX = com.baidu.adp.lib.util.n.d(this.aJT.getPageContext().getPageActivity(), com.baidu.tieba.t.ds18);
        this.aLY = com.baidu.adp.lib.util.n.d(this.aJT.getPageContext().getPageActivity(), com.baidu.tieba.t.ds18);
        this.aLZ = com.baidu.adp.lib.util.n.d(this.aJT.getPageContext().getPageActivity(), com.baidu.tieba.t.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, bw bwVar) {
        boolean z;
        int i2;
        if (wVar != null && wVar.qU() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aLX, 0, this.aLY, 0);
            layoutParams.gravity = 1;
            bwVar.aIb.setLayoutParams(layoutParams);
            bwVar.aMd.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aLX, this.aLZ, this.aLY, 0);
            layoutParams2.gravity = 1;
            bwVar.aIb.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.ba.i(bwVar.aMd, com.baidu.tieba.u.yangnian2);
            bwVar.aMd.setVisibility(0);
        }
        if (bwVar.aiq != this.mSkinType) {
            com.baidu.tbadk.core.util.ba.i(bwVar.aIb, com.baidu.tieba.u.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.ba.i((View) bwVar.aIp, com.baidu.tieba.u.frs_item_abstract_more_text_bg);
            this.aJT.getLayoutMode().X(this.mSkinType == 1);
            this.aJT.getLayoutMode().h(view);
        }
        bwVar.aMe.setOnClickListener(this);
        bwVar.aIp.setOnClickListener(this);
        bwVar.aMe.setTag(Integer.valueOf(i));
        bwVar.aIp.setTag(Integer.valueOf(i));
        if (wVar != null && !wVar.qQ() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            bwVar.aMg.setVisibility(0);
            bwVar.aMh.setVisibility(0);
            bwVar.aMg.setText(wVar.getAddress());
        } else {
            bwVar.aMg.setVisibility(8);
            bwVar.aMh.setVisibility(8);
        }
        bwVar.aIf.setText(com.baidu.tbadk.core.util.bd.n(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.n.px().pz()) {
            bwVar.aIi.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            bwVar.aIi.setUserId(wVar.getAuthor().getUserId());
            bwVar.aIi.setImageDrawable(null);
            bwVar.aIi.c(portrait, 28, false);
        } else {
            bwVar.aIi.setVisibility(8);
        }
        bwVar.aIr.setOnClickListener(new bu(this, wVar));
        wVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            bwVar.aIh.setVisibility(0);
            com.baidu.tbadk.core.util.ba.b(bwVar.aIg, com.baidu.tieba.s.cp_cont_h, 1);
            bwVar.aIh.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            bwVar.aIh.setVisibility(8);
            com.baidu.tbadk.core.util.ba.b(bwVar.aIg, com.baidu.tieba.s.cp_cont_c, 1);
        }
        bwVar.aIg.setText(wVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.qL() == 1) {
            bwVar.mTitle.setVisibility(8);
        } else {
            bwVar.mTitle.setVisibility(0);
            wVar.parser_title();
            bwVar.mTitle.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.iO(wVar.getId())) {
                com.baidu.tbadk.core.util.ba.b(bwVar.mTitle, com.baidu.tieba.s.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ba.b(bwVar.mTitle, com.baidu.tieba.s.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (wVar.qG() != null && wVar.qG().trim().length() > 0) {
            stringBuffer.append(wVar.qG());
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
                    bwVar.aIp.setVisibility(0);
                    bwVar.aIc.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    bwVar.aIp.setVisibility(8);
                    bwVar.aIc.setText(stringBuffer.toString());
                }
                bwVar.aIc.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.iO(wVar.getId())) {
                    com.baidu.tbadk.core.util.ba.b(bwVar.aIc, com.baidu.tieba.s.cp_cont_c, 1);
                }
            } else {
                bwVar.aIp.setVisibility(8);
                bwVar.aIc.setVisibility(8);
            }
        }
        if (wVar.getAnchorInfoData() == null || !this.aLW || wVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aLV, wVar.getAnchorInfoData().getGroup_id(), wVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (bwVar.aMf == null) {
                bwVar.aMf = this.aMa.hz();
                bwVar.aIb.addView(bwVar.aMf.aIs, bwVar.aIb.indexOfChild(bwVar.aIe) + 1);
            }
            i2 = bwVar.aMf.aiq;
            if (i2 != this.mSkinType) {
                this.aJT.getLayoutMode().X(this.mSkinType == 1);
                this.aJT.getLayoutMode().h(bwVar.aMf.aIs);
                bwVar.aMf.aiq = this.mSkinType;
            }
            bwVar.aIe.setVisibility(8);
            bwVar.aMf.aIs.setVisibility(0);
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
            bwVar.aMf.aIt.setData(liveCardData);
            bwVar.aMf.aIt.setStatisticsKey("notice_frs_live");
        } else if (bwVar.aMf != null) {
            this.aMa.j(bwVar.aMf);
            bwVar.aIb.removeView(bwVar.aMf.aIs);
            bwVar.aMf = null;
        }
        if (com.baidu.tbadk.core.n.px().pB() && medias != null && medias.size() > 0 && !z) {
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
                bwVar.aIe.setVisibility(0);
                bwVar.aIe.a(wVar, this.aIV.YO().getName(), this.aIV.YO().getId(), wVar.getTid());
                bwVar.aIe.setShowBig(this.aHR);
                bwVar.aIe.setDrawNum(true);
                bwVar.aIe.setFromCDN(this.mIsFromCDN);
                bwVar.aIe.a(this.aJT.getPageContext(), mediaDataArr, i7);
                bwVar.aIe.setImageFrom("other");
            } else {
                bwVar.aIe.setVisibility(8);
            }
        } else {
            bwVar.aIe.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> qK = wVar.qK();
        if (qK != null && qK.size() > 0) {
            bwVar.aId.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qK.get(0);
            bwVar.aId.setVoiceModel(voiceModel);
            bwVar.aId.setTag(voiceModel);
            bwVar.aId.abN();
            if (voiceModel != null) {
                bwVar.aId.gr(voiceModel.voice_status.intValue());
            }
        } else {
            bwVar.aId.setVisibility(8);
        }
        if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
            bwVar.aIl.setVisibility(0);
            bwVar.aIl.setText(com.baidu.tbadk.core.util.bd.p(wVar.getPraise().getNum()));
        } else {
            bwVar.aIl.setVisibility(8);
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            bwVar.aIn.setVisibility(0);
            bwVar.aIn.setText(com.baidu.tbadk.core.util.bd.p(reply_num));
        } else {
            bwVar.aIn.setVisibility(8);
        }
        if (wVar.qQ()) {
            bwVar.mTitle.setMaxLines(2);
            bwVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.qP() == 1) {
                if (wVar.qJ().get(0).getStatus() == 1) {
                    bwVar.aMe.setText(this.mContext.getResources().getString(com.baidu.tieba.y.i_want_lottery));
                    bwVar.aMe.setVisibility(0);
                } else {
                    bwVar.aMe.setVisibility(8);
                }
            } else if (wVar.qP() == 2) {
                if (wVar.qJ().get(0).getStatus() == 1) {
                    bwVar.aMe.setText(this.mContext.getResources().getString(com.baidu.tieba.y.i_want_share_picture));
                    bwVar.aMe.setVisibility(0);
                } else {
                    bwVar.aMe.setVisibility(8);
                }
            } else {
                bwVar.aMe.setVisibility(8);
                bwVar.mTitle.setMaxLines(Integer.MAX_VALUE);
                bwVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            bwVar.aMe.setVisibility(8);
        }
        bwVar.aiq = this.mSkinType;
        return view;
    }

    public void bG(boolean z) {
        if (this.aHR != z) {
            this.aHR = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aKC != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.ai aA = aA(intValue);
                if (aA instanceof com.baidu.tbadk.core.data.w) {
                    View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
                    this.aKC.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA);
                }
            }
        }
    }

    public int IX() {
        return com.baidu.tieba.v.frs_more_abstract;
    }

    public int JI() {
        return com.baidu.tieba.v.action_button;
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
    public bw a(ViewGroup viewGroup) {
        this.mListView = (ListView) viewGroup;
        return new bw(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_item, null), this.aHU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, bw bwVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) bwVar);
        return a(i, view, wVar, bwVar);
    }
}
