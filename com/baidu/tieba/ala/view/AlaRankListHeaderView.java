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
    private AnimatorSet aWg;
    private boolean biP;
    private long fTr;
    private String fTt;
    private boolean fTu;
    private AlaLastLiveroomInfo fVh;
    private final Runnable gFb;
    private TbPageContext hFA;
    private TextView hFB;
    private TextView hFC;
    private FrameLayout hFD;
    private RelativeLayout hFE;
    private HeadImageView hFF;
    private HeadImageView hFG;
    private TextView hFH;
    private TextView hFI;
    private RelativeLayout hFJ;
    private HeadImageView hFK;
    private HeadImageView hFL;
    private TextView hFM;
    private TextView hFN;
    private LottieAnimationView hFO;
    private boolean hFP;
    private TextView hFQ;
    private ImageView hFR;
    private long hFS;
    private boolean hFT;
    private a hFU;
    private b hFV;
    private com.baidu.tieba.ala.data.h hFW;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bQf();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void ma(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.hFS;
        alaRankListHeaderView.hFS = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.hFP = true;
        this.mHandler = new Handler();
        this.gFb = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hFS <= 0) {
                    AlaRankListHeaderView.this.hFS = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hFU != null) {
                        AlaRankListHeaderView.this.hFU.bQf();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hFB != null && "hour".equals(AlaRankListHeaderView.this.fTt) && AlaRankListHeaderView.this.hFP && AlaRankListHeaderView.this.hFS >= 0) {
                    AlaRankListHeaderView.this.hFB.setText(String.format(AlaRankListHeaderView.this.hFA.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hFS))));
                }
            }
        };
        this.fTr = j;
        this.fTu = z;
        this.fVh = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFP = true;
        this.mHandler = new Handler();
        this.gFb = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hFS <= 0) {
                    AlaRankListHeaderView.this.hFS = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hFU != null) {
                        AlaRankListHeaderView.this.hFU.bQf();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hFB != null && "hour".equals(AlaRankListHeaderView.this.fTt) && AlaRankListHeaderView.this.hFP && AlaRankListHeaderView.this.hFS >= 0) {
                    AlaRankListHeaderView.this.hFB.setText(String.format(AlaRankListHeaderView.this.hFA.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hFS))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFP = true;
        this.mHandler = new Handler();
        this.gFb = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hFS <= 0) {
                    AlaRankListHeaderView.this.hFS = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hFU != null) {
                        AlaRankListHeaderView.this.hFU.bQf();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hFB != null && "hour".equals(AlaRankListHeaderView.this.fTt) && AlaRankListHeaderView.this.hFP && AlaRankListHeaderView.this.hFS >= 0) {
                    AlaRankListHeaderView.this.hFB.setText(String.format(AlaRankListHeaderView.this.hFA.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hFS))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.hFB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.hFQ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.hFR = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.hFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.z.a.Pq().bmJ.aKT)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.hFA, new String[]{com.baidu.live.z.a.Pq().bmJ.aKT}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fTt)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.hFC = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.hFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.hFP = !AlaRankListHeaderView.this.hFP;
                AlaRankListHeaderView.this.hFC.setText(AlaRankListHeaderView.this.hFP ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.hFV != null) {
                    AlaRankListHeaderView.this.hFV.ma(AlaRankListHeaderView.this.hFP);
                }
            }
        });
        this.hFD = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.hFE = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.hFF = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.hFF.setIsRound(true);
        this.hFF.setAutoChangeStyle(false);
        this.hFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hFW != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.hFW.eyT != 1 || AlaRankListHeaderView.this.hFW.live_id <= 0 || AlaRankListHeaderView.this.hFW.live_id == AlaRankListHeaderView.this.fTr || AlaRankListHeaderView.this.fTu) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hFA.getPageActivity(), AlaRankListHeaderView.this.hFW.user_id, AlaRankListHeaderView.this.hFW.user_name, AlaRankListHeaderView.this.hFW.bdPortrait, AlaRankListHeaderView.this.hFW.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.z.a.Pq().bmJ.aLL) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.hFA.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.fVh);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.hFW.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.hFG = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.hFG.setIsRound(true);
        this.hFG.setAutoChangeStyle(false);
        this.hFH = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.hFI = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.hFK = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.hFJ = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.hFK.setIsRound(true);
        this.hFK.setAutoChangeStyle(false);
        this.hFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hFW != null && AlaRankListHeaderView.this.hFW.gux != null && AlaRankListHeaderView.this.hFW.gux.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.hFW.gux.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hFA.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.hFL = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.hFL.setIsRound(true);
        this.hFL.setAutoChangeStyle(false);
        this.hFM = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.hFN = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.hFO = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.hFA = tbPageContext;
        this.fTt = str;
        initView();
        if (j > 0 && "hour".equals(this.fTt) && !this.hFT) {
            this.hFT = true;
            this.hFS = j;
            this.hFB.setText(String.format(this.hFA.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hFS))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjg() {
        if (this.aWg == null) {
            this.aWg = new AnimatorSet();
        }
        this.aWg.cancel();
        HeadImageView headImageView = this.hFP ? this.hFG : this.hFF;
        HeadImageView headImageView2 = this.hFP ? this.hFF : this.hFG;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.hFP ? this.hFL : this.hFK;
        HeadImageView headImageView4 = this.hFP ? this.hFK : this.hFL;
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
        this.aWg.setDuration(1000L);
        this.aWg.playTogether(this.mAnimators);
        this.aWg.setInterpolator(new AccelerateInterpolator());
        this.aWg.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.biP) {
                this.hFG.setAlpha(0);
                this.hFG.setVisibility(0);
                this.hFL.setAlpha(0);
                this.hFL.setVisibility(0);
            }
            this.hFW = hVar;
            if (this.hFP) {
                this.hFF.startLoad(hVar.avatar, 12, false);
            } else {
                this.hFG.startLoad(hVar.avatar, 12, false);
            }
            this.hFH.setText(hVar.getName_show());
            this.hFI.setText(String.format(this.hFA.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.eyT == 1) {
                this.hFO.setVisibility(0);
                this.hFO.loop(true);
                this.hFO.setAnimation("anchor_living.json");
                this.hFO.playAnimation();
            } else {
                this.hFO.setVisibility(8);
            }
            if (hVar.gux != null && (aVar = hVar.gux.get(0)) != null) {
                if (this.hFP) {
                    this.hFK.startLoad(aVar.portrait, 12, false);
                } else {
                    this.hFL.startLoad(aVar.portrait, 12, false);
                }
                this.hFM.setText(aVar.userNickName);
                this.hFN.setText(String.format(this.hFA.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.biA)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.biP) {
                        AlaRankListHeaderView.this.cjg();
                    }
                    AlaRankListHeaderView.this.biP = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fTt)) {
            this.hFQ.setVisibility(0);
            this.hFR.setVisibility(8);
            this.hFB.setText(this.hFA.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fTt)) {
            this.hFQ.setVisibility(8);
            this.hFR.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.hFS > 0 && !z) {
                this.hFB.setText(String.format(this.hFA.getString(a.i.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.hFS))));
                startCountDown();
            } else {
                this.hFB.setText(this.hFA.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fTt)) {
            this.mRootView.setVisibility(0);
            this.hFR.setVisibility(8);
            this.hFQ.setVisibility(8);
            this.hFD.setVisibility(0);
            if (this.hFS >= 0 && this.hFP) {
                this.hFB.setText(String.format(this.hFA.getString(a.i.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hFS))));
            } else if (!this.hFP) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.RW()).append(":00-").append("00".equals(com.baidu.live.utils.j.RV()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.RV()).append(":00");
                this.hFB.setText(sb);
            }
        } else if ("charm_day".equals(this.fTt)) {
            this.mRootView.setVisibility(8);
            this.hFR.setVisibility(8);
            this.hFQ.setVisibility(8);
            this.hFD.setVisibility(8);
            this.hFB.setVisibility(8);
            this.hFC.setVisibility(8);
        } else {
            this.hFD.setVisibility(8);
            this.hFR.setVisibility(8);
            this.hFQ.setVisibility(8);
            this.hFB.setText(this.hFA.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.hFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.hFA.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.hFA, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hFD != null) {
            this.hFD.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gFb);
        this.mHandler.postDelayed(this.gFb, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gFb);
    }

    public void setCountDownCallback(a aVar) {
        this.hFU = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.hFV = bVar;
    }
}
