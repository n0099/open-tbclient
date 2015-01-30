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
    private boolean aCa;
    private FrsActivity aEd;
    private int aGn;
    private int aGo;
    private int aGp;
    private HashMap<Integer, Long> aGq;
    private boolean aGr;
    private com.baidu.adp.lib.e.b<cl> aGs;
    private boolean isPraiseToServer;
    private long praiseStopTime;

    public cf(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aCa = false;
        this.praiseStopTime = 0L;
        this.isPraiseToServer = true;
        this.aGn = 0;
        this.aGo = 0;
        this.aGp = 0;
        this.aGr = TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.aGs = new com.baidu.adp.lib.e.b<>(new cg(this), 5, 0);
        this.aEd = frsActivity;
        this.aGq = new HashMap<>();
        this.aGn = com.baidu.adp.lib.util.l.d(this.aEd.getPageContext().getPageActivity(), com.baidu.tieba.u.ds18);
        this.aGo = com.baidu.adp.lib.util.l.d(this.aEd.getPageContext().getPageActivity(), com.baidu.tieba.u.ds18);
        this.aGp = com.baidu.adp.lib.util.l.d(this.aEd.getPageContext().getPageActivity(), com.baidu.tieba.u.ds70);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        this.mListView = (ListView) viewGroup;
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item, null);
        cm cmVar = new cm(this);
        cmVar.aCh = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list);
        cmVar.aCy = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_item_user_info_view);
        cmVar.aCi = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_item_top_linear_layout);
        cmVar.aGy = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.new_year_color_egg);
        cmVar.aCp = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.frs_photo);
        cmVar.aCo = (UserIconBox) inflate.findViewById(com.baidu.tieba.w.frs_user_tshow_icon_box);
        cmVar.aCn = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_author);
        cmVar.aCm = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_reply_time);
        cmVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_lv_title);
        cmVar.aCj = (TextView) inflate.findViewById(com.baidu.tieba.w.abstract_text);
        cmVar.aCk = (PlayVoiceBnt) inflate.findViewById(com.baidu.tieba.w.abstract_voice);
        cmVar.aCl = (FrsCommonImageLayout) inflate.findViewById(com.baidu.tieba.w.abstract_img_layout);
        cmVar.aCq = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_praise_btn);
        cmVar.aCr = (ImageView) inflate.findViewById(com.baidu.tieba.w.frs_praise_icon);
        cmVar.aCs = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_praise_num);
        cmVar.aGz = (TextView) inflate.findViewById(com.baidu.tieba.w.action_button);
        cmVar.aCt = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_reply_btn);
        cmVar.aCu = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_reply_num);
        cmVar.aCv = (FrsPraiseView) inflate.findViewById(com.baidu.tieba.w.frs_praise_list_user_icon);
        cmVar.aCw = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_more_abstract);
        cmVar.aCx = inflate.findViewById(com.baidu.tieba.w.frs_item_praise_divider_line);
        cmVar.aGB = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_item_location_container);
        cmVar.aGD = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_item_location_address);
        cmVar.aGC = (ImageView) inflate.findViewById(com.baidu.tieba.w.frs_item_location_img);
        inflate.setTag(cmVar);
        com.baidu.adp.lib.util.l.a(this.mContext, cmVar.aCq, 0, 10, 0, 20);
        cmVar.aCt.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.mContext, cmVar.aCt, 0, 10, 0, 20);
        cmVar.aCq.setOnClickListener(this);
        cmVar.aCt.setOnClickListener(this);
        cmVar.aGz.setOnClickListener(this);
        cmVar.aCw.setOnClickListener(this);
        cmVar.aCq.setOnTouchListener(new cn(this, null));
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
        if (xVar != null && xVar.nN() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            layoutParams.setMargins(this.aGn, 0, this.aGo, 0);
            cmVar.aCi.setLayoutParams(layoutParams);
            cmVar.aGy.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.aGn, this.aGp, this.aGo, 0);
            layoutParams2.gravity = 17;
            cmVar.aCi.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.bc.i(cmVar.aGy, com.baidu.tieba.v.yangnian2);
            cmVar.aGy.setVisibility(0);
        }
        i2 = cmVar.Yk;
        if (i2 != this.mSkinType) {
            com.baidu.tbadk.core.util.bc.i(cmVar.aCi, com.baidu.tieba.v.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.bc.i((View) cmVar.aCw, com.baidu.tieba.v.frs_item_abstract_more_text_bg);
            this.aEd.getLayoutMode().ab(this.mSkinType == 1);
            this.aEd.getLayoutMode().h(view);
        }
        cmVar.aCt.setTag(Integer.valueOf(i));
        cmVar.aCq.setTag(Integer.valueOf(i));
        cmVar.aGz.setTag(Integer.valueOf(i));
        cmVar.aCw.setTag(Integer.valueOf(i));
        int i4 = i - this.aEK;
        if (i4 == 0) {
            com.baidu.tbadk.core.util.bc.i(cmVar.aCh, com.baidu.tieba.v.bg_frs);
        } else {
            cmVar.aCh.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.t.transparent));
        }
        cmVar.aCh.setPadding(0, i4 == 0 ? this.aCc : this.aCd, 0, 0);
        if (xVar != null && !xVar.nJ() && !TextUtils.isEmpty(xVar.getAddress()) && !TextUtils.isEmpty(xVar.getAddress().trim())) {
            String address = xVar.getAddress();
            String nD = xVar.nD();
            String nE = xVar.nE();
            cmVar.aGB.setVisibility(0);
            com.baidu.adp.lib.util.l.a(this.aEd.getPageContext().getPageActivity(), cmVar.aGB, 0, 10, 0, 10);
            cmVar.aGD.setText(address);
            com.baidu.tbadk.core.util.bc.c(cmVar.aGC, com.baidu.tieba.v.icon_frs_site);
            if (this.mContext != null && this.mContext.getResources() != null) {
                com.baidu.tbadk.core.util.bc.b(cmVar.aGD, com.baidu.tieba.t.cp_cont_c, 1);
            }
            cmVar.aGB.setEnabled(true);
            cmVar.aGB.setOnClickListener(new ch(this, nD, nE, address));
        } else {
            cmVar.aGB.setEnabled(false);
            cmVar.aGB.setVisibility(4);
        }
        cmVar.aCm.setText(com.baidu.tbadk.core.util.bf.n(xVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.mc().me()) {
            cmVar.aCp.setVisibility(0);
            String portrait = xVar.getAuthor().getPortrait();
            cmVar.aCp.setUserId(xVar.getAuthor().getUserId());
            cmVar.aCp.setImageDrawable(null);
            cmVar.aCp.d(portrait, 28, false);
        } else {
            cmVar.aCp.setVisibility(8);
        }
        cmVar.aCy.setOnClickListener(new ci(this, xVar));
        xVar.getAuthor().getIconInfo();
        ArrayList<IconData> tShowInfo = xVar.getAuthor().getTShowInfo();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            cmVar.aCo.setVisibility(0);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCn, com.baidu.tieba.t.cp_cont_h, 1);
            cmVar.aCo.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
        } else {
            cmVar.aCo.setVisibility(8);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCn, com.baidu.tieba.t.cp_cont_c, 1);
        }
        cmVar.aCn.setText(xVar.getAuthor().getUserName());
        cmVar.aCl.setVisibility(0);
        cmVar.aCj.setVisibility(0);
        xVar.parser_title();
        cmVar.mTitle.setText(xVar.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iw(xVar.getId())) {
            com.baidu.tbadk.core.util.bc.b(cmVar.mTitle, com.baidu.tieba.t.cp_cont_c, 1);
            com.baidu.tbadk.core.util.bc.b(cmVar.aCj, com.baidu.tieba.t.cp_cont_c, 1);
        }
        if (xVar.nC() == 1) {
            cmVar.mTitle.setVisibility(8);
        } else {
            cmVar.mTitle.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (xVar.nx() != null && xVar.nx().trim().length() > 0) {
            stringBuffer.append(xVar.nx());
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
                    cmVar.aCw.setVisibility(0);
                    cmVar.aCj.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    cmVar.aCw.setVisibility(8);
                    cmVar.aCj.setText(stringBuffer.toString());
                }
            } else {
                cmVar.aCw.setVisibility(8);
                cmVar.aCj.setVisibility(8);
            }
        }
        if (xVar.getAnchorInfoData() == null || !this.aGr || xVar.getAnchorInfoData().getGroup_id() == 0 || !a(this.aGq, xVar.getAnchorInfoData().getGroup_id(), xVar.getLast_time_int())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (cmVar.aGA == null) {
                cmVar.aGA = this.aGs.ea();
                cmVar.aCi.addView(cmVar.aGA.aCz, cmVar.aCi.indexOfChild(cmVar.aCl) + 1);
            }
            i3 = cmVar.aGA.Yk;
            if (i3 != this.mSkinType) {
                this.aEd.getLayoutMode().ab(this.mSkinType == 1);
                this.aEd.getLayoutMode().h(cmVar.aGA.aCz);
                cmVar.aGA.Yk = this.mSkinType;
            }
            cmVar.aCl.setVisibility(8);
            cmVar.aGA.aCz.setVisibility(0);
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
            cmVar.aGA.aCA.setData(liveCardData);
            cmVar.aGA.aCA.setStatisticsKey("notice_frs_live");
        } else if (cmVar.aGA != null) {
            this.aGs.j(cmVar.aGA);
            cmVar.aCi.removeView(cmVar.aGA.aCz);
            cmVar.aGA = null;
        }
        if (com.baidu.tbadk.core.l.mc().mg() && medias != null && medias.size() > 0 && !z) {
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
                cmVar.aCl.setVisibility(0);
                cmVar.aCl.a(xVar, this.aEI.aeN().getName(), this.aEI.aeN().getId(), xVar.getTid());
                cmVar.aCl.setShowBig(this.aCa);
                cmVar.aCl.setDrawNum(true);
                cmVar.aCl.setFromCDN(this.mIsFromCDN);
                cmVar.aCl.a(this.aEd.getPageContext(), mediaDataArr, i9);
                cmVar.aCl.setImageFrom("other");
            } else {
                cmVar.aCl.setVisibility(8);
            }
        } else {
            cmVar.aCl.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> nB = xVar.nB();
        if (nB != null && nB.size() > 0) {
            cmVar.aCk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = nB.get(0);
            cmVar.aCk.setVoiceModel(voiceModel);
            cmVar.aCk.setTag(voiceModel);
            cmVar.aCk.ZK();
        } else {
            cmVar.aCk.setVisibility(8);
        }
        if (xVar.getPraise() != null && xVar.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                cmVar.aCv.setVisibility(0);
                cmVar.aCv.setIsFromPb(false);
                cmVar.aCv.ct(this.mSkinType);
                cmVar.aCx.setVisibility(0);
                cmVar.aCv.a(xVar.getPraise(), xVar.getId(), xVar.getFirst_post_id(), false);
            } else {
                cmVar.aCv.setVisibility(8);
                cmVar.aCx.setVisibility(8);
            }
            if (xVar.getPraise().getIsLike() == 1) {
                com.baidu.tbadk.core.util.bc.c(cmVar.aCr, com.baidu.tieba.v.icon_hand_frs_click);
            } else {
                com.baidu.tbadk.core.util.bc.c(cmVar.aCr, com.baidu.tieba.v.icon_hand_frs_normal);
            }
            cmVar.aCs.setText(com.baidu.tbadk.core.util.bf.p(xVar.getPraise().getNum()));
        } else {
            cmVar.aCx.setVisibility(8);
            cmVar.aCv.setVisibility(8);
            cmVar.aCs.setText(this.mContext.getResources().getString(com.baidu.tieba.z.frs_item_praise_text));
            com.baidu.tbadk.core.util.bc.c(cmVar.aCr, com.baidu.tieba.v.icon_hand_frs_normal);
        }
        int reply_num = xVar.getReply_num();
        if (reply_num > 0) {
            cmVar.aCu.setText(com.baidu.tbadk.core.util.bf.p(reply_num));
        } else {
            cmVar.aCu.setText(this.mContext.getResources().getString(com.baidu.tieba.z.frs_item_reply_text));
        }
        if (xVar.nJ()) {
            cmVar.mTitle.setMaxLines(2);
            cmVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            if (xVar.nI() == 1) {
                if (xVar.nA().get(0).getStatus() == 1) {
                    cmVar.aGz.setText(this.mContext.getResources().getString(com.baidu.tieba.z.i_want_lottery));
                    cmVar.aGz.setVisibility(0);
                } else {
                    cmVar.aGz.setVisibility(8);
                }
            } else if (xVar.nI() == 2) {
                if (xVar.nA().get(0).getStatus() == 1) {
                    cmVar.aGz.setText(this.mContext.getResources().getString(com.baidu.tieba.z.i_want_share_picture));
                    cmVar.aGz.setVisibility(0);
                } else {
                    cmVar.aGz.setVisibility(8);
                }
            } else {
                cmVar.aGz.setVisibility(8);
                cmVar.mTitle.setMaxLines(Integer.MAX_VALUE);
                cmVar.mTitle.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            cmVar.aGz.setVisibility(8);
        }
        cmVar.Yk = this.mSkinType;
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
        if (this.aCa != z) {
            this.aCa = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aEJ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) aD(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == FC()) {
                if (this.isPraiseToServer) {
                    this.aEJ.a(id, intValue, view, childAt, xVar);
                    return;
                }
                return;
            }
            this.aEJ.a(id, intValue, view, childAt, xVar);
        }
    }

    public int FC() {
        return com.baidu.tieba.w.frs_praise_btn;
    }

    public int FD() {
        return com.baidu.tieba.w.frs_reply_btn;
    }

    public int FE() {
        return com.baidu.tieba.w.frs_more_abstract;
    }

    public int Gs() {
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
