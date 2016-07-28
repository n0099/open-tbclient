package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends a<com.baidu.tieba.card.a.m> {
    private TbPageContext<?> EA;
    private View aSU;
    public ViewStub aSW;
    public TbImageView aSX;
    private TextView aSZ;
    private TextView aTf;
    private FrsCommonImageLayout aTg;
    public ThreadCommentAndPraiseInfoLayout aTh;
    public ClickableHeaderImageView aUG;
    public PlayVoiceBntNew aUH;
    private UserIconLayout aUI;
    private com.baidu.tieba.card.a.m aUJ;
    private View.OnClickListener aUL;
    private FrsCommonImageLayout.b aUM;
    private final View.OnClickListener aUN;
    private final String aUR;
    private final String aUS;
    private final View.OnClickListener aUT;
    private CustomMessageListener aUs;
    private boolean aav;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    private int mSkinType;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUR = "1";
        this.aUS = "2";
        this.mSkinType = 3;
        this.aav = true;
        this.aUL = new bd(this);
        this.aUs = new be(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aUM = new bf(this);
        this.aUT = new bg(this);
        this.aUN = new bh(this);
        this.aeW = new bi(this);
        this.aez = new bj(this);
        View view = getView();
        this.EA = tbPageContext;
        this.aSU = view.findViewById(u.g.card_home_page_normal_thread_top_line);
        this.aUG = (ClickableHeaderImageView) view.findViewById(u.g.card_home_page_normal_thread_user_header);
        this.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aUG.setDefaultResource(17170445);
        this.aUG.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUG.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUG.setRadius(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds70));
        this.aUI = (UserIconLayout) view.findViewById(u.g.card_home_page_normal_thread_user_layout);
        this.aSZ = (TextView) view.findViewById(u.g.card_home_page_normal_thread_title);
        this.aUH = (PlayVoiceBntNew) view.findViewById(u.g.card_home_page_normal_thread_abstract_voice);
        this.aUH.setAfterClickListener(this.aUN);
        this.aTf = (TextView) view.findViewById(u.g.card_home_page_normal_thread_abstract);
        this.aTg = (FrsCommonImageLayout) view.findViewById(u.g.card_home_page_normal_thread_img_layout);
        this.aTg.setDrawNum(false);
        this.aTg.setAfterChildClickListener(this.aUT);
        this.aTh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_home_page_normal_thread_info_layout);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), u.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aSU, u.d.cp_bg_line_b);
            this.aUI.sd();
            this.aTh.sd();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_normal_thread;
    }

    public void a(com.baidu.tieba.card.a.m mVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (mVar == null || mVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aUJ = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aUL);
        }
        d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        if (this.aUJ.aWs) {
            this.aUG.setVisibility(8);
            this.aUI.setVisibility(8);
        } else {
            this.aUI.setVisibility(0);
            this.aUG.setVisibility(0);
            this.aUG.setData(mVar.threadData);
            this.aUG.setAfterClickListener(this.aeW);
            UserTbVipInfoData qx = this.aUJ.threadData.qx();
            if (qx != null && qx.getvipV_url() != null && this.aSW != null) {
                if (this.aSX == null) {
                    this.aSW.inflate();
                    this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aSX.c(qx.getvipV_url(), 10, false);
                this.aUG.setIsBigV(true);
            }
        }
        this.aUI.setData(mVar.threadData);
        this.aUI.setUserAfterClickListener(this.aeW);
        this.aTh.setData(mVar.threadData);
        this.aTh.setForumAfterClickListener(this.aez);
        this.aTh.setStType(at.La());
        this.aTh.setYuelaouLocate("feed#" + mVar.Lg());
        if (StringUtils.isNull(mVar.threadData.getTitle()) || mVar.threadData.qK() == 1) {
            this.aSZ.setVisibility(8);
        } else {
            this.aSZ.setVisibility(0);
            mVar.threadData.QJ = 0;
            if (this.aUJ.aWs) {
                this.aSZ.setText(mVar.threadData.getTitle());
            } else {
                mVar.threadData.rd();
                this.aSZ.setText(mVar.threadData.qV());
            }
            if (!KT()) {
                at.a(this.aSZ, mVar.Iw().getId(), u.d.cp_cont_b, u.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.av.j((View) this.aSZ, u.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (mVar.threadData.qD() != null && !StringUtils.isNull(mVar.threadData.qD())) {
            stringBuffer.append(mVar.threadData.qD());
        }
        ArrayList<MediaData> qF = mVar.threadData.qF();
        if (qF != null) {
            i = qF.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (qF.get(i4).getVideoUrl() != null && qF.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(qF.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                this.aTf.setText(stringBuffer.toString());
                this.aTf.setVisibility(0);
                if (!KT()) {
                    at.a(this.aTf, mVar.threadData.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.av.j((View) this.aTf, u.d.cp_cont_j);
                }
            } else {
                this.aTf.setVisibility(8);
            }
        } else {
            this.aTf.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> qJ = mVar.threadData.qJ();
        if (qJ != null && qJ.size() > 0) {
            this.aUH.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qJ.get(0);
            this.aUH.setVoiceModel(voiceModel);
            this.aUH.setTag(voiceModel);
            this.aUH.bgJ();
            if (voiceModel != null) {
                this.aUH.lt(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.aUH.setVisibility(8);
            z = false;
        }
        if (this.aUJ.aWs && z) {
            this.aTg.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.nL().nR() && com.baidu.tbadk.core.util.y.s(qF) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (qF.get(i5) == null || !(qF.get(i5).getType() == 3 || qF.get(i5).getType() == 5)) {
                    i3 = i6;
                } else {
                    i7++;
                    i3 = i6 + 1;
                }
                i5++;
                i7 = i7;
                i6 = i3;
            }
            if (i7 > 0) {
                MediaData[] mediaDataArr = new MediaData[i7];
                int i8 = 0;
                int i9 = 0;
                while (i9 < i && i8 < i7) {
                    if (qF.get(i9).getType() == 3 || qF.get(i9).getType() == 5) {
                        mediaDataArr[i8] = qF.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.aTg.setVisibility(0);
                this.aTg.a(mVar.threadData, mVar.threadData.getForum_name(), new StringBuilder(String.valueOf(mVar.threadData.getFid())).toString(), mVar.threadData.getTid());
                this.aTg.setShowBig(com.baidu.tbadk.core.util.bb.ue().ug());
                this.aTg.a(this.EA, mediaDataArr, i6);
                this.aTg.setFromCDN(this.aav);
                this.aTg.setImageFrom("other");
            } else {
                this.aTg.setVisibility(8);
            }
        } else {
            this.aTg.setVisibility(8);
        }
        Lb();
    }

    private void Lb() {
        if (!this.aUJ.asx) {
            this.aTg.setOnChildClickListener(this.aUM);
            this.aUH.setClickable(false);
            this.aTh.setBarNameClickEnabled(false);
        } else {
            this.aTg.setOnChildClickListener(null);
            this.aUH.setClickable(true);
            this.aTh.setBarNameClickEnabled(true);
        }
        int childCount = this.aTg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aTg.getChildAt(i);
            if (childAt != null) {
                if (!this.aUJ.asx) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aav = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTh != null && this.aUs != null) {
            this.aTh.h(bdUniqueId);
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lc() {
        if (this.aUJ != null && this.aUJ.threadData != null) {
            if (!KT()) {
                at.hb(this.aUJ.threadData.getId());
            }
            this.EA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.EA.getPageActivity()).createFromThreadCfg(this.aUJ.threadData, null, at.La(), 18003, true, false, false).addLocateParam(this.aUJ.Lh())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KT() {
        return this.aUJ.aWs && !this.aUJ.asx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
