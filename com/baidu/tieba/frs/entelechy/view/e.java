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
    protected boolean ajJ;
    private bl akj;
    private TbPageContext<?> alI;
    private final View.OnClickListener aoG;
    public ClickableHeaderImageView aoR;
    public ViewStub aoT;
    public TbImageView aoU;
    private final View.OnClickListener aoW;
    public HeadPendantClickableView bFM;
    public View bFO;
    private View.OnClickListener bFS;
    private CardGroupDividerView bGx;
    public PlayVoiceBntNew bHA;
    protected TextView bHB;
    protected ConstrainImageGroup bHC;
    private final View.OnClickListener bHD;
    public ThreadCommentAndPraiseInfoLayout bHH;
    public UserIconLayout bHK;
    public LinearLayout bld;
    public ThreadSkinView ble;
    public TbImageView ckY;
    protected TextView clo;
    private com.baidu.tieba.frs.g.g coH;
    public RelativeLayout coM;
    protected TbImageView coN;
    private View.OnClickListener coO;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajJ = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akj != null && e.this.akj.getAuthor() != null && e.this.akj.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", e.this.akj.getId()));
                }
                if (e.this.akj != null && e.this.akj.rm()) {
                    TiebaStatic.log(new aj("c11663").r("obj_param1", 1).aa("post_id", e.this.akj.getTid()));
                }
                if (e.this.We() != null) {
                    e.this.We().a(view, e.this.akj);
                }
                e.this.Wu();
            }
        };
        this.coO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.We() != null) {
                    e.this.We().a(view, e.this.akj);
                }
                e.this.Wu();
            }
        };
        this.bHD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> We = e.this.We();
                if (We != null) {
                    We.a(view, e.this.akj);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.We() != null) {
                    e.this.We().a(view, e.this.akj);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.We() != null) {
                    e.this.We().a(view, e.this.akj);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.alI = tbPageContext;
        this.ds16 = (int) this.alI.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.alI.getResources().getDimension(d.f.ds32);
        this.aoR = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.aoR.setDefaultResource(17170445);
        this.aoR.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aoR.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aoR.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        this.aoT = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.bHK = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bHK.apI = true;
        this.bHK.setEntelechyEnabled(true);
        this.bHK.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bHA = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bHA.setAfterClickListener(this.bHD);
        this.bHA.setPlayTimeTextView(d.f.fontsize28);
        this.ckY = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.ckY.setPageId(getTag());
        this.bHB = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bHB.setFocusable(true);
        this.bHC = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bHC.setSingleImageRatio(0.75d);
        this.bHC.setImageMargin(dimensionPixelSize);
        this.bHC.setChildClickListener(this.coO);
        this.bHH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bHH.setLocationEnabled(true);
        this.bHH.setViewNumEnabled(true);
        this.bHH.setCommentNumClickListener(this.bFS);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bld = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.coM = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.coN = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.coN.setPageId(getTag());
        this.clo = (TextView) view.findViewById(d.h.app_code_btn);
        this.ble = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bGx = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bGx.setTitleClickListener(this.bFS);
        this.coH = new com.baidu.tieba.frs.g.g(this.alI, this.bHH);
        this.coH.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bHC != null) {
            this.bHC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bHC != null) {
            this.bHC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.j(this.coM, d.g.addresslist_item_bg);
            this.bHC.onChangeSkinType();
            this.bHK.onChangeSkinType();
            this.bHH.onChangeSkinType();
            if (this.bGx != null) {
                this.bGx.onChangeSkinType();
            }
            this.coH.onChangeSkinType();
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
        this.akj = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.coM != null) {
                this.coM.setOnClickListener(this.bFS);
                this.coM.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bFS);
                getView().setLongClickable(true);
            }
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        if (m.je(this.akj.getId())) {
            m.a(this.mTitle, this.akj.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.akj.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bHK.setVisibility(0);
        if (this.akj.getAuthor() != null && !StringUtils.isNull(this.akj.getAuthor().getSealPrefix())) {
            this.bHK.aP(true);
        }
        if (this.akj.getAuthor() == null || this.akj.getAuthor().getPendantData() == null || StringUtils.isNull(this.akj.getAuthor().getPendantData().pV())) {
            UserTbVipInfoData rF = this.akj.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.aoT != null) {
                    if (this.aoU == null) {
                        this.aoT.inflate();
                        this.aoU = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aoU.setVisibility(0);
                    this.aoU.c(rF.getvipV_url(), 10, false);
                    this.aoR.setIsBigV(true);
                }
            } else {
                this.aoR.setIsBigV(false);
                if (this.aoU != null) {
                    this.aoU.setVisibility(8);
                }
            }
            this.bFM.setVisibility(8);
            this.aoR.setVisibility(0);
            this.aoR.setData(blVar);
            this.aoR.setAfterClickListener(this.aoW);
        } else {
            this.aoR.setVisibility(4);
            this.aoR.setIsBigV(false);
            if (this.aoU != null) {
                this.aoU.setVisibility(8);
            }
            this.bFM.setVisibility(0);
            this.bFM.setData(blVar);
        }
        this.bHK.setData(blVar);
        this.bHK.setUserAfterClickListener(this.aoW);
        if (this.bHH.a(blVar)) {
            this.bFO.setVisibility(8);
        } else {
            this.bFO.setVisibility(0);
        }
        this.bHH.f(this.mTbPageContext);
        this.bHH.setForumAfterClickListener(this.aoG);
        this.bHH.setStType(m.rw());
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
            blVar.Zo = 0;
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
                this.bHB.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                this.bHB.setText(cL);
                this.bHB.setContentDescription(sb.toString());
                this.bHB.setVisibility(0);
                m.a(this.bHB, blVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bHB.setVisibility(8);
            }
        } else {
            this.bHB.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHH.getLayoutParams();
        if (layoutParams != null) {
            if (this.bHB.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bHA.getVisibility() == 8 && this.bHH.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.alI.getResources().getDimension(d.f.ds56), 0, 0);
                this.bHH.setPadding(0, 0, 0, 0);
            } else if (this.bHH.xh()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bHH.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bHH.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.coH.P(this.akj);
        ArrayList<VoiceData.VoiceModel> rT = blVar.rT();
        if (u.v(rT)) {
            this.bHA.setVisibility(8);
        } else {
            this.bHA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bHA.setVoiceModel(voiceModel);
            this.bHA.setTag(voiceModel);
            this.bHA.bhR();
            if (voiceModel != null) {
                this.bHA.mG(voiceModel.voice_status.intValue());
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
                this.bHC.setVisibility(0);
                this.bHC.setFromCDN(this.ajJ);
                if (this.akj.sB() != null) {
                    this.bHC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sB = e.this.akj.sB();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.alI.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                                return;
                            }
                            aw.aN(e.this.mContext);
                        }
                    });
                } else {
                    this.bHC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bl> We = e.this.We();
                            if (z) {
                                if (We != null) {
                                    We.aTS = true;
                                    We.a(view, e.this.akj);
                                }
                                e.this.Wu();
                                return;
                            }
                            if (We != null) {
                                We.aTS = false;
                                We.a(view, e.this.akj);
                            }
                            e.this.a(linkedList2, i4, blVar);
                        }
                    });
                }
                this.bHC.setImageUrls(linkedList);
            } else {
                this.bHC.setVisibility(8);
            }
        } else {
            this.bHC.setVisibility(8);
        }
        if (this.coN != null) {
            if (blVar.rR() != null) {
                String tl = blVar.rR().tl();
                if (!StringUtils.isNull(tl)) {
                    this.coN.setVisibility(0);
                    this.coN.c(tl, 10, true);
                } else {
                    this.coN.setVisibility(8);
                }
            } else {
                this.coN.setVisibility(8);
            }
        }
        if (this.clo != null) {
            if (blVar.rS() != null) {
                String pB = blVar.rS().pB();
                if (!StringUtils.isNull(pB)) {
                    String fixedText = al.getFixedText(pB, 20, true);
                    ai.j(this.clo, d.g.btn_red_frame_n);
                    ai.i(this.clo, d.e.cp_cont_h);
                    this.clo.setText(fixedText);
                    this.clo.setVisibility(0);
                } else {
                    this.clo.setVisibility(8);
                }
            } else {
                this.clo.setVisibility(8);
            }
        }
        Wt();
        b.a(this.akj, this.bGx);
        G(blVar);
    }

    public void G(bl blVar) {
        MetaData author;
        if (blVar != null && this.ckY != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sa = blVar.sa();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoR.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bld.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ckY.setVisibility(8);
                if (this.ble != null) {
                    if (sa != null) {
                        this.ble.a(this.alI, sa, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rK(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds16);
                    } else {
                        this.ble.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.ckY.setVisibility(0);
                this.ckY.setImageBitmap(null);
                this.ckY.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.ckY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.alI.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.ble.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds30);
            }
            this.aoR.setLayoutParams(layoutParams);
            this.bld.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.alI.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.alI.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wt() {
        this.bHA.setClickable(true);
        this.bHH.setBarNameClickEnabled(true);
        int childCount = this.bHC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHH != null) {
            this.bHH.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        PbActivityConfig createFromThreadCfg;
        if (this.akj != null) {
            m.jd(this.akj.getId());
            m.a(this.mTitle, this.akj.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.akj.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.akj));
            n sB = this.akj.sB();
            if (sB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.alI.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.akj.aav;
            if (this.akj.aau == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VL;
                long j = kVar.VM;
                aq aqVar = new aq();
                aqVar.pageContext = this.alI;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
            } else if (this.akj.rS() != null) {
                if (aw.aO(this.alI.getPageActivity())) {
                    String postUrl = this.akj.rS().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hI()) {
                        com.baidu.tbadk.browser.a.U(this.alI.getPageActivity(), postUrl);
                    }
                }
            } else {
                s.gS(this.akj.getId());
                boolean z = this.akj.getType() != bl.Za;
                if (this.akj.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.btw()) {
                    createFromThreadCfg = new PbActivityConfig(this.alI.getPageActivity()).createHistoryCfg(this.akj.getTid(), String.valueOf(this.akj.sb()), false, z, m.rw());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.akj, this.mForumName, m.rw(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.akj.sI());
                    createFromThreadCfg.setSmartFrsPosition(this.akj.sP());
                    createFromThreadCfg.setForumId(String.valueOf(this.akj.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
