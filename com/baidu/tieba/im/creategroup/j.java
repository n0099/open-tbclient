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
    private View bhV;
    private String business;
    private com.baidu.tbadk.core.util.b.a bzi;
    private com.baidu.tbadk.core.dialog.b dMH;
    private boolean eOY;
    CreateGroupStepAdapter eOZ;
    CreateGroupStepActivity eOl;
    private int eOp;
    private int ePa;
    private TextView ePb;
    int ePc;
    e ePd;
    h ePe;
    g ePf;
    d ePg;
    i ePh;
    b ePi;
    private NoSwipeableViewPager ePj;
    private com.baidu.tieba.im.util.b ePk;
    private int ePl;
    private int ePm;
    private int ePn;
    private int ePo;
    private int ePp;
    private boolean ePq;
    private String ePr;
    private String ePs;
    private String ePt;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pH(String str) {
        this.ePs = str;
    }

    public void pI(String str) {
        this.ePt = str;
    }

    public String aQc() {
        return this.ePs;
    }

    public String aQd() {
        return this.ePt;
    }

    public View aQe() {
        return this.bhV;
    }

    public int aQf() {
        return this.ePa;
    }

    public View aQg() {
        return this.ePb;
    }

    public View aQh() {
        if (this.ePd != null) {
            return this.ePd.aPR();
        }
        if (this.ePe != null) {
            return this.ePe.aPR();
        }
        return null;
    }

    public View aQi() {
        return this.ePh.aPZ();
    }

    public View aQj() {
        return this.ePh.aPY();
    }

    public boolean aQk() {
        return this.mIsLoading;
    }

    public void aPF() {
        this.ePi.aPF();
        aQF();
    }

    public void pJ(String str) {
        this.ePr = str;
    }

    public String getAddressName() {
        return this.ePr;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.ePi.setBusiness(str);
        aQF();
    }

    public String getBusiness() {
        return this.business;
    }

    public void pK(String str) {
        this.ePi.setAddress(str);
        aQF();
    }

    public boolean aQl() {
        return this.ePq;
    }

    public void ir(boolean z) {
        this.ePq = z;
    }

    public void aPG() {
        this.ePi.aPG();
        aQF();
    }

    public void aPH() {
        this.ePi.aPH();
        aQF();
    }

    public View aQm() {
        return this.ePi.aPD();
    }

    public int aPE() {
        return this.ePi.aPE();
    }

    public View aQn() {
        return this.ePf.aPV();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.ePf.aPU().getText().toString();
    }

    public String getIntro() {
        return this.ePg.aPO().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.ePc;
    }

    public boolean aQo() {
        return this.ePf != null && this.ePa == this.ePf.aPC();
    }

    public boolean aQp() {
        return this.ePg != null && this.ePa == this.ePg.aPC();
    }

    public boolean aQq() {
        return this.ePh != null && this.ePa == this.ePh.aPC();
    }

    public boolean aQr() {
        return this.ePi != null && this.ePa == this.ePi.aPC();
    }

    public boolean aQs() {
        return this.eOZ != null && this.ePa == this.eOZ.getCount();
    }

    public String getErrMsg() {
        if (this.eOZ.pV(this.ePa - 1) != null) {
            return this.eOZ.pV(this.ePa - 1).getErrMsg();
        }
        return null;
    }

    public void aQt() {
        this.ePh.aPZ().setText(e.j.group_create_modify_photo_tip);
    }

    public void aQu() {
        this.ePh.aPX();
    }

    public void clearText() {
        this.ePf.aPW();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eOY = true;
        this.mIsLoading = false;
        this.eOl = null;
        this.eOZ = null;
        this.progressBar = null;
        this.ePa = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bhV = null;
        this.ePb = null;
        this.dMH = null;
        this.ePc = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.ePd = null;
        this.ePe = null;
        this.ePf = null;
        this.ePg = null;
        this.ePh = null;
        this.ePi = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ePj = null;
        this.ePk = null;
        this.ePq = false;
        this.ePr = "";
        this.business = "";
        this.ePs = null;
        this.ePt = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.ePk = new com.baidu.tieba.im.util.b(this.eOl);
        this.ePk.setUniqueId(this.eOl.getUniqueId());
        aQv();
    }

    public void aQv() {
        this.ePk.Rt();
    }

    public void aQw() {
        if (this.ePk != null) {
            this.ePk.cancelLoad();
        }
    }

    private void initListener() {
        this.bhV.setOnClickListener(this.eOl);
        this.ePb.setOnClickListener(this.eOl);
        this.ePf.aPU().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.ePf.aPU().addTextChangedListener(this.eOl);
        this.ePg.aPO().addTextChangedListener(this.eOl);
        this.ePh.aPZ().setOnClickListener(this.eOl);
        this.ePh.aPY().setOnClickListener(this.eOl);
        this.ePi.aPD().setOnClickListener(this.eOl);
        if (this.ePe != null) {
            this.ePe.aPR().setOnClickListener(this.eOl);
        }
        if (this.ePd != null) {
            this.ePd.aPR().setOnClickListener(this.eOl);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eOl = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.ePj = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.eOZ = new CreateGroupStepAdapter(this.eOl);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ePj.setAdapter(this.eOZ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bhV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aQD();
        this.ePb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.ePb.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        al.i(this.ePb, e.f.s_navbar_button_bg);
        is(false);
        aQE();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.ePp = 1;
            this.ePo = 2;
            this.ePl = 3;
            this.ePm = 4;
            this.ePn = 5;
            this.ePd = new e(createGroupStepActivity, this.ePp, i2);
            this.ePi = new b(createGroupStepActivity, this.ePo, 1, 5);
            this.ePf = new g(createGroupStepActivity, this.ePl, 2, 5);
            this.ePg = new d(createGroupStepActivity, this.ePm, 3, 5);
            this.ePh = new i(createGroupStepActivity, this.ePn, 4, 5);
            this.eOZ.a(this.ePd);
            this.eOZ.a(this.ePi);
            this.eOZ.a(this.ePf);
            this.eOZ.a(this.ePg);
            this.eOZ.a(this.ePh);
            this.eOp = 5;
        } else if (i == 2) {
            this.ePp = 1;
            this.ePl = 2;
            this.ePm = 3;
            this.ePn = 4;
            this.ePo = 5;
            this.ePe = new h(createGroupStepActivity, this.ePp, i3);
            this.ePf = new g(createGroupStepActivity, this.ePl, 1, 5);
            this.ePg = new d(createGroupStepActivity, this.ePm, 2, 5);
            this.ePh = new i(createGroupStepActivity, this.ePn, 3, 5);
            this.ePi = new b(createGroupStepActivity, this.ePo, 4, 5);
            this.eOZ.a(this.ePe);
            this.eOZ.a(this.ePf);
            this.eOZ.a(this.ePg);
            this.eOZ.a(this.ePh);
            this.eOZ.a(this.ePi);
            this.eOp = 5;
        } else {
            this.ePl = 1;
            this.ePm = 2;
            this.ePn = 3;
            this.ePo = 4;
            this.ePf = new g(createGroupStepActivity, this.ePl, 1, 4);
            this.ePg = new d(createGroupStepActivity, this.ePm, 2, 4);
            this.ePh = new i(createGroupStepActivity, this.ePn, 3, 4);
            this.ePi = new b(createGroupStepActivity, this.ePo, 4, 4);
            this.eOZ.a(this.ePf);
            this.eOZ.a(this.ePg);
            this.eOZ.a(this.ePh);
            this.eOZ.a(this.ePi);
            this.eOp = 4;
        }
    }

    private void is(boolean z) {
        this.eOY = z;
        aQy();
    }

    public boolean aQx() {
        return this.eOY;
    }

    private void aQy() {
        this.ePb.setEnabled(this.eOY);
        al.i(this.ePb, e.f.s_navbar_button_bg);
    }

    public void aQz() {
        if (this.ePa > 1) {
            this.ePa--;
            aQB();
        }
    }

    public void aQA() {
        if (this.ePa < this.eOp) {
            this.ePa++;
            aQB();
        }
    }

    public void aQB() {
        this.ePj.setCurrentItem(this.ePa - 1);
        aQD();
        aQE();
        aQF();
        this.ePf.aPU().clearFocus();
        this.ePg.aPO().clearFocus();
        c(this.ePf.aPU());
        c(this.ePg.aPO());
        if (aQq() && aQk()) {
            aQg().setEnabled(false);
        } else {
            aQg().setEnabled(true);
        }
    }

    public void aQC() {
        String[] strArr = {this.eOl.getResources().getString(e.j.take_photo), this.eOl.getResources().getString(e.j.album)};
        if (this.dMH == null) {
            this.dMH = new com.baidu.tbadk.core.dialog.b(this.eOl.getPageContext().getPageActivity());
            this.dMH.eC(this.eOl.getResources().getString(e.j.operation));
            this.dMH.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eOl.getPageContext().getPageActivity();
                    if (j.this.bzi == null) {
                        j.this.bzi = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bzi.Et();
                    j.this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bzi.A(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eOl.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eOl.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dMH.d(this.eOl.getPageContext());
        }
        this.dMH.BI();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eOl.getPageContext().getPageActivity();
        if (this.bzi == null) {
            this.bzi = new com.baidu.tbadk.core.util.b.a();
        }
        this.bzi.Et();
        this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bzi.A(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eOl.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void pL(String str) {
        if (!this.ePb.getText().toString().equals(str)) {
            this.ePb.setText(str);
        }
    }

    private void aQD() {
        if (this.eOZ.pV(this.ePa - 1) != null) {
            this.mNavigationBar.setTitleText(this.eOZ.pV(this.ePa - 1).getTitle());
        }
    }

    public void aQE() {
        for (o oVar : this.eOZ.getList()) {
            if (oVar.aPC() == this.ePa) {
                oVar.aPJ();
                if (!oVar.aPN()) {
                    this.ePb.setVisibility(8);
                } else {
                    this.ePb.setVisibility(0);
                }
                pL(oVar.aPL());
            } else {
                oVar.aPI();
            }
        }
        if (this.eOZ.pV(this.ePa - 1) != null && this.eOZ.pV(this.ePa - 1).aPM()) {
            is(true);
        }
    }

    public void aQF() {
        if (aQo()) {
            a(this.ePf.aPU().getText().length(), this.ePf.getLength() / 2, 2, 20);
        } else if (aQp()) {
            int length = this.ePg.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.ePg.aPP().setText(String.valueOf(i));
            if (i <= 50) {
                this.ePg.aPP().setVisibility(0);
            } else {
                this.ePg.aPP().setVisibility(8);
            }
            if (i == 0) {
                this.ePg.aPP().setTextColor(this.eOl.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.ePg.pU(300);
            } else {
                this.ePg.aPQ();
            }
        } else if (aQr()) {
            if (this.ePi.aPE() != 3) {
                is(true);
            } else {
                is(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            is(true);
        } else {
            is(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            is(false);
        } else if (f >= i2 && f <= i3) {
            is(true);
        } else {
            is(false);
        }
        if (i < 1) {
            this.ePf.iq(false);
        } else {
            this.ePf.iq(true);
        }
    }

    public void setData(int i, int i2) {
        this.ePc = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eOl.getLayoutMode().setNightMode(i == 1);
        this.eOl.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aQy();
        al.c(this.ePb, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.ln()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eOl.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
