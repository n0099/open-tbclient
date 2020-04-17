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
import com.baidu.live.data.n;
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
    private TextView cAX;
    private TextView eOM;
    private TextView fHW;
    private ImageView fHX;
    private n fHY;
    private AnimatorSet fIa;
    private ScaleAnimation fIc;
    private ScaleAnimation fId;
    private AnimationSet fIe;
    private AnimationSet fIf;
    private ScaleAnimation fIg;
    private HeadImageView fvE;
    private com.baidu.tieba.ala.liveroom.operation.b fwA;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fHZ = 30000;
    private boolean fIh = false;
    private boolean aIU = false;
    private Set<Long> fIi = new HashSet();
    private boolean fIj = true;
    private boolean fIk = false;
    private long fIl = 0;
    CustomMessageListener fiX = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Ad((String) customResponsedMessage.getData());
            } else {
                b.this.bwy();
            }
        }
    };
    private Set<Long> fIb = new HashSet();

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
        this.fHW = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.fvE = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.cAX = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.eOM = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fHX = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.fvE.setIsRound(true);
        this.fvE.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fvE.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fHW.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fHW.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fHW.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.fHW.setOnClickListener(onClickListener);
    }

    public void kz(boolean z) {
        this.fIj = false;
        if (!this.fIk) {
            this.fHW.setVisibility(8);
            return;
        }
        if (!z) {
            this.fHW.setVisibility(8);
            this.fHX.setVisibility(0);
        } else {
            bwx();
        }
        if (!this.isHost && this.fHY != null && this.fHY.mLiveInfo != null && this.fHY.aqe != null) {
            long j = this.fHY.aqe.userId;
            if (!this.fIi.contains(Long.valueOf(j))) {
                this.fIi.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fHY.mLiveInfo.live_id + "", this.fHY.mLiveInfo.room_id + "", this.fHY.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bwx() {
        if (!this.fIh && this.fHX.getVisibility() != 0) {
            this.fIh = true;
            this.fIc = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fIc.setDuration(200L);
            this.fIc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fHW.setScaleX(1.0f);
                    b.this.fHW.setScaleY(1.0f);
                    b.this.fHW.setAlpha(1.0f);
                    b.this.fIh = false;
                    if (b.this.fIj) {
                        b.this.fHW.setVisibility(0);
                        b.this.fHX.setVisibility(4);
                        return;
                    }
                    b.this.fHW.setVisibility(8);
                    b.this.fHX.setVisibility(0);
                    if (b.this.fIk) {
                        b.this.bwA();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fId = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fId.setDuration(800L);
            this.fId.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fHX.startAnimation(b.this.fIc);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fIe = new AnimationSet(true);
            this.fIe.addAnimation(aVar);
            this.fIe.addAnimation(alphaAnimation);
            this.fIe.setDuration(1000L);
            this.fIe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fHX.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fHX.startAnimation(b.this.fId);
                    b.this.fHW.setVisibility(8);
                    b.this.fHW.setScaleX(1.0f);
                    b.this.fHW.setScaleY(1.0f);
                    b.this.fHW.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fIf = new AnimationSet(true);
            this.fIf.addAnimation(aVar2);
            this.fIf.addAnimation(alphaAnimation2);
            this.fIf.setDuration(1000L);
            this.fIg = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fIg.setDuration(200L);
            this.fIg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fHW.setScaleX(0.9f);
                    b.this.fHW.setScaleY(0.9f);
                    b.this.fHW.startAnimation(b.this.fIf);
                    b.this.fHX.startAnimation(b.this.fIe);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fHW.startAnimation(this.fIg);
        }
    }

    public void bww() {
        this.fIj = true;
        this.fIh = false;
        this.fHW.setScaleX(1.0f);
        this.fHW.setScaleY(1.0f);
        this.fHW.setAlpha(1.0f);
        this.fHW.setVisibility(0);
        if (this.fIk) {
            this.fHX.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void dE(long j) {
        if (j > this.fIl) {
            this.fIl = j;
            this.eOM.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(n nVar, final boolean z, final String str) {
        boolean z2;
        if (this.fHY == null || this.fHY.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (nVar == null || nVar.mLiveInfo == null) ? true : this.fHY.mLiveInfo.live_id == nVar.mLiveInfo.live_id;
        }
        this.fHY = nVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fHY != null && this.fHY.aqe != null) {
            this.fvE.stopLoad();
            this.fvE.startLoad(this.fHY.aqe.portrait, 12, false, false);
            String str2 = this.fHY.aqe.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.cAX.setText(str2);
            if (z2 || nVar.aqe.charmCount > this.fIl) {
                this.fIl = nVar.aqe.charmCount;
                this.eOM.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fIl)));
            }
            this.fHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bwy();
                    if (!z && b.this.fHY != null && b.this.fHY.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fHY.mLiveInfo.live_id + "", b.this.fHY.mLiveInfo.room_id + "", b.this.fHY.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwy() {
        Ad(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ad(String str) {
        if (this.mContext != null && this.fHY != null && this.fHY.aqe != null && this.fHY.mLiveInfo != null) {
            long j = this.fHY.aqe.userId;
            long j2 = this.fHY.mLiveInfo.live_id;
            long j3 = this.fHY.mLiveInfo.room_id;
            String str2 = this.fHY.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aIU);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bwz() {
        if (this.fIa != null) {
            this.fIa.removeAllListeners();
            this.fIa.cancel();
            this.fIa = null;
        }
    }

    public void onDestroy() {
        bwz();
        if (this.fiX != null) {
            MessageManager.getInstance().unRegisterListener(this.fiX);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fIi.clear();
    }

    private void cancelAnimation() {
        if (this.fIg != null) {
            this.fIg.cancel();
        }
        if (this.fIf != null) {
            this.fIf.cancel();
        }
        if (this.fIe != null) {
            this.fIe.cancel();
        }
        if (this.fId != null) {
            this.fId.cancel();
        }
        if (this.fIc != null) {
            this.fIc.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fwA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwA() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void kA(boolean z) {
        this.aIU = z;
    }
}
