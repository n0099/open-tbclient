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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class t extends a<CardPersonDynamicThreadData> {
    private boolean asR;
    public ThreadCommentAndPraiseInfoLayout bHO;
    private TbImageView.a bdc;
    private TextView cAa;
    private ImageView cAb;
    private s cAc;
    private View cAd;
    private TbImageView cAe;
    private ImageView cAf;
    private LinearLayout cAg;
    private TextView cAh;
    private LinearLayout cAi;
    private LinearLayout cAj;
    private TextView cAk;
    private TextView cAl;
    private TextView cAm;
    private TextView cAn;
    private TextView cAo;
    public OriginalThreadCardView cAp;
    private View cAq;
    private View cAr;
    private boolean cAs;
    private boolean cAt;
    com.baidu.tieba.view.h cAu;
    private s.a cAv;
    private final View.OnClickListener cAw;
    private View.OnClickListener cwy;
    private AlaPlayAnimationView cyA;
    private CustomMessageListener cyB;
    private CardPersonDynamicThreadData czH;
    public ThreadViewAndCommentInfoLayout czS;
    private final String czT;
    private final String czU;
    private TextView czV;
    private LinearLayout czW;
    private TextView czX;
    private TextView czY;
    private TextView czZ;
    public PlayVoiceBntNew czb;
    private TextView czd;
    private ConstrainImageGroup cze;
    private final View.OnClickListener czh;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.czT = "1";
        this.czU = "2";
        this.mSkinType = 3;
        this.asR = true;
        this.cAu = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.czH != null && !StringUtils.isNull(t.this.czH.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.czH.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(d.C0140d.cp_link_tip_c) : t.this.mContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            }
        };
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aiz() != null) {
                    t.this.aiz().a(view, t.this.czH);
                }
                if (t.this.czH.cCE != 60) {
                    if ((t.this.czH.cCE != 40 || t.this.czH.cCG != 2) && !t.this.cAt) {
                        t.this.aiS();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).xn();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.czH.threadData.vD().live_status != 1) {
                    t.this.aiW();
                } else {
                    t.this.aiV();
                }
            }
        };
        this.cyB = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.czH != null && t.this.czH.threadId != null && t.this.mTitle != null && t.this.czd != null && ((String) customResponsedMessage.getData()).equals(t.this.czH.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.czH.threadId, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                    o.a(t.this.czd, t.this.czH.threadId, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                }
            }
        };
        this.cAv = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.ex(z);
            }
        };
        this.cAw = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aiz = t.this.aiz();
                if (aiz != null) {
                    view.setTag("1");
                    aiz.a(view, t.this.czH);
                }
                t.this.aiS();
            }
        };
        this.czh = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aiz = t.this.aiz();
                if (aiz != null) {
                    view.setTag("2");
                    aiz.a(view, t.this.czH);
                }
            }
        };
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && t.this.cAe != null) {
                    t.this.cAe.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.czV = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.czW = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.czX = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.czY = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.czZ = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cAo = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cAa = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cAb = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.czb = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.czb.setAfterClickListener(this.czh);
        this.czd = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.czd.setVisibility(8);
        this.cze = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cze.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cze.setChildClickListener(this.cAw);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.h(1.0d);
        this.cze.setImageProcessor(eVar);
        this.cAd = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cAe = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cAf = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.czS = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cAj = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cAk = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cAl = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cAm = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cyA = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cAn = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cAg = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cAh = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cAi = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cAi.setVisibility(8);
        this.cAp = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cAq = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cAr = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwy);
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
                if (t.this.aiz() != null) {
                    t.this.aiz().a(view, t.this.czH);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.h(this.czV, d.C0140d.cp_cont_b);
            am.h(this.czX, d.C0140d.cp_cont_j);
            am.h(this.czY, d.C0140d.cp_cont_b);
            am.h(this.czZ, d.C0140d.cp_cont_d);
            am.h(this.cAo, d.C0140d.cp_cont_d);
            am.h(this.cAa, d.C0140d.cp_cont_d);
            if (this.cAb != null) {
                this.cAb.setImageDrawable(am.getDrawable(d.f.icon_card_more));
            }
            am.h(this.mTitle, d.C0140d.cp_cont_b);
            am.h(this.czd, d.C0140d.cp_cont_f);
            am.h(this.cAh, d.C0140d.cp_cont_f);
            if (this.cAc != null) {
                this.cAc.onChangeSkinType();
            }
            this.czS.onChangeSkinType();
            this.bHO.onChangeSkinType();
            am.j(this.cAq, d.C0140d.cp_bg_line_e);
            am.j(this.cAr, d.C0140d.cp_bg_line_c);
            am.j(this.cAh, d.C0140d.cp_bg_line_e);
            if (this.cAp != null) {
                this.cAp.onChangeSkinType();
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
        this.czH = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        this.czV.setVisibility(cardPersonDynamicThreadData.cCQ ? 0 : 8);
        this.czW.setVisibility(cardPersonDynamicThreadData.cCP ? 0 : 4);
        this.cAq.setVisibility(cardPersonDynamicThreadData.cCP ? 0 : 8);
        this.cAr.setVisibility(cardPersonDynamicThreadData.cCP ? 8 : 0);
        if (cardPersonDynamicThreadData.cCR) {
            this.cAq.setVisibility(8);
            this.cAr.setVisibility(8);
        }
        this.cAs = cardPersonDynamicThreadData.cCE == 40 && cardPersonDynamicThreadData.cCG == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cAt = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cCG == 2;
        }
        this.czV.setText(cardPersonDynamicThreadData.cCH);
        this.czX.setText(cardPersonDynamicThreadData.cCI);
        this.czY.setText(cardPersonDynamicThreadData.cCJ);
        if (cardPersonDynamicThreadData.cCO != null && cardPersonDynamicThreadData.cCO.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cCO.length; i++) {
                sb.append(ap.e(cardPersonDynamicThreadData.cCO[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cCO.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.czZ.setText(sb2);
                this.czZ.setVisibility(0);
            } else {
                this.czZ.setText(d.j.person_homepage);
            }
        } else {
            this.czZ.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cAa.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cAa.setVisibility(0);
            }
            ex(cardPersonDynamicThreadData.isPrivacy);
            this.cAb.setVisibility(0);
            this.cAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cAc == null) {
                            t.this.cAc = new s(t.this.mPageContext);
                            t.this.cAc.create();
                            t.this.cAc.a(t.this.cAv);
                        }
                        t.this.cAc.a(t.this.czH);
                        t.this.cAc.show();
                    }
                }
            });
        } else {
            this.cAa.setVisibility(8);
            this.cAb.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cCM;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.czb.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.czb.setVoiceModel(voiceModel);
            this.czb.setTag(voiceModel);
            this.czb.aPt();
            if (voiceModel != null) {
                this.czb.oH(voiceModel.voice_status.intValue());
            }
            this.czb.bxp();
        } else {
            this.czb.setVisibility(8);
            ew(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cCL;
        am.i(this.cAg, d.C0140d.transparent);
        this.cAh.setVisibility(8);
        this.cAi.setVisibility(8);
        this.cAg.setVisibility(0);
        this.cAd.setVisibility(8);
        this.cAn.setVisibility(8);
        this.cAj.setVisibility(8);
        this.cAm.setVisibility(8);
        this.cyA.bEo();
        if (cardPersonDynamicThreadData.cCE == 36) {
            this.cze.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cCE == 40 || this.czH.cCE == 50) {
            this.cze.setVisibility(8);
            if (com.baidu.tbadk.core.i.te().tk()) {
                this.cAd.setVisibility(0);
                this.cAf.setVisibility(0);
                this.cAf.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAd.getLayoutParams();
                int width = this.cAd.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cAd.setLayoutParams(layoutParams);
                if (this.czH.videoInfo != null) {
                    this.cAe.setDefaultErrorResource(0);
                    this.cAe.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cAe.setEvent(this.bdc);
                    this.cAe.startLoad(this.czH.videoInfo.thumbnail_url, 17, false);
                    if (this.cAs) {
                        this.cAn.setVisibility(0);
                        this.cAn.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.cAj.setVisibility(0);
                        this.cAk.setText(ap.da(this.czH.videoInfo.video_duration.intValue() * 1000));
                        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.H(this.czH.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.czH.cCE == 60 || this.czH.cCE == 49) {
            this.cze.setVisibility(8);
            if (this.czH.threadData.vD() != null && this.czH.threadData.vD().user_info != null && this.czH.cCE == 60) {
                String str = this.czH.threadData.vD().user_info.user_name;
                if (com.baidu.tbadk.util.w.hI(str) > 14) {
                    str = com.baidu.tbadk.util.w.D(str, 14) + "...";
                }
                this.cAh.setText(o.aM(str + SystemInfoUtil.COLON, this.czH.threadData.getTitle()));
                this.cAh.setVisibility(0);
            } else {
                this.cAh.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.te().tk()) {
                this.cAd.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAd.getLayoutParams();
                int width2 = this.cAd.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cAd.setLayoutParams(layoutParams2);
                if (this.czH.threadData.vD() != null) {
                    this.cAe.setDefaultErrorResource(0);
                    this.cAe.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cAe.setEvent(this.bdc);
                    this.cAe.startLoad(cardPersonDynamicThreadData.threadData.vD().cover, 10, false);
                    this.cAf.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cyA.startPlayAnimation();
                    am.i(this.cAg, d.C0140d.cp_bg_line_e);
                    this.cAm.setVisibility(0);
                    this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), ap.H(this.czH.threadData.vD().audience_count)));
                    this.bHO.getCommentContainer().setOnClickListener(this.cwy);
                } else {
                    this.bHO.getCommentContainer().setOnClickListener(this.bHO);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.te().tk() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.y(linkedList) > 0) {
                    this.cze.setVisibility(0);
                    this.cze.setFromCDN(this.asR);
                    this.cze.setSingleImageRatio(0.67d);
                    this.cze.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                t.this.aiS();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cze.setImageMediaList(linkedList);
                } else {
                    this.cze.setVisibility(8);
                }
            } else {
                this.cze.setVisibility(8);
            }
            this.cAg.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.ajH != null) {
            this.cAp.setVisibility(0);
            this.cAp.b(cardPersonDynamicThreadData.threadData.ajH);
            this.cAp.setOnClickListener(this);
            this.czb.setVisibility(8);
            this.cze.setVisibility(8);
            this.cAg.setVisibility(8);
            if (this.cAt) {
                this.cAo.setVisibility(0);
            } else {
                this.cAo.setVisibility(8);
            }
        } else {
            this.cAp.setVisibility(8);
            this.cAo.setVisibility(8);
        }
        aiR();
        c(cardPersonDynamicThreadData);
    }

    private void ew(boolean z) {
        if (this.cze != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cze.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cze.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cAs || this.cAt) {
                this.bHO.setCommentClickable(false);
                this.bHO.setAgreeClickable(false);
                this.bHO.setShareClickable(false);
                this.cAp.setClickable(false);
                this.cAb.setClickable(false);
            } else {
                this.bHO.setCommentClickable(true);
                this.bHO.setAgreeClickable(true);
                this.bHO.setShareClickable(true);
                this.cAp.setClickable(true);
                this.cAb.setClickable(true);
            }
            this.bHO.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cCE == 60) {
                this.bHO.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cCO != null) {
                this.bHO.setMultiForumCount(cardPersonDynamicThreadData.cCO.length);
            }
            this.bHO.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aiR() {
        this.czb.setClickable(true);
        int childCount = this.cze.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cze.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aiV() {
        if (this.czH != null && this.czH.threadData != null && this.czH.threadData.vD() != null) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.kW(this.czH.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.czH.threadData.vD());
            if (this.czH.threadData.vD().user_info != null) {
                alaLiveInfoCoreData.userName = this.czH.threadData.vD().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiW() {
        if (this.czH != null && this.czH.threadData != null && this.czH.threadData.vD() != null && this.czH.threadData.vD().share_info != null) {
            if (!isHost()) {
                o.kW(this.czH.threadId);
            }
            if (this.czH.threadData.vD().share_info.record_tid <= 0) {
                aiV();
                return;
            }
            String valueOf = String.valueOf(this.czH.threadData.vD().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiS() {
        if (this.czH != null) {
            if (!isHost()) {
                o.kW(this.czH.threadId);
                o.a(this.mTitle, this.czH.threadId, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                o.a(this.czd, this.czH.threadId, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.czH.cCE == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.czH.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.czH.threadData.getFid()));
            pbActivityConfig.setForumName(this.czH.threadData.vq());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.czH.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.czH.threadData == null || !this.czH.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").af("obj_type", "2").af("tid", this.czH.threadId).r("obj_param1", this.czH.isHost ? 1 : 2));
        }
    }

    private void aiX() {
        if (this.czH != null && this.czH.threadData != null && this.czH.threadData.ajH != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.czH.threadData.ajH.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").af("obj_type", "3").af("tid", this.czH.threadId).r("obj_param1", this.czH.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(boolean z) {
        if (this.cAa != null) {
            if (z) {
                this.cAa.setText(d.j.privacy);
                Drawable drawable = am.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cAa.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cAa.setText(d.j.public_open);
            Drawable drawable2 = am.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cAa.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.czH.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cAp) {
            aiX();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cze != null) {
            this.cze.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cze != null) {
            this.cze.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
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
                imageUrlData.urlType = this.asR ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vq(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cAs);
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
        o.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        return true;
    }
}
