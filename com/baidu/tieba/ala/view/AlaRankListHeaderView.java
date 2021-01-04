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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
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
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.h;
import com.baidu.tieba.ala.data.p;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet baG;
    private boolean boq;
    private String grB;
    private boolean grC;
    private long grz;
    private AlaLastLiveroomInfo gtp;
    private final Runnable hfw;
    private TbPageContext iiA;
    private TextView iiB;
    private TextView iiC;
    private FrameLayout iiD;
    private RelativeLayout iiE;
    private HeadImageView iiF;
    private HeadImageView iiG;
    private TextView iiH;
    private TextView iiI;
    private RelativeLayout iiJ;
    private HeadImageView iiK;
    private HeadImageView iiL;
    private TextView iiM;
    private TextView iiN;
    private LottieAnimationView iiO;
    private boolean iiP;
    private TextView iiQ;
    private ImageView iiR;
    private long iiS;
    private boolean iiT;
    private a iiU;
    private b iiV;
    private com.baidu.tieba.ala.data.h iiW;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes11.dex */
    public interface a {
        void bYo();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void nf(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.iiS;
        alaRankListHeaderView.iiS = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.iiP = true;
        this.mHandler = new Handler();
        this.hfw = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.iiS <= 0) {
                    AlaRankListHeaderView.this.iiS = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.iiU != null) {
                        AlaRankListHeaderView.this.iiU.bYo();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.iiB != null && "hour".equals(AlaRankListHeaderView.this.grB) && AlaRankListHeaderView.this.iiP && AlaRankListHeaderView.this.iiS >= 0) {
                    AlaRankListHeaderView.this.iiB.setText(String.format(AlaRankListHeaderView.this.iiA.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.iiS))));
                }
            }
        };
        this.grz = j;
        this.grC = z;
        this.gtp = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iiP = true;
        this.mHandler = new Handler();
        this.hfw = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.iiS <= 0) {
                    AlaRankListHeaderView.this.iiS = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.iiU != null) {
                        AlaRankListHeaderView.this.iiU.bYo();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.iiB != null && "hour".equals(AlaRankListHeaderView.this.grB) && AlaRankListHeaderView.this.iiP && AlaRankListHeaderView.this.iiS >= 0) {
                    AlaRankListHeaderView.this.iiB.setText(String.format(AlaRankListHeaderView.this.iiA.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.iiS))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iiP = true;
        this.mHandler = new Handler();
        this.hfw = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.iiS <= 0) {
                    AlaRankListHeaderView.this.iiS = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.iiU != null) {
                        AlaRankListHeaderView.this.iiU.bYo();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.iiB != null && "hour".equals(AlaRankListHeaderView.this.grB) && AlaRankListHeaderView.this.iiP && AlaRankListHeaderView.this.iiS >= 0) {
                    AlaRankListHeaderView.this.iiB.setText(String.format(AlaRankListHeaderView.this.iiA.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.iiS))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_header_layout, this);
        this.iiB = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_refresh_tip);
        this.iiQ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_game_rule);
        this.iiR = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_flower_description);
        this.iiR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.af.a.SE().bwi.aNH)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.iiA, new String[]{com.baidu.live.af.a.SE().bwi.aNH}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.grB)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.iiC = (TextView) this.mRootView.findViewById(a.f.rank_list_switch);
        this.iiC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.iiP = !AlaRankListHeaderView.this.iiP;
                AlaRankListHeaderView.this.iiC.setText(AlaRankListHeaderView.this.iiP ? a.h.hour_rank_list_head_switch_cur : a.h.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.iiV != null) {
                    AlaRankListHeaderView.this.iiV.nf(AlaRankListHeaderView.this.iiP);
                }
            }
        });
        this.iiD = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.iiE = (RelativeLayout) this.mRootView.findViewById(a.f.rl_rank_first);
        this.iiF = (HeadImageView) this.mRootView.findViewById(a.f.rank_first);
        this.iiF.setIsRound(true);
        this.iiF.setAutoChangeStyle(false);
        this.iiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.iiW != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.iiW.eTW != 1 || AlaRankListHeaderView.this.iiW.live_id <= 0 || AlaRankListHeaderView.this.iiW.live_id == AlaRankListHeaderView.this.grz || AlaRankListHeaderView.this.grC) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.iiA.getPageActivity(), AlaRankListHeaderView.this.iiW.user_id, AlaRankListHeaderView.this.iiW.user_name, AlaRankListHeaderView.this.iiW.bdPortrait, AlaRankListHeaderView.this.iiW.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.SE().bwi.aOz) {
                        com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(AlaRankListHeaderView.this.iiW.live_id)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.iiA.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.gtp);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.iiW.live_id, "", "live_sdk");
                        com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        });
        this.iiG = (HeadImageView) this.mRootView.findViewById(a.f.rank_first2);
        this.iiG.setIsRound(true);
        this.iiG.setAutoChangeStyle(false);
        this.iiH = (TextView) this.mRootView.findViewById(a.f.name_rank_1);
        this.iiI = (TextView) this.mRootView.findViewById(a.f.point_rank_1);
        this.iiK = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.iiJ = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.iiK.setIsRound(true);
        this.iiK.setAutoChangeStyle(false);
        this.iiJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.iiW != null && AlaRankListHeaderView.this.iiW.gUD != null && AlaRankListHeaderView.this.iiW.gUD.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.iiW.gUD.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.iiA.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.iiL = (HeadImageView) this.mRootView.findViewById(a.f.charm_first2);
        this.iiL.setIsRound(true);
        this.iiL.setAutoChangeStyle(false);
        this.iiM = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.iiN = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.iiO = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, String str3) {
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
            String stringExtra = intent.getStringExtra("group_id");
            String stringExtra2 = intent.getStringExtra("live_id");
            boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
            String stringExtra3 = intent.getStringExtra("live_owner_uid");
            if (longExtra == j) {
                stringExtra3 = j + "";
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(context, j + "", str, str2, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, str3)));
        }
    }

    public void a(TbPageContext tbPageContext, String str, long j) {
        this.iiA = tbPageContext;
        this.grB = str;
        initView();
        if (j > 0 && "hour".equals(this.grB) && !this.iiT) {
            this.iiT = true;
            this.iiS = j;
            this.iiB.setText(String.format(this.iiA.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.iiS))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csk() {
        if (this.baG == null) {
            this.baG = new AnimatorSet();
        }
        this.baG.cancel();
        HeadImageView headImageView = this.iiP ? this.iiG : this.iiF;
        HeadImageView headImageView2 = this.iiP ? this.iiF : this.iiG;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.iiP ? this.iiL : this.iiK;
        HeadImageView headImageView4 = this.iiP ? this.iiK : this.iiL;
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
        this.baG.setDuration(1000L);
        this.baG.playTogether(this.mAnimators);
        this.baG.setInterpolator(new AccelerateInterpolator());
        this.baG.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.boq) {
                this.iiG.setAlpha(0);
                this.iiG.setVisibility(0);
                this.iiL.setAlpha(0);
                this.iiL.setVisibility(0);
            }
            this.iiW = hVar;
            if (this.iiP) {
                this.iiF.startLoad(hVar.avatar, 12, false);
            } else {
                this.iiG.startLoad(hVar.avatar, 12, false);
            }
            this.iiH.setText(hVar.getName_show());
            this.iiI.setText(String.format(this.iiA.getString(a.h.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.gUA, 0L))));
            if (hVar.eTW == 1) {
                this.iiO.setVisibility(0);
                this.iiO.loop(true);
                this.iiO.setAnimation("anchor_living.json");
                this.iiO.playAnimation();
            } else {
                this.iiO.setVisibility(8);
            }
            if (hVar.gUD != null && (aVar = hVar.gUD.get(0)) != null) {
                if (this.iiP) {
                    this.iiK.startLoad(aVar.portrait, 12, false);
                } else {
                    this.iiL.startLoad(aVar.portrait, 12, false);
                }
                this.iiM.setText(aVar.userNickName);
                this.iiN.setText(String.format(this.iiA.getString(a.h.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.boa)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.boq) {
                        AlaRankListHeaderView.this.csk();
                    }
                    AlaRankListHeaderView.this.boq = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.grB)) {
            this.iiQ.setVisibility(0);
            this.iiR.setVisibility(8);
            this.iiB.setText(this.iiA.getPageActivity().getString(a.h.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grB)) {
            this.iiQ.setVisibility(8);
            this.iiR.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.iiS > 0 && !z) {
                this.iiB.setText(String.format(this.iiA.getString(a.h.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.iiS))));
                startCountDown();
            } else {
                this.iiB.setText(this.iiA.getPageActivity().getString(a.h.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.grB)) {
            this.mRootView.setVisibility(0);
            this.iiR.setVisibility(8);
            this.iiQ.setVisibility(8);
            this.iiD.setVisibility(0);
            if (this.iiS >= 0 && this.iiP) {
                this.iiB.setText(String.format(this.iiA.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.iiS))));
            } else if (!this.iiP) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.Xz()).append(":00-").append("00".equals(com.baidu.live.utils.j.Xy()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.Xy()).append(":00");
                this.iiB.setText(sb);
            }
        } else if ("charm_day".equals(this.grB)) {
            this.mRootView.setVisibility(8);
            this.iiR.setVisibility(8);
            this.iiQ.setVisibility(8);
            this.iiD.setVisibility(8);
            this.iiB.setVisibility(8);
            this.iiC.setVisibility(8);
        } else {
            this.iiD.setVisibility(8);
            this.iiR.setVisibility(8);
            this.iiQ.setVisibility(8);
            this.iiB.setText(this.iiA.getPageActivity().getString(a.h.hkqm_rank_list_refresh_charm_rule));
        }
        this.iiQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.iiA.getPageActivity(), a.h.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.iiA, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.iiD != null) {
            this.iiD.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hfw);
        this.mHandler.postDelayed(this.hfw, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hfw);
    }

    public void setCountDownCallback(a aVar) {
        this.iiU = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.iiV = bVar;
    }
}
