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
    private bl aiQ;
    protected boolean aiq;
    private TbPageContext<?> ako;
    public ViewStub anA;
    public TbImageView anB;
    private final View.OnClickListener anD;
    private final View.OnClickListener ann;
    public ClickableHeaderImageView any;
    public HeadPendantClickableView bEC;
    public View bEE;
    private View.OnClickListener bEI;
    private CardGroupDividerView bFn;
    public UserIconLayout bGA;
    public PlayVoiceBntNew bGq;
    protected TextView bGr;
    protected ConstrainImageGroup bGs;
    private final View.OnClickListener bGt;
    public ThreadCommentAndPraiseInfoLayout bGx;
    public LinearLayout bjT;
    public ThreadSkinView bjU;
    public TbImageView cjQ;
    protected TextView ckg;
    public RelativeLayout cnB;
    protected TbImageView cnC;
    private View.OnClickListener cnD;
    private com.baidu.tieba.frs.h.g cnw;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiq = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiQ != null && e.this.aiQ.getAuthor() != null && e.this.aiQ.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", e.this.aiQ.getId()));
                }
                if (e.this.aiQ != null && e.this.aiQ.rc()) {
                    TiebaStatic.log(new aj("c11663").r("obj_param1", 1).aa("post_id", e.this.aiQ.getTid()));
                }
                if (e.this.VZ() != null) {
                    e.this.VZ().a(view, e.this.aiQ);
                }
                e.this.Wp();
            }
        };
        this.cnD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.VZ() != null) {
                    e.this.VZ().a(view, e.this.aiQ);
                }
                e.this.Wp();
            }
        };
        this.bGt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> VZ = e.this.VZ();
                if (VZ != null) {
                    VZ.a(view, e.this.aiQ);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.VZ() != null) {
                    e.this.VZ().a(view, e.this.aiQ);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.VZ() != null) {
                    e.this.VZ().a(view, e.this.aiQ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.ako = tbPageContext;
        this.ds16 = (int) this.ako.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.ako.getResources().getDimension(d.f.ds32);
        this.any = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.any.setDefaultResource(17170445);
        this.any.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.any.setDefaultBgResource(d.e.cp_bg_line_e);
        this.any.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        this.anA = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.bGA = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bGA.aoo = true;
        this.bGA.setEntelechyEnabled(true);
        this.bGA.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bGq = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bGq.setAfterClickListener(this.bGt);
        this.bGq.setPlayTimeTextView(d.f.fontsize28);
        this.cjQ = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.cjQ.setPageId(getTag());
        this.bGr = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bGr.setFocusable(true);
        this.bGs = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bGs.setSingleImageRatio(0.75d);
        this.bGs.setImageMargin(dimensionPixelSize);
        this.bGs.setChildClickListener(this.cnD);
        this.bGx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bGx.setLocationEnabled(true);
        this.bGx.setViewNumEnabled(true);
        this.bGx.setCommentNumClickListener(this.bEI);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bjT = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cnB = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cnC = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cnC.setPageId(getTag());
        this.ckg = (TextView) view.findViewById(d.h.app_code_btn);
        this.bjU = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bFn = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bFn.setTitleClickListener(this.bEI);
        this.cnw = new com.baidu.tieba.frs.h.g(this.ako, this.bGx);
        this.cnw.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bGs != null) {
            this.bGs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bGs != null) {
            this.bGs.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.j(this.cnB, d.g.addresslist_item_bg);
            this.bGs.onChangeSkinType();
            this.bGA.onChangeSkinType();
            this.bGx.onChangeSkinType();
            if (this.bFn != null) {
                this.bFn.onChangeSkinType();
            }
            this.cnw.onChangeSkinType();
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
        this.aiQ = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cnB != null) {
                this.cnB.setOnClickListener(this.bEI);
                this.cnB.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bEI);
                getView().setLongClickable(true);
            }
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        if (m.iZ(this.aiQ.getId())) {
            m.a(this.mTitle, this.aiQ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.aiQ.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bGA.setVisibility(0);
        if (this.aiQ.getAuthor() != null && !StringUtils.isNull(this.aiQ.getAuthor().getSealPrefix())) {
            this.bGA.aP(true);
        }
        if (this.aiQ.getAuthor() == null || this.aiQ.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiQ.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rv = this.aiQ.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.anA != null) {
                    if (this.anB == null) {
                        this.anA.inflate();
                        this.anB = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.anB.setVisibility(0);
                    this.anB.c(rv.getvipV_url(), 10, false);
                    this.any.setIsBigV(true);
                }
            } else {
                this.any.setIsBigV(false);
                if (this.anB != null) {
                    this.anB.setVisibility(8);
                }
            }
            this.bEC.setVisibility(8);
            this.any.setVisibility(0);
            this.any.setData(blVar);
            this.any.setAfterClickListener(this.anD);
        } else {
            this.any.setVisibility(4);
            this.any.setIsBigV(false);
            if (this.anB != null) {
                this.anB.setVisibility(8);
            }
            this.bEC.setVisibility(0);
            this.bEC.setData(blVar);
        }
        this.bGA.setData(blVar);
        this.bGA.setUserAfterClickListener(this.anD);
        if (this.bGx.a(blVar)) {
            this.bEE.setVisibility(8);
        } else {
            this.bEE.setVisibility(0);
        }
        this.bGx.f(this.mTbPageContext);
        this.bGx.setForumAfterClickListener(this.ann);
        this.bGx.setStType(m.rm());
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rK() == 1) {
            blVar.e(false, true);
            if (blVar.rV() == null || StringUtils.isNull(blVar.rV().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(blVar.rV());
            }
        } else {
            this.mTitle.setVisibility(0);
            blVar.XS = 0;
            blVar.e(false, blVar.ss());
            SpannableStringBuilder rV = blVar.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            this.mTitle.setText(rV);
            m.a(this.mTitle, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rD() != null && !StringUtils.isNull(blVar.rD())) {
            sb.append(blVar.rD());
        }
        ArrayList<MediaData> rF = blVar.rF();
        if (rF != null) {
            i = rF.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rF.get(i2).getVideoUrl() != null && rF.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rF.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cF = blVar.cF(sb.toString());
                this.bGr.setOnTouchListener(new com.baidu.tieba.view.l(cF));
                this.bGr.setText(cF);
                this.bGr.setContentDescription(sb.toString());
                this.bGr.setVisibility(0);
                m.a(this.bGr, blVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bGr.setVisibility(8);
            }
        } else {
            this.bGr.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGx.getLayoutParams();
        if (layoutParams != null) {
            if (this.bGr.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bGq.getVisibility() == 8 && this.bGx.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ako.getResources().getDimension(d.f.ds56), 0, 0);
                this.bGx.setPadding(0, 0, 0, 0);
            } else if (this.bGx.wZ()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bGx.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bGx.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cnw.P(this.aiQ);
        ArrayList<VoiceData.VoiceModel> rJ = blVar.rJ();
        if (u.v(rJ)) {
            this.bGq.setVisibility(8);
        } else {
            this.bGq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bGq.setVoiceModel(voiceModel);
            this.bGq.setTag(voiceModel);
            this.bGq.bhH();
            if (voiceModel != null) {
                this.bGq.mG(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oN().oT() && u.u(rF) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) u.c(rF, i3);
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
                this.bGs.setVisibility(0);
                this.bGs.setFromCDN(this.aiq);
                if (this.aiQ.sr() != null) {
                    this.bGs.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sr = e.this.aiQ.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.ako.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                                return;
                            }
                            aw.aM(e.this.mContext);
                        }
                    });
                } else {
                    this.bGs.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bl> VZ = e.this.VZ();
                            if (z) {
                                if (VZ != null) {
                                    VZ.aSG = true;
                                    VZ.a(view, e.this.aiQ);
                                }
                                e.this.Wp();
                                return;
                            }
                            if (VZ != null) {
                                VZ.aSG = false;
                                VZ.a(view, e.this.aiQ);
                            }
                            e.this.a(linkedList2, i4, blVar);
                        }
                    });
                }
                this.bGs.setImageUrls(linkedList);
            } else {
                this.bGs.setVisibility(8);
            }
        } else {
            this.bGs.setVisibility(8);
        }
        if (this.cnC != null) {
            if (blVar.rH() != null) {
                String tb = blVar.rH().tb();
                if (!StringUtils.isNull(tb)) {
                    this.cnC.setVisibility(0);
                    this.cnC.c(tb, 10, true);
                } else {
                    this.cnC.setVisibility(8);
                }
            } else {
                this.cnC.setVisibility(8);
            }
        }
        if (this.ckg != null) {
            if (blVar.rI() != null) {
                String pr = blVar.rI().pr();
                if (!StringUtils.isNull(pr)) {
                    String fixedText = al.getFixedText(pr, 20, true);
                    ai.j(this.ckg, d.g.btn_red_frame_n);
                    ai.i(this.ckg, d.e.cp_cont_h);
                    this.ckg.setText(fixedText);
                    this.ckg.setVisibility(0);
                } else {
                    this.ckg.setVisibility(8);
                }
            } else {
                this.ckg.setVisibility(8);
            }
        }
        Wo();
        b.a(this.aiQ, this.bFn);
        G(blVar);
    }

    public void G(bl blVar) {
        MetaData author;
        if (blVar != null && this.cjQ != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rQ = blVar.rQ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.any.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bjT.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cjQ.setVisibility(8);
                if (this.bjU != null) {
                    if (rQ != null) {
                        this.bjU.a(this.ako, rQ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rA(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds16);
                    } else {
                        this.bjU.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cjQ.setVisibility(0);
                this.cjQ.setImageBitmap(null);
                this.cjQ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cjQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.ako.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bjU.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds30);
            }
            this.any.setLayoutParams(layoutParams);
            this.bjT.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ako.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiq ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ako.getPageActivity()).createConfig(arrayList, i, blVar.rA(), String.valueOf(blVar.getFid()), blVar.getTid(), this.aiq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wo() {
        this.bGq.setClickable(true);
        this.bGx.setBarNameClickEnabled(true);
        int childCount = this.bGs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bGs.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGx != null) {
            this.bGx.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        PbActivityConfig createFromThreadCfg;
        if (this.aiQ != null) {
            m.iY(this.aiQ.getId());
            m.a(this.mTitle, this.aiQ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.aiQ.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiQ));
            n sr = this.aiQ.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aM(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ako.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.aiQ.YZ;
            if (this.aiQ.YY == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Um;
                long j = kVar.Un;
                aq aqVar = new aq();
                aqVar.pageContext = this.ako;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.aiQ.rI() != null) {
                if (aw.aN(this.ako.getPageActivity())) {
                    String postUrl = this.aiQ.rI().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hy()) {
                        com.baidu.tbadk.browser.a.U(this.ako.getPageActivity(), postUrl);
                    }
                }
            } else {
                s.gN(this.aiQ.getId());
                boolean z = this.aiQ.getType() != bl.XE;
                if (this.aiQ.rR() > 0 && com.baidu.tieba.tbadkCore.util.g.btp()) {
                    createFromThreadCfg = new PbActivityConfig(this.ako.getPageActivity()).createHistoryCfg(this.aiQ.getTid(), String.valueOf(this.aiQ.rR()), false, z, m.rm());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.aiQ, this.mForumName, m.rm(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aiQ.sy());
                    createFromThreadCfg.setSmartFrsPosition(this.aiQ.sF());
                    createFromThreadCfg.setForumId(String.valueOf(this.aiQ.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
