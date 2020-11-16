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
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.g;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.al;
import com.baidu.live.data.aq;
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
    private boolean aIu;
    private View aWB;
    private long bmk;
    private PersonUserData boq;
    private long fXY;
    private Animation gKo;
    protected final PersonCardActivity hBU;
    private TextView hBV;
    private TextView hBW;
    private TextView hBX;
    private TextView hBY;
    private TextView hBZ;
    private boolean hCA;
    private a.InterfaceC0692a hCB;
    private com.baidu.tieba.ala.person.view.a hCC;
    private boolean hCD;
    private com.baidu.tieba.ala.person.a hCE;
    private a hCF;
    private TextView hCa;
    private TextView hCb;
    private TextView hCc;
    private TextView hCd;
    private TextView hCe;
    private TextView hCf;
    private LinearLayout hCg;
    private ImageView hCh;
    private TextView hCi;
    private TextView hCj;
    private TextView hCk;
    private TextView hCl;
    private TextView hCm;
    private ViewGroup hCn;
    private HeadImageView hCo;
    private TbImageView hCp;
    private LinearLayout hCq;
    private View hCr;
    private View hCs;
    private View hCt;
    private View hCu;
    private HeadImageView hCv;
    private ViewGroup hCw;
    private boolean hCx;
    private String hCy;
    private boolean hCz;
    private boolean hzf;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void ciy();

        void ciz();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.hBU = personCardActivity;
        this.hCD = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = mw(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hCC = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hCF = aVar;
    }

    private void initView() {
        this.hCr = this.mRootView.findViewById(a.f.person_card_layout);
        this.hBV = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hCg = (LinearLayout) this.mRootView.findViewById(a.f.report);
        this.hCh = (ImageView) this.mRootView.findViewById(a.f.report_img_view);
        this.hCi = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.aWB = this.mRootView.findViewById(a.f.name_layout);
        this.hBW = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hBX = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hBY = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hBZ = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hCb = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hCa = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hCc = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hCd = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hCe = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hCm = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hCf = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hCl = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hCq = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hCs = this.mRootView.findViewById(a.f.user_divide);
        this.hCt = this.mRootView.findViewById(a.f.user_divide2);
        this.hCj = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.hCk = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.hCn = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hCo = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hCo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hCo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hCo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hCo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hCo.setIsRound(true);
        this.hCo.setAutoChangeStyle(false);
        this.hCo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hCo.setBorderWidth(BdUtilHelper.getDimens(this.hBU.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hCo.setBorderColor(872415231);
        this.hCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.ciN();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hBV.getLayoutParams();
        layoutParams.addRule(1, this.hCg.getId());
        this.hBV.setLayoutParams(layoutParams);
        this.hCh.setVisibility(8);
        this.hCi.setText(a.h.ala_person_report);
        this.hCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hCy) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hCy);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hBU.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hBU.finish();
                }
            }
        });
        this.hCu = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hCv = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hCv.setIsRound(true);
        this.hCv.setAutoChangeStyle(false);
        this.hCv.setDrawBorder(false);
        this.hCv.setDefaultBgResource(a.e.sdk_default_avatar);
        if (!this.hCD) {
            this.hCw = (ViewGroup) this.mRootView.findViewById(a.f.anchor_tag_layout);
            this.hCw.setVisibility(8);
        }
    }

    private void initListener() {
        this.hBV.setOnClickListener(this);
        this.hCj.setOnClickListener(this);
        this.hCk.setOnClickListener(this);
        this.hCf.setOnClickListener(this);
        a(new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0692a
            public void ciB() {
                PersonCardViewNew.this.hBU.ciw();
            }
        });
    }

    public void a(a.InterfaceC0692a interfaceC0692a) {
        this.hCB = interfaceC0692a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.boq = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.hCC.setData(personUserData.user_info);
            if (this.hzf) {
                this.hCq.setVisibility(8);
            }
            if (this.hCq != null && this.hCq.getVisibility() == 0) {
                int childCount = this.hCq.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hCq.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hCq.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hCq.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        if (i4 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                        } else if (i4 == childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = dimensionPixelOffset;
                        }
                    }
                }
                this.hCq.setWeightSum(i2);
                this.hCq.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.hCD) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!al.DT() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Dt()) {
                        this.hCw.setVisibility(8);
                        return;
                    }
                    this.hCw.setVisibility(0);
                    this.hCw.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Ds())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Ds().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Ds().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hBU.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, wR(i));
                                this.hCw.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aIu && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hBU.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hCF != null) {
                                    PersonCardViewNew.this.hCF.ciz();
                                }
                            }
                        });
                        this.hCw.addView(alaPersonTagView2);
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

    private int wR(int i) {
        return a.e.bg_tag_new;
    }

    private void e(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aIu = personUserData.user_info != null && this.hBU.Id(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hCy = personUserData.user_info != null ? personUserData.user_info.aMv : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hCz = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hCz) {
                this.hCq.setVisibility(8);
            } else {
                this.hCq.setVisibility(0);
            }
            if (!z) {
                this.hCc.setText("火星");
            } else {
                this.hCc.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hCl.setVisibility(8);
                this.hCt.setVisibility(8);
            } else {
                this.hCl.setText(String.format(this.hBU.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hCt.setVisibility(0);
                this.hCl.setVisibility(0);
            }
            if (z2) {
                this.hCe.setText(String.format(this.hBU.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hCe.setVisibility(0);
                this.hCs.setVisibility(0);
                return;
            }
            this.hCe.setVisibility(8);
            this.hCs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciN() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hBU.getActivity());
            this.hBU.finish();
        } else if (this.boq != null && this.boq.user_info != null && this.boq.user_info.live_status == 1) {
            g gVar = new g(this.hBU);
            gVar.a(this.bmk, this.fXY, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.boq.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hBU.finish();
        } else {
            if (this.hCE != null && this.hCE.isShowing()) {
                this.hCE.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hBU.getActivity(), true);
            aVar.a(new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0692a
                public void ciB() {
                    if (PersonCardViewNew.this.hCB != null) {
                        PersonCardViewNew.this.hCB.ciB();
                    }
                }
            });
            aVar.show();
            this.hCE = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        aq aqVar = personUserData.user_info;
        if (aqVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(aqVar.fans_count < 0 ? 0L : aqVar.fans_count);
            this.hBX.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hBZ.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(aqVar.follow_count < 0 ? 0L : aqVar.follow_count);
            this.hCd.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hCa.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hBY.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hCb.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hCb.setText("");
            }
            int i2 = this.hCD ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hCD) {
                i = 22;
            }
            this.hBX.setTextSize(1, i);
            this.hCd.setTextSize(1, i);
            this.hBY.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hBV.setVisibility(8);
                this.hCg.setVisibility(8);
            } else if (this.hBU.Id(TbadkCoreApplication.getCurrentAccount())) {
                this.hCg.setVisibility(8);
                this.hBV.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32), 0, 0);
                this.hBV.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hBV.setVisibility(0);
                this.hCg.setVisibility(0);
            } else {
                this.hCg.setVisibility(0);
                this.hBV.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        aq aqVar = personUserData.user_info;
        if (aqVar != null && !StringUtils.isNull(aqVar.getNameShow())) {
            String nameShow = aqVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hBW.setText(nameShow);
        }
        l.a(this.hCo, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(aqVar.description)) {
            this.hCm.setText(a.h.ala_person_desc_default_text);
        } else {
            this.hCm.setText(aqVar.description);
        }
        If(aqVar.aMr);
    }

    private void If(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hCp == null) {
                this.hCp = new TbImageView(this.hCn.getContext());
            }
            this.hCp.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hCn != null && PersonCardViewNew.this.hCp != null && PersonCardViewNew.this.hCp.getLoadedWidth() > 0 && PersonCardViewNew.this.hCp.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hCD) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hCp.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hCn.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hCp.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hCn.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hCo != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hCo.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hCo.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hCo.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hCn.indexOfChild(PersonCardViewNew.this.hCp) < 0) {
                            PersonCardViewNew.this.hCn.addView(PersonCardViewNew.this.hCp, PersonCardViewNew.this.hCn.indexOfChild(PersonCardViewNew.this.hCo) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hCg.getVisibility() == 0 && PersonCardViewNew.this.hBV.getVisibility() == 0) {
                            PersonCardViewNew.this.hBV.setPadding(PersonCardViewNew.this.hBV.getPaddingLeft(), PersonCardViewNew.this.hBV.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hBV.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hBV.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hBV.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hCp.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hCx = false;
            nV(false);
        } else if (!this.hCz && (alaRelationData = personUserData.relation_info) != null) {
            this.hCx = alaRelationData.follow_status != 0;
            if (z) {
                this.hCf.setVisibility(8);
            } else {
                nV(this.hCx);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hCu.setVisibility(0);
            this.hCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hCF != null) {
                        PersonCardViewNew.this.hCF.ciy();
                    }
                }
            });
            this.hCv.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hCu.setVisibility(4);
    }

    private void nV(boolean z) {
        if (z) {
            this.hCf.setText("已关注");
            this.hCf.setBackgroundResource(a.e.ala_person_card_bottom_bg_red3);
        } else {
            this.hCf.setText("关注");
            this.hCf.setBackgroundResource(a.e.ala_person_card_bottom_bg_red2);
        }
        this.hCf.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hCj != null && personUserData != null && personUserData.user_info != null) {
            this.hCj.setVisibility((this.hCA && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCf) {
            ciP();
        } else if (view == this.hCk) {
            ciJ();
        } else if (view == this.hCj) {
            ciO();
        } else if (view == this.hBV) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hBU, this.boq}));
        }
    }

    private void ciO() {
        if (this.hBU != null && this.boq != null && this.boq.user_info != null && !TextUtils.isEmpty(this.boq.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hBU.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.boq.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.hBU.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void ciJ() {
        if (this.boq != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hBU.getActivity());
            } else if (this.boq.user_info == null || JavaTypesHelper.toLong(this.boq.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hBU.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.boq.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hBU.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.blO = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.boq.user_info));
                this.hBU.finish();
            }
        }
    }

    private void ciP() {
        String str;
        if (this.boq != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hBU.getActivity());
                this.hBU.finish();
            } else if (this.boq.user_info == null || JavaTypesHelper.toLong(this.boq.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hBU.getActivity(), a.h.ala_cannot_follow_tourist);
            } else {
                if (this.hCx) {
                    wS(1);
                    this.hBU.civ();
                } else {
                    wS(0);
                    this.hBU.ciu();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (!TextUtils.isEmpty(this.boq.user_info.user_id)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uid", this.boq.user_info.user_id);
                        jSONObject.put("follow", this.hCx ? 1 : 0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913258, jSONObject));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hCx ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aIu) {
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

    public void wS(int i) {
        switch (i) {
            case 0:
                this.hCx = true;
                nV(true);
                if (this.boq != null && this.boq.user_info != null) {
                    this.boq.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.boq.user_info.fans_count >= 0 ? this.boq.user_info.fans_count : 0L);
                    this.hBX.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hBZ.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hCx = false;
                nV(false);
                if (this.boq != null && this.boq.user_info != null) {
                    this.boq.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.boq.user_info.fans_count >= 0 ? this.boq.user_info.fans_count : 0L);
                    this.hBX.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hBZ.setText(formatForPersonCardBeanValue2[1]);
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

    public void nW(boolean z) {
        if (this.boq != null && this.boq.user_info != null) {
            if (z) {
                this.boq.user_info.follow_count++;
            } else {
                this.boq.user_info.follow_count--;
            }
            if (this.boq.user_info.follow_count < 0) {
                this.boq.user_info.follow_count = 0L;
            }
            this.hCf.setText(com.baidu.tieba.ala.person.d.a.aE(this.boq.user_info.follow_count));
        }
    }

    private View mw(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hBU.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hBU.getPageContext().getPageActivity()).inflate(a.g.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void nX(boolean z) {
        this.hzf = z;
    }

    public void nY(boolean z) {
        this.hCA = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gKo == null) {
                        PersonCardViewNew.this.gKo = AnimationUtils.loadAnimation(PersonCardViewNew.this.hBU.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hCr.setAnimation(PersonCardViewNew.this.gKo);
                    PersonCardViewNew.this.hCr.setVisibility(0);
                    PersonCardViewNew.this.gKo.setDuration(300L);
                    PersonCardViewNew.this.gKo.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hCr != null) {
            this.hCr.clearAnimation();
        }
        if (this.hCE != null && this.hCE.isShowing()) {
            this.hCE.dismiss();
        }
    }

    public Animation bTx() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gKo != null) {
            this.gKo.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hBU.getActivity(), a.C0195a.sdk_push_up_out);
        this.hCr.setAnimation(loadAnimation);
        this.hCr.setVisibility(8);
        return loadAnimation;
    }

    public void big() {
        if (this.hCE != null && this.hCE.isShowing()) {
            this.hCE.resize();
        }
        if (this.boq != null && this.boq.user_info != null) {
            If(this.boq.user_info.aMr);
        }
    }

    public void aP(String str, String str2) {
        this.bmk = JavaTypesHelper.toLong(str, 0L);
        this.fXY = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
