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
public class e extends com.baidu.tieba.card.a<bd> implements u {
    private bd aXU;
    protected boolean aXs;
    private final View.OnClickListener bbR;
    public ClickableHeaderImageView bbZ;
    public ViewStub bcb;
    public TbImageView bcc;
    private final View.OnClickListener bce;
    private CardGroupDividerView cSX;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cTY;
    public View cTn;
    protected TextView cUa;
    protected ConstrainImageGroup cUb;
    private final View.OnClickListener cUe;
    public TbImageView cVQ;
    public LinearLayout cjI;
    public ThreadSkinView cjJ;
    public HeadPendantClickableView cju;
    protected TbImageView dIA;
    protected TextView dIB;
    private View.OnClickListener dIC;
    private com.baidu.tieba.frs.f.g dIn;
    public ThreadCommentAndPraiseInfoLayout dIx;
    public UserIconLayout dIy;
    public RelativeLayout dIz;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXs = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aXU != null && e.this.aXU.yS() != null && e.this.aXU.yS().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", e.this.aXU.getId()));
                }
                if (e.this.aXU != null && e.this.aXU.yz()) {
                    TiebaStatic.log(new ak("c11663").s("obj_param1", 1).ab("post_id", e.this.aXU.getTid()));
                }
                if (e.this.akb() != null) {
                    e.this.akb().a(view, e.this.aXU);
                }
                e.this.akv();
            }
        };
        this.dIC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akb() != null) {
                    e.this.akb().a(view, e.this.aXU);
                }
                e.this.akv();
            }
        };
        this.cUe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akb = e.this.akb();
                if (akb != null) {
                    akb.a(view, e.this.aXU);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akb() != null) {
                    e.this.akb().a(view, e.this.aXU);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akb() != null) {
                    e.this.akb().a(view, e.this.aXU);
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
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bbZ.setDefaultResource(17170445);
        this.bbZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bbZ.setDefaultBgResource(d.C0107d.cp_bg_line_e);
        this.bbZ.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bcb = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.dIy = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.dIy.bdi = true;
        this.dIy.setEntelechyEnabled(true);
        this.dIy.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cTY = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cTY.setAfterClickListener(this.cUe);
        this.cTY.setPlayTimeTextView(d.e.fontsize28);
        this.cVQ = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cVQ.setPageId(getTag());
        this.cUa = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cUa.setFocusable(true);
        this.cUb = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.cUb.setSingleImageRatio(0.75d);
        this.cUb.setImageMargin(dimensionPixelSize);
        this.cUb.setChildClickListener(this.dIC);
        this.dIx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dIx.setFrom(2);
        this.dIx.bbP = 3;
        this.cTn = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cjI = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.dIz = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.dIA = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.dIA.setPageId(getTag());
        this.dIB = (TextView) view.findViewById(d.g.app_code_btn);
        this.cjJ = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.cSX = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cSX.setTitleClickListener(this.cSt);
        this.dIn = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dIz);
        this.dIn.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUb != null) {
            this.cUb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUb != null) {
            this.cUb.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout akG() {
        return this.dIx;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0107d.cp_bg_line_d);
            aj.s(this.dIz, d.f.addresslist_item_bg);
            this.cUb.onChangeSkinType();
            this.dIy.onChangeSkinType();
            this.dIx.onChangeSkinType();
            if (this.cSX != null) {
                this.cSX.onChangeSkinType();
            }
            this.dIn.onChangeSkinType();
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
    public void a(final bd bdVar) {
        int i;
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aXU = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.dIz != null) {
                this.dIz.setOnClickListener(this.cSt);
                this.dIz.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.cSt);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.kd(this.aXU.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.aXU.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUa, this.aXU.getId(), d.C0107d.cp_cont_c, d.C0107d.cp_cont_d);
        }
        this.dIy.setVisibility(0);
        if (this.aXU.yS() != null && !StringUtils.isNull(this.aXU.yS().getSealPrefix())) {
            this.dIy.bs(true);
        }
        if (this.aXU.yS() == null || this.aXU.yS().getPendantData() == null || StringUtils.isNull(this.aXU.yS().getPendantData().xt())) {
            UserTbVipInfoData yT = this.aXU.yT();
            if (yT != null && yT.getvipV_url() != null) {
                if (this.bcb != null) {
                    if (this.bcc == null) {
                        this.bcb.inflate();
                        this.bcc = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bcc.setVisibility(0);
                    this.bcc.startLoad(yT.getvipV_url(), 10, false);
                    this.bbZ.setIsBigV(true);
                }
            } else {
                this.bbZ.setIsBigV(false);
                if (this.bcc != null) {
                    this.bcc.setVisibility(8);
                }
            }
            this.cju.setVisibility(8);
            this.bbZ.setVisibility(0);
            this.bbZ.setData(bdVar);
            this.bbZ.setAfterClickListener(this.bce);
        } else {
            this.bbZ.setVisibility(4);
            this.bbZ.setIsBigV(false);
            if (this.bcc != null) {
                this.bcc.setVisibility(8);
            }
            this.cju.setVisibility(0);
            this.cju.setData(bdVar);
        }
        this.dIy.setData(bdVar);
        this.dIy.setUserAfterClickListener(this.bce);
        if (this.dIx.setData(bdVar)) {
            this.cTn.setVisibility(8);
        } else {
            this.cTn.setVisibility(0);
        }
        this.dIx.updataMoreView(this.mTbPageContext);
        this.dIx.setForumAfterClickListener(this.bbR);
        this.dIx.setStType("frs_page");
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yQ() == null || bdVar.yQ().size() == 0)) || bdVar.zi() == 1) {
            bdVar.h(false, true);
            if (bdVar.zs() == null || StringUtils.isNull(bdVar.zs().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bdVar.zs());
            }
        } else {
            this.mTitle.setVisibility(0);
            bdVar.aNn = 0;
            bdVar.h(false, bdVar.zN());
            SpannableStringBuilder zs = bdVar.zs();
            this.mTitle.setOnTouchListener(new m(zs));
            this.mTitle.setText(zs);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
            sb.append(bdVar.getAbstract());
        }
        ArrayList<MediaData> zd = bdVar.zd();
        if (zd != null) {
            i = zd.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (zd.get(i2).getVideoUrl() != null && zd.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(zd.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                SpannableString cQ = bdVar.cQ(sb.toString());
                this.cUa.setOnTouchListener(new m(cQ));
                this.cUa.setText(cQ);
                this.cUa.setContentDescription(sb.toString());
                this.cUa.setVisibility(0);
                com.baidu.tieba.card.k.a(this.cUa, bdVar.getId(), d.C0107d.cp_cont_c, d.C0107d.cp_cont_d);
            } else {
                this.cUa.setVisibility(8);
            }
        } else {
            this.cUa.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dIx.getLayoutParams();
        if (layoutParams != null) {
            if (this.cUa.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.cTY.getVisibility() == 8 && this.dIx.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.dIx.setPadding(0, 0, 0, 0);
            } else if (this.dIx.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dIx.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dIx.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.dIn.T(this.aXU);
        ArrayList<VoiceData.VoiceModel> zh = bdVar.zh();
        if (com.baidu.tbadk.core.util.v.E(zh)) {
            this.cTY.setVisibility(8);
        } else {
            this.cTY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zh.get(0);
            this.cTY.setVoiceModel(voiceModel);
            this.cTY.setTag(voiceModel);
            this.cTY.bnf();
            if (voiceModel != null) {
                this.cTY.qE(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.i.wA().wG() && com.baidu.tbadk.core.util.v.D(zd) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zd, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.cUb.setVisibility(0);
                this.cUb.setFromCDN(this.aXs);
                if (this.aXU.zM() != null) {
                    this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                com.baidu.tbadk.core.data.m zM = e.this.aXU.zM();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), zM.getCartoonId(), zM.getChapterId(), 2)));
                                return;
                            }
                            ax.bd(e.this.mContext);
                        }
                    });
                } else {
                    this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            v<bd> akb = e.this.akb();
                            if (z) {
                                if (akb != null) {
                                    akb.bLD = true;
                                    akb.a(view, e.this.aXU);
                                }
                                e.this.akv();
                                return;
                            }
                            if (akb != null) {
                                akb.bLD = false;
                                akb.a(view, e.this.aXU);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.cUb.setImageMediaList(linkedList);
            } else {
                this.cUb.setVisibility(8);
            }
        } else {
            this.cUb.setVisibility(8);
        }
        if (this.dIA != null) {
            if (bdVar.zf() != null) {
                String Au = bdVar.zf().Au();
                if (!StringUtils.isNull(Au)) {
                    this.dIA.setVisibility(0);
                    this.dIA.startLoad(Au, 10, true);
                } else {
                    this.dIA.setVisibility(8);
                }
            } else {
                this.dIA.setVisibility(8);
            }
        }
        if (this.dIB != null) {
            if (bdVar.zg() != null) {
                String xc = bdVar.zg().xc();
                if (!StringUtils.isNull(xc)) {
                    String fixedText = am.getFixedText(xc, 20, true);
                    aj.s(this.dIB, d.f.btn_red_frame_n);
                    aj.r(this.dIB, d.C0107d.cp_cont_h);
                    this.dIB.setText(fixedText);
                    this.dIB.setVisibility(0);
                } else {
                    this.dIB.setVisibility(8);
                }
            } else {
                this.dIB.setVisibility(8);
            }
        }
        aku();
        b.a(this.aXU, this.cSX);
        H(bdVar);
    }

    public void H(bd bdVar) {
        MetaData yS;
        if (bdVar != null && this.cVQ != null && (yS = bdVar.yS()) != null) {
            final ThemeCardInUserData themeCard = yS.getThemeCard();
            SkinInfo zo = bdVar.zo();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbZ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cjI.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cVQ.setVisibility(8);
                if (this.cjJ != null) {
                    if (zo != null) {
                        this.cjJ.a(this.mPageContext, zo, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.yY(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cjJ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cVQ.setVisibility(0);
                this.cVQ.setImageBitmap(null);
                this.cVQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cjJ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.bbZ.setLayoutParams(layoutParams);
            this.cjI.setLayoutParams(layoutParams2);
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
                    imageUrlData.urlType = this.aXs ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yY(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXs, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void aku() {
        this.cTY.setClickable(true);
        this.dIx.setBarNameClickEnabled(true);
        int childCount = this.cUb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUb.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXs = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dIx != null) {
            this.dIx.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        PbActivityConfig createFromThreadCfg;
        if (this.aXU != null) {
            com.baidu.tieba.card.k.kc(this.aXU.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.aXU.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUa, this.aXU.getId(), d.C0107d.cp_cont_c, d.C0107d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aXU));
            com.baidu.tbadk.core.data.m zM = this.aXU.zM();
            if (zM != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.bd(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zM.getCartoonId(), zM.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.aXU.aOx;
            if (this.aXU.aOw == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKk;
                long j = jVar.aKl;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aKy = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
            } else if (this.aXU.zg() != null) {
                if (ax.be(this.mPageContext.getPageActivity())) {
                    String postUrl = this.aXU.zg().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.oZ()) {
                        com.baidu.tbadk.browser.a.R(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.ha(this.aXU.getId());
                boolean z = this.aXU.getType() != bd.aMY;
                if (this.aXU.zp() > 0 && com.baidu.tieba.tbadkCore.util.f.bwI()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aXU.getTid(), String.valueOf(this.aXU.zp()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXU, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aXU.zT());
                    createFromThreadCfg.setSmartFrsPosition(this.aXU.Aa());
                    createFromThreadCfg.setForumId(String.valueOf(this.aXU.getFid()));
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
