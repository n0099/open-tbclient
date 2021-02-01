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
    private AnimatorSet aZa;
    private boolean bmV;
    private long gpB;
    private String gpD;
    private boolean gpE;
    private AlaLastLiveroomInfo grr;
    private final Runnable hdA;
    private TbPageContext iiN;
    private TextView iiO;
    private TextView iiP;
    private FrameLayout iiQ;
    private RelativeLayout iiR;
    private HeadImageView iiS;
    private HeadImageView iiT;
    private TextView iiU;
    private TextView iiV;
    private RelativeLayout iiW;
    private HeadImageView iiX;
    private HeadImageView iiY;
    private TextView iiZ;
    private TextView ija;
    private LottieAnimationView ijb;
    private boolean ijc;
    private TextView ijd;
    private ImageView ije;
    private long ijf;
    private boolean ijg;
    private a ijh;
    private b iji;
    private com.baidu.tieba.ala.data.h ijj;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes11.dex */
    public interface a {
        void bVb();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void ng(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.ijf;
        alaRankListHeaderView.ijf = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.ijc = true;
        this.mHandler = new Handler();
        this.hdA = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ijf <= 0) {
                    AlaRankListHeaderView.this.ijf = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ijh != null) {
                        AlaRankListHeaderView.this.ijh.bVb();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.iiO != null && "hour".equals(AlaRankListHeaderView.this.gpD) && AlaRankListHeaderView.this.ijc && AlaRankListHeaderView.this.ijf >= 0) {
                    AlaRankListHeaderView.this.iiO.setText(String.format(AlaRankListHeaderView.this.iiN.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.ijf))));
                }
            }
        };
        this.gpB = j;
        this.gpE = z;
        this.grr = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ijc = true;
        this.mHandler = new Handler();
        this.hdA = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ijf <= 0) {
                    AlaRankListHeaderView.this.ijf = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ijh != null) {
                        AlaRankListHeaderView.this.ijh.bVb();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.iiO != null && "hour".equals(AlaRankListHeaderView.this.gpD) && AlaRankListHeaderView.this.ijc && AlaRankListHeaderView.this.ijf >= 0) {
                    AlaRankListHeaderView.this.iiO.setText(String.format(AlaRankListHeaderView.this.iiN.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.ijf))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ijc = true;
        this.mHandler = new Handler();
        this.hdA = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ijf <= 0) {
                    AlaRankListHeaderView.this.ijf = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ijh != null) {
                        AlaRankListHeaderView.this.ijh.bVb();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.iiO != null && "hour".equals(AlaRankListHeaderView.this.gpD) && AlaRankListHeaderView.this.ijc && AlaRankListHeaderView.this.ijf >= 0) {
                    AlaRankListHeaderView.this.iiO.setText(String.format(AlaRankListHeaderView.this.iiN.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.ijf))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_header_layout, this);
        this.iiO = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_refresh_tip);
        this.ijd = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_game_rule);
        this.ije = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_flower_description);
        this.ije.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.ae.a.Qj().buX.aLE)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.iiN, new String[]{com.baidu.live.ae.a.Qj().buX.aLE}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.gpD)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.iiP = (TextView) this.mRootView.findViewById(a.f.rank_list_switch);
        this.iiP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.ijc = !AlaRankListHeaderView.this.ijc;
                AlaRankListHeaderView.this.iiP.setText(AlaRankListHeaderView.this.ijc ? a.h.hour_rank_list_head_switch_cur : a.h.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.iji != null) {
                    AlaRankListHeaderView.this.iji.ng(AlaRankListHeaderView.this.ijc);
                }
            }
        });
        this.iiQ = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.iiR = (RelativeLayout) this.mRootView.findViewById(a.f.rl_rank_first);
        this.iiS = (HeadImageView) this.mRootView.findViewById(a.f.rank_first);
        this.iiS.setIsRound(true);
        this.iiS.setAutoChangeStyle(false);
        this.iiR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ijj != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.ijj.eRx != 1 || AlaRankListHeaderView.this.ijj.live_id <= 0 || AlaRankListHeaderView.this.ijj.live_id == AlaRankListHeaderView.this.gpB || AlaRankListHeaderView.this.gpE) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.iiN.getPageActivity(), AlaRankListHeaderView.this.ijj.user_id, AlaRankListHeaderView.this.ijj.user_name, AlaRankListHeaderView.this.ijj.bdPortrait, AlaRankListHeaderView.this.ijj.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qj().buX.aMw) {
                        com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(AlaRankListHeaderView.this.ijj.live_id)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.iiN.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.grr);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.ijj.live_id, AlaRankListHeaderView.this.ijj.room_id + "", "live_sdk");
                        com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        });
        this.iiT = (HeadImageView) this.mRootView.findViewById(a.f.rank_first2);
        this.iiT.setIsRound(true);
        this.iiT.setAutoChangeStyle(false);
        this.iiU = (TextView) this.mRootView.findViewById(a.f.name_rank_1);
        this.iiV = (TextView) this.mRootView.findViewById(a.f.point_rank_1);
        this.iiX = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.iiW = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.iiX.setIsRound(true);
        this.iiX.setAutoChangeStyle(false);
        this.iiW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ijj != null && AlaRankListHeaderView.this.ijj.gSH != null && AlaRankListHeaderView.this.ijj.gSH.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.ijj.gSH.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.iiN.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.iiY = (HeadImageView) this.mRootView.findViewById(a.f.charm_first2);
        this.iiY.setIsRound(true);
        this.iiY.setAutoChangeStyle(false);
        this.iiZ = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.ija = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.ijb = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
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
        this.iiN = tbPageContext;
        this.gpD = str;
        initView();
        if (j > 0 && "hour".equals(this.gpD) && !this.ijg) {
            this.ijg = true;
            this.ijf = j;
            this.iiO.setText(String.format(this.iiN.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.ijf))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpy() {
        if (this.aZa == null) {
            this.aZa = new AnimatorSet();
        }
        this.aZa.cancel();
        HeadImageView headImageView = this.ijc ? this.iiT : this.iiS;
        HeadImageView headImageView2 = this.ijc ? this.iiS : this.iiT;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.ijc ? this.iiY : this.iiX;
        HeadImageView headImageView4 = this.ijc ? this.iiX : this.iiY;
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
        this.aZa.setDuration(1000L);
        this.aZa.playTogether(this.mAnimators);
        this.aZa.setInterpolator(new AccelerateInterpolator());
        this.aZa.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.bmV) {
                this.iiT.setAlpha(0);
                this.iiT.setVisibility(0);
                this.iiY.setAlpha(0);
                this.iiY.setVisibility(0);
            }
            this.ijj = hVar;
            if (this.ijc) {
                this.iiS.startLoad(hVar.avatar, 12, false);
            } else {
                this.iiT.startLoad(hVar.avatar, 12, false);
            }
            this.iiU.setText(hVar.getName_show());
            this.iiV.setText(String.format(this.iiN.getString(a.h.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.gSE, 0L))));
            if (hVar.eRx == 1) {
                this.ijb.setVisibility(0);
                this.ijb.loop(true);
                this.ijb.setAnimation("anchor_living.json");
                this.ijb.playAnimation();
            } else {
                this.ijb.setVisibility(8);
            }
            if (hVar.gSH != null && (aVar = hVar.gSH.get(0)) != null) {
                if (this.ijc) {
                    this.iiX.startLoad(aVar.portrait, 12, false);
                } else {
                    this.iiY.startLoad(aVar.portrait, 12, false);
                }
                this.iiZ.setText(aVar.userNickName);
                this.ija.setText(String.format(this.iiN.getString(a.h.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aVC)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bmV) {
                        AlaRankListHeaderView.this.cpy();
                    }
                    AlaRankListHeaderView.this.bmV = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.gpD)) {
            this.ijd.setVisibility(0);
            this.ije.setVisibility(8);
            this.iiO.setText(this.iiN.getPageActivity().getString(a.h.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gpD)) {
            this.ijd.setVisibility(8);
            this.ije.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.ijf > 0 && !z) {
                this.iiO.setText(String.format(this.iiN.getString(a.h.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.ijf))));
                startCountDown();
            } else {
                this.iiO.setText(this.iiN.getPageActivity().getString(a.h.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.gpD)) {
            this.mRootView.setVisibility(0);
            this.ije.setVisibility(8);
            this.ijd.setVisibility(8);
            this.iiQ.setVisibility(0);
            if (this.ijf >= 0 && this.ijc) {
                this.iiO.setText(String.format(this.iiN.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.ijf))));
            } else if (!this.ijc) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.Vo()).append(":00-").append("00".equals(com.baidu.live.utils.j.Vn()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.Vn()).append(":00");
                this.iiO.setText(sb);
            }
        } else if ("charm_day".equals(this.gpD)) {
            this.mRootView.setVisibility(8);
            this.ije.setVisibility(8);
            this.ijd.setVisibility(8);
            this.iiQ.setVisibility(8);
            this.iiO.setVisibility(8);
            this.iiP.setVisibility(8);
        } else {
            this.iiQ.setVisibility(8);
            this.ije.setVisibility(8);
            this.ijd.setVisibility(8);
            this.iiO.setText(this.iiN.getPageActivity().getString(a.h.hkqm_rank_list_refresh_charm_rule));
        }
        this.ijd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.iiN.getPageActivity(), a.h.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.iiN, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.iiQ != null) {
            this.iiQ.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hdA);
        this.mHandler.postDelayed(this.hdA, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hdA);
    }

    public void setCountDownCallback(a aVar) {
        this.ijh = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.iji = bVar;
    }
}
