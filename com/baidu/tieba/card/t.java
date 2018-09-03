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
import com.baidu.ar.util.SystemInfoUtil;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.s;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class t extends a<CardPersonDynamicThreadData> {
    private boolean asS;
    public ThreadCommentAndPraiseInfoLayout bHO;
    private TbImageView.a bdc;
    private View cAa;
    private TbImageView cAb;
    private ImageView cAc;
    private LinearLayout cAd;
    private TextView cAe;
    private LinearLayout cAf;
    private LinearLayout cAg;
    private TextView cAh;
    private TextView cAi;
    private TextView cAj;
    private TextView cAk;
    private TextView cAl;
    public OriginalThreadCardView cAm;
    private View cAn;
    private View cAo;
    private boolean cAp;
    private boolean cAq;
    com.baidu.tieba.view.h cAr;
    private s.a cAs;
    private final View.OnClickListener cAt;
    private View.OnClickListener cwv;
    public PlayVoiceBntNew cyY;
    private AlaPlayAnimationView cyx;
    private CustomMessageListener cyy;
    private CardPersonDynamicThreadData czE;
    public ThreadViewAndCommentInfoLayout czP;
    private final String czQ;
    private final String czR;
    private TextView czS;
    private LinearLayout czT;
    private TextView czU;
    private TextView czV;
    private TextView czW;
    private TextView czX;
    private ImageView czY;
    private s czZ;
    private TextView cza;
    private ConstrainImageGroup czb;
    private final View.OnClickListener cze;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.czQ = "1";
        this.czR = "2";
        this.mSkinType = 3;
        this.asS = true;
        this.cAr = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.czE != null && !StringUtils.isNull(t.this.czE.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.czE.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(f.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(f.d.cp_link_tip_a));
            }
        };
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aiC() != null) {
                    t.this.aiC().a(view, t.this.czE);
                }
                if (t.this.czE.cCB != 60) {
                    if ((t.this.czE.cCB != 40 || t.this.czE.cCD != 2) && !t.this.cAq) {
                        t.this.aiV();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(f.j.video_check_click_msg), f.C0146f.icon_toast_game_error).xm();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.czE.threadData.vC().live_status != 1) {
                    t.this.aiZ();
                } else {
                    t.this.aiY();
                }
            }
        };
        this.cyy = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.czE != null && t.this.czE.threadId != null && t.this.mTitle != null && t.this.cza != null && ((String) customResponsedMessage.getData()).equals(t.this.czE.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.czE.threadId, f.d.cp_cont_b, f.d.cp_cont_d);
                    o.a(t.this.cza, t.this.czE.threadId, f.d.cp_cont_j, f.d.cp_cont_d);
                }
            }
        };
        this.cAs = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.ex(z);
            }
        };
        this.cAt = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aiC = t.this.aiC();
                if (aiC != null) {
                    view.setTag("1");
                    aiC.a(view, t.this.czE);
                }
                t.this.aiV();
            }
        };
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aiC = t.this.aiC();
                if (aiC != null) {
                    view.setTag("2");
                    aiC.a(view, t.this.czE);
                }
            }
        };
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && t.this.cAb != null) {
                    t.this.cAb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.czS = (TextView) this.mRootView.findViewById(f.g.year_num);
        this.czT = (LinearLayout) this.mRootView.findViewById(f.g.left_time_view);
        this.czU = (TextView) this.mRootView.findViewById(f.g.month_num);
        this.czV = (TextView) this.mRootView.findViewById(f.g.day_num);
        this.czW = (TextView) this.mRootView.findViewById(f.g.source_bar);
        this.cAl = (TextView) this.mRootView.findViewById(f.g.video_under_review);
        this.czX = (TextView) this.mRootView.findViewById(f.g.tv_privacy_status);
        this.czY = (ImageView) this.mRootView.findViewById(f.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(f.g.thread_title);
        this.cyY = (PlayVoiceBntNew) this.mRootView.findViewById(f.g.card_dynamic_thread_abstract_voice);
        this.cyY.setAfterClickListener(this.cze);
        this.cza = (TextView) this.mRootView.findViewById(f.g.thread_content);
        this.cza.setVisibility(8);
        this.czb = (ConstrainImageGroup) this.mRootView.findViewById(f.g.card_dynamic_thread_img_layout);
        this.czb.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20));
        this.czb.setChildClickListener(this.cAt);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.czb.setImageProcessor(eVar);
        this.cAa = this.mRootView.findViewById(f.g.thread_view_img_container);
        this.cAb = (TbImageView) this.mRootView.findViewById(f.g.thread_video_thumbnail);
        this.cAc = (ImageView) this.mRootView.findViewById(f.g.thread_img_pause_play);
        this.czP = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(f.g.card_dynamic_thread_info_layout);
        this.cAg = (LinearLayout) this.mRootView.findViewById(f.g.duration_container);
        this.cAh = (TextView) this.mRootView.findViewById(f.g.video_duration);
        this.cAi = (TextView) this.mRootView.findViewById(f.g.video_play_count);
        this.cAj = (TextView) this.mRootView.findViewById(f.g.audience_count);
        this.cyx = (AlaPlayAnimationView) this.mRootView.findViewById(f.g.ala_play);
        this.cAk = (TextView) this.mRootView.findViewById(f.g.fake_video_state);
        this.cAd = (LinearLayout) this.mRootView.findViewById(f.g.shared_ala_live_layout);
        this.cAe = (TextView) this.mRootView.findViewById(f.g.shared_ala_live_room_title);
        this.cAf = (LinearLayout) this.mRootView.findViewById(f.g.llAlaLivingLogLayout);
        this.cAf.setVisibility(8);
        this.cAm = (OriginalThreadCardView) this.mRootView.findViewById(f.g.original_thread_info);
        this.cAn = this.mRootView.findViewById(f.g.divider_line_thick);
        this.cAo = this.mRootView.findViewById(f.g.divider_line_thin);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(f.g.card_thread_info_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwv);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setFrom(8);
        this.bHO.setShareReportFrom(6);
        this.bHO.setStType("person_page");
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aiC() != null) {
                    t.this.aiC().a(view, t.this.czE);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.home_thread_card_item_bg);
            am.h(this.czS, f.d.cp_cont_b);
            am.h(this.czU, f.d.cp_cont_j);
            am.h(this.czV, f.d.cp_cont_b);
            am.h(this.czW, f.d.cp_cont_d);
            am.h(this.cAl, f.d.cp_cont_d);
            am.h(this.czX, f.d.cp_cont_d);
            if (this.czY != null) {
                this.czY.setImageDrawable(am.getDrawable(f.C0146f.icon_card_more));
            }
            am.h(this.mTitle, f.d.cp_cont_b);
            am.h(this.cza, f.d.cp_cont_f);
            am.h(this.cAe, f.d.cp_cont_f);
            if (this.czZ != null) {
                this.czZ.onChangeSkinType();
            }
            this.czP.onChangeSkinType();
            this.bHO.onChangeSkinType();
            am.j(this.cAn, f.d.cp_bg_line_e);
            am.j(this.cAo, f.d.cp_bg_line_c);
            am.j(this.cAe, f.d.cp_bg_line_e);
            if (this.cAm != null) {
                this.cAm.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_person_dynamic_thread;
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
        this.czE = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        this.czS.setVisibility(cardPersonDynamicThreadData.cCN ? 0 : 8);
        this.czT.setVisibility(cardPersonDynamicThreadData.cCM ? 0 : 4);
        this.cAn.setVisibility(cardPersonDynamicThreadData.cCM ? 0 : 8);
        this.cAo.setVisibility(cardPersonDynamicThreadData.cCM ? 8 : 0);
        if (cardPersonDynamicThreadData.cCO) {
            this.cAn.setVisibility(8);
            this.cAo.setVisibility(8);
        }
        this.cAp = cardPersonDynamicThreadData.cCB == 40 && cardPersonDynamicThreadData.cCD == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cAq = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cCD == 2;
        }
        this.czS.setText(cardPersonDynamicThreadData.cCE);
        this.czU.setText(cardPersonDynamicThreadData.cCF);
        this.czV.setText(cardPersonDynamicThreadData.cCG);
        if (cardPersonDynamicThreadData.cCL != null && cardPersonDynamicThreadData.cCL.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cCL.length; i++) {
                sb.append(ap.d(cardPersonDynamicThreadData.cCL[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cCL.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(f.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(f.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.czW.setText(sb2);
                this.czW.setVisibility(0);
            } else {
                this.czW.setText(f.j.person_homepage);
            }
        } else {
            this.czW.setText(f.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.czX.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.czX.setVisibility(0);
            }
            ex(cardPersonDynamicThreadData.isPrivacy);
            this.czY.setVisibility(0);
            this.czY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.czZ == null) {
                            t.this.czZ = new s(t.this.mPageContext);
                            t.this.czZ.create();
                            t.this.czZ.a(t.this.cAs);
                        }
                        t.this.czZ.a(t.this.czE);
                        t.this.czZ.show();
                    }
                }
            });
        } else {
            this.czX.setVisibility(8);
            this.czY.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cCJ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cyY.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cyY.setVoiceModel(voiceModel);
            this.cyY.setTag(voiceModel);
            this.cyY.aPq();
            if (voiceModel != null) {
                this.cyY.oH(voiceModel.voice_status.intValue());
            }
            this.cyY.bxq();
        } else {
            this.cyY.setVisibility(8);
            ew(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cCI;
        am.i(this.cAd, f.d.transparent);
        this.cAe.setVisibility(8);
        this.cAf.setVisibility(8);
        this.cAd.setVisibility(0);
        this.cAa.setVisibility(8);
        this.cAk.setVisibility(8);
        this.cAg.setVisibility(8);
        this.cAj.setVisibility(8);
        this.cyx.bEq();
        if (cardPersonDynamicThreadData.cCB == 36) {
            this.czb.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cCB == 40 || this.czE.cCB == 50) {
            this.czb.setVisibility(8);
            if (com.baidu.tbadk.core.i.td().tj()) {
                this.cAa.setVisibility(0);
                this.cAc.setVisibility(0);
                this.cAc.setImageResource(f.C0146f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAa.getLayoutParams();
                int width = this.cAa.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(f.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cAa.setLayoutParams(layoutParams);
                if (this.czE.videoInfo != null) {
                    this.cAb.setDefaultErrorResource(0);
                    this.cAb.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                    this.cAb.setEvent(this.bdc);
                    this.cAb.startLoad(this.czE.videoInfo.thumbnail_url, 17, false);
                    if (this.cAp) {
                        this.cAk.setVisibility(0);
                        this.cAk.setText(String.format(this.mContext.getResources().getString(f.j.video_review_state), new Object[0]));
                    } else {
                        this.cAg.setVisibility(0);
                        this.cAh.setText(ap.da(this.czE.videoInfo.video_duration.intValue() * 1000));
                        this.cAi.setText(String.format(this.mContext.getResources().getString(f.j.play_count), ap.H(this.czE.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.czE.cCB == 60 || this.czE.cCB == 49) {
            this.czb.setVisibility(8);
            if (this.czE.threadData.vC() != null && this.czE.threadData.vC().user_info != null && this.czE.cCB == 60) {
                String str = this.czE.threadData.vC().user_info.user_name;
                if (com.baidu.tbadk.util.w.hI(str) > 14) {
                    str = com.baidu.tbadk.util.w.D(str, 14) + "...";
                }
                this.cAe.setText(o.aM(str + SystemInfoUtil.COLON, this.czE.threadData.getTitle()));
                this.cAe.setVisibility(0);
            } else {
                this.cAe.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.td().tj()) {
                this.cAa.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAa.getLayoutParams();
                int width2 = this.cAa.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(f.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cAa.setLayoutParams(layoutParams2);
                if (this.czE.threadData.vC() != null) {
                    this.cAb.setDefaultErrorResource(0);
                    this.cAb.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                    this.cAb.setEvent(this.bdc);
                    this.cAb.startLoad(cardPersonDynamicThreadData.threadData.vC().cover, 10, false);
                    this.cAc.setImageResource(f.C0146f.btn_icon_play_live_on_n);
                    this.cyx.startPlayAnimation();
                    am.i(this.cAd, f.d.cp_bg_line_e);
                    this.cAj.setVisibility(0);
                    this.cAj.setText(String.format(this.mContext.getResources().getString(f.j.ala_audience_count_prefix), ap.H(this.czE.threadData.vC().audience_count)));
                    this.bHO.getCommentContainer().setOnClickListener(this.cwv);
                } else {
                    this.bHO.getCommentContainer().setOnClickListener(this.bHO);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.td().tj() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.y(linkedList) > 0) {
                    this.czb.setVisibility(0);
                    this.czb.setFromCDN(this.asS);
                    this.czb.setSingleImageRatio(0.67d);
                    this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.aiV();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.czb.setImageMediaList(linkedList);
                } else {
                    this.czb.setVisibility(8);
                }
            } else {
                this.czb.setVisibility(8);
            }
            this.cAd.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.ajH != null) {
            this.cAm.setVisibility(0);
            this.cAm.b(cardPersonDynamicThreadData.threadData.ajH);
            this.cAm.setOnClickListener(this);
            this.cyY.setVisibility(8);
            this.czb.setVisibility(8);
            this.cAd.setVisibility(8);
            if (this.cAq) {
                this.cAl.setVisibility(0);
            } else {
                this.cAl.setVisibility(8);
            }
        } else {
            this.cAm.setVisibility(8);
            this.cAl.setVisibility(8);
        }
        aiU();
        c(cardPersonDynamicThreadData);
    }

    private void ew(boolean z) {
        if (this.czb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20);
            }
            this.czb.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cAp || this.cAq) {
                this.bHO.setCommentClickable(false);
                this.bHO.setAgreeClickable(false);
                this.bHO.setShareClickable(false);
                this.cAm.setClickable(false);
                this.czY.setClickable(false);
            } else {
                this.bHO.setCommentClickable(true);
                this.bHO.setAgreeClickable(true);
                this.bHO.setShareClickable(true);
                this.cAm.setClickable(true);
                this.czY.setClickable(true);
            }
            this.bHO.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cCB == 60) {
                this.bHO.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cCL != null) {
                this.bHO.setMultiForumCount(cardPersonDynamicThreadData.cCL.length);
            }
            this.bHO.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aiU() {
        this.cyY.setClickable(true);
        int childCount = this.czb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.czb.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aiY() {
        if (this.czE != null && this.czE.threadData != null && this.czE.threadData.vC() != null) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), f.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.kY(this.czE.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.czE.threadData.vC());
            if (this.czE.threadData.vC().user_info != null) {
                alaLiveInfoCoreData.userName = this.czE.threadData.vC().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiZ() {
        if (this.czE != null && this.czE.threadData != null && this.czE.threadData.vC() != null && this.czE.threadData.vC().share_info != null) {
            if (!isHost()) {
                o.kY(this.czE.threadId);
            }
            if (this.czE.threadData.vC().share_info.record_tid <= 0) {
                aiY();
                return;
            }
            String valueOf = String.valueOf(this.czE.threadData.vC().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        if (this.czE != null) {
            if (!isHost()) {
                o.kY(this.czE.threadId);
                o.a(this.mTitle, this.czE.threadId, f.d.cp_cont_b, f.d.cp_cont_d);
                o.a(this.cza, this.czE.threadId, f.d.cp_cont_j, f.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.czE.cCB == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.czE.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.czE.threadData.getFid()));
            pbActivityConfig.setForumName(this.czE.threadData.vp());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.czE.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.czE.threadData == null || !this.czE.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").ae("obj_type", "2").ae("tid", this.czE.threadId).r("obj_param1", this.czE.isHost ? 1 : 2));
        }
    }

    private void aja() {
        if (this.czE != null && this.czE.threadData != null && this.czE.threadData.ajH != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.czE.threadData.ajH.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").ae("obj_type", "3").ae("tid", this.czE.threadId).r("obj_param1", this.czE.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(boolean z) {
        if (this.czX != null) {
            if (z) {
                this.czX.setText(f.j.privacy);
                Drawable drawable = am.getDrawable(f.C0146f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.czX.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.czX.setText(f.j.public_open);
            Drawable drawable2 = am.getDrawable(f.C0146f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.czX.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.czE.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cAm) {
            aja();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.czb != null) {
            this.czb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.czb != null) {
            this.czb.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.asS ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vp(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asS, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cAp);
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
        o.a(this.mTitle, cardPersonDynamicThreadData.threadId, f.d.cp_cont_b, f.d.cp_cont_d);
        return true;
    }
}
