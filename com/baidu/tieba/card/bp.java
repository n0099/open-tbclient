package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class bp extends a<CardPersonDynamicThreadData> {
    private TbImageView.a aTO;
    private boolean ahv;
    private TbPageContext<?> ajr;
    private final View.OnClickListener alY;
    private LinearLayout bcs;
    private CustomMessageListener buT;
    public PlayVoiceBntNew bvC;
    private ConstrainImageGroup bvG;
    private View.OnClickListener bvI;
    private final View.OnClickListener bvJ;
    private final String bvO;
    private final String bvP;
    private FrsCommonImageLayout.b bvS;
    private final View.OnClickListener bvT;
    private TextView bwA;
    private TextView bwB;
    private PhotoLiveCoverView bwC;
    private View bwD;
    private TbImageView bwE;
    private ImageView bwF;
    com.baidu.tieba.view.u bwG;
    public ThreadViewAndCommentInfoLayout bwv;
    private CardPersonDynamicThreadData bww;
    private LinearLayout bwx;
    private TextView bwy;
    private TextView bwz;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public bp(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bvO = "1";
        this.bvP = "2";
        this.mSkinType = 3;
        this.ahv = true;
        this.bwG = new bq(this);
        this.bvI = new br(this);
        this.buT = new bs(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bvS = new bt(this);
        this.bvT = new bu(this);
        this.bvJ = new bv(this);
        this.alY = new bw(this);
        this.aTO = new bx(this);
        this.mRootView = getView();
        this.ajr = tbPageContext;
        this.bcs = (LinearLayout) this.mRootView.findViewById(w.h.content_layout);
        this.bwx = (LinearLayout) this.mRootView.findViewById(w.h.left_time_view);
        this.bwy = (TextView) this.mRootView.findViewById(w.h.month_num);
        this.bwz = (TextView) this.mRootView.findViewById(w.h.day_num);
        this.bwA = (TextView) this.mRootView.findViewById(w.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.thread_title);
        this.bvC = (PlayVoiceBntNew) this.mRootView.findViewById(w.h.card_dynamic_thread_abstract_voice);
        this.bvC.setAfterClickListener(this.bvJ);
        this.bwB = (TextView) this.mRootView.findViewById(w.h.thread_content);
        this.bvG = (ConstrainImageGroup) this.mRootView.findViewById(w.h.card_dynamic_thread_img_layout);
        this.bvG.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16));
        this.bvG.setChildClickListener(this.bvT);
        this.bvG.setImageProcessor(new com.baidu.tbadk.widget.layout.i(3));
        this.bwD = this.mRootView.findViewById(w.h.thread_view_img_container);
        this.bwE = (TbImageView) this.mRootView.findViewById(w.h.thread_video_thumbnail);
        this.bwF = (ImageView) this.mRootView.findViewById(w.h.thread_img_pause_play);
        this.bwC = (PhotoLiveCoverView) this.mRootView.findViewById(w.h.photo_live_cover_view);
        this.bwv = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(w.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.i(this.bwy, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.bwz, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bwA, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bwB, w.e.cp_cont_f);
            this.bwv.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bww = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvI);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        this.bwx.setVisibility(cardPersonDynamicThreadData.byg ? 0 : 4);
        if (cardPersonDynamicThreadData.byh && cardPersonDynamicThreadData.threadData.rr() < 0) {
            this.bwv.setVisibility(8);
            if (this.bcs != null) {
                this.bcs.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
            }
        } else {
            this.bwv.setVisibility(0);
            this.bwv.setData(cardPersonDynamicThreadData.threadData);
            if (this.bcs != null) {
                this.bcs.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bxW == 33) {
                arrayList.add(new ap.a(w.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bxW == 1) {
                arrayList.add(new ap.a(w.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bxW == 36) {
                arrayList.add(new ap.a(w.l.vote));
            }
            if (cardPersonDynamicThreadData.bxW == 2) {
                arrayList.add(new ap.a(w.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bxW == 49) {
                arrayList.add(new ap.a(w.l.live_in));
            }
            if (cardPersonDynamicThreadData.bxW == 50) {
                arrayList.add(new ap.a(w.l.live_record));
            }
            this.mTitle.setText(ap.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<ap.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bxW == 11) {
            this.mTitle.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bwy.setText(cardPersonDynamicThreadData.bxY);
        this.bwz.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.byf != null && cardPersonDynamicThreadData.byf.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.byf.length; i++) {
                sb.append(com.baidu.tbadk.core.util.au.d(cardPersonDynamicThreadData.byf[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.byf.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(w.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(w.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bwA.setText(sb2);
                this.bwA.setVisibility(0);
            } else {
                this.bwA.setVisibility(8);
            }
        } else {
            this.bwA.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bxZ != null && cardPersonDynamicThreadData.bxZ.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bxZ.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bxZ[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bwB.setText(sb4);
                this.bwB.setVisibility(0);
            } else {
                this.bwB.setVisibility(8);
            }
        } else {
            this.bwB.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.byc;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bvC.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bvC.setVoiceModel(voiceModel);
            this.bvC.setTag(voiceModel);
            this.bvC.aYC();
            if (voiceModel != null) {
                this.bvC.lT(voiceModel.voice_status.intValue());
            }
        } else {
            this.bvC.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bya;
        this.bwC.setVisibility(8);
        this.bwD.setVisibility(8);
        if (cardPersonDynamicThreadData.bxW == 36) {
            this.bvG.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bxW == 33) {
            this.bvG.setVisibility(8);
            if (com.baidu.tbadk.core.r.oV().pb() && cardPersonDynamicThreadData.byd != null && !StringUtils.isNull(cardPersonDynamicThreadData.byd.livecover_src)) {
                this.bwC.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.byd)) {
                    this.bwC.setShowExpression(false);
                } else {
                    this.bwC.setShowExpression(true);
                }
                this.bwC.setShowImage(com.baidu.tbadk.core.r.oV().pb());
                this.bwC.setChooseStyle(c.getShowStyle());
                this.bwC.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bxW == 40 || cardPersonDynamicThreadData.bxW == 50 || cardPersonDynamicThreadData.bxW == 49) {
            this.bvG.setVisibility(8);
            if (com.baidu.tbadk.core.r.oV().pb()) {
                this.bwD.setVisibility(0);
                if (this.bww.byb != null || this.bww.threadData.rQ() != null) {
                    this.bwE.setDefaultErrorResource(0);
                    this.bwE.setDefaultBgResource(w.g.pic_bg_video_frs);
                    this.bwE.setEvent(this.aTO);
                    if (cardPersonDynamicThreadData.threadData.rQ() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rQ().cover)) {
                        this.bwE.c(cardPersonDynamicThreadData.threadData.rQ().cover, 10, false);
                    } else if (this.bww.byb != null) {
                        this.bwE.c(this.bww.byb.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (com.baidu.tbadk.core.r.oV().pb() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bk bkVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.au.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(linkedList) > 0) {
                this.bvG.setVisibility(0);
                this.bvG.setFromCDN(this.ahv);
                this.bvG.setSingleImageRatio(0.67d);
                this.bvG.setImageClickListener(new by(this, linkedList2, bkVar));
                this.bvG.setImageUrls(linkedList);
            } else {
                this.bvG.setVisibility(8);
            }
        } else {
            this.bvG.setVisibility(8);
        }
        Ti();
    }

    private void Ti() {
        this.bvC.setClickable(true);
        int childCount = this.bvG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvG.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        if (this.bww != null) {
            if (!Te()) {
                ap.hY(this.bww.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajr.getPageActivity()).createCfgForPersonCenter(this.bww.threadId, this.bww.bxT, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Te() {
        return this.bww.bxx && !this.bww.aAo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvG != null) {
            this.bvG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvG != null) {
            this.bvG.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bk bkVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajr.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahv ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bkVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getThumbnails_url(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                    ImageUrlData imageUrlData2 = new ImageUrlData();
                    imageUrlData2.urlType = this.ahv ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(bkVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajr.getPageActivity()).createConfig(arrayList, i, bkVar.rD(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.ahv, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bxW == 33 || cardPersonDynamicThreadData.bxW == 1 || cardPersonDynamicThreadData.bxW == 2 || cardPersonDynamicThreadData.bxW == 49 || cardPersonDynamicThreadData.bxW == 50;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.byd != null) {
            if (cardPersonDynamicThreadData.byd.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.byd.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.byd.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.byd.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.byd.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.byd.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.byd.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.byd.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.byd.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.byd.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bxZ != null && cardPersonDynamicThreadData.bxZ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bxZ.length; i++) {
                sb.append(cardPersonDynamicThreadData.bxZ[i].text);
            }
            photoLiveCardData.setContent(photoLiveCardData.deleteBlackSpace(sb.toString()));
        }
        photoLiveCardData.setTitle(photoLiveCardData.deleteBlackSpace(cardPersonDynamicThreadData.title));
        photoLiveCardData.setThreadId(Long.parseLong(cardPersonDynamicThreadData.threadId));
        return photoLiveCardData;
    }

    private int a(CardPersonDynamicThreadData.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.n> a(CardPersonDynamicThreadData.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
            if (labelInfoArr[i] != null) {
                nVar.ef(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
