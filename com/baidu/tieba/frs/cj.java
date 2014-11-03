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
    private HashMap<Integer, Long> aDJ;
    private boolean ayY;
    private long azc;
    private boolean azd;

    public cj(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.ayY = false;
        this.azc = 0L;
        this.azd = true;
        this.aDJ = new HashMap<>();
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        this.aze = (ListView) viewGroup;
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item, null);
        co coVar = new co(this, null);
        coVar.azl = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list);
        coVar.azC = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
        coVar.azm = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
        coVar.azt = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.frs_photo);
        coVar.azs = (UserIconBox) inflate.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
        coVar.azr = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_lv_author);
        coVar.azq = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
        coVar.JN = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_lv_title);
        coVar.azn = (TextView) inflate.findViewById(com.baidu.tieba.v.abstract_text);
        coVar.azo = (PlayVoiceBnt) inflate.findViewById(com.baidu.tieba.v.abstract_voice);
        coVar.azp = (FrsCommonImageLayout) inflate.findViewById(com.baidu.tieba.v.abstract_img_layout);
        coVar.azu = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_praise_btn);
        coVar.azv = (ImageView) inflate.findViewById(com.baidu.tieba.v.frs_praise_icon);
        coVar.azw = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_praise_num);
        coVar.azx = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_reply_btn);
        coVar.azy = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_reply_num);
        coVar.azz = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.v.frs_praise_list_user_icon);
        coVar.azA = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_more_abstract);
        coVar.azB = inflate.findViewById(com.baidu.tieba.v.frs_item_praise_divider_line);
        coVar.azD = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.live_card_layout);
        coVar.azE = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.v.item_card);
        coVar.aDM = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_item_location_container);
        coVar.aDO = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_item_location_address);
        coVar.aDN = (ImageView) inflate.findViewById(com.baidu.tieba.v.frs_item_location_img);
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
        com.baidu.tbadk.core.util.aw.h(coVar.azm, com.baidu.tieba.u.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.aw.h((View) coVar.azA, com.baidu.tieba.u.frs_item_abstract_more_text_bg);
        coVar.azu.setOnClickListener(this);
        com.baidu.adp.lib.util.m.a(this.mContext, coVar.azu, 0, 10, 0, 20);
        coVar.azx.setOnClickListener(this);
        com.baidu.adp.lib.util.m.a(this.mContext, coVar.azx, 0, 10, 0, 20);
        coVar.azA.setOnClickListener(this);
        coVar.azu.setOnTouchListener(new cn(this, null));
        coVar.azx.setTag(Integer.valueOf(i));
        coVar.azu.setTag(Integer.valueOf(i));
        coVar.azA.setTag(Integer.valueOf(i));
        this.aBz.getLayoutMode().L(this.mSkinType == 1);
        this.aBz.getLayoutMode().h(view);
        int i2 = i - this.aCh;
        if (i2 == 0) {
            com.baidu.tbadk.core.util.aw.h(coVar.azl, com.baidu.tieba.u.bg_frs);
        } else {
            coVar.azl.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.s.transparent));
        }
        coVar.azl.setPadding(0, i2 == 0 ? this.aza : this.azb, 0, 0);
        if (qVar != null && !TextUtils.isEmpty(qVar.getAddress()) && !TextUtils.isEmpty(qVar.getAddress().trim())) {
            coVar.aDM.setVisibility(0);
            coVar.aDO.setText(qVar.getAddress());
            com.baidu.tbadk.core.util.aw.c(coVar.aDN, com.baidu.tieba.u.icon_posts_pin_gray);
            if (this.mContext != null && this.mContext.getResources() != null) {
                com.baidu.tbadk.core.util.aw.b(coVar.aDO, com.baidu.tieba.s.cp_cont_c, 1);
            }
        } else {
            coVar.aDM.setVisibility(8);
        }
        coVar.azq.setText(com.baidu.tbadk.core.util.az.j(qVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.js().ju()) {
            coVar.azt.setVisibility(0);
            String portrait = qVar.getAuthor().getPortrait();
            coVar.azt.setUserId(qVar.getAuthor().getUserId());
            coVar.azt.setImageDrawable(null);
            coVar.azt.c(portrait, 28, false);
        } else {
            coVar.azt.setVisibility(8);
        }
        coVar.azC.setOnClickListener(new ck(this, qVar));
        qVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = qVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            coVar.azs.setVisibility(0);
            com.baidu.tbadk.core.util.aw.b(coVar.azr, com.baidu.tieba.s.cp_cont_h, 1);
            coVar.azs.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            coVar.azs.setVisibility(8);
            com.baidu.tbadk.core.util.aw.b(coVar.azr, com.baidu.tieba.s.cp_cont_c, 1);
        }
        coVar.azr.setText(qVar.getAuthor().getUserName());
        coVar.azp.setVisibility(0);
        coVar.azn.setVisibility(0);
        qVar.parser_title();
        coVar.JN.setText(qVar.getSpan_str());
        com.baidu.tieba.util.o wL = com.baidu.tieba.aj.wm().wL();
        if (wL != null && wL.hH(qVar.getId())) {
            com.baidu.tbadk.core.util.aw.b(coVar.JN, com.baidu.tieba.s.listview_item_thread_read, 1);
        }
        if (qVar.kF() == 1) {
            coVar.JN.setVisibility(8);
        } else {
            coVar.JN.setVisibility(0);
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
                    coVar.azA.setVisibility(0);
                    coVar.azn.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    coVar.azA.setVisibility(8);
                    coVar.azn.setText(stringBuffer.toString());
                }
            } else {
                coVar.azA.setVisibility(8);
                coVar.azn.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.js().jw()) {
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
                        coVar.azp.a(qVar, this.aCf.zL().getName(), this.aCf.zL().getId(), qVar.getTid());
                        coVar.azp.setShowBig(this.ayY);
                        coVar.azp.setDrawNum(true);
                        coVar.azp.setFromCDN(this.mIsFromCDN);
                        coVar.azp.a(mediaDataArr, i7);
                        coVar.azp.setImageFrom("other");
                    }
                } else {
                    coVar.azp.setVisibility(8);
                }
            }
        } else {
            coVar.azp.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> kE = qVar.kE();
        if (kE != null && kE.size() > 0) {
            coVar.azo.setVisibility(0);
            VoiceData.VoiceModel voiceModel = kE.get(0);
            coVar.azo.setVoiceModel(voiceModel);
            coVar.azo.setTag(voiceModel);
            coVar.azo.YL();
        } else {
            coVar.azo.setVisibility(8);
        }
        if (qVar.getPraise() != null && qVar.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.js().ju()) {
                coVar.azz.setVisibility(0);
                coVar.azz.setIsFromPb(false);
                coVar.azz.bN(this.mSkinType);
                coVar.azB.setVisibility(0);
                coVar.azz.a(qVar.getPraise(), qVar.getId(), qVar.getFirst_post_id(), false);
            } else {
                coVar.azz.setVisibility(8);
                coVar.azB.setVisibility(8);
            }
            if (qVar.getPraise().getIsLike() == 1) {
                com.baidu.tbadk.core.util.aw.c(coVar.azv, com.baidu.tieba.u.icon_hand_frs_click);
            } else {
                com.baidu.tbadk.core.util.aw.c(coVar.azv, com.baidu.tieba.u.icon_hand_frs_normal);
            }
            if (qVar.getPraise().getNum() <= 999999) {
                coVar.azw.setText(new StringBuilder().append(qVar.getPraise().getNum()).toString());
            } else {
                coVar.azw.setText("999999+");
            }
        } else {
            coVar.azB.setVisibility(8);
            coVar.azz.setVisibility(8);
            coVar.azw.setText(this.mContext.getResources().getString(com.baidu.tieba.y.frs_item_praise_text));
            com.baidu.tbadk.core.util.aw.c(coVar.azv, com.baidu.tieba.u.icon_hand_frs_normal);
        }
        int reply_num = qVar.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                coVar.azy.setText(String.valueOf(reply_num));
            } else {
                coVar.azy.setText(this.mContext.getResources().getString(com.baidu.tieba.y.frs_item_reply_text));
            }
        } else {
            coVar.azy.setText("999999+");
        }
        if (qVar.getAnchorInfoData() != null) {
            if (qVar.getAnchorInfoData().getGroup_id() != 0) {
                if (a(this.aDJ, qVar.getAnchorInfoData().getGroup_id(), qVar.getLast_time_int())) {
                    coVar.azp.setVisibility(8);
                    coVar.azD.setVisibility(0);
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
                    coVar.azE.setData(liveCardData);
                    coVar.azE.setStatisticsKey("notice_frs_live");
                    return view;
                }
                return new View(this.mContext);
            }
            coVar.azD.setVisibility(8);
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
        if (this.ayY != z) {
            this.ayY = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCg != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) ai(intValue);
            View childAt = this.aze.getChildAt(intValue - (this.aze.getFirstVisiblePosition() - this.aze.getHeaderViewsCount()));
            if (view.getId() == EN()) {
                if (this.azd) {
                    this.aCg.a(id, intValue, view, childAt, qVar);
                    return;
                }
                return;
            }
            this.aCg.a(id, intValue, view, childAt, qVar);
        }
    }

    public int EN() {
        return com.baidu.tieba.v.frs_praise_btn;
    }

    public int EO() {
        return com.baidu.tieba.v.frs_reply_btn;
    }

    public int EP() {
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
