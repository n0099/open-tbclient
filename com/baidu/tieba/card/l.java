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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
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
    private boolean aXA;
    private final View.OnClickListener bcm;
    private ThreadGodReplyLayout cSK;
    private View cSL;
    public ThreadSourceShareAndPraiseLayout cSM;
    private com.baidu.tieba.card.data.l cSN;
    private View.OnClickListener cSO;
    public PlayVoiceBntNew cUt;
    private View cUu;
    private TextView cUv;
    private ConstrainImageGroup cUw;
    private boolean cUx;
    private RelativeLayout cUy;
    private final View.OnClickListener cUz;
    public ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    protected LinearLayout cjQ;
    private com.baidu.tieba.NEGFeedBack.c cje;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cje = null;
        this.mSkinType = 3;
        this.aXA = true;
        this.cUx = true;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akg() != null) {
                    l.this.akg().a(view, l.this.cSN);
                }
                l.this.eB(view == l.this.cSK);
            }
        };
        this.cUz = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.l> akg = l.this.akg();
                if (akg != null) {
                    view.setTag("2");
                    akg.a(view, l.this.cSN);
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akg() != null) {
                    l.this.akg().a(view, l.this.cSN);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cUt = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cUt.setAfterClickListener(this.cUz);
        this.cUv = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cUv.setVisibility(8);
        this.cUw = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cSL = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cUw.setChildClickListener(this.cSO);
        this.cUw.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUw.setImageProcessor(fVar);
        this.cUu = view.findViewById(d.g.divider_line_above_praise);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cje = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cUy = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cje.a(this.cUy, com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120), 0);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setFrom(1);
        this.ciT.setShareReportFrom(3);
        this.ciT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.akg() != null) {
                    l.this.akg().a(view2, l.this.cSN);
                }
                if (l.this.cSN != null && l.this.cSN.threadData != null) {
                    k.kj(l.this.cSN.threadData.getId());
                    if (!l.this.akk()) {
                        k.a(l.this.mTitle, l.this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                        k.a(l.this.cUv, l.this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                        k.a(l.this.cSK.getGodReplyContent(), l.this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                    }
                }
            }
        });
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cSK.setOnClickListener(this.cSO);
        this.cSM = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cSM.bcI.setOnClickListener(this.cSO);
        this.cSM.setFrom(1);
        this.cSM.setShareReportFrom(3);
        this.cSM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.akg() != null) {
                    l.this.akg().a(view2, l.this.cSN);
                }
                if (l.this.cSN != null && l.this.cSN.threadData != null) {
                    k.kj(l.this.cSN.threadData.getId());
                    if (!l.this.akk()) {
                        k.a(l.this.mTitle, l.this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                        k.a(l.this.cUv, l.this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                        k.a(l.this.cSK.getGodReplyContent(), l.this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUw != null) {
            this.cUw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUw != null) {
            this.cUw.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cUu, d.C0108d.transparent);
            this.cUw.onChangeSkinType();
            this.ciT.onChangeSkinType();
            this.cSK.onChangeSkinType();
            this.ciS.onChangeSkinType();
            if (this.cje != null) {
                this.cje.onChangeSkinType();
            }
            aj.t(this.cSL, d.C0108d.cp_bg_line_e);
            if (this.cSM != null) {
                this.cSM.onChangeSkinType();
            }
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
        if (lVar == null || lVar.VM() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cSN = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        if (this.cje != null) {
            if (this.cSN.aLY != null && this.cSN.aLY.size() > 0) {
                ah ahVar = new ah();
                ahVar.cK(this.cSN.VM().getTid());
                ahVar.setFid(this.cSN.VM().getFid());
                ahVar.a(this.cSN.aLY);
                this.cje.setData(ahVar);
                this.cje.setFirstRowSingleColumn(true);
                if (lVar.threadData.yT() != null && !StringUtils.isNull(lVar.threadData.yT().getUserId())) {
                    if (lVar.threadData.yT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.cje.setVisibility(8);
                    } else if (this.cje != null) {
                        this.cje.setVisibility(this.cUx ? 0 : 8);
                    }
                }
            } else {
                this.cje.setVisibility(8);
            }
        }
        this.ciS.setData(lVar.threadData);
        this.cSK.setFromCDN(this.aXA);
        this.cSK.setData(lVar.threadData.Ah());
        if (!akk() && k.kk(this.cSN.threadData.getId())) {
            k.a(this.mTitle, this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cUv, this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            k.a(this.cSK.getGodReplyContent(), this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.ciS.setUserAfterClickListener(this.bcm);
        final bd VM = lVar.VM();
        if (this.ciS.getHeaderImg() != null) {
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (VM.yT() == null || VM.yT().getPendantData() == null || StringUtils.isNull(VM.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                this.ciS.getHeaderImg().setData(VM);
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(VM);
            }
        }
        F(VM);
        ArrayList<VoiceData.VoiceModel> zi = lVar.threadData.zi();
        if (com.baidu.tbadk.core.util.v.E(zi)) {
            this.cUt.setVisibility(8);
            z = false;
        } else {
            this.cUt.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zi.get(0);
            this.cUt.setVoiceModel(voiceModel);
            this.cUt.setTag(voiceModel);
            this.cUt.bng();
            if (voiceModel != null) {
                this.cUt.qE(voiceModel.voice_status.intValue());
            }
            this.cUt.bwR();
            z = true;
        }
        if (this.cSN.cXy && z) {
            this.cUw.setVisibility(8);
        } else {
            ArrayList<MediaData> ze = VM.ze();
            if (com.baidu.tbadk.core.i.wB().wH() && com.baidu.tbadk.core.util.v.D(ze) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < ze.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(ze, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cUw.setVisibility(0);
                    this.cUw.setFromCDN(this.aXA);
                    this.cUw.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.l.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.l> akg = l.this.akg();
                            if (akg != null) {
                                view.setTag("1");
                                akg.a(view, l.this.cSN);
                            }
                            if (z2) {
                                l.this.akA();
                            } else {
                                l.this.a(view, linkedList, i2, VM);
                            }
                        }
                    });
                    this.cUw.setImageMediaList(linkedList);
                } else {
                    this.cUw.setVisibility(8);
                }
            } else {
                this.cUw.setVisibility(8);
            }
        }
        aky();
        akz();
        setPageUniqueId(getTag());
        lD(VM.aPd);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aky() {
        if (this.cUu != null && this.cUw != null && this.cSK != null) {
            if (this.cUw.getVisibility() == 8 && this.cSK.getVisibility() == 8) {
                this.cUu.setVisibility(0);
            } else {
                this.cUu.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                    imageUrlData.urlType = this.aXA ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yZ(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXA, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void akz() {
        if (!this.cSN.brC) {
            this.cUt.setClickable(false);
        } else {
            this.cUt.setClickable(true);
        }
        int childCount = this.cUw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUw.getChildAt(i);
            if (childAt != null) {
                if (!this.cSN.brC) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXA = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cUw != null) {
            this.cUw.setPageUniqueId(bdUniqueId);
        }
        if (this.cje != null) {
            this.cje.setUniqueId(bdUniqueId);
        }
        if (this.ciS != null) {
            this.ciS.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cje != null) {
            this.cje.setEventCallback(aVar);
        }
    }

    public View aki() {
        return this.cSK;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciS != null) {
            return this.ciS.bch;
        }
        return null;
    }

    public View akj() {
        if (this.ciS != null) {
            return this.ciS.bci;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        eB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(boolean z) {
        if (this.cSN != null && this.cSN.threadData != null) {
            if (!akk()) {
                k.kj(this.cSN.threadData.getId());
                k.a(this.mTitle, this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                k.a(this.cUv, this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                k.a(this.cSK.getGodReplyContent(), this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSN.threadData, null, k.yJ(), 18003, true, false, false).addLocateParam(this.cSN.akT());
            addLocateParam.setForumId(String.valueOf(this.cSN.threadData.getFid()));
            addLocateParam.setForumName(this.cSN.threadData.yZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            k.kj(this.cSN.VM().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akk() {
        return this.cSN.cXy && !this.cSN.brC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean F(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        return true;
    }

    public void eD(boolean z) {
        if (this.cSL != null) {
            this.cSL.setVisibility(z ? 0 : 8);
        }
    }

    public void eE(boolean z) {
        this.cUx = z;
    }

    public void lD(int i) {
        if (this.cSN != null && this.cSN.threadData != null) {
            this.mStType = k.yJ();
            if (i == 1) {
                this.ciT.setVisibility(8);
                this.cSM.setStType(this.mStType);
                this.cSM.setData(this.cSN.threadData);
                this.ciS.showForumNameView(false);
                return;
            }
            this.ciT.setData(this.cSN.threadData);
            this.ciT.setStType(this.mStType);
            this.cSM.setVisibility(8);
            this.ciS.showForumNameView(true);
        }
    }
}
