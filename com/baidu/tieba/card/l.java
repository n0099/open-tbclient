package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends a<com.baidu.tieba.card.data.l> {
    private boolean aXt;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private ThreadGodReplyLayout cNP;
    private View cNQ;
    private com.baidu.tieba.card.data.l cNR;
    private View.OnClickListener cNS;
    private boolean cPA;
    private RelativeLayout cPB;
    private final View.OnClickListener cPC;
    public PlayVoiceBntNew cPw;
    private View cPx;
    private TextView cPy;
    private ConstrainImageGroup cPz;
    public ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private com.baidu.tieba.NEGFeedBack.c ciP;
    protected LinearLayout cjA;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciP = null;
        this.mSkinType = 3;
        this.aXt = true;
        this.cPA = true;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aiY() != null) {
                    l.this.aiY().a(view, l.this.cNR);
                }
                l.this.ev(view == l.this.cNP);
            }
        };
        this.cPC = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.l> aiY = l.this.aiY();
                if (aiY != null) {
                    view.setTag("2");
                    aiY.a(view, l.this.cNR);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aiY() != null) {
                    l.this.aiY().a(view, l.this.cNR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cPw = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cPw.setAfterClickListener(this.cPC);
        this.cPy = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cPy.setVisibility(8);
        this.cPz = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cNQ = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cPz.setChildClickListener(this.cNS);
        this.cPz.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.f(1.0d);
        this.cPz.setImageProcessor(fVar);
        this.cPx = view.findViewById(d.g.divider_line_above_praise);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciP = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cPB = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.ciP.a(this.cPB, com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120), 0);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setFrom(1);
        this.ciE.setShareReportFrom(3);
        this.ciE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.aiY() != null) {
                    l.this.aiY().a(view2, l.this.cNR);
                }
                if (l.this.cNR != null && l.this.cNR.threadData != null) {
                    k.jT(l.this.cNR.threadData.getId());
                    if (!l.this.ajc()) {
                        k.a(l.this.mTitle, l.this.cNR.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                        k.a(l.this.cPy, l.this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                        k.a(l.this.cNP.getGodReplyContent(), l.this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                    }
                }
            }
        });
        this.cjA = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cNP.setOnClickListener(this.cNS);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cPz != null) {
            this.cPz.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cPz != null) {
            this.cPz.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cPx, d.C0108d.transparent);
            this.cPz.onChangeSkinType();
            this.ciE.onChangeSkinType();
            this.cNP.onChangeSkinType();
            this.ciD.onChangeSkinType();
            if (this.ciP != null) {
                this.ciP.onChangeSkinType();
            }
            aj.t(this.cNQ, d.C0108d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.VW() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cNR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        if (this.ciP != null) {
            if (this.cNR.aLZ != null && this.cNR.aLZ.size() > 0) {
                ai aiVar = new ai();
                aiVar.cK(this.cNR.VW().getTid());
                aiVar.setFid(this.cNR.VW().getFid());
                aiVar.a(this.cNR.aLZ);
                this.ciP.setData(aiVar);
                this.ciP.setFirstRowSingleColumn(true);
                if (lVar.threadData.yX() != null && !StringUtils.isNull(lVar.threadData.yX().getUserId())) {
                    if (lVar.threadData.yX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.ciP.setVisibility(8);
                    } else if (this.ciP != null) {
                        this.ciP.setVisibility(this.cPA ? 0 : 8);
                    }
                }
            } else {
                this.ciP.setVisibility(8);
            }
        }
        this.ciD.setData(lVar.threadData);
        this.cNP.setFromCDN(this.aXt);
        this.cNP.setData(lVar.threadData.Ao());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.cNP.onChangeSkinType();
        if (!ajc() && k.jU(this.cNR.threadData.getId())) {
            k.a(this.mTitle, this.cNR.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cPy, this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            k.a(this.cNP.getGodReplyContent(), this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.ciD.setUserAfterClickListener(this.bce);
        this.ciE.setData(lVar.threadData);
        this.mStType = k.yN();
        this.ciE.setStType(this.mStType);
        final be VW = lVar.VW();
        if (this.ciD.getHeaderImg() != null) {
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (VW.yX() == null || VW.yX().getPendantData() == null || StringUtils.isNull(VW.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                this.ciD.getHeaderImg().setData(VW);
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(VW);
            }
        }
        F(VW);
        ArrayList<VoiceData.VoiceModel> zm = lVar.threadData.zm();
        if (com.baidu.tbadk.core.util.v.G(zm)) {
            this.cPw.setVisibility(8);
            z = false;
        } else {
            this.cPw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zm.get(0);
            this.cPw.setVoiceModel(voiceModel);
            this.cPw.setTag(voiceModel);
            this.cPw.btM();
            if (voiceModel != null) {
                this.cPw.qL(voiceModel.voice_status.intValue());
            }
            this.cPw.bDs();
            z = true;
        }
        if (this.cNR.cSB && z) {
            this.cPz.setVisibility(8);
        } else {
            ArrayList<MediaData> zi = VW.zi();
            if (com.baidu.tbadk.core.i.wB().wH() && com.baidu.tbadk.core.util.v.F(zi) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zi.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zi, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.F(linkedList) > 0) {
                    this.cPz.setVisibility(0);
                    this.cPz.setFromCDN(this.aXt);
                    this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.l.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.l> aiY = l.this.aiY();
                            if (aiY != null) {
                                view.setTag("1");
                                aiY.a(view, l.this.cNR);
                            }
                            if (z2) {
                                l.this.ajs();
                            } else {
                                l.this.a(view, linkedList, i2, VW);
                            }
                        }
                    });
                    this.cPz.setImageMediaList(linkedList);
                } else {
                    this.cPz.setVisibility(8);
                }
            } else {
                this.cPz.setVisibility(8);
            }
        }
        ajq();
        ajr();
        setPageUniqueId(getTag());
    }

    private void ajq() {
        if (this.cPx != null && this.cPz != null && this.cNP != null) {
            if (this.cPz.getVisibility() == 8 && this.cNP.getVisibility() == 8) {
                this.cPx.setVisibility(0);
            } else {
                this.cPx.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, be beVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aXt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(beVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, beVar.zd(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aXt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void ajr() {
        if (!this.cNR.brk) {
            this.cPw.setClickable(false);
        } else {
            this.cPw.setClickable(true);
        }
        int childCount = this.cPz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cPz.getChildAt(i);
            if (childAt != null) {
                if (!this.cNR.brk) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXt = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cPz != null) {
            this.cPz.setPageUniqueId(bdUniqueId);
        }
        if (this.ciP != null) {
            this.ciP.setUniqueId(bdUniqueId);
        }
        if (this.ciD != null) {
            this.ciD.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.ciP != null) {
            this.ciP.setEventCallback(aVar);
        }
    }

    public View aja() {
        return this.cNP;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciD != null) {
            return this.ciD.bbZ;
        }
        return null;
    }

    public View ajb() {
        if (this.ciD != null) {
            return this.ciD.bca;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        ev(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z) {
        if (this.cNR != null && this.cNR.threadData != null) {
            if (!ajc()) {
                k.jT(this.cNR.threadData.getId());
                k.a(this.mTitle, this.cNR.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                k.a(this.cPy, this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                k.a(this.cNP.getGodReplyContent(), this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cNR.threadData, null, k.yN(), 18003, true, false, false).addLocateParam(this.cNR.ajL());
            addLocateParam.setForumId(String.valueOf(this.cNR.threadData.getFid()));
            addLocateParam.setForumName(this.cNR.threadData.zd());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            k.jT(this.cNR.VW().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajc() {
        return this.cNR.cSB && !this.cNR.brk;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean F(be beVar) {
        SpannableStringBuilder j = beVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        return true;
    }

    public void ex(boolean z) {
        if (this.cNQ != null) {
            this.cNQ.setVisibility(z ? 0 : 8);
        }
    }

    public void ey(boolean z) {
        this.cPA = z;
    }
}
