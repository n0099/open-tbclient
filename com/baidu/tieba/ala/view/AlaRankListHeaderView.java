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
    private AnimatorSet aVN;
    private boolean bix;
    private long fYO;
    private String fYQ;
    private boolean fYR;
    private final Runnable gKv;
    private AlaLastLiveroomInfo gaF;
    private com.baidu.tieba.ala.data.h hLA;
    private TbPageContext hLe;
    private TextView hLf;
    private TextView hLg;
    private FrameLayout hLh;
    private RelativeLayout hLi;
    private HeadImageView hLj;
    private HeadImageView hLk;
    private TextView hLl;
    private TextView hLm;
    private RelativeLayout hLn;
    private HeadImageView hLo;
    private HeadImageView hLp;
    private TextView hLq;
    private TextView hLr;
    private LottieAnimationView hLs;
    private boolean hLt;
    private TextView hLu;
    private ImageView hLv;
    private long hLw;
    private boolean hLx;
    private a hLy;
    private b hLz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bRY();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void mk(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.hLw;
        alaRankListHeaderView.hLw = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.hLt = true;
        this.mHandler = new Handler();
        this.gKv = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hLw <= 0) {
                    AlaRankListHeaderView.this.hLw = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hLy != null) {
                        AlaRankListHeaderView.this.hLy.bRY();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hLf != null && "hour".equals(AlaRankListHeaderView.this.fYQ) && AlaRankListHeaderView.this.hLt && AlaRankListHeaderView.this.hLw >= 0) {
                    AlaRankListHeaderView.this.hLf.setText(String.format(AlaRankListHeaderView.this.hLe.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hLw))));
                }
            }
        };
        this.fYO = j;
        this.fYR = z;
        this.gaF = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLt = true;
        this.mHandler = new Handler();
        this.gKv = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hLw <= 0) {
                    AlaRankListHeaderView.this.hLw = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hLy != null) {
                        AlaRankListHeaderView.this.hLy.bRY();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hLf != null && "hour".equals(AlaRankListHeaderView.this.fYQ) && AlaRankListHeaderView.this.hLt && AlaRankListHeaderView.this.hLw >= 0) {
                    AlaRankListHeaderView.this.hLf.setText(String.format(AlaRankListHeaderView.this.hLe.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hLw))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLt = true;
        this.mHandler = new Handler();
        this.gKv = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.hLw <= 0) {
                    AlaRankListHeaderView.this.hLw = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.hLy != null) {
                        AlaRankListHeaderView.this.hLy.bRY();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.hLf != null && "hour".equals(AlaRankListHeaderView.this.fYQ) && AlaRankListHeaderView.this.hLt && AlaRankListHeaderView.this.hLw >= 0) {
                    AlaRankListHeaderView.this.hLf.setText(String.format(AlaRankListHeaderView.this.hLe.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.hLw))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_header_layout, this);
        this.hLf = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_refresh_tip);
        this.hLu = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_game_rule);
        this.hLv = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_flower_description);
        this.hLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.aa.a.Ph().bms.aKi)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.hLe, new String[]{com.baidu.live.aa.a.Ph().bms.aKi}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fYQ)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.hLg = (TextView) this.mRootView.findViewById(a.f.rank_list_switch);
        this.hLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.hLt = !AlaRankListHeaderView.this.hLt;
                AlaRankListHeaderView.this.hLg.setText(AlaRankListHeaderView.this.hLt ? a.h.hour_rank_list_head_switch_cur : a.h.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.hLz != null) {
                    AlaRankListHeaderView.this.hLz.mk(AlaRankListHeaderView.this.hLt);
                }
            }
        });
        this.hLh = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hLi = (RelativeLayout) this.mRootView.findViewById(a.f.rl_rank_first);
        this.hLj = (HeadImageView) this.mRootView.findViewById(a.f.rank_first);
        this.hLj.setIsRound(true);
        this.hLj.setAutoChangeStyle(false);
        this.hLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hLA != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.hLA.eDa != 1 || AlaRankListHeaderView.this.hLA.live_id <= 0 || AlaRankListHeaderView.this.hLA.live_id == AlaRankListHeaderView.this.fYO || AlaRankListHeaderView.this.fYR) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hLe.getPageActivity(), AlaRankListHeaderView.this.hLA.user_id, AlaRankListHeaderView.this.hLA.user_name, AlaRankListHeaderView.this.hLA.bdPortrait, AlaRankListHeaderView.this.hLA.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.Ph().bms.aLa) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.hLe.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.gaF);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.hLA.live_id, "", "live_sdk");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.hLk = (HeadImageView) this.mRootView.findViewById(a.f.rank_first2);
        this.hLk.setIsRound(true);
        this.hLk.setAutoChangeStyle(false);
        this.hLl = (TextView) this.mRootView.findViewById(a.f.name_rank_1);
        this.hLm = (TextView) this.mRootView.findViewById(a.f.point_rank_1);
        this.hLo = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hLn = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hLo.setIsRound(true);
        this.hLo.setAutoChangeStyle(false);
        this.hLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.hLA != null && AlaRankListHeaderView.this.hLA.gzS != null && AlaRankListHeaderView.this.hLA.gzS.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.hLA.gzS.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hLe.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.hLp = (HeadImageView) this.mRootView.findViewById(a.f.charm_first2);
        this.hLp.setIsRound(true);
        this.hLp.setAutoChangeStyle(false);
        this.hLq = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hLr = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hLs = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
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
        this.hLe = tbPageContext;
        this.fYQ = str;
        initView();
        if (j > 0 && "hour".equals(this.fYQ) && !this.hLx) {
            this.hLx = true;
            this.hLw = j;
            this.hLf.setText(String.format(this.hLe.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hLw))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clb() {
        if (this.aVN == null) {
            this.aVN = new AnimatorSet();
        }
        this.aVN.cancel();
        HeadImageView headImageView = this.hLt ? this.hLk : this.hLj;
        HeadImageView headImageView2 = this.hLt ? this.hLj : this.hLk;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.hLt ? this.hLp : this.hLo;
        HeadImageView headImageView4 = this.hLt ? this.hLo : this.hLp;
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
        this.aVN.setDuration(1000L);
        this.aVN.playTogether(this.mAnimators);
        this.aVN.setInterpolator(new AccelerateInterpolator());
        this.aVN.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.bix) {
                this.hLk.setAlpha(0);
                this.hLk.setVisibility(0);
                this.hLp.setAlpha(0);
                this.hLp.setVisibility(0);
            }
            this.hLA = hVar;
            if (this.hLt) {
                this.hLj.startLoad(hVar.avatar, 12, false);
            } else {
                this.hLk.startLoad(hVar.avatar, 12, false);
            }
            this.hLl.setText(hVar.getName_show());
            this.hLm.setText(String.format(this.hLe.getString(a.h.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.eDa == 1) {
                this.hLs.setVisibility(0);
                this.hLs.loop(true);
                this.hLs.setAnimation("anchor_living.json");
                this.hLs.playAnimation();
            } else {
                this.hLs.setVisibility(8);
            }
            if (hVar.gzS != null && (aVar = hVar.gzS.get(0)) != null) {
                if (this.hLt) {
                    this.hLo.startLoad(aVar.portrait, 12, false);
                } else {
                    this.hLp.startLoad(aVar.portrait, 12, false);
                }
                this.hLq.setText(aVar.userNickName);
                this.hLr.setText(String.format(this.hLe.getString(a.h.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.bih)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bix) {
                        AlaRankListHeaderView.this.clb();
                    }
                    AlaRankListHeaderView.this.bix = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fYQ)) {
            this.hLu.setVisibility(0);
            this.hLv.setVisibility(8);
            this.hLf.setText(this.hLe.getPageActivity().getString(a.h.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fYQ)) {
            this.hLu.setVisibility(8);
            this.hLv.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.hLw > 0 && !z) {
                this.hLf.setText(String.format(this.hLe.getString(a.h.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.hLw))));
                startCountDown();
            } else {
                this.hLf.setText(this.hLe.getPageActivity().getString(a.h.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fYQ)) {
            this.mRootView.setVisibility(0);
            this.hLv.setVisibility(8);
            this.hLu.setVisibility(8);
            this.hLh.setVisibility(0);
            if (this.hLw >= 0 && this.hLt) {
                this.hLf.setText(String.format(this.hLe.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.hLw))));
            } else if (!this.hLt) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.TV()).append(":00-").append("00".equals(com.baidu.live.utils.j.TU()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.TU()).append(":00");
                this.hLf.setText(sb);
            }
        } else if ("charm_day".equals(this.fYQ)) {
            this.mRootView.setVisibility(8);
            this.hLv.setVisibility(8);
            this.hLu.setVisibility(8);
            this.hLh.setVisibility(8);
            this.hLf.setVisibility(8);
            this.hLg.setVisibility(8);
        } else {
            this.hLh.setVisibility(8);
            this.hLv.setVisibility(8);
            this.hLu.setVisibility(8);
            this.hLf.setText(this.hLe.getPageActivity().getString(a.h.hkqm_rank_list_refresh_charm_rule));
        }
        this.hLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.hLe.getPageActivity(), a.h.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.hLe, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hLh != null) {
            this.hLh.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gKv);
        this.mHandler.postDelayed(this.gKv, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gKv);
    }

    public void setCountDownCallback(a aVar) {
        this.hLy = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.hLz = bVar;
    }
}
