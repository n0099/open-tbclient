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
    protected View aXj;
    protected boolean aiR;
    protected bh ajq;
    private final View.OnClickListener anR;
    private HeadPendantClickableView bRc;
    private ThreadGodReplyLayout bRd;
    private View.OnClickListener bRh;
    private PlayVoiceBntNew bSW;
    protected View bSX;
    private TextView bSY;
    protected ConstrainImageGroup bSZ;
    private final View.OnClickListener bTa;
    private ThreadUserInfoLayout boI;
    protected ThreadCommentAndPraiseInfoLayout boM;
    public LinearLayout boQ;
    private com.baidu.tieba.frs.g.g cFB;
    public TbImageView czY;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiR = true;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ZJ() != null) {
                    l.this.ZJ().a(view, l.this.ajq);
                }
                l.this.dD(view == l.this.bRd);
            }
        };
        this.bTa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> ZJ = l.this.ZJ();
                if (ZJ != null) {
                    view.setTag("2");
                    ZJ.a(view, l.this.ajq);
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ZJ() != null) {
                    l.this.ZJ().a(view, l.this.ajq);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.bRc = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.bRc.setAfterClickListener(this.anR);
        this.aXj = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.bSW = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.bSW.setAfterClickListener(this.bTa);
        this.bSY = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.bSY.setVisibility(8);
        this.bSX = view.findViewById(d.g.divider_line_above_praise);
        this.bSZ = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bSZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.bSZ.setChildClickListener(this.bRh);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSZ.setImageProcessor(fVar);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.boI.setUserAfterClickListener(this.anR);
        this.boI.setFrom(3);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this.bRh);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setIsBarViewVisible(false);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(1);
        this.boM.setStType("frs_page");
        this.boM.setFrom(2);
        this.cFB = new com.baidu.tieba.frs.g.g(this.mPageContext, this.boI);
        this.cFB.setUniqueId(getTag());
        this.bRd = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.bRd.setOnClickListener(this.bRh);
        this.czY = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.czY.setPageId(getTag());
        this.boQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.bSZ != null) {
            this.bSZ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.aXj, d.C0080d.cp_bg_line_e);
            aj.k(this.bSX, d.C0080d.cp_bg_line_e);
            this.bSZ.onChangeSkinType();
            this.boM.onChangeSkinType();
            this.boI.onChangeSkinType();
            this.cFB.onChangeSkinType();
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
            getView().setOnClickListener(this.bRh);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bRd.onChangeSkinType();
        if (!ZN() && m.jM(this.ajq.getId())) {
            m.a(this.mTitle, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSY, this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            m.a(this.bRd.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.cFB.Q(this.ajq);
        this.boI.setData(this.ajq);
        this.bRd.setFromCDN(this.aiR);
        this.bRd.setData(this.ajq.sL());
        this.boI.setUserAfterClickListener(this.anR);
        this.boM.setData(bhVar);
        if (this.boI.getHeaderImg() != null) {
            if (this.boI.getIsSimpleThread()) {
                this.boI.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (bhVar.rt() == null || bhVar.rt().getPendantData() == null || StringUtils.isNull(bhVar.rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.boI.getHeaderImg().setVisibility(0);
                this.boI.getHeaderImg().setData(bhVar);
            } else {
                this.boI.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(bhVar);
            }
        }
        y(bhVar);
        ArrayList<VoiceData.VoiceModel> rI = bhVar.rI();
        if (com.baidu.tbadk.core.util.v.v(rI)) {
            this.bSW.setVisibility(8);
            dE(false);
        } else {
            this.bSW.setVisibility(0);
            dE(true);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSW.setVoiceModel(voiceModel);
            this.bSW.setTag(voiceModel);
            this.bSW.bjz();
            if (voiceModel != null) {
                this.bSW.ny(voiceModel.voice_status.intValue());
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
                this.bSZ.setVisibility(0);
                this.bSZ.setFromCDN(this.aiR);
                this.bSZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        x<bh> ZJ = l.this.ZJ();
                        if (z) {
                            if (ZJ != null) {
                                view.setTag("1");
                                ZJ.aUA = true;
                                ZJ.a(view, l.this.ajq);
                            }
                            l.this.dD(false);
                            return;
                        }
                        if (ZJ != null) {
                            view.setTag("1");
                            ZJ.aUA = false;
                            ZJ.a(view, l.this.ajq);
                        }
                        l.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.bSZ.setImageMediaList(linkedList);
            } else {
                this.bSZ.setVisibility(8);
            }
        } else {
            this.bSZ.setVisibility(8);
        }
        ZZ();
        aaa();
        G(bhVar);
        aac();
    }

    private void ZZ() {
        if (this.bSX != null && this.bSZ != null && this.bRd != null) {
            if (this.bSZ.getVisibility() == 8 && this.bRd.getVisibility() == 8) {
                this.bSX.setVisibility(0);
            } else {
                this.bSX.setVisibility(8);
            }
        }
    }

    private void dE(boolean z) {
        if (this.bSZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSZ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.bSZ.setLayoutParams(layoutParams);
        }
    }

    public void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && this.czY != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.czY.setVisibility(8);
                return;
            }
            this.czY.setVisibility(0);
            this.czY.setImageBitmap(null);
            this.czY.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.czY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
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

    private void aaa() {
        this.bSW.setClickable(true);
        int childCount = this.bSZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSZ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boM != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.boI != null) {
            this.boI.setPageUniqueId(bdUniqueId);
        }
        if (this.bSZ != null) {
            this.bSZ.setPageUniqueId(bdUniqueId);
        }
    }

    protected void dD(boolean z) {
        if (this.ajq != null) {
            m.jL(this.ajq.getId());
            m.a(this.mTitle, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSY, this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            m.a(this.bRd.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
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

    private boolean ZN() {
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
        if (this.bSW != null) {
            this.bSW.setVoiceManager(voiceManager);
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

    private void aac() {
        if (this.mTitle != null && this.bSW != null && this.bSZ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSW.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.bSW.setLayoutParams(layoutParams);
            if (this.bSW.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSZ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
                this.bSZ.setLayoutParams(layoutParams2);
            }
        }
    }
}
