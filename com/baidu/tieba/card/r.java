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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.ag;
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
/* loaded from: classes8.dex */
public class r extends b<CardPersonDynamicThreadData> {
    private TextView agY;
    private boolean akO;
    public PlayVoiceBntNew alb;
    private TextView amw;
    private TextView amy;
    private TbImageView.b fUe;
    private CustomMessageListener iwF;
    private CardPersonDynamicThreadData ixT;
    private ConstrainImageGroup ixl;
    private View.OnClickListener ixq;
    private final View.OnClickListener ixr;
    private TBLottieAnimationView iyA;
    private TextView iyB;
    private TextView iyC;
    public OriginalThreadCardView iyD;
    private View iyE;
    private View iyF;
    public ThreadCardBottomOpSegmentLayout iyG;
    private boolean iyH;
    private boolean iyI;
    private EMTextView iyJ;
    com.baidu.tieba.view.g iyK;
    private q.a iyL;
    private final View.OnClickListener iyM;
    public ThreadViewAndCommentInfoLayout iyh;
    private final String iyi;
    private final String iyj;
    private TextView iyk;
    private LinearLayout iyl;
    private TextView iym;
    private TextView iyn;
    private TextView iyo;
    private TextView iyp;
    private ImageView iyq;
    private q iyr;
    private View iys;
    private TbImageView iyt;
    private ImageView iyu;
    private LinearLayout iyv;
    private TextView iyw;
    private LinearLayout iyx;
    private LinearLayout iyy;
    private TextView iyz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iyi = "1";
        this.iyj = "2";
        this.mSkinType = 3;
        this.akO = true;
        this.iyK = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.ixT != null && !StringUtils.isNull(r.this.ixT.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.ixT.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.CAM_X0304) : r.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.ixq = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.csc() != null) {
                    r.this.csc().a(view, r.this.ixT);
                }
                if (r.this.ixT.iBz != 60) {
                    if ((r.this.ixT.iBz != 40 || r.this.ixT.iBC != 2) && !r.this.iyI) {
                        r.this.bzk();
                        return;
                    } else {
                        BdToast.b(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.ixT.eJQ.boj().live_status != 1) {
                    r.this.csz();
                } else {
                    r.this.csy();
                }
            }
        };
        this.iwF = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.ixT != null && r.this.ixT.threadId != null && r.this.mTitle != null && r.this.agY != null && ((String) customResponsedMessage.getData()).equals(r.this.ixT.threadId) && !r.this.isHost()) {
                    m.a(r.this.mTitle, r.this.ixT.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                    m.a(r.this.agY, r.this.ixT.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
                }
            }
        };
        this.iyL = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.pA(z);
            }
        };
        this.iyM = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> csc = r.this.csc();
                if (csc != null) {
                    view.setTag("1");
                    csc.a(view, r.this.ixT);
                }
                r.this.bzk();
            }
        };
        this.ixr = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> csc = r.this.csc();
                if (csc != null) {
                    view.setTag("2");
                    csc.a(view, r.this.ixT);
                }
            }
        };
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && r.this.iyt != null) {
                    r.this.iyt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.iyk = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.iyl = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.iym = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.iyn = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.iyo = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.iyC = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.iyp = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.iyq = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.alb = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.alb.setAfterClickListener(this.ixr);
        this.agY = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.agY.setVisibility(8);
        this.ixl = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.ixl.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.ixl.setChildClickListener(this.iyM);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.ixl.setImageProcessor(aVar);
        this.iys = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.iyt = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.iyu = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.iyh = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.iyy = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.amy = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.amw = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.iyz = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.iyA = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.iyA.loop(true);
        ap.a(this.iyA, R.raw.ala_play);
        this.iyB = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.iyv = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.iyw = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.iyx = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.iyx.setVisibility(8);
        this.iyD = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.iyE = this.mRootView.findViewById(R.id.divider_line_thick);
        this.iyF = this.mRootView.findViewById(R.id.divider_line_thin);
        this.iyG = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.iyG.hideDisagree();
        if (this.iyG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iyG.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.iyG.setLayoutParams(layoutParams);
        }
        this.iyG.setOnClickListener(this.ixq);
        this.iyG.setReplyTimeVisible(false);
        this.iyG.setShowPraiseNum(true);
        this.iyG.setNeedAddPraiseIcon(true);
        this.iyG.setNeedAddReplyIcon(true);
        this.iyG.setShareVisible(true);
        this.iyG.setIsBarViewVisible(false);
        this.iyG.setFrom(13);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 8;
        eVar.eMg = 3;
        this.iyG.setAgreeStatisticData(eVar);
        this.iyG.setShareReportFrom(6);
        this.iyG.setStType("person_page");
        this.iyG.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.csc() != null) {
                    r.this.csc().a(view, r.this.ixT);
                }
            }
        });
        this.iyJ = (EMTextView) this.mRootView.findViewById(R.id.tv_ueg_view);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.iyA, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.iyk, R.color.CAM_X0105);
            ap.setViewTextColor(this.iym, R.color.CAM_X0107);
            ap.setViewTextColor(this.iyn, R.color.CAM_X0105);
            ap.setViewTextColor(this.iyo, R.color.CAM_X0109);
            ap.setViewTextColor(this.iyC, R.color.CAM_X0109);
            ap.setViewTextColor(this.iyp, R.color.CAM_X0109);
            if (this.iyq != null) {
                this.iyq.setImageDrawable(SvgManager.bsR().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.agY, R.color.CAM_X0106);
            ap.setViewTextColor(this.iyw, R.color.CAM_X0106);
            if (this.iyr != null) {
                this.iyr.onChangeSkinType();
            }
            this.iyh.onChangeSkinType();
            this.iyG.onChangeSkinType();
            ap.setBackgroundColor(this.iyE, R.color.CAM_X0204);
            ap.setBackgroundColor(this.iyF, R.color.CAM_X0205);
            ap.setBackgroundColor(this.iyw, R.color.CAM_X0205);
            if (this.iyD != null) {
                this.iyD.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.iyJ).nY(R.color.CAM_X0109).oa(R.string.F_X01);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(final CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ixT = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ixq);
        }
        this.iyk.setVisibility(cardPersonDynamicThreadData.iBM ? 0 : 8);
        this.iyl.setVisibility(cardPersonDynamicThreadData.iBL ? 0 : 4);
        this.iyE.setVisibility(cardPersonDynamicThreadData.iBL ? 0 : 8);
        this.iyF.setVisibility(cardPersonDynamicThreadData.iBL ? 8 : 0);
        if (cardPersonDynamicThreadData.iBN) {
            this.iyE.setVisibility(8);
            this.iyF.setVisibility(8);
        }
        this.iyH = cardPersonDynamicThreadData.iBz == 40 && cardPersonDynamicThreadData.iBC == 2;
        c(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eJQ != null) {
            this.iyI = cardPersonDynamicThreadData.eJQ.isShareThread && cardPersonDynamicThreadData.iBC == 2;
        }
        this.iyk.setText(cardPersonDynamicThreadData.iBD);
        this.iym.setText(cardPersonDynamicThreadData.iBE);
        this.iyn.setText(cardPersonDynamicThreadData.iBF);
        if (cardPersonDynamicThreadData.iBK != null && cardPersonDynamicThreadData.iBK.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.iBK.length; i++) {
                sb.append(au.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.iBK[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.iBK.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.iyo.setText(sb2);
                this.iyo.setVisibility(0);
            } else {
                this.iyo.setText(R.string.person_homepage);
            }
        } else {
            this.iyo.setText(R.string.person_homepage);
        }
        this.iyJ.setVisibility(8);
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.iyp.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.iyp.setVisibility(0);
            }
            pA(cardPersonDynamicThreadData.isPrivacy);
            if (cardPersonDynamicThreadData.isAuthorView == 1) {
                this.iyp.setVisibility(8);
                this.iyJ.setVisibility(0);
            }
            this.iyq.setVisibility(0);
            this.iyq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.iyr == null) {
                            r.this.iyr = new q(r.this.mPageContext);
                            r.this.iyr.create();
                            r.this.iyr.a(r.this.iyL);
                        }
                        r.this.iyr.a(r.this.ixT, cardPersonDynamicThreadData.isAuthorView == 1);
                        r.this.iyr.show();
                    }
                }
            });
        } else {
            this.iyp.setVisibility(8);
            this.iyq.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.iBI;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.alb.setVisibility(0);
            pz(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.alb.setVoiceModel(voiceModel);
            this.alb.setTag(voiceModel);
            this.alb.buo();
            if (voiceModel != null) {
                this.alb.Dp(voiceModel.voice_status.intValue());
            }
            this.alb.ccB();
        } else {
            this.alb.setVisibility(8);
            pz(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.iBH;
        ap.setBackgroundResource(this.iyv, R.color.transparent);
        this.iyw.setVisibility(8);
        this.iyx.setVisibility(8);
        this.iyv.setVisibility(0);
        this.iys.setVisibility(8);
        this.iyB.setVisibility(8);
        this.iyy.setVisibility(8);
        this.iyz.setVisibility(8);
        this.iyA.cancelAnimation();
        this.iyA.setVisibility(8);
        if (cardPersonDynamicThreadData.iBz == 36) {
            this.ixl.setVisibility(8);
        } else if (cardPersonDynamicThreadData.iBz == 40 || this.ixT.iBz == 50) {
            this.ixl.setVisibility(8);
            if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
                this.iys.setVisibility(0);
                this.iyu.setVisibility(0);
                this.iyu.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iys.getLayoutParams();
                int width = this.iys.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.iys.setLayoutParams(layoutParams);
                if (this.ixT.videoInfo != null) {
                    this.iyt.setPlaceHolder(3);
                    this.iyt.setEvent(this.fUe);
                    this.iyt.startLoad(this.ixT.videoInfo.thumbnail_url, 17, false);
                    if (this.iyH) {
                        this.iyB.setVisibility(0);
                        this.iyB.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.iyy.setVisibility(0);
                        this.amy.setText(au.stringForVideoTime(this.ixT.videoInfo.video_duration.intValue() * 1000));
                        this.amw.setText(String.format(this.mContext.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ixT.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.ixT.iBz == 60 || this.ixT.iBz == 49) {
            this.ixl.setVisibility(8);
            if (this.ixT.eJQ.boj() != null && this.ixT.eJQ.boj().user_info != null && this.ixT.iBz == 60) {
                String str = this.ixT.eJQ.boj().user_info.user_name;
                if (ag.getTextLengthWithEmoji(str) > 14) {
                    str = ag.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.iyw.setText(m.eJ(str + ":", this.ixT.eJQ.getTitle()));
                this.iyw.setVisibility(0);
            } else {
                this.iyw.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
                this.iys.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iys.getLayoutParams();
                int width2 = this.iys.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.iys.setLayoutParams(layoutParams2);
                if (this.ixT.eJQ.boj() != null) {
                    this.iyt.setPlaceHolder(3);
                    this.iyt.setEvent(this.fUe);
                    this.iyt.startLoad(cardPersonDynamicThreadData.eJQ.boj().cover, 10, false);
                    this.iyu.setVisibility(8);
                    this.iyA.setVisibility(0);
                    this.iyA.playAnimation();
                    ap.setBackgroundResource(this.iyv, R.color.CAM_X0205);
                    this.iyz.setVisibility(0);
                    this.iyz.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.ixT.eJQ.boj().audience_count)));
                    this.iyG.getCommentContainer().setOnClickListener(this.ixq);
                } else {
                    this.iyG.getCommentContainer().setOnClickListener(this.iyG);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bkT().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final cb cbVar = cardPersonDynamicThreadData.eJQ;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.ixl.setVisibility(0);
                    this.ixl.setFromCDN(this.akO);
                    this.ixl.setSingleImageRatio(0.67d);
                    this.ixl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bzk();
                            } else {
                                r.this.a(view, linkedList, i2, cbVar);
                            }
                        }
                    });
                    this.ixl.setImageMediaList(linkedList);
                } else {
                    this.ixl.setVisibility(8);
                }
            } else {
                this.ixl.setVisibility(8);
            }
            this.iyv.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eJQ != null && cardPersonDynamicThreadData.eJQ.eTc != null) {
            this.iyD.setVisibility(0);
            this.iyD.b(cardPersonDynamicThreadData.eJQ.eTc);
            this.iyD.setOnClickListener(this);
            this.alb.setVisibility(8);
            this.ixl.setVisibility(8);
            this.iyv.setVisibility(8);
            if (this.iyI) {
                this.iyC.setVisibility(0);
            } else {
                this.iyC.setVisibility(8);
            }
        } else {
            this.iyD.setVisibility(8);
            this.iyC.setVisibility(8);
        }
        csu();
        b(cardPersonDynamicThreadData);
    }

    private void pz(boolean z) {
        if (this.ixl != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ixl.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.ixl.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.iyH || this.iyI) {
                this.iyG.setCommentClickable(false);
                this.iyG.setAgreeClickable(false);
                this.iyG.setShareClickable(false);
                this.iyD.setClickable(false);
                this.iyq.setClickable(false);
            } else {
                this.iyG.setCommentClickable(true);
                this.iyG.setAgreeClickable(true);
                this.iyG.setShareClickable(true);
                this.iyD.setClickable(true);
                this.iyq.setClickable(true);
            }
            this.iyG.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.iBz == 60) {
                this.iyG.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.iBK != null) {
                this.iyG.setMultiForumCount(cardPersonDynamicThreadData.iBK.length);
            }
            if (cardPersonDynamicThreadData.eJQ != null) {
                this.iyG.setForumId(String.valueOf(cardPersonDynamicThreadData.eJQ.getFid()));
            }
            this.iyG.setData(cardPersonDynamicThreadData.eJQ);
        }
    }

    private void csu() {
        this.alb.setClickable(true);
        int childCount = this.ixl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ixl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void csy() {
        if (this.ixT != null && this.ixT.eJQ != null && this.ixT.eJQ.boj() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.IN(this.ixT.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ixT.eJQ.boj());
            if (this.ixT.eJQ.boj().user_info != null) {
                alaLiveInfoCoreData.userName = this.ixT.eJQ.boj().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csz() {
        if (this.ixT != null && this.ixT.eJQ != null && this.ixT.eJQ.boj() != null && this.ixT.eJQ.boj().share_info != null) {
            if (!isHost()) {
                m.IN(this.ixT.threadId);
            }
            if (this.ixT.eJQ.boj().share_info.record_tid <= 0) {
                csy();
                return;
            }
            String valueOf = String.valueOf(this.ixT.eJQ.boj().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.ixT.eJQ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzk() {
        if (this.ixT != null) {
            if (!isHost()) {
                m.IN(this.ixT.threadId);
                m.a(this.mTitle, this.ixT.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.agY, this.ixT.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.ixT.iBz == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.ixT.eJQ, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.ixT.eJQ.getFid()));
            pbActivityConfig.setForumName(this.ixT.eJQ.bnU());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.ixT.eJQ.isShareThread);
            pbActivityConfig.setThreadData(this.ixT.eJQ);
            pbActivityConfig.setIsPrivacy(this.ixT.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.ixT.eJQ == null || !this.ixT.eJQ.isShareThread) {
                return;
            }
            TiebaStatic.log(new ar("c12943").dR("obj_type", "2").dR("tid", this.ixT.threadId).ap("obj_param1", this.ixT.isHost ? 1 : 2));
        }
    }

    private void csA() {
        if (this.ixT != null && this.ixT.eJQ != null && this.ixT.eJQ.eTc != null) {
            OriginalThreadInfo originalThreadInfo = this.ixT.eJQ.eTc;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ar("c12943").dR("obj_type", "3").dR("tid", this.ixT.threadId).ap("obj_param1", this.ixT.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        if (this.iyp != null) {
            if (z) {
                this.iyp.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.iyp.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.iyp.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.iyp.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.ixT.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iyD) {
            csA();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ixl != null) {
            this.ixl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ixl != null) {
            this.ixl.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, cb cbVar) {
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
                imageUrlData.urlType = this.akO ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(cbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.s(arrayList).mQ(i).zJ(cbVar.bnU()).zK(String.valueOf(cbVar.getFid())).zL(cbVar.getTid()).jg(this.akO).zM(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).s(cbVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eP = aVar.eP(this.mPageContext.getPageActivity());
        eP.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
    }

    private boolean c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.eJQ == null) {
            return false;
        }
        SpannableStringBuilder f = cardPersonDynamicThreadData.eJQ.f(false, true, this.iyH);
        if (f == null || StringUtils.isNull(f.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(f));
        this.mTitle.setText(f);
        if (isHost()) {
            return true;
        }
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
        return true;
    }
}
