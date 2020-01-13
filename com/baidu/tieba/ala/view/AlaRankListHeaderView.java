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
import com.baidu.live.r.a;
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
    private AnimatorSet agh;
    private boolean apc;
    private final Runnable eFV;
    private long edH;
    private String edJ;
    private boolean edK;
    private TbPageContext fxS;
    private TextView fxT;
    private TextView fxU;
    private FrameLayout fxV;
    private RelativeLayout fxW;
    private HeadImageView fxX;
    private HeadImageView fxY;
    private TextView fxZ;
    private TextView fya;
    private RelativeLayout fyb;
    private HeadImageView fyc;
    private HeadImageView fyd;
    private TextView fye;
    private TextView fyf;
    private LottieAnimationView fyg;
    private boolean fyh;
    private TextView fyi;
    private ImageView fyj;
    private long fyk;
    private boolean fyl;
    private a fym;
    private b fyn;
    private g fyo;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void bcu();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void in(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.fyk;
        alaRankListHeaderView.fyk = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.fyh = true;
        this.mHandler = new Handler();
        this.eFV = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fyk <= 0) {
                    AlaRankListHeaderView.this.fyk = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fym != null) {
                        AlaRankListHeaderView.this.fym.bcu();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fxT != null && "hour".equals(AlaRankListHeaderView.this.edJ) && AlaRankListHeaderView.this.fyh && AlaRankListHeaderView.this.fyk >= 0) {
                    AlaRankListHeaderView.this.fxT.setText(String.format(AlaRankListHeaderView.this.fxS.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fyk))));
                }
            }
        };
        this.edH = j;
        this.edK = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyh = true;
        this.mHandler = new Handler();
        this.eFV = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fyk <= 0) {
                    AlaRankListHeaderView.this.fyk = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fym != null) {
                        AlaRankListHeaderView.this.fym.bcu();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fxT != null && "hour".equals(AlaRankListHeaderView.this.edJ) && AlaRankListHeaderView.this.fyh && AlaRankListHeaderView.this.fyk >= 0) {
                    AlaRankListHeaderView.this.fxT.setText(String.format(AlaRankListHeaderView.this.fxS.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fyk))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyh = true;
        this.mHandler = new Handler();
        this.eFV = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fyk <= 0) {
                    AlaRankListHeaderView.this.fyk = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fym != null) {
                        AlaRankListHeaderView.this.fym.bcu();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fxT != null && "hour".equals(AlaRankListHeaderView.this.edJ) && AlaRankListHeaderView.this.fyh && AlaRankListHeaderView.this.fyk >= 0) {
                    AlaRankListHeaderView.this.fxT.setText(String.format(AlaRankListHeaderView.this.fxS.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fyk))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.fxT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.fyi = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.fyj = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.fyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.s.a.wR().asq.XT)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.fxS, new String[]{com.baidu.live.s.a.wR().asq.XT}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.edJ)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.fxU = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.fxU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.fyh = !AlaRankListHeaderView.this.fyh;
                AlaRankListHeaderView.this.fxU.setText(AlaRankListHeaderView.this.fyh ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.fyn != null) {
                    AlaRankListHeaderView.this.fyn.in(AlaRankListHeaderView.this.fyh);
                }
            }
        });
        this.fxV = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.fxW = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.fxX = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.fxX.setIsRound(true);
        this.fxX.setAutoChangeStyle(false);
        this.fxW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fyo != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.fyo.cOh != 1 || AlaRankListHeaderView.this.fyo.live_id <= 0 || AlaRankListHeaderView.this.fyo.live_id == AlaRankListHeaderView.this.edH || AlaRankListHeaderView.this.edK) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fxS.getPageActivity(), AlaRankListHeaderView.this.fyo.user_id, AlaRankListHeaderView.this.fyo.user_name, AlaRankListHeaderView.this.fyo.evY, AlaRankListHeaderView.this.fyo.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.s.a.wR().asq.YD) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.fxS.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.fyo.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.fxY = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.fxY.setIsRound(true);
        this.fxY.setAutoChangeStyle(false);
        this.fxZ = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.fya = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.fyc = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.fyb = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.fyc.setIsRound(true);
        this.fyc.setAutoChangeStyle(false);
        this.fyb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fyo != null && AlaRankListHeaderView.this.fyo.evB != null && AlaRankListHeaderView.this.fyo.evB.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.fyo.evB.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fxS.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.fyd = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.fyd.setIsRound(true);
        this.fyd.setAutoChangeStyle(false);
        this.fye = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.fyf = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.fyg = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.fxS = tbPageContext;
        this.edJ = str;
        initView();
        if (j > 0 && "hour".equals(this.edJ) && !this.fyl) {
            this.fyl = true;
            this.fyk = j;
            this.fxT.setText(String.format(this.fxS.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fyk))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brW() {
        if (this.agh == null) {
            this.agh = new AnimatorSet();
        }
        this.agh.cancel();
        HeadImageView headImageView = this.fyh ? this.fxY : this.fxX;
        HeadImageView headImageView2 = this.fyh ? this.fxX : this.fxY;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.fyh ? this.fyd : this.fyc;
        HeadImageView headImageView4 = this.fyh ? this.fyc : this.fyd;
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
        this.agh.setDuration(1000L);
        this.agh.playTogether(this.mAnimators);
        this.agh.setInterpolator(new AccelerateInterpolator());
        this.agh.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.apc) {
                this.fxY.setAlpha(0);
                this.fxY.setVisibility(0);
                this.fyd.setAlpha(0);
                this.fyd.setVisibility(0);
            }
            this.fyo = gVar;
            if (this.fyh) {
                this.fxX.startLoad(gVar.avatar, 12, false);
            } else {
                this.fxY.startLoad(gVar.avatar, 12, false);
            }
            this.fxZ.setText(gVar.getName_show());
            this.fya.setText(String.format(this.fxS.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.cOh == 1) {
                this.fyg.setVisibility(0);
                this.fyg.loop(true);
                this.fyg.setAnimation("anchor_living.json");
                this.fyg.playAnimation();
            } else {
                this.fyg.setVisibility(8);
            }
            if (gVar.evB != null && (aVar = gVar.evB.get(0)) != null) {
                if (this.fyh) {
                    this.fyc.startLoad(aVar.portrait, 12, false);
                } else {
                    this.fyd.startLoad(aVar.portrait, 12, false);
                }
                this.fye.setText(aVar.evC);
                this.fyf.setText(String.format(this.fxS.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.evD)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.apc) {
                        AlaRankListHeaderView.this.brW();
                    }
                    AlaRankListHeaderView.this.apc = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.edJ)) {
            this.fyi.setVisibility(0);
            this.fyj.setVisibility(8);
            this.fxT.setText(this.fxS.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edJ)) {
            this.fyi.setVisibility(8);
            this.fyj.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.fyk > 0 && !z) {
                this.fxT.setText(String.format(this.fxS.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.fyk))));
                startCountDown();
            } else {
                this.fxT.setText(this.fxS.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.edJ)) {
            this.mRootView.setVisibility(0);
            this.fyj.setVisibility(8);
            this.fyi.setVisibility(8);
            this.fxV.setVisibility(0);
            if (this.fyk >= 0 && this.fyh) {
                this.fxT.setText(String.format(this.fxS.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fyk))));
            } else if (!this.fyh) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.yG()).append(":00-").append("00".equals(i.yF()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.yF()).append(":00");
                this.fxT.setText(sb);
            }
        } else if ("charm_day".equals(this.edJ)) {
            this.mRootView.setVisibility(8);
            this.fyj.setVisibility(8);
            this.fyi.setVisibility(8);
            this.fxV.setVisibility(8);
            this.fxT.setVisibility(8);
            this.fxU.setVisibility(8);
        } else {
            this.fxV.setVisibility(8);
            this.fyj.setVisibility(8);
            this.fyi.setVisibility(8);
            this.fxT.setText(this.fxS.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.fyi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.fxS.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.fxS, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.fxV != null) {
            this.fxV.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eFV);
        this.mHandler.postDelayed(this.eFV, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eFV);
    }

    public void setCountDownCallback(a aVar) {
        this.fym = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.fyn = bVar;
    }
}
