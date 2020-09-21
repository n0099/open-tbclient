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
import com.baidu.tieba.ala.data.n;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet aRA;
    private boolean bdM;
    private AlaLastLiveroomInfo fAJ;
    private long fyR;
    private String fyT;
    private boolean fyU;
    private final Runnable giK;
    private TbPageContext heG;
    private TextView heH;
    private TextView heI;
    private FrameLayout heJ;
    private RelativeLayout heK;
    private HeadImageView heL;
    private HeadImageView heM;
    private TextView heN;
    private TextView heO;
    private RelativeLayout heP;
    private HeadImageView heQ;
    private HeadImageView heR;
    private TextView heS;
    private TextView heT;
    private LottieAnimationView heU;
    private boolean heV;
    private TextView heW;
    private ImageView heX;
    private long heY;
    private boolean heZ;
    private a hfa;
    private b hfb;
    private com.baidu.tieba.ala.data.h hfc;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bKQ();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void lm(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.heY;
        alaRankListHeaderView.heY = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.heV = true;
        this.mHandler = new Handler();
        this.giK = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.heY <= 0) {
                    AlaRankListHeaderView.this.heY = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hfa != null) {
                        AlaRankListHeaderView.this.hfa.bKQ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.heH != null && "hour".equals(AlaRankListHeaderView.this.fyT) && AlaRankListHeaderView.this.heV && AlaRankListHeaderView.this.heY >= 0) {
                    AlaRankListHeaderView.this.heH.setText(String.format(AlaRankListHeaderView.this.heG.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(AlaRankListHeaderView.this.heY))));
                }
            }
        };
        this.fyR = j;
        this.fyU = z;
        this.fAJ = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heV = true;
        this.mHandler = new Handler();
        this.giK = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.heY <= 0) {
                    AlaRankListHeaderView.this.heY = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hfa != null) {
                        AlaRankListHeaderView.this.hfa.bKQ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.heH != null && "hour".equals(AlaRankListHeaderView.this.fyT) && AlaRankListHeaderView.this.heV && AlaRankListHeaderView.this.heY >= 0) {
                    AlaRankListHeaderView.this.heH.setText(String.format(AlaRankListHeaderView.this.heG.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(AlaRankListHeaderView.this.heY))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.heV = true;
        this.mHandler = new Handler();
        this.giK = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.heY <= 0) {
                    AlaRankListHeaderView.this.heY = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hfa != null) {
                        AlaRankListHeaderView.this.hfa.bKQ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.heH != null && "hour".equals(AlaRankListHeaderView.this.fyT) && AlaRankListHeaderView.this.heV && AlaRankListHeaderView.this.heY >= 0) {
                    AlaRankListHeaderView.this.heH.setText(String.format(AlaRankListHeaderView.this.heG.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(AlaRankListHeaderView.this.heY))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.heH = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.heW = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.heX = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.heX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.x.a.NN().bhy.aHn)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.heG, new String[]{com.baidu.live.x.a.NN().bhy.aHn}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fyT)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.heI = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.heI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.heV = !AlaRankListHeaderView.this.heV;
                AlaRankListHeaderView.this.heI.setText(AlaRankListHeaderView.this.heV ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.hfb != null) {
                    AlaRankListHeaderView.this.hfb.lm(AlaRankListHeaderView.this.heV);
                }
            }
        });
        this.heJ = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.heK = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.heL = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.heL.setIsRound(true);
        this.heL.setAutoChangeStyle(false);
        this.heK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hfc != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.hfc.een != 1 || AlaRankListHeaderView.this.hfc.live_id <= 0 || AlaRankListHeaderView.this.hfc.live_id == AlaRankListHeaderView.this.fyR || AlaRankListHeaderView.this.fyU) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.heG.getPageActivity(), AlaRankListHeaderView.this.hfc.user_id, AlaRankListHeaderView.this.hfc.user_name, AlaRankListHeaderView.this.hfc.bdPortrait, AlaRankListHeaderView.this.hfc.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.NN().bhy.aId) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.heG.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.fAJ);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.hfc.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.heM = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.heM.setIsRound(true);
        this.heM.setAutoChangeStyle(false);
        this.heN = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.heO = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.heQ = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.heP = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.heQ.setIsRound(true);
        this.heQ.setAutoChangeStyle(false);
        this.heP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hfc != null && AlaRankListHeaderView.this.hfc.fYb != null && AlaRankListHeaderView.this.hfc.fYb.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.hfc.fYb.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.heG.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.heR = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.heR.setIsRound(true);
        this.heR.setAutoChangeStyle(false);
        this.heS = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.heT = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.heU = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.heG = tbPageContext;
        this.fyT = str;
        initView();
        if (j > 0 && "hour".equals(this.fyT) && !this.heZ) {
            this.heZ = true;
            this.heY = j;
            this.heH.setText(String.format(this.heG.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(this.heY))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccK() {
        if (this.aRA == null) {
            this.aRA = new AnimatorSet();
        }
        this.aRA.cancel();
        HeadImageView headImageView = this.heV ? this.heM : this.heL;
        HeadImageView headImageView2 = this.heV ? this.heL : this.heM;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.heV ? this.heR : this.heQ;
        HeadImageView headImageView4 = this.heV ? this.heQ : this.heR;
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
        this.aRA.setDuration(1000L);
        this.aRA.playTogether(this.mAnimators);
        this.aRA.setInterpolator(new AccelerateInterpolator());
        this.aRA.start();
    }

    public void b(n nVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = nVar.getList().get(0);
        if (hVar != null) {
            if (!this.bdM) {
                this.heM.setAlpha(0);
                this.heM.setVisibility(0);
                this.heR.setAlpha(0);
                this.heR.setVisibility(0);
            }
            this.hfc = hVar;
            if (this.heV) {
                this.heL.startLoad(hVar.avatar, 12, false);
            } else {
                this.heM.startLoad(hVar.avatar, 12, false);
            }
            this.heN.setText(hVar.getName_show());
            this.heO.setText(String.format(this.heG.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.een == 1) {
                this.heU.setVisibility(0);
                this.heU.loop(true);
                this.heU.setAnimation("anchor_living.json");
                this.heU.playAnimation();
            } else {
                this.heU.setVisibility(8);
            }
            if (hVar.fYb != null && (aVar = hVar.fYb.get(0)) != null) {
                if (this.heV) {
                    this.heQ.startLoad(aVar.portrait, 12, false);
                } else {
                    this.heR.startLoad(aVar.portrait, 12, false);
                }
                this.heS.setText(aVar.userNickName);
                this.heT.setText(String.format(this.heG.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.bdx)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bdM) {
                        AlaRankListHeaderView.this.ccK();
                    }
                    AlaRankListHeaderView.this.bdM = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fyT)) {
            this.heW.setVisibility(0);
            this.heX.setVisibility(8);
            this.heH.setText(this.heG.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fyT)) {
            this.heW.setVisibility(8);
            this.heX.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.heY > 0 && !z) {
                this.heH.setText(String.format(this.heG.getString(a.i.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.heY))));
                startCountDown();
            } else {
                this.heH.setText(this.heG.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fyT)) {
            this.mRootView.setVisibility(0);
            this.heX.setVisibility(8);
            this.heW.setVisibility(8);
            this.heJ.setVisibility(0);
            if (this.heY >= 0 && this.heV) {
                this.heH.setText(String.format(this.heG.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(this.heY))));
            } else if (!this.heV) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.PL()).append(":00-").append("00".equals(com.baidu.live.utils.j.PK()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.PK()).append(":00");
                this.heH.setText(sb);
            }
        } else if ("charm_day".equals(this.fyT)) {
            this.mRootView.setVisibility(8);
            this.heX.setVisibility(8);
            this.heW.setVisibility(8);
            this.heJ.setVisibility(8);
            this.heH.setVisibility(8);
            this.heI.setVisibility(8);
        } else {
            this.heJ.setVisibility(8);
            this.heX.setVisibility(8);
            this.heW.setVisibility(8);
            this.heH.setText(this.heG.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.heW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.heG.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.heG, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.heJ != null) {
            this.heJ.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.giK);
        this.mHandler.postDelayed(this.giK, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.giK);
    }

    public void setCountDownCallback(a aVar) {
        this.hfa = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.hfb = bVar;
    }
}
