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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tbadk.core.util.SvgManager;
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
    private TextView Fk;
    public PlayVoiceBntNew HH;
    private boolean Hx;
    private TbImageView.a cTx;
    public NewThreadCommentAndPraiseInfoLayout dTn;
    private CustomMessageListener eLM;
    private CardPersonDynamicThreadData eMW;
    private ConstrainImageGroup eMr;
    private View.OnClickListener eMw;
    private final View.OnClickListener eMx;
    private TextView eNA;
    private TextView eNB;
    private TBLottieAnimationView eNC;
    private TextView eND;
    private TextView eNE;
    public OriginalThreadCardView eNF;
    private View eNG;
    private View eNH;
    private boolean eNI;
    private boolean eNJ;
    com.baidu.tieba.view.h eNK;
    private q.a eNL;
    private final View.OnClickListener eNM;
    public ThreadViewAndCommentInfoLayout eNh;
    private final String eNi;
    private final String eNj;
    private TextView eNk;
    private LinearLayout eNl;
    private TextView eNm;
    private TextView eNn;
    private TextView eNo;
    private TextView eNp;
    private ImageView eNq;
    private q eNr;
    private View eNs;
    private TbImageView eNt;
    private ImageView eNu;
    private LinearLayout eNv;
    private TextView eNw;
    private LinearLayout eNx;
    private LinearLayout eNy;
    private TextView eNz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNi = "1";
        this.eNj = "2";
        this.mSkinType = 3;
        this.Hx = true;
        this.eNK = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eMW != null && !StringUtils.isNull(r.this.eMW.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eMW.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.eMw = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZV() != null) {
                    r.this.aZV().a(view, r.this.eMW);
                }
                if (r.this.eMW.eQb != 60) {
                    if ((r.this.eMW.eQb != 40 || r.this.eMW.eQd != 2) && !r.this.eNJ) {
                        r.this.ash();
                        return;
                    } else {
                        BdToast.b(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake_n_svg, true).akR();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.eMW.caz.aiX().live_status != 1) {
                    r.this.bas();
                } else {
                    r.this.bar();
                }
            }
        };
        this.eLM = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eMW != null && r.this.eMW.threadId != null && r.this.mTitle != null && r.this.Fk != null && ((String) customResponsedMessage.getData()).equals(r.this.eMW.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eMW.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.Fk, r.this.eMW.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.eNL = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iJ(z);
            }
        };
        this.eNM = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZV = r.this.aZV();
                if (aZV != null) {
                    view.setTag("1");
                    aZV.a(view, r.this.eMW);
                }
                r.this.ash();
            }
        };
        this.eMx = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZV = r.this.aZV();
                if (aZV != null) {
                    view.setTag("2");
                    aZV.a(view, r.this.eMW);
                }
            }
        };
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.eNt != null) {
                    r.this.eNt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eNk = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eNl = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eNm = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eNn = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eNo = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.eNE = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eNp = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eNq = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.HH = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.HH.setAfterClickListener(this.eMx);
        this.Fk = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.Fk.setVisibility(8);
        this.eMr = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.eMr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eMr.setChildClickListener(this.eNM);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.g(1.0d);
        this.eMr.setImageProcessor(aVar);
        this.eNs = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eNt = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eNu = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eNh = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eNy = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eNz = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eNA = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eNB = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eNC = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eNC.loop(true);
        am.a(this.eNC, R.raw.ala_play);
        this.eND = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eNv = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eNw = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eNx = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eNx.setVisibility(8);
        this.eNF = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.eNG = this.mRootView.findViewById(R.id.divider_line_thick);
        this.eNH = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dTn = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dTn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTn.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dTn.setLayoutParams(layoutParams);
        }
        this.dTn.setOnClickListener(this.eMw);
        this.dTn.setReplyTimeVisible(false);
        this.dTn.setShowPraiseNum(true);
        this.dTn.setNeedAddPraiseIcon(true);
        this.dTn.setNeedAddReplyIcon(true);
        this.dTn.setShareVisible(true);
        this.dTn.setIsBarViewVisible(false);
        this.dTn.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bWZ = 8;
        dVar.bXe = 3;
        this.dTn.setAgreeStatisticData(dVar);
        this.dTn.setShareReportFrom(6);
        this.dTn.setStType("person_page");
        this.dTn.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZV() != null) {
                    r.this.aZV().a(view, r.this.eMW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.eNC, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.eNk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eNm, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.eNn, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eNo, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eNp, (int) R.color.cp_cont_d);
            if (this.eNq != null) {
                this.eNq.setImageDrawable(SvgManager.amL().a(R.drawable.icon_pure_card_more_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.Fk, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eNw, (int) R.color.cp_cont_f);
            if (this.eNr != null) {
                this.eNr.onChangeSkinType();
            }
            this.eNh.onChangeSkinType();
            this.dTn.onChangeSkinType();
            am.setBackgroundColor(this.eNG, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNH, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.eNw, R.color.cp_bg_line_e);
            if (this.eNF != null) {
                this.eNF.onChangeSkinType();
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
        this.eMW = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eMw);
        }
        this.eNk.setVisibility(cardPersonDynamicThreadData.eQn ? 0 : 8);
        this.eNl.setVisibility(cardPersonDynamicThreadData.eQm ? 0 : 4);
        this.eNG.setVisibility(cardPersonDynamicThreadData.eQm ? 0 : 8);
        this.eNH.setVisibility(cardPersonDynamicThreadData.eQm ? 8 : 0);
        if (cardPersonDynamicThreadData.eQo) {
            this.eNG.setVisibility(8);
            this.eNH.setVisibility(8);
        }
        this.eNI = cardPersonDynamicThreadData.eQb == 40 && cardPersonDynamicThreadData.eQd == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.caz != null) {
            this.eNJ = cardPersonDynamicThreadData.caz.isShareThread && cardPersonDynamicThreadData.eQd == 2;
        }
        this.eNk.setText(cardPersonDynamicThreadData.eQe);
        this.eNm.setText(cardPersonDynamicThreadData.eQf);
        this.eNn.setText(cardPersonDynamicThreadData.eQg);
        if (cardPersonDynamicThreadData.eQl != null && cardPersonDynamicThreadData.eQl.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eQl.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.eQl[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.eQl.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eNo.setText(sb2);
                this.eNo.setVisibility(0);
            } else {
                this.eNo.setText(R.string.person_homepage);
            }
        } else {
            this.eNo.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eNp.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eNp.setVisibility(0);
            }
            iJ(cardPersonDynamicThreadData.isPrivacy);
            this.eNq.setVisibility(0);
            this.eNq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eNr == null) {
                            r.this.eNr = new q(r.this.mPageContext);
                            r.this.eNr.create();
                            r.this.eNr.a(r.this.eNL);
                        }
                        r.this.eNr.a(r.this.eMW);
                        r.this.eNr.show();
                    }
                }
            });
        } else {
            this.eNp.setVisibility(8);
            this.eNq.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eQj;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.HH.setVisibility(0);
            iI(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.HH.setVoiceModel(voiceModel);
            this.HH.setTag(voiceModel);
            this.HH.bno();
            if (voiceModel != null) {
                this.HH.uJ(voiceModel.voice_status.intValue());
            }
            this.HH.cpA();
        } else {
            this.HH.setVisibility(8);
            iI(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eQi;
        am.setBackgroundResource(this.eNv, R.color.transparent);
        this.eNw.setVisibility(8);
        this.eNx.setVisibility(8);
        this.eNv.setVisibility(0);
        this.eNs.setVisibility(8);
        this.eND.setVisibility(8);
        this.eNy.setVisibility(8);
        this.eNB.setVisibility(8);
        this.eNC.cancelAnimation();
        this.eNC.setVisibility(8);
        if (cardPersonDynamicThreadData.eQb == 36) {
            this.eMr.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eQb == 40 || this.eMW.eQb == 50) {
            this.eMr.setVisibility(8);
            if (com.baidu.tbadk.core.i.ago().isShowImages()) {
                this.eNs.setVisibility(0);
                this.eNu.setVisibility(0);
                this.eNu.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNs.getLayoutParams();
                int width = this.eNs.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eNs.setLayoutParams(layoutParams);
                if (this.eMW.videoInfo != null) {
                    this.eNt.setDefaultErrorResource(0);
                    this.eNt.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eNt.setEvent(this.cTx);
                    this.eNt.startLoad(this.eMW.videoInfo.thumbnail_url, 17, false);
                    if (this.eNI) {
                        this.eND.setVisibility(0);
                        this.eND.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eNy.setVisibility(0);
                        this.eNz.setText(aq.stringForVideoTime(this.eMW.videoInfo.video_duration.intValue() * 1000));
                        this.eNA.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.eMW.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eMW.eQb == 60 || this.eMW.eQb == 49) {
            this.eMr.setVisibility(8);
            if (this.eMW.caz.aiX() != null && this.eMW.caz.aiX().user_info != null && this.eMW.eQb == 60) {
                String str = this.eMW.caz.aiX().user_info.user_name;
                if (com.baidu.tbadk.util.aa.getTextLengthWithEmoji(str) > 14) {
                    str = com.baidu.tbadk.util.aa.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.eNw.setText(n.cw(str + ":", this.eMW.caz.getTitle()));
                this.eNw.setVisibility(0);
            } else {
                this.eNw.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.ago().isShowImages()) {
                this.eNs.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eNs.getLayoutParams();
                int width2 = this.eNs.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eNs.setLayoutParams(layoutParams2);
                if (this.eMW.caz.aiX() != null) {
                    this.eNt.setDefaultErrorResource(0);
                    this.eNt.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eNt.setEvent(this.cTx);
                    this.eNt.startLoad(cardPersonDynamicThreadData.caz.aiX().cover, 10, false);
                    this.eNu.setVisibility(8);
                    this.eNC.setVisibility(0);
                    this.eNC.playAnimation();
                    am.setBackgroundResource(this.eNv, R.color.cp_bg_line_e);
                    this.eNB.setVisibility(0);
                    this.eNB.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.eMW.caz.aiX().audience_count)));
                    this.dTn.getCommentContainer().setOnClickListener(this.eMw);
                } else {
                    this.dTn.getCommentContainer().setOnClickListener(this.dTn);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.ago().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.caz;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.eMr.setVisibility(0);
                    this.eMr.setFromCDN(this.Hx);
                    this.eMr.setSingleImageRatio(0.67d);
                    this.eMr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.ash();
                            } else {
                                r.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.eMr.setImageMediaList(linkedList);
                } else {
                    this.eMr.setVisibility(8);
                }
            } else {
                this.eMr.setVisibility(8);
            }
            this.eNv.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.caz != null && cardPersonDynamicThreadData.caz.cdl != null) {
            this.eNF.setVisibility(0);
            this.eNF.b(cardPersonDynamicThreadData.caz.cdl);
            this.eNF.setOnClickListener(this);
            this.HH.setVisibility(8);
            this.eMr.setVisibility(8);
            this.eNv.setVisibility(8);
            if (this.eNJ) {
                this.eNE.setVisibility(0);
            } else {
                this.eNE.setVisibility(8);
            }
        } else {
            this.eNF.setVisibility(8);
            this.eNE.setVisibility(8);
        }
        bao();
        c(cardPersonDynamicThreadData);
    }

    private void iI(boolean z) {
        if (this.eMr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMr.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.eMr.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.eNI || this.eNJ) {
                this.dTn.setCommentClickable(false);
                this.dTn.setAgreeClickable(false);
                this.dTn.setShareClickable(false);
                this.eNF.setClickable(false);
                this.eNq.setClickable(false);
            } else {
                this.dTn.setCommentClickable(true);
                this.dTn.setAgreeClickable(true);
                this.dTn.setShareClickable(true);
                this.eNF.setClickable(true);
                this.eNq.setClickable(true);
            }
            this.dTn.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eQb == 60) {
                this.dTn.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eQl != null) {
                this.dTn.setMultiForumCount(cardPersonDynamicThreadData.eQl.length);
            }
            if (cardPersonDynamicThreadData.caz != null) {
                this.dTn.setForumId(String.valueOf(cardPersonDynamicThreadData.caz.getFid()));
            }
            this.dTn.setData(cardPersonDynamicThreadData.caz);
        }
    }

    private void bao() {
        this.HH.setClickable(true);
        int childCount = this.eMr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eMr.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bar() {
        if (this.eMW != null && this.eMW.caz != null && this.eMW.caz.aiX() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.uz(this.eMW.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eMW.caz.aiX());
            if (this.eMW.caz.aiX().user_info != null) {
                alaLiveInfoCoreData.userName = this.eMW.caz.aiX().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bas() {
        if (this.eMW != null && this.eMW.caz != null && this.eMW.caz.aiX() != null && this.eMW.caz.aiX().share_info != null) {
            if (!isHost()) {
                n.uz(this.eMW.threadId);
            }
            if (this.eMW.caz.aiX().share_info.record_tid <= 0) {
                bar();
                return;
            }
            String valueOf = String.valueOf(this.eMW.caz.aiX().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ash() {
        if (this.eMW != null) {
            if (!isHost()) {
                n.uz(this.eMW.threadId);
                n.a(this.mTitle, this.eMW.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.Fk, this.eMW.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eMW.eQb == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.eMW.caz, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eMW.caz.getFid()));
            pbActivityConfig.setForumName(this.eMW.caz.aiJ());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eMW.caz.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.eMW.caz == null || !this.eMW.caz.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").bS("obj_type", "2").bS("tid", this.eMW.threadId).O("obj_param1", this.eMW.isHost ? 1 : 2));
        }
    }

    private void bat() {
        if (this.eMW != null && this.eMW.caz != null && this.eMW.caz.cdl != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eMW.caz.cdl.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").bS("obj_type", "3").bS("tid", this.eMW.threadId).O("obj_param1", this.eMW.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(boolean z) {
        if (this.eNp != null) {
            if (z) {
                this.eNp.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eNp.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eNp.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eNp.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eMW.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNF) {
            bat();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eMr != null) {
            this.eMr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eMr != null) {
            this.eMr.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.Hx ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiJ(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Hx, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.caz == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.caz.d(false, true, this.eNI);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
