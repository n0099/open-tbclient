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
import com.baidu.tieba.card.p;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes23.dex */
public class q extends b<CardPersonDynamicThreadData> {
    private TextView afT;
    private boolean ajR;
    public PlayVoiceBntNew akd;
    private TextView alt;
    private TextView alv;
    private TbImageView.a ffc;
    public ThreadCommentAndPraiseInfoLayout gml;
    private ConstrainImageGroup hqS;
    private View.OnClickListener hqX;
    private final View.OnClickListener hqY;
    private CustomMessageListener hqo;
    public ThreadViewAndCommentInfoLayout hrL;
    private final String hrM;
    private final String hrN;
    private TextView hrO;
    private LinearLayout hrP;
    private TextView hrQ;
    private TextView hrR;
    private TextView hrS;
    private TextView hrT;
    private ImageView hrU;
    private p hrV;
    private View hrW;
    private TbImageView hrX;
    private ImageView hrY;
    private LinearLayout hrZ;
    private CardPersonDynamicThreadData hrw;
    private TextView hsa;
    private LinearLayout hsb;
    private LinearLayout hsc;
    private TextView hsd;
    private TBLottieAnimationView hse;
    private TextView hsf;
    private TextView hsg;
    public OriginalThreadCardView hsh;
    private View hsi;
    private View hsj;
    private boolean hsk;
    private boolean hsl;
    com.baidu.tieba.view.g hsm;
    private p.a hsn;
    private final View.OnClickListener hso;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hrM = "1";
        this.hrN = "2";
        this.mSkinType = 3;
        this.ajR = true;
        this.hsm = new com.baidu.tieba.view.g() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.hrw != null && !StringUtils.isNull(q.this.hrw.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.hrw.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.g
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : q.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.hqX = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.ceP() != null) {
                    q.this.ceP().a(view, q.this.hrw);
                }
                if (q.this.hrw.huL != 60) {
                    if ((q.this.hrw.huL != 40 || q.this.hrw.huN != 2) && !q.this.hsl) {
                        q.this.bqz();
                        return;
                    } else {
                        BdToast.a(q.this.getContext(), (CharSequence) q.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).big();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (q.this.hrw.dXg.bfS().live_status != 1) {
                    q.this.cfl();
                } else {
                    q.this.cfk();
                }
            }
        };
        this.hqo = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.hrw != null && q.this.hrw.threadId != null && q.this.mTitle != null && q.this.afT != null && ((String) customResponsedMessage.getData()).equals(q.this.hrw.threadId) && !q.this.isHost()) {
                    m.a(q.this.mTitle, q.this.hrw.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    m.a(q.this.afT, q.this.hrw.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.hsn = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.nr(z);
            }
        };
        this.hso = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> ceP = q.this.ceP();
                if (ceP != null) {
                    view.setTag("1");
                    ceP.a(view, q.this.hrw);
                }
                q.this.bqz();
            }
        };
        this.hqY = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<CardPersonDynamicThreadData> ceP = q.this.ceP();
                if (ceP != null) {
                    view.setTag("2");
                    ceP.a(view, q.this.hrw);
                }
            }
        };
        this.ffc = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && q.this.hrX != null) {
                    q.this.hrX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.hrO = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.hrP = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.hrQ = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.hrR = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.hrS = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.hsg = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.hrT = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.hrU = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.akd = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.akd.setAfterClickListener(this.hqY);
        this.afT = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.afT.setVisibility(8);
        this.hqS = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.hqS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hqS.setChildClickListener(this.hso);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.u(1.0d);
        this.hqS.setImageProcessor(aVar);
        this.hrW = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.hrX = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.hrY = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.hrL = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.hsc = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.alv = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.alt = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.hsd = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.hse = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.hse.loop(true);
        ap.a(this.hse, (int) R.raw.ala_play);
        this.hsf = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.hrZ = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.hsa = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.hsb = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.hsb.setVisibility(8);
        this.hsh = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.hsi = this.mRootView.findViewById(R.id.divider_line_thick);
        this.hsj = this.mRootView.findViewById(R.id.divider_line_thin);
        this.gml = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.gml.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gml.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gml.setLayoutParams(layoutParams);
        }
        this.gml.setOnClickListener(this.hqX);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setShareVisible(true);
        this.gml.setIsBarViewVisible(false);
        this.gml.setFrom(13);
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 8;
        cVar.dZe = 3;
        this.gml.setAgreeStatisticData(cVar);
        this.gml.setShareReportFrom(6);
        this.gml.setStType("person_page");
        this.gml.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.ceP() != null) {
                    q.this.ceP().a(view, q.this.hrw);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.a(this.hse, (int) R.raw.ala_play);
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.hrO, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.hrQ, (int) R.color.cp_cont_j);
            ap.setViewTextColor(this.hrR, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.hrS, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.hsg, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.hrT, (int) R.color.cp_cont_d);
            if (this.hrU != null) {
                this.hrU.setImageDrawable(SvgManager.bkl().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.afT, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.hsa, (int) R.color.cp_cont_f);
            if (this.hrV != null) {
                this.hrV.onChangeSkinType();
            }
            this.hrL.onChangeSkinType();
            this.gml.onChangeSkinType();
            ap.setBackgroundColor(this.hsi, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hsj, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.hsa, R.color.cp_bg_line_e);
            if (this.hsh != null) {
                this.hsh.onChangeSkinType();
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
        this.hrw = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hqX);
        }
        this.hrO.setVisibility(cardPersonDynamicThreadData.huX ? 0 : 8);
        this.hrP.setVisibility(cardPersonDynamicThreadData.huW ? 0 : 4);
        this.hsi.setVisibility(cardPersonDynamicThreadData.huW ? 0 : 8);
        this.hsj.setVisibility(cardPersonDynamicThreadData.huW ? 8 : 0);
        if (cardPersonDynamicThreadData.huY) {
            this.hsi.setVisibility(8);
            this.hsj.setVisibility(8);
        }
        this.hsk = cardPersonDynamicThreadData.huL == 40 && cardPersonDynamicThreadData.huN == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.dXg != null) {
            this.hsl = cardPersonDynamicThreadData.dXg.isShareThread && cardPersonDynamicThreadData.huN == 2;
        }
        this.hrO.setText(cardPersonDynamicThreadData.huO);
        this.hrQ.setText(cardPersonDynamicThreadData.huP);
        this.hrR.setText(cardPersonDynamicThreadData.huQ);
        if (cardPersonDynamicThreadData.huV != null && cardPersonDynamicThreadData.huV.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.huV.length; i++) {
                sb.append(at.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.huV[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.huV.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.hrS.setText(sb2);
                this.hrS.setVisibility(0);
            } else {
                this.hrS.setText(R.string.person_homepage);
            }
        } else {
            this.hrS.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.hrT.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.hrT.setVisibility(0);
            }
            nr(cardPersonDynamicThreadData.isPrivacy);
            this.hrU.setVisibility(0);
            this.hrU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.hrV == null) {
                            q.this.hrV = new p(q.this.mPageContext);
                            q.this.hrV.create();
                            q.this.hrV.a(q.this.hsn);
                        }
                        q.this.hrV.a(q.this.hrw);
                        q.this.hrV.show();
                    }
                }
            });
        } else {
            this.hrT.setVisibility(8);
            this.hrU.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.huT;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.akd.setVisibility(0);
            nq(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.akd.setVoiceModel(voiceModel);
            this.akd.setTag(voiceModel);
            this.akd.changeSkin();
            if (voiceModel != null) {
                this.akd.Cn(voiceModel.voice_status.intValue());
            }
            this.akd.bQr();
        } else {
            this.akd.setVisibility(8);
            nq(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.huS;
        ap.setBackgroundResource(this.hrZ, R.color.transparent);
        this.hsa.setVisibility(8);
        this.hsb.setVisibility(8);
        this.hrZ.setVisibility(0);
        this.hrW.setVisibility(8);
        this.hsf.setVisibility(8);
        this.hsc.setVisibility(8);
        this.hsd.setVisibility(8);
        this.hse.cancelAnimation();
        this.hse.setVisibility(8);
        if (cardPersonDynamicThreadData.huL == 36) {
            this.hqS.setVisibility(8);
        } else if (cardPersonDynamicThreadData.huL == 40 || this.hrw.huL == 50) {
            this.hqS.setVisibility(8);
            if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
                this.hrW.setVisibility(0);
                this.hrY.setVisibility(0);
                this.hrY.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hrW.getLayoutParams();
                int width = this.hrW.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.hrW.setLayoutParams(layoutParams);
                if (this.hrw.videoInfo != null) {
                    this.hrX.setDefaultErrorResource(0);
                    this.hrX.setPlaceHolder(3);
                    this.hrX.setEvent(this.ffc);
                    this.hrX.startLoad(this.hrw.videoInfo.thumbnail_url, 17, false);
                    if (this.hsk) {
                        this.hsf.setVisibility(0);
                        this.hsf.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.hsc.setVisibility(0);
                        this.alv.setText(at.stringForVideoTime(this.hrw.videoInfo.video_duration.intValue() * 1000));
                        this.alt.setText(String.format(this.mContext.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hrw.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.hrw.huL == 60 || this.hrw.huL == 49) {
            this.hqS.setVisibility(8);
            if (this.hrw.dXg.bfS() != null && this.hrw.dXg.bfS().user_info != null && this.hrw.huL == 60) {
                String str = this.hrw.dXg.bfS().user_info.user_name;
                if (af.getTextLengthWithEmoji(str) > 14) {
                    str = af.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.hsa.setText(m.er(str + ":", this.hrw.dXg.getTitle()));
                this.hsa.setVisibility(0);
            } else {
                this.hsa.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
                this.hrW.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hrW.getLayoutParams();
                int width2 = this.hrW.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.hrW.setLayoutParams(layoutParams2);
                if (this.hrw.dXg.bfS() != null) {
                    this.hrX.setDefaultErrorResource(0);
                    this.hrX.setPlaceHolder(3);
                    this.hrX.setEvent(this.ffc);
                    this.hrX.startLoad(cardPersonDynamicThreadData.dXg.bfS().cover, 10, false);
                    this.hrY.setVisibility(8);
                    this.hse.setVisibility(0);
                    this.hse.playAnimation();
                    ap.setBackgroundResource(this.hrZ, R.color.cp_bg_line_e);
                    this.hsd.setVisibility(0);
                    this.hsd.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.hrw.dXg.bfS().audience_count)));
                    this.gml.getCommentContainer().setOnClickListener(this.hqX);
                } else {
                    this.gml.getCommentContainer().setOnClickListener(this.gml);
                }
            }
        } else {
            if (com.baidu.tbadk.core.k.bcG().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bw bwVar = cardPersonDynamicThreadData.dXg;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hqS.setVisibility(0);
                    this.hqS.setFromCDN(this.ajR);
                    this.hqS.setSingleImageRatio(0.67d);
                    this.hqS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                q.this.bqz();
                            } else {
                                q.this.a(view, linkedList, i2, bwVar);
                            }
                        }
                    });
                    this.hqS.setImageMediaList(linkedList);
                } else {
                    this.hqS.setVisibility(8);
                }
            } else {
                this.hqS.setVisibility(8);
            }
            this.hrZ.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.dXg != null && cardPersonDynamicThreadData.dXg.efS != null) {
            this.hsh.setVisibility(0);
            this.hsh.b(cardPersonDynamicThreadData.dXg.efS);
            this.hsh.setOnClickListener(this);
            this.akd.setVisibility(8);
            this.hqS.setVisibility(8);
            this.hrZ.setVisibility(8);
            if (this.hsl) {
                this.hsg.setVisibility(0);
            } else {
                this.hsg.setVisibility(8);
            }
        } else {
            this.hsh.setVisibility(8);
            this.hsg.setVisibility(8);
        }
        cfh();
        c(cardPersonDynamicThreadData);
    }

    private void nq(boolean z) {
        if (this.hqS != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqS.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.hqS.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.hsk || this.hsl) {
                this.gml.setCommentClickable(false);
                this.gml.setAgreeClickable(false);
                this.gml.setShareClickable(false);
                this.hsh.setClickable(false);
                this.hrU.setClickable(false);
            } else {
                this.gml.setCommentClickable(true);
                this.gml.setAgreeClickable(true);
                this.gml.setShareClickable(true);
                this.hsh.setClickable(true);
                this.hrU.setClickable(true);
            }
            this.gml.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.huL == 60) {
                this.gml.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.huV != null) {
                this.gml.setMultiForumCount(cardPersonDynamicThreadData.huV.length);
            }
            if (cardPersonDynamicThreadData.dXg != null) {
                this.gml.setForumId(String.valueOf(cardPersonDynamicThreadData.dXg.getFid()));
            }
            this.gml.setData(cardPersonDynamicThreadData.dXg);
        }
    }

    private void cfh() {
        this.akd.setClickable(true);
        int childCount = this.hqS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hqS.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void cfk() {
        if (this.hrw != null && this.hrw.dXg != null && this.hrw.dXg.bfS() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                m.Hw(this.hrw.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.hrw.dXg.bfS());
            if (this.hrw.dXg.bfS().user_info != null) {
                alaLiveInfoCoreData.userName = this.hrw.dXg.bfS().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfl() {
        if (this.hrw != null && this.hrw.dXg != null && this.hrw.dXg.bfS() != null && this.hrw.dXg.bfS().share_info != null) {
            if (!isHost()) {
                m.Hw(this.hrw.threadId);
            }
            if (this.hrw.dXg.bfS().share_info.record_tid <= 0) {
                cfk();
                return;
            }
            String valueOf = String.valueOf(this.hrw.dXg.bfS().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.hrw.dXg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqz() {
        if (this.hrw != null) {
            if (!isHost()) {
                m.Hw(this.hrw.threadId);
                m.a(this.mTitle, this.hrw.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.afT, this.hrw.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.hrw.huL == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.hrw.dXg, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.hrw.dXg.getFid()));
            pbActivityConfig.setForumName(this.hrw.dXg.bfC());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.hrw.dXg.isShareThread);
            pbActivityConfig.setThreadData(this.hrw.dXg);
            pbActivityConfig.setIsPrivacy(this.hrw.isPrivacy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.hrw.dXg == null || !this.hrw.dXg.isShareThread) {
                return;
            }
            TiebaStatic.log(new aq("c12943").dF("obj_type", "2").dF("tid", this.hrw.threadId).ai("obj_param1", this.hrw.isHost ? 1 : 2));
        }
    }

    private void cfm() {
        if (this.hrw != null && this.hrw.dXg != null && this.hrw.dXg.efS != null) {
            OriginalThreadInfo originalThreadInfo = this.hrw.dXg.efS;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new aq("c12943").dF("obj_type", "3").dF("tid", this.hrw.threadId).ai("obj_param1", this.hrw.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if (this.hrT != null) {
            if (z) {
                this.hrT.setText(R.string.privacy);
                Drawable drawable = ap.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.hrT.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.hrT.setText(R.string.public_open);
            Drawable drawable2 = ap.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.hrT.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.hrw.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hsh) {
            cfm();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hqS != null) {
            this.hqS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hqS != null) {
            this.hqS.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.ajR ? 13 : 14;
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
        aVar.x(arrayList).mX(i).zl(bwVar.bfC()).zm(String.valueOf(bwVar.getFid())).zn(bwVar.getTid()).hF(this.ajR).zo(arrayList.size() > 0 ? arrayList.get(0) : "").hG(true).a(concurrentHashMap).hH(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dO = aVar.dO(this.mPageContext.getPageActivity());
        dO.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.dXg == null) {
            return false;
        }
        SpannableStringBuilder e = cardPersonDynamicThreadData.dXg.e(false, true, this.hsk);
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
        m.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
