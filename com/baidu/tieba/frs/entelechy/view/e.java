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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
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
public class e extends com.baidu.tieba.card.a<bl> implements v {
    protected boolean ajL;
    private bl akl;
    private final View.OnClickListener aoH;
    public ClickableHeaderImageView aoS;
    public ViewStub aoU;
    public TbImageView aoV;
    private final View.OnClickListener aoX;
    private View.OnClickListener bGB;
    public HeadPendantClickableView bGv;
    public View bGx;
    private CardGroupDividerView bHg;
    public PlayVoiceBntNew bIj;
    protected TextView bIk;
    protected ConstrainImageGroup bIl;
    private final View.OnClickListener bIm;
    public ThreadCommentAndPraiseInfoLayout bIq;
    public UserIconLayout bIt;
    public LinearLayout blh;
    public ThreadSkinView bli;
    public TbImageView clJ;
    protected TextView clZ;
    private com.baidu.tieba.frs.g.g cpp;
    public RelativeLayout cpu;
    protected TbImageView cpv;
    private View.OnClickListener cpw;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oV;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajL = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akl != null && e.this.akl.getAuthor() != null && e.this.akl.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", e.this.akl.getId()));
                }
                if (e.this.akl != null && e.this.akl.rm()) {
                    TiebaStatic.log(new aj("c11663").r("obj_param1", 1).aa("post_id", e.this.akl.getTid()));
                }
                if (e.this.WA() != null) {
                    e.this.WA().a(view, e.this.akl);
                }
                e.this.WQ();
            }
        };
        this.cpw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.WA() != null) {
                    e.this.WA().a(view, e.this.akl);
                }
                e.this.WQ();
            }
        };
        this.bIm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> WA = e.this.WA();
                if (WA != null) {
                    WA.a(view, e.this.akl);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.WA() != null) {
                    e.this.WA().a(view, e.this.akl);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.WA() != null) {
                    e.this.WA().a(view, e.this.akl);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.oV = tbPageContext;
        this.ds16 = (int) this.oV.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.oV.getResources().getDimension(d.f.ds32);
        this.aoS = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bGv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.aoS.setDefaultResource(17170445);
        this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aoS.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        this.aoU = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.bIt = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bIt.apJ = true;
        this.bIt.setEntelechyEnabled(true);
        this.bIt.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIj = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIj.setAfterClickListener(this.bIm);
        this.bIj.setPlayTimeTextView(d.f.fontsize28);
        this.clJ = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.clJ.setPageId(getTag());
        this.bIk = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIk.setFocusable(true);
        this.bIl = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bIl.setSingleImageRatio(0.75d);
        this.bIl.setImageMargin(dimensionPixelSize);
        this.bIl.setChildClickListener(this.cpw);
        this.bIq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bIq.setLocationEnabled(true);
        this.bIq.setViewNumEnabled(true);
        this.bIq.setCommentNumClickListener(this.bGB);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
        this.blh = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cpu = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cpv = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cpv.setPageId(getTag());
        this.clZ = (TextView) view.findViewById(d.h.app_code_btn);
        this.bli = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bHg = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bHg.setTitleClickListener(this.bGB);
        this.cpp = new com.baidu.tieba.frs.g.g(this.oV, this.bIq);
        this.cpp.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIl != null) {
            this.bIl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIl != null) {
            this.bIl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.j(this.cpu, d.g.addresslist_item_bg);
            this.bIl.onChangeSkinType();
            this.bIt.onChangeSkinType();
            this.bIq.onChangeSkinType();
            if (this.bHg != null) {
                this.bHg.onChangeSkinType();
            }
            this.cpp.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(final bl blVar) {
        int i;
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.akl = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cpu != null) {
                this.cpu.setOnClickListener(this.bGB);
                this.cpu.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bGB);
                getView().setLongClickable(true);
            }
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        if (m.jf(this.akl.getId())) {
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIk, this.akl.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bIt.setVisibility(0);
        if (this.akl.getAuthor() != null && !StringUtils.isNull(this.akl.getAuthor().getSealPrefix())) {
            this.bIt.aP(true);
        }
        if (this.akl.getAuthor() == null || this.akl.getAuthor().getPendantData() == null || StringUtils.isNull(this.akl.getAuthor().getPendantData().pV())) {
            UserTbVipInfoData rF = this.akl.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.aoU != null) {
                    if (this.aoV == null) {
                        this.aoU.inflate();
                        this.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aoV.setVisibility(0);
                    this.aoV.c(rF.getvipV_url(), 10, false);
                    this.aoS.setIsBigV(true);
                }
            } else {
                this.aoS.setIsBigV(false);
                if (this.aoV != null) {
                    this.aoV.setVisibility(8);
                }
            }
            this.bGv.setVisibility(8);
            this.aoS.setVisibility(0);
            this.aoS.setData(blVar);
            this.aoS.setAfterClickListener(this.aoX);
        } else {
            this.aoS.setVisibility(4);
            this.aoS.setIsBigV(false);
            if (this.aoV != null) {
                this.aoV.setVisibility(8);
            }
            this.bGv.setVisibility(0);
            this.bGv.setData(blVar);
        }
        this.bIt.setData(blVar);
        this.bIt.setUserAfterClickListener(this.aoX);
        if (this.bIq.a(blVar)) {
            this.bGx.setVisibility(8);
        } else {
            this.bGx.setVisibility(0);
        }
        this.bIq.f(this.mTbPageContext);
        this.bIq.setForumAfterClickListener(this.aoH);
        this.bIq.setStType(m.rw());
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rD() == null || blVar.rD().size() == 0)) || blVar.rU() == 1) {
            blVar.e(false, true);
            if (blVar.sf() == null || StringUtils.isNull(blVar.sf().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(blVar.sf());
            }
        } else {
            this.mTitle.setVisibility(0);
            blVar.Zq = 0;
            blVar.e(false, blVar.sC());
            SpannableStringBuilder sf = blVar.sf();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sf));
            this.mTitle.setText(sf);
            m.a(this.mTitle, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rN() != null && !StringUtils.isNull(blVar.rN())) {
            sb.append(blVar.rN());
        }
        ArrayList<MediaData> rP = blVar.rP();
        if (rP != null) {
            i = rP.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rP.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cL = blVar.cL(sb.toString());
                this.bIk.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                this.bIk.setText(cL);
                this.bIk.setContentDescription(sb.toString());
                this.bIk.setVisibility(0);
                m.a(this.bIk, blVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bIk.setVisibility(8);
            }
        } else {
            this.bIk.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIq.getLayoutParams();
        if (layoutParams != null) {
            if (this.bIk.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bIj.getVisibility() == 8 && this.bIq.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.oV.getResources().getDimension(d.f.ds56), 0, 0);
                this.bIq.setPadding(0, 0, 0, 0);
            } else if (this.bIq.xh()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bIq.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bIq.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cpp.P(this.akl);
        ArrayList<VoiceData.VoiceModel> rT = blVar.rT();
        if (u.v(rT)) {
            this.bIj.setVisibility(8);
        } else {
            this.bIj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bIj.setVoiceModel(voiceModel);
            this.bIj.setTag(voiceModel);
            this.bIj.bix();
            if (voiceModel != null) {
                this.bIj.mQ(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oX().pd() && u.u(rP) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) u.c(rP, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !al.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (u.u(linkedList) > 0) {
                this.bIl.setVisibility(0);
                this.bIl.setFromCDN(this.ajL);
                if (this.akl.sB() != null) {
                    this.bIl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sB = e.this.akl.sB();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.oV.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                                return;
                            }
                            aw.aN(e.this.mContext);
                        }
                    });
                } else {
                    this.bIl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bl> WA = e.this.WA();
                            if (z) {
                                if (WA != null) {
                                    WA.aTT = true;
                                    WA.a(view, e.this.akl);
                                }
                                e.this.WQ();
                                return;
                            }
                            if (WA != null) {
                                WA.aTT = false;
                                WA.a(view, e.this.akl);
                            }
                            e.this.a(linkedList2, i4, blVar);
                        }
                    });
                }
                this.bIl.setImageUrls(linkedList);
            } else {
                this.bIl.setVisibility(8);
            }
        } else {
            this.bIl.setVisibility(8);
        }
        if (this.cpv != null) {
            if (blVar.rR() != null) {
                String tl = blVar.rR().tl();
                if (!StringUtils.isNull(tl)) {
                    this.cpv.setVisibility(0);
                    this.cpv.c(tl, 10, true);
                } else {
                    this.cpv.setVisibility(8);
                }
            } else {
                this.cpv.setVisibility(8);
            }
        }
        if (this.clZ != null) {
            if (blVar.rS() != null) {
                String pB = blVar.rS().pB();
                if (!StringUtils.isNull(pB)) {
                    String fixedText = al.getFixedText(pB, 20, true);
                    ai.j(this.clZ, d.g.btn_red_frame_n);
                    ai.i(this.clZ, d.e.cp_cont_h);
                    this.clZ.setText(fixedText);
                    this.clZ.setVisibility(0);
                } else {
                    this.clZ.setVisibility(8);
                }
            } else {
                this.clZ.setVisibility(8);
            }
        }
        WP();
        b.a(this.akl, this.bHg);
        G(blVar);
    }

    public void G(bl blVar) {
        MetaData author;
        if (blVar != null && this.clJ != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sa = blVar.sa();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoS.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.blh.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.clJ.setVisibility(8);
                if (this.bli != null) {
                    if (sa != null) {
                        this.bli.a(this.oV, sa, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rK(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds16);
                    } else {
                        this.bli.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.clJ.setVisibility(0);
                this.clJ.setImageBitmap(null);
                this.clJ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.clJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.oV.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bli.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds30);
            }
            this.aoS.setLayoutParams(layoutParams);
            this.blh.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.oV.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajL ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oV.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WP() {
        this.bIj.setClickable(true);
        this.bIq.setBarNameClickEnabled(true);
        int childCount = this.bIl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bIq != null) {
            this.bIq.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        PbActivityConfig createFromThreadCfg;
        if (this.akl != null) {
            m.je(this.akl.getId());
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIk, this.akl.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.akl));
            n sB = this.akl.sB();
            if (sB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.oV.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.akl.aax;
            if (this.akl.aaw == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VN;
                long j = kVar.VO;
                aq aqVar = new aq();
                aqVar.pageContext = this.oV;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.akl.rS() != null) {
                if (aw.aO(this.oV.getPageActivity())) {
                    String postUrl = this.akl.rS().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hI()) {
                        com.baidu.tbadk.browser.a.U(this.oV.getPageActivity(), postUrl);
                    }
                }
            } else {
                s.gS(this.akl.getId());
                boolean z = this.akl.getType() != bl.Zc;
                if (this.akl.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.bue()) {
                    createFromThreadCfg = new PbActivityConfig(this.oV.getPageActivity()).createHistoryCfg(this.akl.getTid(), String.valueOf(this.akl.sb()), false, z, m.rw());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.oV.getPageActivity()).createFromThreadCfg(this.akl, this.mForumName, m.rw(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.akl.sI());
                    createFromThreadCfg.setSmartFrsPosition(this.akl.sP());
                    createFromThreadCfg.setForumId(String.valueOf(this.akl.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
