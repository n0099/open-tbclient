package com.baidu.tieba.ala.liveroom.l;

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
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {
    private TextView dXU;
    private HeadImageView fJG;
    private com.baidu.tieba.ala.liveroom.operation.b fKC;
    private TextView fVX;
    private ImageView fVY;
    private q fVZ;
    private AnimatorSet fWb;
    private ScaleAnimation fWd;
    private ScaleAnimation fWe;
    private AnimationSet fWf;
    private AnimationSet fWg;
    private ScaleAnimation fWh;
    private TextView fby;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fWa = 30000;
    private boolean fWi = false;
    private boolean aOJ = false;
    private Set<Long> fWj = new HashSet();
    private boolean fWk = true;
    private boolean fWl = false;
    private long fWm = 0;
    CustomMessageListener fwJ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.BN((String) customResponsedMessage.getData());
            } else {
                b.this.bCw();
            }
        }
    };
    private Set<Long> fWc = new HashSet();

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
        this.fVX = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.fJG = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dXU = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fby = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fVY = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.fJG.setIsRound(true);
        this.fJG.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fJG.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fVX.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.fVX.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVX.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fVX.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.fVX.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.fVX.setOnClickListener(onClickListener);
    }

    public void kU(boolean z) {
        this.fWk = false;
        if (!this.fWl) {
            this.fVX.setVisibility(8);
            return;
        }
        if (!z) {
            this.fVX.setVisibility(8);
            this.fVY.setVisibility(0);
        } else {
            bCv();
        }
        if (!this.isHost && this.fVZ != null && this.fVZ.mLiveInfo != null && this.fVZ.avj != null) {
            long j = this.fVZ.avj.userId;
            if (!this.fWj.contains(Long.valueOf(j))) {
                this.fWj.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fVZ.mLiveInfo.live_id + "", this.fVZ.mLiveInfo.room_id + "", this.fVZ.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bCv() {
        if (!this.fWi && this.fVY.getVisibility() != 0) {
            this.fWi = true;
            this.fWd = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fWd.setDuration(200L);
            this.fWd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fVX.setScaleX(1.0f);
                    b.this.fVX.setScaleY(1.0f);
                    b.this.fVX.setAlpha(1.0f);
                    b.this.fWi = false;
                    if (b.this.fWk) {
                        b.this.fVX.setVisibility(0);
                        b.this.fVY.setVisibility(4);
                        return;
                    }
                    b.this.fVX.setVisibility(8);
                    b.this.fVY.setVisibility(0);
                    if (b.this.fWl) {
                        b.this.bCy();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fWe = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fWe.setDuration(800L);
            this.fWe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fVY.startAnimation(b.this.fWd);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fWf = new AnimationSet(true);
            this.fWf.addAnimation(aVar);
            this.fWf.addAnimation(alphaAnimation);
            this.fWf.setDuration(1000L);
            this.fWf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fVY.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fVY.startAnimation(b.this.fWe);
                    b.this.fVX.setVisibility(8);
                    b.this.fVX.setScaleX(1.0f);
                    b.this.fVX.setScaleY(1.0f);
                    b.this.fVX.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fWg = new AnimationSet(true);
            this.fWg.addAnimation(aVar2);
            this.fWg.addAnimation(alphaAnimation2);
            this.fWg.setDuration(1000L);
            this.fWh = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fWh.setDuration(200L);
            this.fWh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fVX.setScaleX(0.9f);
                    b.this.fVX.setScaleY(0.9f);
                    b.this.fVX.startAnimation(b.this.fWg);
                    b.this.fVY.startAnimation(b.this.fWf);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fVX.startAnimation(this.fWh);
        }
    }

    public void bCu() {
        this.fWk = true;
        this.fWi = false;
        this.fVX.setScaleX(1.0f);
        this.fVX.setScaleY(1.0f);
        this.fVX.setAlpha(1.0f);
        this.fVX.setVisibility(0);
        if (this.fWl) {
            this.fVY.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void dF(long j) {
        if (j > this.fWm) {
            this.fWm = j;
            this.fby.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(q qVar, final boolean z, final String str) {
        boolean z2;
        if (this.fVZ == null || this.fVZ.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (qVar == null || qVar.mLiveInfo == null) ? true : this.fVZ.mLiveInfo.live_id == qVar.mLiveInfo.live_id;
        }
        this.fVZ = qVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fVZ != null && this.fVZ.avj != null) {
            this.fJG.stopLoad();
            this.fJG.startLoad(this.fVZ.avj.portrait, 12, false, false);
            String str2 = this.fVZ.avj.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dXU.setText(str2);
            if (z2 || qVar.avj.charmCount > this.fWm) {
                this.fWm = qVar.avj.charmCount;
                this.fby.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fWm)));
            }
            this.fVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bCw();
                    if (!z && b.this.fVZ != null && b.this.fVZ.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fVZ.mLiveInfo.live_id + "", b.this.fVZ.mLiveInfo.room_id + "", b.this.fVZ.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCw() {
        BN(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(String str) {
        if (this.mContext != null && this.fVZ != null && this.fVZ.avj != null && this.fVZ.mLiveInfo != null) {
            long j = this.fVZ.avj.userId;
            long j2 = this.fVZ.mLiveInfo.live_id;
            long j3 = this.fVZ.mLiveInfo.room_id;
            String str2 = this.fVZ.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aOJ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bCx() {
        if (this.fWb != null) {
            this.fWb.removeAllListeners();
            this.fWb.cancel();
            this.fWb = null;
        }
    }

    public void onDestroy() {
        bCx();
        if (this.fwJ != null) {
            MessageManager.getInstance().unRegisterListener(this.fwJ);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fWj.clear();
    }

    private void cancelAnimation() {
        if (this.fWh != null) {
            this.fWh.cancel();
        }
        if (this.fWg != null) {
            this.fWg.cancel();
        }
        if (this.fWf != null) {
            this.fWf.cancel();
        }
        if (this.fWe != null) {
            this.fWe.cancel();
        }
        if (this.fWd != null) {
            this.fWd.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fKC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCy() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void kV(boolean z) {
        this.aOJ = z;
    }
}
