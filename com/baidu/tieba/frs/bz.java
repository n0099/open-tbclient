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
public class bz extends bc<com.baidu.tbadk.core.data.v, cf> implements View.OnClickListener {
    private BaseActivity aSJ;
    private boolean aTu;
    private HashMap<Integer, Long> aXJ;
    private boolean aXK;
    private int aXL;
    private int aXM;
    private int aXN;
    private View.OnClickListener aXO;
    private com.baidu.adp.lib.e.b<a> aXP;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public bz(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aTu = false;
        this.aXK = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXL = 0;
        this.aXM = 0;
        this.aXN = 0;
        this.aXO = new ca(this);
        this.aXP = new com.baidu.adp.lib.e.b<>(new cb(this), 5, 0);
        this.mCardOnClickDispatch = new cc(this);
        this.aSJ = baseActivity;
        this.aXJ = new HashMap<>();
        this.aXL = 0;
        this.aXM = 0;
        this.aXN = com.baidu.adp.lib.util.k.d(this.aSJ.getPageContext().getPageActivity(), i.d.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.v vVar, cf cfVar) {
        boolean z;
        if (vVar == null) {
            return null;
        }
        if (vVar != null && vVar.sE() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aXL, 0, this.aXM, 0);
            layoutParams.gravity = 1;
            cfVar.aTH.setLayoutParams(layoutParams);
            cfVar.aXS.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aXL, this.aXN, this.aXM, 0);
            layoutParams2.gravity = 1;
            cfVar.aTH.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.al.i(cfVar.aXS, i.e.yangnian2);
            cfVar.aXS.setVisibility(0);
        }
        if (cfVar.apH != this.mSkinType) {
            com.baidu.tbadk.core.util.al.i(cfVar.aTH, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.al.i((View) cfVar.aTV, i.e.frs_item_abstract_more_text_bg);
            this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
            this.aSJ.getLayoutMode().k(view);
        }
        cfVar.aXU.setOnClickListener(this);
        cfVar.aTV.setOnClickListener(this);
        cfVar.aXU.setTag(Integer.valueOf(i));
        cfVar.aTV.setTag(Integer.valueOf(i));
        if (vVar != null && !vVar.sA() && !TextUtils.isEmpty(vVar.getAddress()) && !TextUtils.isEmpty(vVar.getAddress().trim())) {
            cfVar.aXW.setVisibility(0);
            cfVar.aXX.setVisibility(0);
            cfVar.aXW.setText(vVar.getAddress());
        } else {
            cfVar.aXW.setVisibility(8);
            cfVar.aXX.setVisibility(8);
        }
        cfVar.aTL.setText(com.baidu.tbadk.core.util.aq.m(vVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.rd().rf()) {
            cfVar.aTO.setVisibility(0);
            String portrait = vVar.getAuthor().getPortrait();
            cfVar.aTO.setUserId(vVar.getAuthor().getUserId());
            cfVar.aTO.setImageDrawable(null);
            cfVar.aTO.d(portrait, 28, false);
        } else {
            cfVar.aTO.setVisibility(8);
        }
        cfVar.aTO.setOnClickListener(new cd(this, vVar));
        cfVar.aTX.setOnClickListener(new ce(this, vVar));
        ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            cfVar.aXT.setVisibility(0);
            com.baidu.tbadk.core.util.al.b(cfVar.aTM, i.c.cp_cont_h, 1);
            cfVar.aXT.setTag(Integer.valueOf(i));
            cfVar.aXT.setOnClickListener(this);
            cfVar.aXT.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            cfVar.aXT.setOnClickListener(this.aXO);
        } else {
            cfVar.aXT.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(cfVar.aTM, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            cfVar.aTN.setVisibility(0);
            com.baidu.tbadk.core.util.al.b(cfVar.aTM, i.c.cp_cont_h, 1);
            cfVar.aTN.setTag(Integer.valueOf(i));
            cfVar.aTN.setOnClickListener(this);
            cfVar.aTN.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            cfVar.aTN.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(cfVar.aTM, i.c.cp_cont_c, 1);
        }
        cfVar.aTM.setText(vVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (vVar.su() == 1) {
            cfVar.aPV.setVisibility(8);
        } else {
            cfVar.aPV.setVisibility(0);
            vVar.parser_title();
            cfVar.aPV.setText(vVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.kE(vVar.getId())) {
                com.baidu.tbadk.core.util.al.b(cfVar.aPV, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.al.b(cfVar.aPV, i.c.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (vVar.sq() != null && vVar.sq().trim().length() > 0) {
            stringBuffer.append(vVar.sq());
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
                    cfVar.aTV.setVisibility(0);
                    cfVar.aTI.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    cfVar.aTV.setVisibility(8);
                    cfVar.aTI.setText(stringBuffer.toString());
                }
                cfVar.aTI.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.kE(vVar.getId())) {
                    com.baidu.tbadk.core.util.al.b(cfVar.aTI, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.al.b(cfVar.aTI, i.c.cp_cont_b, 1);
                }
            } else {
                cfVar.aTV.setVisibility(8);
                cfVar.aTI.setVisibility(8);
            }
        }
        if (vVar.getAnchorInfoData() == null || !this.aXK || vVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aXJ, vVar.getAnchorInfoData().getGroup_id(), vVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (cfVar.aXV == null) {
                cfVar.aXV = this.aXP.ha();
                cfVar.aTH.addView(cfVar.aXV.aTY, cfVar.aTH.indexOfChild(cfVar.aTK) + 1);
            }
            if (cfVar.aXV.apH != this.mSkinType) {
                this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
                this.aSJ.getLayoutMode().k(cfVar.aXV.aTY);
                cfVar.aXV.apH = this.mSkinType;
            }
            cfVar.aTK.setVisibility(8);
            cfVar.aXV.aTY.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(vVar.getAnchorInfoData().getAuthorId());
            liveCardData.setPublisherName(vVar.getAnchorInfoData().getAuthorName());
            liveCardData.setPublisherPortrait(vVar.getAnchorInfoData().getPublisherPortrait());
            liveCardData.setGroupId(vVar.getAnchorInfoData().getGroup_id());
            liveCardData.setIntro(vVar.getAnchorInfoData().getIntro());
            liveCardData.setLikers(vVar.getAnchorInfoData().getLikers());
            liveCardData.setListeners(vVar.getAnchorInfoData().getListeners());
            liveCardData.setName(vVar.getAnchorInfoData().getName());
            liveCardData.setPortrait(vVar.getAnchorInfoData().getPortrait());
            liveCardData.setStatus(vVar.getAnchorInfoData().getStatus());
            liveCardData.setStartTime(vVar.getAnchorInfoData().getStartTime());
            liveCardData.setIsVip(vVar.getAnchorInfoData().getIsVip());
            cfVar.aXV.aTZ.setData(liveCardData);
            cfVar.aXV.aTZ.setStatisticsKey("notice_frs_live");
            if (!cfVar.aXV.aTZ.hasCardOnClickDispatch()) {
                cfVar.aXV.aTZ.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (cfVar.aXV != null) {
            this.aXP.k(cfVar.aXV);
            cfVar.aTH.removeView(cfVar.aXV.aTY);
            cfVar.aXV = null;
        }
        if (com.baidu.tbadk.core.m.rd().rh() && medias != null && medias.size() > 0 && !z) {
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
                cfVar.aTK.setVisibility(0);
                cfVar.aTK.a(vVar, this.aUy.acG().getName(), this.aUy.acG().getId(), vVar.getTid());
                cfVar.aTK.setShowBig(this.aTu);
                cfVar.aTK.setDrawNum(true);
                cfVar.aTK.setFromCDN(this.mIsFromCDN);
                cfVar.aTK.a(this.aSJ.getPageContext(), mediaDataArr, i6);
                cfVar.aTK.setImageFrom("other");
            } else {
                cfVar.aTK.setVisibility(8);
            }
        } else {
            cfVar.aTK.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> st = vVar.st();
        if (st != null && st.size() > 0) {
            cfVar.aTJ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = st.get(0);
            cfVar.aTJ.setVoiceModel(voiceModel);
            cfVar.aTJ.setTag(voiceModel);
            cfVar.aTJ.arb();
            if (voiceModel != null) {
                cfVar.aTJ.ho(voiceModel.voice_status.intValue());
            }
        } else {
            cfVar.aTJ.setVisibility(8);
        }
        if (vVar.getPraise() != null && vVar.getPraise().getNum() > 0) {
            cfVar.aTR.setVisibility(0);
            cfVar.aTR.setText(com.baidu.tbadk.core.util.aq.o(vVar.getPraise().getNum()));
        } else {
            cfVar.aTR.setVisibility(8);
        }
        int reply_num = vVar.getReply_num();
        if (reply_num > 0) {
            cfVar.aTT.setVisibility(0);
            cfVar.aTT.setText(com.baidu.tbadk.core.util.aq.o(reply_num));
        } else {
            cfVar.aTT.setVisibility(8);
        }
        if (vVar.sA()) {
            cfVar.aPV.setMaxLines(2);
            cfVar.aPV.setEllipsize(TextUtils.TruncateAt.END);
            if (vVar.sz() == 1) {
                if (vVar.ss().get(0).getStatus() == 1) {
                    cfVar.aXU.setText(this.mContext.getResources().getString(i.C0057i.i_want_lottery));
                    cfVar.aXU.setVisibility(0);
                } else {
                    cfVar.aXU.setVisibility(8);
                }
            } else if (vVar.sz() == 2) {
                if (vVar.ss().get(0).getStatus() == 1) {
                    cfVar.aXU.setText(this.mContext.getResources().getString(i.C0057i.i_want_share_picture));
                    cfVar.aXU.setVisibility(0);
                } else {
                    cfVar.aXU.setVisibility(8);
                }
            } else {
                cfVar.aXU.setVisibility(8);
                cfVar.aPV.setMaxLines(Integer.MAX_VALUE);
                cfVar.aPV.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            cfVar.aXU.setVisibility(8);
        }
        cfVar.apH = this.mSkinType;
        return view;
    }

    public void bT(boolean z) {
        if (this.aTu != z) {
            this.aTu = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWk != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aA = aA(intValue);
                if (aA instanceof com.baidu.tbadk.core.data.v) {
                    View childAt = this.aTA.getChildAt(intValue - (this.aTA.getFirstVisiblePosition() - this.aTA.getHeaderViewsCount()));
                    this.aWk.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.v) aA);
                }
            }
        }
    }

    public int Ld() {
        return i.f.frs_more_abstract;
    }

    public int LH() {
        return i.f.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout aTY;
        public LiveBroadcastCard aTZ;
        private int apH = -1;

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
    public cf a(ViewGroup viewGroup) {
        this.aTA = (ListView) viewGroup;
        return new cf(LayoutInflater.from(this.mContext).inflate(i.g.frs_item, (ViewGroup) null), this.aTx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, cf cfVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) cfVar);
        return a(i, view, vVar, cfVar);
    }

    public int LJ() {
        return i.f.frs_user_tshow_icon_box;
    }
}
