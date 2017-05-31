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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.cg;
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
public class x extends com.baidu.tieba.card.a<bl> implements cg {
    private bl ahM;
    protected boolean ahm;
    private TbPageContext<?> ajh;
    private final View.OnClickListener alO;
    public ClickableHeaderImageView alV;
    public ViewStub alX;
    public TbImageView alY;
    private final View.OnClickListener ama;
    private CardGroupDividerView bAn;
    public UserIconLayout bBA;
    public PlayVoiceBntNew bBq;
    protected TextView bBr;
    protected ConstrainImageGroup bBs;
    private final View.OnClickListener bBt;
    public ThreadCommentAndPraiseInfoLayout bBx;
    public TbImageView bVW;
    protected TextView bWm;
    private com.baidu.tieba.frs.f.ae bZq;
    public RelativeLayout bZv;
    protected TbImageView bZw;
    private View.OnClickListener bZx;
    public LinearLayout bdK;
    public ThreadSkinView bdL;
    public HeadPendantClickableView bzC;
    public View bzE;
    private View.OnClickListener bzI;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahm = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bzI = new y(this);
        this.bZx = new z(this);
        this.bBt = new aa(this);
        this.ama = new ab(this);
        this.alO = new ac(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajh = tbPageContext;
        this.ds16 = (int) this.ajh.getResources().getDimension(w.f.ds16);
        this.ds32 = (int) this.ajh.getResources().getDimension(w.f.ds32);
        this.alV = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bzC = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.alV.setDefaultResource(17170445);
        this.alV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.alV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.alV.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        this.alX = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bzC.getHeadView() != null) {
            this.bzC.getHeadView().setIsRound(true);
            this.bzC.getHeadView().setDrawBorder(false);
            this.bzC.getHeadView().setDefaultResource(17170445);
            this.bzC.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bzC.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bzC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        }
        this.bzC.vV();
        if (this.bzC.getPendantView() != null) {
            this.bzC.getPendantView().setIsRound(true);
            this.bzC.getPendantView().setDrawBorder(false);
        }
        this.bBA = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.bBA.amA = true;
        this.bBA.setEntelechyEnabled(true);
        this.bBA.setPageName(1);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bBq = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bBq.setAfterClickListener(this.bBt);
        this.bBq.setPlayTimeTextView(w.f.fontsize28);
        this.bVW = (TbImageView) view.findViewById(w.h.frs_normal_item_theme_card);
        this.bVW.setPageId(getTag());
        this.bBr = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bBr.setFocusable(true);
        this.bBs = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
        this.bBs.setSingleImageRatio(0.75d);
        this.bBs.setImageMargin(dimensionPixelSize);
        this.bBs.setChildClickListener(this.bZx);
        this.bBx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bBx.setLocationEnabled(true);
        this.bBx.setViewNumEnabled(true);
        this.bBx.setCommentNumClickListener(this.bzI);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bdK = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bZv = (RelativeLayout) view.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bZw = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.bZw.setPageId(getTag());
        this.bWm = (TextView) view.findViewById(w.h.app_code_btn);
        this.bdL = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bAn = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bAn.setTitleClickListener(this.bzI);
        this.bZq = new com.baidu.tieba.frs.f.ae(this.ajh, this.bBx);
        this.bZq.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bBs != null) {
            this.bBs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bBs != null) {
            this.bBs.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bZv, w.g.addresslist_item_bg);
            this.bBs.onChangeSkinType();
            this.bBA.onChangeSkinType();
            this.bBx.onChangeSkinType();
            if (this.bAn != null) {
                this.bAn.onChangeSkinType();
            }
            this.bZq.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: r */
    public void a(bl blVar) {
        int i;
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahM = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bZv != null) {
                this.bZv.setOnClickListener(this.bzI);
                this.bZv.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bzI);
                getView().setLongClickable(true);
            }
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tieba.card.at.ic(this.ahM.getId())) {
            com.baidu.tieba.card.at.a(this.mTitle, this.ahM.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bBr, this.ahM.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
        }
        this.bBA.setVisibility(0);
        if (this.ahM.getAuthor() != null && !StringUtils.isNull(this.ahM.getAuthor().getSealPrefix())) {
            this.bBA.aN(true);
        }
        if (this.ahM.getAuthor() == null || this.ahM.getAuthor().getPendantData() == null || StringUtils.isNull(this.ahM.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rv = this.ahM.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.alX != null) {
                    if (this.alY == null) {
                        this.alX.inflate();
                        this.alY = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.alY.setVisibility(0);
                    this.alY.c(rv.getvipV_url(), 10, false);
                    this.alV.setIsBigV(true);
                }
            } else {
                this.alV.setIsBigV(false);
                if (this.alY != null) {
                    this.alY.setVisibility(8);
                }
            }
            this.bzC.setVisibility(8);
            this.alV.setVisibility(0);
            this.alV.setData(blVar);
            this.alV.setAfterClickListener(this.ama);
        } else {
            this.alV.setVisibility(4);
            this.alV.setIsBigV(false);
            if (this.alY != null) {
                this.alY.setVisibility(8);
            }
            this.bzC.setVisibility(0);
            this.bzC.setData(blVar);
        }
        this.bBA.setData(blVar);
        this.bBA.setUserAfterClickListener(this.ama);
        if (this.bBx.a(blVar)) {
            this.bzE.setVisibility(8);
        } else {
            this.bzE.setVisibility(0);
        }
        this.bBx.e(this.mTbPageContext);
        this.bBx.setForumAfterClickListener(this.alO);
        this.bBx.setStType(com.baidu.tieba.card.at.rl());
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rJ() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            blVar.XB = 0;
            blVar.e(false, blVar.sr());
            SpannableStringBuilder rU = blVar.rU();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rU));
            this.mTitle.setText(rU);
            com.baidu.tieba.card.at.a(this.mTitle, blVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rC() != null && !StringUtils.isNull(blVar.rC())) {
            sb.append(blVar.rC());
        }
        ArrayList<MediaData> rE = blVar.rE();
        if (rE != null) {
            i = rE.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rE.get(i2).getVideoUrl() != null && rE.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rE.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cu = blVar.cu(sb.toString());
                this.bBr.setOnTouchListener(new com.baidu.tieba.view.aa(cu));
                this.bBr.setText(cu);
                this.bBr.setContentDescription(sb.toString());
                this.bBr.setVisibility(0);
                com.baidu.tieba.card.at.a(this.bBr, blVar.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.bBr.setVisibility(8);
            }
        } else {
            this.bBr.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBx.getLayoutParams();
        if (layoutParams != null) {
            if (this.bBr.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bBq.getVisibility() == 8 && this.bBx.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ajh.getResources().getDimension(w.f.ds56), 0, 0);
                this.bBx.setPadding(0, 0, 0, 0);
            } else if (this.bBx.ww()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bBx.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bBx.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.bZq.K(this.ahM);
        ArrayList<VoiceData.VoiceModel> rI = blVar.rI();
        if (com.baidu.tbadk.core.util.x.r(rI)) {
            this.bBq.setVisibility(8);
        } else {
            this.bBq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bBq.setVoiceModel(voiceModel);
            this.bBq.setTag(voiceModel);
            this.bBq.aZV();
            if (voiceModel != null) {
                this.bBq.mn(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.r.oN().oT() && com.baidu.tbadk.core.util.x.q(rE) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rE, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.au.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(linkedList) > 0) {
                this.bBs.setVisibility(0);
                this.bBs.setFromCDN(this.ahm);
                if (this.ahM.sq() != null) {
                    this.bBs.setImageClickListener(new ad(this));
                } else {
                    this.bBs.setImageClickListener(new ae(this, linkedList2, blVar));
                }
                this.bBs.setImageUrls(linkedList);
            } else {
                this.bBs.setVisibility(8);
            }
        } else {
            this.bBs.setVisibility(8);
        }
        if (this.bZw != null) {
            if (blVar.rG() != null) {
                String sW = blVar.rG().sW();
                if (!StringUtils.isNull(sW)) {
                    this.bZw.setVisibility(0);
                    this.bZw.c(sW, 10, true);
                } else {
                    this.bZw.setVisibility(8);
                }
            } else {
                this.bZw.setVisibility(8);
            }
        }
        if (this.bWm != null) {
            if (blVar.rH() != null) {
                String pr = blVar.rH().pr();
                if (!StringUtils.isNull(pr)) {
                    String fixedText = com.baidu.tbadk.core.util.au.getFixedText(pr, 20, true);
                    com.baidu.tbadk.core.util.aq.j(this.bWm, w.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.aq.i(this.bWm, w.e.cp_cont_h);
                    this.bWm.setText(fixedText);
                    this.bWm.setVisibility(0);
                } else {
                    this.bWm.setVisibility(8);
                }
            } else {
                this.bWm.setVisibility(8);
            }
        }
        Uq();
        p.a(this.ahM, this.bAn);
        B(blVar);
    }

    public void B(bl blVar) {
        MetaData author;
        if (blVar != null && this.bVW != null && (author = blVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rP = blVar.rP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alV.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bdK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bVW.setVisibility(8);
                if (this.bdL != null) {
                    if (rP != null) {
                        this.bdL.a(this.ajh, rP, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rz(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds16);
                    } else {
                        this.bdL.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bVW.setVisibility(0);
                this.bVW.setImageBitmap(null);
                this.bVW.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bVW.setOnClickListener(new af(this, themeCard));
                this.bdL.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds30);
            }
            this.alV.setLayoutParams(layoutParams);
            this.bdK.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajh.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahm ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajh.getPageActivity()).createConfig(arrayList, i, blVar.rz(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ahm, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Uq() {
        this.bBq.setClickable(true);
        this.bBx.setBarNameClickEnabled(true);
        int childCount = this.bBs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bBs.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bBx != null) {
            this.bBx.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        PbActivityConfig createFromThreadCfg;
        if (this.ahM != null) {
            com.baidu.tieba.card.at.ib(this.ahM.getId());
            com.baidu.tieba.card.at.a(this.mTitle, this.ahM.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bBr, this.ahM.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahM));
            com.baidu.tbadk.core.data.n sq = this.ahM.sq();
            if (sq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajh.getPageActivity(), sq.getCartoonId(), sq.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ahM.YH;
            if (this.ahM.YG == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.TX;
                long j = kVar.TY;
                com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                aqVar.pageContext = this.ajh;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.ahM.rH() != null) {
                if (com.baidu.tbadk.core.util.bh.aN(this.ajh.getPageActivity())) {
                    String postUrl = this.ahM.rH().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hB()) {
                        com.baidu.tbadk.browser.f.T(this.ajh.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.u.gm(this.ahM.getId());
                boolean z = this.ahM.getType() != bl.Xo;
                if (this.ahM.rQ() > 0 && com.baidu.tieba.tbadkCore.util.s.bje()) {
                    createFromThreadCfg = new PbActivityConfig(this.ajh.getPageActivity()).createHistoryCfg(this.ahM.getTid(), String.valueOf(this.ahM.rQ()), false, z, com.baidu.tieba.card.at.rl());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.ahM, this.mForumName, com.baidu.tieba.card.at.rl(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ahM.sw());
                    createFromThreadCfg.setSmartFrsPosition(this.ahM.sC());
                    createFromThreadCfg.setForumId(String.valueOf(this.ahM.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
