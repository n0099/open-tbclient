package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
import android.text.SpannableString;
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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.vc.g;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bg> implements com.baidu.tieba.a.e, z {
    private TextView XJ;
    protected bg XR;
    private String Yz;
    private final View.OnClickListener ZF;
    protected boolean ZO;
    private PlayVoiceBntNew ZX;
    private AppletsCellView aaG;
    protected View cKN;
    public ThreadUserInfoLayout dqy;
    protected ThreadCommentAndPraiseInfoLayout dqz;
    protected ThreadSourceShareAndPraiseLayout dro;
    public LinearLayout drz;
    private RelativeLayout eCz;
    private ThreadGodReplyLayout ehN;
    private HeadPendantClickableView ehO;
    protected View eip;
    protected ConstrainImageGroup eir;
    private View.OnClickListener eiw;
    private final View.OnClickListener eix;
    public TbImageView ejZ;
    private TbImageView ekb;
    private String fiJ;
    private g fiz;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZO = true;
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bbF().bbG()) {
                    if (c.this.dqz != null) {
                        c.this.dqz.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.XR);
                }
                c.this.hL(view == c.this.ehN);
            }
        };
        this.eix = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQh = c.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, c.this.XR);
                }
            }
        };
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.XR);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.ehO = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehO.setHasPendantStyle();
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
        }
        this.ehO.setAfterClickListener(this.ZF);
        this.cKN = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.ZX = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.ZX.setAfterClickListener(this.eix);
        this.XJ = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.XJ.setVisibility(8);
        this.eip = view.findViewById(d.g.divider_line_above_praise);
        this.eir = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.eir.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.eir.setChildClickListener(this.eiw);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eir.setImageProcessor(fVar);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.dqy.setUserAfterClickListener(this.ZF);
        this.dqy.setFrom(3);
        this.dqz.setOnClickListener(this.eiw);
        this.dqz.setForumAfterClickListener(this.ZF);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShareVisible(true);
        this.dqz.setShareReportFrom(1);
        this.dqz.setStType("frs_page");
        this.dqz.setFrom(2);
        this.dqz.setDisPraiseFrom(2);
        this.dqz.bSG = 3;
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.dro != null) {
            this.dro.bTy.setOnClickListener(this.eiw);
            this.dro.setFrom(2);
            this.dro.setShareReportFrom(1);
            this.dro.setSourceFromForPb(3);
            this.dro.setStType("frs_page");
            this.dro.setHideBarName(true);
            this.dro.bTy.setNeedAddReplyIcon(true);
        }
        this.eCz = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.fiz = new g(this.mPageContext, this.eCz);
        this.fiz.setUniqueId(getTag());
        this.ehN = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.ehN.setOnClickListener(this.eiw);
        this.ejZ = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ejZ.setPageId(getTag());
        this.ekb = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.ekb != null) {
            this.ekb.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dqz != null) {
                    c.this.dqz.changeSelectStatus();
                }
            }
        });
        this.dqz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(al.getColor(z ? d.C0236d.cp_bg_line_d : d.C0236d.transparent));
                }
            }
        });
        this.drz = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.aaG = (AppletsCellView) view.findViewById(d.g.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eir != null) {
            this.eir.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eir != null) {
            this.eir.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eir != null) {
            this.eir.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.cKN, d.C0236d.cp_bg_line_e);
            this.eir.onChangeSkinType();
            this.dqz.onChangeSkinType();
            this.dqy.onChangeSkinType();
            if (this.aaG != null) {
                this.aaG.onChangeSkinType();
            }
            this.fiz.onChangeSkinType();
            if (this.dro != null && this.dro.getVisibility() == 0) {
                this.dro.onChangeSkinType();
            }
            if (this.ehO != null && this.ehO.getHeadView() != null && (this.ehO.getHeadView() instanceof TbImageView)) {
                this.ehO.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.XR = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eiw);
        }
        this.ehN.onChangeSkinType();
        if (!aQr() && n.tC(this.XR.getId())) {
            n.a(this.mTitle, this.XR.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            n.a(this.XJ, this.XR.getId(), d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
            n.a(this.ehN.getGodReplyContent(), this.XR.getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
        }
        b(bgVar);
        this.fiz.an(this.XR);
        S(bgVar);
        this.dqy.setData(this.XR);
        this.ehN.setFromCDN(this.ZO);
        this.ehN.setData(this.XR.aap());
        this.dqy.setUserAfterClickListener(this.ZF);
        mF(lt(1));
        if (this.dqy.getHeaderImg() != null) {
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (bgVar.YR() == null || bgVar.YR().getPendantData() == null || StringUtils.isNull(bgVar.YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(bgVar);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(bgVar);
            }
        }
        ah(bgVar);
        ai(bgVar);
        this.aaG.setData(bgVar.ZD());
        this.aaG.setForumId(String.valueOf(bgVar.getFid()));
        AppletsCellView appletsCellView = this.aaG;
        AppletsCellView appletsCellView2 = this.aaG;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZX.setVisibility(8);
        } else {
            this.ZX.cfA();
            this.ZX.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZX.setVoiceModel(voiceModel);
            this.ZX.setTag(voiceModel);
            this.ZX.bxV();
            if (voiceModel != null) {
                this.ZX.uu(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (i.Wy().WC() && v.S(Zb) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.eir.setVisibility(0);
                this.eir.setFromCDN(this.ZO);
                this.eir.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQh = c.this.aQh();
                        if (z) {
                            if (aQh != null) {
                                view.setTag("1");
                                aQh.Zv = true;
                                aQh.a(view, c.this.XR);
                            }
                            c.this.hL(false);
                            return;
                        }
                        if (aQh != null) {
                            view.setTag("1");
                            aQh.Zv = false;
                            aQh.a(view, c.this.XR);
                        }
                        c.this.a(view, linkedList, i2, bgVar);
                    }
                });
                this.eir.setImageMediaList(linkedList);
            } else {
                this.eir.setVisibility(8);
            }
        } else {
            this.eir.setVisibility(8);
        }
        aQy();
        aQz();
        bfT();
        if (this.dqz.isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.mMaskView.setVisibility(0);
            if (this.XR.aaA() || this.XR.aaB()) {
                al.l(this.mMaskView, d.C0236d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(d.C0236d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aQy() {
        if (this.eip != null && this.eir != null && this.ehN != null) {
            if (this.eir.getVisibility() == 8 && this.ehN.getVisibility() == 8 && this.aaG.getVisibility() == 8) {
                this.eip.setVisibility(0);
            } else {
                this.eip.setVisibility(8);
            }
        }
    }

    private void S(final bg bgVar) {
        if (this.ekb != null) {
            if (this.ejZ == null || bgVar == null) {
                this.ekb.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDu) && this.ejZ.getVisibility() != 0) {
                if (this.fiz != null && this.fiz.bjm() && (this.ekb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ekb.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ekb.setLayoutParams(layoutParams);
                }
                this.ekb.setVisibility(0);
                this.ekb.setImageDrawable(null);
                this.ekb.startLoad(bgVar.bDu, 10, false);
                this.ekb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bgVar.bDv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ekb.setVisibility(8);
            }
        }
    }

    public void b(bg bgVar) {
        MetaData YR;
        if (bgVar != null && this.ejZ != null && (YR = bgVar.YR()) != null) {
            final ThemeCardInUserData themeCard = YR.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejZ.setVisibility(8);
                return;
            }
            this.ejZ.setVisibility(0);
            this.ejZ.setImageDrawable(null);
            this.ejZ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.ZO ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.T(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZO, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bgVar.getId();
            historyMessage.threadName = bgVar.getTitle();
            historyMessage.forumName = bgVar.YW();
            historyMessage.postID = bgVar.Zh();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
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

    private void aQz() {
        this.ZX.setClickable(true);
        int childCount = this.eir.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eir.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqz != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
        if (this.eir != null) {
            this.eir.setPageUniqueId(bdUniqueId);
        }
    }

    protected void hL(boolean z) {
        if (this.XR != null) {
            n.tB(this.XR.getId());
            n.a(this.mTitle, this.XR.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            n.a(this.XJ, this.XR.getId(), d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
            n.a(this.ehN.getGodReplyContent(), this.XR.getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
            o ZU = this.XR.ZU();
            if (ZU != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.cY(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ZU.getCartoonId(), ZU.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.XR.bCK;
            if (this.XR.bCJ == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bxF;
                long j = lVar.bxG;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bxT = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.XR, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.XR.ZQ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aQr() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.currentPageType = i;
        if (this.dqz != null) {
            this.dqz.bSG = i;
            if (i == 15) {
                this.dqz.setFrom(10);
            } else {
                this.dqz.setFrom(2);
                this.dqz.setDisPraiseFrom(2);
            }
        }
        if (this.dqy != null) {
            if (i == 15) {
                this.dqy.setFrom(5);
            } else {
                this.dqy.setFrom(3);
            }
        }
    }

    private boolean ah(bg bgVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fiJ)) {
            bgVar.bt(this.mUrl, this.fiJ);
        }
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        }
        return true;
    }

    private void ai(bg bgVar) {
        if (bgVar != null && lt(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fiJ)) {
                bgVar.bt(this.mUrl, this.fiJ);
            }
            SpannableString aas = bgVar.aas();
            if (aas != null && !ap.isEmpty(aas.toString())) {
                this.XJ.setVisibility(0);
                this.XJ.setOnTouchListener(new k(aas));
                this.XJ.setText(aas);
                n.a(this.XJ, bgVar.getId(), d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
                return;
            }
            this.XJ.setVisibility(8);
            return;
        }
        this.XJ.setVisibility(8);
    }

    private void bfT() {
        if (this.mTitle != null && this.ZX != null && this.eir != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZX.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.ZX.setLayoutParams(layoutParams);
            if (this.ZX.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eir.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.eir.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mF(int i) {
        if (this.XR != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                if (this.dro != null) {
                    this.dro.setData(this.XR);
                    return;
                }
                return;
            }
            this.dqz.setData(this.XR);
            if (this.dro != null) {
                this.dro.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.Yz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eir != null) {
            this.eir.setPreloadSizeReadyCallback(bVar);
        }
    }
}
