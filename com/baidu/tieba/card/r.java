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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes24.dex */
public class r extends b<CardPersonDynamicThreadData> {
    private TextView ahp;
    public PlayVoiceBntNew alB;
    private boolean alo;
    private TextView amS;
    private TextView amU;
    private TbImageView.a fMS;
    private CustomMessageListener iiX;
    private ConstrainImageGroup ijD;
    private View.OnClickListener ijI;
    private final View.OnClickListener ijJ;
    private TextView ikA;
    private TextView ikB;
    private TextView ikC;
    private TextView ikD;
    private ImageView ikE;
    private q ikF;
    private View ikG;
    private TbImageView ikH;
    private ImageView ikI;
    private LinearLayout ikJ;
    private TextView ikK;
    private LinearLayout ikL;
    private LinearLayout ikM;
    private TextView ikN;
    private TBLottieAnimationView ikO;
    private TextView ikP;
    private TextView ikQ;
    public OriginalThreadCardView ikR;
    private View ikS;
    private View ikT;
    public ThreadCardBottomOpSegmentLayout ikU;
    private boolean ikV;
    private boolean ikW;
    com.baidu.tieba.view.g ikX;
    private q.a ikY;
    private final View.OnClickListener ikZ;
    private CardPersonDynamicThreadData ikh;
    public ThreadViewAndCommentInfoLayout ikv;
    private final String ikw;
    private final String ikx;
    private TextView iky;
    private LinearLayout ikz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ikw = "1";
        this.ikx = "2";
        this.mSkinType = 3;
        this.alo = true;
        this.ikX = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.ikh != null && !StringUtils.isNull(r.this.ikh.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.ikh.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.CAM_X0304) : r.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.ijI = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.crI() != null) {
                    r.this.crI().a(view, r.this.ikh);
                }
                if (r.this.ikh.inM != 60) {
                    if ((r.this.ikh.inM != 40 || r.this.ikh.inP != 2) && !r.this.ikW) {
                        r.this.bAr();
                        return;
                    } else {
                        BdToast.a(r.this.getContext(), (CharSequence) r.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).brB();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.ikh.eCR.bpj().live_status != 1) {
                    r.this.cse();
                } else {
                    r.this.csd();
                }
            }
        };
        this.iiX = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.ikh != null && r.this.ikh.threadId != null && r.this.mTitle != null && r.this.ahp != null && ((String) customResponsedMessage.getData()).equals(r.this.ikh.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.ikh.threadId, (int) R.color.CAM_X0105, (int) R.color.CAM_X0109);
                    n.a(r.this.ahp, r.this.ikh.threadId, (int) R.color.CAM_X0107, (int) R.color.CAM_X0109);
                }
            }
        };
        this.ikY = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.oW(z);
            }
        };
        this.ikZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> crI = r.this.crI();
                if (crI != null) {
                    view.setTag("1");
                    crI.a(view, r.this.ikh);
                }
                r.this.bAr();
            }
        };
        this.ijJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> crI = r.this.crI();
                if (crI != null) {
                    view.setTag("2");
                    crI.a(view, r.this.ikh);
                }
            }
        };
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.ikH != null) {
                    r.this.ikH.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.iky = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.ikz = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.ikA = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.ikB = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.ikC = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.ikQ = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.ikD = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.ikE = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.alB = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.alB.setAfterClickListener(this.ijJ);
        this.ahp = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.ahp.setVisibility(8);
        this.ijD = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.ijD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.ijD.setChildClickListener(this.ikZ);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.ijD.setImageProcessor(aVar);
        this.ikG = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.ikH = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.ikI = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.ikv = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.ikM = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.amU = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.amS = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.ikN = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.ikO = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.ikO.loop(true);
        ap.a(this.ikO, (int) R.raw.ala_play);
        this.ikP = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.ikJ = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.ikK = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.ikL = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.ikL.setVisibility(8);
        this.ikR = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.ikS = this.mRootView.findViewById(R.id.divider_line_thick);
        this.ikT = this.mRootView.findViewById(R.id.divider_line_thin);
        this.ikU = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.ikU.hideDisagree();
        if (this.ikU.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ikU.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ikU.setLayoutParams(layoutParams);
        }
        this.ikU.setOnClickListener(this.ijI);
        this.ikU.setReplyTimeVisible(false);
        this.ikU.setShowPraiseNum(true);
        this.ikU.setNeedAddPraiseIcon(true);
        this.ikU.setNeedAddReplyIcon(true);
        this.ikU.setShareVisible(true);
        this.ikU.setIsBarViewVisible(false);
        this.ikU.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 8;
        dVar.eEP = 3;
        this.ikU.setAgreeStatisticData(dVar);
        this.ikU.setShareReportFrom(6);
        this.ikU.setStType("person_page");
        this.ikU.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.crI() != null) {
                    r.this.crI().a(view, r.this.ikh);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.ikO, (int) R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.iky, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.ikA, (int) R.color.CAM_X0107);
            ap.setViewTextColor(this.ikB, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.ikC, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.ikQ, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.ikD, (int) R.color.CAM_X0109);
            if (this.ikE != null) {
                this.ikE.setImageDrawable(SvgManager.btW().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.ahp, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.ikK, (int) R.color.CAM_X0106);
            if (this.ikF != null) {
                this.ikF.onChangeSkinType();
            }
            this.ikv.onChangeSkinType();
            this.ikU.onChangeSkinType();
            ap.setBackgroundColor(this.ikS, R.color.CAM_X0204);
            ap.setBackgroundColor(this.ikT, R.color.CAM_X0205);
            ap.setBackgroundColor(this.ikK, R.color.CAM_X0205);
            if (this.ikR != null) {
                this.ikR.onChangeSkinType();
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
        this.ikh = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ijI);
        }
        this.iky.setVisibility(cardPersonDynamicThreadData.inZ ? 0 : 8);
        this.ikz.setVisibility(cardPersonDynamicThreadData.inY ? 0 : 4);
        this.ikS.setVisibility(cardPersonDynamicThreadData.inY ? 0 : 8);
        this.ikT.setVisibility(cardPersonDynamicThreadData.inY ? 8 : 0);
        if (cardPersonDynamicThreadData.ioa) {
            this.ikS.setVisibility(8);
            this.ikT.setVisibility(8);
        }
        this.ikV = cardPersonDynamicThreadData.inM == 40 && cardPersonDynamicThreadData.inP == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eCR != null) {
            this.ikW = cardPersonDynamicThreadData.eCR.isShareThread && cardPersonDynamicThreadData.inP == 2;
        }
        this.iky.setText(cardPersonDynamicThreadData.inQ);
        this.ikA.setText(cardPersonDynamicThreadData.inR);
        this.ikB.setText(cardPersonDynamicThreadData.inS);
        if (cardPersonDynamicThreadData.inX != null && cardPersonDynamicThreadData.inX.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.inX.length; i++) {
                sb.append(au.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.inX[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.inX.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.ikC.setText(sb2);
                this.ikC.setVisibility(0);
            } else {
                this.ikC.setText(R.string.person_homepage);
            }
        } else {
            this.ikC.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.ikD.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.ikD.setVisibility(0);
            }
            oW(cardPersonDynamicThreadData.isPrivacy);
            this.ikE.setVisibility(0);
            this.ikE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.ikF == null) {
                            r.this.ikF = new q(r.this.mPageContext);
                            r.this.ikF.create();
                            r.this.ikF.a(r.this.ikY);
                        }
                        r.this.ikF.a(r.this.ikh);
                        r.this.ikF.show();
                    }
                }
            });
        } else {
            this.ikD.setVisibility(8);
            this.ikE.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.inV;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.alB.setVisibility(0);
            oV(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.alB.setVoiceModel(voiceModel);
            this.alB.setTag(voiceModel);
            this.alB.bvs();
            if (voiceModel != null) {
                this.alB.EM(voiceModel.voice_status.intValue());
            }
            this.alB.ccz();
        } else {
            this.alB.setVisibility(8);
            oV(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.inU;
        ap.setBackgroundResource(this.ikJ, R.color.transparent);
        this.ikK.setVisibility(8);
        this.ikL.setVisibility(8);
        this.ikJ.setVisibility(0);
        this.ikG.setVisibility(8);
        this.ikP.setVisibility(8);
        this.ikM.setVisibility(8);
        this.ikN.setVisibility(8);
        this.ikO.cancelAnimation();
        this.ikO.setVisibility(8);
        if (cardPersonDynamicThreadData.inM == 36) {
            this.ijD.setVisibility(8);
        } else if (cardPersonDynamicThreadData.inM == 40 || this.ikh.inM == 50) {
            this.ijD.setVisibility(8);
            if (com.baidu.tbadk.core.k.blV().isShowImages()) {
                this.ikG.setVisibility(0);
                this.ikI.setVisibility(0);
                this.ikI.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ikG.getLayoutParams();
                int width = this.ikG.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.ikG.setLayoutParams(layoutParams);
                if (this.ikh.videoInfo != null) {
                    this.ikH.setDefaultErrorResource(0);
                    this.ikH.setPlaceHolder(3);
                    this.ikH.setEvent(this.fMS);
                    this.ikH.startLoad(this.ikh.videoInfo.thumbnail_url, 17, false);
                    if (this.ikV) {
                        this.ikP.setVisibility(0);
                        this.ikP.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.ikM.setVisibility(0);
                        this.amU.setText(au.stringForVideoTime(this.ikh.videoInfo.video_duration.intValue() * 1000));
                        this.amS.setText(String.format(this.mContext.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ikh.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.ikh.inM == 60 || this.ikh.inM == 49) {
            this.ijD.setVisibility(8);
            if (this.ikh.eCR.bpj() != null && this.ikh.eCR.bpj().user_info != null && this.ikh.inM == 60) {
                String str = this.ikh.eCR.bpj().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.ikK.setText(n.eI(str + ":", this.ikh.eCR.getTitle()));
                this.ikK.setVisibility(0);
            } else {
                this.ikK.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.blV().isShowImages()) {
                this.ikG.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ikG.getLayoutParams();
                int width2 = this.ikG.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.ikG.setLayoutParams(layoutParams2);
                if (this.ikh.eCR.bpj() != null) {
                    this.ikH.setDefaultErrorResource(0);
                    this.ikH.setPlaceHolder(3);
                    this.ikH.setEvent(this.fMS);
                    this.ikH.startLoad(cardPersonDynamicThreadData.eCR.bpj().cover, 10, false);
                    this.ikI.setVisibility(8);
                    this.ikO.setVisibility(0);
                    this.ikO.playAnimation();
                    ap.setBackgroundResource(this.ikJ, R.color.CAM_X0205);
                    this.ikN.setVisibility(0);
                    this.ikN.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.ikh.eCR.bpj().audience_count)));
                    this.ikU.getCommentContainer().setOnClickListener(this.ijI);
                } else {
                    this.ikU.getCommentContainer().setOnClickListener(this.ikU);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.blV().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final by byVar = cardPersonDynamicThreadData.eCR;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.ijD.setVisibility(0);
                    this.ijD.setFromCDN(this.alo);
                    this.ijD.setSingleImageRatio(0.67d);
                    this.ijD.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bAr();
                            } else {
                                r.this.a(view, linkedList, i2, byVar);
                            }
                        }
                    });
                    this.ijD.setImageMediaList(linkedList);
                } else {
                    this.ijD.setVisibility(8);
                }
            } else {
                this.ijD.setVisibility(8);
            }
            this.ikJ.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eCR != null && cardPersonDynamicThreadData.eCR.eLH != null) {
            this.ikR.setVisibility(0);
            this.ikR.b(cardPersonDynamicThreadData.eCR.eLH);
            this.ikR.setOnClickListener(this);
            this.alB.setVisibility(8);
            this.ijD.setVisibility(8);
            this.ikJ.setVisibility(8);
            if (this.ikW) {
                this.ikQ.setVisibility(0);
            } else {
                this.ikQ.setVisibility(8);
            }
        } else {
            this.ikR.setVisibility(8);
            this.ikQ.setVisibility(8);
        }
        csa();
        c(cardPersonDynamicThreadData);
    }

    private void oV(boolean z) {
        if (this.ijD != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ijD.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.ijD.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ikV || this.ikW) {
                this.ikU.setCommentClickable(false);
                this.ikU.setAgreeClickable(false);
                this.ikU.setShareClickable(false);
                this.ikR.setClickable(false);
                this.ikE.setClickable(false);
            } else {
                this.ikU.setCommentClickable(true);
                this.ikU.setAgreeClickable(true);
                this.ikU.setShareClickable(true);
                this.ikR.setClickable(true);
                this.ikE.setClickable(true);
            }
            this.ikU.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.inM == 60) {
                this.ikU.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.inX != null) {
                this.ikU.setMultiForumCount(cardPersonDynamicThreadData.inX.length);
            }
            if (cardPersonDynamicThreadData.eCR != null) {
                this.ikU.setForumId(String.valueOf(cardPersonDynamicThreadData.eCR.getFid()));
            }
            this.ikU.setData(cardPersonDynamicThreadData.eCR);
        }
    }

    private void csa() {
        this.alB.setClickable(true);
        int childCount = this.ijD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ijD.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void csd() {
        if (this.ikh != null && this.ikh.eCR != null && this.ikh.eCR.bpj() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.Jq(this.ikh.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ikh.eCR.bpj());
            if (this.ikh.eCR.bpj().user_info != null) {
                alaLiveInfoCoreData.userName = this.ikh.eCR.bpj().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cse() {
        if (this.ikh != null && this.ikh.eCR != null && this.ikh.eCR.bpj() != null && this.ikh.eCR.bpj().share_info != null) {
            if (!isHost()) {
                n.Jq(this.ikh.threadId);
            }
            if (this.ikh.eCR.bpj().share_info.record_tid <= 0) {
                csd();
                return;
            }
            String valueOf = String.valueOf(this.ikh.eCR.bpj().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.ikh.eCR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAr() {
        if (this.ikh != null) {
            if (!isHost()) {
                n.Jq(this.ikh.threadId);
                n.a(this.mTitle, this.ikh.threadId, (int) R.color.CAM_X0105, (int) R.color.CAM_X0109);
                n.a(this.ahp, this.ikh.threadId, (int) R.color.CAM_X0107, (int) R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.ikh.inM == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.ikh.eCR, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.ikh.eCR.getFid()));
            pbActivityConfig.setForumName(this.ikh.eCR.boT());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.ikh.eCR.isShareThread);
            pbActivityConfig.setThreadData(this.ikh.eCR);
            pbActivityConfig.setIsPrivacy(this.ikh.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.ikh.eCR == null || !this.ikh.eCR.isShareThread) {
                return;
            }
            TiebaStatic.log(new ar("c12943").dY("obj_type", "2").dY("tid", this.ikh.threadId).al("obj_param1", this.ikh.isHost ? 1 : 2));
        }
    }

    private void csf() {
        if (this.ikh != null && this.ikh.eCR != null && this.ikh.eCR.eLH != null) {
            OriginalThreadInfo originalThreadInfo = this.ikh.eCR.eLH;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ar("c12943").dY("obj_type", "3").dY("tid", this.ikh.threadId).al("obj_param1", this.ikh.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(boolean z) {
        if (this.ikD != null) {
            if (z) {
                this.ikD.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.ikD.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.ikD.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.ikD.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.ikh.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ikR) {
            csf();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijD != null) {
            this.ijD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijD != null) {
            this.ijD.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, by byVar) {
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
                imageUrlData.urlType = this.alo ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(byVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).oj(i).AG(byVar.boT()).AH(String.valueOf(byVar.getFid())).AI(byVar.getTid()).iN(this.alo).AJ(arrayList.size() > 0 ? arrayList.get(0) : "").iO(true).a(concurrentHashMap).iP(true).s(byVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig ez = aVar.ez(this.mPageContext.getPageActivity());
        ez.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.eCR == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.eCR.e(false, true, this.ikV);
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
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.CAM_X0105, (int) R.color.CAM_X0109);
        return true;
    }
}
