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
    private AnimatorSet aPw;
    private boolean bbl;
    private long fvC;
    private String fvE;
    private boolean fvF;
    private AlaLastLiveroomInfo fxt;
    private final Runnable gfv;
    private long haA;
    private boolean haB;
    private a haC;
    private b haD;
    private com.baidu.tieba.ala.data.h haE;
    private TbPageContext hai;
    private TextView haj;
    private TextView hak;
    private FrameLayout hal;
    private RelativeLayout ham;
    private HeadImageView han;
    private HeadImageView hao;
    private TextView hap;
    private TextView haq;
    private RelativeLayout har;
    private HeadImageView has;
    private HeadImageView hat;
    private TextView hau;
    private TextView hav;
    private LottieAnimationView haw;
    private boolean hax;
    private TextView hay;
    private ImageView haz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
        void bJF();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void li(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.haA;
        alaRankListHeaderView.haA = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.hax = true;
        this.mHandler = new Handler();
        this.gfv = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.haA <= 0) {
                    AlaRankListHeaderView.this.haA = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.haC != null) {
                        AlaRankListHeaderView.this.haC.bJF();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.haj != null && "hour".equals(AlaRankListHeaderView.this.fvE) && AlaRankListHeaderView.this.hax && AlaRankListHeaderView.this.haA >= 0) {
                    AlaRankListHeaderView.this.haj.setText(String.format(AlaRankListHeaderView.this.hai.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.haA))));
                }
            }
        };
        this.fvC = j;
        this.fvF = z;
        this.fxt = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hax = true;
        this.mHandler = new Handler();
        this.gfv = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.haA <= 0) {
                    AlaRankListHeaderView.this.haA = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.haC != null) {
                        AlaRankListHeaderView.this.haC.bJF();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.haj != null && "hour".equals(AlaRankListHeaderView.this.fvE) && AlaRankListHeaderView.this.hax && AlaRankListHeaderView.this.haA >= 0) {
                    AlaRankListHeaderView.this.haj.setText(String.format(AlaRankListHeaderView.this.hai.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.haA))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hax = true;
        this.mHandler = new Handler();
        this.gfv = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.haA <= 0) {
                    AlaRankListHeaderView.this.haA = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.haC != null) {
                        AlaRankListHeaderView.this.haC.bJF();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.haj != null && "hour".equals(AlaRankListHeaderView.this.fvE) && AlaRankListHeaderView.this.hax && AlaRankListHeaderView.this.haA >= 0) {
                    AlaRankListHeaderView.this.haj.setText(String.format(AlaRankListHeaderView.this.hai.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.haA))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.haj = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.hay = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.haz = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.haz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beH.aFW)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.hai, new String[]{com.baidu.live.w.a.Nk().beH.aFW}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fvE)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.hak = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.hak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.hax = !AlaRankListHeaderView.this.hax;
                AlaRankListHeaderView.this.hak.setText(AlaRankListHeaderView.this.hax ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.haD != null) {
                    AlaRankListHeaderView.this.haD.li(AlaRankListHeaderView.this.hax);
                }
            }
        });
        this.hal = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.ham = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.han = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.han.setIsRound(true);
        this.han.setAutoChangeStyle(false);
        this.ham.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.haE != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.haE.ebZ != 1 || AlaRankListHeaderView.this.haE.live_id <= 0 || AlaRankListHeaderView.this.haE.live_id == AlaRankListHeaderView.this.fvC || AlaRankListHeaderView.this.fvF) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hai.getPageActivity(), AlaRankListHeaderView.this.haE.user_id, AlaRankListHeaderView.this.haE.user_name, AlaRankListHeaderView.this.haE.fVe, AlaRankListHeaderView.this.haE.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beH.aGM) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.hai.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.fxt);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.haE.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.hao = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.hao.setIsRound(true);
        this.hao.setAutoChangeStyle(false);
        this.hap = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.haq = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.has = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.har = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.has.setIsRound(true);
        this.has.setAutoChangeStyle(false);
        this.har.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.haE != null && AlaRankListHeaderView.this.haE.fUI != null && AlaRankListHeaderView.this.haE.fUI.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.haE.fUI.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.hai.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.hat = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.hat.setIsRound(true);
        this.hat.setAutoChangeStyle(false);
        this.hau = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.hav = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.haw = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.hai = tbPageContext;
        this.fvE = str;
        initView();
        if (j > 0 && "hour".equals(this.fvE) && !this.haB) {
            this.haB = true;
            this.haA = j;
            this.haj.setText(String.format(this.hai.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.haA))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void can() {
        if (this.aPw == null) {
            this.aPw = new AnimatorSet();
        }
        this.aPw.cancel();
        HeadImageView headImageView = this.hax ? this.hao : this.han;
        HeadImageView headImageView2 = this.hax ? this.han : this.hao;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.hax ? this.hat : this.has;
        HeadImageView headImageView4 = this.hax ? this.has : this.hat;
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
        this.aPw.setDuration(1000L);
        this.aPw.playTogether(this.mAnimators);
        this.aPw.setInterpolator(new AccelerateInterpolator());
        this.aPw.start();
    }

    public void b(n nVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = nVar.getList().get(0);
        if (hVar != null) {
            if (!this.bbl) {
                this.hao.setAlpha(0);
                this.hao.setVisibility(0);
                this.hat.setAlpha(0);
                this.hat.setVisibility(0);
            }
            this.haE = hVar;
            if (this.hax) {
                this.han.startLoad(hVar.avatar, 12, false);
            } else {
                this.hao.startLoad(hVar.avatar, 12, false);
            }
            this.hap.setText(hVar.getName_show());
            this.haq.setText(String.format(this.hai.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.ebZ == 1) {
                this.haw.setVisibility(0);
                this.haw.loop(true);
                this.haw.setAnimation("anchor_living.json");
                this.haw.playAnimation();
            } else {
                this.haw.setVisibility(8);
            }
            if (hVar.fUI != null && (aVar = hVar.fUI.get(0)) != null) {
                if (this.hax) {
                    this.has.startLoad(aVar.portrait, 12, false);
                } else {
                    this.hat.startLoad(aVar.portrait, 12, false);
                }
                this.hau.setText(aVar.fUJ);
                this.hav.setText(String.format(this.hai.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.baX)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bbl) {
                        AlaRankListHeaderView.this.can();
                    }
                    AlaRankListHeaderView.this.bbl = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fvE)) {
            this.hay.setVisibility(0);
            this.haz.setVisibility(8);
            this.haj.setText(this.hai.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvE)) {
            this.hay.setVisibility(8);
            this.haz.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.haA > 0 && !z) {
                this.haj.setText(String.format(this.hai.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.haA))));
                startCountDown();
            } else {
                this.haj.setText(this.hai.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fvE)) {
            this.mRootView.setVisibility(0);
            this.haz.setVisibility(8);
            this.hay.setVisibility(8);
            this.hal.setVisibility(0);
            if (this.haA >= 0 && this.hax) {
                this.haj.setText(String.format(this.hai.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.haA))));
            } else if (!this.hax) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Pi()).append(":00-").append("00".equals(i.Ph()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Ph()).append(":00");
                this.haj.setText(sb);
            }
        } else if ("charm_day".equals(this.fvE)) {
            this.mRootView.setVisibility(8);
            this.haz.setVisibility(8);
            this.hay.setVisibility(8);
            this.hal.setVisibility(8);
            this.haj.setVisibility(8);
            this.hak.setVisibility(8);
        } else {
            this.hal.setVisibility(8);
            this.haz.setVisibility(8);
            this.hay.setVisibility(8);
            this.haj.setText(this.hai.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.hay.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.hai.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.hai, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hal != null) {
            this.hal.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gfv);
        this.mHandler.postDelayed(this.gfv, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gfv);
    }

    public void setCountDownCallback(a aVar) {
        this.haC = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.haD = bVar;
    }
}
