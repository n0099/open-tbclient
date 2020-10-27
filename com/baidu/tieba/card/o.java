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
/* loaded from: classes21.dex */
public class o extends b<com.baidu.tieba.card.data.l> implements com.baidu.tieba.a.e {
    private static final int agk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView agm;
    private String ahu;
    private final View.OnClickListener ajG;
    private boolean akk;
    public PlayVoiceBntNew akw;
    protected LinearLayout fSf;
    private NEGFeedBackView gMD;
    public ThreadUserInfoLayout gMr;
    public ThreadCommentAndPraiseInfoLayout gMs;
    public ThreadSourceShareAndPraiseLayout gNe;
    private ThreadGodReplyLayout hRJ;
    private HeadPendantClickableView hRK;
    private View hSh;
    private com.baidu.tieba.card.data.l hSi;
    private ConstrainImageGroup hSj;
    private View hSk;
    private boolean hSl;
    private RelativeLayout hSm;
    private ThreadForumEnterButton hSn;
    private View.OnClickListener hSo;
    private final View.OnClickListener hSp;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gMD = null;
        this.mSkinType = 3;
        this.akk = true;
        this.hSl = true;
        this.hSo = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.hSi != null) {
                    o.this.hSi.objType = 1;
                }
                if (o.this.cls() != null) {
                    o.this.cls().a(view, o.this.hSi);
                }
                o.this.oj(view == o.this.hRJ);
            }
        };
        this.hSp = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.l> cls = o.this.cls();
                if (cls != null) {
                    view.setTag("2");
                    cls.a(view, o.this.hSi);
                }
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.hSi == null) {
                    if (o.this.cls() != null) {
                        o.this.cls().a(view, o.this.hSi);
                        return;
                    }
                    return;
                }
                if (view == o.this.gMr.getUserName()) {
                    o.this.hSi.objType = 3;
                } else if (view == o.this.gMr.getHeaderImg()) {
                    o.this.hSi.objType = 4;
                } else if (view == o.this.hSj) {
                    o.this.hSi.objType = 2;
                    return;
                } else {
                    o.this.hSi.objType = 1;
                }
                if (o.this.cls() != null) {
                    o.this.cls().a(view, o.this.hSi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hRK = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hRK.getHeadView() != null) {
            this.hRK.getHeadView().setIsRound(true);
            this.hRK.getHeadView().setDrawBorder(false);
            this.hRK.getHeadView().setDefaultResource(17170445);
            this.hRK.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRK.getHeadView().setPlaceHolder(1);
            this.hRK.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hRK.setHasPendantStyle();
        if (this.hRK.getPendantView() != null) {
            this.hRK.getPendantView().setIsRound(true);
            this.hRK.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akw.setAfterClickListener(this.hSp);
        this.agm = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hSj = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hSk = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hSj.setChildClickListener(this.hSo);
        this.hSj.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.y(1.0d);
        this.hSj.setImageProcessor(fVar);
        this.hSh = view.findViewById(R.id.divider_line_above_praise);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gMr = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gMD = new NEGFeedBackView(this.mPageContext);
        this.hSm = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gMD.a(this.hSm, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gMs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMs.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gMs.setLayoutParams(layoutParams);
        }
        this.gMs.setOnClickListener(this.hSo);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setShareVisible(true);
        this.gMs.setFrom(1);
        this.gMs.setShareReportFrom(3);
        this.gMs.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.cls() != null) {
                    o.this.cls().a(view2, o.this.hSi);
                }
                if (o.this.hSi != null && o.this.hSi.erH != null) {
                    n.II(o.this.hSi.erH.getId());
                    if (!o.this.clB()) {
                        n.a(o.this.mTitle, o.this.hSi.bhz().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.agm, o.this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.hRJ.getGodReplyContent(), o.this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fSf = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hRJ = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hRJ.setOnClickListener(this.hSo);
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gNe.eRI.setOnClickListener(this.hSo);
        this.gNe.setFrom(1);
        this.gNe.setShareReportFrom(3);
        this.gNe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.cls() != null) {
                    o.this.cls().a(view2, o.this.hSi);
                }
                if (o.this.hSi != null && o.this.hSi.erH != null && view2 != o.this.gNe.eQX) {
                    n.II(o.this.hSi.erH.getId());
                    if (!o.this.clB()) {
                        n.a(o.this.mTitle, o.this.hSi.bhz().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.agm, o.this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.hRJ.getGodReplyContent(), o.this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.hSn = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hSj != null) {
            this.hSj.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hSj != null) {
            this.hSj.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hSh, R.color.transparent);
            this.hSj.onChangeSkinType();
            this.gMs.onChangeSkinType();
            this.hRJ.onChangeSkinType();
            this.gMr.onChangeSkinType();
            if (this.gMD != null) {
                this.gMD.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hSk, R.color.cp_bg_line_c);
            if (this.gNe != null) {
                this.gNe.onChangeSkinType();
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
        if (lVar == null || lVar.bhz() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hSi = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hSo);
        }
        if (this.gMD != null) {
            if (this.hSi.feedBackReasonMap != null && this.hSi.feedBackReasonMap.size() > 0) {
                ar arVar = new ar();
                arVar.setTid(this.hSi.bhz().getTid());
                arVar.setFid(this.hSi.bhz().getFid());
                arVar.setNid(this.hSi.bhz().getNid());
                arVar.setFeedBackReasonMap(this.hSi.feedBackReasonMap);
                this.gMD.setData(arVar);
                this.gMD.setFirstRowSingleColumn(true);
                if (lVar.erH.bka() != null && !StringUtils.isNull(lVar.erH.bka().getUserId())) {
                    if (lVar.erH.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gMD.setVisibility(8);
                    } else if (this.gMD != null) {
                        this.gMD.setVisibility(this.hSl ? 0 : 8);
                    }
                }
            } else {
                this.gMD.setVisibility(8);
            }
        }
        this.gMr.setData(lVar.erH);
        this.hRJ.setFromCDN(this.akk);
        this.hRJ.setData(lVar.erH.blD());
        if (!clB() && n.IJ(this.hSi.erH.getId())) {
            n.a(this.mTitle, this.hSi.bhz().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.agm, this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.hRJ.getGodReplyContent(), this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.gMr.setUserAfterClickListener(this.ajG);
        final bw bhz = lVar.bhz();
        if (this.gMr.getHeaderImg() != null) {
            if (this.gMr.getIsSimpleThread()) {
                this.gMr.getHeaderImg().setVisibility(8);
                this.hRK.setVisibility(8);
            } else if (bhz.bka() == null || bhz.bka().getPendantData() == null || StringUtils.isNull(bhz.bka().getPendantData().bhW())) {
                this.hRK.setVisibility(8);
                this.gMr.getHeaderImg().setVisibility(0);
                this.gMr.getHeaderImg().setData(bhz);
            } else {
                this.gMr.getHeaderImg().setVisibility(4);
                this.hRK.setVisibility(0);
                this.hRK.setData(bhz);
            }
        }
        ay.a(this.mTitle, bhz);
        ay.a(this.agm, this.mTitle, bhz, agk);
        ArrayList<VoiceData.VoiceModel> bkn = lVar.erH.bkn();
        if (com.baidu.tbadk.core.util.y.isEmpty(bkn)) {
            this.akw.setVisibility(8);
            z = false;
        } else {
            this.akw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bkn.get(0);
            this.akw.setVoiceModel(voiceModel);
            this.akw.setTag(voiceModel);
            this.akw.changeSkin();
            if (voiceModel != null) {
                this.akw.Dm(voiceModel.voice_status.intValue());
            }
            this.akw.bWJ();
            z = true;
        }
        if (this.hSi.hVO && z) {
            this.hSj.setVisibility(8);
        } else {
            ArrayList<MediaData> bkj = bhz.bkj();
            if (com.baidu.tbadk.core.k.bhh().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bkj) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < bkj.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bkj, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hSj.setVisibility(0);
                    this.hSj.setFromCDN(this.akk);
                    this.hSj.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.o.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.l> cls = o.this.cls();
                            if (cls != null) {
                                view.setTag("1");
                                if (o.this.ajG != null) {
                                    o.this.ajG.onClick(o.this.hSj);
                                }
                                cls.a(view, o.this.hSi);
                            }
                            if (z2) {
                                o.this.bvc();
                            } else {
                                o.this.a(view, linkedList, i2, bhz);
                            }
                        }
                    });
                    this.hSj.setImageMediaList(linkedList);
                } else {
                    this.hSj.setVisibility(8);
                }
            } else {
                this.hSj.setVisibility(8);
            }
        }
        clJ();
        clK();
        setPageUniqueId(getTag());
        this.hSn.setVisibility(8);
        uS(sZ(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void clJ() {
        if (this.hSh != null && this.hSj != null && this.hRJ != null) {
            if (this.hSj.getVisibility() == 8 && this.hRJ.getVisibility() == 8) {
                this.hSh.setVisibility(0);
            } else {
                this.hSh.setVisibility(8);
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
                    imageUrlData.urlType = this.akk ? 13 : 14;
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
        aVar.x(arrayList).nF(i).Aq(bwVar.bke()).Ar(String.valueOf(bwVar.getFid())).As(bwVar.getTid()).io(this.akk).At(arrayList.size() > 0 ? arrayList.get(0) : "").ip(true).a(concurrentHashMap).iq(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bke();
        historyMessage.postID = bwVar.bkr();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void clK() {
        if (!this.hSi.fiZ) {
            this.akw.setClickable(false);
        } else {
            this.akw.setClickable(true);
        }
        int childCount = this.hSj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hSj.getChildAt(i);
            if (childAt != null) {
                if (!this.hSi.fiZ) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hSj != null) {
            this.hSj.setPageUniqueId(bdUniqueId);
        }
        if (this.gMD != null) {
            this.gMD.setUniqueId(bdUniqueId);
        }
        if (this.gMr != null) {
            this.gMr.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvc() {
        oj(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (this.hSi != null && this.hSi.erH != null) {
            if (!clB()) {
                n.II(this.hSi.erH.getId());
                n.a(this.mTitle, this.hSi.bhz().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                n.a(this.agm, this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                n.a(this.hRJ.getGodReplyContent(), this.hSi.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hSi.erH, null, n.bjM(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hSi.bhC());
            addLocateParam.setForumId(String.valueOf(this.hSi.erH.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hSi.erH.bke());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            n.II(this.hSi.bhz().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clB() {
        return this.hSi.hVO && !this.hSi.fiZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ok(boolean z) {
        if (this.hSk != null) {
            this.hSk.setVisibility(z ? 0 : 8);
        }
    }

    public void ol(boolean z) {
        this.hSl = z;
    }

    public void uS(int i) {
        if (this.hSi != null && this.hSi.erH != null) {
            this.mStType = n.bjM();
            if (i == 1) {
                this.gMs.setVisibility(8);
                this.gNe.setStType(this.mStType);
                this.gNe.setData(this.hSi.erH);
                this.gMr.jk(false);
                return;
            }
            this.gMs.setData(this.hSi.erH);
            this.gMs.setStType(this.mStType);
            this.gNe.setVisibility(8);
            this.gMr.jk(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }
}
