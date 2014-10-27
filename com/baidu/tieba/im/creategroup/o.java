package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.content.Intent;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    private boolean Tu;
    CreateGroupStepActivity aSP;
    private int aSU;
    private boolean aTF;
    n aTG;
    ProgressBar aTH;
    private int aTI;
    private View aTJ;
    private TextView aTK;
    int aTL;
    e aTM;
    h aTN;
    g aTO;
    d aTP;
    i aTQ;
    b aTR;
    private NoSwipeableViewPager aTS;
    private com.baidu.tieba.im.util.d aTT;
    private int aTU;
    private int aTV;
    private int aTW;
    private int aTX;
    private int aTY;
    private boolean aTZ;
    private String aUa;
    private String aUb;
    private String aUc;
    private View agA;
    private AlertDialog ayG;
    private String business;
    int mForumId;
    private NavigationBar mNavigationBar;
    String mPortrait;
    private WriteImagesInfo writeImagesInfo;

    public void fM(String str) {
        this.aUb = str;
    }

    public void fN(String str) {
        this.aUc = str;
    }

    public String Lp() {
        return this.aUb;
    }

    public String Lq() {
        return this.aUc;
    }

    public View Lr() {
        return this.aTJ;
    }

    public int Ls() {
        return this.aTI;
    }

    public View Lt() {
        return this.aTK;
    }

    public View Lu() {
        if (this.aTM != null) {
            return this.aTM.Le();
        }
        if (this.aTN != null) {
            return this.aTN.Le();
        }
        return null;
    }

    public View Lv() {
        return this.aTQ.Lm();
    }

    public View Lw() {
        return this.aTQ.Ll();
    }

    public boolean Lx() {
        return this.Tu;
    }

    public void KS() {
        this.aTR.KS();
        LT();
    }

    public void fO(String str) {
        this.aUa = str;
    }

    public String Ly() {
        return this.aUa;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.aTR.setBusiness(str);
        LT();
    }

    public String getBusiness() {
        return this.business;
    }

    public void fP(String str) {
        this.aTR.setAddress(str);
        LT();
    }

    public boolean Lz() {
        return this.aTZ;
    }

    public void cQ(boolean z) {
        this.aTZ = z;
    }

    public void KT() {
        this.aTR.KT();
        LT();
    }

    public void KU() {
        this.aTR.KU();
        LT();
    }

    public View LA() {
        return this.aTR.KQ();
    }

    public int KR() {
        return this.aTR.KR();
    }

    public View LB() {
        return this.aTO.Li();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.aTO.Lh().getText().toString();
    }

    public String getIntro() {
        return this.aTP.Lb().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.aTL;
    }

    public boolean LC() {
        return this.aTO != null && this.aTI == this.aTO.KP();
    }

    public boolean LD() {
        return this.aTP != null && this.aTI == this.aTP.KP();
    }

    public boolean LE() {
        return this.aTQ != null && this.aTI == this.aTQ.KP();
    }

    public boolean LF() {
        return this.aTR != null && this.aTI == this.aTR.KP();
    }

    public boolean LG() {
        return this.aTG != null && this.aTI == this.aTG.getCount();
    }

    public String getErrMsg() {
        if (this.aTG.fu(this.aTI - 1) != null) {
            return this.aTG.fu(this.aTI - 1).getErrMsg();
        }
        return null;
    }

    public void LH() {
        this.aTQ.Lm().setText(com.baidu.tieba.y.group_create_modify_photo_tip);
    }

    public void LI() {
        this.aTQ.Lk();
    }

    public void clearText() {
        this.aTO.Lj();
    }

    public o(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity);
        this.aTF = true;
        this.Tu = false;
        this.aSP = null;
        this.aTG = null;
        this.aTH = null;
        this.aTI = 1;
        this.mNavigationBar = null;
        this.agA = null;
        this.aTJ = null;
        this.aTK = null;
        this.ayG = null;
        this.aTL = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.aTM = null;
        this.aTN = null;
        this.aTO = null;
        this.aTP = null;
        this.aTQ = null;
        this.aTR = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.aTS = null;
        this.aTT = null;
        this.aTZ = false;
        this.aUa = "";
        this.business = "";
        this.aUb = null;
        this.aUc = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        HJ();
    }

    private void initData() {
        this.aTT = new com.baidu.tieba.im.util.d(this.aSP);
        this.aTT.setUniqueId(this.aSP.getUniqueId());
        LJ();
    }

    public void LJ() {
        this.aTT.Nj();
    }

    public void LK() {
        if (this.aTT != null) {
            this.aTT.RQ();
        }
    }

    private void HJ() {
        this.aTJ.setOnClickListener(this.aSP);
        this.aTK.setOnClickListener(this.aSP);
        this.aTO.Lh().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.aTO.Lh().addTextChangedListener(this.aSP);
        this.aTP.Lb().addTextChangedListener(this.aSP);
        this.aTQ.Lm().setOnClickListener(this.aSP);
        this.aTQ.Ll().setOnClickListener(this.aSP);
        this.aTR.KQ().setOnClickListener(this.aSP);
        if (this.aTN != null) {
            this.aTN.Le().setOnClickListener(this.aSP);
        }
        if (this.aTM != null) {
            this.aTM.Le().setOnClickListener(this.aSP);
        }
    }

    public void setIsLoading(boolean z) {
        this.aTH.setVisibility(z ? 0 : 8);
        this.Tu = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.aSP = createGroupStepActivity;
        createGroupStepActivity.setContentView(com.baidu.tieba.w.create_group_step_activity);
        this.agA = createGroupStepActivity.findViewById(com.baidu.tieba.v.parent);
        this.aTH = (ProgressBar) createGroupStepActivity.findViewById(com.baidu.tieba.v.progress);
        this.aTS = (NoSwipeableViewPager) createGroupStepActivity.findViewById(com.baidu.tieba.v.pagercontent);
        this.aTG = new n(this.aSP);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.aTS.setAdapter(this.aTG);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aTJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LR();
        this.aTK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(com.baidu.tieba.y.group_create_step_tip));
        cR(false);
        LS();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.aTY = 1;
            this.aTX = 2;
            this.aTU = 3;
            this.aTV = 4;
            this.aTW = 5;
            this.aTM = new e(createGroupStepActivity, this.aTY, i2);
            this.aTR = new b(createGroupStepActivity, this.aTX, 1, 5);
            this.aTO = new g(createGroupStepActivity, this.aTU, 2, 5);
            this.aTP = new d(createGroupStepActivity, this.aTV, 3, 5);
            this.aTQ = new i(createGroupStepActivity, this.aTW, 4, 5);
            this.aTG.a(this.aTM);
            this.aTG.a(this.aTR);
            this.aTG.a(this.aTO);
            this.aTG.a(this.aTP);
            this.aTG.a(this.aTQ);
            this.aSU = 5;
        } else if (i == 2) {
            this.aTY = 1;
            this.aTU = 2;
            this.aTV = 3;
            this.aTW = 4;
            this.aTX = 5;
            this.aTN = new h(createGroupStepActivity, this.aTY, i3);
            this.aTO = new g(createGroupStepActivity, this.aTU, 1, 5);
            this.aTP = new d(createGroupStepActivity, this.aTV, 2, 5);
            this.aTQ = new i(createGroupStepActivity, this.aTW, 3, 5);
            this.aTR = new b(createGroupStepActivity, this.aTX, 4, 5);
            this.aTG.a(this.aTN);
            this.aTG.a(this.aTO);
            this.aTG.a(this.aTP);
            this.aTG.a(this.aTQ);
            this.aTG.a(this.aTR);
            this.aSU = 5;
        } else {
            this.aTU = 1;
            this.aTV = 2;
            this.aTW = 3;
            this.aTX = 4;
            this.aTO = new g(createGroupStepActivity, this.aTU, 1, 4);
            this.aTP = new d(createGroupStepActivity, this.aTV, 2, 4);
            this.aTQ = new i(createGroupStepActivity, this.aTW, 3, 4);
            this.aTR = new b(createGroupStepActivity, this.aTX, 4, 4);
            this.aTG.a(this.aTO);
            this.aTG.a(this.aTP);
            this.aTG.a(this.aTQ);
            this.aTG.a(this.aTR);
            this.aSU = 4;
        }
    }

    private void cR(boolean z) {
        this.aTF = z;
        LM();
    }

    public boolean LL() {
        return this.aTF;
    }

    private void LM() {
        if (this.aTF) {
            aw.h((View) this.aTK, com.baidu.tieba.u.navi_done_text_bg);
            aw.b(this.aTK, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        aw.h((View) this.aTK, com.baidu.tieba.u.btn_titlebar_finish_d);
        aw.b(this.aTK, com.baidu.tieba.s.navi_done_text_d, 1);
    }

    public void LN() {
        if (this.aTI > 1) {
            this.aTI--;
            LP();
        }
    }

    public void LO() {
        if (this.aTI < this.aSU) {
            this.aTI++;
            LP();
        }
    }

    public void LP() {
        this.aTS.setCurrentItem(this.aTI - 1);
        LR();
        LS();
        LT();
        this.aTO.Lh().clearFocus();
        this.aTP.Lb().clearFocus();
        a(this.aTO.Lh());
        a(this.aTP.Lb());
        if (LE() && Lx()) {
            Lt().setEnabled(false);
        } else {
            Lt().setEnabled(true);
        }
    }

    public void LQ() {
        String[] strArr = {this.aSP.getResources().getString(com.baidu.tieba.y.take_photo), this.aSP.getResources().getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aSP);
        builder.setTitle(this.aSP.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new p(this));
        if (this.ayG == null) {
            this.ayG = builder.create();
        }
        com.baidu.adp.lib.g.j.a(this.ayG, this.aSP);
    }

    public void j(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                EditHeadActivity.a(this.aSP, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath());
            }
            this.writeImagesInfo.clear();
        }
    }

    public void fQ(String str) {
        if (!this.aTK.getText().toString().equals(str)) {
            this.aTK.setText(str);
        }
    }

    private void LR() {
        if (this.aTG.fu(this.aTI - 1) != null) {
            this.mNavigationBar.setTitleText(this.aTG.fu(this.aTI - 1).getTitle());
        }
    }

    public void LS() {
        for (y yVar : this.aTG.getList()) {
            if (yVar.KP() == this.aTI) {
                yVar.KW();
                if (!yVar.La()) {
                    this.aTK.setVisibility(8);
                } else {
                    this.aTK.setVisibility(0);
                }
                fQ(yVar.KY());
            } else {
                yVar.KV();
            }
        }
        if (this.aTG.fu(this.aTI - 1) != null && this.aTG.fu(this.aTI - 1).KZ()) {
            cR(true);
        }
    }

    public void LT() {
        if (LC()) {
            a(this.aTO.Lh().getText().length(), this.aTO.getLength(), 2, 20);
        } else if (LD()) {
            int length = this.aTP.getLength();
            n(length, 15, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            int i = 300 - length;
            this.aTP.Lc().setText(String.valueOf(i));
            if (i <= 50) {
                this.aTP.Lc().setVisibility(0);
            } else {
                this.aTP.Lc().setVisibility(8);
            }
            if (i == 0) {
                this.aTP.Lc().setTextColor(this.aSP.getResources().getColor(com.baidu.tieba.s.group_create_info_count_color));
            } else if (i < 0) {
                this.aTP.ft(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            } else {
                this.aTP.Ld();
            }
        } else if (LF()) {
            if (this.aTR.KR() != 3) {
                cR(true);
            } else {
                cR(false);
            }
        }
    }

    private void n(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            cR(true);
        } else {
            cR(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            cR(false);
        } else if (f >= i2 && f <= i3) {
            cR(true);
        } else {
            cR(false);
        }
        if (i < 1) {
            this.aTO.cP(false);
        } else {
            this.aTO.cP(true);
        }
    }

    public void N(int i, int i2) {
        this.aTL = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.aSP.getLayoutMode().L(i == 1);
        this.aSP.getLayoutMode().h(this.agA);
        aw.d(this.agA, i);
        this.mNavigationBar.onChangeSkinType(i);
        LM();
    }

    public void a(EditText editText) {
        ((InputMethodManager) this.aSP.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
