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
import com.baidu.tbadk.util.af;
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
/* loaded from: classes24.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView agl;
    private boolean akj;
    public PlayVoiceBntNew akv;
    private TextView alL;
    private TextView alN;
    private TbImageView.a frq;
    public ThreadCommentAndPraiseInfoLayout gAE;
    private ConstrainImageGroup hFM;
    private View.OnClickListener hFR;
    private final View.OnClickListener hFS;
    private CustomMessageListener hFi;
    public ThreadViewAndCommentInfoLayout hGF;
    private final String hGG;
    private final String hGH;
    private TextView hGI;
    private LinearLayout hGJ;
    private TextView hGK;
    private TextView hGL;
    private TextView hGM;
    private TextView hGN;
    private ImageView hGO;
    private p hGP;
    private View hGQ;
    private TbImageView hGR;
    private ImageView hGS;
    private LinearLayout hGT;
    private TextView hGU;
    private LinearLayout hGV;
    private LinearLayout hGW;
    private TextView hGX;
    private TBLottieAnimationView hGY;
    private TextView hGZ;
    private CardPersonDynamicThreadData hGq;
    private TextView hHa;
    public OriginalThreadCardView hHb;
    private View hHc;
    private View hHd;
    private boolean hHe;
    private boolean hHf;
    com.baidu.tieba.view.g hHg;
    private p.a hHh;
    private final View.OnClickListener hHi;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hGG = "1";
        this.hGH = "2";
        this.mSkinType = 3;
        this.akj = true;
        this.hHg = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.hGq != null && !StringUtils.isNull(q.this.hGq.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.hGq.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.hFR = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cil() != null) {
                    q.this.cil().a(view, q.this.hGq);
                }
                if (q.this.hGq.hJG != 60) {
                    if ((q.this.hGq.hJG != 40 || q.this.hGq.hJI != 2) && !q.this.hHf) {
                        q.this.btj();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bkP();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.hGq.eji.biB().live_status != 1) {
                    q.this.ciH();
                } else {
                    q.this.ciG();
                }
            }
        };
        this.hFi = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.hGq != null && q.this.hGq.threadId != null && q.this.mTitle != null && q.this.agl != null && ((String) customResponsedMessage.getData()).equals(q.this.hGq.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.hGq.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                    m.a(q.this.agl, q.this.hGq.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
                }
            }
        };
        this.hHh = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.nW(z);
            }
        };
        this.hHi = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cil = q.this.cil();
                if (cil != null) {
                    view.setTag("1");
                    cil.a(view, q.this.hGq);
                }
                q.this.btj();
            }
        };
        this.hFS = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cil = q.this.cil();
                if (cil != null) {
                    view.setTag("2");
                    cil.a(view, q.this.hGq);
                }
            }
        };
        this.frq = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.hGR != null) {
                    q.this.hGR.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hGI = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hGJ = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hGK = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hGL = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hGM = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hHa = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hGN = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hGO = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.akv = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.akv.setAfterClickListener(this.hFS);
        this.agl = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.agl.setVisibility(8);
        this.hFM = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hFM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hFM.setChildClickListener(this.hHi);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.hFM.setImageProcessor(aVar);
        this.hGQ = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hGR = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hGS = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hGF = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hGW = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.alN = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.alL = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hGX = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hGY = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hGY.loop(true);
        ap.a(this.hGY, R.raw.ala_play);
        this.hGZ = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hGT = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hGU = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hGV = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hGV.setVisibility(8);
        this.hHb = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hHc = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hHd = this.mRootView.findViewById(R.id.divider_line_thin);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.gAE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gAE.setLayoutParams(layoutParams);
        }
        this.gAE.setOnClickListener(this.hFR);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setShareVisible(true);
        this.gAE.setIsBarViewVisible(false);
        this.gAE.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 8;
        cVar.elg = 3;
        this.gAE.setAgreeStatisticData(cVar);
        this.gAE.setShareReportFrom(6);
        this.gAE.setStType("person_page");
        this.gAE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cil() != null) {
                    q.this.cil().a(view, q.this.hGq);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hGY, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hGI, R.color.cp_cont_b);
            ap.setViewTextColor(this.hGK, R.color.cp_cont_j);
            ap.setViewTextColor(this.hGL, R.color.cp_cont_b);
            ap.setViewTextColor(this.hGM, R.color.cp_cont_d);
            ap.setViewTextColor(this.hHa, R.color.cp_cont_d);
            ap.setViewTextColor(this.hGN, R.color.cp_cont_d);
            if (this.hGO != null) {
                this.hGO.setImageDrawable(SvgManager.bmU().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.agl, R.color.cp_cont_f);
            ap.setViewTextColor(this.hGU, R.color.cp_cont_f);
            if (this.hGP != null) {
                this.hGP.onChangeSkinType();
            }
            this.hGF.onChangeSkinType();
            this.gAE.onChangeSkinType();
            ap.setBackgroundColor(this.hHc, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hHd, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.hGU, R.color.cp_bg_line_e);
            if (this.hHb != null) {
                this.hHb.onChangeSkinType();
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
        this.hGq = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hFR);
        }
        this.hGI.setVisibility(cardPersonDynamicThreadData.hJS ? 0 : 8);
        this.hGJ.setVisibility(cardPersonDynamicThreadData.hJR ? 0 : 4);
        this.hHc.setVisibility(cardPersonDynamicThreadData.hJR ? 0 : 8);
        this.hHd.setVisibility(cardPersonDynamicThreadData.hJR ? 8 : 0);
        if (cardPersonDynamicThreadData.hJT) {
            this.hHc.setVisibility(8);
            this.hHd.setVisibility(8);
        }
        this.hHe = cardPersonDynamicThreadData.hJG == 40 && cardPersonDynamicThreadData.hJI == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eji != null) {
            this.hHf = cardPersonDynamicThreadData.eji.isShareThread && cardPersonDynamicThreadData.hJI == 2;
        }
        this.hGI.setText(cardPersonDynamicThreadData.hJJ);
        this.hGK.setText(cardPersonDynamicThreadData.hJK);
        this.hGL.setText(cardPersonDynamicThreadData.hJL);
        if (cardPersonDynamicThreadData.hJQ != null && cardPersonDynamicThreadData.hJQ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.hJQ.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.hJQ[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.hJQ.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hGM.setText(sb2);
                this.hGM.setVisibility(0);
            } else {
                this.hGM.setText(R.string.person_homepage);
            }
        } else {
            this.hGM.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hGN.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hGN.setVisibility(0);
            }
            nW(cardPersonDynamicThreadData.isPrivacy);
            this.hGO.setVisibility(0);
            this.hGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.hGP == null) {
                            q.this.hGP = new p(q.this.mPageContext);
                            q.this.hGP.create();
                            q.this.hGP.a(q.this.hHh);
                        }
                        q.this.hGP.a(q.this.hGq);
                        q.this.hGP.show();
                    }
                }
            });
        } else {
            this.hGN.setVisibility(8);
            this.hGO.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.hJO;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.akv.setVisibility(0);
            nV(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.akv.setVoiceModel(voiceModel);
            this.akv.setTag(voiceModel);
            this.akv.changeSkin();
            if (voiceModel != null) {
                this.akv.CT(voiceModel.voice_status.intValue());
            }
            this.akv.bTK();
        } else {
            this.akv.setVisibility(8);
            nV(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.hJN;
        ap.setBackgroundResource(this.hGT, R.color.transparent);
        this.hGU.setVisibility(8);
        this.hGV.setVisibility(8);
        this.hGT.setVisibility(0);
        this.hGQ.setVisibility(8);
        this.hGZ.setVisibility(8);
        this.hGW.setVisibility(8);
        this.hGX.setVisibility(8);
        this.hGY.cancelAnimation();
        this.hGY.setVisibility(8);
        if (cardPersonDynamicThreadData.hJG == 36) {
            this.hFM.setVisibility(8);
        } else if (cardPersonDynamicThreadData.hJG == 40 || this.hGq.hJG == 50) {
            this.hFM.setVisibility(8);
            if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
                this.hGQ.setVisibility(0);
                this.hGS.setVisibility(0);
                this.hGS.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hGQ.getLayoutParams();
                int width = this.hGQ.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hGQ.setLayoutParams(layoutParams);
                if (this.hGq.videoInfo != null) {
                    this.hGR.setDefaultErrorResource(0);
                    this.hGR.setPlaceHolder(3);
                    this.hGR.setEvent(this.frq);
                    this.hGR.startLoad(this.hGq.videoInfo.thumbnail_url, 17, false);
                    if (this.hHe) {
                        this.hGZ.setVisibility(0);
                        this.hGZ.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hGW.setVisibility(0);
                        this.alN.setText(at.stringForVideoTime(this.hGq.videoInfo.video_duration.intValue() * 1000));
                        this.alL.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hGq.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hGq.hJG == 60 || this.hGq.hJG == 49) {
            this.hFM.setVisibility(8);
            if (this.hGq.eji.biB() != null && this.hGq.eji.biB().user_info != null && this.hGq.hJG == 60) {
                String str = this.hGq.eji.biB().user_info.user_name;
                if (af.getTextLengthWithEmoji(str) > 14) {
                    str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hGU.setText(m.ey(str + ":", this.hGq.eji.getTitle()));
                this.hGU.setVisibility(0);
            } else {
                this.hGU.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
                this.hGQ.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hGQ.getLayoutParams();
                int width2 = this.hGQ.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hGQ.setLayoutParams(layoutParams2);
                if (this.hGq.eji.biB() != null) {
                    this.hGR.setDefaultErrorResource(0);
                    this.hGR.setPlaceHolder(3);
                    this.hGR.setEvent(this.frq);
                    this.hGR.startLoad(cardPersonDynamicThreadData.eji.biB().cover, 10, false);
                    this.hGS.setVisibility(8);
                    this.hGY.setVisibility(0);
                    this.hGY.playAnimation();
                    ap.setBackgroundResource(this.hGT, R.color.cp_bg_line_e);
                    this.hGX.setVisibility(0);
                    this.hGX.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.hGq.eji.biB().audience_count)));
                    this.gAE.getCommentContainer().setOnClickListener(this.hFR);
                } else {
                    this.gAE.getCommentContainer().setOnClickListener(this.gAE);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bfo().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bw bwVar = cardPersonDynamicThreadData.eji;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hFM.setVisibility(0);
                    this.hFM.setFromCDN(this.akj);
                    this.hFM.setSingleImageRatio(0.67d);
                    this.hFM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.btj();
                            } else {
                                q.this.a(view, linkedList, i2, bwVar);
                            }
                        }
                    });
                    this.hFM.setImageMediaList(linkedList);
                } else {
                    this.hFM.setVisibility(8);
                }
            } else {
                this.hFM.setVisibility(8);
            }
            this.hGT.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eji != null && cardPersonDynamicThreadData.eji.erY != null) {
            this.hHb.setVisibility(0);
            this.hHb.b(cardPersonDynamicThreadData.eji.erY);
            this.hHb.setOnClickListener(this);
            this.akv.setVisibility(8);
            this.hFM.setVisibility(8);
            this.hGT.setVisibility(8);
            if (this.hHf) {
                this.hHa.setVisibility(0);
            } else {
                this.hHa.setVisibility(8);
            }
        } else {
            this.hHb.setVisibility(8);
            this.hHa.setVisibility(8);
        }
        ciD();
        c(cardPersonDynamicThreadData);
    }

    private void nV(boolean z) {
        if (this.hFM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hFM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hFM.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hHe || this.hHf) {
                this.gAE.setCommentClickable(false);
                this.gAE.setAgreeClickable(false);
                this.gAE.setShareClickable(false);
                this.hHb.setClickable(false);
                this.hGO.setClickable(false);
            } else {
                this.gAE.setCommentClickable(true);
                this.gAE.setAgreeClickable(true);
                this.gAE.setShareClickable(true);
                this.hHb.setClickable(true);
                this.hGO.setClickable(true);
            }
            this.gAE.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.hJG == 60) {
                this.gAE.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.hJQ != null) {
                this.gAE.setMultiForumCount(cardPersonDynamicThreadData.hJQ.length);
            }
            if (cardPersonDynamicThreadData.eji != null) {
                this.gAE.setForumId(String.valueOf(cardPersonDynamicThreadData.eji.getFid()));
            }
            this.gAE.setData(cardPersonDynamicThreadData.eji);
        }
    }

    private void ciD() {
        this.akv.setClickable(true);
        int childCount = this.hFM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hFM.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void ciG() {
        if (this.hGq != null && this.hGq.eji != null && this.hGq.eji.biB() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Ij(this.hGq.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hGq.eji.biB());
            if (this.hGq.eji.biB().user_info != null) {
                alaLiveInfoCoreData.userName = this.hGq.eji.biB().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciH() {
        if (this.hGq != null && this.hGq.eji != null && this.hGq.eji.biB() != null && this.hGq.eji.biB().share_info != null) {
            if (!isHost()) {
                m.Ij(this.hGq.threadId);
            }
            if (this.hGq.eji.biB().share_info.record_tid <= 0) {
                ciG();
                return;
            }
            String valueOf = String.valueOf(this.hGq.eji.biB().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hGq.eji);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btj() {
        if (this.hGq != null) {
            if (!isHost()) {
                m.Ij(this.hGq.threadId);
                m.a(this.mTitle, this.hGq.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.agl, this.hGq.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hGq.hJG == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hGq.eji, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hGq.eji.getFid()));
            pbActivityConfig.setForumName(this.hGq.eji.bil());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hGq.eji.isShareThread);
            pbActivityConfig.setThreadData(this.hGq.eji);
            pbActivityConfig.setIsPrivacy(this.hGq.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hGq.eji == null || !this.hGq.eji.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dK("obj_type", "2").dK("tid", this.hGq.threadId).aj("obj_param1", this.hGq.isHost ? 1 : 2));
        }
    }

    private void ciI() {
        if (this.hGq != null && this.hGq.eji != null && this.hGq.eji.erY != null) {
            OriginalThreadInfo originalThreadInfo = this.hGq.eji.erY;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dK("obj_type", "3").dK("tid", this.hGq.threadId).aj("obj_param1", this.hGq.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(boolean z) {
        if (this.hGN != null) {
            if (z) {
                this.hGN.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hGN.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hGN.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hGN.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hGq.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHb) {
            ciI();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hFM != null) {
            this.hFM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hFM != null) {
            this.hFM.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                imageUrlData.urlType = this.akj ? 13 : 14;
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
        aVar.x(arrayList).nu(i).zX(bwVar.bil()).zY(String.valueOf(bwVar.getFid())).zZ(bwVar.getTid()).ib(this.akj).Aa(arrayList.size() > 0 ? arrayList.get(0) : "").ic(true).a(concurrentHashMap).id(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        dU.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.eji == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.eji.e(false, true, this.hHe);
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
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
        return true;
    }
}
