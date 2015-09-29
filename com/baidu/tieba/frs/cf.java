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
public class cf extends bn<com.baidu.tbadk.core.data.v, cl> implements View.OnClickListener {
    private BaseActivity aRT;
    private boolean aSE;
    private HashMap<Integer, Long> aWY;
    private boolean aWZ;
    private int aXa;
    private int aXb;
    private int aXc;
    private View.OnClickListener aXd;
    private com.baidu.adp.lib.e.b<a> aXe;
    private LiveBroadcastCard.a mCardOnClickDispatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public cf(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aSE = false;
        this.aWZ = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aXa = 0;
        this.aXb = 0;
        this.aXc = 0;
        this.aXd = new cg(this);
        this.aXe = new com.baidu.adp.lib.e.b<>(new ch(this), 5, 0);
        this.mCardOnClickDispatch = new ci(this);
        this.aRT = baseActivity;
        this.aWY = new HashMap<>();
        this.aXa = 0;
        this.aXb = 0;
        this.aXc = com.baidu.adp.lib.util.k.d(this.aRT.getPageContext().getPageActivity(), i.d.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.v vVar, cl clVar) {
        boolean z;
        if (vVar == null) {
            return null;
        }
        if (vVar != null && vVar.sF() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.aXa, 0, this.aXb, 0);
            layoutParams.gravity = 1;
            clVar.aSR.setLayoutParams(layoutParams);
            clVar.aXh.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aXa, this.aXc, this.aXb, 0);
            layoutParams2.gravity = 1;
            clVar.aSR.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.am.i(clVar.aXh, i.e.yangnian2);
            clVar.aXh.setVisibility(0);
        }
        if (clVar.apR != this.mSkinType) {
            com.baidu.tbadk.core.util.am.i(clVar.aSR, i.e.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.am.i((View) clVar.aTf, i.e.frs_item_abstract_more_text_bg);
            this.aRT.getLayoutMode().ad(this.mSkinType == 1);
            this.aRT.getLayoutMode().k(view);
        }
        clVar.aXj.setOnClickListener(this);
        clVar.aTf.setOnClickListener(this);
        clVar.aXj.setTag(Integer.valueOf(i));
        clVar.aTf.setTag(Integer.valueOf(i));
        if (vVar != null && !vVar.sy() && !TextUtils.isEmpty(vVar.getAddress()) && !TextUtils.isEmpty(vVar.getAddress().trim())) {
            clVar.aXl.setVisibility(0);
            clVar.aXm.setVisibility(0);
            clVar.aXl.setText(vVar.getAddress());
        } else {
            clVar.aXl.setVisibility(8);
            clVar.aXm.setVisibility(8);
        }
        clVar.aSV.setText(com.baidu.tbadk.core.util.ar.o(vVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qX().qZ()) {
            clVar.aSY.setVisibility(0);
            String portrait = vVar.getAuthor().getPortrait();
            clVar.aSY.setUserId(vVar.getAuthor().getUserId());
            clVar.aSY.setImageDrawable(null);
            clVar.aSY.d(portrait, 28, false);
        } else {
            clVar.aSY.setVisibility(8);
        }
        clVar.aSY.setOnClickListener(new cj(this, vVar));
        clVar.aTh.setOnClickListener(new ck(this, vVar));
        ArrayList<IconData> iconInfo = vVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            clVar.aXi.setVisibility(0);
            com.baidu.tbadk.core.util.am.b(clVar.aSW, i.c.cp_cont_h, 1);
            clVar.aXi.setTag(Integer.valueOf(i));
            clVar.aXi.setOnClickListener(this);
            clVar.aXi.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds30), this.mContext.getResources().getDimensionPixelSize(i.d.ds10), true);
            clVar.aXi.setOnClickListener(this.aXd);
        } else {
            clVar.aXi.setVisibility(8);
            com.baidu.tbadk.core.util.am.b(clVar.aSW, i.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfo = vVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            clVar.aSX.setVisibility(0);
            com.baidu.tbadk.core.util.am.b(clVar.aSW, i.c.cp_cont_h, 1);
            clVar.aSX.setTag(Integer.valueOf(i));
            clVar.aSX.setOnClickListener(this);
            clVar.aSX.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
        } else {
            clVar.aSX.setVisibility(8);
            com.baidu.tbadk.core.util.am.b(clVar.aSW, i.c.cp_cont_c, 1);
        }
        clVar.aSW.setText(vVar.getAuthor().getUserName());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (vVar.sr() == 1) {
            clVar.aPf.setVisibility(8);
        } else {
            clVar.aPf.setVisibility(0);
            vVar.parser_title();
            clVar.aPf.setText(vVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                com.baidu.tbadk.core.util.am.b(clVar.aPf, i.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.am.b(clVar.aPf, i.c.cp_cont_b, 1);
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
                    clVar.aTf.setVisibility(0);
                    clVar.aSS.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    clVar.aTf.setVisibility(8);
                    clVar.aSS.setText(stringBuffer.toString());
                }
                clVar.aSS.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
                    com.baidu.tbadk.core.util.am.b(clVar.aSS, i.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.am.b(clVar.aSS, i.c.cp_cont_b, 1);
                }
            } else {
                clVar.aTf.setVisibility(8);
                clVar.aSS.setVisibility(8);
            }
        }
        if (vVar.getAnchorInfoData() == null || !this.aWZ || vVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aWY, vVar.getAnchorInfoData().getGroup_id(), vVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (clVar.aXk == null) {
                clVar.aXk = this.aXe.gY();
                clVar.aSR.addView(clVar.aXk.aTi, clVar.aSR.indexOfChild(clVar.aSU) + 1);
            }
            if (clVar.aXk.apR != this.mSkinType) {
                this.aRT.getLayoutMode().ad(this.mSkinType == 1);
                this.aRT.getLayoutMode().k(clVar.aXk.aTi);
                clVar.aXk.apR = this.mSkinType;
            }
            clVar.aSU.setVisibility(8);
            clVar.aXk.aTi.setVisibility(0);
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
            clVar.aXk.aTj.setData(liveCardData);
            clVar.aXk.aTj.setStatisticsKey("notice_frs_live");
            if (!clVar.aXk.aTj.hasCardOnClickDispatch()) {
                clVar.aXk.aTj.setCardOnClickDispatch(this.mCardOnClickDispatch);
            }
        } else if (clVar.aXk != null) {
            this.aXe.k(clVar.aXk);
            clVar.aSR.removeView(clVar.aXk.aTi);
            clVar.aXk = null;
        }
        if (com.baidu.tbadk.core.m.qX().rb() && medias != null && medias.size() > 0 && !z) {
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
                clVar.aSU.setVisibility(0);
                clVar.aSU.a(vVar, this.aTL.aeN().getName(), this.aTL.aeN().getId(), vVar.getTid());
                clVar.aSU.setShowBig(this.aSE);
                clVar.aSU.setDrawNum(true);
                clVar.aSU.setFromCDN(this.mIsFromCDN);
                clVar.aSU.a(this.aRT.getPageContext(), mediaDataArr, i6);
                clVar.aSU.setImageFrom("other");
            } else {
                clVar.aSU.setVisibility(8);
            }
        } else {
            clVar.aSU.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> sp = vVar.sp();
        if (sp != null && sp.size() > 0) {
            clVar.aST.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sp.get(0);
            clVar.aST.setVoiceModel(voiceModel);
            clVar.aST.setTag(voiceModel);
            clVar.aST.axC();
            if (voiceModel != null) {
                clVar.aST.hE(voiceModel.voice_status.intValue());
            }
        } else {
            clVar.aST.setVisibility(8);
        }
        if (vVar.getPraise() != null && vVar.getPraise().getNum() > 0) {
            clVar.aTb.setVisibility(0);
            clVar.aTb.setText(com.baidu.tbadk.core.util.ar.s(vVar.getPraise().getNum()));
        } else {
            clVar.aTb.setVisibility(8);
        }
        int reply_num = vVar.getReply_num();
        if (reply_num > 0) {
            clVar.aTd.setVisibility(0);
            clVar.aTd.setText(com.baidu.tbadk.core.util.ar.s(reply_num));
        } else {
            clVar.aTd.setVisibility(8);
        }
        if (vVar.sy()) {
            clVar.aPf.setMaxLines(2);
            clVar.aPf.setEllipsize(TextUtils.TruncateAt.END);
            if (vVar.sx() == 1) {
                if (vVar.so().get(0).getStatus() == 1) {
                    clVar.aXj.setText(this.mContext.getResources().getString(i.h.i_want_lottery));
                    clVar.aXj.setVisibility(0);
                } else {
                    clVar.aXj.setVisibility(8);
                }
            } else if (vVar.sx() == 2) {
                if (vVar.so().get(0).getStatus() == 1) {
                    clVar.aXj.setText(this.mContext.getResources().getString(i.h.i_want_share_picture));
                    clVar.aXj.setVisibility(0);
                } else {
                    clVar.aXj.setVisibility(8);
                }
            } else {
                clVar.aXj.setVisibility(8);
                clVar.aPf.setMaxLines(Integer.MAX_VALUE);
                clVar.aPf.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            clVar.aXj.setVisibility(8);
        }
        clVar.apR = this.mSkinType;
        return view;
    }

    public void bV(boolean z) {
        if (this.aSE != z) {
            this.aSE = z;
        }
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

    public int KM() {
        return i.f.frs_more_abstract;
    }

    public int Lw() {
        return i.f.action_button;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout aTi;
        public LiveBroadcastCard aTj;
        private int apR = 3;

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
        this.aSK = (ListView) viewGroup;
        return new cl(LayoutInflater.from(this.mContext).inflate(i.g.frs_item, (ViewGroup) null), this.aSH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, cl clVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) clVar);
        return a(i, view, vVar, clVar);
    }

    public int Ly() {
        return i.f.frs_user_tshow_icon_box;
    }
}
