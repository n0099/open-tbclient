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
import com.baidu.live.k.a;
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
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.c;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet Ye;
    private boolean agH;
    private long duD;
    private String duF;
    private boolean duG;
    private TbPageContext eDT;
    private TextView eDU;
    private TextView eDV;
    private FrameLayout eDW;
    private RelativeLayout eDX;
    private HeadImageView eDY;
    private HeadImageView eDZ;
    private TextView eEa;
    private TextView eEb;
    private RelativeLayout eEc;
    private HeadImageView eEd;
    private HeadImageView eEe;
    private TextView eEf;
    private TextView eEg;
    private LottieAnimationView eEh;
    private boolean eEi;
    private TextView eEj;
    private ImageView eEk;
    private long eEl;
    private boolean eEm;
    private a eEn;
    private b eEo;
    private com.baidu.tieba.ala.data.c eEp;
    private final Runnable eaC;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void aKP();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void gW(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.eEl;
        alaRankListHeaderView.eEl = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.eEi = true;
        this.mHandler = new Handler();
        this.eaC = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.eEl <= 0) {
                    AlaRankListHeaderView.this.eEl = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.eEn != null) {
                        AlaRankListHeaderView.this.eEn.aKP();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.eDU != null && "hour".equals(AlaRankListHeaderView.this.duF) && AlaRankListHeaderView.this.eEi && AlaRankListHeaderView.this.eEl >= 0) {
                    AlaRankListHeaderView.this.eDU.setText(String.format(AlaRankListHeaderView.this.eDT.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(AlaRankListHeaderView.this.eEl))));
                }
            }
        };
        this.duD = j;
        this.duG = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eEi = true;
        this.mHandler = new Handler();
        this.eaC = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.eEl <= 0) {
                    AlaRankListHeaderView.this.eEl = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.eEn != null) {
                        AlaRankListHeaderView.this.eEn.aKP();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.eDU != null && "hour".equals(AlaRankListHeaderView.this.duF) && AlaRankListHeaderView.this.eEi && AlaRankListHeaderView.this.eEl >= 0) {
                    AlaRankListHeaderView.this.eDU.setText(String.format(AlaRankListHeaderView.this.eDT.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(AlaRankListHeaderView.this.eEl))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eEi = true;
        this.mHandler = new Handler();
        this.eaC = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.eEl <= 0) {
                    AlaRankListHeaderView.this.eEl = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.eEn != null) {
                        AlaRankListHeaderView.this.eEn.aKP();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.eDU != null && "hour".equals(AlaRankListHeaderView.this.duF) && AlaRankListHeaderView.this.eEi && AlaRankListHeaderView.this.eEl >= 0) {
                    AlaRankListHeaderView.this.eDU.setText(String.format(AlaRankListHeaderView.this.eDT.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(AlaRankListHeaderView.this.eEl))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.eDU = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.eEj = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.eEk = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.eEk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.l.a.uA().ajX.Rm)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.eDT, new String[]{com.baidu.live.l.a.uA().ajX.Rm}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.duF)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.eDV = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.eDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.eEi = !AlaRankListHeaderView.this.eEi;
                AlaRankListHeaderView.this.eDV.setText(AlaRankListHeaderView.this.eEi ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.eEo != null) {
                    AlaRankListHeaderView.this.eEo.gW(AlaRankListHeaderView.this.eEi);
                }
            }
        });
        this.eDW = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.eDX = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.eDY = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.eDY.setIsRound(true);
        this.eDY.setAutoChangeStyle(false);
        this.eDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.eEp != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.eEp.cck != 1 || AlaRankListHeaderView.this.eEp.live_id <= 0 || AlaRankListHeaderView.this.eEp.live_id == AlaRankListHeaderView.this.duD || AlaRankListHeaderView.this.duG) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.eDT.getPageActivity(), AlaRankListHeaderView.this.eEp.user_id, AlaRankListHeaderView.this.eEp.user_name, AlaRankListHeaderView.this.eEp.dHw, AlaRankListHeaderView.this.eEp.getName_show());
                        return;
                    }
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.eDT.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.eEp.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        });
        this.eDZ = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.eDZ.setIsRound(true);
        this.eDZ.setAutoChangeStyle(false);
        this.eEa = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.eEb = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.eEd = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.eEc = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.eEd.setIsRound(true);
        this.eEd.setAutoChangeStyle(false);
        this.eEc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.eEp != null && AlaRankListHeaderView.this.eEp.dHd != null && AlaRankListHeaderView.this.eEp.dHd.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    c.a aVar = AlaRankListHeaderView.this.eEp.dHd.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.eDT.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.eEe = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.eEe.setIsRound(true);
        this.eEe.setAutoChangeStyle(false);
        this.eEf = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.eEg = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.eEh = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.eDT = tbPageContext;
        this.duF = str;
        initView();
        if (j > 0 && "hour".equals(this.duF) && !this.eEm) {
            this.eEm = true;
            this.eEl = j;
            this.eDU.setText(String.format(this.eDT.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(this.eEl))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYV() {
        if (this.Ye == null) {
            this.Ye = new AnimatorSet();
        }
        this.Ye.cancel();
        HeadImageView headImageView = this.eEi ? this.eDZ : this.eDY;
        HeadImageView headImageView2 = this.eEi ? this.eDY : this.eDZ;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.eEi ? this.eEe : this.eEd;
        HeadImageView headImageView4 = this.eEi ? this.eEd : this.eEe;
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
        this.Ye.setDuration(1000L);
        this.Ye.playTogether(this.mAnimators);
        this.Ye.setInterpolator(new AccelerateInterpolator());
        this.Ye.start();
    }

    public void b(com.baidu.tieba.ala.data.e eVar) {
        c.a aVar;
        com.baidu.tieba.ala.data.c cVar = eVar.getList().get(0);
        if (cVar != null) {
            if (!this.agH) {
                this.eDZ.setAlpha(0);
                this.eDZ.setVisibility(0);
                this.eEe.setAlpha(0);
                this.eEe.setVisibility(0);
            }
            this.eEp = cVar;
            if (this.eEi) {
                this.eDY.startLoad(cVar.avatar, 12, false);
            } else {
                this.eDZ.startLoad(cVar.avatar, 12, false);
            }
            this.eEa.setText(cVar.getName_show());
            this.eEb.setText(String.format(this.eDT.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(cVar.TS, 0L))));
            if (cVar.cck == 1) {
                this.eEh.setVisibility(0);
                this.eEh.loop(true);
                this.eEh.setAnimation("anchor_living.json");
                this.eEh.playAnimation();
            } else {
                this.eEh.setVisibility(8);
            }
            if (cVar.dHd != null && (aVar = cVar.dHd.get(0)) != null) {
                if (this.eEi) {
                    this.eEd.startLoad(aVar.portrait, 12, false);
                } else {
                    this.eEe.startLoad(aVar.portrait, 12, false);
                }
                this.eEf.setText(aVar.dHe);
                this.eEg.setText(String.format(this.eDT.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.dHf)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.agH) {
                        AlaRankListHeaderView.this.aYV();
                    }
                    AlaRankListHeaderView.this.agH = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.duF)) {
            this.eEj.setVisibility(0);
            this.eEk.setVisibility(8);
            this.eDU.setText(this.eDT.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.duF)) {
            this.eEj.setVisibility(8);
            this.eEk.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba();
            if (this.eEl > 0 && !z) {
                this.eDU.setText(String.format(this.eDT.getString(a.i.ala_rank_list_flower_count_down_tip), h.getCountDownTime(Long.valueOf(this.eEl))));
                startCountDown();
            } else {
                this.eDU.setText(this.eDT.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.duF)) {
            this.mRootView.setVisibility(0);
            this.eEk.setVisibility(8);
            this.eEj.setVisibility(8);
            this.eDW.setVisibility(0);
            if (this.eEl >= 0 && this.eEi) {
                this.eDU.setText(String.format(this.eDT.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(this.eEl))));
            } else if (!this.eEi) {
                StringBuilder sb = new StringBuilder();
                sb.append(h.wr()).append(":00-").append("00".equals(h.wq()) ? "24" : h.wq()).append(":00");
                this.eDU.setText(sb);
            }
        } else if ("charm_day".equals(this.duF)) {
            this.mRootView.setVisibility(8);
            this.eEk.setVisibility(8);
            this.eEj.setVisibility(8);
            this.eDW.setVisibility(8);
            this.eDU.setVisibility(8);
            this.eDV.setVisibility(8);
        } else {
            this.eDW.setVisibility(8);
            this.eEk.setVisibility(8);
            this.eEj.setVisibility(8);
            this.eDU.setText(this.eDT.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.eEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.eDT.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.eDT, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.eDW != null) {
            this.eDW.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eaC);
        this.mHandler.postDelayed(this.eaC, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.eaC);
    }

    public void setCountDownCallback(a aVar) {
        this.eEn = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.eEo = bVar;
    }
}
