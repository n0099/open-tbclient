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
    private AnimatorSet aiA;
    private boolean asG;
    private final Runnable eKz;
    private long eio;
    private String eiq;
    private boolean eir;
    private TextView fBA;
    private LottieAnimationView fBB;
    private boolean fBC;
    private TextView fBD;
    private ImageView fBE;
    private long fBF;
    private boolean fBG;
    private a fBH;
    private b fBI;
    private g fBJ;
    private TbPageContext fBn;
    private TextView fBo;
    private TextView fBp;
    private FrameLayout fBq;
    private RelativeLayout fBr;
    private HeadImageView fBs;
    private HeadImageView fBt;
    private TextView fBu;
    private TextView fBv;
    private RelativeLayout fBw;
    private HeadImageView fBx;
    private HeadImageView fBy;
    private TextView fBz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void beP();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void iw(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.fBF;
        alaRankListHeaderView.fBF = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.fBC = true;
        this.mHandler = new Handler();
        this.eKz = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fBF <= 0) {
                    AlaRankListHeaderView.this.fBF = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fBH != null) {
                        AlaRankListHeaderView.this.fBH.beP();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fBo != null && "hour".equals(AlaRankListHeaderView.this.eiq) && AlaRankListHeaderView.this.fBC && AlaRankListHeaderView.this.fBF >= 0) {
                    AlaRankListHeaderView.this.fBo.setText(String.format(AlaRankListHeaderView.this.fBn.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fBF))));
                }
            }
        };
        this.eio = j;
        this.eir = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBC = true;
        this.mHandler = new Handler();
        this.eKz = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fBF <= 0) {
                    AlaRankListHeaderView.this.fBF = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fBH != null) {
                        AlaRankListHeaderView.this.fBH.beP();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fBo != null && "hour".equals(AlaRankListHeaderView.this.eiq) && AlaRankListHeaderView.this.fBC && AlaRankListHeaderView.this.fBF >= 0) {
                    AlaRankListHeaderView.this.fBo.setText(String.format(AlaRankListHeaderView.this.fBn.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fBF))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBC = true;
        this.mHandler = new Handler();
        this.eKz = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.fBF <= 0) {
                    AlaRankListHeaderView.this.fBF = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.fBH != null) {
                        AlaRankListHeaderView.this.fBH.beP();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.fBo != null && "hour".equals(AlaRankListHeaderView.this.eiq) && AlaRankListHeaderView.this.fBC && AlaRankListHeaderView.this.fBF >= 0) {
                    AlaRankListHeaderView.this.fBo.setText(String.format(AlaRankListHeaderView.this.fBn.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.fBF))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.fBo = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.fBD = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.fBE = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.fBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.zs().awM.ZU)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.fBn, new String[]{com.baidu.live.v.a.zs().awM.ZU}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.eiq)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.fBp = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.fBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.fBC = !AlaRankListHeaderView.this.fBC;
                AlaRankListHeaderView.this.fBp.setText(AlaRankListHeaderView.this.fBC ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.fBI != null) {
                    AlaRankListHeaderView.this.fBI.iw(AlaRankListHeaderView.this.fBC);
                }
            }
        });
        this.fBq = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.fBr = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.fBs = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.fBs.setIsRound(true);
        this.fBs.setAutoChangeStyle(false);
        this.fBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fBJ != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.fBJ.cSz != 1 || AlaRankListHeaderView.this.fBJ.live_id <= 0 || AlaRankListHeaderView.this.fBJ.live_id == AlaRankListHeaderView.this.eio || AlaRankListHeaderView.this.eir) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fBn.getPageActivity(), AlaRankListHeaderView.this.fBJ.user_id, AlaRankListHeaderView.this.fBJ.user_name, AlaRankListHeaderView.this.fBJ.eAT, AlaRankListHeaderView.this.fBJ.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zs().awM.aaF) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.fBn.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.fBJ.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.fBt = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.fBt.setIsRound(true);
        this.fBt.setAutoChangeStyle(false);
        this.fBu = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.fBv = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.fBx = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.fBw = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.fBx.setIsRound(true);
        this.fBx.setAutoChangeStyle(false);
        this.fBw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.fBJ != null && AlaRankListHeaderView.this.fBJ.eAw != null && AlaRankListHeaderView.this.fBJ.eAw.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.fBJ.eAw.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.fBn.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.fBy = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.fBy.setIsRound(true);
        this.fBy.setAutoChangeStyle(false);
        this.fBz = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.fBA = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.fBB = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.fBn = tbPageContext;
        this.eiq = str;
        initView();
        if (j > 0 && "hour".equals(this.eiq) && !this.fBG) {
            this.fBG = true;
            this.fBF = j;
            this.fBo.setText(String.format(this.fBn.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fBF))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btI() {
        if (this.aiA == null) {
            this.aiA = new AnimatorSet();
        }
        this.aiA.cancel();
        HeadImageView headImageView = this.fBC ? this.fBt : this.fBs;
        HeadImageView headImageView2 = this.fBC ? this.fBs : this.fBt;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.fBC ? this.fBy : this.fBx;
        HeadImageView headImageView4 = this.fBC ? this.fBx : this.fBy;
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
        this.aiA.setDuration(1000L);
        this.aiA.playTogether(this.mAnimators);
        this.aiA.setInterpolator(new AccelerateInterpolator());
        this.aiA.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.asG) {
                this.fBt.setAlpha(0);
                this.fBt.setVisibility(0);
                this.fBy.setAlpha(0);
                this.fBy.setVisibility(0);
            }
            this.fBJ = gVar;
            if (this.fBC) {
                this.fBs.startLoad(gVar.avatar, 12, false);
            } else {
                this.fBt.startLoad(gVar.avatar, 12, false);
            }
            this.fBu.setText(gVar.getName_show());
            this.fBv.setText(String.format(this.fBn.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.cSz == 1) {
                this.fBB.setVisibility(0);
                this.fBB.loop(true);
                this.fBB.setAnimation("anchor_living.json");
                this.fBB.playAnimation();
            } else {
                this.fBB.setVisibility(8);
            }
            if (gVar.eAw != null && (aVar = gVar.eAw.get(0)) != null) {
                if (this.fBC) {
                    this.fBx.startLoad(aVar.portrait, 12, false);
                } else {
                    this.fBy.startLoad(aVar.portrait, 12, false);
                }
                this.fBz.setText(aVar.eAx);
                this.fBA.setText(String.format(this.fBn.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.eAy)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.asG) {
                        AlaRankListHeaderView.this.btI();
                    }
                    AlaRankListHeaderView.this.asG = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eiq)) {
            this.fBD.setVisibility(0);
            this.fBE.setVisibility(8);
            this.fBo.setText(this.fBn.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eiq)) {
            this.fBD.setVisibility(8);
            this.fBE.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.fBF > 0 && !z) {
                this.fBo.setText(String.format(this.fBn.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.fBF))));
                startCountDown();
            } else {
                this.fBo.setText(this.fBn.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.eiq)) {
            this.mRootView.setVisibility(0);
            this.fBE.setVisibility(8);
            this.fBD.setVisibility(8);
            this.fBq.setVisibility(0);
            if (this.fBF >= 0 && this.fBC) {
                this.fBo.setText(String.format(this.fBn.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.fBF))));
            } else if (!this.fBC) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Bg()).append(":00-").append("00".equals(i.Bf()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Bf()).append(":00");
                this.fBo.setText(sb);
            }
        } else if ("charm_day".equals(this.eiq)) {
            this.mRootView.setVisibility(8);
            this.fBE.setVisibility(8);
            this.fBD.setVisibility(8);
            this.fBq.setVisibility(8);
            this.fBo.setVisibility(8);
            this.fBp.setVisibility(8);
        } else {
            this.fBq.setVisibility(8);
            this.fBE.setVisibility(8);
            this.fBD.setVisibility(8);
            this.fBo.setText(this.fBn.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.fBD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.fBn.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.fBn, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.fBq != null) {
            this.fBq.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eKz);
        this.mHandler.postDelayed(this.eKz, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eKz);
    }

    public void setCountDownCallback(a aVar) {
        this.fBH = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.fBI = bVar;
    }
}
