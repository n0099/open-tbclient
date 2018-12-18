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
    private View bhS;
    private String business;
    private com.baidu.tbadk.core.util.b.a bzf;
    private com.baidu.tbadk.core.dialog.b dJT;
    CreateGroupStepActivity eLu;
    private int eLy;
    private String eMA;
    private String eMB;
    private String eMC;
    private boolean eMh;
    CreateGroupStepAdapter eMi;
    private int eMj;
    private TextView eMk;
    int eMl;
    e eMm;
    h eMn;
    g eMo;
    d eMp;
    i eMq;
    b eMr;
    private NoSwipeableViewPager eMs;
    private com.baidu.tieba.im.util.b eMt;
    private int eMu;
    private int eMv;
    private int eMw;
    private int eMx;
    private int eMy;
    private boolean eMz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pE(String str) {
        this.eMB = str;
    }

    public void pF(String str) {
        this.eMC = str;
    }

    public String aPo() {
        return this.eMB;
    }

    public String aPp() {
        return this.eMC;
    }

    public View aPq() {
        return this.bhS;
    }

    public int aPr() {
        return this.eMj;
    }

    public View aPs() {
        return this.eMk;
    }

    public View aPt() {
        if (this.eMm != null) {
            return this.eMm.aPd();
        }
        if (this.eMn != null) {
            return this.eMn.aPd();
        }
        return null;
    }

    public View aPu() {
        return this.eMq.aPl();
    }

    public View aPv() {
        return this.eMq.aPk();
    }

    public boolean aPw() {
        return this.mIsLoading;
    }

    public void aOR() {
        this.eMr.aOR();
        aPR();
    }

    public void pG(String str) {
        this.eMA = str;
    }

    public String getAddressName() {
        return this.eMA;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eMr.setBusiness(str);
        aPR();
    }

    public String getBusiness() {
        return this.business;
    }

    public void pH(String str) {
        this.eMr.setAddress(str);
        aPR();
    }

    public boolean aPx() {
        return this.eMz;
    }

    public void io(boolean z) {
        this.eMz = z;
    }

    public void aOS() {
        this.eMr.aOS();
        aPR();
    }

    public void aOT() {
        this.eMr.aOT();
        aPR();
    }

    public View aPy() {
        return this.eMr.aOP();
    }

    public int aOQ() {
        return this.eMr.aOQ();
    }

    public View aPz() {
        return this.eMo.aPh();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eMo.aPg().getText().toString();
    }

    public String getIntro() {
        return this.eMp.aPa().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eMl;
    }

    public boolean aPA() {
        return this.eMo != null && this.eMj == this.eMo.aOO();
    }

    public boolean aPB() {
        return this.eMp != null && this.eMj == this.eMp.aOO();
    }

    public boolean aPC() {
        return this.eMq != null && this.eMj == this.eMq.aOO();
    }

    public boolean aPD() {
        return this.eMr != null && this.eMj == this.eMr.aOO();
    }

    public boolean aPE() {
        return this.eMi != null && this.eMj == this.eMi.getCount();
    }

    public String getErrMsg() {
        if (this.eMi.pI(this.eMj - 1) != null) {
            return this.eMi.pI(this.eMj - 1).getErrMsg();
        }
        return null;
    }

    public void aPF() {
        this.eMq.aPl().setText(e.j.group_create_modify_photo_tip);
    }

    public void aPG() {
        this.eMq.aPj();
    }

    public void clearText() {
        this.eMo.aPi();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eMh = true;
        this.mIsLoading = false;
        this.eLu = null;
        this.eMi = null;
        this.progressBar = null;
        this.eMj = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bhS = null;
        this.eMk = null;
        this.dJT = null;
        this.eMl = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eMm = null;
        this.eMn = null;
        this.eMo = null;
        this.eMp = null;
        this.eMq = null;
        this.eMr = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eMs = null;
        this.eMt = null;
        this.eMz = false;
        this.eMA = "";
        this.business = "";
        this.eMB = null;
        this.eMC = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eMt = new com.baidu.tieba.im.util.b(this.eLu);
        this.eMt.setUniqueId(this.eLu.getUniqueId());
        aPH();
    }

    public void aPH() {
        this.eMt.Rr();
    }

    public void aPI() {
        if (this.eMt != null) {
            this.eMt.cancelLoad();
        }
    }

    private void initListener() {
        this.bhS.setOnClickListener(this.eLu);
        this.eMk.setOnClickListener(this.eLu);
        this.eMo.aPg().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eMo.aPg().addTextChangedListener(this.eLu);
        this.eMp.aPa().addTextChangedListener(this.eLu);
        this.eMq.aPl().setOnClickListener(this.eLu);
        this.eMq.aPk().setOnClickListener(this.eLu);
        this.eMr.aOP().setOnClickListener(this.eLu);
        if (this.eMn != null) {
            this.eMn.aPd().setOnClickListener(this.eLu);
        }
        if (this.eMm != null) {
            this.eMm.aPd().setOnClickListener(this.eLu);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eLu = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.eMs = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.eMi = new CreateGroupStepAdapter(this.eLu);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eMs.setAdapter(this.eMi);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bhS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aPP();
        this.eMk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.eMk.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        al.i(this.eMk, e.f.s_navbar_button_bg);
        ip(false);
        aPQ();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eMy = 1;
            this.eMx = 2;
            this.eMu = 3;
            this.eMv = 4;
            this.eMw = 5;
            this.eMm = new e(createGroupStepActivity, this.eMy, i2);
            this.eMr = new b(createGroupStepActivity, this.eMx, 1, 5);
            this.eMo = new g(createGroupStepActivity, this.eMu, 2, 5);
            this.eMp = new d(createGroupStepActivity, this.eMv, 3, 5);
            this.eMq = new i(createGroupStepActivity, this.eMw, 4, 5);
            this.eMi.a(this.eMm);
            this.eMi.a(this.eMr);
            this.eMi.a(this.eMo);
            this.eMi.a(this.eMp);
            this.eMi.a(this.eMq);
            this.eLy = 5;
        } else if (i == 2) {
            this.eMy = 1;
            this.eMu = 2;
            this.eMv = 3;
            this.eMw = 4;
            this.eMx = 5;
            this.eMn = new h(createGroupStepActivity, this.eMy, i3);
            this.eMo = new g(createGroupStepActivity, this.eMu, 1, 5);
            this.eMp = new d(createGroupStepActivity, this.eMv, 2, 5);
            this.eMq = new i(createGroupStepActivity, this.eMw, 3, 5);
            this.eMr = new b(createGroupStepActivity, this.eMx, 4, 5);
            this.eMi.a(this.eMn);
            this.eMi.a(this.eMo);
            this.eMi.a(this.eMp);
            this.eMi.a(this.eMq);
            this.eMi.a(this.eMr);
            this.eLy = 5;
        } else {
            this.eMu = 1;
            this.eMv = 2;
            this.eMw = 3;
            this.eMx = 4;
            this.eMo = new g(createGroupStepActivity, this.eMu, 1, 4);
            this.eMp = new d(createGroupStepActivity, this.eMv, 2, 4);
            this.eMq = new i(createGroupStepActivity, this.eMw, 3, 4);
            this.eMr = new b(createGroupStepActivity, this.eMx, 4, 4);
            this.eMi.a(this.eMo);
            this.eMi.a(this.eMp);
            this.eMi.a(this.eMq);
            this.eMi.a(this.eMr);
            this.eLy = 4;
        }
    }

    private void ip(boolean z) {
        this.eMh = z;
        aPK();
    }

    public boolean aPJ() {
        return this.eMh;
    }

    private void aPK() {
        this.eMk.setEnabled(this.eMh);
        al.i(this.eMk, e.f.s_navbar_button_bg);
    }

    public void aPL() {
        if (this.eMj > 1) {
            this.eMj--;
            aPN();
        }
    }

    public void aPM() {
        if (this.eMj < this.eLy) {
            this.eMj++;
            aPN();
        }
    }

    public void aPN() {
        this.eMs.setCurrentItem(this.eMj - 1);
        aPP();
        aPQ();
        aPR();
        this.eMo.aPg().clearFocus();
        this.eMp.aPa().clearFocus();
        c(this.eMo.aPg());
        c(this.eMp.aPa());
        if (aPC() && aPw()) {
            aPs().setEnabled(false);
        } else {
            aPs().setEnabled(true);
        }
    }

    public void aPO() {
        String[] strArr = {this.eLu.getResources().getString(e.j.take_photo), this.eLu.getResources().getString(e.j.album)};
        if (this.dJT == null) {
            this.dJT = new com.baidu.tbadk.core.dialog.b(this.eLu.getPageContext().getPageActivity());
            this.dJT.eC(this.eLu.getResources().getString(e.j.operation));
            this.dJT.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eLu.getPageContext().getPageActivity();
                    if (j.this.bzf == null) {
                        j.this.bzf = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bzf.Et();
                    j.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bzf.A(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eLu.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eLu.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dJT.d(this.eLu.getPageContext());
        }
        this.dJT.BI();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eLu.getPageContext().getPageActivity();
        if (this.bzf == null) {
            this.bzf = new com.baidu.tbadk.core.util.b.a();
        }
        this.bzf.Et();
        this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bzf.A(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eLu.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void pI(String str) {
        if (!this.eMk.getText().toString().equals(str)) {
            this.eMk.setText(str);
        }
    }

    private void aPP() {
        if (this.eMi.pI(this.eMj - 1) != null) {
            this.mNavigationBar.setTitleText(this.eMi.pI(this.eMj - 1).getTitle());
        }
    }

    public void aPQ() {
        for (o oVar : this.eMi.getList()) {
            if (oVar.aOO() == this.eMj) {
                oVar.aOV();
                if (!oVar.aOZ()) {
                    this.eMk.setVisibility(8);
                } else {
                    this.eMk.setVisibility(0);
                }
                pI(oVar.aOX());
            } else {
                oVar.aOU();
            }
        }
        if (this.eMi.pI(this.eMj - 1) != null && this.eMi.pI(this.eMj - 1).aOY()) {
            ip(true);
        }
    }

    public void aPR() {
        if (aPA()) {
            a(this.eMo.aPg().getText().length(), this.eMo.getLength() / 2, 2, 20);
        } else if (aPB()) {
            int length = this.eMp.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.eMp.aPb().setText(String.valueOf(i));
            if (i <= 50) {
                this.eMp.aPb().setVisibility(0);
            } else {
                this.eMp.aPb().setVisibility(8);
            }
            if (i == 0) {
                this.eMp.aPb().setTextColor(this.eLu.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.eMp.pH(300);
            } else {
                this.eMp.aPc();
            }
        } else if (aPD()) {
            if (this.eMr.aOQ() != 3) {
                ip(true);
            } else {
                ip(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            ip(true);
        } else {
            ip(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            ip(false);
        } else if (f >= i2 && f <= i3) {
            ip(true);
        } else {
            ip(false);
        }
        if (i < 1) {
            this.eMo.in(false);
        } else {
            this.eMo.in(true);
        }
    }

    public void setData(int i, int i2) {
        this.eMl = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eLu.getLayoutMode().setNightMode(i == 1);
        this.eLu.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aPK();
        al.c(this.eMk, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.ln()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eLu.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
