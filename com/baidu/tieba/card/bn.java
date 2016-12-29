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
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class bn extends a<CardPersonDynamicThreadData> {
    private View GD;
    private TbPageContext<?> GO;
    private TextView aNY;
    private TbImageView.a aOm;
    private boolean adn;
    private final View.OnClickListener ahg;
    public ThreadCommentAndPraiseInfoLayout bbg;
    public PlayVoiceBntNew bcK;
    private ConstrainImageGroup bcO;
    private View.OnClickListener bcP;
    private FrsCommonImageLayout.b bcQ;
    private final View.OnClickListener bcR;
    private final String bcV;
    private final String bcW;
    private final View.OnClickListener bcX;
    private LinearLayout bcd;
    private CustomMessageListener bct;
    private CardPersonDynamicThreadData bdB;
    private LinearLayout bdC;
    private TextView bdD;
    private TextView bdE;
    private View bdF;
    private TextView bdG;
    private TextView bdH;
    private TextView bdI;
    private PhotoLiveCoverView bdJ;
    private View bdK;
    private TbImageView bdL;
    private ImageView bdM;
    private View.OnClickListener bdN;
    com.baidu.tieba.view.q bdO;
    private View mRootView;
    private int mSkinType;

    public bn(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcV = "1";
        this.bcW = "2";
        this.mSkinType = 3;
        this.adn = true;
        this.bdO = new bo(this);
        this.bcP = new bq(this);
        this.bct = new br(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bcQ = new bs(this);
        this.bcX = new bt(this);
        this.bcR = new bu(this);
        this.ahg = new bv(this);
        this.aOm = new bw(this);
        this.mRootView = getView();
        this.GO = tbPageContext;
        this.GD = this.mRootView.findViewById(r.g.bottom_divider);
        this.bcd = (LinearLayout) this.mRootView.findViewById(r.g.content_layout);
        this.bdC = (LinearLayout) this.mRootView.findViewById(r.g.left_time_view);
        this.bdD = (TextView) this.mRootView.findViewById(r.g.month_num);
        this.bdE = (TextView) this.mRootView.findViewById(r.g.day_num);
        this.bdF = this.mRootView.findViewById(r.g.my_thread_forum);
        this.bdG = (TextView) this.mRootView.findViewById(r.g.identity);
        this.bdH = (TextView) this.mRootView.findViewById(r.g.forum_text);
        this.aNY = (TextView) this.mRootView.findViewById(r.g.thread_title);
        this.bcK = (PlayVoiceBntNew) this.mRootView.findViewById(r.g.card_dynamic_thread_abstract_voice);
        this.bcK.setAfterClickListener(this.bcR);
        this.bdI = (TextView) this.mRootView.findViewById(r.g.thread_content);
        this.bcO = (ConstrainImageGroup) this.mRootView.findViewById(r.g.card_dynamic_thread_img_layout);
        this.bcO.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bcO.setChildClickListener(this.bcX);
        this.bdK = this.mRootView.findViewById(r.g.thread_view_img_container);
        this.bdL = (TbImageView) this.mRootView.findViewById(r.g.thread_video_thumbnail);
        this.bdM = (ImageView) this.mRootView.findViewById(r.g.thread_img_pause_play);
        this.bdJ = (PhotoLiveCoverView) this.mRootView.findViewById(r.g.photo_live_cover_view);
        this.bbg = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.g.card_dynamic_thread_info_layout);
        this.bdN = new bx(this, tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(getView(), r.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.GD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) this.bdD, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.j((View) this.bdE, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.j((View) this.bdG, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.j((View) this.bdH, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.j((View) this.aNY, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.ar.j((View) this.bdI, r.d.cp_cont_c);
            this.bbg.tm();
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
        this.bdB = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bcP);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bfi) {
            this.bdF.setVisibility(0);
            TextView textView = this.bdG;
            if (cardPersonDynamicThreadData.bfj) {
                string = getContext().getString(r.j.person_identity_me);
            } else if (cardPersonDynamicThreadData.sex == 2) {
                string = getContext().getString(r.j.person_identity_she);
            } else {
                string = getContext().getString(r.j.he);
            }
            textView.setText(string);
            String str = cardPersonDynamicThreadData.forumName;
            if (!StringUtils.isNull(str) && str.length() > 7) {
                str = String.valueOf(str.substring(0, 7)) + "...";
            }
            SpannableString spannableString = new SpannableString(String.format(getContext().getString(r.j.person_dynamic_top_bar_name), str));
            spannableString.setSpan(this.bdO, 1, str.length() + 2, 33);
            this.bdH.setText(spannableString);
            this.bdH.setMovementMethod(com.baidu.tieba.view.r.bko());
            this.bdH.setHighlightColor(0);
            this.bdH.setLongClickable(false);
        }
        this.bdC.setVisibility(cardPersonDynamicThreadData.bfh ? 0 : 4);
        if (cardPersonDynamicThreadData.bfi && cardPersonDynamicThreadData.threadData.rx() <= 0) {
            this.bbg.setVisibility(8);
            if (this.bcd != null) {
                this.bcd.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40));
            }
        } else {
            this.bbg.setVisibility(0);
            this.bbg.setFrom(2);
            this.bbg.a(cardPersonDynamicThreadData.threadData);
            this.bbg.setForumAfterClickListener(this.ahg);
            if (this.bcd != null) {
                this.bcd.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.aNY.setVisibility(8);
        } else {
            this.aNY.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.beY == 33) {
                arrayList.add(new ap.a(r.j.kn_zhibo));
            }
            if (cardPersonDynamicThreadData.beY == 1) {
                arrayList.add(new ap.a(r.j.commit_top));
            }
            if (cardPersonDynamicThreadData.beY == 36) {
                arrayList.add(new ap.a(r.j.vote));
            }
            if (cardPersonDynamicThreadData.beY == 2) {
                arrayList.add(new ap.a(r.j.interview_live));
            }
            this.aNY.setText(ap.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<ap.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.beY == 11) {
            this.aNY.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.aNY.setText(cardPersonDynamicThreadData.title);
        }
        this.bdD.setText(cardPersonDynamicThreadData.beZ);
        this.bdE.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bfa != null && cardPersonDynamicThreadData.bfa.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bfa.length; i++) {
                sb.append(cardPersonDynamicThreadData.bfa[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bdI.setText(sb2);
                this.bdI.setVisibility(0);
            } else {
                this.bdI.setVisibility(8);
            }
        } else {
            this.bdI.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bfe;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bcK.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bcK.setVoiceModel(voiceModel);
            this.bcK.setTag(voiceModel);
            this.bcK.axx();
            if (voiceModel != null) {
                this.bcK.lw(voiceModel.voice_status.intValue());
            }
        } else {
            this.bcK.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bfc;
        this.bdJ.setVisibility(8);
        this.bdK.setVisibility(8);
        if (cardPersonDynamicThreadData.beY == 36) {
            this.bcO.setVisibility(8);
        } else if (cardPersonDynamicThreadData.beY == 33) {
            this.bcO.setVisibility(8);
            if (com.baidu.tbadk.core.l.oJ().oP() && cardPersonDynamicThreadData.bff != null && !StringUtils.isNull(cardPersonDynamicThreadData.bff.livecover_src)) {
                this.bdJ.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bff)) {
                    this.bdJ.setShowExpression(false);
                } else {
                    this.bdJ.setShowExpression(true);
                }
                this.bdJ.setShowImage(com.baidu.tbadk.core.l.oJ().oP());
                this.bdJ.setChooseStyle(c.getShowStyle());
                this.bdJ.setData(c);
            }
        } else if (cardPersonDynamicThreadData.beY == 40) {
            this.bcO.setVisibility(8);
            if (com.baidu.tbadk.core.l.oJ().oP()) {
                this.bdK.setVisibility(0);
                if (com.baidu.tbadk.core.l.oJ().oP() && mediaDataArr.length > 0) {
                    this.bdL.setDefaultErrorResource(0);
                    this.bdL.setDefaultBgResource(r.f.pic_bg_video_frs);
                    this.bdL.setEvent(this.aOm);
                    if (this.bdB.bfd != null) {
                        this.bdL.c(this.bdB.bfd.thumbnail_url, 17, false);
                    }
                }
                this.bdK.setOnClickListener(this.bdN);
            }
        } else if (com.baidu.tbadk.core.l.oJ().oP() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bg bgVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.av.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.s(linkedList) > 0) {
                this.bcO.setVisibility(0);
                this.bcO.setFromCDN(this.adn);
                this.bcO.setImageClickListener(new bp(this, linkedList2, bgVar));
                this.bcO.setImageUrls(linkedList);
            } else {
                this.bcO.setVisibility(8);
            }
        } else {
            this.bcO.setVisibility(8);
        }
        OC();
    }

    private void OC() {
        this.bcK.setClickable(true);
        this.bbg.setBarNameClickEnabled(true);
        int childCount = this.bcO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bcO.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        if (this.bdB != null) {
            if (!Ow()) {
                ap.hL(this.bdB.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createCfgForPersonCenter(this.bdB.threadId, this.bdB.beV, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ow() {
        return this.bdB.beA && !this.bdB.avy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bcO != null) {
            this.bcO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bcO != null) {
            this.bcO.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bg bgVar) {
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
                    imageUrlData.urlType = this.adn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bgVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.adn ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.h.b.c(bgVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, bgVar.rK(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.adn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.beY == 33 || cardPersonDynamicThreadData.beY == 1 || cardPersonDynamicThreadData.beY == 2;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bff != null) {
            if (cardPersonDynamicThreadData.bff.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bff.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bff.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bff.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bff.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bff.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bff.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bff.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bff.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bff.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bfa != null && cardPersonDynamicThreadData.bfa.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bfa.length; i++) {
                sb.append(cardPersonDynamicThreadData.bfa[i].text);
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
