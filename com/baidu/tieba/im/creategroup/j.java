package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View bdE;
    private com.baidu.tbadk.core.util.b.a buX;
    private String business;
    private com.baidu.tbadk.core.dialog.b dCd;
    private boolean eDY;
    CreateGroupStepAdapter eDZ;
    CreateGroupStepActivity eDl;
    private int eDp;
    private int eEa;
    private TextView eEb;
    int eEc;
    e eEd;
    h eEe;
    g eEf;
    d eEg;
    i eEh;
    b eEi;
    private NoSwipeableViewPager eEj;
    private com.baidu.tieba.im.util.b eEk;
    private int eEl;
    private int eEm;
    private int eEn;
    private int eEo;
    private int eEp;
    private boolean eEq;
    private String eEr;
    private String eEs;
    private String eEt;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pb(String str) {
        this.eEs = str;
    }

    public void pc(String str) {
        this.eEt = str;
    }

    public String aOa() {
        return this.eEs;
    }

    public String aOb() {
        return this.eEt;
    }

    public View aOc() {
        return this.bdE;
    }

    public int aOd() {
        return this.eEa;
    }

    public View aOe() {
        return this.eEb;
    }

    public View aOf() {
        if (this.eEd != null) {
            return this.eEd.aNP();
        }
        if (this.eEe != null) {
            return this.eEe.aNP();
        }
        return null;
    }

    public View aOg() {
        return this.eEh.aNX();
    }

    public View aOh() {
        return this.eEh.aNW();
    }

    public boolean aOi() {
        return this.mIsLoading;
    }

    public void aND() {
        this.eEi.aND();
        aOD();
    }

    public void pd(String str) {
        this.eEr = str;
    }

    public String getAddressName() {
        return this.eEr;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eEi.setBusiness(str);
        aOD();
    }

    public String getBusiness() {
        return this.business;
    }

    public void pe(String str) {
        this.eEi.setAddress(str);
        aOD();
    }

    public boolean aOj() {
        return this.eEq;
    }

    public void ic(boolean z) {
        this.eEq = z;
    }

    public void aNE() {
        this.eEi.aNE();
        aOD();
    }

    public void aNF() {
        this.eEi.aNF();
        aOD();
    }

    public View aOk() {
        return this.eEi.aNB();
    }

    public int aNC() {
        return this.eEi.aNC();
    }

    public View aOl() {
        return this.eEf.aNT();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eEf.aNS().getText().toString();
    }

    public String getIntro() {
        return this.eEg.aNM().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eEc;
    }

    public boolean aOm() {
        return this.eEf != null && this.eEa == this.eEf.aNA();
    }

    public boolean aOn() {
        return this.eEg != null && this.eEa == this.eEg.aNA();
    }

    public boolean aOo() {
        return this.eEh != null && this.eEa == this.eEh.aNA();
    }

    public boolean aOp() {
        return this.eEi != null && this.eEa == this.eEi.aNA();
    }

    public boolean aOq() {
        return this.eDZ != null && this.eEa == this.eDZ.getCount();
    }

    public String getErrMsg() {
        if (this.eDZ.oV(this.eEa - 1) != null) {
            return this.eDZ.oV(this.eEa - 1).getErrMsg();
        }
        return null;
    }

    public void aOr() {
        this.eEh.aNX().setText(e.j.group_create_modify_photo_tip);
    }

    public void aOs() {
        this.eEh.aNV();
    }

    public void clearText() {
        this.eEf.aNU();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eDY = true;
        this.mIsLoading = false;
        this.eDl = null;
        this.eDZ = null;
        this.progressBar = null;
        this.eEa = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bdE = null;
        this.eEb = null;
        this.dCd = null;
        this.eEc = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eEd = null;
        this.eEe = null;
        this.eEf = null;
        this.eEg = null;
        this.eEh = null;
        this.eEi = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eEj = null;
        this.eEk = null;
        this.eEq = false;
        this.eEr = "";
        this.business = "";
        this.eEs = null;
        this.eEt = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eEk = new com.baidu.tieba.im.util.b(this.eDl);
        this.eEk.setUniqueId(this.eDl.getUniqueId());
        aOt();
    }

    public void aOt() {
        this.eEk.Qc();
    }

    public void aOu() {
        if (this.eEk != null) {
            this.eEk.cancelLoad();
        }
    }

    private void initListener() {
        this.bdE.setOnClickListener(this.eDl);
        this.eEb.setOnClickListener(this.eDl);
        this.eEf.aNS().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eEf.aNS().addTextChangedListener(this.eDl);
        this.eEg.aNM().addTextChangedListener(this.eDl);
        this.eEh.aNX().setOnClickListener(this.eDl);
        this.eEh.aNW().setOnClickListener(this.eDl);
        this.eEi.aNB().setOnClickListener(this.eDl);
        if (this.eEe != null) {
            this.eEe.aNP().setOnClickListener(this.eDl);
        }
        if (this.eEd != null) {
            this.eEd.aNP().setOnClickListener(this.eDl);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eDl = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.eEj = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.eDZ = new CreateGroupStepAdapter(this.eDl);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eEj.setAdapter(this.eDZ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aOB();
        this.eEb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.eEb.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0175e.ds16);
        al.i(this.eEb, e.f.s_navbar_button_bg);
        id(false);
        aOC();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eEp = 1;
            this.eEo = 2;
            this.eEl = 3;
            this.eEm = 4;
            this.eEn = 5;
            this.eEd = new e(createGroupStepActivity, this.eEp, i2);
            this.eEi = new b(createGroupStepActivity, this.eEo, 1, 5);
            this.eEf = new g(createGroupStepActivity, this.eEl, 2, 5);
            this.eEg = new d(createGroupStepActivity, this.eEm, 3, 5);
            this.eEh = new i(createGroupStepActivity, this.eEn, 4, 5);
            this.eDZ.a(this.eEd);
            this.eDZ.a(this.eEi);
            this.eDZ.a(this.eEf);
            this.eDZ.a(this.eEg);
            this.eDZ.a(this.eEh);
            this.eDp = 5;
        } else if (i == 2) {
            this.eEp = 1;
            this.eEl = 2;
            this.eEm = 3;
            this.eEn = 4;
            this.eEo = 5;
            this.eEe = new h(createGroupStepActivity, this.eEp, i3);
            this.eEf = new g(createGroupStepActivity, this.eEl, 1, 5);
            this.eEg = new d(createGroupStepActivity, this.eEm, 2, 5);
            this.eEh = new i(createGroupStepActivity, this.eEn, 3, 5);
            this.eEi = new b(createGroupStepActivity, this.eEo, 4, 5);
            this.eDZ.a(this.eEe);
            this.eDZ.a(this.eEf);
            this.eDZ.a(this.eEg);
            this.eDZ.a(this.eEh);
            this.eDZ.a(this.eEi);
            this.eDp = 5;
        } else {
            this.eEl = 1;
            this.eEm = 2;
            this.eEn = 3;
            this.eEo = 4;
            this.eEf = new g(createGroupStepActivity, this.eEl, 1, 4);
            this.eEg = new d(createGroupStepActivity, this.eEm, 2, 4);
            this.eEh = new i(createGroupStepActivity, this.eEn, 3, 4);
            this.eEi = new b(createGroupStepActivity, this.eEo, 4, 4);
            this.eDZ.a(this.eEf);
            this.eDZ.a(this.eEg);
            this.eDZ.a(this.eEh);
            this.eDZ.a(this.eEi);
            this.eDp = 4;
        }
    }

    private void id(boolean z) {
        this.eDY = z;
        aOw();
    }

    public boolean aOv() {
        return this.eDY;
    }

    private void aOw() {
        this.eEb.setEnabled(this.eDY);
        al.i(this.eEb, e.f.s_navbar_button_bg);
    }

    public void aOx() {
        if (this.eEa > 1) {
            this.eEa--;
            aOz();
        }
    }

    public void aOy() {
        if (this.eEa < this.eDp) {
            this.eEa++;
            aOz();
        }
    }

    public void aOz() {
        this.eEj.setCurrentItem(this.eEa - 1);
        aOB();
        aOC();
        aOD();
        this.eEf.aNS().clearFocus();
        this.eEg.aNM().clearFocus();
        c(this.eEf.aNS());
        c(this.eEg.aNM());
        if (aOo() && aOi()) {
            aOe().setEnabled(false);
        } else {
            aOe().setEnabled(true);
        }
    }

    public void aOA() {
        String[] strArr = {this.eDl.getResources().getString(e.j.take_photo), this.eDl.getResources().getString(e.j.album)};
        if (this.dCd == null) {
            this.dCd = new com.baidu.tbadk.core.dialog.b(this.eDl.getPageContext().getPageActivity());
            this.dCd.ek(this.eDl.getResources().getString(e.j.operation));
            this.dCd.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eDl.getPageContext().getPageActivity();
                    if (j.this.buX == null) {
                        j.this.buX = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.buX.Di();
                    j.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.buX.z(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eDl.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eDl.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dCd.d(this.eDl.getPageContext());
        }
        this.dCd.Ax();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eDl.getPageContext().getPageActivity();
        if (this.buX == null) {
            this.buX = new com.baidu.tbadk.core.util.b.a();
        }
        this.buX.Di();
        this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.buX.z(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eDl.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void pf(String str) {
        if (!this.eEb.getText().toString().equals(str)) {
            this.eEb.setText(str);
        }
    }

    private void aOB() {
        if (this.eDZ.oV(this.eEa - 1) != null) {
            this.mNavigationBar.setTitleText(this.eDZ.oV(this.eEa - 1).getTitle());
        }
    }

    public void aOC() {
        for (o oVar : this.eDZ.getList()) {
            if (oVar.aNA() == this.eEa) {
                oVar.aNH();
                if (!oVar.aNL()) {
                    this.eEb.setVisibility(8);
                } else {
                    this.eEb.setVisibility(0);
                }
                pf(oVar.aNJ());
            } else {
                oVar.aNG();
            }
        }
        if (this.eDZ.oV(this.eEa - 1) != null && this.eDZ.oV(this.eEa - 1).aNK()) {
            id(true);
        }
    }

    public void aOD() {
        if (aOm()) {
            a(this.eEf.aNS().getText().length(), this.eEf.getLength() / 2, 2, 20);
        } else if (aOn()) {
            int length = this.eEg.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.eEg.aNN().setText(String.valueOf(i));
            if (i <= 50) {
                this.eEg.aNN().setVisibility(0);
            } else {
                this.eEg.aNN().setVisibility(8);
            }
            if (i == 0) {
                this.eEg.aNN().setTextColor(this.eDl.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.eEg.oU(300);
            } else {
                this.eEg.aNO();
            }
        } else if (aOp()) {
            if (this.eEi.aNC() != 3) {
                id(true);
            } else {
                id(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            id(true);
        } else {
            id(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            id(false);
        } else if (f >= i2 && f <= i3) {
            id(true);
        } else {
            id(false);
        }
        if (i < 1) {
            this.eEf.ib(false);
        } else {
            this.eEf.ib(true);
        }
    }

    public void setData(int i, int i2) {
        this.eEc = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eDl.getLayoutMode().setNightMode(i == 1);
        this.eDl.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aOw();
        al.c(this.eEb, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.lq()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eDl.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
