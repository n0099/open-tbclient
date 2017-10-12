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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tbadk.util.r;
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
    protected boolean aiG;
    private bh ajg;
    public ClickableHeaderImageView anE;
    public ViewStub anG;
    public TbImageView anH;
    private final View.OnClickListener anJ;
    private final View.OnClickListener anr;
    private View.OnClickListener bJA;
    public HeadPendantClickableView bJv;
    private CardGroupDividerView bKe;
    public View bKw;
    public UserIconLayout bLC;
    public PlayVoiceBntNew bLr;
    protected TextView bLt;
    protected ConstrainImageGroup bLu;
    private final View.OnClickListener bLv;
    public ThreadCommentAndPraiseInfoLayout bLz;
    public LinearLayout bnn;
    public ThreadSkinView bno;
    protected TextView csK;
    public TbImageView csu;
    private com.baidu.tieba.frs.h.g cxD;
    public RelativeLayout cxI;
    protected TbImageView cxJ;
    private View.OnClickListener cxK;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mG;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiG = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ajg != null && e.this.ajg.getAuthor() != null && e.this.ajg.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", e.this.ajg.getId()));
                }
                if (e.this.ajg != null && e.this.ajg.rb()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ad("post_id", e.this.ajg.getTid()));
                }
                if (e.this.Xr() != null) {
                    e.this.Xr().a(view, e.this.ajg);
                }
                e.this.XJ();
            }
        };
        this.cxK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xr() != null) {
                    e.this.Xr().a(view, e.this.ajg);
                }
                e.this.XJ();
            }
        };
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> Xr = e.this.Xr();
                if (Xr != null) {
                    Xr.a(view, e.this.ajg);
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xr() != null) {
                    e.this.Xr().a(view, e.this.ajg);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xr() != null) {
                    e.this.Xr().a(view, e.this.ajg);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mG = tbPageContext;
        this.ds16 = (int) this.mG.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.mG.getResources().getDimension(d.f.ds32);
        this.anE = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bJv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.anE.setDefaultResource(17170445);
        this.anE.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.anE.setDefaultBgResource(d.e.cp_bg_line_e);
        this.anE.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        this.anG = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.bLC = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bLC.aow = true;
        this.bLC.setEntelechyEnabled(true);
        this.bLC.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLr = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLr.setAfterClickListener(this.bLv);
        this.bLr.setPlayTimeTextView(d.f.fontsize28);
        this.csu = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.csu.setPageId(getTag());
        this.bLt = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLt.setFocusable(true);
        this.bLu = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bLu.setSingleImageRatio(0.75d);
        this.bLu.setImageMargin(dimensionPixelSize);
        this.bLu.setChildClickListener(this.cxK);
        this.bLz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bLz.setLocationEnabled(true);
        this.bLz.setViewNumEnabled(true);
        this.bLz.setCommentNumClickListener(this.bJA);
        this.bLz.setFrom(2);
        this.bKw = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bnn = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cxI = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cxJ = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cxJ.setPageId(getTag());
        this.csK = (TextView) view.findViewById(d.h.app_code_btn);
        this.bno = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bKe = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bKe.setTitleClickListener(this.bJA);
        this.cxD = new com.baidu.tieba.frs.h.g(this.mG, this.bLz);
        this.cxD.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLu != null) {
            this.bLu.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLu != null) {
            this.bLu.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.j(this.cxI, d.g.addresslist_item_bg);
            this.bLu.onChangeSkinType();
            this.bLC.onChangeSkinType();
            this.bLz.onChangeSkinType();
            if (this.bKe != null) {
                this.bKe.onChangeSkinType();
            }
            this.cxD.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img;
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
        this.ajg = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cxI != null) {
                this.cxI.setOnClickListener(this.bJA);
                this.cxI.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bJA);
                getView().setLongClickable(true);
            }
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        if (m.jn(this.ajg.getId())) {
            m.a(this.mTitle, this.ajg.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLt, this.ajg.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bLC.setVisibility(0);
        if (this.ajg.getAuthor() != null && !StringUtils.isNull(this.ajg.getAuthor().getSealPrefix())) {
            this.bLC.aO(true);
        }
        if (this.ajg.getAuthor() == null || this.ajg.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajg.getAuthor().getPendantData().pS())) {
            UserTbVipInfoData rv = this.ajg.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.anG != null) {
                    if (this.anH == null) {
                        this.anG.inflate();
                        this.anH = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.anH.setVisibility(0);
                    this.anH.c(rv.getvipV_url(), 10, false);
                    this.anE.setIsBigV(true);
                }
            } else {
                this.anE.setIsBigV(false);
                if (this.anH != null) {
                    this.anH.setVisibility(8);
                }
            }
            this.bJv.setVisibility(8);
            this.anE.setVisibility(0);
            this.anE.setData(bhVar);
            this.anE.setAfterClickListener(this.anJ);
        } else {
            this.anE.setVisibility(4);
            this.anE.setIsBigV(false);
            if (this.anH != null) {
                this.anH.setVisibility(8);
            }
            this.bJv.setVisibility(0);
            this.bJv.setData(bhVar);
        }
        this.bLC.setData(bhVar);
        this.bLC.setUserAfterClickListener(this.anJ);
        if (this.bLz.setData(bhVar)) {
            this.bKw.setVisibility(8);
        } else {
            this.bKw.setVisibility(0);
        }
        this.bLz.updataMoreView(this.mTbPageContext);
        this.bLz.setForumAfterClickListener(this.anr);
        this.bLz.setStType(m.rm());
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rt() == null || bhVar.rt().size() == 0)) || bhVar.rK() == 1) {
            bhVar.e(false, true);
            if (bhVar.rV() == null || StringUtils.isNull(bhVar.rV().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bhVar.rV());
            }
        } else {
            this.mTitle.setVisibility(0);
            bhVar.Yw = 0;
            bhVar.e(false, bhVar.ss());
            SpannableStringBuilder rV = bhVar.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(rV));
            this.mTitle.setText(rV);
            m.a(this.mTitle, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bhVar.rD() != null && !StringUtils.isNull(bhVar.rD())) {
            sb.append(bhVar.rD());
        }
        ArrayList<MediaData> rF = bhVar.rF();
        if (rF != null) {
            i = rF.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rF.get(i2).getVideoUrl() != null && rF.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rF.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                SpannableString cE = bhVar.cE(sb.toString());
                this.bLt.setOnTouchListener(new com.baidu.tieba.view.k(cE));
                this.bLt.setText(cE);
                this.bLt.setContentDescription(sb.toString());
                this.bLt.setVisibility(0);
                m.a(this.bLt, bhVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bLt.setVisibility(8);
            }
        } else {
            this.bLt.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLz.getLayoutParams();
        if (layoutParams != null) {
            if (this.bLt.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bLr.getVisibility() == 8 && this.bLz.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mG.getResources().getDimension(d.f.ds56), 0, 0);
                this.bLz.setPadding(0, 0, 0, 0);
            } else if (this.bLz.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bLz.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bLz.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cxD.O(this.ajg);
        ArrayList<VoiceData.VoiceModel> rJ = bhVar.rJ();
        if (com.baidu.tbadk.core.util.v.u(rJ)) {
            this.bLr.setVisibility(8);
        } else {
            this.bLr.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bLr.setVoiceModel(voiceModel);
            this.bLr.setTag(voiceModel);
            this.bLr.bgh();
            if (voiceModel != null) {
                this.bLr.nh(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.t(rF) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rF, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                this.bLu.setVisibility(0);
                this.bLu.setFromCDN(this.aiG);
                if (this.ajg.sr() != null) {
                    this.bLu.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sr = e.this.ajg.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mG.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                                return;
                            }
                            ax.aT(e.this.mContext);
                        }
                    });
                } else {
                    this.bLu.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bh> Xr = e.this.Xr();
                            if (z) {
                                if (Xr != null) {
                                    Xr.aUA = true;
                                    Xr.a(view, e.this.ajg);
                                }
                                e.this.XJ();
                                return;
                            }
                            if (Xr != null) {
                                Xr.aUA = false;
                                Xr.a(view, e.this.ajg);
                            }
                            e.this.a(view, linkedList, i4, bhVar);
                        }
                    });
                }
                this.bLu.setImageMediaList(linkedList);
            } else {
                this.bLu.setVisibility(8);
            }
        } else {
            this.bLu.setVisibility(8);
        }
        if (this.cxJ != null) {
            if (bhVar.rH() != null) {
                String tc = bhVar.rH().tc();
                if (!StringUtils.isNull(tc)) {
                    this.cxJ.setVisibility(0);
                    this.cxJ.c(tc, 10, true);
                } else {
                    this.cxJ.setVisibility(8);
                }
            } else {
                this.cxJ.setVisibility(8);
            }
        }
        if (this.csK != null) {
            if (bhVar.rI() != null) {
                String px = bhVar.rI().px();
                if (!StringUtils.isNull(px)) {
                    String fixedText = am.getFixedText(px, 20, true);
                    aj.j(this.csK, d.g.btn_red_frame_n);
                    aj.i(this.csK, d.e.cp_cont_h);
                    this.csK.setText(fixedText);
                    this.csK.setVisibility(0);
                } else {
                    this.csK.setVisibility(8);
                }
            } else {
                this.csK.setVisibility(8);
            }
        }
        XI();
        b.a(this.ajg, this.bKe);
        F(bhVar);
    }

    public void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.csu != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rQ = bhVar.rQ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anE.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bnn.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.csu.setVisibility(8);
                if (this.bno != null) {
                    if (rQ != null) {
                        this.bno.a(this.mG, rQ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rA(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds16);
                    } else {
                        this.bno.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.csu.setVisibility(0);
                this.csu.setImageBitmap(null);
                this.csu.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.csu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mG.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bno.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds30);
            }
            this.anE.setLayoutParams(layoutParams);
            this.bnn.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mG.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiG ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mG.getPageActivity()).createConfig(arrayList, i, bhVar.rA(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiG, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XI() {
        this.bLr.setClickable(true);
        this.bLz.setBarNameClickEnabled(true);
        int childCount = this.bLu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLu.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLz != null) {
            this.bLz.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        PbActivityConfig createFromThreadCfg;
        if (this.ajg != null) {
            m.jm(this.ajg.getId());
            m.a(this.mTitle, this.ajg.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLt, this.ajg.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajg));
            n sr = this.ajg.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aT(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mG.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.ajg.ZB;
            if (this.ajg.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Vf;
                long j = kVar.Vg;
                ao aoVar = new ao();
                aoVar.pageContext = this.mG;
                aoVar.VD = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
            } else if (this.ajg.rI() != null) {
                if (ax.aU(this.mG.getPageActivity())) {
                    String postUrl = this.ajg.rI().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.browser.a.U(this.mG.getPageActivity(), postUrl);
                    }
                }
            } else {
                r.gO(this.ajg.getId());
                boolean z = this.ajg.getType() != bh.Yi;
                if (this.ajg.rR() > 0 && com.baidu.tieba.tbadkCore.util.f.bsv()) {
                    createFromThreadCfg = new PbActivityConfig(this.mG.getPageActivity()).createHistoryCfg(this.ajg.getTid(), String.valueOf(this.ajg.rR()), false, z, m.rm());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mG.getPageActivity()).createFromThreadCfg(this.ajg, this.mForumName, m.rm(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.ajg.sy());
                    createFromThreadCfg.setSmartFrsPosition(this.ajg.sF());
                    createFromThreadCfg.setForumId(String.valueOf(this.ajg.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
