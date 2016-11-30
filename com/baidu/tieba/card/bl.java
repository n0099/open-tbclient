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
import com.baidu.tieba.card.an;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class bl extends a<CardPersonDynamicThreadData> {
    private View GD;
    private TbPageContext<?> GO;
    private TextView aOH;
    private TbImageView.a aOV;
    private boolean adU;
    private final View.OnClickListener ahD;
    private LinearLayout bcK;
    public ThreadCommentAndPraiseInfoLayout bca;
    private final String bdD;
    private final String bdE;
    private final View.OnClickListener bdF;
    private CustomMessageListener bdb;
    public PlayVoiceBntNew bds;
    private ConstrainImageGroup bdw;
    private View.OnClickListener bdx;
    private FrsCommonImageLayout.b bdy;
    private final View.OnClickListener bdz;
    private CardPersonDynamicThreadData bej;
    private LinearLayout bek;
    private TextView bel;
    private TextView bem;
    private View ben;
    private TextView beo;
    private TextView bep;
    private TextView beq;
    private PhotoLiveCoverView ber;
    private View bes;
    private TbImageView beu;
    private ImageView bev;
    private View.OnClickListener bew;
    com.baidu.tieba.view.q bex;
    private View mRootView;
    private int mSkinType;

    public bl(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdD = "1";
        this.bdE = "2";
        this.mSkinType = 3;
        this.adU = true;
        this.bex = new bm(this);
        this.bdx = new bo(this);
        this.bdb = new bp(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bdy = new bq(this);
        this.bdF = new br(this);
        this.bdz = new bs(this);
        this.ahD = new bt(this);
        this.aOV = new bu(this);
        this.mRootView = getView();
        this.GO = tbPageContext;
        this.GD = this.mRootView.findViewById(r.g.bottom_divider);
        this.bcK = (LinearLayout) this.mRootView.findViewById(r.g.content_layout);
        this.bek = (LinearLayout) this.mRootView.findViewById(r.g.left_time_view);
        this.bel = (TextView) this.mRootView.findViewById(r.g.month_num);
        this.bem = (TextView) this.mRootView.findViewById(r.g.day_num);
        this.ben = this.mRootView.findViewById(r.g.my_thread_forum);
        this.beo = (TextView) this.mRootView.findViewById(r.g.identity);
        this.bep = (TextView) this.mRootView.findViewById(r.g.forum_text);
        this.aOH = (TextView) this.mRootView.findViewById(r.g.thread_title);
        this.bds = (PlayVoiceBntNew) this.mRootView.findViewById(r.g.card_dynamic_thread_abstract_voice);
        this.bds.setAfterClickListener(this.bdz);
        this.beq = (TextView) this.mRootView.findViewById(r.g.thread_content);
        this.bdw = (ConstrainImageGroup) this.mRootView.findViewById(r.g.card_dynamic_thread_img_layout);
        this.bdw.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bdw.setChildClickListener(this.bdF);
        this.bes = this.mRootView.findViewById(r.g.thread_view_img_container);
        this.beu = (TbImageView) this.mRootView.findViewById(r.g.thread_video_thumbnail);
        this.bev = (ImageView) this.mRootView.findViewById(r.g.thread_img_pause_play);
        this.ber = (PhotoLiveCoverView) this.mRootView.findViewById(r.g.photo_live_cover_view);
        this.bca = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.g.card_dynamic_thread_info_layout);
        this.bew = new bv(this, tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), r.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.at.l(this.GD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.bel, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.j((View) this.bem, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.j((View) this.beo, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.j((View) this.bep, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.j((View) this.aOH, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.beq, r.d.cp_cont_c);
            this.bca.tB();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_person_dynamic_thread;
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
        this.bej = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bdx);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bfS) {
            this.ben.setVisibility(0);
            TextView textView = this.beo;
            if (cardPersonDynamicThreadData.bfT) {
                string = getContext().getString(r.j.person_identity_me);
            } else if (cardPersonDynamicThreadData.sex == 2) {
                string = getContext().getString(r.j.person_identity_she);
            } else {
                string = getContext().getString(r.j.person_identity_he);
            }
            textView.setText(string);
            String str = cardPersonDynamicThreadData.forumName;
            if (!StringUtils.isNull(str) && str.length() > 7) {
                str = String.valueOf(str.substring(0, 7)) + "...";
            }
            SpannableString spannableString = new SpannableString(String.format(getContext().getString(r.j.person_dynamic_top_bar_name), str));
            spannableString.setSpan(this.bex, 1, str.length() + 2, 33);
            this.bep.setText(spannableString);
            this.bep.setMovementMethod(com.baidu.tieba.view.r.bto());
            this.bep.setHighlightColor(0);
            this.bep.setLongClickable(false);
        }
        this.bek.setVisibility(cardPersonDynamicThreadData.bfR ? 0 : 4);
        if (cardPersonDynamicThreadData.bfS && cardPersonDynamicThreadData.threadData.rJ() <= 0) {
            this.bca.setVisibility(8);
            if (this.bcK != null) {
                this.bcK.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40));
            }
        } else {
            this.bca.setVisibility(0);
            this.bca.setFrom(2);
            this.bca.a(cardPersonDynamicThreadData.threadData);
            this.bca.setForumAfterClickListener(this.ahD);
            if (this.bcK != null) {
                this.bcK.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.aOH.setVisibility(8);
        } else {
            this.aOH.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bfJ == 33) {
                arrayList.add(new an.a(r.j.kn_zhibo));
            }
            if (cardPersonDynamicThreadData.isDeal && cardPersonDynamicThreadData.dealInfoData != null) {
                arrayList.add(new an.a(r.j.ecomm));
            }
            if (cardPersonDynamicThreadData.bfJ == 1) {
                arrayList.add(new an.a(r.j.commit_top));
            }
            if (cardPersonDynamicThreadData.bfJ == 36) {
                arrayList.add(new an.a(r.j.vote));
            }
            if (cardPersonDynamicThreadData.bfJ == 2) {
                arrayList.add(new an.a(r.j.interview_live));
            }
            if (cardPersonDynamicThreadData.bfU != null) {
                arrayList.add(new an.a(r.j.card_promotion_text));
            }
            this.aOH.setText(an.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<an.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bfJ == 11) {
            this.aOH.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.aOH.setText(cardPersonDynamicThreadData.title);
        }
        this.bel.setText(cardPersonDynamicThreadData.bfK);
        this.bem.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bfL != null && cardPersonDynamicThreadData.bfL.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bfL.length; i++) {
                sb.append(cardPersonDynamicThreadData.bfL[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.beq.setText(sb2);
                this.beq.setVisibility(0);
            } else {
                this.beq.setVisibility(8);
            }
        } else {
            this.beq.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bfO;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bds.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bds.setVoiceModel(voiceModel);
            this.bds.setTag(voiceModel);
            this.bds.aEg();
            if (voiceModel != null) {
                this.bds.mm(voiceModel.voice_status.intValue());
            }
        } else {
            this.bds.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bfM;
        this.ber.setVisibility(8);
        this.bes.setVisibility(8);
        if (cardPersonDynamicThreadData.bfJ == 36) {
            this.bdw.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bfJ == 33) {
            this.bdw.setVisibility(8);
            if (com.baidu.tbadk.core.l.oJ().oP() && cardPersonDynamicThreadData.bfP != null && !StringUtils.isNull(cardPersonDynamicThreadData.bfP.livecover_src)) {
                this.ber.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bfP)) {
                    this.ber.setShowExpression(false);
                } else {
                    this.ber.setShowExpression(true);
                }
                this.ber.setShowImage(com.baidu.tbadk.core.l.oJ().oP());
                this.ber.setChooseStyle(c.getShowStyle());
                this.ber.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bfJ == 40) {
            this.bdw.setVisibility(8);
            if (com.baidu.tbadk.core.l.oJ().oP()) {
                this.bes.setVisibility(0);
                if (com.baidu.tbadk.core.l.oJ().oP() && mediaDataArr.length > 0) {
                    this.beu.setDefaultErrorResource(0);
                    this.beu.setDefaultBgResource(r.f.pic_bg_video_frs);
                    this.beu.setEvent(this.aOV);
                    if (this.bej.bfN != null) {
                        this.beu.c(this.bej.bfN.thumbnail_url, 17, false);
                    }
                }
                this.bes.setOnClickListener(this.bew);
            }
        } else if (com.baidu.tbadk.core.l.oJ().oP() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bk bkVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.ax.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.s(linkedList) > 0) {
                this.bdw.setVisibility(0);
                this.bdw.setFromCDN(this.adU);
                this.bdw.setImageClickListener(new bn(this, linkedList2, bkVar));
                this.bdw.setImageUrls(linkedList);
            } else {
                this.bdw.setVisibility(8);
            }
        } else {
            this.bdw.setVisibility(8);
        }
        Pg();
    }

    private void Pg() {
        this.bds.setClickable(true);
        this.bca.setBarNameClickEnabled(true);
        int childCount = this.bdw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bdw.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        if (this.bej != null) {
            if (!Pa()) {
                an.hR(this.bej.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createCfgForPersonCenter(this.bej.threadId, this.bej.bfG, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pa() {
        return this.bej.bfl && !this.bej.awb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bdw != null) {
            this.bdw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bdw != null) {
            this.bdw.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bk bkVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GO.getPageActivity(), r.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bkVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.adU ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.h.b.c(bkVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, bkVar.getForum_name(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.adU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bfJ == 33 || cardPersonDynamicThreadData.bfJ == 33 || cardPersonDynamicThreadData.bfJ == 1 || cardPersonDynamicThreadData.bfJ == 2 || (cardPersonDynamicThreadData.isDeal && cardPersonDynamicThreadData.dealInfoData != null) || cardPersonDynamicThreadData.bfU != null;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bfP != null) {
            if (cardPersonDynamicThreadData.bfP.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bfP.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bfP.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bfP.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bfP.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bfP.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bfP.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bfP.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bfP.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bfP.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bfL != null && cardPersonDynamicThreadData.bfL.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bfL.length; i++) {
                sb.append(cardPersonDynamicThreadData.bfL[i].text);
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
