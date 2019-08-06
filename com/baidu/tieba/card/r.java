package com.baidu.tieba.card;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class r extends a<CardPersonDynamicThreadData> {
    private TextView VW;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private TbImageView.a cJY;
    public NewThreadCommentAndPraiseInfoLayout dFu;
    private ConstrainImageGroup eCT;
    private View.OnClickListener eCY;
    private final View.OnClickListener eCZ;
    private CustomMessageListener eCn;
    public ThreadViewAndCommentInfoLayout eDI;
    private final String eDJ;
    private final String eDK;
    private TextView eDL;
    private LinearLayout eDM;
    private TextView eDN;
    private TextView eDO;
    private TextView eDP;
    private TextView eDQ;
    private ImageView eDR;
    private q eDS;
    private View eDT;
    private TbImageView eDU;
    private ImageView eDV;
    private LinearLayout eDW;
    private TextView eDX;
    private LinearLayout eDY;
    private LinearLayout eDZ;
    private CardPersonDynamicThreadData eDx;
    private TextView eEa;
    private TextView eEb;
    private TextView eEc;
    private TBLottieAnimationView eEd;
    private TextView eEe;
    private TextView eEf;
    public OriginalThreadCardView eEg;
    private View eEh;
    private View eEi;
    private boolean eEj;
    private boolean eEk;
    com.baidu.tieba.view.h eEl;
    private q.a eEm;
    private final View.OnClickListener eEn;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eDJ = "1";
        this.eDK = "2";
        this.mSkinType = 3;
        this.Yd = true;
        this.eEl = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eDx != null && !StringUtils.isNull(r.this.eDx.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eDx.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.eCY = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZq() != null) {
                    r.this.aZq().a(view, r.this.eDx);
                }
                if (r.this.eDx.eGE != 60) {
                    if ((r.this.eDx.eGE != 40 || r.this.eDx.eGG != 2) && !r.this.eEk) {
                        r.this.aqd();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_toast_game_error).agS();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eDx.threadData.aeR().live_status != 1) {
                    r.this.aZN();
                } else {
                    r.this.aZM();
                }
            }
        };
        this.eCn = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eDx != null && r.this.eDx.threadId != null && r.this.mTitle != null && r.this.VW != null && ((String) customResponsedMessage.getData()).equals(r.this.eDx.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eDx.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.VW, r.this.eDx.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.eEm = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iD(z);
            }
        };
        this.eEn = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZq = r.this.aZq();
                if (aZq != null) {
                    view.setTag("1");
                    aZq.a(view, r.this.eDx);
                }
                r.this.aqd();
            }
        };
        this.eCZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZq = r.this.aZq();
                if (aZq != null) {
                    view.setTag("2");
                    aZq.a(view, r.this.eDx);
                }
            }
        };
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && r.this.eDU != null) {
                    r.this.eDU.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eDL = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eDM = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eDN = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eDO = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eDP = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.eEf = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eDQ = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eDR = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.Ym = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eCZ);
        this.VW = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.VW.setVisibility(8);
        this.eCT = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.eCT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eCT.setChildClickListener(this.eEn);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.eCT.setImageProcessor(aVar);
        this.eDT = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eDU = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eDV = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eDI = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eDZ = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eEa = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eEb = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eEc = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eEd = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eEd.y(true);
        am.a(this.eEd, (int) R.raw.ala_play);
        this.eEe = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eDW = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eDX = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eDY = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eDY.setVisibility(8);
        this.eEg = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.eEh = this.mRootView.findViewById(R.id.divider_line_thick);
        this.eEi = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dFu = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dFu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFu.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dFu.setLayoutParams(layoutParams);
        }
        this.dFu.setOnClickListener(this.eCY);
        this.dFu.setReplyTimeVisible(false);
        this.dFu.setShowPraiseNum(true);
        this.dFu.setNeedAddPraiseIcon(true);
        this.dFu.setNeedAddReplyIcon(true);
        this.dFu.setShareVisible(true);
        this.dFu.setIsBarViewVisible(false);
        this.dFu.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFA = 8;
        dVar.bFF = 3;
        this.dFu.setAgreeStatisticData(dVar);
        this.dFu.setShareReportFrom(6);
        this.dFu.setStType("person_page");
        this.dFu.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZq() != null) {
                    r.this.aZq().a(view, r.this.eDx);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.eEd, (int) R.raw.ala_play);
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.eDL, R.color.cp_cont_b);
            am.j(this.eDN, R.color.cp_cont_j);
            am.j(this.eDO, R.color.cp_cont_b);
            am.j(this.eDP, R.color.cp_cont_d);
            am.j(this.eEf, R.color.cp_cont_d);
            am.j(this.eDQ, R.color.cp_cont_d);
            if (this.eDR != null) {
                this.eDR.setImageDrawable(am.getDrawable(R.drawable.icon_card_more));
            }
            am.j(this.mTitle, R.color.cp_cont_b);
            am.j(this.VW, R.color.cp_cont_f);
            am.j(this.eDX, R.color.cp_cont_f);
            if (this.eDS != null) {
                this.eDS.onChangeSkinType();
            }
            this.eDI.onChangeSkinType();
            this.dFu.onChangeSkinType();
            am.l(this.eEh, R.color.cp_bg_line_e);
            am.l(this.eEi, R.color.cp_bg_line_c);
            am.l(this.eDX, R.color.cp_bg_line_e);
            if (this.eEg != null) {
                this.eEg.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.eDx = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCY);
        }
        this.eDL.setVisibility(cardPersonDynamicThreadData.eGQ ? 0 : 8);
        this.eDM.setVisibility(cardPersonDynamicThreadData.eGP ? 0 : 4);
        this.eEh.setVisibility(cardPersonDynamicThreadData.eGP ? 0 : 8);
        this.eEi.setVisibility(cardPersonDynamicThreadData.eGP ? 8 : 0);
        if (cardPersonDynamicThreadData.eGR) {
            this.eEh.setVisibility(8);
            this.eEi.setVisibility(8);
        }
        this.eEj = cardPersonDynamicThreadData.eGE == 40 && cardPersonDynamicThreadData.eGG == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.eEk = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.eGG == 2;
        }
        this.eDL.setText(cardPersonDynamicThreadData.eGH);
        this.eDN.setText(cardPersonDynamicThreadData.eGI);
        this.eDO.setText(cardPersonDynamicThreadData.eGJ);
        if (cardPersonDynamicThreadData.eGO != null && cardPersonDynamicThreadData.eGO.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eGO.length; i++) {
                sb.append(aq.j(cardPersonDynamicThreadData.eGO[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.eGO.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eDP.setText(sb2);
                this.eDP.setVisibility(0);
            } else {
                this.eDP.setText(R.string.person_homepage);
            }
        } else {
            this.eDP.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eDQ.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eDQ.setVisibility(0);
            }
            iD(cardPersonDynamicThreadData.isPrivacy);
            this.eDR.setVisibility(0);
            this.eDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eDS == null) {
                            r.this.eDS = new q(r.this.mPageContext);
                            r.this.eDS.create();
                            r.this.eDS.a(r.this.eEm);
                        }
                        r.this.eDS.a(r.this.eDx);
                        r.this.eDS.show();
                    }
                }
            });
        } else {
            this.eDQ.setVisibility(8);
            this.eDR.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eGM;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.Ym.setVisibility(0);
            iC(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIz();
            if (voiceModel != null) {
                this.Ym.wa(voiceModel.voice_status.intValue());
            }
            this.Ym.cqV();
        } else {
            this.Ym.setVisibility(8);
            iC(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eGL;
        am.k(this.eDW, R.color.transparent);
        this.eDX.setVisibility(8);
        this.eDY.setVisibility(8);
        this.eDW.setVisibility(0);
        this.eDT.setVisibility(8);
        this.eEe.setVisibility(8);
        this.eDZ.setVisibility(8);
        this.eEc.setVisibility(8);
        this.eEd.cancelAnimation();
        this.eEd.setVisibility(8);
        if (cardPersonDynamicThreadData.eGE == 36) {
            this.eCT.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eGE == 40 || this.eDx.eGE == 50) {
            this.eCT.setVisibility(8);
            if (com.baidu.tbadk.core.i.aca().ace()) {
                this.eDT.setVisibility(0);
                this.eDV.setVisibility(0);
                this.eDV.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDT.getLayoutParams();
                int width = this.eDT.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eDT.setLayoutParams(layoutParams);
                if (this.eDx.videoInfo != null) {
                    this.eDU.setDefaultErrorResource(0);
                    this.eDU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eDU.setEvent(this.cJY);
                    this.eDU.startLoad(this.eDx.videoInfo.thumbnail_url, 17, false);
                    if (this.eEj) {
                        this.eEe.setVisibility(0);
                        this.eEe.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eDZ.setVisibility(0);
                        this.eEa.setText(aq.is(this.eDx.videoInfo.video_duration.intValue() * 1000));
                        this.eEb.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eDx.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eDx.eGE == 60 || this.eDx.eGE == 49) {
            this.eCT.setVisibility(8);
            if (this.eDx.threadData.aeR() != null && this.eDx.threadData.aeR().user_info != null && this.eDx.eGE == 60) {
                String str = this.eDx.threadData.aeR().user_info.user_name;
                if (com.baidu.tbadk.util.ab.ro(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ad(str, 14) + "...";
                }
                this.eDX.setText(n.cG(str + ":", this.eDx.threadData.getTitle()));
                this.eDX.setVisibility(0);
            } else {
                this.eDX.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.aca().ace()) {
                this.eDT.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eDT.getLayoutParams();
                int width2 = this.eDT.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.af(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eDT.setLayoutParams(layoutParams2);
                if (this.eDx.threadData.aeR() != null) {
                    this.eDU.setDefaultErrorResource(0);
                    this.eDU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eDU.setEvent(this.cJY);
                    this.eDU.startLoad(cardPersonDynamicThreadData.threadData.aeR().cover, 10, false);
                    this.eDV.setVisibility(8);
                    this.eEd.setVisibility(0);
                    this.eEd.br();
                    am.k(this.eDW, R.color.cp_bg_line_e);
                    this.eEc.setVisibility(0);
                    this.eEc.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.eDx.threadData.aeR().audience_count)));
                    this.dFu.getCommentContainer().setOnClickListener(this.eCY);
                } else {
                    this.dFu.getCommentContainer().setOnClickListener(this.dFu);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.aca().ace() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.Z(linkedList) > 0) {
                    this.eCT.setVisibility(0);
                    this.eCT.setFromCDN(this.Yd);
                    this.eCT.setSingleImageRatio(0.67d);
                    this.eCT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.aqd();
                            } else {
                                r.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.eCT.setImageMediaList(linkedList);
                } else {
                    this.eCT.setVisibility(8);
                }
            } else {
                this.eCT.setVisibility(8);
            }
            this.eDW.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bLV != null) {
            this.eEg.setVisibility(0);
            this.eEg.b(cardPersonDynamicThreadData.threadData.bLV);
            this.eEg.setOnClickListener(this);
            this.Ym.setVisibility(8);
            this.eCT.setVisibility(8);
            this.eDW.setVisibility(8);
            if (this.eEk) {
                this.eEf.setVisibility(0);
            } else {
                this.eEf.setVisibility(8);
            }
        } else {
            this.eEg.setVisibility(8);
            this.eEf.setVisibility(8);
        }
        aZJ();
        c(cardPersonDynamicThreadData);
    }

    private void iC(boolean z) {
        if (this.eCT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.eCT.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.eEj || this.eEk) {
                this.dFu.setCommentClickable(false);
                this.dFu.setAgreeClickable(false);
                this.dFu.setShareClickable(false);
                this.eEg.setClickable(false);
                this.eDR.setClickable(false);
            } else {
                this.dFu.setCommentClickable(true);
                this.dFu.setAgreeClickable(true);
                this.dFu.setShareClickable(true);
                this.eEg.setClickable(true);
                this.eDR.setClickable(true);
            }
            this.dFu.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eGE == 60) {
                this.dFu.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eGO != null) {
                this.dFu.setMultiForumCount(cardPersonDynamicThreadData.eGO.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.dFu.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.dFu.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aZJ() {
        this.Ym.setClickable(true);
        int childCount = this.eCT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eCT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aZM() {
        if (this.eDx != null && this.eDx.threadData != null && this.eDx.threadData.aeR() != null) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.vx(this.eDx.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eDx.threadData.aeR());
            if (this.eDx.threadData.aeR().user_info != null) {
                alaLiveInfoCoreData.userName = this.eDx.threadData.aeR().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        if (this.eDx != null && this.eDx.threadData != null && this.eDx.threadData.aeR() != null && this.eDx.threadData.aeR().share_info != null) {
            if (!isHost()) {
                n.vx(this.eDx.threadId);
            }
            if (this.eDx.threadData.aeR().share_info.record_tid <= 0) {
                aZM();
                return;
            }
            String valueOf = String.valueOf(this.eDx.threadData.aeR().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqd() {
        if (this.eDx != null) {
            if (!isHost()) {
                n.vx(this.eDx.threadId);
                n.a(this.mTitle, this.eDx.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VW, this.eDx.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eDx.eGE == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eDx.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eDx.threadData.getFid()));
            pbActivityConfig.setForumName(this.eDx.threadData.aeD());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eDx.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eDx.threadData == null || !this.eDx.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").bT("obj_type", "2").bT("tid", this.eDx.threadId).P("obj_param1", this.eDx.isHost ? 1 : 2));
        }
    }

    private void aZO() {
        if (this.eDx != null && this.eDx.threadData != null && this.eDx.threadData.bLV != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eDx.threadData.bLV.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").bT("obj_type", "3").bT("tid", this.eDx.threadId).P("obj_param1", this.eDx.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(boolean z) {
        if (this.eDQ != null) {
            if (z) {
                this.eDQ.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eDQ.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eDQ.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eDQ.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eDx.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eEg) {
            aZO();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCT != null) {
            this.eCT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCT != null) {
            this.eCT.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.Yd ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeD(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.eEj);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(c));
        this.mTitle.setText(c);
        if (isHost()) {
            return true;
        }
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
