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
import com.baidu.live.data.ao;
import com.baidu.live.data.at;
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
    private boolean aLL;
    private View bby;
    private long bvY;
    private PersonUserData byl;
    private TextView gRx;
    private long gqJ;
    private boolean hUJ;
    private boolean hUT;
    protected final PersonCardActivity hXO;
    private TextView hXU;
    private HeadImageView hXV;
    private a.InterfaceC0697a hXY;
    private boolean hXZ;
    private View hYA;
    private View hYB;
    private View hYC;
    private HeadImageView hYD;
    private ViewGroup hYE;
    private boolean hYF;
    private String hYG;
    private boolean hYH;
    private boolean hYI;
    private com.baidu.tieba.ala.person.view.a hYJ;
    private a hYK;
    private com.baidu.tieba.ala.person.a hYa;
    private TextView hYe;
    private TextView hYf;
    private TextView hYg;
    private TextView hYh;
    private TextView hYi;
    private TextView hYj;
    private TextView hYk;
    private TextView hYl;
    private TextView hYm;
    private TextView hYn;
    private LinearLayout hYo;
    private ImageView hYp;
    private TextView hYq;
    private TextView hYr;
    private TextView hYs;
    private TextView hYt;
    private TextView hYu;
    private ViewGroup hYv;
    private TbImageView hYw;
    private LinearLayout hYx;
    private LinearLayout hYy;
    private ViewGroup hYz;
    private Animation hfp;
    private boolean isHost;
    protected View mRootView;
    private int screenWidth;
    private String uid;
    private String otherParams = "";
    private Handler mHandler = new Handler();
    private HttpMessageListener gQN = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    if (TextUtils.isEmpty(alaPokeResponseMessage.getErrorString())) {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hXO, PersonCardViewNew.this.hXO.getString(a.h.sdk_poke_poke_once_fail));
                        return;
                    } else {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hXO, alaPokeResponseMessage.getErrorString());
                        return;
                    }
                }
                if (alaPokeResponseMessage.bwe == 1) {
                    PersonCardViewNew.this.gRx.setEnabled(false);
                    PersonCardViewNew.this.gRx.setText(PersonCardViewNew.this.hXO.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gRx.setTextColor(PersonCardViewNew.this.hXO.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.bwe == 0) {
                    PersonCardViewNew.this.gRx.setVisibility(8);
                }
                PersonCardViewNew.this.hXO.finish();
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void cpk();

        void cpl();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z, boolean z2) {
        this.hUJ = false;
        this.hXO = personCardActivity;
        this.hXZ = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.hUJ = z2;
        this.mRootView = nr(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hYJ = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hYK = aVar;
    }

    private void initView() {
        this.hYz = (ViewGroup) this.mRootView.findViewById(a.f.person_card_layout);
        this.hXU = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hYo = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hYp = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hYq = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.bby = this.mRootView.findViewById(a.f.name_layout);
        this.hYe = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hYf = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hYg = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hYh = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hYj = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hYi = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hYk = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hYl = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hYm = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hYu = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hYn = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hYt = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hYx = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hYA = this.mRootView.findViewById(a.f.user_divide);
        this.hYB = this.mRootView.findViewById(a.f.user_divide2);
        this.hYr = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hYs = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hYv = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hXV = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hYy = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
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
        this.hXV.setBorderColor(872415231);
        this.hYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cpA();
            }
        });
        if (!this.hUJ) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXU.getLayoutParams();
            layoutParams.addRule(1, this.hYo.getId());
            this.hXU.setLayoutParams(layoutParams);
        }
        this.hYp.setVisibility(8);
        this.hYq.setText(a.h.ala_person_report);
        this.hXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hYG) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hYG);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hXO.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hXO.finish();
                }
            }
        });
        this.hYC = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hYD = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hYD.setIsRound(true);
        this.hYD.setAutoChangeStyle(false);
        this.hYD.setDrawBorder(false);
        this.hYD.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gRx = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hXZ) {
            this.hYE = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hYE.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gQN);
    }

    private void initListener() {
        this.hXU.setOnClickListener(this);
        this.hYr.setOnClickListener(this);
        this.hYs.setOnClickListener(this);
        this.hYn.setOnClickListener(this);
        a(new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0697a
            public void cpn() {
                PersonCardViewNew.this.hXO.cpi();
            }
        });
    }

    public void a(a.InterfaceC0697a interfaceC0697a) {
        this.hXY = interfaceC0697a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.byl = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            e(personUserData);
            i(personUserData);
            this.hYJ.setData(personUserData.user_info);
            if (this.hUT || this.hUJ) {
                this.hYx.setVisibility(8);
            }
            if (this.hYx != null && this.hYx.getVisibility() == 0) {
                int childCount = this.hYy.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hYy.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hYy.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hYy.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hYy.setWeightSum(i2);
                this.hYy.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hXZ || i == 0) {
            this.gRx.setVisibility(8);
        } else {
            this.gRx.setVisibility(0);
        }
        if (i == 1) {
            this.gRx.setEnabled(false);
            this.gRx.setText(this.hXO.getString(a.h.sdk_poke_had_poked));
            this.gRx.setTextColor(this.hXO.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
        if (!this.hXZ) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ao.EU() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Es()) {
                        this.hYE.setVisibility(8);
                        return;
                    }
                    this.hYE.setVisibility(0);
                    this.hYE.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Er())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Er().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Er().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hXO.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, xJ(i));
                                this.hYE.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aLL && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hXO.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hYK != null) {
                                    PersonCardViewNew.this.hYK.cpl();
                                }
                            }
                        });
                        this.hYE.addView(alaPersonTagView2);
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

    private int xJ(int i) {
        return a.e.bg_tag_new;
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aLL = personUserData.user_info != null && this.hXO.IQ(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hYG = personUserData.user_info != null ? personUserData.user_info.aQj : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hYH = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hYH) {
                this.hYx.setVisibility(8);
            } else {
                this.hYx.setVisibility(0);
            }
            if (!z) {
                this.hYk.setText("火星");
            } else {
                this.hYk.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hYt.setVisibility(8);
                this.hYB.setVisibility(8);
            } else {
                this.hYt.setText(String.format(this.hXO.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hYB.setVisibility(0);
                this.hYt.setVisibility(0);
            }
            if (z2) {
                this.hYm.setText(String.format(this.hXO.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hYm.setVisibility(0);
                this.hYA.setVisibility(0);
                return;
            }
            this.hYm.setVisibility(8);
            this.hYA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpA() {
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
            aVar.a(new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0697a
                public void cpn() {
                    if (PersonCardViewNew.this.hXY != null) {
                        PersonCardViewNew.this.hXY.cpn();
                    }
                }
            });
            aVar.show();
            this.hYa = aVar;
        }
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        at atVar = personUserData.user_info;
        if (atVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(atVar.fans_count < 0 ? 0L : atVar.fans_count);
            this.hYf.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hYh.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(atVar.follow_count < 0 ? 0L : atVar.follow_count);
            this.hYl.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hYi.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hYg.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hYj.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hYj.setText("");
            }
            int i2 = this.hXZ ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hXZ) {
                i = 22;
            }
            this.hYf.setTextSize(1, i);
            this.hYl.setTextSize(1, i);
            this.hYg.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hXU.setVisibility(8);
                this.hYo.setVisibility(8);
            } else if (this.hXO.IQ(TbadkCoreApplication.getCurrentAccount())) {
                this.hYo.setVisibility(8);
                if (!this.hUJ) {
                    this.hXU.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                }
                this.hXU.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hXU.setVisibility(0);
                this.hYo.setVisibility(0);
            } else {
                this.hYo.setVisibility(0);
                this.hXU.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        at atVar = personUserData.user_info;
        if (atVar != null && !StringUtils.isNull(atVar.getNameShow())) {
            String nameShow = atVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hYe.setText(nameShow);
        }
        m.a(this.hXV, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(atVar.description)) {
            this.hYu.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hYu.setText(atVar.description);
        }
        IS(atVar.aQf);
    }

    private void IS(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hYw == null) {
                this.hYw = new TbImageView(this.hYv.getContext());
            }
            this.hYw.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hYv != null && PersonCardViewNew.this.hYw != null && PersonCardViewNew.this.hYw.getLoadedWidth() > 0 && PersonCardViewNew.this.hYw.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hXZ) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hYw.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hYv.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hYw.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hYv.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hXV != null && !PersonCardViewNew.this.hUJ) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXV.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hXV.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hXV.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hYv.indexOfChild(PersonCardViewNew.this.hYw) < 0) {
                            PersonCardViewNew.this.hYv.addView(PersonCardViewNew.this.hYw, PersonCardViewNew.this.hYv.indexOfChild(PersonCardViewNew.this.hXV) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hYo.getVisibility() == 0 && PersonCardViewNew.this.hXU.getVisibility() == 0) {
                            PersonCardViewNew.this.hXU.setPadding(PersonCardViewNew.this.hXU.getPaddingLeft(), PersonCardViewNew.this.hXU.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hXU.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXU.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hXU.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hYw.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hYF = false;
            oP(false);
        } else if (!this.hYH && (alaRelationData = personUserData.relation_info) != null) {
            this.hYF = alaRelationData.follow_status != 0;
            if (z) {
                this.hYn.setVisibility(8);
            } else {
                oP(this.hYF);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hYC.setVisibility(0);
            this.hYC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hYK != null) {
                        PersonCardViewNew.this.hYK.cpk();
                    }
                }
            });
            this.hYD.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hYC.setVisibility(4);
    }

    private void oP(boolean z) {
        if (z) {
            this.hYn.setText("已关注");
            this.hYn.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hYn.setText("关注");
            this.hYn.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hYn.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hYr != null && personUserData != null && personUserData.user_info != null) {
            this.hYr.setVisibility((this.hYI && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hYn) {
            cpC();
        } else if (view == this.hYs) {
            cpv();
        } else if (view == this.hYr) {
            cpB();
        } else if (view == this.hXU) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hXO, this.byl}));
        }
    }

    private void cpB() {
        JSONObject jSONObject;
        if (this.hXO != null && this.byl != null && this.byl.user_info != null && !TextUtils.isEmpty(this.byl.user_info.live_id)) {
            com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(this.byl.user_info.live_id)));
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hXO.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.byl.user_info.live_id), "", "live_sdk");
                try {
                    String flvUrl = this.byl.live_info.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    String str = this.byl.live_info.cover;
                    String valueOf = String.valueOf(this.byl.live_info.room_id);
                    String valueOf2 = String.valueOf(this.byl.live_info.live_id);
                    if (TextUtils.isEmpty(this.otherParams)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(this.otherParams);
                    }
                    jSONObject.put("live_url", flvUrl);
                    jSONObject.put("cover", str);
                    jSONObject.put("enterRoomId", valueOf);
                    jSONObject.put("enterLiveId", valueOf2);
                    jSONObject.put("screen_direction", this.byl.live_info.screen_direction);
                    this.otherParams = jSONObject.toString();
                    alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                this.hXO.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cpv() {
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

    private void cpC() {
        String str;
        if (this.byl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXO.getActivity());
                this.hXO.finish();
            } else if (this.byl.user_info == null || JavaTypesHelper.toLong(this.byl.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXO.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hYF) {
                    xK(1);
                    this.hXO.cph();
                } else {
                    xK(0);
                    this.hXO.cpg();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (!TextUtils.isEmpty(this.byl.user_info.user_id)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uid", this.byl.user_info.user_id);
                        jSONObject.put("follow", this.hYF ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hYF ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aLL) {
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

    public void xK(int i) {
        switch (i) {
            case 0:
                this.hYF = true;
                oP(true);
                if (this.byl != null && this.byl.user_info != null) {
                    this.byl.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.byl.user_info.fans_count >= 0 ? this.byl.user_info.fans_count : 0L);
                    this.hYf.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hYh.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hYF = false;
                oP(false);
                if (this.byl != null && this.byl.user_info != null) {
                    this.byl.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.byl.user_info.fans_count >= 0 ? this.byl.user_info.fans_count : 0L);
                    this.hYf.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hYh.setText(formatForPersonCardBeanValue2[1]);
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

    public void oQ(boolean z) {
        if (this.byl != null && this.byl.user_info != null) {
            if (z) {
                this.byl.user_info.follow_count++;
            } else {
                this.byl.user_info.follow_count--;
            }
            if (this.byl.user_info.follow_count < 0) {
                this.byl.user_info.follow_count = 0L;
            }
            this.hYn.setText(com.baidu.tieba.ala.person.d.a.bc(this.byl.user_info.follow_count));
        }
    }

    private View nr(boolean z) {
        if (this.hUJ) {
            if (z) {
                return LayoutInflater.from(this.hXO.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery_hori, (ViewGroup) null);
            }
            return LayoutInflater.from(this.hXO.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery, (ViewGroup) null);
        } else if (z) {
            return LayoutInflater.from(this.hXO.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        } else {
            return LayoutInflater.from(this.hXO.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oR(boolean z) {
        this.hUT = z;
    }

    public void oS(boolean z) {
        this.hYI = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hfp == null) {
                        PersonCardViewNew.this.hfp = AnimationUtils.loadAnimation(PersonCardViewNew.this.hXO.getActivity(), a.C0203a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hYz.setAnimation(PersonCardViewNew.this.hfp);
                    PersonCardViewNew.this.hYz.setVisibility(0);
                    PersonCardViewNew.this.hfp.setDuration(300L);
                    PersonCardViewNew.this.hfp.start();
                    PersonCardViewNew.this.hfp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (PersonCardViewNew.this.hXO.isFinishing()) {
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
        if (this.hYz != null) {
            this.hYz.clearAnimation();
        }
        if (this.hYa != null && this.hYa.isShowing()) {
            this.hYa.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gQN);
    }

    public Animation bZN() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfp != null) {
            this.hfp.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hXO.getActivity(), a.C0203a.sdk_push_up_out);
        this.hYz.setAnimation(loadAnimation);
        this.hYz.setVisibility(8);
        return loadAnimation;
    }

    public void bnO() {
        if (this.hYa != null && this.hYa.isShowing()) {
            this.hYa.resize();
        }
        if (this.byl != null && this.byl.user_info != null) {
            IS(this.byl.user_info.aQf);
        }
    }

    public void aO(String str, String str2) {
        this.bvY = JavaTypesHelper.toLong(str, 0L);
        this.gqJ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
