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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.s;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class t extends a<CardPersonDynamicThreadData> {
    private boolean aAb;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private TbImageView.a bkM;
    private View.OnClickListener cKG;
    private AlaPlayAnimationView cMH;
    private CustomMessageListener cMI;
    private CardPersonDynamicThreadData cNQ;
    public PlayVoiceBntNew cNk;
    private TextView cNm;
    private ConstrainImageGroup cNn;
    private final View.OnClickListener cNq;
    private View cOA;
    private boolean cOB;
    private boolean cOC;
    com.baidu.tieba.view.h cOD;
    private s.a cOE;
    private final View.OnClickListener cOF;
    public ThreadViewAndCommentInfoLayout cOb;
    private final String cOc;
    private final String cOd;
    private TextView cOe;
    private LinearLayout cOf;
    private TextView cOg;
    private TextView cOh;
    private TextView cOi;
    private TextView cOj;
    private ImageView cOk;
    private s cOl;
    private View cOm;
    private TbImageView cOn;
    private ImageView cOo;
    private LinearLayout cOp;
    private TextView cOq;
    private LinearLayout cOr;
    private LinearLayout cOs;
    private TextView cOt;
    private TextView cOu;
    private TextView cOv;
    private TextView cOw;
    private TextView cOx;
    public OriginalThreadCardView cOy;
    private View cOz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cOc = "1";
        this.cOd = "2";
        this.mSkinType = 3;
        this.aAb = true;
        this.cOD = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cNQ != null && !StringUtils.isNull(t.this.cNQ.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cNQ.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.anP() != null) {
                    t.this.anP().a(view, t.this.cNQ);
                }
                if (t.this.cNQ.cQL != 60) {
                    if ((t.this.cNQ.cQL != 40 || t.this.cNQ.cQN != 2) && !t.this.cOC) {
                        t.this.aoj();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).AC();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cNQ.threadData.yP().live_status != 1) {
                    t.this.aon();
                } else {
                    t.this.aom();
                }
            }
        };
        this.cMI = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cNQ != null && t.this.cNQ.threadId != null && t.this.mTitle != null && t.this.cNm != null && ((String) customResponsedMessage.getData()).equals(t.this.cNQ.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cNQ.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cNm, t.this.cNQ.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cOE = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.fg(z);
            }
        };
        this.cOF = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> anP = t.this.anP();
                if (anP != null) {
                    view.setTag("1");
                    anP.a(view, t.this.cNQ);
                }
                t.this.aoj();
            }
        };
        this.cNq = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> anP = t.this.anP();
                if (anP != null) {
                    view.setTag("2");
                    anP.a(view, t.this.cNQ);
                }
            }
        };
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && t.this.cOn != null) {
                    t.this.cOn.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cOe = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cOf = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cOg = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cOh = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cOi = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cOx = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cOj = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cOk = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cNk = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cNk.setAfterClickListener(this.cNq);
        this.cNm = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cNm.setVisibility(8);
        this.cNn = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cNn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20));
        this.cNn.setChildClickListener(this.cOF);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cNn.setImageProcessor(eVar);
        this.cOm = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cOn = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cOo = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cOb = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cOs = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cOt = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cOu = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cOv = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cMH = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cOw = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cOp = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cOq = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cOr = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cOr.setVisibility(8);
        this.cOy = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cOz = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cOA = this.mRootView.findViewById(e.g.divider_line_thin);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setFrom(8);
        this.bWf.setDisPraiseFrom(3);
        this.bWf.setShareReportFrom(6);
        this.bWf.setStType("person_page");
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.anP() != null) {
                    t.this.anP().a(view, t.this.cNQ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cOe, e.d.cp_cont_b);
            al.h(this.cOg, e.d.cp_cont_j);
            al.h(this.cOh, e.d.cp_cont_b);
            al.h(this.cOi, e.d.cp_cont_d);
            al.h(this.cOx, e.d.cp_cont_d);
            al.h(this.cOj, e.d.cp_cont_d);
            if (this.cOk != null) {
                this.cOk.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cNm, e.d.cp_cont_f);
            al.h(this.cOq, e.d.cp_cont_f);
            if (this.cOl != null) {
                this.cOl.onChangeSkinType();
            }
            this.cOb.onChangeSkinType();
            this.bWf.onChangeSkinType();
            al.j(this.cOz, e.d.cp_bg_line_e);
            al.j(this.cOA, e.d.cp_bg_line_c);
            al.j(this.cOq, e.d.cp_bg_line_e);
            if (this.cOy != null) {
                this.cOy.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_person_dynamic_thread;
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
        this.cNQ = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        this.cOe.setVisibility(cardPersonDynamicThreadData.cQX ? 0 : 8);
        this.cOf.setVisibility(cardPersonDynamicThreadData.cQW ? 0 : 4);
        this.cOz.setVisibility(cardPersonDynamicThreadData.cQW ? 0 : 8);
        this.cOA.setVisibility(cardPersonDynamicThreadData.cQW ? 8 : 0);
        if (cardPersonDynamicThreadData.cQY) {
            this.cOz.setVisibility(8);
            this.cOA.setVisibility(8);
        }
        this.cOB = cardPersonDynamicThreadData.cQL == 40 && cardPersonDynamicThreadData.cQN == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cOC = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cQN == 2;
        }
        this.cOe.setText(cardPersonDynamicThreadData.cQO);
        this.cOg.setText(cardPersonDynamicThreadData.cQP);
        this.cOh.setText(cardPersonDynamicThreadData.cQQ);
        if (cardPersonDynamicThreadData.cQV != null && cardPersonDynamicThreadData.cQV.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cQV.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.cQV[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cQV.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cOi.setText(sb2);
                this.cOi.setVisibility(0);
            } else {
                this.cOi.setText(e.j.person_homepage);
            }
        } else {
            this.cOi.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cOj.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cOj.setVisibility(0);
            }
            fg(cardPersonDynamicThreadData.isPrivacy);
            this.cOk.setVisibility(0);
            this.cOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cOl == null) {
                            t.this.cOl = new s(t.this.mPageContext);
                            t.this.cOl.create();
                            t.this.cOl.a(t.this.cOE);
                        }
                        t.this.cOl.a(t.this.cNQ);
                        t.this.cOl.show();
                    }
                }
            });
        } else {
            this.cOj.setVisibility(8);
            this.cOk.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cQT;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cNk.setVisibility(0);
            ff(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cNk.setVoiceModel(voiceModel);
            this.cNk.setTag(voiceModel);
            this.cNk.aUR();
            if (voiceModel != null) {
                this.cNk.pJ(voiceModel.voice_status.intValue());
            }
            this.cNk.bDm();
        } else {
            this.cNk.setVisibility(8);
            ff(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cQS;
        al.i(this.cOp, e.d.transparent);
        this.cOq.setVisibility(8);
        this.cOr.setVisibility(8);
        this.cOp.setVisibility(0);
        this.cOm.setVisibility(8);
        this.cOw.setVisibility(8);
        this.cOs.setVisibility(8);
        this.cOv.setVisibility(8);
        this.cMH.bKt();
        if (cardPersonDynamicThreadData.cQL == 36) {
            this.cNn.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cQL == 40 || this.cNQ.cQL == 50) {
            this.cNn.setVisibility(8);
            if (com.baidu.tbadk.core.i.ws().ww()) {
                this.cOm.setVisibility(0);
                this.cOo.setVisibility(0);
                this.cOo.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOm.getLayoutParams();
                int width = this.cOm.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0175e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cOm.setLayoutParams(layoutParams);
                if (this.cNQ.videoInfo != null) {
                    this.cOn.setDefaultErrorResource(0);
                    this.cOn.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cOn.setEvent(this.bkM);
                    this.cOn.startLoad(this.cNQ.videoInfo.thumbnail_url, 17, false);
                    if (this.cOB) {
                        this.cOw.setVisibility(0);
                        this.cOw.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cOs.setVisibility(0);
                        this.cOt.setText(ao.dt(this.cNQ.videoInfo.video_duration.intValue() * 1000));
                        this.cOu.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.N(this.cNQ.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cNQ.cQL == 60 || this.cNQ.cQL == 49) {
            this.cNn.setVisibility(8);
            if (this.cNQ.threadData.yP() != null && this.cNQ.threadData.yP().user_info != null && this.cNQ.cQL == 60) {
                String str = this.cNQ.threadData.yP().user_info.user_name;
                if (com.baidu.tbadk.util.y.it(str) > 14) {
                    str = com.baidu.tbadk.util.y.J(str, 14) + "...";
                }
                this.cOq.setText(o.bh(str + ":", this.cNQ.threadData.getTitle()));
                this.cOq.setVisibility(0);
            } else {
                this.cOq.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.ws().ww()) {
                this.cOm.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOm.getLayoutParams();
                int width2 = this.cOm.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0175e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cOm.setLayoutParams(layoutParams2);
                if (this.cNQ.threadData.yP() != null) {
                    this.cOn.setDefaultErrorResource(0);
                    this.cOn.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cOn.setEvent(this.bkM);
                    this.cOn.startLoad(cardPersonDynamicThreadData.threadData.yP().cover, 10, false);
                    this.cOo.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cMH.startPlayAnimation();
                    al.i(this.cOp, e.d.cp_bg_line_e);
                    this.cOv.setVisibility(0);
                    this.cOv.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.N(this.cNQ.threadData.yP().audience_count)));
                    this.bWf.getCommentContainer().setOnClickListener(this.cKG);
                } else {
                    this.bWf.getCommentContainer().setOnClickListener(this.bWf);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.ws().ww() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.I(linkedList) > 0) {
                    this.cNn.setVisibility(0);
                    this.cNn.setFromCDN(this.aAb);
                    this.cNn.setSingleImageRatio(0.67d);
                    this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.aoj();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cNn.setImageMediaList(linkedList);
                } else {
                    this.cNn.setVisibility(8);
                }
            } else {
                this.cNn.setVisibility(8);
            }
            this.cOp.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.arg != null) {
            this.cOy.setVisibility(0);
            this.cOy.b(cardPersonDynamicThreadData.threadData.arg);
            this.cOy.setOnClickListener(this);
            this.cNk.setVisibility(8);
            this.cNn.setVisibility(8);
            this.cOp.setVisibility(8);
            if (this.cOC) {
                this.cOx.setVisibility(0);
            } else {
                this.cOx.setVisibility(8);
            }
        } else {
            this.cOy.setVisibility(8);
            this.cOx.setVisibility(8);
        }
        aoi();
        c(cardPersonDynamicThreadData);
    }

    private void ff(boolean z) {
        if (this.cNn != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNn.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20);
            }
            this.cNn.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cOB || this.cOC) {
                this.bWf.setCommentClickable(false);
                this.bWf.setAgreeClickable(false);
                this.bWf.setShareClickable(false);
                this.cOy.setClickable(false);
                this.cOk.setClickable(false);
            } else {
                this.bWf.setCommentClickable(true);
                this.bWf.setAgreeClickable(true);
                this.bWf.setShareClickable(true);
                this.cOy.setClickable(true);
                this.cOk.setClickable(true);
            }
            this.bWf.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cQL == 60) {
                this.bWf.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cQV != null) {
                this.bWf.setMultiForumCount(cardPersonDynamicThreadData.cQV.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.bWf.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.bWf.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aoi() {
        this.cNk.setClickable(true);
        int childCount = this.cNn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cNn.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aom() {
        if (this.cNQ != null && this.cNQ.threadData != null && this.cNQ.threadData.yP() != null) {
            if (!com.baidu.adp.lib.util.j.kX()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.md(this.cNQ.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cNQ.threadData.yP());
            if (this.cNQ.threadData.yP().user_info != null) {
                alaLiveInfoCoreData.userName = this.cNQ.threadData.yP().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aon() {
        if (this.cNQ != null && this.cNQ.threadData != null && this.cNQ.threadData.yP() != null && this.cNQ.threadData.yP().share_info != null) {
            if (!isHost()) {
                o.md(this.cNQ.threadId);
            }
            if (this.cNQ.threadData.yP().share_info.record_tid <= 0) {
                aom();
                return;
            }
            String valueOf = String.valueOf(this.cNQ.threadData.yP().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoj() {
        if (this.cNQ != null) {
            if (!isHost()) {
                o.md(this.cNQ.threadId);
                o.a(this.mTitle, this.cNQ.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cNm, this.cNQ.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cNQ.cQL == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cNQ.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cNQ.threadData.getFid()));
            pbActivityConfig.setForumName(this.cNQ.threadData.yB());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cNQ.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cNQ.threadData == null || !this.cNQ.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").ax("obj_type", "2").ax("tid", this.cNQ.threadId).x("obj_param1", this.cNQ.isHost ? 1 : 2));
        }
    }

    private void aoo() {
        if (this.cNQ != null && this.cNQ.threadData != null && this.cNQ.threadData.arg != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cNQ.threadData.arg.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").ax("obj_type", "3").ax("tid", this.cNQ.threadId).x("obj_param1", this.cNQ.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(boolean z) {
        if (this.cOj != null) {
            if (z) {
                this.cOj.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cOj.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cOj.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cOj.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cNQ.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cOy) {
            aoo();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aAb ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yB(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAb, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cOB);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(c));
        this.mTitle.setText(c);
        if (isHost()) {
            return true;
        }
        o.a(this.mTitle, cardPersonDynamicThreadData.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
        return true;
    }
}
