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
    private TextView KA;
    private boolean NJ;
    public PlayVoiceBntNew NY;
    private TextView Pb;
    private TextView Pe;
    private TbImageView.a dMe;
    public ThreadCommentAndPraiseInfoLayout eNl;
    private ConstrainImageGroup fJN;
    private View.OnClickListener fJS;
    private final View.OnClickListener fJT;
    private CustomMessageListener fJj;
    public ThreadViewAndCommentInfoLayout fKD;
    private final String fKE;
    private final String fKF;
    private TextView fKG;
    private LinearLayout fKH;
    private TextView fKI;
    private TextView fKJ;
    private TextView fKK;
    private TextView fKL;
    private ImageView fKM;
    private o fKN;
    private View fKO;
    private TbImageView fKP;
    private ImageView fKQ;
    private LinearLayout fKR;
    private TextView fKS;
    private LinearLayout fKT;
    private LinearLayout fKU;
    private TextView fKV;
    private TBLottieAnimationView fKW;
    private TextView fKX;
    private TextView fKY;
    public OriginalThreadCardView fKZ;
    private CardPersonDynamicThreadData fKr;
    private View fLa;
    private View fLb;
    private boolean fLc;
    private boolean fLd;
    com.baidu.tieba.view.f fLe;
    private o.a fLf;
    private final View.OnClickListener fLg;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fKE = "1";
        this.fKF = "2";
        this.mSkinType = 3;
        this.NJ = true;
        this.fLe = new com.baidu.tieba.view.f() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.fKr != null && !StringUtils.isNull(p.this.fKr.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.fKr.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.f
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.fJS = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.buE() != null) {
                    p.this.buE().a(view, p.this.fKr);
                }
                if (p.this.fKr.fNC != 60) {
                    if ((p.this.fKr.fNC != 40 || p.this.fKr.fNE != 2) && !p.this.fLd) {
                        p.this.aMw();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEF();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.fKr.cRe.aCF().live_status != 1) {
                    p.this.bvc();
                } else {
                    p.this.bvb();
                }
            }
        };
        this.fJj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.fKr != null && p.this.fKr.threadId != null && p.this.mTitle != null && p.this.KA != null && ((String) customResponsedMessage.getData()).equals(p.this.fKr.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.fKr.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.KA, p.this.fKr.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.fLf = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.ko(z);
            }
        };
        this.fLg = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> buE = p.this.buE();
                if (buE != null) {
                    view.setTag("1");
                    buE.a(view, p.this.fKr);
                }
                p.this.aMw();
            }
        };
        this.fJT = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> buE = p.this.buE();
                if (buE != null) {
                    view.setTag("2");
                    buE.a(view, p.this.fKr);
                }
            }
        };
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.fKP != null) {
                    p.this.fKP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.fKG = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.fKH = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.fKI = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.fKJ = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.fKK = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.fKY = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.fKL = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.fKM = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.NY = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fJT);
        this.KA = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.KA.setVisibility(8);
        this.fJN = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.fJN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fJN.setChildClickListener(this.fLg);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.fJN.setImageProcessor(aVar);
        this.fKO = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.fKP = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.fKQ = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.fKD = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.fKU = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.Pe = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.Pb = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.fKV = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.fKW = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fKW.loop(true);
        am.a(this.fKW, R.raw.ala_play);
        this.fKX = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.fKR = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.fKS = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.fKT = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.fKT.setVisibility(8);
        this.fKZ = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.fLa = this.mRootView.findViewById(R.id.divider_line_thick);
        this.fLb = this.mRootView.findViewById(R.id.divider_line_thin);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.eNl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNl.setLayoutParams(layoutParams);
        }
        this.eNl.setOnClickListener(this.fJS);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setShareVisible(true);
        this.eNl.setIsBarViewVisible(false);
        this.eNl.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 8;
        dVar.cNG = 3;
        this.eNl.setAgreeStatisticData(dVar);
        this.eNl.setShareReportFrom(6);
        this.eNl.setStType("person_page");
        this.eNl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.buE() != null) {
                    p.this.buE().a(view, p.this.fKr);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.fKW, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.fKG, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fKI, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.fKJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fKK, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fKY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fKL, (int) R.color.cp_cont_d);
            if (this.fKM != null) {
                this.fKM.setImageDrawable(SvgManager.aGA().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.KA, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fKS, (int) R.color.cp_cont_f);
            if (this.fKN != null) {
                this.fKN.onChangeSkinType();
            }
            this.fKD.onChangeSkinType();
            this.eNl.onChangeSkinType();
            am.setBackgroundColor(this.fLa, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fLb, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.fKS, R.color.cp_bg_line_e);
            if (this.fKZ != null) {
                this.fKZ.onChangeSkinType();
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
        this.fKr = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fJS);
        }
        this.fKG.setVisibility(cardPersonDynamicThreadData.fNO ? 0 : 8);
        this.fKH.setVisibility(cardPersonDynamicThreadData.fNN ? 0 : 4);
        this.fLa.setVisibility(cardPersonDynamicThreadData.fNN ? 0 : 8);
        this.fLb.setVisibility(cardPersonDynamicThreadData.fNN ? 8 : 0);
        if (cardPersonDynamicThreadData.fNP) {
            this.fLa.setVisibility(8);
            this.fLb.setVisibility(8);
        }
        this.fLc = cardPersonDynamicThreadData.fNC == 40 && cardPersonDynamicThreadData.fNE == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.cRe != null) {
            this.fLd = cardPersonDynamicThreadData.cRe.isShareThread && cardPersonDynamicThreadData.fNE == 2;
        }
        this.fKG.setText(cardPersonDynamicThreadData.fNF);
        this.fKI.setText(cardPersonDynamicThreadData.fNG);
        this.fKJ.setText(cardPersonDynamicThreadData.fNH);
        if (cardPersonDynamicThreadData.fNM != null && cardPersonDynamicThreadData.fNM.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.fNM.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.fNM[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.fNM.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.fKK.setText(sb2);
                this.fKK.setVisibility(0);
            } else {
                this.fKK.setText(R.string.person_homepage);
            }
        } else {
            this.fKK.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.fKL.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.fKL.setVisibility(0);
            }
            ko(cardPersonDynamicThreadData.isPrivacy);
            this.fKM.setVisibility(0);
            this.fKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.fKN == null) {
                            p.this.fKN = new o(p.this.mPageContext);
                            p.this.fKN.create();
                            p.this.fKN.a(p.this.fLf);
                        }
                        p.this.fKN.a(p.this.fKr);
                        p.this.fKN.show();
                    }
                }
            });
        } else {
            this.fKL.setVisibility(8);
            this.fKM.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.fNK;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.NY.setVisibility(0);
            kn(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHq();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
            this.NY.cMf();
        } else {
            this.NY.setVisibility(8);
            kn(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.fNJ;
        am.setBackgroundResource(this.fKR, R.color.transparent);
        this.fKS.setVisibility(8);
        this.fKT.setVisibility(8);
        this.fKR.setVisibility(0);
        this.fKO.setVisibility(8);
        this.fKX.setVisibility(8);
        this.fKU.setVisibility(8);
        this.fKV.setVisibility(8);
        this.fKW.cancelAnimation();
        this.fKW.setVisibility(8);
        if (cardPersonDynamicThreadData.fNC == 36) {
            this.fJN.setVisibility(8);
        } else if (cardPersonDynamicThreadData.fNC == 40 || this.fKr.fNC == 50) {
            this.fJN.setVisibility(8);
            if (com.baidu.tbadk.core.i.azM().isShowImages()) {
                this.fKO.setVisibility(0);
                this.fKQ.setVisibility(0);
                this.fKQ.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKO.getLayoutParams();
                int width = this.fKO.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.fKO.setLayoutParams(layoutParams);
                if (this.fKr.videoInfo != null) {
                    this.fKP.setDefaultErrorResource(0);
                    this.fKP.setPlaceHolder(3);
                    this.fKP.setEvent(this.dMe);
                    this.fKP.startLoad(this.fKr.videoInfo.thumbnail_url, 17, false);
                    if (this.fLc) {
                        this.fKX.setVisibility(0);
                        this.fKX.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.fKU.setVisibility(0);
                        this.Pe.setText(aq.stringForVideoTime(this.fKr.videoInfo.video_duration.intValue() * 1000));
                        this.Pb.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fKr.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.fKr.fNC == 60 || this.fKr.fNC == 49) {
            this.fJN.setVisibility(8);
            if (this.fKr.cRe.aCF() != null && this.fKr.cRe.aCF().user_info != null && this.fKr.fNC == 60) {
                String str = this.fKr.cRe.aCF().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.fKS.setText(l.db(str + ":", this.fKr.cRe.getTitle()));
                this.fKS.setVisibility(0);
            } else {
                this.fKS.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.azM().isShowImages()) {
                this.fKO.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fKO.getLayoutParams();
                int width2 = this.fKO.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.fKO.setLayoutParams(layoutParams2);
                if (this.fKr.cRe.aCF() != null) {
                    this.fKP.setDefaultErrorResource(0);
                    this.fKP.setPlaceHolder(3);
                    this.fKP.setEvent(this.dMe);
                    this.fKP.startLoad(cardPersonDynamicThreadData.cRe.aCF().cover, 10, false);
                    this.fKQ.setVisibility(8);
                    this.fKW.setVisibility(0);
                    this.fKW.playAnimation();
                    am.setBackgroundResource(this.fKR, R.color.cp_bg_line_e);
                    this.fKV.setVisibility(0);
                    this.fKV.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fKr.cRe.aCF().audience_count)));
                    this.eNl.getCommentContainer().setOnClickListener(this.fJS);
                } else {
                    this.eNl.getCommentContainer().setOnClickListener(this.eNl);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.azM().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.cRe;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.fJN.setVisibility(0);
                    this.fJN.setFromCDN(this.NJ);
                    this.fJN.setSingleImageRatio(0.67d);
                    this.fJN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aMw();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.fJN.setImageMediaList(linkedList);
                } else {
                    this.fJN.setVisibility(8);
                }
            } else {
                this.fJN.setVisibility(8);
            }
            this.fKR.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.cRe != null && cardPersonDynamicThreadData.cRe.cTP != null) {
            this.fKZ.setVisibility(0);
            this.fKZ.b(cardPersonDynamicThreadData.cRe.cTP);
            this.fKZ.setOnClickListener(this);
            this.NY.setVisibility(8);
            this.fJN.setVisibility(8);
            this.fKR.setVisibility(8);
            if (this.fLd) {
                this.fKY.setVisibility(0);
            } else {
                this.fKY.setVisibility(8);
            }
        } else {
            this.fKZ.setVisibility(8);
            this.fKY.setVisibility(8);
        }
        buY();
        c(cardPersonDynamicThreadData);
    }

    private void kn(boolean z) {
        if (this.fJN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJN.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.fJN.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.fLc || this.fLd) {
                this.eNl.setCommentClickable(false);
                this.eNl.setAgreeClickable(false);
                this.eNl.setShareClickable(false);
                this.fKZ.setClickable(false);
                this.fKM.setClickable(false);
            } else {
                this.eNl.setCommentClickable(true);
                this.eNl.setAgreeClickable(true);
                this.eNl.setShareClickable(true);
                this.fKZ.setClickable(true);
                this.fKM.setClickable(true);
            }
            this.eNl.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.fNC == 60) {
                this.eNl.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.fNM != null) {
                this.eNl.setMultiForumCount(cardPersonDynamicThreadData.fNM.length);
            }
            if (cardPersonDynamicThreadData.cRe != null) {
                this.eNl.setForumId(String.valueOf(cardPersonDynamicThreadData.cRe.getFid()));
            }
            this.eNl.setData(cardPersonDynamicThreadData.cRe);
        }
    }

    private void buY() {
        this.NY.setClickable(true);
        int childCount = this.fJN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fJN.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bvb() {
        if (this.fKr != null && this.fKr.cRe != null && this.fKr.cRe.aCF() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.zS(this.fKr.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fKr.cRe.aCF());
            if (this.fKr.cRe.aCF().user_info != null) {
                alaLiveInfoCoreData.userName = this.fKr.cRe.aCF().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvc() {
        if (this.fKr != null && this.fKr.cRe != null && this.fKr.cRe.aCF() != null && this.fKr.cRe.aCF().share_info != null) {
            if (!isHost()) {
                l.zS(this.fKr.threadId);
            }
            if (this.fKr.cRe.aCF().share_info.record_tid <= 0) {
                bvb();
                return;
            }
            String valueOf = String.valueOf(this.fKr.cRe.aCF().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.fKr.cRe);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMw() {
        if (this.fKr != null) {
            if (!isHost()) {
                l.zS(this.fKr.threadId);
                l.a(this.mTitle, this.fKr.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.KA, this.fKr.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.fKr.fNC == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.fKr.cRe, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.fKr.cRe.getFid()));
            pbActivityConfig.setForumName(this.fKr.cRe.aCr());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.fKr.cRe.isShareThread);
            pbActivityConfig.setThreadData(this.fKr.cRe);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.fKr.cRe == null || !this.fKr.cRe.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cy("obj_type", "2").cy("tid", this.fKr.threadId).X("obj_param1", this.fKr.isHost ? 1 : 2));
        }
    }

    private void bvd() {
        if (this.fKr != null && this.fKr.cRe != null && this.fKr.cRe.cTP != null) {
            OriginalThreadInfo originalThreadInfo = this.fKr.cRe.cTP;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cy("obj_type", "3").cy("tid", this.fKr.threadId).X("obj_param1", this.fKr.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (this.fKL != null) {
            if (z) {
                this.fKL.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.fKL.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.fKL.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.fKL.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.fKr.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fKZ) {
            bvd();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJN != null) {
            this.fJN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJN != null) {
            this.fJN.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.NJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCr(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.cRe == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.cRe.d(false, true, this.fLc);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        l.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
