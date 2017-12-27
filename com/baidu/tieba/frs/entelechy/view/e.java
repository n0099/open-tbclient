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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.be;
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
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<be> implements u {
    private be aXV;
    protected boolean aXt;
    private final View.OnClickListener bbR;
    public ClickableHeaderImageView bbZ;
    public ViewStub bcb;
    public TbImageView bcc;
    private final View.OnClickListener bce;
    public HeadPendantClickableView cNO;
    private View.OnClickListener cNS;
    public View cOM;
    private CardGroupDividerView cOw;
    private final View.OnClickListener cPC;
    public PlayVoiceBntNew cPw;
    protected TextView cPy;
    protected ConstrainImageGroup cPz;
    public TbImageView cRo;
    public LinearLayout cjA;
    public ThreadSkinView cjB;
    private com.baidu.tieba.frs.f.g dDM;
    public ThreadCommentAndPraiseInfoLayout dDW;
    public UserIconLayout dDX;
    public RelativeLayout dDY;
    protected TbImageView dDZ;
    protected TextView dEa;
    private View.OnClickListener dEb;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXt = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aXV != null && e.this.aXV.yX() != null && e.this.aXV.yX().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", e.this.aXV.getId()));
                }
                if (e.this.aXV != null && e.this.aXV.yC()) {
                    TiebaStatic.log(new ak("c11663").s("obj_param1", 1).ab("post_id", e.this.aXV.getTid()));
                }
                if (e.this.aiY() != null) {
                    e.this.aiY().a(view, e.this.aXV);
                }
                e.this.ajs();
            }
        };
        this.dEb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiY() != null) {
                    e.this.aiY().a(view, e.this.aXV);
                }
                e.this.ajs();
            }
        };
        this.cPC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<be> aiY = e.this.aiY();
                if (aiY != null) {
                    aiY.a(view, e.this.aXV);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiY() != null) {
                    e.this.aiY().a(view, e.this.aXV);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiY() != null) {
                    e.this.aiY().a(view, e.this.aXV);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.bbZ = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bbZ.setDefaultResource(17170445);
        this.bbZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bbZ.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.bbZ.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bcb = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.dDX = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.dDX.bdc = true;
        this.dDX.setEntelechyEnabled(true);
        this.dDX.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cPw = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cPw.setAfterClickListener(this.cPC);
        this.cPw.setPlayTimeTextView(d.e.fontsize28);
        this.cRo = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cRo.setPageId(getTag());
        this.cPy = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cPy.setFocusable(true);
        this.cPz = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.cPz.setSingleImageRatio(0.75d);
        this.cPz.setImageMargin(dimensionPixelSize);
        this.cPz.setChildClickListener(this.dEb);
        this.dDW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dDW.setFrom(2);
        this.dDW.bbP = 3;
        this.cOM = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cjA = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.dDY = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.dDZ = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.dDZ.setPageId(getTag());
        this.dEa = (TextView) view.findViewById(d.g.app_code_btn);
        this.cjB = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.cOw = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cOw.setTitleClickListener(this.cNS);
        this.dDM = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dDY);
        this.dDM.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cPz != null) {
            this.cPz.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cPz != null) {
            this.cPz.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout ajD() {
        return this.dDW;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0108d.cp_bg_line_d);
            aj.s(this.dDY, d.f.addresslist_item_bg);
            this.cPz.onChangeSkinType();
            this.dDX.onChangeSkinType();
            this.dDW.onChangeSkinType();
            if (this.cOw != null) {
                this.cOw.onChangeSkinType();
            }
            this.dDM.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(final be beVar) {
        int i;
        if (beVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aXV = beVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.dDY != null) {
                this.dDY.setOnClickListener(this.cNS);
                this.dDY.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.cNS);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.jU(this.aXV.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.aXV.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cPy, this.aXV.getId(), d.C0108d.cp_cont_c, d.C0108d.cp_cont_d);
        }
        this.dDX.setVisibility(0);
        if (this.aXV.yX() != null && !StringUtils.isNull(this.aXV.yX().getSealPrefix())) {
            this.dDX.bs(true);
        }
        if (this.aXV.yX() == null || this.aXV.yX().getPendantData() == null || StringUtils.isNull(this.aXV.yX().getPendantData().xu())) {
            UserTbVipInfoData yY = this.aXV.yY();
            if (yY != null && yY.getvipV_url() != null) {
                if (this.bcb != null) {
                    if (this.bcc == null) {
                        this.bcb.inflate();
                        this.bcc = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bcc.setVisibility(0);
                    this.bcc.startLoad(yY.getvipV_url(), 10, false);
                    this.bbZ.setIsBigV(true);
                }
            } else {
                this.bbZ.setIsBigV(false);
                if (this.bcc != null) {
                    this.bcc.setVisibility(8);
                }
            }
            this.cNO.setVisibility(8);
            this.bbZ.setVisibility(0);
            this.bbZ.setData(beVar);
            this.bbZ.setAfterClickListener(this.bce);
        } else {
            this.bbZ.setVisibility(4);
            this.bbZ.setIsBigV(false);
            if (this.bcc != null) {
                this.bcc.setVisibility(8);
            }
            this.cNO.setVisibility(0);
            this.cNO.setData(beVar);
        }
        this.dDX.setData(beVar);
        this.dDX.setUserAfterClickListener(this.bce);
        if (this.dDW.setData(beVar)) {
            this.cOM.setVisibility(8);
        } else {
            this.cOM.setVisibility(0);
        }
        this.dDW.updataMoreView(this.mTbPageContext);
        this.dDW.setForumAfterClickListener(this.bbR);
        this.dDW.setStType("frs_page");
        if ((StringUtils.isNull(beVar.getTitle()) && (beVar.yV() == null || beVar.yV().size() == 0)) || beVar.zn() == 1) {
            beVar.h(false, true);
            if (beVar.zx() == null || StringUtils.isNull(beVar.zx().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(beVar.zx());
            }
        } else {
            this.mTitle.setVisibility(0);
            beVar.aNr = 0;
            beVar.h(false, beVar.zV());
            SpannableStringBuilder zx = beVar.zx();
            this.mTitle.setOnTouchListener(new m(zx));
            this.mTitle.setText(zx);
            com.baidu.tieba.card.k.a(this.mTitle, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (beVar.getAbstract() != null && !StringUtils.isNull(beVar.getAbstract())) {
            sb.append(beVar.getAbstract());
        }
        ArrayList<MediaData> zi = beVar.zi();
        if (zi != null) {
            i = zi.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (zi.get(i2).getVideoUrl() != null && zi.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(zi.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(beVar.g(sb.toString(), true))) {
                SpannableString cQ = beVar.cQ(sb.toString());
                this.cPy.setOnTouchListener(new m(cQ));
                this.cPy.setText(cQ);
                this.cPy.setContentDescription(sb.toString());
                this.cPy.setVisibility(0);
                com.baidu.tieba.card.k.a(this.cPy, beVar.getId(), d.C0108d.cp_cont_c, d.C0108d.cp_cont_d);
            } else {
                this.cPy.setVisibility(8);
            }
        } else {
            this.cPy.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDW.getLayoutParams();
        if (layoutParams != null) {
            if (this.cPy.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.cPw.getVisibility() == 8 && this.dDW.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.dDW.setPadding(0, 0, 0, 0);
            } else if (this.dDW.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dDW.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dDW.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.dDM.T(this.aXV);
        ArrayList<VoiceData.VoiceModel> zm = beVar.zm();
        if (com.baidu.tbadk.core.util.v.G(zm)) {
            this.cPw.setVisibility(8);
        } else {
            this.cPw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zm.get(0);
            this.cPw.setVoiceModel(voiceModel);
            this.cPw.setTag(voiceModel);
            this.cPw.btM();
            if (voiceModel != null) {
                this.cPw.qL(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.i.wB().wH() && com.baidu.tbadk.core.util.v.F(zi) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zi, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.F(linkedList) > 0) {
                this.cPz.setVisibility(0);
                this.cPz.setFromCDN(this.aXt);
                if (this.aXV.zU() != null) {
                    this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                com.baidu.tbadk.core.data.m zU = e.this.aXV.zU();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), zU.getCartoonId(), zU.getChapterId(), 2)));
                                return;
                            }
                            ax.bd(e.this.mContext);
                        }
                    });
                } else {
                    this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            v<be> aiY = e.this.aiY();
                            if (z) {
                                if (aiY != null) {
                                    aiY.bLv = true;
                                    aiY.a(view, e.this.aXV);
                                }
                                e.this.ajs();
                                return;
                            }
                            if (aiY != null) {
                                aiY.bLv = false;
                                aiY.a(view, e.this.aXV);
                            }
                            e.this.a(view, linkedList, i4, beVar);
                        }
                    });
                }
                this.cPz.setImageMediaList(linkedList);
            } else {
                this.cPz.setVisibility(8);
            }
        } else {
            this.cPz.setVisibility(8);
        }
        if (this.dDZ != null) {
            if (beVar.zk() != null) {
                String AC = beVar.zk().AC();
                if (!StringUtils.isNull(AC)) {
                    this.dDZ.setVisibility(0);
                    this.dDZ.startLoad(AC, 10, true);
                } else {
                    this.dDZ.setVisibility(8);
                }
            } else {
                this.dDZ.setVisibility(8);
            }
        }
        if (this.dEa != null) {
            if (beVar.zl() != null) {
                String xd = beVar.zl().xd();
                if (!StringUtils.isNull(xd)) {
                    String fixedText = am.getFixedText(xd, 20, true);
                    aj.s(this.dEa, d.f.btn_red_frame_n);
                    aj.r(this.dEa, d.C0108d.cp_cont_h);
                    this.dEa.setText(fixedText);
                    this.dEa.setVisibility(0);
                } else {
                    this.dEa.setVisibility(8);
                }
            } else {
                this.dEa.setVisibility(8);
            }
        }
        ajr();
        b.a(this.aXV, this.cOw);
        H(beVar);
    }

    public void H(be beVar) {
        MetaData yX;
        if (beVar != null && this.cRo != null && (yX = beVar.yX()) != null) {
            final ThemeCardInUserData themeCard = yX.getThemeCard();
            SkinInfo zt = beVar.zt();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbZ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cjA.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cRo.setVisibility(8);
                if (this.cjB != null) {
                    if (zt != null) {
                        this.cjB.a(this.mPageContext, zt, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(beVar.getFid()), beVar.zd(), beVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cjB.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cRo.setVisibility(0);
                this.cRo.setImageBitmap(null);
                this.cRo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cjB.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.bbZ.setLayoutParams(layoutParams);
            this.cjA.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, be beVar) {
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
                    imageUrlData.urlType = this.aXt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(beVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, beVar.zd(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aXt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void ajr() {
        this.cPw.setClickable(true);
        this.dDW.setBarNameClickEnabled(true);
        int childCount = this.cPz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cPz.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXt = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dDW != null) {
            this.dDW.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        PbActivityConfig createFromThreadCfg;
        if (this.aXV != null) {
            com.baidu.tieba.card.k.jT(this.aXV.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.aXV.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cPy, this.aXV.getId(), d.C0108d.cp_cont_c, d.C0108d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aXV));
            com.baidu.tbadk.core.data.m zU = this.aXV.zU();
            if (zU != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.bd(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zU.getCartoonId(), zU.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.aXV.aOz;
            if (this.aXV.aOy == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKm;
                long j = jVar.aKn;
                al alVar = new al();
                alVar.pageContext = this.mPageContext;
                alVar.aKA = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
            } else if (this.aXV.zl() != null) {
                if (ax.be(this.mPageContext.getPageActivity())) {
                    String postUrl = this.aXV.zl().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.oZ()) {
                        com.baidu.tbadk.browser.a.S(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.gZ(this.aXV.getId());
                boolean z = this.aXV.getType() != be.aNc;
                if (this.aXV.zu() > 0 && com.baidu.tieba.tbadkCore.util.f.bDl()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aXV.getTid(), String.valueOf(this.aXV.zu()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXV, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aXV.Ab());
                    createFromThreadCfg.setSmartFrsPosition(this.aXV.Ai());
                    createFromThreadCfg.setForumId(String.valueOf(this.aXV.getFid()));
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
