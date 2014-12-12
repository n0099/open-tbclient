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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class cg extends bi<com.baidu.tbadk.core.data.w> implements View.OnClickListener {
    private boolean aAZ;
    private FrsActivity aDc;
    private HashMap<Integer, Long> aFk;
    private boolean isPraiseToServer;
    private long praiseStopTime;

    public cg(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aAZ = false;
        this.praiseStopTime = 0L;
        this.isPraiseToServer = true;
        this.aDc = frsActivity;
        this.aFk = new HashMap<>();
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        this.mListView = (ListView) viewGroup;
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_item, null);
        cl clVar = new cl(this);
        clVar.aBg = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list);
        clVar.aBx = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_item_user_info_view);
        clVar.aBh = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_item_top_linear_layout);
        clVar.aBo = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.frs_photo);
        clVar.aBn = (UserIconBox) inflate.findViewById(com.baidu.tieba.w.frs_user_tshow_icon_box);
        clVar.aBm = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_author);
        clVar.aBl = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_reply_time);
        clVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_title);
        clVar.aBi = (TextView) inflate.findViewById(com.baidu.tieba.w.abstract_text);
        clVar.aBj = (PlayVoiceBnt) inflate.findViewById(com.baidu.tieba.w.abstract_voice);
        clVar.aBk = (FrsCommonImageLayout) inflate.findViewById(com.baidu.tieba.w.abstract_img_layout);
        clVar.aBp = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_praise_btn);
        clVar.aBq = (ImageView) inflate.findViewById(com.baidu.tieba.w.frs_praise_icon);
        clVar.aBr = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_praise_num);
        clVar.aFq = (TextView) inflate.findViewById(com.baidu.tieba.w.action_button);
        clVar.aBs = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_reply_btn);
        clVar.aBt = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_reply_num);
        clVar.aBu = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.w.frs_praise_list_user_icon);
        clVar.aBv = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_more_abstract);
        clVar.aBw = inflate.findViewById(com.baidu.tieba.w.frs_item_praise_divider_line);
        clVar.aBy = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.live_card_layout);
        clVar.aBz = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.w.item_card);
        clVar.aFr = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_item_location_container);
        clVar.aFt = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_item_location_address);
        clVar.aFs = (ImageView) inflate.findViewById(com.baidu.tieba.w.frs_item_location_img);
        inflate.setTag(clVar);
        return inflate;
    }

    @Override // com.baidu.tieba.frs.bi, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar) {
        super.b(i, view, viewGroup, wVar);
        return a(i, view, wVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.w wVar) {
        cl clVar = (cl) view.getTag();
        com.baidu.tbadk.core.util.ax.i(clVar.aBh, com.baidu.tieba.v.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.ax.i((View) clVar.aBv, com.baidu.tieba.v.frs_item_abstract_more_text_bg);
        clVar.aBp.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.mContext, clVar.aBp, 0, 10, 0, 20);
        clVar.aBs.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.mContext, clVar.aBs, 0, 10, 0, 20);
        clVar.aFq.setOnClickListener(this);
        clVar.aBv.setOnClickListener(this);
        clVar.aBp.setOnTouchListener(new cm(this, null));
        clVar.aBs.setTag(Integer.valueOf(i));
        clVar.aBp.setTag(Integer.valueOf(i));
        clVar.aFq.setTag(Integer.valueOf(i));
        clVar.aBv.setTag(Integer.valueOf(i));
        this.aDc.getLayoutMode().ab(this.mSkinType == 1);
        this.aDc.getLayoutMode().h(view);
        int i2 = i - this.aDJ;
        if (i2 == 0) {
            com.baidu.tbadk.core.util.ax.i(clVar.aBg, com.baidu.tieba.v.bg_frs);
        } else {
            clVar.aBg.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.t.transparent));
        }
        clVar.aBg.setPadding(0, i2 == 0 ? this.aBb : this.aBc, 0, 0);
        if (wVar != null && !wVar.nH() && !TextUtils.isEmpty(wVar.getAddress()) && !TextUtils.isEmpty(wVar.getAddress().trim())) {
            String address = wVar.getAddress();
            String nB = wVar.nB();
            String nC = wVar.nC();
            clVar.aFr.setVisibility(0);
            com.baidu.adp.lib.util.l.a(this.aDc.getPageContext().getPageActivity(), clVar.aFr, 0, 10, 0, 10);
            clVar.aFt.setText(address);
            com.baidu.tbadk.core.util.ax.c(clVar.aFs, com.baidu.tieba.v.icon_frs_site);
            if (this.mContext != null && this.mContext.getResources() != null) {
                com.baidu.tbadk.core.util.ax.b(clVar.aFt, com.baidu.tieba.t.cp_cont_c, 1);
            }
            clVar.aFr.setEnabled(true);
            clVar.aFr.setOnClickListener(new ch(this, nB, nC, address));
        } else {
            clVar.aFr.setEnabled(false);
            clVar.aFr.setVisibility(8);
        }
        clVar.aBl.setText(com.baidu.tbadk.core.util.ba.n(wVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.mc().me()) {
            clVar.aBo.setVisibility(0);
            String portrait = wVar.getAuthor().getPortrait();
            clVar.aBo.setUserId(wVar.getAuthor().getUserId());
            clVar.aBo.setImageDrawable(null);
            clVar.aBo.d(portrait, 28, false);
        } else {
            clVar.aBo.setVisibility(8);
        }
        clVar.aBx.setOnClickListener(new ci(this, wVar));
        wVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = wVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            clVar.aBn.setVisibility(0);
            com.baidu.tbadk.core.util.ax.b(clVar.aBm, com.baidu.tieba.t.cp_cont_h, 1);
            clVar.aBn.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
        } else {
            clVar.aBn.setVisibility(8);
            com.baidu.tbadk.core.util.ax.b(clVar.aBm, com.baidu.tieba.t.cp_cont_c, 1);
        }
        clVar.aBm.setText(wVar.getAuthor().getUserName());
        clVar.aBk.setVisibility(0);
        clVar.aBi.setVisibility(0);
        wVar.parser_title();
        clVar.mTitle.setText(wVar.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.ip(wVar.getId())) {
            com.baidu.tbadk.core.util.ax.b(clVar.mTitle, com.baidu.tieba.t.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ax.b(clVar.aBi, com.baidu.tieba.t.cp_cont_c, 1);
        }
        if (wVar.nA() == 1) {
            clVar.mTitle.setVisibility(8);
        } else {
            clVar.mTitle.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (wVar.nv() != null && wVar.nv().trim().length() > 0) {
            stringBuffer.append(wVar.nv());
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
                    clVar.aBv.setVisibility(0);
                    clVar.aBi.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    clVar.aBv.setVisibility(8);
                    clVar.aBi.setText(stringBuffer.toString());
                }
            } else {
                clVar.aBv.setVisibility(8);
                clVar.aBi.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.mc().mg()) {
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
                        clVar.aBk.a(wVar, this.aDH.aej().getName(), this.aDH.aej().getId(), wVar.getTid());
                        clVar.aBk.setShowBig(this.aAZ);
                        clVar.aBk.setDrawNum(true);
                        clVar.aBk.setFromCDN(this.mIsFromCDN);
                        clVar.aBk.a(this.aDc.getPageContext(), mediaDataArr, i7);
                        clVar.aBk.setImageFrom("other");
                    }
                } else {
                    clVar.aBk.setVisibility(8);
                }
            }
        } else {
            clVar.aBk.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> nz = wVar.nz();
        if (nz != null && nz.size() > 0) {
            clVar.aBj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = nz.get(0);
            clVar.aBj.setVoiceModel(voiceModel);
            clVar.aBj.setTag(voiceModel);
            clVar.aBj.Zf();
        } else {
            clVar.aBj.setVisibility(8);
        }
        if (wVar.getPraise() != null && wVar.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                clVar.aBu.setVisibility(0);
                clVar.aBu.setIsFromPb(false);
                clVar.aBu.cm(this.mSkinType);
                clVar.aBw.setVisibility(0);
                clVar.aBu.a(wVar.getPraise(), wVar.getId(), wVar.getFirst_post_id(), false);
            } else {
                clVar.aBu.setVisibility(8);
                clVar.aBw.setVisibility(8);
            }
            if (wVar.getPraise().getIsLike() == 1) {
                com.baidu.tbadk.core.util.ax.c(clVar.aBq, com.baidu.tieba.v.icon_hand_frs_click);
            } else {
                com.baidu.tbadk.core.util.ax.c(clVar.aBq, com.baidu.tieba.v.icon_hand_frs_normal);
            }
            clVar.aBr.setText(com.baidu.tbadk.core.util.ba.p(wVar.getPraise().getNum()));
        } else {
            clVar.aBw.setVisibility(8);
            clVar.aBu.setVisibility(8);
            clVar.aBr.setText(this.mContext.getResources().getString(com.baidu.tieba.z.frs_item_praise_text));
            com.baidu.tbadk.core.util.ax.c(clVar.aBq, com.baidu.tieba.v.icon_hand_frs_normal);
        }
        int reply_num = wVar.getReply_num();
        if (reply_num > 0) {
            clVar.aBt.setText(com.baidu.tbadk.core.util.ba.p(reply_num));
        } else {
            clVar.aBt.setText(this.mContext.getResources().getString(com.baidu.tieba.z.frs_item_reply_text));
        }
        if (wVar.nH()) {
            clVar.mTitle.setMaxLines(2);
            clVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            if (wVar.nG() == 1) {
                if (wVar.ny().get(0).getStatus() == 1) {
                    clVar.aFq.setText(this.mContext.getResources().getString(com.baidu.tieba.z.i_want_lottery));
                    clVar.aFq.setVisibility(0);
                } else {
                    clVar.aFq.setVisibility(8);
                }
            } else if (wVar.nG() == 2) {
                if (wVar.ny().get(0).getStatus() == 1) {
                    clVar.aFq.setText(this.mContext.getResources().getString(com.baidu.tieba.z.i_want_share_picture));
                    clVar.aFq.setVisibility(0);
                } else {
                    clVar.aFq.setVisibility(8);
                }
            } else {
                clVar.aFq.setVisibility(8);
                clVar.mTitle.setMaxLines(Integer.MAX_VALUE);
                clVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            clVar.aFq.setVisibility(8);
        }
        if (wVar.getAnchorInfoData() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (wVar.getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                if (a(this.aFk, wVar.getAnchorInfoData().getGroup_id(), wVar.getLast_time_int())) {
                    clVar.aBk.setVisibility(8);
                    clVar.aBy.setVisibility(0);
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
                    clVar.aBz.setData(liveCardData);
                    clVar.aBz.setStatisticsKey("notice_frs_live");
                    return view;
                }
                return new View(this.mContext);
            }
            clVar.aBy.setVisibility(8);
            return view;
        }
        return view;
    }

    public void praiseAnimDown(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.praise_animation_scale1));
    }

    public void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.praise_animation_scale3));
            new Handler().postDelayed(new cj(this), 600L);
        }
    }

    public void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.q.praise_animation_scale2));
            new Handler().postDelayed(new ck(this), 200L);
        }
    }

    public void bA(boolean z) {
        if (this.aAZ != z) {
            this.aAZ = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aDI != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) ay(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == Fe()) {
                if (this.isPraiseToServer) {
                    this.aDI.a(id, intValue, view, childAt, wVar);
                    return;
                }
                return;
            }
            this.aDI.a(id, intValue, view, childAt, wVar);
        }
    }

    public int Fe() {
        return com.baidu.tieba.w.frs_praise_btn;
    }

    public int Ff() {
        return com.baidu.tieba.w.frs_reply_btn;
    }

    public int Fg() {
        return com.baidu.tieba.w.frs_more_abstract;
    }

    public int FV() {
        return com.baidu.tieba.w.action_button;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cl);
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
