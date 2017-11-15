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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.n;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<bh> implements v {
    protected boolean aiR;
    private bh ajq;
    public ClickableHeaderImageView anM;
    public ViewStub anO;
    public TbImageView anP;
    private final View.OnClickListener anR;
    private final View.OnClickListener anz;
    private CardGroupDividerView bRL;
    public HeadPendantClickableView bRc;
    private View.OnClickListener bRh;
    public PlayVoiceBntNew bSW;
    protected TextView bSY;
    protected ConstrainImageGroup bSZ;
    public View bSd;
    private final View.OnClickListener bTa;
    public ThreadCommentAndPraiseInfoLayout bTe;
    public UserIconLayout bTh;
    public LinearLayout boQ;
    public ThreadSkinView boR;
    protected TextView cAo;
    private com.baidu.tieba.frs.g.g cFB;
    public RelativeLayout cFI;
    protected TbImageView cFJ;
    private View.OnClickListener cFK;
    public TbImageView czY;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiR = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajq != null && e.this.ajq.rt() != null && e.this.ajq.rt().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", e.this.ajq.getId()));
                }
                if (e.this.ajq != null && e.this.ajq.qY()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ac("post_id", e.this.ajq.getTid()));
                }
                if (e.this.ZJ() != null) {
                    e.this.ZJ().a(view, e.this.ajq);
                }
                e.this.aab();
            }
        };
        this.cFK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ZJ() != null) {
                    e.this.ZJ().a(view, e.this.ajq);
                }
                e.this.aab();
            }
        };
        this.bTa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> ZJ = e.this.ZJ();
                if (ZJ != null) {
                    ZJ.a(view, e.this.ajq);
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ZJ() != null) {
                    e.this.ZJ().a(view, e.this.ajq);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ZJ() != null) {
                    e.this.ZJ().a(view, e.this.ajq);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.anM = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bRc = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.anM.setDefaultResource(17170445);
        this.anM.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.anM.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.anM.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.anO = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.bTh = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.bTh.aoF = true;
        this.bTh.setEntelechyEnabled(true);
        this.bTh.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.bSW = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.bSW.setAfterClickListener(this.bTa);
        this.bSW.setPlayTimeTextView(d.e.fontsize28);
        this.czY = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.czY.setPageId(getTag());
        this.bSY = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.bSY.setFocusable(true);
        this.bSZ = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.bSZ.setSingleImageRatio(0.75d);
        this.bSZ.setImageMargin(dimensionPixelSize);
        this.bSZ.setChildClickListener(this.cFK);
        this.bTe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bTe.setLocationEnabled(true);
        this.bTe.setViewNumEnabled(true);
        this.bTe.setCommentNumClickListener(this.bRh);
        this.bTe.setFrom(2);
        this.bSd = view.findViewById(d.g.divider_below_reply_number_layout);
        this.boQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cFI = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cFJ = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.cFJ.setPageId(getTag());
        this.cAo = (TextView) view.findViewById(d.g.app_code_btn);
        this.boR = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bRL = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.bRL.setTitleClickListener(this.bRh);
        this.cFB = new com.baidu.tieba.frs.g.g(this.mPageContext, this.bTe);
        this.cFB.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0080d.cp_bg_line_d);
            aj.j(this.cFI, d.f.addresslist_item_bg);
            this.bSZ.onChangeSkinType();
            this.bTh.onChangeSkinType();
            this.bTe.onChangeSkinType();
            if (this.bRL != null) {
                this.bRL.onChangeSkinType();
            }
            this.cFB.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(final bh bhVar) {
        int i;
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajq = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cFI != null) {
                this.cFI.setOnClickListener(this.bRh);
                this.cFI.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bRh);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (m.jM(this.ajq.getId())) {
            m.a(this.mTitle, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSY, this.ajq.getId(), d.C0080d.cp_cont_c, d.C0080d.cp_cont_d);
        }
        this.bTh.setVisibility(0);
        if (this.ajq.rt() != null && !StringUtils.isNull(this.ajq.rt().getSealPrefix())) {
            this.bTh.aL(true);
        }
        if (this.ajq.rt() == null || this.ajq.rt().getPendantData() == null || StringUtils.isNull(this.ajq.rt().getPendantData().pQ())) {
            UserTbVipInfoData ru = this.ajq.ru();
            if (ru != null && ru.getvipV_url() != null) {
                if (this.anO != null) {
                    if (this.anP == null) {
                        this.anO.inflate();
                        this.anP = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.anP.setVisibility(0);
                    this.anP.startLoad(ru.getvipV_url(), 10, false);
                    this.anM.setIsBigV(true);
                }
            } else {
                this.anM.setIsBigV(false);
                if (this.anP != null) {
                    this.anP.setVisibility(8);
                }
            }
            this.bRc.setVisibility(8);
            this.anM.setVisibility(0);
            this.anM.setData(bhVar);
            this.anM.setAfterClickListener(this.anR);
        } else {
            this.anM.setVisibility(4);
            this.anM.setIsBigV(false);
            if (this.anP != null) {
                this.anP.setVisibility(8);
            }
            this.bRc.setVisibility(0);
            this.bRc.setData(bhVar);
        }
        this.bTh.setData(bhVar);
        this.bTh.setUserAfterClickListener(this.anR);
        if (this.bTe.setData(bhVar)) {
            this.bSd.setVisibility(8);
        } else {
            this.bSd.setVisibility(0);
        }
        this.bTe.updataMoreView(this.mTbPageContext);
        this.bTe.setForumAfterClickListener(this.anz);
        this.bTe.setStType("frs_page");
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rr() == null || bhVar.rr().size() == 0)) || bhVar.rJ() == 1) {
            bhVar.e(false, true);
            if (bhVar.rU() == null || StringUtils.isNull(bhVar.rU().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bhVar.rU());
            }
        } else {
            this.mTitle.setVisibility(0);
            bhVar.YC = 0;
            bhVar.e(false, bhVar.ss());
            SpannableStringBuilder rU = bhVar.rU();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rU));
            this.mTitle.setText(rU);
            m.a(this.mTitle, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bhVar.getAbstract() != null && !StringUtils.isNull(bhVar.getAbstract())) {
            sb.append(bhVar.getAbstract());
        }
        ArrayList<MediaData> rE = bhVar.rE();
        if (rE != null) {
            i = rE.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rE.get(i2).getVideoUrl() != null && rE.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rE.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                SpannableString cJ = bhVar.cJ(sb.toString());
                this.bSY.setOnTouchListener(new com.baidu.tieba.view.l(cJ));
                this.bSY.setText(cJ);
                this.bSY.setContentDescription(sb.toString());
                this.bSY.setVisibility(0);
                m.a(this.bSY, bhVar.getId(), d.C0080d.cp_cont_c, d.C0080d.cp_cont_d);
            } else {
                this.bSY.setVisibility(8);
            }
        } else {
            this.bSY.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTe.getLayoutParams();
        if (layoutParams != null) {
            if (this.bSY.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bSW.getVisibility() == 8 && this.bTe.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.bTe.setPadding(0, 0, 0, 0);
            } else if (this.bTe.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bTe.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bTe.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cFB.Q(this.ajq);
        ArrayList<VoiceData.VoiceModel> rI = bhVar.rI();
        if (com.baidu.tbadk.core.util.v.v(rI)) {
            this.bSW.setVisibility(8);
        } else {
            this.bSW.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSW.setVoiceModel(voiceModel);
            this.bSW.setTag(voiceModel);
            this.bSW.bjz();
            if (voiceModel != null) {
                this.bSW.ny(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.u(rE) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rE, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                this.bSZ.setVisibility(0);
                this.bSZ.setFromCDN(this.aiR);
                if (this.ajq.sr() != null) {
                    this.bSZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sr = e.this.ajq.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                                return;
                            }
                            ax.aS(e.this.mContext);
                        }
                    });
                } else {
                    this.bSZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bh> ZJ = e.this.ZJ();
                            if (z) {
                                if (ZJ != null) {
                                    ZJ.aUA = true;
                                    ZJ.a(view, e.this.ajq);
                                }
                                e.this.aab();
                                return;
                            }
                            if (ZJ != null) {
                                ZJ.aUA = false;
                                ZJ.a(view, e.this.ajq);
                            }
                            e.this.a(view, linkedList, i4, bhVar);
                        }
                    });
                }
                this.bSZ.setImageMediaList(linkedList);
            } else {
                this.bSZ.setVisibility(8);
            }
        } else {
            this.bSZ.setVisibility(8);
        }
        if (this.cFJ != null) {
            if (bhVar.rG() != null) {
                String tb = bhVar.rG().tb();
                if (!StringUtils.isNull(tb)) {
                    this.cFJ.setVisibility(0);
                    this.cFJ.startLoad(tb, 10, true);
                } else {
                    this.cFJ.setVisibility(8);
                }
            } else {
                this.cFJ.setVisibility(8);
            }
        }
        if (this.cAo != null) {
            if (bhVar.rH() != null) {
                String pv = bhVar.rH().pv();
                if (!StringUtils.isNull(pv)) {
                    String fixedText = am.getFixedText(pv, 20, true);
                    aj.j(this.cAo, d.f.btn_red_frame_n);
                    aj.i(this.cAo, d.C0080d.cp_cont_h);
                    this.cAo.setText(fixedText);
                    this.cAo.setVisibility(0);
                } else {
                    this.cAo.setVisibility(8);
                }
            } else {
                this.cAo.setVisibility(8);
            }
        }
        aaa();
        b.a(this.ajq, this.bRL);
        G(bhVar);
    }

    public void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && this.czY != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            SkinInfo rP = bhVar.rP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anM.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.boQ.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.czY.setVisibility(8);
                if (this.boR != null) {
                    if (rP != null) {
                        this.boR.a(this.mPageContext, rP, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rz(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.boR.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.czY.setVisibility(0);
                this.czY.setImageBitmap(null);
                this.czY.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.czY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.boR.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.anM.setLayoutParams(layoutParams);
            this.boQ.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.urlType = this.aiR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void aaa() {
        this.bSW.setClickable(true);
        this.bTe.setBarNameClickEnabled(true);
        int childCount = this.bSZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSZ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bTe != null) {
            this.bTe.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajq != null) {
            m.jL(this.ajq.getId());
            m.a(this.mTitle, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSY, this.ajq.getId(), d.C0080d.cp_cont_c, d.C0080d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajq));
            n sr = this.ajq.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.ajq.ZK;
            if (this.ajq.ZJ == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Vl;
                long j = kVar.Vm;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.VJ = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
            } else if (this.ajq.rH() != null) {
                if (ax.aT(this.mPageContext.getPageActivity())) {
                    String postUrl = this.ajq.rH().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.browser.a.P(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.gV(this.ajq.getId());
                boolean z = this.ajq.getType() != bh.Yo;
                if (this.ajq.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvE()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajq.getTid(), String.valueOf(this.ajq.rQ()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajq, this.mForumName, "frs_page", 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajq.sy());
                    createFromThreadCfg.setSmartFrsPosition(this.ajq.sF());
                    createFromThreadCfg.setForumId(String.valueOf(this.ajq.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
