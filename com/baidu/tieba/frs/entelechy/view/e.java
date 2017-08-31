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
    private bj ajF;
    protected boolean ajf;
    private final View.OnClickListener aoe;
    public ClickableHeaderImageView aor;
    public ViewStub aot;
    public TbImageView aou;
    private final View.OnClickListener aow;
    public HeadPendantClickableView bJq;
    public View bJs;
    private View.OnClickListener bJw;
    private CardGroupDividerView bKa;
    public PlayVoiceBntNew bLe;
    protected TextView bLf;
    protected ConstrainImageGroup bLg;
    private final View.OnClickListener bLh;
    public ThreadCommentAndPraiseInfoLayout bLl;
    public UserIconLayout bLo;
    public LinearLayout blD;
    public ThreadSkinView blE;
    public TbImageView crf;
    protected TextView crv;
    private com.baidu.tieba.frs.h.g cvV;
    public RelativeLayout cwa;
    protected TbImageView cwb;
    private View.OnClickListener cwc;
    private int ds16;
    private int ds32;
    private TbPageContext<?> mF;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajf = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajF != null && e.this.ajF.getAuthor() != null && e.this.ajF.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", e.this.ajF.getId()));
                }
                if (e.this.ajF != null && e.this.ajF.rh()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ad("post_id", e.this.ajF.getTid()));
                }
                if (e.this.XA() != null) {
                    e.this.XA().a(view, e.this.ajF);
                }
                e.this.XR();
            }
        };
        this.cwc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XA() != null) {
                    e.this.XA().a(view, e.this.ajF);
                }
                e.this.XR();
            }
        };
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bj> XA = e.this.XA();
                if (XA != null) {
                    XA.a(view, e.this.ajF);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XA() != null) {
                    e.this.XA().a(view, e.this.ajF);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.XA() != null) {
                    e.this.XA().a(view, e.this.ajF);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.ds16 = (int) this.mF.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.mF.getResources().getDimension(d.f.ds32);
        this.aor = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bJq = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.aor.setDefaultResource(17170445);
        this.aor.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aor.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aor.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        this.aot = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.bLo = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bLo.apn = true;
        this.bLo.setEntelechyEnabled(true);
        this.bLo.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLe = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLe.setAfterClickListener(this.bLh);
        this.bLe.setPlayTimeTextView(d.f.fontsize28);
        this.crf = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.crf.setPageId(getTag());
        this.bLf = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLf.setFocusable(true);
        this.bLg = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bLg.setSingleImageRatio(0.75d);
        this.bLg.setImageMargin(dimensionPixelSize);
        this.bLg.setChildClickListener(this.cwc);
        this.bLl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bLl.setLocationEnabled(true);
        this.bLl.setViewNumEnabled(true);
        this.bLl.setCommentNumClickListener(this.bJw);
        this.bLl.setFrom(2);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        this.blD = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cwa = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cwb = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cwb.setPageId(getTag());
        this.crv = (TextView) view.findViewById(d.h.app_code_btn);
        this.blE = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bKa = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bKa.setTitleClickListener(this.bJw);
        this.cvV = new com.baidu.tieba.frs.h.g(this.mF, this.bLl);
        this.cvV.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLg != null) {
            this.bLg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLg != null) {
            this.bLg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.j(this.cwa, d.g.addresslist_item_bg);
            this.bLg.onChangeSkinType();
            this.bLo.onChangeSkinType();
            this.bLl.onChangeSkinType();
            if (this.bKa != null) {
                this.bKa.onChangeSkinType();
            }
            this.cvV.onChangeSkinType();
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
        this.ajF = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cwa != null) {
                this.cwa.setOnClickListener(this.bJw);
                this.cwa.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bJw);
                getView().setLongClickable(true);
            }
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (m.jt(this.ajF.getId())) {
            m.a(this.mTitle, this.ajF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.ajF.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bLo.setVisibility(0);
        if (this.ajF.getAuthor() != null && !StringUtils.isNull(this.ajF.getAuthor().getSealPrefix())) {
            this.bLo.aP(true);
        }
        if (this.ajF.getAuthor() == null || this.ajF.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajF.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rB = this.ajF.rB();
            if (rB != null && rB.getvipV_url() != null) {
                if (this.aot != null) {
                    if (this.aou == null) {
                        this.aot.inflate();
                        this.aou = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aou.setVisibility(0);
                    this.aou.c(rB.getvipV_url(), 10, false);
                    this.aor.setIsBigV(true);
                }
            } else {
                this.aor.setIsBigV(false);
                if (this.aou != null) {
                    this.aou.setVisibility(8);
                }
            }
            this.bJq.setVisibility(8);
            this.aor.setVisibility(0);
            this.aor.setData(bjVar);
            this.aor.setAfterClickListener(this.aow);
        } else {
            this.aor.setVisibility(4);
            this.aor.setIsBigV(false);
            if (this.aou != null) {
                this.aou.setVisibility(8);
            }
            this.bJq.setVisibility(0);
            this.bJq.setData(bjVar);
        }
        this.bLo.setData(bjVar);
        this.bLo.setUserAfterClickListener(this.aow);
        if (this.bLl.c(bjVar)) {
            this.bJs.setVisibility(8);
        } else {
            this.bJs.setVisibility(0);
        }
        this.bLl.f(this.mTbPageContext);
        this.bLl.setForumAfterClickListener(this.aoe);
        this.bLl.setStType(m.rs());
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
                this.bLf.setOnTouchListener(new com.baidu.tieba.view.m(cE));
                this.bLf.setText(cE);
                this.bLf.setContentDescription(sb2.toString());
                this.bLf.setVisibility(0);
                m.a(this.bLf, bjVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bLf.setVisibility(8);
            }
        } else {
            this.bLf.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLl.getLayoutParams();
        if (layoutParams != null) {
            if (this.bLf.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bLe.getVisibility() == 8 && this.bLl.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mF.getResources().getDimension(d.f.ds56), 0, 0);
                this.bLl.setPadding(0, 0, 0, 0);
            } else if (this.bLl.xj()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bLl.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bLl.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cvV.T(this.ajF);
        ArrayList<VoiceData.VoiceModel> rP = bjVar.rP();
        if (com.baidu.tbadk.core.util.v.v(rP)) {
            this.bLe.setVisibility(8);
        } else {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
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
                this.bLg.setVisibility(0);
                this.bLg.setFromCDN(this.ajf);
                if (this.ajF.sx() != null) {
                    this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sx = e.this.ajF.sx();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                                return;
                            }
                            ax.aS(e.this.mContext);
                        }
                    });
                } else {
                    this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bj> XA = e.this.XA();
                            if (z) {
                                if (XA != null) {
                                    XA.aTE = true;
                                    XA.a(view, e.this.ajF);
                                }
                                e.this.XR();
                                return;
                            }
                            if (XA != null) {
                                XA.aTE = false;
                                XA.a(view, e.this.ajF);
                            }
                            e.this.a(linkedList2, i4, bjVar);
                        }
                    });
                }
                this.bLg.setImageUrls(linkedList);
            } else {
                this.bLg.setVisibility(8);
            }
        } else {
            this.bLg.setVisibility(8);
        }
        if (this.cwb != null) {
            if (bjVar.rN() != null) {
                String ti = bjVar.rN().ti();
                if (!StringUtils.isNull(ti)) {
                    this.cwb.setVisibility(0);
                    this.cwb.c(ti, 10, true);
                } else {
                    this.cwb.setVisibility(8);
                }
            } else {
                this.cwb.setVisibility(8);
            }
        }
        if (this.crv != null) {
            if (bjVar.rO() != null) {
                String pw = bjVar.rO().pw();
                if (!StringUtils.isNull(pw)) {
                    String fixedText = am.getFixedText(pw, 20, true);
                    aj.j(this.crv, d.g.btn_red_frame_n);
                    aj.i(this.crv, d.e.cp_cont_h);
                    this.crv.setText(fixedText);
                    this.crv.setVisibility(0);
                } else {
                    this.crv.setVisibility(8);
                }
            } else {
                this.crv.setVisibility(8);
            }
        }
        XQ();
        b.a(this.ajF, this.bKa);
        K(bjVar);
    }

    public void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.crf != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rW = bjVar.rW();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aor.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.blD.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crf.setVisibility(8);
                if (this.blE != null) {
                    if (rW != null) {
                        this.blE.a(this.mF, rW, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rG(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds16);
                    } else {
                        this.blE.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.crf.setVisibility(0);
                this.crf.setImageBitmap(null);
                this.crf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.crf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mF.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.blE.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds30);
            }
            this.aor.setLayoutParams(layoutParams);
            this.blD.setLayoutParams(layoutParams2);
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
                    imageUrlData.urlType = this.ajf ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ajf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XQ() {
        this.bLe.setClickable(true);
        this.bLl.setBarNameClickEnabled(true);
        int childCount = this.bLg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLl != null) {
            this.bLl.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XR() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajF != null) {
            m.js(this.ajF.getId());
            m.a(this.mTitle, this.ajF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.ajF.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajF));
            n sx = this.ajF.sx();
            if (sx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.ajF.ZB;
            if (this.ajF.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UR;
                long j = kVar.US;
                aq aqVar = new aq();
                aqVar.pageContext = this.mF;
                aqVar.Vp = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.ajF.rO() != null) {
                if (ax.aT(this.mF.getPageActivity())) {
                    String postUrl = this.ajF.rO().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hz()) {
                        com.baidu.tbadk.browser.a.U(this.mF.getPageActivity(), postUrl);
                    }
                }
            } else {
                s.gR(this.ajF.getId());
                boolean z = this.ajF.getType() != bj.Yh;
                if (this.ajF.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btm()) {
                    createFromThreadCfg = new PbActivityConfig(this.mF.getPageActivity()).createHistoryCfg(this.ajF.getTid(), String.valueOf(this.ajF.rX()), false, z, m.rs());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajF, this.mForumName, m.rs(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajF.sE());
                    createFromThreadCfg.setSmartFrsPosition(this.ajF.sL());
                    createFromThreadCfg.setForumId(String.valueOf(this.ajF.getFid()));
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
