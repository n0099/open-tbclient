package com.baidu.tieba.ala.person.view;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d.g;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.at;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes10.dex */
public class c implements View.OnClickListener {
    private TextView aBZ;
    private long brk;
    private PersonUserData bty;
    private long gmc;
    protected final PersonCardActivity hTh;
    private View hTi;
    private View hTj;
    private TextView hTk;
    private Button hTl;
    private Button hTm;
    private TextView hTn;
    private HeadImageView hTo;
    private ImageView hTp;
    private View hTq;
    private a.InterfaceC0680a hTr;
    private boolean hTs;
    private com.baidu.tieba.ala.person.a hTt;
    private Animation haJ;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private int screenWidth;
    private String uid;

    public c(final PersonCardActivity personCardActivity, boolean z) {
        this.hTh = personCardActivity;
        this.hTs = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = nn(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
    }

    public void eD(String str, String str2) {
        if (str != null && str2 != null) {
            this.aBZ.setText(str);
            m.a(this.hTo, str2, true, false);
        }
    }

    public void d(PersonUserData personUserData) {
        this.bty = personUserData;
        at atVar = personUserData.user_info;
        if (atVar != null) {
            if (!StringUtils.isNull(atVar.getNameShow())) {
                String nameShow = atVar.getNameShow();
                if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                    nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
                }
                this.aBZ.setText(nameShow);
            }
            m.a(this.hTo, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hTn.setVisibility(8);
                this.hTm.setVisibility(8);
            } else if (this.hTh.HE(TbadkCoreApplication.getCurrentAccount())) {
                this.hTm.setVisibility(8);
                this.hTn.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hTn.setVisibility(0);
                this.hTm.setVisibility(0);
            } else {
                this.hTm.setVisibility(0);
                this.hTn.setVisibility(8);
            }
        }
    }

    private void initView() {
        this.hTi = this.mRootView.findViewById(a.f.mystery_person_card_frame);
        this.hTj = this.mRootView.findViewById(a.f.mystery_person_card_layout);
        this.aBZ = (TextView) this.mRootView.findViewById(a.f.person_card_user_name);
        this.hTn = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hTl = (Button) this.mRootView.findViewById(a.f.person_card_at_button);
        this.hTp = (ImageView) this.mRootView.findViewById(a.f.card_decoration);
        this.hTq = this.mRootView.findViewById(a.f.user_portrait_layout);
        this.hTl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.clE();
            }
        });
        this.hTm = (Button) this.mRootView.findViewById(a.f.mystery_person_card_report_btn);
        this.hTo = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hTk = (TextView) this.mRootView.findViewById(a.f.mysterious_text);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hTo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hTo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hTo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hTo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hTo.setIsRound(true);
        this.hTo.setAutoChangeStyle(false);
        this.hTo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hTo.setBorderWidth(BdUtilHelper.getDimens(this.hTh.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.clJ();
            }
        });
        this.hTo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initListener() {
        a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.c.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
            public void clw() {
                c.this.hTh.clr();
            }
        });
        this.hTn.setOnClickListener(this);
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        this.hTr = interfaceC0680a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hTh.getActivity());
            this.hTh.finish();
        } else if (this.bty != null && this.bty.user_info != null && this.bty.user_info.live_status == 1) {
            g gVar = new g(this.hTh);
            gVar.a(this.brk, this.gmc, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bty.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hTh.finish();
        } else {
            if (this.hTt != null && this.hTt.isShowing()) {
                this.hTt.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hTh.getActivity(), true);
            aVar.a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.c.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
                public void clw() {
                    if (c.this.hTr != null) {
                        c.this.hTr.clw();
                    }
                }
            });
            aVar.show();
            this.hTt = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clE() {
        if (this.bty != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hTh.getActivity());
            } else if (this.bty.user_info == null || JavaTypesHelper.toLong(this.bty.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hTh.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bty.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hTh.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bod = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bty.user_info));
                this.hTh.finish();
            }
        }
    }

    private View nn(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hTh.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery_hori, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hTh.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setVisibility(0);
        }
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.haJ == null) {
                        c.this.haJ = AnimationUtils.loadAnimation(c.this.hTh.getActivity(), a.C0194a.sdk_push_up_in);
                    }
                    c.this.hTi.setAnimation(c.this.haJ);
                    c.this.hTi.setVisibility(0);
                    c.this.hTj.setVisibility(0);
                    c.this.hTq.setVisibility(0);
                    c.this.hTp.setVisibility(0);
                    c.this.haJ.setDuration(300L);
                    c.this.haJ.start();
                    c.this.haJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (c.this.hTh.isFinishing()) {
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (!c.this.hTh.isFinishing()) {
                                c.this.cE(c.this.mRootView);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hTi != null) {
            this.hTi.clearAnimation();
        }
        if (this.hTt != null && this.hTt.isShowing()) {
            this.hTt.dismiss();
        }
    }

    public Animation bVW() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.haJ != null) {
            this.haJ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hTh.getActivity(), a.C0194a.sdk_push_up_out);
        this.hTi.setAnimation(loadAnimation);
        this.hTi.setVisibility(8);
        loadAnimation.setDuration(300L);
        loadAnimation.start();
        return loadAnimation;
    }

    public void bjV() {
        if (this.hTt != null && this.hTt.isShowing()) {
            this.hTt.resize();
        }
    }

    public void D(String str, String str2, String str3) {
        this.brk = JavaTypesHelper.toLong(str, 0L);
        this.gmc = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
        this.hTk.setText(str3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTn) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hTh, this.bty}));
        }
    }
}
