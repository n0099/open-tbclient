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
    private boolean aXs;
    private View.OnClickListener cSt;
    private TbImageView.a cTK;
    public PlayVoiceBntNew cTY;
    private AlaPlayAnimationView cTo;
    private CustomMessageListener cTp;
    private CardPersonDynamicThreadData cUN;
    public ThreadViewAndCommentInfoLayout cUY;
    private final String cUZ;
    private TextView cUa;
    private ConstrainImageGroup cUb;
    private final View.OnClickListener cUe;
    private boolean cVA;
    com.baidu.tieba.view.j cVB;
    private p.a cVC;
    private final View.OnClickListener cVD;
    private final String cVa;
    private TextView cVb;
    private LinearLayout cVc;
    private TextView cVd;
    private TextView cVe;
    private TextView cVf;
    private TextView cVg;
    private ImageView cVh;
    private p cVi;
    private PhotoLiveCoverView cVj;
    private View cVk;
    private TbImageView cVl;
    private ImageView cVm;
    private LinearLayout cVn;
    private TextView cVo;
    private LinearLayout cVp;
    private LinearLayout cVq;
    private TextView cVr;
    private TextView cVs;
    private TextView cVt;
    private TextView cVu;
    private TextView cVv;
    public OriginalThreadCardView cVw;
    private View cVx;
    private View cVy;
    private boolean cVz;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cUZ = "1";
        this.cVa = "2";
        this.mSkinType = 3;
        this.aXs = true;
        this.cVB = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.cUN != null && !StringUtils.isNull(q.this.cUN.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.cUN.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.j
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(d.C0107d.cp_link_tip_c) : q.this.mContext.getResources().getColor(d.C0107d.cp_link_tip_a));
            }
        };
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.akb() != null) {
                    q.this.akb().a(view, q.this.cUN);
                }
                if (q.this.cUN.cXB != 33) {
                    if (q.this.cUN.cXB != 60) {
                        if ((q.this.cUN.cXB != 40 || q.this.cUN.cXE != 2) && !q.this.cVA) {
                            q.this.akv();
                            return;
                        } else {
                            BdToast.b(q.this.getContext(), q.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).AI();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (q.this.cUN.threadData.zl().live_status != 1) {
                        q.this.akD();
                        return;
                    } else {
                        q.this.akC();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                q.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(q.this.mPageContext.getPageActivity(), q.this.cUN.threadId).cG(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).eC(23014).wP()));
            }
        };
        this.cTp = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.cUN != null && q.this.cUN.threadId != null && q.this.mTitle != null && q.this.cUa != null && ((String) customResponsedMessage.getData()).equals(q.this.cUN.threadId) && !q.this.isHost()) {
                    k.a(q.this.mTitle, q.this.cUN.threadId, d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                    k.a(q.this.cUa, q.this.cUN.threadId, d.C0107d.cp_cont_j, d.C0107d.cp_cont_d);
                }
            }
        };
        this.cVC = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.eE(z);
            }
        };
        this.cVD = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akb = q.this.akb();
                if (akb != null) {
                    view.setTag("1");
                    akb.a(view, q.this.cUN);
                }
                q.this.akv();
            }
        };
        this.cUe = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> akb = q.this.akb();
                if (akb != null) {
                    view.setTag("2");
                    akb.a(view, q.this.cUN);
                }
            }
        };
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && q.this.cVl != null) {
                    q.this.cVl.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cVb = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cVc = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cVd = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cVe = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cVf = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cVv = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cVg = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cVh = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cTY = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cTY.setAfterClickListener(this.cUe);
        this.cUa = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cUa.setVisibility(8);
        this.cUb = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cUb.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cUb.setChildClickListener(this.cVD);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUb.setImageProcessor(fVar);
        this.cVk = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cVl = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cVm = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cVj = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cUY = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cVq = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cVr = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cVs = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cVt = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cTo = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cVu = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cVn = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cVo = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cVp = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cVp.setVisibility(8);
        this.cVw = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cVx = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cVy = this.mRootView.findViewById(d.g.divider_line_thin);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setFrom(1);
        this.ciL.setShareReportFrom(6);
        this.ciL.setStType("person_page");
        this.ciL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.akb() != null) {
                    q.this.akb().a(view, q.this.cUN);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.cVb, d.C0107d.cp_cont_b);
            aj.r(this.cVd, d.C0107d.cp_cont_j);
            aj.r(this.cVe, d.C0107d.cp_cont_b);
            aj.r(this.cVf, d.C0107d.cp_cont_d);
            aj.r(this.cVv, d.C0107d.cp_cont_d);
            aj.r(this.cVg, d.C0107d.cp_cont_d);
            if (this.cVh != null) {
                this.cVh.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.r(this.mTitle, d.C0107d.cp_cont_b);
            aj.r(this.cUa, d.C0107d.cp_cont_f);
            aj.r(this.cVo, d.C0107d.cp_cont_f);
            if (this.cVi != null) {
                this.cVi.onChangeSkinType();
            }
            this.cUY.onChangeSkinType();
            this.ciL.onChangeSkinType();
            aj.t(this.cVx, d.C0107d.cp_bg_line_e);
            aj.t(this.cVy, d.C0107d.cp_bg_line_c);
            aj.t(this.cVo, d.C0107d.cp_bg_line_e);
            if (this.cVw != null) {
                this.cVw.onChangeSkinType();
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
        this.cUN = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.cVb.setVisibility(cardPersonDynamicThreadData.cXP ? 0 : 8);
        this.cVc.setVisibility(cardPersonDynamicThreadData.cXO ? 0 : 4);
        this.cVx.setVisibility(cardPersonDynamicThreadData.cXO ? 0 : 8);
        this.cVy.setVisibility(cardPersonDynamicThreadData.cXO ? 8 : 0);
        if (cardPersonDynamicThreadData.cXQ) {
            this.cVx.setVisibility(8);
            this.cVy.setVisibility(8);
        }
        this.cVz = cardPersonDynamicThreadData.cXB == 40 && cardPersonDynamicThreadData.cXE == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cVA = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cXE == 2;
        }
        this.cVb.setText(cardPersonDynamicThreadData.cXF);
        this.cVd.setText(cardPersonDynamicThreadData.cXG);
        this.cVe.setText(cardPersonDynamicThreadData.cXH);
        if (cardPersonDynamicThreadData.cXN != null && cardPersonDynamicThreadData.cXN.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cXN.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.cXN[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cXN.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cVf.setText(sb2);
                this.cVf.setVisibility(0);
            } else {
                this.cVf.setText(d.j.person_homepage);
            }
        } else {
            this.cVf.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cVg.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cVg.setVisibility(0);
            }
            eE(cardPersonDynamicThreadData.isPrivacy);
            this.cVh.setVisibility(0);
            this.cVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.cVi == null) {
                            q.this.cVi = new p(q.this.mPageContext);
                            q.this.cVi.create();
                            q.this.cVi.a(q.this.cVC);
                        }
                        q.this.cVi.a(q.this.cUN);
                        q.this.cVi.show();
                    }
                }
            });
        } else {
            this.cVg.setVisibility(8);
            this.cVh.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cXK;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cTY.setVisibility(0);
            eD(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cTY.setVoiceModel(voiceModel);
            this.cTY.setTag(voiceModel);
            this.cTY.bnf();
            if (voiceModel != null) {
                this.cTY.qE(voiceModel.voice_status.intValue());
            }
            this.cTY.bwP();
        } else {
            this.cTY.setVisibility(8);
            eD(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cXJ;
        aj.s(this.cVn, d.C0107d.transparent);
        this.cVo.setVisibility(8);
        this.cVp.setVisibility(8);
        this.cVn.setVisibility(0);
        this.cVj.setVisibility(8);
        this.cVk.setVisibility(8);
        this.cVu.setVisibility(8);
        this.cVq.setVisibility(8);
        this.cVt.setVisibility(8);
        this.cTo.bDR();
        if (cardPersonDynamicThreadData.cXB == 36) {
            this.cUb.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cXB == 33) {
            this.cUb.setVisibility(8);
            if (com.baidu.tbadk.core.i.wA().wG() && cardPersonDynamicThreadData.cXL != null && !StringUtils.isNull(cardPersonDynamicThreadData.cXL.livecover_src)) {
                this.cVj.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.cXL)) {
                    this.cVj.setShowExpression(false);
                } else {
                    this.cVj.setShowExpression(true);
                }
                this.cVj.setShowImage(com.baidu.tbadk.core.i.wA().wG());
                this.cVj.setChooseStyle(d.getShowStyle());
                this.cVj.setData(d);
            }
        } else if (cardPersonDynamicThreadData.cXB == 40 || this.cUN.cXB == 50) {
            this.cUb.setVisibility(8);
            if (com.baidu.tbadk.core.i.wA().wG()) {
                this.cVk.setVisibility(0);
                this.cVm.setVisibility(0);
                this.cVm.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVk.getLayoutParams();
                int width = this.cVk.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cVk.setLayoutParams(layoutParams);
                if (this.cUN.videoInfo != null) {
                    this.cVl.setDefaultErrorResource(0);
                    this.cVl.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cVl.setEvent(this.cTK);
                    this.cVl.startLoad(this.cUN.videoInfo.thumbnail_url, 17, false);
                    if (this.cVz) {
                        this.cVu.setVisibility(0);
                        this.cVu.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cVq.setVisibility(0);
                        this.cVr.setText(am.fV(this.cUN.videoInfo.video_duration.intValue() * 1000));
                        this.cVs.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.J(this.cUN.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cUN.cXB == 60 || this.cUN.cXB == 49) {
            this.cUb.setVisibility(8);
            if (this.cUN.threadData.zl() != null && this.cUN.threadData.zl().user_info != null && this.cUN.cXB == 60) {
                String str = this.cUN.threadData.zl().user_info.user_name;
                if (com.baidu.tbadk.util.w.hc(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cVo.setText(k.aG(str + ":", this.cUN.threadData.getTitle()));
                this.cVo.setVisibility(0);
            } else {
                this.cVo.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.wA().wG()) {
                this.cVk.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVk.getLayoutParams();
                int width2 = this.cVk.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cVk.setLayoutParams(layoutParams2);
                if (this.cUN.threadData.zl() != null) {
                    this.cVl.setDefaultErrorResource(0);
                    this.cVl.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cVl.setEvent(this.cTK);
                    this.cVl.startLoad(cardPersonDynamicThreadData.threadData.zl().cover, 10, false);
                    this.cVm.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cTo.startPlayAnimation();
                    aj.s(this.cVn, d.C0107d.cp_bg_line_e);
                    this.cVt.setVisibility(0);
                    this.cVt.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cUN.threadData.zl().audience_count)));
                    this.ciL.getCommentContainer().setOnClickListener(this.cSt);
                } else {
                    this.ciL.getCommentContainer().setOnClickListener(this.ciL);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.wA().wG() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cUb.setVisibility(0);
                    this.cUb.setFromCDN(this.aXs);
                    this.cUb.setSingleImageRatio(0.67d);
                    this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z) {
                            if (z) {
                                q.this.akv();
                            } else {
                                q.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cUb.setImageMediaList(linkedList);
                } else {
                    this.cUb.setVisibility(8);
                }
            } else {
                this.cUb.setVisibility(8);
            }
            this.cVn.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aOZ != null) {
            this.cVw.setVisibility(0);
            this.cVw.b(cardPersonDynamicThreadData.threadData.aOZ);
            this.cVw.setOnClickListener(this);
            this.cTY.setVisibility(8);
            this.cUb.setVisibility(8);
            this.cVn.setVisibility(8);
            if (this.cVA) {
                this.cVv.setVisibility(0);
            } else {
                this.cVv.setVisibility(8);
            }
        } else {
            this.cVw.setVisibility(8);
            this.cVv.setVisibility(8);
        }
        aku();
        c(cardPersonDynamicThreadData);
    }

    private void eD(boolean z) {
        if (this.cUb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUb.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cUb.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cVz || this.cVA) {
                this.ciL.setCommentClickable(false);
                this.ciL.setAgreeClickable(false);
                this.ciL.setShareClickable(false);
                this.cVw.setClickable(false);
                this.cVh.setClickable(false);
            } else {
                this.ciL.setCommentClickable(true);
                this.ciL.setAgreeClickable(true);
                this.ciL.setShareClickable(true);
                this.cVw.setClickable(true);
                this.cVh.setClickable(true);
            }
            this.ciL.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cXB == 60) {
                this.ciL.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cXN != null) {
                this.ciL.setMultiForumCount(cardPersonDynamicThreadData.cXN.length);
            }
            this.ciL.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aku() {
        this.cTY.setClickable(true);
        int childCount = this.cUb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUb.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void akC() {
        if (this.cUN != null && this.cUN.threadData != null && this.cUN.threadData.zl() != null) {
            if (!com.baidu.adp.lib.util.j.oI()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                k.kc(this.cUN.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cUN.threadData.zl());
            if (this.cUN.threadData.zl().user_info != null) {
                alaLiveInfoCoreData.userName = this.cUN.threadData.zl().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akD() {
        if (this.cUN != null && this.cUN.threadData != null && this.cUN.threadData.zl() != null && this.cUN.threadData.zl().share_info != null) {
            if (!isHost()) {
                k.kc(this.cUN.threadId);
            }
            if (this.cUN.threadData.zl().share_info.record_tid <= 0) {
                akC();
                return;
            }
            String valueOf = String.valueOf(this.cUN.threadData.zl().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.cUN != null) {
            if (!isHost()) {
                k.kc(this.cUN.threadId);
                k.a(this.mTitle, this.cUN.threadId, d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                k.a(this.cUa, this.cUN.threadId, d.C0107d.cp_cont_j, d.C0107d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cUN.cXB == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cUN.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cUN.threadData.getFid()));
            pbActivityConfig.setForumName(this.cUN.threadData.yY());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cUN.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    private void akE() {
        if (this.cUN != null && this.cUN.threadData != null && this.cUN.threadData.aOZ != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cUN.threadData.aOZ.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(boolean z) {
        if (this.cVg != null) {
            if (z) {
                this.cVg.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cVg.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cVg.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cVg.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cUN.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cVw) {
            akE();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUb != null) {
            this.cUb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUb != null) {
            this.cUb.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aXs ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yY(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXs, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (cardPersonDynamicThreadData.cXL != null) {
            if (cardPersonDynamicThreadData.cXL.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.cXL.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.cXL.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.cXL.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.cXL.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.cXL.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.cXL.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.cXL.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.cXL.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.cXL.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.cXC);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.cXI != null && cardPersonDynamicThreadData.cXI.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cXI.length; i++) {
                sb.append(cardPersonDynamicThreadData.cXI[i].text);
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
                eVar.fu(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean e(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.threadData.d(false, true, this.cVz);
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
        k.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        return true;
    }
}
