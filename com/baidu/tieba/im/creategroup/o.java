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
    private boolean Ty;
    private boolean aTT;
    n aTU;
    ProgressBar aTV;
    private int aTW;
    private View aTX;
    private TextView aTY;
    int aTZ;
    CreateGroupStepActivity aTd;
    private int aTi;
    e aUa;
    h aUb;
    g aUc;
    d aUd;
    i aUe;
    b aUf;
    private NoSwipeableViewPager aUg;
    private com.baidu.tieba.im.util.d aUh;
    private int aUi;
    private int aUj;
    private int aUk;
    private int aUl;
    private int aUm;
    private boolean aUn;
    private String aUo;
    private String aUp;
    private String aUq;
    private View agI;
    private AlertDialog ayP;
    private String business;
    int mForumId;
    private NavigationBar mNavigationBar;
    String mPortrait;
    private WriteImagesInfo writeImagesInfo;

    public void fM(String str) {
        this.aUp = str;
    }

    public void fN(String str) {
        this.aUq = str;
    }

    public String Lt() {
        return this.aUp;
    }

    public String Lu() {
        return this.aUq;
    }

    public View Lv() {
        return this.aTX;
    }

    public int Lw() {
        return this.aTW;
    }

    public View Lx() {
        return this.aTY;
    }

    public View Ly() {
        if (this.aUa != null) {
            return this.aUa.Li();
        }
        if (this.aUb != null) {
            return this.aUb.Li();
        }
        return null;
    }

    public View Lz() {
        return this.aUe.Lq();
    }

    public View LA() {
        return this.aUe.Lp();
    }

    public boolean LB() {
        return this.Ty;
    }

    public void KW() {
        this.aUf.KW();
        LX();
    }

    public void fO(String str) {
        this.aUo = str;
    }

    public String LC() {
        return this.aUo;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.aUf.setBusiness(str);
        LX();
    }

    public String getBusiness() {
        return this.business;
    }

    public void fP(String str) {
        this.aUf.setAddress(str);
        LX();
    }

    public boolean LD() {
        return this.aUn;
    }

    public void cQ(boolean z) {
        this.aUn = z;
    }

    public void KX() {
        this.aUf.KX();
        LX();
    }

    public void KY() {
        this.aUf.KY();
        LX();
    }

    public View LE() {
        return this.aUf.KU();
    }

    public int KV() {
        return this.aUf.KV();
    }

    public View LF() {
        return this.aUc.Lm();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.aUc.Ll().getText().toString();
    }

    public String getIntro() {
        return this.aUd.Lf().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.aTZ;
    }

    public boolean LG() {
        return this.aUc != null && this.aTW == this.aUc.KT();
    }

    public boolean LH() {
        return this.aUd != null && this.aTW == this.aUd.KT();
    }

    public boolean LI() {
        return this.aUe != null && this.aTW == this.aUe.KT();
    }

    public boolean LJ() {
        return this.aUf != null && this.aTW == this.aUf.KT();
    }

    public boolean LK() {
        return this.aTU != null && this.aTW == this.aTU.getCount();
    }

    public String getErrMsg() {
        if (this.aTU.fu(this.aTW - 1) != null) {
            return this.aTU.fu(this.aTW - 1).getErrMsg();
        }
        return null;
    }

    public void LL() {
        this.aUe.Lq().setText(com.baidu.tieba.y.group_create_modify_photo_tip);
    }

    public void LM() {
        this.aUe.Lo();
    }

    public void clearText() {
        this.aUc.Ln();
    }

    public o(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity);
        this.aTT = true;
        this.Ty = false;
        this.aTd = null;
        this.aTU = null;
        this.aTV = null;
        this.aTW = 1;
        this.mNavigationBar = null;
        this.agI = null;
        this.aTX = null;
        this.aTY = null;
        this.ayP = null;
        this.aTZ = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.aUa = null;
        this.aUb = null;
        this.aUc = null;
        this.aUd = null;
        this.aUe = null;
        this.aUf = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.aUg = null;
        this.aUh = null;
        this.aUn = false;
        this.aUo = "";
        this.business = "";
        this.aUp = null;
        this.aUq = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        HN();
    }

    private void initData() {
        this.aUh = new com.baidu.tieba.im.util.d(this.aTd);
        this.aUh.setUniqueId(this.aTd.getUniqueId());
        LN();
    }

    public void LN() {
        this.aUh.Nn();
    }

    public void LO() {
        if (this.aUh != null) {
            this.aUh.RT();
        }
    }

    private void HN() {
        this.aTX.setOnClickListener(this.aTd);
        this.aTY.setOnClickListener(this.aTd);
        this.aUc.Ll().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.aUc.Ll().addTextChangedListener(this.aTd);
        this.aUd.Lf().addTextChangedListener(this.aTd);
        this.aUe.Lq().setOnClickListener(this.aTd);
        this.aUe.Lp().setOnClickListener(this.aTd);
        this.aUf.KU().setOnClickListener(this.aTd);
        if (this.aUb != null) {
            this.aUb.Li().setOnClickListener(this.aTd);
        }
        if (this.aUa != null) {
            this.aUa.Li().setOnClickListener(this.aTd);
        }
    }

    public void setIsLoading(boolean z) {
        this.aTV.setVisibility(z ? 0 : 8);
        this.Ty = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.aTd = createGroupStepActivity;
        createGroupStepActivity.setContentView(com.baidu.tieba.w.create_group_step_activity);
        this.agI = createGroupStepActivity.findViewById(com.baidu.tieba.v.parent);
        this.aTV = (ProgressBar) createGroupStepActivity.findViewById(com.baidu.tieba.v.progress);
        this.aUg = (NoSwipeableViewPager) createGroupStepActivity.findViewById(com.baidu.tieba.v.pagercontent);
        this.aTU = new n(this.aTd);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.aUg.setAdapter(this.aTU);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aTX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LV();
        this.aTY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(com.baidu.tieba.y.group_create_step_tip));
        cR(false);
        LW();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.aUm = 1;
            this.aUl = 2;
            this.aUi = 3;
            this.aUj = 4;
            this.aUk = 5;
            this.aUa = new e(createGroupStepActivity, this.aUm, i2);
            this.aUf = new b(createGroupStepActivity, this.aUl, 1, 5);
            this.aUc = new g(createGroupStepActivity, this.aUi, 2, 5);
            this.aUd = new d(createGroupStepActivity, this.aUj, 3, 5);
            this.aUe = new i(createGroupStepActivity, this.aUk, 4, 5);
            this.aTU.a(this.aUa);
            this.aTU.a(this.aUf);
            this.aTU.a(this.aUc);
            this.aTU.a(this.aUd);
            this.aTU.a(this.aUe);
            this.aTi = 5;
        } else if (i == 2) {
            this.aUm = 1;
            this.aUi = 2;
            this.aUj = 3;
            this.aUk = 4;
            this.aUl = 5;
            this.aUb = new h(createGroupStepActivity, this.aUm, i3);
            this.aUc = new g(createGroupStepActivity, this.aUi, 1, 5);
            this.aUd = new d(createGroupStepActivity, this.aUj, 2, 5);
            this.aUe = new i(createGroupStepActivity, this.aUk, 3, 5);
            this.aUf = new b(createGroupStepActivity, this.aUl, 4, 5);
            this.aTU.a(this.aUb);
            this.aTU.a(this.aUc);
            this.aTU.a(this.aUd);
            this.aTU.a(this.aUe);
            this.aTU.a(this.aUf);
            this.aTi = 5;
        } else {
            this.aUi = 1;
            this.aUj = 2;
            this.aUk = 3;
            this.aUl = 4;
            this.aUc = new g(createGroupStepActivity, this.aUi, 1, 4);
            this.aUd = new d(createGroupStepActivity, this.aUj, 2, 4);
            this.aUe = new i(createGroupStepActivity, this.aUk, 3, 4);
            this.aUf = new b(createGroupStepActivity, this.aUl, 4, 4);
            this.aTU.a(this.aUc);
            this.aTU.a(this.aUd);
            this.aTU.a(this.aUe);
            this.aTU.a(this.aUf);
            this.aTi = 4;
        }
    }

    private void cR(boolean z) {
        this.aTT = z;
        LQ();
    }

    public boolean LP() {
        return this.aTT;
    }

    private void LQ() {
        if (this.aTT) {
            aw.h((View) this.aTY, com.baidu.tieba.u.navi_done_text_bg);
            aw.b(this.aTY, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        aw.h((View) this.aTY, com.baidu.tieba.u.btn_titlebar_finish_d);
        aw.b(this.aTY, com.baidu.tieba.s.navi_done_text_d, 1);
    }

    public void LR() {
        if (this.aTW > 1) {
            this.aTW--;
            LT();
        }
    }

    public void LS() {
        if (this.aTW < this.aTi) {
            this.aTW++;
            LT();
        }
    }

    public void LT() {
        this.aUg.setCurrentItem(this.aTW - 1);
        LV();
        LW();
        LX();
        this.aUc.Ll().clearFocus();
        this.aUd.Lf().clearFocus();
        a(this.aUc.Ll());
        a(this.aUd.Lf());
        if (LI() && LB()) {
            Lx().setEnabled(false);
        } else {
            Lx().setEnabled(true);
        }
    }

    public void LU() {
        String[] strArr = {this.aTd.getResources().getString(com.baidu.tieba.y.take_photo), this.aTd.getResources().getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aTd);
        builder.setTitle(this.aTd.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new p(this));
        if (this.ayP == null) {
            this.ayP = builder.create();
        }
        com.baidu.adp.lib.g.j.a(this.ayP, this.aTd);
    }

    public void j(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                EditHeadActivity.a(this.aTd, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath());
            }
            this.writeImagesInfo.clear();
        }
    }

    public void fQ(String str) {
        if (!this.aTY.getText().toString().equals(str)) {
            this.aTY.setText(str);
        }
    }

    private void LV() {
        if (this.aTU.fu(this.aTW - 1) != null) {
            this.mNavigationBar.setTitleText(this.aTU.fu(this.aTW - 1).getTitle());
        }
    }

    public void LW() {
        for (y yVar : this.aTU.getList()) {
            if (yVar.KT() == this.aTW) {
                yVar.La();
                if (!yVar.Le()) {
                    this.aTY.setVisibility(8);
                } else {
                    this.aTY.setVisibility(0);
                }
                fQ(yVar.Lc());
            } else {
                yVar.KZ();
            }
        }
        if (this.aTU.fu(this.aTW - 1) != null && this.aTU.fu(this.aTW - 1).Ld()) {
            cR(true);
        }
    }

    public void LX() {
        if (LG()) {
            a(this.aUc.Ll().getText().length(), this.aUc.getLength(), 2, 20);
        } else if (LH()) {
            int length = this.aUd.getLength();
            n(length, 15, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            int i = 300 - length;
            this.aUd.Lg().setText(String.valueOf(i));
            if (i <= 50) {
                this.aUd.Lg().setVisibility(0);
            } else {
                this.aUd.Lg().setVisibility(8);
            }
            if (i == 0) {
                this.aUd.Lg().setTextColor(this.aTd.getResources().getColor(com.baidu.tieba.s.group_create_info_count_color));
            } else if (i < 0) {
                this.aUd.ft(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            } else {
                this.aUd.Lh();
            }
        } else if (LJ()) {
            if (this.aUf.KV() != 3) {
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
            this.aUc.cP(false);
        } else {
            this.aUc.cP(true);
        }
    }

    public void N(int i, int i2) {
        this.aTZ = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.aTd.getLayoutMode().L(i == 1);
        this.aTd.getLayoutMode().h(this.agI);
        aw.d(this.agI, i);
        this.mNavigationBar.onChangeSkinType(i);
        LQ();
    }

    public void a(EditText editText) {
        ((InputMethodManager) this.aTd.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
