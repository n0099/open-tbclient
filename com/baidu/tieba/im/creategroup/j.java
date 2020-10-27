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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes23.dex */
public class j extends com.baidu.adp.base.c {
    private String business;
    private boolean cDb;
    private View frR;
    CreateGroupStepAdapter jUT;
    private int jUU;
    private TextView jUV;
    private com.baidu.tbadk.core.dialog.i jUW;
    int jUX;
    e jUY;
    h jUZ;
    CreateGroupStepActivity jUg;
    private int jUk;
    g jVa;
    d jVb;
    i jVc;
    b jVd;
    private NoSwipeableViewPager jVe;
    private com.baidu.tieba.im.util.b jVf;
    private int jVg;
    private int jVh;
    private int jVi;
    private int jVj;
    private int jVk;
    private boolean jVl;
    private String jVm;
    private String jVn;
    private String jVo;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void LW(String str) {
        this.jVn = str;
    }

    public void LX(String str) {
        this.jVo = str;
    }

    public String cNv() {
        return this.jVn;
    }

    public String bkp() {
        return this.jVo;
    }

    public View cNw() {
        return this.frR;
    }

    public int cNx() {
        return this.jUU;
    }

    public View cNy() {
        return this.jUV;
    }

    public View cNz() {
        if (this.jUY != null) {
            return this.jUY.cNk();
        }
        if (this.jUZ != null) {
            return this.jUZ.cNk();
        }
        return null;
    }

    public View cNA() {
        return this.jVc.cNs();
    }

    public View cNB() {
        return this.jVc.cNr();
    }

    public boolean cNC() {
        return this.mIsLoading;
    }

    public void cMY() {
        this.jVd.cMY();
        cNX();
    }

    public void LY(String str) {
        this.jVm = str;
    }

    public String akn() {
        return this.jVm;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.jVd.setBusiness(str);
        cNX();
    }

    public String getBusiness() {
        return this.business;
    }

    public void LZ(String str) {
        this.jVd.setAddress(str);
        cNX();
    }

    public boolean cND() {
        return this.jVl;
    }

    public void ry(boolean z) {
        this.jVl = z;
    }

    public void cMZ() {
        this.jVd.cMZ();
        cNX();
    }

    public void cNa() {
        this.jVd.cNa();
        cNX();
    }

    public View cNE() {
        return this.jVd.cMW();
    }

    public int cMX() {
        return this.jVd.cMX();
    }

    public View cNF() {
        return this.jVa.cNo();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.jVa.cNn().getText().toString();
    }

    public String getIntro() {
        return this.jVb.cNh().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.jUX;
    }

    public boolean cNG() {
        return this.jVa != null && this.jUU == this.jVa.cMV();
    }

    public boolean cNH() {
        return this.jVb != null && this.jUU == this.jVb.cMV();
    }

    public boolean cNI() {
        return this.jVc != null && this.jUU == this.jVc.cMV();
    }

    public boolean cNJ() {
        return this.jVd != null && this.jUU == this.jVd.cMV();
    }

    public boolean cNK() {
        return this.jUT != null && this.jUU == this.jUT.getCount();
    }

    public String getErrMsg() {
        if (this.jUT.Cu(this.jUU - 1) != null) {
            return this.jUT.Cu(this.jUU - 1).getErrMsg();
        }
        return null;
    }

    public void cNL() {
        this.jVc.cNs().setText(R.string.group_create_modify_photo_tip);
    }

    public void cNM() {
        this.jVc.cNq();
    }

    public void MG() {
        this.jVa.cNp();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cDb = true;
        this.mIsLoading = false;
        this.jUg = null;
        this.jUT = null;
        this.progressBar = null;
        this.jUU = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.frR = null;
        this.jUV = null;
        this.jUW = null;
        this.jUX = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.jUY = null;
        this.jUZ = null;
        this.jVa = null;
        this.jVb = null;
        this.jVc = null;
        this.jVd = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.jVe = null;
        this.jVf = null;
        this.jVl = false;
        this.jVm = "";
        this.business = "";
        this.jVn = null;
        this.jVo = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.jVf = new com.baidu.tieba.im.util.b(this.jUg);
        this.jVf.setUniqueId(this.jUg.getUniqueId());
        if (!ae.c(this.jUg, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cNN();
        }
    }

    public void cNN() {
        this.jVf.startLoad();
    }

    public void cNO() {
        if (this.jVf != null) {
            this.jVf.cancelLoad();
        }
    }

    private void initListener() {
        this.frR.setOnClickListener(this.jUg);
        this.jUV.setOnClickListener(this.jUg);
        this.jVa.cNn().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.jVa.cNn().addTextChangedListener(this.jUg);
        this.jVb.cNh().addTextChangedListener(this.jUg);
        this.jVc.cNs().setOnClickListener(this.jUg);
        this.jVc.cNr().setOnClickListener(this.jUg);
        this.jVd.cMW().setOnClickListener(this.jUg);
        if (this.jUZ != null) {
            this.jUZ.cNk().setOnClickListener(this.jUg);
        }
        if (this.jUY != null) {
            this.jUY.cNk().setOnClickListener(this.jUg);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.jUg = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.jVe = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.jUT = new CreateGroupStepAdapter(this.jUg);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.jVe.setAdapter(this.jUT);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.frR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cNV();
        this.jUV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.jUV.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.jUV, R.drawable.s_navbar_button_bg);
        rz(false);
        cNW();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.jVk = 1;
            this.jVj = 2;
            this.jVg = 3;
            this.jVh = 4;
            this.jVi = 5;
            this.jUY = new e(createGroupStepActivity, this.jVk, i2);
            this.jVd = new b(createGroupStepActivity, this.jVj, 1, 5);
            this.jVa = new g(createGroupStepActivity, this.jVg, 2, 5);
            this.jVb = new d(createGroupStepActivity, this.jVh, 3, 5);
            this.jVc = new i(createGroupStepActivity, this.jVi, 4, 5);
            this.jUT.a(this.jUY);
            this.jUT.a(this.jVd);
            this.jUT.a(this.jVa);
            this.jUT.a(this.jVb);
            this.jUT.a(this.jVc);
            this.jUk = 5;
        } else if (i == 2) {
            this.jVk = 1;
            this.jVg = 2;
            this.jVh = 3;
            this.jVi = 4;
            this.jVj = 5;
            this.jUZ = new h(createGroupStepActivity, this.jVk, i3);
            this.jVa = new g(createGroupStepActivity, this.jVg, 1, 5);
            this.jVb = new d(createGroupStepActivity, this.jVh, 2, 5);
            this.jVc = new i(createGroupStepActivity, this.jVi, 3, 5);
            this.jVd = new b(createGroupStepActivity, this.jVj, 4, 5);
            this.jUT.a(this.jUZ);
            this.jUT.a(this.jVa);
            this.jUT.a(this.jVb);
            this.jUT.a(this.jVc);
            this.jUT.a(this.jVd);
            this.jUk = 5;
        } else {
            this.jVg = 1;
            this.jVh = 2;
            this.jVi = 3;
            this.jVj = 4;
            this.jVa = new g(createGroupStepActivity, this.jVg, 1, 4);
            this.jVb = new d(createGroupStepActivity, this.jVh, 2, 4);
            this.jVc = new i(createGroupStepActivity, this.jVi, 3, 4);
            this.jVd = new b(createGroupStepActivity, this.jVj, 4, 4);
            this.jUT.a(this.jVa);
            this.jUT.a(this.jVb);
            this.jUT.a(this.jVc);
            this.jUT.a(this.jVd);
            this.jUk = 4;
        }
    }

