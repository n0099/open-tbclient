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
    private boolean aEU;
    private TbImageView.a bpN;
    private View.OnClickListener cVV;
    private AlaPlayAnimationView cXW;
    private CustomMessageListener cXX;
    private TextView cYB;
    private ConstrainImageGroup cYC;
    private final View.OnClickListener cYF;
    public PlayVoiceBntNew cYz;
    private s cZA;
    private View cZB;
    private TbImageView cZC;
    private ImageView cZD;
    private LinearLayout cZE;
    private TextView cZF;
    private LinearLayout cZG;
    private LinearLayout cZH;
    private TextView cZI;
    private TextView cZJ;
    private TextView cZK;
    private TextView cZL;
    private TextView cZM;
    public OriginalThreadCardView cZN;
    private View cZO;
    private View cZP;
    private boolean cZQ;
    private boolean cZR;
    com.baidu.tieba.view.h cZS;
    private s.a cZT;
    private final View.OnClickListener cZU;
    private CardPersonDynamicThreadData cZf;
    public ThreadViewAndCommentInfoLayout cZq;
    private final String cZr;
    private final String cZs;
    private TextView cZt;
    private LinearLayout cZu;
    private TextView cZv;
    private TextView cZw;
    private TextView cZx;
    private TextView cZy;
    private ImageView cZz;
    public ThreadCommentAndPraiseInfoLayout cby;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cZr = "1";
        this.cZs = "2";
        this.mSkinType = 3;
        this.aEU = true;
        this.cZS = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cZf != null && !StringUtils.isNull(t.this.cZf.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cZf.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aqp() != null) {
                    t.this.aqp().a(view, t.this.cZf);
                }
                if (t.this.cZf.dcd != 60) {
                    if ((t.this.cZf.dcd != 40 || t.this.cZf.dcf != 2) && !t.this.cZR) {
                        t.this.aqJ();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).Ca();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cZf.threadData.An().live_status != 1) {
                    t.this.aqN();
                } else {
                    t.this.aqM();
                }
            }
        };
        this.cXX = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cZf != null && t.this.cZf.threadId != null && t.this.mTitle != null && t.this.cYB != null && ((String) customResponsedMessage.getData()).equals(t.this.cZf.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cZf.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cYB, t.this.cZf.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cZT = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.fx(z);
            }
        };
        this.cZU = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aqp = t.this.aqp();
                if (aqp != null) {
                    view.setTag("1");
                    aqp.a(view, t.this.cZf);
                }
                t.this.aqJ();
            }
        };
        this.cYF = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aqp = t.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, t.this.cZf);
                }
            }
        };
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && t.this.cZC != null) {
                    t.this.cZC.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cZt = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cZu = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cZv = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cZw = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cZx = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cZM = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cZy = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cZz = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cYz = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cYz.setAfterClickListener(this.cYF);
        this.cYB = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cYB.setVisibility(8);
        this.cYC = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cYC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cYC.setChildClickListener(this.cZU);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYC.setImageProcessor(eVar);
        this.cZB = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cZC = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cZD = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cZq = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cZH = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cZI = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cZJ = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cZK = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cXW = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cZL = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cZE = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cZF = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cZG = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cZG.setVisibility(8);
        this.cZN = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cZO = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cZP = this.mRootView.findViewById(e.g.divider_line_thin);
        this.cby = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this.cVV);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setIsBarViewVisible(false);
        this.cby.setFrom(8);
        this.cby.setDisPraiseFrom(3);
        this.cby.setShareReportFrom(6);
        this.cby.setStType("person_page");
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aqp() != null) {
                    t.this.aqp().a(view, t.this.cZf);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cZt, e.d.cp_cont_b);
            al.h(this.cZv, e.d.cp_cont_j);
            al.h(this.cZw, e.d.cp_cont_b);
            al.h(this.cZx, e.d.cp_cont_d);
            al.h(this.cZM, e.d.cp_cont_d);
            al.h(this.cZy, e.d.cp_cont_d);
            if (this.cZz != null) {
                this.cZz.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cYB, e.d.cp_cont_f);
            al.h(this.cZF, e.d.cp_cont_f);
            if (this.cZA != null) {
                this.cZA.onChangeSkinType();
            }
            this.cZq.onChangeSkinType();
            this.cby.onChangeSkinType();
            al.j(this.cZO, e.d.cp_bg_line_e);
            al.j(this.cZP, e.d.cp_bg_line_c);
            al.j(this.cZF, e.d.cp_bg_line_e);
            if (this.cZN != null) {
                this.cZN.onChangeSkinType();
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
        this.cZf = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        this.cZt.setVisibility(cardPersonDynamicThreadData.dcp ? 0 : 8);
        this.cZu.setVisibility(cardPersonDynamicThreadData.dco ? 0 : 4);
        this.cZO.setVisibility(cardPersonDynamicThreadData.dco ? 0 : 8);
        this.cZP.setVisibility(cardPersonDynamicThreadData.dco ? 8 : 0);
        if (cardPersonDynamicThreadData.dcq) {
            this.cZO.setVisibility(8);
            this.cZP.setVisibility(8);
        }
        this.cZQ = cardPersonDynamicThreadData.dcd == 40 && cardPersonDynamicThreadData.dcf == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cZR = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.dcf == 2;
        }
        this.cZt.setText(cardPersonDynamicThreadData.dcg);
        this.cZv.setText(cardPersonDynamicThreadData.dch);
        this.cZw.setText(cardPersonDynamicThreadData.dci);
        if (cardPersonDynamicThreadData.dcn != null && cardPersonDynamicThreadData.dcn.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.dcn.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.dcn[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.dcn.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cZx.setText(sb2);
                this.cZx.setVisibility(0);
            } else {
                this.cZx.setText(e.j.person_homepage);
            }
        } else {
            this.cZx.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cZy.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cZy.setVisibility(0);
            }
            fx(cardPersonDynamicThreadData.isPrivacy);
            this.cZz.setVisibility(0);
            this.cZz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cZA == null) {
                            t.this.cZA = new s(t.this.mPageContext);
                            t.this.cZA.create();
                            t.this.cZA.a(t.this.cZT);
                        }
                        t.this.cZA.a(t.this.cZf);
                        t.this.cZA.show();
                    }
                }
            });
        } else {
            this.cZy.setVisibility(8);
            this.cZz.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.dcl;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cYz.setVisibility(0);
            fw(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cYz.setVoiceModel(voiceModel);
            this.cYz.setTag(voiceModel);
            this.cYz.aXt();
            if (voiceModel != null) {
                this.cYz.qK(voiceModel.voice_status.intValue());
            }
            this.cYz.bGc();
        } else {
            this.cYz.setVisibility(8);
            fw(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.dck;
        al.i(this.cZE, e.d.transparent);
        this.cZF.setVisibility(8);
        this.cZG.setVisibility(8);
        this.cZE.setVisibility(0);
        this.cZB.setVisibility(8);
        this.cZL.setVisibility(8);
        this.cZH.setVisibility(8);
        this.cZK.setVisibility(8);
        this.cXW.bNu();
        if (cardPersonDynamicThreadData.dcd == 36) {
            this.cYC.setVisibility(8);
        } else if (cardPersonDynamicThreadData.dcd == 40 || this.cZf.dcd == 50) {
            this.cYC.setVisibility(8);
            if (com.baidu.tbadk.core.i.xR().xV()) {
                this.cZB.setVisibility(0);
                this.cZD.setVisibility(0);
                this.cZD.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cZB.getLayoutParams();
                int width = this.cZB.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0210e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cZB.setLayoutParams(layoutParams);
                if (this.cZf.videoInfo != null) {
                    this.cZC.setDefaultErrorResource(0);
                    this.cZC.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cZC.setEvent(this.bpN);
                    this.cZC.startLoad(this.cZf.videoInfo.thumbnail_url, 17, false);
                    if (this.cZQ) {
                        this.cZL.setVisibility(0);
                        this.cZL.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cZH.setVisibility(0);
                        this.cZI.setText(ao.dV(this.cZf.videoInfo.video_duration.intValue() * 1000));
                        this.cZJ.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cZf.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cZf.dcd == 60 || this.cZf.dcd == 49) {
            this.cYC.setVisibility(8);
            if (this.cZf.threadData.An() != null && this.cZf.threadData.An().user_info != null && this.cZf.dcd == 60) {
                String str = this.cZf.threadData.An().user_info.user_name;
                if (com.baidu.tbadk.util.z.jd(str) > 14) {
                    str = com.baidu.tbadk.util.z.K(str, 14) + "...";
                }
                this.cZF.setText(o.bn(str + ":", this.cZf.threadData.getTitle()));
                this.cZF.setVisibility(0);
            } else {
                this.cZF.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xR().xV()) {
                this.cZB.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cZB.getLayoutParams();
                int width2 = this.cZB.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0210e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cZB.setLayoutParams(layoutParams2);
                if (this.cZf.threadData.An() != null) {
                    this.cZC.setDefaultErrorResource(0);
                    this.cZC.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cZC.setEvent(this.bpN);
                    this.cZC.startLoad(cardPersonDynamicThreadData.threadData.An().cover, 10, false);
                    this.cZD.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cXW.startPlayAnimation();
                    al.i(this.cZE, e.d.cp_bg_line_e);
                    this.cZK.setVisibility(0);
                    this.cZK.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cZf.threadData.An().audience_count)));
                    this.cby.getCommentContainer().setOnClickListener(this.cVV);
                } else {
                    this.cby.getCommentContainer().setOnClickListener(this.cby);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.xR().xV() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bb bbVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cYC.setVisibility(0);
                    this.cYC.setFromCDN(this.aEU);
                    this.cYC.setSingleImageRatio(0.67d);
                    this.cYC.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.aqJ();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cYC.setImageMediaList(linkedList);
                } else {
                    this.cYC.setVisibility(8);
                }
            } else {
                this.cYC.setVisibility(8);
            }
            this.cZE.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.avW != null) {
            this.cZN.setVisibility(0);
            this.cZN.b(cardPersonDynamicThreadData.threadData.avW);
            this.cZN.setOnClickListener(this);
            this.cYz.setVisibility(8);
            this.cYC.setVisibility(8);
            this.cZE.setVisibility(8);
            if (this.cZR) {
                this.cZM.setVisibility(0);
            } else {
                this.cZM.setVisibility(8);
            }
        } else {
            this.cZN.setVisibility(8);
            this.cZM.setVisibility(8);
        }
        aqI();
        c(cardPersonDynamicThreadData);
    }

    private void fw(boolean z) {
        if (this.cYC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYC.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
            }
            this.cYC.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cZQ || this.cZR) {
                this.cby.setCommentClickable(false);
                this.cby.setAgreeClickable(false);
                this.cby.setShareClickable(false);
                this.cZN.setClickable(false);
                this.cZz.setClickable(false);
            } else {
                this.cby.setCommentClickable(true);
                this.cby.setAgreeClickable(true);
                this.cby.setShareClickable(true);
                this.cZN.setClickable(true);
                this.cZz.setClickable(true);
            }
            this.cby.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.dcd == 60) {
                this.cby.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.dcn != null) {
                this.cby.setMultiForumCount(cardPersonDynamicThreadData.dcn.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.cby.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.cby.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aqI() {
        this.cYz.setClickable(true);
        int childCount = this.cYC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aqM() {
        if (this.cZf != null && this.cZf.threadData != null && this.cZf.threadData.An() != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.mW(this.cZf.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cZf.threadData.An());
            if (this.cZf.threadData.An().user_info != null) {
                alaLiveInfoCoreData.userName = this.cZf.threadData.An().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqN() {
        if (this.cZf != null && this.cZf.threadData != null && this.cZf.threadData.An() != null && this.cZf.threadData.An().share_info != null) {
            if (!isHost()) {
                o.mW(this.cZf.threadId);
            }
            if (this.cZf.threadData.An().share_info.record_tid <= 0) {
                aqM();
                return;
            }
            String valueOf = String.valueOf(this.cZf.threadData.An().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        if (this.cZf != null) {
            if (!isHost()) {
                o.mW(this.cZf.threadId);
                o.a(this.mTitle, this.cZf.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cYB, this.cZf.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cZf.dcd == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cZf.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cZf.threadData.getFid()));
            pbActivityConfig.setForumName(this.cZf.threadData.zZ());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cZf.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cZf.threadData == null || !this.cZf.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").aB("obj_type", "2").aB("tid", this.cZf.threadId).y("obj_param1", this.cZf.isHost ? 1 : 2));
        }
    }

    private void aqO() {
        if (this.cZf != null && this.cZf.threadData != null && this.cZf.threadData.avW != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cZf.threadData.avW.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").aB("obj_type", "3").aB("tid", this.cZf.threadId).y("obj_param1", this.cZf.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(boolean z) {
        if (this.cZy != null) {
            if (z) {
                this.cZy.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cZy.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cZy.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cZy.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cZf.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cZN) {
            aqO();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aEU ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cZQ);
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
