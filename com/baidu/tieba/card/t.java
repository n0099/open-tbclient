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
    private boolean aEr;
    private TbImageView.a boY;
    private View.OnClickListener cVj;
    public PlayVoiceBntNew cXN;
    private TextView cXP;
    private ConstrainImageGroup cXQ;
    private final View.OnClickListener cXT;
    private AlaPlayAnimationView cXk;
    private CustomMessageListener cXl;
    public ThreadViewAndCommentInfoLayout cYE;
    private final String cYF;
    private final String cYG;
    private TextView cYH;
    private LinearLayout cYI;
    private TextView cYJ;
    private TextView cYK;
    private TextView cYL;
    private TextView cYM;
    private ImageView cYN;
    private s cYO;
    private View cYP;
    private TbImageView cYQ;
    private ImageView cYR;
    private LinearLayout cYS;
    private TextView cYT;
    private LinearLayout cYU;
    private LinearLayout cYV;
    private TextView cYW;
    private TextView cYX;
    private TextView cYY;
    private TextView cYZ;
    private CardPersonDynamicThreadData cYt;
    private TextView cZa;
    public OriginalThreadCardView cZb;
    private View cZc;
    private View cZd;
    private boolean cZe;
    private boolean cZf;
    com.baidu.tieba.view.h cZg;
    private s.a cZh;
    private final View.OnClickListener cZi;
    public ThreadCommentAndPraiseInfoLayout caM;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cYF = "1";
        this.cYG = "2";
        this.mSkinType = 3;
        this.aEr = true;
        this.cZg = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cYt != null && !StringUtils.isNull(t.this.cYt.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cYt.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(e.d.cp_link_tip_c) : t.this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            }
        };
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.apS() != null) {
                    t.this.apS().a(view, t.this.cYt);
                }
                if (t.this.cYt.dbq != 60) {
                    if ((t.this.cYt.dbq != 40 || t.this.cYt.dbs != 2) && !t.this.cZf) {
                        t.this.aqm();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(e.j.video_check_click_msg), e.f.icon_toast_game_error).BN();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cYt.threadData.Aa().live_status != 1) {
                    t.this.aqq();
                } else {
                    t.this.aqp();
                }
            }
        };
        this.cXl = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cYt != null && t.this.cYt.threadId != null && t.this.mTitle != null && t.this.cXP != null && ((String) customResponsedMessage.getData()).equals(t.this.cYt.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cYt.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                    o.a(t.this.cXP, t.this.cYt.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
                }
            }
        };
        this.cZh = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.fu(z);
            }
        };
        this.cZi = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> apS = t.this.apS();
                if (apS != null) {
                    view.setTag("1");
                    apS.a(view, t.this.cYt);
                }
                t.this.aqm();
            }
        };
        this.cXT = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> apS = t.this.apS();
                if (apS != null) {
                    view.setTag("2");
                    apS.a(view, t.this.cYt);
                }
            }
        };
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && t.this.cYQ != null) {
                    t.this.cYQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cYH = (TextView) this.mRootView.findViewById(e.g.year_num);
        this.cYI = (LinearLayout) this.mRootView.findViewById(e.g.left_time_view);
        this.cYJ = (TextView) this.mRootView.findViewById(e.g.month_num);
        this.cYK = (TextView) this.mRootView.findViewById(e.g.day_num);
        this.cYL = (TextView) this.mRootView.findViewById(e.g.source_bar);
        this.cZa = (TextView) this.mRootView.findViewById(e.g.video_under_review);
        this.cYM = (TextView) this.mRootView.findViewById(e.g.tv_privacy_status);
        this.cYN = (ImageView) this.mRootView.findViewById(e.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.thread_title);
        this.cXN = (PlayVoiceBntNew) this.mRootView.findViewById(e.g.card_dynamic_thread_abstract_voice);
        this.cXN.setAfterClickListener(this.cXT);
        this.cXP = (TextView) this.mRootView.findViewById(e.g.thread_content);
        this.cXP.setVisibility(8);
        this.cXQ = (ConstrainImageGroup) this.mRootView.findViewById(e.g.card_dynamic_thread_img_layout);
        this.cXQ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cXQ.setChildClickListener(this.cZi);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cXQ.setImageProcessor(eVar);
        this.cYP = this.mRootView.findViewById(e.g.thread_view_img_container);
        this.cYQ = (TbImageView) this.mRootView.findViewById(e.g.thread_video_thumbnail);
        this.cYR = (ImageView) this.mRootView.findViewById(e.g.thread_img_pause_play);
        this.cYE = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(e.g.card_dynamic_thread_info_layout);
        this.cYV = (LinearLayout) this.mRootView.findViewById(e.g.duration_container);
        this.cYW = (TextView) this.mRootView.findViewById(e.g.video_duration);
        this.cYX = (TextView) this.mRootView.findViewById(e.g.video_play_count);
        this.cYY = (TextView) this.mRootView.findViewById(e.g.audience_count);
        this.cXk = (AlaPlayAnimationView) this.mRootView.findViewById(e.g.ala_play);
        this.cYZ = (TextView) this.mRootView.findViewById(e.g.fake_video_state);
        this.cYS = (LinearLayout) this.mRootView.findViewById(e.g.shared_ala_live_layout);
        this.cYT = (TextView) this.mRootView.findViewById(e.g.shared_ala_live_room_title);
        this.cYU = (LinearLayout) this.mRootView.findViewById(e.g.llAlaLivingLogLayout);
        this.cYU.setVisibility(8);
        this.cZb = (OriginalThreadCardView) this.mRootView.findViewById(e.g.original_thread_info);
        this.cZc = this.mRootView.findViewById(e.g.divider_line_thick);
        this.cZd = this.mRootView.findViewById(e.g.divider_line_thin);
        this.caM = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_thread_info_layout);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this.cVj);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setIsBarViewVisible(false);
        this.caM.setFrom(8);
        this.caM.setDisPraiseFrom(3);
        this.caM.setShareReportFrom(6);
        this.caM.setStType("person_page");
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.apS() != null) {
                    t.this.apS().a(view, t.this.cYt);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.cYH, e.d.cp_cont_b);
            al.h(this.cYJ, e.d.cp_cont_j);
            al.h(this.cYK, e.d.cp_cont_b);
            al.h(this.cYL, e.d.cp_cont_d);
            al.h(this.cZa, e.d.cp_cont_d);
            al.h(this.cYM, e.d.cp_cont_d);
            if (this.cYN != null) {
                this.cYN.setImageDrawable(al.getDrawable(e.f.icon_card_more));
            }
            al.h(this.mTitle, e.d.cp_cont_b);
            al.h(this.cXP, e.d.cp_cont_f);
            al.h(this.cYT, e.d.cp_cont_f);
            if (this.cYO != null) {
                this.cYO.onChangeSkinType();
            }
            this.cYE.onChangeSkinType();
            this.caM.onChangeSkinType();
            al.j(this.cZc, e.d.cp_bg_line_e);
            al.j(this.cZd, e.d.cp_bg_line_c);
            al.j(this.cYT, e.d.cp_bg_line_e);
            if (this.cZb != null) {
                this.cZb.onChangeSkinType();
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
        this.cYt = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        this.cYH.setVisibility(cardPersonDynamicThreadData.dbC ? 0 : 8);
        this.cYI.setVisibility(cardPersonDynamicThreadData.dbB ? 0 : 4);
        this.cZc.setVisibility(cardPersonDynamicThreadData.dbB ? 0 : 8);
        this.cZd.setVisibility(cardPersonDynamicThreadData.dbB ? 8 : 0);
        if (cardPersonDynamicThreadData.dbD) {
            this.cZc.setVisibility(8);
            this.cZd.setVisibility(8);
        }
        this.cZe = cardPersonDynamicThreadData.dbq == 40 && cardPersonDynamicThreadData.dbs == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cZf = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.dbs == 2;
        }
        this.cYH.setText(cardPersonDynamicThreadData.dbt);
        this.cYJ.setText(cardPersonDynamicThreadData.dbu);
        this.cYK.setText(cardPersonDynamicThreadData.dbv);
        if (cardPersonDynamicThreadData.dbA != null && cardPersonDynamicThreadData.dbA.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.dbA.length; i++) {
                sb.append(ao.d(cardPersonDynamicThreadData.dbA[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.dbA.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(e.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(e.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cYL.setText(sb2);
                this.cYL.setVisibility(0);
            } else {
                this.cYL.setText(e.j.person_homepage);
            }
        } else {
            this.cYL.setText(e.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cYM.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cYM.setVisibility(0);
            }
            fu(cardPersonDynamicThreadData.isPrivacy);
            this.cYN.setVisibility(0);
            this.cYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cYO == null) {
                            t.this.cYO = new s(t.this.mPageContext);
                            t.this.cYO.create();
                            t.this.cYO.a(t.this.cZh);
                        }
                        t.this.cYO.a(t.this.cYt);
                        t.this.cYO.show();
                    }
                }
            });
        } else {
            this.cYM.setVisibility(8);
            this.cYN.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.dby;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cXN.setVisibility(0);
            ft(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cXN.setVoiceModel(voiceModel);
            this.cXN.setTag(voiceModel);
            this.cXN.aWT();
            if (voiceModel != null) {
                this.cXN.qJ(voiceModel.voice_status.intValue());
            }
            this.cXN.bFt();
        } else {
            this.cXN.setVisibility(8);
            ft(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.dbx;
        al.i(this.cYS, e.d.transparent);
        this.cYT.setVisibility(8);
        this.cYU.setVisibility(8);
        this.cYS.setVisibility(0);
        this.cYP.setVisibility(8);
        this.cYZ.setVisibility(8);
        this.cYV.setVisibility(8);
        this.cYY.setVisibility(8);
        this.cXk.bMM();
        if (cardPersonDynamicThreadData.dbq == 36) {
            this.cXQ.setVisibility(8);
        } else if (cardPersonDynamicThreadData.dbq == 40 || this.cYt.dbq == 50) {
            this.cXQ.setVisibility(8);
            if (com.baidu.tbadk.core.i.xE().xI()) {
                this.cYP.setVisibility(0);
                this.cYR.setVisibility(0);
                this.cYR.setImageResource(e.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYP.getLayoutParams();
                int width = this.cYP.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(e.C0210e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cYP.setLayoutParams(layoutParams);
                if (this.cYt.videoInfo != null) {
                    this.cYQ.setDefaultErrorResource(0);
                    this.cYQ.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cYQ.setEvent(this.boY);
                    this.cYQ.startLoad(this.cYt.videoInfo.thumbnail_url, 17, false);
                    if (this.cZe) {
                        this.cYZ.setVisibility(0);
                        this.cYZ.setText(String.format(this.mContext.getResources().getString(e.j.video_review_state), new Object[0]));
                    } else {
                        this.cYV.setVisibility(0);
                        this.cYW.setText(ao.dV(this.cYt.videoInfo.video_duration.intValue() * 1000));
                        this.cYX.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cYt.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cYt.dbq == 60 || this.cYt.dbq == 49) {
            this.cXQ.setVisibility(8);
            if (this.cYt.threadData.Aa() != null && this.cYt.threadData.Aa().user_info != null && this.cYt.dbq == 60) {
                String str = this.cYt.threadData.Aa().user_info.user_name;
                if (com.baidu.tbadk.util.y.iN(str) > 14) {
                    str = com.baidu.tbadk.util.y.K(str, 14) + "...";
                }
                this.cYT.setText(o.bm(str + ":", this.cYt.threadData.getTitle()));
                this.cYT.setVisibility(0);
            } else {
                this.cYT.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.xE().xI()) {
                this.cYP.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYP.getLayoutParams();
                int width2 = this.cYP.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(e.C0210e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cYP.setLayoutParams(layoutParams2);
                if (this.cYt.threadData.Aa() != null) {
                    this.cYQ.setDefaultErrorResource(0);
                    this.cYQ.setDefaultBgResource(e.f.pic_bg_video_frs);
                    this.cYQ.setEvent(this.boY);
                    this.cYQ.startLoad(cardPersonDynamicThreadData.threadData.Aa().cover, 10, false);
                    this.cYR.setImageResource(e.f.btn_icon_play_live_on_n);
                    this.cXk.startPlayAnimation();
                    al.i(this.cYS, e.d.cp_bg_line_e);
                    this.cYY.setVisibility(0);
                    this.cYY.setText(String.format(this.mContext.getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.cYt.threadData.Aa().audience_count)));
                    this.caM.getCommentContainer().setOnClickListener(this.cVj);
                } else {
                    this.caM.getCommentContainer().setOnClickListener(this.caM);
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
                    this.cXQ.setVisibility(0);
                    this.cXQ.setFromCDN(this.aEr);
                    this.cXQ.setSingleImageRatio(0.67d);
                    this.cXQ.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                t.this.aqm();
                            } else {
                                t.this.a(view, linkedList, i2, bbVar);
                            }
                        }
                    });
                    this.cXQ.setImageMediaList(linkedList);
                } else {
                    this.cXQ.setVisibility(8);
                }
            } else {
                this.cXQ.setVisibility(8);
            }
            this.cYS.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.avt != null) {
            this.cZb.setVisibility(0);
            this.cZb.b(cardPersonDynamicThreadData.threadData.avt);
            this.cZb.setOnClickListener(this);
            this.cXN.setVisibility(8);
            this.cXQ.setVisibility(8);
            this.cYS.setVisibility(8);
            if (this.cZf) {
                this.cZa.setVisibility(0);
            } else {
                this.cZa.setVisibility(8);
            }
        } else {
            this.cZb.setVisibility(8);
            this.cZa.setVisibility(8);
        }
        aql();
        c(cardPersonDynamicThreadData);
    }

    private void ft(boolean z) {
        if (this.cXQ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXQ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
            }
            this.cXQ.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cZe || this.cZf) {
                this.caM.setCommentClickable(false);
                this.caM.setAgreeClickable(false);
                this.caM.setShareClickable(false);
                this.cZb.setClickable(false);
                this.cYN.setClickable(false);
            } else {
                this.caM.setCommentClickable(true);
                this.caM.setAgreeClickable(true);
                this.caM.setShareClickable(true);
                this.cZb.setClickable(true);
                this.cYN.setClickable(true);
            }
            this.caM.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.dbq == 60) {
                this.caM.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.dbA != null) {
                this.caM.setMultiForumCount(cardPersonDynamicThreadData.dbA.length);
            }
            if (cardPersonDynamicThreadData.threadData != null) {
                this.caM.setForumId(String.valueOf(cardPersonDynamicThreadData.threadData.getFid()));
            }
            this.caM.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void aql() {
        this.cXN.setClickable(true);
        int childCount = this.cXQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXQ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aqp() {
        if (this.cYt != null && this.cYt.threadData != null && this.cYt.threadData.Aa() != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.mG(this.cYt.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cYt.threadData.Aa());
            if (this.cYt.threadData.Aa().user_info != null) {
                alaLiveInfoCoreData.userName = this.cYt.threadData.Aa().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqq() {
        if (this.cYt != null && this.cYt.threadData != null && this.cYt.threadData.Aa() != null && this.cYt.threadData.Aa().share_info != null) {
            if (!isHost()) {
                o.mG(this.cYt.threadId);
            }
            if (this.cYt.threadData.Aa().share_info.record_tid <= 0) {
                aqp();
                return;
            }
            String valueOf = String.valueOf(this.cYt.threadData.Aa().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqm() {
        if (this.cYt != null) {
            if (!isHost()) {
                o.mG(this.cYt.threadId);
                o.a(this.mTitle, this.cYt.threadId, e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cXP, this.cYt.threadId, e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cYt.dbq == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cYt.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cYt.threadData.getFid()));
            pbActivityConfig.setForumName(this.cYt.threadData.zM());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cYt.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cYt.threadData == null || !this.cYt.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new am("c12943").aA("obj_type", "2").aA("tid", this.cYt.threadId).x("obj_param1", this.cYt.isHost ? 1 : 2));
        }
    }

    private void aqr() {
        if (this.cYt != null && this.cYt.threadData != null && this.cYt.threadData.avt != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cYt.threadData.avt.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new am("c12943").aA("obj_type", "3").aA("tid", this.cYt.threadId).x("obj_param1", this.cYt.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(boolean z) {
        if (this.cYM != null) {
            if (z) {
                this.cYM.setText(e.j.privacy);
                Drawable drawable = al.getDrawable(e.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cYM.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cYM.setText(e.j.public_open);
            Drawable drawable2 = al.getDrawable(e.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cYM.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cYt.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cZb) {
            aqr();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setImageViewPool(bVar);
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
                imageUrlData.urlType = this.aEr ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEr, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cZe);
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
