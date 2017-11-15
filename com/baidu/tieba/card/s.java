package com.baidu.tieba.card;

import android.graphics.Rect;
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
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.AlaPlayAnimationView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class s extends a<CardPersonDynamicThreadData> {
    private boolean aiR;
    private View aol;
    private View.OnClickListener bRh;
    private TbImageView.a bSB;
    public PlayVoiceBntNew bSW;
    private TextView bSY;
    private ConstrainImageGroup bSZ;
    private AlaPlayAnimationView bSe;
    private CustomMessageListener bSf;
    public ThreadViewAndCommentInfoLayout bTM;
    private CardPersonDynamicThreadData bTN;
    private LinearLayout bTO;
    private TextView bTP;
    private TextView bTQ;
    private TextView bTR;
    private PhotoLiveCoverView bTS;
    private View bTT;
    private TbImageView bTU;
    private ImageView bTV;
    private LinearLayout bTW;
    private TextView bTX;
    private LinearLayout bTY;
    private LinearLayout bTZ;
    private final View.OnClickListener bTa;
    private final String bTf;
    private final String bTg;
    private final View.OnClickListener bTk;
    private TextView bUa;
    private TextView bUb;
    private TextView bUc;
    private TextView bUd;
    private View bUe;
    private boolean bUf;
    com.baidu.tieba.view.i bUg;
    private ThreadCommentAndPraiseInfoLayout boM;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bTf = "1";
        this.bTg = "2";
        this.mSkinType = 3;
        this.aiR = true;
        this.bUg = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.card.s.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (s.this.bTN != null && !StringUtils.isNull(s.this.bTN.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(s.this.bTN.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.i
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? s.this.mContext.getResources().getColor(d.C0080d.cp_link_tip_c) : s.this.mContext.getResources().getColor(d.C0080d.cp_link_tip_a));
            }
        };
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.ZJ() != null) {
                    s.this.ZJ().a(view, s.this.bTN);
                }
                if (s.this.bTN.bVJ != 33) {
                    if (s.this.bTN.bVJ != 60) {
                        if (s.this.bTN.bVJ != 40 || s.this.bTN.bVM != 2) {
                            s.this.aab();
                            return;
                        } else {
                            BdToast.b(s.this.getContext(), s.this.getContext().getString(d.j.video_check_click_msg), d.f.icon_toast_game_error).tq();
                            return;
                        }
                    }
                    TiebaStatic.log("c12333");
                    if (s.this.bTN.blt.rM().live_status != 1) {
                        s.this.aai();
                        return;
                    } else {
                        s.this.aah();
                        return;
                    }
                }
                TiebaStatic.log("c10254");
                s.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(s.this.mPageContext.getPageActivity(), s.this.bTN.threadId).cz(PhotoLiveActivityConfig.KEY_FROM_MY_OR_HIS_THREAD).bC(23014).pi()));
            }
        };
        this.bSf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && s.this.bTN != null && s.this.bTN.threadId != null && s.this.mTitle != null && s.this.bSY != null && ((String) customResponsedMessage.getData()).equals(s.this.bTN.threadId) && !s.this.ZN()) {
                    m.a(s.this.mTitle, s.this.bTN.threadId, d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                    m.a(s.this.bSY, s.this.bTN.threadId, d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
                }
            }
        };
        this.bTk = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> ZJ = s.this.ZJ();
                if (ZJ != null) {
                    view.setTag("1");
                    ZJ.a(view, s.this.bTN);
                }
            }
        };
        this.bTa = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<CardPersonDynamicThreadData> ZJ = s.this.ZJ();
                if (ZJ != null) {
                    view.setTag("2");
                    ZJ.a(view, s.this.bTN);
                }
            }
        };
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.card.s.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && s.this.bTU != null) {
                    s.this.bTU.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.bTO = (LinearLayout) this.mRootView.findViewById(d.g.left_time_view);
        this.bTP = (TextView) this.mRootView.findViewById(d.g.month_num);
        this.bTQ = (TextView) this.mRootView.findViewById(d.g.day_num);
        this.bTR = (TextView) this.mRootView.findViewById(d.g.source_bar);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.thread_title);
        this.bSW = (PlayVoiceBntNew) this.mRootView.findViewById(d.g.card_dynamic_thread_abstract_voice);
        this.bSW.setAfterClickListener(this.bTa);
        this.bSY = (TextView) this.mRootView.findViewById(d.g.thread_content);
        this.bSY.setVisibility(8);
        this.bSZ = (ConstrainImageGroup) this.mRootView.findViewById(d.g.card_dynamic_thread_img_layout);
        this.bSZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16));
        this.bSZ.setChildClickListener(this.bTk);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSZ.setImageProcessor(fVar);
        this.bTT = this.mRootView.findViewById(d.g.thread_view_img_container);
        this.bTU = (TbImageView) this.mRootView.findViewById(d.g.thread_video_thumbnail);
        this.bTV = (ImageView) this.mRootView.findViewById(d.g.thread_img_pause_play);
        this.bTS = (PhotoLiveCoverView) this.mRootView.findViewById(d.g.photo_live_cover_view);
        this.bTM = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(d.g.card_dynamic_thread_info_layout);
        this.bTZ = (LinearLayout) this.mRootView.findViewById(d.g.duration_container);
        this.bUa = (TextView) this.mRootView.findViewById(d.g.video_duration);
        this.bUb = (TextView) this.mRootView.findViewById(d.g.video_play_count);
        this.bUc = (TextView) this.mRootView.findViewById(d.g.audience_count);
        this.bSe = (AlaPlayAnimationView) this.mRootView.findViewById(d.g.ala_play);
        this.bUd = (TextView) this.mRootView.findViewById(d.g.fake_video_state);
        this.bTW = (LinearLayout) this.mRootView.findViewById(d.g.shared_ala_live_layout);
        this.bTX = (TextView) this.mRootView.findViewById(d.g.shared_ala_live_room_title);
        this.bTY = (LinearLayout) this.mRootView.findViewById(d.g.llAlaLivingLogLayout);
        this.bTY.setVisibility(8);
        this.bUe = this.mRootView.findViewById(d.g.divider_line_above_praise);
        this.aol = this.mRootView.findViewById(d.g.divider_line);
        this.boM = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_thread_info_layout);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this.bRh);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setShareVisible(true);
        this.boM.setIsBarViewVisible(false);
        this.boM.setFrom(1);
        this.boM.setShareReportFrom(6);
        this.boM.setStType("person_page");
        this.boM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.ZJ() != null) {
                    s.this.ZJ().a(view, s.this.bTN);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.i(this.bTP, d.C0080d.cp_cont_j);
            aj.i(this.bTQ, d.C0080d.cp_cont_b);
            aj.i(this.bTR, d.C0080d.cp_cont_f);
            aj.i(this.mTitle, d.C0080d.cp_cont_b);
            aj.i(this.bSY, d.C0080d.cp_cont_f);
            aj.i(this.bTX, d.C0080d.cp_cont_f);
            this.bTM.onChangeSkinType();
            this.boM.onChangeSkinType();
            aj.k(this.aol, d.C0080d.cp_bg_line_e);
            aj.k(this.bTX, d.C0080d.cp_bg_line_e);
            aj.k(this.bUe, d.C0080d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_dynamic_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bTN = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bRh);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bTO.setVisibility(cardPersonDynamicThreadData.bVU ? 0 : 4);
        this.aol.setVisibility(cardPersonDynamicThreadData.bVU ? 0 : 8);
        if (cardPersonDynamicThreadData.bVV) {
            this.aol.setVisibility(8);
        }
        this.bUf = cardPersonDynamicThreadData.bVJ == 40 && cardPersonDynamicThreadData.bVM == 2;
        d(cardPersonDynamicThreadData);
        this.bTP.setText(cardPersonDynamicThreadData.bVN);
        this.bTQ.setText(cardPersonDynamicThreadData.date);
        if (cardPersonDynamicThreadData.bVT != null && cardPersonDynamicThreadData.bVT.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bVT.length; i++) {
                sb.append(am.e(cardPersonDynamicThreadData.bVT[i].forum_name, 14, "..."));
                if (i < cardPersonDynamicThreadData.bVT.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(d.j.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(d.j.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.bTR.setText(sb2);
                this.bTR.setVisibility(0);
            } else {
                this.bTR.setVisibility(8);
            }
        } else {
            this.bTR.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.bVQ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.bSW.setVisibility(0);
            dE(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.bSW.setVoiceModel(voiceModel);
            this.bSW.setTag(voiceModel);
            this.bSW.bjz();
            if (voiceModel != null) {
                this.bSW.ny(voiceModel.voice_status.intValue());
            }
        } else {
            this.bSW.setVisibility(8);
            dE(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.bVP;
        aj.j(this.bTW, d.C0080d.transparent);
        this.bTX.setVisibility(8);
        this.bTY.setVisibility(8);
        this.bTW.setVisibility(0);
        this.bTS.setVisibility(8);
        this.bTT.setVisibility(8);
        this.bUd.setVisibility(8);
        this.bTZ.setVisibility(8);
        this.bUc.setVisibility(8);
        this.bSe.bBp();
        if (cardPersonDynamicThreadData.bVJ == 36) {
            this.bSZ.setVisibility(8);
            this.bUe.setVisibility(0);
        } else if (cardPersonDynamicThreadData.bVJ == 33) {
            this.bSZ.setVisibility(8);
            this.bUe.setVisibility(8);
            if (com.baidu.tbadk.core.h.oT().oZ() && cardPersonDynamicThreadData.bVR != null && !StringUtils.isNull(cardPersonDynamicThreadData.bVR.livecover_src)) {
                this.bTS.setVisibility(0);
                PhotoLiveCardData c = c(cardPersonDynamicThreadData);
                if (2 == a(cardPersonDynamicThreadData.bVR)) {
                    this.bTS.setShowExpression(false);
                } else {
                    this.bTS.setShowExpression(true);
                }
                this.bTS.setShowImage(com.baidu.tbadk.core.h.oT().oZ());
                this.bTS.setChooseStyle(c.getShowStyle());
                this.bTS.setData(c);
            }
        } else if (cardPersonDynamicThreadData.bVJ == 40 || this.bTN.bVJ == 50) {
            this.bSZ.setVisibility(8);
            this.bUe.setVisibility(8);
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                this.bTT.setVisibility(0);
                this.bTV.setVisibility(0);
                this.bTV.setImageResource(d.f.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTT.getLayoutParams();
                int width = this.bTT.getWidth();
                if (width == 0) {
                    width = (int) getContext().getResources().getDimension(d.e.ds672);
                }
                layoutParams.height = (int) (0.5625d * width);
                this.bTT.setLayoutParams(layoutParams);
                if (this.bTN.videoInfo != null) {
                    this.bTU.setDefaultErrorResource(0);
                    this.bTU.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.bTU.setEvent(this.bSB);
                    this.bTU.startLoad(this.bTN.videoInfo.thumbnail_url, 17, false);
                    if (this.bUf) {
                        this.bUd.setVisibility(0);
                        this.bUd.setText(String.format(this.mContext.getResources().getString(d.j.video_review_state), new Object[0]));
                    } else {
                        this.bTZ.setVisibility(0);
                        this.bUa.setText(am.cX(this.bTN.videoInfo.video_duration.intValue() * 1000));
                        this.bUb.setText(String.format(this.mContext.getResources().getString(d.j.play_count), am.A(this.bTN.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.bTN.bVJ == 60 || this.bTN.bVJ == 49) {
            this.bSZ.setVisibility(8);
            this.bUe.setVisibility(8);
            if (this.bTN.blt.rM() != null && this.bTN.blt.rM().UQ != null && this.bTN.bVJ == 60) {
                String str = this.bTN.blt.rM().UQ.user_name;
                if (com.baidu.tbadk.util.w.gX(str) > 14) {
                    str = com.baidu.tbadk.util.w.H(str, 14) + "...";
                }
                this.bTX.setText(m.aG(str + ":", this.bTN.blt.getTitle()));
                this.bTX.setVisibility(0);
            } else {
                this.bTX.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                this.bTT.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bTT.getLayoutParams();
                int width2 = this.bTT.getWidth();
                if (width2 == 0) {
                    width2 = (int) getContext().getResources().getDimension(d.e.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.bTT.setLayoutParams(layoutParams2);
                if (this.bTN.blt.rM() != null) {
                    this.bTU.setDefaultErrorResource(0);
                    this.bTU.setDefaultBgResource(d.f.pic_bg_video_frs);
                    this.bTU.setEvent(this.bSB);
                    this.bTU.startLoad(cardPersonDynamicThreadData.blt.rM().cover, 10, false);
                    this.bTV.setImageResource(d.f.btn_icon_play_live_on_n);
                    this.bSe.aal();
                    aj.j(this.bTW, d.C0080d.cp_bg_line_e);
                    this.bUc.setVisibility(0);
                    this.bUc.setText(String.format(this.mContext.getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bTN.blt.rM().audience_count)));
                }
            }
        } else {
            if (com.baidu.tbadk.core.h.oT().oZ() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bh bhVar = cardPersonDynamicThreadData.blt;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                    this.bSZ.setVisibility(0);
                    this.bUe.setVisibility(8);
                    this.bSZ.setFromCDN(this.aiR);
                    this.bSZ.setSingleImageRatio(0.67d);
                    this.bSZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.s.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z) {
                            if (z) {
                                s.this.aab();
                            } else {
                                s.this.a(view, linkedList, i2, bhVar);
                            }
                        }
                    });
                    this.bSZ.setImageMediaList(linkedList);
                } else {
                    this.bSZ.setVisibility(8);
                    this.bUe.setVisibility(0);
                }
            } else {
                this.bSZ.setVisibility(8);
                this.bUe.setVisibility(0);
            }
            this.bTW.setVisibility(8);
        }
        aaa();
        b(cardPersonDynamicThreadData);
    }

    private void dE(boolean z) {
        if (this.bSZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSZ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.bSZ.setLayoutParams(layoutParams);
        }
    }

    private void b(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.bUf) {
                this.boM.setCommentClickable(false);
                this.boM.setAgreeClickable(false);
                this.boM.setShareClickable(false);
            } else {
                this.boM.setCommentClickable(true);
                this.boM.setAgreeClickable(true);
                this.boM.setShareClickable(true);
            }
            this.boM.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.bVJ == 60) {
                this.boM.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.bVT != null) {
                this.boM.setMultiForumCount(cardPersonDynamicThreadData.bVT.length);
            }
            this.boM.setData(cardPersonDynamicThreadData.blt);
        }
    }

    private void aaa() {
        this.bSW.setClickable(true);
        int childCount = this.bSZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSZ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void aah() {
        if (this.bTN != null && this.bTN.blt != null && this.bTN.blt.rM() != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.no_network_guide);
                return;
            }
            if (!ZN()) {
                m.jL(this.bTN.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bTN.blt.rM());
            if (this.bTN.blt.rM().UQ != null) {
                alaLiveInfoCoreData.userName = this.bTN.blt.rM().UQ.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aai() {
        if (this.bTN != null && this.bTN.blt != null && this.bTN.blt.rM() != null && this.bTN.blt.rM().UR != null) {
            if (!ZN()) {
                m.jL(this.bTN.threadId);
            }
            if (this.bTN.blt.rM().UR.record_tid <= 0) {
                aah();
                return;
            }
            String valueOf = String.valueOf(this.bTN.blt.rM().UR.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source("profile");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (this.bTN != null) {
            if (!ZN()) {
                m.jL(this.bTN.threadId);
                m.a(this.mTitle, this.bTN.threadId, d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSY, this.bTN.threadId, d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.bTN.bVJ == 40) {
                pbActivityConfig.setVideo_source("profile");
            }
            pbActivityConfig.createFromThreadCfg(this.bTN.blt, null, "person_page", 18005, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.bTN.blt.getFid()));
            pbActivityConfig.setForumName(this.bTN.blt.rz());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZN() {
        return this.bTN.bVl && !this.bTN.aCE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                imageUrlData.urlType = this.aiR ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private PhotoLiveCardData c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return null;
        }
        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
        if (cardPersonDynamicThreadData.bVR != null) {
            if (cardPersonDynamicThreadData.bVR.zan != null) {
                photoLiveCardData.setPraiseNum(cardPersonDynamicThreadData.bVR.zan.num);
            }
            photoLiveCardData.setLastModifiedTime(cardPersonDynamicThreadData.bVR.last_modified_time);
            photoLiveCardData.setPostNum(cardPersonDynamicThreadData.bVR.post_num);
            photoLiveCardData.setLiveCoverSrcBsize(cardPersonDynamicThreadData.bVR.livecover_src_bsize);
            photoLiveCardData.setExpressionDatas(a(cardPersonDynamicThreadData.bVR.labelList));
            photoLiveCardData.setCover(cardPersonDynamicThreadData.bVR.livecover_src);
            photoLiveCardData.setContent(cardPersonDynamicThreadData.bVR.content);
            photoLiveCardData.setShowExpressionViewIndex(cardPersonDynamicThreadData.bVR.showExpressionViewIndex);
            photoLiveCardData.setShowStyle(cardPersonDynamicThreadData.bVR.showStyle);
        }
        photoLiveCardData.setAuthorId(String.valueOf(cardPersonDynamicThreadData.userId));
        photoLiveCardData.setAuthorName(cardPersonDynamicThreadData.userName);
        photoLiveCardData.setAuthorPortrait(cardPersonDynamicThreadData.userPortrait);
        photoLiveCardData.setDiscussNum(cardPersonDynamicThreadData.bVK);
        photoLiveCardData.setForumId(Long.parseLong(cardPersonDynamicThreadData.forumId));
        photoLiveCardData.setForumName(cardPersonDynamicThreadData.forumName);
        if (cardPersonDynamicThreadData.bVO != null && cardPersonDynamicThreadData.bVO.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.bVO.length; i++) {
                sb.append(cardPersonDynamicThreadData.bVO[i].text);
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
                eVar.eu(labelInfoArr[i].labelHot);
                eVar.setLabelName(labelInfoArr[i].labelName);
                eVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.blt == null) {
            return false;
        }
        SpannableStringBuilder c = cardPersonDynamicThreadData.blt.c(false, true, this.bUf);
        if (c == null || StringUtils.isNull(c.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(c));
        this.mTitle.setText(c);
        m.a(this.mTitle, cardPersonDynamicThreadData.blt.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        return true;
    }
}