    private void rz(boolean z) {
        this.cDb = z;
        cNQ();
    }

    public boolean cNP() {
        return this.cDb;
    }

    private void cNQ() {
        this.jUV.setEnabled(this.cDb);
        ap.setBackgroundResource(this.jUV, R.drawable.s_navbar_button_bg);
    }

    public void cNR() {
        if (this.jUU > 1) {
            this.jUU--;
            cNT();
        }
    }

    public void cNS() {
        if (this.jUU < this.jUk) {
            this.jUU++;
            cNT();
        }
    }

    public void cNT() {
        this.jVe.setCurrentItem(this.jUU - 1);
        cNV();
        cNW();
        cNX();
        this.jVa.cNn().clearFocus();
        this.jVb.cNh().clearFocus();
        d(this.jVa.cNn());
        d(this.jVb.cNh());
        if (cNI() && cNC()) {
            cNy().setEnabled(false);
        } else {
            cNy().setEnabled(true);
        }
    }

    public void cNU() {
        String[] strArr = {this.jUg.getResources().getString(R.string.take_photo), this.jUg.getResources().getString(R.string.album)};
        if (this.jUW == null) {
            this.jUW = new com.baidu.tbadk.core.dialog.i(this.jUg.getPageContext());
            this.jUW.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.jUW != null && j.this.jUW.isShowing() && j.this.jUg != null) {
                        j.this.jUW.dismiss();
                    }
                    Activity pageActivity = j.this.jUg.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.jUg.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.jUg.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.jUW.PJ();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.jUg.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.jUg.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Ma(String str) {
        if (!this.jUV.getText().toString().equals(str)) {
            this.jUV.setText(str);
        }
    }

    private void cNV() {
        if (this.jUT.Cu(this.jUU - 1) != null) {
            this.mNavigationBar.setTitleText(this.jUT.Cu(this.jUU - 1).getTitle());
        }
    }

    public void cNW() {
        for (o oVar : this.jUT.getList()) {
            if (oVar.cMV() == this.jUU) {
                oVar.cNc();
                if (!oVar.cNg()) {
                    this.jUV.setVisibility(8);
                } else {
                    this.jUV.setVisibility(0);
                }
                Ma(oVar.cNe());
            } else {
                oVar.cNb();
            }
        }
        if (this.jUT.Cu(this.jUU - 1) != null && this.jUT.Cu(this.jUU - 1).cNf()) {
            rz(true);
        }
    }

    public void cNX() {
        if (cNG()) {
            a(this.jVa.cNn().getText().length(), this.jVa.wp() / 2, 2, 20);
        } else if (cNH()) {
            int wp = this.jVb.wp() / 2;
            T(wp, 15, 300);
            int i = 300 - wp;
            this.jVb.cNi().setText(String.valueOf(i));
            if (i <= 50) {
                this.jVb.cNi().setVisibility(0);
            } else {
                this.jVb.cNi().setVisibility(8);
            }
            if (i == 0) {
                this.jVb.cNi().setTextColor(this.jUg.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.jVb.Ct(300);
            } else {
                this.jVb.cNj();
            }
        } else if (cNJ()) {
            if (this.jVd.cMX() != 3) {
                rz(true);
            } else {
                rz(false);
            }
        }
    }

    private void T(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            rz(true);
        } else {
            rz(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            rz(false);
        } else if (f >= i2 && f <= i3) {
            rz(true);
        } else {
            rz(false);
        }
        if (i < 1) {
            this.jVa.rx(false);
        } else {
            this.jVa.rx(true);
        }
    }

    public void setData(int i, int i2) {
        this.jUX = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.jUg.getLayoutMode().setNightMode(i == 1);
        this.jUg.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cNQ();
        ap.setViewTextColor(this.jUV, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.jUg.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
