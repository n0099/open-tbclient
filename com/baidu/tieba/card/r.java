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
    private ConstrainImageGroup iwX;
    private CustomMessageListener iwr;
    private CardPersonDynamicThreadData ixF;
    public ThreadViewAndCommentInfoLayout ixT;
    private final String ixU;
    private final String ixV;
    private TextView ixW;
    private LinearLayout ixX;
    private TextView ixY;
    private TextView ixZ;
    private View.OnClickListener ixc;
    private final View.OnClickListener ixd;
    private TextView iya;
    private TextView iyb;
    private ImageView iyc;
    private q iyd;
    private View iye;
    private TbImageView iyf;
    private ImageView iyg;
    private LinearLayout iyh;
    private TextView iyi;
    private LinearLayout iyj;
    private LinearLayout iyk;
    private TextView iyl;
    private TBLottieAnimationView iym;
    private TextView iyn;
    private TextView iyo;
    public OriginalThreadCardView iyp;
    private View iyq;
    private View iyr;
    public ThreadCardBottomOpSegmentLayout iys;
    private boolean iyt;
    private boolean iyu;
    private EMTextView iyv;
    com.baidu.tieba.view.g iyw;
    private q.a iyx;
    private final View.OnClickListener iyy;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ixU = "1";
        this.ixV = "2";
        this.mSkinType = 3;
        this.akO = true;
        this.iyw = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.ixF != null && !StringUtils.isNull(r.this.ixF.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.ixF.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.CAM_X0304) : r.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.ixc = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.crV() != null) {
                    r.this.crV().a(view, r.this.ixF);
                }
                if (r.this.ixF.iBl != 60) {
                    if ((r.this.ixF.iBl != 40 || r.this.ixF.iBo != 2) && !r.this.iyu) {
                        r.this.bzk();
                        return;
                    } else {
                        BdToast.b(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.ixF.eJQ.boj().live_status != 1) {
                    r.this.css();
                } else {
                    r.this.csr();
                }
            }
        };
        this.iwr = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.ixF != null && r.this.ixF.threadId != null && r.this.mTitle != null && r.this.agY != null && ((String) customResponsedMessage.getData()).equals(r.this.ixF.threadId) && !r.this.isHost()) {
                    m.a(r.this.mTitle, r.this.ixF.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                    m.a(r.this.agY, r.this.ixF.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
                }
            }
        };
        this.iyx = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.pA(z);
            }
        };
        this.iyy = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> crV = r.this.crV();
                if (crV != null) {
                    view.setTag("1");
                    crV.a(view, r.this.ixF);
                }
                r.this.bzk();
            }
        };
        this.ixd = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> crV = r.this.crV();
                if (crV != null) {
                    view.setTag("2");
                    crV.a(view, r.this.ixF);
                }
            }
        };
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && r.this.iyf != null) {
                    r.this.iyf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.ixW = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.ixX = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.ixY = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.ixZ = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.iya = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.iyo = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.iyb = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.iyc = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.alb = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.alb.setAfterClickListener(this.ixd);
        this.agY = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.agY.setVisibility(8);
        this.iwX = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.iwX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iwX.setChildClickListener(this.iyy);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.iwX.setImageProcessor(aVar);
        this.iye = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.iyf = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.iyg = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.ixT = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.iyk = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.amy = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.amw = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.iyl = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.iym = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.iym.loop(true);
        ap.a(this.iym, R.raw.ala_play);
        this.iyn = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.iyh = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.iyi = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.iyj = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.iyj.setVisibility(8);
        this.iyp = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.iyq = this.mRootView.findViewById(R.id.divider_line_thick);
        this.iyr = this.mRootView.findViewById(R.id.divider_line_thin);
        this.iys = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.iys.hideDisagree();
        if (this.iys.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iys.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.iys.setLayoutParams(layoutParams);
        }
        this.iys.setOnClickListener(this.ixc);
        this.iys.setReplyTimeVisible(false);
        this.iys.setShowPraiseNum(true);
        this.iys.setNeedAddPraiseIcon(true);
        this.iys.setNeedAddReplyIcon(true);
        this.iys.setShareVisible(true);
        this.iys.setIsBarViewVisible(false);
        this.iys.setFrom(13);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 8;
        eVar.eMg = 3;
        this.iys.setAgreeStatisticData(eVar);
        this.iys.setShareReportFrom(6);
        this.iys.setStType("person_page");
        this.iys.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.crV() != null) {
                    r.this.crV().a(view, r.this.ixF);
                }
            }
        });
        this.iyv = (EMTextView) this.mRootView.findViewById(R.id.tv_ueg_view);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.iym, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.ixW, R.color.CAM_X0105);
            ap.setViewTextColor(this.ixY, R.color.CAM_X0107);
            ap.setViewTextColor(this.ixZ, R.color.CAM_X0105);
            ap.setViewTextColor(this.iya, R.color.CAM_X0109);
            ap.setViewTextColor(this.iyo, R.color.CAM_X0109);
            ap.setViewTextColor(this.iyb, R.color.CAM_X0109);
            if (this.iyc != null) {
                this.iyc.setImageDrawable(SvgManager.bsR().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.agY, R.color.CAM_X0106);
            ap.setViewTextColor(this.iyi, R.color.CAM_X0106);
            if (this.iyd != null) {
                this.iyd.onChangeSkinType();
            }
            this.ixT.onChangeSkinType();
            this.iys.onChangeSkinType();
            ap.setBackgroundColor(this.iyq, R.color.CAM_X0204);
            ap.setBackgroundColor(this.iyr, R.color.CAM_X0205);
            ap.setBackgroundColor(this.iyi, R.color.CAM_X0205);
            if (this.iyp != null) {
                this.iyp.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.iyv).nY(R.color.CAM_X0109).oa(R.string.F_X01);
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
        this.ixF = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ixc);
        }
        this.ixW.setVisibility(cardPersonDynamicThreadData.iBy ? 0 : 8);
        this.ixX.setVisibility(cardPersonDynamicThreadData.iBx ? 0 : 4);
        this.iyq.setVisibility(cardPersonDynamicThreadData.iBx ? 0 : 8);
        this.iyr.setVisibility(cardPersonDynamicThreadData.iBx ? 8 : 0);
        if (cardPersonDynamicThreadData.iBz) {
            this.iyq.setVisibility(8);
            this.iyr.setVisibility(8);
        }
        this.iyt = cardPersonDynamicThreadData.iBl == 40 && cardPersonDynamicThreadData.iBo == 2;
        c(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eJQ != null) {
            this.iyu = cardPersonDynamicThreadData.eJQ.isShareThread && cardPersonDynamicThreadData.iBo == 2;
        }
        this.ixW.setText(cardPersonDynamicThreadData.iBp);
        this.ixY.setText(cardPersonDynamicThreadData.iBq);
        this.ixZ.setText(cardPersonDynamicThreadData.iBr);
        if (cardPersonDynamicThreadData.iBw != null && cardPersonDynamicThreadData.iBw.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.iBw.length; i++) {
                sb.append(au.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.iBw[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.iBw.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.iya.setText(sb2);
                this.iya.setVisibility(0);
            } else {
                this.iya.setText(R.string.person_homepage);
            }
        } else {
            this.iya.setText(R.string.person_homepage);
        }
        this.iyv.setVisibility(8);
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.iyb.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.iyb.setVisibility(0);
            }
            pA(cardPersonDynamicThreadData.isPrivacy);
            if (cardPersonDynamicThreadData.isAuthorView == 1) {
                this.iyb.setVisibility(8);
                this.iyv.setVisibility(0);
            }
            this.iyc.setVisibility(0);
            this.iyc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.iyd == null) {
                            r.this.iyd = new q(r.this.mPageContext);
                            r.this.iyd.create();
                            r.this.iyd.a(r.this.iyx);
                        }
                        r.this.iyd.a(r.this.ixF, cardPersonDynamicThreadData.isAuthorView == 1);
                        r.this.iyd.show();
                    }
                }
            });
        } else {
            this.iyb.setVisibility(8);
            this.iyc.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.iBu;
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
            this.alb.ccu();
        } else {
            this.alb.setVisibility(8);
            pz(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.iBt;
        ap.setBackgroundResource(this.iyh, R.color.transparent);
        this.iyi.setVisibility(8);
        this.iyj.setVisibility(8);
        this.iyh.setVisibility(0);
        this.iye.setVisibility(8);
        this.iyn.setVisibility(8);
        this.iyk.setVisibility(8);
        this.iyl.setVisibility(8);
        this.iym.cancelAnimation();
        this.iym.setVisibility(8);
        if (cardPersonDynamicThreadData.iBl == 36) {
            this.iwX.setVisibility(8);
        } else if (cardPersonDynamicThreadData.iBl == 40 || this.ixF.iBl == 50) {
            this.iwX.setVisibility(8);
            if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
                this.iye.setVisibility(0);
                this.iyg.setVisibility(0);
                this.iyg.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iye.getLayoutParams();
                int width = this.iye.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.iye.setLayoutParams(layoutParams);
                if (this.ixF.videoInfo != null) {
                    this.iyf.setPlaceHolder(3);
                    this.iyf.setEvent(this.fUe);
                    this.iyf.startLoad(this.ixF.videoInfo.thumbnail_url, 17, false);
                    if (this.iyt) {
                        this.iyn.setVisibility(0);
                        this.iyn.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.iyk.setVisibility(0);
                        this.amy.setText(au.stringForVideoTime(this.ixF.videoInfo.video_duration.intValue() * 1000));
                        this.amw.setText(String.format(this.mContext.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ixF.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.ixF.iBl == 60 || this.ixF.iBl == 49) {
            this.iwX.setVisibility(8);
            if (this.ixF.eJQ.boj() != null && this.ixF.eJQ.boj().user_info != null && this.ixF.iBl == 60) {
                String str = this.ixF.eJQ.boj().user_info.user_name;
                if (ag.getTextLengthWithEmoji(str) > 14) {
                    str = ag.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.iyi.setText(m.eJ(str + ":", this.ixF.eJQ.getTitle()));
                this.iyi.setVisibility(0);
            } else {
                this.iyi.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
                this.iye.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iye.getLayoutParams();
                int width2 = this.iye.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.iye.setLayoutParams(layoutParams2);
                if (this.ixF.eJQ.boj() != null) {
                    this.iyf.setPlaceHolder(3);
                    this.iyf.setEvent(this.fUe);
                    this.iyf.startLoad(cardPersonDynamicThreadData.eJQ.boj().cover, 10, false);
                    this.iyg.setVisibility(8);
                    this.iym.setVisibility(0);
                    this.iym.playAnimation();
                    ap.setBackgroundResource(this.iyh, R.color.CAM_X0205);
                    this.iyl.setVisibility(0);
                    this.iyl.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.ixF.eJQ.boj().audience_count)));
                    this.iys.getCommentContainer().setOnClickListener(this.ixc);
                } else {
                    this.iys.getCommentContainer().setOnClickListener(this.iys);
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
                    this.iwX.setVisibility(0);
                    this.iwX.setFromCDN(this.akO);
                    this.iwX.setSingleImageRatio(0.67d);
                    this.iwX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bzk();
                            } else {
                                r.this.a(view, linkedList, i2, cbVar);
                            }
                        }
                    });
                    this.iwX.setImageMediaList(linkedList);
                } else {
                    this.iwX.setVisibility(8);
                }
            } else {
                this.iwX.setVisibility(8);
            }
            this.iyh.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eJQ != null && cardPersonDynamicThreadData.eJQ.eTc != null) {
            this.iyp.setVisibility(0);
            this.iyp.b(cardPersonDynamicThreadData.eJQ.eTc);
            this.iyp.setOnClickListener(this);
            this.alb.setVisibility(8);
            this.iwX.setVisibility(8);
            this.iyh.setVisibility(8);
            if (this.iyu) {
                this.iyo.setVisibility(0);
            } else {
                this.iyo.setVisibility(8);
            }
        } else {
            this.iyp.setVisibility(8);
            this.iyo.setVisibility(8);
        }
        csn();
        b(cardPersonDynamicThreadData);
    }

    private void pz(boolean z) {
        if (this.iwX != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwX.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.iwX.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.iyt || this.iyu) {
                this.iys.setCommentClickable(false);
                this.iys.setAgreeClickable(false);
                this.iys.setShareClickable(false);
                this.iyp.setClickable(false);
                this.iyc.setClickable(false);
            } else {
                this.iys.setCommentClickable(true);
                this.iys.setAgreeClickable(true);
                this.iys.setShareClickable(true);
                this.iyp.setClickable(true);
                this.iyc.setClickable(true);
            }
            this.iys.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.iBl == 60) {
                this.iys.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.iBw != null) {
                this.iys.setMultiForumCount(cardPersonDynamicThreadData.iBw.length);
            }
            if (cardPersonDynamicThreadData.eJQ != null) {
                this.iys.setForumId(String.valueOf(cardPersonDynamicThreadData.eJQ.getFid()));
            }
            this.iys.setData(cardPersonDynamicThreadData.eJQ);
        }
    }

    private void csn() {
        this.alb.setClickable(true);
        int childCount = this.iwX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iwX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void csr() {
        if (this.ixF != null && this.ixF.eJQ != null && this.ixF.eJQ.boj() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.IM(this.ixF.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ixF.eJQ.boj());
            if (this.ixF.eJQ.boj().user_info != null) {
                alaLiveInfoCoreData.userName = this.ixF.eJQ.boj().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void css() {
        if (this.ixF != null && this.ixF.eJQ != null && this.ixF.eJQ.boj() != null && this.ixF.eJQ.boj().share_info != null) {
            if (!isHost()) {
                m.IM(this.ixF.threadId);
            }
            if (this.ixF.eJQ.boj().share_info.record_tid <= 0) {
                csr();
                return;
            }
            String valueOf = String.valueOf(this.ixF.eJQ.boj().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.ixF.eJQ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzk() {
        if (this.ixF != null) {
            if (!isHost()) {
                m.IM(this.ixF.threadId);
                m.a(this.mTitle, this.ixF.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.agY, this.ixF.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.ixF.iBl == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.ixF.eJQ, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.ixF.eJQ.getFid()));
            pbActivityConfig.setForumName(this.ixF.eJQ.bnU());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.ixF.eJQ.isShareThread);
            pbActivityConfig.setThreadData(this.ixF.eJQ);
            pbActivityConfig.setIsPrivacy(this.ixF.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.ixF.eJQ == null || !this.ixF.eJQ.isShareThread) {
                return;
            }
            TiebaStatic.log(new ar("c12943").dR("obj_type", "2").dR("tid", this.ixF.threadId).ap("obj_param1", this.ixF.isHost ? 1 : 2));
        }
    }

    private void cst() {
        if (this.ixF != null && this.ixF.eJQ != null && this.ixF.eJQ.eTc != null) {
            OriginalThreadInfo originalThreadInfo = this.ixF.eJQ.eTc;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ar("c12943").dR("obj_type", "3").dR("tid", this.ixF.threadId).ap("obj_param1", this.ixF.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        if (this.iyb != null) {
            if (z) {
                this.iyb.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.iyb.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.iyb.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.iyb.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.ixF.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iyp) {
            cst();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwX != null) {
            this.iwX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwX != null) {
            this.iwX.setImageViewPool(bVar);
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
        SpannableStringBuilder f = cardPersonDynamicThreadData.eJQ.f(false, true, this.iyt);
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
