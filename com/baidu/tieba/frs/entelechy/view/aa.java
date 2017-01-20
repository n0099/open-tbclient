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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.card.a<bh> implements cd {
    private TbPageContext<?> FY;
    private TextView aNb;
    public ViewStub aUU;
    public TbImageView aUV;
    public LinearLayout aUY;
    public ThreadSkinView aUZ;
    private bh acX;
    protected boolean acy;
    private final View.OnClickListener agO;
    private final View.OnClickListener agt;
    public TbImageView bHZ;
    protected TextView bIp;
    protected TbImageView bMA;
    private View.OnClickListener bMB;
    public HeadPendantClickableView bMy;
    public RelativeLayout bMz;
    protected TextView bkS;
    public ThreadCommentAndPraiseInfoLayout bkU;
    private CustomMessageListener blR;
    private CardGroupDividerView blz;
    public View bmA;
    public UserIconLayout bmB;
    protected ConstrainImageGroup bmD;
    private View.OnClickListener bmE;
    private final View.OnClickListener bmG;
    public ClickableHeaderImageView bmy;
    public PlayVoiceBntNew bmz;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;

    public aa(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.acy = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bmE = new ab(this);
        this.bMB = new ac(this);
        this.blR = new ad(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bmG = new ae(this);
        this.agO = new af(this);
        this.agt = new ag(this);
        View view = getView();
        this.FY = tbPageContext;
        this.ds16 = (int) this.FY.getResources().getDimension(r.f.ds16);
        this.ds32 = (int) this.FY.getResources().getDimension(r.f.ds32);
        this.bmy = (ClickableHeaderImageView) view.findViewById(r.h.card_home_page_normal_thread_user_header);
        this.bMy = (HeadPendantClickableView) view.findViewById(r.h.card_home_page_normal_thread_user_pendant_header);
        this.bmy.setDefaultResource(17170445);
        this.bmy.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bmy.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bmy.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        if (this.bMy.getHeadView() != null) {
            this.bMy.getHeadView().setIsRound(true);
            this.bMy.getHeadView().setDrawBorder(false);
            this.bMy.getHeadView().setDefaultResource(17170445);
            this.bMy.getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
            this.bMy.getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
            this.bMy.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        }
        this.bMy.vS();
        if (this.bMy.getPendantView() != null) {
            this.bMy.getPendantView().setIsRound(true);
            this.bMy.getPendantView().setDrawBorder(false);
        }
        this.bmB = (UserIconLayout) view.findViewById(r.h.card_home_page_normal_thread_user_layout);
        this.bmB.agN = true;
        this.bmB.setEntelechyEnabled(true);
        this.bmB.setPageName(1);
        this.aNb = (TextView) view.findViewById(r.h.card_home_page_normal_thread_title);
        this.bmz = (PlayVoiceBntNew) view.findViewById(r.h.card_home_page_normal_thread_abstract_voice);
        this.bmz.setAfterClickListener(this.bmG);
        this.bmz.setPlayTimeTextView(r.f.fontsize28);
        this.bHZ = (TbImageView) view.findViewById(r.h.frs_normal_item_theme_card);
        this.bkS = (TextView) view.findViewById(r.h.card_home_page_normal_thread_abstract);
        this.bkS.setFocusable(true);
        this.bmD = (ConstrainImageGroup) view.findViewById(r.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds4);
        this.bmD.setSingleImageRatio(0.75d);
        this.bmD.setImageMargin(dimensionPixelSize);
        this.bmD.setChildClickListener(this.bMB);
        this.bkU = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.card_home_page_normal_thread_info_layout);
        this.bkU.setLocationEnabled(true);
        this.bkU.setViewNumEnabled(true);
        this.bkU.setCommentNumClickListener(this.bmE);
        this.bmA = view.findViewById(r.h.divider_below_reply_number_layout);
        this.aUY = (LinearLayout) view.findViewById(r.h.card_home_page_normal_thread_content_layout);
        this.bMz = (RelativeLayout) view.findViewById(r.h.card_home_page_normal_thread_root_content);
        this.bMA = (TbImageView) view.findViewById(r.h.game_activity_banner);
        this.bIp = (TextView) view.findViewById(r.h.app_code_btn);
        this.aUZ = (ThreadSkinView) view.findViewById(r.h.frs_thread_skin);
        this.blz = (CardGroupDividerView) view.findViewById(r.h.header_divider);
        this.blz.setTitleClickListener(this.bmE);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bmD != null) {
            this.bmD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bmD != null) {
            this.bmD.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.k(getView(), r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.j(this.bMz, r.g.addresslist_item_bg);
            this.bmD.tg();
            this.bmB.tg();
            this.bkU.tg();
            if (this.blz != null) {
                this.blz.tg();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bh bhVar) {
        int i;
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.acX = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bMz != null) {
                this.bMz.setOnClickListener(this.bmE);
                this.bMz.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bmE);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        this.bmB.setVisibility(0);
        if (this.acX.getAuthor() != null && !StringUtils.isNull(this.acX.getAuthor().getSealPrefix())) {
            this.bmB.aO(true);
        }
        if (this.acX.getAuthor() == null || this.acX.getAuthor().getPendantData() == null || StringUtils.isNull(this.acX.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rx = this.acX.rx();
            if (rx != null && rx.getvipV_url() != null) {
                if (this.aUU != null) {
                    if (this.aUV == null) {
                        this.aUU.inflate();
                        this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                    }
                    this.aUV.setVisibility(0);
                    this.aUV.c(rx.getvipV_url(), 10, false);
                    this.bmy.setIsBigV(true);
                }
            } else {
                this.bmy.setIsBigV(false);
                if (this.aUV != null) {
                    this.aUV.setVisibility(8);
                }
            }
            this.bMy.setVisibility(8);
            this.bmy.setVisibility(0);
            this.bmy.setData(bhVar);
            this.bmy.setAfterClickListener(this.agO);
        } else {
            this.bmy.setVisibility(4);
            this.bmy.setIsBigV(false);
            if (this.aUV != null) {
                this.aUV.setVisibility(8);
            }
            this.bMy.setVisibility(0);
            this.bMy.setData(bhVar);
        }
        this.bmB.setData(bhVar);
        this.bmB.setUserAfterClickListener(this.agO);
        if (this.bkU.a(bhVar)) {
            this.bmA.setVisibility(8);
        } else {
            this.bmA.setVisibility(0);
        }
        this.bkU.e(this.mTbPageContext);
        this.bkU.setForumAfterClickListener(this.agt);
        this.bkU.setStType(com.baidu.tieba.card.at.Mt());
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rv() == null || bhVar.rv().size() == 0)) || bhVar.rL() == 1) {
            this.aNb.setVisibility(8);
        } else {
            this.aNb.setVisibility(0);
            bhVar.SJ = 0;
            bhVar.e(false, bhVar.ss());
            SpannableStringBuilder rV = bhVar.rV();
            this.aNb.setOnTouchListener(new com.baidu.tieba.view.x(rV));
            this.aNb.setText(rV);
            com.baidu.tieba.card.at.a(this.aNb, bhVar.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bhVar.rE() != null && !StringUtils.isNull(bhVar.rE())) {
            sb.append(bhVar.rE());
        }
        ArrayList<MediaData> rG = bhVar.rG();
        if (rG != null) {
            i = rG.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rG.get(i2).getVideoUrl() != null && rG.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rG.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                SpannableString cx = bhVar.cx(sb.toString());
                this.bkS.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.bkS.setText(cx);
                this.bkS.setContentDescription(sb.toString());
                this.bkS.setVisibility(0);
                com.baidu.tieba.card.at.a(this.bkS, bhVar.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
            } else {
                this.bkS.setVisibility(8);
            }
        } else {
            this.bkS.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkU.getLayoutParams();
        if (layoutParams != null) {
            if (this.bkS.getVisibility() == 8 && this.aNb.getVisibility() == 8 && this.bmz.getVisibility() == 8 && this.bkU.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.FY.getResources().getDimension(r.f.ds56), 0, 0);
                this.bkU.setPadding(0, 0, 0, 0);
            } else if (this.bkU.ww()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bkU.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bkU.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        ArrayList<VoiceData.VoiceModel> rK = bhVar.rK();
        if (com.baidu.tbadk.core.util.w.s(rK)) {
            this.bmz.setVisibility(8);
        } else {
            this.bmz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.bmz.setVoiceModel(voiceModel);
            this.bmz.setTag(voiceModel);
            this.bmz.ayK();
            if (voiceModel != null) {
                this.bmz.mj(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.oC().oI() && com.baidu.tbadk.core.util.w.r(rG) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.c(rG, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.at.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.w.r(linkedList) > 0) {
                this.bmD.setVisibility(0);
                this.bmD.setFromCDN(this.acy);
                if (this.acX.sr() != null) {
                    this.bmD.setImageClickListener(new ah(this));
                } else {
                    this.bmD.setImageClickListener(new ai(this, linkedList2, bhVar));
                }
                this.bmD.setImageUrls(linkedList);
            } else {
                this.bmD.setVisibility(8);
            }
        } else {
            this.bmD.setVisibility(8);
        }
        if (this.bMA != null) {
            if (bhVar.rI() != null) {
                String sP = bhVar.rI().sP();
                if (!StringUtils.isNull(sP)) {
                    this.bMA.setVisibility(0);
                    this.bMA.c(sP, 10, true);
                } else {
                    this.bMA.setVisibility(8);
                }
            } else {
                this.bMA.setVisibility(8);
            }
        }
        if (this.bIp != null) {
            if (bhVar.rJ() != null) {
                String me = bhVar.rJ().me();
                if (!StringUtils.isNull(me)) {
                    String fixedText = com.baidu.tbadk.core.util.at.getFixedText(me, 20, true);
                    com.baidu.tbadk.core.util.ap.j((View) this.bIp, r.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.ap.i((View) this.bIp, r.e.cp_cont_h);
                    this.bIp.setText(fixedText);
                    this.bIp.setVisibility(0);
                } else {
                    this.bIp.setVisibility(8);
                }
            } else {
                this.bIp.setVisibility(8);
            }
        }
        Rs();
        p.a(this.acX, this.blz);
        s(bhVar);
    }

    public void s(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.bHZ != null && (author = bhVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rR = bhVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bmy.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aUY.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bHZ.setVisibility(8);
                if (this.aUZ != null) {
                    if (rR != null) {
                        this.aUZ.a(this.FY, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rB(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds16);
                    } else {
                        this.aUZ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds30);
                    }
                }
            } else {
                this.bHZ.setVisibility(0);
                this.bHZ.setImageBitmap(null);
                this.bHZ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bHZ.setOnClickListener(new aj(this, themeCard));
                this.aUZ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds30);
            }
            this.bmy.setLayoutParams(layoutParams);
            this.aUY.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.FY.getPageActivity(), r.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.acy ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.FY.getPageActivity()).createConfig(arrayList, i, bhVar.rB(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.acy, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Rs() {
        this.bmz.setClickable(true);
        this.bkU.setBarNameClickEnabled(true);
        int childCount = this.bmD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bmD.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.acy = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkU != null && this.blR != null) {
            this.bkU.h(bdUniqueId);
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rt() {
        if (this.acX != null) {
            com.baidu.tieba.card.at.ie(this.acX.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.acX));
            com.baidu.tbadk.core.data.o sr = this.acX.sr();
            if (sr != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.FY.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.acX.TR;
            if (this.acX.TQ == 1 && lVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.Pu;
                long j = lVar.Pv;
                com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                anVar.pageContext = this.FY;
                anVar.bookId = str;
                anVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
            } else if (this.acX.rJ() != null) {
                if (bf.ak(this.FY.getPageActivity())) {
                    String postUrl = this.acX.rJ().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gB()) {
                        com.baidu.tbadk.browser.f.v(this.FY.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.r.gu(this.acX.getId());
                if (this.acX.rS() > 0 && com.baidu.tieba.tbadkCore.util.s.biL()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.FY.getPageActivity()).createHistoryCfg(this.acX.getTid(), String.valueOf(this.acX.rS()), false, true, com.baidu.tieba.card.at.Mt());
                    createHistoryCfg.setVideo_source("frs");
                    createHistoryCfg.setFromSmartFrs(this.acX.sy());
                    this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.FY.getPageActivity()).createFromThreadCfg(this.acX, this.mForumName, com.baidu.tieba.card.at.Mt(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                createFromThreadCfg.setFromSmartFrs(this.acX.sy());
                this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
