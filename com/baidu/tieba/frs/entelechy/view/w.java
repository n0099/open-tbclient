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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.card.a<bk> implements ba {
    private TbPageContext<?> GO;
    private TextView aOH;
    protected boolean adU;
    private bk aeu;
    private final View.OnClickListener ahD;
    private final View.OnClickListener ahZ;
    private View aro;
    protected TextView bUI;
    public ThreadSkinView bUJ;
    public TbImageView bUs;
    public ViewStub bbQ;
    public TbImageView bbR;
    protected TextView bbY;
    public LinearLayout bcK;
    public ThreadCommentAndPraiseInfoLayout bca;
    private CustomMessageListener bdb;
    public ClickableHeaderImageView bdr;
    public PlayVoiceBntNew bds;
    public View bdt;
    public UserIconLayout bdu;
    protected ConstrainImageGroup bdw;
    private View.OnClickListener bdx;
    private final View.OnClickListener bdz;
    public HeadPendantClickableView caA;
    public RelativeLayout caB;
    protected TbImageView caC;
    private View.OnClickListener caD;
    private GuessYourLikeHeaderView cat;
    private View cau;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.adU = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bdx = new x(this);
        this.caD = new y(this);
        this.bdb = new z(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bdz = new aa(this);
        this.ahZ = new ab(this);
        this.ahD = new ac(this);
        View view = getView();
        this.GO = tbPageContext;
        this.ds16 = (int) this.GO.getResources().getDimension(r.e.ds16);
        this.ds32 = (int) this.GO.getResources().getDimension(r.e.ds32);
        this.aro = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bdr = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.caA = (HeadPendantClickableView) view.findViewById(r.g.card_home_page_normal_thread_user_pendant_header);
        this.bdr.setDefaultResource(17170445);
        this.bdr.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bdr.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bdr.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        if (this.caA.getHeadView() != null) {
            this.caA.getHeadView().setIsRound(true);
            this.caA.getHeadView().setDrawBorder(false);
            this.caA.getHeadView().setDefaultResource(17170445);
            this.caA.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.caA.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.caA.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        }
        this.caA.wo();
        if (this.caA.getPendantView() != null) {
            this.caA.getPendantView().setIsRound(true);
            this.caA.getPendantView().setDrawBorder(false);
        }
        this.bdu = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.bdu.ahY = true;
        this.bdu.setEntelechyEnabled(true);
        this.bdu.setPageName(1);
        this.aOH = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.bds = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.bds.setAfterClickListener(this.bdz);
        this.bds.setPlayTimeTextView(r.e.fontsize28);
        this.bUs = (TbImageView) view.findViewById(r.g.frs_normal_item_theme_card);
        this.bbY = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bbY.setFocusable(true);
        this.bdw = (ConstrainImageGroup) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4);
        this.bdw.setSingleImageRatio(0.75d);
        this.bdw.setImageMargin(dimensionPixelSize);
        this.bdw.setChildClickListener(this.caD);
        this.bca = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.bca.setLocationEnabled(true);
        this.bca.setCommentNumClickListener(this.bdx);
        this.bdt = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bcK = (LinearLayout) view.findViewById(r.g.card_home_page_normal_thread_content_layout);
        this.caB = (RelativeLayout) view.findViewById(r.g.card_home_page_normal_thread_root_content);
        this.caC = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.bUI = (TextView) view.findViewById(r.g.app_code_btn);
        this.bUJ = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
        this.cat = (GuessYourLikeHeaderView) view.findViewById(r.g.guess_your_like_header);
        this.cau = view.findViewById(r.g.guess_your_like_bottom_line);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bdw != null) {
            this.bdw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bdw != null) {
            this.bdw.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(getView(), r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.k(this.caB, r.f.addresslist_item_bg);
            if (this.aeu != null && this.aeu.needTopMargin) {
                com.baidu.tbadk.core.util.at.l(this.aro, r.d.cp_bg_line_c);
            } else {
                com.baidu.tbadk.core.util.at.l(this.aro, r.d.cp_bg_line_b);
            }
            this.bdw.tB();
            this.bdu.tB();
            this.bca.tB();
            if (this.cat != null) {
                this.cat.tB();
            }
            com.baidu.tbadk.core.util.at.l(this.cau, r.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: j */
    public void onBindDataToView(bk bkVar) {
        int i;
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeu = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.caB != null) {
                this.caB.setOnClickListener(this.bdx);
                this.caB.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bdx);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        this.bdu.setVisibility(0);
        if (this.aeu.getAuthor() != null && !StringUtils.isNull(this.aeu.getAuthor().getSealPrefix())) {
            this.bdu.aN(true);
        }
        if (this.aeu.getAuthor() == null || this.aeu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aeu.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rQ = this.aeu.rQ();
            if (rQ != null && rQ.getvipV_url() != null) {
                if (this.bbQ != null) {
                    if (this.bbR == null) {
                        this.bbQ.inflate();
                        this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.bbR.setVisibility(0);
                    this.bbR.c(rQ.getvipV_url(), 10, false);
                    this.bdr.setIsBigV(true);
                }
            } else {
                this.bdr.setIsBigV(false);
                if (this.bbR != null) {
                    this.bbR.setVisibility(8);
                }
            }
            this.caA.setVisibility(8);
            this.bdr.setVisibility(0);
            this.bdr.setData(bkVar);
            this.bdr.setAfterClickListener(this.ahZ);
        } else {
            this.bdr.setVisibility(4);
            this.bdr.setIsBigV(false);
            if (this.bbR != null) {
                this.bbR.setVisibility(8);
            }
            this.caA.setVisibility(0);
            this.caA.setData(bkVar);
        }
        this.bdu.setData(bkVar);
        this.bdu.setUserAfterClickListener(this.ahZ);
        if (this.bca.a(bkVar)) {
            this.bdt.setVisibility(8);
        } else {
            this.bdt.setVisibility(0);
        }
        this.bca.setForumAfterClickListener(this.ahD);
        this.bca.setStType(com.baidu.tieba.card.an.Pf());
        if ((StringUtils.isNull(bkVar.getTitle()) && (bkVar.rO() == null || bkVar.rO().size() == 0)) || bkVar.sd() == 1) {
            this.aOH.setVisibility(8);
        } else {
            this.aOH.setVisibility(0);
            bkVar.TX = 0;
            bkVar.e(false, bkVar.sL());
            SpannableStringBuilder so = bkVar.so();
            this.aOH.setOnTouchListener(new com.baidu.tieba.view.x(so));
            this.aOH.setText(so);
            com.baidu.tieba.card.an.a(this.aOH, bkVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bkVar.rW() != null && !StringUtils.isNull(bkVar.rW())) {
            sb.append(bkVar.rW());
        }
        ArrayList<MediaData> rY = bkVar.rY();
        if (rY != null) {
            i = rY.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rY.get(i2).getVideoUrl() != null && rY.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rY.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bkVar.g(sb.toString(), true))) {
                SpannableString cy = bkVar.cy(sb.toString());
                this.bbY.setOnTouchListener(new com.baidu.tieba.view.x(cy));
                this.bbY.setText(cy);
                this.bbY.setContentDescription(sb.toString());
                this.bbY.setVisibility(0);
                com.baidu.tieba.card.an.a(this.bbY, bkVar.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
            } else {
                this.bbY.setVisibility(8);
            }
        } else {
            this.bbY.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bca.getLayoutParams();
        if (layoutParams != null) {
            if (this.bbY.getVisibility() == 8 && this.aOH.getVisibility() == 8 && this.bds.getVisibility() == 8 && this.bca.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.GO.getResources().getDimension(r.e.ds56), 0, 0);
            } else {
                layoutParams.setMargins(0, this.ds16, 0, this.ds32);
            }
        }
        ArrayList<VoiceData.VoiceModel> sc = bkVar.sc();
        if (com.baidu.tbadk.core.util.x.t(sc)) {
            this.bds.setVisibility(8);
        } else {
            this.bds.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sc.get(0);
            this.bds.setVoiceModel(voiceModel);
            this.bds.setTag(voiceModel);
            this.bds.aEg();
            if (voiceModel != null) {
                this.bds.mm(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rY) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rY, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !ax.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.s(linkedList) > 0) {
                this.bdw.setVisibility(0);
                this.bdw.setFromCDN(this.adU);
                if (this.aeu.sK() != null) {
                    this.bdw.setImageClickListener(new ad(this));
                } else {
                    this.bdw.setImageClickListener(new ae(this, linkedList2, bkVar));
                }
                this.bdw.setImageUrls(linkedList);
            } else {
                this.bdw.setVisibility(8);
            }
        } else {
            this.bdw.setVisibility(8);
        }
        if (this.caC != null) {
            if (bkVar.sa() != null) {
                String tk = bkVar.sa().tk();
                if (!StringUtils.isNull(tk)) {
                    this.caC.setVisibility(0);
                    this.caC.c(tk, 10, true);
                } else {
                    this.caC.setVisibility(8);
                }
            } else {
                this.caC.setVisibility(8);
            }
        }
        if (this.bUI != null) {
            if (bkVar.sb() != null) {
                String mm = bkVar.sb().mm();
                if (!StringUtils.isNull(mm)) {
                    String fixedText = ax.getFixedText(mm, 20, true);
                    com.baidu.tbadk.core.util.at.k(this.bUI, r.f.btn_red_frame_n);
                    com.baidu.tbadk.core.util.at.j((View) this.bUI, r.d.cp_cont_h);
                    this.bUI.setText(fixedText);
                    this.bUI.setVisibility(0);
                } else {
                    this.bUI.setVisibility(8);
                }
            } else {
                this.bUI.setVisibility(8);
            }
        }
        Pg();
        if (this.cat != null) {
            if ((bkVar.sm() || bkVar.sn()) && com.baidu.tieba.tbadkCore.util.s.bng()) {
                this.cat.setTitleText(StringUtils.isNull(bkVar.sl()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : bkVar.sl());
                this.cat.show();
                this.aro.setVisibility(8);
                if (this.cau != null) {
                    this.cau.setVisibility(0);
                }
                if (bkVar.needTopMargin) {
                    this.cat.btl();
                } else {
                    this.cat.btk();
                    if (bkVar.isFirstFloor) {
                        this.aro.setVisibility(0);
                    }
                }
            } else {
                this.cat.hide();
                this.aro.setVisibility(0);
                if (this.cau != null) {
                    this.cau.setVisibility(8);
                }
            }
        }
        k(bkVar);
    }

    public void k(bk bkVar) {
        MetaData author;
        if (bkVar != null && this.bUs != null && (author = bkVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo si = bkVar.si();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdr.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bcK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bUs.setVisibility(8);
                if (this.bUJ != null) {
                    if (si != null) {
                        this.bUJ.a(this.GO, si, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bkVar.getFid()), bkVar.getForum_name(), bkVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                    } else {
                        this.bUJ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bUs.setVisibility(0);
                this.bUs.setImageBitmap(null);
                this.bUs.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bUs.setOnClickListener(new af(this, themeCard));
                this.bUJ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
            }
            this.bdr.setLayoutParams(layoutParams);
            this.bcK.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bk bkVar) {
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
                    imageUrlData.urlType = this.adU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bkVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, bkVar.getForum_name(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.adU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Pg() {
        this.bds.setClickable(true);
        this.bca.setBarNameClickEnabled(true);
        int childCount = this.bdw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bdw.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bca != null && this.bdb != null) {
            this.bca.h(bdUniqueId);
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        if (this.aeu != null) {
            com.baidu.tieba.card.an.hR(this.aeu.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aeu));
            com.baidu.tbadk.core.data.n sK = this.aeu.sK();
            if (sK != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.GO.getPageActivity(), sK.getCartoonId(), sK.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aeu.Vh;
            if (this.aeu.Vg == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Qo;
                long j = kVar.Qp;
                com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                anVar.pageContext = this.GO;
                anVar.bookId = str;
                anVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
            } else if (this.aeu.sb() != null) {
                if (com.baidu.tbadk.core.util.bk.ak(this.GO.getPageActivity())) {
                    String postUrl = this.aeu.sb().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                        com.baidu.tbadk.browser.f.v(this.GO.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.r.gC(this.aeu.getId());
                if (this.aeu.sj() > 0 && com.baidu.tieba.tbadkCore.util.s.bng()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.GO.getPageActivity()).createHistoryCfg(this.aeu.getTid(), String.valueOf(this.aeu.sj()), false, true, com.baidu.tieba.card.an.Pf());
                    createHistoryCfg.setVideo_source("frs");
                    this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.aeu, this.mForumName, com.baidu.tieba.card.an.Pf(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
