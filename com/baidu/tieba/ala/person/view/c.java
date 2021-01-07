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
/* loaded from: classes11.dex */
public class c implements View.OnClickListener {
    private TextView aGM;
    private long bvY;
    private PersonUserData byl;
    private long gqJ;
    protected final PersonCardActivity hXO;
    private View hXP;
    private View hXQ;
    private TextView hXR;
    private Button hXS;
    private Button hXT;
    private TextView hXU;
    private HeadImageView hXV;
    private ImageView hXW;
    private View hXX;
    private a.InterfaceC0697a hXY;
    private boolean hXZ;
    private com.baidu.tieba.ala.person.a hYa;
    private Animation hfp;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private int screenWidth;
    private String uid;

    public c(final PersonCardActivity personCardActivity, boolean z) {
        this.hXO = personCardActivity;
        this.hXZ = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = nr(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
    }

    public void eE(String str, String str2) {
        if (str != null && str2 != null) {
            this.aGM.setText(str);
            m.a(this.hXV, str2, true, false);
        }
    }

    public void d(PersonUserData personUserData) {
        this.byl = personUserData;
        at atVar = personUserData.user_info;
        if (atVar != null) {
            if (!StringUtils.isNull(atVar.getNameShow())) {
                String nameShow = atVar.getNameShow();
                if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                    nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
                }
                this.aGM.setText(nameShow);
            }
            m.a(this.hXV, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hXU.setVisibility(8);
                this.hXT.setVisibility(8);
            } else if (this.hXO.IP(TbadkCoreApplication.getCurrentAccount())) {
                this.hXT.setVisibility(8);
                this.hXU.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hXU.setVisibility(0);
                this.hXT.setVisibility(0);
            } else {
                this.hXT.setVisibility(0);
                this.hXU.setVisibility(8);
            }
        }
    }

    private void initView() {
        this.hXP = this.mRootView.findViewById(a.f.mystery_person_card_frame);
        this.hXQ = this.mRootView.findViewById(a.f.mystery_person_card_layout);
        this.aGM = (TextView) this.mRootView.findViewById(a.f.person_card_user_name);
        this.hXU = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hXS = (Button) this.mRootView.findViewById(a.f.person_card_at_button);
        this.hXW = (ImageView) this.mRootView.findViewById(a.f.card_decoration);
        this.hXX = this.mRootView.findViewById(a.f.user_portrait_layout);
        this.hXS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cpw();
            }
        });
        this.hXT = (Button) this.mRootView.findViewById(a.f.mystery_person_card_report_btn);
        this.hXV = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hXR = (TextView) this.mRootView.findViewById(a.f.mysterious_text);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hXV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hXV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hXV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hXV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hXV.setIsRound(true);
        this.hXV.setAutoChangeStyle(false);
        this.hXV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXV.setBorderWidth(BdUtilHelper.getDimens(this.hXO.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cpB();
            }
        });
        this.hXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initListener() {
        a(new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.person.view.c.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0697a
            public void cpo() {
                c.this.hXO.cpj();
            }
        });
        this.hXU.setOnClickListener(this);
    }

    public void a(a.InterfaceC0697a interfaceC0697a) {
        this.hXY = interfaceC0697a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpB() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hXO.getActivity());
            this.hXO.finish();
        } else if (this.byl != null && this.byl.user_info != null && this.byl.user_info.live_status == 1) {
            g gVar = new g(this.hXO);
            gVar.a(this.bvY, this.gqJ, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.byl.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hXO.finish();
        } else {
            if (this.hYa != null && this.hYa.isShowing()) {
                this.hYa.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hXO.getActivity(), true);
            aVar.a(new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.person.view.c.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0697a
                public void cpo() {
                    if (c.this.hXY != null) {
                        c.this.hXY.cpo();
                    }
                }
            });
            aVar.show();
            this.hYa = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpw() {
        if (this.byl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXO.getActivity());
            } else if (this.byl.user_info == null || JavaTypesHelper.toLong(this.byl.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXO.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.byl.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hXO.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bsP = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.byl.user_info));
                this.hXO.finish();
            }
        }
    }

    private View nr(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hXO.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery_hori, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hXO.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery, (ViewGroup) null);
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
                    if (c.this.hfp == null) {
                        c.this.hfp = AnimationUtils.loadAnimation(c.this.hXO.getActivity(), a.C0203a.sdk_push_up_in);
                    }
                    c.this.hXP.setAnimation(c.this.hfp);
                    c.this.hXP.setVisibility(0);
                    c.this.hXQ.setVisibility(0);
                    c.this.hXX.setVisibility(0);
                    c.this.hXW.setVisibility(0);
                    c.this.hfp.setDuration(300L);
                    c.this.hfp.start();
                    c.this.hfp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (c.this.hXO.isFinishing()) {
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (!c.this.hXO.isFinishing()) {
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
        if (this.hXP != null) {
            this.hXP.clearAnimation();
        }
        if (this.hYa != null && this.hYa.isShowing()) {
            this.hYa.dismiss();
        }
    }

    public Animation bZO() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfp != null) {
            this.hfp.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hXO.getActivity(), a.C0203a.sdk_push_up_out);
        this.hXP.setAnimation(loadAnimation);
        this.hXP.setVisibility(8);
        loadAnimation.setDuration(300L);
        loadAnimation.start();
        return loadAnimation;
    }

    public void bnP() {
        if (this.hYa != null && this.hYa.isShowing()) {
            this.hYa.resize();
        }
    }

    public void E(String str, String str2, String str3) {
        this.bvY = JavaTypesHelper.toLong(str, 0L);
        this.gqJ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
        this.hXR.setText(str3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hXU) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hXO, this.byl}));
        }
    }
}
