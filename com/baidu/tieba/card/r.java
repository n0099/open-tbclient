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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.ae;
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
/* loaded from: classes23.dex */
public class r extends b<CardPersonDynamicThreadData> {
    private TextView agr;
    public PlayVoiceBntNew akA;
    private boolean akn;
    private TextView alS;
    private TextView alU;
    private TbImageView.a fFg;
    private ConstrainImageGroup hYG;
    private View.OnClickListener hYL;
    private final View.OnClickListener hYM;
    private CustomMessageListener hYa;
    private final String hZA;
    private final String hZB;
    private TextView hZC;
    private LinearLayout hZD;
    private TextView hZE;
    private TextView hZF;
    private TextView hZG;
    private TextView hZH;
    private ImageView hZI;
    private q hZJ;
    private View hZK;
    private TbImageView hZL;
    private ImageView hZM;
    private LinearLayout hZN;
    private TextView hZO;
    private LinearLayout hZP;
    private LinearLayout hZQ;
    private TextView hZR;
    private TBLottieAnimationView hZS;
    private TextView hZT;
    private TextView hZU;
    public OriginalThreadCardView hZV;
    private View hZW;
    private View hZX;
    public ThreadCardBottomOpSegmentLayout hZY;
    private boolean hZZ;
    private CardPersonDynamicThreadData hZk;
    public ThreadViewAndCommentInfoLayout hZz;
    private boolean iaa;
    com.baidu.tieba.view.g iab;
    private q.a iac;
    private final View.OnClickListener iad;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hZA = "1";
        this.hZB = "2";
        this.mSkinType = 3;
        this.akn = true;
        this.iab = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.hZk != null && !StringUtils.isNull(r.this.hZk.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.hZk.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.CAM_X0304) : r.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.hYL = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.cnv() != null) {
                    r.this.cnv().a(view, r.this.hZk);
                }
                if (r.this.hZk.icO != 60) {
                    if ((r.this.hZk.icO != 40 || r.this.hZk.icR != 2) && !r.this.iaa) {
                        r.this.bwR();
                        return;
                    } else {
                        BdToast.a(r.this.getContext(), (CharSequence) r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bom();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.hZk.evQ.blW().live_status != 1) {
                    r.this.cnR();
                } else {
                    r.this.cnQ();
                }
            }
        };
        this.hYa = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.hZk != null && r.this.hZk.threadId != null && r.this.mTitle != null && r.this.agr != null && ((String) customResponsedMessage.getData()).equals(r.this.hZk.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.hZk.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                    n.a(r.this.agr, r.this.hZk.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
                }
            }
        };
        this.iac = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.oA(z);
            }
        };
        this.iad = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> cnv = r.this.cnv();
                if (cnv != null) {
                    view.setTag("1");
                    cnv.a(view, r.this.hZk);
                }
                r.this.bwR();
            }
        };
        this.hYM = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> cnv = r.this.cnv();
                if (cnv != null) {
                    view.setTag("2");
                    cnv.a(view, r.this.hZk);
                }
            }
        };
        this.fFg = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.hZL != null) {
                    r.this.hZL.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hZC = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hZD = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hZE = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hZF = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hZG = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hZU = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hZH = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hZI = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.akA = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.akA.setAfterClickListener(this.hYM);
        this.agr = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.agr.setVisibility(8);
        this.hYG = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hYG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hYG.setChildClickListener(this.iad);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.hYG.setImageProcessor(aVar);
        this.hZK = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hZL = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hZM = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hZz = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hZQ = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.alU = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.alS = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hZR = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hZS = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hZS.loop(true);
        ap.a(this.hZS, R.raw.ala_play);
        this.hZT = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hZN = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hZO = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hZP = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hZP.setVisibility(8);
        this.hZV = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hZW = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hZX = this.mRootView.findViewById(R.id.divider_line_thin);
        this.hZY = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.hZY.hideDisagree();
        if (this.hZY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZY.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hZY.setLayoutParams(layoutParams);
        }
        this.hZY.setOnClickListener(this.hYL);
        this.hZY.setReplyTimeVisible(false);
        this.hZY.setShowPraiseNum(true);
        this.hZY.setNeedAddPraiseIcon(true);
        this.hZY.setNeedAddReplyIcon(true);
        this.hZY.setShareVisible(true);
        this.hZY.setIsBarViewVisible(false);
        this.hZY.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 8;
        dVar.exO = 3;
        this.hZY.setAgreeStatisticData(dVar);
        this.hZY.setShareReportFrom(6);
        this.hZY.setStType("person_page");
        this.hZY.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.cnv() != null) {
                    r.this.cnv().a(view, r.this.hZk);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hZS, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hZC, R.color.CAM_X0105);
            ap.setViewTextColor(this.hZE, R.color.CAM_X0107);
            ap.setViewTextColor(this.hZF, R.color.CAM_X0105);
            ap.setViewTextColor(this.hZG, R.color.CAM_X0109);
            ap.setViewTextColor(this.hZU, R.color.CAM_X0109);
            ap.setViewTextColor(this.hZH, R.color.CAM_X0109);
            if (this.hZI != null) {
                this.hZI.setImageDrawable(SvgManager.bqB().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setViewTextColor(this.agr, R.color.CAM_X0106);
            ap.setViewTextColor(this.hZO, R.color.CAM_X0106);
            if (this.hZJ != null) {
                this.hZJ.onChangeSkinType();
            }
            this.hZz.onChangeSkinType();
            this.hZY.onChangeSkinType();
            ap.setBackgroundColor(this.hZW, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hZX, R.color.CAM_X0205);
            ap.setBackgroundColor(this.hZO, R.color.CAM_X0205);
            if (this.hZV != null) {
                this.hZV.onChangeSkinType();
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
        this.hZk = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hYL);
        }
        this.hZC.setVisibility(cardPersonDynamicThreadData.idb ? 0 : 8);
        this.hZD.setVisibility(cardPersonDynamicThreadData.ida ? 0 : 4);
        this.hZW.setVisibility(cardPersonDynamicThreadData.ida ? 0 : 8);
        this.hZX.setVisibility(cardPersonDynamicThreadData.ida ? 8 : 0);
        if (cardPersonDynamicThreadData.idc) {
            this.hZW.setVisibility(8);
            this.hZX.setVisibility(8);
        }
        this.hZZ = cardPersonDynamicThreadData.icO == 40 && cardPersonDynamicThreadData.icR == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.evQ != null) {
            this.iaa = cardPersonDynamicThreadData.evQ.isShareThread && cardPersonDynamicThreadData.icR == 2;
        }
        this.hZC.setText(cardPersonDynamicThreadData.icS);
        this.hZE.setText(cardPersonDynamicThreadData.icT);
        this.hZF.setText(cardPersonDynamicThreadData.icU);
        if (cardPersonDynamicThreadData.icZ != null && cardPersonDynamicThreadData.icZ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.icZ.length; i++) {
                sb.append(au.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.icZ[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.icZ.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hZG.setText(sb2);
                this.hZG.setVisibility(0);
            } else {
                this.hZG.setText(R.string.person_homepage);
            }
        } else {
            this.hZG.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hZH.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hZH.setVisibility(0);
            }
            oA(cardPersonDynamicThreadData.isPrivacy);
            this.hZI.setVisibility(0);
            this.hZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.hZJ == null) {
                            r.this.hZJ = new q(r.this.mPageContext);
                            r.this.hZJ.create();
                            r.this.hZJ.a(r.this.iac);
                        }
                        r.this.hZJ.a(r.this.hZk);
                        r.this.hZJ.show();
                    }
                }
            });
        } else {
            this.hZH.setVisibility(8);
            this.hZI.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.icX;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.akA.setVisibility(0);
            oz(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.akA.setVoiceModel(voiceModel);
            this.akA.setTag(voiceModel);
            this.akA.changeSkin();
            if (voiceModel != null) {
                this.akA.DX(voiceModel.voice_status.intValue());
            }
            this.akA.bYE();
        } else {
            this.akA.setVisibility(8);
            oz(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.icW;
        ap.setBackgroundResource(this.hZN, R.color.transparent);
        this.hZO.setVisibility(8);
        this.hZP.setVisibility(8);
        this.hZN.setVisibility(0);
        this.hZK.setVisibility(8);
        this.hZT.setVisibility(8);
        this.hZQ.setVisibility(8);
        this.hZR.setVisibility(8);
        this.hZS.cancelAnimation();
        this.hZS.setVisibility(8);
        if (cardPersonDynamicThreadData.icO == 36) {
            this.hYG.setVisibility(8);
        } else if (cardPersonDynamicThreadData.icO == 40 || this.hZk.icO == 50) {
            this.hYG.setVisibility(8);
            if (com.baidu.tbadk.core.k.biL().isShowImages()) {
                this.hZK.setVisibility(0);
                this.hZM.setVisibility(0);
                this.hZM.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZK.getLayoutParams();
                int width = this.hZK.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hZK.setLayoutParams(layoutParams);
                if (this.hZk.videoInfo != null) {
                    this.hZL.setDefaultErrorResource(0);
                    this.hZL.setPlaceHolder(3);
                    this.hZL.setEvent(this.fFg);
                    this.hZL.startLoad(this.hZk.videoInfo.thumbnail_url, 17, false);
                    if (this.hZZ) {
                        this.hZT.setVisibility(0);
                        this.hZT.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hZQ.setVisibility(0);
                        this.alU.setText(au.stringForVideoTime(this.hZk.videoInfo.video_duration.intValue() * 1000));
                        this.alS.setText(String.format(this.mContext.getResources().getString(R.string.play_count), au.numFormatOverWan(this.hZk.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hZk.icO == 60 || this.hZk.icO == 49) {
            this.hYG.setVisibility(8);
            if (this.hZk.evQ.blW() != null && this.hZk.evQ.blW().user_info != null && this.hZk.icO == 60) {
                String str = this.hZk.evQ.blW().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hZO.setText(n.eD(str + ":", this.hZk.evQ.getTitle()));
                this.hZO.setVisibility(0);
            } else {
                this.hZO.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.biL().isShowImages()) {
                this.hZK.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hZK.getLayoutParams();
                int width2 = this.hZK.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hZK.setLayoutParams(layoutParams2);
                if (this.hZk.evQ.blW() != null) {
                    this.hZL.setDefaultErrorResource(0);
                    this.hZL.setPlaceHolder(3);
                    this.hZL.setEvent(this.fFg);
                    this.hZL.startLoad(cardPersonDynamicThreadData.evQ.blW().cover, 10, false);
                    this.hZM.setVisibility(8);
                    this.hZS.setVisibility(0);
                    this.hZS.playAnimation();
                    ap.setBackgroundResource(this.hZN, R.color.CAM_X0205);
                    this.hZR.setVisibility(0);
                    this.hZR.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.hZk.evQ.blW().audience_count)));
                    this.hZY.getCommentContainer().setOnClickListener(this.hYL);
                } else {
                    this.hZY.getCommentContainer().setOnClickListener(this.hZY);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.biL().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bx bxVar = cardPersonDynamicThreadData.evQ;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hYG.setVisibility(0);
                    this.hYG.setFromCDN(this.akn);
                    this.hYG.setSingleImageRatio(0.67d);
                    this.hYG.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bwR();
                            } else {
                                r.this.a(view, linkedList, i2, bxVar);
                            }
                        }
                    });
                    this.hYG.setImageMediaList(linkedList);
                } else {
                    this.hYG.setVisibility(8);
                }
            } else {
                this.hYG.setVisibility(8);
            }
            this.hZN.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.evQ != null && cardPersonDynamicThreadData.evQ.eEF != null) {
            this.hZV.setVisibility(0);
            this.hZV.b(cardPersonDynamicThreadData.evQ.eEF);
            this.hZV.setOnClickListener(this);
            this.akA.setVisibility(8);
            this.hYG.setVisibility(8);
            this.hZN.setVisibility(8);
            if (this.iaa) {
                this.hZU.setVisibility(0);
            } else {
                this.hZU.setVisibility(8);
            }
        } else {
            this.hZV.setVisibility(8);
            this.hZU.setVisibility(8);
        }
        cnN();
        c(cardPersonDynamicThreadData);
    }

    private void oz(boolean z) {
        if (this.hYG != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hYG.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hYG.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hZZ || this.iaa) {
                this.hZY.setCommentClickable(false);
                this.hZY.setAgreeClickable(false);
                this.hZY.setShareClickable(false);
                this.hZV.setClickable(false);
                this.hZI.setClickable(false);
            } else {
                this.hZY.setCommentClickable(true);
                this.hZY.setAgreeClickable(true);
                this.hZY.setShareClickable(true);
                this.hZV.setClickable(true);
                this.hZI.setClickable(true);
            }
            this.hZY.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.icO == 60) {
                this.hZY.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.icZ != null) {
                this.hZY.setMultiForumCount(cardPersonDynamicThreadData.icZ.length);
            }
            if (cardPersonDynamicThreadData.evQ != null) {
                this.hZY.setForumId(String.valueOf(cardPersonDynamicThreadData.evQ.getFid()));
            }
            this.hZY.setData(cardPersonDynamicThreadData.evQ);
        }
    }

    private void cnN() {
        this.akA.setClickable(true);
        int childCount = this.hYG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hYG.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void cnQ() {
        if (this.hZk != null && this.hZk.evQ != null && this.hZk.evQ.blW() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.IA(this.hZk.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hZk.evQ.blW());
            if (this.hZk.evQ.blW().user_info != null) {
                alaLiveInfoCoreData.userName = this.hZk.evQ.blW().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
        if (this.hZk != null && this.hZk.evQ != null && this.hZk.evQ.blW() != null && this.hZk.evQ.blW().share_info != null) {
            if (!isHost()) {
                n.IA(this.hZk.threadId);
            }
            if (this.hZk.evQ.blW().share_info.record_tid <= 0) {
                cnQ();
                return;
            }
            String valueOf = String.valueOf(this.hZk.evQ.blW().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hZk.evQ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwR() {
        if (this.hZk != null) {
            if (!isHost()) {
                n.IA(this.hZk.threadId);
                n.a(this.mTitle, this.hZk.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.agr, this.hZk.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hZk.icO == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hZk.evQ, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hZk.evQ.getFid()));
            pbActivityConfig.setForumName(this.hZk.evQ.blG());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hZk.evQ.isShareThread);
            pbActivityConfig.setThreadData(this.hZk.evQ);
            pbActivityConfig.setIsPrivacy(this.hZk.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hZk.evQ == null || !this.hZk.evQ.isShareThread) {
                return;
            }
            TiebaStatic.log(new ar("c12943").dR("obj_type", "2").dR("tid", this.hZk.threadId).ak("obj_param1", this.hZk.isHost ? 1 : 2));
        }
    }

    private void cnS() {
        if (this.hZk != null && this.hZk.evQ != null && this.hZk.evQ.eEF != null) {
            OriginalThreadInfo originalThreadInfo = this.hZk.evQ.eEF;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ar("c12943").dR("obj_type", "3").dR("tid", this.hZk.threadId).ak("obj_param1", this.hZk.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oA(boolean z) {
        if (this.hZH != null) {
            if (z) {
                this.hZH.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hZH.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hZH.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hZH.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hZk.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hZV) {
            cnS();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYG != null) {
            this.hYG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYG != null) {
            this.hYG.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bx bxVar) {
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
                imageUrlData.urlType = this.akn ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bxVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).nL(i).zZ(bxVar.blG()).Aa(String.valueOf(bxVar.getFid())).Ab(bxVar.getTid()).iy(this.akn).Ac(arrayList.size() > 0 ? arrayList.get(0) : "").iz(true).a(concurrentHashMap).iA(true).s(bxVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        dU.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.evQ == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.evQ.e(false, true, this.hZZ);
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
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
        return true;
    }
}
