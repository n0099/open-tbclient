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
    private boolean asw;
    private final Runnable eKd;
    private long ehY;
    private String eia;
    private boolean eib;
    private TbPageContext fAF;
    private TextView fAG;
    private TextView fAH;
    private FrameLayout fAI;
    private RelativeLayout fAJ;
    private HeadImageView fAK;
    private HeadImageView fAL;
    private TextView fAM;
    private TextView fAN;
    private RelativeLayout fAO;
    private HeadImageView fAP;
    private HeadImageView fAQ;
    private TextView fAR;
    private TextView fAS;
    private LottieAnimationView fAT;
    private boolean fAU;
    private TextView fAV;
    private ImageView fAW;
    private long fAX;
    private boolean fAY;
    private a fAZ;
    private b fBa;
    private g fBb;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void beK();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void iu(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.fAX;
        alaRankListHeaderView.fAX = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.fAU = true;
        this.mHandler = new Handler();
        this.eKd = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAX <= 0) {
                    AlaRankListHeaderView.this.fAX = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAZ != null) {
                        AlaRankListHeaderView.this.fAZ.beK();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAG != null && "hour".equals(AlaRankListHeaderView.this.eia) && AlaRankListHeaderView.this.fAU && AlaRankListHeaderView.this.fAX >= 0) {
                    AlaRankListHeaderView.this.fAG.setText(String.format(AlaRankListHeaderView.this.fAF.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAX))));
                }
            }
        };
        this.ehY = j;
        this.eib = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAU = true;
        this.mHandler = new Handler();
        this.eKd = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAX <= 0) {
                    AlaRankListHeaderView.this.fAX = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAZ != null) {
                        AlaRankListHeaderView.this.fAZ.beK();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAG != null && "hour".equals(AlaRankListHeaderView.this.eia) && AlaRankListHeaderView.this.fAU && AlaRankListHeaderView.this.fAX >= 0) {
                    AlaRankListHeaderView.this.fAG.setText(String.format(AlaRankListHeaderView.this.fAF.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAX))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAU = true;
        this.mHandler = new Handler();
        this.eKd = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAX <= 0) {
                    AlaRankListHeaderView.this.fAX = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAZ != null) {
                        AlaRankListHeaderView.this.fAZ.beK();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAG != null && "hour".equals(AlaRankListHeaderView.this.eia) && AlaRankListHeaderView.this.fAU && AlaRankListHeaderView.this.fAX >= 0) {
                    AlaRankListHeaderView.this.fAG.setText(String.format(AlaRankListHeaderView.this.fAF.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAX))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.fAG = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.fAV = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.fAW = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.fAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.zl().awC.ZK)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.fAF, new String[]{com.baidu.live.v.a.zl().awC.ZK}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.eia)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.fAH = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.fAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.fAU = !AlaRankListHeaderView.this.fAU;
                AlaRankListHeaderView.this.fAH.setText(AlaRankListHeaderView.this.fAU ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.fBa != null) {
                    AlaRankListHeaderView.this.fBa.iu(AlaRankListHeaderView.this.fAU);
                }
            }
        });
        this.fAI = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.fAJ = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.fAK = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.fAK.setIsRound(true);
        this.fAK.setAutoChangeStyle(false);
        this.fAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fBb != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.fBb.cSm != 1 || AlaRankListHeaderView.this.fBb.live_id <= 0 || AlaRankListHeaderView.this.fBb.live_id == AlaRankListHeaderView.this.ehY || AlaRankListHeaderView.this.eib) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fAF.getPageActivity(), AlaRankListHeaderView.this.fBb.user_id, AlaRankListHeaderView.this.fBb.user_name, AlaRankListHeaderView.this.fBb.eAx, AlaRankListHeaderView.this.fBb.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awC.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.fAF.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.fBb.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.fAL = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.fAL.setIsRound(true);
        this.fAL.setAutoChangeStyle(false);
        this.fAM = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.fAN = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.fAP = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.fAO = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.fAP.setIsRound(true);
        this.fAP.setAutoChangeStyle(false);
        this.fAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fBb != null && AlaRankListHeaderView.this.fBb.eAa != null && AlaRankListHeaderView.this.fBb.eAa.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.fBb.eAa.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fAF.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.fAQ = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.fAQ.setIsRound(true);
        this.fAQ.setAutoChangeStyle(false);
        this.fAR = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.fAS = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.fAT = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.fAF = tbPageContext;
        this.eia = str;
        initView();
        if (j > 0 && "hour".equals(this.eia) && !this.fAY) {
            this.fAY = true;
            this.fAX = j;
            this.fAG.setText(String.format(this.fAF.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fAX))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btD() {
        if (this.aiq == null) {
            this.aiq = new AnimatorSet();
        }
        this.aiq.cancel();
        HeadImageView headImageView = this.fAU ? this.fAL : this.fAK;
        HeadImageView headImageView2 = this.fAU ? this.fAK : this.fAL;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.fAU ? this.fAQ : this.fAP;
        HeadImageView headImageView4 = this.fAU ? this.fAP : this.fAQ;
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
            if (!this.asw) {
                this.fAL.setAlpha(0);
                this.fAL.setVisibility(0);
                this.fAQ.setAlpha(0);
                this.fAQ.setVisibility(0);
            }
            this.fBb = gVar;
            if (this.fAU) {
                this.fAK.startLoad(gVar.avatar, 12, false);
            } else {
                this.fAL.startLoad(gVar.avatar, 12, false);
            }
            this.fAM.setText(gVar.getName_show());
            this.fAN.setText(String.format(this.fAF.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.cSm == 1) {
                this.fAT.setVisibility(0);
                this.fAT.loop(true);
                this.fAT.setAnimation("anchor_living.json");
                this.fAT.playAnimation();
            } else {
                this.fAT.setVisibility(8);
            }
            if (gVar.eAa != null && (aVar = gVar.eAa.get(0)) != null) {
                if (this.fAU) {
                    this.fAP.startLoad(aVar.portrait, 12, false);
                } else {
                    this.fAQ.startLoad(aVar.portrait, 12, false);
                }
                this.fAR.setText(aVar.eAb);
                this.fAS.setText(String.format(this.fAF.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.eAc)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.asw) {
                        AlaRankListHeaderView.this.btD();
                    }
                    AlaRankListHeaderView.this.asw = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eia)) {
            this.fAV.setVisibility(0);
            this.fAW.setVisibility(8);
            this.fAG.setText(this.fAF.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eia)) {
            this.fAV.setVisibility(8);
            this.fAW.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.fAX > 0 && !z) {
                this.fAG.setText(String.format(this.fAF.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.fAX))));
                startCountDown();
            } else {
                this.fAG.setText(this.fAF.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.eia)) {
            this.mRootView.setVisibility(0);
            this.fAW.setVisibility(8);
            this.fAV.setVisibility(8);
            this.fAI.setVisibility(0);
            if (this.fAX >= 0 && this.fAU) {
                this.fAG.setText(String.format(this.fAF.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fAX))));
            } else if (!this.fAU) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.AZ()).append(":00-").append("00".equals(i.AY()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.AY()).append(":00");
                this.fAG.setText(sb);
            }
        } else if ("charm_day".equals(this.eia)) {
            this.mRootView.setVisibility(8);
            this.fAW.setVisibility(8);
            this.fAV.setVisibility(8);
            this.fAI.setVisibility(8);
            this.fAG.setVisibility(8);
            this.fAH.setVisibility(8);
        } else {
            this.fAI.setVisibility(8);
            this.fAW.setVisibility(8);
            this.fAV.setVisibility(8);
            this.fAG.setText(this.fAF.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.fAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.fAF.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.fAF, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.fAI != null) {
            this.fAI.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eKd);
        this.mHandler.postDelayed(this.eKd, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eKd);
    }

    public void setCountDownCallback(a aVar) {
        this.fAZ = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.fBa = bVar;
    }
}
