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
    private View.OnClickListener bGC;
    public HeadPendantClickableView bGw;
    public View bGy;
    private CardGroupDividerView bHh;
    public PlayVoiceBntNew bIk;
    protected TextView bIl;
    protected ConstrainImageGroup bIm;
    private final View.OnClickListener bIn;
    public ThreadCommentAndPraiseInfoLayout bIr;
    public UserIconLayout bIu;
    public LinearLayout bli;
    public ThreadSkinView blj;
    public TbImageView clK;
    protected TextView cma;
    private com.baidu.tieba.frs.g.g cpq;
    public RelativeLayout cpv;
    protected TbImageView cpw;
    private View.OnClickListener cpx;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajL = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akl != null && e.this.akl.getAuthor() != null && e.this.akl.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", e.this.akl.getId()));
                }
                if (e.this.akl != null && e.this.akl.rn()) {
                    TiebaStatic.log(new aj("c11663").r("obj_param1", 1).aa("post_id", e.this.akl.getTid()));
                }
                if (e.this.Wx() != null) {
                    e.this.Wx().a(view, e.this.akl);
                }
                e.this.WN();
            }
        };
        this.cpx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Wx() != null) {
                    e.this.Wx().a(view, e.this.akl);
                }
                e.this.WN();
            }
        };
        this.bIn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> Wx = e.this.Wx();
                if (Wx != null) {
                    Wx.a(view, e.this.akl);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Wx() != null) {
                    e.this.Wx().a(view, e.this.akl);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Wx() != null) {
                    e.this.Wx().a(view, e.this.akl);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.oW = tbPageContext;
        this.ds16 = (int) this.oW.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.oW.getResources().getDimension(d.f.ds32);
        this.aoS = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.aoS.setDefaultResource(17170445);
        this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aoS.setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        this.aoU = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.bIu = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bIu.apJ = true;
        this.bIu.setEntelechyEnabled(true);
        this.bIu.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIk = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIk.setAfterClickListener(this.bIn);
        this.bIk.setPlayTimeTextView(d.f.fontsize28);
        this.clK = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.clK.setPageId(getTag());
        this.bIl = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIl.setFocusable(true);
        this.bIm = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bIm.setSingleImageRatio(0.75d);
        this.bIm.setImageMargin(dimensionPixelSize);
        this.bIm.setChildClickListener(this.cpx);
        this.bIr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bIr.setLocationEnabled(true);
        this.bIr.setViewNumEnabled(true);
        this.bIr.setCommentNumClickListener(this.bGC);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bli = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cpv = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cpw = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cpw.setPageId(getTag());
        this.cma = (TextView) view.findViewById(d.h.app_code_btn);
        this.blj = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bHh = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bHh.setTitleClickListener(this.bGC);
        this.cpq = new com.baidu.tieba.frs.g.g(this.oW, this.bIr);
        this.cpq.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIm != null) {
            this.bIm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIm != null) {
            this.bIm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.j(this.cpv, d.g.addresslist_item_bg);
            this.bIm.onChangeSkinType();
            this.bIu.onChangeSkinType();
            this.bIr.onChangeSkinType();
            if (this.bHh != null) {
                this.bHh.onChangeSkinType();
            }
            this.cpq.onChangeSkinType();
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
            if (this.cpv != null) {
                this.cpv.setOnClickListener(this.bGC);
                this.cpv.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bGC);
                getView().setLongClickable(true);
            }
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        if (m.ji(this.akl.getId())) {
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.akl.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bIu.setVisibility(0);
        if (this.akl.getAuthor() != null && !StringUtils.isNull(this.akl.getAuthor().getSealPrefix())) {
            this.bIu.aP(true);
        }
        if (this.akl.getAuthor() == null || this.akl.getAuthor().getPendantData() == null || StringUtils.isNull(this.akl.getAuthor().getPendantData().pW())) {
            UserTbVipInfoData rG = this.akl.rG();
            if (rG != null && rG.getvipV_url() != null) {
                if (this.aoU != null) {
                    if (this.aoV == null) {
                        this.aoU.inflate();
                        this.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aoV.setVisibility(0);
                    this.aoV.c(rG.getvipV_url(), 10, false);
                    this.aoS.setIsBigV(true);
                }
            } else {
                this.aoS.setIsBigV(false);
                if (this.aoV != null) {
                    this.aoV.setVisibility(8);
                }
            }
            this.bGw.setVisibility(8);
            this.aoS.setVisibility(0);
            this.aoS.setData(blVar);
            this.aoS.setAfterClickListener(this.aoX);
        } else {
            this.aoS.setVisibility(4);
            this.aoS.setIsBigV(false);
            if (this.aoV != null) {
                this.aoV.setVisibility(8);
            }
            this.bGw.setVisibility(0);
            this.bGw.setData(blVar);
        }
        this.bIu.setData(blVar);
        this.bIu.setUserAfterClickListener(this.aoX);
        if (this.bIr.a(blVar)) {
            this.bGy.setVisibility(8);
        } else {
            this.bGy.setVisibility(0);
        }
        this.bIr.f(this.mTbPageContext);
        this.bIr.setForumAfterClickListener(this.aoH);
        this.bIr.setStType(m.rx());
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rE() == null || blVar.rE().size() == 0)) || blVar.rV() == 1) {
            blVar.e(false, true);
            if (blVar.sg() == null || StringUtils.isNull(blVar.sg().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(blVar.sg());
            }
        } else {
            this.mTitle.setVisibility(0);
            blVar.Zr = 0;
            blVar.e(false, blVar.sD());
            SpannableStringBuilder sg = blVar.sg();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sg));
            this.mTitle.setText(sg);
            m.a(this.mTitle, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rO() != null && !StringUtils.isNull(blVar.rO())) {
            sb.append(blVar.rO());
        }
        ArrayList<MediaData> rQ = blVar.rQ();
        if (rQ != null) {
            i = rQ.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rQ.get(i2).getVideoUrl() != null && rQ.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rQ.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cO = blVar.cO(sb.toString());
                this.bIl.setOnTouchListener(new com.baidu.tieba.view.l(cO));
                this.bIl.setText(cO);
                this.bIl.setContentDescription(sb.toString());
                this.bIl.setVisibility(0);
                m.a(this.bIl, blVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bIl.setVisibility(8);
            }
        } else {
            this.bIl.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIr.getLayoutParams();
        if (layoutParams != null) {
            if (this.bIl.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bIk.getVisibility() == 8 && this.bIr.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.oW.getResources().getDimension(d.f.ds56), 0, 0);
                this.bIr.setPadding(0, 0, 0, 0);
            } else if (this.bIr.xh()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bIr.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bIr.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cpq.P(this.akl);
        ArrayList<VoiceData.VoiceModel> rU = blVar.rU();
        if (u.v(rU)) {
            this.bIk.setVisibility(8);
        } else {
            this.bIk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rU.get(0);
            this.bIk.setVoiceModel(voiceModel);
            this.bIk.setTag(voiceModel);
            this.bIk.bis();
            if (voiceModel != null) {
                this.bIk.mQ(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oY().pe() && u.u(rQ) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) u.c(rQ, i3);
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
                this.bIm.setVisibility(0);
                this.bIm.setFromCDN(this.ajL);
                if (this.akl.sC() != null) {
                    this.bIm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sC = e.this.akl.sC();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.oW.getPageActivity(), sC.getCartoonId(), sC.getChapterId(), 2)));
                                return;
                            }
                            aw.aN(e.this.mContext);
                        }
                    });
                } else {
                    this.bIm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bl> Wx = e.this.Wx();
                            if (z) {
                                if (Wx != null) {
                                    Wx.aTU = true;
                                    Wx.a(view, e.this.akl);
                                }
                                e.this.WN();
                                return;
                            }
                            if (Wx != null) {
                                Wx.aTU = false;
                                Wx.a(view, e.this.akl);
                            }
                            e.this.a(linkedList2, i4, blVar);
                        }
                    });
                }
                this.bIm.setImageUrls(linkedList);
            } else {
                this.bIm.setVisibility(8);
            }
        } else {
            this.bIm.setVisibility(8);
        }
        if (this.cpw != null) {
            if (blVar.rS() != null) {
                String tm = blVar.rS().tm();
                if (!StringUtils.isNull(tm)) {
                    this.cpw.setVisibility(0);
                    this.cpw.c(tm, 10, true);
                } else {
                    this.cpw.setVisibility(8);
                }
            } else {
                this.cpw.setVisibility(8);
            }
        }
        if (this.cma != null) {
            if (blVar.rT() != null) {
                String pC = blVar.rT().pC();
                if (!StringUtils.isNull(pC)) {
                    String fixedText = al.getFixedText(pC, 20, true);
                    ai.j(this.cma, d.g.btn_red_frame_n);
                    ai.i(this.cma, d.e.cp_cont_h);
                    this.cma.setText(fixedText);
                    this.cma.setVisibility(0);
                } else {
                    this.cma.setVisibility(8);
                }
            } else {
                this.cma.setVisibility(8);
            }
        }
        WM();
        b.a(this.akl, this.bHh);
        G(blVar);
    }

    public void G(bl blVar) {
        MetaData author;
        if (blVar != null && this.clK != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sb = blVar.sb();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoS.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bli.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.clK.setVisibility(8);
                if (this.blj != null) {
                    if (sb != null) {
                        this.blj.a(this.oW, sb, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rL(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds16);
                    } else {
                        this.blj.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.clK.setVisibility(0);
                this.clK.setImageBitmap(null);
                this.clK.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.clK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.oW.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.blj.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds30);
            }
            this.aoS.setLayoutParams(layoutParams);
            this.bli.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.oW.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oW.getPageActivity()).createConfig(arrayList, i, blVar.rL(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WM() {
        this.bIk.setClickable(true);
        this.bIr.setBarNameClickEnabled(true);
        int childCount = this.bIm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIm.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bIr != null) {
            this.bIr.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        PbActivityConfig createFromThreadCfg;
        if (this.akl != null) {
            m.jh(this.akl.getId());
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.akl.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.akl));
            n sC = this.akl.sC();
            if (sC != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.oW.getPageActivity(), sC.getCartoonId(), sC.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.akl.aax;
            if (this.akl.aaw == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VO;
                long j = kVar.VP;
                aq aqVar = new aq();
                aqVar.pageContext = this.oW;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.akl.rT() != null) {
                if (aw.aO(this.oW.getPageActivity())) {
                    String postUrl = this.akl.rT().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hI()) {
                        com.baidu.tbadk.browser.a.U(this.oW.getPageActivity(), postUrl);
                    }
                }
            } else {
                s.gV(this.akl.getId());
                boolean z = this.akl.getType() != bl.Zd;
                if (this.akl.sc() > 0 && com.baidu.tieba.tbadkCore.util.g.btX()) {
                    createFromThreadCfg = new PbActivityConfig(this.oW.getPageActivity()).createHistoryCfg(this.akl.getTid(), String.valueOf(this.akl.sc()), false, z, m.rx());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.akl, this.mForumName, m.rx(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.akl.sJ());
                    createFromThreadCfg.setSmartFrsPosition(this.akl.sQ());
                    createFromThreadCfg.setForumId(String.valueOf(this.akl.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
