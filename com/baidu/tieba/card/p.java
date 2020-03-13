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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.o;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class p extends a<CardPersonDynamicThreadData> {
    private TextView KA;
    private boolean NJ;
    public PlayVoiceBntNew NY;
    private TextView Pb;
    private TextView Pe;
    private TbImageView.a dMs;
    public ThreadCommentAndPraiseInfoLayout eNz;
    private CustomMessageListener fJy;
    private CardPersonDynamicThreadData fKG;
    public ThreadViewAndCommentInfoLayout fKS;
    private final String fKT;
    private final String fKU;
    private TextView fKV;
    private LinearLayout fKW;
    private TextView fKX;
    private TextView fKY;
    private TextView fKZ;
    private ConstrainImageGroup fKc;
    private View.OnClickListener fKh;
    private final View.OnClickListener fKi;
    private TextView fLa;
    private ImageView fLb;
    private o fLc;
    private View fLd;
    private TbImageView fLe;
    private ImageView fLf;
    private LinearLayout fLg;
    private TextView fLh;
    private LinearLayout fLi;
    private LinearLayout fLj;
    private TextView fLk;
    private TBLottieAnimationView fLl;
    private TextView fLm;
    private TextView fLn;
    public OriginalThreadCardView fLo;
    private View fLp;
    private View fLq;
    private boolean fLr;
    private boolean fLs;
    com.baidu.tieba.view.f fLt;
    private o.a fLu;
    private final View.OnClickListener fLv;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mSkinType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fKT = "1";
        this.fKU = "2";
        this.mSkinType = 3;
        this.NJ = true;
        this.fLt = new com.baidu.tieba.view.f() { // from class: com.baidu.tieba.card.p.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (p.this.fKG != null && !StringUtils.isNull(p.this.fKG.forumName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(p.this.mContext).createNormalCfg(p.this.fKG.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }

            @Override // com.baidu.tieba.view.f
            public void a(TextPaint textPaint, boolean z) {
                textPaint.setColor(z ? p.this.mContext.getResources().getColor(R.color.cp_link_tip_c) : p.this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            }
        };
        this.fKh = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.buH() != null) {
                    p.this.buH().a(view, p.this.fKG);
                }
                if (p.this.fKG.fNR != 60) {
                    if ((p.this.fKG.fNR != 40 || p.this.fKG.fNT != 2) && !p.this.fLs) {
                        p.this.aMz();
                        return;
                    } else {
                        BdToast.a(p.this.getContext(), (CharSequence) p.this.getContext().getString(R.string.video_check_click_msg), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEH();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (p.this.fKG.cRg.aCH().live_status != 1) {
                    p.this.bvf();
                } else {
                    p.this.bve();
                }
            }
        };
        this.fJy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.p.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && p.this.fKG != null && p.this.fKG.threadId != null && p.this.mTitle != null && p.this.KA != null && ((String) customResponsedMessage.getData()).equals(p.this.fKG.threadId) && !p.this.isHost()) {
                    l.a(p.this.mTitle, p.this.fKG.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    l.a(p.this.KA, p.this.fKG.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                }
            }
        };
        this.fLu = new o.a() { // from class: com.baidu.tieba.card.p.8
            @Override // com.baidu.tieba.card.o.a
            public void setPrivacy(boolean z) {
                p.this.ko(z);
            }
        };
        this.fLv = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> buH = p.this.buH();
                if (buH != null) {
                    view.setTag("1");
                    buH.a(view, p.this.fKG);
                }
                p.this.aMz();
            }
        };
        this.fKi = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<CardPersonDynamicThreadData> buH = p.this.buH();
                if (buH != null) {
                    view.setTag("2");
                    buH.a(view, p.this.fKG);
                }
            }
        };
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.card.p.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && p.this.fLe != null) {
                    p.this.fLe.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.fKV = (TextView) this.mRootView.findViewById(R.id.year_num);
        this.fKW = (LinearLayout) this.mRootView.findViewById(R.id.left_time_view);
        this.fKX = (TextView) this.mRootView.findViewById(R.id.month_num);
        this.fKY = (TextView) this.mRootView.findViewById(R.id.day_num);
        this.fKZ = (TextView) this.mRootView.findViewById(R.id.source_bar);
        this.fLn = (TextView) this.mRootView.findViewById(R.id.video_under_review);
        this.fLa = (TextView) this.mRootView.findViewById(R.id.tv_privacy_status);
        this.fLb = (ImageView) this.mRootView.findViewById(R.id.iv_more);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.thread_title);
        this.NY = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fKi);
        this.KA = (TextView) this.mRootView.findViewById(R.id.thread_content);
        this.KA.setVisibility(8);
        this.fKc = (ConstrainImageGroup) this.mRootView.findViewById(R.id.card_dynamic_thread_img_layout);
        this.fKc.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fKc.setChildClickListener(this.fLv);
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.fKc.setImageProcessor(aVar);
        this.fLd = this.mRootView.findViewById(R.id.thread_view_img_container);
        this.fLe = (TbImageView) this.mRootView.findViewById(R.id.thread_video_thumbnail);
        this.fLf = (ImageView) this.mRootView.findViewById(R.id.thread_img_pause_play);
        this.fKS = (ThreadViewAndCommentInfoLayout) this.mRootView.findViewById(R.id.card_dynamic_thread_info_layout);
        this.fLj = (LinearLayout) this.mRootView.findViewById(R.id.duration_container);
        this.Pe = (TextView) this.mRootView.findViewById(R.id.video_duration);
        this.Pb = (TextView) this.mRootView.findViewById(R.id.video_play_count);
        this.fLk = (TextView) this.mRootView.findViewById(R.id.audience_count);
        this.fLl = (TBLottieAnimationView) this.mRootView.findViewById(R.id.ala_play);
        this.fLl.loop(true);
        am.a(this.fLl, R.raw.ala_play);
        this.fLm = (TextView) this.mRootView.findViewById(R.id.fake_video_state);
        this.fLg = (LinearLayout) this.mRootView.findViewById(R.id.shared_ala_live_layout);
        this.fLh = (TextView) this.mRootView.findViewById(R.id.shared_ala_live_room_title);
        this.fLi = (LinearLayout) this.mRootView.findViewById(R.id.llAlaLivingLogLayout);
        this.fLi.setVisibility(8);
        this.fLo = (OriginalThreadCardView) this.mRootView.findViewById(R.id.original_thread_info);
        this.fLp = this.mRootView.findViewById(R.id.divider_line_thick);
        this.fLq = this.mRootView.findViewById(R.id.divider_line_thin);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_thread_info_layout);
        if (this.eNz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNz.setLayoutParams(layoutParams);
        }
        this.eNz.setOnClickListener(this.fKh);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setShareVisible(true);
        this.eNz.setIsBarViewVisible(false);
        this.eNz.setFrom(13);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 8;
        dVar.cNI = 3;
        this.eNz.setAgreeStatisticData(dVar);
        this.eNz.setShareReportFrom(6);
        this.eNz.setStType("person_page");
        this.eNz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.buH() != null) {
                    p.this.buH().a(view, p.this.fKG);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.a(this.fLl, R.raw.ala_play);
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.fKV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fKX, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.fKY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fKZ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fLn, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fLa, (int) R.color.cp_cont_d);
            if (this.fLb != null) {
                this.fLb.setImageDrawable(SvgManager.aGC().a(R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.KA, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fLh, (int) R.color.cp_cont_f);
            if (this.fLc != null) {
                this.fLc.onChangeSkinType();
            }
            this.fKS.onChangeSkinType();
            this.eNz.onChangeSkinType();
            am.setBackgroundColor(this.fLp, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fLq, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.fLh, R.color.cp_bg_line_e);
            if (this.fLo != null) {
                this.fLo.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_dynamic_thread;
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
        this.fKG = cardPersonDynamicThreadData;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fKh);
        }
        this.fKV.setVisibility(cardPersonDynamicThreadData.fOd ? 0 : 8);
        this.fKW.setVisibility(cardPersonDynamicThreadData.fOc ? 0 : 4);
        this.fLp.setVisibility(cardPersonDynamicThreadData.fOc ? 0 : 8);
        this.fLq.setVisibility(cardPersonDynamicThreadData.fOc ? 8 : 0);
        if (cardPersonDynamicThreadData.fOe) {
            this.fLp.setVisibility(8);
            this.fLq.setVisibility(8);
        }
        this.fLr = cardPersonDynamicThreadData.fNR == 40 && cardPersonDynamicThreadData.fNT == 2;
        d(cardPersonDynamicThreadData);
        if (cardPersonDynamicThreadData.cRg != null) {
            this.fLs = cardPersonDynamicThreadData.cRg.isShareThread && cardPersonDynamicThreadData.fNT == 2;
        }
        this.fKV.setText(cardPersonDynamicThreadData.fNU);
        this.fKX.setText(cardPersonDynamicThreadData.fNV);
        this.fKY.setText(cardPersonDynamicThreadData.fNW);
        if (cardPersonDynamicThreadData.fOb != null && cardPersonDynamicThreadData.fOb.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cardPersonDynamicThreadData.fOb.length; i++) {
                sb.append(aq.cutChineseAndEnglishWithSuffix(cardPersonDynamicThreadData.fOb[i].forum_name, 14, StringHelper.STRING_MORE));
                if (i < cardPersonDynamicThreadData.fOb.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.mContext.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.mContext.getString(R.string.forum));
                }
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.fKZ.setText(sb2);
                this.fKZ.setVisibility(0);
            } else {
                this.fKZ.setText(R.string.person_homepage);
            }
        } else {
            this.fKZ.setText(R.string.person_homepage);
        }
        if (cardPersonDynamicThreadData.isHost) {
            if (cardPersonDynamicThreadData.from == 3) {
                this.fLa.setVisibility(8);
            } else if (cardPersonDynamicThreadData.from == 1) {
                this.fLa.setVisibility(0);
            }
            ko(cardPersonDynamicThreadData.isPrivacy);
            this.fLb.setVisibility(0);
            this.fLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (p.this.mPageContext != null) {
                        if (p.this.fLc == null) {
                            p.this.fLc = new o(p.this.mPageContext);
                            p.this.fLc.create();
                            p.this.fLc.a(p.this.fLu);
                        }
                        p.this.fLc.a(p.this.fKG);
                        p.this.fLc.show();
                    }
                }
            });
        } else {
            this.fLa.setVisibility(8);
            this.fLb.setVisibility(8);
        }
        VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.fNZ;
        if (voiceModelArr != null && voiceModelArr.length > 0) {
            this.NY.setVisibility(0);
            kn(true);
            VoiceData.VoiceModel voiceModel = voiceModelArr[0];
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHt();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
            this.NY.cMi();
        } else {
            this.NY.setVisibility(8);
            kn(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.fNY;
        am.setBackgroundResource(this.fLg, R.color.transparent);
        this.fLh.setVisibility(8);
        this.fLi.setVisibility(8);
        this.fLg.setVisibility(0);
        this.fLd.setVisibility(8);
        this.fLm.setVisibility(8);
        this.fLj.setVisibility(8);
        this.fLk.setVisibility(8);
        this.fLl.cancelAnimation();
        this.fLl.setVisibility(8);
        if (cardPersonDynamicThreadData.fNR == 36) {
            this.fKc.setVisibility(8);
        } else if (cardPersonDynamicThreadData.fNR == 40 || this.fKG.fNR == 50) {
            this.fKc.setVisibility(8);
            if (com.baidu.tbadk.core.i.azO().isShowImages()) {
                this.fLd.setVisibility(0);
                this.fLf.setVisibility(0);
                this.fLf.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLd.getLayoutParams();
                int width = this.fLd.getWidth();
                if (width == 0 || width > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width = (int) getContext().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams.height = (int) (width * 0.5625d);
                this.fLd.setLayoutParams(layoutParams);
                if (this.fKG.videoInfo != null) {
                    this.fLe.setDefaultErrorResource(0);
                    this.fLe.setPlaceHolder(3);
                    this.fLe.setEvent(this.dMs);
                    this.fLe.startLoad(this.fKG.videoInfo.thumbnail_url, 17, false);
                    if (this.fLr) {
                        this.fLm.setVisibility(0);
                        this.fLm.setText(String.format(this.mContext.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.fLj.setVisibility(0);
                        this.Pe.setText(aq.stringForVideoTime(this.fKG.videoInfo.video_duration.intValue() * 1000));
                        this.Pb.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fKG.videoInfo.play_count.intValue())));
                    }
                }
            }
        } else if (this.fKG.fNR == 60 || this.fKG.fNR == 49) {
            this.fKc.setVisibility(8);
            if (this.fKG.cRg.aCH() != null && this.fKG.cRg.aCH().user_info != null && this.fKG.fNR == 60) {
                String str = this.fKG.cRg.aCH().user_info.user_name;
                if (ad.getTextLengthWithEmoji(str) > 14) {
                    str = ad.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
                }
                this.fLh.setText(l.db(str + ":", this.fKG.cRg.getTitle()));
                this.fLh.setVisibility(0);
            } else {
                this.fLh.setVisibility(8);
            }
            if (com.baidu.tbadk.core.i.azO().isShowImages()) {
                this.fLd.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fLd.getLayoutParams();
                int width2 = this.fLd.getWidth();
                if (width2 == 0 || width2 > com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)) {
                    width2 = (int) getContext().getResources().getDimension(R.dimen.ds560);
                }
                layoutParams2.height = (width2 * 9) / 16;
                this.fLd.setLayoutParams(layoutParams2);
                if (this.fKG.cRg.aCH() != null) {
                    this.fLe.setDefaultErrorResource(0);
                    this.fLe.setPlaceHolder(3);
                    this.fLe.setEvent(this.dMs);
                    this.fLe.startLoad(cardPersonDynamicThreadData.cRg.aCH().cover, 10, false);
                    this.fLf.setVisibility(8);
                    this.fLl.setVisibility(0);
                    this.fLl.playAnimation();
                    am.setBackgroundResource(this.fLg, R.color.cp_bg_line_e);
                    this.fLk.setVisibility(0);
                    this.fLk.setText(String.format(this.mContext.getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.fKG.cRg.aCH().audience_count)));
                    this.eNz.getCommentContainer().setOnClickListener(this.fKh);
                } else {
                    this.eNz.getCommentContainer().setOnClickListener(this.eNz);
                }
            }
        } else {
            if (com.baidu.tbadk.core.i.azO().isShowImages() && mediaDataArr.length > 0) {
                final LinkedList linkedList = new LinkedList();
                final bj bjVar = cardPersonDynamicThreadData.cRg;
                for (MediaData mediaData : mediaDataArr) {
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.getCount(linkedList) > 0) {
                    this.fKc.setVisibility(0);
                    this.fKc.setFromCDN(this.NJ);
                    this.fKc.setSingleImageRatio(0.67d);
                    this.fKc.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.p.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z) {
                            if (z) {
                                p.this.aMz();
                            } else {
                                p.this.a(view, linkedList, i2, bjVar);
                            }
                        }
                    });
                    this.fKc.setImageMediaList(linkedList);
                } else {
                    this.fKc.setVisibility(8);
                }
            } else {
                this.fKc.setVisibility(8);
            }
            this.fLg.setVisibility(8);
        }
        if (cardPersonDynamicThreadData.cRg != null && cardPersonDynamicThreadData.cRg.cTR != null) {
            this.fLo.setVisibility(0);
            this.fLo.b(cardPersonDynamicThreadData.cRg.cTR);
            this.fLo.setOnClickListener(this);
            this.NY.setVisibility(8);
            this.fKc.setVisibility(8);
            this.fLg.setVisibility(8);
            if (this.fLs) {
                this.fLn.setVisibility(0);
            } else {
                this.fLn.setVisibility(8);
            }
        } else {
            this.fLo.setVisibility(8);
            this.fLn.setVisibility(8);
        }
        bvb();
        c(cardPersonDynamicThreadData);
    }

    private void kn(boolean z) {
        if (this.fKc != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKc.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
            }
            this.fKc.setLayoutParams(layoutParams);
        }
    }

    private void c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData != null) {
            if (this.fLr || this.fLs) {
                this.eNz.setCommentClickable(false);
                this.eNz.setAgreeClickable(false);
                this.eNz.setShareClickable(false);
                this.fLo.setClickable(false);
                this.fLb.setClickable(false);
            } else {
                this.eNz.setCommentClickable(true);
                this.eNz.setAgreeClickable(true);
                this.eNz.setShareClickable(true);
                this.fLo.setClickable(true);
                this.fLb.setClickable(true);
            }
            this.eNz.setCommentNumEnable(true);
            if (cardPersonDynamicThreadData.fNR == 60) {
                this.eNz.setCommentNumEnable(false);
            }
            if (cardPersonDynamicThreadData.fOb != null) {
                this.eNz.setMultiForumCount(cardPersonDynamicThreadData.fOb.length);
            }
            if (cardPersonDynamicThreadData.cRg != null) {
                this.eNz.setForumId(String.valueOf(cardPersonDynamicThreadData.cRg.getFid()));
            }
            this.eNz.setData(cardPersonDynamicThreadData.cRg);
        }
    }

    private void bvb() {
        this.NY.setClickable(true);
        int childCount = this.fKc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fKc.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void bve() {
        if (this.fKG != null && this.fKG.cRg != null && this.fKG.cRg.aCH() != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.no_network_guide);
                return;
            }
            if (!isHost()) {
                l.zT(this.fKG.threadId);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.fKG.cRg.aCH());
            if (this.fKG.cRg.aCH().user_info != null) {
                alaLiveInfoCoreData.userName = this.fKG.cRg.aCH().user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", "", false, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvf() {
        if (this.fKG != null && this.fKG.cRg != null && this.fKG.cRg.aCH() != null && this.fKG.cRg.aCH().share_info != null) {
            if (!isHost()) {
                l.zT(this.fKG.threadId);
            }
            if (this.fKG.cRg.aCH().share_info.record_tid <= 0) {
                bve();
                return;
            }
            String valueOf = String.valueOf(this.fKG.cRg.aCH().share_info.record_tid);
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setThreadData(this.fKG.cRg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMz() {
        if (this.fKG != null) {
            if (!isHost()) {
                l.zT(this.fKG.threadId);
                l.a(this.mTitle, this.fKG.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                l.a(this.KA, this.fKG.threadId, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mPageContext.getPageActivity());
            if (this.fKG.fNR == 40) {
                pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.PERSON_PROFILE);
            }
            pbActivityConfig.createFromThreadCfg(this.fKG.cRg, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            pbActivityConfig.setForumId(String.valueOf(this.fKG.cRg.getFid()));
            pbActivityConfig.setForumName(this.fKG.cRg.aCt());
            pbActivityConfig.setStartFrom(this.currentPageType);
            pbActivityConfig.setIsShareThread(this.fKG.cRg.isShareThread);
            pbActivityConfig.setThreadData(this.fKG.cRg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            if (this.fKG.cRg == null || !this.fKG.cRg.isShareThread) {
                return;
            }
            TiebaStatic.log(new an("c12943").cy("obj_type", "2").cy("tid", this.fKG.threadId).X("obj_param1", this.fKG.isHost ? 1 : 2));
        }
    }

    private void bvg() {
        if (this.fKG != null && this.fKG.cRg != null && this.fKG.cRg.cTR != null) {
            OriginalThreadInfo originalThreadInfo = this.fKG.cRg.cTR;
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.threadId, null, "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
            TiebaStatic.log(new an("c12943").cy("obj_type", "3").cy("tid", this.fKG.threadId).X("obj_param1", this.fKG.isHost ? 1 : 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (this.fLa != null) {
            if (z) {
                this.fLa.setText(R.string.privacy);
                Drawable drawable = am.getDrawable(R.drawable.icon_card_privacy);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.fLa.setCompoundDrawables(drawable, null, null, null);
                return;
            }
            this.fLa.setText(R.string.public_open);
            Drawable drawable2 = am.getDrawable(R.drawable.icon_card_open);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.fLa.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHost() {
        return this.fKG.isHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fLo) {
            bvg();
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKc != null) {
            this.fKc.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKc != null) {
            this.fKc.setImageViewPool(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.NJ ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCt(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "other");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private boolean d(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null || cardPersonDynamicThreadData.cRg == null) {
            return false;
        }
        SpannableStringBuilder d = cardPersonDynamicThreadData.cRg.d(false, true, this.fLr);
        if (d == null || StringUtils.isNull(d.toString())) {
            this.mTitle.setVisibility(8);
            return true;
        }
        this.mTitle.setVisibility(0);
        this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(d));
        this.mTitle.setText(d);
        if (isHost()) {
            return true;
        }
        l.a(this.mTitle, cardPersonDynamicThreadData.threadId, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }
}
