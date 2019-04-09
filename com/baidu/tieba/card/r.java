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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class r extends a<CardPersonDynamicThreadData> {
    private TextView XL;
    private boolean ZR;
    public PlayVoiceBntNew aaa;
    private TbImageView.a cAo;
    public NewThreadCommentAndPraiseInfoLayout drn;
    private CustomMessageListener eht;
    private CardPersonDynamicThreadData eiE;
    public ThreadViewAndCommentInfoLayout eiP;
    private final String eiQ;
    private final String eiR;
    private TextView eiS;
    private LinearLayout eiT;
    private TextView eiU;
    private TextView eiV;
    private TextView eiW;
    private TextView eiX;
    private ImageView eiY;
    private q eiZ;
    private ConstrainImageGroup eia;
    private View.OnClickListener eif;
    private final View.OnClickListener eig;
    private View eja;
    private TbImageView ejb;
    private ImageView ejc;
    private LinearLayout ejd;
    private TextView eje;
    private LinearLayout ejf;
    private LinearLayout ejg;
    private TextView ejh;
    private TextView eji;
    private TextView ejj;
    private TBLottieAnimationView ejk;
    private TextView ejl;
    private TextView ejm;
    public OriginalThreadCardView ejn;
    private View ejo;
    private View ejp;
    private boolean ejq;
    private boolean ejr;
    com.baidu.tieba.view.h ejs;
    private q.a ejt;
    private final View.OnClickListener eju;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eiQ = "1";
        this.eiR = "2";
        this.mSkinType = 3;
        this.ZR = true;
        this.ejs = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.r.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (r.this.eiE != null && !StringUtils.isNull(r.this.eiE.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.mContext).createNormalCfg(r.this.eiE.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? r.this.mContext.getResources().getColor(d.C0277d.cp_link_tip_c) : r.this.mContext.getResources().getColor(d.C0277d.cp_link_tip_a));
            }
        };
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aQf() != null) {
                    r.this.aQf().a(view, r.this.eiE);
                }
                if (r.this.eiE.elN != 60) {
                    if ((r.this.eiE.elN != 40 || r.this.eiE.elP != 2) && !r.this.ejr) {
                        r.this.ajU();
                        return;
                    } else {
                        BdToast.c(r.this.getContext(), r.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).abe();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (r.this.eiE.threadData.Zh().live_status != 1) {
                    r.this.aQB();
                } else {
                    r.this.aQA();
                }
            }
        };
        this.eht = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.r.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && r.this.eiE != null && r.this.eiE.threadId != null && r.this.mTitle != null && r.this.XL != null && ((String) customResponsedMessage.getData()).equals(r.this.eiE.threadId) && !r.this.isHost()) {
                    n.a(r.this.mTitle, r.this.eiE.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                    n.a(r.this.XL, r.this.eiE.threadId, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                }
            }
        };
        this.ejt = new q.a() { // from class: com.baidu.tieba.card.r.8
            @Override // com.baidu.tieba.card.q.a
            public void setPrivacy(boolean z) {
                r.this.hP(z);
            }
        };
        this.eju = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aQf = r.this.aQf();
                if (aQf != null) {
                    view.setTag("1");
                    aQf.a(view, r.this.eiE);
                }
                r.this.ajU();
            }
        };
        this.eig = new View.OnClickListener() { // from class: com.baidu.tieba.card.r.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aQf = r.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, r.this.eiE);
                }
            }
        };
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.card.r.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && r.this.ejb != null) {
                    r.this.ejb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.eiS = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.eiT = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.eiU = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.eiV = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.eiW = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.ejm = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.eiX = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.eiY = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.aaa = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.aaa.setAfterClickListener(this.eig);
        this.XL = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.XL.setVisibility(8);
        this.eia = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.eia.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.eia.setChildClickListener(this.eju);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.eia.setImageProcessor(aVar);
        this.eja = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.ejb = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.ejc = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.eiP = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.ejg = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.ejh = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.eji = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.ejj = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.ejk = (TBLottieAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.ejk.G(true);
        al.a(this.ejk, d.i.ala_play);
        this.ejl = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.ejd = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.eje = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.ejf = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.ejf.setVisibility(8);
        this.ejn = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.ejo = this.mRootView.findViewById(d.g.divider_line_thick);
        this.ejp = this.mRootView.findViewById(d.g.divider_line_thin);
        this.drn = (NewThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.drn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.drn.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.drn.setLayoutParams(layoutParams);
        }
        this.drn.setOnClickListener(this.eif);
        this.drn.setReplyTimeVisible(false);
        this.drn.setShowPraiseNum(true);
        this.drn.setNeedAddPraiseIcon(true);
        this.drn.setNeedAddReplyIcon(true);
        this.drn.setShareVisible(true);
        this.drn.setIsBarViewVisible(false);
        this.drn.setFrom(8);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxn = 8;
        dVar.bxs = 3;
        this.drn.setAgreeStatisticData(dVar);
        this.drn.setShareReportFrom(6);
        this.drn.setStType("person_page");
        this.drn.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.aQf() != null) {
                    r.this.aQf().a(view, r.this.eiE);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.a(this.ejk, d.i.ala_play);
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.j(this.eiS, d.C0277d.cp_cont_b);
            al.j(this.eiU, d.C0277d.cp_cont_j);
            al.j(this.eiV, d.C0277d.cp_cont_b);
            al.j(this.eiW, d.C0277d.cp_cont_d);
            al.j(this.ejm, d.C0277d.cp_cont_d);
            al.j(this.eiX, d.C0277d.cp_cont_d);
            if (this.eiY != null) {
                this.eiY.setImageDrawable(al.getDrawable(d.f.icon_card_more));
            }
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.j(this.XL, d.C0277d.cp_cont_f);
            al.j(this.eje, d.C0277d.cp_cont_f);
            if (this.eiZ != null) {
                this.eiZ.onChangeSkinType();
            }
            this.eiP.onChangeSkinType();
            this.drn.onChangeSkinType();
            al.l(this.ejo, d.C0277d.cp_bg_line_e);
            al.l(this.ejp, d.C0277d.cp_bg_line_c);
            al.l(this.eje, d.C0277d.cp_bg_line_e);
            if (this.ejn != null) {
                this.ejn.onChangeSkinType();
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
        this.eiE = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eif);
        }
        this.eiS.setVisibility(cardPersonDynamicThreadData.elZ ? 0 : 8);
        this.eiT.setVisibility(cardPersonDynamicThreadData.elY ? 0 : 4);
        this.ejo.setVisibility(cardPersonDynamicThreadData.elY ? 0 : 8);
        this.ejp.setVisibility(cardPersonDynamicThreadData.elY ? 8 : 0);
        if (cardPersonDynamicThreadData.ema) {
            this.ejo.setVisibility(8);
            this.ejp.setVisibility(8);
        }
        this.ejq = cardPersonDynamicThreadData.elN == 40 && cardPersonDynamicThreadData.elP == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ejr = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.elP == 2;
        }
        this.eiS.setText(cardPersonDynamicThreadData.elQ);
        this.eiU.setText(cardPersonDynamicThreadData.elR);
        this.eiV.setText(cardPersonDynamicThreadData.elS);
        if (cardPersonDynamicThreadData.elX != null && cardPersonDynamicThreadData.elX.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.elX.length; i++) {
                sb.append(ap.g(cardPersonDynamicThreadData.elX[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.elX.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.eiW.setText(sb2);
                this.eiW.setVisibility(0);
            } else {
                this.eiW.setText(d.j.person_homepage);
            }
        } else {
            this.eiW.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.eiX.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.eiX.setVisibility(0);
            }
            hP(cardPersonDynamicThreadData.isPrivacy);
            this.eiY.setVisibility(0);
            this.eiY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.this.mPageContext != null) {
                        if (r.this.eiZ == null) {
                            r.this.eiZ = new q(r.this.mPageContext);
                            r.this.eiZ.create();
                            r.this.eiZ.a(r.this.ejt);
                        }
                        r.this.eiZ.a(r.this.eiE);
                        r.this.eiZ.show();
                    }
                }
            });
        } else {
            this.eiX.setVisibility(8);
            this.eiY.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.elV;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.aaa.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.aaa.setVoiceModel(voiceModel);
            this.aaa.setTag(voiceModel);
            this.aaa.bxS();
            if (voiceModel != null) {
                this.aaa.uq(voiceModel.voice_status.intValue());
            }
            this.aaa.cfz();
        } else {
            this.aaa.setVisibility(8);
            hO(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.elU;
        al.k(this.ejd, d.C0277d.transparent);
        this.eje.setVisibility(8);
        this.ejf.setVisibility(8);
        this.ejd.setVisibility(0);
        this.eja.setVisibility(8);
        this.ejl.setVisibility(8);
        this.ejg.setVisibility(8);
        this.ejj.setVisibility(8);
        this.ejk.cancelAnimation();
        this.ejk.setVisibility(8);
        if (cardPersonDynamicThreadData.elN == 36) {
            this.eia.setVisibility(8);
        } else if (cardPersonDynamicThreadData.elN == 40 || this.eiE.elN == 50) {
            this.eia.setVisibility(8);
            if (com.baidu.tbadk.core.i.Wv().Wz()) {
                this.eja.setVisibility(0);
                this.ejc.setVisibility(0);
                this.ejc.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eja.getLayoutParams();
                int width = this.eja.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.eja.setLayoutParams(layoutParams);
                if (this.eiE.videoInfo != null) {
                    this.ejb.setDefaultErrorResource(0);
                    this.ejb.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ejb.setEvent(this.cAo);
                    this.ejb.startLoad(this.eiE.videoInfo.thumbnail_url, 17, false);
                    if (this.ejq) {
                        this.ejl.setVisibility(0);
                        this.ejl.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.ejg.setVisibility(0);
                        this.ejh.setText(ap.hy(this.eiE.videoInfo.video_duration.intValue() * 1000));
                        this.eji.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.eiE.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.eiE.elN == 60 || this.eiE.elN == 49) {
            this.eia.setVisibility(8);
            if (this.eiE.threadData.Zh() != null && this.eiE.threadData.Zh().user_info != null && this.eiE.elN == 60) {
                String str = this.eiE.threadData.Zh().user_info.user_name;
                if (com.baidu.tbadk.util.ab.pO(str) > 14) {
                    str = com.baidu.tbadk.util.ab.ah(str, 14) + "...";
                }
                this.eje.setText(n.ct(str + Config.TRACE_TODAY_VISIT_SPLIT, this.eiE.threadData.getTitle()));
                this.eje.setVisibility(0);
            } else {
                this.eje.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.Wv().Wz()) {
                this.eja.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eja.getLayoutParams();
                int width2 = this.eja.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.eja.setLayoutParams(layoutParams2);
                if (this.eiE.threadData.Zh() != null) {
                    this.ejb.setDefaultErrorResource(0);
                    this.ejb.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ejb.setEvent(this.cAo);
                    this.ejb.startLoad(cardPersonDynamicThreadData.threadData.Zh().cover, 10, false);
                    this.ejc.setVisibility(8);
                    this.ejk.setVisibility(0);
                    this.ejk.cu();
                    al.k(this.ejd, d.C0277d.cp_bg_line_e);
                    this.ejj.setVisibility(0);
                    this.ejj.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.eiE.threadData.Zh().audience_count)));
                    this.drn.getCommentContainer().setOnClickListener(this.eif);
                } else {
                    this.drn.getCommentContainer().setOnClickListener(this.drn);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.Wv().Wz() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bg bgVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.S(linkedList) > 0) {
                    this.eia.setVisibility(0);
                    this.eia.setFromCDN(this.ZR);
                    this.eia.setSingleImageRatio(0.67d);
                    this.eia.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.r.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z) {
                            if (z) {
                                r.this.ajU();
                            } else {
                                r.this.a(view, linkedList, i2, bgVar);
                            }
                        }
                    });
                    this.eia.setImageMediaList(linkedList);
                } else {
                    this.eia.setVisibility(8);
                }
            } else {
                this.eia.setVisibility(8);
            }
            this.ejd.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.bDz != null) {
            this.ejn.setVisibility(0);
            this.ejn.b(cardPersonDynamicThreadData.threadData.bDz);
            this.ejn.setOnClickListener(this);
            this.aaa.setVisibility(8);
            this.eia.setVisibility(8);
            this.ejd.setVisibility(8);
            if (this.ejr) {
                this.ejm.setVisibility(0);
            } else {
                this.ejm.setVisibility(8);
            }
        } else {
            this.ejn.setVisibility(8);
            this.ejm.setVisibility(8);
        }
        aQx();
        c(cardPersonDynamicThreadData);
    }

    private void hO(boolean z) {
        if (this.eia != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eia.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.eia.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ejq || this.ejr) {
                this.drn.setCommentClickable(false);
                this.drn.setAgreeClickable(false);
                this.drn.setShareClickable(false);
                this.ejn.setClickable(false);
                this.eiY.setClickable(false);
            } else {
                this.drn.setCommentClickable(true);
                this.drn.setAgreeClickable(true);
                this.drn.setShareClickable(true);
                this.ejn.setClickable(true);
                this.eiY.setClickable(true);
            }
            this.drn.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.elN == 60) {
                this.drn.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.elX != null) {
                this.drn.setMultiForumCount(cardPersonDynamicThreadData.elX.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.drn.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.drn.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aQx() {
        this.aaa.setClickable(true);
        int childCount = this.eia.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eia.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aQA() {
        if (this.eiE != null && this.eiE.threadData != null && this.eiE.threadData.Zh() != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                n.tz(this.eiE.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.eiE.threadData.Zh());
            if (this.eiE.threadData.Zh().user_info != null) {
                alaLiveInfoCoreData.userName = this.eiE.threadData.Zh().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQB() {
        if (this.eiE != null && this.eiE.threadData != null && this.eiE.threadData.Zh() != null && this.eiE.threadData.Zh().share_info != null) {
            if (!isHost()) {
                n.tz(this.eiE.threadId);
            }
            if (this.eiE.threadData.Zh().share_info.record_tid <= 0) {
                aQA();
                return;
            }
            String valueOf = String.valueOf(this.eiE.threadData.Zh().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.eiE != null) {
            if (!isHost()) {
                n.tz(this.eiE.threadId);
                n.a(this.mTitle, this.eiE.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                n.a(this.XL, this.eiE.threadId, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.eiE.elN == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.eiE.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.eiE.threadData.getFid()));
            pbActivityConfig.setForumName(this.eiE.threadData.YT());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.eiE.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.eiE.threadData == null || !this.eiE.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").bJ("obj_type", "2").bJ("tid", this.eiE.threadId).T("obj_param1", this.eiE.isHost ? 1 : 2));
        }
    }

    private void aQC() {
        if (this.eiE != null && this.eiE.threadData != null && this.eiE.threadData.bDz != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.eiE.threadData.bDz.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").bJ("obj_type", "3").bJ("tid", this.eiE.threadId).T("obj_param1", this.eiE.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(boolean z) {
        if (this.eiX != null) {
            if (z) {
                this.eiX.setText(d.j.privacy);
                Drawable drawable = al.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.eiX.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.eiX.setText(d.j.public_open);
            Drawable drawable2 = al.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.eiX.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.eiE.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ejn) {
            aQC();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.ZR ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ejq);
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
        n.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        return true;
    }
}
