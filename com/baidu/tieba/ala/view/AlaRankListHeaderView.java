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
/* loaded from: classes10.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet baB;
    private boolean bov;
    private String grA;
    private boolean grB;
    private long gry;
    private AlaLastLiveroomInfo gto;
    private final Runnable hfx;
    private TbPageContext ikK;
    private TextView ikL;
    private TextView ikM;
    private FrameLayout ikN;
    private RelativeLayout ikO;
    private HeadImageView ikP;
    private HeadImageView ikQ;
    private TextView ikR;
    private TextView ikS;
    private RelativeLayout ikT;
    private HeadImageView ikU;
    private HeadImageView ikV;
    private TextView ikW;
    private TextView ikX;
    private LottieAnimationView ikY;
    private boolean ikZ;
    private TextView ila;
    private ImageView ilb;
    private long ilc;
    private boolean ild;
    private a ile;
    private b ilf;
    private com.baidu.tieba.ala.data.h ilg;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes10.dex */
    public interface a {
        void bVo();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void ng(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.ilc;
        alaRankListHeaderView.ilc = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.ikZ = true;
        this.mHandler = new Handler();
        this.hfx = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ilc <= 0) {
                    AlaRankListHeaderView.this.ilc = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ile != null) {
                        AlaRankListHeaderView.this.ile.bVo();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.ikL != null && "hour".equals(AlaRankListHeaderView.this.grA) && AlaRankListHeaderView.this.ikZ && AlaRankListHeaderView.this.ilc >= 0) {
                    AlaRankListHeaderView.this.ikL.setText(String.format(AlaRankListHeaderView.this.ikK.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.ilc))));
                }
            }
        };
        this.gry = j;
        this.grB = z;
        this.gto = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikZ = true;
        this.mHandler = new Handler();
        this.hfx = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ilc <= 0) {
                    AlaRankListHeaderView.this.ilc = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ile != null) {
                        AlaRankListHeaderView.this.ile.bVo();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.ikL != null && "hour".equals(AlaRankListHeaderView.this.grA) && AlaRankListHeaderView.this.ikZ && AlaRankListHeaderView.this.ilc >= 0) {
                    AlaRankListHeaderView.this.ikL.setText(String.format(AlaRankListHeaderView.this.ikK.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.ilc))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikZ = true;
        this.mHandler = new Handler();
        this.hfx = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ilc <= 0) {
                    AlaRankListHeaderView.this.ilc = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ile != null) {
                        AlaRankListHeaderView.this.ile.bVo();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.ikL != null && "hour".equals(AlaRankListHeaderView.this.grA) && AlaRankListHeaderView.this.ikZ && AlaRankListHeaderView.this.ilc >= 0) {
                    AlaRankListHeaderView.this.ikL.setText(String.format(AlaRankListHeaderView.this.ikK.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(AlaRankListHeaderView.this.ilc))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.ala_rank_list_header_layout, this);
        this.ikL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_refresh_tip);
        this.ila = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_game_rule);
        this.ilb = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_flower_description);
        this.ilb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.ae.a.Qm().bwx.aNe)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.ikK, new String[]{com.baidu.live.ae.a.Qm().bwx.aNe}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.grA)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.ikM = (TextView) this.mRootView.findViewById(a.f.rank_list_switch);
        this.ikM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.ikZ = !AlaRankListHeaderView.this.ikZ;
                AlaRankListHeaderView.this.ikM.setText(AlaRankListHeaderView.this.ikZ ? a.h.hour_rank_list_head_switch_cur : a.h.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.ilf != null) {
                    AlaRankListHeaderView.this.ilf.ng(AlaRankListHeaderView.this.ikZ);
                }
            }
        });
        this.ikN = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.ikO = (RelativeLayout) this.mRootView.findViewById(a.f.rl_rank_first);
        this.ikP = (HeadImageView) this.mRootView.findViewById(a.f.rank_first);
        this.ikP.setIsRound(true);
        this.ikP.setAutoChangeStyle(false);
        this.ikO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ilg != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.ilg.eSY != 1 || AlaRankListHeaderView.this.ilg.live_id <= 0 || AlaRankListHeaderView.this.ilg.live_id == AlaRankListHeaderView.this.gry || AlaRankListHeaderView.this.grB) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.ikK.getPageActivity(), AlaRankListHeaderView.this.ilg.user_id, AlaRankListHeaderView.this.ilg.user_name, AlaRankListHeaderView.this.ilg.bdPortrait, AlaRankListHeaderView.this.ilg.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qm().bwx.aNW) {
                        com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(AlaRankListHeaderView.this.ilg.live_id)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.ikK.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.gto);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.ilg.live_id, AlaRankListHeaderView.this.ilg.room_id + "", "live_sdk");
                        com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        });
        this.ikQ = (HeadImageView) this.mRootView.findViewById(a.f.rank_first2);
        this.ikQ.setIsRound(true);
        this.ikQ.setAutoChangeStyle(false);
        this.ikR = (TextView) this.mRootView.findViewById(a.f.name_rank_1);
        this.ikS = (TextView) this.mRootView.findViewById(a.f.point_rank_1);
        this.ikU = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.ikT = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.ikU.setIsRound(true);
        this.ikU.setAutoChangeStyle(false);
        this.ikT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ilg != null && AlaRankListHeaderView.this.ilg.gUE != null && AlaRankListHeaderView.this.ilg.gUE.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.ilg.gUE.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.ikK.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.ikV = (HeadImageView) this.mRootView.findViewById(a.f.charm_first2);
        this.ikV.setIsRound(true);
        this.ikV.setAutoChangeStyle(false);
        this.ikW = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.ikX = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.ikY = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
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
        this.ikK = tbPageContext;
        this.grA = str;
        initView();
        if (j > 0 && "hour".equals(this.grA) && !this.ild) {
            this.ild = true;
            this.ilc = j;
            this.ikL.setText(String.format(this.ikK.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.ilc))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpL() {
        if (this.baB == null) {
            this.baB = new AnimatorSet();
        }
        this.baB.cancel();
        HeadImageView headImageView = this.ikZ ? this.ikQ : this.ikP;
        HeadImageView headImageView2 = this.ikZ ? this.ikP : this.ikQ;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.ikZ ? this.ikV : this.ikU;
        HeadImageView headImageView4 = this.ikZ ? this.ikU : this.ikV;
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
        this.baB.setDuration(1000L);
        this.baB.playTogether(this.mAnimators);
        this.baB.setInterpolator(new AccelerateInterpolator());
        this.baB.start();
    }

    public void b(p pVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = pVar.getList().get(0);
        if (hVar != null) {
            if (!this.bov) {
                this.ikQ.setAlpha(0);
                this.ikQ.setVisibility(0);
                this.ikV.setAlpha(0);
                this.ikV.setVisibility(0);
            }
            this.ilg = hVar;
            if (this.ikZ) {
                this.ikP.startLoad(hVar.avatar, 12, false);
            } else {
                this.ikQ.startLoad(hVar.avatar, 12, false);
            }
            this.ikR.setText(hVar.getName_show());
            this.ikS.setText(String.format(this.ikK.getString(a.h.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.gUB, 0L))));
            if (hVar.eSY == 1) {
                this.ikY.setVisibility(0);
                this.ikY.loop(true);
                this.ikY.setAnimation("anchor_living.json");
                this.ikY.playAnimation();
            } else {
                this.ikY.setVisibility(8);
            }
            if (hVar.gUE != null && (aVar = hVar.gUE.get(0)) != null) {
                if (this.ikZ) {
                    this.ikU.startLoad(aVar.portrait, 12, false);
                } else {
                    this.ikV.startLoad(aVar.portrait, 12, false);
                }
                this.ikW.setText(aVar.userNickName);
                this.ikX.setText(String.format(this.ikK.getString(a.h.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aXc)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.bov) {
                        AlaRankListHeaderView.this.cpL();
                    }
                    AlaRankListHeaderView.this.bov = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.grA)) {
            this.ila.setVisibility(0);
            this.ilb.setVisibility(8);
            this.ikL.setText(this.ikK.getPageActivity().getString(a.h.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grA)) {
            this.ila.setVisibility(8);
            this.ilb.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.ilc > 0 && !z) {
                this.ikL.setText(String.format(this.ikK.getString(a.h.ala_rank_list_flower_count_down_tip), com.baidu.live.utils.j.getCountDownTime(Long.valueOf(this.ilc))));
                startCountDown();
            } else {
                this.ikL.setText(this.ikK.getPageActivity().getString(a.h.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.grA)) {
            this.mRootView.setVisibility(0);
            this.ilb.setVisibility(8);
            this.ila.setVisibility(8);
            this.ikN.setVisibility(0);
            if (this.ilc >= 0 && this.ikZ) {
                this.ikL.setText(String.format(this.ikK.getString(a.h.hour_rank_list_count_down_tip), com.baidu.live.utils.j.c(Long.valueOf(this.ilc))));
            } else if (!this.ikZ) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.live.utils.j.Vr()).append(":00-").append("00".equals(com.baidu.live.utils.j.Vq()) ? SoUtils.SO_EVENT_ID_DEFAULT : com.baidu.live.utils.j.Vq()).append(":00");
                this.ikL.setText(sb);
            }
        } else if ("charm_day".equals(this.grA)) {
            this.mRootView.setVisibility(8);
            this.ilb.setVisibility(8);
            this.ila.setVisibility(8);
            this.ikN.setVisibility(8);
            this.ikL.setVisibility(8);
            this.ikM.setVisibility(8);
        } else {
            this.ikN.setVisibility(8);
            this.ilb.setVisibility(8);
            this.ila.setVisibility(8);
            this.ikL.setText(this.ikK.getPageActivity().getString(a.h.hkqm_rank_list_refresh_charm_rule));
        }
        this.ila.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.ikK.getPageActivity(), a.h.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.ikK, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.ikN != null) {
            this.ikN.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hfx);
        this.mHandler.postDelayed(this.hfx, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hfx);
    }

    public void setCountDownCallback(a aVar) {
        this.ile = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.ilf = bVar;
    }
}
