package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.card.a<bi> implements cd {
    private bi aiC;
    protected boolean aid;
    private TbPageContext<?> ajU;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    protected TextView bRE;
    public TbImageView bRo;
    private com.baidu.tieba.frs.g.af bVE;
    public HeadPendantClickableView bVL;
    public RelativeLayout bVM;
    protected TbImageView bVN;
    private View.OnClickListener bVO;
    public ViewStub bbW;
    public TbImageView bbX;
    public LinearLayout bca;
    public ThreadSkinView bcb;
    protected TextView btU;
    public ThreadCommentAndPraiseInfoLayout btW;
    private CardGroupDividerView buD;
    private CustomMessageListener buW;
    public ClickableHeaderImageView bvD;
    public PlayVoiceBntNew bvE;
    public View bvF;
    public UserIconLayout bvG;
    protected ConstrainImageGroup bvI;
    private View.OnClickListener bvJ;
    private final View.OnClickListener bvL;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aid = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bvJ = new ab(this);
        this.bVO = new ac(this);
        this.buW = new ad(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bvL = new ae(this);
        this.amx = new af(this);
        this.ama = new ag(this);
        View view = getView();
        this.ajU = tbPageContext;
        this.ds16 = (int) this.ajU.getResources().getDimension(w.f.ds16);
        this.ds32 = (int) this.ajU.getResources().getDimension(w.f.ds32);
        this.bvD = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bVL = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.bvD.setDefaultResource(17170445);
        this.bvD.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bvD.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bvD.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bVL.getHeadView() != null) {
            this.bVL.getHeadView().setIsRound(true);
            this.bVL.getHeadView().setDrawBorder(false);
            this.bVL.getHeadView().setDefaultResource(17170445);
            this.bVL.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bVL.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bVL.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        }
        this.bVL.wL();
        if (this.bVL.getPendantView() != null) {
            this.bVL.getPendantView().setIsRound(true);
            this.bVL.getPendantView().setDrawBorder(false);
        }
        this.bvG = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.bvG.amv = true;
        this.bvG.setEntelechyEnabled(true);
        this.bvG.setPageName(1);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvE = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvE.setAfterClickListener(this.bvL);
        this.bvE.setPlayTimeTextView(w.f.fontsize28);
        this.bRo = (TbImageView) view.findViewById(w.h.frs_normal_item_theme_card);
        this.btU = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.btU.setFocusable(true);
        this.bvI = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
        this.bvI.setSingleImageRatio(0.75d);
        this.bvI.setImageMargin(dimensionPixelSize);
        this.bvI.setChildClickListener(this.bVO);
        this.btW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.btW.setLocationEnabled(true);
        this.btW.setViewNumEnabled(true);
        this.btW.setCommentNumClickListener(this.bvJ);
        this.bvF = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bca = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bVM = (RelativeLayout) view.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bVN = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.bRE = (TextView) view.findViewById(w.h.app_code_btn);
        this.bcb = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.buD = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.buD.setTitleClickListener(this.bvJ);
        this.bVE = new com.baidu.tieba.frs.g.af(this.ajU, this.btW);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvI != null) {
            this.bvI.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvI != null) {
            this.bvI.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bVM, w.g.addresslist_item_bg);
            this.bvI.onChangeSkinType();
            this.bvG.onChangeSkinType();
            this.btW.onChangeSkinType();
            if (this.buD != null) {
                this.buD.onChangeSkinType();
            }
            this.bVE.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bi biVar) {
        int i;
        if (biVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiC = biVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bVM != null) {
                this.bVM.setOnClickListener(this.bvJ);
                this.bVM.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bvJ);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        this.bvG.setVisibility(0);
        if (this.aiC.getAuthor() != null && !StringUtils.isNull(this.aiC.getAuthor().getSealPrefix())) {
            this.bvG.aP(true);
        }
        if (this.aiC.getAuthor() == null || this.aiC.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiC.getAuthor().getPendantData().qB())) {
            UserTbVipInfoData sp = this.aiC.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bbW != null) {
                    if (this.bbX == null) {
                        this.bbW.inflate();
                        this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbX.setVisibility(0);
                    this.bbX.c(sp.getvipV_url(), 10, false);
                    this.bvD.setIsBigV(true);
                }
            } else {
                this.bvD.setIsBigV(false);
                if (this.bbX != null) {
                    this.bbX.setVisibility(8);
                }
            }
            this.bVL.setVisibility(8);
            this.bvD.setVisibility(0);
            this.bvD.setData(biVar);
            this.bvD.setAfterClickListener(this.amx);
        } else {
            this.bvD.setVisibility(4);
            this.bvD.setIsBigV(false);
            if (this.bbX != null) {
                this.bbX.setVisibility(8);
            }
            this.bVL.setVisibility(0);
            this.bVL.setData(biVar);
        }
        this.bvG.setData(biVar);
        this.bvG.setUserAfterClickListener(this.amx);
        if (this.btW.a(biVar)) {
            this.bvF.setVisibility(8);
        } else {
            this.bvF.setVisibility(0);
        }
        this.btW.e(this.mTbPageContext);
        this.btW.setForumAfterClickListener(this.ama);
        this.btW.setStType(com.baidu.tieba.card.at.sf());
        if ((StringUtils.isNull(biVar.getTitle()) && (biVar.sn() == null || biVar.sn().size() == 0)) || biVar.sD() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            biVar.Yn = 0;
            biVar.e(false, biVar.tl());
            SpannableStringBuilder sO = biVar.sO();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.x(sO));
            this.mTitle.setText(sO);
            com.baidu.tieba.card.at.a(this.mTitle, biVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (biVar.sw() != null && !StringUtils.isNull(biVar.sw())) {
            sb.append(biVar.sw());
        }
        ArrayList<MediaData> sy = biVar.sy();
        if (sy != null) {
            i = sy.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (sy.get(i2).getVideoUrl() != null && sy.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(sy.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(biVar.g(sb.toString(), true))) {
                SpannableString cx = biVar.cx(sb.toString());
                this.btU.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.btU.setText(cx);
                this.btU.setContentDescription(sb.toString());
                this.btU.setVisibility(0);
                com.baidu.tieba.card.at.a(this.btU, biVar.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.btU.setVisibility(8);
            }
        } else {
            this.btU.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.btW.getLayoutParams();
        if (layoutParams != null) {
            if (this.btU.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bvE.getVisibility() == 8 && this.btW.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ajU.getResources().getDimension(w.f.ds56), 0, 0);
                this.btW.setPadding(0, 0, 0, 0);
            } else if (this.btW.xp()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.btW.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.btW.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.bVE.A(this.aiC);
        ArrayList<VoiceData.VoiceModel> sC = biVar.sC();
        if (com.baidu.tbadk.core.util.x.q(sC)) {
            this.bvE.setVisibility(8);
        } else {
            this.bvE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sC.get(0);
            this.bvE.setVoiceModel(voiceModel);
            this.bvE.setTag(voiceModel);
            this.bvE.bbd();
            if (voiceModel != null) {
                this.bvE.mg(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.q.po().pu() && com.baidu.tbadk.core.util.x.p(sy) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(sy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.au.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.p(linkedList) > 0) {
                this.bvI.setVisibility(0);
                this.bvI.setFromCDN(this.aid);
                if (this.aiC.tk() != null) {
                    this.bvI.setImageClickListener(new ah(this));
                } else {
                    this.bvI.setImageClickListener(new ai(this, linkedList2, biVar));
                }
                this.bvI.setImageUrls(linkedList);
            } else {
                this.bvI.setVisibility(8);
            }
        } else {
            this.bvI.setVisibility(8);
        }
        if (this.bVN != null) {
            if (biVar.sA() != null) {
                String tK = biVar.sA().tK();
                if (!StringUtils.isNull(tK)) {
                    this.bVN.setVisibility(0);
                    this.bVN.c(tK, 10, true);
                } else {
                    this.bVN.setVisibility(8);
                }
            } else {
                this.bVN.setVisibility(8);
            }
        }
        if (this.bRE != null) {
            if (biVar.sB() != null) {
                String pS = biVar.sB().pS();
                if (!StringUtils.isNull(pS)) {
                    String fixedText = com.baidu.tbadk.core.util.au.getFixedText(pS, 20, true);
                    com.baidu.tbadk.core.util.aq.j(this.bRE, w.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.aq.i(this.bRE, w.e.cp_cont_h);
                    this.bRE.setText(fixedText);
                    this.bRE.setVisibility(0);
                } else {
                    this.bRE.setVisibility(8);
                }
            } else {
                this.bRE.setVisibility(8);
            }
        }
        TQ();
        p.a(this.aiC, this.buD);
        s(biVar);
    }

    public void s(bi biVar) {
        MetaData author;
        if (biVar != null && this.bRo != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sJ = biVar.sJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bvD.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bca.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bRo.setVisibility(8);
                if (this.bcb != null) {
                    if (sJ != null) {
                        this.bcb.a(this.ajU, sJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.st(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds16);
                    } else {
                        this.bcb.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bRo.setVisibility(0);
                this.bRo.setImageBitmap(null);
                this.bRo.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bRo.setOnClickListener(new aj(this, themeCard));
                this.bcb.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds30);
            }
            this.bvD.setLayoutParams(layoutParams);
            this.bca.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajU.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aid ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(biVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajU.getPageActivity()).createConfig(arrayList, i, biVar.st(), String.valueOf(biVar.getFid()), biVar.getTid(), this.aid, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void TQ() {
        this.bvE.setClickable(true);
        this.btW.setBarNameClickEnabled(true);
        int childCount = this.bvI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvI.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aid = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.btW != null && this.buW != null) {
            this.btW.h(bdUniqueId);
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TR() {
        if (this.aiC != null) {
            com.baidu.tieba.card.at.hZ(this.aiC.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiC));
            com.baidu.tbadk.core.data.n tk = this.aiC.tk();
            if (tk != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajU.getPageActivity(), tk.getCartoonId(), tk.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aiC.Zt;
            if (this.aiC.Zs == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UT;
                long j = kVar.UU;
                com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                aoVar.pageContext = this.ajU;
                aoVar.bookId = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
            } else if (this.aiC.sB() != null) {
                if (bg.aK(this.ajU.getPageActivity())) {
                    String postUrl = this.aiC.sB().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hB()) {
                        com.baidu.tbadk.browser.f.T(this.ajU.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.r.gp(this.aiC.getId());
                if (this.aiC.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bkn()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajU.getPageActivity()).createHistoryCfg(this.aiC.getTid(), String.valueOf(this.aiC.sK()), false, true, com.baidu.tieba.card.at.sf());
                    createHistoryCfg.setVideo_source("frs");
                    createHistoryCfg.setFromSmartFrs(this.aiC.tr());
                    createHistoryCfg.setSmartFrsPosition(this.aiC.tu());
                    this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajU.getPageActivity()).createFromThreadCfg(this.aiC, this.mForumName, com.baidu.tieba.card.at.sf(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setFromSmartFrs(this.aiC.tr());
                createFromThreadCfg.setSmartFrsPosition(this.aiC.tu());
                this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
