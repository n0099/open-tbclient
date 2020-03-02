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
    private final Runnable eJQ;
    private long ehL;
    private String ehN;
    private boolean ehO;
    private TextView fAA;
    private RelativeLayout fAB;
    private HeadImageView fAC;
    private HeadImageView fAD;
    private TextView fAE;
    private TextView fAF;
    private LottieAnimationView fAG;
    private boolean fAH;
    private TextView fAI;
    private ImageView fAJ;
    private long fAK;
    private boolean fAL;
    private a fAM;
    private b fAN;
    private g fAO;
    private TbPageContext fAs;
    private TextView fAt;
    private TextView fAu;
    private FrameLayout fAv;
    private RelativeLayout fAw;
    private HeadImageView fAx;
    private HeadImageView fAy;
    private TextView fAz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void beJ();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void iu(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.fAK;
        alaRankListHeaderView.fAK = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.fAH = true;
        this.mHandler = new Handler();
        this.eJQ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAK <= 0) {
                    AlaRankListHeaderView.this.fAK = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAM != null) {
                        AlaRankListHeaderView.this.fAM.beJ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAt != null && "hour".equals(AlaRankListHeaderView.this.ehN) && AlaRankListHeaderView.this.fAH && AlaRankListHeaderView.this.fAK >= 0) {
                    AlaRankListHeaderView.this.fAt.setText(String.format(AlaRankListHeaderView.this.fAs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAK))));
                }
            }
        };
        this.ehL = j;
        this.ehO = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAH = true;
        this.mHandler = new Handler();
        this.eJQ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAK <= 0) {
                    AlaRankListHeaderView.this.fAK = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAM != null) {
                        AlaRankListHeaderView.this.fAM.beJ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAt != null && "hour".equals(AlaRankListHeaderView.this.ehN) && AlaRankListHeaderView.this.fAH && AlaRankListHeaderView.this.fAK >= 0) {
                    AlaRankListHeaderView.this.fAt.setText(String.format(AlaRankListHeaderView.this.fAs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAK))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAH = true;
        this.mHandler = new Handler();
        this.eJQ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fAK <= 0) {
                    AlaRankListHeaderView.this.fAK = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fAM != null) {
                        AlaRankListHeaderView.this.fAM.beJ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fAt != null && "hour".equals(AlaRankListHeaderView.this.ehN) && AlaRankListHeaderView.this.fAH && AlaRankListHeaderView.this.fAK >= 0) {
                    AlaRankListHeaderView.this.fAt.setText(String.format(AlaRankListHeaderView.this.fAs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fAK))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.fAt = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.fAI = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.fAJ = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.fAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.zl().awB.ZK)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.fAs, new String[]{com.baidu.live.v.a.zl().awB.ZK}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.ehN)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.fAu = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.fAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.fAH = !AlaRankListHeaderView.this.fAH;
                AlaRankListHeaderView.this.fAu.setText(AlaRankListHeaderView.this.fAH ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.fAN != null) {
                    AlaRankListHeaderView.this.fAN.iu(AlaRankListHeaderView.this.fAH);
                }
            }
        });
        this.fAv = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.fAw = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.fAx = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.fAx.setIsRound(true);
        this.fAx.setAutoChangeStyle(false);
        this.fAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fAO != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.fAO.cSl != 1 || AlaRankListHeaderView.this.fAO.live_id <= 0 || AlaRankListHeaderView.this.fAO.live_id == AlaRankListHeaderView.this.ehL || AlaRankListHeaderView.this.ehO) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fAs.getPageActivity(), AlaRankListHeaderView.this.fAO.user_id, AlaRankListHeaderView.this.fAO.user_name, AlaRankListHeaderView.this.fAO.eAk, AlaRankListHeaderView.this.fAO.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awB.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.fAs.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.fAO.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.fAy = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.fAy.setIsRound(true);
        this.fAy.setAutoChangeStyle(false);
        this.fAz = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.fAA = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.fAC = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.fAB = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.fAC.setIsRound(true);
        this.fAC.setAutoChangeStyle(false);
        this.fAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fAO != null && AlaRankListHeaderView.this.fAO.ezN != null && AlaRankListHeaderView.this.fAO.ezN.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.fAO.ezN.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fAs.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.fAD = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.fAD.setIsRound(true);
        this.fAD.setAutoChangeStyle(false);
        this.fAE = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.fAF = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.fAG = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.fAs = tbPageContext;
        this.ehN = str;
        initView();
        if (j > 0 && "hour".equals(this.ehN) && !this.fAL) {
            this.fAL = true;
            this.fAK = j;
            this.fAt.setText(String.format(this.fAs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fAK))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btC() {
        if (this.aiq == null) {
            this.aiq = new AnimatorSet();
        }
        this.aiq.cancel();
        HeadImageView headImageView = this.fAH ? this.fAy : this.fAx;
        HeadImageView headImageView2 = this.fAH ? this.fAx : this.fAy;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.fAH ? this.fAD : this.fAC;
        HeadImageView headImageView4 = this.fAH ? this.fAC : this.fAD;
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
                this.fAy.setAlpha(0);
                this.fAy.setVisibility(0);
                this.fAD.setAlpha(0);
                this.fAD.setVisibility(0);
            }
            this.fAO = gVar;
            if (this.fAH) {
                this.fAx.startLoad(gVar.avatar, 12, false);
            } else {
                this.fAy.startLoad(gVar.avatar, 12, false);
            }
            this.fAz.setText(gVar.getName_show());
            this.fAA.setText(String.format(this.fAs.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.cSl == 1) {
                this.fAG.setVisibility(0);
                this.fAG.loop(true);
                this.fAG.setAnimation("anchor_living.json");
                this.fAG.playAnimation();
            } else {
                this.fAG.setVisibility(8);
            }
            if (gVar.ezN != null && (aVar = gVar.ezN.get(0)) != null) {
                if (this.fAH) {
                    this.fAC.startLoad(aVar.portrait, 12, false);
                } else {
                    this.fAD.startLoad(aVar.portrait, 12, false);
                }
                this.fAE.setText(aVar.ezO);
                this.fAF.setText(String.format(this.fAs.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.ezP)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.asv) {
                        AlaRankListHeaderView.this.btC();
                    }
                    AlaRankListHeaderView.this.asv = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.ehN)) {
            this.fAI.setVisibility(0);
            this.fAJ.setVisibility(8);
            this.fAt.setText(this.fAs.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehN)) {
            this.fAI.setVisibility(8);
            this.fAJ.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.fAK > 0 && !z) {
                this.fAt.setText(String.format(this.fAs.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.fAK))));
                startCountDown();
            } else {
                this.fAt.setText(this.fAs.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.ehN)) {
            this.mRootView.setVisibility(0);
            this.fAJ.setVisibility(8);
            this.fAI.setVisibility(8);
            this.fAv.setVisibility(0);
            if (this.fAK >= 0 && this.fAH) {
                this.fAt.setText(String.format(this.fAs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fAK))));
            } else if (!this.fAH) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.AZ()).append(":00-").append("00".equals(i.AY()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.AY()).append(":00");
                this.fAt.setText(sb);
            }
        } else if ("charm_day".equals(this.ehN)) {
            this.mRootView.setVisibility(8);
            this.fAJ.setVisibility(8);
            this.fAI.setVisibility(8);
            this.fAv.setVisibility(8);
            this.fAt.setVisibility(8);
            this.fAu.setVisibility(8);
        } else {
            this.fAv.setVisibility(8);
            this.fAJ.setVisibility(8);
            this.fAI.setVisibility(8);
            this.fAt.setText(this.fAs.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.fAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.fAs.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.fAs, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.fAv != null) {
            this.fAv.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eJQ);
        this.mHandler.postDelayed(this.eJQ, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eJQ);
    }

    public void setCountDownCallback(a aVar) {
        this.fAM = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.fAN = bVar;
    }
}
