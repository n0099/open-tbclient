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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private TextView Kf;
    protected bj Kn;
    private String Lg;
    private final View.OnClickListener MX;
    protected boolean Nj;
    private PlayVoiceBntNew Nw;
    private AppletsCellView Om;
    private RelativeLayout ayz;
    protected View caf;
    public ThreadUserInfoLayout eJq;
    protected ThreadCommentAndPraiseInfoLayout eJr;
    protected ThreadSourceShareAndPraiseLayout eKe;
    public LinearLayout ecC;
    private ThreadGodReplyLayout fGP;
    private HeadPendantClickableView fGQ;
    protected View fHo;
    protected ConstrainImageGroup fHq;
    private View.OnClickListener fHv;
    private final View.OnClickListener fHw;
    public TbImageView fIW;
    private TbImageView fIY;
    private i gwh;
    private String gwr;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Nj = true;
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bBr().bBs()) {
                    if (c.this.eJr != null) {
                        c.this.eJr.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bta() != null) {
                    c.this.bta().a(view, c.this.Kn);
                }
                c.this.kh(view == c.this.fGP);
            }
        };
        this.fHw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> bta = c.this.bta();
                if (bta != null) {
                    view.setTag("2");
                    bta.a(view, c.this.Kn);
                }
            }
        };
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bta() != null) {
                    c.this.bta().a(view, c.this.Kn);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.fGQ = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.fGQ.getHeadView() != null) {
            this.fGQ.getHeadView().setIsRound(true);
            this.fGQ.getHeadView().setDrawBorder(false);
            this.fGQ.getHeadView().setDefaultResource(17170445);
            this.fGQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fGQ.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.fGQ.setHasPendantStyle();
        if (this.fGQ.getPendantView() != null) {
            this.fGQ.getPendantView().setIsRound(true);
            this.fGQ.getPendantView().setDrawBorder(false);
        }
        this.fGQ.setAfterClickListener(this.MX);
        this.caf = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.Nw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.Nw.setAfterClickListener(this.fHw);
        this.Kf = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.Kf.setVisibility(8);
        this.fHo = view.findViewById(R.id.divider_line_above_praise);
        this.fHq = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.fHq.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fHq.setChildClickListener(this.fHv);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fHq.setImageProcessor(fVar);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.eJq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.eJq.setUserAfterClickListener(this.MX);
        this.eJq.setFrom(3);
        this.eJr.setOnClickListener(this.fHv);
        this.eJr.setForumAfterClickListener(this.MX);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setIsBarViewVisible(false);
        this.eJr.setShareVisible(true);
        this.eJr.setShareReportFrom(1);
        this.eJr.setStType("frs_page");
        this.eJr.setFrom(2);
        this.eJr.ddB = 3;
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.eKe != null) {
            this.eKe.deA.setOnClickListener(this.fHv);
            this.eKe.setFrom(2);
            this.eKe.setShareReportFrom(1);
            this.eKe.setSourceFromForPb(3);
            this.eKe.setStType("frs_page");
            this.eKe.setHideBarName(true);
            this.eKe.deA.setNeedAddReplyIcon(true);
        }
        this.ayz = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gwh = new i(this.mPageContext, this.ayz);
        this.gwh.setUniqueId(getTag());
        this.fGP = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.fGP.setOnClickListener(this.fHv);
        this.fIW = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.fIW.setPageId(getTag());
        this.fIY = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.fIY != null) {
            this.fIY.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eJr != null) {
                    c.this.eJr.changeSelectStatus();
                }
            }
        });
        this.eJr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fM(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.ecC = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.Om = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.fHq != null) {
            this.fHq.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fHq != null) {
            this.fHq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fHq != null) {
            this.fHq.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.caf, R.color.cp_bg_line_c);
            this.fHq.onChangeSkinType();
            this.eJr.onChangeSkinType();
            this.eJq.onChangeSkinType();
            if (this.Om != null) {
                this.Om.onChangeSkinType();
            }
            this.gwh.onChangeSkinType();
            if (this.eKe != null && this.eKe.getVisibility() == 0) {
                this.eKe.onChangeSkinType();
            }
            if (this.fGQ != null && this.fGQ.getHeadView() != null && (this.fGQ.getHeadView() instanceof TbImageView)) {
                this.fGQ.getHeadView().setPlaceHolder(1);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.Kn = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fHv);
        }
        this.fGP.onChangeSkinType();
        if (!btl() && com.baidu.tieba.card.l.zD(this.Kn.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.Kn.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.Kf, this.Kn.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fGP.getGodReplyContent(), this.Kn.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.gwh.at(this.Kn);
        W(bjVar);
        this.eJq.setData(this.Kn);
        this.fGP.setFromCDN(this.Nj);
        this.fGP.setData(this.Kn.aBx());
        this.eJq.setUserAfterClickListener(this.MX);
        pq(nL(1));
        if (this.eJq.getHeaderImg() != null) {
            if (this.eJq.getIsSimpleThread()) {
                this.eJq.getHeaderImg().setVisibility(8);
                this.fGQ.setVisibility(8);
            } else if (bjVar.azX() == null || bjVar.azX().getPendantData() == null || StringUtils.isNull(bjVar.azX().getPendantData().ayq())) {
                this.fGQ.setVisibility(8);
                this.eJq.getHeaderImg().setVisibility(0);
                this.eJq.getHeaderImg().setData(bjVar);
            } else {
                this.eJq.getHeaderImg().setVisibility(4);
                this.fGQ.setVisibility(0);
                this.fGQ.setData(bjVar);
            }
        }
        ao(bjVar);
        ap(bjVar);
        this.Om.setData(bjVar.aAJ());
        this.Om.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.Om;
        AppletsCellView appletsCellView2 = this.Om;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aAl = bjVar.aAl();
        if (v.isEmpty(aAl)) {
            this.Nw.setVisibility(8);
        } else {
            this.Nw.cKI();
            this.Nw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aAl.get(0);
            this.Nw.setVoiceModel(voiceModel);
            this.Nw.setTag(voiceModel);
            this.Nw.bFO();
            if (voiceModel != null) {
                this.Nw.wQ(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (com.baidu.tbadk.core.i.axy().isShowImages() && v.getCount(aAh) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aAh.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aAh, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.fHq.setVisibility(0);
                this.fHq.setFromCDN(this.Nj);
                this.fHq.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> bta = c.this.bta();
                        if (z) {
                            if (bta != null) {
                                view.setTag("1");
                                bta.Ms = true;
                                bta.a(view, c.this.Kn);
                            }
                            c.this.kh(false);
                            return;
                        }
                        if (bta != null) {
                            view.setTag("1");
                            bta.Ms = false;
                            bta.a(view, c.this.Kn);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.fHq.setImageMediaList(linkedList);
            } else {
                this.fHq.setVisibility(8);
            }
        } else {
            this.fHq.setVisibility(8);
        }
        btt();
        btu();
        bFQ();
        if (this.eJr.isInFrsAllThread() && com.baidu.tieba.frs.a.bBr().bBs()) {
            this.mMaskView.setVisibility(0);
            if (this.Kn.aBG() || this.Kn.aBH()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void btt() {
        if (this.fHo != null && this.fHq != null && this.fGP != null) {
            if (this.fHq.getVisibility() == 8 && this.fGP.getVisibility() == 8 && this.Om.getVisibility() == 8) {
                this.fHo.setVisibility(0);
            } else {
                this.fHo.setVisibility(8);
            }
        }
    }

    private void W(final bj bjVar) {
        if (this.fIY != null) {
            if (this.fIW == null || bjVar == null) {
                this.fIY.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cPO) && this.fIW.getVisibility() != 0) {
                if (this.gwh != null && this.gwh.bJm() && (this.fIY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIY.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fIY.setLayoutParams(layoutParams);
                }
                this.fIY.setVisibility(0);
                this.fIY.setImageDrawable(null);
                this.fIY.startLoad(bjVar.cPO, 10, false);
                this.fIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.cPP, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fIY.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData azX;
        if (bjVar != null && this.fIW != null && (azX = bjVar.azX()) != null) {
            final ThemeCardInUserData themeCard = azX.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fIW.setVisibility(8);
                return;
            }
            this.fIW.setVisibility(0);
            this.fIW.setImageDrawable(null);
            this.fIW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fIW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.Nj ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.isEmpty(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aAc(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(bjVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bjVar.getId();
            historyMessage.threadName = bjVar.getTitle();
            historyMessage.forumName = bjVar.aAc();
            historyMessage.postID = bjVar.aAn();
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

    private void btu() {
        this.Nw.setClickable(true);
        int childCount = this.fHq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fHq.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eJr != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eJq != null) {
            this.eJq.setPageUniqueId(bdUniqueId);
        }
        if (this.fHq != null) {
            this.fHq.setPageUniqueId(bdUniqueId);
        }
    }

    protected void kh(boolean z) {
        if (this.Kn != null) {
            com.baidu.tieba.card.l.zC(this.Kn.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.Kn.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.Kf, this.Kn.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fGP.getGodReplyContent(), this.Kn.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aBg = this.Kn.aBg();
            if (aBg != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aBg.getCartoonId(), aBg.getChapterId(), 2)));
                return;
            }
            m mVar = this.Kn.cPm;
            if (this.Kn.cPl == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.cJV;
                long j = mVar.cJW;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.cKj = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.Kn, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.Kn.aBc() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean btl() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.currentPageType = i;
        if (this.eJr != null) {
            this.eJr.ddB = i;
            if (i == 15) {
                this.eJr.setFrom(10);
            } else {
                this.eJr.setFrom(2);
            }
        }
        if (this.eJq != null) {
            if (i == 15) {
                this.eJq.setFrom(5);
            } else {
                this.eJq.setFrom(3);
            }
        }
    }

    private boolean ao(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gwr)) {
            bjVar.cg(this.mUrl, this.gwr);
        }
        SpannableStringBuilder r = bjVar.r(false, true);
        if (r == null || StringUtils.isNull(r.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(r));
            this.mTitle.setText(r);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ap(bj bjVar) {
        if (bjVar != null && nL(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gwr)) {
                bjVar.cg(this.mUrl, this.gwr);
            }
            SpannableString aAP = bjVar.aAP();
            if (aAP != null && !aq.isEmpty(aAP.toString())) {
                this.Kf.setVisibility(0);
                this.Kf.setOnTouchListener(new h(aAP));
                this.Kf.setText(aAP);
                com.baidu.tieba.card.l.a(this.Kf, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.Kf.setVisibility(8);
            return;
        }
        this.Kf.setVisibility(8);
    }

    private void bFQ() {
        if (this.mTitle != null && this.Nw != null && this.fHq != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.Nw.setLayoutParams(layoutParams);
            if (this.Nw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHq.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.fHq.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pq(int i) {
        if (this.Kn != null) {
            if (i == 1) {
                this.eJr.setVisibility(8);
                if (this.eKe != null) {
                    this.eKe.setData(this.Kn);
                    return;
                }
                return;
            }
            this.eJr.setData(this.Kn);
            if (this.eKe != null) {
                this.eKe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fHq != null) {
            this.fHq.setPreloadSizeReadyCallback(bVar);
        }
    }
}
