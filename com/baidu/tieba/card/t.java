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
    public ThreadCommentAndPraiseInfoLayout bxb;
    private View.OnClickListener cnk;
    private TbImageView.a cpN;
    private AlaPlayAnimationView cpp;
    private CustomMessageListener cpq;
    private CardPersonDynamicThreadData cqI;
    public ThreadViewAndCommentInfoLayout cqT;
    private final String cqU;
    private final String cqV;
    private TextView cqW;
    private LinearLayout cqX;
    private TextView cqY;
    private TextView cqZ;
    public PlayVoiceBntNew cqb;
    private TextView cqd;
    private ConstrainImageGroup cqe;
    private final View.OnClickListener cqh;
    private TextView cra;
    private TextView crb;
    private ImageView crd;
    private s cre;
    private View crf;
    private TbImageView crg;
    private ImageView crh;
    private LinearLayout cri;
    private TextView crj;
    private LinearLayout crk;
    private LinearLayout crl;
    private TextView crm;
    private TextView crn;
    private TextView cro;
    private TextView crp;
    private TextView crq;
    public OriginalThreadCardView crr;
    private View crs;
    private View crt;
    private boolean cru;
    private boolean crv;
    com.baidu.tieba.view.h crw;
    private s.a crx;
    private final View.OnClickListener cry;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cqU = "1";
        this.cqV = "2";
        this.mSkinType = 3;
        this.akC = true;
        this.crw = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                if (t.this.cqI != null && !StringUtils.isNull(t.this.cqI.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cqI.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(d.C0126d.cp_link_tip_c) : t.this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            }
        };
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.aeZ() != null) {
                    t.this.aeZ().a(view2, t.this.cqI);
                }
                if (t.this.cqI.ctB != 60) {
                    if ((t.this.cqI.ctB != 40 || t.this.cqI.ctD != 2) && !t.this.crv) {
                        t.this.afs();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(d.k.video_check_click_msg), d.f.icon_toast_game_error).tK();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cqI.threadData.sh().live_status != 1) {
                    t.this.afw();
                } else {
                    t.this.afv();
                }
            }
        };
        this.cpq = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cqI != null && t.this.cqI.threadId != null && t.this.mTitle != null && t.this.cqd != null && ((String) customResponsedMessage.getData()).equals(t.this.cqI.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cqI.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                    o.a(t.this.cqd, t.this.cqI.threadId, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                }
            }
        };
        this.crx = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.et(z);
            }
        };
        this.cry = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<CardPersonDynamicThreadData> aeZ = t.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("1");
                    aeZ.a(view2, t.this.cqI);
                }
                t.this.afs();
            }
        };
        this.cqh = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<CardPersonDynamicThreadData> aeZ = t.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, t.this.cqI);
                }
            }
        };
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && t.this.crg != null) {
                    t.this.crg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cqW = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cqX = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cqY = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cqZ = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cra = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.crq = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.crb = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.crd = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cqb = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cqb.setAfterClickListener(this.cqh);
        this.cqd = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cqd.setVisibility(8);
        this.cqe = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cqe.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cqe.setChildClickListener(this.cry);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cqe.setImageProcessor(eVar);
        this.crf = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.crg = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.crh = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cqT = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.crl = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.crm = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.crn = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cro = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cpp = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.crp = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cri = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.crj = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.crk = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.crk.setVisibility(8);
        this.crr = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.crs = this.mRootView.findViewById(d.g.divider_line_thick);
        this.crt = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setFrom(8);
        this.bxb.setShareReportFrom(6);
        this.bxb.setStType("person_page");
        this.bxb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.aeZ() != null) {
                    t.this.aeZ().a(view2, t.this.cqI);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.cqW, d.C0126d.cp_cont_b);
            ak.h(this.cqY, d.C0126d.cp_cont_j);
            ak.h(this.cqZ, d.C0126d.cp_cont_b);
            ak.h(this.cra, d.C0126d.cp_cont_d);
            ak.h(this.crq, d.C0126d.cp_cont_d);
            ak.h(this.crb, d.C0126d.cp_cont_d);
            if (this.crd != null) {
                this.crd.setImageDrawable(ak.getDrawable(d.f.icon_card_more));
            }
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.h(this.cqd, d.C0126d.cp_cont_f);
            ak.h(this.crj, d.C0126d.cp_cont_f);
            if (this.cre != null) {
                this.cre.onChangeSkinType();
            }
            this.cqT.onChangeSkinType();
            this.bxb.onChangeSkinType();
            ak.j(this.crs, d.C0126d.cp_bg_line_e);
            ak.j(this.crt, d.C0126d.cp_bg_line_c);
            ak.j(this.crj, d.C0126d.cp_bg_line_e);
            if (this.crr != null) {
                this.crr.onChangeSkinType();
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
        this.cqI = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cnk);
        }
        this.cqW.setVisibility(cardPersonDynamicThreadData.ctN ? 0 : 8);
        this.cqX.setVisibility(cardPersonDynamicThreadData.ctM ? 0 : 4);
        this.crs.setVisibility(cardPersonDynamicThreadData.ctM ? 0 : 8);
        this.crt.setVisibility(cardPersonDynamicThreadData.ctM ? 8 : 0);
        if (cardPersonDynamicThreadData.ctO) {
            this.crs.setVisibility(8);
            this.crt.setVisibility(8);
        }
        this.cru = cardPersonDynamicThreadData.ctB == 40 && cardPersonDynamicThreadData.ctD == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.crv = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.ctD == 2;
        }
        this.cqW.setText(cardPersonDynamicThreadData.ctE);
        this.cqY.setText(cardPersonDynamicThreadData.ctF);
        this.cqZ.setText(cardPersonDynamicThreadData.ctG);
        if (cardPersonDynamicThreadData.ctL != null && cardPersonDynamicThreadData.ctL.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.ctL.length; i++) {
                sb.append(an.e(cardPersonDynamicThreadData.ctL[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.ctL.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.k.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.k.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cra.setText(sb2);
                this.cra.setVisibility(0);
            } else {
                this.cra.setText(d.k.person_homepage);
            }
        } else {
            this.cra.setText(d.k.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.crb.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.crb.setVisibility(0);
            }
            et(cardPersonDynamicThreadData.isPrivacy);
            this.crd.setVisibility(0);
            this.crd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cre == null) {
                            t.this.cre = new s(t.this.mPageContext);
                            t.this.cre.create();
                            t.this.cre.a(t.this.crx);
                        }
                        t.this.cre.a(t.this.cqI);
                        t.this.cre.show();
                    }
                }
            });
        } else {
            this.crb.setVisibility(8);
            this.crd.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.ctJ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cqb.setVisibility(0);
            es(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cqb.setVoiceModel(voiceModel);
            this.cqb.setTag(voiceModel);
            this.cqb.aIS();
            if (voiceModel != null) {
                this.cqb.oa(voiceModel.voice_status.intValue());
            }
            this.cqb.btd();
        } else {
            this.cqb.setVisibility(8);
            es(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.ctI;
        ak.i(this.cri, d.C0126d.transparent);
        this.crj.setVisibility(8);
        this.crk.setVisibility(8);
        this.cri.setVisibility(0);
        this.crf.setVisibility(8);
        this.crp.setVisibility(8);
        this.crl.setVisibility(8);
        this.cro.setVisibility(8);
        this.cpp.bzY();
        if (cardPersonDynamicThreadData.ctB == 36) {
            this.cqe.setVisibility(8);
        } else if (cardPersonDynamicThreadData.ctB == 40 || this.cqI.ctB == 50) {
            this.cqe.setVisibility(8);
            if (com.baidu.tbadk.core.i.pX().qd()) {
                this.crf.setVisibility(0);
                this.crh.setVisibility(0);
                this.crh.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.crf.getLayoutParams();
                int width = this.crf.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.crf.setLayoutParams(layoutParams);
                if (this.cqI.videoInfo != null) {
                    this.crg.setDefaultErrorResource(0);
                    this.crg.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.crg.setEvent(this.cpN);
                    this.crg.startLoad(this.cqI.videoInfo.thumbnail_url, 17, false);
                    if (this.cru) {
                        this.crp.setVisibility(0);
                        this.crp.setText(String.format(this.mContext.getResources().getString(d.k.video_review_state), new Object[0]));
                    } else {
                        this.crl.setVisibility(0);
                        this.crm.setText(an.cV(this.cqI.videoInfo.video_duration.intValue() * 1000));
                        this.crn.setText(String.format(this.mContext.getResources().getString(d.k.play_count), an.B(this.cqI.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cqI.ctB == 60 || this.cqI.ctB == 49) {
            this.cqe.setVisibility(8);
            if (this.cqI.threadData.sh() != null && this.cqI.threadData.sh().user_info != null && this.cqI.ctB == 60) {
                String str = this.cqI.threadData.sh().user_info.user_name;
                if (com.baidu.tbadk.util.w.hm(str) > 14) {
                    str = com.baidu.tbadk.util.w.I(str, 14) + "...";
                }
                this.crj.setText(o.aH(str + ":", this.cqI.threadData.getTitle()));
                this.crj.setVisibility(0);
            } else {
                this.crj.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.pX().qd()) {
                this.crf.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.crf.getLayoutParams();
                int width2 = this.crf.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.crf.setLayoutParams(layoutParams2);
                if (this.cqI.threadData.sh() != null) {
                    this.crg.setDefaultErrorResource(0);
                    this.crg.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.crg.setEvent(this.cpN);
                    this.crg.startLoad(cardPersonDynamicThreadData.threadData.sh().cover, 10, false);
                    this.crh.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cpp.startPlayAnimation();
                    ak.i(this.cri, d.C0126d.cp_bg_line_e);
                    this.cro.setVisibility(0);
                    this.cro.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), an.B(this.cqI.threadData.sh().audience_count)));
                    this.bxb.getCommentContainer().setOnClickListener(this.cnk);
                } else {
                    this.bxb.getCommentContainer().setOnClickListener(this.bxb);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.pX().qd() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.cqe.setVisibility(0);
                    this.cqe.setFromCDN(this.akC);
                    this.cqe.setSingleImageRatio(0.67d);
                    this.cqe.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z) {
                            if (z) {
                                t.this.afs();
                            } else {
                                t.this.a(view2, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cqe.setImageMediaList(linkedList);
                } else {
                    this.cqe.setVisibility(8);
                }
            } else {
                this.cqe.setVisibility(8);
            }
            this.cri.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.abM != null) {
            this.crr.setVisibility(0);
            this.crr.b(cardPersonDynamicThreadData.threadData.abM);
            this.crr.setOnClickListener(this);
            this.cqb.setVisibility(8);
            this.cqe.setVisibility(8);
            this.cri.setVisibility(8);
            if (this.crv) {
                this.crq.setVisibility(0);
            } else {
                this.crq.setVisibility(8);
            }
        } else {
            this.crr.setVisibility(8);
            this.crq.setVisibility(8);
        }
        afr();
        c(cardPersonDynamicThreadData);
    }

    private void es(boolean z) {
        if (this.cqe != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqe.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cqe.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cru || this.crv) {
                this.bxb.setCommentClickable(false);
                this.bxb.setAgreeClickable(false);
                this.bxb.setShareClickable(false);
                this.crr.setClickable(false);
                this.crd.setClickable(false);
            } else {
                this.bxb.setCommentClickable(true);
                this.bxb.setAgreeClickable(true);
                this.bxb.setShareClickable(true);
                this.crr.setClickable(true);
                this.crd.setClickable(true);
            }
            this.bxb.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.ctB == 60) {
                this.bxb.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.ctL != null) {
                this.bxb.setMultiForumCount(cardPersonDynamicThreadData.ctL.length);
            }
            this.bxb.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void afr() {
        this.cqb.setClickable(true);
        int childCount = this.cqe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cqe.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void afv() {
        if (this.cqI != null && this.cqI.threadData != null && this.cqI.threadData.sh() != null) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.ky(this.cqI.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cqI.threadData.sh());
            if (this.cqI.threadData.sh().user_info != null) {
                alaLiveInfoCoreData.userName = this.cqI.threadData.sh().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        if (this.cqI != null && this.cqI.threadData != null && this.cqI.threadData.sh() != null && this.cqI.threadData.sh().share_info != null) {
            if (!isHost()) {
                o.ky(this.cqI.threadId);
            }
            if (this.cqI.threadData.sh().share_info.record_tid <= 0) {
                afv();
                return;
            }
            String valueOf = String.valueOf(this.cqI.threadData.sh().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.cqI != null) {
            if (!isHost()) {
                o.ky(this.cqI.threadId);
                o.a(this.mTitle, this.cqI.threadId, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.cqd, this.cqI.threadId, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cqI.ctB == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cqI.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cqI.threadData.getFid()));
            pbActivityConfig.setForumName(this.cqI.threadData.rU());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cqI.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cqI.threadData == null || !this.cqI.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new al("c12943").ac("obj_type", "2").ac("tid", this.cqI.threadId).r("obj_param1", this.cqI.isHost ? 1 : 2));
        }
    }

    private void afx() {
        if (this.cqI != null && this.cqI.threadData != null && this.cqI.threadData.abM != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cqI.threadData.abM.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new al("c12943").ac("obj_type", "3").ac("tid", this.cqI.threadId).r("obj_param1", this.cqI.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(boolean z) {
        if (this.crb != null) {
            if (z) {
                this.crb.setText(d.k.privacy);
                Drawable drawable = ak.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.crb.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.crb.setText(d.k.public_open);
            Drawable drawable2 = ak.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.crb.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cqI.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.crr) {
            afx();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cqe != null) {
            this.cqe.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cqe != null) {
            this.cqe.setImageViewPool(bVar);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rU(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cru);
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
