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
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.util.s;
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
public class e extends com.baidu.tieba.card.a<bj> implements v {
    private bj ajE;
    protected boolean aje;
    private final View.OnClickListener aoc;
    public ClickableHeaderImageView aop;
    public ViewStub aor;
    public TbImageView aos;
    private final View.OnClickListener aou;
    private CardGroupDividerView bKR;
    public HeadPendantClickableView bKh;
    public View bKj;
    private View.OnClickListener bKn;
    public PlayVoiceBntNew bLV;
    protected TextView bLW;
    protected ConstrainImageGroup bLX;
    private final View.OnClickListener bLY;
    public ThreadCommentAndPraiseInfoLayout bMc;
    public UserIconLayout bMf;
    public LinearLayout blC;
    public ThreadSkinView blD;
    public TbImageView crX;
    protected TextView csn;
    private com.baidu.tieba.frs.h.g cwN;
    public RelativeLayout cwS;
    protected TbImageView cwT;
    private View.OnClickListener cwU;
    private int ds16;
    private int ds32;
    private TbPageContext<?> mF;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aje = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajE != null && e.this.ajE.getAuthor() != null && e.this.ajE.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", e.this.ajE.getId()));
                }
                if (e.this.ajE != null && e.this.ajE.rh()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ad("post_id", e.this.ajE.getTid()));
                }
                if (e.this.XL() != null) {
                    e.this.XL().a(view, e.this.ajE);
                }
                e.this.Yc();
            }
        };
        this.cwU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XL() != null) {
                    e.this.XL().a(view, e.this.ajE);
                }
                e.this.Yc();
            }
        };
        this.bLY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bj> XL = e.this.XL();
                if (XL != null) {
                    XL.a(view, e.this.ajE);
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XL() != null) {
                    e.this.XL().a(view, e.this.ajE);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XL() != null) {
                    e.this.XL().a(view, e.this.ajE);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.ds16 = (int) this.mF.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.mF.getResources().getDimension(d.f.ds32);
        this.aop = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bKh = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.aop.setDefaultResource(17170445);
        this.aop.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aop.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aop.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        this.aor = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.bMf = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bMf.apl = true;
        this.bMf.setEntelechyEnabled(true);
        this.bMf.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLV = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLV.setAfterClickListener(this.bLY);
        this.bLV.setPlayTimeTextView(d.f.fontsize28);
        this.crX = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.crX.setPageId(getTag());
        this.bLW = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLW.setFocusable(true);
        this.bLX = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bLX.setSingleImageRatio(0.75d);
        this.bLX.setImageMargin(dimensionPixelSize);
        this.bLX.setChildClickListener(this.cwU);
        this.bMc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bMc.setLocationEnabled(true);
        this.bMc.setViewNumEnabled(true);
        this.bMc.setCommentNumClickListener(this.bKn);
        this.bMc.setFrom(2);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        this.blC = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cwS = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cwT = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cwT.setPageId(getTag());
        this.csn = (TextView) view.findViewById(d.h.app_code_btn);
        this.blD = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bKR = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bKR.setTitleClickListener(this.bKn);
        this.cwN = new com.baidu.tieba.frs.h.g(this.mF, this.bMc);
        this.cwN.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLX != null) {
            this.bLX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLX != null) {
            this.bLX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.j(this.cwS, d.g.addresslist_item_bg);
            this.bLX.onChangeSkinType();
            this.bMf.onChangeSkinType();
            this.bMc.onChangeSkinType();
            if (this.bKR != null) {
                this.bKR.onChangeSkinType();
            }
            this.cwN.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(final bj bjVar) {
        int i;
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajE = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cwS != null) {
                this.cwS.setOnClickListener(this.bKn);
                this.cwS.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bKn);
                getView().setLongClickable(true);
            }
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (m.jv(this.ajE.getId())) {
            m.a(this.mTitle, this.ajE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLW, this.ajE.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bMf.setVisibility(0);
        if (this.ajE.getAuthor() != null && !StringUtils.isNull(this.ajE.getAuthor().getSealPrefix())) {
            this.bMf.aP(true);
        }
        if (this.ajE.getAuthor() == null || this.ajE.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajE.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rB = this.ajE.rB();
            if (rB != null && rB.getvipV_url() != null) {
                if (this.aor != null) {
                    if (this.aos == null) {
                        this.aor.inflate();
                        this.aos = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aos.setVisibility(0);
                    this.aos.c(rB.getvipV_url(), 10, false);
                    this.aop.setIsBigV(true);
                }
            } else {
                this.aop.setIsBigV(false);
                if (this.aos != null) {
                    this.aos.setVisibility(8);
                }
            }
            this.bKh.setVisibility(8);
            this.aop.setVisibility(0);
            this.aop.setData(bjVar);
            this.aop.setAfterClickListener(this.aou);
        } else {
            this.aop.setVisibility(4);
            this.aop.setIsBigV(false);
            if (this.aos != null) {
                this.aos.setVisibility(8);
            }
            this.bKh.setVisibility(0);
            this.bKh.setData(bjVar);
        }
        this.bMf.setData(bjVar);
        this.bMf.setUserAfterClickListener(this.aou);
        if (this.bMc.c(bjVar)) {
            this.bKj.setVisibility(8);
        } else {
            this.bKj.setVisibility(0);
        }
        this.bMc.f(this.mTbPageContext);
        this.bMc.setForumAfterClickListener(this.aoc);
        this.bMc.setStType(m.rs());
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.rz() == null || bjVar.rz().size() == 0)) || bjVar.rQ() == 1) {
            bjVar.e(false, true);
            if (bjVar.sb() == null || StringUtils.isNull(bjVar.sb().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bjVar.sb());
            }
        } else {
            this.mTitle.setVisibility(0);
            bjVar.Yv = 0;
            bjVar.e(false, bjVar.sy());
            SpannableStringBuilder sb = bjVar.sb();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(sb));
            this.mTitle.setText(sb);
            m.a(this.mTitle, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        StringBuilder sb2 = new StringBuilder();
        if (bjVar.rJ() != null && !StringUtils.isNull(bjVar.rJ())) {
            sb2.append(bjVar.rJ());
        }
        ArrayList<MediaData> rL = bjVar.rL();
        if (rL != null) {
            i = rL.size();
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rL.get(i2).getVideoUrl() != null && rL.get(i2).getVideoUrl().endsWith("swf")) {
                    sb3.append(rL.get(i2).getVideoUrl());
                }
            }
            sb2.append(sb3.toString());
            if (!TextUtils.isEmpty(bjVar.g(sb2.toString(), true))) {
                SpannableString cE = bjVar.cE(sb2.toString());
                this.bLW.setOnTouchListener(new com.baidu.tieba.view.m(cE));
                this.bLW.setText(cE);
                this.bLW.setContentDescription(sb2.toString());
                this.bLW.setVisibility(0);
                m.a(this.bLW, bjVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bLW.setVisibility(8);
            }
        } else {
            this.bLW.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMc.getLayoutParams();
        if (layoutParams != null) {
            if (this.bLW.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bLV.getVisibility() == 8 && this.bMc.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mF.getResources().getDimension(d.f.ds56), 0, 0);
                this.bMc.setPadding(0, 0, 0, 0);
            } else if (this.bMc.xj()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bMc.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bMc.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cwN.T(this.ajE);
        ArrayList<VoiceData.VoiceModel> rP = bjVar.rP();
        if (com.baidu.tbadk.core.util.v.v(rP)) {
            this.bLV.setVisibility(8);
        } else {
            this.bLV.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLV.setVoiceModel(voiceModel);
            this.bLV.setTag(voiceModel);
            this.bLV.bhC();
            if (voiceModel != null) {
                this.bLV.nl(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oS().oY() && com.baidu.tbadk.core.util.v.u(rL) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rL, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !am.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                this.bLX.setVisibility(0);
                this.bLX.setFromCDN(this.aje);
                if (this.ajE.sx() != null) {
                    this.bLX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sx = e.this.ajE.sx();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                                return;
                            }
                            ax.aT(e.this.mContext);
                        }
                    });
                } else {
                    this.bLX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bj> XL = e.this.XL();
                            if (z) {
                                if (XL != null) {
                                    XL.aTB = true;
                                    XL.a(view, e.this.ajE);
                                }
                                e.this.Yc();
                                return;
                            }
                            if (XL != null) {
                                XL.aTB = false;
                                XL.a(view, e.this.ajE);
                            }
                            e.this.a(linkedList2, i4, bjVar);
                        }
                    });
                }
                this.bLX.setImageUrls(linkedList);
            } else {
                this.bLX.setVisibility(8);
            }
        } else {
            this.bLX.setVisibility(8);
        }
        if (this.cwT != null) {
            if (bjVar.rN() != null) {
                String ti = bjVar.rN().ti();
                if (!StringUtils.isNull(ti)) {
                    this.cwT.setVisibility(0);
                    this.cwT.c(ti, 10, true);
                } else {
                    this.cwT.setVisibility(8);
                }
            } else {
                this.cwT.setVisibility(8);
            }
        }
        if (this.csn != null) {
            if (bjVar.rO() != null) {
                String pw = bjVar.rO().pw();
                if (!StringUtils.isNull(pw)) {
                    String fixedText = am.getFixedText(pw, 20, true);
                    aj.j(this.csn, d.g.btn_red_frame_n);
                    aj.i(this.csn, d.e.cp_cont_h);
                    this.csn.setText(fixedText);
                    this.csn.setVisibility(0);
                } else {
                    this.csn.setVisibility(8);
                }
            } else {
                this.csn.setVisibility(8);
            }
        }
        Yb();
        b.a(this.ajE, this.bKR);
        K(bjVar);
    }

    public void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.crX != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rW = bjVar.rW();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aop.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.blC.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crX.setVisibility(8);
                if (this.blD != null) {
                    if (rW != null) {
                        this.blD.a(this.mF, rW, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rG(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds16);
                    } else {
                        this.blD.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.crX.setVisibility(0);
                this.crX.setImageBitmap(null);
                this.crX.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.crX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mF.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.blD.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds30);
            }
            this.aop.setLayoutParams(layoutParams);
            this.blC.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.mF.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aje ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.aje, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Yb() {
        this.bLV.setClickable(true);
        this.bMc.setBarNameClickEnabled(true);
        int childCount = this.bLX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bMc != null) {
            this.bMc.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajE != null) {
            m.ju(this.ajE.getId());
            m.a(this.mTitle, this.ajE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLW, this.ajE.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajE));
            n sx = this.ajE.sx();
            if (sx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aT(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.ajE.ZB;
            if (this.ajE.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UR;
                long j = kVar.US;
                aq aqVar = new aq();
                aqVar.pageContext = this.mF;
                aqVar.Vp = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.ajE.rO() != null) {
                if (ax.aU(this.mF.getPageActivity())) {
                    String postUrl = this.ajE.rO().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hz()) {
                        com.baidu.tbadk.browser.a.U(this.mF.getPageActivity(), postUrl);
                    }
                }
            } else {
                s.gR(this.ajE.getId());
                boolean z = this.ajE.getType() != bj.Yh;
                if (this.ajE.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btx()) {
                    createFromThreadCfg = new PbActivityConfig(this.mF.getPageActivity()).createHistoryCfg(this.ajE.getTid(), String.valueOf(this.ajE.rX()), false, z, m.rs());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajE, this.mForumName, m.rs(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajE.sE());
                    createFromThreadCfg.setSmartFrsPosition(this.ajE.sL());
                    createFromThreadCfg.setForumId(String.valueOf(this.ajE.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
