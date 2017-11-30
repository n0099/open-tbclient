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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.p;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class q extends a<CardPersonDynamicThreadData> {
    private boolean ajn;
    private View.OnClickListener bZf;
    public ThreadCommentAndPraiseInfoLayout bvH;
    public PlayVoiceBntNew caI;
    private TextView caK;
    private ConstrainImageGroup caL;
    private final View.OnClickListener caO;
    private AlaPlayAnimationView caa;
    private CustomMessageListener cab;
    private TbImageView.a cav;
    public ThreadViewAndCommentInfoLayout cbK;
    private final String cbL;
    private final String cbM;
    private TextView cbN;
    private LinearLayout cbO;
    private TextView cbP;
    private TextView cbQ;
    private TextView cbR;
    private TextView cbS;
    private ImageView cbT;
    private p cbU;
    private PhotoLiveCoverView cbV;
    private View cbW;
    private TbImageView cbX;
    private ImageView cbY;
    private LinearLayout cbZ;
    private CardPersonDynamicThreadData cbx;
    private TextView cca;
    private LinearLayout ccb;
    private LinearLayout ccc;
    private TextView ccd;
    private TextView cce;
    private TextView ccf;
    private TextView ccg;
    private TextView cch;
    public OriginalThreadCardView cci;
    private View ccj;
    private View cck;
    private boolean ccl;
    private boolean ccm;
    com.baidu.tieba.view.i ccn;
    private p.a cco;
    private final View.OnClickListener ccp;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbL = "1";
        this.cbM = "2";
        this.mSkinType = 3;
        this.ajn = true;
        this.ccn = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.cbx != null && !StringUtils.isNull(q.this.cbx.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.cbx.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(d.C0082d.cp_link_tip_c) : q.this.mContext.getResources().getColor(d.C0082d.cp_link_tip_a));
            }
        };
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.abs() != null) {
                    q.this.abs().a(view, q.this.cbx);
                }
                if (q.this.cbx.ced != 33) {
                    if (q.this.cbx.ced != 60) {
                        if ((q.this.cbx.ced != 40 || q.this.cbx.ceg != 2) && !q.this.ccm) {
                            q.this.abK();
                            return;
                        } else {
                            BdToast.b(q.this.getContext(), q.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).tt();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (q.this.cbx.threadData.rQ().live_status != 1) {
                        q.this.abS();
                        return;
                    } else {
                        q.this.abR();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                q.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(q.this.mPageContext.getPageActivity(), q.this.cbx.threadId).cz(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bD(23014).pp()));
            }
        };
        this.cab = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.cbx != null && q.this.cbx.threadId != null && q.this.mTitle != null && q.this.caK != null && ((String) customResponsedMessage.getData()).equals(q.this.cbx.threadId) && !q.this.isHost()) {
                    k.a(q.this.mTitle, q.this.cbx.threadId, d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                    k.a(q.this.caK, q.this.cbx.threadId, d.C0082d.cp_cont_j, d.C0082d.cp_cont_d);
                }
            }
        };
        this.cco = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.dS(z);
            }
        };
        this.ccp = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> abs = q.this.abs();
                if (abs != null) {
                    view.setTag("1");
                    abs.a(view, q.this.cbx);
                }
                q.this.abK();
            }
        };
        this.caO = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> abs = q.this.abs();
                if (abs != null) {
                    view.setTag("2");
                    abs.a(view, q.this.cbx);
                }
            }
        };
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && q.this.cbX != null) {
                    q.this.cbX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cbN = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cbO = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cbP = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cbQ = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cbR = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cch = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cbS = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cbT = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.caI = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.caI.setAfterClickListener(this.caO);
        this.caK = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.caK.setVisibility(8);
        this.caL = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.caL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.caL.setChildClickListener(this.ccp);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caL.setImageProcessor(fVar);
        this.cbW = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cbX = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cbY = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cbV = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cbK = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.ccc = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.ccd = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cce = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.ccf = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.caa = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.ccg = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cbZ = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cca = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.ccb = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.ccb.setVisibility(8);
        this.cci = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.ccj = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cck = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setFrom(1);
        this.bvH.setShareReportFrom(6);
        this.bvH.setStType("person_page");
        this.bvH.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.abs() != null) {
                    q.this.abs().a(view, q.this.cbx);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.i(this.cbN, d.C0082d.cp_cont_b);
            aj.i(this.cbP, d.C0082d.cp_cont_j);
            aj.i(this.cbQ, d.C0082d.cp_cont_b);
            aj.i(this.cbR, d.C0082d.cp_cont_d);
            aj.i(this.cch, d.C0082d.cp_cont_d);
            aj.i(this.cbS, d.C0082d.cp_cont_d);
            if (this.cbT != null) {
                this.cbT.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.i(this.mTitle, d.C0082d.cp_cont_b);
            aj.i(this.caK, d.C0082d.cp_cont_f);
            aj.i(this.cca, d.C0082d.cp_cont_f);
            if (this.cbU != null) {
                this.cbU.onChangeSkinType();
            }
            this.cbK.onChangeSkinType();
            this.bvH.onChangeSkinType();
            aj.k(this.ccj, d.C0082d.cp_bg_line_e);
            aj.k(this.cck, d.C0082d.cp_bg_line_c);
            aj.k(this.cca, d.C0082d.cp_bg_line_e);
            if (this.cci != null) {
                this.cci.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_dynamic_thread;
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
        this.cbx = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZf);
        }
        this.cbN.setVisibility(cardPersonDynamicThreadData.cer ? 0 : 8);
        this.cbO.setVisibility(cardPersonDynamicThreadData.ceq ? 0 : 4);
        this.ccj.setVisibility(cardPersonDynamicThreadData.ceq ? 0 : 8);
        this.cck.setVisibility(cardPersonDynamicThreadData.ceq ? 8 : 0);
        if (cardPersonDynamicThreadData.ces) {
            this.ccj.setVisibility(8);
            this.cck.setVisibility(8);
        }
        this.ccl = cardPersonDynamicThreadData.ced == 40 && cardPersonDynamicThreadData.ceg == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ccm = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.ceg == 2;
        }
        this.cbN.setText(cardPersonDynamicThreadData.ceh);
        this.cbP.setText(cardPersonDynamicThreadData.cei);
        this.cbQ.setText(cardPersonDynamicThreadData.cej);
        if (cardPersonDynamicThreadData.cep != null && cardPersonDynamicThreadData.cep.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cep.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.cep[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cep.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cbR.setText(sb2);
                this.cbR.setVisibility(0);
            } else {
                this.cbR.setText(d.j.person_homepage);
            }
        } else {
            this.cbR.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cbS.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cbS.setVisibility(0);
            }
            dS(cardPersonDynamicThreadData.isPrivacy);
            this.cbT.setVisibility(0);
            this.cbT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.cbU == null) {
                            q.this.cbU = new p(q.this.mPageContext);
                            q.this.cbU.create();
                            q.this.cbU.a(q.this.cco);
                        }
                        q.this.cbU.a(q.this.cbx);
                        q.this.cbU.show();
                    }
                }
            });
        } else {
            this.cbS.setVisibility(8);
            this.cbT.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cem;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.caI.setVisibility(0);
            dR(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.caI.setVoiceModel(voiceModel);
            this.caI.setTag(voiceModel);
            this.caI.blz();
            if (voiceModel != null) {
                this.caI.nM(voiceModel.voice_status.intValue());
            }
        } else {
            this.caI.setVisibility(8);
            dR(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cel;
        aj.j(this.cbZ, d.C0082d.transparent);
        this.cca.setVisibility(8);
        this.ccb.setVisibility(8);
        this.cbZ.setVisibility(0);
        this.cbV.setVisibility(8);
        this.cbW.setVisibility(8);
        this.ccg.setVisibility(8);
        this.ccc.setVisibility(8);
        this.ccf.setVisibility(8);
        this.caa.bDX();
        if (cardPersonDynamicThreadData.ced == 36) {
            this.caL.setVisibility(8);
        } else if (cardPersonDynamicThreadData.ced == 33) {
            this.caL.setVisibility(8);
            if (com.baidu.tbadk.core.h.pa().pg() && cardPersonDynamicThreadData.cen != null && !StringUtils.isNull(cardPersonDynamicThreadData.cen.livecover_src)) {
                this.cbV.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.cen)) {
                    this.cbV.setShowExpression(false);
                } else {
                    this.cbV.setShowExpression(true);
                }
                this.cbV.setShowImage(com.baidu.tbadk.core.h.pa().pg());
                this.cbV.setChooseStyle(d.getShowStyle());
                this.cbV.setData(d);
            }
        } else if (cardPersonDynamicThreadData.ced == 40 || this.cbx.ced == 50) {
            this.caL.setVisibility(8);
            if (com.baidu.tbadk.core.h.pa().pg()) {
                this.cbW.setVisibility(0);
                this.cbY.setVisibility(0);
                this.cbY.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbW.getLayoutParams();
                int width = this.cbW.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cbW.setLayoutParams(layoutParams);
                if (this.cbx.videoInfo != null) {
                    this.cbX.setDefaultErrorResource(0);
                    this.cbX.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cbX.setEvent(this.cav);
                    this.cbX.startLoad(this.cbx.videoInfo.thumbnail_url, 17, false);
                    if (this.ccl) {
                        this.ccg.setVisibility(0);
                        this.ccg.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.ccc.setVisibility(0);
                        this.ccd.setText(am.cY(this.cbx.videoInfo.video_duration.intValue() * 1000));
                        this.cce.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.A(this.cbx.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cbx.ced == 60 || this.cbx.ced == 49) {
            this.caL.setVisibility(8);
            if (this.cbx.threadData.rQ() != null && this.cbx.threadData.rQ().user_info != null && this.cbx.ced == 60) {
                String str = this.cbx.threadData.rQ().user_info.user_name;
                if (w.ha(str) > 14) {
                    str = w.H(str, 14) + "...";
                }
                this.cca.setText(k.aH(str + ":", this.cbx.threadData.getTitle()));
                this.cca.setVisibility(0);
            } else {
                this.cca.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.pa().pg()) {
                this.cbW.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cbW.getLayoutParams();
                int width2 = this.cbW.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cbW.setLayoutParams(layoutParams2);
                if (this.cbx.threadData.rQ() != null) {
                    this.cbX.setDefaultErrorResource(0);
                    this.cbX.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cbX.setEvent(this.cav);
                    this.cbX.startLoad(cardPersonDynamicThreadData.threadData.rQ().cover, 10, false);
                    this.cbY.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.caa.startPlayAnimation();
                    aj.j(this.cbZ, d.C0082d.cp_bg_line_e);
                    this.ccf.setVisibility(0);
                    this.ccf.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.cbx.threadData.rQ().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.pa().pg() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caL.setVisibility(0);
                    this.caL.setFromCDN(this.ajn);
                    this.caL.setSingleImageRatio(0.67d);
                    this.caL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                q.this.abK();
                            } else {
                                q.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.caL.setImageMediaList(linkedList);
                } else {
                    this.caL.setVisibility(8);
                }
            } else {
                this.caL.setVisibility(8);
            }
            this.cbZ.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aaI != null) {
            this.cci.setVisibility(0);
            this.cci.b(cardPersonDynamicThreadData.threadData.aaI);
            this.cci.setOnClickListener(this);
            this.caI.setVisibility(8);
            this.caL.setVisibility(8);
            this.cbZ.setVisibility(8);
            if (this.ccm) {
                this.cch.setVisibility(0);
            } else {
                this.cch.setVisibility(8);
            }
        } else {
            this.cci.setVisibility(8);
            this.cch.setVisibility(8);
        }
        abJ();
        c(cardPersonDynamicThreadData);
    }

    private void dR(boolean z) {
        if (this.caL != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caL.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.caL.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ccl || this.ccm) {
                this.bvH.setCommentClickable(false);
                this.bvH.setAgreeClickable(false);
                this.bvH.setShareClickable(false);
                this.cci.setClickable(false);
                this.cbT.setClickable(false);
            } else {
                this.bvH.setCommentClickable(true);
                this.bvH.setAgreeClickable(true);
                this.bvH.setShareClickable(true);
                this.cci.setClickable(true);
                this.cbT.setClickable(true);
            }
            this.bvH.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.ced == 60) {
                this.bvH.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cep != null) {
                this.bvH.setMultiForumCount(cardPersonDynamicThreadData.cep.length);
            }
            this.bvH.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void abJ() {
        this.caI.setClickable(true);
        int childCount = this.caL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caL.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void abR() {
        if (this.cbx != null && this.cbx.threadData != null && this.cbx.threadData.rQ() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                k.jQ(this.cbx.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cbx.threadData.rQ());
            if (this.cbx.threadData.rQ().user_info != null) {
                alaLiveInfoCoreData.userName = this.cbx.threadData.rQ().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abS() {
        if (this.cbx != null && this.cbx.threadData != null && this.cbx.threadData.rQ() != null && this.cbx.threadData.rQ().share_info != null) {
            if (!isHost()) {
                k.jQ(this.cbx.threadId);
            }
            if (this.cbx.threadData.rQ().share_info.record_tid <= 0) {
                abR();
                return;
            }
            String valueOf = String.valueOf(this.cbx.threadData.rQ().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        if (this.cbx != null) {
            if (!isHost()) {
                k.jQ(this.cbx.threadId);
                k.a(this.mTitle, this.cbx.threadId, d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                k.a(this.caK, this.cbx.threadId, d.C0082d.cp_cont_j, d.C0082d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cbx.ced == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cbx.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cbx.threadData.getFid()));
            pbActivityConfig.setForumName(this.cbx.threadData.rD());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cbx.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    private void abT() {
        if (this.cbx != null && this.cbx.threadData != null && this.cbx.threadData.aaI != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cbx.threadData.aaI.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(boolean z) {
        if (this.cbS != null) {
            if (z) {
                this.cbS.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cbS.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cbS.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cbS.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cbx.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cci) {
            abT();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caL != null) {
            this.caL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caL != null) {
            this.caL.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.ajn ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rD(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.cen != null) {
            if (cardPersonDynamicThreadData.cen.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.cen.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.cen.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.cen.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.cen.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.cen.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.cen.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.cen.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.cen.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.cen.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.cee);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.cek != null && cardPersonDynamicThreadData.cek.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cek.length; i++) {
                sb.append(cardPersonDynamicThreadData.cek[i].text);
            }
            photoLiveCardData.setContent(photoLiveCardData.deleteBlackSpace(sb.toString()));
        }
        photoLiveCardData.setTitle(photoLiveCardData.deleteBlackSpace(cardPersonDynamicThreadData.title));
        photoLiveCardData.setThreadId(Long.parseLong(cardPersonDynamicThreadData.threadId));
        return photoLiveCardData;
    }

    private int a(CardPersonDynamicThreadData.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.e> a(CardPersonDynamicThreadData.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
            if (labelInfoArr[i] != null) {
                eVar.ev(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean e(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ccl);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(c));
        this.mTitle.setText(c);
        k.a(this.mTitle, cardPersonDynamicThreadData.threadData.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        return true;
    }
}
