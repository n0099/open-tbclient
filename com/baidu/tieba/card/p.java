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
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.o;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class p extends a<CardPersonDynamicThreadData> {
    private TextView KA;
    private boolean NK;
    public PlayVoiceBntNew NZ;
    private TextView Pc;
    private TextView Pf;
    private TbImageView.a dMI;
    public ThreadCommentAndPraiseInfoLayout eNX;
    private ConstrainImageGroup fKK;
    private View.OnClickListener fKP;
    private final View.OnClickListener fKQ;
    private CustomMessageListener fKg;
    public ThreadViewAndCommentInfoLayout fLA;
    private final String fLB;
    private final String fLC;
    private TextView fLD;
    private LinearLayout fLE;
    private TextView fLF;
    private TextView fLG;
    private TextView fLH;
    private TextView fLI;
    private ImageView fLJ;
    private o fLK;
    private View fLL;
    private TbImageView fLM;
    private ImageView fLN;
    private LinearLayout fLO;
    private TextView fLP;
    private LinearLayout fLQ;
    private LinearLayout fLR;
    private TextView fLS;
    private TBLottieAnimationView fLT;
    private TextView fLU;
    private TextView fLV;
    public OriginalThreadCardView fLW;
    private View fLX;
    private View fLY;
    private boolean fLZ;
    private CardPersonDynamicThreadData fLo;
    private boolean fMa;
    com.baidu.tieba.view.f fMb;
    private o.a fMc;
    private final View.OnClickListener fMd;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fLB = "1";
        this.fLC = "2";
        this.mSkinType = 3;
        this.NK = true;
        this.fMb = new com.baidu.tieba.view.f() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.fLo != null && !StringUtils.isNull(p.this.fLo.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.fLo.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.f
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.fKP = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.buM() != null) {
                    p.this.buM().a(view, p.this.fLo);
                }
                if (p.this.fLo.fOz != 60) {
                    if ((p.this.fLo.fOz != 40 || p.this.fLo.fOB != 2) && !p.this.fMa) {
                        p.this.aMD();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEL();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.fLo.cRt.aCK().live_status != 1) {
                    p.this.bvk();
                } else {
                    p.this.bvj();
                }
            }
        };
        this.fKg = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.fLo != null && p.this.fLo.threadId != null && p.this.mTitle != null && p.this.KA != null && ((String) customResponsedMessage.getData()).equals(p.this.fLo.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.fLo.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.KA, p.this.fLo.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.fMc = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.kt(z);
            }
        };
        this.fMd = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> buM = p.this.buM();
                if (buM != null) {
                    view.setTag("1");
                    buM.a(view, p.this.fLo);
                }
                p.this.aMD();
            }
        };
        this.fKQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> buM = p.this.buM();
                if (buM != null) {
                    view.setTag("2");
                    buM.a(view, p.this.fLo);
                }
            }
        };
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.fLM != null) {
                    p.this.fLM.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.fLD = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.fLE = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.fLF = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.fLG = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.fLH = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.fLV = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.fLI = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.fLJ = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.NZ = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.NZ.setAfterClickListener(this.fKQ);
        this.KA = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.KA.setVisibility(8);
        this.fKK = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.fKK.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fKK.setChildClickListener(this.fMd);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.fKK.setImageProcessor(aVar);
        this.fLL = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.fLM = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.fLN = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.fLA = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.fLR = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.Pf = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.Pc = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.fLS = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.fLT = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fLT.loop(true);
        am.a(this.fLT, R.raw.ala_play);
        this.fLU = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.fLO = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.fLP = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.fLQ = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.fLQ.setVisibility(8);
        this.fLW = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.fLX = this.mRootView.findViewById(R.id.divider_line_thick);
        this.fLY = this.mRootView.findViewById(R.id.divider_line_thin);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.eNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNX.setLayoutParams(layoutParams);
        }
        this.eNX.setOnClickListener(this.fKP);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setShareVisible(true);
        this.eNX.setIsBarViewVisible(false);
        this.eNX.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 8;
        dVar.cNV = 3;
        this.eNX.setAgreeStatisticData(dVar);
        this.eNX.setShareReportFrom(6);
        this.eNX.setStType("person_page");
        this.eNX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.buM() != null) {
                    p.this.buM().a(view, p.this.fLo);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.fLT, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.fLD, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fLF, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.fLG, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fLH, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fLV, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fLI, (int) R.color.cp_cont_d);
            if (this.fLJ != null) {
                this.fLJ.setImageDrawable(SvgManager.aGG().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.KA, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fLP, (int) R.color.cp_cont_f);
            if (this.fLK != null) {
                this.fLK.onChangeSkinType();
            }
            this.fLA.onChangeSkinType();
            this.eNX.onChangeSkinType();
            am.setBackgroundColor(this.fLX, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fLY, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.fLP, R.color.cp_bg_line_e);
            if (this.fLW != null) {
                this.fLW.onChangeSkinType();
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
        this.fLo = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fKP);
        }
        this.fLD.setVisibility(cardPersonDynamicThreadData.fOL ? 0 : 8);
        this.fLE.setVisibility(cardPersonDynamicThreadData.fOK ? 0 : 4);
        this.fLX.setVisibility(cardPersonDynamicThreadData.fOK ? 0 : 8);
        this.fLY.setVisibility(cardPersonDynamicThreadData.fOK ? 8 : 0);
        if (cardPersonDynamicThreadData.fOM) {
            this.fLX.setVisibility(8);
            this.fLY.setVisibility(8);
        }
        this.fLZ = cardPersonDynamicThreadData.fOz == 40 && cardPersonDynamicThreadData.fOB == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.cRt != null) {
            this.fMa = cardPersonDynamicThreadData.cRt.isShareThread && cardPersonDynamicThreadData.fOB == 2;
        }
        this.fLD.setText(cardPersonDynamicThreadData.fOC);
        this.fLF.setText(cardPersonDynamicThreadData.fOD);
        this.fLG.setText(cardPersonDynamicThreadData.fOE);
        if (cardPersonDynamicThreadData.fOJ != null && cardPersonDynamicThreadData.fOJ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.fOJ.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.fOJ[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.fOJ.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.fLH.setText(sb2);
                this.fLH.setVisibility(0);
            } else {
                this.fLH.setText(R.string.person_homepage);
            }
        } else {
            this.fLH.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.fLI.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.fLI.setVisibility(0);
            }
            kt(cardPersonDynamicThreadData.isPrivacy);
            this.fLJ.setVisibility(0);
            this.fLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.fLK == null) {
                            p.this.fLK = new o(p.this.mPageContext);
                            p.this.fLK.create();
                            p.this.fLK.a(p.this.fMc);
                        }
                        p.this.fLK.a(p.this.fLo);
                        p.this.fLK.show();
                    }
                }
            });
        } else {
            this.fLI.setVisibility(8);
            this.fLJ.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.fOH;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.NZ.setVisibility(0);
            ks(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.NZ.setVoiceModel(voiceModel);
            this.NZ.setTag(voiceModel);
            this.NZ.can();
            if (voiceModel != null) {
                this.NZ.xe(voiceModel.voice_status.intValue());
            }
            this.NZ.cMC();
        } else {
            this.NZ.setVisibility(8);
            ks(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.fOG;
        am.setBackgroundResource(this.fLO, R.color.transparent);
        this.fLP.setVisibility(8);
        this.fLQ.setVisibility(8);
        this.fLO.setVisibility(0);
        this.fLL.setVisibility(8);
        this.fLU.setVisibility(8);
        this.fLR.setVisibility(8);
        this.fLS.setVisibility(8);
        this.fLT.cancelAnimation();
        this.fLT.setVisibility(8);
        if (cardPersonDynamicThreadData.fOz == 36) {
            this.fKK.setVisibility(8);
        } else if (cardPersonDynamicThreadData.fOz == 40 || this.fLo.fOz == 50) {
            this.fKK.setVisibility(8);
            if (com.baidu.tbadk.core.i.azR().isShowImages()) {
                this.fLL.setVisibility(0);
                this.fLN.setVisibility(0);
                this.fLN.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLL.getLayoutParams();
                int width = this.fLL.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.fLL.setLayoutParams(layoutParams);
                if (this.fLo.videoInfo != null) {
                    this.fLM.setDefaultErrorResource(0);
                    this.fLM.setPlaceHolder(3);
                    this.fLM.setEvent(this.dMI);
                    this.fLM.startLoad(this.fLo.videoInfo.thumbnail_url, 17, false);
                    if (this.fLZ) {
                        this.fLU.setVisibility(0);
                        this.fLU.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.fLR.setVisibility(0);
                        this.Pf.setText(aq.stringForVideoTime(this.fLo.videoInfo.video_duration.intValue() * 1000));
                        this.Pc.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fLo.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.fLo.fOz == 60 || this.fLo.fOz == 49) {
            this.fKK.setVisibility(8);
            if (this.fLo.cRt.aCK() != null && this.fLo.cRt.aCK().user_info != null && this.fLo.fOz == 60) {
                String str = this.fLo.cRt.aCK().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.fLP.setText(l.da(str + ":", this.fLo.cRt.getTitle()));
                this.fLP.setVisibility(0);
            } else {
                this.fLP.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.azR().isShowImages()) {
                this.fLL.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fLL.getLayoutParams();
                int width2 = this.fLL.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.fLL.setLayoutParams(layoutParams2);
                if (this.fLo.cRt.aCK() != null) {
                    this.fLM.setDefaultErrorResource(0);
                    this.fLM.setPlaceHolder(3);
                    this.fLM.setEvent(this.dMI);
                    this.fLM.startLoad(cardPersonDynamicThreadData.cRt.aCK().cover, 10, false);
                    this.fLN.setVisibility(8);
                    this.fLT.setVisibility(0);
                    this.fLT.playAnimation();
                    am.setBackgroundResource(this.fLO, R.color.cp_bg_line_e);
                    this.fLS.setVisibility(0);
                    this.fLS.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fLo.cRt.aCK().audience_count)));
                    this.eNX.getCommentContainer().setOnClickListener(this.fKP);
                } else {
                    this.eNX.getCommentContainer().setOnClickListener(this.eNX);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.azR().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.cRt;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.fKK.setVisibility(0);
                    this.fKK.setFromCDN(this.NK);
                    this.fKK.setSingleImageRatio(0.67d);
                    this.fKK.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aMD();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.fKK.setImageMediaList(linkedList);
                } else {
                    this.fKK.setVisibility(8);
                }
            } else {
                this.fKK.setVisibility(8);
            }
            this.fLO.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.cRt != null && cardPersonDynamicThreadData.cRt.cUe != null) {
            this.fLW.setVisibility(0);
            this.fLW.b(cardPersonDynamicThreadData.cRt.cUe);
            this.fLW.setOnClickListener(this);
            this.NZ.setVisibility(8);
            this.fKK.setVisibility(8);
            this.fLO.setVisibility(8);
            if (this.fMa) {
                this.fLV.setVisibility(0);
            } else {
                this.fLV.setVisibility(8);
            }
        } else {
            this.fLW.setVisibility(8);
            this.fLV.setVisibility(8);
        }
        bvg();
        c(cardPersonDynamicThreadData);
    }

    private void ks(boolean z) {
        if (this.fKK != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKK.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.fKK.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.fLZ || this.fMa) {
                this.eNX.setCommentClickable(false);
                this.eNX.setAgreeClickable(false);
                this.eNX.setShareClickable(false);
                this.fLW.setClickable(false);
                this.fLJ.setClickable(false);
            } else {
                this.eNX.setCommentClickable(true);
                this.eNX.setAgreeClickable(true);
                this.eNX.setShareClickable(true);
                this.fLW.setClickable(true);
                this.fLJ.setClickable(true);
            }
            this.eNX.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.fOz == 60) {
                this.eNX.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.fOJ != null) {
                this.eNX.setMultiForumCount(cardPersonDynamicThreadData.fOJ.length);
            }
            if (cardPersonDynamicThreadData.cRt != null) {
                this.eNX.setForumId(String.valueOf(cardPersonDynamicThreadData.cRt.getFid()));
            }
            this.eNX.setData(cardPersonDynamicThreadData.cRt);
        }
    }

    private void bvg() {
        this.NZ.setClickable(true);
        int childCount = this.fKK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fKK.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bvj() {
        if (this.fLo != null && this.fLo.cRt != null && this.fLo.cRt.aCK() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.zU(this.fLo.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fLo.cRt.aCK());
            if (this.fLo.cRt.aCK().user_info != null) {
                alaLiveInfoCoreData.userName = this.fLo.cRt.aCK().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvk() {
        if (this.fLo != null && this.fLo.cRt != null && this.fLo.cRt.aCK() != null && this.fLo.cRt.aCK().share_info != null) {
            if (!isHost()) {
                l.zU(this.fLo.threadId);
            }
            if (this.fLo.cRt.aCK().share_info.record_tid <= 0) {
                bvj();
                return;
            }
            String valueOf = String.valueOf(this.fLo.cRt.aCK().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.fLo.cRt);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMD() {
        if (this.fLo != null) {
            if (!isHost()) {
                l.zU(this.fLo.threadId);
                l.a(this.mTitle, this.fLo.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.KA, this.fLo.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.fLo.fOz == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.fLo.cRt, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.fLo.cRt.getFid()));
            pbActivityConfig.setForumName(this.fLo.cRt.aCw());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.fLo.cRt.isShareThread);
            pbActivityConfig.setThreadData(this.fLo.cRt);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.fLo.cRt == null || !this.fLo.cRt.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cx("obj_type", "2").cx("tid", this.fLo.threadId).X("obj_param1", this.fLo.isHost ? 1 : 2));
        }
    }

    private void bvl() {
        if (this.fLo != null && this.fLo.cRt != null && this.fLo.cRt.cUe != null) {
            OriginalThreadInfo originalThreadInfo = this.fLo.cRt.cUe;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cx("obj_type", "3").cx("tid", this.fLo.threadId).X("obj_param1", this.fLo.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(boolean z) {
        if (this.fLI != null) {
            if (z) {
                this.fLI.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.fLI.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.fLI.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.fLI.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.fLo.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fLW) {
            bvl();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKK != null) {
            this.fKK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKK != null) {
            this.fKK.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
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
                imageUrlData.urlType = this.NK ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCw(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.cRt == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.cRt.d(false, true, this.fLZ);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        l.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
