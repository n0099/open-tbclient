package com.baidu.tieba.ala.liveroom.l;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.i;
import com.baidu.live.data.z;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.guardclub.m;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b {
    private TextView csn;
    private HeadImageView dWz;
    private com.baidu.tieba.ala.liveroom.operation.b dXm;
    private TextView dwj;
    private TextView ehT;
    private ImageView ehU;
    private i ehV;
    private AnimatorSet ehX;
    private ScaleAnimation ehZ;
    private ScaleAnimation eia;
    private AnimationSet eib;
    private AnimationSet eic;
    private ScaleAnimation eid;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int ehW = 30000;
    private boolean eie = false;
    private boolean dLJ = false;
    private Set<Long> eif = new HashSet();
    private boolean eig = true;
    private boolean eih = false;
    CustomMessageListener egJ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.tJ((String) customResponsedMessage.getData());
            } else {
                b.this.aSK();
            }
        }
    };
    private Set<Long> ehY = new HashSet();

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
        this.mView.setBackgroundResource(a.f.sdk_round_host_bg);
        this.ehT = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.dWz = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.csn = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.dwj = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.ehU = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.dWz.setIsRound(true);
        this.dWz.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ehT.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else {
            this.ehT.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.ehT.setOnClickListener(onClickListener);
    }

    public void hT(boolean z) {
        this.eig = false;
        if (!this.eih) {
            this.ehT.setVisibility(8);
            return;
        }
        if (!z) {
            this.ehT.setVisibility(8);
            this.ehU.setVisibility(0);
        } else {
            aSJ();
        }
        if (!this.isHost && this.ehV != null && this.ehV.mLiveInfo != null && this.ehV.Ps != null) {
            long j = this.ehV.Ps.userId;
            if (!this.eif.contains(Long.valueOf(j))) {
                this.eif.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.ehV.mLiveInfo.live_id + "", this.ehV.mLiveInfo.room_id + "", this.ehV.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void aSJ() {
        if (!this.eie && this.ehU.getVisibility() != 0) {
            this.eie = true;
            this.ehZ = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.ehZ.setDuration(200L);
            this.ehZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehT.setScaleX(1.0f);
                    b.this.ehT.setScaleY(1.0f);
                    b.this.ehT.setAlpha(1.0f);
                    b.this.eie = false;
                    if (b.this.eig) {
                        b.this.ehT.setVisibility(0);
                        b.this.ehU.setVisibility(4);
                        return;
                    }
                    b.this.ehT.setVisibility(8);
                    b.this.ehU.setVisibility(0);
                    if (b.this.eih) {
                        b.this.aSM();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.eia = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.eia.setDuration(800L);
            this.eia.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehU.startAnimation(b.this.ehZ);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.eib = new AnimationSet(true);
            this.eib.addAnimation(aVar);
            this.eib.addAnimation(alphaAnimation);
            this.eib.setDuration(1000L);
            this.eib.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.ehU.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehU.startAnimation(b.this.eia);
                    b.this.ehT.setVisibility(8);
                    b.this.ehT.setScaleX(1.0f);
                    b.this.ehT.setScaleY(1.0f);
                    b.this.ehT.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.eic = new AnimationSet(true);
            this.eic.addAnimation(aVar2);
            this.eic.addAnimation(alphaAnimation2);
            this.eic.setDuration(1000L);
            this.eid = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.eid.setDuration(200L);
            this.eid.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehT.setScaleX(0.9f);
                    b.this.ehT.setScaleY(0.9f);
                    b.this.ehT.startAnimation(b.this.eic);
                    b.this.ehU.startAnimation(b.this.eib);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ehT.startAnimation(this.eid);
        }
    }

    public void aSI() {
        this.eig = true;
        this.eie = false;
        this.ehT.setScaleX(1.0f);
        this.ehT.setScaleY(1.0f);
        this.ehT.setAlpha(1.0f);
        this.ehT.setVisibility(0);
        if (this.eih) {
            this.ehU.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void a(i iVar, final boolean z, final String str) {
        this.ehV = iVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.ehV != null && this.ehV.Ps != null) {
            this.dWz.stopLoad();
            this.dWz.startLoad(this.ehV.Ps.portrait, 12, false, false);
            String str2 = this.ehV.Ps.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.csn.setText(str2);
            this.dwj.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(iVar.Ps.charmCount)));
            this.ehU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aSK();
                    if (!z && b.this.ehV != null && b.this.ehV.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.ehV.mLiveInfo.live_id + "", b.this.ehV.mLiveInfo.room_id + "", b.this.ehV.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSK() {
        tJ(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(String str) {
        if (this.mContext != null && this.ehV != null && this.ehV.Ps != null && this.ehV.mLiveInfo != null) {
            long j = this.ehV.Ps.userId;
            long j2 = this.ehV.mLiveInfo.live_id;
            long j3 = this.ehV.mLiveInfo.room_id;
            String str2 = this.ehV.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.dLJ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void aSL() {
        if (this.ehX != null) {
            this.ehX.removeAllListeners();
            this.ehX.cancel();
            this.ehX = null;
        }
    }

    public void onDestroy() {
        aSL();
        if (this.egJ != null) {
            MessageManager.getInstance().unRegisterListener(this.egJ);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.eif.clear();
    }

    private void cancelAnimation() {
        if (this.eid != null) {
            this.eid.cancel();
        }
        if (this.eic != null) {
            this.eic.cancel();
        }
        if (this.eib != null) {
            this.eib.cancel();
        }
        if (this.eia != null) {
            this.eia.cancel();
        }
        if (this.ehZ != null) {
            this.ehZ.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.dXm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSM() {
        z aLz;
        if (this.mContext != null && this.mView != null && this.mView.getParent() != null && (this.mView.getParent() instanceof ViewGroup) && (aLz = m.aLx().aLz()) != null && !TextUtils.isEmpty(aLz.TC)) {
            final ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            final View inflate = LayoutInflater.from(this.mContext).inflate(a.h.toast_guard_club_guide, (ViewGroup) null);
            ((TextView) inflate.findViewById(a.g.textView)).setText(aLz.TC);
            if (viewGroup != null) {
                inflate.measure(0, 0);
                int measuredWidth = inflate.getMeasuredWidth();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                this.ehU.getLocationOnScreen(iArr);
                viewGroup.getLocationOnScreen(iArr2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ((iArr[0] + (this.ehU.getWidth() / 2)) - (measuredWidth / 2)) - 2;
                layoutParams.topMargin = ((iArr[1] + this.ehU.getHeight()) - iArr2[1]) + 20;
                viewGroup.addView(inflate, layoutParams);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.l.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (viewGroup != null) {
                            viewGroup.removeView(inflate);
                        }
                    }
                }, 3000L);
            }
        }
    }

    public void hU(boolean z) {
        this.dLJ = z;
    }
}
