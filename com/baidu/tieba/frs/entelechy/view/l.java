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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private View aWX;
    private boolean aiG;
    private bh ajg;
    private final View.OnClickListener anJ;
    private View.OnClickListener bJA;
    private HeadPendantClickableView bJv;
    private ThreadGodReplyLayout bJw;
    private PlayVoiceBntNew bLr;
    private View bLs;
    private TextView bLt;
    private ConstrainImageGroup bLu;
    private final View.OnClickListener bLv;
    private ThreadUserInfoLayout bnf;
    private ThreadCommentAndPraiseInfoLayout bnj;
    public LinearLayout bnn;
    public TbImageView csu;
    private com.baidu.tieba.frs.h.g cxD;
    private String mForumName;
    private TbPageContext<?> mG;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiG = true;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Xr() != null) {
                    l.this.Xr().a(view, l.this.ajg);
                }
                l.this.dA(view == l.this.bJw);
            }
        };
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> Xr = l.this.Xr();
                if (Xr != null) {
                    view.setTag("2");
                    Xr.a(view, l.this.ajg);
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Xr() != null) {
                    l.this.Xr().a(view, l.this.ajg);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mG = tbPageContext;
        this.bJv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
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
        this.bJv.setAfterClickListener(this.anJ);
        this.aWX = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLr = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLr.setAfterClickListener(this.bLv);
        this.bLt = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLt.setVisibility(8);
        this.bLs = view.findViewById(d.h.divider_line_above_praise);
        this.bLu = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLu.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLu.setChildClickListener(this.bJA);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLu.setImageProcessor(fVar);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bnf = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bnf.setUserAfterClickListener(this.anJ);
        this.bnf.setFrom(3);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this.bJA);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(1);
        this.bnj.setFrom(2);
        this.cxD = new com.baidu.tieba.frs.h.g(this.mG, this.bnf);
        this.cxD.setUniqueId(getTag());
        this.bJw = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bJw.setOnClickListener(this.bJA);
        this.csu = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.csu.setPageId(getTag());
        this.bnn = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.bLu != null) {
            this.bLu.setSingleImageRatio(d);
        }
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
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aWX, d.e.cp_bg_line_e);
            aj.k(this.bLs, d.e.cp_bg_line_e);
            this.bLu.onChangeSkinType();
            this.bnj.onChangeSkinType();
            this.bnf.onChangeSkinType();
            this.cxD.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new_frame;
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
        this.ajg = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        this.bJw.onChangeSkinType();
        if (!Xv() && m.jn(this.ajg.getId())) {
            m.a(this.mTitle, this.ajg.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLt, this.ajg.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJw.getGodReplyContent(), this.ajg.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cxD.O(this.ajg);
        this.bnf.setData(this.ajg);
        this.bJw.setFromCDN(this.aiG);
        this.bJw.setData(this.ajg.sL());
        this.bnf.setUserAfterClickListener(this.anJ);
        this.bnj.setData(bhVar);
        this.mStType = m.rm();
        if (this.bnf.getHeaderImg() != null) {
            if (this.bnf.getIsSimpleThread()) {
                this.bnf.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (bhVar.getAuthor() == null || bhVar.getAuthor().getPendantData() == null || StringUtils.isNull(bhVar.getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.bnf.getHeaderImg().setVisibility(0);
                this.bnf.getHeaderImg().setData(bhVar);
            } else {
                this.bnf.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(bhVar);
            }
        }
        y(bhVar);
        ArrayList<VoiceData.VoiceModel> rJ = bhVar.rJ();
        if (com.baidu.tbadk.core.util.v.u(rJ)) {
            this.bLr.setVisibility(8);
            dB(false);
        } else {
            this.bLr.setVisibility(0);
            dB(true);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bLr.setVoiceModel(voiceModel);
            this.bLr.setTag(voiceModel);
            this.bLr.bgh();
            if (voiceModel != null) {
                this.bLr.nh(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rF = bhVar.rF();
        if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.t(rF) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < rF.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                this.bLu.setVisibility(0);
                this.bLu.setFromCDN(this.aiG);
                this.bLu.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        x<bh> Xr = l.this.Xr();
                        if (z) {
                            if (Xr != null) {
                                view.setTag("1");
                                Xr.aUA = true;
                                Xr.a(view, l.this.ajg);
                            }
                            l.this.dA(false);
                            return;
                        }
                        if (Xr != null) {
                            view.setTag("1");
                            Xr.aUA = false;
                            Xr.a(view, l.this.ajg);
                        }
                        l.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.bLu.setImageMediaList(linkedList);
            } else {
                this.bLu.setVisibility(8);
            }
        } else {
            this.bLu.setVisibility(8);
        }
        XH();
        XI();
        F(bhVar);
        XK();
    }

    private void XH() {
        if (this.bLs != null && this.bLu != null && this.bJw != null) {
            if (this.bLu.getVisibility() == 8 && this.bJw.getVisibility() == 8) {
                this.bLs.setVisibility(0);
            } else {
                this.bLs.setVisibility(8);
            }
        }
    }

    private void dB(boolean z) {
        if (this.bLu != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLu.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            }
            this.bLu.setLayoutParams(layoutParams);
        }
    }

    public void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.csu != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.csu.setVisibility(8);
                return;
            }
            this.csu.setVisibility(0);
            this.csu.setImageBitmap(null);
            this.csu.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.csu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mG.getPageActivity(), themeCard.getCardId())));
                }
            });
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
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
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
        int childCount = this.bLu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLu.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiG = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bnj != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bnf != null) {
            this.bnf.setPageUniqueId(bdUniqueId);
        }
        if (this.bLu != null) {
            this.bLu.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(boolean z) {
        if (this.ajg != null) {
            m.jm(this.ajg.getId());
            m.a(this.mTitle, this.ajg.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLt, this.ajg.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJw.getGodReplyContent(), this.ajg.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sr = this.ajg.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mG.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
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
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mG.getPageActivity()).createFromThreadCfg(this.ajg, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajg.getFid()));
            addLocateParam.setForumName(this.ajg.rA());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xv() {
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
        if (this.bLr != null) {
            this.bLr.setVoiceManager(voiceManager);
        }
    }

    private boolean y(bh bhVar) {
        SpannableStringBuilder g = bhVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        return true;
    }

    private void XK() {
        if (this.mTitle != null && this.bLr != null && this.bLu != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLr.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
            this.bLr.setLayoutParams(layoutParams);
            if (this.bLr.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLu.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
                this.bLu.setLayoutParams(layoutParams2);
            }
        }
    }
}
