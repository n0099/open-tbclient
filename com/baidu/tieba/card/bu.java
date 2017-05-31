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
    private boolean ahm;
    private TbPageContext<?> ajh;
    private final View.OnClickListener alO;
    private CustomMessageListener bAA;
    private FrsCommonImageLayout.b bBC;
    private final View.OnClickListener bBD;
    public PlayVoiceBntNew bBq;
    private ConstrainImageGroup bBs;
    private final View.OnClickListener bBt;
    private final String bBy;
    private final String bBz;
    public ThreadViewAndCommentInfoLayout bCg;
    private CardPersonDynamicThreadData bCh;
    private LinearLayout bCi;
    private TextView bCj;
    private TextView bCk;
    private TextView bCl;
    private TextView bCm;
    private PhotoLiveCoverView bCn;
    private View bCo;
    private TbImageView bCp;
    private ImageView bCq;
    com.baidu.tieba.view.v bCr;
    private LinearLayout bdK;
    private TbImageView.a bwc;
    private View.OnClickListener bzI;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public bu(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bBy = "1";
        this.bBz = "2";
        this.mSkinType = 3;
        this.ahm = true;
        this.bCr = new bv(this);
        this.bzI = new bw(this);
        this.bAA = new bx(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bBC = new by(this);
        this.bBD = new bz(this);
        this.bBt = new ca(this);
        this.alO = new cb(this);
        this.bwc = new cc(this);
        this.mRootView = getView();
        this.ajh = tbPageContext;
        this.bdK = (LinearLayout) this.mRootView.findViewById(w.h.content_layout);
        this.bCi = (LinearLayout) this.mRootView.findViewById(w.h.left_time_view);
        this.bCj = (TextView) this.mRootView.findViewById(w.h.month_num);
        this.bCk = (TextView) this.mRootView.findViewById(w.h.day_num);
        this.bCl = (TextView) this.mRootView.findViewById(w.h.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.thread_title);
        this.bBq = (PlayVoiceBntNew) this.mRootView.findViewById(w.h.card_dynamic_thread_abstract_voice);
        this.bBq.setAfterClickListener(this.bBt);
        this.bCm = (TextView) this.mRootView.findViewById(w.h.thread_content);
        this.bBs = (ConstrainImageGroup) this.mRootView.findViewById(w.h.card_dynamic_thread_img_layout);
        this.bBs.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16));
        this.bBs.setChildClickListener(this.bBD);
        this.bBs.setImageProcessor(new com.baidu.tbadk.widget.layout.i(3));
        this.bCo = this.mRootView.findViewById(w.h.thread_view_img_container);
        this.bCp = (TbImageView) this.mRootView.findViewById(w.h.thread_video_thumbnail);
        this.bCq = (ImageView) this.mRootView.findViewById(w.h.thread_img_pause_play);
        this.bCn = (PhotoLiveCoverView) this.mRootView.findViewById(w.h.photo_live_cover_view);
        this.bCg = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(w.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.i(this.bCj, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.bCk, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bCl, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bCm, w.e.cp_cont_f);
            this.bCg.onChangeSkinType();
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
        this.bCh = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bzI);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        this.bCi.setVisibility(cardPersonDynamicThreadData.bEb ? 0 : 4);
        if (cardPersonDynamicThreadData.bEc && cardPersonDynamicThreadData.threadData.rn() < 0) {
            this.bCg.setVisibility(8);
            if (this.bdK != null) {
                this.bdK.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
            }
        } else {
            this.bCg.setVisibility(0);
            this.bCg.setData(cardPersonDynamicThreadData.threadData);
            if (this.bdK != null) {
                this.bdK.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bDS == 33) {
                arrayList.add(new at.a(w.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bDS == 1) {
                arrayList.add(new at.a(w.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bDS == 36) {
                arrayList.add(new at.a(w.l.vote));
            }
            if (cardPersonDynamicThreadData.bDS == 2) {
                arrayList.add(new at.a(w.l.interview_live));
            }
            if (cardPersonDynamicThreadData.bDS == 49) {
                arrayList.add(new at.a(w.l.live_in));
            }
            if (cardPersonDynamicThreadData.bDS == 50) {
                arrayList.add(new at.a(w.l.live_record));
            }
            this.mTitle.setText(at.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<at.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bDS == 11) {
            this.mTitle.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bCj.setText(cardPersonDynamicThreadData.bDU);
        this.bCk.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bEa != null && cardPersonDynamicThreadData.bEa.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bEa.length; i++) {
                sb.append(com.baidu.tbadk.core.util.au.d(cardPersonDynamicThreadData.bEa[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bEa.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(w.l.bar)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(w.l.bar));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bCl.setText(sb2);
                this.bCl.setVisibility(0);
            } else {
                this.bCl.setVisibility(8);
            }
        } else {
            this.bCl.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.bDV != null && cardPersonDynamicThreadData.bDV.length > 0) {
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < cardPersonDynamicThreadData.bDV.length; i2++) {
                sb3.append(cardPersonDynamicThreadData.bDV[i2].text);
            }
            String sb4 = sb3.toString();
            if (sb4.trim().length() > 0) {
                this.bCm.setText(sb4);
                this.bCm.setVisibility(0);
            } else {
                this.bCm.setVisibility(8);
            }
        } else {
            this.bCm.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bDX;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bBq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bBq.setVoiceModel(voiceModel);
            this.bBq.setTag(voiceModel);
            this.bBq.aZV();
            if (voiceModel != null) {
                this.bBq.mn(voiceModel.voice_status.intValue());
            }
        } else {
            this.bBq.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bDW;
        this.bCn.setVisibility(8);
        this.bCo.setVisibility(8);
        if (cardPersonDynamicThreadData.bDS == 36) {
            this.bBs.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bDS == 33) {
            this.bBs.setVisibility(8);
            if (com.baidu.tbadk.core.r.oN().oT() && cardPersonDynamicThreadData.bDY != null && !StringUtils.isNull(cardPersonDynamicThreadData.bDY.livecover_src)) {
                this.bCn.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bDY)) {
                    this.bCn.setShowExpression(false);
                } else {
                    this.bCn.setShowExpression(true);
                }
                this.bCn.setShowImage(com.baidu.tbadk.core.r.oN().oT());
                this.bCn.setChooseStyle(c.getShowStyle());
                this.bCn.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bDS == 40 || cardPersonDynamicThreadData.bDS == 50 || cardPersonDynamicThreadData.bDS == 49) {
            this.bBs.setVisibility(8);
            if (com.baidu.tbadk.core.r.oN().oT()) {
                this.bCo.setVisibility(0);
                if (this.bCh.videoInfo != null || this.bCh.threadData.rM() != null) {
                    this.bCp.setDefaultErrorResource(0);
                    this.bCp.setDefaultBgResource(w.g.pic_bg_video_frs);
                    this.bCp.setEvent(this.bwc);
                    if (cardPersonDynamicThreadData.threadData.rM() != null && !TextUtils.isEmpty(cardPersonDynamicThreadData.threadData.rM().cover)) {
                        this.bCp.c(cardPersonDynamicThreadData.threadData.rM().cover, 10, false);
                    } else if (this.bCh.videoInfo != null) {
                        this.bCp.c(this.bCh.videoInfo.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (com.baidu.tbadk.core.r.oN().oT() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bl blVar = cardPersonDynamicThreadData.threadData;
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
                this.bBs.setVisibility(0);
                this.bBs.setFromCDN(this.ahm);
                this.bBs.setSingleImageRatio(0.67d);
                this.bBs.setImageClickListener(new cd(this, linkedList2, blVar));
                this.bBs.setImageUrls(linkedList);
            } else {
                this.bBs.setVisibility(8);
            }
        } else {
            this.bBs.setVisibility(8);
        }
        Uq();
    }

    private void Uq() {
        this.bBq.setClickable(true);
        int childCount = this.bBs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bBs.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        if (this.bCh != null) {
            if (!Uh()) {
                at.ib(this.bCh.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajh.getPageActivity()).createCfgForPersonCenter(this.bCh.threadId, this.bCh.bDP, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uh() {
        return this.bCh.bDt && !this.bCh.aAa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bBs != null) {
            this.bBs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bBs != null) {
            this.bBs.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bl blVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajh.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahm ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.ahm ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajh.getPageActivity()).createConfig(arrayList, i, blVar.rz(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ahm, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bDS == 33 || cardPersonDynamicThreadData.bDS == 1 || cardPersonDynamicThreadData.bDS == 2 || cardPersonDynamicThreadData.bDS == 49 || cardPersonDynamicThreadData.bDS == 50;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bDY != null) {
            if (cardPersonDynamicThreadData.bDY.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bDY.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bDY.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bDY.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bDY.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bDY.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bDY.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bDY.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bDY.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bDY.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bDV != null && cardPersonDynamicThreadData.bDV.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bDV.length; i++) {
                sb.append(cardPersonDynamicThreadData.bDV[i].text);
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
                nVar.eg(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
