package com.baidu.tieba.ala.person.view;

import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewPager;
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
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.am;
import com.baidu.live.data.ar;
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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private boolean aLj;
    private View aZR;
    private long brr;
    private PersonUserData btz;
    private TextView gFM;
    private Animation gTC;
    private long ggl;
    private boolean hIM;
    protected final PersonCardActivity hLB;
    private TextView hLC;
    private TextView hLD;
    private TextView hLE;
    private TextView hLF;
    private TextView hLG;
    private TextView hLH;
    private TextView hLI;
    private TextView hLJ;
    private TextView hLK;
    private TextView hLL;
    private TextView hLM;
    private LinearLayout hLN;
    private ImageView hLO;
    private TextView hLP;
    private TextView hLQ;
    private TextView hLR;
    private TextView hLS;
    private TextView hLT;
    private ViewGroup hLU;
    private HeadImageView hLV;
    private TbImageView hLW;
    private LinearLayout hLX;
    private LinearLayout hLY;
    private View hLZ;
    private View hMa;
    private View hMb;
    private View hMc;
    private HeadImageView hMd;
    private ViewGroup hMe;
    private boolean hMf;
    private String hMg;
    private boolean hMh;
    private boolean hMi;
    private a.InterfaceC0705a hMj;
    private com.baidu.tieba.ala.person.view.a hMk;
    private boolean hMl;
    private com.baidu.tieba.ala.person.a hMm;
    private a hMn;
    private boolean isHost;
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private Handler mHandler = new Handler();
    private HttpMessageListener gFc = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    BdUtilHelper.showToast(PersonCardViewNew.this.hLB, PersonCardViewNew.this.hLB.getString(a.h.sdk_poke_poke_once_fail));
                    return;
                }
                if (alaPokeResponseMessage.brw == 1) {
                    PersonCardViewNew.this.gFM.setEnabled(false);
                    PersonCardViewNew.this.gFM.setText(PersonCardViewNew.this.hLB.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gFM.setTextColor(PersonCardViewNew.this.hLB.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.brw == 0) {
                    PersonCardViewNew.this.gFM.setVisibility(8);
                }
                PersonCardViewNew.this.hLB.finish();
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cmt();

        void cmu();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.hLB = personCardActivity;
        this.hMl = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = mR(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hMk = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hMn = aVar;
    }

    private void initView() {
        this.hLZ = this.mRootView.findViewById(a.f.person_card_layout);
        this.hLC = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hLN = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hLO = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hLP = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.aZR = this.mRootView.findViewById(a.f.name_layout);
        this.hLD = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hLE = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hLF = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hLG = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hLI = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hLH = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hLJ = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hLK = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hLL = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hLT = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hLM = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hLS = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hLX = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hMa = this.mRootView.findViewById(a.f.user_divide);
        this.hMb = this.mRootView.findViewById(a.f.user_divide2);
        this.hLQ = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hLR = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hLU = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hLV = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hLY = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hLV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hLV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hLV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hLV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hLV.setIsRound(true);
        this.hLV.setAutoChangeStyle(false);
        this.hLV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hLV.setBorderWidth(BdUtilHelper.getDimens(this.hLB.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hLV.setBorderColor(872415231);
        this.hLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmI();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
        layoutParams.addRule(1, this.hLN.getId());
        this.hLC.setLayoutParams(layoutParams);
        this.hLO.setVisibility(8);
        this.hLP.setText(a.h.ala_person_report);
        this.hLV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hMg) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hMg);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hLB.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hLB.finish();
                }
            }
        });
        this.hMc = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hMd = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hMd.setIsRound(true);
        this.hMd.setAutoChangeStyle(false);
        this.hMd.setDrawBorder(false);
        this.hMd.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gFM = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hMl) {
            this.hMe = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hMe.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gFc);
    }

    private void initListener() {
        this.hLC.setOnClickListener(this);
        this.hLQ.setOnClickListener(this);
        this.hLR.setOnClickListener(this);
        this.hLM.setOnClickListener(this);
        a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0705a
            public void cmw() {
                PersonCardViewNew.this.hLB.cmr();
            }
        });
    }

    public void a(a.InterfaceC0705a interfaceC0705a) {
        this.hMj = interfaceC0705a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.btz = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.hMk.setData(personUserData.user_info);
            if (this.hIM) {
                this.hLX.setVisibility(8);
            }
            if (this.hLX != null && this.hLX.getVisibility() == 0) {
                int childCount = this.hLY.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hLY.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hLY.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hLY.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hLY.setWeightSum(i2);
                this.hLY.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hMl || i == 0) {
            this.gFM.setVisibility(8);
        } else {
            this.gFM.setVisibility(0);
        }
        if (i == 1) {
            this.gFM.setEnabled(false);
            this.gFM.setText(this.hLB.getString(a.h.sdk_poke_had_poked));
            this.gFM.setTextColor(this.hLB.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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

    private void d(PersonUserData personUserData) {
        if (!this.hMl) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!am.FE() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Fd()) {
                        this.hMe.setVisibility(8);
                        return;
                    }
                    this.hMe.setVisibility(0);
                    this.hMe.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Fc())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Fc().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Fc().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hLB.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, xw(i));
                                this.hMe.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aLj && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hLB.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hMn != null) {
                                    PersonCardViewNew.this.hMn.cmu();
                                }
                            }
                        });
                        this.hMe.addView(alaPersonTagView2);
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

    private int xw(int i) {
        return a.e.bg_tag_new;
    }

    private void e(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aLj = personUserData.user_info != null && this.hLB.IS(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hMg = personUserData.user_info != null ? personUserData.user_info.aPu : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hMh = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hMh) {
                this.hLX.setVisibility(8);
            } else {
                this.hLX.setVisibility(0);
            }
            if (!z) {
                this.hLJ.setText("火星");
            } else {
                this.hLJ.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hLS.setVisibility(8);
                this.hMb.setVisibility(8);
            } else {
                this.hLS.setText(String.format(this.hLB.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hMb.setVisibility(0);
                this.hLS.setVisibility(0);
            }
            if (z2) {
                this.hLL.setText(String.format(this.hLB.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hLL.setVisibility(0);
                this.hMa.setVisibility(0);
                return;
            }
            this.hLL.setVisibility(8);
            this.hMa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hLB.getActivity());
            this.hLB.finish();
        } else if (this.btz != null && this.btz.user_info != null && this.btz.user_info.live_status == 1) {
            g gVar = new g(this.hLB);
            gVar.a(this.brr, this.ggl, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.btz.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hLB.finish();
        } else {
            if (this.hMm != null && this.hMm.isShowing()) {
                this.hMm.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hLB.getActivity(), true);
            aVar.a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0705a
                public void cmw() {
                    if (PersonCardViewNew.this.hMj != null) {
                        PersonCardViewNew.this.hMj.cmw();
                    }
                }
            });
            aVar.show();
            this.hMm = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ar arVar = personUserData.user_info;
        if (arVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(arVar.fans_count < 0 ? 0L : arVar.fans_count);
            this.hLE.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hLG.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(arVar.follow_count < 0 ? 0L : arVar.follow_count);
            this.hLK.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hLH.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hLF.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hLI.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hLI.setText("");
            }
            int i2 = this.hMl ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hMl) {
                i = 22;
            }
            this.hLE.setTextSize(1, i);
            this.hLK.setTextSize(1, i);
            this.hLF.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hLC.setVisibility(8);
                this.hLN.setVisibility(8);
            } else if (this.hLB.IS(TbadkCoreApplication.getCurrentAccount())) {
                this.hLN.setVisibility(8);
                this.hLC.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                this.hLC.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hLC.setVisibility(0);
                this.hLN.setVisibility(0);
            } else {
                this.hLN.setVisibility(0);
                this.hLC.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        ar arVar = personUserData.user_info;
        if (arVar != null && !StringUtils.isNull(arVar.getNameShow())) {
            String nameShow = arVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hLD.setText(nameShow);
        }
        l.a(this.hLV, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(arVar.description)) {
            this.hLT.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hLT.setText(arVar.description);
        }
        IU(arVar.aPq);
    }

    private void IU(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hLW == null) {
                this.hLW = new TbImageView(this.hLU.getContext());
            }
            this.hLW.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hLU != null && PersonCardViewNew.this.hLW != null && PersonCardViewNew.this.hLW.getLoadedWidth() > 0 && PersonCardViewNew.this.hLW.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hMl) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hLW.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hLU.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hLW.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hLU.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hLV != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hLV.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hLV.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hLV.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hLU.indexOfChild(PersonCardViewNew.this.hLW) < 0) {
                            PersonCardViewNew.this.hLU.addView(PersonCardViewNew.this.hLW, PersonCardViewNew.this.hLU.indexOfChild(PersonCardViewNew.this.hLV) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hLN.getVisibility() == 0 && PersonCardViewNew.this.hLC.getVisibility() == 0) {
                            PersonCardViewNew.this.hLC.setPadding(PersonCardViewNew.this.hLC.getPaddingLeft(), PersonCardViewNew.this.hLC.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hLC.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hLC.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hLC.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hLW.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hMf = false;
            oq(false);
        } else if (!this.hMh && (alaRelationData = personUserData.relation_info) != null) {
            this.hMf = alaRelationData.follow_status != 0;
            if (z) {
                this.hLM.setVisibility(8);
            } else {
                oq(this.hMf);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hMc.setVisibility(0);
            this.hMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hMn != null) {
                        PersonCardViewNew.this.hMn.cmt();
                    }
                }
            });
            this.hMd.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hMc.setVisibility(4);
    }

    private void oq(boolean z) {
        if (z) {
            this.hLM.setText("已关注");
            this.hLM.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hLM.setText("关注");
            this.hLM.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hLM.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hLQ != null && personUserData != null && personUserData.user_info != null) {
            this.hLQ.setVisibility((this.hMi && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hLM) {
            cmK();
        } else if (view == this.hLR) {
            cmE();
        } else if (view == this.hLQ) {
            cmJ();
        } else if (view == this.hLC) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hLB, this.btz}));
        }
    }

    private void cmJ() {
        if (this.hLB != null && this.btz != null && this.btz.user_info != null && !TextUtils.isEmpty(this.btz.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hLB.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.btz.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.hLB.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmE() {
        if (this.btz != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hLB.getActivity());
            } else if (this.btz.user_info == null || JavaTypesHelper.toLong(this.btz.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hLB.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.btz.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hLB.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bqV = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.btz.user_info));
                this.hLB.finish();
            }
        }
    }

    private void cmK() {
        String str;
        if (this.btz != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hLB.getActivity());
                this.hLB.finish();
            } else if (this.btz.user_info == null || JavaTypesHelper.toLong(this.btz.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hLB.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hMf) {
                    xx(1);
                    this.hLB.cmq();
                } else {
                    xx(0);
                    this.hLB.cmp();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (!TextUtils.isEmpty(this.btz.user_info.user_id)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uid", this.btz.user_info.user_id);
                        jSONObject.put("follow", this.hMf ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hMf ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aLj) {
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

    public void xx(int i) {
        switch (i) {
            case 0:
                this.hMf = true;
                oq(true);
                if (this.btz != null && this.btz.user_info != null) {
                    this.btz.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.btz.user_info.fans_count >= 0 ? this.btz.user_info.fans_count : 0L);
                    this.hLE.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hLG.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hMf = false;
                oq(false);
                if (this.btz != null && this.btz.user_info != null) {
                    this.btz.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.btz.user_info.fans_count >= 0 ? this.btz.user_info.fans_count : 0L);
                    this.hLE.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hLG.setText(formatForPersonCardBeanValue2[1]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void or(boolean z) {
        if (this.btz != null && this.btz.user_info != null) {
            if (z) {
                this.btz.user_info.follow_count++;
            } else {
                this.btz.user_info.follow_count--;
            }
            if (this.btz.user_info.follow_count < 0) {
                this.btz.user_info.follow_count = 0L;
            }
            this.hLM.setText(com.baidu.tieba.ala.person.d.a.bc(this.btz.user_info.follow_count));
        }
    }

    private View mR(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hLB.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hLB.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void os(boolean z) {
        this.hIM = z;
    }

    public void ot(boolean z) {
        this.hMi = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gTC == null) {
                        PersonCardViewNew.this.gTC = AnimationUtils.loadAnimation(PersonCardViewNew.this.hLB.getActivity(), a.C0205a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hLZ.setAnimation(PersonCardViewNew.this.gTC);
                    PersonCardViewNew.this.hLZ.setVisibility(0);
                    PersonCardViewNew.this.gTC.setDuration(300L);
                    PersonCardViewNew.this.gTC.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hLZ != null) {
            this.hLZ.clearAnimation();
        }
        if (this.hMm != null && this.hMm.isShowing()) {
            this.hMm.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gFc);
    }

    public Animation bXi() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gTC != null) {
            this.gTC.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hLB.getActivity(), a.C0205a.sdk_push_up_out);
        this.hLZ.setAnimation(loadAnimation);
        this.hLZ.setVisibility(8);
        return loadAnimation;
    }

    public void blq() {
        if (this.hMm != null && this.hMm.isShowing()) {
            this.hMm.resize();
        }
        if (this.btz != null && this.btz.user_info != null) {
            IU(this.btz.user_info.aPq);
        }
    }

    public void aT(String str, String str2) {
        this.brr = JavaTypesHelper.toLong(str, 0L);
        this.ggl = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
