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
    private TextView dTQ;
    private TextView fDx;
    private HeadImageView gAT;
    private TextView gAU;
    private ImageView gAV;
    private r gAW;
    private AnimatorSet gAY;
    private ScaleAnimation gBa;
    private ScaleAnimation gBb;
    private AnimationSet gBc;
    private AnimationSet gBd;
    private ScaleAnimation gBe;
    private com.baidu.tieba.ala.liveroom.operation.b gmS;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int gAX = 30000;
    private boolean gBf = false;
    private boolean aXW = false;
    private Set<Long> gBg = new HashSet();
    private boolean gBh = true;
    private boolean gBi = false;
    private long gBj = 0;
    CustomMessageListener fZy = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.o.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Fs((String) customResponsedMessage.getData());
            } else {
                b.this.bSO();
            }
        }
    };
    private Set<Long> gAZ = new HashSet();

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
        this.gAU = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.gAT = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dTQ = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fDx = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.gAV = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.gAT.setIsRound(true);
        this.gAT.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.gAT.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gAU.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.gAU.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAU.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.gAU.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.gAU.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.gAU.setOnClickListener(onClickListener);
    }

    public void mm(boolean z) {
        this.gBh = false;
        if (!this.gBi) {
            this.gAU.setVisibility(8);
            return;
        }
        if (!z) {
            this.gAU.setVisibility(8);
            this.gAV.setVisibility(0);
        } else {
            bSN();
        }
        if (!this.isHost && this.gAW != null && this.gAW.mLiveInfo != null && this.gAW.aDE != null) {
            long j = this.gAW.aDE.userId;
            if (!this.gBg.contains(Long.valueOf(j))) {
                this.gBg.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.gAW.mLiveInfo.live_id + "", this.gAW.mLiveInfo.room_id + "", this.gAW.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bSN() {
        if (!this.gBf && this.gAV.getVisibility() != 0) {
            this.gBf = true;
            this.gBa = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.gBa.setDuration(200L);
            this.gBa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAU.setScaleX(1.0f);
                    b.this.gAU.setScaleY(1.0f);
                    b.this.gAU.setAlpha(1.0f);
                    b.this.gBf = false;
                    if (b.this.gBh) {
                        b.this.gAU.setVisibility(0);
                        b.this.gAV.setVisibility(4);
                        return;
                    }
                    b.this.gAU.setVisibility(8);
                    b.this.gAV.setVisibility(0);
                    if (b.this.gBi) {
                        b.this.bSQ();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gBb = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.gBb.setDuration(800L);
            this.gBb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAV.startAnimation(b.this.gBa);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.gBc = new AnimationSet(true);
            this.gBc.addAnimation(aVar);
            this.gBc.addAnimation(alphaAnimation);
            this.gBc.setDuration(1000L);
            this.gBc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.gAV.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAV.startAnimation(b.this.gBb);
                    b.this.gAU.setVisibility(8);
                    b.this.gAU.setScaleX(1.0f);
                    b.this.gAU.setScaleY(1.0f);
                    b.this.gAU.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.gBd = new AnimationSet(true);
            this.gBd.addAnimation(aVar2);
            this.gBd.addAnimation(alphaAnimation2);
            this.gBd.setDuration(1000L);
            this.gBe = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.gBe.setDuration(200L);
            this.gBe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gAU.setScaleX(0.9f);
                    b.this.gAU.setScaleY(0.9f);
                    b.this.gAU.startAnimation(b.this.gBd);
                    b.this.gAV.startAnimation(b.this.gBc);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gAU.startAnimation(this.gBe);
        }
    }

    public void bSM() {
        this.gBh = true;
        this.gBf = false;
        this.gAU.setScaleX(1.0f);
        this.gAU.setScaleY(1.0f);
        this.gAU.setAlpha(1.0f);
        this.gAU.setVisibility(0);
        if (this.gBi) {
            this.gAV.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void eh(long j) {
        if (j > this.gBj) {
            this.gBj = j;
            this.fDx.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(r rVar, final boolean z, final String str) {
        boolean z2;
        if (this.gAW == null || this.gAW.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (rVar == null || rVar.mLiveInfo == null) ? true : this.gAW.mLiveInfo.live_id == rVar.mLiveInfo.live_id;
        }
        this.gAW = rVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.gAW != null && this.gAW.aDE != null) {
            this.gAT.stopLoad();
            this.gAT.startLoad(this.gAW.aDE.portrait, 12, false, false);
            String str2 = this.gAW.aDE.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dTQ.setText(str2);
            if (z2 || rVar.aDE.charmCount > this.gBj) {
                this.gBj = rVar.aDE.charmCount;
                this.fDx.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.gBj)));
            }
            this.gAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bSO();
                    if (!z && b.this.gAW != null && b.this.gAW.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.gAW.mLiveInfo.live_id + "", b.this.gAW.mLiveInfo.room_id + "", b.this.gAW.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSO() {
        Fs(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs(String str) {
        if (this.mContext != null && this.gAW != null && this.gAW.aDE != null && this.gAW.mLiveInfo != null) {
            long j = this.gAW.aDE.userId;
            long j2 = this.gAW.mLiveInfo.live_id;
            long j3 = this.gAW.mLiveInfo.room_id;
            String str2 = this.gAW.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aXW);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bSP() {
        if (this.gAY != null) {
            this.gAY.removeAllListeners();
            this.gAY.cancel();
            this.gAY = null;
        }
    }

    public void onDestroy() {
        bSP();
        if (this.fZy != null) {
            MessageManager.getInstance().unRegisterListener(this.fZy);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.gBg.clear();
    }

    private void cancelAnimation() {
        if (this.gBe != null) {
            this.gBe.cancel();
        }
        if (this.gBd != null) {
            this.gBd.cancel();
        }
        if (this.gBc != null) {
            this.gBc.cancel();
        }
        if (this.gBb != null) {
            this.gBb.cancel();
        }
        if (this.gBa != null) {
            this.gBa.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gmS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSQ() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void mn(boolean z) {
        this.aXW = z;
    }
}
