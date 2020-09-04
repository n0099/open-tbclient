package com.baidu.tieba.ala.liveroom.o;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class b {
    private TextView dTU;
    private TextView fDB;
    private HeadImageView gAX;
    private TextView gAY;
    private ImageView gAZ;
    private r gBa;
    private AnimatorSet gBc;
    private ScaleAnimation gBe;
    private ScaleAnimation gBf;
    private AnimationSet gBg;
    private AnimationSet gBh;
    private ScaleAnimation gBi;
    private com.baidu.tieba.ala.liveroom.operation.b gmW;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int gBb = 30000;
    private boolean gBj = false;
    private boolean aXY = false;
    private Set<Long> gBk = new HashSet();
    private boolean gBl = true;
    private boolean gBm = false;
    private long gBn = 0;
    CustomMessageListener fZC = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.o.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Ft((String) customResponsedMessage.getData());
            } else {
                b.this.bSP();
            }
        }
    };
    private Set<Long> gBd = new HashSet();

    public b(Context context) {
        this.mContext = context;
        initView();
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.h.hk_liveroom_hostheader_layout, null);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mView.setBackgroundResource(a.f.sdk_round_host_header_bg_bd);
        } else {
            this.mView.setBackgroundResource(a.f.sdk_round_host_bg);
        }
        this.gAY = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.gAX = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dTU = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fDB = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.gAZ = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.gAX.setIsRound(true);
        this.gAX.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.gAX.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gAY.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.gAY.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAY.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.gAY.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.gAY.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.gAY.setOnClickListener(onClickListener);
    }

    public void mo(boolean z) {
        this.gBl = false;
        if (!this.gBm) {
            this.gAY.setVisibility(8);
            return;
        }
        if (!z) {
            this.gAY.setVisibility(8);
            this.gAZ.setVisibility(0);
        } else {
            bSO();
        }
        if (!this.isHost && this.gBa != null && this.gBa.mLiveInfo != null && this.gBa.aDG != null) {
            long j = this.gBa.aDG.userId;
            if (!this.gBk.contains(Long.valueOf(j))) {
                this.gBk.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.gBa.mLiveInfo.live_id + "", this.gBa.mLiveInfo.room_id + "", this.gBa.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bSO() {
        if (!this.gBj && this.gAZ.getVisibility() != 0) {
            this.gBj = true;
            this.gBe = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.gBe.setDuration(200L);
            this.gBe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAY.setScaleX(1.0f);
                    b.this.gAY.setScaleY(1.0f);
                    b.this.gAY.setAlpha(1.0f);
                    b.this.gBj = false;
                    if (b.this.gBl) {
                        b.this.gAY.setVisibility(0);
                        b.this.gAZ.setVisibility(4);
                        return;
                    }
                    b.this.gAY.setVisibility(8);
                    b.this.gAZ.setVisibility(0);
                    if (b.this.gBm) {
                        b.this.bSR();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gBf = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.gBf.setDuration(800L);
            this.gBf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAZ.startAnimation(b.this.gBe);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.gBg = new AnimationSet(true);
            this.gBg.addAnimation(aVar);
            this.gBg.addAnimation(alphaAnimation);
            this.gBg.setDuration(1000L);
            this.gBg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.gAZ.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAZ.startAnimation(b.this.gBf);
                    b.this.gAY.setVisibility(8);
                    b.this.gAY.setScaleX(1.0f);
                    b.this.gAY.setScaleY(1.0f);
                    b.this.gAY.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.gBh = new AnimationSet(true);
            this.gBh.addAnimation(aVar2);
            this.gBh.addAnimation(alphaAnimation2);
            this.gBh.setDuration(1000L);
            this.gBi = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.gBi.setDuration(200L);
            this.gBi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAY.setScaleX(0.9f);
                    b.this.gAY.setScaleY(0.9f);
                    b.this.gAY.startAnimation(b.this.gBh);
                    b.this.gAZ.startAnimation(b.this.gBg);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gAY.startAnimation(this.gBi);
        }
    }

    public void bSN() {
        this.gBl = true;
        this.gBj = false;
        this.gAY.setScaleX(1.0f);
        this.gAY.setScaleY(1.0f);
        this.gAY.setAlpha(1.0f);
        this.gAY.setVisibility(0);
        if (this.gBm) {
            this.gAZ.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void eh(long j) {
        if (j > this.gBn) {
            this.gBn = j;
            this.fDB.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(r rVar, final boolean z, final String str) {
        boolean z2;
        if (this.gBa == null || this.gBa.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (rVar == null || rVar.mLiveInfo == null) ? true : this.gBa.mLiveInfo.live_id == rVar.mLiveInfo.live_id;
        }
        this.gBa = rVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.gBa != null && this.gBa.aDG != null) {
            this.gAX.stopLoad();
            this.gAX.startLoad(this.gBa.aDG.portrait, 12, false, false);
            String str2 = this.gBa.aDG.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dTU.setText(str2);
            if (z2 || rVar.aDG.charmCount > this.gBn) {
                this.gBn = rVar.aDG.charmCount;
                this.fDB.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.gBn)));
            }
            this.gAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bSP();
                    if (!z && b.this.gBa != null && b.this.gBa.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.gBa.mLiveInfo.live_id + "", b.this.gBa.mLiveInfo.room_id + "", b.this.gBa.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSP() {
        Ft(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft(String str) {
        if (this.mContext != null && this.gBa != null && this.gBa.aDG != null && this.gBa.mLiveInfo != null) {
            long j = this.gBa.aDG.userId;
            long j2 = this.gBa.mLiveInfo.live_id;
            long j3 = this.gBa.mLiveInfo.room_id;
            String str2 = this.gBa.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aXY);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bSQ() {
        if (this.gBc != null) {
            this.gBc.removeAllListeners();
            this.gBc.cancel();
            this.gBc = null;
        }
    }

    public void onDestroy() {
        bSQ();
        if (this.fZC != null) {
            MessageManager.getInstance().unRegisterListener(this.fZC);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.gBk.clear();
    }

    private void cancelAnimation() {
        if (this.gBi != null) {
            this.gBi.cancel();
        }
        if (this.gBh != null) {
            this.gBh.cancel();
        }
        if (this.gBg != null) {
            this.gBg.cancel();
        }
        if (this.gBf != null) {
            this.gBf.cancel();
        }
        if (this.gBe != null) {
            this.gBe.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gmW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSR() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void mp(boolean z) {
        this.aXY = z;
    }
}
