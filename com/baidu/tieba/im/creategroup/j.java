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
import com.baidu.tieba.d;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View aUR;
    private com.baidu.tbadk.core.util.b.a biP;
    private String business;
    private com.baidu.tbadk.core.dialog.b djo;
    private int egA;
    CreateGroupStepActivity egw;
    private int ehA;
    private boolean ehB;
    private String ehC;
    private String ehD;
    private String ehE;
    private boolean ehj;
    CreateGroupStepAdapter ehk;
    private int ehl;
    private TextView ehm;
    int ehn;
    e eho;
    h ehp;
    g ehq;
    d ehr;
    i ehs;
    b eht;
    private NoSwipeableViewPager ehu;
    private com.baidu.tieba.im.util.b ehv;
    private int ehw;
    private int ehx;
    private int ehy;
    private int ehz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void nN(String str) {
        this.ehD = str;
    }

    public void nO(String str) {
        this.ehE = str;
    }

    public String aGR() {
        return this.ehD;
    }

    public String aGS() {
        return this.ehE;
    }

    public View aGT() {
        return this.aUR;
    }

    public int aGU() {
        return this.ehl;
    }

    public View aGV() {
        return this.ehm;
    }

    public View aGW() {
        if (this.eho != null) {
            return this.eho.aGG();
        }
        if (this.ehp != null) {
            return this.ehp.aGG();
        }
        return null;
    }

    public View aGX() {
        return this.ehs.aGO();
    }

    public View aGY() {
        return this.ehs.aGN();
    }

    public boolean aGZ() {
        return this.mIsLoading;
    }

    public void aGu() {
        this.eht.aGu();
        aHu();
    }

    public void nP(String str) {
        this.ehC = str;
    }

    public String aHa() {
        return this.ehC;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eht.setBusiness(str);
        aHu();
    }

    public String getBusiness() {
        return this.business;
    }

    public void nQ(String str) {
        this.eht.setAddress(str);
        aHu();
    }

    public boolean aHb() {
        return this.ehB;
    }

    public void gZ(boolean z) {
        this.ehB = z;
    }

    public void aGv() {
        this.eht.aGv();
        aHu();
    }

    public void aGw() {
        this.eht.aGw();
        aHu();
    }

    public View aHc() {
        return this.eht.aGs();
    }

    public int aGt() {
        return this.eht.aGt();
    }

    public View aHd() {
        return this.ehq.aGK();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.ehq.aGJ().getText().toString();
    }

    public String getIntro() {
        return this.ehr.aGD().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.ehn;
    }

    public boolean aHe() {
        return this.ehq != null && this.ehl == this.ehq.aGr();
    }

    public boolean aHf() {
        return this.ehr != null && this.ehl == this.ehr.aGr();
    }

    public boolean aHg() {
        return this.ehs != null && this.ehl == this.ehs.aGr();
    }

    public boolean aHh() {
        return this.eht != null && this.ehl == this.eht.aGr();
    }

    public boolean aHi() {
        return this.ehk != null && this.ehl == this.ehk.getCount();
    }

    public String getErrMsg() {
        if (this.ehk.ny(this.ehl - 1) != null) {
            return this.ehk.ny(this.ehl - 1).getErrMsg();
        }
        return null;
    }

    public void aHj() {
        this.ehs.aGO().setText(d.k.group_create_modify_photo_tip);
    }

    public void aHk() {
        this.ehs.aGM();
    }

    public void clearText() {
        this.ehq.aGL();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.ehj = true;
        this.mIsLoading = false;
        this.egw = null;
        this.ehk = null;
        this.progressBar = null;
        this.ehl = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aUR = null;
        this.ehm = null;
        this.djo = null;
        this.ehn = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eho = null;
        this.ehp = null;
        this.ehq = null;
        this.ehr = null;
        this.ehs = null;
        this.eht = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ehu = null;
        this.ehv = null;
        this.ehB = false;
        this.ehC = "";
        this.business = "";
        this.ehD = null;
        this.ehE = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.ehv = new com.baidu.tieba.im.util.b(this.egw);
        this.ehv.setUniqueId(this.egw.getUniqueId());
        aHl();
    }

    public void aHl() {
        this.ehv.Mw();
    }

    public void aHm() {
        if (this.ehv != null) {
            this.ehv.cancelLoad();
        }
    }

    private void initListener() {
        this.aUR.setOnClickListener(this.egw);
        this.ehm.setOnClickListener(this.egw);
        this.ehq.aGJ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.ehq.aGJ().addTextChangedListener(this.egw);
        this.ehr.aGD().addTextChangedListener(this.egw);
        this.ehs.aGO().setOnClickListener(this.egw);
        this.ehs.aGN().setOnClickListener(this.egw);
        this.eht.aGs().setOnClickListener(this.egw);
        if (this.ehp != null) {
            this.ehp.aGG().setOnClickListener(this.egw);
        }
        if (this.eho != null) {
            this.eho.aGG().setOnClickListener(this.egw);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.egw = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.i.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.ehu = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.ehk = new CreateGroupStepAdapter(this.egw);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ehu.setAdapter(this.ehk);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        updateTitle();
        this.ehm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.k.next_step));
        ((LinearLayout.LayoutParams) this.ehm.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.e(getPageContext().getPageActivity(), d.e.ds16);
        al.i(this.ehm, d.f.s_navbar_button_bg);
        ha(false);
        aHt();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.ehA = 1;
            this.ehz = 2;
            this.ehw = 3;
            this.ehx = 4;
            this.ehy = 5;
            this.eho = new e(createGroupStepActivity, this.ehA, i2);
            this.eht = new b(createGroupStepActivity, this.ehz, 1, 5);
            this.ehq = new g(createGroupStepActivity, this.ehw, 2, 5);
            this.ehr = new d(createGroupStepActivity, this.ehx, 3, 5);
            this.ehs = new i(createGroupStepActivity, this.ehy, 4, 5);
            this.ehk.a(this.eho);
            this.ehk.a(this.eht);
            this.ehk.a(this.ehq);
            this.ehk.a(this.ehr);
            this.ehk.a(this.ehs);
            this.egA = 5;
        } else if (i == 2) {
            this.ehA = 1;
            this.ehw = 2;
            this.ehx = 3;
            this.ehy = 4;
            this.ehz = 5;
            this.ehp = new h(createGroupStepActivity, this.ehA, i3);
            this.ehq = new g(createGroupStepActivity, this.ehw, 1, 5);
            this.ehr = new d(createGroupStepActivity, this.ehx, 2, 5);
            this.ehs = new i(createGroupStepActivity, this.ehy, 3, 5);
            this.eht = new b(createGroupStepActivity, this.ehz, 4, 5);
            this.ehk.a(this.ehp);
            this.ehk.a(this.ehq);
            this.ehk.a(this.ehr);
            this.ehk.a(this.ehs);
            this.ehk.a(this.eht);
            this.egA = 5;
        } else {
            this.ehw = 1;
            this.ehx = 2;
            this.ehy = 3;
            this.ehz = 4;
            this.ehq = new g(createGroupStepActivity, this.ehw, 1, 4);
            this.ehr = new d(createGroupStepActivity, this.ehx, 2, 4);
            this.ehs = new i(createGroupStepActivity, this.ehy, 3, 4);
            this.eht = new b(createGroupStepActivity, this.ehz, 4, 4);
            this.ehk.a(this.ehq);
            this.ehk.a(this.ehr);
            this.ehk.a(this.ehs);
            this.ehk.a(this.eht);
            this.egA = 4;
        }
    }

    private void ha(boolean z) {
        this.ehj = z;
        aHo();
    }

    public boolean aHn() {
        return this.ehj;
    }

    private void aHo() {
        this.ehm.setEnabled(this.ehj);
        al.i(this.ehm, d.f.s_navbar_button_bg);
    }

    public void aHp() {
        if (this.ehl > 1) {
            this.ehl--;
            aHr();
        }
    }

    public void aHq() {
        if (this.ehl < this.egA) {
            this.ehl++;
            aHr();
        }
    }

    public void aHr() {
        this.ehu.setCurrentItem(this.ehl - 1);
        updateTitle();
        aHt();
        aHu();
        this.ehq.aGJ().clearFocus();
        this.ehr.aGD().clearFocus();
        c(this.ehq.aGJ());
        c(this.ehr.aGD());
        if (aHg() && aGZ()) {
            aGV().setEnabled(false);
        } else {
            aGV().setEnabled(true);
        }
    }

    public void aHs() {
        String[] strArr = {this.egw.getResources().getString(d.k.take_photo), this.egw.getResources().getString(d.k.album)};
        if (this.djo == null) {
            this.djo = new com.baidu.tbadk.core.dialog.b(this.egw.getPageContext().getPageActivity());
            this.djo.dC(this.egw.getResources().getString(d.k.operation));
            this.djo.a(strArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.egw.getPageContext().getPageActivity();
                    if (j.this.biP == null) {
                        j.this.biP = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.biP.zU();
                    j.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.biP.u(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.egw.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.egw.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.djo.d(this.egw.getPageContext());
        }
        this.djo.xd();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.egw.getPageContext().getPageActivity();
        if (this.biP == null) {
            this.biP = new com.baidu.tbadk.core.util.b.a();
        }
        this.biP.zU();
        this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.biP.u(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.egw.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nR(String str) {
        if (!this.ehm.getText().toString().equals(str)) {
            this.ehm.setText(str);
        }
    }

    private void updateTitle() {
        if (this.ehk.ny(this.ehl - 1) != null) {
            this.mNavigationBar.setTitleText(this.ehk.ny(this.ehl - 1).getTitle());
        }
    }

    public void aHt() {
        for (o oVar : this.ehk.getList()) {
            if (oVar.aGr() == this.ehl) {
                oVar.aGy();
                if (!oVar.aGC()) {
                    this.ehm.setVisibility(8);
                } else {
                    this.ehm.setVisibility(0);
                }
                nR(oVar.aGA());
            } else {
                oVar.aGx();
            }
        }
        if (this.ehk.ny(this.ehl - 1) != null && this.ehk.ny(this.ehl - 1).aGB()) {
            ha(true);
        }
    }

    public void aHu() {
        if (aHe()) {
            b(this.ehq.aGJ().getText().length(), this.ehq.getLength() / 2, 2, 20);
        } else if (aHf()) {
            int length = this.ehr.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.ehr.aGE().setText(String.valueOf(i));
            if (i <= 50) {
                this.ehr.aGE().setVisibility(0);
            } else {
                this.ehr.aGE().setVisibility(8);
            }
            if (i == 0) {
                this.ehr.aGE().setTextColor(this.egw.getResources().getColor(d.C0141d.common_color_10170));
            } else if (i < 0) {
                this.ehr.nx(300);
            } else {
                this.ehr.aGF();
            }
        } else if (aHh()) {
            if (this.eht.aGt() != 3) {
                ha(true);
            } else {
                ha(false);
            }
        }
    }

    private void M(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            ha(true);
        } else {
            ha(false);
        }
    }

    private void b(int i, float f, int i2, int i3) {
        if (i == 1) {
            ha(false);
        } else if (f >= i2 && f <= i3) {
            ha(true);
        } else {
            ha(false);
        }
        if (i < 1) {
            this.ehq.gY(false);
        } else {
            this.ehq.gY(true);
        }
    }

    public void bd(int i, int i2) {
        this.ehn = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.egw.getLayoutMode().setNightMode(i == 1);
        this.egw.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aHo();
        al.c(this.ehm, d.C0141d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.jX()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, d.C0141d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.egw.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
