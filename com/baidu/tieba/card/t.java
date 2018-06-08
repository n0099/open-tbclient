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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class t extends a<CardPersonDynamicThreadData> {
    private boolean asK;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private final View.OnClickListener cAa;
    private View.OnClickListener cvP;
    private AlaPlayAnimationView cxT;
    private CustomMessageListener cxU;
    public PlayVoiceBntNew cyE;
    private TextView cyG;
    private ConstrainImageGroup cyH;
    private final View.OnClickListener cyK;
    private TbImageView.a cyq;
    private LinearLayout czA;
    private TextView czB;
    private TextView czC;
    private TextView czD;
    private TextView czE;
    private ImageView czF;
    private s czG;
    private View czH;
    private TbImageView czI;
    private ImageView czJ;
    private LinearLayout czK;
    private TextView czL;
    private LinearLayout czM;
    private LinearLayout czN;
    private TextView czO;
    private TextView czP;
    private TextView czQ;
    private TextView czR;
    private TextView czS;
    public OriginalThreadCardView czT;
    private View czU;
    private View czV;
    private boolean czW;
    private boolean czX;
    com.baidu.tieba.view.h czY;
    private s.a czZ;
    private CardPersonDynamicThreadData czl;
    public ThreadViewAndCommentInfoLayout czw;
    private final String czx;
    private final String czy;
    private TextView czz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.czx = "1";
        this.czy = "2";
        this.mSkinType = 3;
        this.asK = true;
        this.czY = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.czl != null && !StringUtils.isNull(t.this.czl.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.czl.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(d.C0141d.cp_link_tip_c) : t.this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            }
        };
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aiI() != null) {
                    t.this.aiI().a(view, t.this.czl);
                }
                if (t.this.czl.cCf != 60) {
                    if ((t.this.czl.cCf != 40 || t.this.czl.cCh != 2) && !t.this.czX) {
                        t.this.ajb();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(d.k.video_check_click_msg), d.f.icon_toast_game_error).xi();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.czl.threadData.vE().live_status != 1) {
                    t.this.ajf();
                } else {
                    t.this.aje();
                }
            }
        };
        this.cxU = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.czl != null && t.this.czl.threadId != null && t.this.mTitle != null && t.this.cyG != null && ((String) customResponsedMessage.getData()).equals(t.this.czl.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.czl.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                    o.a(t.this.cyG, t.this.czl.threadId, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                }
            }
        };
        this.czZ = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.ex(z);
            }
        };
        this.cAa = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aiI = t.this.aiI();
                if (aiI != null) {
                    view.setTag("1");
                    aiI.a(view, t.this.czl);
                }
                t.this.ajb();
            }
        };
        this.cyK = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<CardPersonDynamicThreadData> aiI = t.this.aiI();
                if (aiI != null) {
                    view.setTag("2");
                    aiI.a(view, t.this.czl);
                }
            }
        };
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && t.this.czI != null) {
                    t.this.czI.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.czz = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.czA = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.czB = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.czC = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.czD = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.czS = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.czE = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.czF = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cyE = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cyE.setAfterClickListener(this.cyK);
        this.cyG = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cyG.setVisibility(8);
        this.cyH = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cyH.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cyH.setChildClickListener(this.cAa);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.j(1.0d);
        this.cyH.setImageProcessor(eVar);
        this.czH = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.czI = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.czJ = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.czw = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.czN = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.czO = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.czP = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.czQ = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cxT = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.czR = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.czK = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.czL = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.czM = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.czM.setVisibility(8);
        this.czT = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.czU = this.mRootView.findViewById(d.g.divider_line_thick);
        this.czV = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setFrom(8);
        this.bFe.setShareReportFrom(6);
        this.bFe.setStType("person_page");
        this.bFe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aiI() != null) {
                    t.this.aiI().a(view, t.this.czl);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.home_thread_card_item_bg);
            al.h(this.czz, d.C0141d.cp_cont_b);
            al.h(this.czB, d.C0141d.cp_cont_j);
            al.h(this.czC, d.C0141d.cp_cont_b);
            al.h(this.czD, d.C0141d.cp_cont_d);
            al.h(this.czS, d.C0141d.cp_cont_d);
            al.h(this.czE, d.C0141d.cp_cont_d);
            if (this.czF != null) {
                this.czF.setImageDrawable(al.getDrawable(d.f.icon_card_more));
            }
            al.h(this.mTitle, d.C0141d.cp_cont_b);
            al.h(this.cyG, d.C0141d.cp_cont_f);
            al.h(this.czL, d.C0141d.cp_cont_f);
            if (this.czG != null) {
                this.czG.onChangeSkinType();
            }
            this.czw.onChangeSkinType();
            this.bFe.onChangeSkinType();
            al.j(this.czU, d.C0141d.cp_bg_line_e);
            al.j(this.czV, d.C0141d.cp_bg_line_c);
            al.j(this.czL, d.C0141d.cp_bg_line_e);
            if (this.czT != null) {
                this.czT.onChangeSkinType();
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
        this.czl = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        this.czz.setVisibility(cardPersonDynamicThreadData.cCr ? 0 : 8);
        this.czA.setVisibility(cardPersonDynamicThreadData.cCq ? 0 : 4);
        this.czU.setVisibility(cardPersonDynamicThreadData.cCq ? 0 : 8);
        this.czV.setVisibility(cardPersonDynamicThreadData.cCq ? 8 : 0);
        if (cardPersonDynamicThreadData.cCs) {
            this.czU.setVisibility(8);
            this.czV.setVisibility(8);
        }
        this.czW = cardPersonDynamicThreadData.cCf == 40 && cardPersonDynamicThreadData.cCh == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.czX = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cCh == 2;
        }
        this.czz.setText(cardPersonDynamicThreadData.cCi);
        this.czB.setText(cardPersonDynamicThreadData.cCj);
        this.czC.setText(cardPersonDynamicThreadData.cCk);
        if (cardPersonDynamicThreadData.cCp != null && cardPersonDynamicThreadData.cCp.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cCp.length; i++) {
                sb.append(ao.e(cardPersonDynamicThreadData.cCp[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cCp.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.k.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.k.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.czD.setText(sb2);
                this.czD.setVisibility(0);
            } else {
                this.czD.setText(d.k.person_homepage);
            }
        } else {
            this.czD.setText(d.k.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.czE.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.czE.setVisibility(0);
            }
            ex(cardPersonDynamicThreadData.isPrivacy);
            this.czF.setVisibility(0);
            this.czF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.czG == null) {
                            t.this.czG = new s(t.this.mPageContext);
                            t.this.czG.create();
                            t.this.czG.a(t.this.czZ);
                        }
                        t.this.czG.a(t.this.czl);
                        t.this.czG.show();
                    }
                }
            });
        } else {
            this.czE.setVisibility(8);
            this.czF.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cCn;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cyE.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cyE.setVoiceModel(voiceModel);
            this.cyE.setTag(voiceModel);
            this.cyE.aNN();
            if (voiceModel != null) {
                this.cyE.om(voiceModel.voice_status.intValue());
            }
            this.cyE.byi();
        } else {
            this.cyE.setVisibility(8);
            ew(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cCm;
        al.i(this.czK, d.C0141d.transparent);
        this.czL.setVisibility(8);
        this.czM.setVisibility(8);
        this.czK.setVisibility(0);
        this.czH.setVisibility(8);
        this.czR.setVisibility(8);
        this.czN.setVisibility(8);
        this.czQ.setVisibility(8);
        this.cxT.bFd();
        if (cardPersonDynamicThreadData.cCf == 36) {
            this.cyH.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cCf == 40 || this.czl.cCf == 50) {
            this.cyH.setVisibility(8);
            if (com.baidu.tbadk.core.i.tt().tz()) {
                this.czH.setVisibility(0);
                this.czJ.setVisibility(0);
                this.czJ.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czH.getLayoutParams();
                int width = this.czH.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.czH.setLayoutParams(layoutParams);
                if (this.czl.videoInfo != null) {
                    this.czI.setDefaultErrorResource(0);
                    this.czI.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.czI.setEvent(this.cyq);
                    this.czI.startLoad(this.czl.videoInfo.thumbnail_url, 17, false);
                    if (this.czW) {
                        this.czR.setVisibility(0);
                        this.czR.setText(String.format(this.mContext.getResources().getString(d.k.video_review_state), new Object[0]));
                    } else {
                        this.czN.setVisibility(0);
                        this.czO.setText(ao.cX(this.czl.videoInfo.video_duration.intValue() * 1000));
                        this.czP.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ao.E(this.czl.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.czl.cCf == 60 || this.czl.cCf == 49) {
            this.cyH.setVisibility(8);
            if (this.czl.threadData.vE() != null && this.czl.threadData.vE().user_info != null && this.czl.cCf == 60) {
                String str = this.czl.threadData.vE().user_info.user_name;
                if (com.baidu.tbadk.util.x.hH(str) > 14) {
                    str = com.baidu.tbadk.util.x.I(str, 14) + "...";
                }
                this.czL.setText(o.aO(str + SystemInfoUtil.COLON, this.czl.threadData.getTitle()));
                this.czL.setVisibility(0);
            } else {
                this.czL.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.tt().tz()) {
                this.czH.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.czH.getLayoutParams();
                int width2 = this.czH.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.czH.setLayoutParams(layoutParams2);
                if (this.czl.threadData.vE() != null) {
                    this.czI.setDefaultErrorResource(0);
                    this.czI.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.czI.setEvent(this.cyq);
                    this.czI.startLoad(cardPersonDynamicThreadData.threadData.vE().cover, 10, false);
                    this.czJ.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cxT.startPlayAnimation();
                    al.i(this.czK, d.C0141d.cp_bg_line_e);
                    this.czQ.setVisibility(0);
                    this.czQ.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), ao.E(this.czl.threadData.vE().audience_count)));
                    this.bFe.getCommentContainer().setOnClickListener(this.cvP);
                } else {
                    this.bFe.getCommentContainer().setOnClickListener(this.bFe);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.tt().tz() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.y(linkedList) > 0) {
                    this.cyH.setVisibility(0);
                    this.cyH.setFromCDN(this.asK);
                    this.cyH.setSingleImageRatio(0.67d);
                    this.cyH.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                t.this.ajb();
                            } else {
                                t.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.cyH.setImageMediaList(linkedList);
                } else {
                    this.cyH.setVisibility(8);
                }
            } else {
                this.cyH.setVisibility(8);
            }
            this.czK.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.ajP != null) {
            this.czT.setVisibility(0);
            this.czT.b(cardPersonDynamicThreadData.threadData.ajP);
            this.czT.setOnClickListener(this);
            this.cyE.setVisibility(8);
            this.cyH.setVisibility(8);
            this.czK.setVisibility(8);
            if (this.czX) {
                this.czS.setVisibility(0);
            } else {
                this.czS.setVisibility(8);
            }
        } else {
            this.czT.setVisibility(8);
            this.czS.setVisibility(8);
        }
        aja();
        c(cardPersonDynamicThreadData);
    }

    private void ew(boolean z) {
        if (this.cyH != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyH.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cyH.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.czW || this.czX) {
                this.bFe.setCommentClickable(false);
                this.bFe.setAgreeClickable(false);
                this.bFe.setShareClickable(false);
                this.czT.setClickable(false);
                this.czF.setClickable(false);
            } else {
                this.bFe.setCommentClickable(true);
                this.bFe.setAgreeClickable(true);
                this.bFe.setShareClickable(true);
                this.czT.setClickable(true);
                this.czF.setClickable(true);
            }
            this.bFe.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cCf == 60) {
                this.bFe.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cCp != null) {
                this.bFe.setMultiForumCount(cardPersonDynamicThreadData.cCp.length);
            }
            this.bFe.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aja() {
        this.cyE.setClickable(true);
        int childCount = this.cyH.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cyH.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aje() {
        if (this.czl != null && this.czl.threadData != null && this.czl.threadData.vE() != null) {
            if (!com.baidu.adp.lib.util.j.jD()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.lb(this.czl.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.czl.threadData.vE());
            if (this.czl.threadData.vE().user_info != null) {
                alaLiveInfoCoreData.userName = this.czl.threadData.vE().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajf() {
        if (this.czl != null && this.czl.threadData != null && this.czl.threadData.vE() != null && this.czl.threadData.vE().share_info != null) {
            if (!isHost()) {
                o.lb(this.czl.threadId);
            }
            if (this.czl.threadData.vE().share_info.record_tid <= 0) {
                aje();
                return;
            }
            String valueOf = String.valueOf(this.czl.threadData.vE().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        if (this.czl != null) {
            if (!isHost()) {
                o.lb(this.czl.threadId);
                o.a(this.mTitle, this.czl.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                o.a(this.cyG, this.czl.threadId, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.czl.cCf == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.czl.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.czl.threadData.getFid()));
            pbActivityConfig.setForumName(this.czl.threadData.vr());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.czl.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.czl.threadData == null || !this.czl.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").ah("obj_type", "2").ah("tid", this.czl.threadId).r("obj_param1", this.czl.isHost ? 1 : 2));
        }
    }

    private void ajg() {
        if (this.czl != null && this.czl.threadData != null && this.czl.threadData.ajP != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.czl.threadData.ajP.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").ah("obj_type", "3").ah("tid", this.czl.threadId).r("obj_param1", this.czl.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(boolean z) {
        if (this.czE != null) {
            if (z) {
                this.czE.setText(d.k.privacy);
                Drawable drawable = al.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.czE.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.czE.setText(d.k.public_open);
            Drawable drawable2 = al.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.czE.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.czl.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czT) {
            ajg();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cyH != null) {
            this.cyH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cyH != null) {
            this.cyH.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                imageUrlData.urlType = this.asK ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.vr(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.asK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.czW);
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
        o.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        return true;
    }
}
