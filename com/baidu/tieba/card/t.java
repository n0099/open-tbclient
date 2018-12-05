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
    private boolean aEq;
    private TbImageView.a boV;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cUX;
    private TextView cUZ;
    private AlaPlayAnimationView cUu;
    private CustomMessageListener cUv;
    private CardPersonDynamicThreadData cVD;
    public ThreadViewAndCommentInfoLayout cVO;
    private final String cVP;
    private final String cVQ;
    private TextView cVR;
    private LinearLayout cVS;
    private TextView cVT;
    private TextView cVU;
    private TextView cVV;
    private TextView cVW;
    private ImageView cVX;
    private s cVY;
    private View cVZ;
    private ConstrainImageGroup cVa;
    private final View.OnClickListener cVd;
    private TbImageView cWa;
    private ImageView cWb;
    private LinearLayout cWc;
    private TextView cWd;
    private LinearLayout cWe;
    private LinearLayout cWf;
    private TextView cWg;
    private TextView cWh;
    private TextView cWi;
    private TextView cWj;
    private TextView cWk;
    public OriginalThreadCardView cWl;
    private View cWm;
    private View cWn;
    private boolean cWo;
    private boolean cWp;
    com.baidu.tieba.view.h cWq;
    private s.a cWr;
    private final View.OnClickListener cWs;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVP = "1";
        this.cVQ = "2";
        this.mSkinType = 3;
        this.aEq = true;
        this.cWq = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cVD != null && !StringUtils.isNull(t.this.cVD.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cVD.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.apc() != null) {
                    t.this.apc().a(view, t.this.cVD);
                }
                if (t.this.cVD.cYy != 60) {
                    if ((t.this.cVD.cYy != 40 || t.this.cVD.cYA != 2) && !t.this.cWp) {
                        t.this.apx();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).BN();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cVD.threadData.Aa().live_status != 1) {
                    t.this.apB();
                } else {
                    t.this.apA();
                }
            }
        };
        this.cUv = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cVD != null && t.this.cVD.threadId != null && t.this.mTitle != null && t.this.cUZ != null && ((String) customResponsedMessage.getData()).equals(t.this.cVD.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cVD.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cUZ, t.this.cVD.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cWr = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.fs(z);
            }
        };
        this.cWs = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> apc = t.this.apc();
                if (apc != null) {
                    view.setTag("1");
                    apc.a(view, t.this.cVD);
                }
                t.this.apx();
            }
        };
        this.cVd = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> apc = t.this.apc();
                if (apc != null) {
                    view.setTag("2");
                    apc.a(view, t.this.cVD);
                }
            }
        };
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && t.this.cWa != null) {
                    t.this.cWa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cVR = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cVS = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cVT = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cVU = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cVV = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cWk = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cVW = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cVX = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cUX = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cUX.setAfterClickListener(this.cVd);
        this.cUZ = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cUZ.setVisibility(8);
        this.cVa = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cVa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cVa.setChildClickListener(this.cWs);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cVa.setImageProcessor(eVar);
        this.cVZ = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cWa = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cWb = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cVO = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cWf = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cWg = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cWh = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cWi = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cUu = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cWj = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cWc = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cWd = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cWe = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cWe.setVisibility(8);
        this.cWl = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cWm = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cWn = this.mRootView.findViewById(e.g.divider_line_thin);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setFrom(8);
        this.caJ.setDisPraiseFrom(3);
        this.caJ.setShareReportFrom(6);
        this.caJ.setStType("person_page");
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.apc() != null) {
                    t.this.apc().a(view, t.this.cVD);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cVR, e.d.cp_cont_b);
            al.h(this.cVT, e.d.cp_cont_j);
            al.h(this.cVU, e.d.cp_cont_b);
            al.h(this.cVV, e.d.cp_cont_d);
            al.h(this.cWk, e.d.cp_cont_d);
            al.h(this.cVW, e.d.cp_cont_d);
            if (this.cVX != null) {
                this.cVX.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cUZ, e.d.cp_cont_f);
            al.h(this.cWd, e.d.cp_cont_f);
            if (this.cVY != null) {
                this.cVY.onChangeSkinType();
            }
            this.cVO.onChangeSkinType();
            this.caJ.onChangeSkinType();
            al.j(this.cWm, e.d.cp_bg_line_e);
            al.j(this.cWn, e.d.cp_bg_line_c);
            al.j(this.cWd, e.d.cp_bg_line_e);
            if (this.cWl != null) {
                this.cWl.onChangeSkinType();
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
        this.cVD = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.cVR.setVisibility(cardPersonDynamicThreadData.cYK ? 0 : 8);
        this.cVS.setVisibility(cardPersonDynamicThreadData.cYJ ? 0 : 4);
        this.cWm.setVisibility(cardPersonDynamicThreadData.cYJ ? 0 : 8);
        this.cWn.setVisibility(cardPersonDynamicThreadData.cYJ ? 8 : 0);
        if (cardPersonDynamicThreadData.cYL) {
            this.cWm.setVisibility(8);
            this.cWn.setVisibility(8);
        }
        this.cWo = cardPersonDynamicThreadData.cYy == 40 && cardPersonDynamicThreadData.cYA == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cWp = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cYA == 2;
        }
        this.cVR.setText(cardPersonDynamicThreadData.cYB);
        this.cVT.setText(cardPersonDynamicThreadData.cYC);
        this.cVU.setText(cardPersonDynamicThreadData.cYD);
        if (cardPersonDynamicThreadData.cYI != null && cardPersonDynamicThreadData.cYI.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cYI.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.cYI[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cYI.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cVV.setText(sb2);
                this.cVV.setVisibility(0);
            } else {
                this.cVV.setText(e.j.person_homepage);
            }
        } else {
            this.cVV.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cVW.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cVW.setVisibility(0);
            }
            fs(cardPersonDynamicThreadData.isPrivacy);
            this.cVX.setVisibility(0);
            this.cVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cVY == null) {
                            t.this.cVY = new s(t.this.mPageContext);
                            t.this.cVY.create();
                            t.this.cVY.a(t.this.cWr);
                        }
                        t.this.cVY.a(t.this.cVD);
                        t.this.cVY.show();
                    }
                }
            });
        } else {
            this.cVW.setVisibility(8);
            this.cVX.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cYG;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cUX.setVisibility(0);
            fr(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cUX.setVoiceModel(voiceModel);
            this.cUX.setTag(voiceModel);
            this.cUX.aWg();
            if (voiceModel != null) {
                this.cUX.qw(voiceModel.voice_status.intValue());
            }
            this.cUX.bEC();
        } else {
            this.cUX.setVisibility(8);
            fr(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cYF;
        al.i(this.cWc, e.d.transparent);
        this.cWd.setVisibility(8);
        this.cWe.setVisibility(8);
        this.cWc.setVisibility(0);
        this.cVZ.setVisibility(8);
        this.cWj.setVisibility(8);
        this.cWf.setVisibility(8);
        this.cWi.setVisibility(8);
        this.cUu.bLX();
        if (cardPersonDynamicThreadData.cYy == 36) {
            this.cVa.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cYy == 40 || this.cVD.cYy == 50) {
            this.cVa.setVisibility(8);
            if (com.baidu.tbadk.core.i.xE().xI()) {
                this.cVZ.setVisibility(0);
                this.cWb.setVisibility(0);
                this.cWb.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVZ.getLayoutParams();
                int width = this.cVZ.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0210e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cVZ.setLayoutParams(layoutParams);
                if (this.cVD.videoInfo != null) {
                    this.cWa.setDefaultErrorResource(0);
                    this.cWa.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cWa.setEvent(this.boV);
                    this.cWa.startLoad(this.cVD.videoInfo.thumbnail_url, 17, false);
                    if (this.cWo) {
                        this.cWj.setVisibility(0);
                        this.cWj.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cWf.setVisibility(0);
                        this.cWg.setText(ao.dV(this.cVD.videoInfo.video_duration.intValue() * 1000));
                        this.cWh.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.W(this.cVD.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cVD.cYy == 60 || this.cVD.cYy == 49) {
            this.cVa.setVisibility(8);
            if (this.cVD.threadData.Aa() != null && this.cVD.threadData.Aa().user_info != null && this.cVD.cYy == 60) {
                String str = this.cVD.threadData.Aa().user_info.user_name;
                if (com.baidu.tbadk.util.y.iM(str) > 14) {
                    str = com.baidu.tbadk.util.y.J(str, 14) + "...";
                }
                this.cWd.setText(o.bm(str + ":", this.cVD.threadData.getTitle()));
                this.cWd.setVisibility(0);
            } else {
                this.cWd.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xE().xI()) {
                this.cVZ.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVZ.getLayoutParams();
                int width2 = this.cVZ.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0210e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cVZ.setLayoutParams(layoutParams2);
                if (this.cVD.threadData.Aa() != null) {
                    this.cWa.setDefaultErrorResource(0);
                    this.cWa.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cWa.setEvent(this.boV);
                    this.cWa.startLoad(cardPersonDynamicThreadData.threadData.Aa().cover, 10, false);
                    this.cWb.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cUu.startPlayAnimation();
                    al.i(this.cWc, e.d.cp_bg_line_e);
                    this.cWi.setVisibility(0);
                    this.cWi.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.W(this.cVD.threadData.Aa().audience_count)));
                    this.caJ.getCommentContainer().setOnClickListener(this.cSt);
                } else {
                    this.caJ.getCommentContainer().setOnClickListener(this.caJ);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.xE().xI() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cVa.setVisibility(0);
                    this.cVa.setFromCDN(this.aEq);
                    this.cVa.setSingleImageRatio(0.67d);
                    this.cVa.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.apx();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cVa.setImageMediaList(linkedList);
                } else {
                    this.cVa.setVisibility(8);
                }
            } else {
                this.cVa.setVisibility(8);
            }
            this.cWc.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.avt != null) {
            this.cWl.setVisibility(0);
            this.cWl.b(cardPersonDynamicThreadData.threadData.avt);
            this.cWl.setOnClickListener(this);
            this.cUX.setVisibility(8);
            this.cVa.setVisibility(8);
            this.cWc.setVisibility(8);
            if (this.cWp) {
                this.cWk.setVisibility(0);
            } else {
                this.cWk.setVisibility(8);
            }
        } else {
            this.cWl.setVisibility(8);
            this.cWk.setVisibility(8);
        }
        apw();
        c(cardPersonDynamicThreadData);
    }

    private void fr(boolean z) {
        if (this.cVa != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVa.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
            }
            this.cVa.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cWo || this.cWp) {
                this.caJ.setCommentClickable(false);
                this.caJ.setAgreeClickable(false);
                this.caJ.setShareClickable(false);
                this.cWl.setClickable(false);
                this.cVX.setClickable(false);
            } else {
                this.caJ.setCommentClickable(true);
                this.caJ.setAgreeClickable(true);
                this.caJ.setShareClickable(true);
                this.cWl.setClickable(true);
                this.cVX.setClickable(true);
            }
            this.caJ.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cYy == 60) {
                this.caJ.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cYI != null) {
                this.caJ.setMultiForumCount(cardPersonDynamicThreadData.cYI.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.caJ.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.caJ.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void apw() {
        this.cUX.setClickable(true);
        int childCount = this.cVa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cVa.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void apA() {
        if (this.cVD != null && this.cVD.threadData != null && this.cVD.threadData.Aa() != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.mD(this.cVD.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cVD.threadData.Aa());
            if (this.cVD.threadData.Aa().user_info != null) {
                alaLiveInfoCoreData.userName = this.cVD.threadData.Aa().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apB() {
        if (this.cVD != null && this.cVD.threadData != null && this.cVD.threadData.Aa() != null && this.cVD.threadData.Aa().share_info != null) {
            if (!isHost()) {
                o.mD(this.cVD.threadId);
            }
            if (this.cVD.threadData.Aa().share_info.record_tid <= 0) {
                apA();
                return;
            }
            String valueOf = String.valueOf(this.cVD.threadData.Aa().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (this.cVD != null) {
            if (!isHost()) {
                o.mD(this.cVD.threadId);
                o.a(this.mTitle, this.cVD.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cUZ, this.cVD.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cVD.cYy == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cVD.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cVD.threadData.getFid()));
            pbActivityConfig.setForumName(this.cVD.threadData.zM());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cVD.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cVD.threadData == null || !this.cVD.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").aA("obj_type", "2").aA("tid", this.cVD.threadId).x("obj_param1", this.cVD.isHost ? 1 : 2));
        }
    }

    private void apC() {
        if (this.cVD != null && this.cVD.threadData != null && this.cVD.threadData.avt != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cVD.threadData.avt.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").aA("obj_type", "3").aA("tid", this.cVD.threadId).x("obj_param1", this.cVD.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.cVW != null) {
            if (z) {
                this.cVW.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cVW.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cVW.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cVW.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cVD.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWl) {
            apC();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cVa != null) {
            this.cVa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cVa != null) {
            this.cVa.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aEq ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cWo);
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
