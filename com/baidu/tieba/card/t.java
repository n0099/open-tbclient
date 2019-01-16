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
    private boolean aET;
    private TbImageView.a bpM;
    private View.OnClickListener cVU;
    private AlaPlayAnimationView cXV;
    private CustomMessageListener cXW;
    private TextView cYA;
    private ConstrainImageGroup cYB;
    private final View.OnClickListener cYE;
    public PlayVoiceBntNew cYy;
    private View cZA;
    private TbImageView cZB;
    private ImageView cZC;
    private LinearLayout cZD;
    private TextView cZE;
    private LinearLayout cZF;
    private LinearLayout cZG;
    private TextView cZH;
    private TextView cZI;
    private TextView cZJ;
    private TextView cZK;
    private TextView cZL;
    public OriginalThreadCardView cZM;
    private View cZN;
    private View cZO;
    private boolean cZP;
    private boolean cZQ;
    com.baidu.tieba.view.h cZR;
    private s.a cZS;
    private final View.OnClickListener cZT;
    private CardPersonDynamicThreadData cZe;
    public ThreadViewAndCommentInfoLayout cZp;
    private final String cZq;
    private final String cZr;
    private TextView cZs;
    private LinearLayout cZt;
    private TextView cZu;
    private TextView cZv;
    private TextView cZw;
    private TextView cZx;
    private ImageView cZy;
    private s cZz;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cZq = "1";
        this.cZr = "2";
        this.mSkinType = 3;
        this.aET = true;
        this.cZR = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cZe != null && !StringUtils.isNull(t.this.cZe.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cZe.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aqp() != null) {
                    t.this.aqp().a(view, t.this.cZe);
                }
                if (t.this.cZe.dcc != 60) {
                    if ((t.this.cZe.dcc != 40 || t.this.cZe.dce != 2) && !t.this.cZQ) {
                        t.this.aqJ();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).Ca();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cZe.threadData.An().live_status != 1) {
                    t.this.aqN();
                } else {
                    t.this.aqM();
                }
            }
        };
        this.cXW = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cZe != null && t.this.cZe.threadId != null && t.this.mTitle != null && t.this.cYA != null && ((String) customResponsedMessage.getData()).equals(t.this.cZe.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cZe.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cYA, t.this.cZe.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cZS = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.fx(z);
            }
        };
        this.cZT = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aqp = t.this.aqp();
                if (aqp != null) {
                    view.setTag("1");
                    aqp.a(view, t.this.cZe);
                }
                t.this.aqJ();
            }
        };
        this.cYE = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aqp = t.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, t.this.cZe);
                }
            }
        };
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && t.this.cZB != null) {
                    t.this.cZB.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cZs = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cZt = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cZu = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cZv = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cZw = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cZL = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cZx = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cZy = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cYy = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cYy.setAfterClickListener(this.cYE);
        this.cYA = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cYA.setVisibility(8);
        this.cYB = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cYB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cYB.setChildClickListener(this.cZT);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYB.setImageProcessor(eVar);
        this.cZA = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cZB = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cZC = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cZp = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cZG = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cZH = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cZI = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cZJ = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cXV = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cZK = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cZD = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cZE = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cZF = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cZF.setVisibility(8);
        this.cZM = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cZN = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cZO = this.mRootView.findViewById(e.g.divider_line_thin);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setFrom(8);
        this.cbx.setDisPraiseFrom(3);
        this.cbx.setShareReportFrom(6);
        this.cbx.setStType("person_page");
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aqp() != null) {
                    t.this.aqp().a(view, t.this.cZe);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cZs, e.d.cp_cont_b);
            al.h(this.cZu, e.d.cp_cont_j);
            al.h(this.cZv, e.d.cp_cont_b);
            al.h(this.cZw, e.d.cp_cont_d);
            al.h(this.cZL, e.d.cp_cont_d);
            al.h(this.cZx, e.d.cp_cont_d);
            if (this.cZy != null) {
                this.cZy.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cYA, e.d.cp_cont_f);
            al.h(this.cZE, e.d.cp_cont_f);
            if (this.cZz != null) {
                this.cZz.onChangeSkinType();
            }
            this.cZp.onChangeSkinType();
            this.cbx.onChangeSkinType();
            al.j(this.cZN, e.d.cp_bg_line_e);
            al.j(this.cZO, e.d.cp_bg_line_c);
            al.j(this.cZE, e.d.cp_bg_line_e);
            if (this.cZM != null) {
                this.cZM.onChangeSkinType();
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
        this.cZe = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        this.cZs.setVisibility(cardPersonDynamicThreadData.dco ? 0 : 8);
        this.cZt.setVisibility(cardPersonDynamicThreadData.dcn ? 0 : 4);
        this.cZN.setVisibility(cardPersonDynamicThreadData.dcn ? 0 : 8);
        this.cZO.setVisibility(cardPersonDynamicThreadData.dcn ? 8 : 0);
        if (cardPersonDynamicThreadData.dcp) {
            this.cZN.setVisibility(8);
            this.cZO.setVisibility(8);
        }
        this.cZP = cardPersonDynamicThreadData.dcc == 40 && cardPersonDynamicThreadData.dce == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cZQ = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.dce == 2;
        }
        this.cZs.setText(cardPersonDynamicThreadData.dcf);
        this.cZu.setText(cardPersonDynamicThreadData.dcg);
        this.cZv.setText(cardPersonDynamicThreadData.dch);
        if (cardPersonDynamicThreadData.dcm != null && cardPersonDynamicThreadData.dcm.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.dcm.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.dcm[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.dcm.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cZw.setText(sb2);
                this.cZw.setVisibility(0);
            } else {
                this.cZw.setText(e.j.person_homepage);
            }
        } else {
            this.cZw.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cZx.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cZx.setVisibility(0);
            }
            fx(cardPersonDynamicThreadData.isPrivacy);
            this.cZy.setVisibility(0);
            this.cZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cZz == null) {
                            t.this.cZz = new s(t.this.mPageContext);
                            t.this.cZz.create();
                            t.this.cZz.a(t.this.cZS);
                        }
                        t.this.cZz.a(t.this.cZe);
                        t.this.cZz.show();
                    }
                }
            });
        } else {
            this.cZx.setVisibility(8);
            this.cZy.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.dck;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cYy.setVisibility(0);
            fw(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cYy.setVoiceModel(voiceModel);
            this.cYy.setTag(voiceModel);
            this.cYy.aXt();
            if (voiceModel != null) {
                this.cYy.qK(voiceModel.voice_status.intValue());
            }
            this.cYy.bGc();
        } else {
            this.cYy.setVisibility(8);
            fw(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.dcj;
        al.i(this.cZD, e.d.transparent);
        this.cZE.setVisibility(8);
        this.cZF.setVisibility(8);
        this.cZD.setVisibility(0);
        this.cZA.setVisibility(8);
        this.cZK.setVisibility(8);
        this.cZG.setVisibility(8);
        this.cZJ.setVisibility(8);
        this.cXV.bNu();
        if (cardPersonDynamicThreadData.dcc == 36) {
            this.cYB.setVisibility(8);
        } else if (cardPersonDynamicThreadData.dcc == 40 || this.cZe.dcc == 50) {
            this.cYB.setVisibility(8);
            if (com.baidu.tbadk.core.i.xR().xV()) {
                this.cZA.setVisibility(0);
                this.cZC.setVisibility(0);
                this.cZC.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cZA.getLayoutParams();
                int width = this.cZA.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0210e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cZA.setLayoutParams(layoutParams);
                if (this.cZe.videoInfo != null) {
                    this.cZB.setDefaultErrorResource(0);
                    this.cZB.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cZB.setEvent(this.bpM);
                    this.cZB.startLoad(this.cZe.videoInfo.thumbnail_url, 17, false);
                    if (this.cZP) {
                        this.cZK.setVisibility(0);
                        this.cZK.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cZG.setVisibility(0);
                        this.cZH.setText(ao.dV(this.cZe.videoInfo.video_duration.intValue() * 1000));
                        this.cZI.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cZe.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cZe.dcc == 60 || this.cZe.dcc == 49) {
            this.cYB.setVisibility(8);
            if (this.cZe.threadData.An() != null && this.cZe.threadData.An().user_info != null && this.cZe.dcc == 60) {
                String str = this.cZe.threadData.An().user_info.user_name;
                if (com.baidu.tbadk.util.z.jd(str) > 14) {
                    str = com.baidu.tbadk.util.z.K(str, 14) + "...";
                }
                this.cZE.setText(o.bn(str + ":", this.cZe.threadData.getTitle()));
                this.cZE.setVisibility(0);
            } else {
                this.cZE.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xR().xV()) {
                this.cZA.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cZA.getLayoutParams();
                int width2 = this.cZA.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0210e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cZA.setLayoutParams(layoutParams2);
                if (this.cZe.threadData.An() != null) {
                    this.cZB.setDefaultErrorResource(0);
                    this.cZB.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cZB.setEvent(this.bpM);
                    this.cZB.startLoad(cardPersonDynamicThreadData.threadData.An().cover, 10, false);
                    this.cZC.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cXV.startPlayAnimation();
                    al.i(this.cZD, e.d.cp_bg_line_e);
                    this.cZJ.setVisibility(0);
                    this.cZJ.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cZe.threadData.An().audience_count)));
                    this.cbx.getCommentContainer().setOnClickListener(this.cVU);
                } else {
                    this.cbx.getCommentContainer().setOnClickListener(this.cbx);
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
                    this.cYB.setVisibility(0);
                    this.cYB.setFromCDN(this.aET);
                    this.cYB.setSingleImageRatio(0.67d);
                    this.cYB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.aqJ();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cYB.setImageMediaList(linkedList);
                } else {
                    this.cYB.setVisibility(8);
                }
            } else {
                this.cYB.setVisibility(8);
            }
            this.cZD.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.avV != null) {
            this.cZM.setVisibility(0);
            this.cZM.b(cardPersonDynamicThreadData.threadData.avV);
            this.cZM.setOnClickListener(this);
            this.cYy.setVisibility(8);
            this.cYB.setVisibility(8);
            this.cZD.setVisibility(8);
            if (this.cZQ) {
                this.cZL.setVisibility(0);
            } else {
                this.cZL.setVisibility(8);
            }
        } else {
            this.cZM.setVisibility(8);
            this.cZL.setVisibility(8);
        }
        aqI();
        c(cardPersonDynamicThreadData);
    }

    private void fw(boolean z) {
        if (this.cYB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYB.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
            }
            this.cYB.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cZP || this.cZQ) {
                this.cbx.setCommentClickable(false);
                this.cbx.setAgreeClickable(false);
                this.cbx.setShareClickable(false);
                this.cZM.setClickable(false);
                this.cZy.setClickable(false);
            } else {
                this.cbx.setCommentClickable(true);
                this.cbx.setAgreeClickable(true);
                this.cbx.setShareClickable(true);
                this.cZM.setClickable(true);
                this.cZy.setClickable(true);
            }
            this.cbx.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.dcc == 60) {
                this.cbx.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.dcm != null) {
                this.cbx.setMultiForumCount(cardPersonDynamicThreadData.dcm.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.cbx.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.cbx.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aqI() {
        this.cYy.setClickable(true);
        int childCount = this.cYB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYB.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aqM() {
        if (this.cZe != null && this.cZe.threadData != null && this.cZe.threadData.An() != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.mW(this.cZe.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cZe.threadData.An());
            if (this.cZe.threadData.An().user_info != null) {
                alaLiveInfoCoreData.userName = this.cZe.threadData.An().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqN() {
        if (this.cZe != null && this.cZe.threadData != null && this.cZe.threadData.An() != null && this.cZe.threadData.An().share_info != null) {
            if (!isHost()) {
                o.mW(this.cZe.threadId);
            }
            if (this.cZe.threadData.An().share_info.record_tid <= 0) {
                aqM();
                return;
            }
            String valueOf = String.valueOf(this.cZe.threadData.An().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        if (this.cZe != null) {
            if (!isHost()) {
                o.mW(this.cZe.threadId);
                o.a(this.mTitle, this.cZe.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cYA, this.cZe.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cZe.dcc == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cZe.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cZe.threadData.getFid()));
            pbActivityConfig.setForumName(this.cZe.threadData.zZ());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cZe.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cZe.threadData == null || !this.cZe.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").aB("obj_type", "2").aB("tid", this.cZe.threadId).y("obj_param1", this.cZe.isHost ? 1 : 2));
        }
    }

    private void aqO() {
        if (this.cZe != null && this.cZe.threadData != null && this.cZe.threadData.avV != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cZe.threadData.avV.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").aB("obj_type", "3").aB("tid", this.cZe.threadId).y("obj_param1", this.cZe.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(boolean z) {
        if (this.cZx != null) {
            if (z) {
                this.cZx.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cZx.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cZx.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cZx.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cZe.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cZM) {
            aqO();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aET ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aET, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cZP);
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
