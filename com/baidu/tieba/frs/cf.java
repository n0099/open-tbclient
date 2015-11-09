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
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class cf extends bn<com.baidu.tbadk.core.data.w, cl> implements View.OnClickListener {
    private boolean aSX;
    private BaseActivity aSm;
    private HashMap<Integer, Long> aXs;
    private boolean aXt;
    private int aXu;
    private int aXv;
    private int aXw;
    private View.OnClickListener aXx;
    private com.baidu.adp.lib.e.b<a> aXy;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public cf(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aSX = false;
        this.aXt = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXu = 0;
        this.aXv = 0;
        this.aXw = 0;
        this.aXx = new cg(this);
        this.aXy = new com.baidu.adp.lib.e.b<>(new ch(this), 5, 0);
        this.mCardOnClickDispatch = new ci(this);
        this.aSm = baseActivity;
        this.aXs = new HashMap<>();
        this.aXu = 0;
        this.aXv = 0;
        this.aXw = com.baidu.adp.lib.util.k.d(this.aSm.getPageContext().getPageActivity(), i.d.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, cl clVar) {
        boolean z;
        if (wVar == null) {
            return null;
        }
        if (wVar != null && wVar.sF() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aXu, 0, this.aXv, 0);
            layoutParams.gravity = 1;
            clVar.aTk.setLayoutParams(layoutParams);
            clVar.aXB.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aXu, this.aXw, this.aXv, 0);
            layoutParams2.gravity = 1;
            clVar.aTk.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.an.i(clVar.aXB, i.e.yangnian2);
            clVar.aXB.setVisibility(0);
        }
        if (clVar.arf != this.mSkinType) {
            com.baidu.tbadk.core.util.an.i(clVar.aTk, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.an.i((View) clVar.aTy, i.e.frs_item_abstract_more_text_bg);
            this.aSm.getLayoutMode().ad(this.mSkinType == 1);
            this.aSm.getLayoutMode().k(view);
        }
        clVar.aXD.setOnClickListener(this);
        clVar.aTy.setOnClickListener(this);
        clVar.aXD.setTag(Integer.valueOf(i));
        clVar.aTy.setTag(Integer.valueOf(i));
        if (wVar != null && !wVar.sy() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            clVar.aXF.setVisibility(0);
            clVar.aXG.setVisibility(0);
            clVar.aXF.setText(wVar.getAddress());
        } else {
            clVar.aXF.setVisibility(8);
            clVar.aXG.setVisibility(8);
        }
        clVar.aTo.setText(com.baidu.tbadk.core.util.as.m(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qV().qX()) {
            clVar.aTr.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            clVar.aTr.setUserId(wVar.getAuthor().getUserId());
            clVar.aTr.setImageDrawable(null);
            clVar.aTr.d(portrait, 28, false);
        } else {
            clVar.aTr.setVisibility(8);
        }
        clVar.aTr.setOnClickListener(new cj(this, wVar));
        clVar.aTA.setOnClickListener(new ck(this, wVar));
        ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            clVar.aXC.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(clVar.aTp, i.c.cp_cont_h, 1);
            clVar.aXC.setTag(Integer.valueOf(i));
            clVar.aXC.setOnClickListener(this);
            clVar.aXC.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            clVar.aXC.setOnClickListener(this.aXx);
        } else {
            clVar.aXC.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(clVar.aTp, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            clVar.aTq.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(clVar.aTp, i.c.cp_cont_h, 1);
            clVar.aTq.setTag(Integer.valueOf(i));
            clVar.aTq.setOnClickListener(this);
            clVar.aTq.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            clVar.aTq.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(clVar.aTp, i.c.cp_cont_c, 1);
        }
        clVar.aTp.setText(wVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.sr() == 1) {
            clVar.aPy.setVisibility(8);
        } else {
            clVar.aPy.setVisibility(0);
            wVar.parser_title();
            clVar.aPy.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(clVar.aPy, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(clVar.aPy, i.c.cp_cont_b, 1);
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
                    clVar.aTy.setVisibility(0);
                    clVar.aTl.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    clVar.aTy.setVisibility(8);
                    clVar.aTl.setText(stringBuffer.toString());
                }
                clVar.aTl.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lR(wVar.getId())) {
                    com.baidu.tbadk.core.util.an.b(clVar.aTl, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(clVar.aTl, i.c.cp_cont_b, 1);
                }
            } else {
                clVar.aTy.setVisibility(8);
                clVar.aTl.setVisibility(8);
            }
        }
        if (wVar.getAnchorInfoData() == null || !this.aXt || wVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aXs, wVar.getAnchorInfoData().getGroup_id(), wVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (clVar.aXE == null) {
                clVar.aXE = this.aXy.gZ();
                clVar.aTk.addView(clVar.aXE.aTB, clVar.aTk.indexOfChild(clVar.aTn) + 1);
            }
            if (clVar.aXE.arf != this.mSkinType) {
                this.aSm.getLayoutMode().ad(this.mSkinType == 1);
                this.aSm.getLayoutMode().k(clVar.aXE.aTB);
                clVar.aXE.arf = this.mSkinType;
            }
            clVar.aTn.setVisibility(8);
            clVar.aXE.aTB.setVisibility(0);
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
            clVar.aXE.aTC.setData(liveCardData);
            clVar.aXE.aTC.setStatisticsKey("notice_frs_live");
            if (!clVar.aXE.aTC.hasCardOnClickDispatch()) {
                clVar.aXE.aTC.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (clVar.aXE != null) {
            this.aXy.k(clVar.aXE);
            clVar.aTk.removeView(clVar.aXE.aTB);
            clVar.aXE = null;
        }
        if (com.baidu.tbadk.core.m.qV().qZ() && medias != null && medias.size() > 0 && !z) {
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
                clVar.aTn.setVisibility(0);
                clVar.aTn.a(wVar, this.aUe.afg().getName(), this.aUe.afg().getId(), wVar.getTid());
                clVar.aTn.setShowBig(this.aSX);
                clVar.aTn.setDrawNum(true);
                clVar.aTn.setFromCDN(this.mIsFromCDN);
                clVar.aTn.a(this.aSm.getPageContext(), mediaDataArr, i6);
                clVar.aTn.setImageFrom("other");
            } else {
                clVar.aTn.setVisibility(8);
            }
        } else {
            clVar.aTn.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> sp = wVar.sp();
        if (sp != null && sp.size() > 0) {
            clVar.aTm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sp.get(0);
            clVar.aTm.setVoiceModel(voiceModel);
            clVar.aTm.setTag(voiceModel);
            clVar.aTm.ayR();
            if (voiceModel != null) {
                clVar.aTm.hR(voiceModel.voice_status.intValue());
            }
        } else {
            clVar.aTm.setVisibility(8);
        }
        if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
            clVar.aTu.setVisibility(0);
            clVar.aTu.setText(com.baidu.tbadk.core.util.as.q(wVar.getPraise().getNum()));
        } else {
            clVar.aTu.setVisibility(8);
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            clVar.aTw.setVisibility(0);
            clVar.aTw.setText(com.baidu.tbadk.core.util.as.q(reply_num));
        } else {
            clVar.aTw.setVisibility(8);
        }
        if (wVar.sy()) {
            clVar.aPy.setMaxLines(2);
            clVar.aPy.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.sx() == 1) {
                if (wVar.so().get(0).getStatus() == 1) {
                    clVar.aXD.setText(this.mContext.getResources().getString(i.h.i_want_lottery));
                    clVar.aXD.setVisibility(0);
                } else {
                    clVar.aXD.setVisibility(8);
                }
            } else if (wVar.sx() == 2) {
                if (wVar.so().get(0).getStatus() == 1) {
                    clVar.aXD.setText(this.mContext.getResources().getString(i.h.i_want_share_picture));
                    clVar.aXD.setVisibility(0);
                } else {
                    clVar.aXD.setVisibility(8);
                }
            } else {
                clVar.aXD.setVisibility(8);
                clVar.aPy.setMaxLines(Integer.MAX_VALUE);
                clVar.aPy.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            clVar.aXD.setVisibility(8);
        }
        clVar.arf = this.mSkinType;
        return view;
    }

    public void bX(boolean z) {
        if (this.aSX != z) {
            this.aSX = z;
        }
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

    public int KY() {
        return i.f.frs_more_abstract;
    }

    public int LI() {
        return i.f.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout aTB;
        public LiveBroadcastCard aTC;
        private int arf = 3;

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
    /* renamed from: j */
    public cl a(ViewGroup viewGroup) {
        this.aTd = (ListView) viewGroup;
        return new cl(LayoutInflater.from(this.mContext).inflate(i.g.frs_item, (ViewGroup) null), this.aTa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, cl clVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) clVar);
        return a(i, view, wVar, clVar);
    }

    public int LK() {
        return i.f.frs_user_tshow_icon_box;
    }
}
