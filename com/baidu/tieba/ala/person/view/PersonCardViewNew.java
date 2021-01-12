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
/* loaded from: classes10.dex */
public class PersonCardViewNew implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private boolean aGY;
    private View aWK;
    private long brk;
    private PersonUserData bty;
    private TextView gMR;
    private long gmc;
    private boolean hQc;
    private boolean hQm;
    private TextView hTA;
    private TextView hTB;
    private TextView hTC;
    private TextView hTD;
    private TextView hTE;
    private TextView hTF;
    private TextView hTG;
    private LinearLayout hTH;
    private ImageView hTI;
    private TextView hTJ;
    private TextView hTK;
    private TextView hTL;
    private TextView hTM;
    private TextView hTN;
    private ViewGroup hTO;
    private TbImageView hTP;
    private LinearLayout hTQ;
    private LinearLayout hTR;
    private ViewGroup hTS;
    private View hTT;
    private View hTU;
    private View hTV;
    private HeadImageView hTW;
    private ViewGroup hTX;
    private boolean hTY;
    private String hTZ;
    protected final PersonCardActivity hTh;
    private TextView hTn;
    private HeadImageView hTo;
    private a.InterfaceC0680a hTr;
    private boolean hTs;
    private com.baidu.tieba.ala.person.a hTt;
    private TextView hTx;
    private TextView hTy;
    private TextView hTz;
    private boolean hUa;
    private boolean hUb;
    private com.baidu.tieba.ala.person.view.a hUc;
    private a hUd;
    private Animation haJ;
    private boolean isHost;
    protected View mRootView;
    private int screenWidth;
    private String uid;
    private String otherParams = "";
    private Handler mHandler = new Handler();
    private HttpMessageListener gMh = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    if (TextUtils.isEmpty(alaPokeResponseMessage.getErrorString())) {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hTh, PersonCardViewNew.this.hTh.getString(a.h.sdk_poke_poke_once_fail));
                        return;
                    } else {
                        BdUtilHelper.showToast(PersonCardViewNew.this.hTh, alaPokeResponseMessage.getErrorString());
                        return;
                    }
                }
                if (alaPokeResponseMessage.brq == 1) {
                    PersonCardViewNew.this.gMR.setEnabled(false);
                    PersonCardViewNew.this.gMR.setText(PersonCardViewNew.this.hTh.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gMR.setTextColor(PersonCardViewNew.this.hTh.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.brq == 0) {
                    PersonCardViewNew.this.gMR.setVisibility(8);
                }
                PersonCardViewNew.this.hTh.finish();
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void clt();

        void clu();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z, boolean z2) {
        this.hQc = false;
        this.hTh = personCardActivity;
        this.hTs = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.hQc = z2;
        this.mRootView = nn(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hUc = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hUd = aVar;
    }

    private void initView() {
        this.hTS = (ViewGroup) this.mRootView.findViewById(a.f.person_card_layout);
        this.hTn = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hTH = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hTI = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hTJ = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.aWK = this.mRootView.findViewById(a.f.name_layout);
        this.hTx = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hTy = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hTz = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hTA = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hTC = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hTB = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hTD = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hTE = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hTF = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hTN = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hTG = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hTM = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hTQ = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hTT = this.mRootView.findViewById(a.f.user_divide);
        this.hTU = this.mRootView.findViewById(a.f.user_divide2);
        this.hTK = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hTL = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hTO = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hTo = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hTR = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
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
        this.hTo.setBorderColor(872415231);
        this.hTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.clJ();
            }
        });
        if (!this.hQc) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTn.getLayoutParams();
            layoutParams.addRule(1, this.hTH.getId());
            this.hTn.setLayoutParams(layoutParams);
        }
        this.hTI.setVisibility(8);
        this.hTJ.setText(a.h.ala_person_report);
        this.hTo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hTZ) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hTZ);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hTh.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hTh.finish();
                }
            }
        });
        this.hTV = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hTW = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hTW.setIsRound(true);
        this.hTW.setAutoChangeStyle(false);
        this.hTW.setDrawBorder(false);
        this.hTW.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gMR = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hTs) {
            this.hTX = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hTX.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gMh);
    }

    private void initListener() {
        this.hTn.setOnClickListener(this);
        this.hTK.setOnClickListener(this);
        this.hTL.setOnClickListener(this);
        this.hTG.setOnClickListener(this);
        a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
            public void clw() {
                PersonCardViewNew.this.hTh.clr();
            }
        });
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        this.hTr = interfaceC0680a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bty = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            e(personUserData);
            i(personUserData);
            this.hUc.setData(personUserData.user_info);
            if (this.hQm || this.hQc) {
                this.hTQ.setVisibility(8);
            }
            if (this.hTQ != null && this.hTQ.getVisibility() == 0) {
                int childCount = this.hTR.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hTR.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hTR.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hTR.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hTR.setWeightSum(i2);
                this.hTR.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hTs || i == 0) {
            this.gMR.setVisibility(8);
        } else {
            this.gMR.setVisibility(0);
        }
        if (i == 1) {
            this.gMR.setEnabled(false);
            this.gMR.setText(this.hTh.getString(a.h.sdk_poke_had_poked));
            this.gMR.setTextColor(this.hTh.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
        if (!this.hTs) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ao.AZ() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Ax()) {
                        this.hTX.setVisibility(8);
                        return;
                    }
                    this.hTX.setVisibility(0);
                    this.hTX.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Aw())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Aw().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Aw().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hTh.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, wd(i));
                                this.hTX.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aGY && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hTh.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hUd != null) {
                                    PersonCardViewNew.this.hUd.clu();
                                }
                            }
                        });
                        this.hTX.addView(alaPersonTagView2);
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

    private int wd(int i) {
        return a.e.bg_tag_new;
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aGY = personUserData.user_info != null && this.hTh.HE(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hTZ = personUserData.user_info != null ? personUserData.user_info.aLw : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hUa = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hUa) {
                this.hTQ.setVisibility(8);
            } else {
                this.hTQ.setVisibility(0);
            }
            if (!z) {
                this.hTD.setText("火星");
            } else {
                this.hTD.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hTM.setVisibility(8);
                this.hTU.setVisibility(8);
            } else {
                this.hTM.setText(String.format(this.hTh.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hTU.setVisibility(0);
                this.hTM.setVisibility(0);
            }
            if (z2) {
                this.hTF.setText(String.format(this.hTh.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hTF.setVisibility(0);
                this.hTT.setVisibility(0);
                return;
            }
            this.hTF.setVisibility(8);
            this.hTT.setVisibility(8);
        }
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
            aVar.a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
                public void clw() {
                    if (PersonCardViewNew.this.hTr != null) {
                        PersonCardViewNew.this.hTr.clw();
                    }
                }
            });
            aVar.show();
            this.hTt = aVar;
        }
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        at atVar = personUserData.user_info;
        if (atVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(atVar.fans_count < 0 ? 0L : atVar.fans_count);
            this.hTy.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hTA.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(atVar.follow_count < 0 ? 0L : atVar.follow_count);
            this.hTE.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hTB.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hTz.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hTC.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hTC.setText("");
            }
            int i2 = this.hTs ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hTs) {
                i = 22;
            }
            this.hTy.setTextSize(1, i);
            this.hTE.setTextSize(1, i);
            this.hTz.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hTn.setVisibility(8);
                this.hTH.setVisibility(8);
            } else if (this.hTh.HE(TbadkCoreApplication.getCurrentAccount())) {
                this.hTH.setVisibility(8);
                if (!this.hQc) {
                    this.hTn.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                }
                this.hTn.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hTn.setVisibility(0);
                this.hTH.setVisibility(0);
            } else {
                this.hTH.setVisibility(0);
                this.hTn.setVisibility(8);
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
            this.hTx.setText(nameShow);
        }
        m.a(this.hTo, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(atVar.description)) {
            this.hTN.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hTN.setText(atVar.description);
        }
        HG(atVar.aLs);
    }

    private void HG(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hTP == null) {
                this.hTP = new TbImageView(this.hTO.getContext());
            }
            this.hTP.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hTO != null && PersonCardViewNew.this.hTP != null && PersonCardViewNew.this.hTP.getLoadedWidth() > 0 && PersonCardViewNew.this.hTP.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hTs) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hTP.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hTO.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hTP.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hTO.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hTo != null && !PersonCardViewNew.this.hQc) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hTo.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hTo.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hTo.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hTO.indexOfChild(PersonCardViewNew.this.hTP) < 0) {
                            PersonCardViewNew.this.hTO.addView(PersonCardViewNew.this.hTP, PersonCardViewNew.this.hTO.indexOfChild(PersonCardViewNew.this.hTo) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hTH.getVisibility() == 0 && PersonCardViewNew.this.hTn.getVisibility() == 0) {
                            PersonCardViewNew.this.hTn.setPadding(PersonCardViewNew.this.hTn.getPaddingLeft(), PersonCardViewNew.this.hTn.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hTn.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hTn.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hTn.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hTP.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hTY = false;
            oL(false);
        } else if (!this.hUa && (alaRelationData = personUserData.relation_info) != null) {
            this.hTY = alaRelationData.follow_status != 0;
            if (z) {
                this.hTG.setVisibility(8);
            } else {
                oL(this.hTY);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hTV.setVisibility(0);
            this.hTV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hUd != null) {
                        PersonCardViewNew.this.hUd.clt();
                    }
                }
            });
            this.hTW.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hTV.setVisibility(4);
    }

    private void oL(boolean z) {
        if (z) {
            this.hTG.setText("已关注");
            this.hTG.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hTG.setText("关注");
            this.hTG.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hTG.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hTK != null && personUserData != null && personUserData.user_info != null) {
            this.hTK.setVisibility((this.hUb && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTG) {
            clL();
        } else if (view == this.hTL) {
            clE();
        } else if (view == this.hTK) {
            clK();
        } else if (view == this.hTn) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hTh, this.bty}));
        }
    }

    private void clK() {
        JSONObject jSONObject;
        if (this.hTh != null && this.bty != null && this.bty.user_info != null && !TextUtils.isEmpty(this.bty.user_info.live_id)) {
            com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(this.bty.user_info.live_id)));
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hTh.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bty.user_info.live_id), "", "live_sdk");
                try {
                    String flvUrl = this.bty.live_info.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    String str = this.bty.live_info.cover;
                    String valueOf = String.valueOf(this.bty.live_info.room_id);
                    String valueOf2 = String.valueOf(this.bty.live_info.live_id);
                    if (TextUtils.isEmpty(this.otherParams)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(this.otherParams);
                    }
                    jSONObject.put("live_url", flvUrl);
                    jSONObject.put("cover", str);
                    jSONObject.put("enterRoomId", valueOf);
                    jSONObject.put("enterLiveId", valueOf2);
                    jSONObject.put("screen_direction", this.bty.live_info.screen_direction);
                    this.otherParams = jSONObject.toString();
                    alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
                this.hTh.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void clE() {
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

    private void clL() {
        String str;
        if (this.bty != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hTh.getActivity());
                this.hTh.finish();
            } else if (this.bty.user_info == null || JavaTypesHelper.toLong(this.bty.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hTh.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hTY) {
                    we(1);
                    this.hTh.clq();
                } else {
                    we(0);
                    this.hTh.clp();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (!TextUtils.isEmpty(this.bty.user_info.user_id)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uid", this.bty.user_info.user_id);
                        jSONObject.put("follow", this.hTY ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hTY ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aGY) {
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

    public void we(int i) {
        switch (i) {
            case 0:
                this.hTY = true;
                oL(true);
                if (this.bty != null && this.bty.user_info != null) {
                    this.bty.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bty.user_info.fans_count >= 0 ? this.bty.user_info.fans_count : 0L);
                    this.hTy.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hTA.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hTY = false;
                oL(false);
                if (this.bty != null && this.bty.user_info != null) {
                    this.bty.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bty.user_info.fans_count >= 0 ? this.bty.user_info.fans_count : 0L);
                    this.hTy.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hTA.setText(formatForPersonCardBeanValue2[1]);
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

    public void oM(boolean z) {
        if (this.bty != null && this.bty.user_info != null) {
            if (z) {
                this.bty.user_info.follow_count++;
            } else {
                this.bty.user_info.follow_count--;
            }
            if (this.bty.user_info.follow_count < 0) {
                this.bty.user_info.follow_count = 0L;
            }
            this.hTG.setText(com.baidu.tieba.ala.person.d.a.bc(this.bty.user_info.follow_count));
        }
    }

    private View nn(boolean z) {
        if (this.hQc) {
            if (z) {
                return LayoutInflater.from(this.hTh.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery_hori, (ViewGroup) null);
            }
            return LayoutInflater.from(this.hTh.getPageContext().getPageActivity()).inflate(a.g.ala_person_card_self_mystery, (ViewGroup) null);
        } else if (z) {
            return LayoutInflater.from(this.hTh.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        } else {
            return LayoutInflater.from(this.hTh.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oN(boolean z) {
        this.hQm = z;
    }

    public void oO(boolean z) {
        this.hUb = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.haJ == null) {
                        PersonCardViewNew.this.haJ = AnimationUtils.loadAnimation(PersonCardViewNew.this.hTh.getActivity(), a.C0194a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hTS.setAnimation(PersonCardViewNew.this.haJ);
                    PersonCardViewNew.this.hTS.setVisibility(0);
                    PersonCardViewNew.this.haJ.setDuration(300L);
                    PersonCardViewNew.this.haJ.start();
                    PersonCardViewNew.this.haJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (PersonCardViewNew.this.hTh.isFinishing()) {
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
        if (this.hTS != null) {
            this.hTS.clearAnimation();
        }
        if (this.hTt != null && this.hTt.isShowing()) {
            this.hTt.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gMh);
    }

    public Animation bVW() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.haJ != null) {
            this.haJ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hTh.getActivity(), a.C0194a.sdk_push_up_out);
        this.hTS.setAnimation(loadAnimation);
        this.hTS.setVisibility(8);
        return loadAnimation;
    }

    public void bjV() {
        if (this.hTt != null && this.hTt.isShowing()) {
            this.hTt.resize();
        }
        if (this.bty != null && this.bty.user_info != null) {
            HG(this.bty.user_info.aLs);
        }
    }

    public void aN(String str, String str2) {
        this.brk = JavaTypesHelper.toLong(str, 0L);
        this.gmc = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
