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
/* loaded from: classes7.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView ahj;
    private boolean akY;
    public PlayVoiceBntNew alm;
    private TextView amG;
    private TextView amI;
    private TbImageView.b fRP;
    private CustomMessageListener iqN;
    private CardPersonDynamicThreadData irX;
    private ConstrainImageGroup irt;
    private View.OnClickListener iry;
    private final View.OnClickListener irz;
    private TextView isA;
    private LinearLayout isB;
    private LinearLayout isC;
    private TextView isD;
    private TBLottieAnimationView isE;
    private TextView isF;
    private TextView isG;
    public OriginalThreadCardView isH;
    private View isI;
    private View isJ;
    public ThreadCardBottomOpSegmentLayout isK;
    private boolean isL;
    private boolean isM;
    com.baidu.tieba.view.g isN;
    private p.a isO;
    private final View.OnClickListener isP;
    public ThreadViewAndCommentInfoLayout isl;
    private final String ism;
    private final String isn;
    private TextView iso;
    private LinearLayout isp;
    private TextView isq;
    private TextView isr;
    private TextView iss;
    private TextView ist;
    private ImageView isu;
    private p isv;
    private View isw;
    private TbImageView isx;
    private ImageView isy;
    private LinearLayout isz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ism = "1";
        this.isn = "2";
        this.mSkinType = 3;
        this.akY = true;
        this.isN = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.irX != null && !StringUtils.isNull(q.this.irX.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.irX.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.CAM_X0304) : q.this.mContext.getResources().getColor(R.color.CAM_X0302));
            }
        };
        this.iry = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cqL() != null) {
                    q.this.cqL().a(view, q.this.irX);
                }
                if (q.this.irX.ivB != 60) {
                    if ((q.this.irX.ivB != 40 || q.this.irX.ivE != 2) && !q.this.isM) {
                        q.this.byS();
                        return;
                    } else {
                        BdToast.b(q.this.getContext(), q.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.irX.eHK.bnQ().live_status != 1) {
                    q.this.crh();
                } else {
                    q.this.crg();
                }
            }
        };
        this.iqN = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.irX != null && q.this.irX.threadId != null && q.this.mTitle != null && q.this.ahj != null && ((String) customResponsedMessage.getData()).equals(q.this.irX.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.irX.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                    m.a(q.this.ahj, q.this.irX.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
                }
            }
        };
        this.isO = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.pq(z);
            }
        };
        this.isP = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cqL = q.this.cqL();
                if (cqL != null) {
                    view.setTag("1");
                    cqL.a(view, q.this.irX);
                }
                q.this.byS();
            }
        };
        this.irz = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cqL = q.this.cqL();
                if (cqL != null) {
                    view.setTag("2");
                    cqL.a(view, q.this.irX);
                }
            }
        };
        this.fRP = new TbImageView.b() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && q.this.isx != null) {
                    q.this.isx.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.iso = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.isp = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.isq = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.isr = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.iss = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.isG = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.ist = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.isu = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.alm = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.alm.setAfterClickListener(this.irz);
        this.ahj = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.ahj.setVisibility(8);
        this.irt = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.irt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.irt.setChildClickListener(this.isP);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.irt.setImageProcessor(aVar);
        this.isw = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.isx = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.isy = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.isl = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.isC = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.amI = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.amG = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.isD = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.isE = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.isE.loop(true);
        ao.a(this.isE, R.raw.ala_play);
        this.isF = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.isz = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.isA = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.isB = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.isB.setVisibility(8);
        this.isH = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.isI = this.mRootView.findViewById(R.id.divider_line_thick);
        this.isJ = this.mRootView.findViewById(R.id.divider_line_thin);
        this.isK = (ThreadCardBottomOpSegmentLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        this.isK.hideDisagree();
        if (this.isK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isK.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.isK.setLayoutParams(layoutParams);
        }
        this.isK.setOnClickListener(this.iry);
        this.isK.setReplyTimeVisible(false);
        this.isK.setShowPraiseNum(true);
        this.isK.setNeedAddPraiseIcon(true);
        this.isK.setNeedAddReplyIcon(true);
        this.isK.setShareVisible(true);
        this.isK.setIsBarViewVisible(false);
        this.isK.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJO = 8;
        dVar.eJU = 3;
        this.isK.setAgreeStatisticData(dVar);
        this.isK.setShareReportFrom(6);
        this.isK.setStType("person_page");
        this.isK.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cqL() != null) {
                    q.this.cqL().a(view, q.this.irX);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.a(this.isE, R.raw.ala_play);
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setViewTextColor(this.iso, R.color.CAM_X0105);
            ao.setViewTextColor(this.isq, R.color.CAM_X0107);
            ao.setViewTextColor(this.isr, R.color.CAM_X0105);
            ao.setViewTextColor(this.iss, R.color.CAM_X0109);
            ao.setViewTextColor(this.isG, R.color.CAM_X0109);
            ao.setViewTextColor(this.ist, R.color.CAM_X0109);
            if (this.isu != null) {
                this.isu.setImageDrawable(SvgManager.bsx().a(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setViewTextColor(this.ahj, R.color.CAM_X0106);
            ao.setViewTextColor(this.isA, R.color.CAM_X0106);
            if (this.isv != null) {
                this.isv.onChangeSkinType();
            }
            this.isl.onChangeSkinType();
            this.isK.onChangeSkinType();
            ao.setBackgroundColor(this.isI, R.color.CAM_X0204);
            ao.setBackgroundColor(this.isJ, R.color.CAM_X0205);
            ao.setBackgroundColor(this.isA, R.color.CAM_X0205);
            if (this.isH != null) {
                this.isH.onChangeSkinType();
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
        this.irX = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iry);
        }
        this.iso.setVisibility(cardPersonDynamicThreadData.ivO ? 0 : 8);
        this.isp.setVisibility(cardPersonDynamicThreadData.ivN ? 0 : 4);
        this.isI.setVisibility(cardPersonDynamicThreadData.ivN ? 0 : 8);
        this.isJ.setVisibility(cardPersonDynamicThreadData.ivN ? 8 : 0);
        if (cardPersonDynamicThreadData.ivP) {
            this.isI.setVisibility(8);
            this.isJ.setVisibility(8);
        }
        this.isL = cardPersonDynamicThreadData.ivB == 40 && cardPersonDynamicThreadData.ivE == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.eHK != null) {
            this.isM = cardPersonDynamicThreadData.eHK.isShareThread && cardPersonDynamicThreadData.ivE == 2;
        }
        this.iso.setText(cardPersonDynamicThreadData.ivF);
        this.isq.setText(cardPersonDynamicThreadData.ivG);
        this.isr.setText(cardPersonDynamicThreadData.ivH);
        if (cardPersonDynamicThreadData.ivM != null && cardPersonDynamicThreadData.ivM.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.ivM.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.ivM[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.ivM.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.iss.setText(sb2);
                this.iss.setVisibility(0);
            } else {
                this.iss.setText(R.string.person_homepage);
            }
        } else {
            this.iss.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.ist.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.ist.setVisibility(0);
            }
            pq(cardPersonDynamicThreadData.isPrivacy);
            this.isu.setVisibility(0);
            this.isu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.isv == null) {
                            q.this.isv = new p(q.this.mPageContext);
                            q.this.isv.create();
                            q.this.isv.a(q.this.isO);
                        }
                        q.this.isv.a(q.this.irX);
                        q.this.isv.show();
                    }
                }
            });
        } else {
            this.ist.setVisibility(8);
            this.isu.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.ivK;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.alm.setVisibility(0);
            pp(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.alm.setVoiceModel(voiceModel);
            this.alm.setTag(voiceModel);
            this.alm.btU();
            if (voiceModel != null) {
                this.alm.CY(voiceModel.voice_status.intValue());
            }
            this.alm.cbz();
        } else {
            this.alm.setVisibility(8);
            pp(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.ivJ;
        ao.setBackgroundResource(this.isz, R.color.transparent);
        this.isA.setVisibility(8);
        this.isB.setVisibility(8);
        this.isz.setVisibility(0);
        this.isw.setVisibility(8);
        this.isF.setVisibility(8);
        this.isC.setVisibility(8);
        this.isD.setVisibility(8);
        this.isE.cancelAnimation();
        this.isE.setVisibility(8);
        if (cardPersonDynamicThreadData.ivB == 36) {
            this.irt.setVisibility(8);
        } else if (cardPersonDynamicThreadData.ivB == 40 || this.irX.ivB == 50) {
            this.irt.setVisibility(8);
            if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
                this.isw.setVisibility(0);
                this.isy.setVisibility(0);
                this.isy.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isw.getLayoutParams();
                int width = this.isw.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.isw.setLayoutParams(layoutParams);
                if (this.irX.videoInfo != null) {
                    this.isx.setPlaceHolder(3);
                    this.isx.setEvent(this.fRP);
                    this.isx.startLoad(this.irX.videoInfo.thumbnail_url, 17, false);
                    if (this.isL) {
                        this.isF.setVisibility(0);
                        this.isF.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.isC.setVisibility(0);
                        this.amI.setText(at.stringForVideoTime(this.irX.videoInfo.video_duration.intValue() * 1000));
                        this.amG.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.irX.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.irX.ivB == 60 || this.irX.ivB == 49) {
            this.irt.setVisibility(8);
            if (this.irX.eHK.bnQ() != null && this.irX.eHK.bnQ().user_info != null && this.irX.ivB == 60) {
                String str = this.irX.eHK.bnQ().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.isA.setText(m.eI(str + ":", this.irX.eHK.getTitle()));
                this.isA.setVisibility(0);
            } else {
                this.isA.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
                this.isw.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.isw.getLayoutParams();
                int width2 = this.isw.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.isw.setLayoutParams(layoutParams2);
                if (this.irX.eHK.bnQ() != null) {
                    this.isx.setPlaceHolder(3);
                    this.isx.setEvent(this.fRP);
                    this.isx.startLoad(cardPersonDynamicThreadData.eHK.bnQ().cover, 10, false);
                    this.isy.setVisibility(8);
                    this.isE.setVisibility(0);
                    this.isE.playAnimation();
                    ao.setBackgroundResource(this.isz, R.color.CAM_X0205);
                    this.isD.setVisibility(0);
                    this.isD.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.irX.eHK.bnQ().audience_count)));
                    this.isK.getCommentContainer().setOnClickListener(this.iry);
                } else {
                    this.isK.getCommentContainer().setOnClickListener(this.isK);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bkB().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bz bzVar = cardPersonDynamicThreadData.eHK;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(linkedList) > 0) {
                    this.irt.setVisibility(0);
                    this.irt.setFromCDN(this.akY);
                    this.irt.setSingleImageRatio(0.67d);
                    this.irt.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                q.this.byS();
                            } else {
                                q.this.a(view, linkedList, i2, bzVar);
                            }
                        }
                    });
                    this.irt.setImageMediaList(linkedList);
                } else {
                    this.irt.setVisibility(8);
                }
            } else {
                this.irt.setVisibility(8);
            }
            this.isz.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.eHK != null && cardPersonDynamicThreadData.eHK.eQQ != null) {
            this.isH.setVisibility(0);
            this.isH.b(cardPersonDynamicThreadData.eHK.eQQ);
            this.isH.setOnClickListener(this);
            this.alm.setVisibility(8);
            this.irt.setVisibility(8);
            this.isz.setVisibility(8);
            if (this.isM) {
                this.isG.setVisibility(0);
            } else {
                this.isG.setVisibility(8);
            }
        } else {
            this.isH.setVisibility(8);
            this.isG.setVisibility(8);
        }
        crd();
        c(cardPersonDynamicThreadData);
    }

    private void pp(boolean z) {
        if (this.irt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.irt.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.irt.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.isL || this.isM) {
                this.isK.setCommentClickable(false);
                this.isK.setAgreeClickable(false);
                this.isK.setShareClickable(false);
                this.isH.setClickable(false);
                this.isu.setClickable(false);
            } else {
                this.isK.setCommentClickable(true);
                this.isK.setAgreeClickable(true);
                this.isK.setShareClickable(true);
                this.isH.setClickable(true);
                this.isu.setClickable(true);
            }
            this.isK.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.ivB == 60) {
                this.isK.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.ivM != null) {
                this.isK.setMultiForumCount(cardPersonDynamicThreadData.ivM.length);
            }
            if (cardPersonDynamicThreadData.eHK != null) {
                this.isK.setForumId(String.valueOf(cardPersonDynamicThreadData.eHK.getFid()));
            }
            this.isK.setData(cardPersonDynamicThreadData.eHK);
        }
    }

    private void crd() {
        this.alm.setClickable(true);
        int childCount = this.irt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.irt.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void crg() {
        if (this.irX != null && this.irX.eHK != null && this.irX.eHK.bnQ() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Ic(this.irX.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.irX.eHK.bnQ());
            if (this.irX.eHK.bnQ().user_info != null) {
                alaLiveInfoCoreData.userName = this.irX.eHK.bnQ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crh() {
        if (this.irX != null && this.irX.eHK != null && this.irX.eHK.bnQ() != null && this.irX.eHK.bnQ().share_info != null) {
            if (!isHost()) {
                m.Ic(this.irX.threadId);
            }
            if (this.irX.eHK.bnQ().share_info.record_tid <= 0) {
                crg();
                return;
            }
            String valueOf = String.valueOf(this.irX.eHK.bnQ().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.irX.eHK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byS() {
        if (this.irX != null) {
            if (!isHost()) {
                m.Ic(this.irX.threadId);
                m.a(this.mTitle, this.irX.threadId, R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.ahj, this.irX.threadId, R.color.CAM_X0107, R.color.CAM_X0109);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.irX.ivB == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.irX.eHK, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.irX.eHK.getFid()));
            pbActivityConfig.setForumName(this.irX.eHK.bnB());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.irX.eHK.isShareThread);
            pbActivityConfig.setThreadData(this.irX.eHK);
            pbActivityConfig.setIsPrivacy(this.irX.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.irX.eHK == null || !this.irX.eHK.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dW("obj_type", "2").dW("tid", this.irX.threadId).an("obj_param1", this.irX.isHost ? 1 : 2));
        }
    }

    private void cri() {
        if (this.irX != null && this.irX.eHK != null && this.irX.eHK.eQQ != null) {
            OriginalThreadInfo originalThreadInfo = this.irX.eHK.eQQ;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dW("obj_type", "3").dW("tid", this.irX.threadId).an("obj_param1", this.irX.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(boolean z) {
        if (this.ist != null) {
            if (z) {
                this.ist.setText(R.string.privacy);
                Drawable drawable = ao.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.ist.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.ist.setText(R.string.public_open);
            Drawable drawable2 = ao.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.ist.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.irX.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.isH) {
            cri();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.irt != null) {
            this.irt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.irt != null) {
            this.irt.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.akY ? 13 : 14;
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
        aVar.s(arrayList).mN(i).zs(bzVar.bnB()).zt(String.valueOf(bzVar.getFid())).zu(bzVar.getTid()).je(this.akY).zv(arrayList.size() > 0 ? arrayList.get(0) : "").jf(true).d(concurrentHashMap).jg(true).s(bzVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eQ = aVar.eQ(this.mPageContext.getPageActivity());
        eQ.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.eHK == null) {
            return false;
        }
        SpannableStringBuilder f = cardPersonDynamicThreadData.eHK.f(false, true, this.isL);
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
