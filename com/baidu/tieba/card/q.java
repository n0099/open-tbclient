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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes18.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView aeq;
    private boolean aib;
    public PlayVoiceBntNew aio;
    private TextView ajC;
    private TextView ajE;
    private TbImageView.a eRz;
    public ThreadCommentAndPraiseInfoLayout fXb;
    private ConstrainImageGroup gWS;
    private View.OnClickListener gWX;
    private final View.OnClickListener gWY;
    private CustomMessageListener gWo;
    public ThreadViewAndCommentInfoLayout gXL;
    private final String gXM;
    private final String gXN;
    private TextView gXO;
    private LinearLayout gXP;
    private TextView gXQ;
    private TextView gXR;
    private TextView gXS;
    private TextView gXT;
    private ImageView gXU;
    private p gXV;
    private View gXW;
    private TbImageView gXX;
    private ImageView gXY;
    private LinearLayout gXZ;
    private CardPersonDynamicThreadData gXw;
    private TextView gYa;
    private LinearLayout gYb;
    private LinearLayout gYc;
    private TextView gYd;
    private TBLottieAnimationView gYe;
    private TextView gYf;
    private TextView gYg;
    public OriginalThreadCardView gYh;
    private View gYi;
    private View gYj;
    private boolean gYk;
    private boolean gYl;
    com.baidu.tieba.view.g gYm;
    private p.a gYn;
    private final View.OnClickListener gYo;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gXM = "1";
        this.gXN = "2";
        this.mSkinType = 3;
        this.aib = true;
        this.gYm = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.gXw != null && !StringUtils.isNull(q.this.gXw.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.gXw.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.gWX = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bRn() != null) {
                    q.this.bRn().a(view, q.this.gXw);
                }
                if (q.this.gXw.haM != 60) {
                    if ((q.this.gXw.haM != 40 || q.this.gXw.haO != 2) && !q.this.gYl) {
                        q.this.bgS();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).aYR();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.gXw.dLK.aWF().live_status != 1) {
                    q.this.bRJ();
                } else {
                    q.this.bRI();
                }
            }
        };
        this.gWo = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.gXw != null && q.this.gXw.threadId != null && q.this.mTitle != null && q.this.aeq != null && ((String) customResponsedMessage.getData()).equals(q.this.gXw.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.gXw.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                    m.a(q.this.aeq, q.this.gXw.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
                }
            }
        };
        this.gYn = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.mG(z);
            }
        };
        this.gYo = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bRn = q.this.bRn();
                if (bRn != null) {
                    view.setTag("1");
                    bRn.a(view, q.this.gXw);
                }
                q.this.bgS();
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bRn = q.this.bRn();
                if (bRn != null) {
                    view.setTag("2");
                    bRn.a(view, q.this.gXw);
                }
            }
        };
        this.eRz = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.gXX != null) {
                    q.this.gXX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.gXO = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.gXP = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.gXQ = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.gXR = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.gXS = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.gYg = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.gXT = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.gXU = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.aio = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.aio.setAfterClickListener(this.gWY);
        this.aeq = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.aeq.setVisibility(8);
        this.gWS = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.gWS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gWS.setChildClickListener(this.gYo);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.gWS.setImageProcessor(aVar);
        this.gXW = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.gXX = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.gXY = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.gXL = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.gYc = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.ajE = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.ajC = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.gYd = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.gYe = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gYe.loop(true);
        ao.a(this.gYe, R.raw.ala_play);
        this.gYf = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.gXZ = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.gYa = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.gYb = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.gYb.setVisibility(8);
        this.gYh = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.gYi = this.mRootView.findViewById(R.id.divider_line_thick);
        this.gYj = this.mRootView.findViewById(R.id.divider_line_thin);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.fXb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fXb.setLayoutParams(layoutParams);
        }
        this.fXb.setOnClickListener(this.gWX);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setShareVisible(true);
        this.fXb.setIsBarViewVisible(false);
        this.fXb.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 8;
        cVar.dNH = 3;
        this.fXb.setAgreeStatisticData(cVar);
        this.fXb.setShareReportFrom(6);
        this.fXb.setStType("person_page");
        this.fXb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bRn() != null) {
                    q.this.bRn().a(view, q.this.gXw);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.a(this.gYe, R.raw.ala_play);
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setViewTextColor(this.gXO, R.color.cp_cont_b);
            ao.setViewTextColor(this.gXQ, R.color.cp_cont_j);
            ao.setViewTextColor(this.gXR, R.color.cp_cont_b);
            ao.setViewTextColor(this.gXS, R.color.cp_cont_d);
            ao.setViewTextColor(this.gYg, R.color.cp_cont_d);
            ao.setViewTextColor(this.gXT, R.color.cp_cont_d);
            if (this.gXU != null) {
                this.gXU.setImageDrawable(SvgManager.baR().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ao.setViewTextColor(this.aeq, R.color.cp_cont_f);
            ao.setViewTextColor(this.gYa, R.color.cp_cont_f);
            if (this.gXV != null) {
                this.gXV.onChangeSkinType();
            }
            this.gXL.onChangeSkinType();
            this.fXb.onChangeSkinType();
            ao.setBackgroundColor(this.gYi, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.gYj, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.gYa, R.color.cp_bg_line_e);
            if (this.gYh != null) {
                this.gYh.onChangeSkinType();
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
        this.gXw = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gWX);
        }
        this.gXO.setVisibility(cardPersonDynamicThreadData.haY ? 0 : 8);
        this.gXP.setVisibility(cardPersonDynamicThreadData.haX ? 0 : 4);
        this.gYi.setVisibility(cardPersonDynamicThreadData.haX ? 0 : 8);
        this.gYj.setVisibility(cardPersonDynamicThreadData.haX ? 8 : 0);
        if (cardPersonDynamicThreadData.haZ) {
            this.gYi.setVisibility(8);
            this.gYj.setVisibility(8);
        }
        this.gYk = cardPersonDynamicThreadData.haM == 40 && cardPersonDynamicThreadData.haO == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dLK != null) {
            this.gYl = cardPersonDynamicThreadData.dLK.isShareThread && cardPersonDynamicThreadData.haO == 2;
        }
        this.gXO.setText(cardPersonDynamicThreadData.haP);
        this.gXQ.setText(cardPersonDynamicThreadData.haQ);
        this.gXR.setText(cardPersonDynamicThreadData.haR);
        if (cardPersonDynamicThreadData.haW != null && cardPersonDynamicThreadData.haW.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.haW.length; i++) {
                sb.append(as.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.haW[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.haW.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.gXS.setText(sb2);
                this.gXS.setVisibility(0);
            } else {
                this.gXS.setText(R.string.person_homepage);
            }
        } else {
            this.gXS.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.gXT.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.gXT.setVisibility(0);
            }
            mG(cardPersonDynamicThreadData.isPrivacy);
            this.gXU.setVisibility(0);
            this.gXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.gXV == null) {
                            q.this.gXV = new p(q.this.mPageContext);
                            q.this.gXV.create();
                            q.this.gXV.a(q.this.gYn);
                        }
                        q.this.gXV.a(q.this.gXw);
                        q.this.gXV.show();
                    }
                }
            });
        } else {
            this.gXT.setVisibility(8);
            this.gXU.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.haU;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.aio.setVisibility(0);
            mF(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.aio.setVoiceModel(voiceModel);
            this.aio.setTag(voiceModel);
            this.aio.changeSkin();
            if (voiceModel != null) {
                this.aio.zt(voiceModel.voice_status.intValue());
            }
            this.aio.bFz();
        } else {
            this.aio.setVisibility(8);
            mF(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.haT;
        ao.setBackgroundResource(this.gXZ, R.color.transparent);
        this.gYa.setVisibility(8);
        this.gYb.setVisibility(8);
        this.gXZ.setVisibility(0);
        this.gXW.setVisibility(8);
        this.gYf.setVisibility(8);
        this.gYc.setVisibility(8);
        this.gYd.setVisibility(8);
        this.gYe.cancelAnimation();
        this.gYe.setVisibility(8);
        if (cardPersonDynamicThreadData.haM == 36) {
            this.gWS.setVisibility(8);
        } else if (cardPersonDynamicThreadData.haM == 40 || this.gXw.haM == 50) {
            this.gWS.setVisibility(8);
            if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
                this.gXW.setVisibility(0);
                this.gXY.setVisibility(0);
                this.gXY.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gXW.getLayoutParams();
                int width = this.gXW.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.gXW.setLayoutParams(layoutParams);
                if (this.gXw.videoInfo != null) {
                    this.gXX.setDefaultErrorResource(0);
                    this.gXX.setPlaceHolder(3);
                    this.gXX.setEvent(this.eRz);
                    this.gXX.startLoad(this.gXw.videoInfo.thumbnail_url, 17, false);
                    if (this.gYk) {
                        this.gYf.setVisibility(0);
                        this.gYf.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.gYc.setVisibility(0);
                        this.ajE.setText(as.stringForVideoTime(this.gXw.videoInfo.video_duration.intValue() * 1000));
                        this.ajC.setText(String.format(this.mContext.getResources().getString(R.string.play_count), as.numFormatOverWan(this.gXw.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.gXw.haM == 60 || this.gXw.haM == 49) {
            this.gWS.setVisibility(8);
            if (this.gXw.dLK.aWF() != null && this.gXw.dLK.aWF().user_info != null && this.gXw.haM == 60) {
                String str = this.gXw.dLK.aWF().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.gYa.setText(m.dV(str + ":", this.gXw.dLK.getTitle()));
                this.gYa.setVisibility(0);
            } else {
                this.gYa.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
                this.gXW.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gXW.getLayoutParams();
                int width2 = this.gXW.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.gXW.setLayoutParams(layoutParams2);
                if (this.gXw.dLK.aWF() != null) {
                    this.gXX.setDefaultErrorResource(0);
                    this.gXX.setPlaceHolder(3);
                    this.gXX.setEvent(this.eRz);
                    this.gXX.startLoad(cardPersonDynamicThreadData.dLK.aWF().cover, 10, false);
                    this.gXY.setVisibility(8);
                    this.gYe.setVisibility(0);
                    this.gYe.playAnimation();
                    ao.setBackgroundResource(this.gXZ, R.color.cp_bg_line_e);
                    this.gYd.setVisibility(0);
                    this.gYd.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), as.numFormatOverWan(this.gXw.dLK.aWF().audience_count)));
                    this.fXb.getCommentContainer().setOnClickListener(this.gWX);
                } else {
                    this.fXb.getCommentContainer().setOnClickListener(this.fXb);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.aTv().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bv bvVar = cardPersonDynamicThreadData.dLK;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(linkedList) > 0) {
                    this.gWS.setVisibility(0);
                    this.gWS.setFromCDN(this.aib);
                    this.gWS.setSingleImageRatio(0.67d);
                    this.gWS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bgS();
                            } else {
                                q.this.a(view, linkedList, i2, bvVar);
                            }
                        }
                    });
                    this.gWS.setImageMediaList(linkedList);
                } else {
                    this.gWS.setVisibility(8);
                }
            } else {
                this.gWS.setVisibility(8);
            }
            this.gXZ.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dLK != null && cardPersonDynamicThreadData.dLK.dUi != null) {
            this.gYh.setVisibility(0);
            this.gYh.b(cardPersonDynamicThreadData.dLK.dUi);
            this.gYh.setOnClickListener(this);
            this.aio.setVisibility(8);
            this.gWS.setVisibility(8);
            this.gXZ.setVisibility(8);
            if (this.gYl) {
                this.gYg.setVisibility(0);
            } else {
                this.gYg.setVisibility(8);
            }
        } else {
            this.gYh.setVisibility(8);
            this.gYg.setVisibility(8);
        }
        bRF();
        c(cardPersonDynamicThreadData);
    }

    private void mF(boolean z) {
        if (this.gWS != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gWS.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.gWS.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.gYk || this.gYl) {
                this.fXb.setCommentClickable(false);
                this.fXb.setAgreeClickable(false);
                this.fXb.setShareClickable(false);
                this.gYh.setClickable(false);
                this.gXU.setClickable(false);
            } else {
                this.fXb.setCommentClickable(true);
                this.fXb.setAgreeClickable(true);
                this.fXb.setShareClickable(true);
                this.gYh.setClickable(true);
                this.gXU.setClickable(true);
            }
            this.fXb.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.haM == 60) {
                this.fXb.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.haW != null) {
                this.fXb.setMultiForumCount(cardPersonDynamicThreadData.haW.length);
            }
            if (cardPersonDynamicThreadData.dLK != null) {
                this.fXb.setForumId(String.valueOf(cardPersonDynamicThreadData.dLK.getFid()));
            }
            this.fXb.setData(cardPersonDynamicThreadData.dLK);
        }
    }

    private void bRF() {
        this.aio.setClickable(true);
        int childCount = this.gWS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gWS.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bRI() {
        if (this.gXw != null && this.gXw.dLK != null && this.gXw.dLK.aWF() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Ez(this.gXw.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.gXw.dLK.aWF());
            if (this.gXw.dLK.aWF().user_info != null) {
                alaLiveInfoCoreData.userName = this.gXw.dLK.aWF().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRJ() {
        if (this.gXw != null && this.gXw.dLK != null && this.gXw.dLK.aWF() != null && this.gXw.dLK.aWF().share_info != null) {
            if (!isHost()) {
                m.Ez(this.gXw.threadId);
            }
            if (this.gXw.dLK.aWF().share_info.record_tid <= 0) {
                bRI();
                return;
            }
            String valueOf = String.valueOf(this.gXw.dLK.aWF().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.gXw.dLK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgS() {
        if (this.gXw != null) {
            if (!isHost()) {
                m.Ez(this.gXw.threadId);
                m.a(this.mTitle, this.gXw.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.aeq, this.gXw.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.gXw.haM == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.gXw.dLK, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.gXw.dLK.getFid()));
            pbActivityConfig.setForumName(this.gXw.dLK.aWp());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.gXw.dLK.isShareThread);
            pbActivityConfig.setThreadData(this.gXw.dLK);
            pbActivityConfig.setIsPrivacy(this.gXw.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.gXw.dLK == null || !this.gXw.dLK.isShareThread) {
                return;
            }
            TiebaStatic.log(new ap("c12943").dn("obj_type", "2").dn("tid", this.gXw.threadId).ah("obj_param1", this.gXw.isHost ? 1 : 2));
        }
    }

    private void bRK() {
        if (this.gXw != null && this.gXw.dLK != null && this.gXw.dLK.dUi != null) {
            OriginalThreadInfo originalThreadInfo = this.gXw.dLK.dUi;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ap("c12943").dn("obj_type", "3").dn("tid", this.gXw.threadId).ah("obj_param1", this.gXw.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG(boolean z) {
        if (this.gXT != null) {
            if (z) {
                this.gXT.setText(R.string.privacy);
                Drawable drawable = ao.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.gXT.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.gXT.setText(R.string.public_open);
            Drawable drawable2 = ao.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.gXT.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.gXw.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gYh) {
            bRK();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gWS != null) {
            this.gWS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gWS != null) {
            this.gWS.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bv bvVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aib ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bvVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.s(arrayList).kG(i).wE(bvVar.aWp()).wF(String.valueOf(bvVar.getFid())).wG(bvVar.getTid()).hl(this.aib).wH(arrayList.size() > 0 ? arrayList.get(0) : "").hm(true).a(concurrentHashMap).hn(true).r(bvVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dI = aVar.dI(this.mPageContext.getPageActivity());
        dI.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dLK == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.dLK.d(false, true, this.gYk);
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
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
        return true;
    }
}
