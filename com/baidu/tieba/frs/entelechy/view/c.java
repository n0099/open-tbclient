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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<cb> implements e, z {
    protected cb aiB;
    private TextView air;
    private String ajx;
    private final View.OnClickListener alB;
    protected boolean amh;
    private PlayVoiceBntNew amu;
    private AppletsCellView anz;
    private RelativeLayout bND;
    protected View ghb;
    public LinearLayout gpQ;
    protected ThreadSourceShareAndPraiseLayout hpQ;
    public ThreadUserInfoLayout hpd;
    protected ThreadCommentAndPraiseInfoLayout hpe;
    public TbImageView iAJ;
    private TbImageView iAL;
    protected View iyS;
    protected ConstrainImageGroup iyU;
    private View.OnClickListener iyZ;
    private ThreadGodReplyLayout iyu;
    private HeadPendantClickableView iyv;
    private final View.OnClickListener iza;
    private i juC;
    private String juM;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.amh = true;
        this.iyZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) {
                    if (c.this.hpe != null) {
                        c.this.hpe.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.csi() != null) {
                    c.this.csi().a(view, c.this.aiB);
                }
                c.this.pv(view == c.this.iyu);
            }
        };
        this.iza = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<cb> csi = c.this.csi();
                if (csi != null) {
                    view.setTag("2");
                    csi.a(view, c.this.aiB);
                }
            }
        };
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.csi() != null) {
                    c.this.csi().a(view, c.this.aiB);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.iyv = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iyv.getHeadView() != null) {
            this.iyv.getHeadView().setIsRound(true);
            this.iyv.getHeadView().setDrawBorder(false);
            this.iyv.getHeadView().setDefaultResource(17170445);
            this.iyv.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iyv.setHasPendantStyle();
        if (this.iyv.getPendantView() != null) {
            this.iyv.getPendantView().setIsRound(true);
            this.iyv.getPendantView().setDrawBorder(false);
        }
        this.iyv.setAfterClickListener(this.alB);
        this.ghb = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.amu = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.amu.setAfterClickListener(this.iza);
        this.air = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.air.setVisibility(8);
        this.iyS = view.findViewById(R.id.divider_line_above_praise);
        this.iyU = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iyU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iyU.setChildClickListener(this.iyZ);
        f fVar = new f(3);
        fVar.r(1.0d);
        this.iyU.setImageProcessor(fVar);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hpd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hpd.setUserAfterClickListener(this.alB);
        this.hpd.setFrom(3);
        this.hpe.setOnClickListener(this.iyZ);
        this.hpe.setForumAfterClickListener(this.alB);
        this.hpe.setReplyTimeVisible(false);
        this.hpe.setShowPraiseNum(true);
        this.hpe.setNeedAddPraiseIcon(true);
        this.hpe.setNeedAddReplyIcon(true);
        this.hpe.setIsBarViewVisible(false);
        this.hpe.setShareVisible(true);
        this.hpe.setShareReportFrom(1);
        this.hpe.setStType("frs_page");
        this.hpe.setFrom(2);
        this.hpe.flV = 3;
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.hpQ != null) {
            this.hpQ.fmS.setOnClickListener(this.iyZ);
            this.hpQ.setFrom(2);
            this.hpQ.setShareReportFrom(1);
            this.hpQ.setSourceFromForPb(3);
            this.hpQ.setStType("frs_page");
            this.hpQ.setHideBarName(true);
            this.hpQ.fmS.setNeedAddReplyIcon(true);
        }
        this.bND = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.juC = new i(this.mPageContext, this.bND);
        this.juC.setUniqueId(getTag());
        this.iyu = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.iyu.setOnClickListener(this.iyZ);
        this.iAJ = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.iAJ.setPageId(getTag());
        this.iAL = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.iAL != null) {
            this.iAL.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.hpe != null) {
                    c.this.hpe.changeSelectStatus();
                }
            }
        });
        this.hpe.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
                }
            }
        });
        this.gpQ = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.anz = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.iyU != null) {
            this.iyU.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iyU != null) {
            this.iyU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iyU != null) {
            this.iyU.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.ghb, R.color.CAM_X0204);
            this.iyU.onChangeSkinType();
            this.hpe.onChangeSkinType();
            this.hpd.onChangeSkinType();
            if (this.anz != null) {
                this.anz.onChangeSkinType();
            }
            this.juC.onChangeSkinType();
            if (this.hpQ != null && this.hpQ.getVisibility() == 0) {
                this.hpQ.onChangeSkinType();
            }
            if (this.iyv != null && this.iyv.getHeadView() != null && (this.iyv.getHeadView() instanceof TbImageView)) {
                this.iyv.getHeadView().setPlaceHolder(1);
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
    public void a(final cb cbVar) {
        if (cbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiB = cbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iyZ);
        }
        this.iyu.onChangeSkinType();
        if (!csr() && m.IX(this.aiB.getId())) {
            m.a(this.mTitle, this.aiB.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.air, this.aiB.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.iyu.getGodReplyContent(), this.aiB.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        b(cbVar);
        this.juC.aB(this.aiB);
        ab(cbVar);
        this.hpd.setData(this.aiB);
        this.iyu.setFromCDN(this.amh);
        this.iyu.setData(this.aiB.bpx());
        this.hpd.setUserAfterClickListener(this.alB);
        vb(sY(1));
        if (this.hpd.getHeaderImg() != null) {
            if (this.hpd.getIsSimpleThread()) {
                this.hpd.getHeaderImg().setVisibility(8);
                this.iyv.setVisibility(8);
            } else if (cbVar.bnS() == null || cbVar.bnS().getPendantData() == null || StringUtils.isNull(cbVar.bnS().getPendantData().getImgUrl())) {
                this.iyv.setVisibility(8);
                this.hpd.getHeaderImg().setVisibility(0);
                this.hpd.getHeaderImg().setData(cbVar);
            } else {
                this.hpd.getHeaderImg().setVisibility(4);
                this.iyv.setVisibility(0);
                this.iyv.setData(cbVar);
            }
        }
        au(cbVar);
        av(cbVar);
        this.anz.setData(cbVar.boG());
        this.anz.setForumId(String.valueOf(cbVar.getFid()));
        AppletsCellView appletsCellView = this.anz;
        AppletsCellView appletsCellView2 = this.anz;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bof = cbVar.bof();
        if (y.isEmpty(bof)) {
            this.amu.setVisibility(8);
        } else {
            this.amu.ccH();
            this.amu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bof.get(0);
            this.amu.setVoiceModel(voiceModel);
            this.amu.setTag(voiceModel);
            this.amu.bur();
            if (voiceModel != null) {
                this.amu.Ds(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> bob = cbVar.bob();
        if (k.bkV().isShowImages() && y.getCount(bob) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bob.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bob, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.iyU.setVisibility(0);
                this.iyU.setFromCDN(this.amh);
                this.iyU.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        ab<cb> csi = c.this.csi();
                        if (z) {
                            if (csi != null) {
                                view.setTag("1");
                                csi.akF = true;
                                csi.a(view, c.this.aiB);
                            }
                            c.this.pv(false);
                            return;
                        }
                        if (csi != null) {
                            view.setTag("1");
                            csi.akF = false;
                            csi.a(view, c.this.aiB);
                        }
                        c.this.a(view, linkedList, i2, cbVar);
                    }
                });
                this.iyU.setImageMediaList(linkedList);
            } else {
                this.iyU.setVisibility(8);
            }
        } else {
            this.iyU.setVisibility(8);
        }
        csz();
        csA();
        cGU();
        if ((com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) && this.hpe.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aiB.bpF() || this.aiB.bpG() || this.aiB.bpH()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void csz() {
        if (this.iyS != null && this.iyU != null && this.iyu != null) {
            if (this.iyU.getVisibility() == 8 && this.iyu.getVisibility() == 8 && this.anz.getVisibility() == 8) {
                this.iyS.setVisibility(0);
            } else {
                this.iyS.setVisibility(8);
            }
        }
    }

    private void ab(final cb cbVar) {
        if (this.iAL != null) {
            if (this.iAJ == null || cbVar == null) {
                this.iAL.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eUE) && this.iAJ.getVisibility() != 0) {
                if (this.juC != null && this.juC.cLI() && (this.iAL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iAL.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.iAL.setLayoutParams(layoutParams);
                }
                this.iAL.setVisibility(0);
                this.iAL.setImageDrawable(null);
                this.iAL.startLoad(cbVar.eUE, 10, false);
                this.iAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", cbVar.eUF, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.iAL.setVisibility(8);
            }
        }
    }

    public void b(cb cbVar) {
        MetaData bnS;
        if (cbVar != null && this.iAJ != null && (bnS = cbVar.bnS()) != null) {
            final ThemeCardInUserData themeCard = bnS.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iAJ.setVisibility(8);
                return;
            }
            this.iAJ.setVisibility(0);
            this.iAJ.setImageDrawable(null);
            this.iAJ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, cb cbVar) {
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
                imageUrlData.urlType = this.amh ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(cbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mR(i).zQ(cbVar.bnW()).zR(String.valueOf(cbVar.getFid())).zS(cbVar.getTid()).jg(this.amh).zT(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).s(cbVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig eO = aVar.eO(this.mPageContext.getPageActivity());
            eO.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = cbVar.getId();
            historyMessage.threadName = cbVar.getTitle();
            historyMessage.forumName = cbVar.bnW();
            historyMessage.postID = cbVar.boi();
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

    private void csA() {
        this.amu.setClickable(true);
        int childCount = this.iyU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iyU.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hpe != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hpd != null) {
            this.hpd.setPageUniqueId(bdUniqueId);
        }
        if (this.iyU != null) {
            this.iyU.setPageUniqueId(bdUniqueId);
        }
    }

    protected void pv(boolean z) {
        if (this.aiB != null) {
            m.IW(this.aiB.getId());
            m.a(this.mTitle, this.aiB.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.air, this.aiB.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.iyu.getGodReplyContent(), this.aiB.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            t bpe = this.aiB.bpe();
            if (bpe != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bh.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bpe.getCartoonId(), bpe.getChapterId(), 2)));
                return;
            }
            q qVar = this.aiB.eUc;
            if (this.aiB.eUb == 1 && qVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = qVar.eOb;
                long j = qVar.eOc;
                ay ayVar = new ay();
                ayVar.pageContext = this.mPageContext;
                ayVar.eOB = str;
                ayVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ayVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aiB, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aiB.bpa() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean csr() {
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
    public void uZ(int i) {
        this.currentPageType = i;
        if (this.hpe != null) {
            this.hpe.flV = i;
            this.hpe.setFrom(2);
        }
        if (this.hpd != null) {
            this.hpd.setFrom(3);
        }
    }

    private boolean au(cb cbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.juM)) {
            cbVar.dD(this.mUrl, this.juM);
        }
        SpannableStringBuilder A = cbVar.A(false, true);
        if (A == null || StringUtils.isNull(A.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(A));
            this.mTitle.setText(A);
            m.a(this.mTitle, cbVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        return true;
    }

    private void av(cb cbVar) {
        if (cbVar != null && sY(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.juM)) {
                cbVar.dD(this.mUrl, this.juM);
            }
            SpannableString boO = cbVar.boO();
            if (boO != null && !au.isEmpty(boO.toString())) {
                this.air.setVisibility(0);
                this.air.setOnTouchListener(new com.baidu.tieba.view.i(boO));
                this.air.setText(boO);
                m.a(this.air, cbVar.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.air.setVisibility(8);
            return;
        }
        this.air.setVisibility(8);
    }

    private void cGU() {
        if (this.mTitle != null && this.amu != null && this.iyU != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amu.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.amu.setLayoutParams(layoutParams);
            if (this.amu.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iyU.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.iyU.setLayoutParams(layoutParams2);
            }
        }
    }

    public void vb(int i) {
        if (this.aiB != null) {
            if (i == 1) {
                this.hpe.setVisibility(8);
                if (this.hpQ != null) {
                    this.hpQ.setData(this.aiB);
                    return;
                }
                return;
            }
            this.hpe.setData(this.aiB);
            if (this.hpQ != null) {
                this.hpQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }
}
