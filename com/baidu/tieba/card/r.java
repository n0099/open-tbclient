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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.af;
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
    private TextView agm;
    private boolean akk;
    public PlayVoiceBntNew akw;
    private TextView alM;
    private TextView alO;
    private TbImageView.a fzO;
    public ThreadCommentAndPraiseInfoLayout gMs;
    private CustomMessageListener hRD;
    private CardPersonDynamicThreadData hSN;
    private ConstrainImageGroup hSj;
    private View.OnClickListener hSo;
    private final View.OnClickListener hSp;
    private View hTA;
    private boolean hTB;
    private boolean hTC;
    com.baidu.tieba.view.g hTD;
    private q.a hTE;
    private final View.OnClickListener hTF;
    public ThreadViewAndCommentInfoLayout hTc;
    private final String hTd;
    private final String hTe;
    private TextView hTf;
    private LinearLayout hTg;
    private TextView hTh;
    private TextView hTi;
    private TextView hTj;
    private TextView hTk;
    private ImageView hTl;
    private q hTm;
    private View hTn;
    private TbImageView hTo;
    private ImageView hTp;
    private LinearLayout hTq;
    private TextView hTr;
    private LinearLayout hTs;
    private LinearLayout hTt;
    private TextView hTu;
    private TBLottieAnimationView hTv;
    private TextView hTw;
    private TextView hTx;
    public OriginalThreadCardView hTy;
    private View hTz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hTd = "1";
        this.hTe = "2";
        this.mSkinType = 3;
        this.akk = true;
        this.hTD = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.hSN != null && !StringUtils.isNull(r.this.hSN.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.hSN.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.hSo = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.cls() != null) {
                    r.this.cls().a(view, r.this.hSN);
                }
                if (r.this.hSN.hWd != 60) {
                    if ((r.this.hSN.hWd != 40 || r.this.hSN.hWf != 2) && !r.this.hTC) {
                        r.this.bvc();
                        return;
                    } else {
                        BdToast.a(r.this.getContext(), (CharSequence) r.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bmI();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.hSN.erH.bku().live_status != 1) {
                    r.this.clO();
                } else {
                    r.this.clN();
                }
            }
        };
        this.hRD = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.hSN != null && r.this.hSN.threadId != null && r.this.mTitle != null && r.this.agm != null && ((String) customResponsedMessage.getData()).equals(r.this.hSN.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.hSN.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                    n.a(r.this.agm, r.this.hSN.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
                }
            }
        };
        this.hTE = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.oo(z);
            }
        };
        this.hTF = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> cls = r.this.cls();
                if (cls != null) {
                    view.setTag("1");
                    cls.a(view, r.this.hSN);
                }
                r.this.bvc();
            }
        };
        this.hSp = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> cls = r.this.cls();
                if (cls != null) {
                    view.setTag("2");
                    cls.a(view, r.this.hSN);
                }
            }
        };
        this.fzO = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.hTo != null) {
                    r.this.hTo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hTf = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hTg = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hTh = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hTi = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hTj = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hTx = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hTk = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hTl = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.akw = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.akw.setAfterClickListener(this.hSp);
        this.agm = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.agm.setVisibility(8);
        this.hSj = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hSj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hSj.setChildClickListener(this.hTF);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.y(1.0d);
        this.hSj.setImageProcessor(aVar);
        this.hTn = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hTo = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hTp = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hTc = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hTt = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.alO = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.alM = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hTu = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hTv = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hTv.loop(true);
        ap.a(this.hTv, R.raw.ala_play);
        this.hTw = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hTq = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hTr = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hTs = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hTs.setVisibility(8);
        this.hTy = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hTz = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hTA = this.mRootView.findViewById(R.id.divider_line_thin);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.gMs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMs.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gMs.setLayoutParams(layoutParams);
        }
        this.gMs.setOnClickListener(this.hSo);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setShareVisible(true);
        this.gMs.setIsBarViewVisible(false);
        this.gMs.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 8;
        cVar.etG = 3;
        this.gMs.setAgreeStatisticData(cVar);
        this.gMs.setShareReportFrom(6);
        this.gMs.setStType("person_page");
        this.gMs.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.cls() != null) {
                    r.this.cls().a(view, r.this.hSN);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hTv, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hTf, R.color.cp_cont_b);
            ap.setViewTextColor(this.hTh, R.color.cp_cont_j);
            ap.setViewTextColor(this.hTi, R.color.cp_cont_b);
            ap.setViewTextColor(this.hTj, R.color.cp_cont_d);
            ap.setViewTextColor(this.hTx, R.color.cp_cont_d);
            ap.setViewTextColor(this.hTk, R.color.cp_cont_d);
            if (this.hTl != null) {
                this.hTl.setImageDrawable(SvgManager.boN().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.agm, R.color.cp_cont_f);
            ap.setViewTextColor(this.hTr, R.color.cp_cont_f);
            if (this.hTm != null) {
                this.hTm.onChangeSkinType();
            }
            this.hTc.onChangeSkinType();
            this.gMs.onChangeSkinType();
            ap.setBackgroundColor(this.hTz, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hTA, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.hTr, R.color.cp_bg_line_e);
            if (this.hTy != null) {
                this.hTy.onChangeSkinType();
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
        this.hSN = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hSo);
        }
        this.hTf.setVisibility(cardPersonDynamicThreadData.hWp ? 0 : 8);
        this.hTg.setVisibility(cardPersonDynamicThreadData.hWo ? 0 : 4);
        this.hTz.setVisibility(cardPersonDynamicThreadData.hWo ? 0 : 8);
        this.hTA.setVisibility(cardPersonDynamicThreadData.hWo ? 8 : 0);
        if (cardPersonDynamicThreadData.hWq) {
            this.hTz.setVisibility(8);
            this.hTA.setVisibility(8);
        }
        this.hTB = cardPersonDynamicThreadData.hWd == 40 && cardPersonDynamicThreadData.hWf == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.erH != null) {
            this.hTC = cardPersonDynamicThreadData.erH.isShareThread && cardPersonDynamicThreadData.hWf == 2;
        }
        this.hTf.setText(cardPersonDynamicThreadData.hWg);
        this.hTh.setText(cardPersonDynamicThreadData.hWh);
        this.hTi.setText(cardPersonDynamicThreadData.hWi);
        if (cardPersonDynamicThreadData.hWn != null && cardPersonDynamicThreadData.hWn.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.hWn.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.hWn[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.hWn.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hTj.setText(sb2);
                this.hTj.setVisibility(0);
            } else {
                this.hTj.setText(R.string.person_homepage);
            }
        } else {
            this.hTj.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hTk.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hTk.setVisibility(0);
            }
            oo(cardPersonDynamicThreadData.isPrivacy);
            this.hTl.setVisibility(0);
            this.hTl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.hTm == null) {
                            r.this.hTm = new q(r.this.mPageContext);
                            r.this.hTm.create();
                            r.this.hTm.a(r.this.hTE);
                        }
                        r.this.hTm.a(r.this.hSN);
                        r.this.hTm.show();
                    }
                }
            });
        } else {
            this.hTk.setVisibility(8);
            this.hTl.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.hWl;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.akw.setVisibility(0);
            on(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.akw.setVoiceModel(voiceModel);
            this.akw.setTag(voiceModel);
            this.akw.changeSkin();
            if (voiceModel != null) {
                this.akw.Dm(voiceModel.voice_status.intValue());
            }
            this.akw.bWJ();
        } else {
            this.akw.setVisibility(8);
            on(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.hWk;
        ap.setBackgroundResource(this.hTq, R.color.transparent);
        this.hTr.setVisibility(8);
        this.hTs.setVisibility(8);
        this.hTq.setVisibility(0);
        this.hTn.setVisibility(8);
        this.hTw.setVisibility(8);
        this.hTt.setVisibility(8);
        this.hTu.setVisibility(8);
        this.hTv.cancelAnimation();
        this.hTv.setVisibility(8);
        if (cardPersonDynamicThreadData.hWd == 36) {
            this.hSj.setVisibility(8);
        } else if (cardPersonDynamicThreadData.hWd == 40 || this.hSN.hWd == 50) {
            this.hSj.setVisibility(8);
            if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
                this.hTn.setVisibility(0);
                this.hTp.setVisibility(0);
                this.hTp.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTn.getLayoutParams();
                int width = this.hTn.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hTn.setLayoutParams(layoutParams);
                if (this.hSN.videoInfo != null) {
                    this.hTo.setDefaultErrorResource(0);
                    this.hTo.setPlaceHolder(3);
                    this.hTo.setEvent(this.fzO);
                    this.hTo.startLoad(this.hSN.videoInfo.thumbnail_url, 17, false);
                    if (this.hTB) {
                        this.hTw.setVisibility(0);
                        this.hTw.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hTt.setVisibility(0);
                        this.alO.setText(at.stringForVideoTime(this.hSN.videoInfo.video_duration.intValue() * 1000));
                        this.alM.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hSN.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hSN.hWd == 60 || this.hSN.hWd == 49) {
            this.hSj.setVisibility(8);
            if (this.hSN.erH.bku() != null && this.hSN.erH.bku().user_info != null && this.hSN.hWd == 60) {
                String str = this.hSN.erH.bku().user_info.user_name;
                if (af.getTextLengthWithEmoji(str) > 14) {
                    str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hTr.setText(n.eD(str + ":", this.hSN.erH.getTitle()));
                this.hTr.setVisibility(0);
            } else {
                this.hTr.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
                this.hTn.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hTn.getLayoutParams();
                int width2 = this.hTn.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hTn.setLayoutParams(layoutParams2);
                if (this.hSN.erH.bku() != null) {
                    this.hTo.setDefaultErrorResource(0);
                    this.hTo.setPlaceHolder(3);
                    this.hTo.setEvent(this.fzO);
                    this.hTo.startLoad(cardPersonDynamicThreadData.erH.bku().cover, 10, false);
                    this.hTp.setVisibility(8);
                    this.hTv.setVisibility(0);
                    this.hTv.playAnimation();
                    ap.setBackgroundResource(this.hTq, R.color.cp_bg_line_e);
                    this.hTu.setVisibility(0);
                    this.hTu.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.hSN.erH.bku().audience_count)));
                    this.gMs.getCommentContainer().setOnClickListener(this.hSo);
                } else {
                    this.gMs.getCommentContainer().setOnClickListener(this.gMs);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bhh().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bw bwVar = cardPersonDynamicThreadData.erH;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hSj.setVisibility(0);
                    this.hSj.setFromCDN(this.akk);
                    this.hSj.setSingleImageRatio(0.67d);
                    this.hSj.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bvc();
                            } else {
                                r.this.a(view, linkedList, i2, bwVar);
                            }
                        }
                    });
                    this.hSj.setImageMediaList(linkedList);
                } else {
                    this.hSj.setVisibility(8);
                }
            } else {
                this.hSj.setVisibility(8);
            }
            this.hTq.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.erH != null && cardPersonDynamicThreadData.erH.eAy != null) {
            this.hTy.setVisibility(0);
            this.hTy.b(cardPersonDynamicThreadData.erH.eAy);
            this.hTy.setOnClickListener(this);
            this.akw.setVisibility(8);
            this.hSj.setVisibility(8);
            this.hTq.setVisibility(8);
            if (this.hTC) {
                this.hTx.setVisibility(0);
            } else {
                this.hTx.setVisibility(8);
            }
        } else {
            this.hTy.setVisibility(8);
            this.hTx.setVisibility(8);
        }
        clK();
        c(cardPersonDynamicThreadData);
    }

    private void on(boolean z) {
        if (this.hSj != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hSj.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hSj.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hTB || this.hTC) {
                this.gMs.setCommentClickable(false);
                this.gMs.setAgreeClickable(false);
                this.gMs.setShareClickable(false);
                this.hTy.setClickable(false);
                this.hTl.setClickable(false);
            } else {
                this.gMs.setCommentClickable(true);
                this.gMs.setAgreeClickable(true);
                this.gMs.setShareClickable(true);
                this.hTy.setClickable(true);
                this.hTl.setClickable(true);
            }
            this.gMs.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.hWd == 60) {
                this.gMs.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.hWn != null) {
                this.gMs.setMultiForumCount(cardPersonDynamicThreadData.hWn.length);
            }
            if (cardPersonDynamicThreadData.erH != null) {
                this.gMs.setForumId(String.valueOf(cardPersonDynamicThreadData.erH.getFid()));
            }
            this.gMs.setData(cardPersonDynamicThreadData.erH);
        }
    }

    private void clK() {
        this.akw.setClickable(true);
        int childCount = this.hSj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hSj.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void clN() {
        if (this.hSN != null && this.hSN.erH != null && this.hSN.erH.bku() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.II(this.hSN.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hSN.erH.bku());
            if (this.hSN.erH.bku().user_info != null) {
                alaLiveInfoCoreData.userName = this.hSN.erH.bku().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clO() {
        if (this.hSN != null && this.hSN.erH != null && this.hSN.erH.bku() != null && this.hSN.erH.bku().share_info != null) {
            if (!isHost()) {
                n.II(this.hSN.threadId);
            }
            if (this.hSN.erH.bku().share_info.record_tid <= 0) {
                clN();
                return;
            }
            String valueOf = String.valueOf(this.hSN.erH.bku().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hSN.erH);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvc() {
        if (this.hSN != null) {
            if (!isHost()) {
                n.II(this.hSN.threadId);
                n.a(this.mTitle, this.hSN.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                n.a(this.agm, this.hSN.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hSN.hWd == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hSN.erH, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hSN.erH.getFid()));
            pbActivityConfig.setForumName(this.hSN.erH.bke());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hSN.erH.isShareThread);
            pbActivityConfig.setThreadData(this.hSN.erH);
            pbActivityConfig.setIsPrivacy(this.hSN.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hSN.erH == null || !this.hSN.erH.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dR("obj_type", "2").dR("tid", this.hSN.threadId).aj("obj_param1", this.hSN.isHost ? 1 : 2));
        }
    }

    private void clP() {
        if (this.hSN != null && this.hSN.erH != null && this.hSN.erH.eAy != null) {
            OriginalThreadInfo originalThreadInfo = this.hSN.erH.eAy;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dR("obj_type", "3").dR("tid", this.hSN.threadId).aj("obj_param1", this.hSN.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(boolean z) {
        if (this.hTk != null) {
            if (z) {
                this.hTk.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hTk.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hTk.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hTk.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hSN.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTy) {
            clP();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hSj != null) {
            this.hSj.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hSj != null) {
            this.hSj.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                imageUrlData.urlType = this.akk ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).nF(i).Aq(bwVar.bke()).Ar(String.valueOf(bwVar.getFid())).As(bwVar.getTid()).io(this.akk).At(arrayList.size() > 0 ? arrayList.get(0) : "").ip(true).a(concurrentHashMap).iq(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        dU.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.erH == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.erH.e(false, true, this.hTB);
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
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
        return true;
    }
}
