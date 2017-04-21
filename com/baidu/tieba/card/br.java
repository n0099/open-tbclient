package com.baidu.tieba.card;

import android.text.SpannableString;
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
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
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
public class br extends a<CardPersonDynamicThreadData> {
    private TbImageView.a aTt;
    private boolean aid;
    private TbPageContext<?> ajU;
    private final View.OnClickListener ama;
    private View avK;
    private LinearLayout bca;
    public ThreadCommentAndPraiseInfoLayout btW;
    private CustomMessageListener buW;
    public PlayVoiceBntNew bvE;
    private ConstrainImageGroup bvI;
    private View.OnClickListener bvJ;
    private FrsCommonImageLayout.b bvK;
    private final View.OnClickListener bvL;
    private final String bvP;
    private final String bvQ;
    private final View.OnClickListener bvR;
    private TextView bwA;
    private TextView bwB;
    private TextView bwC;
    private PhotoLiveCoverView bwD;
    private View bwE;
    private TbImageView bwF;
    private ImageView bwG;
    com.baidu.tieba.view.q bwH;
    private CardPersonDynamicThreadData bwv;
    private LinearLayout bww;
    private TextView bwx;
    private TextView bwy;
    private View bwz;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public br(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bvP = "1";
        this.bvQ = "2";
        this.mSkinType = 3;
        this.aid = true;
        this.bwH = new bs(this);
        this.bvJ = new bt(this);
        this.buW = new bu(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bvK = new bv(this);
        this.bvR = new bw(this);
        this.bvL = new bx(this);
        this.ama = new by(this);
        this.aTt = new bz(this);
        this.mRootView = getView();
        this.ajU = tbPageContext;
        this.avK = this.mRootView.findViewById(w.h.bottom_divider);
        this.bca = (LinearLayout) this.mRootView.findViewById(w.h.content_layout);
        this.bww = (LinearLayout) this.mRootView.findViewById(w.h.left_time_view);
        this.bwx = (TextView) this.mRootView.findViewById(w.h.month_num);
        this.bwy = (TextView) this.mRootView.findViewById(w.h.day_num);
        this.bwz = this.mRootView.findViewById(w.h.my_thread_forum);
        this.bwA = (TextView) this.mRootView.findViewById(w.h.identity);
        this.bwB = (TextView) this.mRootView.findViewById(w.h.forum_text);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.thread_title);
        this.bvE = (PlayVoiceBntNew) this.mRootView.findViewById(w.h.card_dynamic_thread_abstract_voice);
        this.bvE.setAfterClickListener(this.bvL);
        this.bwC = (TextView) this.mRootView.findViewById(w.h.thread_content);
        this.bvI = (ConstrainImageGroup) this.mRootView.findViewById(w.h.card_dynamic_thread_img_layout);
        this.bvI.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4));
        this.bvI.setChildClickListener(this.bvR);
        this.bwE = this.mRootView.findViewById(w.h.thread_view_img_container);
        this.bwF = (TbImageView) this.mRootView.findViewById(w.h.thread_video_thumbnail);
        this.bwG = (ImageView) this.mRootView.findViewById(w.h.thread_img_pause_play);
        this.bwD = (PhotoLiveCoverView) this.mRootView.findViewById(w.h.photo_live_cover_view);
        this.btW = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avK, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.bwx, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.bwy, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.bwA, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.bwB, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bwC, w.e.cp_cont_c);
            this.btW.onChangeSkinType();
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
        String string;
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bwv = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvJ);
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.byh) {
            this.bwz.setVisibility(0);
            TextView textView = this.bwA;
            if (cardPersonDynamicThreadData.bjz) {
                string = getContext().getString(w.l.me);
            } else if (cardPersonDynamicThreadData.sex == 2) {
                string = getContext().getString(w.l.person_identity_she);
            } else {
                string = getContext().getString(w.l.he);
            }
            textView.setText(string);
            String str = cardPersonDynamicThreadData.forumName;
            if (!StringUtils.isNull(str) && str.length() > 7) {
                str = String.valueOf(str.substring(0, 7)) + "...";
            }
            SpannableString spannableString = new SpannableString(String.format(getContext().getString(w.l.person_dynamic_top_bar_name), str));
            spannableString.setSpan(this.bwH, 1, str.length() + 2, 33);
            this.bwB.setText(spannableString);
            this.bwB.setMovementMethod(com.baidu.tieba.view.r.bnq());
            this.bwB.setHighlightColor(0);
            this.bwB.setLongClickable(false);
        }
        this.bww.setVisibility(cardPersonDynamicThreadData.byg ? 0 : 4);
        if (cardPersonDynamicThreadData.byh && cardPersonDynamicThreadData.threadData.sh() <= 0) {
            this.btW.setVisibility(8);
            if (this.bca != null) {
                this.bca.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
            }
        } else {
            this.btW.setVisibility(0);
            this.btW.setFrom(2);
            this.btW.a(cardPersonDynamicThreadData.threadData);
            this.btW.setForumAfterClickListener(this.ama);
            if (this.bca != null) {
                this.bca.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bxY == 33) {
                arrayList.add(new at.a(w.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bxY == 1) {
                arrayList.add(new at.a(w.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bxY == 36) {
                arrayList.add(new at.a(w.l.vote));
            }
            if (cardPersonDynamicThreadData.bxY == 2) {
                arrayList.add(new at.a(w.l.interview_live));
            }
            this.mTitle.setText(at.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<at.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bxY == 11) {
            this.mTitle.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.bwx.setText(cardPersonDynamicThreadData.bxZ);
        this.bwy.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bya != null && cardPersonDynamicThreadData.bya.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bya.length; i++) {
                sb.append(cardPersonDynamicThreadData.bya[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bwC.setText(sb2);
                this.bwC.setVisibility(0);
            } else {
                this.bwC.setVisibility(8);
            }
        } else {
            this.bwC.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.byd;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bvE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bvE.setVoiceModel(voiceModel);
            this.bvE.setTag(voiceModel);
            this.bvE.bbd();
            if (voiceModel != null) {
                this.bvE.mg(voiceModel.voice_status.intValue());
            }
        } else {
            this.bvE.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.byb;
        this.bwD.setVisibility(8);
        this.bwE.setVisibility(8);
        if (cardPersonDynamicThreadData.bxY == 36) {
            this.bvI.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bxY == 33) {
            this.bvI.setVisibility(8);
            if (com.baidu.tbadk.core.q.po().pu() && cardPersonDynamicThreadData.bye != null && !StringUtils.isNull(cardPersonDynamicThreadData.bye.livecover_src)) {
                this.bwD.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bye)) {
                    this.bwD.setShowExpression(false);
                } else {
                    this.bwD.setShowExpression(true);
                }
                this.bwD.setShowImage(com.baidu.tbadk.core.q.po().pu());
                this.bwD.setChooseStyle(c.getShowStyle());
                this.bwD.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bxY == 40 || cardPersonDynamicThreadData.bxY == 50) {
            this.bvI.setVisibility(8);
            if (com.baidu.tbadk.core.q.po().pu()) {
                this.bwE.setVisibility(0);
                if (com.baidu.tbadk.core.q.po().pu() && mediaDataArr.length > 0) {
                    this.bwF.setDefaultErrorResource(0);
                    this.bwF.setDefaultBgResource(w.g.pic_bg_video_frs);
                    this.bwF.setEvent(this.aTt);
                    if (this.bwv.byc != null) {
                        this.bwF.c(this.bwv.byc.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (com.baidu.tbadk.core.q.po().pu() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bi biVar = cardPersonDynamicThreadData.threadData;
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
            if (com.baidu.tbadk.core.util.x.p(linkedList) > 0) {
                this.bvI.setVisibility(0);
                this.bvI.setFromCDN(this.aid);
                this.bvI.setImageClickListener(new ca(this, linkedList2, biVar));
                this.bvI.setImageUrls(linkedList);
            } else {
                this.bvI.setVisibility(8);
            }
        } else {
            this.bvI.setVisibility(8);
        }
        TQ();
    }

    private void TQ() {
        this.bvE.setClickable(true);
        this.btW.setBarNameClickEnabled(true);
        int childCount = this.bvI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvI.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TR() {
        if (this.bwv != null) {
            if (!TN()) {
                at.hZ(this.bwv.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajU.getPageActivity()).createCfgForPersonCenter(this.bwv.threadId, this.bwv.bxV, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TN() {
        return this.bwv.bxz && !this.bwv.aAq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvI != null) {
            this.bvI.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvI != null) {
            this.bvI.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajU.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aid ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(biVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.aid ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(biVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajU.getPageActivity()).createConfig(arrayList, i, biVar.st(), String.valueOf(biVar.getFid()), biVar.getTid(), this.aid, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bxY == 33 || cardPersonDynamicThreadData.bxY == 1 || cardPersonDynamicThreadData.bxY == 2;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bye != null) {
            if (cardPersonDynamicThreadData.bye.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bye.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bye.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bye.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bye.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bye.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bye.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bye.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bye.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bye.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bya != null && cardPersonDynamicThreadData.bya.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bya.length; i++) {
                sb.append(cardPersonDynamicThreadData.bya[i].text);
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
                nVar.eh(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
