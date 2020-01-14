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
/* loaded from: classes9.dex */
public class p extends a<CardPersonDynamicThreadData> {
    private TextView Kf;
    private boolean Nj;
    public PlayVoiceBntNew Nw;
    private TextView OB;
    private TextView Oz;
    private TbImageView.a dHZ;
    public ThreadCommentAndPraiseInfoLayout eJr;
    private CustomMessageListener fGM;
    private CardPersonDynamicThreadData fHU;
    private ConstrainImageGroup fHq;
    private View.OnClickListener fHv;
    private final View.OnClickListener fHw;
    private TextView fIA;
    private TextView fIB;
    public OriginalThreadCardView fIC;
    private View fID;
    private View fIE;
    private boolean fIF;
    private boolean fIG;
    com.baidu.tieba.view.f fIH;
    private o.a fII;
    private final View.OnClickListener fIJ;
    public ThreadViewAndCommentInfoLayout fIg;
    private final String fIh;
    private final String fIi;
    private TextView fIj;
    private LinearLayout fIk;
    private TextView fIl;
    private TextView fIm;
    private TextView fIn;
    private TextView fIo;
    private ImageView fIp;
    private o fIq;
    private View fIr;
    private TbImageView fIs;
    private ImageView fIt;
    private LinearLayout fIu;
    private TextView fIv;
    private LinearLayout fIw;
    private LinearLayout fIx;
    private TextView fIy;
    private TBLottieAnimationView fIz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fIh = "1";
        this.fIi = "2";
        this.mSkinType = 3;
        this.Nj = true;
        this.fIH = new com.baidu.tieba.view.f() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.fHU != null && !StringUtils.isNull(p.this.fHU.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.fHU.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.f
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bta() != null) {
                    p.this.bta().a(view, p.this.fHU);
                }
                if (p.this.fHU.fLg != 60) {
                    if ((p.this.fHU.fLg != 40 || p.this.fHU.fLi != 2) && !p.this.fIG) {
                        p.this.aKa();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aCu();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.fHU.cNb.aAq().live_status != 1) {
                    p.this.bty();
                } else {
                    p.this.btx();
                }
            }
        };
        this.fGM = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.fHU != null && p.this.fHU.threadId != null && p.this.mTitle != null && p.this.Kf != null && ((String) customResponsedMessage.getData()).equals(p.this.fHU.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.fHU.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.Kf, p.this.fHU.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.fII = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.km(z);
            }
        };
        this.fIJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> bta = p.this.bta();
                if (bta != null) {
                    view.setTag("1");
                    bta.a(view, p.this.fHU);
                }
                p.this.aKa();
            }
        };
        this.fHw = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> bta = p.this.bta();
                if (bta != null) {
                    view.setTag("2");
                    bta.a(view, p.this.fHU);
                }
            }
        };
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.fIs != null) {
                    p.this.fIs.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.fIj = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.fIk = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.fIl = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.fIm = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.fIn = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.fIB = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.fIo = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.fIp = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.Nw = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.Nw.setAfterClickListener(this.fHw);
        this.Kf = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.Kf.setVisibility(8);
        this.fHq = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.fHq.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fHq.setChildClickListener(this.fIJ);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.fHq.setImageProcessor(aVar);
        this.fIr = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.fIs = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.fIt = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.fIg = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.fIx = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.OB = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.Oz = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.fIy = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.fIz = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fIz.loop(true);
        am.a(this.fIz, R.raw.ala_play);
        this.fIA = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.fIu = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.fIv = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.fIw = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.fIw.setVisibility(8);
        this.fIC = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.fID = this.mRootView.findViewById(R.id.divider_line_thick);
        this.fIE = this.mRootView.findViewById(R.id.divider_line_thin);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.eJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eJr.setLayoutParams(layoutParams);
        }
        this.eJr.setOnClickListener(this.fHv);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setShareVisible(true);
        this.eJr.setIsBarViewVisible(false);
        this.eJr.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 8;
        dVar.cJD = 3;
        this.eJr.setAgreeStatisticData(dVar);
        this.eJr.setShareReportFrom(6);
        this.eJr.setStType("person_page");
        this.eJr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.bta() != null) {
                    p.this.bta().a(view, p.this.fHU);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.fIz, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.fIj, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fIl, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.fIm, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fIn, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fIB, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fIo, (int) R.color.cp_cont_d);
            if (this.fIp != null) {
                this.fIp.setImageDrawable(SvgManager.aEp().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.Kf, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fIv, (int) R.color.cp_cont_f);
            if (this.fIq != null) {
                this.fIq.onChangeSkinType();
            }
            this.fIg.onChangeSkinType();
            this.eJr.onChangeSkinType();
            am.setBackgroundColor(this.fID, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fIE, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.fIv, R.color.cp_bg_line_e);
            if (this.fIC != null) {
                this.fIC.onChangeSkinType();
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
        this.fHU = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fHv);
        }
        this.fIj.setVisibility(cardPersonDynamicThreadData.fLs ? 0 : 8);
        this.fIk.setVisibility(cardPersonDynamicThreadData.fLr ? 0 : 4);
        this.fID.setVisibility(cardPersonDynamicThreadData.fLr ? 0 : 8);
        this.fIE.setVisibility(cardPersonDynamicThreadData.fLr ? 8 : 0);
        if (cardPersonDynamicThreadData.fLt) {
            this.fID.setVisibility(8);
            this.fIE.setVisibility(8);
        }
        this.fIF = cardPersonDynamicThreadData.fLg == 40 && cardPersonDynamicThreadData.fLi == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.cNb != null) {
            this.fIG = cardPersonDynamicThreadData.cNb.isShareThread && cardPersonDynamicThreadData.fLi == 2;
        }
        this.fIj.setText(cardPersonDynamicThreadData.fLj);
        this.fIl.setText(cardPersonDynamicThreadData.fLk);
        this.fIm.setText(cardPersonDynamicThreadData.fLl);
        if (cardPersonDynamicThreadData.fLq != null && cardPersonDynamicThreadData.fLq.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.fLq.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.fLq[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.fLq.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.fIn.setText(sb2);
                this.fIn.setVisibility(0);
            } else {
                this.fIn.setText(R.string.person_homepage);
            }
        } else {
            this.fIn.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.fIo.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.fIo.setVisibility(0);
            }
            km(cardPersonDynamicThreadData.isPrivacy);
            this.fIp.setVisibility(0);
            this.fIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.fIq == null) {
                            p.this.fIq = new o(p.this.mPageContext);
                            p.this.fIq.create();
                            p.this.fIq.a(p.this.fII);
                        }
                        p.this.fIq.a(p.this.fHU);
                        p.this.fIq.show();
                    }
                }
            });
        } else {
            this.fIo.setVisibility(8);
            this.fIp.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.fLo;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.Nw.setVisibility(0);
            kl(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.Nw.setVoiceModel(voiceModel);
            this.Nw.setTag(voiceModel);
            this.Nw.bFO();
            if (voiceModel != null) {
                this.Nw.wQ(voiceModel.voice_status.intValue());
            }
            this.Nw.cKK();
        } else {
            this.Nw.setVisibility(8);
            kl(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.fLn;
        am.setBackgroundResource(this.fIu, R.color.transparent);
        this.fIv.setVisibility(8);
        this.fIw.setVisibility(8);
        this.fIu.setVisibility(0);
        this.fIr.setVisibility(8);
        this.fIA.setVisibility(8);
        this.fIx.setVisibility(8);
        this.fIy.setVisibility(8);
        this.fIz.cancelAnimation();
        this.fIz.setVisibility(8);
        if (cardPersonDynamicThreadData.fLg == 36) {
            this.fHq.setVisibility(8);
        } else if (cardPersonDynamicThreadData.fLg == 40 || this.fHU.fLg == 50) {
            this.fHq.setVisibility(8);
            if (com.baidu.tbadk.core.i.axy().isShowImages()) {
                this.fIr.setVisibility(0);
                this.fIt.setVisibility(0);
                this.fIt.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fIr.getLayoutParams();
                int width = this.fIr.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.fIr.setLayoutParams(layoutParams);
                if (this.fHU.videoInfo != null) {
                    this.fIs.setDefaultErrorResource(0);
                    this.fIs.setPlaceHolder(3);
                    this.fIs.setEvent(this.dHZ);
                    this.fIs.startLoad(this.fHU.videoInfo.thumbnail_url, 17, false);
                    if (this.fIF) {
                        this.fIA.setVisibility(0);
                        this.fIA.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.fIx.setVisibility(0);
                        this.OB.setText(aq.stringForVideoTime(this.fHU.videoInfo.video_duration.intValue() * 1000));
                        this.Oz.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fHU.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.fHU.fLg == 60 || this.fHU.fLg == 49) {
            this.fHq.setVisibility(8);
            if (this.fHU.cNb.aAq() != null && this.fHU.cNb.aAq().user_info != null && this.fHU.fLg == 60) {
                String str = this.fHU.cNb.aAq().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.fIv.setText(l.cS(str + ":", this.fHU.cNb.getTitle()));
                this.fIv.setVisibility(0);
            } else {
                this.fIv.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.axy().isShowImages()) {
                this.fIr.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fIr.getLayoutParams();
                int width2 = this.fIr.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.fIr.setLayoutParams(layoutParams2);
                if (this.fHU.cNb.aAq() != null) {
                    this.fIs.setDefaultErrorResource(0);
                    this.fIs.setPlaceHolder(3);
                    this.fIs.setEvent(this.dHZ);
                    this.fIs.startLoad(cardPersonDynamicThreadData.cNb.aAq().cover, 10, false);
                    this.fIt.setVisibility(8);
                    this.fIz.setVisibility(0);
                    this.fIz.playAnimation();
                    am.setBackgroundResource(this.fIu, R.color.cp_bg_line_e);
                    this.fIy.setVisibility(0);
                    this.fIy.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fHU.cNb.aAq().audience_count)));
                    this.eJr.getCommentContainer().setOnClickListener(this.fHv);
                } else {
                    this.eJr.getCommentContainer().setOnClickListener(this.eJr);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.axy().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.cNb;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.fHq.setVisibility(0);
                    this.fHq.setFromCDN(this.Nj);
                    this.fHq.setSingleImageRatio(0.67d);
                    this.fHq.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aKa();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.fHq.setImageMediaList(linkedList);
                } else {
                    this.fHq.setVisibility(8);
                }
            } else {
                this.fHq.setVisibility(8);
            }
            this.fIu.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.cNb != null && cardPersonDynamicThreadData.cNb.cPN != null) {
            this.fIC.setVisibility(0);
            this.fIC.b(cardPersonDynamicThreadData.cNb.cPN);
            this.fIC.setOnClickListener(this);
            this.Nw.setVisibility(8);
            this.fHq.setVisibility(8);
            this.fIu.setVisibility(8);
            if (this.fIG) {
                this.fIB.setVisibility(0);
            } else {
                this.fIB.setVisibility(8);
            }
        } else {
            this.fIC.setVisibility(8);
            this.fIB.setVisibility(8);
        }
        btu();
        c(cardPersonDynamicThreadData);
    }

    private void kl(boolean z) {
        if (this.fHq != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHq.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.fHq.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.fIF || this.fIG) {
                this.eJr.setCommentClickable(false);
                this.eJr.setAgreeClickable(false);
                this.eJr.setShareClickable(false);
                this.fIC.setClickable(false);
                this.fIp.setClickable(false);
            } else {
                this.eJr.setCommentClickable(true);
                this.eJr.setAgreeClickable(true);
                this.eJr.setShareClickable(true);
                this.fIC.setClickable(true);
                this.fIp.setClickable(true);
            }
            this.eJr.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.fLg == 60) {
                this.eJr.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.fLq != null) {
                this.eJr.setMultiForumCount(cardPersonDynamicThreadData.fLq.length);
            }
            if (cardPersonDynamicThreadData.cNb != null) {
                this.eJr.setForumId(String.valueOf(cardPersonDynamicThreadData.cNb.getFid()));
            }
            this.eJr.setData(cardPersonDynamicThreadData.cNb);
        }
    }

    private void btu() {
        this.Nw.setClickable(true);
        int childCount = this.fHq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fHq.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void btx() {
        if (this.fHU != null && this.fHU.cNb != null && this.fHU.cNb.aAq() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.zC(this.fHU.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fHU.cNb.aAq());
            if (this.fHU.cNb.aAq().user_info != null) {
                alaLiveInfoCoreData.userName = this.fHU.cNb.aAq().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bty() {
        if (this.fHU != null && this.fHU.cNb != null && this.fHU.cNb.aAq() != null && this.fHU.cNb.aAq().share_info != null) {
            if (!isHost()) {
                l.zC(this.fHU.threadId);
            }
            if (this.fHU.cNb.aAq().share_info.record_tid <= 0) {
                btx();
                return;
            }
            String valueOf = String.valueOf(this.fHU.cNb.aAq().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.fHU.cNb);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKa() {
        if (this.fHU != null) {
            if (!isHost()) {
                l.zC(this.fHU.threadId);
                l.a(this.mTitle, this.fHU.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.Kf, this.fHU.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.fHU.fLg == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.fHU.cNb, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.fHU.cNb.getFid()));
            pbActivityConfig.setForumName(this.fHU.cNb.aAc());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.fHU.cNb.isShareThread);
            pbActivityConfig.setThreadData(this.fHU.cNb);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.fHU.cNb == null || !this.fHU.cNb.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cp("obj_type", "2").cp("tid", this.fHU.threadId).Z("obj_param1", this.fHU.isHost ? 1 : 2));
        }
    }

    private void btz() {
        if (this.fHU != null && this.fHU.cNb != null && this.fHU.cNb.cPN != null) {
            OriginalThreadInfo originalThreadInfo = this.fHU.cNb.cPN;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cp("obj_type", "3").cp("tid", this.fHU.threadId).Z("obj_param1", this.fHU.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (this.fIo != null) {
            if (z) {
                this.fIo.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.fIo.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.fIo.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.fIo.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.fHU.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fIC) {
            btz();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fHq != null) {
            this.fHq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fHq != null) {
            this.fHq.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.Nj ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aAc(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.cNb == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.cNb.d(false, true, this.fIF);
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
