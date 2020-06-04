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
    private long eUS;
    private String eUU;
    private boolean eUV;
    private final Runnable fCU;
    private TbPageContext guY;
    private TextView guZ;
    private TextView gva;
    private FrameLayout gvb;
    private RelativeLayout gvc;
    private HeadImageView gvd;
    private HeadImageView gve;
    private TextView gvf;
    private TextView gvg;
    private RelativeLayout gvh;
    private HeadImageView gvi;
    private HeadImageView gvj;
    private TextView gvk;
    private TextView gvl;
    private LottieAnimationView gvm;
    private boolean gvn;
    private TextView gvo;
    private ImageView gvp;
    private long gvq;
    private boolean gvr;
    private a gvs;
    private b gvt;
    private g gvu;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void btY();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void jQ(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.gvq;
        alaRankListHeaderView.gvq = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.gvn = true;
        this.mHandler = new Handler();
        this.fCU = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gvq <= 0) {
                    AlaRankListHeaderView.this.gvq = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gvs != null) {
                        AlaRankListHeaderView.this.gvs.btY();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.guZ != null && "hour".equals(AlaRankListHeaderView.this.eUU) && AlaRankListHeaderView.this.gvn && AlaRankListHeaderView.this.gvq >= 0) {
                    AlaRankListHeaderView.this.guZ.setText(String.format(AlaRankListHeaderView.this.guY.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gvq))));
                }
            }
        };
        this.eUS = j;
        this.eUV = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvn = true;
        this.mHandler = new Handler();
        this.fCU = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gvq <= 0) {
                    AlaRankListHeaderView.this.gvq = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gvs != null) {
                        AlaRankListHeaderView.this.gvs.btY();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.guZ != null && "hour".equals(AlaRankListHeaderView.this.eUU) && AlaRankListHeaderView.this.gvn && AlaRankListHeaderView.this.gvq >= 0) {
                    AlaRankListHeaderView.this.guZ.setText(String.format(AlaRankListHeaderView.this.guY.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gvq))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvn = true;
        this.mHandler = new Handler();
        this.fCU = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gvq <= 0) {
                    AlaRankListHeaderView.this.gvq = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gvs != null) {
                        AlaRankListHeaderView.this.gvs.btY();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.guZ != null && "hour".equals(AlaRankListHeaderView.this.eUU) && AlaRankListHeaderView.this.gvn && AlaRankListHeaderView.this.gvq >= 0) {
                    AlaRankListHeaderView.this.guZ.setText(String.format(AlaRankListHeaderView.this.guY.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gvq))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.guZ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.gvo = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.gvp = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.gvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.Ge().aWF.axq)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.guY, new String[]{com.baidu.live.v.a.Ge().aWF.axq}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.eUU)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.gva = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.gva.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.gvn = !AlaRankListHeaderView.this.gvn;
                AlaRankListHeaderView.this.gva.setText(AlaRankListHeaderView.this.gvn ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.gvt != null) {
                    AlaRankListHeaderView.this.gvt.jQ(AlaRankListHeaderView.this.gvn);
                }
            }
        });
        this.gvb = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.gvc = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.gvd = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.gvd.setIsRound(true);
        this.gvd.setAutoChangeStyle(false);
        this.gvc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gvu != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.gvu.dFH != 1 || AlaRankListHeaderView.this.gvu.live_id <= 0 || AlaRankListHeaderView.this.gvu.live_id == AlaRankListHeaderView.this.eUS || AlaRankListHeaderView.this.eUV) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.guY.getPageActivity(), AlaRankListHeaderView.this.gvu.user_id, AlaRankListHeaderView.this.gvu.user_name, AlaRankListHeaderView.this.gvu.fth, AlaRankListHeaderView.this.gvu.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.guY.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.gvu.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.gve = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.gve.setIsRound(true);
        this.gve.setAutoChangeStyle(false);
        this.gvf = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.gvg = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.gvi = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.gvh = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.gvi.setIsRound(true);
        this.gvi.setAutoChangeStyle(false);
        this.gvh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gvu != null && AlaRankListHeaderView.this.gvu.fsL != null && AlaRankListHeaderView.this.gvu.fsL.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.gvu.fsL.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.guY.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.gvj = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.gvj.setIsRound(true);
        this.gvj.setAutoChangeStyle(false);
        this.gvk = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.gvl = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.gvm = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.guY = tbPageContext;
        this.eUU = str;
        initView();
        if (j > 0 && "hour".equals(this.eUU) && !this.gvr) {
            this.gvr = true;
            this.gvq = j;
            this.guZ.setText(String.format(this.guY.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gvq))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        if (this.aGp == null) {
            this.aGp = new AnimatorSet();
        }
        this.aGp.cancel();
        HeadImageView headImageView = this.gvn ? this.gve : this.gvd;
        HeadImageView headImageView2 = this.gvn ? this.gvd : this.gve;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.gvn ? this.gvj : this.gvi;
        HeadImageView headImageView4 = this.gvn ? this.gvi : this.gvj;
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
                this.gve.setAlpha(0);
                this.gve.setVisibility(0);
                this.gvj.setAlpha(0);
                this.gvj.setVisibility(0);
            }
            this.gvu = gVar;
            if (this.gvn) {
                this.gvd.startLoad(gVar.avatar, 12, false);
            } else {
                this.gve.startLoad(gVar.avatar, 12, false);
            }
            this.gvf.setText(gVar.getName_show());
            this.gvg.setText(String.format(this.guY.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.dFH == 1) {
                this.gvm.setVisibility(0);
                this.gvm.loop(true);
                this.gvm.setAnimation("anchor_living.json");
                this.gvm.playAnimation();
            } else {
                this.gvm.setVisibility(8);
            }
            if (gVar.fsL != null && (aVar = gVar.fsL.get(0)) != null) {
                if (this.gvn) {
                    this.gvi.startLoad(aVar.portrait, 12, false);
                } else {
                    this.gvj.startLoad(aVar.portrait, 12, false);
                }
                this.gvk.setText(aVar.fsM);
                this.gvl.setText(String.format(this.guY.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aRJ)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aSa) {
                        AlaRankListHeaderView.this.bJL();
                    }
                    AlaRankListHeaderView.this.aSa = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eUU)) {
            this.gvo.setVisibility(0);
            this.gvp.setVisibility(8);
            this.guZ.setText(this.guY.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eUU)) {
            this.gvo.setVisibility(8);
            this.gvp.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.gvq > 0 && !z) {
                this.guZ.setText(String.format(this.guY.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.gvq))));
                startCountDown();
            } else {
                this.guZ.setText(this.guY.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.eUU)) {
            this.mRootView.setVisibility(0);
            this.gvp.setVisibility(8);
            this.gvo.setVisibility(8);
            this.gvb.setVisibility(0);
            if (this.gvq >= 0 && this.gvn) {
                this.guZ.setText(String.format(this.guY.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gvq))));
            } else if (!this.gvn) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.HW()).append(":00-").append("00".equals(i.HV()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.HV()).append(":00");
                this.guZ.setText(sb);
            }
        } else if ("charm_day".equals(this.eUU)) {
            this.mRootView.setVisibility(8);
            this.gvp.setVisibility(8);
            this.gvo.setVisibility(8);
            this.gvb.setVisibility(8);
            this.guZ.setVisibility(8);
            this.gva.setVisibility(8);
        } else {
            this.gvb.setVisibility(8);
            this.gvp.setVisibility(8);
            this.gvo.setVisibility(8);
            this.guZ.setText(this.guY.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.gvo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.guY.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.guY, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.gvb != null) {
            this.gvb.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fCU);
        this.mHandler.postDelayed(this.fCU, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fCU);
    }

    public void setCountDownCallback(a aVar) {
        this.gvs = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.gvt = bVar;
    }
}
