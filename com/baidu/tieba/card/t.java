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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class t extends a<CardPersonDynamicThreadData> {
    private boolean akC;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private View.OnClickListener cme;
    private TbImageView.a coG;
    public PlayVoiceBntNew coU;
    private TextView coW;
    private ConstrainImageGroup coX;
    private AlaPlayAnimationView coj;
    private CustomMessageListener cok;
    private CardPersonDynamicThreadData cpC;
    public ThreadViewAndCommentInfoLayout cpN;
    private final String cpO;
    private final String cpP;
    private TextView cpQ;
    private LinearLayout cpR;
    private TextView cpS;
    private TextView cpT;
    private TextView cpU;
    private TextView cpV;
    private ImageView cpW;
    private s cpX;
    private View cpY;
    private TbImageView cpZ;
    private final View.OnClickListener cpa;
    private ImageView cqa;
    private LinearLayout cqb;
    private TextView cqc;
    private LinearLayout cqd;
    private LinearLayout cqe;
    private TextView cqf;
    private TextView cqg;
    private TextView cqh;
    private TextView cqi;
    private TextView cqj;
    public OriginalThreadCardView cqk;
    private View cql;
    private View cqm;
    private boolean cqn;
    private boolean cqo;
    com.baidu.tieba.view.h cqp;
    private s.a cqq;
    private final View.OnClickListener cqr;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cpO = "1";
        this.cpP = "2";
        this.mSkinType = 3;
        this.akC = true;
        this.cqp = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                if (t.this.cpC != null && !StringUtils.isNull(t.this.cpC.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cpC.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(d.C0126d.cp_link_tip_c) : t.this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            }
        };
        this.cme = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.aeZ() != null) {
                    t.this.aeZ().a(view2, t.this.cpC);
                }
                if (t.this.cpC.csu != 60) {
                    if ((t.this.cpC.csu != 40 || t.this.cpC.csw != 2) && !t.this.cqo) {
                        t.this.afs();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(d.k.video_check_click_msg), d.f.icon_toast_game_error).tL();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cpC.threadData.si().live_status != 1) {
                    t.this.afw();
                } else {
                    t.this.afv();
                }
            }
        };
        this.cok = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cpC != null && t.this.cpC.threadId != null && t.this.mTitle != null && t.this.coW != null && ((String) customResponsedMessage.getData()).equals(t.this.cpC.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cpC.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                    o.a(t.this.coW, t.this.cpC.threadId, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                }
            }
        };
        this.cqq = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.es(z);
            }
        };
        this.cqr = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<CardPersonDynamicThreadData> aeZ = t.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("1");
                    aeZ.a(view2, t.this.cpC);
                }
                t.this.afs();
            }
        };
        this.cpa = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<CardPersonDynamicThreadData> aeZ = t.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, t.this.cpC);
                }
            }
        };
        this.coG = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && t.this.cpZ != null) {
                    t.this.cpZ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cpQ = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cpR = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cpS = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cpT = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cpU = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cqj = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cpV = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cpW = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.coU = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.coU.setAfterClickListener(this.cpa);
        this.coW = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.coW.setVisibility(8);
        this.coX = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.coX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.coX.setChildClickListener(this.cqr);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coX.setImageProcessor(eVar);
        this.cpY = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cpZ = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cqa = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cpN = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cqe = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cqf = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cqg = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cqh = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.coj = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cqi = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cqb = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cqc = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cqd = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cqd.setVisibility(8);
        this.cqk = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cql = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cqm = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cme);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setFrom(8);
        this.bwk.setShareReportFrom(6);
        this.bwk.setStType("person_page");
        this.bwk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.aeZ() != null) {
                    t.this.aeZ().a(view2, t.this.cpC);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.cpQ, d.C0126d.cp_cont_b);
            ak.h(this.cpS, d.C0126d.cp_cont_j);
            ak.h(this.cpT, d.C0126d.cp_cont_b);
            ak.h(this.cpU, d.C0126d.cp_cont_d);
            ak.h(this.cqj, d.C0126d.cp_cont_d);
            ak.h(this.cpV, d.C0126d.cp_cont_d);
            if (this.cpW != null) {
                this.cpW.setImageDrawable(ak.getDrawable(d.f.icon_card_more));
            }
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.h(this.coW, d.C0126d.cp_cont_f);
            ak.h(this.cqc, d.C0126d.cp_cont_f);
            if (this.cpX != null) {
                this.cpX.onChangeSkinType();
            }
            this.cpN.onChangeSkinType();
            this.bwk.onChangeSkinType();
            ak.j(this.cql, d.C0126d.cp_bg_line_e);
            ak.j(this.cqm, d.C0126d.cp_bg_line_c);
            ak.j(this.cqc, d.C0126d.cp_bg_line_e);
            if (this.cqk != null) {
                this.cqk.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_person_dynamic_thread;
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
        this.cpC = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cme);
        }
        this.cpQ.setVisibility(cardPersonDynamicThreadData.csG ? 0 : 8);
        this.cpR.setVisibility(cardPersonDynamicThreadData.csF ? 0 : 4);
        this.cql.setVisibility(cardPersonDynamicThreadData.csF ? 0 : 8);
        this.cqm.setVisibility(cardPersonDynamicThreadData.csF ? 8 : 0);
        if (cardPersonDynamicThreadData.csH) {
            this.cql.setVisibility(8);
            this.cqm.setVisibility(8);
        }
        this.cqn = cardPersonDynamicThreadData.csu == 40 && cardPersonDynamicThreadData.csw == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cqo = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.csw == 2;
        }
        this.cpQ.setText(cardPersonDynamicThreadData.csx);
        this.cpS.setText(cardPersonDynamicThreadData.csy);
        this.cpT.setText(cardPersonDynamicThreadData.csz);
        if (cardPersonDynamicThreadData.csE != null && cardPersonDynamicThreadData.csE.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.csE.length; i++) {
                sb.append(an.e(cardPersonDynamicThreadData.csE[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.csE.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.k.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.k.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cpU.setText(sb2);
                this.cpU.setVisibility(0);
            } else {
                this.cpU.setText(d.k.person_homepage);
            }
        } else {
            this.cpU.setText(d.k.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cpV.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cpV.setVisibility(0);
            }
            es(cardPersonDynamicThreadData.isPrivacy);
            this.cpW.setVisibility(0);
            this.cpW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cpX == null) {
                            t.this.cpX = new s(t.this.mPageContext);
                            t.this.cpX.create();
                            t.this.cpX.a(t.this.cqq);
                        }
                        t.this.cpX.a(t.this.cpC);
                        t.this.cpX.show();
                    }
                }
            });
        } else {
            this.cpV.setVisibility(8);
            this.cpW.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.csC;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.coU.setVisibility(0);
            er(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.coU.setVoiceModel(voiceModel);
            this.coU.setTag(voiceModel);
            this.coU.aIT();
            if (voiceModel != null) {
                this.coU.oc(voiceModel.voice_status.intValue());
            }
            this.coU.btf();
        } else {
            this.coU.setVisibility(8);
            er(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.csB;
        ak.i(this.cqb, d.C0126d.transparent);
        this.cqc.setVisibility(8);
        this.cqd.setVisibility(8);
        this.cqb.setVisibility(0);
        this.cpY.setVisibility(8);
        this.cqi.setVisibility(8);
        this.cqe.setVisibility(8);
        this.cqh.setVisibility(8);
        this.coj.bAa();
        if (cardPersonDynamicThreadData.csu == 36) {
            this.coX.setVisibility(8);
        } else if (cardPersonDynamicThreadData.csu == 40 || this.cpC.csu == 50) {
            this.coX.setVisibility(8);
            if (com.baidu.tbadk.core.i.pY().qe()) {
                this.cpY.setVisibility(0);
                this.cqa.setVisibility(0);
                this.cqa.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpY.getLayoutParams();
                int width = this.cpY.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cpY.setLayoutParams(layoutParams);
                if (this.cpC.videoInfo != null) {
                    this.cpZ.setDefaultErrorResource(0);
                    this.cpZ.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cpZ.setEvent(this.coG);
                    this.cpZ.startLoad(this.cpC.videoInfo.thumbnail_url, 17, false);
                    if (this.cqn) {
                        this.cqi.setVisibility(0);
                        this.cqi.setText(String.format(this.mContext.getResources().getString(d.k.video_review_state), new Object[0]));
                    } else {
                        this.cqe.setVisibility(0);
                        this.cqf.setText(an.cV(this.cpC.videoInfo.video_duration.intValue() * 1000));
                        this.cqg.setText(String.format(this.mContext.getResources().getString(d.k.play_count), an.B(this.cpC.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cpC.csu == 60 || this.cpC.csu == 49) {
            this.coX.setVisibility(8);
            if (this.cpC.threadData.si() != null && this.cpC.threadData.si().user_info != null && this.cpC.csu == 60) {
                String str = this.cpC.threadData.si().user_info.user_name;
                if (com.baidu.tbadk.util.w.hl(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cqc.setText(o.aH(str + ":", this.cpC.threadData.getTitle()));
                this.cqc.setVisibility(0);
            } else {
                this.cqc.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.pY().qe()) {
                this.cpY.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cpY.getLayoutParams();
                int width2 = this.cpY.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cpY.setLayoutParams(layoutParams2);
                if (this.cpC.threadData.si() != null) {
                    this.cpZ.setDefaultErrorResource(0);
                    this.cpZ.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cpZ.setEvent(this.coG);
                    this.cpZ.startLoad(cardPersonDynamicThreadData.threadData.si().cover, 10, false);
                    this.cqa.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.coj.startPlayAnimation();
                    ak.i(this.cqb, d.C0126d.cp_bg_line_e);
                    this.cqh.setVisibility(0);
                    this.cqh.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cpC.threadData.si().audience_count)));
                    this.bwk.getCommentContainer().setOnClickListener(this.cme);
                } else {
                    this.bwk.getCommentContainer().setOnClickListener(this.bwk);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.pY().qe() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.coX.setVisibility(0);
                    this.coX.setFromCDN(this.akC);
                    this.coX.setSingleImageRatio(0.67d);
                    this.coX.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z) {
                            if (z) {
                                t.this.afs();
                            } else {
                                t.this.a(view2, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.coX.setImageMediaList(linkedList);
                } else {
                    this.coX.setVisibility(8);
                }
            } else {
                this.coX.setVisibility(8);
            }
            this.cqb.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.abL != null) {
            this.cqk.setVisibility(0);
            this.cqk.b(cardPersonDynamicThreadData.threadData.abL);
            this.cqk.setOnClickListener(this);
            this.coU.setVisibility(8);
            this.coX.setVisibility(8);
            this.cqb.setVisibility(8);
            if (this.cqo) {
                this.cqj.setVisibility(0);
            } else {
                this.cqj.setVisibility(8);
            }
        } else {
            this.cqk.setVisibility(8);
            this.cqj.setVisibility(8);
        }
        afr();
        c(cardPersonDynamicThreadData);
    }

    private void er(boolean z) {
        if (this.coX != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coX.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.coX.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cqn || this.cqo) {
                this.bwk.setCommentClickable(false);
                this.bwk.setAgreeClickable(false);
                this.bwk.setShareClickable(false);
                this.cqk.setClickable(false);
                this.cpW.setClickable(false);
            } else {
                this.bwk.setCommentClickable(true);
                this.bwk.setAgreeClickable(true);
                this.bwk.setShareClickable(true);
                this.cqk.setClickable(true);
                this.cpW.setClickable(true);
            }
            this.bwk.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.csu == 60) {
                this.bwk.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.csE != null) {
                this.bwk.setMultiForumCount(cardPersonDynamicThreadData.csE.length);
            }
            this.bwk.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void afr() {
        this.coU.setClickable(true);
        int childCount = this.coX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.coX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void afv() {
        if (this.cpC != null && this.cpC.threadData != null && this.cpC.threadData.si() != null) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.kv(this.cpC.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cpC.threadData.si());
            if (this.cpC.threadData.si().user_info != null) {
                alaLiveInfoCoreData.userName = this.cpC.threadData.si().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (this.cpC != null && this.cpC.threadData != null && this.cpC.threadData.si() != null && this.cpC.threadData.si().share_info != null) {
            if (!isHost()) {
                o.kv(this.cpC.threadId);
            }
            if (this.cpC.threadData.si().share_info.record_tid <= 0) {
                afv();
                return;
            }
            String valueOf = String.valueOf(this.cpC.threadData.si().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.cpC != null) {
            if (!isHost()) {
                o.kv(this.cpC.threadId);
                o.a(this.mTitle, this.cpC.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.coW, this.cpC.threadId, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cpC.csu == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cpC.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cpC.threadData.getFid()));
            pbActivityConfig.setForumName(this.cpC.threadData.rV());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cpC.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cpC.threadData == null || !this.cpC.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new al("c12943").ac("obj_type", "2").ac("tid", this.cpC.threadId).r("obj_param1", this.cpC.isHost ? 1 : 2));
        }
    }

    private void afx() {
        if (this.cpC != null && this.cpC.threadData != null && this.cpC.threadData.abL != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cpC.threadData.abL.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new al("c12943").ac("obj_type", "3").ac("tid", this.cpC.threadId).r("obj_param1", this.cpC.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cpV != null) {
            if (z) {
                this.cpV.setText(d.k.privacy);
                Drawable drawable = ak.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cpV.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cpV.setText(d.k.public_open);
            Drawable drawable2 = ak.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cpV.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cpC.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cqk) {
            afx();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coX != null) {
            this.coX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coX != null) {
            this.coX.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.akC ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rV(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cqn);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.j(c));
        this.mTitle.setText(c);
        if (isHost()) {
            return true;
        }
        o.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        return true;
    }
}
