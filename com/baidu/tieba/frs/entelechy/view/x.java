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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.card.a<bm> implements cg {
    protected boolean ahU;
    private bm aiu;
    private TbPageContext<?> ajP;
    private final View.OnClickListener amF;
    public ClickableHeaderImageView amN;
    public ViewStub amP;
    public TbImageView amQ;
    private final View.OnClickListener amS;
    private View.OnClickListener bAB;
    public HeadPendantClickableView bAv;
    public View bAx;
    private CardGroupDividerView bBg;
    public PlayVoiceBntNew bCj;
    protected TextView bCk;
    protected ConstrainImageGroup bCl;
    private final View.OnClickListener bCm;
    public ThreadCommentAndPraiseInfoLayout bCq;
    public UserIconLayout bCt;
    public LinearLayout bgH;
    public ThreadSkinView bgI;
    public TbImageView cee;
    protected TextView ceu;
    public RelativeLayout chE;
    protected TbImageView chF;
    private View.OnClickListener chG;
    private com.baidu.tieba.frs.f.v chz;
    private int ds16;
    private int ds32;
    private String mForumName;
    protected int mSkinType;
    private TextView mTitle;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahU = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bAB = new y(this);
        this.chG = new z(this);
        this.bCm = new aa(this);
        this.amS = new ab(this);
        this.amF = new ac(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajP = tbPageContext;
        this.ds16 = (int) this.ajP.getResources().getDimension(w.f.ds16);
        this.ds32 = (int) this.ajP.getResources().getDimension(w.f.ds32);
        this.amN = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bAv = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        this.amN.setDefaultResource(17170445);
        this.amN.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.amN.setDefaultBgResource(w.e.cp_bg_line_e);
        this.amN.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        this.amP = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.bCt = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.bCt.any = true;
        this.bCt.setEntelechyEnabled(true);
        this.bCt.setPageName(1);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bCj = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bCj.setAfterClickListener(this.bCm);
        this.bCj.setPlayTimeTextView(w.f.fontsize28);
        this.cee = (TbImageView) view.findViewById(w.h.frs_normal_item_theme_card);
        this.cee.setPageId(getTag());
        this.bCk = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bCk.setFocusable(true);
        this.bCl = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4);
        this.bCl.setSingleImageRatio(0.75d);
        this.bCl.setImageMargin(dimensionPixelSize);
        this.bCl.setChildClickListener(this.chG);
        this.bCq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bCq.setLocationEnabled(true);
        this.bCq.setViewNumEnabled(true);
        this.bCq.setCommentNumClickListener(this.bAB);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bgH = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.chE = (RelativeLayout) view.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.chF = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.chF.setPageId(getTag());
        this.ceu = (TextView) view.findViewById(w.h.app_code_btn);
        this.bgI = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bBg = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bBg.setTitleClickListener(this.bAB);
        this.chz = new com.baidu.tieba.frs.f.v(this.ajP, this.bCq);
        this.chz.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bCl != null) {
            this.bCl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bCl != null) {
            this.bCl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.j(this.chE, w.g.addresslist_item_bg);
            this.bCl.onChangeSkinType();
            this.bCt.onChangeSkinType();
            this.bCq.onChangeSkinType();
            if (this.bBg != null) {
                this.bBg.onChangeSkinType();
            }
            this.chz.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: t */
    public void a(bm bmVar) {
        int i;
        if (bmVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiu = bmVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.chE != null) {
                this.chE.setOnClickListener(this.bAB);
                this.chE.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bAB);
                getView().setLongClickable(true);
            }
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tieba.card.at.iJ(this.aiu.getId())) {
            com.baidu.tieba.card.at.a(this.mTitle, this.aiu.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bCk, this.aiu.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
        }
        this.bCt.setVisibility(0);
        if (this.aiu.getAuthor() != null && !StringUtils.isNull(this.aiu.getAuthor().getSealPrefix())) {
            this.bCt.aO(true);
        }
        if (this.aiu.getAuthor() == null || this.aiu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiu.getAuthor().getPendantData().pI())) {
            UserTbVipInfoData rr = this.aiu.rr();
            if (rr != null && rr.getvipV_url() != null) {
                if (this.amP != null) {
                    if (this.amQ == null) {
                        this.amP.inflate();
                        this.amQ = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.amQ.setVisibility(0);
                    this.amQ.c(rr.getvipV_url(), 10, false);
                    this.amN.setIsBigV(true);
                }
            } else {
                this.amN.setIsBigV(false);
                if (this.amQ != null) {
                    this.amQ.setVisibility(8);
                }
            }
            this.bAv.setVisibility(8);
            this.amN.setVisibility(0);
            this.amN.setData(bmVar);
            this.amN.setAfterClickListener(this.amS);
        } else {
            this.amN.setVisibility(4);
            this.amN.setIsBigV(false);
            if (this.amQ != null) {
                this.amQ.setVisibility(8);
            }
            this.bAv.setVisibility(0);
            this.bAv.setData(bmVar);
        }
        this.bCt.setData(bmVar);
        this.bCt.setUserAfterClickListener(this.amS);
        if (this.bCq.a(bmVar)) {
            this.bAx.setVisibility(8);
        } else {
            this.bAx.setVisibility(0);
        }
        this.bCq.e(this.mTbPageContext);
        this.bCq.setForumAfterClickListener(this.amF);
        this.bCq.setStType(com.baidu.tieba.card.at.ri());
        if ((StringUtils.isNull(bmVar.getTitle()) && (bmVar.rp() == null || bmVar.rp().size() == 0)) || bmVar.rG() == 1) {
            bmVar.e(false, true);
            if (bmVar.rR() == null || StringUtils.isNull(bmVar.rR().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bmVar.rR());
            }
        } else {
            this.mTitle.setVisibility(0);
            bmVar.XB = 0;
            bmVar.e(false, bmVar.so());
            SpannableStringBuilder rR = bmVar.rR();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rR));
            this.mTitle.setText(rR);
            com.baidu.tieba.card.at.a(this.mTitle, bmVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bmVar.rz() != null && !StringUtils.isNull(bmVar.rz())) {
            sb.append(bmVar.rz());
        }
        ArrayList<MediaData> rB = bmVar.rB();
        if (rB != null) {
            i = rB.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rB.get(i2).getVideoUrl() != null && rB.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rB.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bmVar.g(sb.toString(), true))) {
                SpannableString cA = bmVar.cA(sb.toString());
                this.bCk.setOnTouchListener(new com.baidu.tieba.view.aa(cA));
                this.bCk.setText(cA);
                this.bCk.setContentDescription(sb.toString());
                this.bCk.setVisibility(0);
                com.baidu.tieba.card.at.a(this.bCk, bmVar.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.bCk.setVisibility(8);
            }
        } else {
            this.bCk.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCq.getLayoutParams();
        if (layoutParams != null) {
            if (this.bCk.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bCj.getVisibility() == 8 && this.bCq.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.ajP.getResources().getDimension(w.f.ds56), 0, 0);
                this.bCq.setPadding(0, 0, 0, 0);
            } else if (this.bCq.wO()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bCq.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bCq.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.chz.L(this.aiu);
        ArrayList<VoiceData.VoiceModel> rF = bmVar.rF();
        if (com.baidu.tbadk.core.util.z.t(rF)) {
            this.bCj.setVisibility(8);
        } else {
            this.bCj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rF.get(0);
            this.bCj.setVoiceModel(voiceModel);
            this.bCj.setTag(voiceModel);
            this.bCj.bef();
            if (voiceModel != null) {
                this.bCj.my(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.r.oK().oQ() && com.baidu.tbadk.core.util.z.s(rB) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.z.c(rB, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.aw.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.z.s(linkedList) > 0) {
                this.bCl.setVisibility(0);
                this.bCl.setFromCDN(this.ahU);
                if (this.aiu.sn() != null) {
                    this.bCl.setImageClickListener(new ad(this));
                } else {
                    this.bCl.setImageClickListener(new ae(this, linkedList2, bmVar));
                }
                this.bCl.setImageUrls(linkedList);
            } else {
                this.bCl.setVisibility(8);
            }
        } else {
            this.bCl.setVisibility(8);
        }
        if (this.chF != null) {
            if (bmVar.rD() != null) {
                String sU = bmVar.rD().sU();
                if (!StringUtils.isNull(sU)) {
                    this.chF.setVisibility(0);
                    this.chF.c(sU, 10, true);
                } else {
                    this.chF.setVisibility(8);
                }
            } else {
                this.chF.setVisibility(8);
            }
        }
        if (this.ceu != null) {
            if (bmVar.rE() != null) {
                String po = bmVar.rE().po();
                if (!StringUtils.isNull(po)) {
                    String fixedText = com.baidu.tbadk.core.util.aw.getFixedText(po, 20, true);
                    com.baidu.tbadk.core.util.as.j(this.ceu, w.g.btn_red_frame_n);
                    com.baidu.tbadk.core.util.as.i(this.ceu, w.e.cp_cont_h);
                    this.ceu.setText(fixedText);
                    this.ceu.setVisibility(0);
                } else {
                    this.ceu.setVisibility(8);
                }
            } else {
                this.ceu.setVisibility(8);
            }
        }
        VH();
        p.a(this.aiu, this.bBg);
        C(bmVar);
    }

    public void C(bm bmVar) {
        MetaData author;
        if (bmVar != null && this.cee != null && (author = bmVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rM = bmVar.rM();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amN.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bgH.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cee.setVisibility(8);
                if (this.bgI != null) {
                    if (rM != null) {
                        this.bgI.a(this.ajP, rM, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bmVar.getFid()), bmVar.rw(), bmVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds16);
                    } else {
                        this.bgI.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.cee.setVisibility(0);
                this.cee.setImageBitmap(null);
                this.cee.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cee.setOnClickListener(new af(this, themeCard));
                this.bgI.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds30);
            }
            this.amN.setLayoutParams(layoutParams);
            this.bgH.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bm bmVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bmVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajP.getPageActivity()).createConfig(arrayList, i, bmVar.rw(), String.valueOf(bmVar.getFid()), bmVar.getTid(), this.ahU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void VH() {
        this.bCj.setClickable(true);
        this.bCq.setBarNameClickEnabled(true);
        int childCount = this.bCl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bCq != null) {
            this.bCq.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VI() {
        PbActivityConfig createFromThreadCfg;
        if (this.aiu != null) {
            com.baidu.tieba.card.at.iI(this.aiu.getId());
            com.baidu.tieba.card.at.a(this.mTitle, this.aiu.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bCk, this.aiu.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiu));
            com.baidu.tbadk.core.data.o sn = this.aiu.sn();
            if (sn != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajP.getPageActivity(), sn.getCartoonId(), sn.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.aiu.YI;
            if (this.aiu.YH == 1 && lVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.TW;
                long j = lVar.TX;
                com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
                arVar.pageContext = this.ajP;
                arVar.bookId = str;
                arVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, arVar));
            } else if (this.aiu.rE() != null) {
                if (bl.aN(this.ajP.getPageActivity())) {
                    String postUrl = this.aiu.rE().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hA()) {
                        com.baidu.tbadk.browser.g.U(this.ajP.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.v.gH(this.aiu.getId());
                boolean z = this.aiu.getType() != bm.Xo;
                if (this.aiu.rN() > 0 && com.baidu.tieba.tbadkCore.util.s.bns()) {
                    createFromThreadCfg = new PbActivityConfig(this.ajP.getPageActivity()).createHistoryCfg(this.aiu.getTid(), String.valueOf(this.aiu.rN()), false, z, com.baidu.tieba.card.at.ri());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.aiu, this.mForumName, com.baidu.tieba.card.at.ri(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aiu.su());
                    createFromThreadCfg.setSmartFrsPosition(this.aiu.sA());
                    createFromThreadCfg.setForumId(String.valueOf(this.aiu.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
