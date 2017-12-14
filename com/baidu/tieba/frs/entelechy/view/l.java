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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.m;
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
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<bd> implements u {
    protected bd ajJ;
    protected boolean ajh;
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private ThreadGodReplyLayout bZf;
    private View.OnClickListener bZj;
    protected View ban;
    private ThreadUserInfoLayout bvE;
    protected ThreadCommentAndPraiseInfoLayout bvI;
    public LinearLayout bvL;
    private com.baidu.tieba.frs.g.g cOS;
    private PlayVoiceBntNew caM;
    protected View caN;
    private TextView caO;
    protected ConstrainImageGroup caP;
    private final View.OnClickListener caS;
    public TbImageView ccH;
    private RelativeLayout cth;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajh = true;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.ajJ);
                }
                l.this.dO(view == l.this.bZf);
            }
        };
        this.caS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> abt = l.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, l.this.ajJ);
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.ajJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.bZe.setAfterClickListener(this.aod);
        this.ban = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caM = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caM.setAfterClickListener(this.caS);
        this.caO = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caO.setVisibility(8);
        this.caN = view.findViewById(d.g.divider_line_above_praise);
        this.caP = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.caP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.caP.setChildClickListener(this.bZj);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caP.setImageProcessor(fVar);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bvE.setUserAfterClickListener(this.aod);
        this.bvE.setFrom(3);
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(1);
        this.bvI.setStType("frs_page");
        this.bvI.setFrom(2);
        this.bvI.anO = 3;
        this.cth = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cOS = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cth);
        this.cOS.setUniqueId(getTag());
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.bZf.setOnClickListener(this.bZj);
        this.ccH = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccH.setPageId(getTag());
        this.bvL = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout abY() {
        return this.bvI;
    }

    public void setSingleImageRatio(double d) {
        if (this.caP != null) {
            this.caP.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caP != null) {
            this.caP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caP != null) {
            this.caP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.ban, d.C0096d.cp_bg_line_e);
            this.caP.onChangeSkinType();
            this.bvI.onChangeSkinType();
            this.bvE.onChangeSkinType();
            this.cOS.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(final bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajJ = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZj);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bZf.onChangeSkinType();
        if (!abx() && com.baidu.tieba.card.k.jP(this.ajJ.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.ajJ.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caO, this.ajJ.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.bZf.getGodReplyContent(), this.ajJ.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
        }
        this.cOS.U(this.ajJ);
        this.bvE.setData(this.ajJ);
        this.bZf.setFromCDN(this.ajh);
        this.bZf.setData(this.ajJ.sM());
        this.bvE.setUserAfterClickListener(this.aod);
        this.bvI.setData(bdVar);
        if (this.bvE.getHeaderImg() != null) {
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (bdVar.rv() == null || bdVar.rv().getPendantData() == null || StringUtils.isNull(bdVar.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                this.bvE.getHeaderImg().setData(bdVar);
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(bdVar);
            }
        }
        B(bdVar);
        ArrayList<VoiceData.VoiceModel> rK = bdVar.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caM.setVisibility(8);
        } else {
            this.caM.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.caM.setVoiceModel(voiceModel);
            this.caM.setTag(voiceModel);
            this.caM.bmf();
            if (voiceModel != null) {
                this.caM.nT(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rG = bdVar.rG();
        if (com.baidu.tbadk.core.h.oY().pe() && com.baidu.tbadk.core.util.v.v(rG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < rG.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                this.caP.setVisibility(0);
                this.caP.setFromCDN(this.ajh);
                this.caP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        v<bd> abt = l.this.abt();
                        if (z) {
                            if (abt != null) {
                                view.setTag("1");
                                abt.aXD = true;
                                abt.a(view, l.this.ajJ);
                            }
                            l.this.dO(false);
                            return;
                        }
                        if (abt != null) {
                            view.setTag("1");
                            abt.aXD = false;
                            abt.a(view, l.this.ajJ);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.caP.setImageMediaList(linkedList);
            } else {
                this.caP.setVisibility(8);
            }
        } else {
            this.caP.setVisibility(8);
        }
        abL();
        abM();
        D(bdVar);
        aoe();
    }

    private void abL() {
        if (this.caN != null && this.caP != null && this.bZf != null) {
            if (this.caP.getVisibility() == 8 && this.bZf.getVisibility() == 8) {
                this.caN.setVisibility(0);
            } else {
                this.caN.setVisibility(8);
            }
        }
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccH != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccH.setVisibility(8);
                return;
            }
            this.ccH.setVisibility(0);
            this.ccH.setImageBitmap(null);
            this.ccH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                imageUrlData.urlType = this.ajh ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajh, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void abM() {
        this.caM.setClickable(true);
        int childCount = this.caP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caP.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajh = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvI != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
        if (this.caP != null) {
            this.caP.setPageUniqueId(bdUniqueId);
        }
    }

    protected void dO(boolean z) {
        if (this.ajJ != null) {
            com.baidu.tieba.card.k.jO(this.ajJ.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.ajJ.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caO, this.ajJ.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.bZf.getGodReplyContent(), this.ajJ.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
            m ss = this.ajJ.ss();
            if (ss != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aR(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.ajJ.ZX;
            if (this.ajJ.ZW == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VM;
                long j = jVar.VN;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wa = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajJ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajJ.getFid()));
            addLocateParam.setForumName(this.ajJ.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ajJ.sm() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.caM != null) {
            this.caM.setVoiceManager(voiceManager);
        }
    }

    private boolean B(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        }
        return true;
    }

    private void aoe() {
        if (this.mTitle != null && this.caM != null && this.caP != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.caM.setLayoutParams(layoutParams);
            if (this.caM.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.caP.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.caP.setLayoutParams(layoutParams2);
            }
        }
    }
}
