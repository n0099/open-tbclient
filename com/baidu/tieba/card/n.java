package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes20.dex */
public class n extends b<com.baidu.tieba.card.data.l> implements com.baidu.tieba.a.e {
    private static final int afR = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView afT;
    private String ahc;
    private boolean ajR;
    private final View.OnClickListener ajn;
    public PlayVoiceBntNew akd;
    protected LinearLayout fxB;
    public ThreadSourceShareAndPraiseLayout gmX;
    public ThreadUserInfoLayout gmk;
    public ThreadCommentAndPraiseInfoLayout gml;
    private NEGFeedBackView gmw;
    private View hqQ;
    private com.baidu.tieba.card.data.l hqR;
    private ConstrainImageGroup hqS;
    private View hqT;
    private boolean hqU;
    private RelativeLayout hqV;
    private ThreadForumEnterButton hqW;
    private View.OnClickListener hqX;
    private final View.OnClickListener hqY;
    private ThreadGodReplyLayout hqs;
    private HeadPendantClickableView hqt;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gmw = null;
        this.mSkinType = 3;
        this.ajR = true;
        this.hqU = true;
        this.hqX = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hqR != null) {
                    n.this.hqR.objType = 1;
                }
                if (n.this.ceP() != null) {
                    n.this.ceP().a(view, n.this.hqR);
                }
                n.this.nm(view == n.this.hqs);
            }
        };
        this.hqY = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.l> ceP = n.this.ceP();
                if (ceP != null) {
                    view.setTag("2");
                    ceP.a(view, n.this.hqR);
                }
            }
        };
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hqR == null) {
                    if (n.this.ceP() != null) {
                        n.this.ceP().a(view, n.this.hqR);
                        return;
                    }
                    return;
                }
                if (view == n.this.gmk.getUserName()) {
                    n.this.hqR.objType = 3;
                } else if (view == n.this.gmk.getHeaderImg()) {
                    n.this.hqR.objType = 4;
                } else if (view == n.this.hqS) {
                    n.this.hqR.objType = 2;
                    return;
                } else {
                    n.this.hqR.objType = 1;
                }
                if (n.this.ceP() != null) {
                    n.this.ceP().a(view, n.this.hqR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hqt = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hqt.getHeadView() != null) {
            this.hqt.getHeadView().setIsRound(true);
            this.hqt.getHeadView().setDrawBorder(false);
            this.hqt.getHeadView().setDefaultResource(17170445);
            this.hqt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hqt.getHeadView().setPlaceHolder(1);
            this.hqt.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hqt.setHasPendantStyle();
        if (this.hqt.getPendantView() != null) {
            this.hqt.getPendantView().setIsRound(true);
            this.hqt.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akd = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akd.setAfterClickListener(this.hqY);
        this.afT = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hqS = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hqT = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hqS.setChildClickListener(this.hqX);
        this.hqS.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.u(1.0d);
        this.hqS.setImageProcessor(fVar);
        this.hqQ = view.findViewById(R.id.divider_line_above_praise);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gmk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gmw = new NEGFeedBackView(this.mPageContext);
        this.hqV = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gmw.a(this.hqV, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gml.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gml.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gml.setLayoutParams(layoutParams);
        }
        this.gml.setOnClickListener(this.hqX);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setShareVisible(true);
        this.gml.setFrom(1);
        this.gml.setShareReportFrom(3);
        this.gml.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.ceP() != null) {
                    n.this.ceP().a(view2, n.this.hqR);
                }
                if (n.this.hqR != null && n.this.hqR.dXg != null) {
                    m.Hw(n.this.hqR.dXg.getId());
                    if (!n.this.ceY()) {
                        m.a(n.this.mTitle, n.this.hqR.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.afT, n.this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hqs.getGodReplyContent(), n.this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fxB = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hqs = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hqs.setOnClickListener(this.hqX);
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gmX.exc.setOnClickListener(this.hqX);
        this.gmX.setFrom(1);
        this.gmX.setShareReportFrom(3);
        this.gmX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.ceP() != null) {
                    n.this.ceP().a(view2, n.this.hqR);
                }
                if (n.this.hqR != null && n.this.hqR.dXg != null && view2 != n.this.gmX.ewr) {
                    m.Hw(n.this.hqR.dXg.getId());
                    if (!n.this.ceY()) {
                        m.a(n.this.mTitle, n.this.hqR.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.afT, n.this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hqs.getGodReplyContent(), n.this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.hqW = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hqS != null) {
            this.hqS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hqS != null) {
            this.hqS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hqQ, R.color.transparent);
            this.hqS.onChangeSkinType();
            this.gml.onChangeSkinType();
            this.hqs.onChangeSkinType();
            this.gmk.onChangeSkinType();
            if (this.gmw != null) {
                this.gmw.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hqT, R.color.cp_bg_line_c);
            if (this.gmX != null) {
                this.gmX.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.bcY() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hqR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hqX);
        }
        if (this.gmw != null) {
            if (this.hqR.feedBackReasonMap != null && this.hqR.feedBackReasonMap.size() > 0) {
                ar arVar = new ar();
                arVar.setTid(this.hqR.bcY().getTid());
                arVar.setFid(this.hqR.bcY().getFid());
                arVar.setNid(this.hqR.bcY().getNid());
                arVar.setFeedBackReasonMap(this.hqR.feedBackReasonMap);
                this.gmw.setData(arVar);
                this.gmw.setFirstRowSingleColumn(true);
                if (lVar.dXg.bfy() != null && !StringUtils.isNull(lVar.dXg.bfy().getUserId())) {
                    if (lVar.dXg.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gmw.setVisibility(8);
                    } else if (this.gmw != null) {
                        this.gmw.setVisibility(this.hqU ? 0 : 8);
                    }
                }
            } else {
                this.gmw.setVisibility(8);
            }
        }
        this.gmk.setData(lVar.dXg);
        this.hqs.setFromCDN(this.ajR);
        this.hqs.setData(lVar.dXg.bhb());
        if (!ceY() && m.Hx(this.hqR.dXg.getId())) {
            m.a(this.mTitle, this.hqR.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afT, this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hqs.getGodReplyContent(), this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.gmk.setUserAfterClickListener(this.ajn);
        final bw bcY = lVar.bcY();
        if (this.gmk.getHeaderImg() != null) {
            if (this.gmk.getIsSimpleThread()) {
                this.gmk.getHeaderImg().setVisibility(8);
                this.hqt.setVisibility(8);
            } else if (bcY.bfy() == null || bcY.bfy().getPendantData() == null || StringUtils.isNull(bcY.bfy().getPendantData().bdu())) {
                this.hqt.setVisibility(8);
                this.gmk.getHeaderImg().setVisibility(0);
                this.gmk.getHeaderImg().setData(bcY);
            } else {
                this.gmk.getHeaderImg().setVisibility(4);
                this.hqt.setVisibility(0);
                this.hqt.setData(bcY);
            }
        }
        ay.a(this.mTitle, bcY);
        ay.a(this.afT, this.mTitle, bcY, afR);
        ArrayList<VoiceData.VoiceModel> bfL = lVar.dXg.bfL();
        if (com.baidu.tbadk.core.util.y.isEmpty(bfL)) {
            this.akd.setVisibility(8);
            z = false;
        } else {
            this.akd.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bfL.get(0);
            this.akd.setVoiceModel(voiceModel);
            this.akd.setTag(voiceModel);
            this.akd.changeSkin();
            if (voiceModel != null) {
                this.akd.Cn(voiceModel.voice_status.intValue());
            }
            this.akd.bQr();
            z = true;
        }
        if (this.hqR.huw && z) {
            this.hqS.setVisibility(8);
        } else {
            ArrayList<MediaData> bfH = bcY.bfH();
            if (com.baidu.tbadk.core.k.bcG().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bfH) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < bfH.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bfH, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hqS.setVisibility(0);
                    this.hqS.setFromCDN(this.ajR);
                    this.hqS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.l> ceP = n.this.ceP();
                            if (ceP != null) {
                                view.setTag("1");
                                if (n.this.ajn != null) {
                                    n.this.ajn.onClick(n.this.hqS);
                                }
                                ceP.a(view, n.this.hqR);
                            }
                            if (z2) {
                                n.this.bqz();
                            } else {
                                n.this.a(view, linkedList, i2, bcY);
                            }
                        }
                    });
                    this.hqS.setImageMediaList(linkedList);
                } else {
                    this.hqS.setVisibility(8);
                }
            } else {
                this.hqS.setVisibility(8);
            }
        }
        cfg();
        cfh();
        setPageUniqueId(getTag());
        this.hqW.setVisibility(8);
        tU(sq(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cfg() {
        if (this.hqQ != null && this.hqS != null && this.hqs != null) {
            if (this.hqS.getVisibility() == 8 && this.hqs.getVisibility() == 8) {
                this.hqQ.setVisibility(0);
            } else {
                this.hqQ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
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
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).mX(i).zl(bwVar.bfC()).zm(String.valueOf(bwVar.getFid())).zn(bwVar.getTid()).hF(this.ajR).zo(arrayList.size() > 0 ? arrayList.get(0) : "").hG(true).a(concurrentHashMap).hH(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dO = aVar.dO(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dO.getIntent().putExtra("from", "index");
        } else {
            dO.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bfC();
        historyMessage.postID = bwVar.bfP();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void cfh() {
        if (!this.hqR.eOt) {
            this.akd.setClickable(false);
        } else {
            this.akd.setClickable(true);
        }
        int childCount = this.hqS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hqS.getChildAt(i);
            if (childAt != null) {
                if (!this.hqR.eOt) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hqS != null) {
            this.hqS.setPageUniqueId(bdUniqueId);
        }
        if (this.gmw != null) {
            this.gmw.setUniqueId(bdUniqueId);
        }
        if (this.gmk != null) {
            this.gmk.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqz() {
        nm(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm(boolean z) {
        if (this.hqR != null && this.hqR.dXg != null) {
            if (!ceY()) {
                m.Hw(this.hqR.dXg.getId());
                m.a(this.mTitle, this.hqR.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.afT, this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.hqs.getGodReplyContent(), this.hqR.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hqR.dXg, null, m.bfk(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hqR.bdb());
            addLocateParam.setForumId(String.valueOf(this.hqR.dXg.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hqR.dXg.bfC());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.Hw(this.hqR.bcY().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceY() {
        return this.hqR.huw && !this.hqR.eOt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void nn(boolean z) {
        if (this.hqT != null) {
            this.hqT.setVisibility(z ? 0 : 8);
        }
    }

    public void no(boolean z) {
        this.hqU = z;
    }

    public void tU(int i) {
        if (this.hqR != null && this.hqR.dXg != null) {
            this.mStType = m.bfk();
            if (i == 1) {
                this.gml.setVisibility(8);
                this.gmX.setStType(this.mStType);
                this.gmX.setData(this.hqR.dXg);
                this.gmk.iz(false);
                return;
            }
            this.gml.setData(this.hqR.dXg);
            this.gml.setStType(this.mStType);
            this.gmX.setVisibility(8);
            this.gmk.iz(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }
}
