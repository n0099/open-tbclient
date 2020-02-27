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
    private TextView cbJ;
    private HeadImageView eQy;
    private com.baidu.tieba.ala.liveroom.operation.b eRu;
    private TextView ekI;
    private TextView fda;
    private ImageView fdb;
    private m fdc;
    private AnimatorSet fde;
    private ScaleAnimation fdg;
    private ScaleAnimation fdh;
    private AnimationSet fdi;
    private AnimationSet fdj;
    private ScaleAnimation fdk;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int fdd = 30000;
    private boolean fdl = false;
    private boolean aqa = false;
    private Set<Long> fdm = new HashSet();
    private boolean fdn = true;
    private boolean fdo = false;
    private long fdp = 0;
    CustomMessageListener eDS = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.yt((String) customResponsedMessage.getData());
            } else {
                b.this.bmZ();
            }
        }
    };
    private Set<Long> fdf = new HashSet();

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
        this.fda = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.eQy = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.cbJ = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.ekI = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.fdb = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.eQy.setIsRound(true);
        this.eQy.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eQy.setAutoChangeStyle(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fda.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fda.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fda.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.fda.setOnClickListener(onClickListener);
    }

    public void jw(boolean z) {
        this.fdn = false;
        if (!this.fdo) {
            this.fda.setVisibility(8);
            return;
        }
        if (!z) {
            this.fda.setVisibility(8);
            this.fdb.setVisibility(0);
        } else {
            bmY();
        }
        if (!this.isHost && this.fdc != null && this.fdc.mLiveInfo != null && this.fdc.XQ != null) {
            long j = this.fdc.XQ.userId;
            if (!this.fdm.contains(Long.valueOf(j))) {
                this.fdm.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.fdc.mLiveInfo.live_id + "", this.fdc.mLiveInfo.room_id + "", this.fdc.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bmY() {
        if (!this.fdl && this.fdb.getVisibility() != 0) {
            this.fdl = true;
            this.fdg = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.fdg.setDuration(200L);
            this.fdg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fda.setScaleX(1.0f);
                    b.this.fda.setScaleY(1.0f);
                    b.this.fda.setAlpha(1.0f);
                    b.this.fdl = false;
                    if (b.this.fdn) {
                        b.this.fda.setVisibility(0);
                        b.this.fdb.setVisibility(4);
                        return;
                    }
                    b.this.fda.setVisibility(8);
                    b.this.fdb.setVisibility(0);
                    if (b.this.fdo) {
                        b.this.bnb();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fdh = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.fdh.setDuration(800L);
            this.fdh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdb.startAnimation(b.this.fdg);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar = new com.baidu.live.tieba.view.a(90.0f, 0.0f, 0.0f, false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.fdi = new AnimationSet(true);
            this.fdi.addAnimation(aVar);
            this.fdi.addAnimation(alphaAnimation);
            this.fdi.setDuration(1000L);
            this.fdi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    b.this.fdb.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fdb.startAnimation(b.this.fdh);
                    b.this.fda.setVisibility(8);
                    b.this.fda.setScaleX(1.0f);
                    b.this.fda.setScaleY(1.0f);
                    b.this.fda.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            com.baidu.live.tieba.view.a aVar2 = new com.baidu.live.tieba.view.a(0.0f, -90.0f, 0.0f, false);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.fdj = new AnimationSet(true);
            this.fdj.addAnimation(aVar2);
            this.fdj.addAnimation(alphaAnimation2);
            this.fdj.setDuration(1000L);
            this.fdk = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
            this.fdk.setDuration(200L);
            this.fdk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.fda.setScaleX(0.9f);
                    b.this.fda.setScaleY(0.9f);
                    b.this.fda.startAnimation(b.this.fdj);
                    b.this.fdb.startAnimation(b.this.fdi);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.fda.startAnimation(this.fdk);
        }
    }

    public void bmX() {
        this.fdn = true;
        this.fdl = false;
        this.fda.setScaleX(1.0f);
        this.fda.setScaleY(1.0f);
        this.fda.setAlpha(1.0f);
        this.fda.setVisibility(0);
        if (this.fdo) {
            this.fdb.setVisibility(4);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void cW(long j) {
        if (j > this.fdp) {
            this.fdp = j;
            this.ekI.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(m mVar, final boolean z, final String str) {
        boolean z2;
        if (this.fdc == null || this.fdc.mLiveInfo == null) {
            z2 = true;
        } else {
            z2 = (mVar == null || mVar.mLiveInfo == null) ? true : this.fdc.mLiveInfo.live_id == mVar.mLiveInfo.live_id;
        }
        this.fdc = mVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.fdc != null && this.fdc.XQ != null) {
            this.eQy.stopLoad();
            this.eQy.startLoad(this.fdc.XQ.portrait, 12, false, false);
            String str2 = this.fdc.XQ.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.cbJ.setText(str2);
            if (z2 || mVar.XQ.charmCount > this.fdp) {
                this.fdp = mVar.XQ.charmCount;
                this.ekI.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.fdp)));
            }
            this.fdb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bmZ();
                    if (!z && b.this.fdc != null && b.this.fdc.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.fdc.mLiveInfo.live_id + "", b.this.fdc.mLiveInfo.room_id + "", b.this.fdc.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmZ() {
        yt(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(String str) {
        if (this.mContext != null && this.fdc != null && this.fdc.XQ != null && this.fdc.mLiveInfo != null) {
            long j = this.fdc.XQ.userId;
            long j2 = this.fdc.mLiveInfo.live_id;
            long j3 = this.fdc.mLiveInfo.room_id;
            String str2 = this.fdc.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aqa);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    private void bna() {
        if (this.fde != null) {
            this.fde.removeAllListeners();
            this.fde.cancel();
            this.fde = null;
        }
    }

    public void onDestroy() {
        bna();
        if (this.eDS != null) {
            MessageManager.getInstance().unRegisterListener(this.eDS);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.fdm.clear();
    }

    private void cancelAnimation() {
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
        if (this.fdg != null) {
            this.fdg.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eRu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnb() {
        if (this.mContext == null || this.mView == null) {
        }
    }

    public void jx(boolean z) {
        this.aqa = z;
    }
}
