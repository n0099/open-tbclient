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
public class bp extends a<CardPersonDynamicThreadData> {
    private View GB;
    private TbPageContext<?> GM;
    private TextView aMI;
    private TbImageView.a aMQ;
    public ThreadCommentAndPraiseInfoLayout aYR;
    private LinearLayout aZA;
    private CustomMessageListener aZT;
    private boolean adw;
    private final View.OnClickListener ahd;
    public PlayVoiceBntNew baj;
    private ConstrainImageGroup bam;
    private View.OnClickListener ban;
    private FrsCommonImageLayout.b bao;
    private final View.OnClickListener bap;
    private final String bau;
    private final String bav;
    private final View.OnClickListener baw;
    private CardPersonDynamicThreadData bbe;
    private LinearLayout bbf;
    private TextView bbg;
    private TextView bbh;
    private View bbi;
    private TextView bbj;
    private TextView bbk;
    private TextView bbl;
    private PhotoLiveCoverView bbm;
    private View bbn;
    private TbImageView bbo;
    private ImageView bbp;
    private View.OnClickListener bbq;
    com.baidu.tieba.view.q bbr;
    private View mRootView;
    private int mSkinType;

    public bp(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bau = "1";
        this.bav = "2";
        this.mSkinType = 3;
        this.adw = true;
        this.bbr = new bq(this);
        this.ban = new bs(this);
        this.aZT = new bt(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bao = new bu(this);
        this.baw = new bv(this);
        this.bap = new bw(this);
        this.ahd = new bx(this);
        this.aMQ = new by(this);
        this.mRootView = getView();
        this.GM = tbPageContext;
        this.GB = this.mRootView.findViewById(r.g.bottom_divider);
        this.aZA = (LinearLayout) this.mRootView.findViewById(r.g.content_layout);
        this.bbf = (LinearLayout) this.mRootView.findViewById(r.g.left_time_view);
        this.bbg = (TextView) this.mRootView.findViewById(r.g.month_num);
        this.bbh = (TextView) this.mRootView.findViewById(r.g.day_num);
        this.bbi = this.mRootView.findViewById(r.g.my_thread_forum);
        this.bbj = (TextView) this.mRootView.findViewById(r.g.identity);
        this.bbk = (TextView) this.mRootView.findViewById(r.g.forum_text);
        this.aMI = (TextView) this.mRootView.findViewById(r.g.thread_title);
        this.baj = (PlayVoiceBntNew) this.mRootView.findViewById(r.g.card_dynamic_thread_abstract_voice);
        this.baj.setAfterClickListener(this.bap);
        this.bbl = (TextView) this.mRootView.findViewById(r.g.thread_content);
        this.bam = (ConstrainImageGroup) this.mRootView.findViewById(r.g.card_dynamic_thread_img_layout);
        this.bam.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bam.setChildClickListener(this.baw);
        this.bbn = this.mRootView.findViewById(r.g.thread_view_img_container);
        this.bbo = (TbImageView) this.mRootView.findViewById(r.g.thread_video_thumbnail);
        this.bbp = (ImageView) this.mRootView.findViewById(r.g.thread_img_pause_play);
        this.bbm = (PhotoLiveCoverView) this.mRootView.findViewById(r.g.photo_live_cover_view);
        this.aYR = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.g.card_dynamic_thread_info_layout);
        this.bbq = new bz(this, tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), r.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.l(this.GB, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.bbg, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.bbh, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.bbj, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.bbk, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.aMI, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.bbl, r.d.cp_cont_c);
            this.aYR.tx();
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
        this.bbe = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ban);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bcT) {
            this.bbi.setVisibility(0);
            TextView textView = this.bbj;
            if (cardPersonDynamicThreadData.bcU) {
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
            spannableString.setSpan(this.bbr, 1, str.length() + 2, 33);
            this.bbk.setText(spannableString);
            this.bbk.setMovementMethod(com.baidu.tieba.view.r.bqV());
            this.bbk.setHighlightColor(0);
            this.bbk.setLongClickable(false);
        }
        this.bbf.setVisibility(cardPersonDynamicThreadData.bcS ? 0 : 4);
        if (cardPersonDynamicThreadData.bcT && cardPersonDynamicThreadData.threadData.rH() <= 0) {
            this.aYR.setVisibility(8);
            if (this.aZA != null) {
                this.aZA.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40));
            }
        } else {
            this.aYR.setVisibility(0);
            this.aYR.setFrom(2);
            this.aYR.setData(cardPersonDynamicThreadData.threadData);
            this.aYR.setForumAfterClickListener(this.ahd);
            if (this.aZA != null) {
                this.aZA.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.aMI.setVisibility(8);
        } else {
            this.aMI.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bcK == 33) {
                arrayList.add(new an.a(r.j.kn_zhibo));
            }
            if (cardPersonDynamicThreadData.isDeal && cardPersonDynamicThreadData.dealInfoData != null) {
                arrayList.add(new an.a(r.j.ecomm));
            }
            if (cardPersonDynamicThreadData.bcK == 1) {
                arrayList.add(new an.a(r.j.commit_top));
            }
            if (cardPersonDynamicThreadData.bcK == 36) {
                arrayList.add(new an.a(r.j.vote));
            }
            if (cardPersonDynamicThreadData.bcK == 2) {
                arrayList.add(new an.a(r.j.interview_live));
            }
            if (cardPersonDynamicThreadData.bcV != null) {
                arrayList.add(new an.a(r.j.card_promotion_text));
            }
            this.aMI.setText(an.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<an.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bcK == 11) {
            this.aMI.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.aMI.setText(cardPersonDynamicThreadData.title);
        }
        this.bbg.setText(cardPersonDynamicThreadData.bcL);
        this.bbh.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bcM != null && cardPersonDynamicThreadData.bcM.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bcM.length; i++) {
                sb.append(cardPersonDynamicThreadData.bcM[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bbl.setText(sb2);
                this.bbl.setVisibility(0);
            } else {
                this.bbl.setVisibility(8);
            }
        } else {
            this.bbl.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bcP;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.baj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.baj.setVoiceModel(voiceModel);
            this.baj.setTag(voiceModel);
            this.baj.aCk();
            if (voiceModel != null) {
                this.baj.me(voiceModel.voice_status.intValue());
            }
        } else {
            this.baj.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bcN;
        this.bbm.setVisibility(8);
        this.bbn.setVisibility(8);
        if (cardPersonDynamicThreadData.bcK == 36) {
            this.bam.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bcK == 33) {
            this.bam.setVisibility(8);
            if (com.baidu.tbadk.core.l.oH().oN() && cardPersonDynamicThreadData.bcQ != null && !StringUtils.isNull(cardPersonDynamicThreadData.bcQ.livecover_src)) {
                this.bbm.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bcQ)) {
                    this.bbm.setShowExpression(false);
                } else {
                    this.bbm.setShowExpression(true);
                }
                this.bbm.setShowImage(com.baidu.tbadk.core.l.oH().oN());
                this.bbm.setChooseStyle(c.getShowStyle());
                this.bbm.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bcK == 40) {
            this.bam.setVisibility(8);
            if (com.baidu.tbadk.core.l.oH().oN()) {
                this.bbn.setVisibility(0);
                if (com.baidu.tbadk.core.l.oH().oN() && mediaDataArr.length > 0) {
                    this.bbo.setDefaultErrorResource(0);
                    this.bbo.setDefaultBgResource(r.f.pic_bg_video_frs);
                    this.bbo.setEvent(this.aMQ);
                    if (this.bbe.bcO != null) {
                        this.bbo.c(this.bbe.bcO.thumbnail_url, 17, false);
                    }
                }
                this.bbn.setOnClickListener(this.bbq);
            }
        } else if (com.baidu.tbadk.core.l.oH().oN() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bi biVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.az.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.bam.setVisibility(0);
                this.bam.setFromCDN(this.adw);
                this.bam.setImageClickListener(new br(this, linkedList2, biVar));
                this.bam.setImageUrls(linkedList);
            } else {
                this.bam.setVisibility(8);
            }
        } else {
            this.bam.setVisibility(8);
        }
        Oe();
    }

    private void Oe() {
        this.baj.setClickable(true);
        this.aYR.setBarNameClickEnabled(true);
        int childCount = this.bam.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bam.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Of() {
        if (this.bbe != null) {
            if (!NW()) {
                an.hN(this.bbe.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createCfgForPersonCenter(this.bbe.threadId, this.bbe.bcH, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean NW() {
        return this.bbe.bcm && !this.bbe.avh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bam != null) {
            this.bam.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bam != null) {
            this.bam.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GM.getPageActivity(), r.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adw ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(biVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.adw ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.h.b.c(biVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GM.getPageActivity()).createConfig(arrayList, i, biVar.getForum_name(), String.valueOf(biVar.getFid()), biVar.getTid(), this.adw, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bcK == 33 || cardPersonDynamicThreadData.bcK == 33 || cardPersonDynamicThreadData.bcK == 1 || cardPersonDynamicThreadData.bcK == 2 || (cardPersonDynamicThreadData.isDeal && cardPersonDynamicThreadData.dealInfoData != null) || cardPersonDynamicThreadData.bcV != null;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bcQ != null) {
            if (cardPersonDynamicThreadData.bcQ.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bcQ.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bcQ.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bcQ.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bcQ.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bcQ.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bcQ.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bcQ.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bcQ.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bcQ.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bcM != null && cardPersonDynamicThreadData.bcM.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bcM.length; i++) {
                sb.append(cardPersonDynamicThreadData.bcM[i].text);
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
