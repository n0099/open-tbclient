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
    private boolean aAQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private TbImageView.a blx;
    private View.OnClickListener cLM;
    private AlaPlayAnimationView cNN;
    private CustomMessageListener cNO;
    private CardPersonDynamicThreadData cOW;
    public PlayVoiceBntNew cOq;
    private TextView cOs;
    private ConstrainImageGroup cOt;
    private final View.OnClickListener cOw;
    private TextView cPA;
    private TextView cPB;
    private TextView cPC;
    private TextView cPD;
    public OriginalThreadCardView cPE;
    private View cPF;
    private View cPG;
    private boolean cPH;
    private boolean cPI;
    com.baidu.tieba.view.h cPJ;
    private s.a cPK;
    private final View.OnClickListener cPL;
    public ThreadViewAndCommentInfoLayout cPh;
    private final String cPi;
    private final String cPj;
    private TextView cPk;
    private LinearLayout cPl;
    private TextView cPm;
    private TextView cPn;
    private TextView cPo;
    private TextView cPp;
    private ImageView cPq;
    private s cPr;
    private View cPs;
    private TbImageView cPt;
    private ImageView cPu;
    private LinearLayout cPv;
    private TextView cPw;
    private LinearLayout cPx;
    private LinearLayout cPy;
    private TextView cPz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cPi = "1";
        this.cPj = "2";
        this.mSkinType = 3;
        this.aAQ = true;
        this.cPJ = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cOW != null && !StringUtils.isNull(t.this.cOW.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cOW.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.anq() != null) {
                    t.this.anq().a(view, t.this.cOW);
                }
                if (t.this.cOW.cRR != 60) {
                    if ((t.this.cOW.cRR != 40 || t.this.cOW.cRT != 2) && !t.this.cPI) {
                        t.this.anK();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).AJ();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cOW.threadData.yW().live_status != 1) {
                    t.this.anO();
                } else {
                    t.this.anN();
                }
            }
        };
        this.cNO = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cOW != null && t.this.cOW.threadId != null && t.this.mTitle != null && t.this.cOs != null && ((String) customResponsedMessage.getData()).equals(t.this.cOW.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cOW.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cOs, t.this.cOW.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cPK = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.fr(z);
            }
        };
        this.cPL = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> anq = t.this.anq();
                if (anq != null) {
                    view.setTag("1");
                    anq.a(view, t.this.cOW);
                }
                t.this.anK();
            }
        };
        this.cOw = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> anq = t.this.anq();
                if (anq != null) {
                    view.setTag("2");
                    anq.a(view, t.this.cOW);
                }
            }
        };
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && t.this.cPt != null) {
                    t.this.cPt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cPk = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cPl = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cPm = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cPn = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cPo = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cPD = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cPp = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cPq = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cOq = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cOq.setAfterClickListener(this.cOw);
        this.cOs = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cOs.setVisibility(8);
        this.cOt = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cOt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20));
        this.cOt.setChildClickListener(this.cPL);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cOt.setImageProcessor(eVar);
        this.cPs = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cPt = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cPu = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cPh = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cPy = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cPz = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cPA = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cPB = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cNN = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cPC = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cPv = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cPw = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cPx = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cPx.setVisibility(8);
        this.cPE = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cPF = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cPG = this.mRootView.findViewById(e.g.divider_line_thin);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setFrom(8);
        this.bWR.setDisPraiseFrom(3);
        this.bWR.setShareReportFrom(6);
        this.bWR.setStType("person_page");
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.anq() != null) {
                    t.this.anq().a(view, t.this.cOW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cPk, e.d.cp_cont_b);
            al.h(this.cPm, e.d.cp_cont_j);
            al.h(this.cPn, e.d.cp_cont_b);
            al.h(this.cPo, e.d.cp_cont_d);
            al.h(this.cPD, e.d.cp_cont_d);
            al.h(this.cPp, e.d.cp_cont_d);
            if (this.cPq != null) {
                this.cPq.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cOs, e.d.cp_cont_f);
            al.h(this.cPw, e.d.cp_cont_f);
            if (this.cPr != null) {
                this.cPr.onChangeSkinType();
            }
            this.cPh.onChangeSkinType();
            this.bWR.onChangeSkinType();
            al.j(this.cPF, e.d.cp_bg_line_e);
            al.j(this.cPG, e.d.cp_bg_line_c);
            al.j(this.cPw, e.d.cp_bg_line_e);
            if (this.cPE != null) {
                this.cPE.onChangeSkinType();
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
        this.cOW = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        this.cPk.setVisibility(cardPersonDynamicThreadData.cSd ? 0 : 8);
        this.cPl.setVisibility(cardPersonDynamicThreadData.cSc ? 0 : 4);
        this.cPF.setVisibility(cardPersonDynamicThreadData.cSc ? 0 : 8);
        this.cPG.setVisibility(cardPersonDynamicThreadData.cSc ? 8 : 0);
        if (cardPersonDynamicThreadData.cSe) {
            this.cPF.setVisibility(8);
            this.cPG.setVisibility(8);
        }
        this.cPH = cardPersonDynamicThreadData.cRR == 40 && cardPersonDynamicThreadData.cRT == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cPI = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cRT == 2;
        }
        this.cPk.setText(cardPersonDynamicThreadData.cRU);
        this.cPm.setText(cardPersonDynamicThreadData.cRV);
        this.cPn.setText(cardPersonDynamicThreadData.cRW);
        if (cardPersonDynamicThreadData.cSb != null && cardPersonDynamicThreadData.cSb.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cSb.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.cSb[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cSb.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cPo.setText(sb2);
                this.cPo.setVisibility(0);
            } else {
                this.cPo.setText(e.j.person_homepage);
            }
        } else {
            this.cPo.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cPp.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cPp.setVisibility(0);
            }
            fr(cardPersonDynamicThreadData.isPrivacy);
            this.cPq.setVisibility(0);
            this.cPq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cPr == null) {
                            t.this.cPr = new s(t.this.mPageContext);
                            t.this.cPr.create();
                            t.this.cPr.a(t.this.cPK);
                        }
                        t.this.cPr.a(t.this.cOW);
                        t.this.cPr.show();
                    }
                }
            });
        } else {
            this.cPp.setVisibility(8);
            this.cPq.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cRZ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cOq.setVisibility(0);
            fq(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cOq.setVoiceModel(voiceModel);
            this.cOq.setTag(voiceModel);
            this.cOq.aUo();
            if (voiceModel != null) {
                this.cOq.qc(voiceModel.voice_status.intValue());
            }
            this.cOq.bCH();
        } else {
            this.cOq.setVisibility(8);
            fq(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cRY;
        al.i(this.cPv, e.d.transparent);
        this.cPw.setVisibility(8);
        this.cPx.setVisibility(8);
        this.cPv.setVisibility(0);
        this.cPs.setVisibility(8);
        this.cPC.setVisibility(8);
        this.cPy.setVisibility(8);
        this.cPB.setVisibility(8);
        this.cNN.bJS();
        if (cardPersonDynamicThreadData.cRR == 36) {
            this.cOt.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cRR == 40 || this.cOW.cRR == 50) {
            this.cOt.setVisibility(8);
            if (com.baidu.tbadk.core.i.wA().wE()) {
                this.cPs.setVisibility(0);
                this.cPu.setVisibility(0);
                this.cPu.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPs.getLayoutParams();
                int width = this.cPs.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0200e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cPs.setLayoutParams(layoutParams);
                if (this.cOW.videoInfo != null) {
                    this.cPt.setDefaultErrorResource(0);
                    this.cPt.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cPt.setEvent(this.blx);
                    this.cPt.startLoad(this.cOW.videoInfo.thumbnail_url, 17, false);
                    if (this.cPH) {
                        this.cPC.setVisibility(0);
                        this.cPC.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cPy.setVisibility(0);
                        this.cPz.setText(ao.dH(this.cOW.videoInfo.video_duration.intValue() * 1000));
                        this.cPA.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.P(this.cOW.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cOW.cRR == 60 || this.cOW.cRR == 49) {
            this.cOt.setVisibility(8);
            if (this.cOW.threadData.yW() != null && this.cOW.threadData.yW().user_info != null && this.cOW.cRR == 60) {
                String str = this.cOW.threadData.yW().user_info.user_name;
                if (com.baidu.tbadk.util.y.iu(str) > 14) {
                    str = com.baidu.tbadk.util.y.J(str, 14) + "...";
                }
                this.cPw.setText(o.bh(str + ":", this.cOW.threadData.getTitle()));
                this.cPw.setVisibility(0);
            } else {
                this.cPw.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.wA().wE()) {
                this.cPs.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cPs.getLayoutParams();
                int width2 = this.cPs.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0200e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cPs.setLayoutParams(layoutParams2);
                if (this.cOW.threadData.yW() != null) {
                    this.cPt.setDefaultErrorResource(0);
                    this.cPt.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cPt.setEvent(this.blx);
                    this.cPt.startLoad(cardPersonDynamicThreadData.threadData.yW().cover, 10, false);
                    this.cPu.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cNN.startPlayAnimation();
                    al.i(this.cPv, e.d.cp_bg_line_e);
                    this.cPB.setVisibility(0);
                    this.cPB.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.P(this.cOW.threadData.yW().audience_count)));
                    this.bWR.getCommentContainer().setOnClickListener(this.cLM);
                } else {
                    this.bWR.getCommentContainer().setOnClickListener(this.bWR);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.wA().wE() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cOt.setVisibility(0);
                    this.cOt.setFromCDN(this.aAQ);
                    this.cOt.setSingleImageRatio(0.67d);
                    this.cOt.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.anK();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cOt.setImageMediaList(linkedList);
                } else {
                    this.cOt.setVisibility(8);
                }
            } else {
                this.cOt.setVisibility(8);
            }
            this.cPv.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.arT != null) {
            this.cPE.setVisibility(0);
            this.cPE.b(cardPersonDynamicThreadData.threadData.arT);
            this.cPE.setOnClickListener(this);
            this.cOq.setVisibility(8);
            this.cOt.setVisibility(8);
            this.cPv.setVisibility(8);
            if (this.cPI) {
                this.cPD.setVisibility(0);
            } else {
                this.cPD.setVisibility(8);
            }
        } else {
            this.cPE.setVisibility(8);
            this.cPD.setVisibility(8);
        }
        anJ();
        c(cardPersonDynamicThreadData);
    }

    private void fq(boolean z) {
        if (this.cOt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOt.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20);
            }
            this.cOt.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cPH || this.cPI) {
                this.bWR.setCommentClickable(false);
                this.bWR.setAgreeClickable(false);
                this.bWR.setShareClickable(false);
                this.cPE.setClickable(false);
                this.cPq.setClickable(false);
            } else {
                this.bWR.setCommentClickable(true);
                this.bWR.setAgreeClickable(true);
                this.bWR.setShareClickable(true);
                this.cPE.setClickable(true);
                this.cPq.setClickable(true);
            }
            this.bWR.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cRR == 60) {
                this.bWR.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cSb != null) {
                this.bWR.setMultiForumCount(cardPersonDynamicThreadData.cSb.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.bWR.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.bWR.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void anJ() {
        this.cOq.setClickable(true);
        int childCount = this.cOt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cOt.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void anN() {
        if (this.cOW != null && this.cOW.threadData != null && this.cOW.threadData.yW() != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.me(this.cOW.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cOW.threadData.yW());
            if (this.cOW.threadData.yW().user_info != null) {
                alaLiveInfoCoreData.userName = this.cOW.threadData.yW().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anO() {
        if (this.cOW != null && this.cOW.threadData != null && this.cOW.threadData.yW() != null && this.cOW.threadData.yW().share_info != null) {
            if (!isHost()) {
                o.me(this.cOW.threadId);
            }
            if (this.cOW.threadData.yW().share_info.record_tid <= 0) {
                anN();
                return;
            }
            String valueOf = String.valueOf(this.cOW.threadData.yW().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anK() {
        if (this.cOW != null) {
            if (!isHost()) {
                o.me(this.cOW.threadId);
                o.a(this.mTitle, this.cOW.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cOs, this.cOW.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cOW.cRR == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cOW.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cOW.threadData.getFid()));
            pbActivityConfig.setForumName(this.cOW.threadData.yI());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cOW.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cOW.threadData == null || !this.cOW.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").ax("obj_type", "2").ax("tid", this.cOW.threadId).x("obj_param1", this.cOW.isHost ? 1 : 2));
        }
    }

    private void anP() {
        if (this.cOW != null && this.cOW.threadData != null && this.cOW.threadData.arT != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cOW.threadData.arT.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").ax("obj_type", "3").ax("tid", this.cOW.threadId).x("obj_param1", this.cOW.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(boolean z) {
        if (this.cPp != null) {
            if (z) {
                this.cPp.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cPp.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cPp.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cPp.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cOW.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cPE) {
            anP();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aAQ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yI(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAQ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cPH);
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
