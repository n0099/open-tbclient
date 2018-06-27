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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
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
    private boolean atn;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private TbImageView.a bcT;
    private View.OnClickListener ctV;
    private AlaPlayAnimationView cvY;
    private CustomMessageListener cvZ;
    private TextView cwA;
    private ConstrainImageGroup cwB;
    private final View.OnClickListener cwE;
    public PlayVoiceBntNew cwy;
    private View cxA;
    private TbImageView cxB;
    private ImageView cxC;
    private LinearLayout cxD;
    private TextView cxE;
    private LinearLayout cxF;
    private LinearLayout cxG;
    private TextView cxH;
    private TextView cxI;
    private TextView cxJ;
    private TextView cxK;
    private TextView cxL;
    public OriginalThreadCardView cxM;
    private View cxN;
    private View cxO;
    private boolean cxP;
    private boolean cxQ;
    com.baidu.tieba.view.h cxR;
    private s.a cxS;
    private final View.OnClickListener cxT;
    private CardPersonDynamicThreadData cxe;
    public ThreadViewAndCommentInfoLayout cxp;
    private final String cxq;
    private final String cxr;
    private TextView cxs;
    private LinearLayout cxt;
    private TextView cxu;
    private TextView cxv;
    private TextView cxw;
    private TextView cxx;
    private ImageView cxy;
    private s cxz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cxq = "1";
        this.cxr = "2";
        this.mSkinType = 3;
        this.atn = true;
        this.cxR = new com.baidu.tieba.view.h() { // from class: com.baidu.tieba.card.t.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (t.this.cxe != null && !StringUtils.isNull(t.this.cxe.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(t.this.mContext).createNormalCfg(t.this.cxe.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.h
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? t.this.mContext.getResources().getColor(d.C0142d.cp_link_tip_c) : t.this.mContext.getResources().getColor(d.C0142d.cp_link_tip_a));
            }
        };
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aia() != null) {
                    t.this.aia().a(view, t.this.cxe);
                }
                if (t.this.cxe.czZ != 60) {
                    if ((t.this.cxe.czZ != 40 || t.this.cxe.cAb != 2) && !t.this.cxQ) {
                        t.this.ait();
                        return;
                    } else {
                        BdToast.b(t.this.getContext(), t.this.getContext().getString(d.k.video_check_click_msg), d.f.icon_toast_game_error).xv();
                        return;
                    }
                }
                TiebaStatic.log("c12333");
                if (t.this.cxe.threadData.vO().live_status != 1) {
                    t.this.aix();
                } else {
                    t.this.aiw();
                }
            }
        };
        this.cvZ = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.card.t.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && t.this.cxe != null && t.this.cxe.threadId != null && t.this.mTitle != null && t.this.cwA != null && ((String) customResponsedMessage.getData()).equals(t.this.cxe.threadId) && !t.this.isHost()) {
                    o.a(t.this.mTitle, t.this.cxe.threadId, d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                    o.a(t.this.cwA, t.this.cxe.threadId, d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
                }
            }
        };
        this.cxS = new s.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.s.a
            public void setPrivacy(boolean z) {
                t.this.ew(z);
            }
        };
        this.cxT = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aia = t.this.aia();
                if (aia != null) {
                    view.setTag("1");
                    aia.a(view, t.this.cxe);
                }
                t.this.ait();
            }
        };
        this.cwE = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<CardPersonDynamicThreadData> aia = t.this.aia();
                if (aia != null) {
                    view.setTag("2");
                    aia.a(view, t.this.cxe);
                }
            }
        };
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.card.t.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && t.this.cxB != null) {
                    t.this.cxB.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cxs = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cxt = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cxu = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cxv = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cxw = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.cxL = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cxx = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cxy = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.cwy = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.cwy.setAfterClickListener(this.cwE);
        this.cwA = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.cwA.setVisibility(8);
        this.cwB = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.cwB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cwB.setChildClickListener(this.cxT);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cwB.setImageProcessor(eVar);
        this.cxA = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.cxB = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.cxC = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cxp = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.cxG = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cxH = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cxI = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.cxJ = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cvY = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cxK = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.cxD = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cxE = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.cxF = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.cxF.setVisibility(8);
        this.cxM = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.cxN = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cxO = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setFrom(8);
        this.bGZ.setShareReportFrom(6);
        this.bGZ.setStType("person_page");
        this.bGZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aia() != null) {
                    t.this.aia().a(view, t.this.cxe);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.h(this.cxs, d.C0142d.cp_cont_b);
            am.h(this.cxu, d.C0142d.cp_cont_j);
            am.h(this.cxv, d.C0142d.cp_cont_b);
            am.h(this.cxw, d.C0142d.cp_cont_d);
            am.h(this.cxL, d.C0142d.cp_cont_d);
            am.h(this.cxx, d.C0142d.cp_cont_d);
            if (this.cxy != null) {
                this.cxy.setImageDrawable(am.getDrawable(d.f.icon_card_more));
            }
            am.h(this.mTitle, d.C0142d.cp_cont_b);
            am.h(this.cwA, d.C0142d.cp_cont_f);
            am.h(this.cxE, d.C0142d.cp_cont_f);
            if (this.cxz != null) {
                this.cxz.onChangeSkinType();
            }
            this.cxp.onChangeSkinType();
            this.bGZ.onChangeSkinType();
            am.j(this.cxN, d.C0142d.cp_bg_line_e);
            am.j(this.cxO, d.C0142d.cp_bg_line_c);
            am.j(this.cxE, d.C0142d.cp_bg_line_e);
            if (this.cxM != null) {
                this.cxM.onChangeSkinType();
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
        this.cxe = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        this.cxs.setVisibility(cardPersonDynamicThreadData.cAl ? 0 : 8);
        this.cxt.setVisibility(cardPersonDynamicThreadData.cAk ? 0 : 4);
        this.cxN.setVisibility(cardPersonDynamicThreadData.cAk ? 0 : 8);
        this.cxO.setVisibility(cardPersonDynamicThreadData.cAk ? 8 : 0);
        if (cardPersonDynamicThreadData.cAm) {
            this.cxN.setVisibility(8);
            this.cxO.setVisibility(8);
        }
        this.cxP = cardPersonDynamicThreadData.czZ == 40 && cardPersonDynamicThreadData.cAb == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.cxQ = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.cAb == 2;
        }
        this.cxs.setText(cardPersonDynamicThreadData.cAc);
        this.cxu.setText(cardPersonDynamicThreadData.cAd);
        this.cxv.setText(cardPersonDynamicThreadData.cAe);
        if (cardPersonDynamicThreadData.cAj != null && cardPersonDynamicThreadData.cAj.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cAj.length; i++) {
                sb.append(ap.e(cardPersonDynamicThreadData.cAj[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.cAj.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.k.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.k.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cxw.setText(sb2);
                this.cxw.setVisibility(0);
            } else {
                this.cxw.setText(d.k.person_homepage);
            }
        } else {
            this.cxw.setText(d.k.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cxx.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cxx.setVisibility(0);
            }
            ew(cardPersonDynamicThreadData.isPrivacy);
            this.cxy.setVisibility(0);
            this.cxy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (t.this.mPageContext != null) {
                        if (t.this.cxz == null) {
                            t.this.cxz = new s(t.this.mPageContext);
                            t.this.cxz.create();
                            t.this.cxz.a(t.this.cxS);
                        }
                        t.this.cxz.a(t.this.cxe);
                        t.this.cxz.show();
                    }
                }
            });
        } else {
            this.cxx.setVisibility(8);
            this.cxy.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.cAh;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.cwy.setVisibility(0);
            ev(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.cwy.setVoiceModel(voiceModel);
            this.cwy.setTag(voiceModel);
            this.cwy.aOt();
            if (voiceModel != null) {
                this.cwy.ot(voiceModel.voice_status.intValue());
            }
            this.cwy.byM();
        } else {
            this.cwy.setVisibility(8);
            ev(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cAg;
        am.i(this.cxD, d.C0142d.transparent);
        this.cxE.setVisibility(8);
        this.cxF.setVisibility(8);
        this.cxD.setVisibility(0);
        this.cxA.setVisibility(8);
        this.cxK.setVisibility(8);
        this.cxG.setVisibility(8);
        this.cxJ.setVisibility(8);
        this.cvY.bFD();
        if (cardPersonDynamicThreadData.czZ == 36) {
            this.cwB.setVisibility(8);
        } else if (cardPersonDynamicThreadData.czZ == 40 || this.cxe.czZ == 50) {
            this.cwB.setVisibility(8);
            if (com.baidu.tbadk.core.i.tt().tz()) {
                this.cxA.setVisibility(0);
                this.cxC.setVisibility(0);
                this.cxC.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxA.getLayoutParams();
                int width = this.cxA.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cxA.setLayoutParams(layoutParams);
                if (this.cxe.videoInfo != null) {
                    this.cxB.setDefaultErrorResource(0);
                    this.cxB.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cxB.setEvent(this.bcT);
                    this.cxB.startLoad(this.cxe.videoInfo.thumbnail_url, 17, false);
                    if (this.cxP) {
                        this.cxK.setVisibility(0);
                        this.cxK.setText(String.format(this.mContext.getResources().getString(d.k.video_review_state), new Object[0]));
                    } else {
                        this.cxG.setVisibility(0);
                        this.cxH.setText(ap.cY(this.cxe.videoInfo.video_duration.intValue() * 1000));
                        this.cxI.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ap.F(this.cxe.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cxe.czZ == 60 || this.cxe.czZ == 49) {
            this.cwB.setVisibility(8);
            if (this.cxe.threadData.vO() != null && this.cxe.threadData.vO().user_info != null && this.cxe.czZ == 60) {
                String str = this.cxe.threadData.vO().user_info.user_name;
                if (com.baidu.tbadk.util.x.hL(str) > 14) {
                    str = com.baidu.tbadk.util.x.I(str, 14) + "...";
                }
                this.cxE.setText(o.aO(str + SystemInfoUtil.COLON, this.cxe.threadData.getTitle()));
                this.cxE.setVisibility(0);
            } else {
                this.cxE.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.tt().tz()) {
                this.cxA.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cxA.getLayoutParams();
                int width2 = this.cxA.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cxA.setLayoutParams(layoutParams2);
                if (this.cxe.threadData.vO() != null) {
                    this.cxB.setDefaultErrorResource(0);
                    this.cxB.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.cxB.setEvent(this.bcT);
                    this.cxB.startLoad(cardPersonDynamicThreadData.threadData.vO().cover, 10, false);
                    this.cxC.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cvY.startPlayAnimation();
                    am.i(this.cxD, d.C0142d.cp_bg_line_e);
                    this.cxJ.setVisibility(0);
                    this.cxJ.setText(String.format(this.mContext.getResources().getString(d.k.ala_audience_count_prefix), ap.F(this.cxe.threadData.vO().audience_count)));
                    this.bGZ.getCommentContainer().setOnClickListener(this.ctV);
                } else {
                    this.bGZ.getCommentContainer().setOnClickListener(this.bGZ);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.tt().tz() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bc bcVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.z(linkedList) > 0) {
                    this.cwB.setVisibility(0);
                    this.cwB.setFromCDN(this.atn);
                    this.cwB.setSingleImageRatio(0.67d);
                    this.cwB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.t.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                t.this.ait();
                            } else {
                                t.this.a(view, linkedList, i2, bcVar);
                            }
                        }
                    });
                    this.cwB.setImageMediaList(linkedList);
                } else {
                    this.cwB.setVisibility(8);
                }
            } else {
                this.cwB.setVisibility(8);
            }
            this.cxD.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.akk != null) {
            this.cxM.setVisibility(0);
            this.cxM.b(cardPersonDynamicThreadData.threadData.akk);
            this.cxM.setOnClickListener(this);
            this.cwy.setVisibility(8);
            this.cwB.setVisibility(8);
            this.cxD.setVisibility(8);
            if (this.cxQ) {
                this.cxL.setVisibility(0);
            } else {
                this.cxL.setVisibility(8);
            }
        } else {
            this.cxM.setVisibility(8);
            this.cxL.setVisibility(8);
        }
        ais();
        c(cardPersonDynamicThreadData);
    }

    private void ev(boolean z) {
        if (this.cwB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwB.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
            }
            this.cwB.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.cxP || this.cxQ) {
                this.bGZ.setCommentClickable(false);
                this.bGZ.setAgreeClickable(false);
                this.bGZ.setShareClickable(false);
                this.cxM.setClickable(false);
                this.cxy.setClickable(false);
            } else {
                this.bGZ.setCommentClickable(true);
                this.bGZ.setAgreeClickable(true);
                this.bGZ.setShareClickable(true);
                this.cxM.setClickable(true);
                this.cxy.setClickable(true);
            }
            this.bGZ.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.czZ == 60) {
                this.bGZ.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.cAj != null) {
                this.bGZ.setMultiForumCount(cardPersonDynamicThreadData.cAj.length);
            }
            this.bGZ.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void ais() {
        this.cwy.setClickable(true);
        int childCount = this.cwB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwB.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aiw() {
        if (this.cxe != null && this.cxe.threadData != null && this.cxe.threadData.vO() != null) {
            if (!com.baidu.adp.lib.util.j.jD()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.no_network_guide);
                return;
            }
            if (!isHost()) {
                o.kY(this.cxe.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cxe.threadData.vO());
            if (this.cxe.threadData.vO().user_info != null) {
                alaLiveInfoCoreData.userName = this.cxe.threadData.vO().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aix() {
        if (this.cxe != null && this.cxe.threadData != null && this.cxe.threadData.vO() != null && this.cxe.threadData.vO().share_info != null) {
            if (!isHost()) {
                o.kY(this.cxe.threadId);
            }
            if (this.cxe.threadData.vO().share_info.record_tid <= 0) {
                aiw();
                return;
            }
            String valueOf = String.valueOf(this.cxe.threadData.vO().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        if (this.cxe != null) {
            if (!isHost()) {
                o.kY(this.cxe.threadId);
                o.a(this.mTitle, this.cxe.threadId, d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                o.a(this.cwA, this.cxe.threadId, d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cxe.czZ == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cxe.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cxe.threadData.getFid()));
            pbActivityConfig.setForumName(this.cxe.threadData.vB());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cxe.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            if (this.cxe.threadData == null || !this.cxe.threadData.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").ah("obj_type", "2").ah("tid", this.cxe.threadId).r("obj_param1", this.cxe.isHost ? 1 : 2));
        }
    }

    private void aiy() {
        if (this.cxe != null && this.cxe.threadData != null && this.cxe.threadData.akk != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cxe.threadData.akk.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").ah("obj_type", "3").ah("tid", this.cxe.threadId).r("obj_param1", this.cxe.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(boolean z) {
        if (this.cxx != null) {
            if (z) {
                this.cxx.setText(d.k.privacy);
                Drawable drawable = am.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cxx.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cxx.setText(d.k.public_open);
            Drawable drawable2 = am.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cxx.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cxe.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cxM) {
            aiy();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cwB != null) {
            this.cwB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cwB != null) {
            this.cwB.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bc bcVar) {
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
                imageUrlData.urlType = this.atn ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bcVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bcVar.vB(), String.valueOf(bcVar.getFid()), bcVar.getTid(), this.atn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.cxP);
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
        o.a(this.mTitle, cardPersonDynamicThreadData.threadId, d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        return true;
    }
}
