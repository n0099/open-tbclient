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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
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
    private TextView aeA;
    private boolean aik;
    public PlayVoiceBntNew aiw;
    private TextView ajH;
    private TextView ajJ;
    private TbImageView.a eLd;
    public ThreadCommentAndPraiseInfoLayout fRI;
    private CustomMessageListener gQI;
    private CardPersonDynamicThreadData gRR;
    private ConstrainImageGroup gRn;
    private View.OnClickListener gRs;
    private final View.OnClickListener gRt;
    private TextView gSA;
    private TextView gSB;
    public OriginalThreadCardView gSC;
    private View gSD;
    private View gSE;
    private boolean gSF;
    private boolean gSG;
    com.baidu.tieba.view.g gSH;
    private p.a gSI;
    private final View.OnClickListener gSJ;
    public ThreadViewAndCommentInfoLayout gSg;
    private final String gSh;
    private final String gSi;
    private TextView gSj;
    private LinearLayout gSk;
    private TextView gSl;
    private TextView gSm;
    private TextView gSn;
    private TextView gSo;
    private ImageView gSp;
    private p gSq;
    private View gSr;
    private TbImageView gSs;
    private ImageView gSt;
    private LinearLayout gSu;
    private TextView gSv;
    private LinearLayout gSw;
    private LinearLayout gSx;
    private TextView gSy;
    private TBLottieAnimationView gSz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gSh = "1";
        this.gSi = "2";
        this.mSkinType = 3;
        this.aik = true;
        this.gSH = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.gRR != null && !StringUtils.isNull(q.this.gRR.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.gRR.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.gRs = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bOc() != null) {
                    q.this.bOc().a(view, q.this.gRR);
                }
                if (q.this.gRR.gVi != 60) {
                    if ((q.this.gRR.gVi != 40 || q.this.gRR.gVk != 2) && !q.this.gSG) {
                        q.this.bdl();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aUS();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.gRR.dLi.aSJ().live_status != 1) {
                    q.this.bOy();
                } else {
                    q.this.bOx();
                }
            }
        };
        this.gQI = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.gRR != null && q.this.gRR.threadId != null && q.this.mTitle != null && q.this.aeA != null && ((String) customResponsedMessage.getData()).equals(q.this.gRR.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.gRR.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    m.a(q.this.aeA, q.this.gRR.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.gSI = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.mb(z);
            }
        };
        this.gSJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bOc = q.this.bOc();
                if (bOc != null) {
                    view.setTag("1");
                    bOc.a(view, q.this.gRR);
                }
                q.this.bdl();
            }
        };
        this.gRt = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bOc = q.this.bOc();
                if (bOc != null) {
                    view.setTag("2");
                    bOc.a(view, q.this.gRR);
                }
            }
        };
        this.eLd = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.gSs != null) {
                    q.this.gSs.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.gSj = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.gSk = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.gSl = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.gSm = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.gSn = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.gSB = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.gSo = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.gSp = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.aiw = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.aiw.setAfterClickListener(this.gRt);
        this.aeA = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.aeA.setVisibility(8);
        this.gRn = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.gRn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gRn.setChildClickListener(this.gSJ);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.gRn.setImageProcessor(aVar);
        this.gSr = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.gSs = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.gSt = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.gSg = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.gSx = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.ajJ = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.ajH = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.gSy = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.gSz = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gSz.loop(true);
        an.a(this.gSz, (int) R.raw.ala_play);
        this.gSA = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.gSu = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.gSv = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.gSw = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.gSw.setVisibility(8);
        this.gSC = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.gSD = this.mRootView.findViewById(R.id.divider_line_thick);
        this.gSE = this.mRootView.findViewById(R.id.divider_line_thin);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.fRI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fRI.setLayoutParams(layoutParams);
        }
        this.fRI.setOnClickListener(this.gRs);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setShareVisible(true);
        this.fRI.setIsBarViewVisible(false);
        this.fRI.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 8;
        cVar.dHw = 3;
        this.fRI.setAgreeStatisticData(cVar);
        this.fRI.setShareReportFrom(6);
        this.fRI.setStType("person_page");
        this.fRI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bOc() != null) {
                    q.this.bOc().a(view, q.this.gRR);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.a(this.gSz, (int) R.raw.ala_play);
            an.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            an.setViewTextColor(this.gSj, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.gSl, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.gSm, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.gSn, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.gSB, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.gSo, (int) R.color.cp_cont_d);
            if (this.gSp != null) {
                this.gSp.setImageDrawable(SvgManager.aWQ().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.aeA, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.gSv, (int) R.color.cp_cont_f);
            if (this.gSq != null) {
                this.gSq.onChangeSkinType();
            }
            this.gSg.onChangeSkinType();
            this.fRI.onChangeSkinType();
            an.setBackgroundColor(this.gSD, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.gSE, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.gSv, R.color.cp_bg_line_e);
            if (this.gSC != null) {
                this.gSC.onChangeSkinType();
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
        this.gRR = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gRs);
        }
        this.gSj.setVisibility(cardPersonDynamicThreadData.gVu ? 0 : 8);
        this.gSk.setVisibility(cardPersonDynamicThreadData.gVt ? 0 : 4);
        this.gSD.setVisibility(cardPersonDynamicThreadData.gVt ? 0 : 8);
        this.gSE.setVisibility(cardPersonDynamicThreadData.gVt ? 8 : 0);
        if (cardPersonDynamicThreadData.gVv) {
            this.gSD.setVisibility(8);
            this.gSE.setVisibility(8);
        }
        this.gSF = cardPersonDynamicThreadData.gVi == 40 && cardPersonDynamicThreadData.gVk == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dLi != null) {
            this.gSG = cardPersonDynamicThreadData.dLi.isShareThread && cardPersonDynamicThreadData.gVk == 2;
        }
        this.gSj.setText(cardPersonDynamicThreadData.gVl);
        this.gSl.setText(cardPersonDynamicThreadData.gVm);
        this.gSm.setText(cardPersonDynamicThreadData.gVn);
        if (cardPersonDynamicThreadData.gVs != null && cardPersonDynamicThreadData.gVs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.gVs.length; i++) {
                sb.append(ar.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.gVs[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.gVs.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.gSn.setText(sb2);
                this.gSn.setVisibility(0);
            } else {
                this.gSn.setText(R.string.person_homepage);
            }
        } else {
            this.gSn.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.gSo.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.gSo.setVisibility(0);
            }
            mb(cardPersonDynamicThreadData.isPrivacy);
            this.gSp.setVisibility(0);
            this.gSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.gSq == null) {
                            q.this.gSq = new p(q.this.mPageContext);
                            q.this.gSq.create();
                            q.this.gSq.a(q.this.gSI);
                        }
                        q.this.gSq.a(q.this.gRR);
                        q.this.gSq.show();
                    }
                }
            });
        } else {
            this.gSo.setVisibility(8);
            this.gSp.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.gVq;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.aiw.setVisibility(0);
            ma(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.aiw.setVoiceModel(voiceModel);
            this.aiw.setTag(voiceModel);
            this.aiw.aYi();
            if (voiceModel != null) {
                this.aiw.yU(voiceModel.voice_status.intValue());
            }
            this.aiw.bCn();
        } else {
            this.aiw.setVisibility(8);
            ma(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.gVp;
        an.setBackgroundResource(this.gSu, R.color.transparent);
        this.gSv.setVisibility(8);
        this.gSw.setVisibility(8);
        this.gSu.setVisibility(0);
        this.gSr.setVisibility(8);
        this.gSA.setVisibility(8);
        this.gSx.setVisibility(8);
        this.gSy.setVisibility(8);
        this.gSz.cancelAnimation();
        this.gSz.setVisibility(8);
        if (cardPersonDynamicThreadData.gVi == 36) {
            this.gRn.setVisibility(8);
        } else if (cardPersonDynamicThreadData.gVi == 40 || this.gRR.gVi == 50) {
            this.gRn.setVisibility(8);
            if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
                this.gSr.setVisibility(0);
                this.gSt.setVisibility(0);
                this.gSt.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSr.getLayoutParams();
                int width = this.gSr.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.gSr.setLayoutParams(layoutParams);
                if (this.gRR.videoInfo != null) {
                    this.gSs.setDefaultErrorResource(0);
                    this.gSs.setPlaceHolder(3);
                    this.gSs.setEvent(this.eLd);
                    this.gSs.startLoad(this.gRR.videoInfo.thumbnail_url, 17, false);
                    if (this.gSF) {
                        this.gSA.setVisibility(0);
                        this.gSA.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.gSx.setVisibility(0);
                        this.ajJ.setText(ar.stringForVideoTime(this.gRR.videoInfo.video_duration.intValue() * 1000));
                        this.ajH.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ar.numFormatOverWan(this.gRR.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.gRR.gVi == 60 || this.gRR.gVi == 49) {
            this.gRn.setVisibility(8);
            if (this.gRR.dLi.aSJ() != null && this.gRR.dLi.aSJ().user_info != null && this.gRR.gVi == 60) {
                String str = this.gRR.dLi.aSJ().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.gSv.setText(m.dT(str + ":", this.gRR.dLi.getTitle()));
                this.gSv.setVisibility(0);
            } else {
                this.gSv.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
                this.gSr.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gSr.getLayoutParams();
                int width2 = this.gSr.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.gSr.setLayoutParams(layoutParams2);
                if (this.gRR.dLi.aSJ() != null) {
                    this.gSs.setDefaultErrorResource(0);
                    this.gSs.setPlaceHolder(3);
                    this.gSs.setEvent(this.eLd);
                    this.gSs.startLoad(cardPersonDynamicThreadData.dLi.aSJ().cover, 10, false);
                    this.gSt.setVisibility(8);
                    this.gSz.setVisibility(0);
                    this.gSz.playAnimation();
                    an.setBackgroundResource(this.gSu, R.color.cp_bg_line_e);
                    this.gSy.setVisibility(0);
                    this.gSy.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), ar.numFormatOverWan(this.gRR.dLi.aSJ().audience_count)));
                    this.fRI.getCommentContainer().setOnClickListener(this.gRs);
                } else {
                    this.fRI.getCommentContainer().setOnClickListener(this.fRI);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.aPA().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bu buVar = cardPersonDynamicThreadData.dLi;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.getCount(linkedList) > 0) {
                    this.gRn.setVisibility(0);
                    this.gRn.setFromCDN(this.aik);
                    this.gRn.setSingleImageRatio(0.67d);
                    this.gRn.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bdl();
                            } else {
                                q.this.a(view, linkedList, i2, buVar);
                            }
                        }
                    });
                    this.gRn.setImageMediaList(linkedList);
                } else {
                    this.gRn.setVisibility(8);
                }
            } else {
                this.gRn.setVisibility(8);
            }
            this.gSu.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dLi != null && cardPersonDynamicThreadData.dLi.dNX != null) {
            this.gSC.setVisibility(0);
            this.gSC.b(cardPersonDynamicThreadData.dLi.dNX);
            this.gSC.setOnClickListener(this);
            this.aiw.setVisibility(8);
            this.gRn.setVisibility(8);
            this.gSu.setVisibility(8);
            if (this.gSG) {
                this.gSB.setVisibility(0);
            } else {
                this.gSB.setVisibility(8);
            }
        } else {
            this.gSC.setVisibility(8);
            this.gSB.setVisibility(8);
        }
        bOu();
        c(cardPersonDynamicThreadData);
    }

    private void ma(boolean z) {
        if (this.gRn != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gRn.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.gRn.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.gSF || this.gSG) {
                this.fRI.setCommentClickable(false);
                this.fRI.setAgreeClickable(false);
                this.fRI.setShareClickable(false);
                this.gSC.setClickable(false);
                this.gSp.setClickable(false);
            } else {
                this.fRI.setCommentClickable(true);
                this.fRI.setAgreeClickable(true);
                this.fRI.setShareClickable(true);
                this.gSC.setClickable(true);
                this.gSp.setClickable(true);
            }
            this.fRI.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.gVi == 60) {
                this.fRI.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.gVs != null) {
                this.fRI.setMultiForumCount(cardPersonDynamicThreadData.gVs.length);
            }
            if (cardPersonDynamicThreadData.dLi != null) {
                this.fRI.setForumId(String.valueOf(cardPersonDynamicThreadData.dLi.getFid()));
            }
            this.fRI.setData(cardPersonDynamicThreadData.dLi);
        }
    }

    private void bOu() {
        this.aiw.setClickable(true);
        int childCount = this.gRn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gRn.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bOx() {
        if (this.gRR != null && this.gRR.dLi != null && this.gRR.dLi.aSJ() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.DO(this.gRR.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.gRR.dLi.aSJ());
            if (this.gRR.dLi.aSJ().user_info != null) {
                alaLiveInfoCoreData.userName = this.gRR.dLi.aSJ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOy() {
        if (this.gRR != null && this.gRR.dLi != null && this.gRR.dLi.aSJ() != null && this.gRR.dLi.aSJ().share_info != null) {
            if (!isHost()) {
                m.DO(this.gRR.threadId);
            }
            if (this.gRR.dLi.aSJ().share_info.record_tid <= 0) {
                bOx();
                return;
            }
            String valueOf = String.valueOf(this.gRR.dLi.aSJ().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.gRR.dLi);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdl() {
        if (this.gRR != null) {
            if (!isHost()) {
                m.DO(this.gRR.threadId);
                m.a(this.mTitle, this.gRR.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.aeA, this.gRR.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.gRR.gVi == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.gRR.dLi, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.gRR.dLi.getFid()));
            pbActivityConfig.setForumName(this.gRR.dLi.aSt());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.gRR.dLi.isShareThread);
            pbActivityConfig.setThreadData(this.gRR.dLi);
            pbActivityConfig.setIsPrivacy(this.gRR.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.gRR.dLi == null || !this.gRR.dLi.isShareThread) {
                return;
            }
            TiebaStatic.log(new ao("c12943").dk("obj_type", "2").dk("tid", this.gRR.threadId).ag("obj_param1", this.gRR.isHost ? 1 : 2));
        }
    }

    private void bOz() {
        if (this.gRR != null && this.gRR.dLi != null && this.gRR.dLi.dNX != null) {
            OriginalThreadInfo originalThreadInfo = this.gRR.dLi.dNX;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ao("c12943").dk("obj_type", "3").dk("tid", this.gRR.threadId).ag("obj_param1", this.gRR.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(boolean z) {
        if (this.gSo != null) {
            if (z) {
                this.gSo.setText(R.string.privacy);
                Drawable drawable = an.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.gSo.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.gSo.setText(R.string.public_open);
            Drawable drawable2 = an.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.gSo.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.gRR.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gSC) {
            bOz();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gRn != null) {
            this.gRn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gRn != null) {
            this.gRn.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bu buVar) {
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
                imageUrlData.urlType = this.aik ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(buVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, buVar.aSt(), String.valueOf(buVar.getFid()), buVar.getTid(), this.aik, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(buVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dLi == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.dLi.d(false, true, this.gSF);
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
