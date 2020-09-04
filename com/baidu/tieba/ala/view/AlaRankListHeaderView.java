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
import com.baidu.live.utils.i;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.h;
import com.baidu.tieba.ala.data.n;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet aPy;
    private boolean bbn;
    private long fvG;
    private String fvI;
    private boolean fvJ;
    private AlaLastLiveroomInfo fxx;
    private final Runnable gfz;
    private LottieAnimationView haA;
    private boolean haB;
    private TextView haC;
    private ImageView haD;
    private long haE;
    private boolean haF;
    private a haG;
    private b haH;
    private com.baidu.tieba.ala.data.h haI;
    private TbPageContext ham;
    private TextView han;
    private TextView hao;
    private FrameLayout hap;
    private RelativeLayout haq;
    private HeadImageView har;
    private HeadImageView has;
    private TextView hat;
    private TextView hau;
    private RelativeLayout hav;
    private HeadImageView haw;
    private HeadImageView hax;
    private TextView hay;
    private TextView haz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
        void bJG();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void lk(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.haE;
        alaRankListHeaderView.haE = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.haB = true;
        this.mHandler = new Handler();
        this.gfz = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.haE <= 0) {
                    AlaRankListHeaderView.this.haE = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.haG != null) {
                        AlaRankListHeaderView.this.haG.bJG();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.han != null && "hour".equals(AlaRankListHeaderView.this.fvI) && AlaRankListHeaderView.this.haB && AlaRankListHeaderView.this.haE >= 0) {
                    AlaRankListHeaderView.this.han.setText(String.format(AlaRankListHeaderView.this.ham.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.haE))));
                }
            }
        };
        this.fvG = j;
        this.fvJ = z;
        this.fxx = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.haB = true;
        this.mHandler = new Handler();
        this.gfz = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.haE <= 0) {
                    AlaRankListHeaderView.this.haE = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.haG != null) {
                        AlaRankListHeaderView.this.haG.bJG();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.han != null && "hour".equals(AlaRankListHeaderView.this.fvI) && AlaRankListHeaderView.this.haB && AlaRankListHeaderView.this.haE >= 0) {
                    AlaRankListHeaderView.this.han.setText(String.format(AlaRankListHeaderView.this.ham.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.haE))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.haB = true;
        this.mHandler = new Handler();
        this.gfz = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.haE <= 0) {
                    AlaRankListHeaderView.this.haE = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.haG != null) {
                        AlaRankListHeaderView.this.haG.bJG();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.han != null && "hour".equals(AlaRankListHeaderView.this.fvI) && AlaRankListHeaderView.this.haB && AlaRankListHeaderView.this.haE >= 0) {
                    AlaRankListHeaderView.this.han.setText(String.format(AlaRankListHeaderView.this.ham.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.haE))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.han = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.haC = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.haD = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.haD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beJ.aFY)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.ham, new String[]{com.baidu.live.w.a.Nk().beJ.aFY}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fvI)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.hao = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.hao.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.haB = !AlaRankListHeaderView.this.haB;
                AlaRankListHeaderView.this.hao.setText(AlaRankListHeaderView.this.haB ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.haH != null) {
                    AlaRankListHeaderView.this.haH.lk(AlaRankListHeaderView.this.haB);
                }
            }
        });
        this.hap = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.haq = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.har = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.har.setIsRound(true);
        this.har.setAutoChangeStyle(false);
        this.haq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.haI != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.haI.ecd != 1 || AlaRankListHeaderView.this.haI.live_id <= 0 || AlaRankListHeaderView.this.haI.live_id == AlaRankListHeaderView.this.fvG || AlaRankListHeaderView.this.fvJ) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.ham.getPageActivity(), AlaRankListHeaderView.this.haI.user_id, AlaRankListHeaderView.this.haI.user_name, AlaRankListHeaderView.this.haI.fVi, AlaRankListHeaderView.this.haI.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beJ.aGO) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.ham.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.fxx);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.haI.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.has = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.has.setIsRound(true);
        this.has.setAutoChangeStyle(false);
        this.hat = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.hau = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.haw = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.hav = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.haw.setIsRound(true);
        this.haw.setAutoChangeStyle(false);
        this.hav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.haI != null && AlaRankListHeaderView.this.haI.fUM != null && AlaRankListHeaderView.this.haI.fUM.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.haI.fUM.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.ham.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.hax = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.hax.setIsRound(true);
        this.hax.setAutoChangeStyle(false);
        this.hay = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.haz = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.haA = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.ham = tbPageContext;
        this.fvI = str;
        initView();
        if (j > 0 && "hour".equals(this.fvI) && !this.haF) {
            this.haF = true;
            this.haE = j;
            this.han.setText(String.format(this.ham.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.haE))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cao() {
        if (this.aPy == null) {
            this.aPy = new AnimatorSet();
        }
        this.aPy.cancel();
        HeadImageView headImageView = this.haB ? this.has : this.har;
        HeadImageView headImageView2 = this.haB ? this.har : this.has;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.haB ? this.hax : this.haw;
        HeadImageView headImageView4 = this.haB ? this.haw : this.hax;
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
        this.aPy.setDuration(1000L);
        this.aPy.playTogether(this.mAnimators);
        this.aPy.setInterpolator(new AccelerateInterpolator());
        this.aPy.start();
    }

    public void b(n nVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = nVar.getList().get(0);
        if (hVar != null) {
            if (!this.bbn) {
                this.has.setAlpha(0);
                this.has.setVisibility(0);
                this.hax.setAlpha(0);
                this.hax.setVisibility(0);
            }
            this.haI = hVar;
            if (this.haB) {
                this.har.startLoad(hVar.avatar, 12, false);
            } else {
                this.has.startLoad(hVar.avatar, 12, false);
            }
            this.hat.setText(hVar.getName_show());
            this.hau.setText(String.format(this.ham.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.ecd == 1) {
                this.haA.setVisibility(0);
                this.haA.loop(true);
                this.haA.setAnimation("anchor_living.json");
                this.haA.playAnimation();
            } else {
                this.haA.setVisibility(8);
            }
            if (hVar.fUM != null && (aVar = hVar.fUM.get(0)) != null) {
                if (this.haB) {
                    this.haw.startLoad(aVar.portrait, 12, false);
                } else {
                    this.hax.startLoad(aVar.portrait, 12, false);
                }
                this.hay.setText(aVar.fUN);
                this.haz.setText(String.format(this.ham.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.baZ)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bbn) {
                        AlaRankListHeaderView.this.cao();
                    }
                    AlaRankListHeaderView.this.bbn = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fvI)) {
            this.haC.setVisibility(0);
            this.haD.setVisibility(8);
            this.han.setText(this.ham.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvI)) {
            this.haC.setVisibility(8);
            this.haD.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.haE > 0 && !z) {
                this.han.setText(String.format(this.ham.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.haE))));
                startCountDown();
            } else {
                this.han.setText(this.ham.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fvI)) {
            this.mRootView.setVisibility(0);
            this.haD.setVisibility(8);
            this.haC.setVisibility(8);
            this.hap.setVisibility(0);
            if (this.haE >= 0 && this.haB) {
                this.han.setText(String.format(this.ham.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.haE))));
            } else if (!this.haB) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Pi()).append(":00-").append("00".equals(i.Ph()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Ph()).append(":00");
                this.han.setText(sb);
            }
        } else if ("charm_day".equals(this.fvI)) {
            this.mRootView.setVisibility(8);
            this.haD.setVisibility(8);
            this.haC.setVisibility(8);
            this.hap.setVisibility(8);
            this.han.setVisibility(8);
            this.hao.setVisibility(8);
        } else {
            this.hap.setVisibility(8);
            this.haD.setVisibility(8);
            this.haC.setVisibility(8);
            this.han.setText(this.ham.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.haC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.ham.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.ham, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hap != null) {
            this.hap.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gfz);
        this.mHandler.postDelayed(this.gfz, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gfz);
    }

    public void setCountDownCallback(a aVar) {
        this.haG = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.haH = bVar;
    }
}
