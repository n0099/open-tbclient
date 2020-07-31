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
/* loaded from: classes4.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private AnimatorSet aKj;
    private boolean aVW;
    private final Runnable fTw;
    private long fkg;
    private String fki;
    private boolean fkj;
    private AlaLastLiveroomInfo flX;
    private TextView gNA;
    private RelativeLayout gNB;
    private HeadImageView gNC;
    private HeadImageView gND;
    private TextView gNE;
    private TextView gNF;
    private LottieAnimationView gNG;
    private boolean gNH;
    private TextView gNI;
    private ImageView gNJ;
    private long gNK;
    private boolean gNL;
    private a gNM;
    private b gNN;
    private com.baidu.tieba.ala.data.h gNO;
    private TbPageContext gNs;
    private TextView gNt;
    private TextView gNu;
    private FrameLayout gNv;
    private RelativeLayout gNw;
    private HeadImageView gNx;
    private HeadImageView gNy;
    private TextView gNz;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void bAk();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void kI(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.gNK;
        alaRankListHeaderView.gNK = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        super(context);
        this.gNH = true;
        this.mHandler = new Handler();
        this.fTw = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gNK <= 0) {
                    AlaRankListHeaderView.this.gNK = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gNM != null) {
                        AlaRankListHeaderView.this.gNM.bAk();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gNt != null && "hour".equals(AlaRankListHeaderView.this.fki) && AlaRankListHeaderView.this.gNH && AlaRankListHeaderView.this.gNK >= 0) {
                    AlaRankListHeaderView.this.gNt.setText(String.format(AlaRankListHeaderView.this.gNs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gNK))));
                }
            }
        };
        this.fkg = j;
        this.fkj = z;
        this.flX = alaLastLiveroomInfo;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gNH = true;
        this.mHandler = new Handler();
        this.fTw = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gNK <= 0) {
                    AlaRankListHeaderView.this.gNK = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gNM != null) {
                        AlaRankListHeaderView.this.gNM.bAk();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gNt != null && "hour".equals(AlaRankListHeaderView.this.fki) && AlaRankListHeaderView.this.gNH && AlaRankListHeaderView.this.gNK >= 0) {
                    AlaRankListHeaderView.this.gNt.setText(String.format(AlaRankListHeaderView.this.gNs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gNK))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gNH = true;
        this.mHandler = new Handler();
        this.fTw = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.gNK <= 0) {
                    AlaRankListHeaderView.this.gNK = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.gNM != null) {
                        AlaRankListHeaderView.this.gNM.bAk();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.gNt != null && "hour".equals(AlaRankListHeaderView.this.fki) && AlaRankListHeaderView.this.gNH && AlaRankListHeaderView.this.gNK >= 0) {
                    AlaRankListHeaderView.this.gNt.setText(String.format(AlaRankListHeaderView.this.gNs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(AlaRankListHeaderView.this.gNK))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.gNt = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.gNI = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.gNJ = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.gNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.Hs().aZn.aAM)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.gNs, new String[]{com.baidu.live.v.a.Hs().aZn.aAM}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.fki)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.gNu = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.gNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.gNH = !AlaRankListHeaderView.this.gNH;
                AlaRankListHeaderView.this.gNu.setText(AlaRankListHeaderView.this.gNH ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.gNN != null) {
                    AlaRankListHeaderView.this.gNN.kI(AlaRankListHeaderView.this.gNH);
                }
            }
        });
        this.gNv = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.gNw = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.gNx = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.gNx.setIsRound(true);
        this.gNx.setAutoChangeStyle(false);
        this.gNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gNO != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.gNO.dSD != 1 || AlaRankListHeaderView.this.gNO.live_id <= 0 || AlaRankListHeaderView.this.gNO.live_id == AlaRankListHeaderView.this.fkg || AlaRankListHeaderView.this.fkj) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gNs.getPageActivity(), AlaRankListHeaderView.this.gNO.user_id, AlaRankListHeaderView.this.gNO.user_name, AlaRankListHeaderView.this.gNO.fJN, AlaRankListHeaderView.this.gNO.getName_show());
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hs().aZn.aBC) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.gNs.getPageActivity());
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(AlaRankListHeaderView.this.flX);
                        alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.gNO.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        });
        this.gNy = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.gNy.setIsRound(true);
        this.gNy.setAutoChangeStyle(false);
        this.gNz = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.gNA = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.gNC = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.gNB = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.gNC.setIsRound(true);
        this.gNC.setAutoChangeStyle(false);
        this.gNB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.gNO != null && AlaRankListHeaderView.this.gNO.fJr != null && AlaRankListHeaderView.this.gNO.fJr.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    h.a aVar = AlaRankListHeaderView.this.gNO.fJr.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.gNs.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.gND = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.gND.setIsRound(true);
        this.gND.setAutoChangeStyle(false);
        this.gNE = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.gNF = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.gNG = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.gNs = tbPageContext;
        this.fki = str;
        initView();
        if (j > 0 && "hour".equals(this.fki) && !this.gNL) {
            this.gNL = true;
            this.gNK = j;
            this.gNt.setText(String.format(this.gNs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gNK))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQc() {
        if (this.aKj == null) {
            this.aKj = new AnimatorSet();
        }
        this.aKj.cancel();
        HeadImageView headImageView = this.gNH ? this.gNy : this.gNx;
        HeadImageView headImageView2 = this.gNH ? this.gNx : this.gNy;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.gNH ? this.gND : this.gNC;
        HeadImageView headImageView4 = this.gNH ? this.gNC : this.gND;
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
        this.aKj.setDuration(1000L);
        this.aKj.playTogether(this.mAnimators);
        this.aKj.setInterpolator(new AccelerateInterpolator());
        this.aKj.start();
    }

    public void b(n nVar) {
        h.a aVar;
        com.baidu.tieba.ala.data.h hVar = nVar.getList().get(0);
        if (hVar != null) {
            if (!this.aVW) {
                this.gNy.setAlpha(0);
                this.gNy.setVisibility(0);
                this.gND.setAlpha(0);
                this.gND.setVisibility(0);
            }
            this.gNO = hVar;
            if (this.gNH) {
                this.gNx.startLoad(hVar.avatar, 12, false);
            } else {
                this.gNy.startLoad(hVar.avatar, 12, false);
            }
            this.gNz.setText(hVar.getName_show());
            this.gNA.setText(String.format(this.gNs.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(hVar.point, 0L))));
            if (hVar.dSD == 1) {
                this.gNG.setVisibility(0);
                this.gNG.loop(true);
                this.gNG.setAnimation("anchor_living.json");
                this.gNG.playAnimation();
            } else {
                this.gNG.setVisibility(8);
            }
            if (hVar.fJr != null && (aVar = hVar.fJr.get(0)) != null) {
                if (this.gNH) {
                    this.gNC.startLoad(aVar.portrait, 12, false);
                } else {
                    this.gND.startLoad(aVar.portrait, 12, false);
                }
                this.gNE.setText(aVar.fJs);
                this.gNF.setText(String.format(this.gNs.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.aVI)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.aVW) {
                        AlaRankListHeaderView.this.bQc();
                    }
                    AlaRankListHeaderView.this.aVW = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.fki)) {
            this.gNI.setVisibility(0);
            this.gNJ.setVisibility(8);
            this.gNt.setText(this.gNs.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fki)) {
            this.gNI.setVisibility(8);
            this.gNJ.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu();
            if (this.gNK > 0 && !z) {
                this.gNt.setText(String.format(this.gNs.getString(a.i.ala_rank_list_flower_count_down_tip), i.getCountDownTime(Long.valueOf(this.gNK))));
                startCountDown();
            } else {
                this.gNt.setText(this.gNs.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.fki)) {
            this.mRootView.setVisibility(0);
            this.gNJ.setVisibility(8);
            this.gNI.setVisibility(8);
            this.gNv.setVisibility(0);
            if (this.gNK >= 0 && this.gNH) {
                this.gNt.setText(String.format(this.gNs.getString(a.i.hour_rank_list_count_down_tip), i.b(Long.valueOf(this.gNK))));
            } else if (!this.gNH) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.Jq()).append(":00-").append("00".equals(i.Jp()) ? SoUtils.SO_EVENT_ID_DEFAULT : i.Jp()).append(":00");
                this.gNt.setText(sb);
            }
        } else if ("charm_day".equals(this.fki)) {
            this.mRootView.setVisibility(8);
            this.gNJ.setVisibility(8);
            this.gNI.setVisibility(8);
            this.gNv.setVisibility(8);
            this.gNt.setVisibility(8);
            this.gNu.setVisibility(8);
        } else {
            this.gNv.setVisibility(8);
            this.gNJ.setVisibility(8);
            this.gNI.setVisibility(8);
            this.gNt.setText(this.gNs.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.gNI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.gNs.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.gNs, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.gNv != null) {
            this.gNv.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fTw);
        this.mHandler.postDelayed(this.fTw, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fTw);
    }

    public void setCountDownCallback(a aVar) {
        this.gNM = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.gNN = bVar;
    }
}
