package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.data.ag;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class b {
    private TextView bXF;
    private HeadImageView eMv;
    private com.baidu.tieba.ala.liveroom.operation.b eNr;
    private TextView eZN;
    private ImageView eZO;
    private l eZP;
    private AnimatorSet eZR;
    private ScaleAnimation eZT;
    private ScaleAnimation eZU;
    private AnimationSet eZV;
    private AnimationSet eZW;
    private ScaleAnimation eZX;
    private TextView egE;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int eZQ = 30000;
    private boolean eZY = false;
    private boolean eAt = false;
    private Set<Long> eZZ = new HashSet();
    private boolean faa = true;
    private boolean fab = false;
    CustomMessageListener eYm = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.n.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.yH((String) customResponsedMessage.getData());
            } else {
                b.this.blr();
            }
        }
    };
    private Set<Long> eZS = new HashSet();

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
        this.eZN = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.eMv = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.bXF = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.egE = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.eZO = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.eMv.setIsRound(true);
        this.eMv.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eMv.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eZN.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eZN.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.eZN.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.eZN.setOnClickListener(onClickListener);
    }

    public void ju(boolean z) {
        this.faa = false;
        if (!this.fab) {
            this.eZN.setVisibility(8);
            return;
        }
        if (!z) {
            this.eZN.setVisibility(8);
            this.eZO.setVisibility(0);
        } else {
            blq();
        }
        if (!this.isHost && this.eZP != null && this.eZP.mLiveInfo != null && this.eZP.Wf != null) {
            long j = this.eZP.Wf.userId;
            if (!this.eZZ.contains(Long.valueOf(j))) {
                this.eZZ.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.eZP.mLiveInfo.live_id + "", this.eZP.mLiveInfo.room_id + "", this.eZP.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void blq() {
        if (!this.eZY && this.eZO.getVisibility() != 0) {
            this.eZY = true;
            this.eZT = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.eZT.setDuration(200L);
            this.eZT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eZN.setScaleX(1.0f);
                    b.this.eZN.setScaleY(1.0f);
                    b.this.eZN.setAlpha(1.0f);
                    b.this.eZY = false;
                    if (b.this.faa) {
                        b.this.eZN.setVisibility(0);
                        b.this.eZO.setVisibility(4);
                        return;
                    }
                    b.this.eZN.setVisibility(8);
                    b.this.eZO.setVisibility(0);
                    if (b.this.fab) {
                        b.this.blt();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.eZU = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.eZU.setDuration(800L);
            this.eZU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eZO.startAnimation(b.this.eZT);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.eZV = new AnimationSet(true);
            this.eZV.addAnimation(aVar);
            this.eZV.addAnimation(alphaAnimation);
            this.eZV.setDuration(1000L);
            this.eZV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.eZO.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eZO.startAnimation(b.this.eZU);
                    b.this.eZN.setVisibility(8);
                    b.this.eZN.setScaleX(1.0f);
                    b.this.eZN.setScaleY(1.0f);
                    b.this.eZN.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.eZW = new AnimationSet(true);
            this.eZW.addAnimation(aVar2);
            this.eZW.addAnimation(alphaAnimation2);
            this.eZW.setDuration(1000L);
            this.eZX = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.eZX.setDuration(200L);
            this.eZX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.eZN.setScaleX(0.9f);
                    b.this.eZN.setScaleY(0.9f);
                    b.this.eZN.startAnimation(b.this.eZW);
                    b.this.eZO.startAnimation(b.this.eZV);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.eZN.startAnimation(this.eZX);
        }
    }

    public void blp() {
        this.faa = true;
        this.eZY = false;
        this.eZN.setScaleX(1.0f);
        this.eZN.setScaleY(1.0f);
        this.eZN.setAlpha(1.0f);
        this.eZN.setVisibility(0);
        if (this.fab) {
            this.eZO.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void a(l lVar, final boolean z, final String str) {
        this.eZP = lVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.eZP != null && this.eZP.Wf != null) {
            this.eMv.stopLoad();
            this.eMv.startLoad(this.eZP.Wf.portrait, 12, false, false);
            String str2 = this.eZP.Wf.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.bXF.setText(str2);
            this.egE.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(lVar.Wf.charmCount)));
            this.eZO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.blr();
                    if (!z && b.this.eZP != null && b.this.eZP.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.eZP.mLiveInfo.live_id + "", b.this.eZP.mLiveInfo.room_id + "", b.this.eZP.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        yH(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(String str) {
        if (this.mContext != null && this.eZP != null && this.eZP.Wf != null && this.eZP.mLiveInfo != null) {
            long j = this.eZP.Wf.userId;
            long j2 = this.eZP.mLiveInfo.live_id;
            long j3 = this.eZP.mLiveInfo.room_id;
            String str2 = this.eZP.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.eAt);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bls() {
        if (this.eZR != null) {
            this.eZR.removeAllListeners();
            this.eZR.cancel();
            this.eZR = null;
        }
    }

    public void onDestroy() {
        bls();
        if (this.eYm != null) {
            MessageManager.getInstance().unRegisterListener(this.eYm);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.eZZ.clear();
    }

    private void cancelAnimation() {
        if (this.eZX != null) {
            this.eZX.cancel();
        }
        if (this.eZW != null) {
            this.eZW.cancel();
        }
        if (this.eZV != null) {
            this.eZV.cancel();
        }
        if (this.eZU != null) {
            this.eZU.cancel();
        }
        if (this.eZT != null) {
            this.eZT.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eNr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        ag bdb;
        if (this.mContext != null && this.mView != null && this.mView.getParent() != null && (this.mView.getParent() instanceof ViewGroup) && (bdb = com.baidu.tieba.ala.guardclub.l.bcZ().bdb()) != null && !TextUtils.isEmpty(bdb.aan)) {
            final ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            final View inflate = LayoutInflater.from(this.mContext).inflate(a.h.toast_guard_club_guide, (ViewGroup) null);
            ((TextView) inflate.findViewById(a.g.textView)).setText(bdb.aan);
            if (viewGroup != null) {
                inflate.measure(0, 0);
                int measuredWidth = inflate.getMeasuredWidth();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                this.eZO.getLocationOnScreen(iArr);
                viewGroup.getLocationOnScreen(iArr2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ((iArr[0] + (this.eZO.getWidth() / 2)) - (measuredWidth / 2)) - 2;
                layoutParams.topMargin = ((iArr[1] + this.eZO.getHeight()) - iArr2[1]) + 20;
                viewGroup.addView(inflate, layoutParams);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.b.7
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

    public void jv(boolean z) {
        this.eAt = z;
    }
}
