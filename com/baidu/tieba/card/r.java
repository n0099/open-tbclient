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
    private TbImageView.a fFE;
    public ThreadCommentAndPraiseInfoLayout gSR;
    private CustomMessageListener hXA;
    private CardPersonDynamicThreadData hYK;
    public ThreadViewAndCommentInfoLayout hYZ;
    private ConstrainImageGroup hYg;
    private View.OnClickListener hYl;
    private final View.OnClickListener hYm;
    com.baidu.tieba.view.g hZA;
    private q.a hZB;
    private final View.OnClickListener hZC;
    private final String hZa;
    private final String hZb;
    private TextView hZc;
    private LinearLayout hZd;
    private TextView hZe;
    private TextView hZf;
    private TextView hZg;
    private TextView hZh;
    private ImageView hZi;
    private q hZj;
    private View hZk;
    private TbImageView hZl;
    private ImageView hZm;
    private LinearLayout hZn;
    private TextView hZo;
    private LinearLayout hZp;
    private LinearLayout hZq;
    private TextView hZr;
    private TBLottieAnimationView hZs;
    private TextView hZt;
    private TextView hZu;
    public OriginalThreadCardView hZv;
    private View hZw;
    private View hZx;
    private boolean hZy;
    private boolean hZz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hZa = "1";
        this.hZb = "2";
        this.mSkinType = 3;
        this.akk = true;
        this.hZA = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.hYK != null && !StringUtils.isNull(r.this.hYK.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.hYK.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : r.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.hYl = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.cnT() != null) {
                    r.this.cnT().a(view, r.this.hYK);
                }
                if (r.this.hYK.ica != 60) {
                    if ((r.this.hYK.ica != 40 || r.this.hYK.icc != 2) && !r.this.hZz) {
                        r.this.bxB();
                        return;
                    } else {
                        BdToast.a(r.this.getContext(), (CharSequence) r.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).bpi();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (r.this.hYK.exA.bmU().live_status != 1) {
                    r.this.cop();
                } else {
                    r.this.coo();
                }
            }
        };
        this.hXA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.hYK != null && r.this.hYK.threadId != null && r.this.mTitle != null && r.this.agm != null && ((String) customResponsedMessage.getData()).equals(r.this.hYK.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.hYK.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    n.a(r.this.agm, r.this.hYK.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.hZB = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.ox(z);
            }
        };
        this.hZC = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> cnT = r.this.cnT();
                if (cnT != null) {
                    view.setTag("1");
                    cnT.a(view, r.this.hYK);
                }
                r.this.bxB();
            }
        };
        this.hYm = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> cnT = r.this.cnT();
                if (cnT != null) {
                    view.setTag("2");
                    cnT.a(view, r.this.hYK);
                }
            }
        };
        this.fFE = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && r.this.hZl != null) {
                    r.this.hZl.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hZc = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hZd = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hZe = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hZf = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hZg = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hZu = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hZh = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hZi = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.akw = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.akw.setAfterClickListener(this.hYm);
        this.agm = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.agm.setVisibility(8);
        this.hYg = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hYg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hYg.setChildClickListener(this.hZC);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.y(1.0d);
        this.hYg.setImageProcessor(aVar);
        this.hZk = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hZl = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hZm = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hYZ = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hZq = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.alO = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.alM = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hZr = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hZs = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hZs.loop(true);
        ap.a(this.hZs, (int) R.raw.ala_play);
        this.hZt = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hZn = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hZo = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hZp = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hZp.setVisibility(8);
        this.hZv = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hZw = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hZx = this.mRootView.findViewById(R.id.divider_line_thin);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.gSR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSR.setLayoutParams(layoutParams);
        }
        this.gSR.setOnClickListener(this.hYl);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setShareVisible(true);
        this.gSR.setIsBarViewVisible(false);
        this.gSR.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 8;
        cVar.ezz = 3;
        this.gSR.setAgreeStatisticData(cVar);
        this.gSR.setShareReportFrom(6);
        this.gSR.setStType("person_page");
        this.gSR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.cnT() != null) {
                    r.this.cnT().a(view, r.this.hYK);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hZs, (int) R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hZc, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.hZe, (int) R.color.cp_cont_j);
            ap.setViewTextColor(this.hZf, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.hZg, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.hZu, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.hZh, (int) R.color.cp_cont_d);
            if (this.hZi != null) {
                this.hZi.setImageDrawable(SvgManager.brn().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.agm, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.hZo, (int) R.color.cp_cont_f);
            if (this.hZj != null) {
                this.hZj.onChangeSkinType();
            }
            this.hYZ.onChangeSkinType();
            this.gSR.onChangeSkinType();
            ap.setBackgroundColor(this.hZw, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hZx, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.hZo, R.color.cp_bg_line_e);
            if (this.hZv != null) {
                this.hZv.onChangeSkinType();
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
        this.hYK = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hYl);
        }
        this.hZc.setVisibility(cardPersonDynamicThreadData.icm ? 0 : 8);
        this.hZd.setVisibility(cardPersonDynamicThreadData.icl ? 0 : 4);
        this.hZw.setVisibility(cardPersonDynamicThreadData.icl ? 0 : 8);
        this.hZx.setVisibility(cardPersonDynamicThreadData.icl ? 8 : 0);
        if (cardPersonDynamicThreadData.icn) {
            this.hZw.setVisibility(8);
            this.hZx.setVisibility(8);
        }
        this.hZy = cardPersonDynamicThreadData.ica == 40 && cardPersonDynamicThreadData.icc == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.exA != null) {
            this.hZz = cardPersonDynamicThreadData.exA.isShareThread && cardPersonDynamicThreadData.icc == 2;
        }
        this.hZc.setText(cardPersonDynamicThreadData.icd);
        this.hZe.setText(cardPersonDynamicThreadData.ice);
        this.hZf.setText(cardPersonDynamicThreadData.icf);
        if (cardPersonDynamicThreadData.ick != null && cardPersonDynamicThreadData.ick.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.ick.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.ick[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.ick.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hZg.setText(sb2);
                this.hZg.setVisibility(0);
            } else {
                this.hZg.setText(R.string.person_homepage);
            }
        } else {
            this.hZg.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hZh.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hZh.setVisibility(0);
            }
            ox(cardPersonDynamicThreadData.isPrivacy);
            this.hZi.setVisibility(0);
            this.hZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.hZj == null) {
                            r.this.hZj = new q(r.this.mPageContext);
                            r.this.hZj.create();
                            r.this.hZj.a(r.this.hZB);
                        }
                        r.this.hZj.a(r.this.hYK);
                        r.this.hZj.show();
                    }
                }
            });
        } else {
            this.hZh.setVisibility(8);
            this.hZi.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.ici;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.akw.setVisibility(0);
            ow(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.akw.setVoiceModel(voiceModel);
            this.akw.setTag(voiceModel);
            this.akw.changeSkin();
            if (voiceModel != null) {
                this.akw.Dz(voiceModel.voice_status.intValue());
            }
            this.akw.bZl();
        } else {
            this.akw.setVisibility(8);
            ow(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.ich;
        ap.setBackgroundResource(this.hZn, R.color.transparent);
        this.hZo.setVisibility(8);
        this.hZp.setVisibility(8);
        this.hZn.setVisibility(0);
        this.hZk.setVisibility(8);
        this.hZt.setVisibility(8);
        this.hZq.setVisibility(8);
        this.hZr.setVisibility(8);
        this.hZs.cancelAnimation();
        this.hZs.setVisibility(8);
        if (cardPersonDynamicThreadData.ica == 36) {
            this.hYg.setVisibility(8);
        } else if (cardPersonDynamicThreadData.ica == 40 || this.hYK.ica == 50) {
            this.hYg.setVisibility(8);
            if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
                this.hZk.setVisibility(0);
                this.hZm.setVisibility(0);
                this.hZm.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hZk.getLayoutParams();
                int width = this.hZk.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hZk.setLayoutParams(layoutParams);
                if (this.hYK.videoInfo != null) {
                    this.hZl.setDefaultErrorResource(0);
                    this.hZl.setPlaceHolder(3);
                    this.hZl.setEvent(this.fFE);
                    this.hZl.startLoad(this.hYK.videoInfo.thumbnail_url, 17, false);
                    if (this.hZy) {
                        this.hZt.setVisibility(0);
                        this.hZt.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hZq.setVisibility(0);
                        this.alO.setText(at.stringForVideoTime(this.hYK.videoInfo.video_duration.intValue() * 1000));
                        this.alM.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hYK.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hYK.ica == 60 || this.hYK.ica == 49) {
            this.hYg.setVisibility(8);
            if (this.hYK.exA.bmU() != null && this.hYK.exA.bmU().user_info != null && this.hYK.ica == 60) {
                String str = this.hYK.exA.bmU().user_info.user_name;
                if (af.getTextLengthWithEmoji(str) > 14) {
                    str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hZo.setText(n.eD(str + ":", this.hYK.exA.getTitle()));
                this.hZo.setVisibility(0);
            } else {
                this.hZo.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
                this.hZk.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hZk.getLayoutParams();
                int width2 = this.hZk.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hZk.setLayoutParams(layoutParams2);
                if (this.hYK.exA.bmU() != null) {
                    this.hZl.setDefaultErrorResource(0);
                    this.hZl.setPlaceHolder(3);
                    this.hZl.setEvent(this.fFE);
                    this.hZl.startLoad(cardPersonDynamicThreadData.exA.bmU().cover, 10, false);
                    this.hZm.setVisibility(8);
                    this.hZs.setVisibility(0);
                    this.hZs.playAnimation();
                    ap.setBackgroundResource(this.hZn, R.color.cp_bg_line_e);
                    this.hZr.setVisibility(0);
                    this.hZr.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.hYK.exA.bmU().audience_count)));
                    this.gSR.getCommentContainer().setOnClickListener(this.hYl);
                } else {
                    this.gSR.getCommentContainer().setOnClickListener(this.gSR);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bjH().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bw bwVar = cardPersonDynamicThreadData.exA;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hYg.setVisibility(0);
                    this.hYg.setFromCDN(this.akk);
                    this.hYg.setSingleImageRatio(0.67d);
                    this.hYg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                r.this.bxB();
                            } else {
                                r.this.a(view, linkedList, i2, bwVar);
                            }
                        }
                    });
                    this.hYg.setImageMediaList(linkedList);
                } else {
                    this.hYg.setVisibility(8);
                }
            } else {
                this.hYg.setVisibility(8);
            }
            this.hZn.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.exA != null && cardPersonDynamicThreadData.exA.eGn != null) {
            this.hZv.setVisibility(0);
            this.hZv.b(cardPersonDynamicThreadData.exA.eGn);
            this.hZv.setOnClickListener(this);
            this.akw.setVisibility(8);
            this.hYg.setVisibility(8);
            this.hZn.setVisibility(8);
            if (this.hZz) {
                this.hZu.setVisibility(0);
            } else {
                this.hZu.setVisibility(8);
            }
        } else {
            this.hZv.setVisibility(8);
            this.hZu.setVisibility(8);
        }
        col();
        c(cardPersonDynamicThreadData);
    }

    private void ow(boolean z) {
        if (this.hYg != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hYg.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hYg.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hZy || this.hZz) {
                this.gSR.setCommentClickable(false);
                this.gSR.setAgreeClickable(false);
                this.gSR.setShareClickable(false);
                this.hZv.setClickable(false);
                this.hZi.setClickable(false);
            } else {
                this.gSR.setCommentClickable(true);
                this.gSR.setAgreeClickable(true);
                this.gSR.setShareClickable(true);
                this.hZv.setClickable(true);
                this.hZi.setClickable(true);
            }
            this.gSR.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.ica == 60) {
                this.gSR.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.ick != null) {
                this.gSR.setMultiForumCount(cardPersonDynamicThreadData.ick.length);
            }
            if (cardPersonDynamicThreadData.exA != null) {
                this.gSR.setForumId(String.valueOf(cardPersonDynamicThreadData.exA.getFid()));
            }
            this.gSR.setData(cardPersonDynamicThreadData.exA);
        }
    }

    private void col() {
        this.akw.setClickable(true);
        int childCount = this.hYg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hYg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void coo() {
        if (this.hYK != null && this.hYK.exA != null && this.hYK.exA.bmU() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.IZ(this.hYK.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hYK.exA.bmU());
            if (this.hYK.exA.bmU().user_info != null) {
                alaLiveInfoCoreData.userName = this.hYK.exA.bmU().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cop() {
        if (this.hYK != null && this.hYK.exA != null && this.hYK.exA.bmU() != null && this.hYK.exA.bmU().share_info != null) {
            if (!isHost()) {
                n.IZ(this.hYK.threadId);
            }
            if (this.hYK.exA.bmU().share_info.record_tid <= 0) {
                coo();
                return;
            }
            String valueOf = String.valueOf(this.hYK.exA.bmU().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hYK.exA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxB() {
        if (this.hYK != null) {
            if (!isHost()) {
                n.IZ(this.hYK.threadId);
                n.a(this.mTitle, this.hYK.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.agm, this.hYK.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hYK.ica == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hYK.exA, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hYK.exA.getFid()));
            pbActivityConfig.setForumName(this.hYK.exA.bmE());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hYK.exA.isShareThread);
            pbActivityConfig.setThreadData(this.hYK.exA);
            pbActivityConfig.setIsPrivacy(this.hYK.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hYK.exA == null || !this.hYK.exA.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dR("obj_type", "2").dR("tid", this.hYK.threadId).al("obj_param1", this.hYK.isHost ? 1 : 2));
        }
    }

    private void coq() {
        if (this.hYK != null && this.hYK.exA != null && this.hYK.exA.eGn != null) {
            OriginalThreadInfo originalThreadInfo = this.hYK.exA.eGn;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dR("obj_type", "3").dR("tid", this.hYK.threadId).al("obj_param1", this.hYK.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ox(boolean z) {
        if (this.hZh != null) {
            if (z) {
                this.hZh.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hZh.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hZh.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hZh.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hYK.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hZv) {
            coq();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYg != null) {
            this.hYg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYg != null) {
            this.hYg.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
        aVar.x(arrayList).nP(i).AE(bwVar.bmE()).AF(String.valueOf(bwVar.getFid())).AG(bwVar.getTid()).ix(this.akk).AH(arrayList.size() > 0 ? arrayList.get(0) : "").iy(true).a(concurrentHashMap).iz(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        dU.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.exA == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.exA.e(false, true, this.hZy);
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
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
