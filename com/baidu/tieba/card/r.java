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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
/* loaded from: classes6.dex */
public class r extends a<CardPersonDynamicThreadData> {
    private TextView FK;
    private boolean HY;
    public PlayVoiceBntNew Ii;
    private TbImageView.a cUo;
    public NewThreadCommentAndPraiseInfoLayout dUe;
    private CustomMessageListener eMD;
    private CardPersonDynamicThreadData eNN;
    public ThreadViewAndCommentInfoLayout eNY;
    private final String eNZ;
    private ConstrainImageGroup eNi;
    private View.OnClickListener eNn;
    private final View.OnClickListener eNo;
    private boolean eOA;
    com.baidu.tieba.view.h eOB;
    private q.a eOC;
    private final View.OnClickListener eOD;
    private final String eOa;
    private TextView eOb;
    private LinearLayout eOc;
    private TextView eOd;
    private TextView eOe;
    private TextView eOf;
    private TextView eOg;
    private ImageView eOh;
    private q eOi;
    private View eOj;
    private TbImageView eOk;
    private ImageView eOl;
    private LinearLayout eOm;
    private TextView eOn;
    private LinearLayout eOo;
    private LinearLayout eOp;
    private TextView eOq;
    private TextView eOr;
    private TextView eOs;
    private TBLottieAnimationView eOt;
    private TextView eOu;
    private TextView eOv;
    public OriginalThreadCardView eOw;
    private View eOx;
    private View eOy;
    private boolean eOz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNZ = "1";
        this.eOa = "2";
        this.mSkinType = 3;
        this.HY = true;
        this.eOB = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eNN != null && !StringUtils.isNull(r.this.eNN.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eNN.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.eNn = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZX() != null) {
                    r.this.aZX().a(view, r.this.eNN);
                }
                if (r.this.eNN.eQS != 60) {
                    if ((r.this.eNN.eQS != 40 || r.this.eNN.eQU != 2) && !r.this.eOA) {
                        r.this.asj();
                        return;
                    } else {
                        BdToast.b(r.this.getContext(), r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake_n_svg, true).akT();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.eNN.cbq.aiZ().live_status != 1) {
                    r.this.bau();
                } else {
                    r.this.bat();
                }
            }
        };
        this.eMD = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eNN != null && r.this.eNN.threadId != null && r.this.mTitle != null && r.this.FK != null && ((String) customResponsedMessage.getData()).equals(r.this.eNN.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eNN.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.FK, r.this.eNN.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.eOC = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.iJ(z);
            }
        };
        this.eOD = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZX = r.this.aZX();
                if (aZX != null) {
                    view.setTag("1");
                    aZX.a(view, r.this.eNN);
                }
                r.this.asj();
            }
        };
        this.eNo = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aZX = r.this.aZX();
                if (aZX != null) {
                    view.setTag("2");
                    aZX.a(view, r.this.eNN);
                }
            }
        };
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.eOk != null) {
                    r.this.eOk.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eOb = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.eOc = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.eOd = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.eOe = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.eOf = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.eOv = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.eOg = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.eOh = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.Ii = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.Ii.setAfterClickListener(this.eNo);
        this.FK = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.FK.setVisibility(8);
        this.eNi = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.eNi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eNi.setChildClickListener(this.eOD);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.g(1.0d);
        this.eNi.setImageProcessor(aVar);
        this.eOj = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.eOk = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.eOl = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.eNY = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.eOp = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.eOq = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.eOr = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.eOs = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.eOt = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.eOt.loop(true);
        am.a(this.eOt, R.raw.ala_play);
        this.eOu = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.eOm = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.eOn = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.eOo = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.eOo.setVisibility(8);
        this.eOw = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.eOx = this.mRootView.findViewById(R.id.divider_line_thick);
        this.eOy = this.mRootView.findViewById(R.id.divider_line_thin);
        this.dUe = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.dUe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dUe.setLayoutParams(layoutParams);
        }
        this.dUe.setOnClickListener(this.eNn);
        this.dUe.setReplyTimeVisible(false);
        this.dUe.setShowPraiseNum(true);
        this.dUe.setNeedAddPraiseIcon(true);
        this.dUe.setNeedAddReplyIcon(true);
        this.dUe.setShareVisible(true);
        this.dUe.setIsBarViewVisible(false);
        this.dUe.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXQ = 8;
        dVar.bXV = 3;
        this.dUe.setAgreeStatisticData(dVar);
        this.dUe.setShareReportFrom(6);
        this.dUe.setStType("person_page");
        this.dUe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aZX() != null) {
                    r.this.aZX().a(view, r.this.eNN);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.eOt, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.eOb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOd, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.eOe, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOf, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOv, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eOg, (int) R.color.cp_cont_d);
            if (this.eOh != null) {
                this.eOh.setImageDrawable(SvgManager.amN().a(R.drawable.icon_pure_card_more_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.FK, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.eOn, (int) R.color.cp_cont_f);
            if (this.eOi != null) {
                this.eOi.onChangeSkinType();
            }
            this.eNY.onChangeSkinType();
            this.dUe.onChangeSkinType();
            am.setBackgroundColor(this.eOx, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOy, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.eOn, R.color.cp_bg_line_e);
            if (this.eOw != null) {
                this.eOw.onChangeSkinType();
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
        this.eNN = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eNn);
        }
        this.eOb.setVisibility(cardPersonDynamicThreadData.eRe ? 0 : 8);
        this.eOc.setVisibility(cardPersonDynamicThreadData.eRd ? 0 : 4);
        this.eOx.setVisibility(cardPersonDynamicThreadData.eRd ? 0 : 8);
        this.eOy.setVisibility(cardPersonDynamicThreadData.eRd ? 8 : 0);
        if (cardPersonDynamicThreadData.eRf) {
            this.eOx.setVisibility(8);
            this.eOy.setVisibility(8);
        }
        this.eOz = cardPersonDynamicThreadData.eQS == 40 && cardPersonDynamicThreadData.eQU == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.cbq != null) {
            this.eOA = cardPersonDynamicThreadData.cbq.isShareThread && cardPersonDynamicThreadData.eQU == 2;
        }
        this.eOb.setText(cardPersonDynamicThreadData.eQV);
        this.eOd.setText(cardPersonDynamicThreadData.eQW);
        this.eOe.setText(cardPersonDynamicThreadData.eQX);
        if (cardPersonDynamicThreadData.eRc != null && cardPersonDynamicThreadData.eRc.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.eRc.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.eRc[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.eRc.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eOf.setText(sb2);
                this.eOf.setVisibility(0);
            } else {
                this.eOf.setText(R.string.person_homepage);
            }
        } else {
            this.eOf.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eOg.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eOg.setVisibility(0);
            }
            iJ(cardPersonDynamicThreadData.isPrivacy);
            this.eOh.setVisibility(0);
            this.eOh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eOi == null) {
                            r.this.eOi = new q(r.this.mPageContext);
                            r.this.eOi.create();
                            r.this.eOi.a(r.this.eOC);
                        }
                        r.this.eOi.a(r.this.eNN);
                        r.this.eOi.show();
                    }
                }
            });
        } else {
            this.eOg.setVisibility(8);
            this.eOh.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.eRa;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.Ii.setVisibility(0);
            iI(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.Ii.setVoiceModel(voiceModel);
            this.Ii.setTag(voiceModel);
            this.Ii.bnq();
            if (voiceModel != null) {
                this.Ii.uK(voiceModel.voice_status.intValue());
            }
            this.Ii.cpC();
        } else {
            this.Ii.setVisibility(8);
            iI(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.eQZ;
        am.setBackgroundResource(this.eOm, R.color.transparent);
        this.eOn.setVisibility(8);
        this.eOo.setVisibility(8);
        this.eOm.setVisibility(0);
        this.eOj.setVisibility(8);
        this.eOu.setVisibility(8);
        this.eOp.setVisibility(8);
        this.eOs.setVisibility(8);
        this.eOt.cancelAnimation();
        this.eOt.setVisibility(8);
        if (cardPersonDynamicThreadData.eQS == 36) {
            this.eNi.setVisibility(8);
        } else if (cardPersonDynamicThreadData.eQS == 40 || this.eNN.eQS == 50) {
            this.eNi.setVisibility(8);
            if (com.baidu.tbadk.core.i.agq().isShowImages()) {
                this.eOj.setVisibility(0);
                this.eOl.setVisibility(0);
                this.eOl.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOj.getLayoutParams();
                int width = this.eOj.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eOj.setLayoutParams(layoutParams);
                if (this.eNN.videoInfo != null) {
                    this.eOk.setDefaultErrorResource(0);
                    this.eOk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eOk.setEvent(this.cUo);
                    this.eOk.startLoad(this.eNN.videoInfo.thumbnail_url, 17, false);
                    if (this.eOz) {
                        this.eOu.setVisibility(0);
                        this.eOu.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.eOp.setVisibility(0);
                        this.eOq.setText(aq.stringForVideoTime(this.eNN.videoInfo.video_duration.intValue() * 1000));
                        this.eOr.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.eNN.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eNN.eQS == 60 || this.eNN.eQS == 49) {
            this.eNi.setVisibility(8);
            if (this.eNN.cbq.aiZ() != null && this.eNN.cbq.aiZ().user_info != null && this.eNN.eQS == 60) {
                String str = this.eNN.cbq.aiZ().user_info.user_name;
                if (com.baidu.tbadk.util.aa.getTextLengthWithEmoji(str) > 14) {
                    str = com.baidu.tbadk.util.aa.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.eOn.setText(n.cw(str + ":", this.eNN.cbq.getTitle()));
                this.eOn.setVisibility(0);
            } else {
                this.eOn.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.agq().isShowImages()) {
                this.eOj.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eOj.getLayoutParams();
                int width2 = this.eOj.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eOj.setLayoutParams(layoutParams2);
                if (this.eNN.cbq.aiZ() != null) {
                    this.eOk.setDefaultErrorResource(0);
                    this.eOk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    this.eOk.setEvent(this.cUo);
                    this.eOk.startLoad(cardPersonDynamicThreadData.cbq.aiZ().cover, 10, false);
                    this.eOl.setVisibility(8);
                    this.eOt.setVisibility(0);
                    this.eOt.playAnimation();
                    am.setBackgroundResource(this.eOm, R.color.cp_bg_line_e);
                    this.eOs.setVisibility(0);
                    this.eOs.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.eNN.cbq.aiZ().audience_count)));
                    this.dUe.getCommentContainer().setOnClickListener(this.eNn);
                } else {
                    this.dUe.getCommentContainer().setOnClickListener(this.dUe);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.agq().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.cbq;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.eNi.setVisibility(0);
                    this.eNi.setFromCDN(this.HY);
                    this.eNi.setSingleImageRatio(0.67d);
                    this.eNi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.asj();
                            } else {
                                r.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.eNi.setImageMediaList(linkedList);
                } else {
                    this.eNi.setVisibility(8);
                }
            } else {
                this.eNi.setVisibility(8);
            }
            this.eOm.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.cbq != null && cardPersonDynamicThreadData.cbq.cec != null) {
            this.eOw.setVisibility(0);
            this.eOw.b(cardPersonDynamicThreadData.cbq.cec);
            this.eOw.setOnClickListener(this);
            this.Ii.setVisibility(8);
            this.eNi.setVisibility(8);
            this.eOm.setVisibility(8);
            if (this.eOA) {
                this.eOv.setVisibility(0);
            } else {
                this.eOv.setVisibility(8);
            }
        } else {
            this.eOw.setVisibility(8);
            this.eOv.setVisibility(8);
        }
        baq();
        c(cardPersonDynamicThreadData);
    }

    private void iI(boolean z) {
        if (this.eNi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNi.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.eNi.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.eOz || this.eOA) {
                this.dUe.setCommentClickable(false);
                this.dUe.setAgreeClickable(false);
                this.dUe.setShareClickable(false);
                this.eOw.setClickable(false);
                this.eOh.setClickable(false);
            } else {
                this.dUe.setCommentClickable(true);
                this.dUe.setAgreeClickable(true);
                this.dUe.setShareClickable(true);
                this.eOw.setClickable(true);
                this.eOh.setClickable(true);
            }
            this.dUe.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.eQS == 60) {
                this.dUe.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.eRc != null) {
                this.dUe.setMultiForumCount(cardPersonDynamicThreadData.eRc.length);
            }
            if (cardPersonDynamicThreadData.cbq != null) {
                this.dUe.setForumId(String.valueOf(cardPersonDynamicThreadData.cbq.getFid()));
            }
            this.dUe.setData(cardPersonDynamicThreadData.cbq);
        }
    }

    private void baq() {
        this.Ii.setClickable(true);
        int childCount = this.eNi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eNi.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bat() {
        if (this.eNN != null && this.eNN.cbq != null && this.eNN.cbq.aiZ() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.uz(this.eNN.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eNN.cbq.aiZ());
            if (this.eNN.cbq.aiZ().user_info != null) {
                alaLiveInfoCoreData.userName = this.eNN.cbq.aiZ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        if (this.eNN != null && this.eNN.cbq != null && this.eNN.cbq.aiZ() != null && this.eNN.cbq.aiZ().share_info != null) {
            if (!isHost()) {
                n.uz(this.eNN.threadId);
            }
            if (this.eNN.cbq.aiZ().share_info.record_tid <= 0) {
                bat();
                return;
            }
            String valueOf = String.valueOf(this.eNN.cbq.aiZ().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asj() {
        if (this.eNN != null) {
            if (!isHost()) {
                n.uz(this.eNN.threadId);
                n.a(this.mTitle, this.eNN.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.FK, this.eNN.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eNN.eQS == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.eNN.cbq, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eNN.cbq.getFid()));
            pbActivityConfig.setForumName(this.eNN.cbq.aiL());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eNN.cbq.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.eNN.cbq == null || !this.eNN.cbq.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").bS("obj_type", "2").bS("tid", this.eNN.threadId).O("obj_param1", this.eNN.isHost ? 1 : 2));
        }
    }

    private void bav() {
        if (this.eNN != null && this.eNN.cbq != null && this.eNN.cbq.cec != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eNN.cbq.cec.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").bS("obj_type", "3").bS("tid", this.eNN.threadId).O("obj_param1", this.eNN.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(boolean z) {
        if (this.eOg != null) {
            if (z) {
                this.eOg.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eOg.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eOg.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eOg.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eNN.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eOw) {
            bav();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eNi != null) {
            this.eNi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eNi != null) {
            this.eNi.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                imageUrlData.urlType = this.HY ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiL(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.HY, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.cbq == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.cbq.d(false, true, this.eOz);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
