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
    private TextView cbK;
    private HeadImageView eQz;
    private com.baidu.tieba.ala.liveroom.operation.b eRv;
    private TextView ekJ;
    private TextView fdb;
    private ImageView fdc;
    private m fdd;
    private AnimatorSet fdf;
    private ScaleAnimation fdh;
    private ScaleAnimation fdi;
    private AnimationSet fdj;
    private AnimationSet fdk;
    private ScaleAnimation fdl;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fde = 30000;
    private boolean fdm = false;
    private boolean aqa = false;
    private Set<Long> fdn = new HashSet();
    private boolean fdo = true;
    private boolean fdp = false;
    private long fdq = 0;
    CustomMessageListener eDT = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.yt((String) customResponsedMessage.getData());
            } else {
                b.this.bnb();
            }
        }
    };
    private Set<Long> fdg = new HashSet();

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
        this.fdb = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.eQz = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.cbK = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.ekJ = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fdc = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.eQz.setIsRound(true);
        this.eQz.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eQz.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fdb.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fdb.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fdb.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.fdb.setOnClickListener(onClickListener);
    }

    public void jw(boolean z) {
        this.fdo = false;
        if (!this.fdp) {
            this.fdb.setVisibility(8);
            return;
        }
        if (!z) {
            this.fdb.setVisibility(8);
            this.fdc.setVisibility(0);
        } else {
            bna();
        }
        if (!this.isHost && this.fdd != null && this.fdd.mLiveInfo != null && this.fdd.XQ != null) {
            long j = this.fdd.XQ.userId;
            if (!this.fdn.contains(Long.valueOf(j))) {
                this.fdn.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fdd.mLiveInfo.live_id + "", this.fdd.mLiveInfo.room_id + "", this.fdd.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bna() {
        if (!this.fdm && this.fdc.getVisibility() != 0) {
            this.fdm = true;
            this.fdh = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fdh.setDuration(200L);
            this.fdh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdb.setScaleX(1.0f);
                    b.this.fdb.setScaleY(1.0f);
                    b.this.fdb.setAlpha(1.0f);
                    b.this.fdm = false;
                    if (b.this.fdo) {
                        b.this.fdb.setVisibility(0);
                        b.this.fdc.setVisibility(4);
                        return;
                    }
                    b.this.fdb.setVisibility(8);
                    b.this.fdc.setVisibility(0);
                    if (b.this.fdp) {
                        b.this.bnd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdi = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fdi.setDuration(800L);
            this.fdi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdc.startAnimation(b.this.fdh);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fdj = new AnimationSet(true);
            this.fdj.addAnimation(aVar);
            this.fdj.addAnimation(alphaAnimation);
            this.fdj.setDuration(1000L);
            this.fdj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fdc.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdc.startAnimation(b.this.fdi);
                    b.this.fdb.setVisibility(8);
                    b.this.fdb.setScaleX(1.0f);
                    b.this.fdb.setScaleY(1.0f);
                    b.this.fdb.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fdk = new AnimationSet(true);
            this.fdk.addAnimation(aVar2);
            this.fdk.addAnimation(alphaAnimation2);
            this.fdk.setDuration(1000L);
            this.fdl = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fdl.setDuration(200L);
            this.fdl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdb.setScaleX(0.9f);
                    b.this.fdb.setScaleY(0.9f);
                    b.this.fdb.startAnimation(b.this.fdk);
                    b.this.fdc.startAnimation(b.this.fdj);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdb.startAnimation(this.fdl);
        }
    }

    public void bmZ() {
        this.fdo = true;
        this.fdm = false;
        this.fdb.setScaleX(1.0f);
        this.fdb.setScaleY(1.0f);
        this.fdb.setAlpha(1.0f);
        this.fdb.setVisibility(0);
        if (this.fdp) {
            this.fdc.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void cW(long j) {
        if (j > this.fdq) {
            this.fdq = j;
            this.ekJ.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(m mVar, final boolean z, final String str) {
        boolean z2;
        if (this.fdd == null || this.fdd.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (mVar == null || mVar.mLiveInfo == null) ? true : this.fdd.mLiveInfo.live_id == mVar.mLiveInfo.live_id;
        }
        this.fdd = mVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fdd != null && this.fdd.XQ != null) {
            this.eQz.stopLoad();
            this.eQz.startLoad(this.fdd.XQ.portrait, 12, false, false);
            String str2 = this.fdd.XQ.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.cbK.setText(str2);
            if (z2 || mVar.XQ.charmCount > this.fdq) {
                this.fdq = mVar.XQ.charmCount;
                this.ekJ.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fdq)));
            }
            this.fdc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bnb();
                    if (!z && b.this.fdd != null && b.this.fdd.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fdd.mLiveInfo.live_id + "", b.this.fdd.mLiveInfo.room_id + "", b.this.fdd.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnb() {
        yt(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(String str) {
        if (this.mContext != null && this.fdd != null && this.fdd.XQ != null && this.fdd.mLiveInfo != null) {
            long j = this.fdd.XQ.userId;
            long j2 = this.fdd.mLiveInfo.live_id;
            long j3 = this.fdd.mLiveInfo.room_id;
            String str2 = this.fdd.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aqa);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bnc() {
        if (this.fdf != null) {
            this.fdf.removeAllListeners();
            this.fdf.cancel();
            this.fdf = null;
        }
    }

    public void onDestroy() {
        bnc();
        if (this.eDT != null) {
            MessageManager.getInstance().unRegisterListener(this.eDT);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fdn.clear();
    }

    private void cancelAnimation() {
        if (this.fdl != null) {
            this.fdl.cancel();
        }
        if (this.fdk != null) {
            this.fdk.cancel();
        }
        if (this.fdj != null) {
            this.fdj.cancel();
        }
        if (this.fdi != null) {
            this.fdi.cancel();
        }
        if (this.fdh != null) {
            this.fdh.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eRv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnd() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void jx(boolean z) {
        this.aqa = z;
    }
}
