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
import com.baidu.tbadk.core.data.bj;
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
public class aa extends com.baidu.tieba.card.a<bj> implements cd {
    private TextView aSO;
    protected boolean ahO;
    private bj ain;
    private TbPageContext<?> ajF;
    private final View.OnClickListener alM;
    private final View.OnClickListener amj;
    public TbImageView bPi;
    protected TextView bPy;
    public HeadPendantClickableView bTG;
    public RelativeLayout bTH;
    protected TbImageView bTI;
    private View.OnClickListener bTJ;
    private com.baidu.tieba.frs.f.af bTz;
    public ViewStub bbh;
    public TbImageView bbi;
    public LinearLayout bbl;
    public ThreadSkinView bbm;
    protected TextView brK;
    public ThreadCommentAndPraiseInfoLayout brM;
    private CustomMessageListener bsL;
    private CardGroupDividerView bss;
    private final View.OnClickListener btB;
    public ClickableHeaderImageView btt;
    public PlayVoiceBntNew btu;
    public View btv;
    public UserIconLayout btw;
    protected ConstrainImageGroup bty;
    private View.OnClickListener btz;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;

    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahO = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.btz = new ab(this);
        this.bTJ = new ac(this);
        this.bsL = new ad(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.btB = new ae(this);
        this.amj = new af(this);
        this.alM = new ag(this);
        View view = getView();
        this.ajF = tbPageContext;
        this.ds16 = (int) this.ajF.getResources().getDimension(w.f.ds16);
        this.ds32 = (int) this.ajF.getResources().getDimension(w.f.ds32);
        this.btt = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bTG = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.btt.setDefaultResource(17170445);
        this.btt.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btt.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btt.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bTG.getHeadView() != null) {
            this.bTG.getHeadView().setIsRound(true);
            this.bTG.getHeadView().setDrawBorder(false);
            this.bTG.getHeadView().setDefaultResource(17170445);
            this.bTG.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTG.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTG.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        }
        this.bTG.wp();
        if (this.bTG.getPendantView() != null) {
            this.bTG.getPendantView().setIsRound(true);
            this.bTG.getPendantView().setDrawBorder(false);
        }
        this.btw = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.btw.amh = true;
        this.btw.setEntelechyEnabled(true);
        this.btw.setPageName(1);
        this.aSO = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.btu = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.btu.setAfterClickListener(this.btB);
        this.btu.setPlayTimeTextView(w.f.fontsize28);
        this.bPi = (TbImageView) view.findViewById(w.h.frs_normal_item_theme_card);
        this.brK = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.brK.setFocusable(true);
        this.bty = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
        this.bty.setSingleImageRatio(0.75d);
        this.bty.setImageMargin(dimensionPixelSize);
        this.bty.setChildClickListener(this.bTJ);
        this.brM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.brM.setLocationEnabled(true);
        this.brM.setViewNumEnabled(true);
        this.brM.setCommentNumClickListener(this.btz);
        this.btv = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bbl = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bTH = (RelativeLayout) view.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bTI = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.bPy = (TextView) view.findViewById(w.h.app_code_btn);
        this.bbm = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bss = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bss.setTitleClickListener(this.btz);
        this.bTz = new com.baidu.tieba.frs.f.af(this.ajF, this.brM);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bty != null) {
            this.bty.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bty != null) {
            this.bty.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bTH, w.g.addresslist_item_bg);
            this.bty.tD();
            this.btw.tD();
            this.brM.tD();
            if (this.bss != null) {
                this.bss.tD();
            }
            this.bTz.tD();
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
    public void onBindDataToView(bj bjVar) {
        int i;
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ain = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bTH != null) {
                this.bTH.setOnClickListener(this.btz);
                this.bTH.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.btz);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        this.btw.setVisibility(0);
        if (this.ain.getAuthor() != null && !StringUtils.isNull(this.ain.getAuthor().getSealPrefix())) {
            this.btw.aN(true);
        }
        if (this.ain.getAuthor() == null || this.ain.getAuthor().getPendantData() == null || StringUtils.isNull(this.ain.getAuthor().getPendantData().qd())) {
            UserTbVipInfoData rR = this.ain.rR();
            if (rR != null && rR.getvipV_url() != null) {
                if (this.bbh != null) {
                    if (this.bbi == null) {
                        this.bbh.inflate();
                        this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbi.setVisibility(0);
                    this.bbi.c(rR.getvipV_url(), 10, false);
                    this.btt.setIsBigV(true);
                }
            } else {
                this.btt.setIsBigV(false);
                if (this.bbi != null) {
                    this.bbi.setVisibility(8);
                }
            }
            this.bTG.setVisibility(8);
            this.btt.setVisibility(0);
            this.btt.setData(bjVar);
            this.btt.setAfterClickListener(this.amj);
        } else {
            this.btt.setVisibility(4);
            this.btt.setIsBigV(false);
            if (this.bbi != null) {
                this.bbi.setVisibility(8);
            }
            this.bTG.setVisibility(0);
            this.bTG.setData(bjVar);
        }
        this.btw.setData(bjVar);
        this.btw.setUserAfterClickListener(this.amj);
        if (this.brM.a(bjVar)) {
            this.btv.setVisibility(8);
        } else {
            this.btv.setVisibility(0);
        }
        this.brM.e(this.mTbPageContext);
        this.brM.setForumAfterClickListener(this.alM);
        this.brM.setStType(com.baidu.tieba.card.at.rH());
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.rP() == null || bjVar.rP().size() == 0)) || bjVar.sf() == 1) {
            this.aSO.setVisibility(8);
        } else {
            this.aSO.setVisibility(0);
            bjVar.XW = 0;
            bjVar.e(false, bjVar.sN());
            SpannableStringBuilder sq = bjVar.sq();
            this.aSO.setOnTouchListener(new com.baidu.tieba.view.x(sq));
            this.aSO.setText(sq);
            com.baidu.tieba.card.at.a(this.aSO, bjVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bjVar.rY() != null && !StringUtils.isNull(bjVar.rY())) {
            sb.append(bjVar.rY());
        }
        ArrayList<MediaData> sa = bjVar.sa();
        if (sa != null) {
            i = sa.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (sa.get(i2).getVideoUrl() != null && sa.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(sa.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bjVar.g(sb.toString(), true))) {
                SpannableString cq = bjVar.cq(sb.toString());
                this.brK.setOnTouchListener(new com.baidu.tieba.view.x(cq));
                this.brK.setText(cq);
                this.brK.setContentDescription(sb.toString());
                this.brK.setVisibility(0);
                com.baidu.tieba.card.at.a(this.brK, bjVar.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.brK.setVisibility(8);
            }
        } else {
            this.brK.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brM.getLayoutParams();
        if (layoutParams != null) {
            if (this.brK.getVisibility() == 8 && this.aSO.getVisibility() == 8 && this.btu.getVisibility() == 8 && this.brM.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ajF.getResources().getDimension(w.f.ds56), 0, 0);
                this.brM.setPadding(0, 0, 0, 0);
            } else if (this.brM.wT()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.brM.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.brM.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.bTz.D(this.ain);
        ArrayList<VoiceData.VoiceModel> se = bjVar.se();
        if (com.baidu.tbadk.core.util.x.q(se)) {
            this.btu.setVisibility(8);
        } else {
            this.btu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.btu.setVoiceModel(voiceModel);
            this.btu.setTag(voiceModel);
            this.btu.ayg();
            if (voiceModel != null) {
                this.btu.lZ(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.oQ().oW() && com.baidu.tbadk.core.util.x.p(sa) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(sa, i3);
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
                this.bty.setVisibility(0);
                this.bty.setFromCDN(this.ahO);
                if (this.ain.sM() != null) {
                    this.bty.setImageClickListener(new ah(this));
                } else {
                    this.bty.setImageClickListener(new ai(this, linkedList2, bjVar));
                }
                this.bty.setImageUrls(linkedList);
            } else {
                this.bty.setVisibility(8);
            }
        } else {
            this.bty.setVisibility(8);
        }
        if (this.bTI != null) {
            if (bjVar.sc() != null) {
                String tm = bjVar.sc().tm();
                if (!StringUtils.isNull(tm)) {
                    this.bTI.setVisibility(0);
                    this.bTI.c(tm, 10, true);
                } else {
                    this.bTI.setVisibility(8);
                }
            } else {
                this.bTI.setVisibility(8);
            }
        }
        if (this.bPy != null) {
            if (bjVar.sd() != null) {
                String pu = bjVar.sd().pu();
                if (!StringUtils.isNull(pu)) {
                    String fixedText = com.baidu.tbadk.core.util.au.getFixedText(pu, 20, true);
                    com.baidu.tbadk.core.util.aq.j(this.bPy, w.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.aq.i((View) this.bPy, w.e.cp_cont_h);
                    this.bPy.setText(fixedText);
                    this.bPy.setVisibility(0);
                } else {
                    this.bPy.setVisibility(8);
                }
            } else {
                this.bPy.setVisibility(8);
            }
        }
        Sq();
        p.a(this.ain, this.bss);
        s(bjVar);
    }

    public void s(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.bPi != null && (author = bjVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sl = bjVar.sl();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btt.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bbl.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bPi.setVisibility(8);
                if (this.bbm != null) {
                    if (sl != null) {
                        this.bbm.a(this.ajF, sl, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rV(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds16);
                    } else {
                        this.bbm.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bPi.setVisibility(0);
                this.bPi.setImageBitmap(null);
                this.bPi.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bPi.setOnClickListener(new aj(this, themeCard));
                this.bbm.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds30);
            }
            this.btt.setLayoutParams(layoutParams);
            this.bbl.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajF.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahO ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajF.getPageActivity()).createConfig(arrayList, i, bjVar.rV(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ahO, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Sq() {
        this.btu.setClickable(true);
        this.brM.setBarNameClickEnabled(true);
        int childCount = this.bty.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bty.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahO = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brM != null && this.bsL != null) {
            this.brM.h(bdUniqueId);
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        if (this.ain != null) {
            com.baidu.tieba.card.at.hU(this.ain.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ain));
            com.baidu.tbadk.core.data.n sM = this.ain.sM();
            if (sM != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajF.getPageActivity(), sM.getCartoonId(), sM.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ain.Zc;
            if (this.ain.Zb == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Uw;
                long j = kVar.Ux;
                com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
                apVar.pageContext = this.ajF;
                apVar.bookId = str;
                apVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, apVar));
            } else if (this.ain.sd() != null) {
                if (bg.aI(this.ajF.getPageActivity())) {
                    String postUrl = this.ain.sd().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hv()) {
                        com.baidu.tbadk.browser.f.P(this.ajF.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.r.gj(this.ain.getId());
                if (this.ain.sm() > 0 && com.baidu.tieba.tbadkCore.util.s.biB()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajF.getPageActivity()).createHistoryCfg(this.ain.getTid(), String.valueOf(this.ain.sm()), false, true, com.baidu.tieba.card.at.rH());
                    createHistoryCfg.setVideo_source("frs");
                    createHistoryCfg.setFromSmartFrs(this.ain.sT());
                    createHistoryCfg.setSmartFrsPosition(this.ain.sW());
                    this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajF.getPageActivity()).createFromThreadCfg(this.ain, this.mForumName, com.baidu.tieba.card.at.rH(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setFromSmartFrs(this.ain.sT());
                createFromThreadCfg.setSmartFrsPosition(this.ain.sW());
                this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
