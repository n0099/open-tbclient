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
/* loaded from: classes15.dex */
public class n extends b<com.baidu.tieba.card.data.l> implements com.baidu.tieba.a.e {
    private static final int afx = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView afz;
    private String agH;
    private final View.OnClickListener aiR;
    public PlayVoiceBntNew ajD;
    private boolean ajr;
    protected LinearLayout fum;
    public ThreadUserInfoLayout giZ;
    public ThreadSourceShareAndPraiseLayout gjM;
    public ThreadCommentAndPraiseInfoLayout gja;
    private NEGFeedBackView gjl;
    private View hjJ;
    private com.baidu.tieba.card.data.l hjK;
    private ConstrainImageGroup hjL;
    private View hjM;
    private boolean hjN;
    private RelativeLayout hjO;
    private ThreadForumEnterButton hjP;
    private View.OnClickListener hjQ;
    private final View.OnClickListener hjR;
    private ThreadGodReplyLayout hjl;
    private HeadPendantClickableView hjm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjl = null;
        this.mSkinType = 3;
        this.ajr = true;
        this.hjN = true;
        this.hjQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hjK != null) {
                    n.this.hjK.objType = 1;
                }
                if (n.this.cbz() != null) {
                    n.this.cbz().a(view, n.this.hjK);
                }
                n.this.ne(view == n.this.hjl);
            }
        };
        this.hjR = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.l> cbz = n.this.cbz();
                if (cbz != null) {
                    view.setTag("2");
                    cbz.a(view, n.this.hjK);
                }
            }
        };
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hjK == null) {
                    if (n.this.cbz() != null) {
                        n.this.cbz().a(view, n.this.hjK);
                        return;
                    }
                    return;
                }
                if (view == n.this.giZ.getUserName()) {
                    n.this.hjK.objType = 3;
                } else if (view == n.this.giZ.getHeaderImg()) {
                    n.this.hjK.objType = 4;
                } else if (view == n.this.hjL) {
                    n.this.hjK.objType = 2;
                    return;
                } else {
                    n.this.hjK.objType = 1;
                }
                if (n.this.cbz() != null) {
                    n.this.cbz().a(view, n.this.hjK);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hjm = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hjm.getHeadView() != null) {
            this.hjm.getHeadView().setIsRound(true);
            this.hjm.getHeadView().setDrawBorder(false);
            this.hjm.getHeadView().setDefaultResource(17170445);
            this.hjm.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjm.getHeadView().setPlaceHolder(1);
            this.hjm.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hjm.setHasPendantStyle();
        if (this.hjm.getPendantView() != null) {
            this.hjm.getPendantView().setIsRound(true);
            this.hjm.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.ajD = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.ajD.setAfterClickListener(this.hjR);
        this.afz = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hjL = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hjM = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hjL.setChildClickListener(this.hjQ);
        this.hjL.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.u(1.0d);
        this.hjL.setImageProcessor(fVar);
        this.hjJ = view.findViewById(R.id.divider_line_above_praise);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.giZ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gjl = new NEGFeedBackView(this.mPageContext);
        this.hjO = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gjl.a(this.hjO, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gja.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gja.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gja.setLayoutParams(layoutParams);
        }
        this.gja.setOnClickListener(this.hjQ);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setShareVisible(true);
        this.gja.setFrom(1);
        this.gja.setShareReportFrom(3);
        this.gja.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cbz() != null) {
                    n.this.cbz().a(view2, n.this.hjK);
                }
                if (n.this.hjK != null && n.this.hjK.dUS != null) {
                    m.GY(n.this.hjK.dUS.getId());
                    if (!n.this.cbI()) {
                        m.a(n.this.mTitle, n.this.hjK.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.afz, n.this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hjl.getGodReplyContent(), n.this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fum = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hjl = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hjl.setOnClickListener(this.hjQ);
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gjM.euU.setOnClickListener(this.hjQ);
        this.gjM.setFrom(1);
        this.gjM.setShareReportFrom(3);
        this.gjM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cbz() != null) {
                    n.this.cbz().a(view2, n.this.hjK);
                }
                if (n.this.hjK != null && n.this.hjK.dUS != null && view2 != n.this.gjM.euj) {
                    m.GY(n.this.hjK.dUS.getId());
                    if (!n.this.cbI()) {
                        m.a(n.this.mTitle, n.this.hjK.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.afz, n.this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hjl.getGodReplyContent(), n.this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.hjP = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjL != null) {
            this.hjL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjL != null) {
            this.hjL.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hjJ, R.color.transparent);
            this.hjL.onChangeSkinType();
            this.gja.onChangeSkinType();
            this.hjl.onChangeSkinType();
            this.giZ.onChangeSkinType();
            if (this.gjl != null) {
                this.gjl.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hjM, R.color.cp_bg_line_c);
            if (this.gjM != null) {
                this.gjM.onChangeSkinType();
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
        if (lVar == null || lVar.bce() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hjK = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hjQ);
        }
        if (this.gjl != null) {
            if (this.hjK.feedBackReasonMap != null && this.hjK.feedBackReasonMap.size() > 0) {
                ar arVar = new ar();
                arVar.setTid(this.hjK.bce().getTid());
                arVar.setFid(this.hjK.bce().getFid());
                arVar.setNid(this.hjK.bce().getNid());
                arVar.setFeedBackReasonMap(this.hjK.feedBackReasonMap);
                this.gjl.setData(arVar);
                this.gjl.setFirstRowSingleColumn(true);
                if (lVar.dUS.beE() != null && !StringUtils.isNull(lVar.dUS.beE().getUserId())) {
                    if (lVar.dUS.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gjl.setVisibility(8);
                    } else if (this.gjl != null) {
                        this.gjl.setVisibility(this.hjN ? 0 : 8);
                    }
                }
            } else {
                this.gjl.setVisibility(8);
            }
        }
        this.giZ.setData(lVar.dUS);
        this.hjl.setFromCDN(this.ajr);
        this.hjl.setData(lVar.dUS.bgh());
        if (!cbI() && m.GZ(this.hjK.dUS.getId())) {
            m.a(this.mTitle, this.hjK.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afz, this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hjl.getGodReplyContent(), this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.giZ.setUserAfterClickListener(this.aiR);
        final bw bce = lVar.bce();
        if (this.giZ.getHeaderImg() != null) {
            if (this.giZ.getIsSimpleThread()) {
                this.giZ.getHeaderImg().setVisibility(8);
                this.hjm.setVisibility(8);
            } else if (bce.beE() == null || bce.beE().getPendantData() == null || StringUtils.isNull(bce.beE().getPendantData().bcA())) {
                this.hjm.setVisibility(8);
                this.giZ.getHeaderImg().setVisibility(0);
                this.giZ.getHeaderImg().setData(bce);
            } else {
                this.giZ.getHeaderImg().setVisibility(4);
                this.hjm.setVisibility(0);
                this.hjm.setData(bce);
            }
        }
        ay.a(this.mTitle, bce);
        ay.a(this.afz, this.mTitle, bce, afx);
        ArrayList<VoiceData.VoiceModel> beR = lVar.dUS.beR();
        if (com.baidu.tbadk.core.util.y.isEmpty(beR)) {
            this.ajD.setVisibility(8);
            z = false;
        } else {
            this.ajD.setVisibility(0);
            VoiceData.VoiceModel voiceModel = beR.get(0);
            this.ajD.setVoiceModel(voiceModel);
            this.ajD.setTag(voiceModel);
            this.ajD.changeSkin();
            if (voiceModel != null) {
                this.ajD.BM(voiceModel.voice_status.intValue());
            }
            this.ajD.bPe();
            z = true;
        }
        if (this.hjK.hno && z) {
            this.hjL.setVisibility(8);
        } else {
            ArrayList<MediaData> beN = bce.beN();
            if (com.baidu.tbadk.core.k.bbM().isShowImages() && com.baidu.tbadk.core.util.y.getCount(beN) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < beN.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(beN, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hjL.setVisibility(0);
                    this.hjL.setFromCDN(this.ajr);
                    this.hjL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.l> cbz = n.this.cbz();
                            if (cbz != null) {
                                view.setTag("1");
                                if (n.this.aiR != null) {
                                    n.this.aiR.onClick(n.this.hjL);
                                }
                                cbz.a(view, n.this.hjK);
                            }
                            if (z2) {
                                n.this.bpE();
                            } else {
                                n.this.a(view, linkedList, i2, bce);
                            }
                        }
                    });
                    this.hjL.setImageMediaList(linkedList);
                } else {
                    this.hjL.setVisibility(8);
                }
            } else {
                this.hjL.setVisibility(8);
            }
        }
        cbQ();
        cbR();
        setPageUniqueId(getTag());
        this.hjP.setVisibility(8);
        tB(rY(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cbQ() {
        if (this.hjJ != null && this.hjL != null && this.hjl != null) {
            if (this.hjL.getVisibility() == 8 && this.hjl.getVisibility() == 8) {
                this.hjJ.setVisibility(0);
            } else {
                this.hjJ.setVisibility(8);
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
                    imageUrlData.urlType = this.ajr ? 13 : 14;
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
        aVar.x(arrayList).mM(i).yP(bwVar.beI()).yQ(String.valueOf(bwVar.getFid())).yR(bwVar.getTid()).hH(this.ajr).yS(arrayList.size() > 0 ? arrayList.get(0) : "").hI(true).a(concurrentHashMap).hJ(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dP = aVar.dP(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dP.getIntent().putExtra("from", "index");
        } else {
            dP.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.beI();
        historyMessage.postID = bwVar.beV();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void cbR() {
        if (!this.hjK.eLX) {
            this.ajD.setClickable(false);
        } else {
            this.ajD.setClickable(true);
        }
        int childCount = this.hjL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hjL.getChildAt(i);
            if (childAt != null) {
                if (!this.hjK.eLX) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hjL != null) {
            this.hjL.setPageUniqueId(bdUniqueId);
        }
        if (this.gjl != null) {
            this.gjl.setUniqueId(bdUniqueId);
        }
        if (this.giZ != null) {
            this.giZ.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpE() {
        ne(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        if (this.hjK != null && this.hjK.dUS != null) {
            if (!cbI()) {
                m.GY(this.hjK.dUS.getId());
                m.a(this.mTitle, this.hjK.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.afz, this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.hjl.getGodReplyContent(), this.hjK.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hjK.dUS, null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hjK.bch());
            addLocateParam.setForumId(String.valueOf(this.hjK.dUS.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hjK.dUS.beI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.GY(this.hjK.bce().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbI() {
        return this.hjK.hno && !this.hjK.eLX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void nf(boolean z) {
        if (this.hjM != null) {
            this.hjM.setVisibility(z ? 0 : 8);
        }
    }

    public void ng(boolean z) {
        this.hjN = z;
    }

    public void tB(int i) {
        if (this.hjK != null && this.hjK.dUS != null) {
            this.mStType = m.beq();
            if (i == 1) {
                this.gja.setVisibility(8);
                this.gjM.setStType(this.mStType);
                this.gjM.setData(this.hjK.dUS);
                this.giZ.iB(false);
                return;
            }
            this.gja.setData(this.hjK.dUS);
            this.gja.setStType(this.mStType);
            this.gjM.setVisibility(8);
            this.giZ.iB(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }
}
