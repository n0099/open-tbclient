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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View aMS;
    private com.baidu.tbadk.core.util.b.a baD;
    private String business;
    private com.baidu.tbadk.core.dialog.b cYS;
    private boolean dUS;
    CreateGroupStepAdapter dUT;
    private int dUU;
    private TextView dUV;
    int dUW;
    e dUX;
    h dUY;
    g dUZ;
    CreateGroupStepActivity dUf;
    private int dUj;
    d dVa;
    i dVb;
    b dVc;
    private NoSwipeableViewPager dVd;
    private com.baidu.tieba.im.util.b dVe;
    private int dVf;
    private int dVg;
    private int dVh;
    private int dVi;
    private int dVj;
    private boolean dVk;
    private String dVl;
    private String dVm;
    private String dVn;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void mY(String str) {
        this.dVm = str;
    }

    public void mZ(String str) {
        this.dVn = str;
    }

    public String aBY() {
        return this.dVm;
    }

    public String aBZ() {
        return this.dVn;
    }

    public View aCa() {
        return this.aMS;
    }

    public int aCb() {
        return this.dUU;
    }

    public View aCc() {
        return this.dUV;
    }

    public View aCd() {
        if (this.dUX != null) {
            return this.dUX.aBN();
        }
        if (this.dUY != null) {
            return this.dUY.aBN();
        }
        return null;
    }

    public View aCe() {
        return this.dVb.aBV();
    }

    public View aCf() {
        return this.dVb.aBU();
    }

    public boolean aCg() {
        return this.mIsLoading;
    }

    public void aBB() {
        this.dVc.aBB();
        aCB();
    }

    public void na(String str) {
        this.dVl = str;
    }

    public String aCh() {
        return this.dVl;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.dVc.setBusiness(str);
        aCB();
    }

    public String getBusiness() {
        return this.business;
    }

    public void nb(String str) {
        this.dVc.setAddress(str);
        aCB();
    }

    public boolean aCi() {
        return this.dVk;
    }

    public void gS(boolean z) {
        this.dVk = z;
    }

    public void aBC() {
        this.dVc.aBC();
        aCB();
    }

    public void aBD() {
        this.dVc.aBD();
        aCB();
    }

    public View aCj() {
        return this.dVc.aBz();
    }

    public int aBA() {
        return this.dVc.aBA();
    }

    public View aCk() {
        return this.dUZ.aBR();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.dUZ.aBQ().getText().toString();
    }

    public String getIntro() {
        return this.dVa.aBK().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.dUW;
    }

    public boolean aCl() {
        return this.dUZ != null && this.dUU == this.dUZ.aBy();
    }

    public boolean aCm() {
        return this.dVa != null && this.dUU == this.dVa.aBy();
    }

    public boolean aCn() {
        return this.dVb != null && this.dUU == this.dVb.aBy();
    }

    public boolean aCo() {
        return this.dVc != null && this.dUU == this.dVc.aBy();
    }

    public boolean aCp() {
        return this.dUT != null && this.dUU == this.dUT.getCount();
    }

    public String getErrMsg() {
        if (this.dUT.no(this.dUU - 1) != null) {
            return this.dUT.no(this.dUU - 1).getErrMsg();
        }
        return null;
    }

    public void aCq() {
        this.dVb.aBV().setText(d.k.group_create_modify_photo_tip);
    }

    public void aCr() {
        this.dVb.aBT();
    }

    public void clearText() {
        this.dUZ.aBS();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.dUS = true;
        this.mIsLoading = false;
        this.dUf = null;
        this.dUT = null;
        this.progressBar = null;
        this.dUU = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aMS = null;
        this.dUV = null;
        this.cYS = null;
        this.dUW = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.dUX = null;
        this.dUY = null;
        this.dUZ = null;
        this.dVa = null;
        this.dVb = null;
        this.dVc = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.dVd = null;
        this.dVe = null;
        this.dVk = false;
        this.dVl = "";
        this.business = "";
        this.dVm = null;
        this.dVn = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.dVe = new com.baidu.tieba.im.util.b(this.dUf);
        this.dVe.setUniqueId(this.dUf.getUniqueId());
        aCs();
    }

    public void aCs() {
        this.dVe.Jc();
    }

    public void aCt() {
        if (this.dVe != null) {
            this.dVe.cancelLoad();
        }
    }

    private void initListener() {
        this.aMS.setOnClickListener(this.dUf);
        this.dUV.setOnClickListener(this.dUf);
        this.dUZ.aBQ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.dUZ.aBQ().addTextChangedListener(this.dUf);
        this.dVa.aBK().addTextChangedListener(this.dUf);
        this.dVb.aBV().setOnClickListener(this.dUf);
        this.dVb.aBU().setOnClickListener(this.dUf);
        this.dVc.aBz().setOnClickListener(this.dUf);
        if (this.dUY != null) {
            this.dUY.aBN().setOnClickListener(this.dUf);
        }
        if (this.dUX != null) {
            this.dUX.aBN().setOnClickListener(this.dUf);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.dUf = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.i.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.dVd = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.dUT = new CreateGroupStepAdapter(this.dUf);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.dVd.setAdapter(this.dUT);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        updateTitle();
        this.dUV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.k.next_step));
        ((LinearLayout.LayoutParams) this.dUV.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.e(getPageContext().getPageActivity(), d.e.ds16);
        ak.i(this.dUV, d.f.s_navbar_button_bg);
        gT(false);
        aCA();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.dVj = 1;
            this.dVi = 2;
            this.dVf = 3;
            this.dVg = 4;
            this.dVh = 5;
            this.dUX = new e(createGroupStepActivity, this.dVj, i2);
            this.dVc = new b(createGroupStepActivity, this.dVi, 1, 5);
            this.dUZ = new g(createGroupStepActivity, this.dVf, 2, 5);
            this.dVa = new d(createGroupStepActivity, this.dVg, 3, 5);
            this.dVb = new i(createGroupStepActivity, this.dVh, 4, 5);
            this.dUT.a(this.dUX);
            this.dUT.a(this.dVc);
            this.dUT.a(this.dUZ);
            this.dUT.a(this.dVa);
            this.dUT.a(this.dVb);
            this.dUj = 5;
        } else if (i == 2) {
            this.dVj = 1;
            this.dVf = 2;
            this.dVg = 3;
            this.dVh = 4;
            this.dVi = 5;
            this.dUY = new h(createGroupStepActivity, this.dVj, i3);
            this.dUZ = new g(createGroupStepActivity, this.dVf, 1, 5);
            this.dVa = new d(createGroupStepActivity, this.dVg, 2, 5);
            this.dVb = new i(createGroupStepActivity, this.dVh, 3, 5);
            this.dVc = new b(createGroupStepActivity, this.dVi, 4, 5);
            this.dUT.a(this.dUY);
            this.dUT.a(this.dUZ);
            this.dUT.a(this.dVa);
            this.dUT.a(this.dVb);
            this.dUT.a(this.dVc);
            this.dUj = 5;
        } else {
            this.dVf = 1;
            this.dVg = 2;
            this.dVh = 3;
            this.dVi = 4;
            this.dUZ = new g(createGroupStepActivity, this.dVf, 1, 4);
            this.dVa = new d(createGroupStepActivity, this.dVg, 2, 4);
            this.dVb = new i(createGroupStepActivity, this.dVh, 3, 4);
            this.dVc = new b(createGroupStepActivity, this.dVi, 4, 4);
            this.dUT.a(this.dUZ);
            this.dUT.a(this.dVa);
            this.dUT.a(this.dVb);
            this.dUT.a(this.dVc);
            this.dUj = 4;
        }
    }

    private void gT(boolean z) {
        this.dUS = z;
        aCv();
    }

    public boolean aCu() {
        return this.dUS;
    }

    private void aCv() {
        this.dUV.setEnabled(this.dUS);
        ak.i(this.dUV, d.f.s_navbar_button_bg);
    }

    public void aCw() {
        if (this.dUU > 1) {
            this.dUU--;
            aCy();
        }
    }

    public void aCx() {
        if (this.dUU < this.dUj) {
            this.dUU++;
            aCy();
        }
    }

    public void aCy() {
        this.dVd.setCurrentItem(this.dUU - 1);
        updateTitle();
        aCA();
        aCB();
        this.dUZ.aBQ().clearFocus();
        this.dVa.aBK().clearFocus();
        c(this.dUZ.aBQ());
        c(this.dVa.aBK());
        if (aCn() && aCg()) {
            aCc().setEnabled(false);
        } else {
            aCc().setEnabled(true);
        }
    }

    public void aCz() {
        String[] strArr = {this.dUf.getResources().getString(d.k.take_photo), this.dUf.getResources().getString(d.k.album)};
        if (this.cYS == null) {
            this.cYS = new com.baidu.tbadk.core.dialog.b(this.dUf.getPageContext().getPageActivity());
            this.cYS.dd(this.dUf.getResources().getString(d.k.operation));
            this.cYS.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.dUf.getPageContext().getPageActivity();
                    if (j.this.baD == null) {
                        j.this.baD = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.baD.wu();
                    j.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.baD.v(pageActivity)) {
                        if (i == 0) {
                            aj.b(j.this.dUf.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.dUf.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.cYS.d(this.dUf.getPageContext());
        }
        this.cYS.tG();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.dUf.getPageContext().getPageActivity();
        if (this.baD == null) {
            this.baD = new com.baidu.tbadk.core.util.b.a();
        }
        this.baD.wu();
        this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.baD.v(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.dUf.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nc(String str) {
        if (!this.dUV.getText().toString().equals(str)) {
            this.dUV.setText(str);
        }
    }

    private void updateTitle() {
        if (this.dUT.no(this.dUU - 1) != null) {
            this.mNavigationBar.setTitleText(this.dUT.no(this.dUU - 1).getTitle());
        }
    }

    public void aCA() {
        for (o oVar : this.dUT.getList()) {
            if (oVar.aBy() == this.dUU) {
                oVar.aBF();
                if (!oVar.aBJ()) {
                    this.dUV.setVisibility(8);
                } else {
                    this.dUV.setVisibility(0);
                }
                nc(oVar.aBH());
            } else {
                oVar.aBE();
            }
        }
        if (this.dUT.no(this.dUU - 1) != null && this.dUT.no(this.dUU - 1).aBI()) {
            gT(true);
        }
    }

    public void aCB() {
        if (aCl()) {
            b(this.dUZ.aBQ().getText().length(), this.dUZ.getLength() / 2, 2, 20);
        } else if (aCm()) {
            int length = this.dVa.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.dVa.aBL().setText(String.valueOf(i));
            if (i <= 50) {
                this.dVa.aBL().setVisibility(0);
            } else {
                this.dVa.aBL().setVisibility(8);
            }
            if (i == 0) {
                this.dVa.aBL().setTextColor(this.dUf.getResources().getColor(d.C0126d.common_color_10170));
            } else if (i < 0) {
                this.dVa.nn(300);
            } else {
                this.dVa.aBM();
            }
        } else if (aCo()) {
            if (this.dVc.aBA() != 3) {
                gT(true);
            } else {
                gT(false);
            }
        }
    }

    private void M(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            gT(true);
        } else {
            gT(false);
        }
    }

    private void b(int i, float f, int i2, int i3) {
        if (i == 1) {
            gT(false);
        } else if (f >= i2 && f <= i3) {
            gT(true);
        } else {
            gT(false);
        }
        if (i < 1) {
            this.dUZ.gR(false);
        } else {
            this.dUZ.gR(true);
        }
    }

    public void bc(int i, int i2) {
        this.dUW = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.dUf.getLayoutMode().setNightMode(i == 1);
        this.dUf.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aCv();
        ak.c(this.dUV, d.C0126d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.hj()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ak.j(viewGroup, d.C0126d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.dUf.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
