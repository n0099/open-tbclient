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
public class bv extends bd<com.baidu.tbadk.core.data.x, cb> implements View.OnClickListener {
    private BaseActivity aSX;
    private boolean aTI;
    private HashMap<Integer, Long> aXE;
    private boolean aXF;
    private int aXG;
    private int aXH;
    private int aXI;
    private View.OnClickListener aXJ;
    private com.baidu.adp.lib.e.b<a> aXK;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public bv(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aTI = false;
        this.aXF = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXG = 0;
        this.aXH = 0;
        this.aXI = 0;
        this.aXJ = new bw(this);
        this.aXK = new com.baidu.adp.lib.e.b<>(new bx(this), 5, 0);
        this.mCardOnClickDispatch = new by(this);
        this.aSX = baseActivity;
        this.aXE = new HashMap<>();
        this.aXG = 0;
        this.aXH = 0;
        this.aXI = com.baidu.adp.lib.util.k.d(this.aSX.getPageContext().getPageActivity(), i.d.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.x xVar, cb cbVar) {
        boolean z;
        if (xVar == null) {
            return null;
        }
        if (xVar != null && xVar.sI() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aXG, 0, this.aXH, 0);
            layoutParams.gravity = 1;
            cbVar.aTV.setLayoutParams(layoutParams);
            cbVar.aXN.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aXG, this.aXI, this.aXH, 0);
            layoutParams2.gravity = 1;
            cbVar.aTV.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.al.h(cbVar.aXN, i.e.yangnian2);
            cbVar.aXN.setVisibility(0);
        }
        if (cbVar.arr != this.mSkinType) {
            com.baidu.tbadk.core.util.al.h(cbVar.aTV, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.al.h((View) cbVar.aUj, i.e.frs_item_abstract_more_text_bg);
            this.aSX.getLayoutMode().ad(this.mSkinType == 1);
            this.aSX.getLayoutMode().k(view);
        }
        cbVar.aXP.setOnClickListener(this);
        cbVar.aUj.setOnClickListener(this);
        cbVar.aXP.setTag(Integer.valueOf(i));
        cbVar.aUj.setTag(Integer.valueOf(i));
        if (xVar != null && !xVar.sD() && !TextUtils.isEmpty(xVar.getAddress()) && !TextUtils.isEmpty(xVar.getAddress().trim())) {
            cbVar.aXR.setVisibility(0);
            cbVar.aXS.setVisibility(0);
            cbVar.aXR.setText(xVar.getAddress());
        } else {
            cbVar.aXR.setVisibility(8);
            cbVar.aXS.setVisibility(8);
        }
        cbVar.aTZ.setText(com.baidu.tbadk.core.util.aq.m(xVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.rb().rd()) {
            cbVar.aUc.setVisibility(0);
            String portrait = xVar.getAuthor().getPortrait();
            cbVar.aUc.setUserId(xVar.getAuthor().getUserId());
            cbVar.aUc.setImageDrawable(null);
            cbVar.aUc.d(portrait, 28, false);
        } else {
            cbVar.aUc.setVisibility(8);
        }
        cbVar.aUc.setOnClickListener(new bz(this, xVar));
        cbVar.aUl.setOnClickListener(new ca(this, xVar));
        ArrayList<IconData> iconInfo = xVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            cbVar.aXO.setVisibility(0);
            com.baidu.tbadk.core.util.al.b(cbVar.aUa, i.c.cp_cont_h, 1);
            cbVar.aXO.setTag(Integer.valueOf(i));
            cbVar.aXO.setOnClickListener(this);
            cbVar.aXO.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            cbVar.aXO.setOnClickListener(this.aXJ);
        } else {
            cbVar.aXO.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(cbVar.aUa, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = xVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            cbVar.aUb.setVisibility(0);
            com.baidu.tbadk.core.util.al.b(cbVar.aUa, i.c.cp_cont_h, 1);
            cbVar.aUb.setTag(Integer.valueOf(i));
            cbVar.aUb.setOnClickListener(this);
            cbVar.aUb.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            cbVar.aUb.setVisibility(8);
            com.baidu.tbadk.core.util.al.b(cbVar.aUa, i.c.cp_cont_c, 1);
        }
        cbVar.aUa.setText(xVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (xVar.sw() == 1) {
            cbVar.aQj.setVisibility(8);
        } else {
            cbVar.aQj.setVisibility(0);
            xVar.parser_title();
            cbVar.aQj.setText(xVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lj(xVar.getId())) {
                com.baidu.tbadk.core.util.al.b(cbVar.aQj, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.al.b(cbVar.aQj, i.c.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (xVar.sr() != null && xVar.sr().trim().length() > 0) {
            stringBuffer.append(xVar.sr());
        }
        ArrayList<MediaData> medias = xVar.getMedias();
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
                    cbVar.aUj.setVisibility(0);
                    cbVar.aTW.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    cbVar.aUj.setVisibility(8);
                    cbVar.aTW.setText(stringBuffer.toString());
                }
                cbVar.aTW.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lj(xVar.getId())) {
                    com.baidu.tbadk.core.util.al.b(cbVar.aTW, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.al.b(cbVar.aTW, i.c.cp_cont_b, 1);
                }
            } else {
                cbVar.aUj.setVisibility(8);
                cbVar.aTW.setVisibility(8);
            }
        }
        if (xVar.getAnchorInfoData() == null || !this.aXF || xVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aXE, xVar.getAnchorInfoData().getGroup_id(), xVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (cbVar.aXQ == null) {
                cbVar.aXQ = this.aXK.gX();
                cbVar.aTV.addView(cbVar.aXQ.aUm, cbVar.aTV.indexOfChild(cbVar.aTY) + 1);
            }
            if (cbVar.aXQ.arr != this.mSkinType) {
                this.aSX.getLayoutMode().ad(this.mSkinType == 1);
                this.aSX.getLayoutMode().k(cbVar.aXQ.aUm);
                cbVar.aXQ.arr = this.mSkinType;
            }
            cbVar.aTY.setVisibility(8);
            cbVar.aXQ.aUm.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(xVar.getAnchorInfoData().getAuthorId());
            liveCardData.setPublisherName(xVar.getAnchorInfoData().getAuthorName());
            liveCardData.setPublisherPortrait(xVar.getAnchorInfoData().getPublisherPortrait());
            liveCardData.setGroupId(xVar.getAnchorInfoData().getGroup_id());
            liveCardData.setIntro(xVar.getAnchorInfoData().getIntro());
            liveCardData.setLikers(xVar.getAnchorInfoData().getLikers());
            liveCardData.setListeners(xVar.getAnchorInfoData().getListeners());
            liveCardData.setName(xVar.getAnchorInfoData().getName());
            liveCardData.setPortrait(xVar.getAnchorInfoData().getPortrait());
            liveCardData.setStatus(xVar.getAnchorInfoData().getStatus());
            liveCardData.setStartTime(xVar.getAnchorInfoData().getStartTime());
            liveCardData.setIsVip(xVar.getAnchorInfoData().getIsVip());
            cbVar.aXQ.aUn.setData(liveCardData);
            cbVar.aXQ.aUn.setStatisticsKey("notice_frs_live");
            if (!cbVar.aXQ.aUn.hasCardOnClickDispatch()) {
                cbVar.aXQ.aUn.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (cbVar.aXQ != null) {
            this.aXK.k(cbVar.aXQ);
            cbVar.aTV.removeView(cbVar.aXQ.aUm);
            cbVar.aXQ = null;
        }
        if (com.baidu.tbadk.core.m.rb().rf() && medias != null && medias.size() > 0 && !z) {
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
                cbVar.aTY.setVisibility(0);
                cbVar.aTY.a(xVar, this.aUN.acP().getName(), this.aUN.acP().getId(), xVar.getTid());
                cbVar.aTY.setShowBig(this.aTI);
                cbVar.aTY.setDrawNum(true);
                cbVar.aTY.setFromCDN(this.mIsFromCDN);
                cbVar.aTY.a(this.aSX.getPageContext(), mediaDataArr, i6);
                cbVar.aTY.setImageFrom("other");
            } else {
                cbVar.aTY.setVisibility(8);
            }
        } else {
            cbVar.aTY.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> su = xVar.su();
        if (su != null && su.size() > 0) {
            cbVar.aTX.setVisibility(0);
            VoiceData.VoiceModel voiceModel = su.get(0);
            cbVar.aTX.setVoiceModel(voiceModel);
            cbVar.aTX.setTag(voiceModel);
            cbVar.aTX.avp();
            if (voiceModel != null) {
                cbVar.aTX.hy(voiceModel.voice_status.intValue());
            }
        } else {
            cbVar.aTX.setVisibility(8);
        }
        if (xVar.getPraise() != null && xVar.getPraise().getNum() > 0) {
            cbVar.aUf.setVisibility(0);
            cbVar.aUf.setText(com.baidu.tbadk.core.util.aq.o(xVar.getPraise().getNum()));
        } else {
            cbVar.aUf.setVisibility(8);
        }
        int reply_num = xVar.getReply_num();
        if (reply_num > 0) {
            cbVar.aUh.setVisibility(0);
            cbVar.aUh.setText(com.baidu.tbadk.core.util.aq.o(reply_num));
        } else {
            cbVar.aUh.setVisibility(8);
        }
        if (xVar.sD()) {
            cbVar.aQj.setMaxLines(2);
            cbVar.aQj.setEllipsize(TextUtils.TruncateAt.END);
            if (xVar.sC() == 1) {
                if (xVar.st().get(0).getStatus() == 1) {
                    cbVar.aXP.setText(this.mContext.getResources().getString(i.h.i_want_lottery));
                    cbVar.aXP.setVisibility(0);
                } else {
                    cbVar.aXP.setVisibility(8);
                }
            } else if (xVar.sC() == 2) {
                if (xVar.st().get(0).getStatus() == 1) {
                    cbVar.aXP.setText(this.mContext.getResources().getString(i.h.i_want_share_picture));
                    cbVar.aXP.setVisibility(0);
                } else {
                    cbVar.aXP.setVisibility(8);
                }
            } else {
                cbVar.aXP.setVisibility(8);
                cbVar.aQj.setMaxLines(Integer.MAX_VALUE);
                cbVar.aQj.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            cbVar.aXP.setVisibility(8);
        }
        cbVar.arr = this.mSkinType;
        return view;
    }

    public void bY(boolean z) {
        if (this.aTI != z) {
            this.aTI = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWB != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aA = aA(intValue);
                if (aA instanceof com.baidu.tbadk.core.data.x) {
                    View childAt = this.aTO.getChildAt(intValue - (this.aTO.getFirstVisiblePosition() - this.aTO.getHeaderViewsCount()));
                    this.aWB.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.x) aA);
                }
            }
        }
    }

    public int KR() {
        return i.f.frs_more_abstract;
    }

    public int Ly() {
        return i.f.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout aUm;
        public LiveBroadcastCard aUn;
        private int arr = -1;

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
    /* renamed from: i */
    public cb a(ViewGroup viewGroup) {
        this.aTO = (ListView) viewGroup;
        return new cb(LayoutInflater.from(this.mContext).inflate(i.g.frs_item, (ViewGroup) null), this.aTL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.x xVar, cb cbVar) {
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tbadk.core.data.x) cbVar);
        return a(i, view, xVar, cbVar);
    }

    public int LA() {
        return i.f.frs_user_tshow_icon_box;
    }
}
