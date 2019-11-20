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
    private AnimatorSet XM;
    private boolean agp;
    private final Runnable dZL;
    private long dtM;
    private String dtO;
    private boolean dtP;
    private TbPageContext eDc;
    private TextView eDd;
    private TextView eDe;
    private FrameLayout eDf;
    private RelativeLayout eDg;
    private HeadImageView eDh;
    private HeadImageView eDi;
    private TextView eDj;
    private TextView eDk;
    private RelativeLayout eDl;
    private HeadImageView eDm;
    private HeadImageView eDn;
    private TextView eDo;
    private TextView eDp;
    private LottieAnimationView eDq;
    private boolean eDr;
    private TextView eDs;
    private ImageView eDt;
    private long eDu;
    private boolean eDv;
    private a eDw;
    private b eDx;
    private com.baidu.tieba.ala.data.c eDy;
    private ArrayList<Animator> mAnimators;
    private final Handler mHandler;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void aKN();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void gW(boolean z);
    }

    static /* synthetic */ long c(AlaRankListHeaderView alaRankListHeaderView) {
        long j = alaRankListHeaderView.eDu;
        alaRankListHeaderView.eDu = j - 1;
        return j;
    }

    public AlaRankListHeaderView(Context context, long j, boolean z) {
        super(context);
        this.eDr = true;
        this.mHandler = new Handler();
        this.dZL = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.eDu <= 0) {
                    AlaRankListHeaderView.this.eDu = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.eDw != null) {
                        AlaRankListHeaderView.this.eDw.aKN();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.eDd != null && "hour".equals(AlaRankListHeaderView.this.dtO) && AlaRankListHeaderView.this.eDr && AlaRankListHeaderView.this.eDu >= 0) {
                    AlaRankListHeaderView.this.eDd.setText(String.format(AlaRankListHeaderView.this.eDc.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(AlaRankListHeaderView.this.eDu))));
                }
            }
        };
        this.dtM = j;
        this.dtP = z;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eDr = true;
        this.mHandler = new Handler();
        this.dZL = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.eDu <= 0) {
                    AlaRankListHeaderView.this.eDu = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.eDw != null) {
                        AlaRankListHeaderView.this.eDw.aKN();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.eDd != null && "hour".equals(AlaRankListHeaderView.this.dtO) && AlaRankListHeaderView.this.eDr && AlaRankListHeaderView.this.eDu >= 0) {
                    AlaRankListHeaderView.this.eDd.setText(String.format(AlaRankListHeaderView.this.eDc.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(AlaRankListHeaderView.this.eDu))));
                }
            }
        };
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eDr = true;
        this.mHandler = new Handler();
        this.dZL = new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaRankListHeaderView.this.eDu <= 0) {
                    AlaRankListHeaderView.this.eDu = 0L;
                    AlaRankListHeaderView.this.release();
                    if (AlaRankListHeaderView.this.eDw != null) {
                        AlaRankListHeaderView.this.eDw.aKN();
                    }
                } else {
                    AlaRankListHeaderView.c(AlaRankListHeaderView.this);
                    AlaRankListHeaderView.this.startCountDown();
                }
                if (AlaRankListHeaderView.this.eDd != null && "hour".equals(AlaRankListHeaderView.this.dtO) && AlaRankListHeaderView.this.eDr && AlaRankListHeaderView.this.eDu >= 0) {
                    AlaRankListHeaderView.this.eDd.setText(String.format(AlaRankListHeaderView.this.eDc.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(AlaRankListHeaderView.this.eDu))));
                }
            }
        };
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.ala_rank_list_header_layout, this);
        this.eDd = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_refresh_tip);
        this.eDs = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_game_rule);
        this.eDt = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_flower_description);
        this.eDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.l.a.uB().ajF.QL)) {
                    UrlManager.getInstance().dealOneLink(AlaRankListHeaderView.this.eDc, new String[]{com.baidu.live.l.a.uB().ajF.QL}, true);
                    if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListHeaderView.this.dtO)) {
                        TiebaInitialize.log(new StatisticItem("c12963"));
                    }
                }
            }
        });
        this.eDe = (TextView) this.mRootView.findViewById(a.g.rank_list_switch);
        this.eDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListHeaderView.this.eDr = !AlaRankListHeaderView.this.eDr;
                AlaRankListHeaderView.this.eDe.setText(AlaRankListHeaderView.this.eDr ? a.i.hour_rank_list_head_switch_cur : a.i.hour_rank_list_head_switch_pre);
                if (AlaRankListHeaderView.this.eDx != null) {
                    AlaRankListHeaderView.this.eDx.gW(AlaRankListHeaderView.this.eDr);
                }
            }
        });
        this.eDf = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.eDg = (RelativeLayout) this.mRootView.findViewById(a.g.rl_rank_first);
        this.eDh = (HeadImageView) this.mRootView.findViewById(a.g.rank_first);
        this.eDh.setIsRound(true);
        this.eDh.setAutoChangeStyle(false);
        this.eDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.eDy != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("author", null, 1)));
                    if (AlaRankListHeaderView.this.eDy.cbt != 1 || AlaRankListHeaderView.this.eDy.live_id <= 0 || AlaRankListHeaderView.this.eDy.live_id == AlaRankListHeaderView.this.dtM || AlaRankListHeaderView.this.dtP) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.eDc.getPageActivity(), AlaRankListHeaderView.this.eDy.user_id, AlaRankListHeaderView.this.eDy.user_name, AlaRankListHeaderView.this.eDy.dGF, AlaRankListHeaderView.this.eDy.getName_show());
                        return;
                    }
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(AlaRankListHeaderView.this.eDc.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(AlaRankListHeaderView.this.eDy.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        });
        this.eDi = (HeadImageView) this.mRootView.findViewById(a.g.rank_first2);
        this.eDi.setIsRound(true);
        this.eDi.setAutoChangeStyle(false);
        this.eDj = (TextView) this.mRootView.findViewById(a.g.name_rank_1);
        this.eDk = (TextView) this.mRootView.findViewById(a.g.point_rank_1);
        this.eDm = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.eDl = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.eDm.setIsRound(true);
        this.eDm.setAutoChangeStyle(false);
        this.eDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.eDy != null && AlaRankListHeaderView.this.eDy.dGm != null && AlaRankListHeaderView.this.eDy.dGm.size() > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913104, new HourRankItemData("financier", null, 1)));
                    c.a aVar = AlaRankListHeaderView.this.eDy.dGm.get(0);
                    if (aVar != null) {
                        AlaRankListHeaderView.this.a(AlaRankListHeaderView.this.eDc.getPageActivity(), JavaTypesHelper.toLong(aVar.userId, 0L), aVar.userName, aVar.portrait, aVar.getName_show());
                    }
                }
            }
        });
        this.eDn = (HeadImageView) this.mRootView.findViewById(a.g.charm_first2);
        this.eDn.setIsRound(true);
        this.eDn.setAutoChangeStyle(false);
        this.eDo = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.eDp = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.eDq = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
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
        this.eDc = tbPageContext;
        this.dtO = str;
        initView();
        if (j > 0 && "hour".equals(this.dtO) && !this.eDv) {
            this.eDv = true;
            this.eDu = j;
            this.eDd.setText(String.format(this.eDc.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(this.eDu))));
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYT() {
        if (this.XM == null) {
            this.XM = new AnimatorSet();
        }
        this.XM.cancel();
        HeadImageView headImageView = this.eDr ? this.eDi : this.eDh;
        HeadImageView headImageView2 = this.eDr ? this.eDh : this.eDi;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(headImageView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headImageView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(headImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(headImageView2, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(headImageView2, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headImageView2, "alpha", 0.0f, 1.0f);
        HeadImageView headImageView3 = this.eDr ? this.eDn : this.eDm;
        HeadImageView headImageView4 = this.eDr ? this.eDm : this.eDn;
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
        this.XM.setDuration(1000L);
        this.XM.playTogether(this.mAnimators);
        this.XM.setInterpolator(new AccelerateInterpolator());
        this.XM.start();
    }

    public void b(com.baidu.tieba.ala.data.e eVar) {
        c.a aVar;
        com.baidu.tieba.ala.data.c cVar = eVar.getList().get(0);
        if (cVar != null) {
            if (!this.agp) {
                this.eDi.setAlpha(0);
                this.eDi.setVisibility(0);
                this.eDn.setAlpha(0);
                this.eDn.setVisibility(0);
            }
            this.eDy = cVar;
            if (this.eDr) {
                this.eDh.startLoad(cVar.avatar, 12, false);
            } else {
                this.eDi.startLoad(cVar.avatar, 12, false);
            }
            this.eDj.setText(cVar.getName_show());
            this.eDk.setText(String.format(this.eDc.getString(a.i.head_hour_rank_anchor), StringHelper.formatForHourRankValue(JavaTypesHelper.toLong(cVar.Tx, 0L))));
            if (cVar.cbt == 1) {
                this.eDq.setVisibility(0);
                this.eDq.loop(true);
                this.eDq.setAnimation("anchor_living.json");
                this.eDq.playAnimation();
            } else {
                this.eDq.setVisibility(8);
            }
            if (cVar.dGm != null && (aVar = cVar.dGm.get(0)) != null) {
                if (this.eDr) {
                    this.eDm.startLoad(aVar.portrait, 12, false);
                } else {
                    this.eDn.startLoad(aVar.portrait, 12, false);
                }
                this.eDo.setText(aVar.dGn);
                this.eDp.setText(String.format(this.eDc.getString(a.i.head_hour_rank_gold), StringHelper.formatForHourRankValue(aVar.dGo)));
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaRankListHeaderView.this.agp) {
                        AlaRankListHeaderView.this.aYT();
                    }
                    AlaRankListHeaderView.this.agp = true;
                }
            }, 300L);
        }
    }

    private void initView() {
        if (ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(this.dtO)) {
            this.eDs.setVisibility(0);
            this.eDt.setVisibility(8);
            this.eDd.setText(this.eDc.getPageActivity().getString(a.i.ala_rank_list_game_refresh_rule));
        } else if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.dtO)) {
            this.eDs.setVisibility(8);
            this.eDt.setVisibility(8);
            boolean z = TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba();
            if (this.eDu > 0 && !z) {
                this.eDd.setText(String.format(this.eDc.getString(a.i.ala_rank_list_flower_count_down_tip), h.getCountDownTime(Long.valueOf(this.eDu))));
                startCountDown();
            } else {
                this.eDd.setText(this.eDc.getPageActivity().getString(a.i.hkqm_rank_list_refresh_flower_rule));
            }
        } else if ("hour".equals(this.dtO)) {
            this.mRootView.setVisibility(0);
            this.eDt.setVisibility(8);
            this.eDs.setVisibility(8);
            this.eDf.setVisibility(0);
            if (this.eDu >= 0 && this.eDr) {
                this.eDd.setText(String.format(this.eDc.getString(a.i.hour_rank_list_count_down_tip), h.b(Long.valueOf(this.eDu))));
            } else if (!this.eDr) {
                StringBuilder sb = new StringBuilder();
                sb.append(h.ws()).append(":00-").append("00".equals(h.wr()) ? "24" : h.wr()).append(":00");
                this.eDd.setText(sb);
            }
        } else if ("charm_day".equals(this.dtO)) {
            this.mRootView.setVisibility(8);
            this.eDt.setVisibility(8);
            this.eDs.setVisibility(8);
            this.eDf.setVisibility(8);
            this.eDd.setVisibility(8);
            this.eDe.setVisibility(8);
        } else {
            this.eDf.setVisibility(8);
            this.eDt.setVisibility(8);
            this.eDs.setVisibility(8);
            this.eDd.setText(this.eDc.getPageActivity().getString(a.i.hkqm_rank_list_refresh_charm_rule));
        }
        this.eDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.AlaRankListHeaderView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty("https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123")) {
                    BdUtilHelper.showToast(AlaRankListHeaderView.this.eDc.getPageActivity(), a.i.sdk_url_is_null);
                } else {
                    UrlManager.getInstance().dealOneLinkWithDialog(AlaRankListHeaderView.this.eDc, "", new String[]{"https://tieba.baidu.com/n/video/liverank/rule?key=24295ff34773fe1c877d3eeabd3f86b123"}, false, null, true);
                }
            }
        });
    }

    public void setIsCunzrrentRank(boolean z) {
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.eDf != null) {
            this.eDf.setVisibility(i);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.dZL);
        this.mHandler.postDelayed(this.dZL, 1000L);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.dZL);
    }

    public void setCountDownCallback(a aVar) {
        this.eDw = aVar;
    }

    public void setRankListCallback(b bVar) {
        this.eDx = bVar;
    }
}
