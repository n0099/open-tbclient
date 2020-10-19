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
    private AnimatorSet aUL;
    private boolean bhy;
    private long fLa;
    private String fLc;
    private boolean fLd;
    private AlaLastLiveroomInfo fMS;
    private final Runnable guX;
    private TbPageContext htJ;
    private TextView htK;
    private TextView htL;
    private FrameLayout htM;
    private RelativeLayout htN;
    private HeadImageView htO;
    private HeadImageView htP;
    private TextView htQ;
    private TextView htR;
    private RelativeLayout htS;
    private HeadImageView htT;
    private HeadImageView htU;
    private TextView htV;
    private TextView htW;
    private LottieAnimationView htX;
    private boolean htY;
    private TextView htZ;
    private ImageView hua;
    private long hub;
    private boolean huc;
    private a hud;
    private b hue;
    private com.baidu.tieba.ala.data.h huf;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bNA();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void lK(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.hub;
        alaRankListHeaderView.hub = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.htY = true;
        this.mHandler = new Handler();
        this.guX = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hub <= 0) {
                    AlaRankListHeaderView.this.hub = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hud != null) {
                        AlaRankListHeaderView.this.hud.bNA();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.htK != null && "hour".equals(AlaRankListHeaderView.this.fLc) && AlaRankListHeaderView.this.htY && AlaRankListHeaderView.this.hub >= 0) {
                    AlaRankListHeaderView.this.htK.setText(String.format(AlaRankListHeaderView.this.htJ.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(AlaRankListHeaderView.this.hub))));
                }
            }
        };
        this.fLa = j;
        this.fLd = z;
        this.fMS = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htY = true;
        this.mHandler = new Handler();
        this.guX = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hub <= 0) {
                    AlaRankListHeaderView.this.hub = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hud != null) {
                        AlaRankListHeaderView.this.hud.bNA();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.htK != null && "hour".equals(AlaRankListHeaderView.this.fLc) && AlaRankListHeaderView.this.htY && AlaRankListHeaderView.this.hub >= 0) {
                    AlaRankListHeaderView.this.htK.setText(String.format(AlaRankListHeaderView.this.htJ.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(AlaRankListHeaderView.this.hub))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.htY = true;
        this.mHandler = new Handler();
        this.guX = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hub <= 0) {
                    AlaRankListHeaderView.this.hub = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hud != null) {
                        AlaRankListHeaderView.this.hud.bNA();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.htK != null && "hour".equals(AlaRankListHeaderView.this.fLc) && AlaRankListHeaderView.this.htY && AlaRankListHeaderView.this.hub >= 0) {
                    AlaRankListHeaderView.this.htK.setText(String.format(AlaRankListHeaderView.this.htJ.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(AlaRankListHeaderView.this.hub))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.htK = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.htZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.hua = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.hua.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.x.a.OS().blo.aKr)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.htJ, new String[]{com.baidu.live.x.a.OS().blo.aKr}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fLc)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.htL = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.htL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.htY = !AlaRankListHeaderView.this.htY;
                AlaRankListHeaderView.this.htL.setText(AlaRankListHeaderView.this.htY ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.hue != null) {
                    AlaRankListHeaderView.this.hue.lK(AlaRankListHeaderView.this.htY);
                }
            }
        });
        this.htM = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.htN = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.htO = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.htO.setIsRound(true);
        this.htO.setAutoChangeStyle(false);
        this.htN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.huf != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.huf.eqs != 1 || AlaRankListHeaderView.this.huf.live_id <= 0 || AlaRankListHeaderView.this.huf.live_id == AlaRankListHeaderView.this.fLa || AlaRankListHeaderView.this.fLd) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.htJ.getPageActivity(), AlaRankListHeaderView.this.huf.user_id, AlaRankListHeaderView.this.huf.user_name, AlaRankListHeaderView.this.huf.bdPortrait, AlaRankListHeaderView.this.huf.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.OS().blo.aLh) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.htJ.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.fMS);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.huf.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.htP = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.htP.setIsRound(true);
        this.htP.setAutoChangeStyle(false);
        this.htQ = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.htR = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.htT = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.htS = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.htT.setIsRound(true);
        this.htT.setAutoChangeStyle(false);
        this.htS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.huf != null && AlaRankListHeaderView.this.huf.gkt != null && AlaRankListHeaderView.this.huf.gkt.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.huf.gkt.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.htJ.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.htU = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.htU.setIsRound(true);
        this.htU.setAutoChangeStyle(false);
        this.htV = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.htW = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.htX = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.htJ = tbPageContext;
        this.fLc = str;
        initView();
        if (j > 0 && "hour".equals(this.fLc) && !this.huc) {
            this.huc = true;
            this.hub = j;
            this.htK.setText(String.format(this.htJ.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(this.hub))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgg() {
        if (this.aUL == null) {
            this.aUL = new AnimatorSet();
        }
        this.aUL.cancel();
        HeadImageView headImageView = this.htY ? this.htP : this.htO;
        HeadImageView headImageView2 = this.htY ? this.htO : this.htP;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.htY ? this.htU : this.htT;
        HeadImageView headImageView4 = this.htY ? this.htT : this.htU;
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
        this.aUL.setDuration(1000L);
        this.aUL.playTogether(this.mAnimators);
        this.aUL.setInterpolator(new AccelerateInterpolator());
        this.aUL.start();
    }

    public void b(n nVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = nVar.getList().get(0);
        if (hVar != null) {
            if (!this.bhy) {
                this.htP.setAlpha(0);
                this.htP.setVisibility(0);
                this.htU.setAlpha(0);
                this.htU.setVisibility(0);
            }
            this.huf = hVar;
            if (this.htY) {
                this.htO.startLoad(hVar.avatar, 12, false);
            } else {
                this.htP.startLoad(hVar.avatar, 12, false);
            }
            this.htQ.setText(hVar.getName_show());
            this.htR.setText(String.format(this.htJ.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.eqs == 1) {
                this.htX.setVisibility(0);
                this.htX.loop(true);
                this.htX.setAnimation("anchor_living.json");
                this.htX.playAnimation();
            } else {
                this.htX.setVisibility(8);
            }
            if (hVar.gkt != null && (aVar = hVar.gkt.get(0)) != null) {
                if (this.htY) {
                    this.htT.startLoad(aVar.portrait, 12, false);
                } else {
                    this.htU.startLoad(aVar.portrait, 12, false);
                }
                this.htV.setText(aVar.userNickName);
                this.htW.setText(String.format(this.htJ.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.bhj)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bhy) {
                        AlaRankListHeaderView.this.cgg();
                    }
                    AlaRankListHeaderView.this.bhy = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fLc)) {
            this.htZ.setVisibility(0);
            this.hua.setVisibility(8);
            this.htK.setText(this.htJ.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fLc)) {
            this.htZ.setVisibility(8);
            this.hua.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.hub > 0 && !z) {
                this.htK.setText(String.format(this.htJ.getString(a.i.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.hub))));
                startCountDown();
            } else {
                this.htK.setText(this.htJ.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fLc)) {
            this.mRootView.setVisibility(0);
            this.hua.setVisibility(8);
            this.htZ.setVisibility(8);
            this.htM.setVisibility(0);
            if (this.hub >= 0 && this.htY) {
                this.htK.setText(String.format(this.htJ.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.b(Long.valueOf(this.hub))));
            } else if (!this.htY) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.QQ()).append(":00-").append("00".equals(com.baidu.live.utils.j.QP()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.QP()).append(":00");
                this.htK.setText(sb);
            }
        } else if ("charm_day".equals(this.fLc)) {
            this.mRootView.setVisibility(8);
            this.hua.setVisibility(8);
            this.htZ.setVisibility(8);
            this.htM.setVisibility(8);
            this.htK.setVisibility(8);
            this.htL.setVisibility(8);
        } else {
            this.htM.setVisibility(8);
            this.hua.setVisibility(8);
            this.htZ.setVisibility(8);
            this.htK.setText(this.htJ.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.htZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.htJ.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.htJ, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.htM != null) {
            this.htM.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.guX);
        this.mHandler.postDelayed(this.guX, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.guX);
    }

    public void setCountDownCallback(a aVar) {
        this.hud = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.hue = bVar;
    }
}
