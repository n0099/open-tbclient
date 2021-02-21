package com.baidu.tieba.ala.person.view;

import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d.g;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.as;
import com.baidu.live.data.ax;
import com.baidu.live.message.AlaPokeResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.tbadk.schemeability.ISchemeAbility;
import com.baidu.live.tbadk.schemeability.SchemeAbilityManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PersonCardViewNew implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private boolean aJC;
    private View aZQ;
    private long buN;
    private PersonUserData bxd;
    private TextView gPL;
    private long goZ;
    private boolean hUL;
    private boolean hUV;
    protected final PersonCardActivity hXQ;
    private TextView hXW;
    private HeadImageView hXX;
    private LinearLayout hYA;
    private ViewGroup hYB;
    private View hYC;
    private View hYD;
    private View hYE;
    private HeadImageView hYF;
    private ViewGroup hYG;
    private boolean hYH;
    private String hYI;
    private boolean hYJ;
    private boolean hYK;
    private com.baidu.tieba.ala.person.view.a hYL;
    private a hYM;
    private a.InterfaceC0681a hYa;
    private boolean hYb;
    private com.baidu.tieba.ala.person.a hYc;
    private TextView hYg;
    private TextView hYh;
    private TextView hYi;
    private TextView hYj;
    private TextView hYk;
    private TextView hYl;
    private TextView hYm;
    private TextView hYn;
    private TextView hYo;
    private TextView hYp;
    private LinearLayout hYq;
    private ImageView hYr;
    private TextView hYs;
    private TextView hYt;
    private TextView hYu;
    private TextView hYv;
    private TextView hYw;
    private ViewGroup hYx;
    private TbImageView hYy;
    private LinearLayout hYz;
    private Animation hdH;
    private boolean isHost;
    protected View mRootView;
    private int screenWidth;
    private String uid;
    private String otherParams = "";
    private Handler mHandler = new Handler();
    private HttpMessageListener gPb = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    if (TextUtils.isEmpty(alaPokeResponseMessage.getErrorString())) {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hXQ, PersonCardViewNew.this.hXQ.getString(a.h.sdk_poke_poke_once_fail));
                        return;
                    } else {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hXQ, alaPokeResponseMessage.getErrorString());
                        return;
                    }
                }
                if (alaPokeResponseMessage.buT == 1) {
                    PersonCardViewNew.this.gPL.setEnabled(false);
                    PersonCardViewNew.this.gPL.setText(PersonCardViewNew.this.hXQ.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gPL.setTextColor(PersonCardViewNew.this.hXQ.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.buT == 0) {
                    PersonCardViewNew.this.gPL.setVisibility(8);
                }
                PersonCardViewNew.this.hXQ.finish();
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void cmy();

        void cmz();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z, boolean z2) {
        this.hUL = false;
        this.hXQ = personCardActivity;
        this.hYb = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.hUL = z2;
        this.mRootView = ns(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hYL = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hYM = aVar;
    }

    private void initView() {
        this.hYB = (ViewGroup) this.mRootView.findViewById(a.f.person_card_layout);
        this.hXW = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hYq = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hYr = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hYs = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.aZQ = this.mRootView.findViewById(a.f.name_layout);
        this.hYg = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hYh = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hYi = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hYj = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hYl = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hYk = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hYm = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hYn = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hYo = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hYw = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hYp = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hYv = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hYz = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hYC = this.mRootView.findViewById(a.f.user_divide);
        this.hYD = this.mRootView.findViewById(a.f.user_divide2);
        this.hYt = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hYu = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hYx = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hXX = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hYA = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
        this.hXX.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hXX.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hXX.setIsRound(true);
        this.hXX.setAutoChangeStyle(false);
        this.hXX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXX.setBorderWidth(BdUtilHelper.getDimens(this.hXQ.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXX.setBorderColor(872415231);
        this.hYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmO();
            }
        });
        if (!this.hUL) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXW.getLayoutParams();
            layoutParams.addRule(1, this.hYq.getId());
            this.hXW.setLayoutParams(layoutParams);
        }
        this.hYr.setVisibility(8);
        this.hYs.setText(a.h.ala_person_report);
        this.hXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hYI) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hYI);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hXQ.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hXQ.finish();
                }
            }
        });
        this.hYE = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hYF = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hYF.setIsRound(true);
        this.hYF.setAutoChangeStyle(false);
        this.hYF.setDrawBorder(false);
        this.hYF.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gPL = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hYb) {
            this.hYG = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hYG.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gPb);
    }

    private void initListener() {
        this.hXW.setOnClickListener(this);
        this.hYt.setOnClickListener(this);
        this.hYu.setOnClickListener(this);
        this.hYp.setOnClickListener(this);
        a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0681a
            public void cmB() {
                PersonCardViewNew.this.hXQ.cmw();
            }
        });
    }

    public void a(a.InterfaceC0681a interfaceC0681a) {
        this.hYa = interfaceC0681a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bxd = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            e(personUserData);
            i(personUserData);
            this.hYL.setData(personUserData.user_info);
            if (this.hUV || this.hUL) {
                this.hYz.setVisibility(8);
            }
            if (this.hYz != null && this.hYz.getVisibility() == 0) {
                int childCount = this.hYA.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hYA.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hYA.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hYA.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hYA.setWeightSum(i2);
                this.hYA.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hYb || i == 0) {
            this.gPL.setVisibility(8);
        } else {
            this.gPL.setVisibility(0);
        }
        if (i == 1) {
            this.gPL.setEnabled(false);
            this.gPL.setText(this.hXQ.getString(a.h.sdk_poke_had_poked));
            this.gPL.setTextColor(this.hXQ.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gPL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HttpMessage httpMessage = new HttpMessage(1021227);
                httpMessage.addParam("poke_user_id", personUserData.user_info.user_id);
                httpMessage.addParam("live_id", personUserData.live_info.live_id);
                MessageManager.getInstance().sendMessage(httpMessage);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913267, ""));
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_HOST_POKE));
            }
        });
        a(personUserData, z);
    }

    private void e(PersonUserData personUserData) {
        if (!this.hYb) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!as.Cm() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Bh()) {
                        this.hYG.setVisibility(8);
                        return;
                    }
                    this.hYG.setVisibility(0);
                    this.hYG.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Bg())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Bg().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Bg().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hXQ.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, wo(i));
                                this.hYG.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aJC && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hXQ.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hYM != null) {
                                    PersonCardViewNew.this.hYM.cmz();
                                }
                            }
                        });
                        this.hYG.addView(alaPersonTagView2);
                        a(alaPersonTagView2, dimensionPixelSize2, dimensionPixelSize);
                    }
                }
            }
        }
    }

    private void a(AlaPersonTagView alaPersonTagView, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) alaPersonTagView.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
        marginLayoutParams.height = i2;
        alaPersonTagView.setLayoutParams(marginLayoutParams);
    }

    private int wo(int i) {
        return a.e.bg_tag_new;
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aJC = personUserData.user_info != null && this.hXQ.Ij(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hYI = personUserData.user_info != null ? personUserData.user_info.aOt : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hYJ = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hYJ) {
                this.hYz.setVisibility(8);
            } else {
                this.hYz.setVisibility(0);
            }
            if (!z) {
                this.hYm.setText("火星");
            } else {
                this.hYm.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hYv.setVisibility(8);
                this.hYD.setVisibility(8);
            } else {
                this.hYv.setText(String.format(this.hXQ.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hYD.setVisibility(0);
                this.hYv.setVisibility(0);
            }
            if (z2) {
                this.hYo.setText(String.format(this.hXQ.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hYo.setVisibility(0);
                this.hYC.setVisibility(0);
                return;
            }
            this.hYo.setVisibility(8);
            this.hYC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hXQ.getActivity());
            this.hXQ.finish();
        } else if (this.bxd != null && this.bxd.user_info != null && this.bxd.user_info.live_status == 1) {
            g gVar = new g(this.hXQ);
            gVar.a(this.buN, this.goZ, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bxd.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hXQ.finish();
        } else {
            if (this.hYc != null && this.hYc.isShowing()) {
                this.hYc.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hXQ.getActivity(), true);
            aVar.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0681a
                public void cmB() {
                    if (PersonCardViewNew.this.hYa != null) {
                        PersonCardViewNew.this.hYa.cmB();
                    }
                }
            });
            aVar.show();
            this.hYc = aVar;
        }
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(axVar.fans_count < 0 ? 0L : axVar.fans_count);
            this.hYh.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hYj.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(axVar.follow_count < 0 ? 0L : axVar.follow_count);
            this.hYn.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hYk.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hYi.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hYl.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hYl.setText("");
            }
            int i2 = this.hYb ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hYb) {
                i = 22;
            }
            this.hYh.setTextSize(1, i);
            this.hYn.setTextSize(1, i);
            this.hYi.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hXW.setVisibility(8);
                this.hYq.setVisibility(8);
            } else if (this.hXQ.Ij(TbadkCoreApplication.getCurrentAccount())) {
                this.hYq.setVisibility(8);
                if (!this.hUL) {
                    this.hXW.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                }
                this.hXW.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hXW.setVisibility(0);
                this.hYq.setVisibility(0);
            } else {
                this.hYq.setVisibility(0);
                this.hXW.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null && !StringUtils.isNull(axVar.getNameShow())) {
            String nameShow = axVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hYg.setText(nameShow);
        }
        m.a(this.hXX, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(axVar.description)) {
            this.hYw.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hYw.setText(axVar.description);
        }
        Il(axVar.aOp);
    }

    private void Il(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hYy == null) {
                this.hYy = new TbImageView(this.hYx.getContext());
            }
            this.hYy.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hYx != null && PersonCardViewNew.this.hYy != null && PersonCardViewNew.this.hYy.getLoadedWidth() > 0 && PersonCardViewNew.this.hYy.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hYb) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hYy.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hYx.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hYy.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hYx.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hXX != null && !PersonCardViewNew.this.hUL) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXX.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hXX.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hXX.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hYx.indexOfChild(PersonCardViewNew.this.hYy) < 0) {
                            PersonCardViewNew.this.hYx.addView(PersonCardViewNew.this.hYy, PersonCardViewNew.this.hYx.indexOfChild(PersonCardViewNew.this.hXX) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hYq.getVisibility() == 0 && PersonCardViewNew.this.hXW.getVisibility() == 0) {
                            PersonCardViewNew.this.hXW.setPadding(PersonCardViewNew.this.hXW.getPaddingLeft(), PersonCardViewNew.this.hXW.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hXW.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXW.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hXW.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hYy.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hYH = false;
            oV(false);
        } else if (!this.hYJ && (alaRelationData = personUserData.relation_info) != null) {
            this.hYH = alaRelationData.follow_status != 0;
            if (z) {
                this.hYp.setVisibility(8);
            } else {
                oV(this.hYH);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hYE.setVisibility(0);
            this.hYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hYM != null) {
                        PersonCardViewNew.this.hYM.cmy();
                    }
                }
            });
            this.hYF.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hYE.setVisibility(4);
    }

    private void oV(boolean z) {
        if (z) {
            this.hYp.setText("已关注");
            this.hYp.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hYp.setText("关注");
            this.hYp.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hYp.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hYt != null && personUserData != null && personUserData.user_info != null) {
            this.hYt.setVisibility((this.hYK && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hYp) {
            cmQ();
        } else if (view == this.hYu) {
            cmJ();
        } else if (view == this.hYt) {
            cmP();
        } else if (view == this.hXW) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hXQ, this.bxd}));
        }
    }

    private void cmP() {
        JSONObject jSONObject;
        if (this.hXQ != null && this.bxd != null && this.bxd.user_info != null && !TextUtils.isEmpty(this.bxd.user_info.live_id)) {
            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(this.bxd.user_info.live_id)));
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hXQ.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bxd.user_info.live_id), this.bxd.live_info.room_id + "", "live_sdk");
                try {
                    String flvUrl = this.bxd.live_info.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    String str = this.bxd.live_info.cover;
                    String valueOf = String.valueOf(this.bxd.live_info.room_id);
                    String valueOf2 = String.valueOf(this.bxd.live_info.live_id);
                    if (TextUtils.isEmpty(this.otherParams)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(this.otherParams);
                    }
                    jSONObject.put("live_url", flvUrl);
                    jSONObject.put("cover", str);
                    jSONObject.put("enterRoomId", valueOf);
                    jSONObject.put("enterLiveId", valueOf2);
                    jSONObject.put("screen_direction", this.bxd.live_info.screen_direction);
                    this.otherParams = jSONObject.toString();
                    alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
                this.hXQ.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmJ() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXQ.getActivity());
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXQ.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hXQ.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.brE = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bxd.user_info));
                this.hXQ.finish();
            }
        }
    }

    private void cmQ() {
        String str;
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXQ.getActivity());
                this.hXQ.finish();
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXQ.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hYH) {
                    wp(1);
                    this.hXQ.cmv();
                } else {
                    wp(0);
                    this.hXQ.cmu();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (!TextUtils.isEmpty(this.bxd.user_info.user_id)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uid", this.bxd.user_info.user_id);
                        jSONObject.put("follow", this.hYH ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hYH ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aJC) {
                        str = "author_profile";
                    } else {
                        str = "guest_profile";
                    }
                    alaStaticItem2.addParams("loc", str);
                    alaStaticItem2.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    }

    public void wp(int i) {
        switch (i) {
            case 0:
                this.hYH = true;
                oV(true);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hYh.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hYj.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hYH = false;
                oV(false);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hYh.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hYj.setText(formatForPersonCardBeanValue2[1]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void oW(boolean z) {
        if (this.bxd != null && this.bxd.user_info != null) {
            if (z) {
                this.bxd.user_info.follow_count++;
            } else {
                this.bxd.user_info.follow_count--;
            }
            if (this.bxd.user_info.follow_count < 0) {
                this.bxd.user_info.follow_count = 0L;
            }
            this.hYp.setText(com.baidu.tieba.ala.person.d.a.bg(this.bxd.user_info.follow_count));
        }
    }

    private View ns(boolean z) {
        if (this.hUL) {
            if (z) {
                return LayoutInflater.from(this.hXQ.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery_hori, (ViewGroup) null);
            }
            return LayoutInflater.from(this.hXQ.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery, (ViewGroup) null);
        } else if (z) {
            return LayoutInflater.from(this.hXQ.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        } else {
            return LayoutInflater.from(this.hXQ.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oX(boolean z) {
        this.hUV = z;
    }

    public void oY(boolean z) {
        this.hYK = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hdH == null) {
                        PersonCardViewNew.this.hdH = AnimationUtils.loadAnimation(PersonCardViewNew.this.hXQ.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hYB.setAnimation(PersonCardViewNew.this.hdH);
                    PersonCardViewNew.this.hYB.setVisibility(0);
                    PersonCardViewNew.this.hdH.setDuration(300L);
                    PersonCardViewNew.this.hdH.start();
                    PersonCardViewNew.this.hdH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (PersonCardViewNew.this.hXQ.isFinishing()) {
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
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
        if (this.hYB != null) {
            this.hYB.clearAnimation();
        }
        if (this.hYc != null && this.hYc.isShowing()) {
            this.hYc.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gPb);
    }

    public Animation bWH() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdH != null) {
            this.hdH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hXQ.getActivity(), a.C0195a.sdk_push_up_out);
        this.hYB.setAnimation(loadAnimation);
        this.hYB.setVisibility(8);
        return loadAnimation;
    }

    public void bkp() {
        if (this.hYc != null && this.hYc.isShowing()) {
            this.hYc.resize();
        }
        if (this.bxd != null && this.bxd.user_info != null) {
            Il(this.bxd.user_info.aOp);
        }
    }

    public void aN(String str, String str2) {
        this.buN = JavaTypesHelper.toLong(str, 0L);
        this.goZ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
