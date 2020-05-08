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
    private TextView cBd;
    private TextView eOR;
    private TextView fIb;
    private ImageView fIc;
    private n fId;
    private AnimatorSet fIf;
    private ScaleAnimation fIh;
    private ScaleAnimation fIi;
    private AnimationSet fIj;
    private AnimationSet fIk;
    private ScaleAnimation fIl;
    private HeadImageView fvJ;
    private com.baidu.tieba.ala.liveroom.operation.b fwF;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fIe = 30000;
    private boolean fIm = false;
    private boolean aJa = false;
    private Set<Long> fIn = new HashSet();
    private boolean fIo = true;
    private boolean fIp = false;
    private long fIq = 0;
    CustomMessageListener fjc = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Ag((String) customResponsedMessage.getData());
            } else {
                b.this.bww();
            }
        }
    };
    private Set<Long> fIg = new HashSet();

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
        this.fIb = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.fvJ = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.cBd = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.eOR = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fIc = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.fvJ.setIsRound(true);
        this.fvJ.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fvJ.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fIb.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fIb.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fIb.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.fIb.setOnClickListener(onClickListener);
    }

    public void kz(boolean z) {
        this.fIo = false;
        if (!this.fIp) {
            this.fIb.setVisibility(8);
            return;
        }
        if (!z) {
            this.fIb.setVisibility(8);
            this.fIc.setVisibility(0);
        } else {
            bwv();
        }
        if (!this.isHost && this.fId != null && this.fId.mLiveInfo != null && this.fId.aqk != null) {
            long j = this.fId.aqk.userId;
            if (!this.fIn.contains(Long.valueOf(j))) {
                this.fIn.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fId.mLiveInfo.live_id + "", this.fId.mLiveInfo.room_id + "", this.fId.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bwv() {
        if (!this.fIm && this.fIc.getVisibility() != 0) {
            this.fIm = true;
            this.fIh = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fIh.setDuration(200L);
            this.fIh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fIb.setScaleX(1.0f);
                    b.this.fIb.setScaleY(1.0f);
                    b.this.fIb.setAlpha(1.0f);
                    b.this.fIm = false;
                    if (b.this.fIo) {
                        b.this.fIb.setVisibility(0);
                        b.this.fIc.setVisibility(4);
                        return;
                    }
                    b.this.fIb.setVisibility(8);
                    b.this.fIc.setVisibility(0);
                    if (b.this.fIp) {
                        b.this.bwy();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fIi = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fIi.setDuration(800L);
            this.fIi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fIc.startAnimation(b.this.fIh);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fIj = new AnimationSet(true);
            this.fIj.addAnimation(aVar);
            this.fIj.addAnimation(alphaAnimation);
            this.fIj.setDuration(1000L);
            this.fIj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fIc.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fIc.startAnimation(b.this.fIi);
                    b.this.fIb.setVisibility(8);
                    b.this.fIb.setScaleX(1.0f);
                    b.this.fIb.setScaleY(1.0f);
                    b.this.fIb.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fIk = new AnimationSet(true);
            this.fIk.addAnimation(aVar2);
            this.fIk.addAnimation(alphaAnimation2);
            this.fIk.setDuration(1000L);
            this.fIl = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fIl.setDuration(200L);
            this.fIl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fIb.setScaleX(0.9f);
                    b.this.fIb.setScaleY(0.9f);
                    b.this.fIb.startAnimation(b.this.fIk);
                    b.this.fIc.startAnimation(b.this.fIj);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fIb.startAnimation(this.fIl);
        }
    }

    public void bwu() {
        this.fIo = true;
        this.fIm = false;
        this.fIb.setScaleX(1.0f);
        this.fIb.setScaleY(1.0f);
        this.fIb.setAlpha(1.0f);
        this.fIb.setVisibility(0);
        if (this.fIp) {
            this.fIc.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void dE(long j) {
        if (j > this.fIq) {
            this.fIq = j;
            this.eOR.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(n nVar, final boolean z, final String str) {
        boolean z2;
        if (this.fId == null || this.fId.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (nVar == null || nVar.mLiveInfo == null) ? true : this.fId.mLiveInfo.live_id == nVar.mLiveInfo.live_id;
        }
        this.fId = nVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fId != null && this.fId.aqk != null) {
            this.fvJ.stopLoad();
            this.fvJ.startLoad(this.fId.aqk.portrait, 12, false, false);
            String str2 = this.fId.aqk.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.cBd.setText(str2);
            if (z2 || nVar.aqk.charmCount > this.fIq) {
                this.fIq = nVar.aqk.charmCount;
                this.eOR.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fIq)));
            }
            this.fIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bww();
                    if (!z && b.this.fId != null && b.this.fId.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fId.mLiveInfo.live_id + "", b.this.fId.mLiveInfo.room_id + "", b.this.fId.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bww() {
        Ag(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ag(String str) {
        if (this.mContext != null && this.fId != null && this.fId.aqk != null && this.fId.mLiveInfo != null) {
            long j = this.fId.aqk.userId;
            long j2 = this.fId.mLiveInfo.live_id;
            long j3 = this.fId.mLiveInfo.room_id;
            String str2 = this.fId.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aJa);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bwx() {
        if (this.fIf != null) {
            this.fIf.removeAllListeners();
            this.fIf.cancel();
            this.fIf = null;
        }
    }

    public void onDestroy() {
        bwx();
        if (this.fjc != null) {
            MessageManager.getInstance().unRegisterListener(this.fjc);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fIn.clear();
    }

    private void cancelAnimation() {
        if (this.fIl != null) {
            this.fIl.cancel();
        }
        if (this.fIk != null) {
            this.fIk.cancel();
        }
        if (this.fIj != null) {
            this.fIj.cancel();
        }
        if (this.fIi != null) {
            this.fIi.cancel();
        }
        if (this.fIh != null) {
            this.fIh.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fwF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwy() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void kA(boolean z) {
        this.aJa = z;
    }
}
