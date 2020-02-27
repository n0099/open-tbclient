package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet aiq;
    private boolean asv;
    private final Runnable eJP;
    private long ehK;
    private String ehM;
    private boolean ehN;
    private HeadImageView fAA;
    private HeadImageView fAB;
    private TextView fAC;
    private TextView fAD;
    private LottieAnimationView fAE;
    private boolean fAF;
    private TextView fAG;
    private ImageView fAH;
    private long fAI;
    private boolean fAJ;
    private a fAK;
    private b fAL;
    private g fAM;
    private TbPageContext fAq;
    private TextView fAr;
    private TextView fAs;
    private FrameLayout fAt;
    private RelativeLayout fAu;
    private HeadImageView fAv;
    private HeadImageView fAw;
    private TextView fAx;
    private TextView fAy;
    private RelativeLayout fAz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void beH();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void iu(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.fAI;
        alaRankListHeaderView.fAI = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.fAF = true;
        this.mHandler = new Handler();
        this.eJP = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAI <= 0) {
                    AlaRankListHeaderView.this.fAI = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAK != null) {
                        AlaRankListHeaderView.this.fAK.beH();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAr != null && "hour".equals(AlaRankListHeaderView.this.ehM) && AlaRankListHeaderView.this.fAF && AlaRankListHeaderView.this.fAI >= 0) {
                    AlaRankListHeaderView.this.fAr.setText(String.format(AlaRankListHeaderView.this.fAq.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAI))));
                }
            }
        };
        this.ehK = j;
        this.ehN = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAF = true;
        this.mHandler = new Handler();
        this.eJP = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAI <= 0) {
                    AlaRankListHeaderView.this.fAI = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAK != null) {
                        AlaRankListHeaderView.this.fAK.beH();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAr != null && "hour".equals(AlaRankListHeaderView.this.ehM) && AlaRankListHeaderView.this.fAF && AlaRankListHeaderView.this.fAI >= 0) {
                    AlaRankListHeaderView.this.fAr.setText(String.format(AlaRankListHeaderView.this.fAq.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAI))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAF = true;
        this.mHandler = new Handler();
        this.eJP = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAI <= 0) {
                    AlaRankListHeaderView.this.fAI = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAK != null) {
                        AlaRankListHeaderView.this.fAK.beH();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAr != null && "hour".equals(AlaRankListHeaderView.this.ehM) && AlaRankListHeaderView.this.fAF && AlaRankListHeaderView.this.fAI >= 0) {
                    AlaRankListHeaderView.this.fAr.setText(String.format(AlaRankListHeaderView.this.fAq.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAI))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.fAr = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.fAG = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.fAH = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.fAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.zj().awA.ZK)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.fAq, new String[]{com.baidu.live.v.a.zj().awA.ZK}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.ehM)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.fAs = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.fAs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.fAF = !AlaRankListHeaderView.this.fAF;
                AlaRankListHeaderView.this.fAs.setText(AlaRankListHeaderView.this.fAF ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.fAL != null) {
                    AlaRankListHeaderView.this.fAL.iu(AlaRankListHeaderView.this.fAF);
                }
            }
        });
        this.fAt = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.fAu = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.fAv = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.fAv.setIsRound(true);
        this.fAv.setAutoChangeStyle(false);
        this.fAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fAM != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.fAM.cSk != 1 || AlaRankListHeaderView.this.fAM.live_id <= 0 || AlaRankListHeaderView.this.fAM.live_id == AlaRankListHeaderView.this.ehK || AlaRankListHeaderView.this.ehN) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fAq.getPageActivity(), AlaRankListHeaderView.this.fAM.user_id, AlaRankListHeaderView.this.fAM.user_name, AlaRankListHeaderView.this.fAM.eAj, AlaRankListHeaderView.this.fAM.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zj().awA.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.fAq.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.fAM.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.fAw = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.fAw.setIsRound(true);
        this.fAw.setAutoChangeStyle(false);
        this.fAx = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.fAy = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.fAA = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.fAz = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.fAA.setIsRound(true);
        this.fAA.setAutoChangeStyle(false);
        this.fAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fAM != null && AlaRankListHeaderView.this.fAM.ezM != null && AlaRankListHeaderView.this.fAM.ezM.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.fAM.ezM.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fAq.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.fAB = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.fAB.setIsRound(true);
        this.fAB.setAutoChangeStyle(false);
        this.fAC = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.fAD = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.fAE = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, String str3) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent intent = activity.getIntent();
            long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
            String stringExtra = intent.getStringExtra("group_id");
            String stringExtra2 = intent.getStringExtra("live_id");
            boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
            String stringExtra3 = intent.getStringExtra("live_owner_uid");
            if (longExtra == j) {
                stringExtra3 = j + "";
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(context, j + "", str, str2, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, str3, "")));
            activity.finish();
        }
    }

    public void a(TbPageContext tbPageContext, String str, long j) {
        this.fAq = tbPageContext;
        this.ehM = str;
        initView();
        if (j > 0 && "hour".equals(this.ehM) && !this.fAJ) {
            this.fAJ = true;
            this.fAI = j;
            this.fAr.setText(String.format(this.fAq.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fAI))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btA() {
        if (this.aiq == null) {
            this.aiq = new AnimatorSet();
        }
        this.aiq.cancel();
        HeadImageView headImageView = this.fAF ? this.fAw : this.fAv;
        HeadImageView headImageView2 = this.fAF ? this.fAv : this.fAw;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.fAF ? this.fAB : this.fAA;
        HeadImageView headImageView4 = this.fAF ? this.fAA : this.fAB;
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(headImageView3, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(headImageView3, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(headImageView3, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(headImageView4, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(headImageView4, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(headImageView4, "alpha", 0.0f, 1.0f);
        if (this.mAnimators == null) {
            this.mAnimators = new ArrayList<>();
        }
        this.mAnimators.clear();
        this.mAnimators.add(ofFloat);
        this.mAnimators.add(ofFloat2);
        this.mAnimators.add(ofFloat3);
        this.mAnimators.add(ofFloat4);
        this.mAnimators.add(ofFloat5);
        this.mAnimators.add(ofFloat6);
        this.mAnimators.add(ofFloat7);
        this.mAnimators.add(ofFloat8);
        this.mAnimators.add(ofFloat9);
        this.mAnimators.add(ofFloat10);
        this.mAnimators.add(ofFloat11);
        this.mAnimators.add(ofFloat12);
        this.aiq.setDuration(1000L);
        this.aiq.playTogether(this.mAnimators);
        this.aiq.setInterpolator(new AccelerateInterpolator());
        this.aiq.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.asv) {
                this.fAw.setAlpha(0);
                this.fAw.setVisibility(0);
                this.fAB.setAlpha(0);
                this.fAB.setVisibility(0);
            }
            this.fAM = gVar;
            if (this.fAF) {
                this.fAv.startLoad(gVar.avatar, 12, false);
            } else {
                this.fAw.startLoad(gVar.avatar, 12, false);
            }
            this.fAx.setText(gVar.getName_show());
            this.fAy.setText(String.format(this.fAq.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.cSk == 1) {
                this.fAE.setVisibility(0);
                this.fAE.loop(true);
                this.fAE.setAnimation("anchor_living.json");
                this.fAE.playAnimation();
            } else {
                this.fAE.setVisibility(8);
            }
            if (gVar.ezM != null && (aVar = gVar.ezM.get(0)) != null) {
                if (this.fAF) {
                    this.fAA.startLoad(aVar.portrait, 12, false);
                } else {
                    this.fAB.startLoad(aVar.portrait, 12, false);
                }
                this.fAC.setText(aVar.ezN);
                this.fAD.setText(String.format(this.fAq.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.ezO)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.asv) {
                        AlaRankListHeaderView.this.btA();
                    }
                    AlaRankListHeaderView.this.asv = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ehM)) {
            this.fAG.setVisibility(0);
            this.fAH.setVisibility(8);
            this.fAr.setText(this.fAq.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehM)) {
            this.fAG.setVisibility(8);
            this.fAH.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.fAI > 0 && !z) {
                this.fAr.setText(String.format(this.fAq.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.fAI))));
                startCountDown();
            } else {
                this.fAr.setText(this.fAq.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.ehM)) {
            this.mRootView.setVisibility(0);
            this.fAH.setVisibility(8);
            this.fAG.setVisibility(8);
            this.fAt.setVisibility(0);
            if (this.fAI >= 0 && this.fAF) {
                this.fAr.setText(String.format(this.fAq.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fAI))));
            } else if (!this.fAF) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.AX()).append(":00-").append("00".equals(i.AW()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.AW()).append(":00");
                this.fAr.setText(sb);
            }
        } else if ("charm_day".equals(this.ehM)) {
            this.mRootView.setVisibility(8);
            this.fAH.setVisibility(8);
            this.fAG.setVisibility(8);
            this.fAt.setVisibility(8);
            this.fAr.setVisibility(8);
            this.fAs.setVisibility(8);
        } else {
            this.fAt.setVisibility(8);
            this.fAH.setVisibility(8);
            this.fAG.setVisibility(8);
            this.fAr.setText(this.fAq.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.fAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.fAq.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.fAq, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.fAt != null) {
            this.fAt.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eJP);
        this.mHandler.postDelayed(this.eJP, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eJP);
    }

    public void setCountDownCallback(a aVar) {
        this.fAK = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.fAL = bVar;
    }
}
