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
    private boolean eDZ;
    CreateGroupStepActivity eDm;
    private int eDq;
    CreateGroupStepAdapter eEa;
    private int eEb;
    private TextView eEc;
    int eEd;
    e eEe;
    h eEf;
    g eEg;
    d eEh;
    i eEi;
    b eEj;
    private NoSwipeableViewPager eEk;
    private com.baidu.tieba.im.util.b eEl;
    private int eEm;
    private int eEn;
    private int eEo;
    private int eEp;
    private int eEq;
    private boolean eEr;
    private String eEs;
    private String eEt;
    private String eEu;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pb(String str) {
        this.eEt = str;
    }

    public void pc(String str) {
        this.eEu = str;
    }

    public String aOa() {
        return this.eEt;
    }

    public String aOb() {
        return this.eEu;
    }

    public View aOc() {
        return this.bdE;
    }

    public int aOd() {
        return this.eEb;
    }

    public View aOe() {
        return this.eEc;
    }

    public View aOf() {
        if (this.eEe != null) {
            return this.eEe.aNP();
        }
        if (this.eEf != null) {
            return this.eEf.aNP();
        }
        return null;
    }

    public View aOg() {
        return this.eEi.aNX();
    }

    public View aOh() {
        return this.eEi.aNW();
    }

    public boolean aOi() {
        return this.mIsLoading;
    }

    public void aND() {
        this.eEj.aND();
        aOD();
    }

    public void pd(String str) {
        this.eEs = str;
    }

    public String getAddressName() {
        return this.eEs;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eEj.setBusiness(str);
        aOD();
    }

    public String getBusiness() {
        return this.business;
    }

    public void pe(String str) {
        this.eEj.setAddress(str);
        aOD();
    }

    public boolean aOj() {
        return this.eEr;
    }

    public void ic(boolean z) {
        this.eEr = z;
    }

    public void aNE() {
        this.eEj.aNE();
        aOD();
    }

    public void aNF() {
        this.eEj.aNF();
        aOD();
    }

    public View aOk() {
        return this.eEj.aNB();
    }

    public int aNC() {
        return this.eEj.aNC();
    }

    public View aOl() {
        return this.eEg.aNT();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eEg.aNS().getText().toString();
    }

    public String getIntro() {
        return this.eEh.aNM().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eEd;
    }

    public boolean aOm() {
        return this.eEg != null && this.eEb == this.eEg.aNA();
    }

    public boolean aOn() {
        return this.eEh != null && this.eEb == this.eEh.aNA();
    }

    public boolean aOo() {
        return this.eEi != null && this.eEb == this.eEi.aNA();
    }

    public boolean aOp() {
        return this.eEj != null && this.eEb == this.eEj.aNA();
    }

    public boolean aOq() {
        return this.eEa != null && this.eEb == this.eEa.getCount();
    }

    public String getErrMsg() {
        if (this.eEa.oV(this.eEb - 1) != null) {
            return this.eEa.oV(this.eEb - 1).getErrMsg();
        }
        return null;
    }

    public void aOr() {
        this.eEi.aNX().setText(e.j.group_create_modify_photo_tip);
    }

    public void aOs() {
        this.eEi.aNV();
    }

    public void clearText() {
        this.eEg.aNU();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eDZ = true;
        this.mIsLoading = false;
        this.eDm = null;
        this.eEa = null;
        this.progressBar = null;
        this.eEb = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bdE = null;
        this.eEc = null;
        this.dCd = null;
        this.eEd = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eEe = null;
        this.eEf = null;
        this.eEg = null;
        this.eEh = null;
        this.eEi = null;
        this.eEj = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eEk = null;
        this.eEl = null;
        this.eEr = false;
        this.eEs = "";
        this.business = "";
        this.eEt = null;
        this.eEu = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eEl = new com.baidu.tieba.im.util.b(this.eDm);
        this.eEl.setUniqueId(this.eDm.getUniqueId());
        aOt();
    }

    public void aOt() {
        this.eEl.Qc();
    }

    public void aOu() {
        if (this.eEl != null) {
            this.eEl.cancelLoad();
        }
    }

    private void initListener() {
        this.bdE.setOnClickListener(this.eDm);
        this.eEc.setOnClickListener(this.eDm);
        this.eEg.aNS().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eEg.aNS().addTextChangedListener(this.eDm);
        this.eEh.aNM().addTextChangedListener(this.eDm);
        this.eEi.aNX().setOnClickListener(this.eDm);
        this.eEi.aNW().setOnClickListener(this.eDm);
        this.eEj.aNB().setOnClickListener(this.eDm);
        if (this.eEf != null) {
            this.eEf.aNP().setOnClickListener(this.eDm);
        }
        if (this.eEe != null) {
            this.eEe.aNP().setOnClickListener(this.eDm);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eDm = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.eEk = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.eEa = new CreateGroupStepAdapter(this.eDm);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eEk.setAdapter(this.eEa);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aOB();
        this.eEc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.eEc.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0175e.ds16);
        al.i(this.eEc, e.f.s_navbar_button_bg);
        id(false);
        aOC();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eEq = 1;
            this.eEp = 2;
            this.eEm = 3;
            this.eEn = 4;
            this.eEo = 5;
            this.eEe = new e(createGroupStepActivity, this.eEq, i2);
            this.eEj = new b(createGroupStepActivity, this.eEp, 1, 5);
            this.eEg = new g(createGroupStepActivity, this.eEm, 2, 5);
            this.eEh = new d(createGroupStepActivity, this.eEn, 3, 5);
            this.eEi = new i(createGroupStepActivity, this.eEo, 4, 5);
            this.eEa.a(this.eEe);
            this.eEa.a(this.eEj);
            this.eEa.a(this.eEg);
            this.eEa.a(this.eEh);
            this.eEa.a(this.eEi);
            this.eDq = 5;
        } else if (i == 2) {
            this.eEq = 1;
            this.eEm = 2;
            this.eEn = 3;
            this.eEo = 4;
            this.eEp = 5;
            this.eEf = new h(createGroupStepActivity, this.eEq, i3);
            this.eEg = new g(createGroupStepActivity, this.eEm, 1, 5);
            this.eEh = new d(createGroupStepActivity, this.eEn, 2, 5);
            this.eEi = new i(createGroupStepActivity, this.eEo, 3, 5);
            this.eEj = new b(createGroupStepActivity, this.eEp, 4, 5);
            this.eEa.a(this.eEf);
            this.eEa.a(this.eEg);
            this.eEa.a(this.eEh);
            this.eEa.a(this.eEi);
            this.eEa.a(this.eEj);
            this.eDq = 5;
        } else {
            this.eEm = 1;
            this.eEn = 2;
            this.eEo = 3;
            this.eEp = 4;
            this.eEg = new g(createGroupStepActivity, this.eEm, 1, 4);
            this.eEh = new d(createGroupStepActivity, this.eEn, 2, 4);
            this.eEi = new i(createGroupStepActivity, this.eEo, 3, 4);
            this.eEj = new b(createGroupStepActivity, this.eEp, 4, 4);
            this.eEa.a(this.eEg);
            this.eEa.a(this.eEh);
            this.eEa.a(this.eEi);
            this.eEa.a(this.eEj);
            this.eDq = 4;
        }
    }

    private void id(boolean z) {
        this.eDZ = z;
        aOw();
    }

    public boolean aOv() {
        return this.eDZ;
    }

    private void aOw() {
        this.eEc.setEnabled(this.eDZ);
        al.i(this.eEc, e.f.s_navbar_button_bg);
    }

    public void aOx() {
        if (this.eEb > 1) {
            this.eEb--;
            aOz();
        }
    }

    public void aOy() {
        if (this.eEb < this.eDq) {
            this.eEb++;
            aOz();
        }
    }

    public void aOz() {
        this.eEk.setCurrentItem(this.eEb - 1);
        aOB();
        aOC();
        aOD();
        this.eEg.aNS().clearFocus();
        this.eEh.aNM().clearFocus();
        c(this.eEg.aNS());
        c(this.eEh.aNM());
        if (aOo() && aOi()) {
            aOe().setEnabled(false);
        } else {
            aOe().setEnabled(true);
        }
    }

    public void aOA() {
        String[] strArr = {this.eDm.getResources().getString(e.j.take_photo), this.eDm.getResources().getString(e.j.album)};
        if (this.dCd == null) {
            this.dCd = new com.baidu.tbadk.core.dialog.b(this.eDm.getPageContext().getPageActivity());
            this.dCd.ek(this.eDm.getResources().getString(e.j.operation));
            this.dCd.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eDm.getPageContext().getPageActivity();
                    if (j.this.buX == null) {
                        j.this.buX = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.buX.Di();
                    j.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.buX.z(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eDm.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eDm.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dCd.d(this.eDm.getPageContext());
        }
        this.dCd.Ax();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eDm.getPageContext().getPageActivity();
        if (this.buX == null) {
            this.buX = new com.baidu.tbadk.core.util.b.a();
        }
        this.buX.Di();
        this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.buX.z(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eDm.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void pf(String str) {
        if (!this.eEc.getText().toString().equals(str)) {
            this.eEc.setText(str);
        }
    }

    private void aOB() {
        if (this.eEa.oV(this.eEb - 1) != null) {
            this.mNavigationBar.setTitleText(this.eEa.oV(this.eEb - 1).getTitle());
        }
    }

    public void aOC() {
        for (o oVar : this.eEa.getList()) {
            if (oVar.aNA() == this.eEb) {
                oVar.aNH();
                if (!oVar.aNL()) {
                    this.eEc.setVisibility(8);
                } else {
                    this.eEc.setVisibility(0);
                }
                pf(oVar.aNJ());
            } else {
                oVar.aNG();
            }
        }
        if (this.eEa.oV(this.eEb - 1) != null && this.eEa.oV(this.eEb - 1).aNK()) {
            id(true);
        }
    }

    public void aOD() {
        if (aOm()) {
            a(this.eEg.aNS().getText().length(), this.eEg.getLength() / 2, 2, 20);
        } else if (aOn()) {
            int length = this.eEh.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.eEh.aNN().setText(String.valueOf(i));
            if (i <= 50) {
                this.eEh.aNN().setVisibility(0);
            } else {
                this.eEh.aNN().setVisibility(8);
            }
            if (i == 0) {
                this.eEh.aNN().setTextColor(this.eDm.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.eEh.oU(300);
            } else {
                this.eEh.aNO();
            }
        } else if (aOp()) {
            if (this.eEj.aNC() != 3) {
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
            this.eEg.ib(false);
        } else {
            this.eEg.ib(true);
        }
    }

    public void setData(int i, int i2) {
        this.eEd = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eDm.getLayoutMode().setNightMode(i == 1);
        this.eDm.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aOw();
        al.c(this.eEc, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.lq()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eDm.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
