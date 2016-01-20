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
public class cy extends bp<com.baidu.tbadk.core.data.z, de> implements View.OnClickListener {
    private BaseActivity bbA;
    private boolean bck;
    private HashMap<Integer, Long> bhq;
    private boolean bhr;
    private int bhs;
    private int bht;
    private int bhu;
    private View.OnClickListener bhv;
    private com.baidu.adp.lib.f.b<a> bhw;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public cy(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bck = false;
        this.bhr = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.bhs = 0;
        this.bht = 0;
        this.bhu = 0;
        this.bhv = new cz(this);
        this.bhw = new com.baidu.adp.lib.f.b<>(new da(this), 5, 0);
        this.mCardOnClickDispatch = new db(this);
        this.bbA = baseActivity;
        this.bhq = new HashMap<>();
        this.bhs = 0;
        this.bht = 0;
        this.bhu = com.baidu.adp.lib.util.k.d(this.bbA.getPageContext().getPageActivity(), n.e.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.z zVar, de deVar) {
        boolean z;
        if (zVar == null) {
            return null;
        }
        if (zVar != null && zVar.sQ() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.bhs, 0, this.bht, 0);
            layoutParams.gravity = 1;
            deVar.bcx.setLayoutParams(layoutParams);
            deVar.bhz.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.bhs, this.bhu, this.bht, 0);
            layoutParams2.gravity = 1;
            deVar.bcx.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.as.i(deVar.bhz, n.f.yangnian2);
            deVar.bhz.setVisibility(0);
        }
        ca.a(this.bbA, deVar.bhy, deVar.bcC, deVar.bcB, deVar.bhC, deVar.bhD, deVar.bhB, view, zVar, this.mSkinType, new dc(this, zVar));
        if (deVar.ahf != this.mSkinType) {
            com.baidu.tbadk.core.util.as.i(deVar.bcx, n.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.as.i((View) deVar.bcI, n.f.frs_item_abstract_more_text_bg);
            this.bbA.getLayoutMode().ac(this.mSkinType == 1);
            this.bbA.getLayoutMode().k(view);
        }
        deVar.bhA.setOnClickListener(this);
        deVar.bcI.setOnClickListener(this);
        deVar.bhA.setTag(Integer.valueOf(i));
        deVar.bcI.setTag(Integer.valueOf(i));
        if (zVar != null && !zVar.sJ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
            deVar.bgj.setVisibility(0);
            deVar.bgk.setVisibility(0);
            deVar.bgj.setText(zVar.getAddress());
        } else {
            deVar.bgj.setVisibility(8);
            deVar.bgk.setVisibility(8);
        }
        deVar.agy.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qQ().qS()) {
            deVar.bcC.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            deVar.bcC.setUserId(zVar.getAuthor().getUserId());
            deVar.bcC.setImageDrawable(null);
            deVar.bcC.d(portrait, 28, false);
        } else {
            deVar.bcC.setVisibility(8);
        }
        deVar.bcC.setOnClickListener(new dd(this, zVar));
        ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            deVar.agU.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(deVar.bcB, n.d.cp_cont_h, 1);
            deVar.agU.setTag(Integer.valueOf(i));
            deVar.agU.setOnClickListener(this);
            deVar.agU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds10), true);
            deVar.agU.setOnClickListener(this.bhv);
        } else {
            deVar.agU.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(deVar.bcB, n.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            deVar.agT.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(deVar.bcB, n.d.cp_cont_h, 1);
            deVar.agT.setTag(Integer.valueOf(i));
            deVar.agT.setOnClickListener(this);
            deVar.agT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.e.ds36), this.mContext.getResources().getDimensionPixelSize(n.e.ds36), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
        } else {
            deVar.agT.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(deVar.bcB, n.d.cp_cont_c, 1);
        }
        deVar.bcB.setText(zVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (zVar.sC() == 1) {
            deVar.aOn.setVisibility(8);
        } else {
            deVar.aOn.setVisibility(0);
            zVar.parser_title();
            deVar.aOn.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mD(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(deVar.aOn, n.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(deVar.aOn, n.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (zVar.sy() != null && zVar.sy().trim().length() > 0) {
            stringBuffer.append(zVar.sy());
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
                    deVar.bcI.setVisibility(0);
                    deVar.bcy.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    deVar.bcI.setVisibility(8);
                    deVar.bcy.setText(stringBuffer.toString());
                }
                deVar.bcy.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mD(zVar.getId())) {
                    com.baidu.tbadk.core.util.as.b(deVar.bcy, n.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(deVar.bcy, n.d.cp_cont_b, 1);
                }
            } else {
                deVar.bcI.setVisibility(8);
                deVar.bcy.setVisibility(8);
            }
        }
        if (zVar.getAnchorInfoData() == null || !this.bhr || zVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.bhq, zVar.getAnchorInfoData().getGroup_id(), zVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (deVar.bhE == null) {
                deVar.bhE = this.bhw.hb();
                deVar.bcx.addView(deVar.bhE.bcL, deVar.bcx.indexOfChild(deVar.bcA) + 1);
            }
            if (deVar.bhE.ahf != this.mSkinType) {
                this.bbA.getLayoutMode().ac(this.mSkinType == 1);
                this.bbA.getLayoutMode().k(deVar.bhE.bcL);
                deVar.bhE.ahf = this.mSkinType;
            }
            deVar.bcA.setVisibility(8);
            deVar.bhE.bcL.setVisibility(0);
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
            deVar.bhE.bcM.setData(liveCardData);
            deVar.bhE.bcM.setStatisticsKey("notice_frs_live");
            if (!deVar.bhE.bcM.hasCardOnClickDispatch()) {
                deVar.bhE.bcM.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (deVar.bhE != null) {
            this.bhw.k(deVar.bhE);
            deVar.bcx.removeView(deVar.bhE.bcL);
            deVar.bhE = null;
        }
        if (com.baidu.tbadk.core.m.qQ().qW() && medias != null && medias.size() > 0 && !z) {
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
                deVar.bcA.setVisibility(0);
                deVar.bcA.a(zVar, this.bdo.akG().getName(), this.bdo.akG().getId(), zVar.getTid());
                deVar.bcA.setShowBig(this.bck);
                deVar.bcA.setDrawNum(true);
                deVar.bcA.setFromCDN(this.mIsFromCDN);
                deVar.bcA.a(this.bbA.getPageContext(), mediaDataArr, i6);
                deVar.bcA.setImageFrom("other");
            } else {
                deVar.bcA.setVisibility(8);
            }
        } else {
            deVar.bcA.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> sB = zVar.sB();
        if (sB != null && sB.size() > 0) {
            deVar.bcz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sB.get(0);
            deVar.bcz.setVoiceModel(voiceModel);
            deVar.bcz.setTag(voiceModel);
            deVar.bcz.aGx();
            if (voiceModel != null) {
                deVar.bcz.je(voiceModel.voice_status.intValue());
            }
        } else {
            deVar.bcz.setVisibility(8);
        }
        if (zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
            deVar.agz.setVisibility(0);
            deVar.agz.setText(com.baidu.tbadk.core.util.ax.x(zVar.getPraise().getNum()));
        } else {
            deVar.agz.setVisibility(8);
        }
        int reply_num = zVar.getReply_num();
        if (reply_num > 0) {
            deVar.bcG.setVisibility(0);
            deVar.bcG.setText(com.baidu.tbadk.core.util.ax.x(reply_num));
        } else {
            deVar.bcG.setVisibility(8);
        }
        if (zVar.sJ()) {
            deVar.aOn.setMaxLines(2);
            deVar.aOn.setEllipsize(TextUtils.TruncateAt.END);
            if (zVar.sI() == 1) {
                if (zVar.sA().get(0).getStatus() == 1) {
                    deVar.bhA.setText(this.mContext.getResources().getString(n.j.i_want_lottery));
                    deVar.bhA.setVisibility(0);
                } else {
                    deVar.bhA.setVisibility(8);
                }
            } else if (zVar.sI() == 2) {
                if (zVar.sA().get(0).getStatus() == 1) {
                    deVar.bhA.setText(this.mContext.getResources().getString(n.j.i_want_share_picture));
                    deVar.bhA.setVisibility(0);
                } else {
                    deVar.bhA.setVisibility(8);
                }
            } else {
                deVar.bhA.setVisibility(8);
                deVar.aOn.setMaxLines(Integer.MAX_VALUE);
                deVar.aOn.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            deVar.bhA.setVisibility(8);
        }
        deVar.ahf = this.mSkinType;
        return view;
    }

    public void cl(boolean z) {
        if (this.bck != z) {
            this.bck = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfE != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u au = au(intValue);
                if (au instanceof com.baidu.tbadk.core.data.z) {
                    View childAt = this.bcq.getChildAt(intValue - (this.bcq.getFirstVisiblePosition() - this.bcq.getHeaderViewsCount()));
                    this.bfE.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) au);
                }
            }
        }
    }

    public int MQ() {
        return n.g.frs_more_abstract;
    }

    public int Nz() {
        return n.g.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        private int ahf = 3;
        public LinearLayout bcL;
        public LiveBroadcastCard bcM;

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
    /* renamed from: u */
    public de a(ViewGroup viewGroup) {
        this.bcq = (ListView) viewGroup;
        return new de(LayoutInflater.from(this.mContext).inflate(n.h.frs_item, (ViewGroup) null), this.bcn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, de deVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) deVar);
        return a(i, view, zVar, deVar);
    }

    public int NB() {
        return n.g.frs_user_tshow_icon_box;
    }
}
