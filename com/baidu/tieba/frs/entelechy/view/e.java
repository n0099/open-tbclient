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
    protected boolean ajk;
    private final View.OnClickListener anT;
    public ClickableHeaderImageView aob;
    public ViewStub aod;
    public TbImageView aoe;
    private final View.OnClickListener aog;
    private CardGroupDividerView bZR;
    public HeadPendantClickableView bZi;
    private View.OnClickListener bZn;
    public LinearLayout bvP;
    public ThreadSkinView bvQ;
    protected TextView cJG;
    private com.baidu.tieba.frs.g.g cOW;
    public ThreadCommentAndPraiseInfoLayout cPg;
    public UserIconLayout cPh;
    public RelativeLayout cPi;
    protected TbImageView cPj;
    private View.OnClickListener cPk;
    public PlayVoiceBntNew caQ;
    protected TextView caS;
    protected ConstrainImageGroup caT;
    private final View.OnClickListener caW;
    public View cah;
    public TbImageView ccL;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajk = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajM != null && e.this.ajM.rv() != null && e.this.ajM.rv().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", e.this.ajM.getId()));
                }
                if (e.this.ajM != null && e.this.ajM.ra()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ac("post_id", e.this.ajM.getTid()));
                }
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajM);
                }
                e.this.abM();
            }
        };
        this.cPk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajM);
                }
                e.this.abM();
            }
        };
        this.caW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> abt = e.this.abt();
                if (abt != null) {
                    abt.a(view, e.this.ajM);
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajM);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.abt() != null) {
                    e.this.abt().a(view, e.this.ajM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.aob = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.aob.setDefaultResource(17170445);
        this.aob.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.aob.setDefaultBgResource(d.C0095d.cp_bg_line_e);
        this.aob.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.aod = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.cPh = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.cPh.apd = true;
        this.cPh.setEntelechyEnabled(true);
        this.cPh.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caQ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caQ.setAfterClickListener(this.caW);
        this.caQ.setPlayTimeTextView(d.e.fontsize28);
        this.ccL = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccL.setPageId(getTag());
        this.caS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caS.setFocusable(true);
        this.caT = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.caT.setSingleImageRatio(0.75d);
        this.caT.setImageMargin(dimensionPixelSize);
        this.caT.setChildClickListener(this.cPk);
        this.cPg = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cPg.setFrom(2);
        this.cPg.anR = 3;
        this.cah = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bvP = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cPi = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cPj = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.cPj.setPageId(getTag());
        this.cJG = (TextView) view.findViewById(d.g.app_code_btn);
        this.bvQ = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bZR = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.bZR.setTitleClickListener(this.bZn);
        this.cOW = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPi);
        this.cOW.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caT != null) {
            this.caT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caT != null) {
            this.caT.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.cPg;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0095d.cp_bg_line_d);
            aj.j(this.cPi, d.f.addresslist_item_bg);
            this.caT.onChangeSkinType();
            this.cPh.onChangeSkinType();
            this.cPg.onChangeSkinType();
            if (this.bZR != null) {
                this.bZR.onChangeSkinType();
            }
            this.cOW.onChangeSkinType();
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
        this.ajM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cPi != null) {
                this.cPi.setOnClickListener(this.bZn);
                this.cPi.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bZn);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jP(this.ajM.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caS, this.ajM.getId(), d.C0095d.cp_cont_c, d.C0095d.cp_cont_d);
        }
        this.cPh.setVisibility(0);
        if (this.ajM.rv() != null && !StringUtils.isNull(this.ajM.rv().getSealPrefix())) {
            this.cPh.aM(true);
        }
        if (this.ajM.rv() == null || this.ajM.rv().getPendantData() == null || StringUtils.isNull(this.ajM.rv().getPendantData().pR())) {
            UserTbVipInfoData rw = this.ajM.rw();
            if (rw != null && rw.getvipV_url() != null) {
                if (this.aod != null) {
                    if (this.aoe == null) {
                        this.aod.inflate();
                        this.aoe = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.aoe.setVisibility(0);
                    this.aoe.startLoad(rw.getvipV_url(), 10, false);
                    this.aob.setIsBigV(true);
                }
            } else {
                this.aob.setIsBigV(false);
                if (this.aoe != null) {
                    this.aoe.setVisibility(8);
                }
            }
            this.bZi.setVisibility(8);
            this.aob.setVisibility(0);
            this.aob.setData(bdVar);
            this.aob.setAfterClickListener(this.aog);
        } else {
            this.aob.setVisibility(4);
            this.aob.setIsBigV(false);
            if (this.aoe != null) {
                this.aoe.setVisibility(8);
            }
            this.bZi.setVisibility(0);
            this.bZi.setData(bdVar);
        }
        this.cPh.setData(bdVar);
        this.cPh.setUserAfterClickListener(this.aog);
        if (this.cPg.setData(bdVar)) {
            this.cah.setVisibility(8);
        } else {
            this.cah.setVisibility(0);
        }
        this.cPg.updataMoreView(this.mTbPageContext);
        this.cPg.setForumAfterClickListener(this.anT);
        this.cPg.setStType("frs_page");
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
            bdVar.YS = 0;
            bdVar.e(false, bdVar.st());
            SpannableStringBuilder rV = bdVar.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            this.mTitle.setText(rV);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
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
                this.caS.setOnTouchListener(new com.baidu.tieba.view.l(cJ));
                this.caS.setText(cJ);
                this.caS.setContentDescription(sb.toString());
                this.caS.setVisibility(0);
                com.baidu.tieba.card.k.a(this.caS, bdVar.getId(), d.C0095d.cp_cont_c, d.C0095d.cp_cont_d);
            } else {
                this.caS.setVisibility(8);
            }
        } else {
            this.caS.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPg.getLayoutParams();
        if (layoutParams != null) {
            if (this.caS.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.caQ.getVisibility() == 8 && this.cPg.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.cPg.setPadding(0, 0, 0, 0);
            } else if (this.cPg.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.cPg.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.cPg.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cOW.U(this.ajM);
        ArrayList<VoiceData.VoiceModel> rK = bdVar.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caQ.setVisibility(8);
        } else {
            this.caQ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.caQ.setVoiceModel(voiceModel);
            this.caQ.setTag(voiceModel);
            this.caQ.bmf();
            if (voiceModel != null) {
                this.caQ.nT(voiceModel.voice_status.intValue());
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
                this.caT.setVisibility(0);
                this.caT.setFromCDN(this.ajk);
                if (this.ajM.ss() != null) {
                    this.caT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                m ss = e.this.ajM.ss();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                                return;
                            }
                            ax.aR(e.this.mContext);
                        }
                    });
                } else {
                    this.caT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            v<bd> abt = e.this.abt();
                            if (z) {
                                if (abt != null) {
                                    abt.aXH = true;
                                    abt.a(view, e.this.ajM);
                                }
                                e.this.abM();
                                return;
                            }
                            if (abt != null) {
                                abt.aXH = false;
                                abt.a(view, e.this.ajM);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.caT.setImageMediaList(linkedList);
            } else {
                this.caT.setVisibility(8);
            }
        } else {
            this.caT.setVisibility(8);
        }
        if (this.cPj != null) {
            if (bdVar.rI() != null) {
                String tb = bdVar.rI().tb();
                if (!StringUtils.isNull(tb)) {
                    this.cPj.setVisibility(0);
                    this.cPj.startLoad(tb, 10, true);
                } else {
                    this.cPj.setVisibility(8);
                }
            } else {
                this.cPj.setVisibility(8);
            }
        }
        if (this.cJG != null) {
            if (bdVar.rJ() != null) {
                String pA = bdVar.rJ().pA();
                if (!StringUtils.isNull(pA)) {
                    String fixedText = am.getFixedText(pA, 20, true);
                    aj.j(this.cJG, d.f.btn_red_frame_n);
                    aj.i(this.cJG, d.C0095d.cp_cont_h);
                    this.cJG.setText(fixedText);
                    this.cJG.setVisibility(0);
                } else {
                    this.cJG.setVisibility(8);
                }
            } else {
                this.cJG.setVisibility(8);
            }
        }
        abL();
        b.a(this.ajM, this.bZR);
        D(bdVar);
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccL != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            SkinInfo rR = bdVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aob.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bvP.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccL.setVisibility(8);
                if (this.bvQ != null) {
                    if (rR != null) {
                        this.bvQ.a(this.mPageContext, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.rB(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.bvQ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.ccL.setVisibility(0);
                this.ccL.setImageBitmap(null);
                this.ccL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.ccL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bvQ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.aob.setLayoutParams(layoutParams);
            this.bvP.setLayoutParams(layoutParams2);
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
                    imageUrlData.urlType = this.ajk ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajk, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void abL() {
        this.caQ.setClickable(true);
        this.cPg.setBarNameClickEnabled(true);
        int childCount = this.caT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajk = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cPg != null) {
            this.cPg.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jO(this.ajM.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caS, this.ajM.getId(), d.C0095d.cp_cont_c, d.C0095d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajM));
            m ss = this.ajM.ss();
            if (ss != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aR(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.ajM.aaa;
            if (this.ajM.ZZ == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VP;
                long j = jVar.VQ;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wd = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
            } else if (this.ajM.rJ() != null) {
                if (ax.aS(this.mPageContext.getPageActivity())) {
                    String postUrl = this.ajM.rJ().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.browser.a.P(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.gW(this.ajM.getId());
                boolean z = this.ajM.getType() != bd.YD;
                if (this.ajM.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxV()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajM.getTid(), String.valueOf(this.ajM.rS()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajM.sz());
                    createFromThreadCfg.setSmartFrsPosition(this.ajM.sG());
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
