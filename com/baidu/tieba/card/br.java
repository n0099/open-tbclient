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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class br extends a<CardPersonDynamicThreadData> {
    private View FN;
    private TbPageContext<?> FY;
    private TextView aNb;
    private TbImageView.a aNp;
    private LinearLayout aUY;
    private boolean acy;
    private final View.OnClickListener agt;
    public ThreadCommentAndPraiseInfoLayout bkU;
    private CustomMessageListener blR;
    private ConstrainImageGroup bmD;
    private View.OnClickListener bmE;
    private FrsCommonImageLayout.b bmF;
    private final View.OnClickListener bmG;
    private final String bmK;
    private final String bmL;
    private final View.OnClickListener bmM;
    public PlayVoiceBntNew bmz;
    private TbImageView bnA;
    private ImageView bnB;
    com.baidu.tieba.view.q bnC;
    private CardPersonDynamicThreadData bnq;
    private LinearLayout bnr;
    private TextView bns;
    private TextView bnt;
    private View bnu;
    private TextView bnv;
    private TextView bnw;
    private TextView bnx;
    private PhotoLiveCoverView bny;
    private View bnz;
    private View mRootView;
    private int mSkinType;

    public br(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bmK = "1";
        this.bmL = "2";
        this.mSkinType = 3;
        this.acy = true;
        this.bnC = new bs(this);
        this.bmE = new bt(this);
        this.blR = new bu(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bmF = new bv(this);
        this.bmM = new bw(this);
        this.bmG = new bx(this);
        this.agt = new by(this);
        this.aNp = new bz(this);
        this.mRootView = getView();
        this.FY = tbPageContext;
        this.FN = this.mRootView.findViewById(r.h.bottom_divider);
        this.aUY = (LinearLayout) this.mRootView.findViewById(r.h.content_layout);
        this.bnr = (LinearLayout) this.mRootView.findViewById(r.h.left_time_view);
        this.bns = (TextView) this.mRootView.findViewById(r.h.month_num);
        this.bnt = (TextView) this.mRootView.findViewById(r.h.day_num);
        this.bnu = this.mRootView.findViewById(r.h.my_thread_forum);
        this.bnv = (TextView) this.mRootView.findViewById(r.h.identity);
        this.bnw = (TextView) this.mRootView.findViewById(r.h.forum_text);
        this.aNb = (TextView) this.mRootView.findViewById(r.h.thread_title);
        this.bmz = (PlayVoiceBntNew) this.mRootView.findViewById(r.h.card_dynamic_thread_abstract_voice);
        this.bmz.setAfterClickListener(this.bmG);
        this.bnx = (TextView) this.mRootView.findViewById(r.h.thread_content);
        this.bmD = (ConstrainImageGroup) this.mRootView.findViewById(r.h.card_dynamic_thread_img_layout);
        this.bmD.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds4));
        this.bmD.setChildClickListener(this.bmM);
        this.bnz = this.mRootView.findViewById(r.h.thread_view_img_container);
        this.bnA = (TbImageView) this.mRootView.findViewById(r.h.thread_video_thumbnail);
        this.bnB = (ImageView) this.mRootView.findViewById(r.h.thread_img_pause_play);
        this.bny = (PhotoLiveCoverView) this.mRootView.findViewById(r.h.photo_live_cover_view);
        this.bkU = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(getView(), r.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.ap.k(this.FN, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.i((View) this.bns, r.e.cp_cont_f);
            com.baidu.tbadk.core.util.ap.i((View) this.bnt, r.e.cp_cont_f);
            com.baidu.tbadk.core.util.ap.i((View) this.bnv, r.e.cp_cont_f);
            com.baidu.tbadk.core.util.ap.i((View) this.bnw, r.e.cp_cont_f);
            com.baidu.tbadk.core.util.ap.i((View) this.aNb, r.e.cp_cont_b);
            com.baidu.tbadk.core.util.ap.i((View) this.bnx, r.e.cp_cont_c);
            this.bkU.tg();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_person_dynamic_thread;
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
        this.bnq = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bmE);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bpc) {
            this.bnu.setVisibility(0);
            TextView textView = this.bnv;
            if (cardPersonDynamicThreadData.baK) {
                string = getContext().getString(r.l.me);
            } else if (cardPersonDynamicThreadData.sex == 2) {
                string = getContext().getString(r.l.person_identity_she);
            } else {
                string = getContext().getString(r.l.he);
            }
            textView.setText(string);
            String str = cardPersonDynamicThreadData.forumName;
            if (!StringUtils.isNull(str) && str.length() > 7) {
                str = String.valueOf(str.substring(0, 7)) + "...";
            }
            SpannableString spannableString = new SpannableString(String.format(getContext().getString(r.l.person_dynamic_top_bar_name), str));
            spannableString.setSpan(this.bnC, 1, str.length() + 2, 33);
            this.bnw.setText(spannableString);
            this.bnw.setMovementMethod(com.baidu.tieba.view.r.blQ());
            this.bnw.setHighlightColor(0);
            this.bnw.setLongClickable(false);
        }
        this.bnr.setVisibility(cardPersonDynamicThreadData.bpb ? 0 : 4);
        if (cardPersonDynamicThreadData.bpc && cardPersonDynamicThreadData.threadData.rp() <= 0) {
            this.bkU.setVisibility(8);
            if (this.aUY != null) {
                this.aUY.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds40));
            }
        } else {
            this.bkU.setVisibility(0);
            this.bkU.setFrom(2);
            this.bkU.a(cardPersonDynamicThreadData.threadData);
            this.bkU.setForumAfterClickListener(this.agt);
            if (this.aUY != null) {
                this.aUY.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.aNb.setVisibility(8);
        } else {
            this.aNb.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.boT == 33) {
                arrayList.add(new at.a(r.l.kn_zhibo));
            }
            if (cardPersonDynamicThreadData.boT == 1) {
                arrayList.add(new at.a(r.l.commit_top));
            }
            if (cardPersonDynamicThreadData.boT == 36) {
                arrayList.add(new at.a(r.l.vote));
            }
            if (cardPersonDynamicThreadData.boT == 2) {
                arrayList.add(new at.a(r.l.interview_live));
            }
            this.aNb.setText(at.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<at.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.boT == 11) {
            this.aNb.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.aNb.setText(cardPersonDynamicThreadData.title);
        }
        this.bns.setText(cardPersonDynamicThreadData.boU);
        this.bnt.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.boV != null && cardPersonDynamicThreadData.boV.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.boV.length; i++) {
                sb.append(cardPersonDynamicThreadData.boV[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bnx.setText(sb2);
                this.bnx.setVisibility(0);
            } else {
                this.bnx.setVisibility(8);
            }
        } else {
            this.bnx.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.boY;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bmz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bmz.setVoiceModel(voiceModel);
            this.bmz.setTag(voiceModel);
            this.bmz.ayK();
            if (voiceModel != null) {
                this.bmz.mj(voiceModel.voice_status.intValue());
            }
        } else {
            this.bmz.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.boW;
        this.bny.setVisibility(8);
        this.bnz.setVisibility(8);
        if (cardPersonDynamicThreadData.boT == 36) {
            this.bmD.setVisibility(8);
        } else if (cardPersonDynamicThreadData.boT == 33) {
            this.bmD.setVisibility(8);
            if (com.baidu.tbadk.core.l.oC().oI() && cardPersonDynamicThreadData.boZ != null && !StringUtils.isNull(cardPersonDynamicThreadData.boZ.livecover_src)) {
                this.bny.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.boZ)) {
                    this.bny.setShowExpression(false);
                } else {
                    this.bny.setShowExpression(true);
                }
                this.bny.setShowImage(com.baidu.tbadk.core.l.oC().oI());
                this.bny.setChooseStyle(c.getShowStyle());
                this.bny.setData(c);
            }
        } else if (cardPersonDynamicThreadData.boT == 40 || cardPersonDynamicThreadData.boT == 50) {
            this.bmD.setVisibility(8);
            if (com.baidu.tbadk.core.l.oC().oI()) {
                this.bnz.setVisibility(0);
                if (com.baidu.tbadk.core.l.oC().oI() && mediaDataArr.length > 0) {
                    this.bnA.setDefaultErrorResource(0);
                    this.bnA.setDefaultBgResource(r.g.pic_bg_video_frs);
                    this.bnA.setEvent(this.aNp);
                    if (this.bnq.boX != null) {
                        this.bnA.c(this.bnq.boX.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (com.baidu.tbadk.core.l.oC().oI() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bh bhVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.at.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.w.r(linkedList) > 0) {
                this.bmD.setVisibility(0);
                this.bmD.setFromCDN(this.acy);
                this.bmD.setImageClickListener(new ca(this, linkedList2, bhVar));
                this.bmD.setImageUrls(linkedList);
            } else {
                this.bmD.setVisibility(8);
            }
        } else {
            this.bmD.setVisibility(8);
        }
        Rs();
    }

    private void Rs() {
        this.bmz.setClickable(true);
        this.bkU.setBarNameClickEnabled(true);
        int childCount = this.bmD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bmD.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rt() {
        if (this.bnq != null) {
            if (!Rp()) {
                at.ie(this.bnq.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.FY.getPageActivity()).createCfgForPersonCenter(this.bnq.threadId, this.bnq.boQ, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Rp() {
        return this.bnq.bou && !this.bnq.auD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bmD != null) {
            this.bmD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bmD != null) {
            this.bmD.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bh bhVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.FY.getPageActivity(), r.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.acy ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.acy ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.FY.getPageActivity()).createConfig(arrayList, i, bhVar.rB(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.acy, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.boT == 33 || cardPersonDynamicThreadData.boT == 1 || cardPersonDynamicThreadData.boT == 2;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.boZ != null) {
            if (cardPersonDynamicThreadData.boZ.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.boZ.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.boZ.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.boZ.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.boZ.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.boZ.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.boZ.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.boZ.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.boZ.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.boZ.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.boV != null && cardPersonDynamicThreadData.boV.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.boV.length; i++) {
                sb.append(cardPersonDynamicThreadData.boV[i].text);
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
                nVar.ej(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
