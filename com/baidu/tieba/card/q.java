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
    private boolean aXA;
    private View.OnClickListener cSO;
    private AlaPlayAnimationView cTJ;
    private CustomMessageListener cTK;
    private TbImageView.a cUf;
    public PlayVoiceBntNew cUt;
    private TextView cUv;
    private ConstrainImageGroup cUw;
    private final View.OnClickListener cUz;
    private TextView cVA;
    private TextView cVB;
    private ImageView cVC;
    private p cVD;
    private PhotoLiveCoverView cVE;
    private View cVF;
    private TbImageView cVG;
    private ImageView cVH;
    private LinearLayout cVI;
    private TextView cVJ;
    private LinearLayout cVK;
    private LinearLayout cVL;
    private TextView cVM;
    private TextView cVN;
    private TextView cVO;
    private TextView cVP;
    private TextView cVQ;
    public OriginalThreadCardView cVR;
    private View cVS;
    private View cVT;
    private boolean cVU;
    private boolean cVV;
    com.baidu.tieba.view.j cVW;
    private p.a cVX;
    private final View.OnClickListener cVY;
    private CardPersonDynamicThreadData cVi;
    public ThreadViewAndCommentInfoLayout cVt;
    private final String cVu;
    private final String cVv;
    private TextView cVw;
    private LinearLayout cVx;
    private TextView cVy;
    private TextView cVz;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVu = "1";
        this.cVv = "2";
        this.mSkinType = 3;
        this.aXA = true;
        this.cVW = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.cVi != null && !StringUtils.isNull(q.this.cVi.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.cVi.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.j
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(d.C0108d.cp_link_tip_c) : q.this.mContext.getResources().getColor(d.C0108d.cp_link_tip_a));
            }
        };
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.akg() != null) {
                    q.this.akg().a(view, q.this.cVi);
                }
                if (q.this.cVi.cXW != 33) {
                    if (q.this.cVi.cXW != 60) {
                        if ((q.this.cVi.cXW != 40 || q.this.cVi.cXZ != 2) && !q.this.cVV) {
                            q.this.akA();
                            return;
                        } else {
                            BdToast.b(q.this.getContext(), q.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).AJ();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (q.this.cVi.threadData.zm().live_status != 1) {
                        q.this.akI();
                        return;
                    } else {
                        q.this.akH();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                q.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(q.this.mPageContext.getPageActivity(), q.this.cVi.threadId).cG(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).eC(23014).wQ()));
            }
        };
        this.cTK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.cVi != null && q.this.cVi.threadId != null && q.this.mTitle != null && q.this.cUv != null && ((String) customResponsedMessage.getData()).equals(q.this.cVi.threadId) && !q.this.isHost()) {
                    k.a(q.this.mTitle, q.this.cVi.threadId, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                    k.a(q.this.cUv, q.this.cVi.threadId, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
                }
            }
        };
        this.cVX = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.eH(z);
            }
        };
        this.cVY = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akg = q.this.akg();
                if (akg != null) {
                    view.setTag("1");
                    akg.a(view, q.this.cVi);
                }
                q.this.akA();
            }
        };
        this.cUz = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akg = q.this.akg();
                if (akg != null) {
                    view.setTag("2");
                    akg.a(view, q.this.cVi);
                }
            }
        };
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && q.this.cVG != null) {
                    q.this.cVG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cVw = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cVx = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cVy = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cVz = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cVA = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cVQ = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cVB = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cVC = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cUt = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cUt.setAfterClickListener(this.cUz);
        this.cUv = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cUv.setVisibility(8);
        this.cUw = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cUw.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cUw.setChildClickListener(this.cVY);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUw.setImageProcessor(fVar);
        this.cVF = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cVG = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cVH = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cVE = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cVt = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cVL = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cVM = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cVN = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cVO = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cTJ = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cVP = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cVI = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cVJ = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cVK = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cVK.setVisibility(8);
        this.cVR = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cVS = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cVT = this.mRootView.findViewById(d.g.divider_line_thin);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setFrom(1);
        this.ciT.setShareReportFrom(6);
        this.ciT.setStType("person_page");
        this.ciT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.akg() != null) {
                    q.this.akg().a(view, q.this.cVi);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.cVw, d.C0108d.cp_cont_b);
            aj.r(this.cVy, d.C0108d.cp_cont_j);
            aj.r(this.cVz, d.C0108d.cp_cont_b);
            aj.r(this.cVA, d.C0108d.cp_cont_d);
            aj.r(this.cVQ, d.C0108d.cp_cont_d);
            aj.r(this.cVB, d.C0108d.cp_cont_d);
            if (this.cVC != null) {
                this.cVC.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.r(this.mTitle, d.C0108d.cp_cont_b);
            aj.r(this.cUv, d.C0108d.cp_cont_f);
            aj.r(this.cVJ, d.C0108d.cp_cont_f);
            if (this.cVD != null) {
                this.cVD.onChangeSkinType();
            }
            this.cVt.onChangeSkinType();
            this.ciT.onChangeSkinType();
            aj.t(this.cVS, d.C0108d.cp_bg_line_e);
            aj.t(this.cVT, d.C0108d.cp_bg_line_c);
            aj.t(this.cVJ, d.C0108d.cp_bg_line_e);
            if (this.cVR != null) {
                this.cVR.onChangeSkinType();
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
        this.cVi = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        this.cVw.setVisibility(cardPersonDynamicThreadData.cYk ? 0 : 8);
        this.cVx.setVisibility(cardPersonDynamicThreadData.cYj ? 0 : 4);
        this.cVS.setVisibility(cardPersonDynamicThreadData.cYj ? 0 : 8);
        this.cVT.setVisibility(cardPersonDynamicThreadData.cYj ? 8 : 0);
        if (cardPersonDynamicThreadData.cYl) {
            this.cVS.setVisibility(8);
            this.cVT.setVisibility(8);
        }
        this.cVU = cardPersonDynamicThreadData.cXW == 40 && cardPersonDynamicThreadData.cXZ == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cVV = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cXZ == 2;
        }
        this.cVw.setText(cardPersonDynamicThreadData.cYa);
        this.cVy.setText(cardPersonDynamicThreadData.cYb);
        this.cVz.setText(cardPersonDynamicThreadData.cYc);
        if (cardPersonDynamicThreadData.cYi != null && cardPersonDynamicThreadData.cYi.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cYi.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.cYi[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cYi.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cVA.setText(sb2);
                this.cVA.setVisibility(0);
            } else {
                this.cVA.setText(d.j.person_homepage);
            }
        } else {
            this.cVA.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cVB.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cVB.setVisibility(0);
            }
            eH(cardPersonDynamicThreadData.isPrivacy);
            this.cVC.setVisibility(0);
            this.cVC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.cVD == null) {
                            q.this.cVD = new p(q.this.mPageContext);
                            q.this.cVD.create();
                            q.this.cVD.a(q.this.cVX);
                        }
                        q.this.cVD.a(q.this.cVi);
                        q.this.cVD.show();
                    }
                }
            });
        } else {
            this.cVB.setVisibility(8);
            this.cVC.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cYf;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cUt.setVisibility(0);
            eG(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cUt.setVoiceModel(voiceModel);
            this.cUt.setTag(voiceModel);
            this.cUt.bng();
            if (voiceModel != null) {
                this.cUt.qE(voiceModel.voice_status.intValue());
            }
            this.cUt.bwR();
        } else {
            this.cUt.setVisibility(8);
            eG(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cYe;
        aj.s(this.cVI, d.C0108d.transparent);
        this.cVJ.setVisibility(8);
        this.cVK.setVisibility(8);
        this.cVI.setVisibility(0);
        this.cVE.setVisibility(8);
        this.cVF.setVisibility(8);
        this.cVP.setVisibility(8);
        this.cVL.setVisibility(8);
        this.cVO.setVisibility(8);
        this.cTJ.bDT();
        if (cardPersonDynamicThreadData.cXW == 36) {
            this.cUw.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cXW == 33) {
            this.cUw.setVisibility(8);
            if (com.baidu.tbadk.core.i.wB().wH() && cardPersonDynamicThreadData.cYg != null && !StringUtils.isNull(cardPersonDynamicThreadData.cYg.livecover_src)) {
                this.cVE.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.cYg)) {
                    this.cVE.setShowExpression(false);
                } else {
                    this.cVE.setShowExpression(true);
                }
                this.cVE.setShowImage(com.baidu.tbadk.core.i.wB().wH());
                this.cVE.setChooseStyle(d.getShowStyle());
                this.cVE.setData(d);
            }
        } else if (cardPersonDynamicThreadData.cXW == 40 || this.cVi.cXW == 50) {
            this.cUw.setVisibility(8);
            if (com.baidu.tbadk.core.i.wB().wH()) {
                this.cVF.setVisibility(0);
                this.cVH.setVisibility(0);
                this.cVH.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVF.getLayoutParams();
                int width = this.cVF.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cVF.setLayoutParams(layoutParams);
                if (this.cVi.videoInfo != null) {
                    this.cVG.setDefaultErrorResource(0);
                    this.cVG.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cVG.setEvent(this.cUf);
                    this.cVG.startLoad(this.cVi.videoInfo.thumbnail_url, 17, false);
                    if (this.cVU) {
                        this.cVP.setVisibility(0);
                        this.cVP.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cVL.setVisibility(0);
                        this.cVM.setText(am.fV(this.cVi.videoInfo.video_duration.intValue() * 1000));
                        this.cVN.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.J(this.cVi.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cVi.cXW == 60 || this.cVi.cXW == 49) {
            this.cUw.setVisibility(8);
            if (this.cVi.threadData.zm() != null && this.cVi.threadData.zm().user_info != null && this.cVi.cXW == 60) {
                String str = this.cVi.threadData.zm().user_info.user_name;
                if (com.baidu.tbadk.util.w.hk(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cVJ.setText(k.aF(str + ":", this.cVi.threadData.getTitle()));
                this.cVJ.setVisibility(0);
            } else {
                this.cVJ.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.wB().wH()) {
                this.cVF.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVF.getLayoutParams();
                int width2 = this.cVF.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cVF.setLayoutParams(layoutParams2);
                if (this.cVi.threadData.zm() != null) {
                    this.cVG.setDefaultErrorResource(0);
                    this.cVG.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cVG.setEvent(this.cUf);
                    this.cVG.startLoad(cardPersonDynamicThreadData.threadData.zm().cover, 10, false);
                    this.cVH.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cTJ.startPlayAnimation();
                    aj.s(this.cVI, d.C0108d.cp_bg_line_e);
                    this.cVO.setVisibility(0);
                    this.cVO.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cVi.threadData.zm().audience_count)));
                    this.ciT.getCommentContainer().setOnClickListener(this.cSO);
                } else {
                    this.ciT.getCommentContainer().setOnClickListener(this.ciT);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.wB().wH() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cUw.setVisibility(0);
                    this.cUw.setFromCDN(this.aXA);
                    this.cUw.setSingleImageRatio(0.67d);
                    this.cUw.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z) {
                            if (z) {
                                q.this.akA();
                            } else {
                                q.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cUw.setImageMediaList(linkedList);
                } else {
                    this.cUw.setVisibility(8);
                }
            } else {
                this.cUw.setVisibility(8);
            }
            this.cVI.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aPc != null) {
            this.cVR.setVisibility(0);
            this.cVR.b(cardPersonDynamicThreadData.threadData.aPc);
            this.cVR.setOnClickListener(this);
            this.cUt.setVisibility(8);
            this.cUw.setVisibility(8);
            this.cVI.setVisibility(8);
            if (this.cVV) {
                this.cVQ.setVisibility(0);
            } else {
                this.cVQ.setVisibility(8);
            }
        } else {
            this.cVR.setVisibility(8);
            this.cVQ.setVisibility(8);
        }
        akz();
        c(cardPersonDynamicThreadData);
    }

    private void eG(boolean z) {
        if (this.cUw != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUw.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cUw.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cVU || this.cVV) {
                this.ciT.setCommentClickable(false);
                this.ciT.setAgreeClickable(false);
                this.ciT.setShareClickable(false);
                this.cVR.setClickable(false);
                this.cVC.setClickable(false);
            } else {
                this.ciT.setCommentClickable(true);
                this.ciT.setAgreeClickable(true);
                this.ciT.setShareClickable(true);
                this.cVR.setClickable(true);
                this.cVC.setClickable(true);
            }
            this.ciT.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cXW == 60) {
                this.ciT.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cYi != null) {
                this.ciT.setMultiForumCount(cardPersonDynamicThreadData.cYi.length);
            }
            this.ciT.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void akz() {
        this.cUt.setClickable(true);
        int childCount = this.cUw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUw.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void akH() {
        if (this.cVi != null && this.cVi.threadData != null && this.cVi.threadData.zm() != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                k.kk(this.cVi.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cVi.threadData.zm());
            if (this.cVi.threadData.zm().user_info != null) {
                alaLiveInfoCoreData.userName = this.cVi.threadData.zm().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        if (this.cVi != null && this.cVi.threadData != null && this.cVi.threadData.zm() != null && this.cVi.threadData.zm().share_info != null) {
            if (!isHost()) {
                k.kk(this.cVi.threadId);
            }
            if (this.cVi.threadData.zm().share_info.record_tid <= 0) {
                akH();
                return;
            }
            String valueOf = String.valueOf(this.cVi.threadData.zm().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.cVi != null) {
            if (!isHost()) {
                k.kk(this.cVi.threadId);
                k.a(this.mTitle, this.cVi.threadId, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                k.a(this.cUv, this.cVi.threadId, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cVi.cXW == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cVi.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cVi.threadData.getFid()));
            pbActivityConfig.setForumName(this.cVi.threadData.yZ());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cVi.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    private void akJ() {
        if (this.cVi != null && this.cVi.threadData != null && this.cVi.threadData.aPc != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cVi.threadData.aPc.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        if (this.cVB != null) {
            if (z) {
                this.cVB.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cVB.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cVB.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cVB.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cVi.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cVR) {
            akJ();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUw != null) {
            this.cUw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUw != null) {
            this.cUw.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aXA ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yZ(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXA, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (cardPersonDynamicThreadData.cYg != null) {
            if (cardPersonDynamicThreadData.cYg.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.cYg.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.cYg.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.cYg.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.cYg.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.cYg.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.cYg.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.cYg.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.cYg.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.cYg.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.cXX);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.cYd != null && cardPersonDynamicThreadData.cYd.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cYd.length; i++) {
                sb.append(cardPersonDynamicThreadData.cYd[i].text);
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
                eVar.hp(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.fC(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean e(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.threadData.d(false, true, this.cVU);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        k.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        return true;
    }
}
