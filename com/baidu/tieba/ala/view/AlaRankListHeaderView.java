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
    private AnimatorSet aAT;
    private boolean aLU;
    private long eId;
    private String eIf;
    private boolean eIg;
    private final Runnable foQ;
    private TbPageContext gfO;
    private TextView gfP;
    private TextView gfQ;
    private FrameLayout gfR;
    private RelativeLayout gfS;
    private HeadImageView gfT;
    private HeadImageView gfU;
    private TextView gfV;
    private TextView gfW;
    private RelativeLayout gfX;
    private HeadImageView gfY;
    private HeadImageView gfZ;
    private TextView gga;
    private TextView ggb;
    private LottieAnimationView ggc;
    private boolean ggd;
    private TextView gge;
    private ImageView ggf;
    private long ggg;
    private boolean ggh;
    private a ggi;
    private b ggj;
    private g ggk;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void bof();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void jx(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.ggg;
        alaRankListHeaderView.ggg = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.ggd = true;
        this.mHandler = new Handler();
        this.foQ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ggg <= 0) {
                    AlaRankListHeaderView.this.ggg = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ggi != null) {
                        AlaRankListHeaderView.this.ggi.bof();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gfP != null && "hour".equals(AlaRankListHeaderView.this.eIf) && AlaRankListHeaderView.this.ggd && AlaRankListHeaderView.this.ggg >= 0) {
                    AlaRankListHeaderView.this.gfP.setText(String.format(AlaRankListHeaderView.this.gfO.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.ggg))));
                }
            }
        };
        this.eId = j;
        this.eIg = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggd = true;
        this.mHandler = new Handler();
        this.foQ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ggg <= 0) {
                    AlaRankListHeaderView.this.ggg = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ggi != null) {
                        AlaRankListHeaderView.this.ggi.bof();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gfP != null && "hour".equals(AlaRankListHeaderView.this.eIf) && AlaRankListHeaderView.this.ggd && AlaRankListHeaderView.this.ggg >= 0) {
                    AlaRankListHeaderView.this.gfP.setText(String.format(AlaRankListHeaderView.this.gfO.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.ggg))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggd = true;
        this.mHandler = new Handler();
        this.foQ = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ggg <= 0) {
                    AlaRankListHeaderView.this.ggg = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ggi != null) {
                        AlaRankListHeaderView.this.ggi.bof();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gfP != null && "hour".equals(AlaRankListHeaderView.this.eIf) && AlaRankListHeaderView.this.ggd && AlaRankListHeaderView.this.ggg >= 0) {
                    AlaRankListHeaderView.this.gfP.setText(String.format(AlaRankListHeaderView.this.gfO.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.ggg))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.gfP = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.gge = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.ggf = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.ggf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.Eo().aQp.asj)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.gfO, new String[]{com.baidu.live.v.a.Eo().aQp.asj}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.eIf)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.gfQ = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.gfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.ggd = !AlaRankListHeaderView.this.ggd;
                AlaRankListHeaderView.this.gfQ.setText(AlaRankListHeaderView.this.ggd ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.ggj != null) {
                    AlaRankListHeaderView.this.ggj.jx(AlaRankListHeaderView.this.ggd);
                }
            }
        });
        this.gfR = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.gfS = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.gfT = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.gfT.setIsRound(true);
        this.gfT.setAutoChangeStyle(false);
        this.gfS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ggk != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.ggk.drI != 1 || AlaRankListHeaderView.this.ggk.live_id <= 0 || AlaRankListHeaderView.this.ggk.live_id == AlaRankListHeaderView.this.eId || AlaRankListHeaderView.this.eIg) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gfO.getPageActivity(), AlaRankListHeaderView.this.ggk.user_id, AlaRankListHeaderView.this.ggk.user_name, AlaRankListHeaderView.this.ggk.ffm, AlaRankListHeaderView.this.ggk.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Eo().aQp.asU) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.gfO.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.ggk.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.gfU = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.gfU.setIsRound(true);
        this.gfU.setAutoChangeStyle(false);
        this.gfV = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.gfW = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.gfY = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.gfX = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.gfY.setIsRound(true);
        this.gfY.setAutoChangeStyle(false);
        this.gfX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ggk != null && AlaRankListHeaderView.this.ggk.feQ != null && AlaRankListHeaderView.this.ggk.feQ.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.ggk.feQ.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gfO.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.gfZ = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.gfZ.setIsRound(true);
        this.gfZ.setAutoChangeStyle(false);
        this.gga = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.ggb = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.ggc = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.gfO = tbPageContext;
        this.eIf = str;
        initView();
        if (j > 0 && "hour".equals(this.eIf) && !this.ggh) {
            this.ggh = true;
            this.ggg = j;
            this.gfP.setText(String.format(this.gfO.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.ggg))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDt() {
        if (this.aAT == null) {
            this.aAT = new AnimatorSet();
        }
        this.aAT.cancel();
        HeadImageView headImageView = this.ggd ? this.gfU : this.gfT;
        HeadImageView headImageView2 = this.ggd ? this.gfT : this.gfU;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.ggd ? this.gfZ : this.gfY;
        HeadImageView headImageView4 = this.ggd ? this.gfY : this.gfZ;
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
        this.aAT.setDuration(1000L);
        this.aAT.playTogether(this.mAnimators);
        this.aAT.setInterpolator(new AccelerateInterpolator());
        this.aAT.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.aLU) {
                this.gfU.setAlpha(0);
                this.gfU.setVisibility(0);
                this.gfZ.setAlpha(0);
                this.gfZ.setVisibility(0);
            }
            this.ggk = gVar;
            if (this.ggd) {
                this.gfT.startLoad(gVar.avatar, 12, false);
            } else {
                this.gfU.startLoad(gVar.avatar, 12, false);
            }
            this.gfV.setText(gVar.getName_show());
            this.gfW.setText(String.format(this.gfO.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.drI == 1) {
                this.ggc.setVisibility(0);
                this.ggc.loop(true);
                this.ggc.setAnimation("anchor_living.json");
                this.ggc.playAnimation();
            } else {
                this.ggc.setVisibility(8);
            }
            if (gVar.feQ != null && (aVar = gVar.feQ.get(0)) != null) {
                if (this.ggd) {
                    this.gfY.startLoad(aVar.portrait, 12, false);
                } else {
                    this.gfZ.startLoad(aVar.portrait, 12, false);
                }
                this.gga.setText(aVar.feR);
                this.ggb.setText(String.format(this.gfO.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aLD)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aLU) {
                        AlaRankListHeaderView.this.bDt();
                    }
                    AlaRankListHeaderView.this.aLU = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eIf)) {
            this.gge.setVisibility(0);
            this.ggf.setVisibility(8);
            this.gfP.setText(this.gfO.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eIf)) {
            this.gge.setVisibility(8);
            this.ggf.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.ggg > 0 && !z) {
                this.gfP.setText(String.format(this.gfO.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.ggg))));
                startCountDown();
            } else {
                this.gfP.setText(this.gfO.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.eIf)) {
            this.mRootView.setVisibility(0);
            this.ggf.setVisibility(8);
            this.gge.setVisibility(8);
            this.gfR.setVisibility(0);
            if (this.ggg >= 0 && this.ggd) {
                this.gfP.setText(String.format(this.gfO.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.ggg))));
            } else if (!this.ggd) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Ge()).append(":00-").append("00".equals(i.Gd()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Gd()).append(":00");
                this.gfP.setText(sb);
            }
        } else if ("charm_day".equals(this.eIf)) {
            this.mRootView.setVisibility(8);
            this.ggf.setVisibility(8);
            this.gge.setVisibility(8);
            this.gfR.setVisibility(8);
            this.gfP.setVisibility(8);
            this.gfQ.setVisibility(8);
        } else {
            this.gfR.setVisibility(8);
            this.ggf.setVisibility(8);
            this.gge.setVisibility(8);
            this.gfP.setText(this.gfO.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.gge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.gfO.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.gfO, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.gfR != null) {
            this.gfR.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.foQ);
        this.mHandler.postDelayed(this.foQ, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.foQ);
    }

    public void setCountDownCallback(a aVar) {
        this.ggi = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.ggj = bVar;
    }
}
