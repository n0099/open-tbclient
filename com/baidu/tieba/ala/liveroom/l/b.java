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
import com.baidu.live.data.m;
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
    private TextView cbL;
    private HeadImageView eQM;
    private com.baidu.tieba.ala.liveroom.operation.b eRI;
    private TextView ekW;
    private TextView fdo;
    private ImageView fdp;
    private m fdq;
    private AnimatorSet fds;
    private ScaleAnimation fdu;
    private ScaleAnimation fdv;
    private AnimationSet fdw;
    private AnimationSet fdx;
    private ScaleAnimation fdy;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fdr = 30000;
    private boolean fdz = false;
    private boolean aqb = false;
    private Set<Long> fdA = new HashSet();
    private boolean fdB = true;
    private boolean fdC = false;
    private long fdD = 0;
    CustomMessageListener eEg = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.yu((String) customResponsedMessage.getData());
            } else {
                b.this.bnc();
            }
        }
    };
    private Set<Long> fdt = new HashSet();

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
        this.fdo = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.eQM = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.cbL = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.ekW = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fdp = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.eQM.setIsRound(true);
        this.eQM.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eQM.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fdo.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fdo.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fdo.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.fdo.setOnClickListener(onClickListener);
    }

    public void jw(boolean z) {
        this.fdB = false;
        if (!this.fdC) {
            this.fdo.setVisibility(8);
            return;
        }
        if (!z) {
            this.fdo.setVisibility(8);
            this.fdp.setVisibility(0);
        } else {
            bnb();
        }
        if (!this.isHost && this.fdq != null && this.fdq.mLiveInfo != null && this.fdq.XQ != null) {
            long j = this.fdq.XQ.userId;
            if (!this.fdA.contains(Long.valueOf(j))) {
                this.fdA.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fdq.mLiveInfo.live_id + "", this.fdq.mLiveInfo.room_id + "", this.fdq.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bnb() {
        if (!this.fdz && this.fdp.getVisibility() != 0) {
            this.fdz = true;
            this.fdu = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fdu.setDuration(200L);
            this.fdu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdo.setScaleX(1.0f);
                    b.this.fdo.setScaleY(1.0f);
                    b.this.fdo.setAlpha(1.0f);
                    b.this.fdz = false;
                    if (b.this.fdB) {
                        b.this.fdo.setVisibility(0);
                        b.this.fdp.setVisibility(4);
                        return;
                    }
                    b.this.fdo.setVisibility(8);
                    b.this.fdp.setVisibility(0);
                    if (b.this.fdC) {
                        b.this.bne();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdv = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fdv.setDuration(800L);
            this.fdv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdp.startAnimation(b.this.fdu);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fdw = new AnimationSet(true);
            this.fdw.addAnimation(aVar);
            this.fdw.addAnimation(alphaAnimation);
            this.fdw.setDuration(1000L);
            this.fdw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fdp.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdp.startAnimation(b.this.fdv);
                    b.this.fdo.setVisibility(8);
                    b.this.fdo.setScaleX(1.0f);
                    b.this.fdo.setScaleY(1.0f);
                    b.this.fdo.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fdx = new AnimationSet(true);
            this.fdx.addAnimation(aVar2);
            this.fdx.addAnimation(alphaAnimation2);
            this.fdx.setDuration(1000L);
            this.fdy = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fdy.setDuration(200L);
            this.fdy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdo.setScaleX(0.9f);
                    b.this.fdo.setScaleY(0.9f);
                    b.this.fdo.startAnimation(b.this.fdx);
                    b.this.fdp.startAnimation(b.this.fdw);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdo.startAnimation(this.fdy);
        }
    }

    public void bna() {
        this.fdB = true;
        this.fdz = false;
        this.fdo.setScaleX(1.0f);
        this.fdo.setScaleY(1.0f);
        this.fdo.setAlpha(1.0f);
        this.fdo.setVisibility(0);
        if (this.fdC) {
            this.fdp.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void cW(long j) {
        if (j > this.fdD) {
            this.fdD = j;
            this.ekW.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(m mVar, final boolean z, final String str) {
        boolean z2;
        if (this.fdq == null || this.fdq.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (mVar == null || mVar.mLiveInfo == null) ? true : this.fdq.mLiveInfo.live_id == mVar.mLiveInfo.live_id;
        }
        this.fdq = mVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fdq != null && this.fdq.XQ != null) {
            this.eQM.stopLoad();
            this.eQM.startLoad(this.fdq.XQ.portrait, 12, false, false);
            String str2 = this.fdq.XQ.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.cbL.setText(str2);
            if (z2 || mVar.XQ.charmCount > this.fdD) {
                this.fdD = mVar.XQ.charmCount;
                this.ekW.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fdD)));
            }
            this.fdp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bnc();
                    if (!z && b.this.fdq != null && b.this.fdq.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fdq.mLiveInfo.live_id + "", b.this.fdq.mLiveInfo.room_id + "", b.this.fdq.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnc() {
        yu(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(String str) {
        if (this.mContext != null && this.fdq != null && this.fdq.XQ != null && this.fdq.mLiveInfo != null) {
            long j = this.fdq.XQ.userId;
            long j2 = this.fdq.mLiveInfo.live_id;
            long j3 = this.fdq.mLiveInfo.room_id;
            String str2 = this.fdq.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aqb);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bnd() {
        if (this.fds != null) {
            this.fds.removeAllListeners();
            this.fds.cancel();
            this.fds = null;
        }
    }

    public void onDestroy() {
        bnd();
        if (this.eEg != null) {
            MessageManager.getInstance().unRegisterListener(this.eEg);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fdA.clear();
    }

    private void cancelAnimation() {
        if (this.fdy != null) {
            this.fdy.cancel();
        }
        if (this.fdx != null) {
            this.fdx.cancel();
        }
        if (this.fdw != null) {
            this.fdw.cancel();
        }
        if (this.fdv != null) {
            this.fdv.cancel();
        }
        if (this.fdu != null) {
            this.fdu.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eRI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bne() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void jx(boolean z) {
        this.aqb = z;
    }
}
