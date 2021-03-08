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
/* loaded from: classes10.dex */
public class PersonCardViewNew implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private boolean aLc;
    private View bbr;
    private long bwn;
    private PersonUserData byD;
    private TextView gRu;
    private long gqI;
    private boolean hWE;
    private boolean hWu;
    private TextView hZF;
    private HeadImageView hZG;
    private a.InterfaceC0687a hZJ;
    private boolean hZK;
    private com.baidu.tieba.ala.person.a hZL;
    private TextView hZP;
    private TextView hZQ;
    private TextView hZR;
    private TextView hZS;
    private TextView hZT;
    private TextView hZU;
    private TextView hZV;
    private TextView hZW;
    private TextView hZX;
    private TextView hZY;
    private LinearLayout hZZ;
    protected final PersonCardActivity hZz;
    private Animation hfq;
    private ImageView iaa;
    private TextView iab;
    private TextView iac;
    private TextView iad;
    private TextView iae;
    private TextView iaf;
    private ViewGroup iag;
    private TbImageView iah;
    private LinearLayout iai;
    private LinearLayout iaj;
    private ViewGroup iak;
    private View ial;
    private View iam;
    private View ian;
    private HeadImageView iao;
    private ViewGroup iap;
    private boolean iaq;
    private String iar;
    private boolean ias;
    private boolean iat;
    private com.baidu.tieba.ala.person.view.a iau;
    private a iav;
    private boolean isHost;
    protected View mRootView;
    private int screenWidth;
    private String uid;
    private String otherParams = "";
    private Handler mHandler = new Handler();
    private HttpMessageListener gQK = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    if (TextUtils.isEmpty(alaPokeResponseMessage.getErrorString())) {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hZz, PersonCardViewNew.this.hZz.getString(a.h.sdk_poke_poke_once_fail));
                        return;
                    } else {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hZz, alaPokeResponseMessage.getErrorString());
                        return;
                    }
                }
                if (alaPokeResponseMessage.bwt == 1) {
                    PersonCardViewNew.this.gRu.setEnabled(false);
                    PersonCardViewNew.this.gRu.setText(PersonCardViewNew.this.hZz.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gRu.setTextColor(PersonCardViewNew.this.hZz.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.bwt == 0) {
                    PersonCardViewNew.this.gRu.setVisibility(8);
                }
                PersonCardViewNew.this.hZz.finish();
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void cmE();

        void cmF();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z, boolean z2) {
        this.hWu = false;
        this.hZz = personCardActivity;
        this.hZK = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.hWu = z2;
        this.mRootView = ns(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.iau = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.iav = aVar;
    }

    private void initView() {
        this.iak = (ViewGroup) this.mRootView.findViewById(a.f.person_card_layout);
        this.hZF = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hZZ = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.iaa = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.iab = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.bbr = this.mRootView.findViewById(a.f.name_layout);
        this.hZP = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hZQ = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hZR = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hZS = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hZU = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hZT = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hZV = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hZW = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hZX = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.iaf = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hZY = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.iae = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.iai = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.ial = this.mRootView.findViewById(a.f.user_divide);
        this.iam = this.mRootView.findViewById(a.f.user_divide2);
        this.iac = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.iad = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.iag = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hZG = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.iaj = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
        this.hZG.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hZG.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hZG.setIsRound(true);
        this.hZG.setAutoChangeStyle(false);
        this.hZG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hZG.setBorderWidth(BdUtilHelper.getDimens(this.hZz.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hZG.setBorderColor(872415231);
        this.hZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmU();
            }
        });
        if (!this.hWu) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZF.getLayoutParams();
            layoutParams.addRule(1, this.hZZ.getId());
            this.hZF.setLayoutParams(layoutParams);
        }
        this.iaa.setVisibility(8);
        this.iab.setText(a.h.ala_person_report);
        this.hZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.iar) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.iar);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hZz.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hZz.finish();
                }
            }
        });
        this.ian = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.iao = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.iao.setIsRound(true);
        this.iao.setAutoChangeStyle(false);
        this.iao.setDrawBorder(false);
        this.iao.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gRu = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hZK) {
            this.iap = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.iap.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gQK);
    }

    private void initListener() {
        this.hZF.setOnClickListener(this);
        this.iac.setOnClickListener(this);
        this.iad.setOnClickListener(this);
        this.hZY.setOnClickListener(this);
        a(new a.InterfaceC0687a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0687a
            public void cmH() {
                PersonCardViewNew.this.hZz.cmC();
            }
        });
    }

    public void a(a.InterfaceC0687a interfaceC0687a) {
        this.hZJ = interfaceC0687a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.byD = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            e(personUserData);
            i(personUserData);
            this.iau.setData(personUserData.user_info);
            if (this.hWE || this.hWu) {
                this.iai.setVisibility(8);
            }
            if (this.iai != null && this.iai.getVisibility() == 0) {
                int childCount = this.iaj.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.iaj.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.iaj.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.iaj.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.iaj.setWeightSum(i2);
                this.iaj.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hZK || i == 0) {
            this.gRu.setVisibility(8);
        } else {
            this.gRu.setVisibility(0);
        }
        if (i == 1) {
            this.gRu.setEnabled(false);
            this.gRu.setText(this.hZz.getString(a.h.sdk_poke_had_poked));
            this.gRu.setTextColor(this.hZz.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
        if (!this.hZK) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!as.Cp() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Bk()) {
                        this.iap.setVisibility(8);
                        return;
                    }
                    this.iap.setVisibility(0);
                    this.iap.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Bj())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Bj().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Bj().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hZz.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, wp(i));
                                this.iap.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aLc && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hZz.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.iav != null) {
                                    PersonCardViewNew.this.iav.cmF();
                                }
                            }
                        });
                        this.iap.addView(alaPersonTagView2);
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

    private int wp(int i) {
        return a.e.bg_tag_new;
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aLc = personUserData.user_info != null && this.hZz.Is(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.iar = personUserData.user_info != null ? personUserData.user_info.aPT : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.ias = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.ias) {
                this.iai.setVisibility(8);
            } else {
                this.iai.setVisibility(0);
            }
            if (!z) {
                this.hZV.setText("火星");
            } else {
                this.hZV.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.iae.setVisibility(8);
                this.iam.setVisibility(8);
            } else {
                this.iae.setText(String.format(this.hZz.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.iam.setVisibility(0);
                this.iae.setVisibility(0);
            }
            if (z2) {
                this.hZX.setText(String.format(this.hZz.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hZX.setVisibility(0);
                this.ial.setVisibility(0);
                return;
            }
            this.hZX.setVisibility(8);
            this.ial.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hZz.getActivity());
            this.hZz.finish();
        } else if (this.byD != null && this.byD.user_info != null && this.byD.user_info.live_status == 1) {
            g gVar = new g(this.hZz);
            gVar.a(this.bwn, this.gqI, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.byD.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hZz.finish();
        } else {
            if (this.hZL != null && this.hZL.isShowing()) {
                this.hZL.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hZz.getActivity(), true);
            aVar.a(new a.InterfaceC0687a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0687a
                public void cmH() {
                    if (PersonCardViewNew.this.hZJ != null) {
                        PersonCardViewNew.this.hZJ.cmH();
                    }
                }
            });
            aVar.show();
            this.hZL = aVar;
        }
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(axVar.fans_count < 0 ? 0L : axVar.fans_count);
            this.hZQ.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hZS.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(axVar.follow_count < 0 ? 0L : axVar.follow_count);
            this.hZW.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hZT.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hZR.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hZU.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hZU.setText("");
            }
            int i2 = this.hZK ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hZK) {
                i = 22;
            }
            this.hZQ.setTextSize(1, i);
            this.hZW.setTextSize(1, i);
            this.hZR.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hZF.setVisibility(8);
                this.hZZ.setVisibility(8);
            } else if (this.hZz.Is(TbadkCoreApplication.getCurrentAccount())) {
                this.hZZ.setVisibility(8);
                if (!this.hWu) {
                    this.hZF.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                }
                this.hZF.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hZF.setVisibility(0);
                this.hZZ.setVisibility(0);
            } else {
                this.hZZ.setVisibility(0);
                this.hZF.setVisibility(8);
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
            this.hZP.setText(nameShow);
        }
        m.a(this.hZG, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(axVar.description)) {
            this.iaf.setText(a.h.ala_person_desc_default_text);
        } else {
            this.iaf.setText(axVar.description);
        }
        Iu(axVar.aPP);
    }

    private void Iu(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.iah == null) {
                this.iah = new TbImageView(this.iag.getContext());
            }
            this.iah.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.iag != null && PersonCardViewNew.this.iah != null && PersonCardViewNew.this.iah.getLoadedWidth() > 0 && PersonCardViewNew.this.iah.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hZK) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.iah.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.iag.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.iah.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.iag.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hZG != null && !PersonCardViewNew.this.hWu) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hZG.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hZG.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hZG.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.iag.indexOfChild(PersonCardViewNew.this.iah) < 0) {
                            PersonCardViewNew.this.iag.addView(PersonCardViewNew.this.iah, PersonCardViewNew.this.iag.indexOfChild(PersonCardViewNew.this.hZG) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hZZ.getVisibility() == 0 && PersonCardViewNew.this.hZF.getVisibility() == 0) {
                            PersonCardViewNew.this.hZF.setPadding(PersonCardViewNew.this.hZF.getPaddingLeft(), PersonCardViewNew.this.hZF.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hZF.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hZF.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hZF.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.iah.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.iaq = false;
            oV(false);
        } else if (!this.ias && (alaRelationData = personUserData.relation_info) != null) {
            this.iaq = alaRelationData.follow_status != 0;
            if (z) {
                this.hZY.setVisibility(8);
            } else {
                oV(this.iaq);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.ian.setVisibility(0);
            this.ian.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.iav != null) {
                        PersonCardViewNew.this.iav.cmE();
                    }
                }
            });
            this.iao.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.ian.setVisibility(4);
    }

    private void oV(boolean z) {
        if (z) {
            this.hZY.setText("已关注");
            this.hZY.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hZY.setText("关注");
            this.hZY.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hZY.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.iac != null && personUserData != null && personUserData.user_info != null) {
            this.iac.setVisibility((this.iat && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hZY) {
            cmW();
        } else if (view == this.iad) {
            cmP();
        } else if (view == this.iac) {
            cmV();
        } else if (view == this.hZF) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hZz, this.byD}));
        }
    }

    private void cmV() {
        JSONObject jSONObject;
        if (this.hZz != null && this.byD != null && this.byD.user_info != null && !TextUtils.isEmpty(this.byD.user_info.live_id)) {
            com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(this.byD.user_info.live_id)));
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hZz.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.byD.user_info.live_id), this.byD.live_info.room_id + "", "live_sdk");
                try {
                    String flvUrl = this.byD.live_info.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    String str = this.byD.live_info.cover;
                    String valueOf = String.valueOf(this.byD.live_info.room_id);
                    String valueOf2 = String.valueOf(this.byD.live_info.live_id);
                    if (TextUtils.isEmpty(this.otherParams)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(this.otherParams);
                    }
                    jSONObject.put("live_url", flvUrl);
                    jSONObject.put("cover", str);
                    jSONObject.put("enterRoomId", valueOf);
                    jSONObject.put("enterLiveId", valueOf2);
                    jSONObject.put("screen_direction", this.byD.live_info.screen_direction);
                    this.otherParams = jSONObject.toString();
                    alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
                this.hZz.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmP() {
        if (this.byD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hZz.getActivity());
            } else if (this.byD.user_info == null || JavaTypesHelper.toLong(this.byD.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hZz.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.byD.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hZz.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bte = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.byD.user_info));
                this.hZz.finish();
            }
        }
    }

    private void cmW() {
        String str;
        if (this.byD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hZz.getActivity());
                this.hZz.finish();
            } else if (this.byD.user_info == null || JavaTypesHelper.toLong(this.byD.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hZz.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.iaq) {
                    wq(1);
                    this.hZz.cmB();
                } else {
                    wq(0);
                    this.hZz.cmA();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (!TextUtils.isEmpty(this.byD.user_info.user_id)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uid", this.byD.user_info.user_id);
                        jSONObject.put("follow", this.iaq ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.iaq ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aLc) {
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

    public void wq(int i) {
        switch (i) {
            case 0:
                this.iaq = true;
                oV(true);
                if (this.byD != null && this.byD.user_info != null) {
                    this.byD.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.byD.user_info.fans_count >= 0 ? this.byD.user_info.fans_count : 0L);
                    this.hZQ.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hZS.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.iaq = false;
                oV(false);
                if (this.byD != null && this.byD.user_info != null) {
                    this.byD.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.byD.user_info.fans_count >= 0 ? this.byD.user_info.fans_count : 0L);
                    this.hZQ.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hZS.setText(formatForPersonCardBeanValue2[1]);
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
        if (this.byD != null && this.byD.user_info != null) {
            if (z) {
                this.byD.user_info.follow_count++;
            } else {
                this.byD.user_info.follow_count--;
            }
            if (this.byD.user_info.follow_count < 0) {
                this.byD.user_info.follow_count = 0L;
            }
            this.hZY.setText(com.baidu.tieba.ala.person.d.a.bg(this.byD.user_info.follow_count));
        }
    }

    private View ns(boolean z) {
        if (this.hWu) {
            if (z) {
                return LayoutInflater.from(this.hZz.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery_hori, (ViewGroup) null);
            }
            return LayoutInflater.from(this.hZz.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery, (ViewGroup) null);
        } else if (z) {
            return LayoutInflater.from(this.hZz.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        } else {
            return LayoutInflater.from(this.hZz.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oX(boolean z) {
        this.hWE = z;
    }

    public void oY(boolean z) {
        this.iat = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hfq == null) {
                        PersonCardViewNew.this.hfq = AnimationUtils.loadAnimation(PersonCardViewNew.this.hZz.getActivity(), a.C0201a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.iak.setAnimation(PersonCardViewNew.this.hfq);
                    PersonCardViewNew.this.iak.setVisibility(0);
                    PersonCardViewNew.this.hfq.setDuration(300L);
                    PersonCardViewNew.this.hfq.start();
                    PersonCardViewNew.this.hfq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (PersonCardViewNew.this.hZz.isFinishing()) {
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
        if (this.iak != null) {
            this.iak.clearAnimation();
        }
        if (this.hZL != null && this.hZL.isShowing()) {
            this.hZL.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gQK);
    }

    public Animation bWN() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfq != null) {
            this.hfq.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hZz.getActivity(), a.C0201a.sdk_push_up_out);
        this.iak.setAnimation(loadAnimation);
        this.iak.setVisibility(8);
        return loadAnimation;
    }

    public void bkr() {
        if (this.hZL != null && this.hZL.isShowing()) {
            this.hZL.resize();
        }
        if (this.byD != null && this.byD.user_info != null) {
            Iu(this.byD.user_info.aPP);
        }
    }

    public void aN(String str, String str2) {
        this.bwn = JavaTypesHelper.toLong(str, 0L);
        this.gqI = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
