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
    private HeadImageView fJR;
    private com.baidu.tieba.ala.liveroom.operation.b fKN;
    private TextView fWi;
    private ImageView fWj;
    private q fWk;
    private AnimatorSet fWm;
    private ScaleAnimation fWo;
    private ScaleAnimation fWp;
    private AnimationSet fWq;
    private AnimationSet fWr;
    private ScaleAnimation fWs;
    private TextView fbJ;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fWl = 30000;
    private boolean fWt = false;
    private boolean aOJ = false;
    private Set<Long> fWu = new HashSet();
    private boolean fWv = true;
    private boolean fWw = false;
    private long fWx = 0;
    CustomMessageListener fwU = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.BN((String) customResponsedMessage.getData());
            } else {
                b.this.bCy();
            }
        }
    };
    private Set<Long> fWn = new HashSet();

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
        this.fWi = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.fJR = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dXU = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fbJ = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fWj = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.fJR.setIsRound(true);
        this.fJR.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fJR.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fWi.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.fWi.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fWi.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fWi.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.fWi.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.fWi.setOnClickListener(onClickListener);
    }

    public void kU(boolean z) {
        this.fWv = false;
        if (!this.fWw) {
            this.fWi.setVisibility(8);
            return;
        }
        if (!z) {
            this.fWi.setVisibility(8);
            this.fWj.setVisibility(0);
        } else {
            bCx();
        }
        if (!this.isHost && this.fWk != null && this.fWk.mLiveInfo != null && this.fWk.avj != null) {
            long j = this.fWk.avj.userId;
            if (!this.fWu.contains(Long.valueOf(j))) {
                this.fWu.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fWk.mLiveInfo.live_id + "", this.fWk.mLiveInfo.room_id + "", this.fWk.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bCx() {
        if (!this.fWt && this.fWj.getVisibility() != 0) {
            this.fWt = true;
            this.fWo = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fWo.setDuration(200L);
            this.fWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fWi.setScaleX(1.0f);
                    b.this.fWi.setScaleY(1.0f);
                    b.this.fWi.setAlpha(1.0f);
                    b.this.fWt = false;
                    if (b.this.fWv) {
                        b.this.fWi.setVisibility(0);
                        b.this.fWj.setVisibility(4);
                        return;
                    }
                    b.this.fWi.setVisibility(8);
                    b.this.fWj.setVisibility(0);
                    if (b.this.fWw) {
                        b.this.bCA();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fWp = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fWp.setDuration(800L);
            this.fWp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fWj.startAnimation(b.this.fWo);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fWq = new AnimationSet(true);
            this.fWq.addAnimation(aVar);
            this.fWq.addAnimation(alphaAnimation);
            this.fWq.setDuration(1000L);
            this.fWq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fWj.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fWj.startAnimation(b.this.fWp);
                    b.this.fWi.setVisibility(8);
                    b.this.fWi.setScaleX(1.0f);
                    b.this.fWi.setScaleY(1.0f);
                    b.this.fWi.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fWr = new AnimationSet(true);
            this.fWr.addAnimation(aVar2);
            this.fWr.addAnimation(alphaAnimation2);
            this.fWr.setDuration(1000L);
            this.fWs = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fWs.setDuration(200L);
            this.fWs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fWi.setScaleX(0.9f);
                    b.this.fWi.setScaleY(0.9f);
                    b.this.fWi.startAnimation(b.this.fWr);
                    b.this.fWj.startAnimation(b.this.fWq);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fWi.startAnimation(this.fWs);
        }
    }

    public void bCw() {
        this.fWv = true;
        this.fWt = false;
        this.fWi.setScaleX(1.0f);
        this.fWi.setScaleY(1.0f);
        this.fWi.setAlpha(1.0f);
        this.fWi.setVisibility(0);
        if (this.fWw) {
            this.fWj.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void dF(long j) {
        if (j > this.fWx) {
            this.fWx = j;
            this.fbJ.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(q qVar, final boolean z, final String str) {
        boolean z2;
        if (this.fWk == null || this.fWk.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (qVar == null || qVar.mLiveInfo == null) ? true : this.fWk.mLiveInfo.live_id == qVar.mLiveInfo.live_id;
        }
        this.fWk = qVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fWk != null && this.fWk.avj != null) {
            this.fJR.stopLoad();
            this.fJR.startLoad(this.fWk.avj.portrait, 12, false, false);
            String str2 = this.fWk.avj.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dXU.setText(str2);
            if (z2 || qVar.avj.charmCount > this.fWx) {
                this.fWx = qVar.avj.charmCount;
                this.fbJ.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fWx)));
            }
            this.fWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bCy();
                    if (!z && b.this.fWk != null && b.this.fWk.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fWk.mLiveInfo.live_id + "", b.this.fWk.mLiveInfo.room_id + "", b.this.fWk.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCy() {
        BN(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(String str) {
        if (this.mContext != null && this.fWk != null && this.fWk.avj != null && this.fWk.mLiveInfo != null) {
            long j = this.fWk.avj.userId;
            long j2 = this.fWk.mLiveInfo.live_id;
            long j3 = this.fWk.mLiveInfo.room_id;
            String str2 = this.fWk.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aOJ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bCz() {
        if (this.fWm != null) {
            this.fWm.removeAllListeners();
            this.fWm.cancel();
            this.fWm = null;
        }
    }

    public void onDestroy() {
        bCz();
        if (this.fwU != null) {
            MessageManager.getInstance().unRegisterListener(this.fwU);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fWu.clear();
    }

    private void cancelAnimation() {
        if (this.fWs != null) {
            this.fWs.cancel();
        }
        if (this.fWr != null) {
            this.fWr.cancel();
        }
        if (this.fWq != null) {
            this.fWq.cancel();
        }
        if (this.fWp != null) {
            this.fWp.cancel();
        }
        if (this.fWo != null) {
            this.fWo.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fKN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCA() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void kV(boolean z) {
        this.aOJ = z;
    }
}
