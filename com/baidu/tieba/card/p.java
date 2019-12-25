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
/* loaded from: classes8.dex */
public class p extends a<CardPersonDynamicThreadData> {
    private TextView JZ;
    private boolean Nf;
    public PlayVoiceBntNew Ns;
    private TextView Ov;
    private TextView Ox;
    private TbImageView.a dHQ;
    public ThreadCommentAndPraiseInfoLayout eIh;
    private CustomMessageListener fDC;
    private CardPersonDynamicThreadData fEK;
    public ThreadViewAndCommentInfoLayout fEW;
    private final String fEX;
    private final String fEY;
    private TextView fEZ;
    private ConstrainImageGroup fEg;
    private View.OnClickListener fEl;
    private final View.OnClickListener fEm;
    private LinearLayout fFa;
    private TextView fFb;
    private TextView fFc;
    private TextView fFd;
    private TextView fFe;
    private ImageView fFf;
    private o fFg;
    private View fFh;
    private TbImageView fFi;
    private ImageView fFj;
    private LinearLayout fFk;
    private TextView fFl;
    private LinearLayout fFm;
    private LinearLayout fFn;
    private TextView fFo;
    private TBLottieAnimationView fFp;
    private TextView fFq;
    private TextView fFr;
    public OriginalThreadCardView fFs;
    private View fFt;
    private View fFu;
    private boolean fFv;
    private boolean fFw;
    com.baidu.tieba.view.f fFx;
    private o.a fFy;
    private final View.OnClickListener fFz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fEX = "1";
        this.fEY = "2";
        this.mSkinType = 3;
        this.Nf = true;
        this.fFx = new com.baidu.tieba.view.f() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.fEK != null && !StringUtils.isNull(p.this.fEK.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.fEK.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.f
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.fEl = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.brY() != null) {
                    p.this.brY().a(view, p.this.fEK);
                }
                if (p.this.fEK.fHW != 60) {
                    if ((p.this.fEK.fHW != 40 || p.this.fEK.fHY != 2) && !p.this.fFw) {
                        p.this.aJG();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aCb();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.fEK.cMR.azX().live_status != 1) {
                    p.this.bsw();
                } else {
                    p.this.bsv();
                }
            }
        };
        this.fDC = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.fEK != null && p.this.fEK.threadId != null && p.this.mTitle != null && p.this.JZ != null && ((String) customResponsedMessage.getData()).equals(p.this.fEK.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.fEK.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.JZ, p.this.fEK.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.fFy = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.kb(z);
            }
        };
        this.fFz = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> brY = p.this.brY();
                if (brY != null) {
                    view.setTag("1");
                    brY.a(view, p.this.fEK);
                }
                p.this.aJG();
            }
        };
        this.fEm = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> brY = p.this.brY();
                if (brY != null) {
                    view.setTag("2");
                    brY.a(view, p.this.fEK);
                }
            }
        };
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.fFi != null) {
                    p.this.fFi.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.fEZ = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.fFa = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.fFb = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.fFc = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.fFd = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.fFr = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.fFe = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.fFf = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.Ns = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.Ns.setAfterClickListener(this.fEm);
        this.JZ = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.JZ.setVisibility(8);
        this.fEg = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.fEg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fEg.setChildClickListener(this.fFz);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.fEg.setImageProcessor(aVar);
        this.fFh = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.fFi = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.fFj = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.fEW = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.fFn = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.Ox = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.Ov = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.fFo = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.fFp = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fFp.loop(true);
        am.a(this.fFp, R.raw.ala_play);
        this.fFq = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.fFk = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.fFl = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.fFm = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.fFm.setVisibility(8);
        this.fFs = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.fFt = this.mRootView.findViewById(R.id.divider_line_thick);
        this.fFu = this.mRootView.findViewById(R.id.divider_line_thin);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.eIh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eIh.setLayoutParams(layoutParams);
        }
        this.eIh.setOnClickListener(this.fEl);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setShareVisible(true);
        this.eIh.setIsBarViewVisible(false);
        this.eIh.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 8;
        dVar.cJs = 3;
        this.eIh.setAgreeStatisticData(dVar);
        this.eIh.setShareReportFrom(6);
        this.eIh.setStType("person_page");
        this.eIh.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.brY() != null) {
                    p.this.brY().a(view, p.this.fEK);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.fFp, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.fEZ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fFb, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.fFc, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fFd, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fFr, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fFe, (int) R.color.cp_cont_d);
            if (this.fFf != null) {
                this.fFf.setImageDrawable(SvgManager.aDW().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.JZ, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fFl, (int) R.color.cp_cont_f);
            if (this.fFg != null) {
                this.fFg.onChangeSkinType();
            }
            this.fEW.onChangeSkinType();
            this.eIh.onChangeSkinType();
            am.setBackgroundColor(this.fFt, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fFu, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.fFl, R.color.cp_bg_line_e);
            if (this.fFs != null) {
                this.fFs.onChangeSkinType();
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
        this.fEK = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fEl);
        }
        this.fEZ.setVisibility(cardPersonDynamicThreadData.fIi ? 0 : 8);
        this.fFa.setVisibility(cardPersonDynamicThreadData.fIh ? 0 : 4);
        this.fFt.setVisibility(cardPersonDynamicThreadData.fIh ? 0 : 8);
        this.fFu.setVisibility(cardPersonDynamicThreadData.fIh ? 8 : 0);
        if (cardPersonDynamicThreadData.fIj) {
            this.fFt.setVisibility(8);
            this.fFu.setVisibility(8);
        }
        this.fFv = cardPersonDynamicThreadData.fHW == 40 && cardPersonDynamicThreadData.fHY == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.cMR != null) {
            this.fFw = cardPersonDynamicThreadData.cMR.isShareThread && cardPersonDynamicThreadData.fHY == 2;
        }
        this.fEZ.setText(cardPersonDynamicThreadData.fHZ);
        this.fFb.setText(cardPersonDynamicThreadData.fIa);
        this.fFc.setText(cardPersonDynamicThreadData.fIb);
        if (cardPersonDynamicThreadData.fIg != null && cardPersonDynamicThreadData.fIg.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.fIg.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.fIg[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.fIg.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.fFd.setText(sb2);
                this.fFd.setVisibility(0);
            } else {
                this.fFd.setText(R.string.person_homepage);
            }
        } else {
            this.fFd.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.fFe.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.fFe.setVisibility(0);
            }
            kb(cardPersonDynamicThreadData.isPrivacy);
            this.fFf.setVisibility(0);
            this.fFf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.fFg == null) {
                            p.this.fFg = new o(p.this.mPageContext);
                            p.this.fFg.create();
                            p.this.fFg.a(p.this.fFy);
                        }
                        p.this.fFg.a(p.this.fEK);
                        p.this.fFg.show();
                    }
                }
            });
        } else {
            this.fFe.setVisibility(8);
            this.fFf.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.fIe;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.Ns.setVisibility(0);
            ka(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.Ns.setVoiceModel(voiceModel);
            this.Ns.setTag(voiceModel);
            this.Ns.bEM();
            if (voiceModel != null) {
                this.Ns.wL(voiceModel.voice_status.intValue());
            }
            this.Ns.cJE();
        } else {
            this.Ns.setVisibility(8);
            ka(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.fId;
        am.setBackgroundResource(this.fFk, R.color.transparent);
        this.fFl.setVisibility(8);
        this.fFm.setVisibility(8);
        this.fFk.setVisibility(0);
        this.fFh.setVisibility(8);
        this.fFq.setVisibility(8);
        this.fFn.setVisibility(8);
        this.fFo.setVisibility(8);
        this.fFp.cancelAnimation();
        this.fFp.setVisibility(8);
        if (cardPersonDynamicThreadData.fHW == 36) {
            this.fEg.setVisibility(8);
        } else if (cardPersonDynamicThreadData.fHW == 40 || this.fEK.fHW == 50) {
            this.fEg.setVisibility(8);
            if (com.baidu.tbadk.core.i.axf().isShowImages()) {
                this.fFh.setVisibility(0);
                this.fFj.setVisibility(0);
                this.fFj.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fFh.getLayoutParams();
                int width = this.fFh.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.fFh.setLayoutParams(layoutParams);
                if (this.fEK.videoInfo != null) {
                    this.fFi.setDefaultErrorResource(0);
                    this.fFi.setPlaceHolder(3);
                    this.fFi.setEvent(this.dHQ);
                    this.fFi.startLoad(this.fEK.videoInfo.thumbnail_url, 17, false);
                    if (this.fFv) {
                        this.fFq.setVisibility(0);
                        this.fFq.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.fFn.setVisibility(0);
                        this.Ox.setText(aq.stringForVideoTime(this.fEK.videoInfo.video_duration.intValue() * 1000));
                        this.Ov.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fEK.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.fEK.fHW == 60 || this.fEK.fHW == 49) {
            this.fEg.setVisibility(8);
            if (this.fEK.cMR.azX() != null && this.fEK.cMR.azX().user_info != null && this.fEK.fHW == 60) {
                String str = this.fEK.cMR.azX().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.fFl.setText(l.cQ(str + ":", this.fEK.cMR.getTitle()));
                this.fFl.setVisibility(0);
            } else {
                this.fFl.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.axf().isShowImages()) {
                this.fFh.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fFh.getLayoutParams();
                int width2 = this.fFh.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.fFh.setLayoutParams(layoutParams2);
                if (this.fEK.cMR.azX() != null) {
                    this.fFi.setDefaultErrorResource(0);
                    this.fFi.setPlaceHolder(3);
                    this.fFi.setEvent(this.dHQ);
                    this.fFi.startLoad(cardPersonDynamicThreadData.cMR.azX().cover, 10, false);
                    this.fFj.setVisibility(8);
                    this.fFp.setVisibility(0);
                    this.fFp.playAnimation();
                    am.setBackgroundResource(this.fFk, R.color.cp_bg_line_e);
                    this.fFo.setVisibility(0);
                    this.fFo.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fEK.cMR.azX().audience_count)));
                    this.eIh.getCommentContainer().setOnClickListener(this.fEl);
                } else {
                    this.eIh.getCommentContainer().setOnClickListener(this.eIh);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.axf().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.cMR;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.fEg.setVisibility(0);
                    this.fEg.setFromCDN(this.Nf);
                    this.fEg.setSingleImageRatio(0.67d);
                    this.fEg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aJG();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.fEg.setImageMediaList(linkedList);
                } else {
                    this.fEg.setVisibility(8);
                }
            } else {
                this.fEg.setVisibility(8);
            }
            this.fFk.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.cMR != null && cardPersonDynamicThreadData.cMR.cPD != null) {
            this.fFs.setVisibility(0);
            this.fFs.b(cardPersonDynamicThreadData.cMR.cPD);
            this.fFs.setOnClickListener(this);
            this.Ns.setVisibility(8);
            this.fEg.setVisibility(8);
            this.fFk.setVisibility(8);
            if (this.fFw) {
                this.fFr.setVisibility(0);
            } else {
                this.fFr.setVisibility(8);
            }
        } else {
            this.fFs.setVisibility(8);
            this.fFr.setVisibility(8);
        }
        bss();
        c(cardPersonDynamicThreadData);
    }

    private void ka(boolean z) {
        if (this.fEg != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEg.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.fEg.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.fFv || this.fFw) {
                this.eIh.setCommentClickable(false);
                this.eIh.setAgreeClickable(false);
                this.eIh.setShareClickable(false);
                this.fFs.setClickable(false);
                this.fFf.setClickable(false);
            } else {
                this.eIh.setCommentClickable(true);
                this.eIh.setAgreeClickable(true);
                this.eIh.setShareClickable(true);
                this.fFs.setClickable(true);
                this.fFf.setClickable(true);
            }
            this.eIh.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.fHW == 60) {
                this.eIh.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.fIg != null) {
                this.eIh.setMultiForumCount(cardPersonDynamicThreadData.fIg.length);
            }
            if (cardPersonDynamicThreadData.cMR != null) {
                this.eIh.setForumId(String.valueOf(cardPersonDynamicThreadData.cMR.getFid()));
            }
            this.eIh.setData(cardPersonDynamicThreadData.cMR);
        }
    }

    private void bss() {
        this.Ns.setClickable(true);
        int childCount = this.fEg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fEg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bsv() {
        if (this.fEK != null && this.fEK.cMR != null && this.fEK.cMR.azX() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.zs(this.fEK.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fEK.cMR.azX());
            if (this.fEK.cMR.azX().user_info != null) {
                alaLiveInfoCoreData.userName = this.fEK.cMR.azX().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsw() {
        if (this.fEK != null && this.fEK.cMR != null && this.fEK.cMR.azX() != null && this.fEK.cMR.azX().share_info != null) {
            if (!isHost()) {
                l.zs(this.fEK.threadId);
            }
            if (this.fEK.cMR.azX().share_info.record_tid <= 0) {
                bsv();
                return;
            }
            String valueOf = String.valueOf(this.fEK.cMR.azX().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.fEK.cMR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJG() {
        if (this.fEK != null) {
            if (!isHost()) {
                l.zs(this.fEK.threadId);
                l.a(this.mTitle, this.fEK.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.JZ, this.fEK.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.fEK.fHW == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.fEK.cMR, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.fEK.cMR.getFid()));
            pbActivityConfig.setForumName(this.fEK.cMR.azJ());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.fEK.cMR.isShareThread);
            pbActivityConfig.setThreadData(this.fEK.cMR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.fEK.cMR == null || !this.fEK.cMR.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cp("obj_type", "2").cp("tid", this.fEK.threadId).Z("obj_param1", this.fEK.isHost ? 1 : 2));
        }
    }

    private void bsx() {
        if (this.fEK != null && this.fEK.cMR != null && this.fEK.cMR.cPD != null) {
            OriginalThreadInfo originalThreadInfo = this.fEK.cMR.cPD;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cp("obj_type", "3").cp("tid", this.fEK.threadId).Z("obj_param1", this.fEK.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(boolean z) {
        if (this.fFe != null) {
            if (z) {
                this.fFe.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.fFe.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.fFe.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.fFe.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.fEK.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fFs) {
            bsx();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fEg != null) {
            this.fEg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fEg != null) {
            this.fEg.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.Nf ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.azJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.cMR == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.cMR.d(false, true, this.fFv);
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
