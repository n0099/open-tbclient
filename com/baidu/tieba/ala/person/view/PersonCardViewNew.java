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
    private TextView gPx;
    private long goL;
    private boolean hUH;
    private boolean hUx;
    protected final PersonCardActivity hXC;
    private TextView hXI;
    private HeadImageView hXJ;
    private a.InterfaceC0680a hXM;
    private boolean hXN;
    private com.baidu.tieba.ala.person.a hXO;
    private TextView hXS;
    private TextView hXT;
    private TextView hXU;
    private TextView hXV;
    private TextView hXW;
    private TextView hXX;
    private TextView hXY;
    private TextView hXZ;
    private TextView hYa;
    private TextView hYb;
    private LinearLayout hYc;
    private ImageView hYd;
    private TextView hYe;
    private TextView hYf;
    private TextView hYg;
    private TextView hYh;
    private TextView hYi;
    private ViewGroup hYj;
    private TbImageView hYk;
    private LinearLayout hYl;
    private LinearLayout hYm;
    private ViewGroup hYn;
    private View hYo;
    private View hYp;
    private View hYq;
    private HeadImageView hYr;
    private ViewGroup hYs;
    private boolean hYt;
    private String hYu;
    private boolean hYv;
    private boolean hYw;
    private com.baidu.tieba.ala.person.view.a hYx;
    private a hYy;
    private Animation hdt;
    private boolean isHost;
    protected View mRootView;
    private int screenWidth;
    private String uid;
    private String otherParams = "";
    private Handler mHandler = new Handler();
    private HttpMessageListener gON = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    if (TextUtils.isEmpty(alaPokeResponseMessage.getErrorString())) {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hXC, PersonCardViewNew.this.hXC.getString(a.h.sdk_poke_poke_once_fail));
                        return;
                    } else {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hXC, alaPokeResponseMessage.getErrorString());
                        return;
                    }
                }
                if (alaPokeResponseMessage.buT == 1) {
                    PersonCardViewNew.this.gPx.setEnabled(false);
                    PersonCardViewNew.this.gPx.setText(PersonCardViewNew.this.hXC.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gPx.setTextColor(PersonCardViewNew.this.hXC.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.buT == 0) {
                    PersonCardViewNew.this.gPx.setVisibility(8);
                }
                PersonCardViewNew.this.hXC.finish();
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void cmr();

        void cms();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z, boolean z2) {
        this.hUx = false;
        this.hXC = personCardActivity;
        this.hXN = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.hUx = z2;
        this.mRootView = ns(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hYx = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hYy = aVar;
    }

    private void initView() {
        this.hYn = (ViewGroup) this.mRootView.findViewById(a.f.person_card_layout);
        this.hXI = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hYc = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hYd = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hYe = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.aZQ = this.mRootView.findViewById(a.f.name_layout);
        this.hXS = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hXT = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hXU = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hXV = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hXX = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hXW = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hXY = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hXZ = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hYa = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hYi = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hYb = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hYh = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hYl = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hYo = this.mRootView.findViewById(a.f.user_divide);
        this.hYp = this.mRootView.findViewById(a.f.user_divide2);
        this.hYf = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hYg = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hYj = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hXJ = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hYm = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
        this.hXJ.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hXJ.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hXJ.setIsRound(true);
        this.hXJ.setAutoChangeStyle(false);
        this.hXJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXJ.setBorderWidth(BdUtilHelper.getDimens(this.hXC.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXJ.setBorderColor(872415231);
        this.hYc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmH();
            }
        });
        if (!this.hUx) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXI.getLayoutParams();
            layoutParams.addRule(1, this.hYc.getId());
            this.hXI.setLayoutParams(layoutParams);
        }
        this.hYd.setVisibility(8);
        this.hYe.setText(a.h.ala_person_report);
        this.hXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hYu) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hYu);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hXC.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hXC.finish();
                }
            }
        });
        this.hYq = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hYr = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hYr.setIsRound(true);
        this.hYr.setAutoChangeStyle(false);
        this.hYr.setDrawBorder(false);
        this.hYr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gPx = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hXN) {
            this.hYs = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hYs.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gON);
    }

    private void initListener() {
        this.hXI.setOnClickListener(this);
        this.hYf.setOnClickListener(this);
        this.hYg.setOnClickListener(this);
        this.hYb.setOnClickListener(this);
        a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
            public void cmu() {
                PersonCardViewNew.this.hXC.cmp();
            }
        });
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        this.hXM = interfaceC0680a;
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
            this.hYx.setData(personUserData.user_info);
            if (this.hUH || this.hUx) {
                this.hYl.setVisibility(8);
            }
            if (this.hYl != null && this.hYl.getVisibility() == 0) {
                int childCount = this.hYm.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hYm.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hYm.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hYm.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hYm.setWeightSum(i2);
                this.hYm.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hXN || i == 0) {
            this.gPx.setVisibility(8);
        } else {
            this.gPx.setVisibility(0);
        }
        if (i == 1) {
            this.gPx.setEnabled(false);
            this.gPx.setText(this.hXC.getString(a.h.sdk_poke_had_poked));
            this.gPx.setTextColor(this.hXC.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
        if (!this.hXN) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!as.Cm() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Bh()) {
                        this.hYs.setVisibility(8);
                        return;
                    }
                    this.hYs.setVisibility(0);
                    this.hYs.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Bg())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Bg().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Bg().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hXC.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, wo(i));
                                this.hYs.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aJC && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hXC.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hYy != null) {
                                    PersonCardViewNew.this.hYy.cms();
                                }
                            }
                        });
                        this.hYs.addView(alaPersonTagView2);
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
            this.aJC = personUserData.user_info != null && this.hXC.Ii(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hYu = personUserData.user_info != null ? personUserData.user_info.aOt : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hYv = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hYv) {
                this.hYl.setVisibility(8);
            } else {
                this.hYl.setVisibility(0);
            }
            if (!z) {
                this.hXY.setText("火星");
            } else {
                this.hXY.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hYh.setVisibility(8);
                this.hYp.setVisibility(8);
            } else {
                this.hYh.setText(String.format(this.hXC.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hYp.setVisibility(0);
                this.hYh.setVisibility(0);
            }
            if (z2) {
                this.hYa.setText(String.format(this.hXC.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hYa.setVisibility(0);
                this.hYo.setVisibility(0);
                return;
            }
            this.hYa.setVisibility(8);
            this.hYo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hXC.getActivity());
            this.hXC.finish();
        } else if (this.bxd != null && this.bxd.user_info != null && this.bxd.user_info.live_status == 1) {
            g gVar = new g(this.hXC);
            gVar.a(this.buN, this.goL, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bxd.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hXC.finish();
        } else {
            if (this.hXO != null && this.hXO.isShowing()) {
                this.hXO.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hXC.getActivity(), true);
            aVar.a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
                public void cmu() {
                    if (PersonCardViewNew.this.hXM != null) {
                        PersonCardViewNew.this.hXM.cmu();
                    }
                }
            });
            aVar.show();
            this.hXO = aVar;
        }
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(axVar.fans_count < 0 ? 0L : axVar.fans_count);
            this.hXT.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hXV.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(axVar.follow_count < 0 ? 0L : axVar.follow_count);
            this.hXZ.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hXW.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hXU.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hXX.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hXX.setText("");
            }
            int i2 = this.hXN ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hXN) {
                i = 22;
            }
            this.hXT.setTextSize(1, i);
            this.hXZ.setTextSize(1, i);
            this.hXU.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hXI.setVisibility(8);
                this.hYc.setVisibility(8);
            } else if (this.hXC.Ii(TbadkCoreApplication.getCurrentAccount())) {
                this.hYc.setVisibility(8);
                if (!this.hUx) {
                    this.hXI.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                }
                this.hXI.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hXI.setVisibility(0);
                this.hYc.setVisibility(0);
            } else {
                this.hYc.setVisibility(0);
                this.hXI.setVisibility(8);
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
            this.hXS.setText(nameShow);
        }
        m.a(this.hXJ, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(axVar.description)) {
            this.hYi.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hYi.setText(axVar.description);
        }
        Ik(axVar.aOp);
    }

    private void Ik(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hYk == null) {
                this.hYk = new TbImageView(this.hYj.getContext());
            }
            this.hYk.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hYj != null && PersonCardViewNew.this.hYk != null && PersonCardViewNew.this.hYk.getLoadedWidth() > 0 && PersonCardViewNew.this.hYk.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hXN) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hYk.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hYj.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hYk.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hYj.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hXJ != null && !PersonCardViewNew.this.hUx) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXJ.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hXJ.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hXJ.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hYj.indexOfChild(PersonCardViewNew.this.hYk) < 0) {
                            PersonCardViewNew.this.hYj.addView(PersonCardViewNew.this.hYk, PersonCardViewNew.this.hYj.indexOfChild(PersonCardViewNew.this.hXJ) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hYc.getVisibility() == 0 && PersonCardViewNew.this.hXI.getVisibility() == 0) {
                            PersonCardViewNew.this.hXI.setPadding(PersonCardViewNew.this.hXI.getPaddingLeft(), PersonCardViewNew.this.hXI.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hXI.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXI.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hXI.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hYk.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hYt = false;
            oV(false);
        } else if (!this.hYv && (alaRelationData = personUserData.relation_info) != null) {
            this.hYt = alaRelationData.follow_status != 0;
            if (z) {
                this.hYb.setVisibility(8);
            } else {
                oV(this.hYt);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hYq.setVisibility(0);
            this.hYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hYy != null) {
                        PersonCardViewNew.this.hYy.cmr();
                    }
                }
            });
            this.hYr.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hYq.setVisibility(4);
    }

    private void oV(boolean z) {
        if (z) {
            this.hYb.setText("已关注");
            this.hYb.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hYb.setText("关注");
            this.hYb.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hYb.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hYf != null && personUserData != null && personUserData.user_info != null) {
            this.hYf.setVisibility((this.hYw && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hYb) {
            cmJ();
        } else if (view == this.hYg) {
            cmC();
        } else if (view == this.hYf) {
            cmI();
        } else if (view == this.hXI) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hXC, this.bxd}));
        }
    }

    private void cmI() {
        JSONObject jSONObject;
        if (this.hXC != null && this.bxd != null && this.bxd.user_info != null && !TextUtils.isEmpty(this.bxd.user_info.live_id)) {
            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(this.bxd.user_info.live_id)));
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hXC.getPageContext().getPageActivity());
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
                this.hXC.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmC() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXC.getActivity());
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXC.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hXC.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.brE = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bxd.user_info));
                this.hXC.finish();
            }
        }
    }

    private void cmJ() {
        String str;
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXC.getActivity());
                this.hXC.finish();
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXC.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hYt) {
                    wp(1);
                    this.hXC.cmo();
                } else {
                    wp(0);
                    this.hXC.cmn();
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
                        jSONObject.put("follow", this.hYt ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hYt ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
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
                this.hYt = true;
                oV(true);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hXT.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hXV.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hYt = false;
                oV(false);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hXT.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hXV.setText(formatForPersonCardBeanValue2[1]);
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
            this.hYb.setText(com.baidu.tieba.ala.person.d.a.bg(this.bxd.user_info.follow_count));
        }
    }

    private View ns(boolean z) {
        if (this.hUx) {
            if (z) {
                return LayoutInflater.from(this.hXC.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery_hori, (ViewGroup) null);
            }
            return LayoutInflater.from(this.hXC.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery, (ViewGroup) null);
        } else if (z) {
            return LayoutInflater.from(this.hXC.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        } else {
            return LayoutInflater.from(this.hXC.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oX(boolean z) {
        this.hUH = z;
    }

    public void oY(boolean z) {
        this.hYw = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hdt == null) {
                        PersonCardViewNew.this.hdt = AnimationUtils.loadAnimation(PersonCardViewNew.this.hXC.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hYn.setAnimation(PersonCardViewNew.this.hdt);
                    PersonCardViewNew.this.hYn.setVisibility(0);
                    PersonCardViewNew.this.hdt.setDuration(300L);
                    PersonCardViewNew.this.hdt.start();
                    PersonCardViewNew.this.hdt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (PersonCardViewNew.this.hXC.isFinishing()) {
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
        if (this.hYn != null) {
            this.hYn.clearAnimation();
        }
        if (this.hXO != null && this.hXO.isShowing()) {
            this.hXO.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gON);
    }

    public Animation bWA() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdt != null) {
            this.hdt.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hXC.getActivity(), a.C0195a.sdk_push_up_out);
        this.hYn.setAnimation(loadAnimation);
        this.hYn.setVisibility(8);
        return loadAnimation;
    }

    public void bkp() {
        if (this.hXO != null && this.hXO.isShowing()) {
            this.hXO.resize();
        }
        if (this.bxd != null && this.bxd.user_info != null) {
            Ik(this.bxd.user_info.aOp);
        }
    }

    public void aN(String str, String str2) {
        this.buN = JavaTypesHelper.toLong(str, 0L);
        this.goL = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
