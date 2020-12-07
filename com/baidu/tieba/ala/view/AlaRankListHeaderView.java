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
    private AnimatorSet aYZ;
    private boolean bmL;
    private final Runnable gTH;
    private long ggZ;
    private String ghb;
    private boolean ghc;
    private AlaLastLiveroomInfo giQ;
    private TbPageContext hVY;
    private TextView hVZ;
    private TextView hWa;
    private FrameLayout hWb;
    private RelativeLayout hWc;
    private HeadImageView hWd;
    private HeadImageView hWe;
    private TextView hWf;
    private TextView hWg;
    private RelativeLayout hWh;
    private HeadImageView hWi;
    private HeadImageView hWj;
    private TextView hWk;
    private TextView hWl;
    private LottieAnimationView hWm;
    private boolean hWn;
    private TextView hWo;
    private ImageView hWp;
    private long hWq;
    private boolean hWr;
    private a hWs;
    private b hWt;
    private com.baidu.tieba.ala.data.h hWu;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bVI();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void mF(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.hWq;
        alaRankListHeaderView.hWq = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.hWn = true;
        this.mHandler = new Handler();
        this.gTH = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hWq <= 0) {
                    AlaRankListHeaderView.this.hWq = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hWs != null) {
                        AlaRankListHeaderView.this.hWs.bVI();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hVZ != null && "hour".equals(AlaRankListHeaderView.this.ghb) && AlaRankListHeaderView.this.hWn && AlaRankListHeaderView.this.hWq >= 0) {
                    AlaRankListHeaderView.this.hVZ.setText(String.format(AlaRankListHeaderView.this.hVY.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hWq))));
                }
            }
        };
        this.ggZ = j;
        this.ghc = z;
        this.giQ = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWn = true;
        this.mHandler = new Handler();
        this.gTH = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hWq <= 0) {
                    AlaRankListHeaderView.this.hWq = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hWs != null) {
                        AlaRankListHeaderView.this.hWs.bVI();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hVZ != null && "hour".equals(AlaRankListHeaderView.this.ghb) && AlaRankListHeaderView.this.hWn && AlaRankListHeaderView.this.hWq >= 0) {
                    AlaRankListHeaderView.this.hVZ.setText(String.format(AlaRankListHeaderView.this.hVY.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hWq))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWn = true;
        this.mHandler = new Handler();
        this.gTH = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hWq <= 0) {
                    AlaRankListHeaderView.this.hWq = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hWs != null) {
                        AlaRankListHeaderView.this.hWs.bVI();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hVZ != null && "hour".equals(AlaRankListHeaderView.this.ghb) && AlaRankListHeaderView.this.hWn && AlaRankListHeaderView.this.hWq >= 0) {
                    AlaRankListHeaderView.this.hVZ.setText(String.format(AlaRankListHeaderView.this.hVY.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hWq))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_header_layout, this);
        this.hVZ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_refresh_tip);
        this.hWo = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_game_rule);
        this.hWp = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_flower_description);
        this.hWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.ae.a.RB().brA.aNd)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.hVY, new String[]{com.baidu.live.ae.a.RB().brA.aNd}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.ghb)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.hWa = (TextView) this.mRootView.findViewById(a.f.rank_list_switch);
        this.hWa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.hWn = !AlaRankListHeaderView.this.hWn;
                AlaRankListHeaderView.this.hWa.setText(AlaRankListHeaderView.this.hWn ? a.h.hour_rank_list_head_switch_cur : a.h.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.hWt != null) {
                    AlaRankListHeaderView.this.hWt.mF(AlaRankListHeaderView.this.hWn);
                }
            }
        });
        this.hWb = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hWc = (RelativeLayout) this.mRootView.findViewById(a.f.rl_rank_first);
        this.hWd = (HeadImageView) this.mRootView.findViewById(a.f.rank_first);
        this.hWd.setIsRound(true);
        this.hWd.setAutoChangeStyle(false);
        this.hWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hWu != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.hWu.eKc != 1 || AlaRankListHeaderView.this.hWu.live_id <= 0 || AlaRankListHeaderView.this.hWu.live_id == AlaRankListHeaderView.this.ggZ || AlaRankListHeaderView.this.ghc) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hVY.getPageActivity(), AlaRankListHeaderView.this.hWu.user_id, AlaRankListHeaderView.this.hWu.user_name, AlaRankListHeaderView.this.hWu.bdPortrait, AlaRankListHeaderView.this.hWu.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.hVY.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.giQ);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.hWu.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.hWe = (HeadImageView) this.mRootView.findViewById(a.f.rank_first2);
        this.hWe.setIsRound(true);
        this.hWe.setAutoChangeStyle(false);
        this.hWf = (TextView) this.mRootView.findViewById(a.f.name_rank_1);
        this.hWg = (TextView) this.mRootView.findViewById(a.f.point_rank_1);
        this.hWi = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hWh = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hWi.setIsRound(true);
        this.hWi.setAutoChangeStyle(false);
        this.hWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hWu != null && AlaRankListHeaderView.this.hWu.gIP != null && AlaRankListHeaderView.this.hWu.gIP.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.hWu.gIP.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hVY.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.hWj = (HeadImageView) this.mRootView.findViewById(a.f.charm_first2);
        this.hWj.setIsRound(true);
        this.hWj.setAutoChangeStyle(false);
        this.hWk = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hWl = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hWm = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(context, j + "", str, str2, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, str3, "")));
        }
    }

    public void a(TbPageContext tbPageContext, String str, long j) {
        this.hVY = tbPageContext;
        this.ghb = str;
        initView();
        if (j > 0 && "hour".equals(this.ghb) && !this.hWr) {
            this.hWr = true;
            this.hWq = j;
            this.hVZ.setText(String.format(this.hVY.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hWq))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpq() {
        if (this.aYZ == null) {
            this.aYZ = new AnimatorSet();
        }
        this.aYZ.cancel();
        HeadImageView headImageView = this.hWn ? this.hWe : this.hWd;
        HeadImageView headImageView2 = this.hWn ? this.hWd : this.hWe;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.hWn ? this.hWj : this.hWi;
        HeadImageView headImageView4 = this.hWn ? this.hWi : this.hWj;
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
        this.aYZ.setDuration(1000L);
        this.aYZ.playTogether(this.mAnimators);
        this.aYZ.setInterpolator(new AccelerateInterpolator());
        this.aYZ.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.bmL) {
                this.hWe.setAlpha(0);
                this.hWe.setVisibility(0);
                this.hWj.setAlpha(0);
                this.hWj.setVisibility(0);
            }
            this.hWu = hVar;
            if (this.hWn) {
                this.hWd.startLoad(hVar.avatar, 12, false);
            } else {
                this.hWe.startLoad(hVar.avatar, 12, false);
            }
            this.hWf.setText(hVar.getName_show());
            this.hWg.setText(String.format(this.hVY.getString(a.h.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.gIM, 0L))));
            if (hVar.eKc == 1) {
                this.hWm.setVisibility(0);
                this.hWm.loop(true);
                this.hWm.setAnimation("anchor_living.json");
                this.hWm.playAnimation();
            } else {
                this.hWm.setVisibility(8);
            }
            if (hVar.gIP != null && (aVar = hVar.gIP.get(0)) != null) {
                if (this.hWn) {
                    this.hWi.startLoad(aVar.portrait, 12, false);
                } else {
                    this.hWj.startLoad(aVar.portrait, 12, false);
                }
                this.hWk.setText(aVar.userNickName);
                this.hWl.setText(String.format(this.hVY.getString(a.h.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.bmv)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bmL) {
                        AlaRankListHeaderView.this.cpq();
                    }
                    AlaRankListHeaderView.this.bmL = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ghb)) {
            this.hWo.setVisibility(0);
            this.hWp.setVisibility(8);
            this.hVZ.setText(this.hVY.getPageActivity().getString(a.h.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ghb)) {
            this.hWo.setVisibility(8);
            this.hWp.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.hWq > 0 && !z) {
                this.hVZ.setText(String.format(this.hVY.getString(a.h.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.hWq))));
                startCountDown();
            } else {
                this.hVZ.setText(this.hVY.getPageActivity().getString(a.h.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.ghb)) {
            this.mRootView.setVisibility(0);
            this.hWp.setVisibility(8);
            this.hWo.setVisibility(8);
            this.hWb.setVisibility(0);
            if (this.hWq >= 0 && this.hWn) {
                this.hVZ.setText(String.format(this.hVY.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hWq))));
            } else if (!this.hWn) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.Wv()).append(":00-").append("00".equals(com.baidu.live.utils.j.Wu()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.Wu()).append(":00");
                this.hVZ.setText(sb);
            }
        } else if ("charm_day".equals(this.ghb)) {
            this.mRootView.setVisibility(8);
            this.hWp.setVisibility(8);
            this.hWo.setVisibility(8);
            this.hWb.setVisibility(8);
            this.hVZ.setVisibility(8);
            this.hWa.setVisibility(8);
        } else {
            this.hWb.setVisibility(8);
            this.hWp.setVisibility(8);
            this.hWo.setVisibility(8);
            this.hVZ.setText(this.hVY.getPageActivity().getString(a.h.hkqm_rank_list_refresh_charm_rule));
        }
        this.hWo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.hVY.getPageActivity(), a.h.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.hVY, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hWb != null) {
            this.hWb.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gTH);
        this.mHandler.postDelayed(this.gTH, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gTH);
    }

    public void setCountDownCallback(a aVar) {
        this.hWs = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.hWt = bVar;
    }
}
