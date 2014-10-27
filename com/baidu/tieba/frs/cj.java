package com.baidu.tieba.frs;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class cj extends bm<com.baidu.tbadk.core.data.q> implements View.OnClickListener {
    private HashMap<Integer, Long> aDz;
    private boolean ayP;
    private long ayT;
    private boolean ayU;

    public cj(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.ayP = false;
        this.ayT = 0L;
        this.ayU = true;
        this.aDz = new HashMap<>();
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        this.ayV = (ListView) viewGroup;
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item, null);
        co coVar = new co(this, null);
        coVar.azc = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list);
        coVar.azt = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
        coVar.azd = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
        coVar.azk = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.frs_photo);
        coVar.azj = (UserIconBox) inflate.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
        coVar.azi = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_lv_author);
        coVar.azh = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
        coVar.JM = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_lv_title);
        coVar.aze = (TextView) inflate.findViewById(com.baidu.tieba.v.abstract_text);
        coVar.azf = (PlayVoiceBnt) inflate.findViewById(com.baidu.tieba.v.abstract_voice);
        coVar.azg = (FrsCommonImageLayout) inflate.findViewById(com.baidu.tieba.v.abstract_img_layout);
        coVar.azl = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_praise_btn);
        coVar.azm = (ImageView) inflate.findViewById(com.baidu.tieba.v.frs_praise_icon);
        coVar.azn = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_praise_num);
        coVar.azo = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_reply_btn);
        coVar.azp = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_reply_num);
        coVar.azq = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.v.frs_praise_list_user_icon);
        coVar.azr = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_more_abstract);
        coVar.azs = inflate.findViewById(com.baidu.tieba.v.frs_item_praise_divider_line);
        coVar.azu = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.live_card_layout);
        coVar.azv = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.v.item_card);
        coVar.aDC = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_item_location_container);
        coVar.aDE = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_item_location_address);
        coVar.aDD = (ImageView) inflate.findViewById(com.baidu.tieba.v.frs_item_location_img);
        inflate.setTag(coVar);
        return inflate;
    }

    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.q qVar) {
        super.b(i, view, viewGroup, qVar);
        return a(i, view, qVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x033d: INVOKE  (r2v17 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x0339: INVOKE  (r2v16 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r12v0 com.baidu.tbadk.core.data.q) type: VIRTUAL call: com.baidu.tbadk.core.data.q.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, com.baidu.tbadk.core.data.q qVar) {
        co coVar = (co) view.getTag();
        com.baidu.tbadk.core.util.aw.h(coVar.azd, com.baidu.tieba.u.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.aw.h((View) coVar.azr, com.baidu.tieba.u.frs_item_abstract_more_text_bg);
        coVar.azl.setOnClickListener(this);
        com.baidu.adp.lib.util.m.a(this.mContext, coVar.azl, 0, 10, 0, 20);
        coVar.azo.setOnClickListener(this);
        com.baidu.adp.lib.util.m.a(this.mContext, coVar.azo, 0, 10, 0, 20);
        coVar.azr.setOnClickListener(this);
        coVar.azl.setOnTouchListener(new cn(this, null));
        coVar.azo.setTag(Integer.valueOf(i));
        coVar.azl.setTag(Integer.valueOf(i));
        coVar.azr.setTag(Integer.valueOf(i));
        this.aBp.getLayoutMode().L(this.mSkinType == 1);
        this.aBp.getLayoutMode().h(view);
        int i2 = i - this.aBX;
        if (i2 == 0) {
            com.baidu.tbadk.core.util.aw.h(coVar.azc, com.baidu.tieba.u.bg_frs);
        } else {
            coVar.azc.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.s.transparent));
        }
        coVar.azc.setPadding(0, i2 == 0 ? this.ayR : this.ayS, 0, 0);
        if (qVar != null && !TextUtils.isEmpty(qVar.getAddress()) && !TextUtils.isEmpty(qVar.getAddress().trim())) {
            coVar.aDC.setVisibility(0);
            coVar.aDE.setText(qVar.getAddress());
            com.baidu.tbadk.core.util.aw.c(coVar.aDD, com.baidu.tieba.u.icon_posts_pin_gray);
            if (this.mContext != null && this.mContext.getResources() != null) {
                com.baidu.tbadk.core.util.aw.b(coVar.aDE, com.baidu.tieba.s.cp_cont_c, 1);
            }
        } else {
            coVar.aDC.setVisibility(8);
        }
        coVar.azh.setText(com.baidu.tbadk.core.util.ay.j(qVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.k.js().ju()) {
            coVar.azk.setVisibility(0);
            String portrait = qVar.getAuthor().getPortrait();
            coVar.azk.setUserId(qVar.getAuthor().getUserId());
            coVar.azk.setImageDrawable(null);
            coVar.azk.c(portrait, 28, false);
        } else {
            coVar.azk.setVisibility(8);
        }
        coVar.azt.setOnClickListener(new ck(this, qVar));
        qVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = qVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            coVar.azj.setVisibility(0);
            com.baidu.tbadk.core.util.aw.b(coVar.azi, com.baidu.tieba.s.cp_cont_h, 1);
            coVar.azj.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            coVar.azj.setVisibility(8);
            com.baidu.tbadk.core.util.aw.b(coVar.azi, com.baidu.tieba.s.cp_cont_c, 1);
        }
        coVar.azi.setText(qVar.getAuthor().getUserName());
        coVar.azg.setVisibility(0);
        coVar.aze.setVisibility(0);
        qVar.parser_title();
        coVar.JM.setText(qVar.getSpan_str());
        com.baidu.tieba.util.o wJ = com.baidu.tieba.aj.wk().wJ();
        if (wJ != null && wJ.hH(qVar.getId())) {
            com.baidu.tbadk.core.util.aw.b(coVar.JM, com.baidu.tieba.s.listview_item_thread_read, 1);
        }
        if (qVar.kF() == 1) {
            coVar.JM.setVisibility(8);
        } else {
            coVar.JM.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (qVar.kB() != null && qVar.kB().trim().length() > 0) {
            stringBuffer.append(qVar.kB());
        }
        ArrayList<MediaData> medias = qVar.getMedias();
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
                    coVar.azr.setVisibility(0);
                    coVar.aze.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    coVar.azr.setVisibility(8);
                    coVar.aze.setText(stringBuffer.toString());
                }
            } else {
                coVar.azr.setVisibility(8);
                coVar.aze.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.k.js().jw()) {
            if (medias != null) {
                if (medias.size() > 0) {
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
                        coVar.azg.a(qVar, this.aBV.zJ().getName(), this.aBV.zJ().getId(), qVar.getTid());
                        coVar.azg.setShowBig(this.ayP);
                        coVar.azg.setDrawNum(true);
                        coVar.azg.setFromCDN(this.mIsFromCDN);
                        coVar.azg.a(mediaDataArr, i7);
                        coVar.azg.setImageFrom("other");
                    }
                } else {
                    coVar.azg.setVisibility(8);
                }
            }
        } else {
            coVar.azg.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> kE = qVar.kE();
        if (kE != null && kE.size() > 0) {
            coVar.azf.setVisibility(0);
            VoiceData.VoiceModel voiceModel = kE.get(0);
            coVar.azf.setVoiceModel(voiceModel);
            coVar.azf.setTag(voiceModel);
            coVar.azf.YI();
        } else {
            coVar.azf.setVisibility(8);
        }
        if (qVar.getPraise() != null && qVar.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.k.js().ju()) {
                coVar.azq.setVisibility(0);
                coVar.azq.setIsFromPb(false);
                coVar.azq.bN(this.mSkinType);
                coVar.azs.setVisibility(0);
                coVar.azq.a(qVar.getPraise(), qVar.getId(), qVar.getFirst_post_id(), false);
            } else {
                coVar.azq.setVisibility(8);
                coVar.azs.setVisibility(8);
            }
            if (qVar.getPraise().getIsLike() == 1) {
                com.baidu.tbadk.core.util.aw.c(coVar.azm, com.baidu.tieba.u.icon_hand_frs_click);
            } else {
                com.baidu.tbadk.core.util.aw.c(coVar.azm, com.baidu.tieba.u.icon_hand_frs_normal);
            }
            if (qVar.getPraise().getNum() <= 999999) {
                coVar.azn.setText(new StringBuilder().append(qVar.getPraise().getNum()).toString());
            } else {
                coVar.azn.setText("999999+");
            }
        } else {
            coVar.azs.setVisibility(8);
            coVar.azq.setVisibility(8);
            coVar.azn.setText(this.mContext.getResources().getString(com.baidu.tieba.y.frs_item_praise_text));
            com.baidu.tbadk.core.util.aw.c(coVar.azm, com.baidu.tieba.u.icon_hand_frs_normal);
        }
        int reply_num = qVar.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                coVar.azp.setText(String.valueOf(reply_num));
            } else {
                coVar.azp.setText(this.mContext.getResources().getString(com.baidu.tieba.y.frs_item_reply_text));
            }
        } else {
            coVar.azp.setText("999999+");
        }
        if (qVar.getAnchorInfoData() != null) {
            if (qVar.getAnchorInfoData().getGroup_id() != 0) {
                if (a(this.aDz, qVar.getAnchorInfoData().getGroup_id(), qVar.getLast_time_int())) {
                    coVar.azg.setVisibility(8);
                    coVar.azu.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(qVar.getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(qVar.getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(qVar.getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(qVar.getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(qVar.getAnchorInfoData().getIntro());
                    liveCardData.setLikers(qVar.getAnchorInfoData().getLikers());
                    liveCardData.setListeners(qVar.getAnchorInfoData().getListeners());
                    liveCardData.setName(qVar.getAnchorInfoData().getName());
                    liveCardData.setPortrait(qVar.getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(qVar.getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(qVar.getAnchorInfoData().getStartTime());
                    coVar.azv.setData(liveCardData);
                    coVar.azv.setStatisticsKey("notice_frs_live");
                    return view;
                }
                return new View(this.mContext);
            }
            coVar.azu.setVisibility(8);
            return view;
        }
        return view;
    }

    public void z(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.praise_animation_scale1));
    }

    public void d(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new cl(this), 600L);
        }
    }

    public void c(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new cm(this), 200L);
        }
    }

    public void bL(boolean z) {
        if (this.ayP != z) {
            this.ayP = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBW != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) ai(intValue);
            View childAt = this.ayV.getChildAt(intValue - (this.ayV.getFirstVisiblePosition() - this.ayV.getHeaderViewsCount()));
            if (view.getId() == EL()) {
                if (this.ayU) {
                    this.aBW.a(id, intValue, view, childAt, qVar);
                    return;
                }
                return;
            }
            this.aBW.a(id, intValue, view, childAt, qVar);
        }
    }

    public int EL() {
        return com.baidu.tieba.v.frs_praise_btn;
    }

    public int EM() {
        return com.baidu.tieba.v.frs_reply_btn;
    }

    public int EN() {
        return com.baidu.tieba.v.frs_more_abstract;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof co);
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
}
