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
    private TextView adB;
    public PlayVoiceBntNew agJ;
    private boolean agw;
    private TextView ahH;
    private TextView ahJ;
    private TbImageView.a emE;
    public ThreadCommentAndPraiseInfoLayout fsw;
    private CustomMessageListener goS;
    private View.OnClickListener gpC;
    private final View.OnClickListener gpD;
    private ConstrainImageGroup gpx;
    private ImageView gqA;
    private LinearLayout gqB;
    private TextView gqC;
    private LinearLayout gqD;
    private LinearLayout gqE;
    private TextView gqF;
    private TBLottieAnimationView gqG;
    private TextView gqH;
    private TextView gqI;
    public OriginalThreadCardView gqJ;
    private View gqK;
    private View gqL;
    private boolean gqM;
    private boolean gqN;
    com.baidu.tieba.view.g gqO;
    private o.a gqP;
    private final View.OnClickListener gqQ;
    private CardPersonDynamicThreadData gqb;
    public ThreadViewAndCommentInfoLayout gqn;
    private final String gqo;
    private final String gqp;
    private TextView gqq;
    private LinearLayout gqr;
    private TextView gqs;
    private TextView gqt;
    private TextView gqu;
    private TextView gqv;
    private ImageView gqw;
    private o gqx;
    private View gqy;
    private TbImageView gqz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gqo = "1";
        this.gqp = "2";
        this.mSkinType = 3;
        this.agw = true;
        this.gqO = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.gqb != null && !StringUtils.isNull(p.this.gqb.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.gqb.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.gpC = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bEx() != null) {
                    p.this.bEx().a(view, p.this.gqb);
                }
                if (p.this.gqb.gtm != 60) {
                    if ((p.this.gqb.gtm != 40 || p.this.gqb.gto != 2) && !p.this.gqN) {
                        p.this.aUY();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aMX();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.gqb.dqE.aKV().live_status != 1) {
                    p.this.bEV();
                } else {
                    p.this.bEU();
                }
            }
        };
        this.goS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.gqb != null && p.this.gqb.threadId != null && p.this.mTitle != null && p.this.adB != null && ((String) customResponsedMessage.getData()).equals(p.this.gqb.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.gqb.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.adB, p.this.gqb.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.gqP = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.lw(z);
            }
        };
        this.gqQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> bEx = p.this.bEx();
                if (bEx != null) {
                    view.setTag("1");
                    bEx.a(view, p.this.gqb);
                }
                p.this.aUY();
            }
        };
        this.gpD = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> bEx = p.this.bEx();
                if (bEx != null) {
                    view.setTag("2");
                    bEx.a(view, p.this.gqb);
                }
            }
        };
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.gqz != null) {
                    p.this.gqz.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.gqq = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.gqr = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.gqs = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.gqt = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.gqu = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.gqI = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.gqv = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.gqw = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.agJ = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.agJ.setAfterClickListener(this.gpD);
        this.adB = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.adB.setVisibility(8);
        this.gpx = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.gpx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gpx.setChildClickListener(this.gqQ);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.n(1.0d);
        this.gpx.setImageProcessor(aVar);
        this.gqy = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.gqz = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.gqA = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.gqn = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.gqE = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.ahJ = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.ahH = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.gqF = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.gqG = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.gqG.loop(true);
        am.a(this.gqG, R.raw.ala_play);
        this.gqH = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.gqB = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.gqC = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.gqD = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.gqD.setVisibility(8);
        this.gqJ = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.gqK = this.mRootView.findViewById(R.id.divider_line_thick);
        this.gqL = this.mRootView.findViewById(R.id.divider_line_thin);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.fsw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsw.setLayoutParams(layoutParams);
        }
        this.fsw.setOnClickListener(this.gpC);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setShareVisible(true);
        this.fsw.setIsBarViewVisible(false);
        this.fsw.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 8;
        dVar.dnd = 3;
        this.fsw.setAgreeStatisticData(dVar);
        this.fsw.setShareReportFrom(6);
        this.fsw.setStType("person_page");
        this.fsw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bEx() != null) {
                    p.this.bEx().a(view, p.this.gqb);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.gqG, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gqq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gqs, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.gqt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gqu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gqI, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gqv, (int) R.color.cp_cont_d);
            if (this.gqw != null) {
                this.gqw.setImageDrawable(SvgManager.aOR().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adB, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gqC, (int) R.color.cp_cont_f);
            if (this.gqx != null) {
                this.gqx.onChangeSkinType();
            }
            this.gqn.onChangeSkinType();
            this.fsw.onChangeSkinType();
            am.setBackgroundColor(this.gqK, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gqL, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gqC, R.color.cp_bg_line_e);
            if (this.gqJ != null) {
                this.gqJ.onChangeSkinType();
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
        this.gqb = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gpC);
        }
        this.gqq.setVisibility(cardPersonDynamicThreadData.gty ? 0 : 8);
        this.gqr.setVisibility(cardPersonDynamicThreadData.gtx ? 0 : 4);
        this.gqK.setVisibility(cardPersonDynamicThreadData.gtx ? 0 : 8);
        this.gqL.setVisibility(cardPersonDynamicThreadData.gtx ? 8 : 0);
        if (cardPersonDynamicThreadData.gtz) {
            this.gqK.setVisibility(8);
            this.gqL.setVisibility(8);
        }
        this.gqM = cardPersonDynamicThreadData.gtm == 40 && cardPersonDynamicThreadData.gto == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dqE != null) {
            this.gqN = cardPersonDynamicThreadData.dqE.isShareThread && cardPersonDynamicThreadData.gto == 2;
        }
        this.gqq.setText(cardPersonDynamicThreadData.gtp);
        this.gqs.setText(cardPersonDynamicThreadData.gtq);
        this.gqt.setText(cardPersonDynamicThreadData.gtr);
        if (cardPersonDynamicThreadData.gtw != null && cardPersonDynamicThreadData.gtw.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.gtw.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.gtw[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.gtw.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.gqu.setText(sb2);
                this.gqu.setVisibility(0);
            } else {
                this.gqu.setText(R.string.person_homepage);
            }
        } else {
            this.gqu.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.gqv.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.gqv.setVisibility(0);
            }
            lw(cardPersonDynamicThreadData.isPrivacy);
            this.gqw.setVisibility(0);
            this.gqw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.gqx == null) {
                            p.this.gqx = new o(p.this.mPageContext);
                            p.this.gqx.create();
                            p.this.gqx.a(p.this.gqP);
                        }
                        p.this.gqx.a(p.this.gqb);
                        p.this.gqx.show();
                    }
                }
            });
        } else {
            this.gqv.setVisibility(8);
            this.gqw.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.gtu;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.agJ.setVisibility(0);
            lv(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.agJ.setVoiceModel(voiceModel);
            this.agJ.setTag(voiceModel);
            this.agJ.ckN();
            if (voiceModel != null) {
                this.agJ.xC(voiceModel.voice_status.intValue());
            }
            this.agJ.cXx();
        } else {
            this.agJ.setVisibility(8);
            lv(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.gtt;
        am.setBackgroundResource(this.gqB, R.color.transparent);
        this.gqC.setVisibility(8);
        this.gqD.setVisibility(8);
        this.gqB.setVisibility(0);
        this.gqy.setVisibility(8);
        this.gqH.setVisibility(8);
        this.gqE.setVisibility(8);
        this.gqF.setVisibility(8);
        this.gqG.cancelAnimation();
        this.gqG.setVisibility(8);
        if (cardPersonDynamicThreadData.gtm == 36) {
            this.gpx.setVisibility(8);
        } else if (cardPersonDynamicThreadData.gtm == 40 || this.gqb.gtm == 50) {
            this.gpx.setVisibility(8);
            if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
                this.gqy.setVisibility(0);
                this.gqA.setVisibility(0);
                this.gqA.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gqy.getLayoutParams();
                int width = this.gqy.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.gqy.setLayoutParams(layoutParams);
                if (this.gqb.videoInfo != null) {
                    this.gqz.setDefaultErrorResource(0);
                    this.gqz.setPlaceHolder(3);
                    this.gqz.setEvent(this.emE);
                    this.gqz.startLoad(this.gqb.videoInfo.thumbnail_url, 17, false);
                    if (this.gqM) {
                        this.gqH.setVisibility(0);
                        this.gqH.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.gqE.setVisibility(0);
                        this.ahJ.setText(aq.stringForVideoTime(this.gqb.videoInfo.video_duration.intValue() * 1000));
                        this.ahH.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.gqb.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.gqb.gtm == 60 || this.gqb.gtm == 49) {
            this.gpx.setVisibility(8);
            if (this.gqb.dqE.aKV() != null && this.gqb.dqE.aKV().user_info != null && this.gqb.gtm == 60) {
                String str = this.gqb.dqE.aKV().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.gqC.setText(l.m33do(str + ":", this.gqb.dqE.getTitle()));
                this.gqC.setVisibility(0);
            } else {
                this.gqC.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
                this.gqy.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gqy.getLayoutParams();
                int width2 = this.gqy.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.gqy.setLayoutParams(layoutParams2);
                if (this.gqb.dqE.aKV() != null) {
                    this.gqz.setDefaultErrorResource(0);
                    this.gqz.setPlaceHolder(3);
                    this.gqz.setEvent(this.emE);
                    this.gqz.startLoad(cardPersonDynamicThreadData.dqE.aKV().cover, 10, false);
                    this.gqA.setVisibility(8);
                    this.gqG.setVisibility(0);
                    this.gqG.playAnimation();
                    am.setBackgroundResource(this.gqB, R.color.cp_bg_line_e);
                    this.gqF.setVisibility(0);
                    this.gqF.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.gqb.dqE.aKV().audience_count)));
                    this.fsw.getCommentContainer().setOnClickListener(this.gpC);
                } else {
                    this.fsw.getCommentContainer().setOnClickListener(this.fsw);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.aIc().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.dqE;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.gpx.setVisibility(0);
                    this.gpx.setFromCDN(this.agw);
                    this.gpx.setSingleImageRatio(0.67d);
                    this.gpx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aUY();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.gpx.setImageMediaList(linkedList);
                } else {
                    this.gpx.setVisibility(8);
                }
            } else {
                this.gpx.setVisibility(8);
            }
            this.gqB.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dqE != null && cardPersonDynamicThreadData.dqE.dtt != null) {
            this.gqJ.setVisibility(0);
            this.gqJ.b(cardPersonDynamicThreadData.dqE.dtt);
            this.gqJ.setOnClickListener(this);
            this.agJ.setVisibility(8);
            this.gpx.setVisibility(8);
            this.gqB.setVisibility(8);
            if (this.gqN) {
                this.gqI.setVisibility(0);
            } else {
                this.gqI.setVisibility(8);
            }
        } else {
            this.gqJ.setVisibility(8);
            this.gqI.setVisibility(8);
        }
        bER();
        c(cardPersonDynamicThreadData);
    }

    private void lv(boolean z) {
        if (this.gpx != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpx.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.gpx.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.gqM || this.gqN) {
                this.fsw.setCommentClickable(false);
                this.fsw.setAgreeClickable(false);
                this.fsw.setShareClickable(false);
                this.gqJ.setClickable(false);
                this.gqw.setClickable(false);
            } else {
                this.fsw.setCommentClickable(true);
                this.fsw.setAgreeClickable(true);
                this.fsw.setShareClickable(true);
                this.gqJ.setClickable(true);
                this.gqw.setClickable(true);
            }
            this.fsw.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.gtm == 60) {
                this.fsw.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.gtw != null) {
                this.fsw.setMultiForumCount(cardPersonDynamicThreadData.gtw.length);
            }
            if (cardPersonDynamicThreadData.dqE != null) {
                this.fsw.setForumId(String.valueOf(cardPersonDynamicThreadData.dqE.getFid()));
            }
            this.fsw.setData(cardPersonDynamicThreadData.dqE);
        }
    }

    private void bER() {
        this.agJ.setClickable(true);
        int childCount = this.gpx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gpx.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bEU() {
        if (this.gqb != null && this.gqb.dqE != null && this.gqb.dqE.aKV() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.BE(this.gqb.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.gqb.dqE.aKV());
            if (this.gqb.dqE.aKV().user_info != null) {
                alaLiveInfoCoreData.userName = this.gqb.dqE.aKV().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEV() {
        if (this.gqb != null && this.gqb.dqE != null && this.gqb.dqE.aKV() != null && this.gqb.dqE.aKV().share_info != null) {
            if (!isHost()) {
                l.BE(this.gqb.threadId);
            }
            if (this.gqb.dqE.aKV().share_info.record_tid <= 0) {
                bEU();
                return;
            }
            String valueOf = String.valueOf(this.gqb.dqE.aKV().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.gqb.dqE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUY() {
        if (this.gqb != null) {
            if (!isHost()) {
                l.BE(this.gqb.threadId);
                l.a(this.mTitle, this.gqb.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.adB, this.gqb.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.gqb.gtm == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.gqb.dqE, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.gqb.dqE.getFid()));
            pbActivityConfig.setForumName(this.gqb.dqE.aKH());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.gqb.dqE.isShareThread);
            pbActivityConfig.setThreadData(this.gqb.dqE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.gqb.dqE == null || !this.gqb.dqE.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cI("obj_type", "2").cI("tid", this.gqb.threadId).af("obj_param1", this.gqb.isHost ? 1 : 2));
        }
    }

    private void bEW() {
        if (this.gqb != null && this.gqb.dqE != null && this.gqb.dqE.dtt != null) {
            OriginalThreadInfo originalThreadInfo = this.gqb.dqE.dtt;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cI("obj_type", "3").cI("tid", this.gqb.threadId).af("obj_param1", this.gqb.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(boolean z) {
        if (this.gqv != null) {
            if (z) {
                this.gqv.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.gqv.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.gqv.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.gqv.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.gqb.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqJ) {
            bEW();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpx != null) {
            this.gpx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpx != null) {
            this.gpx.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.agw ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKH(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agw, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dqE == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.dqE.d(false, true, this.gqM);
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
