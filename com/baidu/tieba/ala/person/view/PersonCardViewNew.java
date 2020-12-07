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
    private TextView gFK;
    private Animation gTA;
    private long ggj;
    private boolean hIK;
    private TextView hLA;
    private TextView hLB;
    private TextView hLC;
    private TextView hLD;
    private TextView hLE;
    private TextView hLF;
    private TextView hLG;
    private TextView hLH;
    private TextView hLI;
    private TextView hLJ;
    private TextView hLK;
    private LinearLayout hLL;
    private ImageView hLM;
    private TextView hLN;
    private TextView hLO;
    private TextView hLP;
    private TextView hLQ;
    private TextView hLR;
    private ViewGroup hLS;
    private HeadImageView hLT;
    private TbImageView hLU;
    private LinearLayout hLV;
    private LinearLayout hLW;
    private View hLX;
    private View hLY;
    private View hLZ;
    protected final PersonCardActivity hLz;
    private View hMa;
    private HeadImageView hMb;
    private ViewGroup hMc;
    private boolean hMd;
    private String hMe;
    private boolean hMf;
    private boolean hMg;
    private a.InterfaceC0705a hMh;
    private com.baidu.tieba.ala.person.view.a hMi;
    private boolean hMj;
    private com.baidu.tieba.ala.person.a hMk;
    private a hMl;
    private boolean isHost;
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private Handler mHandler = new Handler();
    private HttpMessageListener gFa = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                    BdUtilHelper.showToast(PersonCardViewNew.this.hLz, PersonCardViewNew.this.hLz.getString(a.h.sdk_poke_poke_once_fail));
                    return;
                }
                if (alaPokeResponseMessage.brw == 1) {
                    PersonCardViewNew.this.gFK.setEnabled(false);
                    PersonCardViewNew.this.gFK.setText(PersonCardViewNew.this.hLz.getString(a.h.sdk_poke_had_poked));
                    PersonCardViewNew.this.gFK.setTextColor(PersonCardViewNew.this.hLz.getResources().getColor(a.c.sdk_color_f9d8e0));
                } else if (alaPokeResponseMessage.brw == 0) {
                    PersonCardViewNew.this.gFK.setVisibility(8);
                }
                PersonCardViewNew.this.hLz.finish();
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cms();

        void cmt();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.hLz = personCardActivity;
        this.hMj = z;
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
        this.hMi = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hMl = aVar;
    }

    private void initView() {
        this.hLX = this.mRootView.findViewById(a.f.person_card_layout);
        this.hLA = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hLL = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hLM = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hLN = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.aZR = this.mRootView.findViewById(a.f.name_layout);
        this.hLB = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hLC = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hLD = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hLE = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hLG = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hLF = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hLH = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hLI = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hLJ = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hLR = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hLK = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hLQ = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hLV = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hLY = this.mRootView.findViewById(a.f.user_divide);
        this.hLZ = this.mRootView.findViewById(a.f.user_divide2);
        this.hLO = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hLP = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hLS = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hLT = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hLW = (LinearLayout) this.mRootView.findViewById(a.f.bottom_left_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hLT.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hLT.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hLT.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hLT.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hLT.setIsRound(true);
        this.hLT.setAutoChangeStyle(false);
        this.hLT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hLT.setBorderWidth(BdUtilHelper.getDimens(this.hLz.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hLT.setBorderColor(872415231);
        this.hLL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmH();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLA.getLayoutParams();
        layoutParams.addRule(1, this.hLL.getId());
        this.hLA.setLayoutParams(layoutParams);
        this.hLM.setVisibility(8);
        this.hLN.setText(a.h.ala_person_report);
        this.hLT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hMe) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hMe);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hLz.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hLz.finish();
                }
            }
        });
        this.hMa = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hMb = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hMb.setIsRound(true);
        this.hMb.setAutoChangeStyle(false);
        this.hMb.setDrawBorder(false);
        this.hMb.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gFK = (TextView) this.mRootView.findViewById(a.f.poke);
        if (!this.hMj) {
            this.hMc = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hMc.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.gFa);
    }

    private void initListener() {
        this.hLA.setOnClickListener(this);
        this.hLO.setOnClickListener(this);
        this.hLP.setOnClickListener(this);
        this.hLK.setOnClickListener(this);
        a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0705a
            public void cmv() {
                PersonCardViewNew.this.hLz.cmq();
            }
        });
    }

    public void a(a.InterfaceC0705a interfaceC0705a) {
        this.hMh = interfaceC0705a;
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
            this.hMi.setData(personUserData.user_info);
            if (this.hIK) {
                this.hLV.setVisibility(8);
            }
            if (this.hLV != null && this.hLV.getVisibility() == 0) {
                int childCount = this.hLW.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hLW.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hLW.getResources().getDimensionPixelOffset(i2 >= 2 ? a.d.sdk_ds20 : a.d.sdk_ds10);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hLW.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hLW.setWeightSum(i2);
                this.hLW.requestLayout();
            }
        }
    }

    public void a(final PersonUserData personUserData, boolean z, int i, boolean z2) {
        if (!z2 || this.hMj || i == 0) {
            this.gFK.setVisibility(8);
        } else {
            this.gFK.setVisibility(0);
        }
        if (i == 1) {
            this.gFK.setEnabled(false);
            this.gFK.setText(this.hLz.getString(a.h.sdk_poke_had_poked));
            this.gFK.setTextColor(this.hLz.getResources().getColor(a.c.sdk_color_f9d8e0));
        }
        this.gFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
        if (!this.hMj) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!am.FE() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Fd()) {
                        this.hMc.setVisibility(8);
                        return;
                    }
                    this.hMc.setVisibility(0);
                    this.hMc.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Fc())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Fc().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Fc().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hLz.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, xw(i));
                                this.hMc.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aLj && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hLz.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hMl != null) {
                                    PersonCardViewNew.this.hMl.cmt();
                                }
                            }
                        });
                        this.hMc.addView(alaPersonTagView2);
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
            this.aLj = personUserData.user_info != null && this.hLz.IS(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hMe = personUserData.user_info != null ? personUserData.user_info.aPu : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hMf = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hMf) {
                this.hLV.setVisibility(8);
            } else {
                this.hLV.setVisibility(0);
            }
            if (!z) {
                this.hLH.setText("火星");
            } else {
                this.hLH.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hLQ.setVisibility(8);
                this.hLZ.setVisibility(8);
            } else {
                this.hLQ.setText(String.format(this.hLz.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hLZ.setVisibility(0);
                this.hLQ.setVisibility(0);
            }
            if (z2) {
                this.hLJ.setText(String.format(this.hLz.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hLJ.setVisibility(0);
                this.hLY.setVisibility(0);
                return;
            }
            this.hLJ.setVisibility(8);
            this.hLY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hLz.getActivity());
            this.hLz.finish();
        } else if (this.btz != null && this.btz.user_info != null && this.btz.user_info.live_status == 1) {
            g gVar = new g(this.hLz);
            gVar.a(this.brr, this.ggj, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.btz.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hLz.finish();
        } else {
            if (this.hMk != null && this.hMk.isShowing()) {
                this.hMk.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hLz.getActivity(), true);
            aVar.a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0705a
                public void cmv() {
                    if (PersonCardViewNew.this.hMh != null) {
                        PersonCardViewNew.this.hMh.cmv();
                    }
                }
            });
            aVar.show();
            this.hMk = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ar arVar = personUserData.user_info;
        if (arVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(arVar.fans_count < 0 ? 0L : arVar.fans_count);
            this.hLC.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hLE.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(arVar.follow_count < 0 ? 0L : arVar.follow_count);
            this.hLI.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hLF.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hLD.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hLG.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hLG.setText("");
            }
            int i2 = this.hMj ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hMj) {
                i = 22;
            }
            this.hLC.setTextSize(1, i);
            this.hLI.setTextSize(1, i);
            this.hLD.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hLA.setVisibility(8);
                this.hLL.setVisibility(8);
            } else if (this.hLz.IS(TbadkCoreApplication.getCurrentAccount())) {
                this.hLL.setVisibility(8);
                this.hLA.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                this.hLA.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hLA.setVisibility(0);
                this.hLL.setVisibility(0);
            } else {
                this.hLL.setVisibility(0);
                this.hLA.setVisibility(8);
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
            this.hLB.setText(nameShow);
        }
        l.a(this.hLT, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(arVar.description)) {
            this.hLR.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hLR.setText(arVar.description);
        }
        IU(arVar.aPq);
    }

    private void IU(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hLU == null) {
                this.hLU = new TbImageView(this.hLS.getContext());
            }
            this.hLU.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.10
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hLS != null && PersonCardViewNew.this.hLU != null && PersonCardViewNew.this.hLU.getLoadedWidth() > 0 && PersonCardViewNew.this.hLU.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hMj) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hLU.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hLS.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hLU.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hLS.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hLT != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hLT.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hLT.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hLT.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hLS.indexOfChild(PersonCardViewNew.this.hLU) < 0) {
                            PersonCardViewNew.this.hLS.addView(PersonCardViewNew.this.hLU, PersonCardViewNew.this.hLS.indexOfChild(PersonCardViewNew.this.hLT) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hLL.getVisibility() == 0 && PersonCardViewNew.this.hLA.getVisibility() == 0) {
                            PersonCardViewNew.this.hLA.setPadding(PersonCardViewNew.this.hLA.getPaddingLeft(), PersonCardViewNew.this.hLA.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hLA.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hLA.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hLA.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hLU.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hMd = false;
            oq(false);
        } else if (!this.hMf && (alaRelationData = personUserData.relation_info) != null) {
            this.hMd = alaRelationData.follow_status != 0;
            if (z) {
                this.hLK.setVisibility(8);
            } else {
                oq(this.hMd);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hMa.setVisibility(0);
            this.hMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hMl != null) {
                        PersonCardViewNew.this.hMl.cms();
                    }
                }
            });
            this.hMb.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hMa.setVisibility(4);
    }

    private void oq(boolean z) {
        if (z) {
            this.hLK.setText("已关注");
            this.hLK.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hLK.setText("关注");
            this.hLK.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hLK.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hLO != null && personUserData != null && personUserData.user_info != null) {
            this.hLO.setVisibility((this.hMg && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hLK) {
            cmJ();
        } else if (view == this.hLP) {
            cmD();
        } else if (view == this.hLO) {
            cmI();
        } else if (view == this.hLA) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hLz, this.btz}));
        }
    }

    private void cmI() {
        if (this.hLz != null && this.btz != null && this.btz.user_info != null && !TextUtils.isEmpty(this.btz.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hLz.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.btz.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.hLz.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmD() {
        if (this.btz != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hLz.getActivity());
            } else if (this.btz.user_info == null || JavaTypesHelper.toLong(this.btz.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hLz.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.btz.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hLz.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bqV = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.btz.user_info));
                this.hLz.finish();
            }
        }
    }

    private void cmJ() {
        String str;
        if (this.btz != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hLz.getActivity());
                this.hLz.finish();
            } else if (this.btz.user_info == null || JavaTypesHelper.toLong(this.btz.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hLz.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hMd) {
                    xx(1);
                    this.hLz.cmp();
                } else {
                    xx(0);
                    this.hLz.cmo();
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
                        jSONObject.put("follow", this.hMd ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hMd ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
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
                this.hMd = true;
                oq(true);
                if (this.btz != null && this.btz.user_info != null) {
                    this.btz.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.btz.user_info.fans_count >= 0 ? this.btz.user_info.fans_count : 0L);
                    this.hLC.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hLE.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hMd = false;
                oq(false);
                if (this.btz != null && this.btz.user_info != null) {
                    this.btz.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.btz.user_info.fans_count >= 0 ? this.btz.user_info.fans_count : 0L);
                    this.hLC.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hLE.setText(formatForPersonCardBeanValue2[1]);
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
            this.hLK.setText(com.baidu.tieba.ala.person.d.a.bc(this.btz.user_info.follow_count));
        }
    }

    private View mR(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hLz.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hLz.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void os(boolean z) {
        this.hIK = z;
    }

    public void ot(boolean z) {
        this.hMg = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gTA == null) {
                        PersonCardViewNew.this.gTA = AnimationUtils.loadAnimation(PersonCardViewNew.this.hLz.getActivity(), a.C0205a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hLX.setAnimation(PersonCardViewNew.this.gTA);
                    PersonCardViewNew.this.hLX.setVisibility(0);
                    PersonCardViewNew.this.gTA.setDuration(300L);
                    PersonCardViewNew.this.gTA.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hLX != null) {
            this.hLX.clearAnimation();
        }
        if (this.hMk != null && this.hMk.isShowing()) {
            this.hMk.dismiss();
        }
        MessageManager.getInstance().unRegisterListener(this.gFa);
    }

    public Animation bXh() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gTA != null) {
            this.gTA.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hLz.getActivity(), a.C0205a.sdk_push_up_out);
        this.hLX.setAnimation(loadAnimation);
        this.hLX.setVisibility(8);
        return loadAnimation;
    }

    public void blq() {
        if (this.hMk != null && this.hMk.isShowing()) {
            this.hMk.resize();
        }
        if (this.btz != null && this.btz.user_info != null) {
            IU(this.btz.user_info.aPq);
        }
    }

    public void aT(String str, String str2) {
        this.brr = JavaTypesHelper.toLong(str, 0L);
        this.ggj = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
