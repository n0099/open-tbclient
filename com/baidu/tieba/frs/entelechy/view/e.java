package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<bd> implements u {
    private bd ajM;
    protected boolean ajn;
    private final View.OnClickListener anO;
    public ClickableHeaderImageView anW;
    public ViewStub anY;
    public TbImageView anZ;
    private final View.OnClickListener aob;
    private CardGroupDividerView bZJ;
    public View bZZ;
    public HeadPendantClickableView bZa;
    private View.OnClickListener bZf;
    public LinearLayout bvK;
    public ThreadSkinView bvL;
    protected TextView cJs;
    private com.baidu.tieba.frs.g.g cOH;
    public ThreadCommentAndPraiseInfoLayout cOR;
    public UserIconLayout cOS;
    public RelativeLayout cOT;
    protected TbImageView cOU;
    private View.OnClickListener cOV;
    public PlayVoiceBntNew caI;
    protected TextView caK;
    protected ConstrainImageGroup caL;
    private final View.OnClickListener caO;
    public TbImageView ccC;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajn = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajM != null && e.this.ajM.rx() != null && e.this.ajM.rx().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", e.this.ajM.getId()));
                }
                if (e.this.ajM != null && e.this.ajM.rc()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ac("post_id", e.this.ajM.getTid()));
                }
                if (e.this.abs() != null) {
                    e.this.abs().a(view, e.this.ajM);
                }
                e.this.abK();
            }
        };
        this.cOV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abs() != null) {
                    e.this.abs().a(view, e.this.ajM);
                }
                e.this.abK();
            }
        };
        this.caO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> abs = e.this.abs();
                if (abs != null) {
                    abs.a(view, e.this.ajM);
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abs() != null) {
                    e.this.abs().a(view, e.this.ajM);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abs() != null) {
                    e.this.abs().a(view, e.this.ajM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.anW = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.anW.setDefaultResource(17170445);
        this.anW.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.anW.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.anW.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.anY = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.cOS = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.cOS.aoX = true;
        this.cOS.setEntelechyEnabled(true);
        this.cOS.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caI = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caI.setAfterClickListener(this.caO);
        this.caI.setPlayTimeTextView(d.e.fontsize28);
        this.ccC = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccC.setPageId(getTag());
        this.caK = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caK.setFocusable(true);
        this.caL = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.caL.setSingleImageRatio(0.75d);
        this.caL.setImageMargin(dimensionPixelSize);
        this.caL.setChildClickListener(this.cOV);
        this.cOR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cOR.setFrom(2);
        this.cOR.anM = 3;
        this.bZZ = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bvK = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cOT = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cOU = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.cOU.setPageId(getTag());
        this.cJs = (TextView) view.findViewById(d.g.app_code_btn);
        this.bvL = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bZJ = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.bZJ.setTitleClickListener(this.bZf);
        this.cOH = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cOT);
        this.cOH.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caL != null) {
            this.caL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caL != null) {
            this.caL.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0082d.cp_bg_line_d);
            aj.j(this.cOT, d.f.addresslist_item_bg);
            this.caL.onChangeSkinType();
            this.cOS.onChangeSkinType();
            this.cOR.onChangeSkinType();
            if (this.bZJ != null) {
                this.bZJ.onChangeSkinType();
            }
            this.cOH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: y */
    public void a(final bd bdVar) {
        int i;
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cOT != null) {
                this.cOT.setOnClickListener(this.bZf);
                this.cOT.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bZf);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jR(this.ajM.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caK, this.ajM.getId(), d.C0082d.cp_cont_c, d.C0082d.cp_cont_d);
        }
        this.cOS.setVisibility(0);
        if (this.ajM.rx() != null && !StringUtils.isNull(this.ajM.rx().getSealPrefix())) {
            this.cOS.aL(true);
        }
        if (this.ajM.rx() == null || this.ajM.rx().getPendantData() == null || StringUtils.isNull(this.ajM.rx().getPendantData().pT())) {
            UserTbVipInfoData ry = this.ajM.ry();
            if (ry != null && ry.getvipV_url() != null) {
                if (this.anY != null) {
                    if (this.anZ == null) {
                        this.anY.inflate();
                        this.anZ = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.anZ.setVisibility(0);
                    this.anZ.startLoad(ry.getvipV_url(), 10, false);
                    this.anW.setIsBigV(true);
                }
            } else {
                this.anW.setIsBigV(false);
                if (this.anZ != null) {
                    this.anZ.setVisibility(8);
                }
            }
            this.bZa.setVisibility(8);
            this.anW.setVisibility(0);
            this.anW.setData(bdVar);
            this.anW.setAfterClickListener(this.aob);
        } else {
            this.anW.setVisibility(4);
            this.anW.setIsBigV(false);
            if (this.anZ != null) {
                this.anZ.setVisibility(8);
            }
            this.bZa.setVisibility(0);
            this.bZa.setData(bdVar);
        }
        this.cOS.setData(bdVar);
        this.cOS.setUserAfterClickListener(this.aob);
        if (this.cOR.setData(bdVar)) {
            this.bZZ.setVisibility(8);
        } else {
            this.bZZ.setVisibility(0);
        }
        this.cOR.updataMoreView(this.mTbPageContext);
        this.cOR.setForumAfterClickListener(this.anO);
        this.cOR.setStType("frs_page");
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rv() == null || bdVar.rv().size() == 0)) || bdVar.rN() == 1) {
            bdVar.e(false, true);
            if (bdVar.rX() == null || StringUtils.isNull(bdVar.rX().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bdVar.rX());
            }
        } else {
            this.mTitle.setVisibility(0);
            bdVar.YV = 0;
            bdVar.e(false, bdVar.sv());
            SpannableStringBuilder rX = bdVar.rX();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rX));
            this.mTitle.setText(rX);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
            sb.append(bdVar.getAbstract());
        }
        ArrayList<MediaData> rI = bdVar.rI();
        if (rI != null) {
            i = rI.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rI.get(i2).getVideoUrl() != null && rI.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rI.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                SpannableString cJ = bdVar.cJ(sb.toString());
                this.caK.setOnTouchListener(new com.baidu.tieba.view.l(cJ));
                this.caK.setText(cJ);
                this.caK.setContentDescription(sb.toString());
                this.caK.setVisibility(0);
                com.baidu.tieba.card.k.a(this.caK, bdVar.getId(), d.C0082d.cp_cont_c, d.C0082d.cp_cont_d);
            } else {
                this.caK.setVisibility(8);
            }
        } else {
            this.caK.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOR.getLayoutParams();
        if (layoutParams != null) {
            if (this.caK.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.caI.getVisibility() == 8 && this.cOR.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.cOR.setPadding(0, 0, 0, 0);
            } else if (this.cOR.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.cOR.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.cOR.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cOH.S(this.ajM);
        ArrayList<VoiceData.VoiceModel> rM = bdVar.rM();
        if (com.baidu.tbadk.core.util.v.w(rM)) {
            this.caI.setVisibility(8);
        } else {
            this.caI.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.caI.setVoiceModel(voiceModel);
            this.caI.setTag(voiceModel);
            this.caI.blz();
            if (voiceModel != null) {
                this.caI.nM(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.pa().pg() && com.baidu.tbadk.core.util.v.v(rI) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rI, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                this.caL.setVisibility(0);
                this.caL.setFromCDN(this.ajn);
                if (this.ajM.su() != null) {
                    this.caL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                m su = e.this.ajM.su();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                                return;
                            }
                            ax.aU(e.this.mContext);
                        }
                    });
                } else {
                    this.caL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            v<bd> abs = e.this.abs();
                            if (z) {
                                if (abs != null) {
                                    abs.aXB = true;
                                    abs.a(view, e.this.ajM);
                                }
                                e.this.abK();
                                return;
                            }
                            if (abs != null) {
                                abs.aXB = false;
                                abs.a(view, e.this.ajM);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.caL.setImageMediaList(linkedList);
            } else {
                this.caL.setVisibility(8);
            }
        } else {
            this.caL.setVisibility(8);
        }
        if (this.cOU != null) {
            if (bdVar.rK() != null) {
                String te = bdVar.rK().te();
                if (!StringUtils.isNull(te)) {
                    this.cOU.setVisibility(0);
                    this.cOU.startLoad(te, 10, true);
                } else {
                    this.cOU.setVisibility(8);
                }
            } else {
                this.cOU.setVisibility(8);
            }
        }
        if (this.cJs != null) {
            if (bdVar.rL() != null) {
                String pC = bdVar.rL().pC();
                if (!StringUtils.isNull(pC)) {
                    String fixedText = am.getFixedText(pC, 20, true);
                    aj.j(this.cJs, d.f.btn_red_frame_n);
                    aj.i(this.cJs, d.C0082d.cp_cont_h);
                    this.cJs.setText(fixedText);
                    this.cJs.setVisibility(0);
                } else {
                    this.cJs.setVisibility(8);
                }
            } else {
                this.cJs.setVisibility(8);
            }
        }
        abJ();
        b.a(this.ajM, this.bZJ);
        B(bdVar);
    }

    public void B(bd bdVar) {
        MetaData rx;
        if (bdVar != null && this.ccC != null && (rx = bdVar.rx()) != null) {
            final ThemeCardInUserData themeCard = rx.getThemeCard();
            SkinInfo rT = bdVar.rT();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anW.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bvK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccC.setVisibility(8);
                if (this.bvL != null) {
                    if (rT != null) {
                        this.bvL.a(this.mPageContext, rT, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.rD(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.bvL.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.ccC.setVisibility(0);
                this.ccC.setImageBitmap(null);
                this.ccC.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.ccC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bvL.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.anW.setLayoutParams(layoutParams);
            this.bvK.setLayoutParams(layoutParams2);
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
                    imageUrlData.urlType = this.ajn ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rD(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void abJ() {
        this.caI.setClickable(true);
        this.cOR.setBarNameClickEnabled(true);
        int childCount = this.caL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caL.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cOR != null) {
            this.cOR.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jQ(this.ajM.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caK, this.ajM.getId(), d.C0082d.cp_cont_c, d.C0082d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajM));
            m su = this.ajM.su();
            if (su != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aU(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.ajM.aad;
            if (this.ajM.aac == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VS;
                long j = jVar.VT;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wg = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
            } else if (this.ajM.rL() != null) {
                if (ax.aV(this.mPageContext.getPageActivity())) {
                    String postUrl = this.ajM.rL().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.browser.a.Q(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.gY(this.ajM.getId());
                boolean z = this.ajM.getType() != bd.YG;
                if (this.ajM.rU() > 0 && com.baidu.tieba.tbadkCore.util.f.bxo()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajM.getTid(), String.valueOf(this.ajM.rU()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajM.sB());
                    createFromThreadCfg.setSmartFrsPosition(this.ajM.sI());
                    createFromThreadCfg.setForumId(String.valueOf(this.ajM.getFid()));
                    createFromThreadCfg.setStartFrom(3);
                    this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
