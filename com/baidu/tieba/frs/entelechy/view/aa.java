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
    private bi aiB;
    protected boolean aic;
    private TbPageContext<?> ajT;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    public TbImageView bOX;
    protected TextView bPn;
    private com.baidu.tieba.frs.g.af bTn;
    public HeadPendantClickableView bTu;
    public RelativeLayout bTv;
    protected TbImageView bTw;
    private View.OnClickListener bTx;
    public ViewStub bba;
    public TbImageView bbb;
    public LinearLayout bbe;
    public ThreadSkinView bbf;
    protected TextView brC;
    public ThreadCommentAndPraiseInfoLayout brE;
    private CustomMessageListener bsD;
    private CardGroupDividerView bsk;
    public ClickableHeaderImageView btk;
    public PlayVoiceBntNew btl;
    public View btm;
    public UserIconLayout bto;
    protected ConstrainImageGroup btq;
    private View.OnClickListener btr;
    private final View.OnClickListener btt;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aic = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.btr = new ab(this);
        this.bTx = new ac(this);
        this.bsD = new ad(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.btt = new ae(this);
        this.amx = new af(this);
        this.ama = new ag(this);
        View view = getView();
        this.ajT = tbPageContext;
        this.ds16 = (int) this.ajT.getResources().getDimension(w.f.ds16);
        this.ds32 = (int) this.ajT.getResources().getDimension(w.f.ds32);
        this.btk = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bTu = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.btk.setDefaultResource(17170445);
        this.btk.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btk.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btk.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bTu.getHeadView() != null) {
            this.bTu.getHeadView().setIsRound(true);
            this.bTu.getHeadView().setDrawBorder(false);
            this.bTu.getHeadView().setDefaultResource(17170445);
            this.bTu.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTu.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTu.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        }
        this.bTu.wL();
        if (this.bTu.getPendantView() != null) {
            this.bTu.getPendantView().setIsRound(true);
            this.bTu.getPendantView().setDrawBorder(false);
        }
        this.bto = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.bto.amv = true;
        this.bto.setEntelechyEnabled(true);
        this.bto.setPageName(1);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.btl = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.btl.setAfterClickListener(this.btt);
        this.btl.setPlayTimeTextView(w.f.fontsize28);
        this.bOX = (TbImageView) view.findViewById(w.h.frs_normal_item_theme_card);
        this.brC = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.brC.setFocusable(true);
        this.btq = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
        this.btq.setSingleImageRatio(0.75d);
        this.btq.setImageMargin(dimensionPixelSize);
        this.btq.setChildClickListener(this.bTx);
        this.brE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.brE.setLocationEnabled(true);
        this.brE.setViewNumEnabled(true);
        this.brE.setCommentNumClickListener(this.btr);
        this.btm = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bbe = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bTv = (RelativeLayout) view.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bTw = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.bPn = (TextView) view.findViewById(w.h.app_code_btn);
        this.bbf = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bsk = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bsk.setTitleClickListener(this.btr);
        this.bTn = new com.baidu.tieba.frs.g.af(this.ajT, this.brE);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.btq != null) {
            this.btq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.btq != null) {
            this.btq.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bTv, w.g.addresslist_item_bg);
            this.btq.onChangeSkinType();
            this.bto.onChangeSkinType();
            this.brE.onChangeSkinType();
            if (this.bsk != null) {
                this.bsk.onChangeSkinType();
            }
            this.bTn.onChangeSkinType();
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
        this.aiB = biVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bTv != null) {
                this.bTv.setOnClickListener(this.btr);
                this.bTv.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.btr);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        this.bto.setVisibility(0);
        if (this.aiB.getAuthor() != null && !StringUtils.isNull(this.aiB.getAuthor().getSealPrefix())) {
            this.bto.aP(true);
        }
        if (this.aiB.getAuthor() == null || this.aiB.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiB.getAuthor().getPendantData().qB())) {
            UserTbVipInfoData sp = this.aiB.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bba != null) {
                    if (this.bbb == null) {
                        this.bba.inflate();
                        this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbb.setVisibility(0);
                    this.bbb.c(sp.getvipV_url(), 10, false);
                    this.btk.setIsBigV(true);
                }
            } else {
                this.btk.setIsBigV(false);
                if (this.bbb != null) {
                    this.bbb.setVisibility(8);
                }
            }
            this.bTu.setVisibility(8);
            this.btk.setVisibility(0);
            this.btk.setData(biVar);
            this.btk.setAfterClickListener(this.amx);
        } else {
            this.btk.setVisibility(4);
            this.btk.setIsBigV(false);
            if (this.bbb != null) {
                this.bbb.setVisibility(8);
            }
            this.bTu.setVisibility(0);
            this.bTu.setData(biVar);
        }
        this.bto.setData(biVar);
        this.bto.setUserAfterClickListener(this.amx);
        if (this.brE.a(biVar)) {
            this.btm.setVisibility(8);
        } else {
            this.btm.setVisibility(0);
        }
        this.brE.e(this.mTbPageContext);
        this.brE.setForumAfterClickListener(this.ama);
        this.brE.setStType(com.baidu.tieba.card.at.sf());
        if ((StringUtils.isNull(biVar.getTitle()) && (biVar.sn() == null || biVar.sn().size() == 0)) || biVar.sD() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            biVar.Ym = 0;
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
                this.brC.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.brC.setText(cx);
                this.brC.setContentDescription(sb.toString());
                this.brC.setVisibility(0);
                com.baidu.tieba.card.at.a(this.brC, biVar.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.brC.setVisibility(8);
            }
        } else {
            this.brC.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brE.getLayoutParams();
        if (layoutParams != null) {
            if (this.brC.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.btl.getVisibility() == 8 && this.brE.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ajT.getResources().getDimension(w.f.ds56), 0, 0);
                this.brE.setPadding(0, 0, 0, 0);
            } else if (this.brE.xp()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.brE.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.brE.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.bTn.A(this.aiB);
        ArrayList<VoiceData.VoiceModel> sC = biVar.sC();
        if (com.baidu.tbadk.core.util.x.q(sC)) {
            this.btl.setVisibility(8);
        } else {
            this.btl.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sC.get(0);
            this.btl.setVoiceModel(voiceModel);
            this.btl.setTag(voiceModel);
            this.btl.bac();
            if (voiceModel != null) {
                this.btl.ma(voiceModel.voice_status.intValue());
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
                this.btq.setVisibility(0);
                this.btq.setFromCDN(this.aic);
                if (this.aiB.tk() != null) {
                    this.btq.setImageClickListener(new ah(this));
                } else {
                    this.btq.setImageClickListener(new ai(this, linkedList2, biVar));
                }
                this.btq.setImageUrls(linkedList);
            } else {
                this.btq.setVisibility(8);
            }
        } else {
            this.btq.setVisibility(8);
        }
        if (this.bTw != null) {
            if (biVar.sA() != null) {
                String tK = biVar.sA().tK();
                if (!StringUtils.isNull(tK)) {
                    this.bTw.setVisibility(0);
                    this.bTw.c(tK, 10, true);
                } else {
                    this.bTw.setVisibility(8);
                }
            } else {
                this.bTw.setVisibility(8);
            }
        }
        if (this.bPn != null) {
            if (biVar.sB() != null) {
                String pS = biVar.sB().pS();
                if (!StringUtils.isNull(pS)) {
                    String fixedText = com.baidu.tbadk.core.util.au.getFixedText(pS, 20, true);
                    com.baidu.tbadk.core.util.aq.j(this.bPn, w.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.aq.i(this.bPn, w.e.cp_cont_h);
                    this.bPn.setText(fixedText);
                    this.bPn.setVisibility(0);
                } else {
                    this.bPn.setVisibility(8);
                }
            } else {
                this.bPn.setVisibility(8);
            }
        }
        SO();
        p.a(this.aiB, this.bsk);
        s(biVar);
    }

    public void s(bi biVar) {
        MetaData author;
        if (biVar != null && this.bOX != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sJ = biVar.sJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btk.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bbe.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bOX.setVisibility(8);
                if (this.bbf != null) {
                    if (sJ != null) {
                        this.bbf.a(this.ajT, sJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.st(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds16);
                    } else {
                        this.bbf.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bOX.setVisibility(0);
                this.bOX.setImageBitmap(null);
                this.bOX.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bOX.setOnClickListener(new aj(this, themeCard));
                this.bbf.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds30);
            }
            this.btk.setLayoutParams(layoutParams);
            this.bbe.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajT.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aic ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajT.getPageActivity()).createConfig(arrayList, i, biVar.st(), String.valueOf(biVar.getFid()), biVar.getTid(), this.aic, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void SO() {
        this.btl.setClickable(true);
        this.brE.setBarNameClickEnabled(true);
        int childCount = this.btq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.btq.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aic = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brE != null && this.bsD != null) {
            this.brE.h(bdUniqueId);
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SP() {
        if (this.aiB != null) {
            com.baidu.tieba.card.at.hY(this.aiB.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiB));
            com.baidu.tbadk.core.data.n tk = this.aiB.tk();
            if (tk != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajT.getPageActivity(), tk.getCartoonId(), tk.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aiB.Zs;
            if (this.aiB.Zr == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UR;
                long j = kVar.US;
                com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                aoVar.pageContext = this.ajT;
                aoVar.bookId = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
            } else if (this.aiB.sB() != null) {
                if (bg.aK(this.ajT.getPageActivity())) {
                    String postUrl = this.aiB.sB().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hA()) {
                        com.baidu.tbadk.browser.f.T(this.ajT.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.r.gp(this.aiB.getId());
                if (this.aiB.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bjm()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajT.getPageActivity()).createHistoryCfg(this.aiB.getTid(), String.valueOf(this.aiB.sK()), false, true, com.baidu.tieba.card.at.sf());
                    createHistoryCfg.setVideo_source("frs");
                    createHistoryCfg.setFromSmartFrs(this.aiB.tr());
                    createHistoryCfg.setSmartFrsPosition(this.aiB.tu());
                    this.ajT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajT.getPageActivity()).createFromThreadCfg(this.aiB, this.mForumName, com.baidu.tieba.card.at.sf(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setFromSmartFrs(this.aiB.tr());
                createFromThreadCfg.setSmartFrsPosition(this.aiB.tu());
                this.ajT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
