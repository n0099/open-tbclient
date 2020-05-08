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
    private AnimatorSet aAZ;
    private boolean aMa;
    private long eIi;
    private String eIk;
    private boolean eIl;
    private final Runnable foV;
    private TbPageContext gfU;
    private TextView gfV;
    private TextView gfW;
    private FrameLayout gfX;
    private RelativeLayout gfY;
    private HeadImageView gfZ;
    private HeadImageView gga;
    private TextView ggb;
    private TextView ggc;
    private RelativeLayout ggd;
    private HeadImageView gge;
    private HeadImageView ggf;
    private TextView ggg;
    private TextView ggh;
    private LottieAnimationView ggi;
    private boolean ggj;
    private TextView ggk;
    private ImageView ggl;
    private long ggm;
    private boolean ggn;
    private a ggo;
    private b ggp;
    private g ggq;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes3.dex */
    public interface a {
        void bod();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void jx(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.ggm;
        alaRankListHeaderView.ggm = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.ggj = true;
        this.mHandler = new Handler();
        this.foV = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ggm <= 0) {
                    AlaRankListHeaderView.this.ggm = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ggo != null) {
                        AlaRankListHeaderView.this.ggo.bod();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gfV != null && "hour".equals(AlaRankListHeaderView.this.eIk) && AlaRankListHeaderView.this.ggj && AlaRankListHeaderView.this.ggm >= 0) {
                    AlaRankListHeaderView.this.gfV.setText(String.format(AlaRankListHeaderView.this.gfU.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.ggm))));
                }
            }
        };
        this.eIi = j;
        this.eIl = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggj = true;
        this.mHandler = new Handler();
        this.foV = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ggm <= 0) {
                    AlaRankListHeaderView.this.ggm = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ggo != null) {
                        AlaRankListHeaderView.this.ggo.bod();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gfV != null && "hour".equals(AlaRankListHeaderView.this.eIk) && AlaRankListHeaderView.this.ggj && AlaRankListHeaderView.this.ggm >= 0) {
                    AlaRankListHeaderView.this.gfV.setText(String.format(AlaRankListHeaderView.this.gfU.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.ggm))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggj = true;
        this.mHandler = new Handler();
        this.foV = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.ggm <= 0) {
                    AlaRankListHeaderView.this.ggm = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.ggo != null) {
                        AlaRankListHeaderView.this.ggo.bod();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gfV != null && "hour".equals(AlaRankListHeaderView.this.eIk) && AlaRankListHeaderView.this.ggj && AlaRankListHeaderView.this.ggm >= 0) {
                    AlaRankListHeaderView.this.gfV.setText(String.format(AlaRankListHeaderView.this.gfU.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.ggm))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.gfV = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.ggk = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.ggl = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.ggl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.En().aQu.asq)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.gfU, new String[]{com.baidu.live.v.a.En().aQu.asq}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.eIk)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.gfW = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.gfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.ggj = !AlaRankListHeaderView.this.ggj;
                AlaRankListHeaderView.this.gfW.setText(AlaRankListHeaderView.this.ggj ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.ggp != null) {
                    AlaRankListHeaderView.this.ggp.jx(AlaRankListHeaderView.this.ggj);
                }
            }
        });
        this.gfX = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.gfY = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.gfZ = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.gfZ.setIsRound(true);
        this.gfZ.setAutoChangeStyle(false);
        this.gfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ggq != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.ggq.drM != 1 || AlaRankListHeaderView.this.ggq.live_id <= 0 || AlaRankListHeaderView.this.ggq.live_id == AlaRankListHeaderView.this.eIi || AlaRankListHeaderView.this.eIl) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gfU.getPageActivity(), AlaRankListHeaderView.this.ggq.user_id, AlaRankListHeaderView.this.ggq.user_name, AlaRankListHeaderView.this.ggq.ffr, AlaRankListHeaderView.this.ggq.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.En().aQu.ata) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.gfU.getPageActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.ggq.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.gga = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.gga.setIsRound(true);
        this.gga.setAutoChangeStyle(false);
        this.ggb = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.ggc = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.gge = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.ggd = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.gge.setIsRound(true);
        this.gge.setAutoChangeStyle(false);
        this.ggd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ggq != null && AlaRankListHeaderView.this.ggq.feV != null && AlaRankListHeaderView.this.ggq.feV.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    g.a aVar = AlaRankListHeaderView.this.ggq.feV.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gfU.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.ggf = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.ggf.setIsRound(true);
        this.ggf.setAutoChangeStyle(false);
        this.ggg = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.ggh = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.ggi = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.gfU = tbPageContext;
        this.eIk = str;
        initView();
        if (j > 0 && "hour".equals(this.eIk) && !this.ggn) {
            this.ggn = true;
            this.ggm = j;
            this.gfV.setText(String.format(this.gfU.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.ggm))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDr() {
        if (this.aAZ == null) {
            this.aAZ = new AnimatorSet();
        }
        this.aAZ.cancel();
        HeadImageView headImageView = this.ggj ? this.gga : this.gfZ;
        HeadImageView headImageView2 = this.ggj ? this.gfZ : this.gga;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.ggj ? this.ggf : this.gge;
        HeadImageView headImageView4 = this.ggj ? this.gge : this.ggf;
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
        this.aAZ.setDuration(1000L);
        this.aAZ.playTogether(this.mAnimators);
        this.aAZ.setInterpolator(new AccelerateInterpolator());
        this.aAZ.start();
    }

    public void b(m mVar) {
        g.a aVar;
        g gVar = mVar.getList().get(0);
        if (gVar != null) {
            if (!this.aMa) {
                this.gga.setAlpha(0);
                this.gga.setVisibility(0);
                this.ggf.setAlpha(0);
                this.ggf.setVisibility(0);
            }
            this.ggq = gVar;
            if (this.ggj) {
                this.gfZ.startLoad(gVar.avatar, 12, false);
            } else {
                this.gga.startLoad(gVar.avatar, 12, false);
            }
            this.ggb.setText(gVar.getName_show());
            this.ggc.setText(String.format(this.gfU.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(gVar.point, 0L))));
            if (gVar.drM == 1) {
                this.ggi.setVisibility(0);
                this.ggi.loop(true);
                this.ggi.setAnimation("anchor_living.json");
                this.ggi.playAnimation();
            } else {
                this.ggi.setVisibility(8);
            }
            if (gVar.feV != null && (aVar = gVar.feV.get(0)) != null) {
                if (this.ggj) {
                    this.gge.startLoad(aVar.portrait, 12, false);
                } else {
                    this.ggf.startLoad(aVar.portrait, 12, false);
                }
                this.ggg.setText(aVar.feW);
                this.ggh.setText(String.format(this.gfU.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aLJ)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aMa) {
                        AlaRankListHeaderView.this.bDr();
                    }
                    AlaRankListHeaderView.this.aMa = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.eIk)) {
            this.ggk.setVisibility(0);
            this.ggl.setVisibility(8);
            this.gfV.setText(this.gfU.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eIk)) {
            this.ggk.setVisibility(8);
            this.ggl.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.ggm > 0 && !z) {
                this.gfV.setText(String.format(this.gfU.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.ggm))));
                startCountDown();
            } else {
                this.gfV.setText(this.gfU.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.eIk)) {
            this.mRootView.setVisibility(0);
            this.ggl.setVisibility(8);
            this.ggk.setVisibility(8);
            this.gfX.setVisibility(0);
            if (this.ggm >= 0 && this.ggj) {
                this.gfV.setText(String.format(this.gfU.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.ggm))));
            } else if (!this.ggj) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Gd()).append(":00-").append("00".equals(i.Gc()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Gc()).append(":00");
                this.gfV.setText(sb);
            }
        } else if ("charm_day".equals(this.eIk)) {
            this.mRootView.setVisibility(8);
            this.ggl.setVisibility(8);
            this.ggk.setVisibility(8);
            this.gfX.setVisibility(8);
            this.gfV.setVisibility(8);
            this.gfW.setVisibility(8);
        } else {
            this.gfX.setVisibility(8);
            this.ggl.setVisibility(8);
            this.ggk.setVisibility(8);
            this.gfV.setText(this.gfU.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.ggk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.gfU.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.gfU, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.gfX != null) {
            this.gfX.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.foV);
        this.mHandler.postDelayed(this.foV, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.foV);
    }

    public void setCountDownCallback(a aVar) {
        this.ggo = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.ggp = bVar;
    }
}
