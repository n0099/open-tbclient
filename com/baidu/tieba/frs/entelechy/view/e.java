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
    private bd aZM;
    protected boolean aZj;
    private final View.OnClickListener bdQ;
    public ClickableHeaderImageView bdX;
    public ViewStub bdZ;
    public TbImageView bea;
    private final View.OnClickListener bec;
    private View.OnClickListener cVJ;
    public View cWr;
    public PlayVoiceBntNew cXc;
    protected TextView cXe;
    protected ConstrainImageGroup cXf;
    private final View.OnClickListener cXi;
    private CardGroupDividerView cXw;
    public TbImageView cYW;
    private TbImageView cYY;
    public HeadPendantClickableView cmU;
    public LinearLayout cnj;
    public ThreadSkinView cnk;
    private com.baidu.tieba.frs.g.g dLJ;
    public ThreadCommentAndPraiseInfoLayout dLT;
    public UserIconLayout dLU;
    public RelativeLayout dLV;
    protected TbImageView dLW;
    protected TextView dLX;
    private View.OnClickListener dLY;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aZj = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aZM != null && e.this.aZM.zn() != null && e.this.aZM.zn().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", e.this.aZM.getId()));
                }
                if (e.this.aZM != null && e.this.aZM.yU()) {
                    TiebaStatic.log(new ak("c11663").s("obj_param1", 1).ab("post_id", e.this.aZM.getTid()));
                }
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZM);
                }
                e.this.alj();
            }
        };
        this.dLY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZM);
                }
                e.this.alj();
            }
        };
        this.cXi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akP = e.this.akP();
                if (akP != null) {
                    akP.a(view, e.this.aZM);
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZM);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akP() != null) {
                    e.this.akP().a(view, e.this.aZM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.bdX = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bdX.setDefaultResource(17170445);
        this.bdX.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bdX.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.bdX.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bdZ = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.dLU = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.dLU.bfj = true;
        this.dLU.setEntelechyEnabled(true);
        this.dLU.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cXc = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cXc.setAfterClickListener(this.cXi);
        this.cXc.setPlayTimeTextView(d.e.fontsize28);
        this.cYW = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYW.setPageId(getTag());
        this.cYY = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.cYY.setPageId(getTag());
        this.cXe = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cXe.setFocusable(true);
        this.cXf = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.cXf.setSingleImageRatio(0.75d);
        this.cXf.setImageMargin(dimensionPixelSize);
        this.cXf.setChildClickListener(this.dLY);
        this.dLT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dLT.setFrom(2);
        this.dLT.aQE = 3;
        this.cWr = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cnj = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.dLV = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.dLW = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.dLW.setPageId(getTag());
        this.dLX = (TextView) view.findViewById(d.g.app_code_btn);
        this.cnk = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.cXw = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cXw.setTitleClickListener(this.cVJ);
        this.dLJ = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLV);
        this.dLJ.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cXf != null) {
            this.cXf.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXf != null) {
            this.cXf.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.dLT;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0140d.cp_bg_line_d);
            aj.s(this.dLV, d.f.addresslist_item_bg);
            this.cXf.onChangeSkinType();
            this.dLU.onChangeSkinType();
            this.dLT.onChangeSkinType();
            if (this.cXw != null) {
                this.cXw.onChangeSkinType();
            }
            this.dLJ.onChangeSkinType();
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
        this.aZM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.dLV != null) {
                this.dLV.setOnClickListener(this.cVJ);
                this.dLV.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.cVJ);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.j.ks(this.aZM.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.aZM.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cXe, this.aZM.getId(), d.C0140d.cp_cont_c, d.C0140d.cp_cont_d);
        }
        this.dLU.setVisibility(0);
        if (this.aZM.zn() != null && !StringUtils.isNull(this.aZM.zn().getSealPrefix())) {
            this.dLU.by(true);
        }
        if (this.aZM.zn() == null || this.aZM.zn().getPendantData() == null || StringUtils.isNull(this.aZM.zn().getPendantData().ya())) {
            UserTbVipInfoData zo = this.aZM.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.bdZ != null) {
                    if (this.bea == null) {
                        this.bdZ.inflate();
                        this.bea = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bea.setVisibility(0);
                    this.bea.startLoad(zo.getvipV_url(), 10, false);
                    this.bdX.setIsBigV(true);
                }
            } else {
                this.bdX.setIsBigV(false);
                if (this.bea != null) {
                    this.bea.setVisibility(8);
                }
            }
            this.cmU.setVisibility(8);
            this.bdX.setVisibility(0);
            this.bdX.setData(bdVar);
            this.bdX.setAfterClickListener(this.bec);
        } else {
            this.bdX.setVisibility(4);
            this.bdX.setIsBigV(false);
            if (this.bea != null) {
                this.bea.setVisibility(8);
            }
            this.cmU.setVisibility(0);
            this.cmU.setData(bdVar);
        }
        this.dLU.setData(bdVar);
        this.dLU.setUserAfterClickListener(this.bec);
        if (this.dLT.setData(bdVar)) {
            this.cWr.setVisibility(8);
        } else {
            this.cWr.setVisibility(0);
        }
        this.dLT.updataMoreView(this.mTbPageContext);
        this.dLT.setForumAfterClickListener(this.bdQ);
        this.dLT.setStType("frs_page");
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
            bdVar.aOJ = 0;
            bdVar.h(false, bdVar.Ah());
            SpannableStringBuilder zN = bdVar.zN();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(zN));
            this.mTitle.setText(zN);
            com.baidu.tieba.card.j.a(this.mTitle, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
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
            if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                SpannableString db = bdVar.db(sb.toString());
                this.cXe.setOnTouchListener(new com.baidu.tieba.view.m(db));
                this.cXe.setText(db);
                this.cXe.setContentDescription(sb.toString());
                this.cXe.setVisibility(0);
                com.baidu.tieba.card.j.a(this.cXe, bdVar.getId(), d.C0140d.cp_cont_c, d.C0140d.cp_cont_d);
            } else {
                this.cXe.setVisibility(8);
            }
        } else {
            this.cXe.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLT.getLayoutParams();
        if (layoutParams != null) {
            if (this.cXe.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.cXc.getVisibility() == 8 && this.dLT.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.dLT.setPadding(0, 0, 0, 0);
            } else if (this.dLT.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dLT.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dLT.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        K(bdVar);
        this.dLJ.W(this.aZM);
        H(bdVar);
        ArrayList<VoiceData.VoiceModel> zC = bdVar.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cXc.setVisibility(8);
        } else {
            this.cXc.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cXc.setVoiceModel(voiceModel);
            this.cXc.setTag(voiceModel);
            this.cXc.aNR();
            if (voiceModel != null) {
                this.cXc.qG(voiceModel.voice_status.intValue());
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
                this.cXf.setVisibility(0);
                this.cXf.setFromCDN(this.aZj);
                if (this.aZM.Ag() != null) {
                    this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                com.baidu.tbadk.core.data.m Ag = e.this.aZM.Ag();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                                return;
                            }
                            ay.aZ(e.this.mContext);
                        }
                    });
                } else {
                    this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            v<bd> akP = e.this.akP();
                            if (z) {
                                if (akP != null) {
                                    akP.bNP = true;
                                    akP.a(view, e.this.aZM);
                                }
                                e.this.alj();
                                return;
                            }
                            if (akP != null) {
                                akP.bNP = false;
                                akP.a(view, e.this.aZM);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.cXf.setImageMediaList(linkedList);
            } else {
                this.cXf.setVisibility(8);
            }
        } else {
            this.cXf.setVisibility(8);
        }
        if (this.dLW != null) {
            if (bdVar.zA() != null) {
                String AO = bdVar.zA().AO();
                if (!StringUtils.isNull(AO)) {
                    this.dLW.setVisibility(0);
                    this.dLW.startLoad(AO, 10, true);
                } else {
                    this.dLW.setVisibility(8);
                }
            } else {
                this.dLW.setVisibility(8);
            }
        }
        if (this.dLX != null) {
            if (bdVar.zB() != null) {
                String xN = bdVar.zB().xN();
                if (!StringUtils.isNull(xN)) {
                    String fixedText = am.getFixedText(xN, 20, true);
                    aj.s(this.dLX, d.f.btn_red_frame_n);
                    aj.r(this.dLX, d.C0140d.cp_cont_h);
                    this.dLX.setText(fixedText);
                    this.dLX.setVisibility(0);
                } else {
                    this.dLX.setVisibility(8);
                }
            } else {
                this.dLX.setVisibility(8);
            }
        }
        ali();
        b.a(this.aZM, this.cXw);
    }

    private void H(final bd bdVar) {
        if (this.cYY != null) {
            if (bdVar == null || StringUtils.isNull(bdVar.aQx)) {
                this.cYY.setVisibility(8);
            } else if (this.cYW == null || (this.cYW != null && this.cYW.getVisibility() != 0)) {
                if (this.dLJ != null && this.dLJ.aAu() && (this.cYY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYY.setLayoutParams(layoutParams);
                }
                this.cYY.setVisibility(0);
                this.cYY.setImageDrawable(null);
                this.cYY.startLoad(bdVar.aQx, 10, false);
                this.cYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bdVar.aQy, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYY.setVisibility(8);
            }
        }
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYW != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            SkinInfo zJ = bdVar.zJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdX.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cnj.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYW.setVisibility(8);
                if (this.cnk != null) {
                    if (zJ != null) {
                        this.cnk.a(this.mPageContext, zJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.zt(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cnk.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cYW.setVisibility(0);
                this.cYW.setImageBitmap(null);
                this.cYW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cnk.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.bdX.setLayoutParams(layoutParams);
            this.cnj.setLayoutParams(layoutParams2);
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
                    imageUrlData.urlType = this.aZj ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aZj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void ali() {
        this.cXc.setClickable(true);
        this.dLT.setBarNameClickEnabled(true);
        int childCount = this.cXf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXf.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aZj = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dLT != null) {
            this.dLT.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        PbActivityConfig createFromThreadCfg;
        if (this.aZM != null) {
            com.baidu.tieba.card.j.kr(this.aZM.getId());
            com.baidu.tieba.card.j.a(this.mTitle, this.aZM.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cXe, this.aZM.getId(), d.C0140d.cp_cont_c, d.C0140d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aZM));
            com.baidu.tbadk.core.data.m Ag = this.aZM.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.aZM.aPT;
            if (this.aZM.aPS == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLH;
                long j = jVar.aLI;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLV = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
            } else if (this.aZM.zB() != null) {
                if (ay.ba(this.mPageContext.getPageActivity())) {
                    String postUrl = this.aZM.zB().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.browser.b.S(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.t.hr(this.aZM.getId());
                boolean z = this.aZM.getType() != bd.aOu;
                if (this.aZM.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxT()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aZM.getTid(), String.valueOf(this.aZM.zK()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZM, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aZM.An());
                    createFromThreadCfg.setSmartFrsPosition(this.aZM.Au());
                    createFromThreadCfg.setForumId(String.valueOf(this.aZM.getFid()));
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
