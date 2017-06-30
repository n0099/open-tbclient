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
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class bu extends a<CardPersonDynamicThreadData> {
    private boolean ahU;
    private TbPageContext<?> ajP;
    private final View.OnClickListener amF;
    private View.OnClickListener bAB;
    private CustomMessageListener bBt;
    public ThreadViewAndCommentInfoLayout bCZ;
    public PlayVoiceBntNew bCj;
    private ConstrainImageGroup bCl;
    private final View.OnClickListener bCm;
    private final String bCr;
    private final String bCs;
    private FrsCommonImageLayout.b bCv;
    private final View.OnClickListener bCw;
    private CardPersonDynamicThreadData bDa;
    private LinearLayout bDb;
    private TextView bDc;
    private TextView bDd;
    private TextView bDe;
    private TextView bDf;
    private PhotoLiveCoverView bDg;
    private View bDh;
    private TbImageView bDi;
    private ImageView bDj;
    com.baidu.tieba.view.v bDk;
    private LinearLayout bgH;
    private TbImageView.a byN;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public bu(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bCr = "1";
        this.bCs = "2";
        this.mSkinType = 3;
        this.ahU = true;
        this.bDk = new bv(this);
        this.bAB = new bw(this);
        this.bBt = new bx(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bCv = new by(this);
        this.bCw = new bz(this);
        this.bCm = new ca(this);
        this.amF = new cb(this);
        this.byN = new cc(this);
        this.mRootView = getView();
        this.ajP = tbPageContext;
        this.bgH = (LinearLayout) this.mRootView.findViewById(w.h.content_layout);
        this.bDb = (LinearLayout) this.mRootView.findViewById(w.h.left_time_view);
        this.bDc = (TextView) this.mRootView.findViewById(w.h.month_num);
        this.bDd = (TextView) this.mRootView.findViewById(w.h.day_num);
        this.bDe = (TextView) this.mRootView.findViewById(w.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.thread_title);
        this.bCj = (PlayVoiceBntNew) this.mRootView.findViewById(w.h.card_dynamic_thread_abstract_voice);
        this.bCj.setAfterClickListener(this.bCm);
        this.bDf = (TextView) this.mRootView.findViewById(w.h.thread_content);
        this.bCl = (ConstrainImageGroup) this.mRootView.findViewById(w.h.card_dynamic_thread_img_layout);
        this.bCl.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16));
        this.bCl.setChildClickListener(this.bCw);
        this.bCl.setImageProcessor(new com.baidu.tbadk.widget.layout.i(3));
        this.bDh = this.mRootView.findViewById(w.h.thread_view_img_container);
        this.bDi = (TbImageView) this.mRootView.findViewById(w.h.thread_video_thumbnail);
        this.bDj = (ImageView) this.mRootView.findViewById(w.h.thread_img_pause_play);
        this.bDg = (PhotoLiveCoverView) this.mRootView.findViewById(w.h.photo_live_cover_view);
        this.bCZ = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(w.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.as.i(this.bDc, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.as.i(this.bDd, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.i(this.bDe, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.as.i(this.mTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.i(this.bDf, w.e.cp_cont_f);
            this.bCZ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bDa = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bAB);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        this.bDb.setVisibility(cardPersonDynamicThreadData.bET ? 0 : 4);
        if (cardPersonDynamicThreadData.bEU && cardPersonDynamicThreadData.threadData.rj() < 0) {
            this.bCZ.setVisibility(8);
            if (this.bgH != null) {
                this.bgH.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
            }
        } else {
            this.bCZ.setVisibility(0);
            this.bCZ.setData(cardPersonDynamicThreadData.threadData);
            if (this.bgH != null) {
                this.bgH.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bEK == 33) {
                arrayList.add(new at.a(w.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bEK == 1) {
                arrayList.add(new at.a(w.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bEK == 36) {
                arrayList.add(new at.a(w.l.vote));
            }
            if (cardPersonDynamicThreadData.bEK == 2) {
                arrayList.add(new at.a(w.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bEK == 49) {
                arrayList.add(new at.a(w.l.live_in));
            }
            if (cardPersonDynamicThreadData.bEK == 50) {
                arrayList.add(new at.a(w.l.live_record));
            }
            this.mTitle.setText(at.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<at.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bEK == 11) {
            this.mTitle.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bDc.setText(cardPersonDynamicThreadData.bEM);
        this.bDd.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bES != null && cardPersonDynamicThreadData.bES.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bES.length; i++) {
                sb.append(com.baidu.tbadk.core.util.aw.d(cardPersonDynamicThreadData.bES[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bES.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(w.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(w.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bDe.setText(sb2);
                this.bDe.setVisibility(0);
            } else {
                this.bDe.setVisibility(8);
            }
        } else {
            this.bDe.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bEN != null && cardPersonDynamicThreadData.bEN.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bEN.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bEN[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bDf.setText(sb4);
                this.bDf.setVisibility(0);
            } else {
                this.bDf.setVisibility(8);
            }
        } else {
            this.bDf.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bEP;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bCj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bCj.setVoiceModel(voiceModel);
            this.bCj.setTag(voiceModel);
            this.bCj.bef();
            if (voiceModel != null) {
                this.bCj.my(voiceModel.voice_status.intValue());
            }
        } else {
            this.bCj.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bEO;
        this.bDg.setVisibility(8);
        this.bDh.setVisibility(8);
        if (cardPersonDynamicThreadData.bEK == 36) {
            this.bCl.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bEK == 33) {
            this.bCl.setVisibility(8);
            if (com.baidu.tbadk.core.r.oK().oQ() && cardPersonDynamicThreadData.bEQ != null && !StringUtils.isNull(cardPersonDynamicThreadData.bEQ.livecover_src)) {
                this.bDg.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bEQ)) {
                    this.bDg.setShowExpression(false);
                } else {
                    this.bDg.setShowExpression(true);
                }
                this.bDg.setShowImage(com.baidu.tbadk.core.r.oK().oQ());
                this.bDg.setChooseStyle(c.getShowStyle());
                this.bDg.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bEK == 40 || cardPersonDynamicThreadData.bEK == 50 || cardPersonDynamicThreadData.bEK == 49) {
            this.bCl.setVisibility(8);
            if (com.baidu.tbadk.core.r.oK().oQ()) {
                this.bDh.setVisibility(0);
                if (this.bDa.videoInfo != null || this.bDa.threadData.rJ() != null) {
                    this.bDi.setDefaultErrorResource(0);
                    this.bDi.setDefaultBgResource(w.g.pic_bg_video_frs);
                    this.bDi.setEvent(this.byN);
                    if (cardPersonDynamicThreadData.threadData.rJ() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rJ().cover)) {
                        this.bDi.c(cardPersonDynamicThreadData.threadData.rJ().cover, 10, false);
                    } else if (this.bDa.videoInfo != null) {
                        this.bDi.c(this.bDa.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (com.baidu.tbadk.core.r.oK().oQ() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bm bmVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.aw.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.z.s(linkedList) > 0) {
                this.bCl.setVisibility(0);
                this.bCl.setFromCDN(this.ahU);
                this.bCl.setSingleImageRatio(0.67d);
                this.bCl.setImageClickListener(new cd(this, linkedList2, bmVar));
                this.bCl.setImageUrls(linkedList);
            } else {
                this.bCl.setVisibility(8);
            }
        } else {
            this.bCl.setVisibility(8);
        }
        VH();
    }

    private void VH() {
        this.bCj.setClickable(true);
        int childCount = this.bCl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VI() {
        if (this.bDa != null) {
            if (!Vw()) {
                at.iI(this.bDa.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajP.getPageActivity()).createCfgForPersonCenter(this.bDa.threadId, this.bDa.bEH, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vw() {
        return this.bDa.bEm && !this.bDa.aBd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bCl != null) {
            this.bCl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bCl != null) {
            this.bCl.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bm bmVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bmVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.ahU ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(bmVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajP.getPageActivity()).createConfig(arrayList, i, bmVar.rw(), String.valueOf(bmVar.getFid()), bmVar.getTid(), this.ahU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bEK == 33 || cardPersonDynamicThreadData.bEK == 1 || cardPersonDynamicThreadData.bEK == 2 || cardPersonDynamicThreadData.bEK == 49 || cardPersonDynamicThreadData.bEK == 50;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bEQ != null) {
            if (cardPersonDynamicThreadData.bEQ.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bEQ.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bEQ.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bEQ.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bEQ.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bEQ.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bEQ.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bEQ.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bEQ.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bEQ.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bEN != null && cardPersonDynamicThreadData.bEN.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bEN.length; i++) {
                sb.append(cardPersonDynamicThreadData.bEN[i].text);
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
                nVar.ei(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
