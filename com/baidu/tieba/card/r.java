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
    private CustomMessageListener iiZ;
    private ConstrainImageGroup ijF;
    private View.OnClickListener ijK;
    private final View.OnClickListener ijL;
    private TextView ikA;
    private LinearLayout ikB;
    private TextView ikC;
    private TextView ikD;
    private TextView ikE;
    private TextView ikF;
    private ImageView ikG;
    private q ikH;
    private View ikI;
    private TbImageView ikJ;
    private ImageView ikK;
    private LinearLayout ikL;
    private TextView ikM;
    private LinearLayout ikN;
    private LinearLayout ikO;
    private TextView ikP;
    private TBLottieAnimationView ikQ;
    private TextView ikR;
    private TextView ikS;
    public OriginalThreadCardView ikT;
    private View ikU;
    private View ikV;
    public ThreadCardBottomOpSegmentLayout ikW;
    private boolean ikX;
    private boolean ikY;
    com.baidu.tieba.view.g ikZ;
    private CardPersonDynamicThreadData ikj;
    public ThreadViewAndCommentInfoLayout ikx;
    private final String iky;
    private final String ikz;
    private q.a ila;
    private final View.OnClickListener ilb;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iky = "1";
        this.ikz = "2";
        this.mSkinType = 3;
        this.alo = true;
        this.ikZ = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.ikj != null && !StringUtils.isNull(r.this.ikj.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.ikj.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.CAM_X0304) : r.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.ijK = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.crJ() != null) {
                    r.this.crJ().a(view, r.this.ikj);
                }
                if (r.this.ikj.inO != 60) {
                    if ((r.this.ikj.inO != 40 || r.this.ikj.inR != 2) && !r.this.ikY) {
                        r.this.bAr();
                        return;
                    } else {
                        BdToast.a(r.this.getContext(), (CharSequence) r.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).brB();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.ikj.eCR.bpj().live_status != 1) {
                    r.this.csf();
                } else {
                    r.this.cse();
                }
            }
        };
        this.iiZ = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.ikj != null && r.this.ikj.threadId != null && r.this.mTitle != null && r.this.ahp != null && ((String) customResponsedMessage.getData()).equals(r.this.ikj.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.ikj.threadId, (int) R.color.CAM_X0105, (int) R.color.CAM_X0109);
                    n.a(r.this.ahp, r.this.ikj.threadId, (int) R.color.CAM_X0107, (int) R.color.CAM_X0109);
                }
            }
        };
        this.ila = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.oW(z);
            }
        };
        this.ilb = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> crJ = r.this.crJ();
                if (crJ != null) {
                    view.setTag("1");
                    crJ.a(view, r.this.ikj);
                }
                r.this.bAr();
            }
        };
        this.ijL = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> crJ = r.this.crJ();
                if (crJ != null) {
                    view.setTag("2");
                    crJ.a(view, r.this.ikj);
                }
            }
        };
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.ikJ != null) {
                    r.this.ikJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.ikA = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.ikB = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.ikC = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.ikD = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.ikE = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.ikS = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.ikF = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.ikG = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.alB = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.alB.setAfterClickListener(this.ijL);
        this.ahp = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.ahp.setVisibility(8);
        this.ijF = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.ijF.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.ijF.setChildClickListener(this.ilb);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.ijF.setImageProcessor(aVar);
        this.ikI = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.ikJ = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.ikK = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.ikx = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.ikO = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.amU = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.amS = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.ikP = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.ikQ = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.ikQ.loop(true);
        ap.a(this.ikQ, (int) R.raw.ala_play);
        this.ikR = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.ikL = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.ikM = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.ikN = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.ikN.setVisibility(8);
        this.ikT = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.ikU = this.mRootView.findViewById(R.id.divider_line_thick);
        this.ikV = this.mRootView.findViewById(R.id.divider_line_thin);
        this.ikW = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.ikW.hideDisagree();
        if (this.ikW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ikW.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ikW.setLayoutParams(layoutParams);
        }
        this.ikW.setOnClickListener(this.ijK);
        this.ikW.setReplyTimeVisible(false);
        this.ikW.setShowPraiseNum(true);
        this.ikW.setNeedAddPraiseIcon(true);
        this.ikW.setNeedAddReplyIcon(true);
        this.ikW.setShareVisible(true);
        this.ikW.setIsBarViewVisible(false);
        this.ikW.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 8;
        dVar.eEP = 3;
        this.ikW.setAgreeStatisticData(dVar);
        this.ikW.setShareReportFrom(6);
        this.ikW.setStType("person_page");
        this.ikW.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.crJ() != null) {
                    r.this.crJ().a(view, r.this.ikj);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.ikQ, (int) R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.ikA, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.ikC, (int) R.color.CAM_X0107);
            ap.setViewTextColor(this.ikD, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.ikE, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.ikS, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.ikF, (int) R.color.CAM_X0109);
            if (this.ikG != null) {
                this.ikG.setImageDrawable(SvgManager.btW().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.ahp, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.ikM, (int) R.color.CAM_X0106);
            if (this.ikH != null) {
                this.ikH.onChangeSkinType();
            }
            this.ikx.onChangeSkinType();
            this.ikW.onChangeSkinType();
            ap.setBackgroundColor(this.ikU, R.color.CAM_X0204);
            ap.setBackgroundColor(this.ikV, R.color.CAM_X0205);
            ap.setBackgroundColor(this.ikM, R.color.CAM_X0205);
            if (this.ikT != null) {
                this.ikT.onChangeSkinType();
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
        this.ikj = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ijK);
        }
        this.ikA.setVisibility(cardPersonDynamicThreadData.iob ? 0 : 8);
        this.ikB.setVisibility(cardPersonDynamicThreadData.ioa ? 0 : 4);
        this.ikU.setVisibility(cardPersonDynamicThreadData.ioa ? 0 : 8);
        this.ikV.setVisibility(cardPersonDynamicThreadData.ioa ? 8 : 0);
        if (cardPersonDynamicThreadData.ioc) {
            this.ikU.setVisibility(8);
            this.ikV.setVisibility(8);
        }
        this.ikX = cardPersonDynamicThreadData.inO == 40 && cardPersonDynamicThreadData.inR == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eCR != null) {
            this.ikY = cardPersonDynamicThreadData.eCR.isShareThread && cardPersonDynamicThreadData.inR == 2;
        }
        this.ikA.setText(cardPersonDynamicThreadData.inS);
        this.ikC.setText(cardPersonDynamicThreadData.inT);
        this.ikD.setText(cardPersonDynamicThreadData.inU);
        if (cardPersonDynamicThreadData.inZ != null && cardPersonDynamicThreadData.inZ.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.inZ.length; i++) {
                sb.append(au.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.inZ[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.inZ.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.ikE.setText(sb2);
                this.ikE.setVisibility(0);
            } else {
                this.ikE.setText(R.string.person_homepage);
            }
        } else {
            this.ikE.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.ikF.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.ikF.setVisibility(0);
            }
            oW(cardPersonDynamicThreadData.isPrivacy);
            this.ikG.setVisibility(0);
            this.ikG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.ikH == null) {
                            r.this.ikH = new q(r.this.mPageContext);
                            r.this.ikH.create();
                            r.this.ikH.a(r.this.ila);
                        }
                        r.this.ikH.a(r.this.ikj);
                        r.this.ikH.show();
                    }
                }
            });
        } else {
            this.ikF.setVisibility(8);
            this.ikG.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.inX;
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
            this.alB.ccA();
        } else {
            this.alB.setVisibility(8);
            oV(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.inW;
        ap.setBackgroundResource(this.ikL, R.color.transparent);
        this.ikM.setVisibility(8);
        this.ikN.setVisibility(8);
        this.ikL.setVisibility(0);
        this.ikI.setVisibility(8);
        this.ikR.setVisibility(8);
        this.ikO.setVisibility(8);
        this.ikP.setVisibility(8);
        this.ikQ.cancelAnimation();
        this.ikQ.setVisibility(8);
        if (cardPersonDynamicThreadData.inO == 36) {
            this.ijF.setVisibility(8);
        } else if (cardPersonDynamicThreadData.inO == 40 || this.ikj.inO == 50) {
            this.ijF.setVisibility(8);
            if (com.baidu.tbadk.core.k.blV().isShowImages()) {
                this.ikI.setVisibility(0);
                this.ikK.setVisibility(0);
                this.ikK.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ikI.getLayoutParams();
                int width = this.ikI.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.ikI.setLayoutParams(layoutParams);
                if (this.ikj.videoInfo != null) {
                    this.ikJ.setDefaultErrorResource(0);
                    this.ikJ.setPlaceHolder(3);
                    this.ikJ.setEvent(this.fMS);
                    this.ikJ.startLoad(this.ikj.videoInfo.thumbnail_url, 17, false);
                    if (this.ikX) {
                        this.ikR.setVisibility(0);
                        this.ikR.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.ikO.setVisibility(0);
                        this.amU.setText(au.stringForVideoTime(this.ikj.videoInfo.video_duration.intValue() * 1000));
                        this.amS.setText(String.format(this.mContext.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ikj.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.ikj.inO == 60 || this.ikj.inO == 49) {
            this.ijF.setVisibility(8);
            if (this.ikj.eCR.bpj() != null && this.ikj.eCR.bpj().user_info != null && this.ikj.inO == 60) {
                String str = this.ikj.eCR.bpj().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.ikM.setText(n.eI(str + ":", this.ikj.eCR.getTitle()));
                this.ikM.setVisibility(0);
            } else {
                this.ikM.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.blV().isShowImages()) {
                this.ikI.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ikI.getLayoutParams();
                int width2 = this.ikI.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.ikI.setLayoutParams(layoutParams2);
                if (this.ikj.eCR.bpj() != null) {
                    this.ikJ.setDefaultErrorResource(0);
                    this.ikJ.setPlaceHolder(3);
                    this.ikJ.setEvent(this.fMS);
                    this.ikJ.startLoad(cardPersonDynamicThreadData.eCR.bpj().cover, 10, false);
                    this.ikK.setVisibility(8);
                    this.ikQ.setVisibility(0);
                    this.ikQ.playAnimation();
                    ap.setBackgroundResource(this.ikL, R.color.CAM_X0205);
                    this.ikP.setVisibility(0);
                    this.ikP.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.ikj.eCR.bpj().audience_count)));
                    this.ikW.getCommentContainer().setOnClickListener(this.ijK);
                } else {
                    this.ikW.getCommentContainer().setOnClickListener(this.ikW);
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
                    this.ijF.setVisibility(0);
                    this.ijF.setFromCDN(this.alo);
                    this.ijF.setSingleImageRatio(0.67d);
                    this.ijF.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bAr();
                            } else {
                                r.this.a(view, linkedList, i2, byVar);
                            }
                        }
                    });
                    this.ijF.setImageMediaList(linkedList);
                } else {
                    this.ijF.setVisibility(8);
                }
            } else {
                this.ijF.setVisibility(8);
            }
            this.ikL.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eCR != null && cardPersonDynamicThreadData.eCR.eLH != null) {
            this.ikT.setVisibility(0);
            this.ikT.b(cardPersonDynamicThreadData.eCR.eLH);
            this.ikT.setOnClickListener(this);
            this.alB.setVisibility(8);
            this.ijF.setVisibility(8);
            this.ikL.setVisibility(8);
            if (this.ikY) {
                this.ikS.setVisibility(0);
            } else {
                this.ikS.setVisibility(8);
            }
        } else {
            this.ikT.setVisibility(8);
            this.ikS.setVisibility(8);
        }
        csb();
        c(cardPersonDynamicThreadData);
    }

    private void oV(boolean z) {
        if (this.ijF != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ijF.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.ijF.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ikX || this.ikY) {
                this.ikW.setCommentClickable(false);
                this.ikW.setAgreeClickable(false);
                this.ikW.setShareClickable(false);
                this.ikT.setClickable(false);
                this.ikG.setClickable(false);
            } else {
                this.ikW.setCommentClickable(true);
                this.ikW.setAgreeClickable(true);
                this.ikW.setShareClickable(true);
                this.ikT.setClickable(true);
                this.ikG.setClickable(true);
            }
            this.ikW.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.inO == 60) {
                this.ikW.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.inZ != null) {
                this.ikW.setMultiForumCount(cardPersonDynamicThreadData.inZ.length);
            }
            if (cardPersonDynamicThreadData.eCR != null) {
                this.ikW.setForumId(String.valueOf(cardPersonDynamicThreadData.eCR.getFid()));
            }
            this.ikW.setData(cardPersonDynamicThreadData.eCR);
        }
    }

    private void csb() {
        this.alB.setClickable(true);
        int childCount = this.ijF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ijF.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void cse() {
        if (this.ikj != null && this.ikj.eCR != null && this.ikj.eCR.bpj() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.Jq(this.ikj.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.ikj.eCR.bpj());
            if (this.ikj.eCR.bpj().user_info != null) {
                alaLiveInfoCoreData.userName = this.ikj.eCR.bpj().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csf() {
        if (this.ikj != null && this.ikj.eCR != null && this.ikj.eCR.bpj() != null && this.ikj.eCR.bpj().share_info != null) {
            if (!isHost()) {
                n.Jq(this.ikj.threadId);
            }
            if (this.ikj.eCR.bpj().share_info.record_tid <= 0) {
                cse();
                return;
            }
            String valueOf = String.valueOf(this.ikj.eCR.bpj().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.ikj.eCR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAr() {
        if (this.ikj != null) {
            if (!isHost()) {
                n.Jq(this.ikj.threadId);
                n.a(this.mTitle, this.ikj.threadId, (int) R.color.CAM_X0105, (int) R.color.CAM_X0109);
                n.a(this.ahp, this.ikj.threadId, (int) R.color.CAM_X0107, (int) R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.ikj.inO == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.ikj.eCR, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.ikj.eCR.getFid()));
            pbActivityConfig.setForumName(this.ikj.eCR.boT());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.ikj.eCR.isShareThread);
            pbActivityConfig.setThreadData(this.ikj.eCR);
            pbActivityConfig.setIsPrivacy(this.ikj.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.ikj.eCR == null || !this.ikj.eCR.isShareThread) {
                return;
            }
            TiebaStatic.log(new ar("c12943").dY("obj_type", "2").dY("tid", this.ikj.threadId).al("obj_param1", this.ikj.isHost ? 1 : 2));
        }
    }

    private void csg() {
        if (this.ikj != null && this.ikj.eCR != null && this.ikj.eCR.eLH != null) {
            OriginalThreadInfo originalThreadInfo = this.ikj.eCR.eLH;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new ar("c12943").dY("obj_type", "3").dY("tid", this.ikj.threadId).al("obj_param1", this.ikj.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(boolean z) {
        if (this.ikF != null) {
            if (z) {
                this.ikF.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.ikF.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.ikF.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.ikF.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.ikj.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ikT) {
            csg();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijF != null) {
            this.ijF.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijF != null) {
            this.ijF.setImageViewPool(bVar);
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
        SpannableStringBuilder e = cardPersonDynamicThreadData.eCR.e(false, true, this.ikX);
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
