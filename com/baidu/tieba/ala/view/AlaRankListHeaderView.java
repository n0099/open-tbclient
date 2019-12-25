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
import com.baidu.live.q.a;
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
import com.baidu.live.utils.i;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet afx;
    private boolean aoq;
    private final Runnable eEL;
    private String edB;
    private boolean edC;
    private long edz;
    private TbPageContext fuH;
    private TextView fuI;
    private TextView fuJ;
    private FrameLayout fuK;
    private RelativeLayout fuL;
    private HeadImageView fuM;
    private HeadImageView fuN;
    private TextView fuO;
    private TextView fuP;
    private RelativeLayout fuQ;
    private HeadImageView fuR;
    private HeadImageView fuS;
    private TextView fuT;
    private TextView fuU;
    private LottieAnimationView fuV;
    private boolean fuW;
    private TextView fuX;
    private ImageView fuY;
    private long fuZ;
    private boolean fva;
    private a fvb;
    private b fvc;
    private g fvd;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void bbZ();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void id(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.fuZ;
        alaRankListHeaderView.fuZ = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.fuW = true;
        this.mHandler = new Handler();
        this.eEL = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fuZ <= 0) {
                    AlaRankListHeaderView.this.fuZ = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fvb != null) {
                        AlaRankListHeaderView.this.fvb.bbZ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fuI != null && "hour".equals(AlaRankListHeaderView.this.edB) && AlaRankListHeaderView.this.fuW && AlaRankListHeaderView.this.fuZ >= 0) {
                    AlaRankListHeaderView.this.fuI.setText(String.format(AlaRankListHeaderView.this.fuH.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fuZ))));
                }
            }
        };
        this.edz = j;
        this.edC = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fuW = true;
        this.mHandler = new Handler();
        this.eEL = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fuZ <= 0) {
                    AlaRankListHeaderView.this.fuZ = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fvb != null) {
                        AlaRankListHeaderView.this.fvb.bbZ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fuI != null && "hour".equals(AlaRankListHeaderView.this.edB) && AlaRankListHeaderView.this.fuW && AlaRankListHeaderView.this.fuZ >= 0) {
                    AlaRankListHeaderView.this.fuI.setText(String.format(AlaRankListHeaderView.this.fuH.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fuZ))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fuW = true;
        this.mHandler = new Handler();
        this.eEL = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fuZ <= 0) {
                    AlaRankListHeaderView.this.fuZ = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fvb != null) {
                        AlaRankListHeaderView.this.fvb.bbZ();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fuI != null && "hour".equals(AlaRankListHeaderView.this.edB) && AlaRankListHeaderView.this.fuW && AlaRankListHeaderView.this.fuZ >= 0) {
                    AlaRankListHeaderView.this.fuI.setText(String.format(AlaRankListHeaderView.this.fuH.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fuZ))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.fuI = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.fuX = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.fuY = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.fuY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.r.a.wA().arE.XA)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.fuH, new String[]{com.baidu.live.r.a.wA().arE.XA}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.edB)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.fuJ = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.fuJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.fuW = !AlaRankListHeaderView.this.fuW;
                AlaRankListHeaderView.this.fuJ.setText(AlaRankListHeaderView.this.fuW ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.fvc != null) {
                    AlaRankListHeaderView.this.fvc.id(AlaRankListHeaderView.this.fuW);
                }
            }
        });
        this.fuK = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.fuL = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.fuM = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.fuM.setIsRound(true);
        this.fuM.setAutoChangeStyle(false);
        this.fuL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fvd != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.fvd.cNX != 1 || AlaRankListHeaderView.this.fvd.live_id <= 0 || AlaRankListHeaderView.this.fvd.live_id == AlaRankListHeaderView.this.edz || AlaRankListHeaderView.this.edC) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fuH.getPageActivity(), AlaRankListHeaderView.this.fvd.user_id, AlaRankListHeaderView.this.fvd.user_name, AlaRankListHeaderView.this.fvd.euN, AlaRankListHeaderView.this.fvd.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.r.a.wA().arE.Yr) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.fuH.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.fvd.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.fuN = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.fuN.setIsRound(true);
        this.fuN.setAutoChangeStyle(false);
        this.fuO = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.fuP = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.fuR = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.fuQ = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.fuR.setIsRound(true);
        this.fuR.setAutoChangeStyle(false);
        this.fuQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fvd != null && AlaRankListHeaderView.this.fvd.euq != null && AlaRankListHeaderView.this.fvd.euq.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.fvd.euq.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fuH.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.fuS = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.fuS.setIsRound(true);
        this.fuS.setAutoChangeStyle(false);
        this.fuT = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.fuU = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.fuV = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.fuH = tbPageContext;
        this.edB = str;
        initView();
        if (j > 0 && "hour".equals(this.edB) && !this.fva) {
            this.fva = true;
            this.fuZ = j;
            this.fuI.setText(String.format(this.fuH.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fuZ))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        if (this.afx == null) {
            this.afx = new AnimatorSet();
        }
        this.afx.cancel();
        HeadImageView headImageView = this.fuW ? this.fuN : this.fuM;
        HeadImageView headImageView2 = this.fuW ? this.fuM : this.fuN;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.fuW ? this.fuS : this.fuR;
        HeadImageView headImageView4 = this.fuW ? this.fuR : this.fuS;
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
        this.afx.setDuration(1000L);
        this.afx.playTogether(this.mAnimators);
        this.afx.setInterpolator(new AccelerateInterpolator());
        this.afx.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.aoq) {
                this.fuN.setAlpha(0);
                this.fuN.setVisibility(0);
                this.fuS.setAlpha(0);
                this.fuS.setVisibility(0);
            }
            this.fvd = gVar;
            if (this.fuW) {
                this.fuM.startLoad(gVar.avatar, 12, false);
            } else {
                this.fuN.startLoad(gVar.avatar, 12, false);
            }
            this.fuO.setText(gVar.getName_show());
            this.fuP.setText(String.format(this.fuH.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.aao, 0L))));
            if (gVar.cNX == 1) {
                this.fuV.setVisibility(0);
                this.fuV.loop(true);
                this.fuV.setAnimation("anchor_living.json");
                this.fuV.playAnimation();
            } else {
                this.fuV.setVisibility(8);
            }
            if (gVar.euq != null && (aVar = gVar.euq.get(0)) != null) {
                if (this.fuW) {
                    this.fuR.startLoad(aVar.portrait, 12, false);
                } else {
                    this.fuS.startLoad(aVar.portrait, 12, false);
                }
                this.fuT.setText(aVar.eur);
                this.fuU.setText(String.format(this.fuH.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.eus)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aoq) {
                        AlaRankListHeaderView.this.bqU();
                    }
                    AlaRankListHeaderView.this.aoq = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.edB)) {
            this.fuX.setVisibility(0);
            this.fuY.setVisibility(8);
            this.fuI.setText(this.fuH.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edB)) {
            this.fuX.setVisibility(8);
            this.fuY.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.fuZ > 0 && !z) {
                this.fuI.setText(String.format(this.fuH.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.fuZ))));
                startCountDown();
            } else {
                this.fuI.setText(this.fuH.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.edB)) {
            this.mRootView.setVisibility(0);
            this.fuY.setVisibility(8);
            this.fuX.setVisibility(8);
            this.fuK.setVisibility(0);
            if (this.fuZ >= 0 && this.fuW) {
                this.fuI.setText(String.format(this.fuH.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fuZ))));
            } else if (!this.fuW) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.yq()).append(":00-").append("00".equals(i.yp()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.yp()).append(":00");
                this.fuI.setText(sb);
            }
        } else if ("charm_day".equals(this.edB)) {
            this.mRootView.setVisibility(8);
            this.fuY.setVisibility(8);
            this.fuX.setVisibility(8);
            this.fuK.setVisibility(8);
            this.fuI.setVisibility(8);
            this.fuJ.setVisibility(8);
        } else {
            this.fuK.setVisibility(8);
            this.fuY.setVisibility(8);
            this.fuX.setVisibility(8);
            this.fuI.setText(this.fuH.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.fuX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.fuH.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.fuH, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.fuK != null) {
            this.fuK.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eEL);
        this.mHandler.postDelayed(this.eEL, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eEL);
    }

    public void setCountDownCallback(a aVar) {
        this.fvb = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.fvc = bVar;
    }
}
