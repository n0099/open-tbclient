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
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.card.cb;
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
public class x extends com.baidu.tieba.card.a<bk> implements cb {
    private bk ahV;
    protected boolean ahv;
    private TbPageContext<?> ajr;
    private final View.OnClickListener alY;
    public ClickableHeaderImageView amf;
    public ViewStub amh;
    public TbImageView ami;
    private final View.OnClickListener amk;
    public TbImageView bQf;
    protected TextView bQv;
    public RelativeLayout bTD;
    protected TbImageView bTE;
    private View.OnClickListener bTF;
    private com.baidu.tieba.frs.e.ae bTy;
    public LinearLayout bcs;
    public ThreadSkinView bct;
    private CardGroupDividerView buA;
    public View buR;
    public HeadPendantClickableView buV;
    public PlayVoiceBntNew bvC;
    protected TextView bvF;
    protected ConstrainImageGroup bvG;
    private View.OnClickListener bvI;
    private final View.OnClickListener bvJ;
    public ThreadCommentAndPraiseInfoLayout bvN;
    public UserIconLayout bvQ;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahv = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bvI = new y(this);
        this.bTF = new z(this);
        this.bvJ = new aa(this);
        this.amk = new ab(this);
        this.alY = new ac(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajr = tbPageContext;
        this.ds16 = (int) this.ajr.getResources().getDimension(w.f.ds16);
        this.ds32 = (int) this.ajr.getResources().getDimension(w.f.ds32);
        this.amf = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.buV = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.amf.setDefaultResource(17170445);
        this.amf.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.amf.setDefaultBgResource(w.e.cp_bg_line_e);
        this.amf.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        this.amh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.buV.getHeadView() != null) {
            this.buV.getHeadView().setIsRound(true);
            this.buV.getHeadView().setDrawBorder(false);
            this.buV.getHeadView().setDefaultResource(17170445);
            this.buV.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.buV.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.buV.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        }
        this.buV.vY();
        if (this.buV.getPendantView() != null) {
            this.buV.getPendantView().setIsRound(true);
            this.buV.getPendantView().setDrawBorder(false);
        }
        this.bvQ = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.bvQ.amE = true;
        this.bvQ.setEntelechyEnabled(true);
        this.bvQ.setPageName(1);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvC = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvC.setAfterClickListener(this.bvJ);
        this.bvC.setPlayTimeTextView(w.f.fontsize28);
        this.bQf = (TbImageView) view.findViewById(w.h.frs_normal_item_theme_card);
        this.bQf.setPageId(getTag());
        this.bvF = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bvF.setFocusable(true);
        this.bvG = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
        this.bvG.setSingleImageRatio(0.75d);
        this.bvG.setImageMargin(dimensionPixelSize);
        this.bvG.setChildClickListener(this.bTF);
        this.bvN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bvN.setLocationEnabled(true);
        this.bvN.setViewNumEnabled(true);
        this.bvN.setCommentNumClickListener(this.bvI);
        this.buR = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bcs = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bTD = (RelativeLayout) view.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bTE = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.bTE.setPageId(getTag());
        this.bQv = (TextView) view.findViewById(w.h.app_code_btn);
        this.bct = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.buA = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.buA.setTitleClickListener(this.bvI);
        this.bTy = new com.baidu.tieba.frs.e.ae(this.ajr, this.bvN);
        this.bTy.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvG != null) {
            this.bvG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvG != null) {
            this.bvG.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bTD, w.g.addresslist_item_bg);
            this.bvG.onChangeSkinType();
            this.bvQ.onChangeSkinType();
            this.bvN.onChangeSkinType();
            if (this.buA != null) {
                this.buA.onChangeSkinType();
            }
            this.bTy.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: p */
    public void onBindDataToView(bk bkVar) {
        int i;
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahV = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bTD != null) {
                this.bTD.setOnClickListener(this.bvI);
                this.bTD.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bvI);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tieba.card.ap.hZ(this.ahV.getId())) {
            com.baidu.tieba.card.ap.a(this.mTitle, this.ahV.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvF, this.ahV.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
        }
        this.bvQ.setVisibility(0);
        if (this.ahV.getAuthor() != null && !StringUtils.isNull(this.ahV.getAuthor().getSealPrefix())) {
            this.bvQ.aP(true);
        }
        if (this.ahV.getAuthor() == null || this.ahV.getAuthor().getPendantData() == null || StringUtils.isNull(this.ahV.getAuthor().getPendantData().pT())) {
            UserTbVipInfoData rz = this.ahV.rz();
            if (rz != null && rz.getvipV_url() != null) {
                if (this.amh != null) {
                    if (this.ami == null) {
                        this.amh.inflate();
                        this.ami = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.ami.setVisibility(0);
                    this.ami.c(rz.getvipV_url(), 10, false);
                    this.amf.setIsBigV(true);
                }
            } else {
                this.amf.setIsBigV(false);
                if (this.ami != null) {
                    this.ami.setVisibility(8);
                }
            }
            this.buV.setVisibility(8);
            this.amf.setVisibility(0);
            this.amf.setData(bkVar);
            this.amf.setAfterClickListener(this.amk);
        } else {
            this.amf.setVisibility(4);
            this.amf.setIsBigV(false);
            if (this.ami != null) {
                this.ami.setVisibility(8);
            }
            this.buV.setVisibility(0);
            this.buV.setData(bkVar);
        }
        this.bvQ.setData(bkVar);
        this.bvQ.setUserAfterClickListener(this.amk);
        if (this.bvN.a(bkVar)) {
            this.buR.setVisibility(8);
        } else {
            this.buR.setVisibility(0);
        }
        this.bvN.e(this.mTbPageContext);
        this.bvN.setForumAfterClickListener(this.alY);
        this.bvN.setStType(com.baidu.tieba.card.ap.rp());
        if ((StringUtils.isNull(bkVar.getTitle()) && (bkVar.rx() == null || bkVar.rx().size() == 0)) || bkVar.rN() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            bkVar.XF = 0;
            bkVar.e(false, bkVar.sv());
            SpannableStringBuilder rY = bkVar.rY();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rY));
            this.mTitle.setText(rY);
            com.baidu.tieba.card.ap.a(this.mTitle, bkVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bkVar.rG() != null && !StringUtils.isNull(bkVar.rG())) {
            sb.append(bkVar.rG());
        }
        ArrayList<MediaData> rI = bkVar.rI();
        if (rI != null) {
            i = rI.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rI.get(i2).getVideoUrl() != null && rI.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rI.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bkVar.g(sb.toString(), true))) {
                SpannableString cv = bkVar.cv(sb.toString());
                this.bvF.setOnTouchListener(new com.baidu.tieba.view.aa(cv));
                this.bvF.setText(cv);
                this.bvF.setContentDescription(sb.toString());
                this.bvF.setVisibility(0);
                com.baidu.tieba.card.ap.a(this.bvF, bkVar.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.bvF.setVisibility(8);
            }
        } else {
            this.bvF.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvN.getLayoutParams();
        if (layoutParams != null) {
            if (this.bvF.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bvC.getVisibility() == 8 && this.bvN.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ajr.getResources().getDimension(w.f.ds56), 0, 0);
                this.bvN.setPadding(0, 0, 0, 0);
            } else if (this.bvN.wA()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bvN.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bvN.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.bTy.F(this.ahV);
        ArrayList<VoiceData.VoiceModel> rM = bkVar.rM();
        if (com.baidu.tbadk.core.util.x.r(rM)) {
            this.bvC.setVisibility(8);
        } else {
            this.bvC.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.bvC.setVoiceModel(voiceModel);
            this.bvC.setTag(voiceModel);
            this.bvC.aYC();
            if (voiceModel != null) {
                this.bvC.lT(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.r.oV().pb() && com.baidu.tbadk.core.util.x.q(rI) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rI, i3);
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
                this.bvG.setVisibility(0);
                this.bvG.setFromCDN(this.ahv);
                if (this.ahV.su() != null) {
                    this.bvG.setImageClickListener(new ad(this));
                } else {
                    this.bvG.setImageClickListener(new ae(this, linkedList2, bkVar));
                }
                this.bvG.setImageUrls(linkedList);
            } else {
                this.bvG.setVisibility(8);
            }
        } else {
            this.bvG.setVisibility(8);
        }
        if (this.bTE != null) {
            if (bkVar.rK() != null) {
                String sX = bkVar.rK().sX();
                if (!StringUtils.isNull(sX)) {
                    this.bTE.setVisibility(0);
                    this.bTE.c(sX, 10, true);
                } else {
                    this.bTE.setVisibility(8);
                }
            } else {
                this.bTE.setVisibility(8);
            }
        }
        if (this.bQv != null) {
            if (bkVar.rL() != null) {
                String pz = bkVar.rL().pz();
                if (!StringUtils.isNull(pz)) {
                    String fixedText = com.baidu.tbadk.core.util.au.getFixedText(pz, 20, true);
                    com.baidu.tbadk.core.util.aq.j(this.bQv, w.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.aq.i(this.bQv, w.e.cp_cont_h);
                    this.bQv.setText(fixedText);
                    this.bQv.setVisibility(0);
                } else {
                    this.bQv.setVisibility(8);
                }
            } else {
                this.bQv.setVisibility(8);
            }
        }
        Ti();
        p.a(this.ahV, this.buA);
        w(bkVar);
    }

    public void w(bk bkVar) {
        MetaData author;
        if (bkVar != null && this.bQf != null && (author = bkVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rT = bkVar.rT();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amf.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bcs.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bQf.setVisibility(8);
                if (this.bct != null) {
                    if (rT != null) {
                        this.bct.a(this.ajr, rT, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bkVar.getFid()), bkVar.rD(), bkVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds16);
                    } else {
                        this.bct.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bQf.setVisibility(0);
                this.bQf.setImageBitmap(null);
                this.bQf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bQf.setOnClickListener(new af(this, themeCard));
                this.bct.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds30);
            }
            this.amf.setLayoutParams(layoutParams);
            this.bcs.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bk bkVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajr.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahv ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bkVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajr.getPageActivity()).createConfig(arrayList, i, bkVar.rD(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.ahv, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Ti() {
        this.bvC.setClickable(true);
        this.bvN.setBarNameClickEnabled(true);
        int childCount = this.bvG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvG.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahv = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvN != null) {
            this.bvN.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        PbActivityConfig createFromThreadCfg;
        if (this.ahV != null) {
            com.baidu.tieba.card.ap.hY(this.ahV.getId());
            com.baidu.tieba.card.ap.a(this.mTitle, this.ahV.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvF, this.ahV.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahV));
            com.baidu.tbadk.core.data.n su = this.ahV.su();
            if (su != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajr.getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ahV.YL;
            if (this.ahV.YK == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Uk;
                long j = kVar.Ul;
                com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
                apVar.pageContext = this.ajr;
                apVar.bookId = str;
                apVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, apVar));
            } else if (this.ahV.rL() != null) {
                if (bg.aN(this.ajr.getPageActivity())) {
                    String postUrl = this.ahV.rL().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hB()) {
                        com.baidu.tbadk.browser.f.T(this.ajr.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.u.gn(this.ahV.getId());
                boolean z = this.ahV.getType() != bk.Xt;
                if (this.ahV.rU() > 0 && com.baidu.tieba.tbadkCore.util.s.bhK()) {
                    createFromThreadCfg = new PbActivityConfig(this.ajr.getPageActivity()).createHistoryCfg(this.ahV.getTid(), String.valueOf(this.ahV.rU()), false, z, com.baidu.tieba.card.ap.rp());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.ajr.getPageActivity()).createFromThreadCfg(this.ahV, this.mForumName, com.baidu.tieba.card.ap.rp(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ahV.sB());
                    createFromThreadCfg.setSmartFrsPosition(this.ahV.sE());
                    createFromThreadCfg.setForumId(String.valueOf(this.ahV.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.ajr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
