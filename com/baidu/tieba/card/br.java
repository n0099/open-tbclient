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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class br extends a<CardPersonDynamicThreadData> {
    private View GB;
    private TbPageContext<?> GM;
    private TextView aYh;
    public ThreadCommentAndPraiseInfoLayout aYp;
    private CustomMessageListener aZB;
    public PlayVoiceBntNew aZS;
    private ConstrainImageGroup aZV;
    private View.OnClickListener aZW;
    private FrsCommonImageLayout.b aZX;
    private final View.OnClickListener aZY;
    private TbImageView.a aZy;
    private boolean adl;
    private final View.OnClickListener ahu;
    private CardPersonDynamicThreadData baN;
    private LinearLayout baO;
    private TextView baP;
    private TextView baQ;
    private View baR;
    private TextView baS;
    private TextView baT;
    private TextView baU;
    private PhotoLiveCoverView baV;
    private View baW;
    private TbImageView baX;
    private ImageView baY;
    private View.OnClickListener baZ;
    private final String bac;
    private final String bad;
    private final View.OnClickListener bae;
    com.baidu.tieba.view.q bba;
    private int mSkinType;

    public br(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bac = "1";
        this.bad = "2";
        this.mSkinType = 3;
        this.adl = true;
        this.bba = new bs(this);
        this.aZW = new bu(this);
        this.aZB = new bv(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aZX = new bw(this);
        this.bae = new bx(this);
        this.aZY = new by(this);
        this.ahu = new bz(this);
        this.aZy = new ca(this);
        View view = getView();
        this.GM = tbPageContext;
        this.GB = view.findViewById(t.g.bottom_divider);
        this.baO = (LinearLayout) view.findViewById(t.g.left_time_view);
        this.baP = (TextView) view.findViewById(t.g.month_num);
        this.baQ = (TextView) view.findViewById(t.g.day_num);
        this.baR = view.findViewById(t.g.my_thread_forum);
        this.baS = (TextView) view.findViewById(t.g.identity);
        this.baT = (TextView) view.findViewById(t.g.forum_text);
        this.aYh = (TextView) view.findViewById(t.g.thread_title);
        this.aZS = (PlayVoiceBntNew) view.findViewById(t.g.card_dynamic_thread_abstract_voice);
        this.aZS.setAfterClickListener(this.aZY);
        this.baU = (TextView) view.findViewById(t.g.thread_content);
        this.aZV = (ConstrainImageGroup) view.findViewById(t.g.card_dynamic_thread_img_layout);
        this.aZV.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds4));
        this.aZV.setChildClickListener(this.bae);
        this.baW = view.findViewById(t.g.thread_view_img_container);
        this.baX = (TbImageView) view.findViewById(t.g.thread_video_thumbnail);
        this.baY = (ImageView) view.findViewById(t.g.thread_img_pause_play);
        this.baV = (PhotoLiveCoverView) view.findViewById(t.g.photo_live_cover_view);
        this.aYp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_dynamic_thread_info_layout);
        this.baZ = new cb(this, tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.l(this.GB, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.baP, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.baQ, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.baS, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.baT, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.j((View) this.aYh, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.baU, t.d.cp_cont_c);
            this.aYp.ti();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_person_dynamic_thread;
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
        this.baN = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aZW);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (cardPersonDynamicThreadData.bcz) {
            this.baR.setVisibility(0);
            TextView textView = this.baS;
            if (cardPersonDynamicThreadData.bcA) {
                string = getContext().getString(t.j.person_identity_me);
            } else if (cardPersonDynamicThreadData.sex == 2) {
                string = getContext().getString(t.j.person_identity_she);
            } else {
                string = getContext().getString(t.j.person_identity_he);
            }
            textView.setText(string);
            String str = cardPersonDynamicThreadData.forumName;
            if (!StringUtils.isNull(str) && str.length() > 7) {
                str = String.valueOf(str.substring(0, 7)) + "...";
            }
            SpannableString spannableString = new SpannableString(String.format(getContext().getString(t.j.person_dynamic_top_bar_name), str));
            spannableString.setSpan(this.bba, 1, str.length() + 2, 33);
            this.baT.setText(spannableString);
            this.baT.setMovementMethod(com.baidu.tieba.view.r.bqr());
            this.baT.setHighlightColor(0);
            this.baT.setLongClickable(false);
        }
        this.baO.setVisibility(cardPersonDynamicThreadData.bcy ? 0 : 4);
        if (cardPersonDynamicThreadData.bcz && cardPersonDynamicThreadData.threadData.rv() <= 0) {
            this.aYp.setVisibility(8);
        } else {
            this.aYp.setVisibility(0);
            this.aYp.setFrom(2);
            this.aYp.setData(cardPersonDynamicThreadData.threadData);
            this.aYp.setForumAfterClickListener(this.ahu);
        }
        if (StringUtils.isNull(cardPersonDynamicThreadData.title)) {
            this.aYh.setVisibility(8);
        } else {
            this.aYh.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        if (b(cardPersonDynamicThreadData)) {
            if (cardPersonDynamicThreadData.bcq == 33) {
                arrayList.add(new ap.a(t.j.kn_zhibo));
            }
            if (cardPersonDynamicThreadData.isDeal && cardPersonDynamicThreadData.dealInfoData != null) {
                arrayList.add(new ap.a(t.j.ecomm));
            }
            if (cardPersonDynamicThreadData.bcq == 1) {
                arrayList.add(new ap.a(t.j.commit_top));
            }
            if (cardPersonDynamicThreadData.bcq == 36) {
                arrayList.add(new ap.a(t.j.vote));
            }
            if (cardPersonDynamicThreadData.bcq == 2) {
                arrayList.add(new ap.a(t.j.interview_live));
            }
            if (cardPersonDynamicThreadData.bcB != null) {
                arrayList.add(new ap.a(t.j.card_promotion_text));
            }
            this.aYh.setText(ap.a(getContext(), String.valueOf(cardPersonDynamicThreadData.title) + " ", (ArrayList<ap.a>) arrayList, true));
        } else if (cardPersonDynamicThreadData.bcq == 11) {
            this.aYh.setText(String.valueOf(cardPersonDynamicThreadData.title) + " ");
        } else {
            this.aYh.setText(cardPersonDynamicThreadData.title);
        }
        this.baP.setText(cardPersonDynamicThreadData.bcr);
        this.baQ.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bcs != null && cardPersonDynamicThreadData.bcs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bcs.length; i++) {
                sb.append(cardPersonDynamicThreadData.bcs[i].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.baU.setText(sb2);
                this.baU.setVisibility(0);
            } else {
                this.baU.setVisibility(8);
            }
        } else {
            this.baU.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bcv;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.aZS.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.aZS.setVoiceModel(voiceModel);
            this.aZS.setTag(voiceModel);
            this.aZS.bkk();
            if (voiceModel != null) {
                this.aZS.lW(voiceModel.voice_status.intValue());
            }
        } else {
            this.aZS.setVisibility(8);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bct;
        this.baV.setVisibility(8);
        this.baW.setVisibility(8);
        if (cardPersonDynamicThreadData.bcq == 36) {
            this.aZV.setVisibility(8);
        } else if (cardPersonDynamicThreadData.bcq == 33) {
            this.aZV.setVisibility(8);
            if (com.baidu.tbadk.core.l.oG().oM() && cardPersonDynamicThreadData.bcw != null && !StringUtils.isNull(cardPersonDynamicThreadData.bcw.livecover_src)) {
                this.baV.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bcw)) {
                    this.baV.setShowExpression(false);
                } else {
                    this.baV.setShowExpression(true);
                }
                this.baV.setShowImage(com.baidu.tbadk.core.l.oG().oM());
                this.baV.setChooseStyle(c.getShowStyle());
                this.baV.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bcq == 40) {
            this.aZV.setVisibility(8);
            if (com.baidu.tbadk.core.l.oG().oM()) {
                this.baW.setVisibility(0);
                if (com.baidu.tbadk.core.l.oG().oM() && mediaDataArr.length > 0) {
                    this.baX.setDefaultErrorResource(0);
                    this.baX.setDefaultBgResource(t.f.pic_bg_video_frs);
                    this.baX.setEvent(this.aZy);
                    if (this.baN.bcu != null) {
                        this.baX.c(this.baN.bcu.thumbnail_url, 17, false);
                    }
                }
                this.baW.setOnClickListener(this.baZ);
            }
        } else if (com.baidu.tbadk.core.l.oG().oM() && mediaDataArr.length > 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bg bgVar = cardPersonDynamicThreadData.threadData;
            for (MediaData mediaData : mediaDataArr) {
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.ba.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.aZV.setVisibility(0);
                this.aZV.setFromCDN(this.adl);
                this.aZV.setImageClickListener(new bt(this, linkedList2, bgVar));
                this.aZV.setImageUrls(linkedList);
            } else {
                this.aZV.setVisibility(8);
            }
        } else {
            this.aZV.setVisibility(8);
        }
        NE();
    }

    private void NE() {
        this.aZS.setClickable(true);
        this.aYp.setBarNameClickEnabled(true);
        int childCount = this.aZV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aZV.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (this.baN != null) {
            if (!Nv()) {
                ap.hG(this.baN.threadId);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createCfgForPersonCenter(this.baN.threadId, this.baN.bcn, "person_post", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nv() {
        return this.baN.bbU && !this.baN.avE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aZV != null) {
            this.aZV.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aZV != null) {
            this.aZV.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bg bgVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GM.getPageActivity(), t.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getThumbnails_url())) {
                arrayList.add(mediaData.getThumbnails_url());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adl ? 13 : 14;
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
                    imageUrlData2.urlType = this.adl ? 13 : 14;
                    imageUrlData2.imageUrl = mediaData2.getPicUrl();
                    imageUrlData2.originalUrl = mediaData2.getOriginalUrl();
                    imageUrlData2.originalSize = mediaData2.getOriginalSize();
                    imageUrlData2.threadId = com.baidu.adp.lib.h.b.c(bgVar.getTid(), -1L);
                    imageUrlData2.postId = mediaData2.getPostId();
                    concurrentHashMap.put(mediaData2.getPicUrl(), imageUrlData2);
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GM.getPageActivity()).createConfig(arrayList, i, bgVar.getForum_name(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.adl, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return false;
        }
        return cardPersonDynamicThreadData.bcq == 33 || cardPersonDynamicThreadData.bcq == 33 || cardPersonDynamicThreadData.bcq == 1 || cardPersonDynamicThreadData.bcq == 2 || (cardPersonDynamicThreadData.isDeal && cardPersonDynamicThreadData.dealInfoData != null) || cardPersonDynamicThreadData.bcB != null;
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bcw != null) {
            if (cardPersonDynamicThreadData.bcw.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bcw.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bcw.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bcw.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bcw.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bcw.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bcw.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bcw.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bcw.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bcw.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.Pr);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.replyNum);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bcs != null && cardPersonDynamicThreadData.bcs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bcs.length; i++) {
                sb.append(cardPersonDynamicThreadData.bcs[i].text);
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
