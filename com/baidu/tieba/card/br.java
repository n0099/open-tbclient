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
    private TextView aSO;
    private TbImageView.a aTc;
    private boolean ahO;
    private TbPageContext<?> ajF;
    private final View.OnClickListener alM;
    private View avs;
    private LinearLayout bbl;
    public ThreadCommentAndPraiseInfoLayout brM;
    private CustomMessageListener bsL;
    private FrsCommonImageLayout.b btA;
    private final View.OnClickListener btB;
    private final String btF;
    private final String btG;
    private final View.OnClickListener btH;
    public PlayVoiceBntNew btu;
    private ConstrainImageGroup bty;
    private View.OnClickListener btz;
    private CardPersonDynamicThreadData bul;
    private LinearLayout bum;
    private TextView bun;
    private TextView buo;
    private View bup;
    private TextView buq;
    private TextView bur;
    private TextView bus;
    private PhotoLiveCoverView but;
    private View buu;
    private TbImageView buv;
    private ImageView buw;
    com.baidu.tieba.view.q bux;
    private View mRootView;
    private int mSkinType;

    public br(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btF = "1";
        this.btG = "2";
        this.mSkinType = 3;
        this.ahO = true;
        this.bux = new bs(this);
        this.btz = new bt(this);
        this.bsL = new bu(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.btA = new bv(this);
        this.btH = new bw(this);
        this.btB = new bx(this);
        this.alM = new by(this);
        this.aTc = new bz(this);
        this.mRootView = getView();
        this.ajF = tbPageContext;
        this.avs = this.mRootView.findViewById(w.h.bottom_divider);
        this.bbl = (LinearLayout) this.mRootView.findViewById(w.h.content_layout);
        this.bum = (LinearLayout) this.mRootView.findViewById(w.h.left_time_view);
        this.bun = (TextView) this.mRootView.findViewById(w.h.month_num);
        this.buo = (TextView) this.mRootView.findViewById(w.h.day_num);
        this.bup = this.mRootView.findViewById(w.h.my_thread_forum);
        this.buq = (TextView) this.mRootView.findViewById(w.h.identity);
        this.bur = (TextView) this.mRootView.findViewById(w.h.forum_text);
        this.aSO = (TextView) this.mRootView.findViewById(w.h.thread_title);
        this.btu = (PlayVoiceBntNew) this.mRootView.findViewById(w.h.card_dynamic_thread_abstract_voice);
        this.btu.setAfterClickListener(this.btB);
        this.bus = (TextView) this.mRootView.findViewById(w.h.thread_content);
        this.bty = (ConstrainImageGroup) this.mRootView.findViewById(w.h.card_dynamic_thread_img_layout);
        this.bty.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4));
        this.bty.setChildClickListener(this.btH);
        this.buu = this.mRootView.findViewById(w.h.thread_view_img_container);
        this.buv = (TbImageView) this.mRootView.findViewById(w.h.thread_video_thumbnail);
        this.buw = (ImageView) this.mRootView.findViewById(w.h.thread_img_pause_play);
        this.but = (PhotoLiveCoverView) this.mRootView.findViewById(w.h.photo_live_cover_view);
        this.brM = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.card_dynamic_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avs, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i((View) this.bun, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i((View) this.buo, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i((View) this.buq, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i((View) this.bur, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.i((View) this.aSO, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i((View) this.bus, w.e.cp_cont_c);
            this.brM.tD();
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
        this.bul = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.btz);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bvX) {
            this.bup.setVisibility(0);
            TextView textView = this.buq;
            if (cardPersonDynamicThreadData.bhu) {
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
            spannableString.setSpan(this.bux, 1, str.length() + 2, 33);
            this.bur.setText(spannableString);
            this.bur.setMovementMethod(com.baidu.tieba.view.r.blF());
            this.bur.setHighlightColor(0);
            this.bur.setLongClickable(false);
        }
        this.bum.setVisibility(cardPersonDynamicThreadData.bvW ? 0 : 4);
        if (cardPersonDynamicThreadData.bvX && cardPersonDynamicThreadData.threadData.rJ() <= 0) {
            this.brM.setVisibility(8);
            if (this.bbl != null) {
                this.bbl.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
            }
        } else {
            this.brM.setVisibility(0);
            this.brM.setFrom(2);
            this.brM.a(cardPersonDynamicThreadData.threadData);
            this.brM.setForumAfterClickListener(this.alM);
            if (this.bbl != null) {
                this.bbl.setPadding(0, 0, 0, 0);
            }
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.aSO.setVisibility(8);
        } else {
            this.aSO.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bvO == 33) {
                arrayList.add(new at.a(w.l.kn_zhibo));
            }
            if (cardPersonDynamicThreadData.bvO == 1) {
                arrayList.add(new at.a(w.l.commit_top));
            }
            if (cardPersonDynamicThreadData.bvO == 36) {
                arrayList.add(new at.a(w.l.vote));
            }
            if (cardPersonDynamicThreadData.bvO == 2) {
                arrayList.add(new at.a(w.l.interview_live));
            }
            this.aSO.setText(at.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<at.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bvO == 11) {
            this.aSO.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.aSO.setText(cardPersonDynamicThreadData.title);
        }
        this.bun.setText(cardPersonDynamicThreadData.bvP);
        this.buo.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bvQ != null && cardPersonDynamicThreadData.bvQ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bvQ.length; i++) {
                sb.append(cardPersonDynamicThreadData.bvQ[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bus.setText(sb2);
                this.bus.setVisibility(0);
            } else {
                this.bus.setVisibility(8);
            }
        } else {
            this.bus.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bvT;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.btu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.btu.setVoiceModel(voiceModel);
            this.btu.setTag(voiceModel);
            this.btu.ayg();
            if (voiceModel != null) {
                this.btu.lZ(voiceModel.voice_status.intValue());
            }
        } else {
            this.btu.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bvR;
        this.but.setVisibility(8);
        this.buu.setVisibility(8);
        if (cardPersonDynamicThreadData.bvO == 36) {
            this.bty.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bvO == 33) {
            this.bty.setVisibility(8);
            if (com.baidu.tbadk.core.l.oQ().oW() && cardPersonDynamicThreadData.bvU != null && !StringUtils.isNull(cardPersonDynamicThreadData.bvU.livecover_src)) {
                this.but.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bvU)) {
                    this.but.setShowExpression(false);
                } else {
                    this.but.setShowExpression(true);
                }
                this.but.setShowImage(com.baidu.tbadk.core.l.oQ().oW());
                this.but.setChooseStyle(c.getShowStyle());
                this.but.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bvO == 40 || cardPersonDynamicThreadData.bvO == 50) {
            this.bty.setVisibility(8);
            if (com.baidu.tbadk.core.l.oQ().oW()) {
                this.buu.setVisibility(0);
                if (com.baidu.tbadk.core.l.oQ().oW() && mediaDataArr.length > 0) {
                    this.buv.setDefaultErrorResource(0);
                    this.buv.setDefaultBgResource(w.g.pic_bg_video_frs);
                    this.buv.setEvent(this.aTc);
                    if (this.bul.bvS != null) {
                        this.buv.c(this.bul.bvS.thumbnail_url, 17, false);
                    }
                }
            }
        } else if (com.baidu.tbadk.core.l.oQ().oW() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bj bjVar = cardPersonDynamicThreadData.threadData;
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
                this.bty.setVisibility(0);
                this.bty.setFromCDN(this.ahO);
                this.bty.setImageClickListener(new ca(this, linkedList2, bjVar));
                this.bty.setImageUrls(linkedList);
            } else {
                this.bty.setVisibility(8);
            }
        } else {
            this.bty.setVisibility(8);
        }
        Sq();
    }

    private void Sq() {
        this.btu.setClickable(true);
        this.brM.setBarNameClickEnabled(true);
        int childCount = this.bty.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bty.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        if (this.bul != null) {
            if (!Sn()) {
                at.hU(this.bul.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajF.getPageActivity()).createCfgForPersonCenter(this.bul.threadId, this.bul.bvL, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sn() {
        return this.bul.bvp && !this.bul.azY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bty != null) {
            this.bty.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bty != null) {
            this.bty.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bj bjVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajF.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahO ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
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
                    imageUrlData2.urlType = this.ahO ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajF.getPageActivity()).createConfig(arrayList, i, bjVar.rV(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ahO, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bvO == 33 || cardPersonDynamicThreadData.bvO == 1 || cardPersonDynamicThreadData.bvO == 2;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bvU != null) {
            if (cardPersonDynamicThreadData.bvU.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bvU.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bvU.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bvU.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bvU.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bvU.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bvU.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bvU.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bvU.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bvU.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bvQ != null && cardPersonDynamicThreadData.bvQ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bvQ.length; i++) {
                sb.append(cardPersonDynamicThreadData.bvQ[i].text);
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
                nVar.ee(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
