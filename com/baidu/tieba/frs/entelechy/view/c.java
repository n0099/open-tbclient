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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, z {
    private TextView agm;
    protected bw agx;
    private String ahu;
    private final View.OnClickListener ajG;
    protected boolean akk;
    private PlayVoiceBntNew akw;
    private AppletsCellView alA;
    private RelativeLayout bET;
    protected View fQl;
    public LinearLayout fXV;
    public ThreadUserInfoLayout gSQ;
    protected ThreadCommentAndPraiseInfoLayout gSR;
    protected ThreadSourceShareAndPraiseLayout gTD;
    private ThreadGodReplyLayout hXG;
    private HeadPendantClickableView hXH;
    protected View hYe;
    protected ConstrainImageGroup hYg;
    private View.OnClickListener hYl;
    private final View.OnClickListener hYm;
    public TbImageView hZP;
    private TbImageView hZR;
    private String iTG;
    private i iTw;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akk = true;
        this.hYl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) {
                    if (c.this.gSR != null) {
                        c.this.gSR.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cnT() != null) {
                    c.this.cnT().a(view, c.this.agx);
                }
                c.this.os(view == c.this.hXG);
            }
        };
        this.hYm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bw> cnT = c.this.cnT();
                if (cnT != null) {
                    view.setTag("2");
                    cnT.a(view, c.this.agx);
                }
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cnT() != null) {
                    c.this.cnT().a(view, c.this.agx);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hXH = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hXH.getHeadView() != null) {
            this.hXH.getHeadView().setIsRound(true);
            this.hXH.getHeadView().setDrawBorder(false);
            this.hXH.getHeadView().setDefaultResource(17170445);
            this.hXH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hXH.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hXH.setHasPendantStyle();
        if (this.hXH.getPendantView() != null) {
            this.hXH.getPendantView().setIsRound(true);
            this.hXH.getPendantView().setDrawBorder(false);
        }
        this.hXH.setAfterClickListener(this.ajG);
        this.fQl = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akw.setAfterClickListener(this.hYm);
        this.agm = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.agm.setVisibility(8);
        this.hYe = view.findViewById(R.id.divider_line_above_praise);
        this.hYg = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hYg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hYg.setChildClickListener(this.hYl);
        f fVar = new f(3);
        fVar.y(1.0d);
        this.hYg.setImageProcessor(fVar);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gSQ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gSQ.setUserAfterClickListener(this.ajG);
        this.gSQ.setFrom(3);
        this.gSR.setOnClickListener(this.hYl);
        this.gSR.setForumAfterClickListener(this.ajG);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setIsBarViewVisible(false);
        this.gSR.setShareVisible(true);
        this.gSR.setShareReportFrom(1);
        this.gSR.setStType("frs_page");
        this.gSR.setFrom(2);
        this.gSR.eWz = 3;
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gTD != null) {
            this.gTD.eXx.setOnClickListener(this.hYl);
            this.gTD.setFrom(2);
            this.gTD.setShareReportFrom(1);
            this.gTD.setSourceFromForPb(3);
            this.gTD.setStType("frs_page");
            this.gTD.setHideBarName(true);
            this.gTD.eXx.setNeedAddReplyIcon(true);
        }
        this.bET = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.iTw = new i(this.mPageContext, this.bET);
        this.iTw.setUniqueId(getTag());
        this.hXG = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hXG.setOnClickListener(this.hYl);
        this.hZP = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.hZP.setPageId(getTag());
        this.hZR = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.hZR != null) {
            this.hZR.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gSR != null) {
                    c.this.gSR.changeSelectStatus();
                }
            }
        });
        this.gSR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void js(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fXV = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.alA = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hYg != null) {
            this.hYg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYg != null) {
            this.hYg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYg != null) {
            this.hYg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
            this.hYg.onChangeSkinType();
            this.gSR.onChangeSkinType();
            this.gSQ.onChangeSkinType();
            if (this.alA != null) {
                this.alA.onChangeSkinType();
            }
            this.iTw.onChangeSkinType();
            if (this.gTD != null && this.gTD.getVisibility() == 0) {
                this.gTD.onChangeSkinType();
            }
            if (this.hXH != null && this.hXH.getHeadView() != null && (this.hXH.getHeadView() instanceof TbImageView)) {
                this.hXH.getHeadView().setPlaceHolder(1);
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
        this.agx = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hYl);
        }
        this.hXG.onChangeSkinType();
        if (!coc() && n.Ja(this.agx.getId())) {
            n.a(this.mTitle, this.agx.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.agm, this.agx.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            n.a(this.hXG.getGodReplyContent(), this.agx.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bwVar);
        this.iTw.ay(this.agx);
        Y(bwVar);
        this.gSQ.setData(this.agx);
        this.hXG.setFromCDN(this.akk);
        this.hXG.setData(this.agx.bod());
        this.gSQ.setUserAfterClickListener(this.ajG);
        vf(tj(1));
        if (this.gSQ.getHeaderImg() != null) {
            if (this.gSQ.getIsSimpleThread()) {
                this.gSQ.getHeaderImg().setVisibility(8);
                this.hXH.setVisibility(8);
            } else if (bwVar.bmA() == null || bwVar.bmA().getPendantData() == null || StringUtils.isNull(bwVar.bmA().getPendantData().bkw())) {
                this.hXH.setVisibility(8);
                this.gSQ.getHeaderImg().setVisibility(0);
                this.gSQ.getHeaderImg().setData(bwVar);
            } else {
                this.gSQ.getHeaderImg().setVisibility(4);
                this.hXH.setVisibility(0);
                this.hXH.setData(bwVar);
            }
        }
        ar(bwVar);
        as(bwVar);
        this.alA.setData(bwVar.bnp());
        this.alA.setForumId(String.valueOf(bwVar.getFid()));
        AppletsCellView appletsCellView = this.alA;
        AppletsCellView appletsCellView2 = this.alA;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bmN = bwVar.bmN();
        if (y.isEmpty(bmN)) {
            this.akw.setVisibility(8);
        } else {
            this.akw.bZl();
            this.akw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bmN.get(0);
            this.akw.setVoiceModel(voiceModel);
            this.akw.setTag(voiceModel);
            this.akw.changeSkin();
            if (voiceModel != null) {
                this.akw.Dz(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        if (k.bjH().isShowImages() && y.getCount(bmJ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bmJ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bmJ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.hYg.setVisibility(0);
                this.hYg.setFromCDN(this.akk);
                this.hYg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bw> cnT = c.this.cnT();
                        if (z) {
                            if (cnT != null) {
                                view.setTag("1");
                                cnT.aiJ = true;
                                cnT.a(view, c.this.agx);
                            }
                            c.this.os(false);
                            return;
                        }
                        if (cnT != null) {
                            view.setTag("1");
                            cnT.aiJ = false;
                            cnT.a(view, c.this.agx);
                        }
                        c.this.a(view, linkedList, i2, bwVar);
                    }
                });
                this.hYg.setImageMediaList(linkedList);
            } else {
                this.hYg.setVisibility(8);
            }
        } else {
            this.hYg.setVisibility(8);
        }
        cok();
        col();
        cCo();
        if ((com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) && this.gSR.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agx.bol() || this.agx.bom() || this.agx.bon()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cok() {
        if (this.hYe != null && this.hYg != null && this.hXG != null) {
            if (this.hYg.getVisibility() == 8 && this.hXG.getVisibility() == 8 && this.alA.getVisibility() == 8) {
                this.hYe.setVisibility(0);
            } else {
                this.hYe.setVisibility(8);
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hZR != null) {
            if (this.hZP == null || bwVar == null) {
                this.hZR.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.eGo) && this.hZP.getVisibility() != 0) {
                if (this.iTw != null && this.iTw.cGc() && (this.hZR.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZR.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hZR.setLayoutParams(layoutParams);
                }
                this.hZR.setVisibility(0);
                this.hZR.setImageDrawable(null);
                this.hZR.startLoad(bwVar.eGo, 10, false);
                this.hZR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bwVar.eGp, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hZR.setVisibility(8);
            }
        }
    }

    public void b(bw bwVar) {
        MetaData bmA;
        if (bwVar != null && this.hZP != null && (bmA = bwVar.bmA()) != null) {
            final ThemeCardInUserData themeCard = bmA.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hZP.setVisibility(8);
                return;
            }
            this.hZP.setVisibility(0);
            this.hZP.setImageDrawable(null);
            this.hZP.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hZP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.akk ? 13 : 14;
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
        if (!y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nP(i).AE(bwVar.bmE()).AF(String.valueOf(bwVar.getFid())).AG(bwVar.getTid()).ix(this.akk).AH(arrayList.size() > 0 ? arrayList.get(0) : "").iy(true).a(concurrentHashMap).iz(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
            dU.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bwVar.getId();
            historyMessage.threadName = bwVar.getTitle();
            historyMessage.forumName = bwVar.bmE();
            historyMessage.postID = bwVar.bmR();
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

    private void col() {
        this.akw.setClickable(true);
        int childCount = this.hYg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hYg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSR != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gSQ != null) {
            this.gSQ.setPageUniqueId(bdUniqueId);
        }
        if (this.hYg != null) {
            this.hYg.setPageUniqueId(bdUniqueId);
        }
    }

    protected void os(boolean z) {
        if (this.agx != null) {
            n.IZ(this.agx.getId());
            n.a(this.mTitle, this.agx.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.agm, this.agx.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            n.a(this.hXG.getGodReplyContent(), this.agx.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r bnL = this.agx.bnL();
            if (bnL != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bnL.getCartoonId(), bnL.getChapterId(), 2)));
                return;
            }
            o oVar = this.agx.eFM;
            if (this.agx.eFL == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.ezT;
                long j = oVar.ezU;
                au auVar = new au();
                auVar.pageContext = this.mPageContext;
                auVar.eAt = str;
                auVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.agx, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.agx.bnH() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean coc() {
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
    public void vd(int i) {
        this.currentPageType = i;
        if (this.gSR != null) {
            this.gSR.eWz = i;
            this.gSR.setFrom(2);
        }
        if (this.gSQ != null) {
            this.gSQ.setFrom(3);
        }
    }

    private boolean ar(bw bwVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iTG)) {
            bwVar.dG(this.mUrl, this.iTG);
        }
        SpannableStringBuilder B = bwVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        return true;
    }

    private void as(bw bwVar) {
        if (bwVar != null && tj(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iTG)) {
                bwVar.dG(this.mUrl, this.iTG);
            }
            SpannableString bnv = bwVar.bnv();
            if (bnv != null && !at.isEmpty(bnv.toString())) {
                this.agm.setVisibility(0);
                this.agm.setOnTouchListener(new com.baidu.tieba.view.i(bnv));
                this.agm.setText(bnv);
                n.a(this.agm, bwVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.agm.setVisibility(8);
            return;
        }
        this.agm.setVisibility(8);
    }

    private void cCo() {
        if (this.mTitle != null && this.akw != null && this.hYg != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.akw.setLayoutParams(layoutParams);
            if (this.akw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hYg.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hYg.setLayoutParams(layoutParams2);
            }
        }
    }

    public void vf(int i) {
        if (this.agx != null) {
            if (i == 1) {
                this.gSR.setVisibility(8);
                if (this.gTD != null) {
                    this.gTD.setData(this.agx);
                    return;
                }
                return;
            }
            this.gSR.setData(this.agx);
            if (this.gTD != null) {
                this.gTD.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int tj(int i) {
        return com.baidu.tieba.a.d.bIR().ax(this.ahu, i);
    }
}
