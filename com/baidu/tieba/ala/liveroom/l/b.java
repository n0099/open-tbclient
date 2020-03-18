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
    private TextView cbW;
    private HeadImageView eRk;
    private com.baidu.tieba.ala.liveroom.operation.b eSg;
    private TextView elm;
    private TextView fdM;
    private ImageView fdN;
    private m fdO;
    private AnimatorSet fdQ;
    private ScaleAnimation fdS;
    private ScaleAnimation fdT;
    private AnimationSet fdU;
    private AnimationSet fdV;
    private ScaleAnimation fdW;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fdP = 30000;
    private boolean fdX = false;
    private boolean aql = false;
    private Set<Long> fdY = new HashSet();
    private boolean fdZ = true;
    private boolean fea = false;
    private long feb = 0;
    CustomMessageListener eEC = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.yu((String) customResponsedMessage.getData());
            } else {
                b.this.bnh();
            }
        }
    };
    private Set<Long> fdR = new HashSet();

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
        this.fdM = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.eRk = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.cbW = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.elm = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fdN = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.eRk.setIsRound(true);
        this.eRk.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eRk.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fdM.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fdM.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fdM.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.fdM.setOnClickListener(onClickListener);
    }

    public void jy(boolean z) {
        this.fdZ = false;
        if (!this.fea) {
            this.fdM.setVisibility(8);
            return;
        }
        if (!z) {
            this.fdM.setVisibility(8);
            this.fdN.setVisibility(0);
        } else {
            bng();
        }
        if (!this.isHost && this.fdO != null && this.fdO.mLiveInfo != null && this.fdO.Ya != null) {
            long j = this.fdO.Ya.userId;
            if (!this.fdY.contains(Long.valueOf(j))) {
                this.fdY.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fdO.mLiveInfo.live_id + "", this.fdO.mLiveInfo.room_id + "", this.fdO.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bng() {
        if (!this.fdX && this.fdN.getVisibility() != 0) {
            this.fdX = true;
            this.fdS = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fdS.setDuration(200L);
            this.fdS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdM.setScaleX(1.0f);
                    b.this.fdM.setScaleY(1.0f);
                    b.this.fdM.setAlpha(1.0f);
                    b.this.fdX = false;
                    if (b.this.fdZ) {
                        b.this.fdM.setVisibility(0);
                        b.this.fdN.setVisibility(4);
                        return;
                    }
                    b.this.fdM.setVisibility(8);
                    b.this.fdN.setVisibility(0);
                    if (b.this.fea) {
                        b.this.bnj();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdT = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fdT.setDuration(800L);
            this.fdT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdN.startAnimation(b.this.fdS);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fdU = new AnimationSet(true);
            this.fdU.addAnimation(aVar);
            this.fdU.addAnimation(alphaAnimation);
            this.fdU.setDuration(1000L);
            this.fdU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fdN.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdN.startAnimation(b.this.fdT);
                    b.this.fdM.setVisibility(8);
                    b.this.fdM.setScaleX(1.0f);
                    b.this.fdM.setScaleY(1.0f);
                    b.this.fdM.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fdV = new AnimationSet(true);
            this.fdV.addAnimation(aVar2);
            this.fdV.addAnimation(alphaAnimation2);
            this.fdV.setDuration(1000L);
            this.fdW = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fdW.setDuration(200L);
            this.fdW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdM.setScaleX(0.9f);
                    b.this.fdM.setScaleY(0.9f);
                    b.this.fdM.startAnimation(b.this.fdV);
                    b.this.fdN.startAnimation(b.this.fdU);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdM.startAnimation(this.fdW);
        }
    }

    public void bnf() {
        this.fdZ = true;
        this.fdX = false;
        this.fdM.setScaleX(1.0f);
        this.fdM.setScaleY(1.0f);
        this.fdM.setAlpha(1.0f);
        this.fdM.setVisibility(0);
        if (this.fea) {
            this.fdN.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void cW(long j) {
        if (j > this.feb) {
            this.feb = j;
            this.elm.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(m mVar, final boolean z, final String str) {
        boolean z2;
        if (this.fdO == null || this.fdO.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (mVar == null || mVar.mLiveInfo == null) ? true : this.fdO.mLiveInfo.live_id == mVar.mLiveInfo.live_id;
        }
        this.fdO = mVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fdO != null && this.fdO.Ya != null) {
            this.eRk.stopLoad();
            this.eRk.startLoad(this.fdO.Ya.portrait, 12, false, false);
            String str2 = this.fdO.Ya.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.cbW.setText(str2);
            if (z2 || mVar.Ya.charmCount > this.feb) {
                this.feb = mVar.Ya.charmCount;
                this.elm.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.feb)));
            }
            this.fdN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bnh();
                    if (!z && b.this.fdO != null && b.this.fdO.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fdO.mLiveInfo.live_id + "", b.this.fdO.mLiveInfo.room_id + "", b.this.fdO.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnh() {
        yu(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(String str) {
        if (this.mContext != null && this.fdO != null && this.fdO.Ya != null && this.fdO.mLiveInfo != null) {
            long j = this.fdO.Ya.userId;
            long j2 = this.fdO.mLiveInfo.live_id;
            long j3 = this.fdO.mLiveInfo.room_id;
            String str2 = this.fdO.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aql);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bni() {
        if (this.fdQ != null) {
            this.fdQ.removeAllListeners();
            this.fdQ.cancel();
            this.fdQ = null;
        }
    }

    public void onDestroy() {
        bni();
        if (this.eEC != null) {
            MessageManager.getInstance().unRegisterListener(this.eEC);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fdY.clear();
    }

    private void cancelAnimation() {
        if (this.fdW != null) {
            this.fdW.cancel();
        }
        if (this.fdV != null) {
            this.fdV.cancel();
        }
        if (this.fdU != null) {
            this.fdU.cancel();
        }
        if (this.fdT != null) {
            this.fdT.cancel();
        }
        if (this.fdS != null) {
            this.fdS.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eSg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnj() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void jz(boolean z) {
        this.aql = z;
    }
}
