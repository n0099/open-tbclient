package com.baidu.tieba.ala.liveroom.n;

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
/* loaded from: classes4.dex */
public class b {
    private TextView dKI;
    private TextView fsd;
    private com.baidu.tieba.ala.liveroom.operation.b gaQ;
    private HeadImageView god;
    private TextView goe;
    private ImageView gof;
    private q gog;
    private AnimatorSet goi;
    private ScaleAnimation gok;
    private ScaleAnimation gol;
    private AnimationSet gom;
    private AnimationSet gon;
    private ScaleAnimation goo;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int goh = 30000;
    private boolean gop = false;
    private boolean aSI = false;
    private Set<Long> goq = new HashSet();
    private boolean gor = true;
    private boolean gos = false;
    private long got = 0;
    CustomMessageListener fNA = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.n.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.CX((String) customResponsedMessage.getData());
            } else {
                b.this.bIN();
            }
        }
    };
    private Set<Long> goj = new HashSet();

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
        this.goe = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.god = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dKI = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fsd = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.gof = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.god.setIsRound(true);
        this.god.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.god.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.goe.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.goe.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.goe.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.goe.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.goe.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.goe.setOnClickListener(onClickListener);
    }

    public void lI(boolean z) {
        this.gor = false;
        if (!this.gos) {
            this.goe.setVisibility(8);
            return;
        }
        if (!z) {
            this.goe.setVisibility(8);
            this.gof.setVisibility(0);
        } else {
            bIM();
        }
        if (!this.isHost && this.gog != null && this.gog.mLiveInfo != null && this.gog.ayC != null) {
            long j = this.gog.ayC.userId;
            if (!this.goq.contains(Long.valueOf(j))) {
                this.goq.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.gog.mLiveInfo.live_id + "", this.gog.mLiveInfo.room_id + "", this.gog.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bIM() {
        if (!this.gop && this.gof.getVisibility() != 0) {
            this.gop = true;
            this.gok = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.gok.setDuration(200L);
            this.gok.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.goe.setScaleX(1.0f);
                    b.this.goe.setScaleY(1.0f);
                    b.this.goe.setAlpha(1.0f);
                    b.this.gop = false;
                    if (b.this.gor) {
                        b.this.goe.setVisibility(0);
                        b.this.gof.setVisibility(4);
                        return;
                    }
                    b.this.goe.setVisibility(8);
                    b.this.gof.setVisibility(0);
                    if (b.this.gos) {
                        b.this.bIP();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.gol = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.gol.setDuration(800L);
            this.gol.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gof.startAnimation(b.this.gok);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.gom = new AnimationSet(true);
            this.gom.addAnimation(aVar);
            this.gom.addAnimation(alphaAnimation);
            this.gom.setDuration(1000L);
            this.gom.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.gof.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.gof.startAnimation(b.this.gol);
                    b.this.goe.setVisibility(8);
                    b.this.goe.setScaleX(1.0f);
                    b.this.goe.setScaleY(1.0f);
                    b.this.goe.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.gon = new AnimationSet(true);
            this.gon.addAnimation(aVar2);
            this.gon.addAnimation(alphaAnimation2);
            this.gon.setDuration(1000L);
            this.goo = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.goo.setDuration(200L);
            this.goo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.goe.setScaleX(0.9f);
                    b.this.goe.setScaleY(0.9f);
                    b.this.goe.startAnimation(b.this.gon);
                    b.this.gof.startAnimation(b.this.gom);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.goe.startAnimation(this.goo);
        }
    }

    public void bIL() {
        this.gor = true;
        this.gop = false;
        this.goe.setScaleX(1.0f);
        this.goe.setScaleY(1.0f);
        this.goe.setAlpha(1.0f);
        this.goe.setVisibility(0);
        if (this.gos) {
            this.gof.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void dW(long j) {
        if (j > this.got) {
            this.got = j;
            this.fsd.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(q qVar, final boolean z, final String str) {
        boolean z2;
        if (this.gog == null || this.gog.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (qVar == null || qVar.mLiveInfo == null) ? true : this.gog.mLiveInfo.live_id == qVar.mLiveInfo.live_id;
        }
        this.gog = qVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.gog != null && this.gog.ayC != null) {
            this.god.stopLoad();
            this.god.startLoad(this.gog.ayC.portrait, 12, false, false);
            String str2 = this.gog.ayC.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dKI.setText(str2);
            if (z2 || qVar.ayC.charmCount > this.got) {
                this.got = qVar.ayC.charmCount;
                this.fsd.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.got)));
            }
            this.gof.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bIN();
                    if (!z && b.this.gog != null && b.this.gog.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.gog.mLiveInfo.live_id + "", b.this.gog.mLiveInfo.room_id + "", b.this.gog.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIN() {
        CX(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CX(String str) {
        if (this.mContext != null && this.gog != null && this.gog.ayC != null && this.gog.mLiveInfo != null) {
            long j = this.gog.ayC.userId;
            long j2 = this.gog.mLiveInfo.live_id;
            long j3 = this.gog.mLiveInfo.room_id;
            String str2 = this.gog.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aSI);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bIO() {
        if (this.goi != null) {
            this.goi.removeAllListeners();
            this.goi.cancel();
            this.goi = null;
        }
    }

    public void onDestroy() {
        bIO();
        if (this.fNA != null) {
            MessageManager.getInstance().unRegisterListener(this.fNA);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.goq.clear();
    }

    private void cancelAnimation() {
        if (this.goo != null) {
            this.goo.cancel();
        }
        if (this.gon != null) {
            this.gon.cancel();
        }
        if (this.gom != null) {
            this.gom.cancel();
        }
        if (this.gol != null) {
            this.gol.cancel();
        }
        if (this.gok != null) {
            this.gok.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gaQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIP() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void lJ(boolean z) {
        this.aSI = z;
    }
}
