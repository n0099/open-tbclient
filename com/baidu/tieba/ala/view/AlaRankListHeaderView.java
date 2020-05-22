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
    private AnimatorSet aGp;
    private boolean aSa;
    private long eUH;
    private String eUJ;
    private boolean eUK;
    private final Runnable fCJ;
    private TbPageContext guN;
    private TextView guO;
    private TextView guP;
    private FrameLayout guQ;
    private RelativeLayout guR;
    private HeadImageView guS;
    private HeadImageView guT;
    private TextView guU;
    private TextView guV;
    private RelativeLayout guW;
    private HeadImageView guX;
    private HeadImageView guY;
    private TextView guZ;
    private TextView gva;
    private LottieAnimationView gvb;
    private boolean gvc;
    private TextView gvd;
    private ImageView gve;
    private long gvf;
    private boolean gvg;
    private a gvh;
    private b gvi;
    private g gvj;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void btW();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void jQ(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.gvf;
        alaRankListHeaderView.gvf = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.gvc = true;
        this.mHandler = new Handler();
        this.fCJ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gvf <= 0) {
                    AlaRankListHeaderView.this.gvf = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gvh != null) {
                        AlaRankListHeaderView.this.gvh.btW();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.guO != null && "hour".equals(AlaRankListHeaderView.this.eUJ) && AlaRankListHeaderView.this.gvc && AlaRankListHeaderView.this.gvf >= 0) {
                    AlaRankListHeaderView.this.guO.setText(String.format(AlaRankListHeaderView.this.guN.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gvf))));
                }
            }
        };
        this.eUH = j;
        this.eUK = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvc = true;
        this.mHandler = new Handler();
        this.fCJ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gvf <= 0) {
                    AlaRankListHeaderView.this.gvf = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gvh != null) {
                        AlaRankListHeaderView.this.gvh.btW();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.guO != null && "hour".equals(AlaRankListHeaderView.this.eUJ) && AlaRankListHeaderView.this.gvc && AlaRankListHeaderView.this.gvf >= 0) {
                    AlaRankListHeaderView.this.guO.setText(String.format(AlaRankListHeaderView.this.guN.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gvf))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvc = true;
        this.mHandler = new Handler();
        this.fCJ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gvf <= 0) {
                    AlaRankListHeaderView.this.gvf = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gvh != null) {
                        AlaRankListHeaderView.this.gvh.btW();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.guO != null && "hour".equals(AlaRankListHeaderView.this.eUJ) && AlaRankListHeaderView.this.gvc && AlaRankListHeaderView.this.gvf >= 0) {
                    AlaRankListHeaderView.this.guO.setText(String.format(AlaRankListHeaderView.this.guN.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gvf))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.guO = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.gvd = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.gve = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.gve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.Ge().aWF.axq)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.guN, new String[]{com.baidu.live.v.a.Ge().aWF.axq}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.eUJ)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.guP = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.guP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.gvc = !AlaRankListHeaderView.this.gvc;
                AlaRankListHeaderView.this.guP.setText(AlaRankListHeaderView.this.gvc ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.gvi != null) {
                    AlaRankListHeaderView.this.gvi.jQ(AlaRankListHeaderView.this.gvc);
                }
            }
        });
        this.guQ = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.guR = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.guS = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.guS.setIsRound(true);
        this.guS.setAutoChangeStyle(false);
        this.guR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gvj != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.gvj.dFH != 1 || AlaRankListHeaderView.this.gvj.live_id <= 0 || AlaRankListHeaderView.this.gvj.live_id == AlaRankListHeaderView.this.eUH || AlaRankListHeaderView.this.eUK) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.guN.getPageActivity(), AlaRankListHeaderView.this.gvj.user_id, AlaRankListHeaderView.this.gvj.user_name, AlaRankListHeaderView.this.gvj.fsW, AlaRankListHeaderView.this.gvj.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.guN.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.gvj.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.guT = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.guT.setIsRound(true);
        this.guT.setAutoChangeStyle(false);
        this.guU = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.guV = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.guX = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.guW = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.guX.setIsRound(true);
        this.guX.setAutoChangeStyle(false);
        this.guW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gvj != null && AlaRankListHeaderView.this.gvj.fsA != null && AlaRankListHeaderView.this.gvj.fsA.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.gvj.fsA.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.guN.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.guY = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.guY.setIsRound(true);
        this.guY.setAutoChangeStyle(false);
        this.guZ = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.gva = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.gvb = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.guN = tbPageContext;
        this.eUJ = str;
        initView();
        if (j > 0 && "hour".equals(this.eUJ) && !this.gvg) {
            this.gvg = true;
            this.gvf = j;
            this.guO.setText(String.format(this.guN.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gvf))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        if (this.aGp == null) {
            this.aGp = new AnimatorSet();
        }
        this.aGp.cancel();
        HeadImageView headImageView = this.gvc ? this.guT : this.guS;
        HeadImageView headImageView2 = this.gvc ? this.guS : this.guT;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.gvc ? this.guY : this.guX;
        HeadImageView headImageView4 = this.gvc ? this.guX : this.guY;
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
        this.aGp.setDuration(1000L);
        this.aGp.playTogether(this.mAnimators);
        this.aGp.setInterpolator(new AccelerateInterpolator());
        this.aGp.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.aSa) {
                this.guT.setAlpha(0);
                this.guT.setVisibility(0);
                this.guY.setAlpha(0);
                this.guY.setVisibility(0);
            }
            this.gvj = gVar;
            if (this.gvc) {
                this.guS.startLoad(gVar.avatar, 12, false);
            } else {
                this.guT.startLoad(gVar.avatar, 12, false);
            }
            this.guU.setText(gVar.getName_show());
            this.guV.setText(String.format(this.guN.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.dFH == 1) {
                this.gvb.setVisibility(0);
                this.gvb.loop(true);
                this.gvb.setAnimation("anchor_living.json");
                this.gvb.playAnimation();
            } else {
                this.gvb.setVisibility(8);
            }
            if (gVar.fsA != null && (aVar = gVar.fsA.get(0)) != null) {
                if (this.gvc) {
                    this.guX.startLoad(aVar.portrait, 12, false);
                } else {
                    this.guY.startLoad(aVar.portrait, 12, false);
                }
                this.guZ.setText(aVar.fsB);
                this.gva.setText(String.format(this.guN.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aRJ)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aSa) {
                        AlaRankListHeaderView.this.bJJ();
                    }
                    AlaRankListHeaderView.this.aSa = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eUJ)) {
            this.gvd.setVisibility(0);
            this.gve.setVisibility(8);
            this.guO.setText(this.guN.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eUJ)) {
            this.gvd.setVisibility(8);
            this.gve.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.gvf > 0 && !z) {
                this.guO.setText(String.format(this.guN.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.gvf))));
                startCountDown();
            } else {
                this.guO.setText(this.guN.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.eUJ)) {
            this.mRootView.setVisibility(0);
            this.gve.setVisibility(8);
            this.gvd.setVisibility(8);
            this.guQ.setVisibility(0);
            if (this.gvf >= 0 && this.gvc) {
                this.guO.setText(String.format(this.guN.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gvf))));
            } else if (!this.gvc) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.HW()).append(":00-").append("00".equals(i.HV()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.HV()).append(":00");
                this.guO.setText(sb);
            }
        } else if ("charm_day".equals(this.eUJ)) {
            this.mRootView.setVisibility(8);
            this.gve.setVisibility(8);
            this.gvd.setVisibility(8);
            this.guQ.setVisibility(8);
            this.guO.setVisibility(8);
            this.guP.setVisibility(8);
        } else {
            this.guQ.setVisibility(8);
            this.gve.setVisibility(8);
            this.gvd.setVisibility(8);
            this.guO.setText(this.guN.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.gvd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.guN.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.guN, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.guQ != null) {
            this.guQ.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fCJ);
        this.mHandler.postDelayed(this.fCJ, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fCJ);
    }

    public void setCountDownCallback(a aVar) {
        this.gvh = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.gvi = bVar;
    }
}
