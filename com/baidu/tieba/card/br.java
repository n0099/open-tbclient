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
    private TbImageView.a aTr;
    private boolean aic;
    private TbPageContext<?> ajT;
    private final View.OnClickListener ama;
    private View avI;
    private LinearLayout bbe;
    public ThreadCommentAndPraiseInfoLayout brE;
    private CustomMessageListener bsD;
    public PlayVoiceBntNew btl;
    private ConstrainImageGroup btq;
    private View.OnClickListener btr;
    private FrsCommonImageLayout.b bts;
    private final View.OnClickListener btt;
    private final String btx;
    private final String bty;
    private final View.OnClickListener btz;
    private CardPersonDynamicThreadData bud;
    private LinearLayout bue;
    private TextView buf;
    private TextView bug;
    private View buh;
    private TextView bui;
    private TextView buj;
    private TextView buk;
    private PhotoLiveCoverView bul;
    private View bum;
    private TbImageView bun;
    private ImageView buo;
    com.baidu.tieba.view.q bup;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public br(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btx = "1";
        this.bty = "2";
        this.mSkinType = 3;
        this.aic = true;
        this.bup = new bs(this);
        this.btr = new bt(this);
        this.bsD = new bu(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bts = new bv(this);
        this.btz = new bw(this);
        this.btt = new bx(this);
        this.ama = new by(this);
        this.aTr = new bz(this);
        this.mRootView = getView();
        this.ajT = tbPageContext;
        this.avI = this.mRootView.findViewById(w.h.bottom_divider);
        this.bbe = (LinearLayout) this.mRootView.findViewById(w.h.content_layout);
        this.bue = (LinearLayout) this.mRootView.findViewById(w.h.left_time_view);
        this.buf = (TextView) this.mRootView.findViewById(w.h.month_num);
        this.bug = (TextView) this.mRootView.findViewById(w.h.day_num);
        this.buh = this.mRootView.findViewById(w.h.my_thread_forum);
        this.bui = (TextView) this.mRootView.findViewById(w.h.identity);
        this.buj = (TextView) this.mRootView.findViewById(w.h.forum_text);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.thread_title);
        this.btl = (PlayVoiceBntNew) this.mRootView.findViewById(w.h.card_dynamic_thread_abstract_voice);
        this.btl.setAfterClickListener(this.btt);
        this.buk = (TextView) this.mRootView.findViewById(w.h.thread_content);
        this.btq = (ConstrainImageGroup) this.mRootView.findViewById(w.h.card_dynamic_thread_img_layout);
        this.btq.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4));
        this.btq.setChildClickListener(this.btz);
        this.bum = this.mRootView.findViewById(w.h.thread_view_img_container);
        this.bun = (TbImageView) this.mRootView.findViewById(w.h.thread_video_thumbnail);
        this.buo = (ImageView) this.mRootView.findViewById(w.h.thread_img_pause_play);
        this.bul = (PhotoLiveCoverView) this.mRootView.findViewById(w.h.photo_live_cover_view);
        this.brE = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avI, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.buf, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.bug, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.bui, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.buj, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.buk, w.e.cp_cont_c);
            this.brE.onChangeSkinType();
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
        this.bud = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.btr);
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bvQ) {
            this.buh.setVisibility(0);
            TextView textView = this.bui;
            if (cardPersonDynamicThreadData.bho) {
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
            spannableString.setSpan(this.bup, 1, str.length() + 2, 33);
            this.buj.setText(spannableString);
            this.buj.setMovementMethod(com.baidu.tieba.view.r.bmp());
            this.buj.setHighlightColor(0);
            this.buj.setLongClickable(false);
        }
        this.bue.setVisibility(cardPersonDynamicThreadData.bvP ? 0 : 4);
        if (cardPersonDynamicThreadData.bvQ && cardPersonDynamicThreadData.threadData.sh() <= 0) {
            this.brE.setVisibility(8);
            if (this.bbe != null) {
                this.bbe.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
            }
        } else {
            this.brE.setVisibility(0);
            this.brE.setFrom(2);
            this.brE.a(cardPersonDynamicThreadData.threadData);
            this.brE.setForumAfterClickListener(this.ama);
            if (this.bbe != null) {
                this.bbe.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bvH == 33) {
                arrayList.add(new at.a(w.l.photo_live_tips));
            }
            if (cardPersonDynamicThreadData.bvH == 1) {
                arrayList.add(new at.a(w.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bvH == 36) {
                arrayList.add(new at.a(w.l.vote));
            }
            if (cardPersonDynamicThreadData.bvH == 2) {
                arrayList.add(new at.a(w.l.interview_live));
            }
            this.mTitle.setText(at.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<at.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bvH == 11) {
            this.mTitle.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.mTitle.setText(cardPersonDynamicThreadData.title);
        }
        this.buf.setText(cardPersonDynamicThreadData.bvI);
        this.bug.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bvJ != null && cardPersonDynamicThreadData.bvJ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bvJ.length; i++) {
                sb.append(cardPersonDynamicThreadData.bvJ[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.buk.setText(sb2);
                this.buk.setVisibility(0);
            } else {
                this.buk.setVisibility(8);
            }
        } else {
            this.buk.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bvM;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.btl.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.btl.setVoiceModel(voiceModel);
            this.btl.setTag(voiceModel);
            this.btl.bac();
            if (voiceModel != null) {
                this.btl.ma(voiceModel.voice_status.intValue());
            }
        } else {
            this.btl.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bvK;
        this.bul.setVisibility(8);
        this.bum.setVisibility(8);
        if (cardPersonDynamicThreadData.bvH == 36) {
            this.btq.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bvH == 33) {
            this.btq.setVisibility(8);
            if (com.baidu.tbadk.core.q.po().pu() && cardPersonDynamicThreadData.bvN != null && !StringUtils.isNull(cardPersonDynamicThreadData.bvN.livecover_src)) {
                this.bul.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bvN)) {
                    this.bul.setShowExpression(false);
                } else {
                    this.bul.setShowExpression(true);
                }
                this.bul.setShowImage(com.baidu.tbadk.core.q.po().pu());
                this.bul.setChooseStyle(c.getShowStyle());
                this.bul.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bvH == 40 || cardPersonDynamicThreadData.bvH == 50) {
            this.btq.setVisibility(8);
            if (com.baidu.tbadk.core.q.po().pu()) {
                this.bum.setVisibility(0);
                if (com.baidu.tbadk.core.q.po().pu() && mediaDataArr.length > 0) {
                    this.bun.setDefaultErrorResource(0);
                    this.bun.setDefaultBgResource(w.g.pic_bg_video_frs);
                    this.bun.setEvent(this.aTr);
                    if (this.bud.bvL != null) {
                        this.bun.c(this.bud.bvL.thumbnail_url, 17, false);
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
                this.btq.setVisibility(0);
                this.btq.setFromCDN(this.aic);
                this.btq.setImageClickListener(new ca(this, linkedList2, biVar));
                this.btq.setImageUrls(linkedList);
            } else {
                this.btq.setVisibility(8);
            }
        } else {
            this.btq.setVisibility(8);
        }
        SO();
    }

    private void SO() {
        this.btl.setClickable(true);
        this.brE.setBarNameClickEnabled(true);
        int childCount = this.btq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.btq.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SP() {
        if (this.bud != null) {
            if (!SL()) {
                at.hY(this.bud.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajT.getPageActivity()).createCfgForPersonCenter(this.bud.threadId, this.bud.bvE, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SL() {
        return this.bud.bvi && !this.bud.aAo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.btq != null) {
            this.btq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.btq != null) {
            this.btq.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajT.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aic ? 13 : 14;
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
                    imageUrlData2.urlType = this.aic ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(biVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajT.getPageActivity()).createConfig(arrayList, i, biVar.st(), String.valueOf(biVar.getFid()), biVar.getTid(), this.aic, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bvH == 33 || cardPersonDynamicThreadData.bvH == 1 || cardPersonDynamicThreadData.bvH == 2;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bvN != null) {
            if (cardPersonDynamicThreadData.bvN.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bvN.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bvN.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bvN.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bvN.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bvN.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bvN.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bvN.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bvN.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bvN.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bvJ != null && cardPersonDynamicThreadData.bvJ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bvJ.length; i++) {
                sb.append(cardPersonDynamicThreadData.bvJ[i].text);
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
