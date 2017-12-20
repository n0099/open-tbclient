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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCoverView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.p;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class q extends a<CardPersonDynamicThreadData> {
    private boolean ajh;
    private View.OnClickListener bZj;
    public ThreadCommentAndPraiseInfoLayout bvI;
    public PlayVoiceBntNew caM;
    private TextView caO;
    private ConstrainImageGroup caP;
    private final View.OnClickListener caS;
    private AlaPlayAnimationView cae;
    private CustomMessageListener caf;
    private TbImageView.a caz;
    private CardPersonDynamicThreadData cbB;
    public ThreadViewAndCommentInfoLayout cbO;
    private final String cbP;
    private final String cbQ;
    private TextView cbR;
    private LinearLayout cbS;
    private TextView cbT;
    private TextView cbU;
    private TextView cbV;
    private TextView cbW;
    private ImageView cbX;
    private p cbY;
    private PhotoLiveCoverView cbZ;
    private View cca;
    private TbImageView ccb;
    private ImageView ccc;
    private LinearLayout ccd;
    private TextView cce;
    private LinearLayout ccf;
    private LinearLayout ccg;
    private TextView cch;
    private TextView cci;
    private TextView ccj;
    private TextView cck;
    private TextView ccl;
    public OriginalThreadCardView ccm;
    private View ccn;
    private View cco;
    private boolean ccp;
    private boolean ccq;
    com.baidu.tieba.view.i ccr;
    private p.a cct;
    private final View.OnClickListener ccu;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbP = "1";
        this.cbQ = "2";
        this.mSkinType = 3;
        this.ajh = true;
        this.ccr = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.q.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (q.this.cbB != null && !StringUtils.isNull(q.this.cbB.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(q.this.mContext).createNormalCfg(q.this.cbB.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? q.this.mContext.getResources().getColor(d.C0096d.cp_link_tip_c) : q.this.mContext.getResources().getColor(d.C0096d.cp_link_tip_a));
            }
        };
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.abt() != null) {
                    q.this.abt().a(view, q.this.cbB);
                }
                if (q.this.cbB.cer != 33) {
                    if (q.this.cbB.cer != 60) {
                        if ((q.this.cbB.cer != 40 || q.this.cbB.ceu != 2) && !q.this.ccq) {
                            q.this.abM();
                            return;
                        } else {
                            BdToast.b(q.this.getContext(), q.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).tq();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (q.this.cbB.threadData.rO().live_status != 1) {
                        q.this.abU();
                        return;
                    } else {
                        q.this.abT();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                q.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(q.this.mPageContext.getPageActivity(), q.this.cbB.threadId).cz(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bD(23014).pn()));
            }
        };
        this.caf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && q.this.cbB != null && q.this.cbB.threadId != null && q.this.mTitle != null && q.this.caO != null && ((String) customResponsedMessage.getData()).equals(q.this.cbB.threadId) && !q.this.isHost()) {
                    k.a(q.this.mTitle, q.this.cbB.threadId, d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                    k.a(q.this.caO, q.this.cbB.threadId, d.C0096d.cp_cont_j, d.C0096d.cp_cont_d);
                }
            }
        };
        this.cct = new p.a() { // from class: com.baidu.tieba.card.q.8
            @Override // com.baidu.tieba.card.p.a
            public void setPrivacy(boolean z) {
                q.this.dT(z);
            }
        };
        this.ccu = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> abt = q.this.abt();
                if (abt != null) {
                    view.setTag("1");
                    abt.a(view, q.this.cbB);
                }
                q.this.abM();
            }
        };
        this.caS = new View.OnClickListener() { // from class: com.baidu.tieba.card.q.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<CardPersonDynamicThreadData> abt = q.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, q.this.cbB);
                }
            }
        };
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.card.q.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && q.this.ccb != null) {
                    q.this.ccb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.cbR = (TextView) this.mRootView.findViewById(d.g.year_num);
        this.cbS = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.cbT = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.cbU = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.cbV = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.ccl = (TextView) this.mRootView.findViewById(d.g.video_under_review);
        this.cbW = (TextView) this.mRootView.findViewById(d.g.tv_privacy_status);
        this.cbX = (ImageView) this.mRootView.findViewById(d.g.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.caM = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.caM.setAfterClickListener(this.caS);
        this.caO = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.caO.setVisibility(8);
        this.caP = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.caP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.caP.setChildClickListener(this.ccu);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caP.setImageProcessor(fVar);
        this.cca = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.ccb = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.ccc = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.cbZ = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.cbO = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.ccg = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.cch = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.cci = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.ccj = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.cae = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.cck = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.ccd = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.cce = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.ccf = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.ccf.setVisibility(8);
        this.ccm = (OriginalThreadCardView) this.mRootView.findViewById(d.g.original_thread_info);
        this.ccn = this.mRootView.findViewById(d.g.divider_line_thick);
        this.cco = this.mRootView.findViewById(d.g.divider_line_thin);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setFrom(1);
        this.bvI.setShareReportFrom(6);
        this.bvI.setStType("person_page");
        this.bvI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.abt() != null) {
                    q.this.abt().a(view, q.this.cbB);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.i(this.cbR, d.C0096d.cp_cont_b);
            aj.i(this.cbT, d.C0096d.cp_cont_j);
            aj.i(this.cbU, d.C0096d.cp_cont_b);
            aj.i(this.cbV, d.C0096d.cp_cont_d);
            aj.i(this.ccl, d.C0096d.cp_cont_d);
            aj.i(this.cbW, d.C0096d.cp_cont_d);
            if (this.cbX != null) {
                this.cbX.setImageDrawable(aj.getDrawable(d.f.icon_card_more));
            }
            aj.i(this.mTitle, d.C0096d.cp_cont_b);
            aj.i(this.caO, d.C0096d.cp_cont_f);
            aj.i(this.cce, d.C0096d.cp_cont_f);
            if (this.cbY != null) {
                this.cbY.onChangeSkinType();
            }
            this.cbO.onChangeSkinType();
            this.bvI.onChangeSkinType();
            aj.k(this.ccn, d.C0096d.cp_bg_line_e);
            aj.k(this.cco, d.C0096d.cp_bg_line_c);
            aj.k(this.cce, d.C0096d.cp_bg_line_e);
            if (this.ccm != null) {
                this.ccm.onChangeSkinType();
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
        this.cbB = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZj);
        }
        this.cbR.setVisibility(cardPersonDynamicThreadData.ceF ? 0 : 8);
        this.cbS.setVisibility(cardPersonDynamicThreadData.ceE ? 0 : 4);
        this.ccn.setVisibility(cardPersonDynamicThreadData.ceE ? 0 : 8);
        this.cco.setVisibility(cardPersonDynamicThreadData.ceE ? 8 : 0);
        if (cardPersonDynamicThreadData.ceG) {
            this.ccn.setVisibility(8);
            this.cco.setVisibility(8);
        }
        this.ccp = cardPersonDynamicThreadData.cer == 40 && cardPersonDynamicThreadData.ceu == 2;
        e(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.threadData != null) {
            this.ccq = cardPersonDynamicThreadData.threadData.isShareThread && cardPersonDynamicThreadData.ceu == 2;
        }
        this.cbR.setText(cardPersonDynamicThreadData.cev);
        this.cbT.setText(cardPersonDynamicThreadData.cew);
        this.cbU.setText(cardPersonDynamicThreadData.cex);
        if (cardPersonDynamicThreadData.ceD != null && cardPersonDynamicThreadData.ceD.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.ceD.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.ceD[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.ceD.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.cbV.setText(sb2);
                this.cbV.setVisibility(0);
            } else {
                this.cbV.setText(d.j.person_homepage);
            }
        } else {
            this.cbV.setText(d.j.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.cbW.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.cbW.setVisibility(0);
            }
            dT(cardPersonDynamicThreadData.isPrivacy);
            this.cbX.setVisibility(0);
            this.cbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q.this.mPageContext != null) {
                        if (q.this.cbY == null) {
                            q.this.cbY = new p(q.this.mPageContext);
                            q.this.cbY.create();
                            q.this.cbY.a(q.this.cct);
                        }
                        q.this.cbY.a(q.this.cbB);
                        q.this.cbY.show();
                    }
                }
            });
        } else {
            this.cbW.setVisibility(8);
            this.cbX.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.ceA;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.caM.setVisibility(0);
            dS(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.caM.setVoiceModel(voiceModel);
            this.caM.setTag(voiceModel);
            this.caM.bme();
            if (voiceModel != null) {
                this.caM.nT(voiceModel.voice_status.intValue());
            }
        } else {
            this.caM.setVisibility(8);
            dS(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.cez;
        aj.j(this.ccd, d.C0096d.transparent);
        this.cce.setVisibility(8);
        this.ccf.setVisibility(8);
        this.ccd.setVisibility(0);
        this.cbZ.setVisibility(8);
        this.cca.setVisibility(8);
        this.cck.setVisibility(8);
        this.ccg.setVisibility(8);
        this.ccj.setVisibility(8);
        this.cae.bEF();
        if (cardPersonDynamicThreadData.cer == 36) {
            this.caP.setVisibility(8);
        } else if (cardPersonDynamicThreadData.cer == 33) {
            this.caP.setVisibility(8);
            if (com.baidu.tbadk.core.h.oY().pe() && cardPersonDynamicThreadData.ceB != null && !StringUtils.isNull(cardPersonDynamicThreadData.ceB.livecover_src)) {
                this.cbZ.setVisibility(0);
                PhotoLiveCardData d = d(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.ceB)) {
                    this.cbZ.setShowExpression(false);
                } else {
                    this.cbZ.setShowExpression(true);
                }
                this.cbZ.setShowImage(com.baidu.tbadk.core.h.oY().pe());
                this.cbZ.setChooseStyle(d.getShowStyle());
                this.cbZ.setData(d);
            }
        } else if (cardPersonDynamicThreadData.cer == 40 || this.cbB.cer == 50) {
            this.caP.setVisibility(8);
            if (com.baidu.tbadk.core.h.oY().pe()) {
                this.cca.setVisibility(0);
                this.ccc.setVisibility(0);
                this.ccc.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cca.getLayoutParams();
                int width = this.cca.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.cca.setLayoutParams(layoutParams);
                if (this.cbB.videoInfo != null) {
                    this.ccb.setDefaultErrorResource(0);
                    this.ccb.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ccb.setEvent(this.caz);
                    this.ccb.startLoad(this.cbB.videoInfo.thumbnail_url, 17, false);
                    if (this.ccp) {
                        this.cck.setVisibility(0);
                        this.cck.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.ccg.setVisibility(0);
                        this.cch.setText(am.cY(this.cbB.videoInfo.video_duration.intValue() * 1000));
                        this.cci.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.A(this.cbB.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.cbB.cer == 60 || this.cbB.cer == 49) {
            this.caP.setVisibility(8);
            if (this.cbB.threadData.rO() != null && this.cbB.threadData.rO().user_info != null && this.cbB.cer == 60) {
                String str = this.cbB.threadData.rO().user_info.user_name;
                if (com.baidu.tbadk.util.w.gY(str) > 14) {
                    str = com.baidu.tbadk.util.w.H(str, 14) + "...";
                }
                this.cce.setText(k.aH(str + ":", this.cbB.threadData.getTitle()));
                this.cce.setVisibility(0);
            } else {
                this.cce.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oY().pe()) {
                this.cca.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cca.getLayoutParams();
                int width2 = this.cca.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.cca.setLayoutParams(layoutParams2);
                if (this.cbB.threadData.rO() != null) {
                    this.ccb.setDefaultErrorResource(0);
                    this.ccb.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.ccb.setEvent(this.caz);
                    this.ccb.startLoad(cardPersonDynamicThreadData.threadData.rO().cover, 10, false);
                    this.ccc.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.cae.startPlayAnimation();
                    aj.j(this.ccd, d.C0096d.cp_bg_line_e);
                    this.ccj.setVisibility(0);
                    this.ccj.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.cbB.threadData.rO().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.oY().pe() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bd bdVar = cardPersonDynamicThreadData.threadData;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caP.setVisibility(0);
                    this.caP.setFromCDN(this.ajh);
                    this.caP.setSingleImageRatio(0.67d);
                    this.caP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.q.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                q.this.abM();
                            } else {
                                q.this.a(view, linkedList, i2, bdVar);
                            }
                        }
                    });
                    this.caP.setImageMediaList(linkedList);
                } else {
                    this.caP.setVisibility(8);
                }
            } else {
                this.caP.setVisibility(8);
            }
            this.ccd.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.threadData != null && cardPersonDynamicThreadData.threadData.aaC != null) {
            this.ccm.setVisibility(0);
            this.ccm.b(cardPersonDynamicThreadData.threadData.aaC);
            this.ccm.setOnClickListener(this);
            this.caM.setVisibility(8);
            this.caP.setVisibility(8);
            this.ccd.setVisibility(8);
            if (this.ccq) {
                this.ccl.setVisibility(0);
            } else {
                this.ccl.setVisibility(8);
            }
        } else {
            this.ccm.setVisibility(8);
            this.ccl.setVisibility(8);
        }
        abL();
        c(cardPersonDynamicThreadData);
    }

    private void dS(boolean z) {
        if (this.caP != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caP.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.caP.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.ccp || this.ccq) {
                this.bvI.setCommentClickable(false);
                this.bvI.setAgreeClickable(false);
                this.bvI.setShareClickable(false);
                this.ccm.setClickable(false);
                this.cbX.setClickable(false);
            } else {
                this.bvI.setCommentClickable(true);
                this.bvI.setAgreeClickable(true);
                this.bvI.setShareClickable(true);
                this.ccm.setClickable(true);
                this.cbX.setClickable(true);
            }
            this.bvI.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.cer == 60) {
                this.bvI.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.ceD != null) {
                this.bvI.setMultiForumCount(cardPersonDynamicThreadData.ceD.length);
            }
            this.bvI.setData(cardPersonDynamicThreadData.threadData);
        }
    }

    private void abL() {
        this.caM.setClickable(true);
        int childCount = this.caP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caP.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void abT() {
        if (this.cbB != null && this.cbB.threadData != null && this.cbB.threadData.rO() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!isHost()) {
                k.jO(this.cbB.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cbB.threadData.rO());
            if (this.cbB.threadData.rO().user_info != null) {
                alaLiveInfoCoreData.userName = this.cbB.threadData.rO().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abU() {
        if (this.cbB != null && this.cbB.threadData != null && this.cbB.threadData.rO() != null && this.cbB.threadData.rO().share_info != null) {
            if (!isHost()) {
                k.jO(this.cbB.threadId);
            }
            if (this.cbB.threadData.rO().share_info.record_tid <= 0) {
                abT();
                return;
            }
            String valueOf = String.valueOf(this.cbB.threadData.rO().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            pbActivityConfig.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        if (this.cbB != null) {
            if (!isHost()) {
                k.jO(this.cbB.threadId);
                k.a(this.mTitle, this.cbB.threadId, d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                k.a(this.caO, this.cbB.threadId, d.C0096d.cp_cont_j, d.C0096d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.cbB.cer == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.cbB.threadData, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.cbB.threadData.getFid()));
            pbActivityConfig.setForumName(this.cbB.threadData.rB());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.cbB.threadData.isShareThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    private void abV() {
        if (this.cbB != null && this.cbB.threadData != null && this.cbB.threadData.aaC != null) {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.cbB.threadData.aaC.threadId, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(boolean z) {
        if (this.cbW != null) {
            if (z) {
                this.cbW.setText(d.j.privacy);
                Drawable drawable = aj.getDrawable(d.f.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.cbW.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.cbW.setText(d.j.public_open);
            Drawable drawable2 = aj.getDrawable(d.f.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.cbW.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.cbB.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ccm) {
            abV();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caP != null) {
            this.caP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caP != null) {
            this.caP.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.ajh ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajh, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.ceB != null) {
            if (cardPersonDynamicThreadData.ceB.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.ceB.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.ceB.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.ceB.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.ceB.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.ceB.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.ceB.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.ceB.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.ceB.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.ceB.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.ces);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.cey != null && cardPersonDynamicThreadData.cey.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.cey.length; i++) {
                sb.append(cardPersonDynamicThreadData.cey[i].text);
            }
            photoLiveCardData.setContent(photoLiveCardData.deleteBlackSpace(sb.toString()));
        }
        photoLiveCardData.setTitle(photoLiveCardData.deleteBlackSpace(cardPersonDynamicThreadData.title));
        photoLiveCardData.setThreadId(Long.parseLong(cardPersonDynamicThreadData.threadId));
        return photoLiveCardData;
    }

    private int a(CardPersonDynamicThreadData.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.e> a(CardPersonDynamicThreadData.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
            if (labelInfoArr[i] != null) {
                eVar.ev(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean e(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.threadData == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.threadData.c(false, true, this.ccp);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(c));
        this.mTitle.setText(c);
        k.a(this.mTitle, cardPersonDynamicThreadData.threadData.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        return true;
    }
}
