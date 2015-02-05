package com.baidu.tieba.frs;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class cf extends bh<com.baidu.tbadk.core.data.x> implements View.OnClickListener {
    private boolean aBX;
    private FrsActivity aEa;
    private int aGk;
    private int aGl;
    private int aGm;
    private HashMap<Integer, Long> aGn;
    private boolean aGo;
    private com.baidu.adp.lib.e.b<cl> aGp;
    private boolean isPraiseToServer;
    private long praiseStopTime;

    public cf(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aBX = false;
        this.praiseStopTime = 0L;
        this.isPraiseToServer = true;
        this.aGk = 0;
        this.aGl = 0;
        this.aGm = 0;
        this.aGo = TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aGp = new com.baidu.adp.lib.e.b<>(new cg(this), 5, 0);
        this.aEa = frsActivity;
        this.aGn = new HashMap<>();
        this.aGk = com.baidu.adp.lib.util.l.d(this.aEa.getPageContext().getPageActivity(), com.baidu.tieba.u.ds18);
        this.aGl = com.baidu.adp.lib.util.l.d(this.aEa.getPageContext().getPageActivity(), com.baidu.tieba.u.ds18);
        this.aGm = com.baidu.adp.lib.util.l.d(this.aEa.getPageContext().getPageActivity(), com.baidu.tieba.u.ds70);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        this.mListView = (ListView) viewGroup;
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item, null);
        cm cmVar = new cm(this);
        cmVar.aCe = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list);
        cmVar.aCv = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_item_user_info_view);
        cmVar.aCf = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_item_top_linear_layout);
        cmVar.aGv = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.new_year_color_egg);
        cmVar.aCm = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.frs_photo);
        cmVar.aCl = (UserIconBox) inflate.findViewById(com.baidu.tieba.w.frs_user_tshow_icon_box);
        cmVar.aCk = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_author);
        cmVar.aCj = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_reply_time);
        cmVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_title);
        cmVar.aCg = (TextView) inflate.findViewById(com.baidu.tieba.w.abstract_text);
        cmVar.aCh = (PlayVoiceBnt) inflate.findViewById(com.baidu.tieba.w.abstract_voice);
        cmVar.aCi = (FrsCommonImageLayout) inflate.findViewById(com.baidu.tieba.w.abstract_img_layout);
        cmVar.aCn = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_praise_btn);
        cmVar.aCo = (ImageView) inflate.findViewById(com.baidu.tieba.w.frs_praise_icon);
        cmVar.aCp = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_praise_num);
        cmVar.aGw = (TextView) inflate.findViewById(com.baidu.tieba.w.action_button);
        cmVar.aCq = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_reply_btn);
        cmVar.aCr = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_reply_num);
        cmVar.aCs = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.w.frs_praise_list_user_icon);
        cmVar.aCt = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_more_abstract);
        cmVar.aCu = inflate.findViewById(com.baidu.tieba.w.frs_item_praise_divider_line);
        cmVar.aGy = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_item_location_container);
        cmVar.aGA = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_item_location_address);
        cmVar.aGz = (ImageView) inflate.findViewById(com.baidu.tieba.w.frs_item_location_img);
        inflate.setTag(cmVar);
        com.baidu.adp.lib.util.l.a(this.mContext, cmVar.aCn, 0, 10, 0, 20);
        cmVar.aCq.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.mContext, cmVar.aCq, 0, 10, 0, 20);
        cmVar.aCn.setOnClickListener(this);
        cmVar.aCq.setOnClickListener(this);
        cmVar.aGw.setOnClickListener(this);
        cmVar.aCt.setOnClickListener(this);
        cmVar.aCn.setOnTouchListener(new cn(this, null));
        return inflate;
    }

    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.x xVar) {
        super.b(i, view, viewGroup, xVar);
        return a(i, view, xVar);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.x xVar) {
        int i2;
        boolean z;
        int i3;
        cm cmVar = (cm) view.getTag();
        if (xVar != null && xVar.nG() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            layoutParams.setMargins(this.aGk, 0, this.aGl, 0);
            cmVar.aCf.setLayoutParams(layoutParams);
            cmVar.aGv.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aGk, this.aGm, this.aGl, 0);
            layoutParams2.gravity = 17;
            cmVar.aCf.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.bc.i(cmVar.aGv, com.baidu.tieba.v.yangnian2);
            cmVar.aGv.setVisibility(0);
        }
        i2 = cmVar.Yh;
        if (i2 != this.mSkinType) {
            com.baidu.tbadk.core.util.bc.i(cmVar.aCf, com.baidu.tieba.v.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.bc.i((View) cmVar.aCt, com.baidu.tieba.v.frs_item_abstract_more_text_bg);
            this.aEa.getLayoutMode().ab(this.mSkinType == 1);
            this.aEa.getLayoutMode().h(view);
        }
        cmVar.aCq.setTag(Integer.valueOf(i));
        cmVar.aCn.setTag(Integer.valueOf(i));
        cmVar.aGw.setTag(Integer.valueOf(i));
        cmVar.aCt.setTag(Integer.valueOf(i));
        int i4 = i - this.aEH;
        if (i4 == 0) {
            com.baidu.tbadk.core.util.bc.i(cmVar.aCe, com.baidu.tieba.v.bg_frs);
        } else {
            cmVar.aCe.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.t.transparent));
        }
        cmVar.aCe.setPadding(0, i4 == 0 ? this.aBZ : this.aCa, 0, 0);
        if (xVar != null && !xVar.nC() && !TextUtils.isEmpty(xVar.getAddress()) && !TextUtils.isEmpty(xVar.getAddress().trim())) {
            String address = xVar.getAddress();
            String nw = xVar.nw();
            String nx = xVar.nx();
            cmVar.aGy.setVisibility(0);
            com.baidu.adp.lib.util.l.a(this.aEa.getPageContext().getPageActivity(), cmVar.aGy, 0, 10, 0, 10);
            cmVar.aGA.setText(address);
            com.baidu.tbadk.core.util.bc.c(cmVar.aGz, com.baidu.tieba.v.icon_frs_site);
            if (this.mContext != null && this.mContext.getResources() != null) {
                com.baidu.tbadk.core.util.bc.b(cmVar.aGA, com.baidu.tieba.t.cp_cont_c, 1);
            }
            cmVar.aGy.setEnabled(true);
            cmVar.aGy.setOnClickListener(new ch(this, nw, nx, address));
        } else {
            cmVar.aGy.setEnabled(false);
            cmVar.aGy.setVisibility(4);
        }
        cmVar.aCj.setText(com.baidu.tbadk.core.util.bf.n(xVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.lV().lX()) {
            cmVar.aCm.setVisibility(0);
            String portrait = xVar.getAuthor().getPortrait();
            cmVar.aCm.setUserId(xVar.getAuthor().getUserId());
            cmVar.aCm.setImageDrawable(null);
            cmVar.aCm.d(portrait, 28, false);
        } else {
            cmVar.aCm.setVisibility(8);
        }
        cmVar.aCv.setOnClickListener(new ci(this, xVar));
        xVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = xVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            cmVar.aCl.setVisibility(0);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCk, com.baidu.tieba.t.cp_cont_h, 1);
            cmVar.aCl.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
        } else {
            cmVar.aCl.setVisibility(8);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCk, com.baidu.tieba.t.cp_cont_c, 1);
        }
        cmVar.aCk.setText(xVar.getAuthor().getUserName());
        cmVar.aCi.setVisibility(0);
        cmVar.aCg.setVisibility(0);
        xVar.parser_title();
        cmVar.mTitle.setText(xVar.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iu(xVar.getId())) {
            com.baidu.tbadk.core.util.bc.b(cmVar.mTitle, com.baidu.tieba.t.cp_cont_c, 1);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCg, com.baidu.tieba.t.cp_cont_c, 1);
        } else {
            com.baidu.tbadk.core.util.bc.b(cmVar.mTitle, com.baidu.tieba.t.cp_cont_b, 1);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCg, com.baidu.tieba.t.cp_cont_b, 1);
        }
        if (xVar.nv() == 1) {
            cmVar.mTitle.setVisibility(8);
        } else {
            cmVar.mTitle.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (xVar.nq() != null && xVar.nq().trim().length() > 0) {
            stringBuffer.append(xVar.nq());
        }
        ArrayList<MediaData> medias = xVar.getMedias();
        if (medias != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= medias.size()) {
                    break;
                }
                if (medias.get(i6).getVideoUrl() != null && medias.get(i6).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(medias.get(i6).getVideoUrl());
                }
                i5 = i6 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    cmVar.aCt.setVisibility(0);
                    cmVar.aCg.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    cmVar.aCt.setVisibility(8);
                    cmVar.aCg.setText(stringBuffer.toString());
                }
            } else {
                cmVar.aCt.setVisibility(8);
                cmVar.aCg.setVisibility(8);
            }
        }
        if (xVar.getAnchorInfoData() == null || !this.aGo || xVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aGn, xVar.getAnchorInfoData().getGroup_id(), xVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (cmVar.aGx == null) {
                cmVar.aGx = this.aGp.ea();
                cmVar.aCf.addView(cmVar.aGx.aCw, cmVar.aCf.indexOfChild(cmVar.aCi) + 1);
            }
            i3 = cmVar.aGx.Yh;
            if (i3 != this.mSkinType) {
                this.aEa.getLayoutMode().ab(this.mSkinType == 1);
                this.aEa.getLayoutMode().h(cmVar.aGx.aCw);
                cmVar.aGx.Yh = this.mSkinType;
            }
            cmVar.aCi.setVisibility(8);
            cmVar.aGx.aCw.setVisibility(0);
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
            cmVar.aGx.aCx.setData(liveCardData);
            cmVar.aGx.aCx.setStatisticsKey("notice_frs_live");
        } else if (cmVar.aGx != null) {
            this.aGp.j(cmVar.aGx);
            cmVar.aCf.removeView(cmVar.aGx.aCw);
            cmVar.aGx = null;
        }
        if (com.baidu.tbadk.core.l.lV().lZ() && medias != null && medias.size() > 0 && !z) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = i7;
                if (i10 >= medias.size()) {
                    break;
                }
                if (medias.get(i10) != null && (medias.get(i10).getType() == 3 || medias.get(i10).getType() == 5)) {
                    i8++;
                    i9++;
                }
                i7 = i10 + 1;
            }
            if (i8 > 0) {
                MediaData[] mediaDataArr = new MediaData[i8];
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    int i13 = i11;
                    int i14 = i12;
                    if (i13 >= medias.size() || i14 >= i8) {
                        break;
                    }
                    if (medias.get(i13).getType() == 3 || medias.get(i13).getType() == 5) {
                        mediaDataArr[i14] = medias.get(i13);
                        i12 = i14 + 1;
                    } else {
                        i12 = i14;
                    }
                    i11 = i13 + 1;
                }
                cmVar.aCi.setVisibility(0);
                cmVar.aCi.a(xVar, this.aEF.aeI().getName(), this.aEF.aeI().getId(), xVar.getTid());
                cmVar.aCi.setShowBig(this.aBX);
                cmVar.aCi.setDrawNum(true);
                cmVar.aCi.setFromCDN(this.mIsFromCDN);
                cmVar.aCi.a(this.aEa.getPageContext(), mediaDataArr, i9);
                cmVar.aCi.setImageFrom("other");
            } else {
                cmVar.aCi.setVisibility(8);
            }
        } else {
            cmVar.aCi.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> nu = xVar.nu();
        if (nu != null && nu.size() > 0) {
            cmVar.aCh.setVisibility(0);
            VoiceData.VoiceModel voiceModel = nu.get(0);
            cmVar.aCh.setVoiceModel(voiceModel);
            cmVar.aCh.setTag(voiceModel);
            cmVar.aCh.ZF();
            if (voiceModel != null) {
                cmVar.aCh.gK(voiceModel.voice_status.intValue());
            }
        } else {
            cmVar.aCh.setVisibility(8);
        }
        if (xVar.getPraise() != null && xVar.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.lV().lX()) {
                cmVar.aCs.setVisibility(0);
                cmVar.aCs.setIsFromPb(false);
                cmVar.aCs.ct(this.mSkinType);
                cmVar.aCu.setVisibility(0);
                cmVar.aCs.a(xVar.getPraise(), xVar.getId(), xVar.getFirst_post_id(), false);
            } else {
                cmVar.aCs.setVisibility(8);
                cmVar.aCu.setVisibility(8);
            }
            if (xVar.getPraise().getIsLike() == 1) {
                com.baidu.tbadk.core.util.bc.c(cmVar.aCo, com.baidu.tieba.v.icon_hand_frs_click);
            } else {
                com.baidu.tbadk.core.util.bc.c(cmVar.aCo, com.baidu.tieba.v.icon_hand_frs_normal);
            }
            cmVar.aCp.setText(com.baidu.tbadk.core.util.bf.p(xVar.getPraise().getNum()));
        } else {
            cmVar.aCu.setVisibility(8);
            cmVar.aCs.setVisibility(8);
            cmVar.aCp.setText(this.mContext.getResources().getString(com.baidu.tieba.z.frs_item_praise_text));
            com.baidu.tbadk.core.util.bc.c(cmVar.aCo, com.baidu.tieba.v.icon_hand_frs_normal);
        }
        int reply_num = xVar.getReply_num();
        if (reply_num > 0) {
            cmVar.aCr.setText(com.baidu.tbadk.core.util.bf.p(reply_num));
        } else {
            cmVar.aCr.setText(this.mContext.getResources().getString(com.baidu.tieba.z.frs_item_reply_text));
        }
        if (xVar.nC()) {
            cmVar.mTitle.setMaxLines(2);
            cmVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            if (xVar.nB() == 1) {
                if (xVar.nt().get(0).getStatus() == 1) {
                    cmVar.aGw.setText(this.mContext.getResources().getString(com.baidu.tieba.z.i_want_lottery));
                    cmVar.aGw.setVisibility(0);
                } else {
                    cmVar.aGw.setVisibility(8);
                }
            } else if (xVar.nB() == 2) {
                if (xVar.nt().get(0).getStatus() == 1) {
                    cmVar.aGw.setText(this.mContext.getResources().getString(com.baidu.tieba.z.i_want_share_picture));
                    cmVar.aGw.setVisibility(0);
                } else {
                    cmVar.aGw.setVisibility(8);
                }
            } else {
                cmVar.aGw.setVisibility(8);
                cmVar.mTitle.setMaxLines(Integer.MAX_VALUE);
                cmVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            cmVar.aGw.setVisibility(8);
        }
        cmVar.Yh = this.mSkinType;
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

    public void bD(boolean z) {
        if (this.aBX != z) {
            this.aBX = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aEG != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) aD(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == Fw()) {
                if (this.isPraiseToServer) {
                    this.aEG.a(id, intValue, view, childAt, xVar);
                    return;
                }
                return;
            }
            this.aEG.a(id, intValue, view, childAt, xVar);
        }
    }

    public int Fw() {
        return com.baidu.tieba.w.frs_praise_btn;
    }

    public int Fx() {
        return com.baidu.tieba.w.frs_reply_btn;
    }

    public int Fy() {
        return com.baidu.tieba.w.frs_more_abstract;
    }

    public int Gm() {
        return com.baidu.tieba.w.action_button;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cm);
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
