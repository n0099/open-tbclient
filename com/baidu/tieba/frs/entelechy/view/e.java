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
    private bd ajJ;
    protected boolean ajh;
    private final View.OnClickListener anQ;
    public ClickableHeaderImageView anY;
    public ViewStub aoa;
    public TbImageView aob;
    private final View.OnClickListener aod;
    private CardGroupDividerView bZN;
    public HeadPendantClickableView bZe;
    private View.OnClickListener bZj;
    public LinearLayout bvL;
    public ThreadSkinView bvM;
    protected TextView cJC;
    private com.baidu.tieba.frs.g.g cOS;
    public ThreadCommentAndPraiseInfoLayout cPc;
    public UserIconLayout cPd;
    public RelativeLayout cPe;
    protected TbImageView cPf;
    private View.OnClickListener cPg;
    public PlayVoiceBntNew caM;
    protected TextView caO;
    protected ConstrainImageGroup caP;
    private final View.OnClickListener caS;
    public View cad;
    public TbImageView ccH;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajh = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajJ != null && e.this.ajJ.rv() != null && e.this.ajJ.rv().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", e.this.ajJ.getId()));
                }
                if (e.this.ajJ != null && e.this.ajJ.ra()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ac("post_id", e.this.ajJ.getTid()));
                }
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajJ);
                }
                e.this.abN();
            }
        };
        this.cPg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajJ);
                }
                e.this.abN();
            }
        };
        this.caS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> abt = e.this.abt();
                if (abt != null) {
                    abt.a(view, e.this.ajJ);
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajJ);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.anY = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.anY.setDefaultResource(17170445);
        this.anY.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.anY.setDefaultBgResource(d.C0096d.cp_bg_line_e);
        this.anY.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.aoa = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.cPd = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.cPd.apa = true;
        this.cPd.setEntelechyEnabled(true);
        this.cPd.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caM = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caM.setAfterClickListener(this.caS);
        this.caM.setPlayTimeTextView(d.e.fontsize28);
        this.ccH = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccH.setPageId(getTag());
        this.caO = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caO.setFocusable(true);
        this.caP = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.caP.setSingleImageRatio(0.75d);
        this.caP.setImageMargin(dimensionPixelSize);
        this.caP.setChildClickListener(this.cPg);
        this.cPc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cPc.setFrom(2);
        this.cPc.anO = 3;
        this.cad = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bvL = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cPe = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cPf = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.cPf.setPageId(getTag());
        this.cJC = (TextView) view.findViewById(d.g.app_code_btn);
        this.bvM = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bZN = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.bZN.setTitleClickListener(this.bZj);
        this.cOS = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPe);
        this.cOS.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caP != null) {
            this.caP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caP != null) {
            this.caP.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout abY() {
        return this.cPc;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0096d.cp_bg_line_d);
            aj.j(this.cPe, d.f.addresslist_item_bg);
            this.caP.onChangeSkinType();
            this.cPd.onChangeSkinType();
            this.cPc.onChangeSkinType();
            if (this.bZN != null) {
                this.bZN.onChangeSkinType();
            }
            this.cOS.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(final bd bdVar) {
        int i;
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajJ = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cPe != null) {
                this.cPe.setOnClickListener(this.bZj);
                this.cPe.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bZj);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jP(this.ajJ.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.ajJ.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caO, this.ajJ.getId(), d.C0096d.cp_cont_c, d.C0096d.cp_cont_d);
        }
        this.cPd.setVisibility(0);
        if (this.ajJ.rv() != null && !StringUtils.isNull(this.ajJ.rv().getSealPrefix())) {
            this.cPd.aM(true);
        }
        if (this.ajJ.rv() == null || this.ajJ.rv().getPendantData() == null || StringUtils.isNull(this.ajJ.rv().getPendantData().pR())) {
            UserTbVipInfoData rw = this.ajJ.rw();
            if (rw != null && rw.getvipV_url() != null) {
                if (this.aoa != null) {
                    if (this.aob == null) {
                        this.aoa.inflate();
                        this.aob = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.aob.setVisibility(0);
                    this.aob.startLoad(rw.getvipV_url(), 10, false);
                    this.anY.setIsBigV(true);
                }
            } else {
                this.anY.setIsBigV(false);
                if (this.aob != null) {
                    this.aob.setVisibility(8);
                }
            }
            this.bZe.setVisibility(8);
            this.anY.setVisibility(0);
            this.anY.setData(bdVar);
            this.anY.setAfterClickListener(this.aod);
        } else {
            this.anY.setVisibility(4);
            this.anY.setIsBigV(false);
            if (this.aob != null) {
                this.aob.setVisibility(8);
            }
            this.bZe.setVisibility(0);
            this.bZe.setData(bdVar);
        }
        this.cPd.setData(bdVar);
        this.cPd.setUserAfterClickListener(this.aod);
        if (this.cPc.setData(bdVar)) {
            this.cad.setVisibility(8);
        } else {
            this.cad.setVisibility(0);
        }
        this.cPc.updataMoreView(this.mTbPageContext);
        this.cPc.setForumAfterClickListener(this.anQ);
        this.cPc.setStType("frs_page");
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rt() == null || bdVar.rt().size() == 0)) || bdVar.rL() == 1) {
            bdVar.e(false, true);
            if (bdVar.rV() == null || StringUtils.isNull(bdVar.rV().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bdVar.rV());
            }
        } else {
            this.mTitle.setVisibility(0);
            bdVar.YP = 0;
            bdVar.e(false, bdVar.st());
            SpannableStringBuilder rV = bdVar.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            this.mTitle.setText(rV);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
            sb.append(bdVar.getAbstract());
        }
        ArrayList<MediaData> rG = bdVar.rG();
        if (rG != null) {
            i = rG.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rG.get(i2).getVideoUrl() != null && rG.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rG.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                SpannableString cJ = bdVar.cJ(sb.toString());
                this.caO.setOnTouchListener(new com.baidu.tieba.view.l(cJ));
                this.caO.setText(cJ);
                this.caO.setContentDescription(sb.toString());
                this.caO.setVisibility(0);
                com.baidu.tieba.card.k.a(this.caO, bdVar.getId(), d.C0096d.cp_cont_c, d.C0096d.cp_cont_d);
            } else {
                this.caO.setVisibility(8);
            }
        } else {
            this.caO.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPc.getLayoutParams();
        if (layoutParams != null) {
            if (this.caO.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.caM.getVisibility() == 8 && this.cPc.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.cPc.setPadding(0, 0, 0, 0);
            } else if (this.cPc.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.cPc.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.cPc.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cOS.U(this.ajJ);
        ArrayList<VoiceData.VoiceModel> rK = bdVar.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caM.setVisibility(8);
        } else {
            this.caM.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.caM.setVoiceModel(voiceModel);
            this.caM.setTag(voiceModel);
            this.caM.bmf();
            if (voiceModel != null) {
                this.caM.nT(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oY().pe() && com.baidu.tbadk.core.util.v.v(rG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rG, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                this.caP.setVisibility(0);
                this.caP.setFromCDN(this.ajh);
                if (this.ajJ.ss() != null) {
                    this.caP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                m ss = e.this.ajJ.ss();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                                return;
                            }
                            ax.aR(e.this.mContext);
                        }
                    });
                } else {
                    this.caP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            v<bd> abt = e.this.abt();
                            if (z) {
                                if (abt != null) {
                                    abt.aXD = true;
                                    abt.a(view, e.this.ajJ);
                                }
                                e.this.abN();
                                return;
                            }
                            if (abt != null) {
                                abt.aXD = false;
                                abt.a(view, e.this.ajJ);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.caP.setImageMediaList(linkedList);
            } else {
                this.caP.setVisibility(8);
            }
        } else {
            this.caP.setVisibility(8);
        }
        if (this.cPf != null) {
            if (bdVar.rI() != null) {
                String tb = bdVar.rI().tb();
                if (!StringUtils.isNull(tb)) {
                    this.cPf.setVisibility(0);
                    this.cPf.startLoad(tb, 10, true);
                } else {
                    this.cPf.setVisibility(8);
                }
            } else {
                this.cPf.setVisibility(8);
            }
        }
        if (this.cJC != null) {
            if (bdVar.rJ() != null) {
                String pA = bdVar.rJ().pA();
                if (!StringUtils.isNull(pA)) {
                    String fixedText = am.getFixedText(pA, 20, true);
                    aj.j(this.cJC, d.f.btn_red_frame_n);
                    aj.i(this.cJC, d.C0096d.cp_cont_h);
                    this.cJC.setText(fixedText);
                    this.cJC.setVisibility(0);
                } else {
                    this.cJC.setVisibility(8);
                }
            } else {
                this.cJC.setVisibility(8);
            }
        }
        abM();
        b.a(this.ajJ, this.bZN);
        D(bdVar);
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccH != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            SkinInfo rR = bdVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anY.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bvL.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccH.setVisibility(8);
                if (this.bvM != null) {
                    if (rR != null) {
                        this.bvM.a(this.mPageContext, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.rB(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.bvM.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.ccH.setVisibility(0);
                this.ccH.setImageBitmap(null);
                this.ccH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bvM.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.anY.setLayoutParams(layoutParams);
            this.bvL.setLayoutParams(layoutParams2);
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
                    imageUrlData.urlType = this.ajh ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajh, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void abM() {
        this.caM.setClickable(true);
        this.cPc.setBarNameClickEnabled(true);
        int childCount = this.caP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caP.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajh = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cPc != null) {
            this.cPc.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abN() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajJ != null) {
            com.baidu.tieba.card.k.jO(this.ajJ.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.ajJ.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caO, this.ajJ.getId(), d.C0096d.cp_cont_c, d.C0096d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajJ));
            m ss = this.ajJ.ss();
            if (ss != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aR(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.ajJ.ZX;
            if (this.ajJ.ZW == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VM;
                long j = jVar.VN;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wa = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
            } else if (this.ajJ.rJ() != null) {
                if (ax.aS(this.mPageContext.getPageActivity())) {
                    String postUrl = this.ajJ.rJ().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.browser.a.P(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.gW(this.ajJ.getId());
                boolean z = this.ajJ.getType() != bd.YA;
                if (this.ajJ.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxV()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajJ.getTid(), String.valueOf(this.ajJ.rS()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajJ, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajJ.sz());
                    createFromThreadCfg.setSmartFrsPosition(this.ajJ.sG());
                    createFromThreadCfg.setForumId(String.valueOf(this.ajJ.getFid()));
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
