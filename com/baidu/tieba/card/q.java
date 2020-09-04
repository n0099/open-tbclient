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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private TextView afB;
    public PlayVoiceBntNew ajF;
    private boolean ajt;
    private TextView akT;
    private TextView akV;
    private TbImageView.a fcj;
    public ThreadCommentAndPraiseInfoLayout gje;
    private ConstrainImageGroup hjP;
    private View.OnClickListener hjU;
    private final View.OnClickListener hjV;
    private CustomMessageListener hjl;
    public ThreadViewAndCommentInfoLayout hkI;
    private final String hkJ;
    private final String hkK;
    private TextView hkL;
    private LinearLayout hkM;
    private TextView hkN;
    private TextView hkO;
    private TextView hkP;
    private TextView hkQ;
    private ImageView hkR;
    private p hkS;
    private View hkT;
    private TbImageView hkU;
    private ImageView hkV;
    private LinearLayout hkW;
    private TextView hkX;
    private LinearLayout hkY;
    private LinearLayout hkZ;
    private CardPersonDynamicThreadData hkt;
    private TextView hla;
    private TBLottieAnimationView hlb;
    private TextView hlc;
    private TextView hld;
    public OriginalThreadCardView hle;
    private View hlf;
    private View hlg;
    private boolean hlh;
    private boolean hli;
    com.baidu.tieba.view.g hlj;
    private p.a hlk;
    private final View.OnClickListener hll;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hkJ = "1";
        this.hkK = "2";
        this.mSkinType = 3;
        this.ajt = true;
        this.hlj = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.hkt != null && !StringUtils.isNull(q.this.hkt.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.hkt.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.hjU = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cbA() != null) {
                    q.this.cbA().a(view, q.this.hkt);
                }
                if (q.this.hkt.hnH != 60) {
                    if ((q.this.hkt.hnH != 40 || q.this.hkt.hnJ != 2) && !q.this.hli) {
                        q.this.bpF();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).bhm();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.hkt.dUW.beY().live_status != 1) {
                    q.this.cbW();
                } else {
                    q.this.cbV();
                }
            }
        };
        this.hjl = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.hkt != null && q.this.hkt.threadId != null && q.this.mTitle != null && q.this.afB != null && ((String) customResponsedMessage.getData()).equals(q.this.hkt.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.hkt.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    m.a(q.this.afB, q.this.hkt.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.hlk = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.nl(z);
            }
        };
        this.hll = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cbA = q.this.cbA();
                if (cbA != null) {
                    view.setTag("1");
                    cbA.a(view, q.this.hkt);
                }
                q.this.bpF();
            }
        };
        this.hjV = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cbA = q.this.cbA();
                if (cbA != null) {
                    view.setTag("2");
                    cbA.a(view, q.this.hkt);
                }
            }
        };
        this.fcj = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.hkU != null) {
                    q.this.hkU.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hkL = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hkM = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hkN = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hkO = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hkP = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hld = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hkQ = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hkR = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.ajF = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.ajF.setAfterClickListener(this.hjV);
        this.afB = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.afB.setVisibility(8);
        this.hjP = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hjP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hjP.setChildClickListener(this.hll);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.u(1.0d);
        this.hjP.setImageProcessor(aVar);
        this.hkT = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hkU = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hkV = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hkI = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hkZ = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.akV = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.akT = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hla = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hlb = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hlb.loop(true);
        ap.a(this.hlb, (int) R.raw.ala_play);
        this.hlc = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hkW = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hkX = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hkY = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hkY.setVisibility(8);
        this.hle = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hlf = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hlg = this.mRootView.findViewById(R.id.divider_line_thin);
        this.gje = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.gje.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gje.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gje.setLayoutParams(layoutParams);
        }
        this.gje.setOnClickListener(this.hjU);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setShareVisible(true);
        this.gje.setIsBarViewVisible(false);
        this.gje.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWO = 8;
        cVar.dWU = 3;
        this.gje.setAgreeStatisticData(cVar);
        this.gje.setShareReportFrom(6);
        this.gje.setStType("person_page");
        this.gje.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cbA() != null) {
                    q.this.cbA().a(view, q.this.hkt);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hlb, (int) R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hkL, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.hkN, (int) R.color.cp_cont_j);
            ap.setViewTextColor(this.hkO, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.hkP, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.hld, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.hkQ, (int) R.color.cp_cont_d);
            if (this.hkR != null) {
                this.hkR.setImageDrawable(SvgManager.bjq().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.afB, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.hkX, (int) R.color.cp_cont_f);
            if (this.hkS != null) {
                this.hkS.onChangeSkinType();
            }
            this.hkI.onChangeSkinType();
            this.gje.onChangeSkinType();
            ap.setBackgroundColor(this.hlf, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hlg, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.hkX, R.color.cp_bg_line_e);
            if (this.hle != null) {
                this.hle.onChangeSkinType();
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
        this.hkt = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hjU);
        }
        this.hkL.setVisibility(cardPersonDynamicThreadData.hnT ? 0 : 8);
        this.hkM.setVisibility(cardPersonDynamicThreadData.hnS ? 0 : 4);
        this.hlf.setVisibility(cardPersonDynamicThreadData.hnS ? 0 : 8);
        this.hlg.setVisibility(cardPersonDynamicThreadData.hnS ? 8 : 0);
        if (cardPersonDynamicThreadData.hnU) {
            this.hlf.setVisibility(8);
            this.hlg.setVisibility(8);
        }
        this.hlh = cardPersonDynamicThreadData.hnH == 40 && cardPersonDynamicThreadData.hnJ == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dUW != null) {
            this.hli = cardPersonDynamicThreadData.dUW.isShareThread && cardPersonDynamicThreadData.hnJ == 2;
        }
        this.hkL.setText(cardPersonDynamicThreadData.hnK);
        this.hkN.setText(cardPersonDynamicThreadData.hnL);
        this.hkO.setText(cardPersonDynamicThreadData.hnM);
        if (cardPersonDynamicThreadData.hnR != null && cardPersonDynamicThreadData.hnR.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.hnR.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.hnR[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.hnR.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hkP.setText(sb2);
                this.hkP.setVisibility(0);
            } else {
                this.hkP.setText(R.string.person_homepage);
            }
        } else {
            this.hkP.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hkQ.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hkQ.setVisibility(0);
            }
            nl(cardPersonDynamicThreadData.isPrivacy);
            this.hkR.setVisibility(0);
            this.hkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.hkS == null) {
                            q.this.hkS = new p(q.this.mPageContext);
                            q.this.hkS.create();
                            q.this.hkS.a(q.this.hlk);
                        }
                        q.this.hkS.a(q.this.hkt);
                        q.this.hkS.show();
                    }
                }
            });
        } else {
            this.hkQ.setVisibility(8);
            this.hkR.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.hnP;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.ajF.setVisibility(0);
            nk(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.ajF.setVoiceModel(voiceModel);
            this.ajF.setTag(voiceModel);
            this.ajF.changeSkin();
            if (voiceModel != null) {
                this.ajF.BM(voiceModel.voice_status.intValue());
            }
            this.ajF.bPf();
        } else {
            this.ajF.setVisibility(8);
            nk(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.hnO;
        ap.setBackgroundResource(this.hkW, R.color.transparent);
        this.hkX.setVisibility(8);
        this.hkY.setVisibility(8);
        this.hkW.setVisibility(0);
        this.hkT.setVisibility(8);
        this.hlc.setVisibility(8);
        this.hkZ.setVisibility(8);
        this.hla.setVisibility(8);
        this.hlb.cancelAnimation();
        this.hlb.setVisibility(8);
        if (cardPersonDynamicThreadData.hnH == 36) {
            this.hjP.setVisibility(8);
        } else if (cardPersonDynamicThreadData.hnH == 40 || this.hkt.hnH == 50) {
            this.hjP.setVisibility(8);
            if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
                this.hkT.setVisibility(0);
                this.hkV.setVisibility(0);
                this.hkV.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hkT.getLayoutParams();
                int width = this.hkT.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hkT.setLayoutParams(layoutParams);
                if (this.hkt.videoInfo != null) {
                    this.hkU.setDefaultErrorResource(0);
                    this.hkU.setPlaceHolder(3);
                    this.hkU.setEvent(this.fcj);
                    this.hkU.startLoad(this.hkt.videoInfo.thumbnail_url, 17, false);
                    if (this.hlh) {
                        this.hlc.setVisibility(0);
                        this.hlc.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hkZ.setVisibility(0);
                        this.akV.setText(at.stringForVideoTime(this.hkt.videoInfo.video_duration.intValue() * 1000));
                        this.akT.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hkt.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hkt.hnH == 60 || this.hkt.hnH == 49) {
            this.hjP.setVisibility(8);
            if (this.hkt.dUW.beY() != null && this.hkt.dUW.beY().user_info != null && this.hkt.hnH == 60) {
                String str = this.hkt.dUW.beY().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hkX.setText(m.en(str + ":", this.hkt.dUW.getTitle()));
                this.hkX.setVisibility(0);
            } else {
                this.hkX.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
                this.hkT.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hkT.getLayoutParams();
                int width2 = this.hkT.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hkT.setLayoutParams(layoutParams2);
                if (this.hkt.dUW.beY() != null) {
                    this.hkU.setDefaultErrorResource(0);
                    this.hkU.setPlaceHolder(3);
                    this.hkU.setEvent(this.fcj);
                    this.hkU.startLoad(cardPersonDynamicThreadData.dUW.beY().cover, 10, false);
                    this.hkV.setVisibility(8);
                    this.hlb.setVisibility(0);
                    this.hlb.playAnimation();
                    ap.setBackgroundResource(this.hkW, R.color.cp_bg_line_e);
                    this.hla.setVisibility(0);
                    this.hla.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.hkt.dUW.beY().audience_count)));
                    this.gje.getCommentContainer().setOnClickListener(this.hjU);
                } else {
                    this.gje.getCommentContainer().setOnClickListener(this.gje);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bbM().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bw bwVar = cardPersonDynamicThreadData.dUW;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hjP.setVisibility(0);
                    this.hjP.setFromCDN(this.ajt);
                    this.hjP.setSingleImageRatio(0.67d);
                    this.hjP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bpF();
                            } else {
                                q.this.a(view, linkedList, i2, bwVar);
                            }
                        }
                    });
                    this.hjP.setImageMediaList(linkedList);
                } else {
                    this.hjP.setVisibility(8);
                }
            } else {
                this.hjP.setVisibility(8);
            }
            this.hkW.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dUW != null && cardPersonDynamicThreadData.dUW.edI != null) {
            this.hle.setVisibility(0);
            this.hle.b(cardPersonDynamicThreadData.dUW.edI);
            this.hle.setOnClickListener(this);
            this.ajF.setVisibility(8);
            this.hjP.setVisibility(8);
            this.hkW.setVisibility(8);
            if (this.hli) {
                this.hld.setVisibility(0);
            } else {
                this.hld.setVisibility(8);
            }
        } else {
            this.hle.setVisibility(8);
            this.hld.setVisibility(8);
        }
        cbS();
        c(cardPersonDynamicThreadData);
    }

    private void nk(boolean z) {
        if (this.hjP != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjP.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hjP.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hlh || this.hli) {
                this.gje.setCommentClickable(false);
                this.gje.setAgreeClickable(false);
                this.gje.setShareClickable(false);
                this.hle.setClickable(false);
                this.hkR.setClickable(false);
            } else {
                this.gje.setCommentClickable(true);
                this.gje.setAgreeClickable(true);
                this.gje.setShareClickable(true);
                this.hle.setClickable(true);
                this.hkR.setClickable(true);
            }
            this.gje.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.hnH == 60) {
                this.gje.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.hnR != null) {
                this.gje.setMultiForumCount(cardPersonDynamicThreadData.hnR.length);
            }
            if (cardPersonDynamicThreadData.dUW != null) {
                this.gje.setForumId(String.valueOf(cardPersonDynamicThreadData.dUW.getFid()));
            }
            this.gje.setData(cardPersonDynamicThreadData.dUW);
        }
    }

    private void cbS() {
        this.ajF.setClickable(true);
        int childCount = this.hjP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hjP.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void cbV() {
        if (this.hkt != null && this.hkt.dUW != null && this.hkt.dUW.beY() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.GZ(this.hkt.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hkt.dUW.beY());
            if (this.hkt.dUW.beY().user_info != null) {
                alaLiveInfoCoreData.userName = this.hkt.dUW.beY().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbW() {
        if (this.hkt != null && this.hkt.dUW != null && this.hkt.dUW.beY() != null && this.hkt.dUW.beY().share_info != null) {
            if (!isHost()) {
                m.GZ(this.hkt.threadId);
            }
            if (this.hkt.dUW.beY().share_info.record_tid <= 0) {
                cbV();
                return;
            }
            String valueOf = String.valueOf(this.hkt.dUW.beY().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hkt.dUW);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpF() {
        if (this.hkt != null) {
            if (!isHost()) {
                m.GZ(this.hkt.threadId);
                m.a(this.mTitle, this.hkt.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.afB, this.hkt.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hkt.hnH == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hkt.dUW, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hkt.dUW.getFid()));
            pbActivityConfig.setForumName(this.hkt.dUW.beI());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hkt.dUW.isShareThread);
            pbActivityConfig.setThreadData(this.hkt.dUW);
            pbActivityConfig.setIsPrivacy(this.hkt.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hkt.dUW == null || !this.hkt.dUW.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dD("obj_type", "2").dD("tid", this.hkt.threadId).ai("obj_param1", this.hkt.isHost ? 1 : 2));
        }
    }

    private void cbX() {
        if (this.hkt != null && this.hkt.dUW != null && this.hkt.dUW.edI != null) {
            OriginalThreadInfo originalThreadInfo = this.hkt.dUW.edI;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dD("obj_type", "3").dD("tid", this.hkt.threadId).ai("obj_param1", this.hkt.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(boolean z) {
        if (this.hkQ != null) {
            if (z) {
                this.hkQ.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hkQ.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hkQ.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hkQ.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hkt.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hle) {
            cbX();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjP != null) {
            this.hjP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjP != null) {
            this.hjP.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                imageUrlData.urlType = this.ajt ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).mM(i).yQ(bwVar.beI()).yR(String.valueOf(bwVar.getFid())).yS(bwVar.getTid()).hI(this.ajt).yT(arrayList.size() > 0 ? arrayList.get(0) : "").hJ(true).a(concurrentHashMap).hK(true).r(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dP = aVar.dP(this.mPageContext.getPageActivity());
        dP.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dUW == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.dUW.e(false, true, this.hlh);
        if (e == null || StringUtils.isNull(e.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(e));
        this.mTitle.setText(e);
        if (isHost()) {
            return true;
        }
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
