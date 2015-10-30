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
    private boolean aSP;
    private BaseActivity aSe;
    private HashMap<Integer, Long> aXj;
    private boolean aXk;
    private int aXl;
    private int aXm;
    private int aXn;
    private View.OnClickListener aXo;
    private com.baidu.adp.lib.e.b<a> aXp;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public cf(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aSP = false;
        this.aXk = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXl = 0;
        this.aXm = 0;
        this.aXn = 0;
        this.aXo = new cg(this);
        this.aXp = new com.baidu.adp.lib.e.b<>(new ch(this), 5, 0);
        this.mCardOnClickDispatch = new ci(this);
        this.aSe = baseActivity;
        this.aXj = new HashMap<>();
        this.aXl = 0;
        this.aXm = 0;
        this.aXn = com.baidu.adp.lib.util.k.d(this.aSe.getPageContext().getPageActivity(), i.d.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar, cl clVar) {
        boolean z;
        if (wVar == null) {
            return null;
        }
        if (wVar != null && wVar.sC() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aXl, 0, this.aXm, 0);
            layoutParams.gravity = 1;
            clVar.aTc.setLayoutParams(layoutParams);
            clVar.aXs.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aXl, this.aXn, this.aXm, 0);
            layoutParams2.gravity = 1;
            clVar.aTc.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.an.i(clVar.aXs, i.e.yangnian2);
            clVar.aXs.setVisibility(0);
        }
        if (clVar.apS != this.mSkinType) {
            com.baidu.tbadk.core.util.an.i(clVar.aTc, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.an.i((View) clVar.aTq, i.e.frs_item_abstract_more_text_bg);
            this.aSe.getLayoutMode().ad(this.mSkinType == 1);
            this.aSe.getLayoutMode().k(view);
        }
        clVar.aXu.setOnClickListener(this);
        clVar.aTq.setOnClickListener(this);
        clVar.aXu.setTag(Integer.valueOf(i));
        clVar.aTq.setTag(Integer.valueOf(i));
        if (wVar != null && !wVar.sv() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            clVar.aXw.setVisibility(0);
            clVar.aXx.setVisibility(0);
            clVar.aXw.setText(wVar.getAddress());
        } else {
            clVar.aXw.setVisibility(8);
            clVar.aXx.setVisibility(8);
        }
        clVar.aTg.setText(com.baidu.tbadk.core.util.as.m(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qU().qW()) {
            clVar.aTj.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            clVar.aTj.setUserId(wVar.getAuthor().getUserId());
            clVar.aTj.setImageDrawable(null);
            clVar.aTj.d(portrait, 28, false);
        } else {
            clVar.aTj.setVisibility(8);
        }
        clVar.aTj.setOnClickListener(new cj(this, wVar));
        clVar.aTs.setOnClickListener(new ck(this, wVar));
        ArrayList<IconData> iconInfo = wVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            clVar.aXt.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(clVar.aTh, i.c.cp_cont_h, 1);
            clVar.aXt.setTag(Integer.valueOf(i));
            clVar.aXt.setOnClickListener(this);
            clVar.aXt.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            clVar.aXt.setOnClickListener(this.aXo);
        } else {
            clVar.aXt.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(clVar.aTh, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            clVar.aTi.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(clVar.aTh, i.c.cp_cont_h, 1);
            clVar.aTi.setTag(Integer.valueOf(i));
            clVar.aTi.setOnClickListener(this);
            clVar.aTi.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            clVar.aTi.setVisibility(8);
            com.baidu.tbadk.core.util.an.b(clVar.aTh, i.c.cp_cont_c, 1);
        }
        clVar.aTh.setText(wVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (wVar.so() == 1) {
            clVar.aPq.setVisibility(8);
        } else {
            clVar.aPq.setVisibility(0);
            wVar.parser_title();
            clVar.aPq.setText(wVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                com.baidu.tbadk.core.util.an.b(clVar.aPq, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.an.b(clVar.aPq, i.c.cp_cont_b, 1);
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
                    clVar.aTq.setVisibility(0);
                    clVar.aTd.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    clVar.aTq.setVisibility(8);
                    clVar.aTd.setText(stringBuffer.toString());
                }
                clVar.aTd.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
                    com.baidu.tbadk.core.util.an.b(clVar.aTd, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(clVar.aTd, i.c.cp_cont_b, 1);
                }
            } else {
                clVar.aTq.setVisibility(8);
                clVar.aTd.setVisibility(8);
            }
        }
        if (wVar.getAnchorInfoData() == null || !this.aXk || wVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aXj, wVar.getAnchorInfoData().getGroup_id(), wVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (clVar.aXv == null) {
                clVar.aXv = this.aXp.gY();
                clVar.aTc.addView(clVar.aXv.aTt, clVar.aTc.indexOfChild(clVar.aTf) + 1);
            }
            if (clVar.aXv.apS != this.mSkinType) {
                this.aSe.getLayoutMode().ad(this.mSkinType == 1);
                this.aSe.getLayoutMode().k(clVar.aXv.aTt);
                clVar.aXv.apS = this.mSkinType;
            }
            clVar.aTf.setVisibility(8);
            clVar.aXv.aTt.setVisibility(0);
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
            clVar.aXv.aTu.setData(liveCardData);
            clVar.aXv.aTu.setStatisticsKey("notice_frs_live");
            if (!clVar.aXv.aTu.hasCardOnClickDispatch()) {
                clVar.aXv.aTu.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (clVar.aXv != null) {
            this.aXp.k(clVar.aXv);
            clVar.aTc.removeView(clVar.aXv.aTt);
            clVar.aXv = null;
        }
        if (com.baidu.tbadk.core.m.qU().qY() && medias != null && medias.size() > 0 && !z) {
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
                clVar.aTf.setVisibility(0);
                clVar.aTf.a(wVar, this.aTW.aeJ().getName(), this.aTW.aeJ().getId(), wVar.getTid());
                clVar.aTf.setShowBig(this.aSP);
                clVar.aTf.setDrawNum(true);
                clVar.aTf.setFromCDN(this.mIsFromCDN);
                clVar.aTf.a(this.aSe.getPageContext(), mediaDataArr, i6);
                clVar.aTf.setImageFrom("other");
            } else {
                clVar.aTf.setVisibility(8);
            }
        } else {
            clVar.aTf.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> sm = wVar.sm();
        if (sm != null && sm.size() > 0) {
            clVar.aTe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sm.get(0);
            clVar.aTe.setVoiceModel(voiceModel);
            clVar.aTe.setTag(voiceModel);
            clVar.aTe.axI();
            if (voiceModel != null) {
                clVar.aTe.hE(voiceModel.voice_status.intValue());
            }
        } else {
            clVar.aTe.setVisibility(8);
        }
        if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
            clVar.aTm.setVisibility(0);
            clVar.aTm.setText(com.baidu.tbadk.core.util.as.q(wVar.getPraise().getNum()));
        } else {
            clVar.aTm.setVisibility(8);
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            clVar.aTo.setVisibility(0);
            clVar.aTo.setText(com.baidu.tbadk.core.util.as.q(reply_num));
        } else {
            clVar.aTo.setVisibility(8);
        }
        if (wVar.sv()) {
            clVar.aPq.setMaxLines(2);
            clVar.aPq.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.su() == 1) {
                if (wVar.sl().get(0).getStatus() == 1) {
                    clVar.aXu.setText(this.mContext.getResources().getString(i.h.i_want_lottery));
                    clVar.aXu.setVisibility(0);
                } else {
                    clVar.aXu.setVisibility(8);
                }
            } else if (wVar.su() == 2) {
                if (wVar.sl().get(0).getStatus() == 1) {
                    clVar.aXu.setText(this.mContext.getResources().getString(i.h.i_want_share_picture));
                    clVar.aXu.setVisibility(0);
                } else {
                    clVar.aXu.setVisibility(8);
                }
            } else {
                clVar.aXu.setVisibility(8);
                clVar.aPq.setMaxLines(Integer.MAX_VALUE);
                clVar.aPq.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            clVar.aXu.setVisibility(8);
        }
        clVar.apS = this.mSkinType;
        return view;
    }

    public void bV(boolean z) {
        if (this.aSP != z) {
            this.aSP = z;
        }
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

    public int KI() {
        return i.f.frs_more_abstract;
    }

    public int Ls() {
        return i.f.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout aTt;
        public LiveBroadcastCard aTu;
        private int apS = 3;

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
        this.aSV = (ListView) viewGroup;
        return new cl(LayoutInflater.from(this.mContext).inflate(i.g.frs_item, (ViewGroup) null), this.aSS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, cl clVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) clVar);
        return a(i, view, wVar, clVar);
    }

    public int Lu() {
        return i.f.frs_user_tshow_icon_box;
    }
}
