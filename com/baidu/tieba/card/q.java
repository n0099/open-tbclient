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
    private boolean ajk;
    private View.OnClickListener bZn;
    public ThreadCommentAndPraiseInfoLayout bvM;
    private TbImageView.a caD;
    public PlayVoiceBntNew caQ;
    private TextView caS;
    private ConstrainImageGroup caT;
    private final View.OnClickListener caW;
    private AlaPlayAnimationView cai;
    private CustomMessageListener caj;
    private CardPersonDynamicThreadData cbF;
    public ThreadViewAndCommentInfoLayout cbS;
    private final String cbT;
    private final String cbU;
    private TextView cbV;
    private LinearLayout cbW;
    private TextView cbX;
    private TextView cbY;
    private TextView cbZ;
    private TextView cca;
    private ImageView ccb;
    private p ccc;
    private PhotoLiveCoverView ccd;
    private View cce;
    private TbImageView ccf;
    private ImageView ccg;
    private LinearLayout cch;
    private TextView cci;
    private LinearLayout ccj;
    private LinearLayout cck;
    private TextView ccl;
    private TextView ccm;
    private TextView ccn;
    private TextView cco;
    private TextView ccp;
    public OriginalThreadCardView ccq;
    private View ccr;
    private View cct;
    private boolean ccu;
    private boolean ccv;
    com.baidu.tieba.view.i ccw;
    private p.a ccx;
    private final View.OnClickListener ccy;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbT = "1";
        this.cbU = "2";
        this.mSkinType = 3;
        this.ajk = true;
        this.ccw = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.cbF != null && !StringUtils.isNull(q.this.cbF.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.cbF.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(d.C0095d.cp_link_tip_c) : q.this.mContext.getResources().getColor(d.C0095d.cp_link_tip_a));
            }
        };
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.abt() != null) {
                    q.this.abt().a(view, q.this.cbF);
                }
                if (q.this.cbF.cev != 33) {
                    if (q.this.cbF.cev != 60) {
                        if ((q.this.cbF.cev != 40 || q.this.cbF.cey != 2) && !q.this.ccv) {
                            q.this.abM();
                            return;
                        } else {
                            BdToast.b(q.this.getContext(), q.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).tq();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (q.this.cbF.threadData.rO().live_status != 1) {
                        q.this.abU();
                        return;
                    } else {
                        q.this.abT();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                q.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(q.this.mPageContext.getPageActivity(), q.this.cbF.threadId).cz(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bD(23014).pn()));
            }
        };
        this.caj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.cbF != null && q.this.cbF.threadId != null && q.this.mTitle != null && q.this.caS != null && ((String) customResponsedMessage.getData()).equals(q.this.cbF.threadId) && !q.this.isHost()) {
                    k.a(q.this.mTitle, q.this.cbF.threadId, d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                    k.a(q.this.caS, q.this.cbF.threadId, d.C0095d.cp_cont_j, d.C0095d.cp_cont_d);
                }
            }
        };
        this.ccx = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.dT(z);
            }
        };
        this.ccy = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> abt = q.this.abt();
                if (abt != null) {
                    view.setTag("1");
                    abt.a(view, q.this.cbF);
                }
                q.this.abM();
            }
        };
        this.caW = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> abt = q.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, q.this.cbF);
                }
            }
        };
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && q.this.ccf != null) {
                    q.this.ccf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cbV = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cbW = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cbX = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cbY = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cbZ = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.ccp = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cca = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.ccb = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.caQ = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.caQ.setAfterClickListener(this.caW);
        this.caS = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.caS.setVisibility(8);
        this.caT = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.caT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.caT.setChildClickListener(this.ccy);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caT.setImageProcessor(fVar);
        this.cce = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.ccf = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.ccg = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.ccd = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cbS = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cck = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.ccl = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.ccm = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.ccn = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cai = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cco = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cch = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cci = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.ccj = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.ccj.setVisibility(8);
        this.ccq = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.ccr = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cct = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setFrom(1);
        this.bvM.setShareReportFrom(6);
        this.bvM.setStType("person_page");
        this.bvM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.abt() != null) {
                    q.this.abt().a(view, q.this.cbF);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.i(this.cbV, d.C0095d.cp_cont_b);
            aj.i(this.cbX, d.C0095d.cp_cont_j);
            aj.i(this.cbY, d.C0095d.cp_cont_b);
            aj.i(this.cbZ, d.C0095d.cp_cont_d);
            aj.i(this.ccp, d.C0095d.cp_cont_d);
            aj.i(this.cca, d.C0095d.cp_cont_d);
            if (this.ccb != null) {
                this.ccb.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.i(this.mTitle, d.C0095d.cp_cont_b);
            aj.i(this.caS, d.C0095d.cp_cont_f);
            aj.i(this.cci, d.C0095d.cp_cont_f);
            if (this.ccc != null) {
                this.ccc.onChangeSkinType();
            }
            this.cbS.onChangeSkinType();
            this.bvM.onChangeSkinType();
            aj.k(this.ccr, d.C0095d.cp_bg_line_e);
            aj.k(this.cct, d.C0095d.cp_bg_line_c);
            aj.k(this.cci, d.C0095d.cp_bg_line_e);
            if (this.ccq != null) {
                this.ccq.onChangeSkinType();
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
        this.cbF = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        this.cbV.setVisibility(cardPersonDynamicThreadData.ceJ ? 0 : 8);
        this.cbW.setVisibility(cardPersonDynamicThreadData.ceI ? 0 : 4);
        this.ccr.setVisibility(cardPersonDynamicThreadData.ceI ? 0 : 8);
        this.cct.setVisibility(cardPersonDynamicThreadData.ceI ? 8 : 0);
        if (cardPersonDynamicThreadData.ceK) {
            this.ccr.setVisibility(8);
            this.cct.setVisibility(8);
        }
        this.ccu = cardPersonDynamicThreadData.cev == 40 && cardPersonDynamicThreadData.cey == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ccv = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cey == 2;
        }
        this.cbV.setText(cardPersonDynamicThreadData.cez);
        this.cbX.setText(cardPersonDynamicThreadData.ceA);
        this.cbY.setText(cardPersonDynamicThreadData.ceB);
        if (cardPersonDynamicThreadData.ceH != null && cardPersonDynamicThreadData.ceH.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.ceH.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.ceH[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.ceH.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cbZ.setText(sb2);
                this.cbZ.setVisibility(0);
            } else {
                this.cbZ.setText(d.j.person_homepage);
            }
        } else {
            this.cbZ.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cca.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cca.setVisibility(0);
            }
            dT(cardPersonDynamicThreadData.isPrivacy);
            this.ccb.setVisibility(0);
            this.ccb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.ccc == null) {
                            q.this.ccc = new p(q.this.mPageContext);
                            q.this.ccc.create();
                            q.this.ccc.a(q.this.ccx);
                        }
                        q.this.ccc.a(q.this.cbF);
                        q.this.ccc.show();
                    }
                }
            });
        } else {
            this.cca.setVisibility(8);
            this.ccb.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.ceE;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.caQ.setVisibility(0);
            dS(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.caQ.setVoiceModel(voiceModel);
            this.caQ.setTag(voiceModel);
            this.caQ.bmf();
            if (voiceModel != null) {
                this.caQ.nT(voiceModel.voice_status.intValue());
            }
        } else {
            this.caQ.setVisibility(8);
            dS(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.ceD;
        aj.j(this.cch, d.C0095d.transparent);
        this.cci.setVisibility(8);
        this.ccj.setVisibility(8);
        this.cch.setVisibility(0);
        this.ccd.setVisibility(8);
        this.cce.setVisibility(8);
        this.cco.setVisibility(8);
        this.cck.setVisibility(8);
        this.ccn.setVisibility(8);
        this.cai.bEG();
        if (cardPersonDynamicThreadData.cev == 36) {
            this.caT.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cev == 33) {
            this.caT.setVisibility(8);
            if (com.baidu.tbadk.core.h.oY().pe() && cardPersonDynamicThreadData.ceF != null && !StringUtils.isNull(cardPersonDynamicThreadData.ceF.livecover_src)) {
                this.ccd.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.ceF)) {
                    this.ccd.setShowExpression(false);
                } else {
                    this.ccd.setShowExpression(true);
                }
                this.ccd.setShowImage(com.baidu.tbadk.core.h.oY().pe());
                this.ccd.setChooseStyle(d.getShowStyle());
                this.ccd.setData(d);
            }
        } else if (cardPersonDynamicThreadData.cev == 40 || this.cbF.cev == 50) {
            this.caT.setVisibility(8);
            if (com.baidu.tbadk.core.h.oY().pe()) {
                this.cce.setVisibility(0);
                this.ccg.setVisibility(0);
                this.ccg.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cce.getLayoutParams();
                int width = this.cce.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cce.setLayoutParams(layoutParams);
                if (this.cbF.videoInfo != null) {
                    this.ccf.setDefaultErrorResource(0);
                    this.ccf.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ccf.setEvent(this.caD);
                    this.ccf.startLoad(this.cbF.videoInfo.thumbnail_url, 17, false);
                    if (this.ccu) {
                        this.cco.setVisibility(0);
                        this.cco.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cck.setVisibility(0);
                        this.ccl.setText(am.cY(this.cbF.videoInfo.video_duration.intValue() * 1000));
                        this.ccm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.A(this.cbF.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cbF.cev == 60 || this.cbF.cev == 49) {
            this.caT.setVisibility(8);
            if (this.cbF.threadData.rO() != null && this.cbF.threadData.rO().user_info != null && this.cbF.cev == 60) {
                String str = this.cbF.threadData.rO().user_info.user_name;
                if (com.baidu.tbadk.util.w.gY(str) > 14) {
                    str = com.baidu.tbadk.util.w.H(str, 14) + "...";
                }
                this.cci.setText(k.aH(str + ":", this.cbF.threadData.getTitle()));
                this.cci.setVisibility(0);
            } else {
                this.cci.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oY().pe()) {
                this.cce.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cce.getLayoutParams();
                int width2 = this.cce.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cce.setLayoutParams(layoutParams2);
                if (this.cbF.threadData.rO() != null) {
                    this.ccf.setDefaultErrorResource(0);
                    this.ccf.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ccf.setEvent(this.caD);
                    this.ccf.startLoad(cardPersonDynamicThreadData.threadData.rO().cover, 10, false);
                    this.ccg.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cai.startPlayAnimation();
                    aj.j(this.cch, d.C0095d.cp_bg_line_e);
                    this.ccn.setVisibility(0);
                    this.ccn.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.cbF.threadData.rO().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.oY().pe() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caT.setVisibility(0);
                    this.caT.setFromCDN(this.ajk);
                    this.caT.setSingleImageRatio(0.67d);
                    this.caT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                q.this.abM();
                            } else {
                                q.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.caT.setImageMediaList(linkedList);
                } else {
                    this.caT.setVisibility(8);
                }
            } else {
                this.caT.setVisibility(8);
            }
            this.cch.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aaF != null) {
            this.ccq.setVisibility(0);
            this.ccq.b(cardPersonDynamicThreadData.threadData.aaF);
            this.ccq.setOnClickListener(this);
            this.caQ.setVisibility(8);
            this.caT.setVisibility(8);
            this.cch.setVisibility(8);
            if (this.ccv) {
                this.ccp.setVisibility(0);
            } else {
                this.ccp.setVisibility(8);
            }
        } else {
            this.ccq.setVisibility(8);
            this.ccp.setVisibility(8);
        }
        abL();
        c(cardPersonDynamicThreadData);
    }

    private void dS(boolean z) {
        if (this.caT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.caT.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ccu || this.ccv) {
                this.bvM.setCommentClickable(false);
                this.bvM.setAgreeClickable(false);
                this.bvM.setShareClickable(false);
                this.ccq.setClickable(false);
                this.ccb.setClickable(false);
            } else {
                this.bvM.setCommentClickable(true);
                this.bvM.setAgreeClickable(true);
                this.bvM.setShareClickable(true);
                this.ccq.setClickable(true);
                this.ccb.setClickable(true);
            }
            this.bvM.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cev == 60) {
                this.bvM.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.ceH != null) {
                this.bvM.setMultiForumCount(cardPersonDynamicThreadData.ceH.length);
            }
            this.bvM.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void abL() {
        this.caQ.setClickable(true);
        int childCount = this.caT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void abT() {
        if (this.cbF != null && this.cbF.threadData != null && this.cbF.threadData.rO() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                k.jO(this.cbF.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cbF.threadData.rO());
            if (this.cbF.threadData.rO().user_info != null) {
                alaLiveInfoCoreData.userName = this.cbF.threadData.rO().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abU() {
        if (this.cbF != null && this.cbF.threadData != null && this.cbF.threadData.rO() != null && this.cbF.threadData.rO().share_info != null) {
            if (!isHost()) {
                k.jO(this.cbF.threadId);
            }
            if (this.cbF.threadData.rO().share_info.record_tid <= 0) {
                abT();
                return;
            }
            String valueOf = String.valueOf(this.cbF.threadData.rO().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        if (this.cbF != null) {
            if (!isHost()) {
                k.jO(this.cbF.threadId);
                k.a(this.mTitle, this.cbF.threadId, d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                k.a(this.caS, this.cbF.threadId, d.C0095d.cp_cont_j, d.C0095d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cbF.cev == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cbF.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cbF.threadData.getFid()));
            pbActivityConfig.setForumName(this.cbF.threadData.rB());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cbF.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    private void abV() {
        if (this.cbF != null && this.cbF.threadData != null && this.cbF.threadData.aaF != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cbF.threadData.aaF.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(boolean z) {
        if (this.cca != null) {
            if (z) {
                this.cca.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cca.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cca.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cca.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cbF.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ccq) {
            abV();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caT != null) {
            this.caT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caT != null) {
            this.caT.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.ajk ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajk, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (cardPersonDynamicThreadData.ceF != null) {
            if (cardPersonDynamicThreadData.ceF.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.ceF.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.ceF.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.ceF.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.ceF.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.ceF.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.ceF.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.ceF.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.ceF.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.ceF.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.cew);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.ceC != null && cardPersonDynamicThreadData.ceC.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.ceC.length; i++) {
                sb.append(cardPersonDynamicThreadData.ceC[i].text);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ccu);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(c));
        this.mTitle.setText(c);
        k.a(this.mTitle, cardPersonDynamicThreadData.threadData.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        return true;
    }
}
