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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.p;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView adV;
    private boolean aha;
    public PlayVoiceBntNew ahm;
    private TextView ail;
    private TextView ain;
    private TbImageView.a eBu;
    public ThreadCommentAndPraiseInfoLayout fGz;
    private CustomMessageListener gDS;
    private View.OnClickListener gEC;
    private final View.OnClickListener gED;
    private ConstrainImageGroup gEx;
    private ImageView gFA;
    private LinearLayout gFB;
    private TextView gFC;
    private LinearLayout gFD;
    private LinearLayout gFE;
    private TextView gFF;
    private TBLottieAnimationView gFG;
    private TextView gFH;
    private TextView gFI;
    public OriginalThreadCardView gFJ;
    private View gFK;
    private View gFL;
    private boolean gFM;
    private boolean gFN;
    com.baidu.tieba.view.g gFO;
    private p.a gFP;
    private final View.OnClickListener gFQ;
    private CardPersonDynamicThreadData gFb;
    public ThreadViewAndCommentInfoLayout gFn;
    private final String gFo;
    private final String gFp;
    private TextView gFq;
    private LinearLayout gFr;
    private TextView gFs;
    private TextView gFt;
    private TextView gFu;
    private TextView gFv;
    private ImageView gFw;
    private p gFx;
    private View gFy;
    private TbImageView gFz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gFo = "1";
        this.gFp = "2";
        this.mSkinType = 3;
        this.aha = true;
        this.gFO = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.gFb != null && !StringUtils.isNull(q.this.gFb.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.gFb.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.gEC = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bKU() != null) {
                    q.this.bKU().a(view, q.this.gFb);
                }
                if (q.this.gFb.gIi != 60) {
                    if ((q.this.gFb.gIi != 40 || q.this.gFb.gIk != 2) && !q.this.gFN) {
                        q.this.bbj();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aSY();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.gFb.dEA.aQS().live_status != 1) {
                    q.this.bLq();
                } else {
                    q.this.bLp();
                }
            }
        };
        this.gDS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.gFb != null && q.this.gFb.threadId != null && q.this.mTitle != null && q.this.adV != null && ((String) customResponsedMessage.getData()).equals(q.this.gFb.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.gFb.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    m.a(q.this.adV, q.this.gFb.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.gFP = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.lS(z);
            }
        };
        this.gFQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bKU = q.this.bKU();
                if (bKU != null) {
                    view.setTag("1");
                    bKU.a(view, q.this.gFb);
                }
                q.this.bbj();
            }
        };
        this.gED = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bKU = q.this.bKU();
                if (bKU != null) {
                    view.setTag("2");
                    bKU.a(view, q.this.gFb);
                }
            }
        };
        this.eBu = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.gFz != null) {
                    q.this.gFz.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.gFq = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.gFr = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.gFs = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.gFt = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.gFu = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.gFI = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.gFv = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.gFw = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.ahm = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.ahm.setAfterClickListener(this.gED);
        this.adV = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.adV.setVisibility(8);
        this.gEx = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.gEx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gEx.setChildClickListener(this.gFQ);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.gEx.setImageProcessor(aVar);
        this.gFy = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.gFz = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.gFA = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.gFn = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.gFE = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.ain = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.ail = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.gFF = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.gFG = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gFG.loop(true);
        am.a(this.gFG, (int) R.raw.ala_play);
        this.gFH = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.gFB = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.gFC = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.gFD = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.gFD.setVisibility(8);
        this.gFJ = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.gFK = this.mRootView.findViewById(R.id.divider_line_thick);
        this.gFL = this.mRootView.findViewById(R.id.divider_line_thin);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.fGz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGz.setLayoutParams(layoutParams);
        }
        this.fGz.setOnClickListener(this.gEC);
        this.fGz.setReplyTimeVisible(false);
        this.fGz.setShowPraiseNum(true);
        this.fGz.setNeedAddPraiseIcon(true);
        this.fGz.setNeedAddReplyIcon(true);
        this.fGz.setShareVisible(true);
        this.fGz.setIsBarViewVisible(false);
        this.fGz.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 8;
        cVar.dBf = 3;
        this.fGz.setAgreeStatisticData(cVar);
        this.fGz.setShareReportFrom(6);
        this.fGz.setStType("person_page");
        this.fGz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bKU() != null) {
                    q.this.bKU().a(view, q.this.gFb);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.gFG, (int) R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gFq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gFs, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.gFt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gFu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gFI, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gFv, (int) R.color.cp_cont_d);
            if (this.gFw != null) {
                this.gFw.setImageDrawable(SvgManager.aUW().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adV, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gFC, (int) R.color.cp_cont_f);
            if (this.gFx != null) {
                this.gFx.onChangeSkinType();
            }
            this.gFn.onChangeSkinType();
            this.fGz.onChangeSkinType();
            am.setBackgroundColor(this.gFK, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gFL, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gFC, R.color.cp_bg_line_e);
            if (this.gFJ != null) {
                this.gFJ.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.gFb = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gEC);
        }
        this.gFq.setVisibility(cardPersonDynamicThreadData.gIu ? 0 : 8);
        this.gFr.setVisibility(cardPersonDynamicThreadData.gIt ? 0 : 4);
        this.gFK.setVisibility(cardPersonDynamicThreadData.gIt ? 0 : 8);
        this.gFL.setVisibility(cardPersonDynamicThreadData.gIt ? 8 : 0);
        if (cardPersonDynamicThreadData.gIv) {
            this.gFK.setVisibility(8);
            this.gFL.setVisibility(8);
        }
        this.gFM = cardPersonDynamicThreadData.gIi == 40 && cardPersonDynamicThreadData.gIk == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dEA != null) {
            this.gFN = cardPersonDynamicThreadData.dEA.isShareThread && cardPersonDynamicThreadData.gIk == 2;
        }
        this.gFq.setText(cardPersonDynamicThreadData.gIl);
        this.gFs.setText(cardPersonDynamicThreadData.gIm);
        this.gFt.setText(cardPersonDynamicThreadData.gIn);
        if (cardPersonDynamicThreadData.gIs != null && cardPersonDynamicThreadData.gIs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.gIs.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.gIs[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.gIs.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.gFu.setText(sb2);
                this.gFu.setVisibility(0);
            } else {
                this.gFu.setText(R.string.person_homepage);
            }
        } else {
            this.gFu.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.gFv.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.gFv.setVisibility(0);
            }
            lS(cardPersonDynamicThreadData.isPrivacy);
            this.gFw.setVisibility(0);
            this.gFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.gFx == null) {
                            q.this.gFx = new p(q.this.mPageContext);
                            q.this.gFx.create();
                            q.this.gFx.a(q.this.gFP);
                        }
                        q.this.gFx.a(q.this.gFb);
                        q.this.gFx.show();
                    }
                }
            });
        } else {
            this.gFv.setVisibility(8);
            this.gFw.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.gIq;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.ahm.setVisibility(0);
            lR(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.ahm.setVoiceModel(voiceModel);
            this.ahm.setTag(voiceModel);
            this.ahm.crv();
            if (voiceModel != null) {
                this.ahm.yk(voiceModel.voice_status.intValue());
            }
            this.ahm.dfa();
        } else {
            this.ahm.setVisibility(8);
            lR(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.gIp;
        am.setBackgroundResource(this.gFB, R.color.transparent);
        this.gFC.setVisibility(8);
        this.gFD.setVisibility(8);
        this.gFB.setVisibility(0);
        this.gFy.setVisibility(8);
        this.gFH.setVisibility(8);
        this.gFE.setVisibility(8);
        this.gFF.setVisibility(8);
        this.gFG.cancelAnimation();
        this.gFG.setVisibility(8);
        if (cardPersonDynamicThreadData.gIi == 36) {
            this.gEx.setVisibility(8);
        } else if (cardPersonDynamicThreadData.gIi == 40 || this.gFb.gIi == 50) {
            this.gEx.setVisibility(8);
            if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                this.gFy.setVisibility(0);
                this.gFA.setVisibility(0);
                this.gFA.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFy.getLayoutParams();
                int width = this.gFy.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.gFy.setLayoutParams(layoutParams);
                if (this.gFb.videoInfo != null) {
                    this.gFz.setDefaultErrorResource(0);
                    this.gFz.setPlaceHolder(3);
                    this.gFz.setEvent(this.eBu);
                    this.gFz.startLoad(this.gFb.videoInfo.thumbnail_url, 17, false);
                    if (this.gFM) {
                        this.gFH.setVisibility(0);
                        this.gFH.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.gFE.setVisibility(0);
                        this.ain.setText(aq.stringForVideoTime(this.gFb.videoInfo.video_duration.intValue() * 1000));
                        this.ail.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.gFb.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.gFb.gIi == 60 || this.gFb.gIi == 49) {
            this.gEx.setVisibility(8);
            if (this.gFb.dEA.aQS() != null && this.gFb.dEA.aQS().user_info != null && this.gFb.gIi == 60) {
                String str = this.gFb.dEA.aQS().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.gFC.setText(m.dO(str + ":", this.gFb.dEA.getTitle()));
                this.gFC.setVisibility(0);
            } else {
                this.gFC.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                this.gFy.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gFy.getLayoutParams();
                int width2 = this.gFy.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.gFy.setLayoutParams(layoutParams2);
                if (this.gFb.dEA.aQS() != null) {
                    this.gFz.setDefaultErrorResource(0);
                    this.gFz.setPlaceHolder(3);
                    this.gFz.setEvent(this.eBu);
                    this.gFz.startLoad(cardPersonDynamicThreadData.dEA.aQS().cover, 10, false);
                    this.gFA.setVisibility(8);
                    this.gFG.setVisibility(0);
                    this.gFG.playAnimation();
                    am.setBackgroundResource(this.gFB, R.color.cp_bg_line_e);
                    this.gFF.setVisibility(0);
                    this.gFF.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.gFb.dEA.aQS().audience_count)));
                    this.fGz.getCommentContainer().setOnClickListener(this.gEC);
                } else {
                    this.fGz.getCommentContainer().setOnClickListener(this.fGz);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.aNQ().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bk bkVar = cardPersonDynamicThreadData.dEA;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.gEx.setVisibility(0);
                    this.gEx.setFromCDN(this.aha);
                    this.gEx.setSingleImageRatio(0.67d);
                    this.gEx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bbj();
                            } else {
                                q.this.a(view, linkedList, i2, bkVar);
                            }
                        }
                    });
                    this.gEx.setImageMediaList(linkedList);
                } else {
                    this.gEx.setVisibility(8);
                }
            } else {
                this.gEx.setVisibility(8);
            }
            this.gFB.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dEA != null && cardPersonDynamicThreadData.dEA.dHm != null) {
            this.gFJ.setVisibility(0);
            this.gFJ.b(cardPersonDynamicThreadData.dEA.dHm);
            this.gFJ.setOnClickListener(this);
            this.ahm.setVisibility(8);
            this.gEx.setVisibility(8);
            this.gFB.setVisibility(8);
            if (this.gFN) {
                this.gFI.setVisibility(0);
            } else {
                this.gFI.setVisibility(8);
            }
        } else {
            this.gFJ.setVisibility(8);
            this.gFI.setVisibility(8);
        }
        bLm();
        c(cardPersonDynamicThreadData);
    }

    private void lR(boolean z) {
        if (this.gEx != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEx.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.gEx.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.gFM || this.gFN) {
                this.fGz.setCommentClickable(false);
                this.fGz.setAgreeClickable(false);
                this.fGz.setShareClickable(false);
                this.gFJ.setClickable(false);
                this.gFw.setClickable(false);
            } else {
                this.fGz.setCommentClickable(true);
                this.fGz.setAgreeClickable(true);
                this.fGz.setShareClickable(true);
                this.gFJ.setClickable(true);
                this.gFw.setClickable(true);
            }
            this.fGz.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.gIi == 60) {
                this.fGz.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.gIs != null) {
                this.fGz.setMultiForumCount(cardPersonDynamicThreadData.gIs.length);
            }
            if (cardPersonDynamicThreadData.dEA != null) {
                this.fGz.setForumId(String.valueOf(cardPersonDynamicThreadData.dEA.getFid()));
            }
            this.fGz.setData(cardPersonDynamicThreadData.dEA);
        }
    }

    private void bLm() {
        this.ahm.setClickable(true);
        int childCount = this.gEx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gEx.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bLp() {
        if (this.gFb != null && this.gFb.dEA != null && this.gFb.dEA.aQS() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Dn(this.gFb.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.gFb.dEA.aQS());
            if (this.gFb.dEA.aQS().user_info != null) {
                alaLiveInfoCoreData.userName = this.gFb.dEA.aQS().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLq() {
        if (this.gFb != null && this.gFb.dEA != null && this.gFb.dEA.aQS() != null && this.gFb.dEA.aQS().share_info != null) {
            if (!isHost()) {
                m.Dn(this.gFb.threadId);
            }
            if (this.gFb.dEA.aQS().share_info.record_tid <= 0) {
                bLp();
                return;
            }
            String valueOf = String.valueOf(this.gFb.dEA.aQS().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.gFb.dEA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbj() {
        if (this.gFb != null) {
            if (!isHost()) {
                m.Dn(this.gFb.threadId);
                m.a(this.mTitle, this.gFb.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.adV, this.gFb.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.gFb.gIi == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.gFb.dEA, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.gFb.dEA.getFid()));
            pbActivityConfig.setForumName(this.gFb.dEA.aQC());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.gFb.dEA.isShareThread);
            pbActivityConfig.setThreadData(this.gFb.dEA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.gFb.dEA == null || !this.gFb.dEA.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").dh("obj_type", "2").dh("tid", this.gFb.threadId).ag("obj_param1", this.gFb.isHost ? 1 : 2));
        }
    }

    private void bLr() {
        if (this.gFb != null && this.gFb.dEA != null && this.gFb.dEA.dHm != null) {
            OriginalThreadInfo originalThreadInfo = this.gFb.dEA.dHm;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").dh("obj_type", "3").dh("tid", this.gFb.threadId).ag("obj_param1", this.gFb.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.gFv != null) {
            if (z) {
                this.gFv.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.gFv.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.gFv.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.gFv.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.gFb.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gFJ) {
            bLr();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEx != null) {
            this.gEx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEx != null) {
            this.gEx.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bk bkVar) {
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
                imageUrlData.urlType = this.aha ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bkVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bkVar.aQC(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.aha, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bkVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dEA == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.dEA.d(false, true, this.gFM);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
