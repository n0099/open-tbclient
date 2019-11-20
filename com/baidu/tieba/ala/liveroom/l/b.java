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
    private TextView crw;
    private HeadImageView dVI;
    private com.baidu.tieba.ala.liveroom.operation.b dWv;
    private TextView dvs;
    private TextView ehc;
    private ImageView ehd;
    private i ehe;
    private AnimatorSet ehg;
    private ScaleAnimation ehi;
    private ScaleAnimation ehj;
    private AnimationSet ehk;
    private AnimationSet ehl;
    private ScaleAnimation ehm;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int ehf = 30000;
    private boolean ehn = false;
    private boolean dKS = false;
    private Set<Long> eho = new HashSet();
    private boolean ehp = true;
    private boolean ehq = false;
    CustomMessageListener efS = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.tJ((String) customResponsedMessage.getData());
            } else {
                b.this.aSI();
            }
        }
    };
    private Set<Long> ehh = new HashSet();

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
        this.ehc = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.dVI = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.crw = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.dvs = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.ehd = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.dVI.setIsRound(true);
        this.dVI.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ehc.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else {
            this.ehc.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.ehc.setOnClickListener(onClickListener);
    }

    public void hT(boolean z) {
        this.ehp = false;
        if (!this.ehq) {
            this.ehc.setVisibility(8);
            return;
        }
        if (!z) {
            this.ehc.setVisibility(8);
            this.ehd.setVisibility(0);
        } else {
            aSH();
        }
        if (!this.isHost && this.ehe != null && this.ehe.mLiveInfo != null && this.ehe.OR != null) {
            long j = this.ehe.OR.userId;
            if (!this.eho.contains(Long.valueOf(j))) {
                this.eho.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.ehe.mLiveInfo.live_id + "", this.ehe.mLiveInfo.room_id + "", this.ehe.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void aSH() {
        if (!this.ehn && this.ehd.getVisibility() != 0) {
            this.ehn = true;
            this.ehi = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.ehi.setDuration(200L);
            this.ehi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehc.setScaleX(1.0f);
                    b.this.ehc.setScaleY(1.0f);
                    b.this.ehc.setAlpha(1.0f);
                    b.this.ehn = false;
                    if (b.this.ehp) {
                        b.this.ehc.setVisibility(0);
                        b.this.ehd.setVisibility(4);
                        return;
                    }
                    b.this.ehc.setVisibility(8);
                    b.this.ehd.setVisibility(0);
                    if (b.this.ehq) {
                        b.this.aSK();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ehj = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.ehj.setDuration(800L);
            this.ehj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehd.startAnimation(b.this.ehi);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.ehk = new AnimationSet(true);
            this.ehk.addAnimation(aVar);
            this.ehk.addAnimation(alphaAnimation);
            this.ehk.setDuration(1000L);
            this.ehk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.ehd.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehd.startAnimation(b.this.ehj);
                    b.this.ehc.setVisibility(8);
                    b.this.ehc.setScaleX(1.0f);
                    b.this.ehc.setScaleY(1.0f);
                    b.this.ehc.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.ehl = new AnimationSet(true);
            this.ehl.addAnimation(aVar2);
            this.ehl.addAnimation(alphaAnimation2);
            this.ehl.setDuration(1000L);
            this.ehm = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.ehm.setDuration(200L);
            this.ehm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.ehc.setScaleX(0.9f);
                    b.this.ehc.setScaleY(0.9f);
                    b.this.ehc.startAnimation(b.this.ehl);
                    b.this.ehd.startAnimation(b.this.ehk);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ehc.startAnimation(this.ehm);
        }
    }

    public void aSG() {
        this.ehp = true;
        this.ehn = false;
        this.ehc.setScaleX(1.0f);
        this.ehc.setScaleY(1.0f);
        this.ehc.setAlpha(1.0f);
        this.ehc.setVisibility(0);
        if (this.ehq) {
            this.ehd.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void a(i iVar, final boolean z, final String str) {
        this.ehe = iVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.ehe != null && this.ehe.OR != null) {
            this.dVI.stopLoad();
            this.dVI.startLoad(this.ehe.OR.portrait, 12, false, false);
            String str2 = this.ehe.OR.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.crw.setText(str2);
            this.dvs.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(iVar.OR.charmCount)));
            this.ehd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.aSI();
                    if (!z && b.this.ehe != null && b.this.ehe.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.ehe.mLiveInfo.live_id + "", b.this.ehe.mLiveInfo.room_id + "", b.this.ehe.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSI() {
        tJ(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(String str) {
        if (this.mContext != null && this.ehe != null && this.ehe.OR != null && this.ehe.mLiveInfo != null) {
            long j = this.ehe.OR.userId;
            long j2 = this.ehe.mLiveInfo.live_id;
            long j3 = this.ehe.mLiveInfo.room_id;
            String str2 = this.ehe.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.dKS);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void aSJ() {
        if (this.ehg != null) {
            this.ehg.removeAllListeners();
            this.ehg.cancel();
            this.ehg = null;
        }
    }

    public void onDestroy() {
        aSJ();
        if (this.efS != null) {
            MessageManager.getInstance().unRegisterListener(this.efS);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.eho.clear();
    }

    private void cancelAnimation() {
        if (this.ehm != null) {
            this.ehm.cancel();
        }
        if (this.ehl != null) {
            this.ehl.cancel();
        }
        if (this.ehk != null) {
            this.ehk.cancel();
        }
        if (this.ehj != null) {
            this.ehj.cancel();
        }
        if (this.ehi != null) {
            this.ehi.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.dWv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSK() {
        z aLx;
        if (this.mContext != null && this.mView != null && this.mView.getParent() != null && (this.mView.getParent() instanceof ViewGroup) && (aLx = m.aLv().aLx()) != null && !TextUtils.isEmpty(aLx.Tj)) {
            final ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            final View inflate = LayoutInflater.from(this.mContext).inflate(a.h.toast_guard_club_guide, (ViewGroup) null);
            ((TextView) inflate.findViewById(a.g.textView)).setText(aLx.Tj);
            if (viewGroup != null) {
                inflate.measure(0, 0);
                int measuredWidth = inflate.getMeasuredWidth();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                this.ehd.getLocationOnScreen(iArr);
                viewGroup.getLocationOnScreen(iArr2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ((iArr[0] + (this.ehd.getWidth() / 2)) - (measuredWidth / 2)) - 2;
                layoutParams.topMargin = ((iArr[1] + this.ehd.getHeight()) - iArr2[1]) + 20;
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
        this.dKS = z;
    }
}
