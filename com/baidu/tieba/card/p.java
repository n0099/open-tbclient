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
    private TextView ady;
    public PlayVoiceBntNew agG;
    private boolean agt;
    private TextView ahE;
    private TextView ahG;
    private TbImageView.a emz;
    public ThreadCommentAndPraiseInfoLayout fsr;
    private CustomMessageListener goM;
    private CardPersonDynamicThreadData gpV;
    private ConstrainImageGroup gpr;
    private View.OnClickListener gpw;
    private final View.OnClickListener gpx;
    private TBLottieAnimationView gqA;
    private TextView gqB;
    private TextView gqC;
    public OriginalThreadCardView gqD;
    private View gqE;
    private View gqF;
    private boolean gqG;
    private boolean gqH;
    com.baidu.tieba.view.g gqI;
    private o.a gqJ;
    private final View.OnClickListener gqK;
    public ThreadViewAndCommentInfoLayout gqh;
    private final String gqi;
    private final String gqj;
    private TextView gqk;
    private LinearLayout gql;
    private TextView gqm;
    private TextView gqn;
    private TextView gqo;
    private TextView gqp;
    private ImageView gqq;
    private o gqr;
    private View gqs;
    private TbImageView gqt;
    private ImageView gqu;
    private LinearLayout gqv;
    private TextView gqw;
    private LinearLayout gqx;
    private LinearLayout gqy;
    private TextView gqz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gqi = "1";
        this.gqj = "2";
        this.mSkinType = 3;
        this.agt = true;
        this.gqI = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.gpV != null && !StringUtils.isNull(p.this.gpV.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.gpV.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.gpw = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bEy() != null) {
                    p.this.bEy().a(view, p.this.gpV);
                }
                if (p.this.gpV.gtg != 60) {
                    if ((p.this.gpV.gtg != 40 || p.this.gpV.gti != 2) && !p.this.gqH) {
                        p.this.aVa();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aMZ();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.gpV.dqA.aKX().live_status != 1) {
                    p.this.bEW();
                } else {
                    p.this.bEV();
                }
            }
        };
        this.goM = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.gpV != null && p.this.gpV.threadId != null && p.this.mTitle != null && p.this.ady != null && ((String) customResponsedMessage.getData()).equals(p.this.gpV.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.gpV.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.ady, p.this.gpV.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.gqJ = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.lw(z);
            }
        };
        this.gqK = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> bEy = p.this.bEy();
                if (bEy != null) {
                    view.setTag("1");
                    bEy.a(view, p.this.gpV);
                }
                p.this.aVa();
            }
        };
        this.gpx = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> bEy = p.this.bEy();
                if (bEy != null) {
                    view.setTag("2");
                    bEy.a(view, p.this.gpV);
                }
            }
        };
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.gqt != null) {
                    p.this.gqt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.gqk = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.gql = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.gqm = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.gqn = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.gqo = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.gqC = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.gqp = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.gqq = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.agG = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.agG.setAfterClickListener(this.gpx);
        this.ady = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.ady.setVisibility(8);
        this.gpr = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.gpr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gpr.setChildClickListener(this.gqK);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.n(1.0d);
        this.gpr.setImageProcessor(aVar);
        this.gqs = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.gqt = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.gqu = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.gqh = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.gqy = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.ahG = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.ahE = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.gqz = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.gqA = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gqA.loop(true);
        am.a(this.gqA, R.raw.ala_play);
        this.gqB = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.gqv = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.gqw = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.gqx = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.gqx.setVisibility(8);
        this.gqD = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.gqE = this.mRootView.findViewById(R.id.divider_line_thick);
        this.gqF = this.mRootView.findViewById(R.id.divider_line_thin);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.fsr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsr.setLayoutParams(layoutParams);
        }
        this.fsr.setOnClickListener(this.gpw);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setShareVisible(true);
        this.fsr.setIsBarViewVisible(false);
        this.fsr.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 8;
        dVar.dmZ = 3;
        this.fsr.setAgreeStatisticData(dVar);
        this.fsr.setShareReportFrom(6);
        this.fsr.setStType("person_page");
        this.fsr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bEy() != null) {
                    p.this.bEy().a(view, p.this.gpV);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.gqA, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gqk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gqm, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.gqn, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gqo, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gqC, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gqp, (int) R.color.cp_cont_d);
            if (this.gqq != null) {
                this.gqq.setImageDrawable(SvgManager.aOU().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ady, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gqw, (int) R.color.cp_cont_f);
            if (this.gqr != null) {
                this.gqr.onChangeSkinType();
            }
            this.gqh.onChangeSkinType();
            this.fsr.onChangeSkinType();
            am.setBackgroundColor(this.gqE, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gqF, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gqw, R.color.cp_bg_line_e);
            if (this.gqD != null) {
                this.gqD.onChangeSkinType();
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
        this.gpV = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gpw);
        }
        this.gqk.setVisibility(cardPersonDynamicThreadData.gts ? 0 : 8);
        this.gql.setVisibility(cardPersonDynamicThreadData.gtr ? 0 : 4);
        this.gqE.setVisibility(cardPersonDynamicThreadData.gtr ? 0 : 8);
        this.gqF.setVisibility(cardPersonDynamicThreadData.gtr ? 8 : 0);
        if (cardPersonDynamicThreadData.gtt) {
            this.gqE.setVisibility(8);
            this.gqF.setVisibility(8);
        }
        this.gqG = cardPersonDynamicThreadData.gtg == 40 && cardPersonDynamicThreadData.gti == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dqA != null) {
            this.gqH = cardPersonDynamicThreadData.dqA.isShareThread && cardPersonDynamicThreadData.gti == 2;
        }
        this.gqk.setText(cardPersonDynamicThreadData.gtj);
        this.gqm.setText(cardPersonDynamicThreadData.gtk);
        this.gqn.setText(cardPersonDynamicThreadData.gtl);
        if (cardPersonDynamicThreadData.gtq != null && cardPersonDynamicThreadData.gtq.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.gtq.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.gtq[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.gtq.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.gqo.setText(sb2);
                this.gqo.setVisibility(0);
            } else {
                this.gqo.setText(R.string.person_homepage);
            }
        } else {
            this.gqo.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.gqp.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.gqp.setVisibility(0);
            }
            lw(cardPersonDynamicThreadData.isPrivacy);
            this.gqq.setVisibility(0);
            this.gqq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.gqr == null) {
                            p.this.gqr = new o(p.this.mPageContext);
                            p.this.gqr.create();
                            p.this.gqr.a(p.this.gqJ);
                        }
                        p.this.gqr.a(p.this.gpV);
                        p.this.gqr.show();
                    }
                }
            });
        } else {
            this.gqp.setVisibility(8);
            this.gqq.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.gto;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.agG.setVisibility(0);
            lv(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.agG.setVoiceModel(voiceModel);
            this.agG.setTag(voiceModel);
            this.agG.ckO();
            if (voiceModel != null) {
                this.agG.xC(voiceModel.voice_status.intValue());
            }
            this.agG.cXz();
        } else {
            this.agG.setVisibility(8);
            lv(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.gtn;
        am.setBackgroundResource(this.gqv, R.color.transparent);
        this.gqw.setVisibility(8);
        this.gqx.setVisibility(8);
        this.gqv.setVisibility(0);
        this.gqs.setVisibility(8);
        this.gqB.setVisibility(8);
        this.gqy.setVisibility(8);
        this.gqz.setVisibility(8);
        this.gqA.cancelAnimation();
        this.gqA.setVisibility(8);
        if (cardPersonDynamicThreadData.gtg == 36) {
            this.gpr.setVisibility(8);
        } else if (cardPersonDynamicThreadData.gtg == 40 || this.gpV.gtg == 50) {
            this.gpr.setVisibility(8);
            if (com.baidu.tbadk.core.i.aIe().isShowImages()) {
                this.gqs.setVisibility(0);
                this.gqu.setVisibility(0);
                this.gqu.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gqs.getLayoutParams();
                int width = this.gqs.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.gqs.setLayoutParams(layoutParams);
                if (this.gpV.videoInfo != null) {
                    this.gqt.setDefaultErrorResource(0);
                    this.gqt.setPlaceHolder(3);
                    this.gqt.setEvent(this.emz);
                    this.gqt.startLoad(this.gpV.videoInfo.thumbnail_url, 17, false);
                    if (this.gqG) {
                        this.gqB.setVisibility(0);
                        this.gqB.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.gqy.setVisibility(0);
                        this.ahG.setText(aq.stringForVideoTime(this.gpV.videoInfo.video_duration.intValue() * 1000));
                        this.ahE.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.gpV.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.gpV.gtg == 60 || this.gpV.gtg == 49) {
            this.gpr.setVisibility(8);
            if (this.gpV.dqA.aKX() != null && this.gpV.dqA.aKX().user_info != null && this.gpV.gtg == 60) {
                String str = this.gpV.dqA.aKX().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.gqw.setText(l.m33do(str + ":", this.gpV.dqA.getTitle()));
                this.gqw.setVisibility(0);
            } else {
                this.gqw.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.aIe().isShowImages()) {
                this.gqs.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gqs.getLayoutParams();
                int width2 = this.gqs.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.gqs.setLayoutParams(layoutParams2);
                if (this.gpV.dqA.aKX() != null) {
                    this.gqt.setDefaultErrorResource(0);
                    this.gqt.setPlaceHolder(3);
                    this.gqt.setEvent(this.emz);
                    this.gqt.startLoad(cardPersonDynamicThreadData.dqA.aKX().cover, 10, false);
                    this.gqu.setVisibility(8);
                    this.gqA.setVisibility(0);
                    this.gqA.playAnimation();
                    am.setBackgroundResource(this.gqv, R.color.cp_bg_line_e);
                    this.gqz.setVisibility(0);
                    this.gqz.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.gpV.dqA.aKX().audience_count)));
                    this.fsr.getCommentContainer().setOnClickListener(this.gpw);
                } else {
                    this.fsr.getCommentContainer().setOnClickListener(this.fsr);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.aIe().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.dqA;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.gpr.setVisibility(0);
                    this.gpr.setFromCDN(this.agt);
                    this.gpr.setSingleImageRatio(0.67d);
                    this.gpr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aVa();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.gpr.setImageMediaList(linkedList);
                } else {
                    this.gpr.setVisibility(8);
                }
            } else {
                this.gpr.setVisibility(8);
            }
            this.gqv.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dqA != null && cardPersonDynamicThreadData.dqA.dto != null) {
            this.gqD.setVisibility(0);
            this.gqD.b(cardPersonDynamicThreadData.dqA.dto);
            this.gqD.setOnClickListener(this);
            this.agG.setVisibility(8);
            this.gpr.setVisibility(8);
            this.gqv.setVisibility(8);
            if (this.gqH) {
                this.gqC.setVisibility(0);
            } else {
                this.gqC.setVisibility(8);
            }
        } else {
            this.gqD.setVisibility(8);
            this.gqC.setVisibility(8);
        }
        bES();
        c(cardPersonDynamicThreadData);
    }

    private void lv(boolean z) {
        if (this.gpr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpr.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.gpr.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.gqG || this.gqH) {
                this.fsr.setCommentClickable(false);
                this.fsr.setAgreeClickable(false);
                this.fsr.setShareClickable(false);
                this.gqD.setClickable(false);
                this.gqq.setClickable(false);
            } else {
                this.fsr.setCommentClickable(true);
                this.fsr.setAgreeClickable(true);
                this.fsr.setShareClickable(true);
                this.gqD.setClickable(true);
                this.gqq.setClickable(true);
            }
            this.fsr.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.gtg == 60) {
                this.fsr.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.gtq != null) {
                this.fsr.setMultiForumCount(cardPersonDynamicThreadData.gtq.length);
            }
            if (cardPersonDynamicThreadData.dqA != null) {
                this.fsr.setForumId(String.valueOf(cardPersonDynamicThreadData.dqA.getFid()));
            }
            this.fsr.setData(cardPersonDynamicThreadData.dqA);
        }
    }

    private void bES() {
        this.agG.setClickable(true);
        int childCount = this.gpr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gpr.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bEV() {
        if (this.gpV != null && this.gpV.dqA != null && this.gpV.dqA.aKX() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.BB(this.gpV.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.gpV.dqA.aKX());
            if (this.gpV.dqA.aKX().user_info != null) {
                alaLiveInfoCoreData.userName = this.gpV.dqA.aKX().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEW() {
        if (this.gpV != null && this.gpV.dqA != null && this.gpV.dqA.aKX() != null && this.gpV.dqA.aKX().share_info != null) {
            if (!isHost()) {
                l.BB(this.gpV.threadId);
            }
            if (this.gpV.dqA.aKX().share_info.record_tid <= 0) {
                bEV();
                return;
            }
            String valueOf = String.valueOf(this.gpV.dqA.aKX().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.gpV.dqA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVa() {
        if (this.gpV != null) {
            if (!isHost()) {
                l.BB(this.gpV.threadId);
                l.a(this.mTitle, this.gpV.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.ady, this.gpV.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.gpV.gtg == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.gpV.dqA, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.gpV.dqA.getFid()));
            pbActivityConfig.setForumName(this.gpV.dqA.aKJ());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.gpV.dqA.isShareThread);
            pbActivityConfig.setThreadData(this.gpV.dqA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.gpV.dqA == null || !this.gpV.dqA.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cI("obj_type", "2").cI("tid", this.gpV.threadId).af("obj_param1", this.gpV.isHost ? 1 : 2));
        }
    }

    private void bEX() {
        if (this.gpV != null && this.gpV.dqA != null && this.gpV.dqA.dto != null) {
            OriginalThreadInfo originalThreadInfo = this.gpV.dqA.dto;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cI("obj_type", "3").cI("tid", this.gpV.threadId).af("obj_param1", this.gpV.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(boolean z) {
        if (this.gqp != null) {
            if (z) {
                this.gqp.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.gqp.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.gqp.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.gqp.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.gpV.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqD) {
            bEX();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpr != null) {
            this.gpr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpr != null) {
            this.gpr.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.agt ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dqA == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.dqA.d(false, true, this.gqG);
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
        l.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
