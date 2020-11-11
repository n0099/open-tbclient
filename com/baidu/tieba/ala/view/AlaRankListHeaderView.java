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
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet aXy;
    private boolean bki;
    private long fZh;
    private String fZj;
    private boolean fZk;
    private final Runnable gKO;
    private AlaLastLiveroomInfo gaY;
    private FrameLayout hLA;
    private RelativeLayout hLB;
    private HeadImageView hLC;
    private HeadImageView hLD;
    private TextView hLE;
    private TextView hLF;
    private RelativeLayout hLG;
    private HeadImageView hLH;
    private HeadImageView hLI;
    private TextView hLJ;
    private TextView hLK;
    private LottieAnimationView hLL;
    private boolean hLM;
    private TextView hLN;
    private ImageView hLO;
    private long hLP;
    private boolean hLQ;
    private a hLR;
    private b hLS;
    private com.baidu.tieba.ala.data.h hLT;
    private TbPageContext hLx;
    private TextView hLy;
    private TextView hLz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bSF();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void mj(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.hLP;
        alaRankListHeaderView.hLP = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.hLM = true;
        this.mHandler = new Handler();
        this.gKO = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hLP <= 0) {
                    AlaRankListHeaderView.this.hLP = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hLR != null) {
                        AlaRankListHeaderView.this.hLR.bSF();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hLy != null && "hour".equals(AlaRankListHeaderView.this.fZj) && AlaRankListHeaderView.this.hLM && AlaRankListHeaderView.this.hLP >= 0) {
                    AlaRankListHeaderView.this.hLy.setText(String.format(AlaRankListHeaderView.this.hLx.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hLP))));
                }
            }
        };
        this.fZh = j;
        this.fZk = z;
        this.gaY = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLM = true;
        this.mHandler = new Handler();
        this.gKO = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hLP <= 0) {
                    AlaRankListHeaderView.this.hLP = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hLR != null) {
                        AlaRankListHeaderView.this.hLR.bSF();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hLy != null && "hour".equals(AlaRankListHeaderView.this.fZj) && AlaRankListHeaderView.this.hLM && AlaRankListHeaderView.this.hLP >= 0) {
                    AlaRankListHeaderView.this.hLy.setText(String.format(AlaRankListHeaderView.this.hLx.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hLP))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLM = true;
        this.mHandler = new Handler();
        this.gKO = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hLP <= 0) {
                    AlaRankListHeaderView.this.hLP = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hLR != null) {
                        AlaRankListHeaderView.this.hLR.bSF();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hLy != null && "hour".equals(AlaRankListHeaderView.this.fZj) && AlaRankListHeaderView.this.hLM && AlaRankListHeaderView.this.hLP >= 0) {
                    AlaRankListHeaderView.this.hLy.setText(String.format(AlaRankListHeaderView.this.hLx.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hLP))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_header_layout, this);
        this.hLy = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_refresh_tip);
        this.hLN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_game_rule);
        this.hLO = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_flower_description);
        this.hLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.aa.a.PQ().bod.aLT)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.hLx, new String[]{com.baidu.live.aa.a.PQ().bod.aLT}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fZj)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.hLz = (TextView) this.mRootView.findViewById(a.f.rank_list_switch);
        this.hLz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.hLM = !AlaRankListHeaderView.this.hLM;
                AlaRankListHeaderView.this.hLz.setText(AlaRankListHeaderView.this.hLM ? a.h.hour_rank_list_head_switch_cur : a.h.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.hLS != null) {
                    AlaRankListHeaderView.this.hLS.mj(AlaRankListHeaderView.this.hLM);
                }
            }
        });
        this.hLA = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hLB = (RelativeLayout) this.mRootView.findViewById(a.f.rl_rank_first);
        this.hLC = (HeadImageView) this.mRootView.findViewById(a.f.rank_first);
        this.hLC.setIsRound(true);
        this.hLC.setAutoChangeStyle(false);
        this.hLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hLT != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.hLT.eEI != 1 || AlaRankListHeaderView.this.hLT.live_id <= 0 || AlaRankListHeaderView.this.hLT.live_id == AlaRankListHeaderView.this.fZh || AlaRankListHeaderView.this.fZk) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hLx.getPageActivity(), AlaRankListHeaderView.this.hLT.user_id, AlaRankListHeaderView.this.hLT.user_name, AlaRankListHeaderView.this.hLT.bdPortrait, AlaRankListHeaderView.this.hLT.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.PQ().bod.aML) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.hLx.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.gaY);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.hLT.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.hLD = (HeadImageView) this.mRootView.findViewById(a.f.rank_first2);
        this.hLD.setIsRound(true);
        this.hLD.setAutoChangeStyle(false);
        this.hLE = (TextView) this.mRootView.findViewById(a.f.name_rank_1);
        this.hLF = (TextView) this.mRootView.findViewById(a.f.point_rank_1);
        this.hLH = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hLG = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hLH.setIsRound(true);
        this.hLH.setAutoChangeStyle(false);
        this.hLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hLT != null && AlaRankListHeaderView.this.hLT.gAl != null && AlaRankListHeaderView.this.hLT.gAl.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.hLT.gAl.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hLx.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.hLI = (HeadImageView) this.mRootView.findViewById(a.f.charm_first2);
        this.hLI.setIsRound(true);
        this.hLI.setAutoChangeStyle(false);
        this.hLJ = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hLK = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hLL = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
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
        this.hLx = tbPageContext;
        this.fZj = str;
        initView();
        if (j > 0 && "hour".equals(this.fZj) && !this.hLQ) {
            this.hLQ = true;
            this.hLP = j;
            this.hLy.setText(String.format(this.hLx.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hLP))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clI() {
        if (this.aXy == null) {
            this.aXy = new AnimatorSet();
        }
        this.aXy.cancel();
        HeadImageView headImageView = this.hLM ? this.hLD : this.hLC;
        HeadImageView headImageView2 = this.hLM ? this.hLC : this.hLD;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.hLM ? this.hLI : this.hLH;
        HeadImageView headImageView4 = this.hLM ? this.hLH : this.hLI;
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
        this.aXy.setDuration(1000L);
        this.aXy.playTogether(this.mAnimators);
        this.aXy.setInterpolator(new AccelerateInterpolator());
        this.aXy.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.bki) {
                this.hLD.setAlpha(0);
                this.hLD.setVisibility(0);
                this.hLI.setAlpha(0);
                this.hLI.setVisibility(0);
            }
            this.hLT = hVar;
            if (this.hLM) {
                this.hLC.startLoad(hVar.avatar, 12, false);
            } else {
                this.hLD.startLoad(hVar.avatar, 12, false);
            }
            this.hLE.setText(hVar.getName_show());
            this.hLF.setText(String.format(this.hLx.getString(a.h.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.eEI == 1) {
                this.hLL.setVisibility(0);
                this.hLL.loop(true);
                this.hLL.setAnimation("anchor_living.json");
                this.hLL.playAnimation();
            } else {
                this.hLL.setVisibility(8);
            }
            if (hVar.gAl != null && (aVar = hVar.gAl.get(0)) != null) {
                if (this.hLM) {
                    this.hLH.startLoad(aVar.portrait, 12, false);
                } else {
                    this.hLI.startLoad(aVar.portrait, 12, false);
                }
                this.hLJ.setText(aVar.userNickName);
                this.hLK.setText(String.format(this.hLx.getString(a.h.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.bjT)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bki) {
                        AlaRankListHeaderView.this.clI();
                    }
                    AlaRankListHeaderView.this.bki = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fZj)) {
            this.hLN.setVisibility(0);
            this.hLO.setVisibility(8);
            this.hLy.setText(this.hLx.getPageActivity().getString(a.h.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fZj)) {
            this.hLN.setVisibility(8);
            this.hLO.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.hLP > 0 && !z) {
                this.hLy.setText(String.format(this.hLx.getString(a.h.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.hLP))));
                startCountDown();
            } else {
                this.hLy.setText(this.hLx.getPageActivity().getString(a.h.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fZj)) {
            this.mRootView.setVisibility(0);
            this.hLO.setVisibility(8);
            this.hLN.setVisibility(8);
            this.hLA.setVisibility(0);
            if (this.hLP >= 0 && this.hLM) {
                this.hLy.setText(String.format(this.hLx.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hLP))));
            } else if (!this.hLM) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.UE()).append(":00-").append("00".equals(com.baidu.live.utils.j.UD()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.UD()).append(":00");
                this.hLy.setText(sb);
            }
        } else if ("charm_day".equals(this.fZj)) {
            this.mRootView.setVisibility(8);
            this.hLO.setVisibility(8);
            this.hLN.setVisibility(8);
            this.hLA.setVisibility(8);
            this.hLy.setVisibility(8);
            this.hLz.setVisibility(8);
        } else {
            this.hLA.setVisibility(8);
            this.hLO.setVisibility(8);
            this.hLN.setVisibility(8);
            this.hLy.setText(this.hLx.getPageActivity().getString(a.h.hkqm_rank_list_refresh_charm_rule));
        }
        this.hLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.hLx.getPageActivity(), a.h.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.hLx, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hLA != null) {
            this.hLA.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gKO);
        this.mHandler.postDelayed(this.gKO, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gKO);
    }

    public void setCountDownCallback(a aVar) {
        this.hLR = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.hLS = bVar;
    }
}
