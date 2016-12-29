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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.card.a<bg> implements bb {
    private TbPageContext<?> GO;
    private TextView aNY;
    private bg adN;
    protected boolean adn;
    private final View.OnClickListener ahA;
    private final View.OnClickListener ahg;
    public TbImageView bAE;
    protected TextView bAU;
    public ThreadSkinView bAV;
    public HeadPendantClickableView bGj;
    public RelativeLayout bGk;
    protected TbImageView bGl;
    private View.OnClickListener bGm;
    public ViewStub baW;
    public TbImageView baX;
    private CardGroupDividerView bbM;
    protected TextView bbe;
    public ThreadCommentAndPraiseInfoLayout bbg;
    public ClickableHeaderImageView bcJ;
    public PlayVoiceBntNew bcK;
    public View bcL;
    public UserIconLayout bcM;
    protected ConstrainImageGroup bcO;
    private View.OnClickListener bcP;
    private final View.OnClickListener bcR;
    public LinearLayout bcd;
    private CustomMessageListener bct;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;

    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.adn = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bcP = new ab(this);
        this.bGm = new ac(this);
        this.bct = new ad(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bcR = new ae(this);
        this.ahA = new af(this);
        this.ahg = new ag(this);
        View view = getView();
        this.GO = tbPageContext;
        this.ds16 = (int) this.GO.getResources().getDimension(r.e.ds16);
        this.ds32 = (int) this.GO.getResources().getDimension(r.e.ds32);
        this.bcJ = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.bGj = (HeadPendantClickableView) view.findViewById(r.g.card_home_page_normal_thread_user_pendant_header);
        this.bcJ.setDefaultResource(17170445);
        this.bcJ.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bcJ.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bcJ.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        if (this.bGj.getHeadView() != null) {
            this.bGj.getHeadView().setIsRound(true);
            this.bGj.getHeadView().setDrawBorder(false);
            this.bGj.getHeadView().setDefaultResource(17170445);
            this.bGj.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bGj.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bGj.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        }
        this.bGj.vY();
        if (this.bGj.getPendantView() != null) {
            this.bGj.getPendantView().setIsRound(true);
            this.bGj.getPendantView().setDrawBorder(false);
        }
        this.bcM = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.bcM.ahz = true;
        this.bcM.setEntelechyEnabled(true);
        this.bcM.setPageName(1);
        this.aNY = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.bcK = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.bcK.setAfterClickListener(this.bcR);
        this.bcK.setPlayTimeTextView(r.e.fontsize28);
        this.bAE = (TbImageView) view.findViewById(r.g.frs_normal_item_theme_card);
        this.bbe = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bbe.setFocusable(true);
        this.bcO = (ConstrainImageGroup) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4);
        this.bcO.setSingleImageRatio(0.75d);
        this.bcO.setImageMargin(dimensionPixelSize);
        this.bcO.setChildClickListener(this.bGm);
        this.bbg = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.bbg.setLocationEnabled(true);
        this.bbg.setViewNumEnabled(true);
        this.bbg.setCommentNumClickListener(this.bcP);
        this.bcL = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bcd = (LinearLayout) view.findViewById(r.g.card_home_page_normal_thread_content_layout);
        this.bGk = (RelativeLayout) view.findViewById(r.g.card_home_page_normal_thread_root_content);
        this.bGl = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.bAU = (TextView) view.findViewById(r.g.app_code_btn);
        this.bAV = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
        this.bbM = (CardGroupDividerView) view.findViewById(r.g.header_divider);
        this.bbM.setTitleClickListener(this.bcP);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bcO != null) {
            this.bcO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bcO != null) {
            this.bcO.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(getView(), r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.k(this.bGk, r.f.addresslist_item_bg);
            this.bcO.tm();
            this.bcM.tm();
            this.bbg.tm();
            if (this.bbM != null) {
                this.bbM.tm();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: o */
    public void onBindDataToView(bg bgVar) {
        int i;
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adN = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bGk != null) {
                this.bGk.setOnClickListener(this.bcP);
                this.bGk.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bcP);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        this.bcM.setVisibility(0);
        if (this.adN.getAuthor() != null && !StringUtils.isNull(this.adN.getAuthor().getSealPrefix())) {
            this.bcM.aO(true);
        }
        if (this.adN.getAuthor() == null || this.adN.getAuthor().getPendantData() == null || StringUtils.isNull(this.adN.getAuthor().getPendantData().pS())) {
            UserTbVipInfoData rF = this.adN.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.baW != null) {
                    if (this.baX == null) {
                        this.baW.inflate();
                        this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.baX.setVisibility(0);
                    this.baX.c(rF.getvipV_url(), 10, false);
                    this.bcJ.setIsBigV(true);
                }
            } else {
                this.bcJ.setIsBigV(false);
                if (this.baX != null) {
                    this.baX.setVisibility(8);
                }
            }
            this.bGj.setVisibility(8);
            this.bcJ.setVisibility(0);
            this.bcJ.setData(bgVar);
            this.bcJ.setAfterClickListener(this.ahA);
        } else {
            this.bcJ.setVisibility(4);
            this.bcJ.setIsBigV(false);
            if (this.baX != null) {
                this.baX.setVisibility(8);
            }
            this.bGj.setVisibility(0);
            this.bGj.setData(bgVar);
        }
        this.bcM.setData(bgVar);
        this.bcM.setUserAfterClickListener(this.ahA);
        if (this.bbg.a(bgVar)) {
            this.bcL.setVisibility(8);
        } else {
            this.bcL.setVisibility(0);
        }
        this.bbg.e(this.mTbPageContext);
        this.bbg.setForumAfterClickListener(this.ahg);
        this.bbg.setStType(com.baidu.tieba.card.ap.OB());
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.rD() == null || bgVar.rD().size() == 0)) || bgVar.rU() == 1) {
            this.aNY.setVisibility(8);
        } else {
            this.aNY.setVisibility(0);
            bgVar.Tx = 0;
            bgVar.e(false, bgVar.sA());
            SpannableStringBuilder sd = bgVar.sd();
            this.aNY.setOnTouchListener(new com.baidu.tieba.view.x(sd));
            this.aNY.setText(sd);
            com.baidu.tieba.card.ap.a(this.aNY, bgVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bgVar.rN() != null && !StringUtils.isNull(bgVar.rN())) {
            sb.append(bgVar.rN());
        }
        ArrayList<MediaData> rP = bgVar.rP();
        if (rP != null) {
            i = rP.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rP.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bgVar.g(sb.toString(), true))) {
                SpannableString cz = bgVar.cz(sb.toString());
                this.bbe.setOnTouchListener(new com.baidu.tieba.view.x(cz));
                this.bbe.setText(cz);
                this.bbe.setContentDescription(sb.toString());
                this.bbe.setVisibility(0);
                com.baidu.tieba.card.ap.a(this.bbe, bgVar.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
            } else {
                this.bbe.setVisibility(8);
            }
        } else {
            this.bbe.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbg.getLayoutParams();
        if (layoutParams != null) {
            if (this.bbe.getVisibility() == 8 && this.aNY.getVisibility() == 8 && this.bcK.getVisibility() == 8 && this.bbg.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.GO.getResources().getDimension(r.e.ds56), 0, 0);
                this.bbg.setPadding(0, 0, 0, 0);
            } else if (this.bbg.wB()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bbg.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bbg.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        ArrayList<VoiceData.VoiceModel> rT = bgVar.rT();
        if (com.baidu.tbadk.core.util.x.t(rT)) {
            this.bcK.setVisibility(8);
        } else {
            this.bcK.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bcK.setVoiceModel(voiceModel);
            this.bcK.setTag(voiceModel);
            this.bcK.axx();
            if (voiceModel != null) {
                this.bcK.lw(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rP) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rP, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.av.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.s(linkedList) > 0) {
                this.bcO.setVisibility(0);
                this.bcO.setFromCDN(this.adn);
                if (this.adN.sz() != null) {
                    this.bcO.setImageClickListener(new ah(this));
                } else {
                    this.bcO.setImageClickListener(new ai(this, linkedList2, bgVar));
                }
                this.bcO.setImageUrls(linkedList);
            } else {
                this.bcO.setVisibility(8);
            }
        } else {
            this.bcO.setVisibility(8);
        }
        if (this.bGl != null) {
            if (bgVar.rR() != null) {
                String sV = bgVar.rR().sV();
                if (!StringUtils.isNull(sV)) {
                    this.bGl.setVisibility(0);
                    this.bGl.c(sV, 10, true);
                } else {
                    this.bGl.setVisibility(8);
                }
            } else {
                this.bGl.setVisibility(8);
            }
        }
        if (this.bAU != null) {
            if (bgVar.rS() != null) {
                String mm = bgVar.rS().mm();
                if (!StringUtils.isNull(mm)) {
                    String fixedText = com.baidu.tbadk.core.util.av.getFixedText(mm, 20, true);
                    com.baidu.tbadk.core.util.ar.k(this.bAU, r.f.btn_red_frame_n);
                    com.baidu.tbadk.core.util.ar.j((View) this.bAU, r.d.cp_cont_h);
                    this.bAU.setText(fixedText);
                    this.bAU.setVisibility(0);
                } else {
                    this.bAU.setVisibility(8);
                }
            } else {
                this.bAU.setVisibility(8);
            }
        }
        OC();
        p.a(this.adN, this.bbM);
        p(bgVar);
    }

    public void p(bg bgVar) {
        MetaData author;
        if (bgVar != null && this.bAE != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rZ = bgVar.rZ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcJ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bcd.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bAE.setVisibility(8);
                if (this.bAV != null) {
                    if (rZ != null) {
                        this.bAV.a(this.GO, rZ, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bgVar.getFid()), bgVar.rK(), bgVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                    } else {
                        this.bAV.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bAE.setVisibility(0);
                this.bAE.setImageBitmap(null);
                this.bAE.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bAE.setOnClickListener(new aj(this, themeCard));
                this.bAV.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
            }
            this.bcJ.setLayoutParams(layoutParams);
            this.bcd.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GO.getPageActivity(), r.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, bgVar.rK(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.adn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void OC() {
        this.bcK.setClickable(true);
        this.bbg.setBarNameClickEnabled(true);
        int childCount = this.bcO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bcO.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adn = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbg != null && this.bct != null) {
            this.bbg.h(bdUniqueId);
            this.bct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        if (this.adN != null) {
            com.baidu.tieba.card.ap.hL(this.adN.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.adN));
            com.baidu.tbadk.core.data.n sz = this.adN.sz();
            if (sz != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.GO.getPageActivity(), sz.getCartoonId(), sz.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.adN.UE;
            if (this.adN.UD == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Ql;
                long j = kVar.Qm;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.GO;
                amVar.bookId = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
            } else if (this.adN.rS() != null) {
                if (bh.ai(this.GO.getPageActivity())) {
                    String postUrl = this.adN.rS().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                        com.baidu.tbadk.browser.f.v(this.GO.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.r.gx(this.adN.getId());
                if (this.adN.sa() > 0 && com.baidu.tieba.tbadkCore.util.s.bha()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.GO.getPageActivity()).createHistoryCfg(this.adN.getTid(), String.valueOf(this.adN.sa()), false, true, com.baidu.tieba.card.ap.OB());
                    createHistoryCfg.setVideo_source("frs");
                    createHistoryCfg.setFromSmartFrs(this.adN.sG());
                    this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.adN, this.mForumName, com.baidu.tieba.card.ap.OB(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setFromSmartFrs(this.adN.sG());
                this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
