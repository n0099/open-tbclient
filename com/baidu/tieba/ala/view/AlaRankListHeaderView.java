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
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet aIN;
    private boolean aUG;
    private final Runnable fOd;
    private long ffd;
    private String fff;
    private boolean ffg;
    private AlaLastLiveroomInfo fgP;
    private TbPageContext gHM;
    private TextView gHN;
    private TextView gHO;
    private FrameLayout gHP;
    private RelativeLayout gHQ;
    private HeadImageView gHR;
    private HeadImageView gHS;
    private TextView gHT;
    private TextView gHU;
    private RelativeLayout gHV;
    private HeadImageView gHW;
    private HeadImageView gHX;
    private TextView gHY;
    private TextView gHZ;
    private LottieAnimationView gIa;
    private boolean gIb;
    private TextView gIc;
    private ImageView gId;
    private long gIe;
    private boolean gIf;
    private a gIg;
    private b gIh;
    private g gIi;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void bwT();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void ke(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.gIe;
        alaRankListHeaderView.gIe = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.gIb = true;
        this.mHandler = new Handler();
        this.fOd = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gIe <= 0) {
                    AlaRankListHeaderView.this.gIe = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gIg != null) {
                        AlaRankListHeaderView.this.gIg.bwT();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gHN != null && "hour".equals(AlaRankListHeaderView.this.fff) && AlaRankListHeaderView.this.gIb && AlaRankListHeaderView.this.gIe >= 0) {
                    AlaRankListHeaderView.this.gHN.setText(String.format(AlaRankListHeaderView.this.gHM.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gIe))));
                }
            }
        };
        this.ffd = j;
        this.ffg = z;
        this.fgP = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIb = true;
        this.mHandler = new Handler();
        this.fOd = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gIe <= 0) {
                    AlaRankListHeaderView.this.gIe = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gIg != null) {
                        AlaRankListHeaderView.this.gIg.bwT();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gHN != null && "hour".equals(AlaRankListHeaderView.this.fff) && AlaRankListHeaderView.this.gIb && AlaRankListHeaderView.this.gIe >= 0) {
                    AlaRankListHeaderView.this.gHN.setText(String.format(AlaRankListHeaderView.this.gHM.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gIe))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIb = true;
        this.mHandler = new Handler();
        this.fOd = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gIe <= 0) {
                    AlaRankListHeaderView.this.gIe = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gIg != null) {
                        AlaRankListHeaderView.this.gIg.bwT();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gHN != null && "hour".equals(AlaRankListHeaderView.this.fff) && AlaRankListHeaderView.this.gIb && AlaRankListHeaderView.this.gIe >= 0) {
                    AlaRankListHeaderView.this.gHN.setText(String.format(AlaRankListHeaderView.this.gHM.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gIe))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.gHN = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.gIc = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.gId = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.gId.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.Hm().aZp.azz)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.gHM, new String[]{com.baidu.live.v.a.Hm().aZp.azz}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fff)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.gHO = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.gHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.gIb = !AlaRankListHeaderView.this.gIb;
                AlaRankListHeaderView.this.gHO.setText(AlaRankListHeaderView.this.gIb ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.gIh != null) {
                    AlaRankListHeaderView.this.gIh.ke(AlaRankListHeaderView.this.gIb);
                }
            }
        });
        this.gHP = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.gHQ = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.gHR = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.gHR.setIsRound(true);
        this.gHR.setAutoChangeStyle(false);
        this.gHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gIi != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.gIi.dMs != 1 || AlaRankListHeaderView.this.gIi.live_id <= 0 || AlaRankListHeaderView.this.gIi.live_id == AlaRankListHeaderView.this.ffd || AlaRankListHeaderView.this.ffg) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gHM.getPageActivity(), AlaRankListHeaderView.this.gIi.user_id, AlaRankListHeaderView.this.gIi.user_name, AlaRankListHeaderView.this.gIi.fEs, AlaRankListHeaderView.this.gIi.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hm().aZp.aAp) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.gHM.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.fgP);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.gIi.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.gHS = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.gHS.setIsRound(true);
        this.gHS.setAutoChangeStyle(false);
        this.gHT = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.gHU = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.gHW = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.gHV = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.gHW.setIsRound(true);
        this.gHW.setAutoChangeStyle(false);
        this.gHV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gIi != null && AlaRankListHeaderView.this.gIi.fDW != null && AlaRankListHeaderView.this.gIi.fDW.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.gIi.fDW.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gHM.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.gHX = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.gHX.setIsRound(true);
        this.gHX.setAutoChangeStyle(false);
        this.gHY = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.gHZ = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.gIa = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.gHM = tbPageContext;
        this.fff = str;
        initView();
        if (j > 0 && "hour".equals(this.fff) && !this.gIf) {
            this.gIf = true;
            this.gIe = j;
            this.gHN.setText(String.format(this.gHM.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gIe))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMQ() {
        if (this.aIN == null) {
            this.aIN = new AnimatorSet();
        }
        this.aIN.cancel();
        HeadImageView headImageView = this.gIb ? this.gHS : this.gHR;
        HeadImageView headImageView2 = this.gIb ? this.gHR : this.gHS;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.gIb ? this.gHX : this.gHW;
        HeadImageView headImageView4 = this.gIb ? this.gHW : this.gHX;
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
        this.aIN.setDuration(1000L);
        this.aIN.playTogether(this.mAnimators);
        this.aIN.setInterpolator(new AccelerateInterpolator());
        this.aIN.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.aUG) {
                this.gHS.setAlpha(0);
                this.gHS.setVisibility(0);
                this.gHX.setAlpha(0);
                this.gHX.setVisibility(0);
            }
            this.gIi = gVar;
            if (this.gIb) {
                this.gHR.startLoad(gVar.avatar, 12, false);
            } else {
                this.gHS.startLoad(gVar.avatar, 12, false);
            }
            this.gHT.setText(gVar.getName_show());
            this.gHU.setText(String.format(this.gHM.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.dMs == 1) {
                this.gIa.setVisibility(0);
                this.gIa.loop(true);
                this.gIa.setAnimation("anchor_living.json");
                this.gIa.playAnimation();
            } else {
                this.gIa.setVisibility(8);
            }
            if (gVar.fDW != null && (aVar = gVar.fDW.get(0)) != null) {
                if (this.gIb) {
                    this.gHW.startLoad(aVar.portrait, 12, false);
                } else {
                    this.gHX.startLoad(aVar.portrait, 12, false);
                }
                this.gHY.setText(aVar.fDX);
                this.gHZ.setText(String.format(this.gHM.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aUp)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aUG) {
                        AlaRankListHeaderView.this.bMQ();
                    }
                    AlaRankListHeaderView.this.aUG = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fff)) {
            this.gIc.setVisibility(0);
            this.gId.setVisibility(8);
            this.gHN.setText(this.gHM.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fff)) {
            this.gIc.setVisibility(8);
            this.gId.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.gIe > 0 && !z) {
                this.gHN.setText(String.format(this.gHM.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.gIe))));
                startCountDown();
            } else {
                this.gHN.setText(this.gHM.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fff)) {
            this.mRootView.setVisibility(0);
            this.gId.setVisibility(8);
            this.gIc.setVisibility(8);
            this.gHP.setVisibility(0);
            if (this.gIe >= 0 && this.gIb) {
                this.gHN.setText(String.format(this.gHM.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gIe))));
            } else if (!this.gIb) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Jj()).append(":00-").append("00".equals(i.Ji()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Ji()).append(":00");
                this.gHN.setText(sb);
            }
        } else if ("charm_day".equals(this.fff)) {
            this.mRootView.setVisibility(8);
            this.gId.setVisibility(8);
            this.gIc.setVisibility(8);
            this.gHP.setVisibility(8);
            this.gHN.setVisibility(8);
            this.gHO.setVisibility(8);
        } else {
            this.gHP.setVisibility(8);
            this.gId.setVisibility(8);
            this.gIc.setVisibility(8);
            this.gHN.setText(this.gHM.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.gIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.gHM.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.gHM, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.gHP != null) {
            this.gHP.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fOd);
        this.mHandler.postDelayed(this.fOd, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fOd);
    }

    public void setCountDownCallback(a aVar) {
        this.gIg = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.gIh = bVar;
    }
}
