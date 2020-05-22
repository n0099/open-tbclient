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
    private TbImageView.a eBj;
    public ThreadCommentAndPraiseInfoLayout fGo;
    private CustomMessageListener gDH;
    private CardPersonDynamicThreadData gEQ;
    private ConstrainImageGroup gEm;
    private View.OnClickListener gEr;
    private final View.OnClickListener gEs;
    private View gFA;
    private boolean gFB;
    private boolean gFC;
    com.baidu.tieba.view.g gFD;
    private p.a gFE;
    private final View.OnClickListener gFF;
    public ThreadViewAndCommentInfoLayout gFc;
    private final String gFd;
    private final String gFe;
    private TextView gFf;
    private LinearLayout gFg;
    private TextView gFh;
    private TextView gFi;
    private TextView gFj;
    private TextView gFk;
    private ImageView gFl;
    private p gFm;
    private View gFn;
    private TbImageView gFo;
    private ImageView gFp;
    private LinearLayout gFq;
    private TextView gFr;
    private LinearLayout gFs;
    private LinearLayout gFt;
    private TextView gFu;
    private TBLottieAnimationView gFv;
    private TextView gFw;
    private TextView gFx;
    public OriginalThreadCardView gFy;
    private View gFz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gFd = "1";
        this.gFe = "2";
        this.mSkinType = 3;
        this.aha = true;
        this.gFD = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.gEQ != null && !StringUtils.isNull(q.this.gEQ.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.gEQ.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.gEr = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bKS() != null) {
                    q.this.bKS().a(view, q.this.gEQ);
                }
                if (q.this.gEQ.gHX != 60) {
                    if ((q.this.gEQ.gHX != 40 || q.this.gEQ.gHZ != 2) && !q.this.gFC) {
                        q.this.bbi();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aSY();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.gEQ.dEA.aQS().live_status != 1) {
                    q.this.bLo();
                } else {
                    q.this.bLn();
                }
            }
        };
        this.gDH = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.gEQ != null && q.this.gEQ.threadId != null && q.this.mTitle != null && q.this.adV != null && ((String) customResponsedMessage.getData()).equals(q.this.gEQ.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.gEQ.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    m.a(q.this.adV, q.this.gEQ.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.gFE = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.lS(z);
            }
        };
        this.gFF = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bKS = q.this.bKS();
                if (bKS != null) {
                    view.setTag("1");
                    bKS.a(view, q.this.gEQ);
                }
                q.this.bbi();
            }
        };
        this.gEs = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> bKS = q.this.bKS();
                if (bKS != null) {
                    view.setTag("2");
                    bKS.a(view, q.this.gEQ);
                }
            }
        };
        this.eBj = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.gFo != null) {
                    q.this.gFo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.gFf = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.gFg = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.gFh = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.gFi = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.gFj = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.gFx = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.gFk = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.gFl = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.ahm = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.ahm.setAfterClickListener(this.gEs);
        this.adV = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.adV.setVisibility(8);
        this.gEm = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.gEm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gEm.setChildClickListener(this.gFF);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.gEm.setImageProcessor(aVar);
        this.gFn = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.gFo = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.gFp = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.gFc = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.gFt = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.ain = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.ail = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.gFu = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.gFv = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gFv.loop(true);
        am.a(this.gFv, (int) R.raw.ala_play);
        this.gFw = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.gFq = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.gFr = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.gFs = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.gFs.setVisibility(8);
        this.gFy = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.gFz = this.mRootView.findViewById(R.id.divider_line_thick);
        this.gFA = this.mRootView.findViewById(R.id.divider_line_thin);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.fGo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGo.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGo.setLayoutParams(layoutParams);
        }
        this.fGo.setOnClickListener(this.gEr);
        this.fGo.setReplyTimeVisible(false);
        this.fGo.setShowPraiseNum(true);
        this.fGo.setNeedAddPraiseIcon(true);
        this.fGo.setNeedAddReplyIcon(true);
        this.fGo.setShareVisible(true);
        this.fGo.setIsBarViewVisible(false);
        this.fGo.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 8;
        cVar.dBf = 3;
        this.fGo.setAgreeStatisticData(cVar);
        this.fGo.setShareReportFrom(6);
        this.fGo.setStType("person_page");
        this.fGo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.bKS() != null) {
                    q.this.bKS().a(view, q.this.gEQ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.gFv, (int) R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gFf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gFh, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.gFi, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gFj, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gFx, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gFk, (int) R.color.cp_cont_d);
            if (this.gFl != null) {
                this.gFl.setImageDrawable(SvgManager.aUV().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adV, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gFr, (int) R.color.cp_cont_f);
            if (this.gFm != null) {
                this.gFm.onChangeSkinType();
            }
            this.gFc.onChangeSkinType();
            this.fGo.onChangeSkinType();
            am.setBackgroundColor(this.gFz, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gFA, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gFr, R.color.cp_bg_line_e);
            if (this.gFy != null) {
                this.gFy.onChangeSkinType();
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
        this.gEQ = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gEr);
        }
        this.gFf.setVisibility(cardPersonDynamicThreadData.gIj ? 0 : 8);
        this.gFg.setVisibility(cardPersonDynamicThreadData.gIi ? 0 : 4);
        this.gFz.setVisibility(cardPersonDynamicThreadData.gIi ? 0 : 8);
        this.gFA.setVisibility(cardPersonDynamicThreadData.gIi ? 8 : 0);
        if (cardPersonDynamicThreadData.gIk) {
            this.gFz.setVisibility(8);
            this.gFA.setVisibility(8);
        }
        this.gFB = cardPersonDynamicThreadData.gHX == 40 && cardPersonDynamicThreadData.gHZ == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dEA != null) {
            this.gFC = cardPersonDynamicThreadData.dEA.isShareThread && cardPersonDynamicThreadData.gHZ == 2;
        }
        this.gFf.setText(cardPersonDynamicThreadData.gIa);
        this.gFh.setText(cardPersonDynamicThreadData.gIb);
        this.gFi.setText(cardPersonDynamicThreadData.gIc);
        if (cardPersonDynamicThreadData.gIh != null && cardPersonDynamicThreadData.gIh.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.gIh.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.gIh[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.gIh.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.gFj.setText(sb2);
                this.gFj.setVisibility(0);
            } else {
                this.gFj.setText(R.string.person_homepage);
            }
        } else {
            this.gFj.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.gFk.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.gFk.setVisibility(0);
            }
            lS(cardPersonDynamicThreadData.isPrivacy);
            this.gFl.setVisibility(0);
            this.gFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.gFm == null) {
                            q.this.gFm = new p(q.this.mPageContext);
                            q.this.gFm.create();
                            q.this.gFm.a(q.this.gFE);
                        }
                        q.this.gFm.a(q.this.gEQ);
                        q.this.gFm.show();
                    }
                }
            });
        } else {
            this.gFk.setVisibility(8);
            this.gFl.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.gIf;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.ahm.setVisibility(0);
            lR(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.ahm.setVoiceModel(voiceModel);
            this.ahm.setTag(voiceModel);
            this.ahm.crm();
            if (voiceModel != null) {
                this.ahm.yi(voiceModel.voice_status.intValue());
            }
            this.ahm.deL();
        } else {
            this.ahm.setVisibility(8);
            lR(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.gIe;
        am.setBackgroundResource(this.gFq, R.color.transparent);
        this.gFr.setVisibility(8);
        this.gFs.setVisibility(8);
        this.gFq.setVisibility(0);
        this.gFn.setVisibility(8);
        this.gFw.setVisibility(8);
        this.gFt.setVisibility(8);
        this.gFu.setVisibility(8);
        this.gFv.cancelAnimation();
        this.gFv.setVisibility(8);
        if (cardPersonDynamicThreadData.gHX == 36) {
            this.gEm.setVisibility(8);
        } else if (cardPersonDynamicThreadData.gHX == 40 || this.gEQ.gHX == 50) {
            this.gEm.setVisibility(8);
            if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                this.gFn.setVisibility(0);
                this.gFp.setVisibility(0);
                this.gFp.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFn.getLayoutParams();
                int width = this.gFn.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.gFn.setLayoutParams(layoutParams);
                if (this.gEQ.videoInfo != null) {
                    this.gFo.setDefaultErrorResource(0);
                    this.gFo.setPlaceHolder(3);
                    this.gFo.setEvent(this.eBj);
                    this.gFo.startLoad(this.gEQ.videoInfo.thumbnail_url, 17, false);
                    if (this.gFB) {
                        this.gFw.setVisibility(0);
                        this.gFw.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.gFt.setVisibility(0);
                        this.ain.setText(aq.stringForVideoTime(this.gEQ.videoInfo.video_duration.intValue() * 1000));
                        this.ail.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.gEQ.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.gEQ.gHX == 60 || this.gEQ.gHX == 49) {
            this.gEm.setVisibility(8);
            if (this.gEQ.dEA.aQS() != null && this.gEQ.dEA.aQS().user_info != null && this.gEQ.gHX == 60) {
                String str = this.gEQ.dEA.aQS().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.gFr.setText(m.dO(str + ":", this.gEQ.dEA.getTitle()));
                this.gFr.setVisibility(0);
            } else {
                this.gFr.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                this.gFn.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gFn.getLayoutParams();
                int width2 = this.gFn.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.gFn.setLayoutParams(layoutParams2);
                if (this.gEQ.dEA.aQS() != null) {
                    this.gFo.setDefaultErrorResource(0);
                    this.gFo.setPlaceHolder(3);
                    this.gFo.setEvent(this.eBj);
                    this.gFo.startLoad(cardPersonDynamicThreadData.dEA.aQS().cover, 10, false);
                    this.gFp.setVisibility(8);
                    this.gFv.setVisibility(0);
                    this.gFv.playAnimation();
                    am.setBackgroundResource(this.gFq, R.color.cp_bg_line_e);
                    this.gFu.setVisibility(0);
                    this.gFu.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.gEQ.dEA.aQS().audience_count)));
                    this.fGo.getCommentContainer().setOnClickListener(this.gEr);
                } else {
                    this.fGo.getCommentContainer().setOnClickListener(this.fGo);
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
                    this.gEm.setVisibility(0);
                    this.gEm.setFromCDN(this.aha);
                    this.gEm.setSingleImageRatio(0.67d);
                    this.gEm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bbi();
                            } else {
                                q.this.a(view, linkedList, i2, bkVar);
                            }
                        }
                    });
                    this.gEm.setImageMediaList(linkedList);
                } else {
                    this.gEm.setVisibility(8);
                }
            } else {
                this.gEm.setVisibility(8);
            }
            this.gFq.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dEA != null && cardPersonDynamicThreadData.dEA.dHm != null) {
            this.gFy.setVisibility(0);
            this.gFy.b(cardPersonDynamicThreadData.dEA.dHm);
            this.gFy.setOnClickListener(this);
            this.ahm.setVisibility(8);
            this.gEm.setVisibility(8);
            this.gFq.setVisibility(8);
            if (this.gFC) {
                this.gFx.setVisibility(0);
            } else {
                this.gFx.setVisibility(8);
            }
        } else {
            this.gFy.setVisibility(8);
            this.gFx.setVisibility(8);
        }
        bLk();
        c(cardPersonDynamicThreadData);
    }

    private void lR(boolean z) {
        if (this.gEm != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEm.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.gEm.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.gFB || this.gFC) {
                this.fGo.setCommentClickable(false);
                this.fGo.setAgreeClickable(false);
                this.fGo.setShareClickable(false);
                this.gFy.setClickable(false);
                this.gFl.setClickable(false);
            } else {
                this.fGo.setCommentClickable(true);
                this.fGo.setAgreeClickable(true);
                this.fGo.setShareClickable(true);
                this.gFy.setClickable(true);
                this.gFl.setClickable(true);
            }
            this.fGo.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.gHX == 60) {
                this.fGo.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.gIh != null) {
                this.fGo.setMultiForumCount(cardPersonDynamicThreadData.gIh.length);
            }
            if (cardPersonDynamicThreadData.dEA != null) {
                this.fGo.setForumId(String.valueOf(cardPersonDynamicThreadData.dEA.getFid()));
            }
            this.fGo.setData(cardPersonDynamicThreadData.dEA);
        }
    }

    private void bLk() {
        this.ahm.setClickable(true);
        int childCount = this.gEm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gEm.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bLn() {
        if (this.gEQ != null && this.gEQ.dEA != null && this.gEQ.dEA.aQS() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Dn(this.gEQ.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.gEQ.dEA.aQS());
            if (this.gEQ.dEA.aQS().user_info != null) {
                alaLiveInfoCoreData.userName = this.gEQ.dEA.aQS().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLo() {
        if (this.gEQ != null && this.gEQ.dEA != null && this.gEQ.dEA.aQS() != null && this.gEQ.dEA.aQS().share_info != null) {
            if (!isHost()) {
                m.Dn(this.gEQ.threadId);
            }
            if (this.gEQ.dEA.aQS().share_info.record_tid <= 0) {
                bLn();
                return;
            }
            String valueOf = String.valueOf(this.gEQ.dEA.aQS().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.gEQ.dEA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbi() {
        if (this.gEQ != null) {
            if (!isHost()) {
                m.Dn(this.gEQ.threadId);
                m.a(this.mTitle, this.gEQ.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.adV, this.gEQ.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.gEQ.gHX == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.gEQ.dEA, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.gEQ.dEA.getFid()));
            pbActivityConfig.setForumName(this.gEQ.dEA.aQC());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.gEQ.dEA.isShareThread);
            pbActivityConfig.setThreadData(this.gEQ.dEA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.gEQ.dEA == null || !this.gEQ.dEA.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").dh("obj_type", "2").dh("tid", this.gEQ.threadId).ag("obj_param1", this.gEQ.isHost ? 1 : 2));
        }
    }

    private void bLp() {
        if (this.gEQ != null && this.gEQ.dEA != null && this.gEQ.dEA.dHm != null) {
            OriginalThreadInfo originalThreadInfo = this.gEQ.dEA.dHm;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").dh("obj_type", "3").dh("tid", this.gEQ.threadId).ag("obj_param1", this.gEQ.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.gFk != null) {
            if (z) {
                this.gFk.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.gFk.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.gFk.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.gFk.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.gEQ.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gFy) {
            bLp();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEm != null) {
            this.gEm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEm != null) {
            this.gEm.setImageViewPool(bVar);
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
        SpannableStringBuilder d = cardPersonDynamicThreadData.dEA.d(false, true, this.gFB);
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
