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
    private View bes;
    private String business;
    private com.baidu.tbadk.core.util.b.a bvI;
    private com.baidu.tbadk.core.dialog.b dDu;
    CreateGroupStepActivity eEF;
    private int eEJ;
    d eFA;
    i eFB;
    b eFC;
    private NoSwipeableViewPager eFD;
    private com.baidu.tieba.im.util.b eFE;
    private int eFF;
    private int eFG;
    private int eFH;
    private int eFI;
    private int eFJ;
    private boolean eFK;
    private String eFL;
    private String eFM;
    private String eFN;
    private boolean eFs;
    CreateGroupStepAdapter eFt;
    private int eFu;
    private TextView eFv;
    int eFw;
    e eFx;
    h eFy;
    g eFz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pc(String str) {
        this.eFM = str;
    }

    public void pd(String str) {
        this.eFN = str;
    }

    public String aNx() {
        return this.eFM;
    }

    public String aNy() {
        return this.eFN;
    }

    public View aNz() {
        return this.bes;
    }

    public int aNA() {
        return this.eFu;
    }

    public View aNB() {
        return this.eFv;
    }

    public View aNC() {
        if (this.eFx != null) {
            return this.eFx.aNm();
        }
        if (this.eFy != null) {
            return this.eFy.aNm();
        }
        return null;
    }

    public View aND() {
        return this.eFB.aNu();
    }

    public View aNE() {
        return this.eFB.aNt();
    }

    public boolean aNF() {
        return this.mIsLoading;
    }

    public void aNa() {
        this.eFC.aNa();
        aOa();
    }

    public void pe(String str) {
        this.eFL = str;
    }

    public String getAddressName() {
        return this.eFL;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eFC.setBusiness(str);
        aOa();
    }

    public String getBusiness() {
        return this.business;
    }

    public void pf(String str) {
        this.eFC.setAddress(str);
        aOa();
    }

    public boolean aNG() {
        return this.eFK;
    }

    public void il(boolean z) {
        this.eFK = z;
    }

    public void aNb() {
        this.eFC.aNb();
        aOa();
    }

    public void aNc() {
        this.eFC.aNc();
        aOa();
    }

    public View aNH() {
        return this.eFC.aMY();
    }

    public int aMZ() {
        return this.eFC.aMZ();
    }

    public View aNI() {
        return this.eFz.aNq();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eFz.aNp().getText().toString();
    }

    public String getIntro() {
        return this.eFA.aNj().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eFw;
    }

    public boolean aNJ() {
        return this.eFz != null && this.eFu == this.eFz.aMX();
    }

    public boolean aNK() {
        return this.eFA != null && this.eFu == this.eFA.aMX();
    }

    public boolean aNL() {
        return this.eFB != null && this.eFu == this.eFB.aMX();
    }

    public boolean aNM() {
        return this.eFC != null && this.eFu == this.eFC.aMX();
    }

    public boolean aNN() {
        return this.eFt != null && this.eFu == this.eFt.getCount();
    }

    public String getErrMsg() {
        if (this.eFt.po(this.eFu - 1) != null) {
            return this.eFt.po(this.eFu - 1).getErrMsg();
        }
        return null;
    }

    public void aNO() {
        this.eFB.aNu().setText(e.j.group_create_modify_photo_tip);
    }

    public void aNP() {
        this.eFB.aNs();
    }

    public void clearText() {
        this.eFz.aNr();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eFs = true;
        this.mIsLoading = false;
        this.eEF = null;
        this.eFt = null;
        this.progressBar = null;
        this.eFu = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bes = null;
        this.eFv = null;
        this.dDu = null;
        this.eFw = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eFx = null;
        this.eFy = null;
        this.eFz = null;
        this.eFA = null;
        this.eFB = null;
        this.eFC = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eFD = null;
        this.eFE = null;
        this.eFK = false;
        this.eFL = "";
        this.business = "";
        this.eFM = null;
        this.eFN = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eFE = new com.baidu.tieba.im.util.b(this.eEF);
        this.eFE.setUniqueId(this.eEF.getUniqueId());
        aNQ();
    }

    public void aNQ() {
        this.eFE.Ql();
    }

    public void aNR() {
        if (this.eFE != null) {
            this.eFE.cancelLoad();
        }
    }

    private void initListener() {
        this.bes.setOnClickListener(this.eEF);
        this.eFv.setOnClickListener(this.eEF);
        this.eFz.aNp().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eFz.aNp().addTextChangedListener(this.eEF);
        this.eFA.aNj().addTextChangedListener(this.eEF);
        this.eFB.aNu().setOnClickListener(this.eEF);
        this.eFB.aNt().setOnClickListener(this.eEF);
        this.eFC.aMY().setOnClickListener(this.eEF);
        if (this.eFy != null) {
            this.eFy.aNm().setOnClickListener(this.eEF);
        }
        if (this.eFx != null) {
            this.eFx.aNm().setOnClickListener(this.eEF);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eEF = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.eFD = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.eFt = new CreateGroupStepAdapter(this.eEF);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eFD.setAdapter(this.eFt);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bes = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aNY();
        this.eFv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.eFv.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0200e.ds16);
        al.i(this.eFv, e.f.s_navbar_button_bg);
        im(false);
        aNZ();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eFJ = 1;
            this.eFI = 2;
            this.eFF = 3;
            this.eFG = 4;
            this.eFH = 5;
            this.eFx = new e(createGroupStepActivity, this.eFJ, i2);
            this.eFC = new b(createGroupStepActivity, this.eFI, 1, 5);
            this.eFz = new g(createGroupStepActivity, this.eFF, 2, 5);
            this.eFA = new d(createGroupStepActivity, this.eFG, 3, 5);
            this.eFB = new i(createGroupStepActivity, this.eFH, 4, 5);
            this.eFt.a(this.eFx);
            this.eFt.a(this.eFC);
            this.eFt.a(this.eFz);
            this.eFt.a(this.eFA);
            this.eFt.a(this.eFB);
            this.eEJ = 5;
        } else if (i == 2) {
            this.eFJ = 1;
            this.eFF = 2;
            this.eFG = 3;
            this.eFH = 4;
            this.eFI = 5;
            this.eFy = new h(createGroupStepActivity, this.eFJ, i3);
            this.eFz = new g(createGroupStepActivity, this.eFF, 1, 5);
            this.eFA = new d(createGroupStepActivity, this.eFG, 2, 5);
            this.eFB = new i(createGroupStepActivity, this.eFH, 3, 5);
            this.eFC = new b(createGroupStepActivity, this.eFI, 4, 5);
            this.eFt.a(this.eFy);
            this.eFt.a(this.eFz);
            this.eFt.a(this.eFA);
            this.eFt.a(this.eFB);
            this.eFt.a(this.eFC);
            this.eEJ = 5;
        } else {
            this.eFF = 1;
            this.eFG = 2;
            this.eFH = 3;
            this.eFI = 4;
            this.eFz = new g(createGroupStepActivity, this.eFF, 1, 4);
            this.eFA = new d(createGroupStepActivity, this.eFG, 2, 4);
            this.eFB = new i(createGroupStepActivity, this.eFH, 3, 4);
            this.eFC = new b(createGroupStepActivity, this.eFI, 4, 4);
            this.eFt.a(this.eFz);
            this.eFt.a(this.eFA);
            this.eFt.a(this.eFB);
            this.eFt.a(this.eFC);
            this.eEJ = 4;
        }
    }

    private void im(boolean z) {
        this.eFs = z;
        aNT();
    }

    public boolean aNS() {
        return this.eFs;
    }

    private void aNT() {
        this.eFv.setEnabled(this.eFs);
        al.i(this.eFv, e.f.s_navbar_button_bg);
    }

    public void aNU() {
        if (this.eFu > 1) {
            this.eFu--;
            aNW();
        }
    }

    public void aNV() {
        if (this.eFu < this.eEJ) {
            this.eFu++;
            aNW();
        }
    }

    public void aNW() {
        this.eFD.setCurrentItem(this.eFu - 1);
        aNY();
        aNZ();
        aOa();
        this.eFz.aNp().clearFocus();
        this.eFA.aNj().clearFocus();
        c(this.eFz.aNp());
        c(this.eFA.aNj());
        if (aNL() && aNF()) {
            aNB().setEnabled(false);
        } else {
            aNB().setEnabled(true);
        }
    }

    public void aNX() {
        String[] strArr = {this.eEF.getResources().getString(e.j.take_photo), this.eEF.getResources().getString(e.j.album)};
        if (this.dDu == null) {
            this.dDu = new com.baidu.tbadk.core.dialog.b(this.eEF.getPageContext().getPageActivity());
            this.dDu.ek(this.eEF.getResources().getString(e.j.operation));
            this.dDu.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eEF.getPageContext().getPageActivity();
                    if (j.this.bvI == null) {
                        j.this.bvI = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bvI.Dp();
                    j.this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bvI.A(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eEF.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eEF.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dDu.d(this.eEF.getPageContext());
        }
        this.dDu.AE();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eEF.getPageContext().getPageActivity();
        if (this.bvI == null) {
            this.bvI = new com.baidu.tbadk.core.util.b.a();
        }
        this.bvI.Dp();
        this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bvI.A(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eEF.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void pg(String str) {
        if (!this.eFv.getText().toString().equals(str)) {
            this.eFv.setText(str);
        }
    }

    private void aNY() {
        if (this.eFt.po(this.eFu - 1) != null) {
            this.mNavigationBar.setTitleText(this.eFt.po(this.eFu - 1).getTitle());
        }
    }

    public void aNZ() {
        for (o oVar : this.eFt.getList()) {
            if (oVar.aMX() == this.eFu) {
                oVar.aNe();
                if (!oVar.aNi()) {
                    this.eFv.setVisibility(8);
                } else {
                    this.eFv.setVisibility(0);
                }
                pg(oVar.aNg());
            } else {
                oVar.aNd();
            }
        }
        if (this.eFt.po(this.eFu - 1) != null && this.eFt.po(this.eFu - 1).aNh()) {
            im(true);
        }
    }

    public void aOa() {
        if (aNJ()) {
            a(this.eFz.aNp().getText().length(), this.eFz.getLength() / 2, 2, 20);
        } else if (aNK()) {
            int length = this.eFA.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.eFA.aNk().setText(String.valueOf(i));
            if (i <= 50) {
                this.eFA.aNk().setVisibility(0);
            } else {
                this.eFA.aNk().setVisibility(8);
            }
            if (i == 0) {
                this.eFA.aNk().setTextColor(this.eEF.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.eFA.pm(300);
            } else {
                this.eFA.aNl();
            }
        } else if (aNM()) {
            if (this.eFC.aMZ() != 3) {
                im(true);
            } else {
                im(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            im(true);
        } else {
            im(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            im(false);
        } else if (f >= i2 && f <= i3) {
            im(true);
        } else {
            im(false);
        }
        if (i < 1) {
            this.eFz.ik(false);
        } else {
            this.eFz.ik(true);
        }
    }

    public void setData(int i, int i2) {
        this.eFw = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eEF.getLayoutMode().setNightMode(i == 1);
        this.eEF.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aNT();
        al.c(this.eFv, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.lo()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eEF.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
