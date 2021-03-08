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
/* loaded from: classes7.dex */
public class r extends b<CardPersonDynamicThreadData> {
    private TextView air;
    private boolean amh;
    public PlayVoiceBntNew amu;
    private TextView anO;
    private TextView anQ;
    private TbImageView.b fVE;
    private q iAa;
    private View iAb;
    private TbImageView iAc;
    private ImageView iAd;
    private LinearLayout iAe;
    private TextView iAf;
    private LinearLayout iAg;
    private LinearLayout iAh;
    private TextView iAi;
    private TBLottieAnimationView iAj;
    private TextView iAk;
    private TextView iAl;
    public OriginalThreadCardView iAm;
    private View iAn;
    private View iAo;
    public ThreadCardBottomOpSegmentLayout iAp;
    private boolean iAq;
    private boolean iAr;
    private EMTextView iAs;
    com.baidu.tieba.view.g iAt;
    private q.a iAu;
    private final View.OnClickListener iAv;
    private ConstrainImageGroup iyU;
    private View.OnClickListener iyZ;
    private CustomMessageListener iyo;
    private CardPersonDynamicThreadData izC;
    public ThreadViewAndCommentInfoLayout izQ;
    private final String izR;
    private final String izS;
    private TextView izT;
    private LinearLayout izU;
    private TextView izV;
    private TextView izW;
    private TextView izX;
    private TextView izY;
    private ImageView izZ;
    private final View.OnClickListener iza;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.izR = "1";
        this.izS = "2";
        this.mSkinType = 3;
        this.amh = true;
        this.iAt = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.izC != null && !StringUtils.isNull(r.this.izC.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.izC.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.CAM_X0304) : r.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.iyZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.csi() != null) {
                    r.this.csi().a(view, r.this.izC);
                }
                if (r.this.izC.iDi != 60) {
                    if ((r.this.izC.iDi != 40 || r.this.izC.iDl != 2) && !r.this.iAr) {
                        r.this.bzn();
                        return;
                    } else {
                        BdToast.b(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.izC.eLr.bol().live_status != 1) {
                    r.this.csF();
                } else {
                    r.this.csE();
                }
            }
        };
        this.iyo = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.izC != null && r.this.izC.threadId != null && r.this.mTitle != null && r.this.air != null && ((String) customResponsedMessage.getData()).equals(r.this.izC.threadId) && !r.this.isHost()) {
                    m.a(r.this.mTitle, r.this.izC.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                    m.a(r.this.air, r.this.izC.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
                }
            }
        };
        this.iAu = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.pA(z);
            }
        };
        this.iAv = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> csi = r.this.csi();
                if (csi != null) {
                    view.setTag("1");
                    csi.a(view, r.this.izC);
                }
                r.this.bzn();
            }
        };
        this.iza = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> csi = r.this.csi();
                if (csi != null) {
                    view.setTag("2");
                    csi.a(view, r.this.izC);
                }
            }
        };
        this.fVE = new TbImageView.b() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && r.this.iAc != null) {
                    r.this.iAc.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.izT = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.izU = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.izV = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.izW = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.izX = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.iAl = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.izY = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.izZ = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.amu = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.amu.setAfterClickListener(this.iza);
        this.air = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.air.setVisibility(8);
        this.iyU = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.iyU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iyU.setChildClickListener(this.iAv);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.iyU.setImageProcessor(aVar);
        this.iAb = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.iAc = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.iAd = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.izQ = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.iAh = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.anQ = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.anO = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.iAi = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.iAj = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.iAj.loop(true);
        ap.a(this.iAj, R.raw.ala_play);
        this.iAk = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.iAe = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.iAf = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.iAg = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.iAg.setVisibility(8);
        this.iAm = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.iAn = this.mRootView.findViewById(R.id.divider_line_thick);
        this.iAo = this.mRootView.findViewById(R.id.divider_line_thin);
        this.iAp = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.iAp.hideDisagree();
        if (this.iAp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iAp.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.iAp.setLayoutParams(layoutParams);
        }
        this.iAp.setOnClickListener(this.iyZ);
        this.iAp.setReplyTimeVisible(false);
        this.iAp.setShowPraiseNum(true);
        this.iAp.setNeedAddPraiseIcon(true);
        this.iAp.setNeedAddReplyIcon(true);
        this.iAp.setShareVisible(true);
        this.iAp.setIsBarViewVisible(false);
        this.iAp.setFrom(13);
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 8;
        eVar.eNH = 3;
        this.iAp.setAgreeStatisticData(eVar);
        this.iAp.setShareReportFrom(6);
        this.iAp.setStType("person_page");
        this.iAp.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.csi() != null) {
                    r.this.csi().a(view, r.this.izC);
                }
            }
        });
        this.iAs = (EMTextView) this.mRootView.findViewById(R.id.tv_ueg_view);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.iAj, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.izT, R.color.CAM_X0105);
            ap.setViewTextColor(this.izV, R.color.CAM_X0107);
            ap.setViewTextColor(this.izW, R.color.CAM_X0105);
            ap.setViewTextColor(this.izX, R.color.CAM_X0109);
            ap.setViewTextColor(this.iAl, R.color.CAM_X0109);
            ap.setViewTextColor(this.izY, R.color.CAM_X0109);
            if (this.izZ != null) {
                this.izZ.setImageDrawable(SvgManager.bsU().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.air, R.color.CAM_X0106);
            ap.setViewTextColor(this.iAf, R.color.CAM_X0106);
            if (this.iAa != null) {
                this.iAa.onChangeSkinType();
            }
            this.izQ.onChangeSkinType();
            this.iAp.onChangeSkinType();
            ap.setBackgroundColor(this.iAn, R.color.CAM_X0204);
            ap.setBackgroundColor(this.iAo, R.color.CAM_X0205);
            ap.setBackgroundColor(this.iAf, R.color.CAM_X0205);
            if (this.iAm != null) {
                this.iAm.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.iAs).nZ(R.color.CAM_X0109).ob(R.string.F_X01);
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
        this.izC = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iyZ);
        }
        this.izT.setVisibility(cardPersonDynamicThreadData.iDv ? 0 : 8);
        this.izU.setVisibility(cardPersonDynamicThreadData.iDu ? 0 : 4);
        this.iAn.setVisibility(cardPersonDynamicThreadData.iDu ? 0 : 8);
        this.iAo.setVisibility(cardPersonDynamicThreadData.iDu ? 8 : 0);
        if (cardPersonDynamicThreadData.iDw) {
            this.iAn.setVisibility(8);
            this.iAo.setVisibility(8);
        }
        this.iAq = cardPersonDynamicThreadData.iDi == 40 && cardPersonDynamicThreadData.iDl == 2;
        c(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eLr != null) {
            this.iAr = cardPersonDynamicThreadData.eLr.isShareThread && cardPersonDynamicThreadData.iDl == 2;
        }
        this.izT.setText(cardPersonDynamicThreadData.iDm);
        this.izV.setText(cardPersonDynamicThreadData.iDn);
        this.izW.setText(cardPersonDynamicThreadData.iDo);
        if (cardPersonDynamicThreadData.iDt != null && cardPersonDynamicThreadData.iDt.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.iDt.length; i++) {
                sb.append(au.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.iDt[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.iDt.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.izX.setText(sb2);
                this.izX.setVisibility(0);
            } else {
                this.izX.setText(R.string.person_homepage);
            }
        } else {
            this.izX.setText(R.string.person_homepage);
        }
        this.iAs.setVisibility(8);
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.izY.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.izY.setVisibility(0);
            }
            pA(cardPersonDynamicThreadData.isPrivacy);
            if (cardPersonDynamicThreadData.isAuthorView == 1) {
                this.izY.setVisibility(8);
                this.iAs.setVisibility(0);
            }
            this.izZ.setVisibility(0);
            this.izZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.iAa == null) {
                            r.this.iAa = new q(r.this.mPageContext);
                            r.this.iAa.create();
                            r.this.iAa.a(r.this.iAu);
                        }
                        r.this.iAa.a(r.this.izC, cardPersonDynamicThreadData.isAuthorView == 1);
                        r.this.iAa.show();
                    }
                }
            });
        } else {
            this.izY.setVisibility(8);
            this.izZ.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.iDr;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.amu.setVisibility(0);
            pz(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.amu.setVoiceModel(voiceModel);
            this.amu.setTag(voiceModel);
            this.amu.bur();
            if (voiceModel != null) {
                this.amu.Ds(voiceModel.voice_status.intValue());
            }
            this.amu.ccH();
        } else {
            this.amu.setVisibility(8);
            pz(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.iDq;
        ap.setBackgroundResource(this.iAe, R.color.transparent);
        this.iAf.setVisibility(8);
        this.iAg.setVisibility(8);
        this.iAe.setVisibility(0);
        this.iAb.setVisibility(8);
        this.iAk.setVisibility(8);
        this.iAh.setVisibility(8);
        this.iAi.setVisibility(8);
        this.iAj.cancelAnimation();
        this.iAj.setVisibility(8);
        if (cardPersonDynamicThreadData.iDi == 36) {
            this.iyU.setVisibility(8);
        } else if (cardPersonDynamicThreadData.iDi == 40 || this.izC.iDi == 50) {
            this.iyU.setVisibility(8);
            if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
                this.iAb.setVisibility(0);
                this.iAd.setVisibility(0);
                this.iAd.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iAb.getLayoutParams();
                int width = this.iAb.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.iAb.setLayoutParams(layoutParams);
                if (this.izC.videoInfo != null) {
                    this.iAc.setPlaceHolder(3);
                    this.iAc.setEvent(this.fVE);
                    this.iAc.startLoad(this.izC.videoInfo.thumbnail_url, 17, false);
                    if (this.iAq) {
                        this.iAk.setVisibility(0);
                        this.iAk.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.iAh.setVisibility(0);
                        this.anQ.setText(au.stringForVideoTime(this.izC.videoInfo.video_duration.intValue() * 1000));
                        this.anO.setText(String.format(this.mContext.getResources().getString(R.string.play_count), au.numFormatOverWan(this.izC.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.izC.iDi == 60 || this.izC.iDi == 49) {
            this.iyU.setVisibility(8);
            if (this.izC.eLr.bol() != null && this.izC.eLr.bol().user_info != null && this.izC.iDi == 60) {
                String str = this.izC.eLr.bol().user_info.user_name;
                if (ag.getTextLengthWithEmoji(str) > 14) {
                    str = ag.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.iAf.setText(m.eJ(str + ":", this.izC.eLr.getTitle()));
                this.iAf.setVisibility(0);
            } else {
                this.iAf.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
                this.iAb.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iAb.getLayoutParams();
                int width2 = this.iAb.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.iAb.setLayoutParams(layoutParams2);
                if (this.izC.eLr.bol() != null) {
                    this.iAc.setPlaceHolder(3);
                    this.iAc.setEvent(this.fVE);
                    this.iAc.startLoad(cardPersonDynamicThreadData.eLr.bol().cover, 10, false);
                    this.iAd.setVisibility(8);
                    this.iAj.setVisibility(0);
                    this.iAj.playAnimation();
                    ap.setBackgroundResource(this.iAe, R.color.CAM_X0205);
                    this.iAi.setVisibility(0);
                    this.iAi.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.izC.eLr.bol().audience_count)));
                    this.iAp.getCommentContainer().setOnClickListener(this.iyZ);
                } else {
                    this.iAp.getCommentContainer().setOnClickListener(this.iAp);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bkV().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final cb cbVar = cardPersonDynamicThreadData.eLr;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.iyU.setVisibility(0);
                    this.iyU.setFromCDN(this.amh);
                    this.iyU.setSingleImageRatio(0.67d);
                    this.iyU.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bzn();
                            } else {
                                r.this.a(view, linkedList, i2, cbVar);
                            }
                        }
                    });
                    this.iyU.setImageMediaList(linkedList);
                } else {
                    this.iyU.setVisibility(8);
                }
            } else {
                this.iyU.setVisibility(8);
            }
            this.iAe.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eLr != null && cardPersonDynamicThreadData.eLr.eUD != null) {
            this.iAm.setVisibility(0);
            this.iAm.b(cardPersonDynamicThreadData.eLr.eUD);
            this.iAm.setOnClickListener(this);
            this.amu.setVisibility(8);
            this.iyU.setVisibility(8);
            this.iAe.setVisibility(8);
            if (this.iAr) {
                this.iAl.setVisibility(0);
            } else {
                this.iAl.setVisibility(8);
            }
        } else {
            this.iAm.setVisibility(8);
            this.iAl.setVisibility(8);
        }
        csA();
        b(cardPersonDynamicThreadData);
    }

    private void pz(boolean z) {
        if (this.iyU != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iyU.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.iyU.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.iAq || this.iAr) {
                this.iAp.setCommentClickable(false);
                this.iAp.setAgreeClickable(false);
                this.iAp.setShareClickable(false);
                this.iAm.setClickable(false);
                this.izZ.setClickable(false);
            } else {
                this.iAp.setCommentClickable(true);
                this.iAp.setAgreeClickable(true);
                this.iAp.setShareClickable(true);
                this.iAm.setClickable(true);
                this.izZ.setClickable(true);
            }
            this.iAp.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.iDi == 60) {
                this.iAp.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.iDt != null) {
                this.iAp.setMultiForumCount(cardPersonDynamicThreadData.iDt.length);
            }
            if (cardPersonDynamicThreadData.eLr != null) {
                this.iAp.setForumId(String.valueOf(cardPersonDynamicThreadData.eLr.getFid()));
            }
            this.iAp.setData(cardPersonDynamicThreadData.eLr);
        }
    }

    private void csA() {
        this.amu.setClickable(true);
        int childCount = this.iyU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iyU.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void csE() {
        if (this.izC != null && this.izC.eLr != null && this.izC.eLr.bol() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.IW(this.izC.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.izC.eLr.bol());
            if (this.izC.eLr.bol().user_info != null) {
                alaLiveInfoCoreData.userName = this.izC.eLr.bol().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csF() {
        if (this.izC != null && this.izC.eLr != null && this.izC.eLr.bol() != null && this.izC.eLr.bol().share_info != null) {
            if (!isHost()) {
                m.IW(this.izC.threadId);
            }
            if (this.izC.eLr.bol().share_info.record_tid <= 0) {
                csE();
                return;
            }
            String valueOf = String.valueOf(this.izC.eLr.bol().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.izC.eLr);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzn() {
        if (this.izC != null) {
            if (!isHost()) {
                m.IW(this.izC.threadId);
                m.a(this.mTitle, this.izC.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.air, this.izC.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.izC.iDi == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.izC.eLr, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.izC.eLr.getFid()));
            pbActivityConfig.setForumName(this.izC.eLr.bnW());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.izC.eLr.isShareThread);
            pbActivityConfig.setThreadData(this.izC.eLr);
            pbActivityConfig.setIsPrivacy(this.izC.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.izC.eLr == null || !this.izC.eLr.isShareThread) {
                return;
            }
            TiebaStatic.log(new ar("c12943").dR("obj_type", "2").dR("tid", this.izC.threadId).aq("obj_param1", this.izC.isHost ? 1 : 2));
        }
    }

    private void csG() {
        if (this.izC != null && this.izC.eLr != null && this.izC.eLr.eUD != null) {
            OriginalThreadInfo originalThreadInfo = this.izC.eLr.eUD;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ar("c12943").dR("obj_type", "3").dR("tid", this.izC.threadId).aq("obj_param1", this.izC.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        if (this.izY != null) {
            if (z) {
                this.izY.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.izY.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.izY.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.izY.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.izC.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iAm) {
            csG();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iyU != null) {
            this.iyU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iyU != null) {
            this.iyU.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.amh ? 13 : 14;
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
        aVar.s(arrayList).mR(i).zQ(cbVar.bnW()).zR(String.valueOf(cbVar.getFid())).zS(cbVar.getTid()).jg(this.amh).zT(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).s(cbVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eO = aVar.eO(this.mPageContext.getPageActivity());
        eO.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
    }

    private boolean c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.eLr == null) {
            return false;
        }
        SpannableStringBuilder f = cardPersonDynamicThreadData.eLr.f(false, true, this.iAq);
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
