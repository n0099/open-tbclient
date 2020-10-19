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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private TextView agl;
    protected bw agw;
    private String aht;
    private final View.OnClickListener ajF;
    protected boolean akj;
    private PlayVoiceBntNew akv;
    private AppletsCellView alz;
    private RelativeLayout bwu;
    protected View fCa;
    public LinearLayout fJK;
    public ThreadUserInfoLayout gAD;
    protected ThreadCommentAndPraiseInfoLayout gAE;
    protected ThreadSourceShareAndPraiseLayout gBq;
    protected View hFK;
    protected ConstrainImageGroup hFM;
    private View.OnClickListener hFR;
    private final View.OnClickListener hFS;
    private ThreadGodReplyLayout hFm;
    private HeadPendantClickableView hFn;
    public TbImageView hHv;
    private TbImageView hHx;
    private i iBd;
    private String iBn;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akj = true;
        this.hFR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) {
                    if (c.this.gAE != null) {
                        c.this.gAE.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cil() != null) {
                    c.this.cil().a(view, c.this.agw);
                }
                c.this.nR(view == c.this.hFm);
            }
        };
        this.hFS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bw> cil = c.this.cil();
                if (cil != null) {
                    view.setTag("2");
                    cil.a(view, c.this.agw);
                }
            }
        };
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cil() != null) {
                    c.this.cil().a(view, c.this.agw);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hFn = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hFn.getHeadView() != null) {
            this.hFn.getHeadView().setIsRound(true);
            this.hFn.getHeadView().setDrawBorder(false);
            this.hFn.getHeadView().setDefaultResource(17170445);
            this.hFn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hFn.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hFn.setHasPendantStyle();
        if (this.hFn.getPendantView() != null) {
            this.hFn.getPendantView().setIsRound(true);
            this.hFn.getPendantView().setDrawBorder(false);
        }
        this.hFn.setAfterClickListener(this.ajF);
        this.fCa = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akv = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akv.setAfterClickListener(this.hFS);
        this.agl = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.agl.setVisibility(8);
        this.hFK = view.findViewById(R.id.divider_line_above_praise);
        this.hFM = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hFM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hFM.setChildClickListener(this.hFR);
        f fVar = new f(3);
        fVar.x(1.0d);
        this.hFM.setImageProcessor(fVar);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gAD = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gAD.setUserAfterClickListener(this.ajF);
        this.gAD.setFrom(3);
        this.gAE.setOnClickListener(this.hFR);
        this.gAE.setForumAfterClickListener(this.ajF);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setIsBarViewVisible(false);
        this.gAE.setShareVisible(true);
        this.gAE.setShareReportFrom(1);
        this.gAE.setStType("frs_page");
        this.gAE.setFrom(2);
        this.gAE.eIo = 3;
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gBq != null) {
            this.gBq.eJm.setOnClickListener(this.hFR);
            this.gBq.setFrom(2);
            this.gBq.setShareReportFrom(1);
            this.gBq.setSourceFromForPb(3);
            this.gBq.setStType("frs_page");
            this.gBq.setHideBarName(true);
            this.gBq.eJm.setNeedAddReplyIcon(true);
        }
        this.bwu = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.iBd = new i(this.mPageContext, this.bwu);
        this.iBd.setUniqueId(getTag());
        this.hFm = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hFm.setOnClickListener(this.hFR);
        this.hHv = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.hHv.setPageId(getTag());
        this.hHx = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.hHx != null) {
            this.hHx.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gAE != null) {
                    c.this.gAE.changeSelectStatus();
                }
            }
        });
        this.gAE.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iW(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fJK = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.alz = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hFM != null) {
            this.hFM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hFM != null) {
            this.hFM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hFM != null) {
            this.hFM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c);
            this.hFM.onChangeSkinType();
            this.gAE.onChangeSkinType();
            this.gAD.onChangeSkinType();
            if (this.alz != null) {
                this.alz.onChangeSkinType();
            }
            this.iBd.onChangeSkinType();
            if (this.gBq != null && this.gBq.getVisibility() == 0) {
                this.gBq.onChangeSkinType();
            }
            if (this.hFn != null && this.hFn.getHeadView() != null && (this.hFn.getHeadView() instanceof TbImageView)) {
                this.hFn.getHeadView().setPlaceHolder(1);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(final bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agw = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hFR);
        }
        this.hFm.onChangeSkinType();
        if (!ciu() && m.Ik(this.agw.getId())) {
            m.a(this.mTitle, this.agw.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.agl, this.agw.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hFm.getGodReplyContent(), this.agw.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bwVar);
        this.iBd.ay(this.agw);
        Y(bwVar);
        this.gAD.setData(this.agw);
        this.hFm.setFromCDN(this.akj);
        this.hFm.setData(this.agw.bjK());
        this.gAD.setUserAfterClickListener(this.ajF);
        uz(sO(1));
        if (this.gAD.getHeaderImg() != null) {
            if (this.gAD.getIsSimpleThread()) {
                this.gAD.getHeaderImg().setVisibility(8);
                this.hFn.setVisibility(8);
            } else if (bwVar.bih() == null || bwVar.bih().getPendantData() == null || StringUtils.isNull(bwVar.bih().getPendantData().bgd())) {
                this.hFn.setVisibility(8);
                this.gAD.getHeaderImg().setVisibility(0);
                this.gAD.getHeaderImg().setData(bwVar);
            } else {
                this.gAD.getHeaderImg().setVisibility(4);
                this.hFn.setVisibility(0);
                this.hFn.setData(bwVar);
            }
        }
        ar(bwVar);
        as(bwVar);
        this.alz.setData(bwVar.biW());
        this.alz.setForumId(String.valueOf(bwVar.getFid()));
        AppletsCellView appletsCellView = this.alz;
        AppletsCellView appletsCellView2 = this.alz;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> biu = bwVar.biu();
        if (com.baidu.tbadk.core.util.y.isEmpty(biu)) {
            this.akv.setVisibility(8);
        } else {
            this.akv.bTK();
            this.akv.setVisibility(0);
            VoiceData.VoiceModel voiceModel = biu.get(0);
            this.akv.setVoiceModel(voiceModel);
            this.akv.setTag(voiceModel);
            this.akv.changeSkin();
            if (voiceModel != null) {
                this.akv.CT(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> biq = bwVar.biq();
        if (k.bfo().isShowImages() && com.baidu.tbadk.core.util.y.getCount(biq) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < biq.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(biq, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                this.hFM.setVisibility(0);
                this.hFM.setFromCDN(this.akj);
                this.hFM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bw> cil = c.this.cil();
                        if (z) {
                            if (cil != null) {
                                view.setTag("1");
                                cil.aiI = true;
                                cil.a(view, c.this.agw);
                            }
                            c.this.nR(false);
                            return;
                        }
                        if (cil != null) {
                            view.setTag("1");
                            cil.aiI = false;
                            cil.a(view, c.this.agw);
                        }
                        c.this.a(view, linkedList, i2, bwVar);
                    }
                });
                this.hFM.setImageMediaList(linkedList);
            } else {
                this.hFM.setVisibility(8);
            }
        } else {
            this.hFM.setVisibility(8);
        }
        ciC();
        ciD();
        cwG();
        if ((com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) && this.gAE.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agw.bjS() || this.agw.bjT() || this.agw.bjU()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void ciC() {
        if (this.hFK != null && this.hFM != null && this.hFm != null) {
            if (this.hFM.getVisibility() == 8 && this.hFm.getVisibility() == 8 && this.alz.getVisibility() == 8) {
                this.hFK.setVisibility(0);
            } else {
                this.hFK.setVisibility(8);
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hHx != null) {
            if (this.hHv == null || bwVar == null) {
                this.hHx.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.erZ) && this.hHv.getVisibility() != 0) {
                if (this.iBd != null && this.iBd.cAu() && (this.hHx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHx.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hHx.setLayoutParams(layoutParams);
                }
                this.hHx.setVisibility(0);
                this.hHx.setImageDrawable(null);
                this.hHx.startLoad(bwVar.erZ, 10, false);
                this.hHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bwVar.esa, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hHx.setVisibility(8);
            }
        }
    }

    public void b(bw bwVar) {
        MetaData bih;
        if (bwVar != null && this.hHv != null && (bih = bwVar.bih()) != null) {
            final ThemeCardInUserData themeCard = bih.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hHv.setVisibility(8);
                return;
            }
            this.hHv.setVisibility(0);
            this.hHv.setImageDrawable(null);
            this.hHv.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.akj ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nu(i).zX(bwVar.bil()).zY(String.valueOf(bwVar.getFid())).zZ(bwVar.getTid()).ib(this.akj).Aa(arrayList.size() > 0 ? arrayList.get(0) : "").ic(true).a(concurrentHashMap).id(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
            dU.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bwVar.getId();
            historyMessage.threadName = bwVar.getTitle();
            historyMessage.forumName = bwVar.bil();
            historyMessage.postID = bwVar.biy();
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

    private void ciD() {
        this.akv.setClickable(true);
        int childCount = this.hFM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hFM.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gAE != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gAD != null) {
            this.gAD.setPageUniqueId(bdUniqueId);
        }
        if (this.hFM != null) {
            this.hFM.setPageUniqueId(bdUniqueId);
        }
    }

    protected void nR(boolean z) {
        if (this.agw != null) {
            m.Ij(this.agw.getId());
            m.a(this.mTitle, this.agw.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.agl, this.agw.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hFm.getGodReplyContent(), this.agw.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r bjs = this.agw.bjs();
            if (bjs != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bjs.getCartoonId(), bjs.getChapterId(), 2)));
                return;
            }
            o oVar = this.agw.erx;
            if (this.agw.erw == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.elA;
                long j = oVar.elB;
                au auVar = new au();
                auVar.pageContext = this.mPageContext;
                auVar.ema = str;
                auVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.agw, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.agw.bjo() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ciu() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.currentPageType = i;
        if (this.gAE != null) {
            this.gAE.eIo = i;
            this.gAE.setFrom(2);
        }
        if (this.gAD != null) {
            this.gAD.setFrom(3);
        }
    }

    private boolean ar(bw bwVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iBn)) {
            bwVar.dz(this.mUrl, this.iBn);
        }
        SpannableStringBuilder B = bwVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            m.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        return true;
    }

    private void as(bw bwVar) {
        if (bwVar != null && sO(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iBn)) {
                bwVar.dz(this.mUrl, this.iBn);
            }
            SpannableString bjc = bwVar.bjc();
            if (bjc != null && !at.isEmpty(bjc.toString())) {
                this.agl.setVisibility(0);
                this.agl.setOnTouchListener(new com.baidu.tieba.view.i(bjc));
                this.agl.setText(bjc);
                m.a(this.agl, bwVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.agl.setVisibility(8);
            return;
        }
        this.agl.setVisibility(8);
    }

    private void cwG() {
        if (this.mTitle != null && this.akv != null && this.hFM != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akv.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.akv.setLayoutParams(layoutParams);
            if (this.akv.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hFM.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hFM.setLayoutParams(layoutParams2);
            }
        }
    }

    public void uz(int i) {
        if (this.agw != null) {
            if (i == 1) {
                this.gAE.setVisibility(8);
                if (this.gBq != null) {
                    this.gBq.setData(this.agw);
                    return;
                }
                return;
            }
            this.gAE.setData(this.agw);
            if (this.gBq != null) {
                this.gBq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }
}
