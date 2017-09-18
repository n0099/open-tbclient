package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<bj> implements v {
    private View aVj;
    private bj ajE;
    private boolean aje;
    private final View.OnClickListener aou;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private View bKj;
    private View.OnClickListener bKn;
    private PlayVoiceBntNew bLV;
    private TextView bLW;
    private ConstrainImageGroup bLX;
    private final View.OnClickListener bLY;
    public LinearLayout blC;
    private ThreadUserInfoLayout blu;
    private ThreadCommentAndPraiseInfoLayout bly;
    public TbImageView crX;
    private com.baidu.tieba.frs.h.g cwN;
    private TbPageContext<?> mF;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aje = true;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.XL() != null) {
                    l.this.XL().a(view, l.this.ajE);
                }
                l.this.dI(view == l.this.bKi);
            }
        };
        this.bLY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bj> XL = l.this.XL();
                if (XL != null) {
                    view.setTag("2");
                    XL.a(view, l.this.ajE);
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.XL() != null) {
                    l.this.XL().a(view, l.this.ajE);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.bKh = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
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
        this.bKh.setAfterClickListener(this.aou);
        this.aVj = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLV = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLV.setAfterClickListener(this.bLY);
        this.bLW = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLW.setVisibility(8);
        this.bLX = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLX.setChildClickListener(this.bKn);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLX.setImageProcessor(fVar);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.blu.setUserAfterClickListener(this.aou);
        this.blu.setFrom(3);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this.bKn);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setIsBarViewVisible(false);
        this.bly.setShareVisible(true);
        this.bly.setShareReportFrom(1);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setFrom(2);
        this.cwN = new com.baidu.tieba.frs.h.g(this.mF, this.blu);
        this.cwN.setUniqueId(getTag());
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bKi.setOnClickListener(this.bKn);
        this.crX = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.crX.setPageId(getTag());
        this.blC = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.bLX != null) {
            this.bLX.setSingleImageRatio(d);
        }
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
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aVj, d.e.cp_bg_line_c);
            this.bLX.onChangeSkinType();
            this.bly.onChangeSkinType();
            this.blu.onChangeSkinType();
            this.cwN.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(final bj bjVar) {
        boolean z;
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
            getView().setOnClickListener(this.bKn);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.bKi.onChangeSkinType();
        if (!XP() && m.jv(this.ajE.getId())) {
            m.a(this.mTitle, this.ajE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLW, this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getGodReplyContent(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getPraiseNum(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cwN.T(this.ajE);
        this.blu.c(this.ajE);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.mF.getResources().getDimension(d.f.ds10);
        this.bly.setLayoutParams(layoutParams);
        this.bKi.setFromCDN(this.aje);
        this.bKi.setData(this.ajE.sR());
        this.blu.setUserAfterClickListener(this.aou);
        this.bly.c(bjVar);
        this.bKj.setVisibility(0);
        this.mStType = m.rs();
        if (this.blu.getHeaderImg() != null) {
            if (this.blu.getIsSimpleThread()) {
                this.blu.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (bjVar.getAuthor() == null || bjVar.getAuthor().getPendantData() == null || StringUtils.isNull(bjVar.getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.blu.getHeaderImg().setVisibility(0);
                this.blu.getHeaderImg().setData(bjVar);
            } else {
                this.blu.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(bjVar);
            }
        }
        boolean D = D(bjVar);
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
        ArrayList<MediaData> rL = bjVar.rL();
        if (com.baidu.tbadk.core.h.oS().oY() && com.baidu.tbadk.core.util.v.u(rL) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i = 0; i < rL.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rL, i);
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
                this.bLX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z2) {
                        x<bj> XL = l.this.XL();
                        if (z2) {
                            if (XL != null) {
                                view.setTag("1");
                                XL.aTB = true;
                                XL.a(view, l.this.ajE);
                            }
                            l.this.dI(false);
                            return;
                        }
                        if (XL != null) {
                            view.setTag("1");
                            XL.aTB = false;
                            XL.a(view, l.this.ajE);
                        }
                        l.this.a(linkedList2, i2, bjVar);
                    }
                });
                this.bLX.setImageUrls(linkedList);
                z = true;
                Yb();
                h(D, false, z);
                K(bjVar);
            }
            this.bLX.setVisibility(8);
        } else {
            this.bLX.setVisibility(8);
        }
        z = false;
        Yb();
        h(D, false, z);
        K(bjVar);
    }

    public void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.crX != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crX.setVisibility(8);
                return;
            }
            this.crX.setVisibility(0);
            this.crX.setImageBitmap(null);
            this.crX.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mF.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLW.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bLX.getLayoutParams();
        if (!z && z2) {
            layoutParams2.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams3.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams3.topMargin = 0;
            }
        } else if (z2) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds10);
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
        int childCount = this.bLX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aje = z;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bly != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.blu != null) {
            this.blu.setPageUniqueId(bdUniqueId);
        }
        if (this.bLX != null) {
            this.bLX.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(boolean z) {
        if (this.ajE != null) {
            m.ju(this.ajE.getId());
            m.a(this.mTitle, this.ajE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLW, this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getGodReplyContent(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getPraiseNum(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sx = this.ajE.sx();
            if (sx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                return;
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
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajE, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajE.getFid()));
            addLocateParam.setForumName(this.ajE.rG());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XP() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bLV != null) {
            this.bLV.setVoiceManager(voiceManager);
        }
    }

    private boolean D(bj bjVar) {
        SpannableStringBuilder g = bjVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        return true;
    }
}
