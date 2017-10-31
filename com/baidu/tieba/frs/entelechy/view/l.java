package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.tbadk.core.util.aj;
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
public class l extends com.baidu.tieba.card.a<bh> implements v {
    protected View aXa;
    protected boolean aiR;
    protected bh ajq;
    private final View.OnClickListener anS;
    private HeadPendantClickableView bQP;
    private ThreadGodReplyLayout bQQ;
    private View.OnClickListener bQU;
    private PlayVoiceBntNew bSJ;
    protected View bSK;
    private TextView bSL;
    protected ConstrainImageGroup bSM;
    private final View.OnClickListener bSN;
    protected ThreadCommentAndPraiseInfoLayout boD;
    public LinearLayout boH;
    private ThreadUserInfoLayout boz;
    private com.baidu.tieba.frs.g.g cFi;
    public TbImageView czF;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiR = true;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Zx() != null) {
                    l.this.Zx().a(view, l.this.ajq);
                }
                l.this.dy(view == l.this.bQQ);
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> Zx = l.this.Zx();
                if (Zx != null) {
                    view.setTag("2");
                    Zx.a(view, l.this.ajq);
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Zx() != null) {
                    l.this.Zx().a(view, l.this.ajq);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.bQP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.bQP.setAfterClickListener(this.anS);
        this.aXa = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.bSJ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.bSJ.setAfterClickListener(this.bSN);
        this.bSL = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.bSL.setVisibility(8);
        this.bSK = view.findViewById(d.g.divider_line_above_praise);
        this.bSM = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bSM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.bSM.setChildClickListener(this.bQU);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSM.setImageProcessor(fVar);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.boz.setUserAfterClickListener(this.anS);
        this.boz.setFrom(3);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setIsBarViewVisible(false);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(1);
        this.boD.setStType("frs_page");
        this.boD.setFrom(2);
        this.cFi = new com.baidu.tieba.frs.g.g(this.mPageContext, this.boz);
        this.cFi.setUniqueId(getTag());
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.bQQ.setOnClickListener(this.bQU);
        this.czF = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.czF.setPageId(getTag());
        this.boH = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.bSM != null) {
            this.bSM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSM != null) {
            this.bSM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSM != null) {
            this.bSM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.aXa, d.C0080d.cp_bg_line_e);
            aj.k(this.bSK, d.C0080d.cp_bg_line_e);
            this.bSM.onChangeSkinType();
            this.boD.onChangeSkinType();
            this.boz.onChangeSkinType();
            this.cFi.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(final bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajq = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bQQ.onChangeSkinType();
        if (!ZB() && m.jL(this.ajq.getId())) {
            m.a(this.mTitle, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSL, this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            m.a(this.bQQ.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.cFi.Q(this.ajq);
        this.boz.setData(this.ajq);
        this.bQQ.setFromCDN(this.aiR);
        this.bQQ.setData(this.ajq.sL());
        this.boz.setUserAfterClickListener(this.anS);
        this.boD.setData(bhVar);
        if (this.boz.getHeaderImg() != null) {
            if (this.boz.getIsSimpleThread()) {
                this.boz.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (bhVar.rt() == null || bhVar.rt().getPendantData() == null || StringUtils.isNull(bhVar.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.boz.getHeaderImg().setVisibility(0);
                this.boz.getHeaderImg().setData(bhVar);
            } else {
                this.boz.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(bhVar);
            }
        }
        y(bhVar);
        ArrayList<VoiceData.VoiceModel> rI = bhVar.rI();
        if (com.baidu.tbadk.core.util.v.v(rI)) {
            this.bSJ.setVisibility(8);
            dz(false);
        } else {
            this.bSJ.setVisibility(0);
            dz(true);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSJ.setVoiceModel(voiceModel);
            this.bSJ.setTag(voiceModel);
            this.bSJ.bjo();
            if (voiceModel != null) {
                this.bSJ.nx(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rE = bhVar.rE();
        if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.u(rE) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < rE.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rE, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                this.bSM.setVisibility(0);
                this.bSM.setFromCDN(this.aiR);
                this.bSM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        x<bh> Zx = l.this.Zx();
                        if (z) {
                            if (Zx != null) {
                                view.setTag("1");
                                Zx.aUs = true;
                                Zx.a(view, l.this.ajq);
                            }
                            l.this.dy(false);
                            return;
                        }
                        if (Zx != null) {
                            view.setTag("1");
                            Zx.aUs = false;
                            Zx.a(view, l.this.ajq);
                        }
                        l.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.bSM.setImageMediaList(linkedList);
            } else {
                this.bSM.setVisibility(8);
            }
        } else {
            this.bSM.setVisibility(8);
        }
        ZN();
        ZO();
        G(bhVar);
        ZQ();
    }

    private void ZN() {
        if (this.bSK != null && this.bSM != null && this.bQQ != null) {
            if (this.bSM.getVisibility() == 8 && this.bQQ.getVisibility() == 8) {
                this.bSK.setVisibility(0);
            } else {
                this.bSK.setVisibility(8);
            }
        }
    }

    private void dz(boolean z) {
        if (this.bSM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.bSM.setLayoutParams(layoutParams);
        }
    }

    public void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && this.czF != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.czF.setVisibility(8);
                return;
            }
            this.czF.setVisibility(0);
            this.czF.setImageBitmap(null);
            this.czF.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.czF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            String str = null;
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                str = mediaData.getSrc_pic();
            } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                str = mediaData.getPicUrl();
            }
            if (!StringUtils.isNull(str)) {
                arrayList.add(str);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aiR ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!com.baidu.tbadk.core.util.v.v(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        }
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    private void ZO() {
        this.bSJ.setClickable(true);
        int childCount = this.bSM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSM.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boD != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.boz != null) {
            this.boz.setPageUniqueId(bdUniqueId);
        }
        if (this.bSM != null) {
            this.bSM.setPageUniqueId(bdUniqueId);
        }
    }

    protected void dy(boolean z) {
        if (this.ajq != null) {
            m.jK(this.ajq.getId());
            m.a(this.mTitle, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSL, this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            m.a(this.bQQ.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            n sr = this.ajq.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ajq.ZK;
            if (this.ajq.ZJ == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Vl;
                long j = kVar.Vm;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.VJ = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajq, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajq.getFid()));
            addLocateParam.setForumName(this.ajq.rz());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ajq.sl() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra(PbActivityConfig.KEY_IS_INTERVIEW_LIVE, true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZB() {
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
        if (this.bSJ != null) {
            this.bSJ.setVoiceManager(voiceManager);
        }
    }

    private boolean y(bh bhVar) {
        SpannableStringBuilder g = bhVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        }
        return true;
    }

    private void ZQ() {
        if (this.mTitle != null && this.bSJ != null && this.bSM != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSJ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.bSJ.setLayoutParams(layoutParams);
            if (this.bSJ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSM.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
                this.bSM.setLayoutParams(layoutParams2);
            }
        }
    }
}
