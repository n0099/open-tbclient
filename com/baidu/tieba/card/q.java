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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.ad;
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
/* loaded from: classes8.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView aia;
    private boolean alQ;
    public PlayVoiceBntNew amd;
    private TextView anx;
    private TextView anz;
    private TbImageView.b fWw;
    private CustomMessageListener ivu;
    private CardPersonDynamicThreadData iwE;
    public ThreadViewAndCommentInfoLayout iwS;
    private final String iwT;
    private final String iwU;
    private TextView iwV;
    private LinearLayout iwW;
    private TextView iwX;
    private TextView iwY;
    private TextView iwZ;
    private ConstrainImageGroup iwa;
    private View.OnClickListener iwf;
    private final View.OnClickListener iwg;
    private TextView ixa;
    private ImageView ixb;
    private p ixc;
    private View ixd;
    private TbImageView ixe;
    private ImageView ixf;
    private LinearLayout ixg;
    private TextView ixh;
    private LinearLayout ixi;
    private LinearLayout ixj;
    private TextView ixk;
    private TBLottieAnimationView ixl;
    private TextView ixm;
    private TextView ixn;
    public OriginalThreadCardView ixo;
    private View ixp;
    private View ixq;
    public ThreadCardBottomOpSegmentLayout ixr;
    private boolean ixs;
    private boolean ixt;
    com.baidu.tieba.view.g ixu;
    private p.a ixv;
    private final View.OnClickListener ixw;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iwT = "1";
        this.iwU = "2";
        this.mSkinType = 3;
        this.alQ = true;
        this.ixu = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.iwE != null && !StringUtils.isNull(q.this.iwE.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.iwE.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.CAM_X0304) : q.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.iwf = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cuD() != null) {
                    q.this.cuD().a(view, q.this.iwE);
                }
                if (q.this.iwE.iAi != 60) {
                    if ((q.this.iwE.iAi != 40 || q.this.iwE.iAl != 2) && !q.this.ixt) {
                        q.this.bCM();
                        return;
                    } else {
                        BdToast.b(q.this.getContext(), q.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bue();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.iwE.eMv.brK().live_status != 1) {
                    q.this.cuZ();
                } else {
                    q.this.cuY();
                }
            }
        };
        this.ivu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.iwE != null && q.this.iwE.threadId != null && q.this.mTitle != null && q.this.aia != null && ((String) customResponsedMessage.getData()).equals(q.this.iwE.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.iwE.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                    m.a(q.this.aia, q.this.iwE.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
                }
            }
        };
        this.ixv = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.pu(z);
            }
        };
        this.ixw = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cuD = q.this.cuD();
                if (cuD != null) {
                    view.setTag("1");
                    cuD.a(view, q.this.iwE);
                }
                q.this.bCM();
            }
        };
        this.iwg = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cuD = q.this.cuD();
                if (cuD != null) {
                    view.setTag("2");
                    cuD.a(view, q.this.iwE);
                }
            }
        };
        this.fWw = new TbImageView.b() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && q.this.ixe != null) {
                    q.this.ixe.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.iwV = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.iwW = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.iwX = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.iwY = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.iwZ = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.ixn = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.ixa = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.ixb = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.amd = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.amd.setAfterClickListener(this.iwg);
        this.aia = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.aia.setVisibility(8);
        this.iwa = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.iwa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iwa.setChildClickListener(this.ixw);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.iwa.setImageProcessor(aVar);
        this.ixd = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.ixe = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.ixf = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.iwS = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.ixj = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.anz = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.anx = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.ixk = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.ixl = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.ixl.loop(true);
        ao.a(this.ixl, R.raw.ala_play);
        this.ixm = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.ixg = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.ixh = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.ixi = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.ixi.setVisibility(8);
        this.ixo = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.ixp = this.mRootView.findViewById(R.id.divider_line_thick);
        this.ixq = this.mRootView.findViewById(R.id.divider_line_thin);
        this.ixr = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.ixr.hideDisagree();
        if (this.ixr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ixr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ixr.setLayoutParams(layoutParams);
        }
        this.ixr.setOnClickListener(this.iwf);
        this.ixr.setReplyTimeVisible(false);
        this.ixr.setShowPraiseNum(true);
        this.ixr.setNeedAddPraiseIcon(true);
        this.ixr.setNeedAddReplyIcon(true);
        this.ixr.setShareVisible(true);
        this.ixr.setIsBarViewVisible(false);
        this.ixr.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOz = 8;
        dVar.eOF = 3;
        this.ixr.setAgreeStatisticData(dVar);
        this.ixr.setShareReportFrom(6);
        this.ixr.setStType("person_page");
        this.ixr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cuD() != null) {
                    q.this.cuD().a(view, q.this.iwE);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.a(this.ixl, R.raw.ala_play);
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setViewTextColor(this.iwV, R.color.CAM_X0105);
            ao.setViewTextColor(this.iwX, R.color.CAM_X0107);
            ao.setViewTextColor(this.iwY, R.color.CAM_X0105);
            ao.setViewTextColor(this.iwZ, R.color.CAM_X0109);
            ao.setViewTextColor(this.ixn, R.color.CAM_X0109);
            ao.setViewTextColor(this.ixa, R.color.CAM_X0109);
            if (this.ixb != null) {
                this.ixb.setImageDrawable(SvgManager.bwr().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setViewTextColor(this.aia, R.color.CAM_X0106);
            ao.setViewTextColor(this.ixh, R.color.CAM_X0106);
            if (this.ixc != null) {
                this.ixc.onChangeSkinType();
            }
            this.iwS.onChangeSkinType();
            this.ixr.onChangeSkinType();
            ao.setBackgroundColor(this.ixp, R.color.CAM_X0204);
            ao.setBackgroundColor(this.ixq, R.color.CAM_X0205);
            ao.setBackgroundColor(this.ixh, R.color.CAM_X0205);
            if (this.ixo != null) {
                this.ixo.onChangeSkinType();
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
        this.iwE = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iwf);
        }
        this.iwV.setVisibility(cardPersonDynamicThreadData.iAv ? 0 : 8);
        this.iwW.setVisibility(cardPersonDynamicThreadData.iAu ? 0 : 4);
        this.ixp.setVisibility(cardPersonDynamicThreadData.iAu ? 0 : 8);
        this.ixq.setVisibility(cardPersonDynamicThreadData.iAu ? 8 : 0);
        if (cardPersonDynamicThreadData.iAw) {
            this.ixp.setVisibility(8);
            this.ixq.setVisibility(8);
        }
        this.ixs = cardPersonDynamicThreadData.iAi == 40 && cardPersonDynamicThreadData.iAl == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eMv != null) {
            this.ixt = cardPersonDynamicThreadData.eMv.isShareThread && cardPersonDynamicThreadData.iAl == 2;
        }
        this.iwV.setText(cardPersonDynamicThreadData.iAm);
        this.iwX.setText(cardPersonDynamicThreadData.iAn);
        this.iwY.setText(cardPersonDynamicThreadData.iAo);
        if (cardPersonDynamicThreadData.iAt != null && cardPersonDynamicThreadData.iAt.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.iAt.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.iAt[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.iAt.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.iwZ.setText(sb2);
                this.iwZ.setVisibility(0);
            } else {
                this.iwZ.setText(R.string.person_homepage);
            }
        } else {
            this.iwZ.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.ixa.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.ixa.setVisibility(0);
            }
            pu(cardPersonDynamicThreadData.isPrivacy);
            this.ixb.setVisibility(0);
            this.ixb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.ixc == null) {
                            q.this.ixc = new p(q.this.mPageContext);
                            q.this.ixc.create();
                            q.this.ixc.a(q.this.ixv);
                        }
                        q.this.ixc.a(q.this.iwE);
                        q.this.ixc.show();
                    }
                }
            });
        } else {
            this.ixa.setVisibility(8);
            this.ixb.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.iAr;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.amd.setVisibility(0);
            pt(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.amd.setVoiceModel(voiceModel);
            this.amd.setTag(voiceModel);
            this.amd.bxO();
            if (voiceModel != null) {
                this.amd.EE(voiceModel.voice_status.intValue());
            }
            this.amd.cfr();
        } else {
            this.amd.setVisibility(8);
            pt(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.iAq;
        ao.setBackgroundResource(this.ixg, R.color.transparent);
        this.ixh.setVisibility(8);
        this.ixi.setVisibility(8);
        this.ixg.setVisibility(0);
        this.ixd.setVisibility(8);
        this.ixm.setVisibility(8);
        this.ixj.setVisibility(8);
        this.ixk.setVisibility(8);
        this.ixl.cancelAnimation();
        this.ixl.setVisibility(8);
        if (cardPersonDynamicThreadData.iAi == 36) {
            this.iwa.setVisibility(8);
        } else if (cardPersonDynamicThreadData.iAi == 40 || this.iwE.iAi == 50) {
            this.iwa.setVisibility(8);
            if (com.baidu.tbadk.core.k.bov().isShowImages()) {
                this.ixd.setVisibility(0);
                this.ixf.setVisibility(0);
                this.ixf.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ixd.getLayoutParams();
                int width = this.ixd.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.ixd.setLayoutParams(layoutParams);
                if (this.iwE.videoInfo != null) {
                    this.ixe.setPlaceHolder(3);
                    this.ixe.setEvent(this.fWw);
                    this.ixe.startLoad(this.iwE.videoInfo.thumbnail_url, 17, false);
                    if (this.ixs) {
                        this.ixm.setVisibility(0);
                        this.ixm.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.ixj.setVisibility(0);
                        this.anz.setText(at.stringForVideoTime(this.iwE.videoInfo.video_duration.intValue() * 1000));
                        this.anx.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.iwE.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.iwE.iAi == 60 || this.iwE.iAi == 49) {
            this.iwa.setVisibility(8);
            if (this.iwE.eMv.brK() != null && this.iwE.eMv.brK().user_info != null && this.iwE.iAi == 60) {
                String str = this.iwE.eMv.brK().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.ixh.setText(m.eJ(str + ":", this.iwE.eMv.getTitle()));
                this.ixh.setVisibility(0);
            } else {
                this.ixh.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bov().isShowImages()) {
                this.ixd.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ixd.getLayoutParams();
                int width2 = this.ixd.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.ixd.setLayoutParams(layoutParams2);
                if (this.iwE.eMv.brK() != null) {
                    this.ixe.setPlaceHolder(3);
                    this.ixe.setEvent(this.fWw);
                    this.ixe.startLoad(cardPersonDynamicThreadData.eMv.brK().cover, 10, false);
                    this.ixf.setVisibility(8);
                    this.ixl.setVisibility(0);
                    this.ixl.playAnimation();
                    ao.setBackgroundResource(this.ixg, R.color.CAM_X0205);
                    this.ixk.setVisibility(0);
                    this.ixk.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.iwE.eMv.brK().audience_count)));
                    this.ixr.getCommentContainer().setOnClickListener(this.iwf);
                } else {
                    this.ixr.getCommentContainer().setOnClickListener(this.ixr);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bov().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bz bzVar = cardPersonDynamicThreadData.eMv;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(linkedList) > 0) {
                    this.iwa.setVisibility(0);
                    this.iwa.setFromCDN(this.alQ);
                    this.iwa.setSingleImageRatio(0.67d);
                    this.iwa.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bCM();
                            } else {
                                q.this.a(view, linkedList, i2, bzVar);
                            }
                        }
                    });
                    this.iwa.setImageMediaList(linkedList);
                } else {
                    this.iwa.setVisibility(8);
                }
            } else {
                this.iwa.setVisibility(8);
            }
            this.ixg.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eMv != null && cardPersonDynamicThreadData.eMv.eVB != null) {
            this.ixo.setVisibility(0);
            this.ixo.b(cardPersonDynamicThreadData.eMv.eVB);
            this.ixo.setOnClickListener(this);
            this.amd.setVisibility(8);
            this.iwa.setVisibility(8);
            this.ixg.setVisibility(8);
            if (this.ixt) {
                this.ixn.setVisibility(0);
            } else {
                this.ixn.setVisibility(8);
            }
        } else {
            this.ixo.setVisibility(8);
            this.ixn.setVisibility(8);
        }
        cuV();
        c(cardPersonDynamicThreadData);
    }

    private void pt(boolean z) {
        if (this.iwa != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwa.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.iwa.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ixs || this.ixt) {
                this.ixr.setCommentClickable(false);
                this.ixr.setAgreeClickable(false);
                this.ixr.setShareClickable(false);
                this.ixo.setClickable(false);
                this.ixb.setClickable(false);
            } else {
                this.ixr.setCommentClickable(true);
                this.ixr.setAgreeClickable(true);
                this.ixr.setShareClickable(true);
                this.ixo.setClickable(true);
                this.ixb.setClickable(true);
            }
            this.ixr.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.iAi == 60) {
                this.ixr.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.iAt != null) {
                this.ixr.setMultiForumCount(cardPersonDynamicThreadData.iAt.length);
            }
            if (cardPersonDynamicThreadData.eMv != null) {
                this.ixr.setForumId(String.valueOf(cardPersonDynamicThreadData.eMv.getFid()));
            }
            this.ixr.setData(cardPersonDynamicThreadData.eMv);
        }
    }

    private void cuV() {
        this.amd.setClickable(true);
        int childCount = this.iwa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iwa.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void cuY() {
        if (this.iwE != null && this.iwE.eMv != null && this.iwE.eMv.brK() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Jn(this.iwE.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.iwE.eMv.brK());
            if (this.iwE.eMv.brK().user_info != null) {
                alaLiveInfoCoreData.userName = this.iwE.eMv.brK().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuZ() {
        if (this.iwE != null && this.iwE.eMv != null && this.iwE.eMv.brK() != null && this.iwE.eMv.brK().share_info != null) {
            if (!isHost()) {
                m.Jn(this.iwE.threadId);
            }
            if (this.iwE.eMv.brK().share_info.record_tid <= 0) {
                cuY();
                return;
            }
            String valueOf = String.valueOf(this.iwE.eMv.brK().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.iwE.eMv);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCM() {
        if (this.iwE != null) {
            if (!isHost()) {
                m.Jn(this.iwE.threadId);
                m.a(this.mTitle, this.iwE.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.aia, this.iwE.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.iwE.iAi == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.iwE.eMv, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.iwE.eMv.getFid()));
            pbActivityConfig.setForumName(this.iwE.eMv.brv());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.iwE.eMv.isShareThread);
            pbActivityConfig.setThreadData(this.iwE.eMv);
            pbActivityConfig.setIsPrivacy(this.iwE.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.iwE.eMv == null || !this.iwE.eMv.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dX("obj_type", "2").dX("tid", this.iwE.threadId).an("obj_param1", this.iwE.isHost ? 1 : 2));
        }
    }

    private void cva() {
        if (this.iwE != null && this.iwE.eMv != null && this.iwE.eMv.eVB != null) {
            OriginalThreadInfo originalThreadInfo = this.iwE.eMv.eVB;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dX("obj_type", "3").dX("tid", this.iwE.threadId).an("obj_param1", this.iwE.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (this.ixa != null) {
            if (z) {
                this.ixa.setText(R.string.privacy);
                Drawable drawable = ao.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.ixa.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.ixa.setText(R.string.public_open);
            Drawable drawable2 = ao.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.ixa.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.iwE.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ixo) {
            cva();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwa != null) {
            this.iwa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwa != null) {
            this.iwa.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bz bzVar) {
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
                imageUrlData.urlType = this.alQ ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bzVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).ot(i).AD(bzVar.brv()).AE(String.valueOf(bzVar.getFid())).AF(bzVar.getTid()).ji(this.alQ).AG(arrayList.size() > 0 ? arrayList.get(0) : "").jj(true).d(concurrentHashMap).jk(true).s(bzVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eS = aVar.eS(this.mPageContext.getPageActivity());
        eS.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.eMv == null) {
            return false;
        }
        SpannableStringBuilder f = cardPersonDynamicThreadData.eMv.f(false, true, this.ixs);
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
