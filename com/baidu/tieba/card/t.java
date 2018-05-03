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
    private View.OnClickListener cma;
    private TbImageView.a coD;
    public PlayVoiceBntNew coR;
    private TextView coT;
    private ConstrainImageGroup coU;
    private final View.OnClickListener coX;
    private AlaPlayAnimationView cog;
    private CustomMessageListener coh;
    public ThreadViewAndCommentInfoLayout cpK;
    private final String cpL;
    private final String cpM;
    private TextView cpN;
    private LinearLayout cpO;
    private TextView cpP;
    private TextView cpQ;
    private TextView cpR;
    private TextView cpS;
    private ImageView cpT;
    private s cpU;
    private View cpV;
    private TbImageView cpW;
    private ImageView cpX;
    private LinearLayout cpY;
    private TextView cpZ;
    private CardPersonDynamicThreadData cpz;
    private LinearLayout cqa;
    private LinearLayout cqb;
    private TextView cqc;
    private TextView cqd;
    private TextView cqe;
    private TextView cqf;
    private TextView cqg;
    public OriginalThreadCardView cqh;
    private View cqi;
    private View cqj;
    private boolean cqk;
    private boolean cql;
    com.baidu.tieba.view.h cqm;
    private s.a cqn;
    private final View.OnClickListener cqo;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cpL = "1";
        this.cpM = "2";
        this.mSkinType = 3;
        this.akC = true;
        this.cqm = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                if (t.this.cpz != null && !StringUtils.isNull(t.this.cpz.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cpz.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(d.C0126d.cp_link_tip_c) : t.this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            }
        };
        this.cma = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.aeZ() != null) {
                    t.this.aeZ().a(view2, t.this.cpz);
                }
                if (t.this.cpz.csr != 60) {
                    if ((t.this.cpz.csr != 40 || t.this.cpz.cst != 2) && !t.this.cql) {
                        t.this.afs();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(d.k.video_check_click_msg), d.f.icon_toast_game_error).tL();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cpz.threadData.si().live_status != 1) {
                    t.this.afw();
                } else {
                    t.this.afv();
                }
            }
        };
        this.coh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cpz != null && t.this.cpz.threadId != null && t.this.mTitle != null && t.this.coT != null && ((String) customResponsedMessage.getData()).equals(t.this.cpz.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cpz.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                    o.a(t.this.coT, t.this.cpz.threadId, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                }
            }
        };
        this.cqn = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.es(z);
            }
        };
        this.cqo = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<CardPersonDynamicThreadData> aeZ = t.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("1");
                    aeZ.a(view2, t.this.cpz);
                }
                t.this.afs();
            }
        };
        this.coX = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<CardPersonDynamicThreadData> aeZ = t.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, t.this.cpz);
                }
            }
        };
        this.coD = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && t.this.cpW != null) {
                    t.this.cpW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cpN = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cpO = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cpP = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cpQ = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cpR = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cqg = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cpS = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cpT = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.coR = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.coR.setAfterClickListener(this.coX);
        this.coT = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.coT.setVisibility(8);
        this.coU = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.coU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.coU.setChildClickListener(this.cqo);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coU.setImageProcessor(eVar);
        this.cpV = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cpW = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cpX = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cpK = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cqb = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cqc = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cqd = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cqe = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cog = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cqf = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cpY = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cpZ = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cqa = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cqa.setVisibility(8);
        this.cqh = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cqi = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cqj = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cma);
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
                    t.this.aeZ().a(view2, t.this.cpz);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.cpN, d.C0126d.cp_cont_b);
            ak.h(this.cpP, d.C0126d.cp_cont_j);
            ak.h(this.cpQ, d.C0126d.cp_cont_b);
            ak.h(this.cpR, d.C0126d.cp_cont_d);
            ak.h(this.cqg, d.C0126d.cp_cont_d);
            ak.h(this.cpS, d.C0126d.cp_cont_d);
            if (this.cpT != null) {
                this.cpT.setImageDrawable(ak.getDrawable(d.f.icon_card_more));
            }
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.h(this.coT, d.C0126d.cp_cont_f);
            ak.h(this.cpZ, d.C0126d.cp_cont_f);
            if (this.cpU != null) {
                this.cpU.onChangeSkinType();
            }
            this.cpK.onChangeSkinType();
            this.bwk.onChangeSkinType();
            ak.j(this.cqi, d.C0126d.cp_bg_line_e);
            ak.j(this.cqj, d.C0126d.cp_bg_line_c);
            ak.j(this.cpZ, d.C0126d.cp_bg_line_e);
            if (this.cqh != null) {
                this.cqh.onChangeSkinType();
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
        this.cpz = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cma);
        }
        this.cpN.setVisibility(cardPersonDynamicThreadData.csD ? 0 : 8);
        this.cpO.setVisibility(cardPersonDynamicThreadData.csC ? 0 : 4);
        this.cqi.setVisibility(cardPersonDynamicThreadData.csC ? 0 : 8);
        this.cqj.setVisibility(cardPersonDynamicThreadData.csC ? 8 : 0);
        if (cardPersonDynamicThreadData.csE) {
            this.cqi.setVisibility(8);
            this.cqj.setVisibility(8);
        }
        this.cqk = cardPersonDynamicThreadData.csr == 40 && cardPersonDynamicThreadData.cst == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cql = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cst == 2;
        }
        this.cpN.setText(cardPersonDynamicThreadData.csu);
        this.cpP.setText(cardPersonDynamicThreadData.csv);
        this.cpQ.setText(cardPersonDynamicThreadData.csw);
        if (cardPersonDynamicThreadData.csB != null && cardPersonDynamicThreadData.csB.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.csB.length; i++) {
                sb.append(an.e(cardPersonDynamicThreadData.csB[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.csB.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.k.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.k.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cpR.setText(sb2);
                this.cpR.setVisibility(0);
            } else {
                this.cpR.setText(d.k.person_homepage);
            }
        } else {
            this.cpR.setText(d.k.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cpS.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cpS.setVisibility(0);
            }
            es(cardPersonDynamicThreadData.isPrivacy);
            this.cpT.setVisibility(0);
            this.cpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cpU == null) {
                            t.this.cpU = new s(t.this.mPageContext);
                            t.this.cpU.create();
                            t.this.cpU.a(t.this.cqn);
                        }
                        t.this.cpU.a(t.this.cpz);
                        t.this.cpU.show();
                    }
                }
            });
        } else {
            this.cpS.setVisibility(8);
            this.cpT.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.csz;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.coR.setVisibility(0);
            er(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.coR.setVoiceModel(voiceModel);
            this.coR.setTag(voiceModel);
            this.coR.aIT();
            if (voiceModel != null) {
                this.coR.ob(voiceModel.voice_status.intValue());
            }
            this.coR.btf();
        } else {
            this.coR.setVisibility(8);
            er(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.csy;
        ak.i(this.cpY, d.C0126d.transparent);
        this.cpZ.setVisibility(8);
        this.cqa.setVisibility(8);
        this.cpY.setVisibility(0);
        this.cpV.setVisibility(8);
        this.cqf.setVisibility(8);
        this.cqb.setVisibility(8);
        this.cqe.setVisibility(8);
        this.cog.bAa();
        if (cardPersonDynamicThreadData.csr == 36) {
            this.coU.setVisibility(8);
        } else if (cardPersonDynamicThreadData.csr == 40 || this.cpz.csr == 50) {
            this.coU.setVisibility(8);
            if (com.baidu.tbadk.core.i.pY().qe()) {
                this.cpV.setVisibility(0);
                this.cpX.setVisibility(0);
                this.cpX.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpV.getLayoutParams();
                int width = this.cpV.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cpV.setLayoutParams(layoutParams);
                if (this.cpz.videoInfo != null) {
                    this.cpW.setDefaultErrorResource(0);
                    this.cpW.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cpW.setEvent(this.coD);
                    this.cpW.startLoad(this.cpz.videoInfo.thumbnail_url, 17, false);
                    if (this.cqk) {
                        this.cqf.setVisibility(0);
                        this.cqf.setText(String.format(this.mContext.getResources().getString(d.k.video_review_state), new Object[0]));
                    } else {
                        this.cqb.setVisibility(0);
                        this.cqc.setText(an.cU(this.cpz.videoInfo.video_duration.intValue() * 1000));
                        this.cqd.setText(String.format(this.mContext.getResources().getString(d.k.play_count), an.B(this.cpz.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cpz.csr == 60 || this.cpz.csr == 49) {
            this.coU.setVisibility(8);
            if (this.cpz.threadData.si() != null && this.cpz.threadData.si().user_info != null && this.cpz.csr == 60) {
                String str = this.cpz.threadData.si().user_info.user_name;
                if (com.baidu.tbadk.util.w.hl(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.cpZ.setText(o.aH(str + ":", this.cpz.threadData.getTitle()));
                this.cpZ.setVisibility(0);
            } else {
                this.cpZ.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.pY().qe()) {
                this.cpV.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cpV.getLayoutParams();
                int width2 = this.cpV.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cpV.setLayoutParams(layoutParams2);
                if (this.cpz.threadData.si() != null) {
                    this.cpW.setDefaultErrorResource(0);
                    this.cpW.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cpW.setEvent(this.coD);
                    this.cpW.startLoad(cardPersonDynamicThreadData.threadData.si().cover, 10, false);
                    this.cpX.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cog.startPlayAnimation();
                    ak.i(this.cpY, d.C0126d.cp_bg_line_e);
                    this.cqe.setVisibility(0);
                    this.cqe.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cpz.threadData.si().audience_count)));
                    this.bwk.getCommentContainer().setOnClickListener(this.cma);
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
                    this.coU.setVisibility(0);
                    this.coU.setFromCDN(this.akC);
                    this.coU.setSingleImageRatio(0.67d);
                    this.coU.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z) {
                            if (z) {
                                t.this.afs();
                            } else {
                                t.this.a(view2, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.coU.setImageMediaList(linkedList);
                } else {
                    this.coU.setVisibility(8);
                }
            } else {
                this.coU.setVisibility(8);
            }
            this.cpY.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.abL != null) {
            this.cqh.setVisibility(0);
            this.cqh.b(cardPersonDynamicThreadData.threadData.abL);
            this.cqh.setOnClickListener(this);
            this.coR.setVisibility(8);
            this.coU.setVisibility(8);
            this.cpY.setVisibility(8);
            if (this.cql) {
                this.cqg.setVisibility(0);
            } else {
                this.cqg.setVisibility(8);
            }
        } else {
            this.cqh.setVisibility(8);
            this.cqg.setVisibility(8);
        }
        afr();
        c(cardPersonDynamicThreadData);
    }

    private void er(boolean z) {
        if (this.coU != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coU.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.coU.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cqk || this.cql) {
                this.bwk.setCommentClickable(false);
                this.bwk.setAgreeClickable(false);
                this.bwk.setShareClickable(false);
                this.cqh.setClickable(false);
                this.cpT.setClickable(false);
            } else {
                this.bwk.setCommentClickable(true);
                this.bwk.setAgreeClickable(true);
                this.bwk.setShareClickable(true);
                this.cqh.setClickable(true);
                this.cpT.setClickable(true);
            }
            this.bwk.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.csr == 60) {
                this.bwk.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.csB != null) {
                this.bwk.setMultiForumCount(cardPersonDynamicThreadData.csB.length);
            }
            this.bwk.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void afr() {
        this.coR.setClickable(true);
        int childCount = this.coU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.coU.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void afv() {
        if (this.cpz != null && this.cpz.threadData != null && this.cpz.threadData.si() != null) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.kv(this.cpz.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cpz.threadData.si());
            if (this.cpz.threadData.si().user_info != null) {
                alaLiveInfoCoreData.userName = this.cpz.threadData.si().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (this.cpz != null && this.cpz.threadData != null && this.cpz.threadData.si() != null && this.cpz.threadData.si().share_info != null) {
            if (!isHost()) {
                o.kv(this.cpz.threadId);
            }
            if (this.cpz.threadData.si().share_info.record_tid <= 0) {
                afv();
                return;
            }
            String valueOf = String.valueOf(this.cpz.threadData.si().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.cpz != null) {
            if (!isHost()) {
                o.kv(this.cpz.threadId);
                o.a(this.mTitle, this.cpz.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.coT, this.cpz.threadId, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cpz.csr == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cpz.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cpz.threadData.getFid()));
            pbActivityConfig.setForumName(this.cpz.threadData.rV());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cpz.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cpz.threadData == null || !this.cpz.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new al("c12943").ac("obj_type", "2").ac("tid", this.cpz.threadId).r("obj_param1", this.cpz.isHost ? 1 : 2));
        }
    }

    private void afx() {
        if (this.cpz != null && this.cpz.threadData != null && this.cpz.threadData.abL != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cpz.threadData.abL.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new al("c12943").ac("obj_type", "3").ac("tid", this.cpz.threadId).r("obj_param1", this.cpz.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cpS != null) {
            if (z) {
                this.cpS.setText(d.k.privacy);
                Drawable drawable = ak.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cpS.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cpS.setText(d.k.public_open);
            Drawable drawable2 = ak.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cpS.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cpz.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cqh) {
            afx();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coU != null) {
            this.coU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coU != null) {
            this.coU.setImageViewPool(bVar);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cqk);
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
