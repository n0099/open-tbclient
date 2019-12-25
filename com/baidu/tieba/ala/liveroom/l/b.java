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
import com.baidu.live.data.ac;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.guardclub.l;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private TextView bXt;
    private HeadImageView eLi;
    private com.baidu.tieba.ala.liveroom.operation.b eMc;
    private TextView eXo;
    private ImageView eXp;
    private k eXq;
    private AnimatorSet eXs;
    private ScaleAnimation eXu;
    private ScaleAnimation eXv;
    private AnimationSet eXw;
    private AnimationSet eXx;
    private ScaleAnimation eXy;
    private TextView egu;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int eXr = 30000;
    private boolean eXz = false;
    private boolean ezi = false;
    private Set<Long> eXA = new HashSet();
    private boolean eXB = true;
    private boolean eXC = false;
    CustomMessageListener eVM = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.yy((String) customResponsedMessage.getData());
            } else {
                b.this.bkv();
            }
        }
    };
    private Set<Long> eXt = new HashSet();

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
        this.eXo = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.eLi = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.bXt = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.egu = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.eXp = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.eLi.setIsRound(true);
        this.eLi.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eLi.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eXo.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eXo.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.eXo.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.eXo.setOnClickListener(onClickListener);
    }

    public void jj(boolean z) {
        this.eXB = false;
        if (!this.eXC) {
            this.eXo.setVisibility(8);
            return;
        }
        if (!z) {
            this.eXo.setVisibility(8);
            this.eXp.setVisibility(0);
        } else {
            bku();
        }
        if (!this.isHost && this.eXq != null && this.eXq.mLiveInfo != null && this.eXq.VP != null) {
            long j = this.eXq.VP.userId;
            if (!this.eXA.contains(Long.valueOf(j))) {
                this.eXA.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.eXq.mLiveInfo.live_id + "", this.eXq.mLiveInfo.room_id + "", this.eXq.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bku() {
        if (!this.eXz && this.eXp.getVisibility() != 0) {
            this.eXz = true;
            this.eXu = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.eXu.setDuration(200L);
            this.eXu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eXo.setScaleX(1.0f);
                    b.this.eXo.setScaleY(1.0f);
                    b.this.eXo.setAlpha(1.0f);
                    b.this.eXz = false;
                    if (b.this.eXB) {
                        b.this.eXo.setVisibility(0);
                        b.this.eXp.setVisibility(4);
                        return;
                    }
                    b.this.eXo.setVisibility(8);
                    b.this.eXp.setVisibility(0);
                    if (b.this.eXC) {
                        b.this.bkx();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.eXv = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.eXv.setDuration(800L);
            this.eXv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eXp.startAnimation(b.this.eXu);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.eXw = new AnimationSet(true);
            this.eXw.addAnimation(aVar);
            this.eXw.addAnimation(alphaAnimation);
            this.eXw.setDuration(1000L);
            this.eXw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.eXp.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eXp.startAnimation(b.this.eXv);
                    b.this.eXo.setVisibility(8);
                    b.this.eXo.setScaleX(1.0f);
                    b.this.eXo.setScaleY(1.0f);
                    b.this.eXo.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.eXx = new AnimationSet(true);
            this.eXx.addAnimation(aVar2);
            this.eXx.addAnimation(alphaAnimation2);
            this.eXx.setDuration(1000L);
            this.eXy = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.eXy.setDuration(200L);
            this.eXy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eXo.setScaleX(0.9f);
                    b.this.eXo.setScaleY(0.9f);
                    b.this.eXo.startAnimation(b.this.eXx);
                    b.this.eXp.startAnimation(b.this.eXw);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.eXo.startAnimation(this.eXy);
        }
    }

    public void bkt() {
        this.eXB = true;
        this.eXz = false;
        this.eXo.setScaleX(1.0f);
        this.eXo.setScaleY(1.0f);
        this.eXo.setAlpha(1.0f);
        this.eXo.setVisibility(0);
        if (this.eXC) {
            this.eXp.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void a(k kVar, final boolean z, final String str) {
        this.eXq = kVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.eXq != null && this.eXq.VP != null) {
            this.eLi.stopLoad();
            this.eLi.startLoad(this.eXq.VP.portrait, 12, false, false);
            String str2 = this.eXq.VP.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.bXt.setText(str2);
            this.egu.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(kVar.VP.charmCount)));
            this.eXp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bkv();
                    if (!z && b.this.eXq != null && b.this.eXq.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.eXq.mLiveInfo.live_id + "", b.this.eXq.mLiveInfo.room_id + "", b.this.eXq.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkv() {
        yy(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(String str) {
        if (this.mContext != null && this.eXq != null && this.eXq.VP != null && this.eXq.mLiveInfo != null) {
            long j = this.eXq.VP.userId;
            long j2 = this.eXq.mLiveInfo.live_id;
            long j3 = this.eXq.mLiveInfo.room_id;
            String str2 = this.eXq.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.ezi);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bkw() {
        if (this.eXs != null) {
            this.eXs.removeAllListeners();
            this.eXs.cancel();
            this.eXs = null;
        }
    }

    public void onDestroy() {
        bkw();
        if (this.eVM != null) {
            MessageManager.getInstance().unRegisterListener(this.eVM);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.eXA.clear();
    }

    private void cancelAnimation() {
        if (this.eXy != null) {
            this.eXy.cancel();
        }
        if (this.eXx != null) {
            this.eXx.cancel();
        }
        if (this.eXw != null) {
            this.eXw.cancel();
        }
        if (this.eXv != null) {
            this.eXv.cancel();
        }
        if (this.eXu != null) {
            this.eXu.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eMc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkx() {
        ac bcG;
        if (this.mContext != null && this.mView != null && this.mView.getParent() != null && (this.mView.getParent() instanceof ViewGroup) && (bcG = l.bcE().bcG()) != null && !TextUtils.isEmpty(bcG.ZZ)) {
            final ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            final View inflate = LayoutInflater.from(this.mContext).inflate(a.h.toast_guard_club_guide, (ViewGroup) null);
            ((TextView) inflate.findViewById(a.g.textView)).setText(bcG.ZZ);
            if (viewGroup != null) {
                inflate.measure(0, 0);
                int measuredWidth = inflate.getMeasuredWidth();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                this.eXp.getLocationOnScreen(iArr);
                viewGroup.getLocationOnScreen(iArr2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ((iArr[0] + (this.eXp.getWidth() / 2)) - (measuredWidth / 2)) - 2;
                layoutParams.topMargin = ((iArr[1] + this.eXp.getHeight()) - iArr2[1]) + 20;
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

    public void jk(boolean z) {
        this.ezi = z;
    }
}
