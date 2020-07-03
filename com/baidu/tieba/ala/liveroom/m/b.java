package com.baidu.tieba.ala.liveroom.m;

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
/* loaded from: classes3.dex */
public class b {
    private TextView dEL;
    private HeadImageView fUR;
    private com.baidu.tieba.ala.liveroom.operation.b fVL;
    private TextView fmT;
    private TextView gjf;
    private ImageView gjg;
    private q gjh;
    private AnimatorSet gjj;
    private ScaleAnimation gjl;
    private ScaleAnimation gjm;
    private AnimationSet gjn;
    private AnimationSet gjo;
    private ScaleAnimation gjp;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int gji = 30000;
    private boolean gjq = false;
    private boolean aRp = false;
    private Set<Long> gjr = new HashSet();
    private boolean gjs = true;
    private boolean gjt = false;
    private long gju = 0;
    CustomMessageListener fIf = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.m.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Cl((String) customResponsedMessage.getData());
            } else {
                b.this.bFE();
            }
        }
    };
    private Set<Long> gjk = new HashSet();

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
        this.gjf = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.fUR = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dEL = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fmT = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.gjg = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.fUR.setIsRound(true);
        this.fUR.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fUR.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gjf.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.gjf.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gjf.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.gjf.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.gjf.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.gjf.setOnClickListener(onClickListener);
    }

    public void lf(boolean z) {
        this.gjs = false;
        if (!this.gjt) {
            this.gjf.setVisibility(8);
            return;
        }
        if (!z) {
            this.gjf.setVisibility(8);
            this.gjg.setVisibility(0);
        } else {
            bFD();
        }
        if (!this.isHost && this.gjh != null && this.gjh.mLiveInfo != null && this.gjh.axp != null) {
            long j = this.gjh.axp.userId;
            if (!this.gjr.contains(Long.valueOf(j))) {
                this.gjr.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.gjh.mLiveInfo.live_id + "", this.gjh.mLiveInfo.room_id + "", this.gjh.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bFD() {
        if (!this.gjq && this.gjg.getVisibility() != 0) {
            this.gjq = true;
            this.gjl = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.gjl.setDuration(200L);
            this.gjl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gjf.setScaleX(1.0f);
                    b.this.gjf.setScaleY(1.0f);
                    b.this.gjf.setAlpha(1.0f);
                    b.this.gjq = false;
                    if (b.this.gjs) {
                        b.this.gjf.setVisibility(0);
                        b.this.gjg.setVisibility(4);
                        return;
                    }
                    b.this.gjf.setVisibility(8);
                    b.this.gjg.setVisibility(0);
                    if (b.this.gjt) {
                        b.this.bFG();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gjm = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.gjm.setDuration(800L);
            this.gjm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gjg.startAnimation(b.this.gjl);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.gjn = new AnimationSet(true);
            this.gjn.addAnimation(aVar);
            this.gjn.addAnimation(alphaAnimation);
            this.gjn.setDuration(1000L);
            this.gjn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.gjg.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gjg.startAnimation(b.this.gjm);
                    b.this.gjf.setVisibility(8);
                    b.this.gjf.setScaleX(1.0f);
                    b.this.gjf.setScaleY(1.0f);
                    b.this.gjf.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.gjo = new AnimationSet(true);
            this.gjo.addAnimation(aVar2);
            this.gjo.addAnimation(alphaAnimation2);
            this.gjo.setDuration(1000L);
            this.gjp = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.gjp.setDuration(200L);
            this.gjp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gjf.setScaleX(0.9f);
                    b.this.gjf.setScaleY(0.9f);
                    b.this.gjf.startAnimation(b.this.gjo);
                    b.this.gjg.startAnimation(b.this.gjn);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gjf.startAnimation(this.gjp);
        }
    }

    public void bFC() {
        this.gjs = true;
        this.gjq = false;
        this.gjf.setScaleX(1.0f);
        this.gjf.setScaleY(1.0f);
        this.gjf.setAlpha(1.0f);
        this.gjf.setVisibility(0);
        if (this.gjt) {
            this.gjg.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void dI(long j) {
        if (j > this.gju) {
            this.gju = j;
            this.fmT.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(q qVar, final boolean z, final String str) {
        boolean z2;
        if (this.gjh == null || this.gjh.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (qVar == null || qVar.mLiveInfo == null) ? true : this.gjh.mLiveInfo.live_id == qVar.mLiveInfo.live_id;
        }
        this.gjh = qVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.gjh != null && this.gjh.axp != null) {
            this.fUR.stopLoad();
            this.fUR.startLoad(this.gjh.axp.portrait, 12, false, false);
            String str2 = this.gjh.axp.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dEL.setText(str2);
            if (z2 || qVar.axp.charmCount > this.gju) {
                this.gju = qVar.axp.charmCount;
                this.fmT.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.gju)));
            }
            this.gjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bFE();
                    if (!z && b.this.gjh != null && b.this.gjh.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.gjh.mLiveInfo.live_id + "", b.this.gjh.mLiveInfo.room_id + "", b.this.gjh.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFE() {
        Cl(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cl(String str) {
        if (this.mContext != null && this.gjh != null && this.gjh.axp != null && this.gjh.mLiveInfo != null) {
            long j = this.gjh.axp.userId;
            long j2 = this.gjh.mLiveInfo.live_id;
            long j3 = this.gjh.mLiveInfo.room_id;
            String str2 = this.gjh.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aRp);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bFF() {
        if (this.gjj != null) {
            this.gjj.removeAllListeners();
            this.gjj.cancel();
            this.gjj = null;
        }
    }

    public void onDestroy() {
        bFF();
        if (this.fIf != null) {
            MessageManager.getInstance().unRegisterListener(this.fIf);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.gjr.clear();
    }

    private void cancelAnimation() {
        if (this.gjp != null) {
            this.gjp.cancel();
        }
        if (this.gjo != null) {
            this.gjo.cancel();
        }
        if (this.gjn != null) {
            this.gjn.cancel();
        }
        if (this.gjm != null) {
            this.gjm.cancel();
        }
        if (this.gjl != null) {
            this.gjl.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fVL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFG() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void lg(boolean z) {
        this.aRp = z;
    }
}
