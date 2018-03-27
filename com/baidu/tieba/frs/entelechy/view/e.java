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
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bd> implements t {
    protected boolean aYZ;
    private bd aZC;
    private final View.OnClickListener bdG;
    public ClickableHeaderImageView bdO;
    public ViewStub bdQ;
    public TbImageView bdR;
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    public PlayVoiceBntNew cWT;
    protected TextView cWV;
    protected ConstrainImageGroup cWW;
    private final View.OnClickListener cWZ;
    public View cWi;
    private CardGroupDividerView cXn;
    public TbImageView cYN;
    private TbImageView cYP;
    public HeadPendantClickableView cmL;
    public LinearLayout cna;
    public ThreadSkinView cnb;
    private com.baidu.tieba.frs.g.g dLC;
    public ThreadCommentAndPraiseInfoLayout dLM;
    public UserIconLayout dLN;
    public RelativeLayout dLO;
    protected TbImageView dLP;
    protected TextView dLQ;
    private View.OnClickListener dLR;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aYZ = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aZC != null && e.this.aZC.zn() != null && e.this.aZC.zn().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", e.this.aZC.getId()));
                }
                if (e.this.aZC != null && e.this.aZC.yU()) {
                    TiebaStatic.log(new ak("c11663").s("obj_param1", 1).ab("post_id", e.this.aZC.getTid()));
                }
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZC);
                }
                e.this.alj();
            }
        };
        this.dLR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZC);
                }
                e.this.alj();
            }
        };
        this.cWZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akP = e.this.akP();
                if (akP != null) {
                    akP.a(view, e.this.aZC);
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZC);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZC);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.bdO = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bdO.setDefaultResource(17170445);
        this.bdO.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bdO.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.bdO.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bdQ = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.dLN = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.dLN.beZ = true;
        this.dLN.setEntelechyEnabled(true);
        this.dLN.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cWT = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cWT.setAfterClickListener(this.cWZ);
        this.cWT.setPlayTimeTextView(d.e.fontsize28);
        this.cYN = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYN.setPageId(getTag());
        this.cYP = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.cYP.setPageId(getTag());
        this.cWV = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cWV.setFocusable(true);
        this.cWW = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.cWW.setSingleImageRatio(0.75d);
        this.cWW.setImageMargin(dimensionPixelSize);
        this.cWW.setChildClickListener(this.dLR);
        this.dLM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dLM.setFrom(2);
        this.dLM.aQv = 3;
        this.cWi = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cna = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.dLO = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.dLP = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.dLP.setPageId(getTag());
        this.dLQ = (TextView) view.findViewById(d.g.app_code_btn);
        this.cnb = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.cXn = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cXn.setTitleClickListener(this.cVA);
        this.dLC = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLO);
        this.dLC.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWW != null) {
            this.cWW.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWW != null) {
            this.cWW.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.dLM;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0141d.cp_bg_line_d);
            aj.s(this.dLO, d.f.addresslist_item_bg);
            this.cWW.onChangeSkinType();
            this.dLN.onChangeSkinType();
            this.dLM.onChangeSkinType();
            if (this.cXn != null) {
                this.cXn.onChangeSkinType();
            }
            this.dLC.onChangeSkinType();
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
        this.aZC = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.dLO != null) {
                this.dLO.setOnClickListener(this.cVA);
                this.dLO.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.cVA);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.j.ks(this.aZC.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.aZC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cWV, this.aZC.getId(), d.C0141d.cp_cont_c, d.C0141d.cp_cont_d);
        }
        this.dLN.setVisibility(0);
        if (this.aZC.zn() != null && !StringUtils.isNull(this.aZC.zn().getSealPrefix())) {
            this.dLN.by(true);
        }
        if (this.aZC.zn() == null || this.aZC.zn().getPendantData() == null || StringUtils.isNull(this.aZC.zn().getPendantData().ya())) {
            UserTbVipInfoData zo = this.aZC.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.bdQ != null) {
                    if (this.bdR == null) {
                        this.bdQ.inflate();
                        this.bdR = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bdR.setVisibility(0);
                    this.bdR.startLoad(zo.getvipV_url(), 10, false);
                    this.bdO.setIsBigV(true);
                }
            } else {
                this.bdO.setIsBigV(false);
                if (this.bdR != null) {
                    this.bdR.setVisibility(8);
                }
            }
            this.cmL.setVisibility(8);
            this.bdO.setVisibility(0);
            this.bdO.setData(bdVar);
            this.bdO.setAfterClickListener(this.bdT);
        } else {
            this.bdO.setVisibility(4);
            this.bdO.setIsBigV(false);
            if (this.bdR != null) {
                this.bdR.setVisibility(8);
            }
            this.cmL.setVisibility(0);
            this.cmL.setData(bdVar);
        }
        this.dLN.setData(bdVar);
        this.dLN.setUserAfterClickListener(this.bdT);
        if (this.dLM.setData(bdVar)) {
            this.cWi.setVisibility(8);
        } else {
            this.cWi.setVisibility(0);
        }
        this.dLM.updataMoreView(this.mTbPageContext);
        this.dLM.setForumAfterClickListener(this.bdG);
        this.dLM.setStType("frs_page");
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.zl() == null || bdVar.zl().size() == 0)) || bdVar.zD() == 1) {
            bdVar.h(false, true);
            if (bdVar.zN() == null || StringUtils.isNull(bdVar.zN().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bdVar.zN());
            }
        } else {
            this.mTitle.setVisibility(0);
            bdVar.aOz = 0;
            bdVar.h(false, bdVar.Ah());
            SpannableStringBuilder zN = bdVar.zN();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(zN));
            this.mTitle.setText(zN);
            com.baidu.tieba.card.j.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
            sb.append(bdVar.getAbstract());
        }
        ArrayList<MediaData> zy = bdVar.zy();
        if (zy != null) {
            i = zy.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (zy.get(i2).getVideoUrl() != null && zy.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(zy.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bdVar.f(sb.toString(), true))) {
                SpannableString db = bdVar.db(sb.toString());
                this.cWV.setOnTouchListener(new com.baidu.tieba.view.m(db));
                this.cWV.setText(db);
                this.cWV.setContentDescription(sb.toString());
                this.cWV.setVisibility(0);
                com.baidu.tieba.card.j.a(this.cWV, bdVar.getId(), d.C0141d.cp_cont_c, d.C0141d.cp_cont_d);
            } else {
                this.cWV.setVisibility(8);
            }
        } else {
            this.cWV.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLM.getLayoutParams();
        if (layoutParams != null) {
            if (this.cWV.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.cWT.getVisibility() == 8 && this.dLM.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.dLM.setPadding(0, 0, 0, 0);
            } else if (this.dLM.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dLM.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dLM.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        K(bdVar);
        this.dLC.W(this.aZC);
        H(bdVar);
        ArrayList<VoiceData.VoiceModel> zC = bdVar.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWT.setVisibility(8);
        } else {
            this.cWT.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cWT.setVoiceModel(voiceModel);
            this.cWT.setTag(voiceModel);
            this.cWT.aNR();
            if (voiceModel != null) {
                this.cWT.of(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.i.xo().xu() && com.baidu.tbadk.core.util.v.D(zy) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.cWW.setVisibility(0);
                this.cWW.setFromCDN(this.aYZ);
                if (this.aZC.Ag() != null) {
                    this.cWW.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                com.baidu.tbadk.core.data.m Ag = e.this.aZC.Ag();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                                return;
                            }
                            ay.aZ(e.this.mContext);
                        }
                    });
                } else {
                    this.cWW.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            v<bd> akP = e.this.akP();
                            if (z) {
                                if (akP != null) {
                                    akP.bNF = true;
                                    akP.a(view, e.this.aZC);
                                }
                                e.this.alj();
                                return;
                            }
                            if (akP != null) {
                                akP.bNF = false;
                                akP.a(view, e.this.aZC);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.cWW.setImageMediaList(linkedList);
            } else {
                this.cWW.setVisibility(8);
            }
        } else {
            this.cWW.setVisibility(8);
        }
        if (this.dLP != null) {
            if (bdVar.zA() != null) {
                String AP = bdVar.zA().AP();
                if (!StringUtils.isNull(AP)) {
                    this.dLP.setVisibility(0);
                    this.dLP.startLoad(AP, 10, true);
                } else {
                    this.dLP.setVisibility(8);
                }
            } else {
                this.dLP.setVisibility(8);
            }
        }
        if (this.dLQ != null) {
            if (bdVar.zB() != null) {
                String xN = bdVar.zB().xN();
                if (!StringUtils.isNull(xN)) {
                    String fixedText = am.getFixedText(xN, 20, true);
                    aj.s(this.dLQ, d.f.btn_red_frame_n);
                    aj.r(this.dLQ, d.C0141d.cp_cont_h);
                    this.dLQ.setText(fixedText);
                    this.dLQ.setVisibility(0);
                } else {
                    this.dLQ.setVisibility(8);
                }
            } else {
                this.dLQ.setVisibility(8);
            }
        }
        ali();
        b.a(this.aZC, this.cXn);
        this.bdO.changeGrayScaleMode(bdVar.AC());
    }

    private void H(final bd bdVar) {
        if (this.cYP != null) {
            if (bdVar == null || StringUtils.isNull(bdVar.aQn)) {
                this.cYP.setVisibility(8);
            } else if (this.cYN == null || (this.cYN != null && this.cYN.getVisibility() != 0)) {
                if (this.dLC != null && this.dLC.aAv() && (this.cYP.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYP.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYP.setLayoutParams(layoutParams);
                }
                this.cYP.setVisibility(0);
                this.cYP.setImageDrawable(null);
                this.cYP.startLoad(bdVar.aQn, 10, false);
                this.cYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bdVar.aQo, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYP.setVisibility(8);
            }
        }
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYN != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            SkinInfo zJ = bdVar.zJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdO.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cna.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYN.setVisibility(8);
                if (this.cnb != null) {
                    if (zJ != null) {
                        this.cnb.a(this.mPageContext, zJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.zt(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cnb.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cYN.setVisibility(0);
                this.cYN.setImageBitmap(null);
                this.cYN.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cnb.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.bdO.setLayoutParams(layoutParams);
            this.cna.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.aYZ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYZ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void ali() {
        this.cWT.setClickable(true);
        this.dLM.setBarNameClickEnabled(true);
        int childCount = this.cWW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWW.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aYZ = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dLM != null) {
            this.dLM.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        PbActivityConfig createFromThreadCfg;
        if (this.aZC != null) {
            com.baidu.tieba.card.j.kr(this.aZC.getId());
            com.baidu.tieba.card.j.a(this.mTitle, this.aZC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cWV, this.aZC.getId(), d.C0141d.cp_cont_c, d.C0141d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aZC));
            com.baidu.tbadk.core.data.m Ag = this.aZC.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.aZC.aPJ;
            if (this.aZC.aPI == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLx;
                long j = jVar.aLy;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLL = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
            } else if (this.aZC.zB() != null) {
                if (ay.ba(this.mPageContext.getPageActivity())) {
                    String postUrl = this.aZC.zB().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.browser.b.S(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.t.hr(this.aZC.getId());
                boolean z = this.aZC.getType() != bd.aOk;
                if (this.aZC.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxX()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aZC.getTid(), String.valueOf(this.aZC.zK()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZC, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aZC.An());
                    createFromThreadCfg.setSmartFrsPosition(this.aZC.Au());
                    createFromThreadCfg.setForumId(String.valueOf(this.aZC.getFid()));
                    createFromThreadCfg.setStartFrom(3);
                    this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
