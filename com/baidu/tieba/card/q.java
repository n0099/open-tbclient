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
import com.baidu.tbadk.util.ae;
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
/* loaded from: classes18.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView afz;
    public PlayVoiceBntNew ajD;
    private boolean ajr;
    private TextView akR;
    private TextView akT;
    private TbImageView.a fcf;
    public ThreadCommentAndPraiseInfoLayout gja;
    private ConstrainImageGroup hjL;
    private View.OnClickListener hjQ;
    private final View.OnClickListener hjR;
    private CustomMessageListener hjh;
    public ThreadViewAndCommentInfoLayout hkE;
    private final String hkF;
    private final String hkG;
    private TextView hkH;
    private LinearLayout hkI;
    private TextView hkJ;
    private TextView hkK;
    private TextView hkL;
    private TextView hkM;
    private ImageView hkN;
    private p hkO;
    private View hkP;
    private TbImageView hkQ;
    private ImageView hkR;
    private LinearLayout hkS;
    private TextView hkT;
    private LinearLayout hkU;
    private LinearLayout hkV;
    private TextView hkW;
    private TBLottieAnimationView hkX;
    private TextView hkY;
    private TextView hkZ;
    private CardPersonDynamicThreadData hkp;
    public OriginalThreadCardView hla;
    private View hlb;
    private View hlc;
    private boolean hld;
    private boolean hle;
    com.baidu.tieba.view.g hlf;
    private p.a hlg;
    private final View.OnClickListener hlh;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hkF = "1";
        this.hkG = "2";
        this.mSkinType = 3;
        this.ajr = true;
        this.hlf = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.hkp != null && !StringUtils.isNull(q.this.hkp.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.hkp.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.hjQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cbz() != null) {
                    q.this.cbz().a(view, q.this.hkp);
                }
                if (q.this.hkp.hnD != 60) {
                    if ((q.this.hkp.hnD != 40 || q.this.hkp.hnF != 2) && !q.this.hle) {
                        q.this.bpE();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).bhm();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.hkp.dUS.beY().live_status != 1) {
                    q.this.cbV();
                } else {
                    q.this.cbU();
                }
            }
        };
        this.hjh = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.hkp != null && q.this.hkp.threadId != null && q.this.mTitle != null && q.this.afz != null && ((String) customResponsedMessage.getData()).equals(q.this.hkp.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.hkp.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                    m.a(q.this.afz, q.this.hkp.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
                }
            }
        };
        this.hlg = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.nj(z);
            }
        };
        this.hlh = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cbz = q.this.cbz();
                if (cbz != null) {
                    view.setTag("1");
                    cbz.a(view, q.this.hkp);
                }
                q.this.bpE();
            }
        };
        this.hjR = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> cbz = q.this.cbz();
                if (cbz != null) {
                    view.setTag("2");
                    cbz.a(view, q.this.hkp);
                }
            }
        };
        this.fcf = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.hkQ != null) {
                    q.this.hkQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hkH = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hkI = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hkJ = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hkK = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hkL = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hkZ = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hkM = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hkN = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.ajD = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.ajD.setAfterClickListener(this.hjR);
        this.afz = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.afz.setVisibility(8);
        this.hjL = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hjL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hjL.setChildClickListener(this.hlh);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.u(1.0d);
        this.hjL.setImageProcessor(aVar);
        this.hkP = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hkQ = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hkR = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hkE = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hkV = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.akT = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.akR = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hkW = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hkX = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hkX.loop(true);
        ap.a(this.hkX, R.raw.ala_play);
        this.hkY = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hkS = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hkT = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hkU = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hkU.setVisibility(8);
        this.hla = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hlb = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hlc = this.mRootView.findViewById(R.id.divider_line_thin);
        this.gja = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.gja.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gja.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gja.setLayoutParams(layoutParams);
        }
        this.gja.setOnClickListener(this.hjQ);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setShareVisible(true);
        this.gja.setIsBarViewVisible(false);
        this.gja.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 8;
        cVar.dWQ = 3;
        this.gja.setAgreeStatisticData(cVar);
        this.gja.setShareReportFrom(6);
        this.gja.setStType("person_page");
        this.gja.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.cbz() != null) {
                    q.this.cbz().a(view, q.this.hkp);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hkX, R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hkH, R.color.cp_cont_b);
            ap.setViewTextColor(this.hkJ, R.color.cp_cont_j);
            ap.setViewTextColor(this.hkK, R.color.cp_cont_b);
            ap.setViewTextColor(this.hkL, R.color.cp_cont_d);
            ap.setViewTextColor(this.hkZ, R.color.cp_cont_d);
            ap.setViewTextColor(this.hkM, R.color.cp_cont_d);
            if (this.hkN != null) {
                this.hkN.setImageDrawable(SvgManager.bjq().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setViewTextColor(this.afz, R.color.cp_cont_f);
            ap.setViewTextColor(this.hkT, R.color.cp_cont_f);
            if (this.hkO != null) {
                this.hkO.onChangeSkinType();
            }
            this.hkE.onChangeSkinType();
            this.gja.onChangeSkinType();
            ap.setBackgroundColor(this.hlb, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hlc, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.hkT, R.color.cp_bg_line_e);
            if (this.hla != null) {
                this.hla.onChangeSkinType();
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
        this.hkp = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hjQ);
        }
        this.hkH.setVisibility(cardPersonDynamicThreadData.hnP ? 0 : 8);
        this.hkI.setVisibility(cardPersonDynamicThreadData.hnO ? 0 : 4);
        this.hlb.setVisibility(cardPersonDynamicThreadData.hnO ? 0 : 8);
        this.hlc.setVisibility(cardPersonDynamicThreadData.hnO ? 8 : 0);
        if (cardPersonDynamicThreadData.hnQ) {
            this.hlb.setVisibility(8);
            this.hlc.setVisibility(8);
        }
        this.hld = cardPersonDynamicThreadData.hnD == 40 && cardPersonDynamicThreadData.hnF == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dUS != null) {
            this.hle = cardPersonDynamicThreadData.dUS.isShareThread && cardPersonDynamicThreadData.hnF == 2;
        }
        this.hkH.setText(cardPersonDynamicThreadData.hnG);
        this.hkJ.setText(cardPersonDynamicThreadData.hnH);
        this.hkK.setText(cardPersonDynamicThreadData.hnI);
        if (cardPersonDynamicThreadData.hnN != null && cardPersonDynamicThreadData.hnN.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.hnN.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.hnN[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.hnN.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hkL.setText(sb2);
                this.hkL.setVisibility(0);
            } else {
                this.hkL.setText(R.string.person_homepage);
            }
        } else {
            this.hkL.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hkM.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hkM.setVisibility(0);
            }
            nj(cardPersonDynamicThreadData.isPrivacy);
            this.hkN.setVisibility(0);
            this.hkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.hkO == null) {
                            q.this.hkO = new p(q.this.mPageContext);
                            q.this.hkO.create();
                            q.this.hkO.a(q.this.hlg);
                        }
                        q.this.hkO.a(q.this.hkp);
                        q.this.hkO.show();
                    }
                }
            });
        } else {
            this.hkM.setVisibility(8);
            this.hkN.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.hnL;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.ajD.setVisibility(0);
            ni(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.ajD.setVoiceModel(voiceModel);
            this.ajD.setTag(voiceModel);
            this.ajD.changeSkin();
            if (voiceModel != null) {
                this.ajD.BM(voiceModel.voice_status.intValue());
            }
            this.ajD.bPe();
        } else {
            this.ajD.setVisibility(8);
            ni(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.hnK;
        ap.setBackgroundResource(this.hkS, R.color.transparent);
        this.hkT.setVisibility(8);
        this.hkU.setVisibility(8);
        this.hkS.setVisibility(0);
        this.hkP.setVisibility(8);
        this.hkY.setVisibility(8);
        this.hkV.setVisibility(8);
        this.hkW.setVisibility(8);
        this.hkX.cancelAnimation();
        this.hkX.setVisibility(8);
        if (cardPersonDynamicThreadData.hnD == 36) {
            this.hjL.setVisibility(8);
        } else if (cardPersonDynamicThreadData.hnD == 40 || this.hkp.hnD == 50) {
            this.hjL.setVisibility(8);
            if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
                this.hkP.setVisibility(0);
                this.hkR.setVisibility(0);
                this.hkR.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hkP.getLayoutParams();
                int width = this.hkP.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hkP.setLayoutParams(layoutParams);
                if (this.hkp.videoInfo != null) {
                    this.hkQ.setDefaultErrorResource(0);
                    this.hkQ.setPlaceHolder(3);
                    this.hkQ.setEvent(this.fcf);
                    this.hkQ.startLoad(this.hkp.videoInfo.thumbnail_url, 17, false);
                    if (this.hld) {
                        this.hkY.setVisibility(0);
                        this.hkY.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hkV.setVisibility(0);
                        this.akT.setText(at.stringForVideoTime(this.hkp.videoInfo.video_duration.intValue() * 1000));
                        this.akR.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hkp.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hkp.hnD == 60 || this.hkp.hnD == 49) {
            this.hjL.setVisibility(8);
            if (this.hkp.dUS.beY() != null && this.hkp.dUS.beY().user_info != null && this.hkp.hnD == 60) {
                String str = this.hkp.dUS.beY().user_info.user_name;
                if (ae.getTextLengthWithEmoji(str) > 14) {
                    str = ae.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hkT.setText(m.em(str + ":", this.hkp.dUS.getTitle()));
                this.hkT.setVisibility(0);
            } else {
                this.hkT.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
                this.hkP.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hkP.getLayoutParams();
                int width2 = this.hkP.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hkP.setLayoutParams(layoutParams2);
                if (this.hkp.dUS.beY() != null) {
                    this.hkQ.setDefaultErrorResource(0);
                    this.hkQ.setPlaceHolder(3);
                    this.hkQ.setEvent(this.fcf);
                    this.hkQ.startLoad(cardPersonDynamicThreadData.dUS.beY().cover, 10, false);
                    this.hkR.setVisibility(8);
                    this.hkX.setVisibility(0);
                    this.hkX.playAnimation();
                    ap.setBackgroundResource(this.hkS, R.color.cp_bg_line_e);
                    this.hkW.setVisibility(0);
                    this.hkW.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.hkp.dUS.beY().audience_count)));
                    this.gja.getCommentContainer().setOnClickListener(this.hjQ);
                } else {
                    this.gja.getCommentContainer().setOnClickListener(this.gja);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bbM().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bw bwVar = cardPersonDynamicThreadData.dUS;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hjL.setVisibility(0);
                    this.hjL.setFromCDN(this.ajr);
                    this.hjL.setSingleImageRatio(0.67d);
                    this.hjL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bpE();
                            } else {
                                q.this.a(view, linkedList, i2, bwVar);
                            }
                        }
                    });
                    this.hjL.setImageMediaList(linkedList);
                } else {
                    this.hjL.setVisibility(8);
                }
            } else {
                this.hjL.setVisibility(8);
            }
            this.hkS.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dUS != null && cardPersonDynamicThreadData.dUS.edE != null) {
            this.hla.setVisibility(0);
            this.hla.b(cardPersonDynamicThreadData.dUS.edE);
            this.hla.setOnClickListener(this);
            this.ajD.setVisibility(8);
            this.hjL.setVisibility(8);
            this.hkS.setVisibility(8);
            if (this.hle) {
                this.hkZ.setVisibility(0);
            } else {
                this.hkZ.setVisibility(8);
            }
        } else {
            this.hla.setVisibility(8);
            this.hkZ.setVisibility(8);
        }
        cbR();
        c(cardPersonDynamicThreadData);
    }

    private void ni(boolean z) {
        if (this.hjL != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjL.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hjL.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hld || this.hle) {
                this.gja.setCommentClickable(false);
                this.gja.setAgreeClickable(false);
                this.gja.setShareClickable(false);
                this.hla.setClickable(false);
                this.hkN.setClickable(false);
            } else {
                this.gja.setCommentClickable(true);
                this.gja.setAgreeClickable(true);
                this.gja.setShareClickable(true);
                this.hla.setClickable(true);
                this.hkN.setClickable(true);
            }
            this.gja.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.hnD == 60) {
                this.gja.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.hnN != null) {
                this.gja.setMultiForumCount(cardPersonDynamicThreadData.hnN.length);
            }
            if (cardPersonDynamicThreadData.dUS != null) {
                this.gja.setForumId(String.valueOf(cardPersonDynamicThreadData.dUS.getFid()));
            }
            this.gja.setData(cardPersonDynamicThreadData.dUS);
        }
    }

    private void cbR() {
        this.ajD.setClickable(true);
        int childCount = this.hjL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hjL.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void cbU() {
        if (this.hkp != null && this.hkp.dUS != null && this.hkp.dUS.beY() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.GY(this.hkp.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hkp.dUS.beY());
            if (this.hkp.dUS.beY().user_info != null) {
                alaLiveInfoCoreData.userName = this.hkp.dUS.beY().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbV() {
        if (this.hkp != null && this.hkp.dUS != null && this.hkp.dUS.beY() != null && this.hkp.dUS.beY().share_info != null) {
            if (!isHost()) {
                m.GY(this.hkp.threadId);
            }
            if (this.hkp.dUS.beY().share_info.record_tid <= 0) {
                cbU();
                return;
            }
            String valueOf = String.valueOf(this.hkp.dUS.beY().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hkp.dUS);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpE() {
        if (this.hkp != null) {
            if (!isHost()) {
                m.GY(this.hkp.threadId);
                m.a(this.mTitle, this.hkp.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.afz, this.hkp.threadId, R.color.cp_cont_j, R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hkp.hnD == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hkp.dUS, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hkp.dUS.getFid()));
            pbActivityConfig.setForumName(this.hkp.dUS.beI());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hkp.dUS.isShareThread);
            pbActivityConfig.setThreadData(this.hkp.dUS);
            pbActivityConfig.setIsPrivacy(this.hkp.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hkp.dUS == null || !this.hkp.dUS.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dD("obj_type", "2").dD("tid", this.hkp.threadId).ai("obj_param1", this.hkp.isHost ? 1 : 2));
        }
    }

    private void cbW() {
        if (this.hkp != null && this.hkp.dUS != null && this.hkp.dUS.edE != null) {
            OriginalThreadInfo originalThreadInfo = this.hkp.dUS.edE;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dD("obj_type", "3").dD("tid", this.hkp.threadId).ai("obj_param1", this.hkp.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(boolean z) {
        if (this.hkM != null) {
            if (z) {
                this.hkM.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hkM.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hkM.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hkM.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hkp.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hla) {
            cbW();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjL != null) {
            this.hjL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjL != null) {
            this.hjL.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.ajr ? 13 : 14;
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
        aVar.x(arrayList).mM(i).yP(bwVar.beI()).yQ(String.valueOf(bwVar.getFid())).yR(bwVar.getTid()).hH(this.ajr).yS(arrayList.size() > 0 ? arrayList.get(0) : "").hI(true).a(concurrentHashMap).hJ(true).r(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dP = aVar.dP(this.mPageContext.getPageActivity());
        dP.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dUS == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.dUS.e(false, true, this.hld);
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
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, R.color.cp_cont_b, R.color.cp_cont_d);
        return true;
    }
}
