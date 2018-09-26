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
    private boolean avq;
    public ThreadCommentAndPraiseInfoLayout bND;
    private TbImageView.a bgx;
    private View.OnClickListener cCl;
    public PlayVoiceBntNew cEQ;
    private TextView cES;
    private ConstrainImageGroup cET;
    private final View.OnClickListener cEW;
    private AlaPlayAnimationView cEn;
    private CustomMessageListener cEo;
    public ThreadViewAndCommentInfoLayout cFH;
    private final String cFI;
    private final String cFJ;
    private TextView cFK;
    private LinearLayout cFL;
    private TextView cFM;
    private TextView cFN;
    private TextView cFO;
    private TextView cFP;
    private ImageView cFQ;
    private s cFR;
    private View cFS;
    private TbImageView cFT;
    private ImageView cFU;
    private LinearLayout cFV;
    private TextView cFW;
    private LinearLayout cFX;
    private LinearLayout cFY;
    private TextView cFZ;
    private CardPersonDynamicThreadData cFw;
    private TextView cGa;
    private TextView cGb;
    private TextView cGc;
    private TextView cGd;
    public OriginalThreadCardView cGe;
    private View cGf;
    private View cGg;
    private boolean cGh;
    private boolean cGi;
    com.baidu.tieba.view.h cGj;
    private s.a cGk;
    private final View.OnClickListener cGl;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cFI = "1";
        this.cFJ = "2";
        this.mSkinType = 3;
        this.avq = true;
        this.cGj = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cFw != null && !StringUtils.isNull(t.this.cFw.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cFw.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.akm() != null) {
                    t.this.akm().a(view, t.this.cFw);
                }
                if (t.this.cFw.cIs != 60) {
                    if ((t.this.cFw.cIs != 40 || t.this.cFw.cIu != 2) && !t.this.cGi) {
                        t.this.akG();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).yt();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cFw.threadData.wG().live_status != 1) {
                    t.this.akK();
                } else {
                    t.this.akJ();
                }
            }
        };
        this.cEo = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cFw != null && t.this.cFw.threadId != null && t.this.mTitle != null && t.this.cES != null && ((String) customResponsedMessage.getData()).equals(t.this.cFw.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cFw.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cES, t.this.cFw.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cGk = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.eO(z);
            }
        };
        this.cGl = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> akm = t.this.akm();
                if (akm != null) {
                    view.setTag("1");
                    akm.a(view, t.this.cFw);
                }
                t.this.akG();
            }
        };
        this.cEW = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> akm = t.this.akm();
                if (akm != null) {
                    view.setTag("2");
                    akm.a(view, t.this.cFw);
                }
            }
        };
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && t.this.cFT != null) {
                    t.this.cFT.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cFK = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cFL = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cFM = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cFN = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cFO = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cGd = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cFP = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cFQ = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cEQ = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cEQ.setAfterClickListener(this.cEW);
        this.cES = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cES.setVisibility(8);
        this.cET = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cET.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20));
        this.cET.setChildClickListener(this.cGl);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cET.setImageProcessor(eVar);
        this.cFS = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cFT = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cFU = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cFH = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cFY = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cFZ = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cGa = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cGb = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cEn = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cGc = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cFV = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cFW = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cFX = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cFX.setVisibility(8);
        this.cGe = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cGf = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cGg = this.mRootView.findViewById(e.g.divider_line_thin);
        this.bND = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setIsBarViewVisible(false);
        this.bND.setFrom(8);
        this.bND.setDisPraiseFrom(3);
        this.bND.setShareReportFrom(6);
        this.bND.setStType("person_page");
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.akm() != null) {
                    t.this.akm().a(view, t.this.cFw);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cFK, e.d.cp_cont_b);
            al.h(this.cFM, e.d.cp_cont_j);
            al.h(this.cFN, e.d.cp_cont_b);
            al.h(this.cFO, e.d.cp_cont_d);
            al.h(this.cGd, e.d.cp_cont_d);
            al.h(this.cFP, e.d.cp_cont_d);
            if (this.cFQ != null) {
                this.cFQ.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cES, e.d.cp_cont_f);
            al.h(this.cFW, e.d.cp_cont_f);
            if (this.cFR != null) {
                this.cFR.onChangeSkinType();
            }
            this.cFH.onChangeSkinType();
            this.bND.onChangeSkinType();
            al.j(this.cGf, e.d.cp_bg_line_e);
            al.j(this.cGg, e.d.cp_bg_line_c);
            al.j(this.cFW, e.d.cp_bg_line_e);
            if (this.cGe != null) {
                this.cGe.onChangeSkinType();
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
        this.cFw = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        this.cFK.setVisibility(cardPersonDynamicThreadData.cIE ? 0 : 8);
        this.cFL.setVisibility(cardPersonDynamicThreadData.cID ? 0 : 4);
        this.cGf.setVisibility(cardPersonDynamicThreadData.cID ? 0 : 8);
        this.cGg.setVisibility(cardPersonDynamicThreadData.cID ? 8 : 0);
        if (cardPersonDynamicThreadData.cIF) {
            this.cGf.setVisibility(8);
            this.cGg.setVisibility(8);
        }
        this.cGh = cardPersonDynamicThreadData.cIs == 40 && cardPersonDynamicThreadData.cIu == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cGi = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cIu == 2;
        }
        this.cFK.setText(cardPersonDynamicThreadData.cIv);
        this.cFM.setText(cardPersonDynamicThreadData.cIw);
        this.cFN.setText(cardPersonDynamicThreadData.cIx);
        if (cardPersonDynamicThreadData.cIC != null && cardPersonDynamicThreadData.cIC.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cIC.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.cIC[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cIC.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cFO.setText(sb2);
                this.cFO.setVisibility(0);
            } else {
                this.cFO.setText(e.j.person_homepage);
            }
        } else {
            this.cFO.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cFP.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cFP.setVisibility(0);
            }
            eO(cardPersonDynamicThreadData.isPrivacy);
            this.cFQ.setVisibility(0);
            this.cFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cFR == null) {
                            t.this.cFR = new s(t.this.mPageContext);
                            t.this.cFR.create();
                            t.this.cFR.a(t.this.cGk);
                        }
                        t.this.cFR.a(t.this.cFw);
                        t.this.cFR.show();
                    }
                }
            });
        } else {
            this.cFP.setVisibility(8);
            this.cFQ.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cIA;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cEQ.setVisibility(0);
            eN(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cEQ.setVoiceModel(voiceModel);
            this.cEQ.setTag(voiceModel);
            this.cEQ.aRD();
            if (voiceModel != null) {
                this.cEQ.pl(voiceModel.voice_status.intValue());
            }
            this.cEQ.bzY();
        } else {
            this.cEQ.setVisibility(8);
            eN(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cIz;
        al.i(this.cFV, e.d.transparent);
        this.cFW.setVisibility(8);
        this.cFX.setVisibility(8);
        this.cFV.setVisibility(0);
        this.cFS.setVisibility(8);
        this.cGc.setVisibility(8);
        this.cFY.setVisibility(8);
        this.cGb.setVisibility(8);
        this.cEn.bHh();
        if (cardPersonDynamicThreadData.cIs == 36) {
            this.cET.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cIs == 40 || this.cFw.cIs == 50) {
            this.cET.setVisibility(8);
            if (com.baidu.tbadk.core.i.uj().un()) {
                this.cFS.setVisibility(0);
                this.cFU.setVisibility(0);
                this.cFU.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cFS.getLayoutParams();
                int width = this.cFS.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0141e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cFS.setLayoutParams(layoutParams);
                if (this.cFw.videoInfo != null) {
                    this.cFT.setDefaultErrorResource(0);
                    this.cFT.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cFT.setEvent(this.bgx);
                    this.cFT.startLoad(this.cFw.videoInfo.thumbnail_url, 17, false);
                    if (this.cGh) {
                        this.cGc.setVisibility(0);
                        this.cGc.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cFY.setVisibility(0);
                        this.cFZ.setText(ao.dj(this.cFw.videoInfo.video_duration.intValue() * 1000));
                        this.cGa.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.L(this.cFw.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cFw.cIs == 60 || this.cFw.cIs == 49) {
            this.cET.setVisibility(8);
            if (this.cFw.threadData.wG() != null && this.cFw.threadData.wG().user_info != null && this.cFw.cIs == 60) {
                String str = this.cFw.threadData.wG().user_info.user_name;
                if (com.baidu.tbadk.util.y.ig(str) > 14) {
                    str = com.baidu.tbadk.util.y.I(str, 14) + "...";
                }
                this.cFW.setText(o.aU(str + ":", this.cFw.threadData.getTitle()));
                this.cFW.setVisibility(0);
            } else {
                this.cFW.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.uj().un()) {
                this.cFS.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cFS.getLayoutParams();
                int width2 = this.cFS.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0141e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cFS.setLayoutParams(layoutParams2);
                if (this.cFw.threadData.wG() != null) {
                    this.cFT.setDefaultErrorResource(0);
                    this.cFT.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cFT.setEvent(this.bgx);
                    this.cFT.startLoad(cardPersonDynamicThreadData.threadData.wG().cover, 10, false);
                    this.cFU.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cEn.startPlayAnimation();
                    al.i(this.cFV, e.d.cp_bg_line_e);
                    this.cGb.setVisibility(0);
                    this.cGb.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.L(this.cFw.threadData.wG().audience_count)));
                    this.bND.getCommentContainer().setOnClickListener(this.cCl);
                } else {
                    this.bND.getCommentContainer().setOnClickListener(this.bND);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.uj().un() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.y(linkedList) > 0) {
                    this.cET.setVisibility(0);
                    this.cET.setFromCDN(this.avq);
                    this.cET.setSingleImageRatio(0.67d);
                    this.cET.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.akG();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cET.setImageMediaList(linkedList);
                } else {
                    this.cET.setVisibility(8);
                }
            } else {
                this.cET.setVisibility(8);
            }
            this.cFV.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aml != null) {
            this.cGe.setVisibility(0);
            this.cGe.b(cardPersonDynamicThreadData.threadData.aml);
            this.cGe.setOnClickListener(this);
            this.cEQ.setVisibility(8);
            this.cET.setVisibility(8);
            this.cFV.setVisibility(8);
            if (this.cGi) {
                this.cGd.setVisibility(0);
            } else {
                this.cGd.setVisibility(8);
            }
        } else {
            this.cGe.setVisibility(8);
            this.cGd.setVisibility(8);
        }
        akF();
        c(cardPersonDynamicThreadData);
    }

    private void eN(boolean z) {
        if (this.cET != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cET.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20);
            }
            this.cET.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cGh || this.cGi) {
                this.bND.setCommentClickable(false);
                this.bND.setAgreeClickable(false);
                this.bND.setShareClickable(false);
                this.cGe.setClickable(false);
                this.cFQ.setClickable(false);
            } else {
                this.bND.setCommentClickable(true);
                this.bND.setAgreeClickable(true);
                this.bND.setShareClickable(true);
                this.cGe.setClickable(true);
                this.cFQ.setClickable(true);
            }
            this.bND.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cIs == 60) {
                this.bND.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cIC != null) {
                this.bND.setMultiForumCount(cardPersonDynamicThreadData.cIC.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.bND.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.bND.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void akF() {
        this.cEQ.setClickable(true);
        int childCount = this.cET.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cET.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void akJ() {
        if (this.cFw != null && this.cFw.threadData != null && this.cFw.threadData.wG() != null) {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.lA(this.cFw.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cFw.threadData.wG());
            if (this.cFw.threadData.wG().user_info != null) {
                alaLiveInfoCoreData.userName = this.cFw.threadData.wG().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akK() {
        if (this.cFw != null && this.cFw.threadData != null && this.cFw.threadData.wG() != null && this.cFw.threadData.wG().share_info != null) {
            if (!isHost()) {
                o.lA(this.cFw.threadId);
            }
            if (this.cFw.threadData.wG().share_info.record_tid <= 0) {
                akJ();
                return;
            }
            String valueOf = String.valueOf(this.cFw.threadData.wG().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        if (this.cFw != null) {
            if (!isHost()) {
                o.lA(this.cFw.threadId);
                o.a(this.mTitle, this.cFw.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cES, this.cFw.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cFw.cIs == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cFw.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cFw.threadData.getFid()));
            pbActivityConfig.setForumName(this.cFw.threadData.ws());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cFw.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cFw.threadData == null || !this.cFw.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").al("obj_type", "2").al("tid", this.cFw.threadId).w("obj_param1", this.cFw.isHost ? 1 : 2));
        }
    }

    private void akL() {
        if (this.cFw != null && this.cFw.threadData != null && this.cFw.threadData.aml != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cFw.threadData.aml.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").al("obj_type", "3").al("tid", this.cFw.threadId).w("obj_param1", this.cFw.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(boolean z) {
        if (this.cFP != null) {
            if (z) {
                this.cFP.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cFP.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cFP.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cFP.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cFw.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cGe) {
            akL();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cET != null) {
            this.cET.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cET != null) {
            this.cET.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.avq ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.ws(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.avq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cGh);
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
