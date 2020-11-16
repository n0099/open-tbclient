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
/* loaded from: classes22.dex */
public class j extends com.baidu.adp.base.c {
    private String business;
    private boolean cHk;
    private View fwY;
    CreateGroupStepActivity kaN;
    private int kaR;
    CreateGroupStepAdapter kbA;
    private int kbB;
    private TextView kbC;
    private com.baidu.tbadk.core.dialog.i kbD;
    int kbE;
    e kbF;
    h kbG;
    g kbH;
    d kbI;
    i kbJ;
    b kbK;
    private NoSwipeableViewPager kbL;
    private com.baidu.tieba.im.util.b kbM;
    private int kbN;
    private int kbO;
    private int kbP;
    private int kbQ;
    private int kbR;
    private boolean kbS;
    private String kbT;
    private String kbU;
    private String kbV;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void LO(String str) {
        this.kbU = str;
    }

    public void LP(String str) {
        this.kbV = str;
    }

    public String cPC() {
        return this.kbU;
    }

    public String blR() {
        return this.kbV;
    }

    public View cPD() {
        return this.fwY;
    }

    public int cPE() {
        return this.kbB;
    }

    public View cPF() {
        return this.kbC;
    }

    public View cPG() {
        if (this.kbF != null) {
            return this.kbF.cPr();
        }
        if (this.kbG != null) {
            return this.kbG.cPr();
        }
        return null;
    }

    public View cPH() {
        return this.kbJ.cPz();
    }

    public View cPI() {
        return this.kbJ.cPy();
    }

    public boolean cPJ() {
        return this.mIsLoading;
    }

    public void cPf() {
        this.kbK.cPf();
        cQe();
    }

    public void LQ(String str) {
        this.kbT = str;
    }

    public String amf() {
        return this.kbT;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.kbK.setBusiness(str);
        cQe();
    }

    public String getBusiness() {
        return this.business;
    }

    public void LR(String str) {
        this.kbK.setAddress(str);
        cQe();
    }

    public boolean cPK() {
        return this.kbS;
    }

    public void rK(boolean z) {
        this.kbS = z;
    }

    public void cPg() {
        this.kbK.cPg();
        cQe();
    }

    public void cPh() {
        this.kbK.cPh();
        cQe();
    }

    public View cPL() {
        return this.kbK.cPd();
    }

    public int cPe() {
        return this.kbK.cPe();
    }

    public View cPM() {
        return this.kbH.cPv();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.kbH.cPu().getText().toString();
    }

    public String getIntro() {
        return this.kbI.cPo().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.kbE;
    }

    public boolean cPN() {
        return this.kbH != null && this.kbB == this.kbH.cPc();
    }

    public boolean cPO() {
        return this.kbI != null && this.kbB == this.kbI.cPc();
    }

    public boolean cPP() {
        return this.kbJ != null && this.kbB == this.kbJ.cPc();
    }

    public boolean cPQ() {
        return this.kbK != null && this.kbB == this.kbK.cPc();
    }

    public boolean cPR() {
        return this.kbA != null && this.kbB == this.kbA.getCount();
    }

    public String getErrMsg() {
        if (this.kbA.Df(this.kbB - 1) != null) {
            return this.kbA.Df(this.kbB - 1).getErrMsg();
        }
        return null;
    }

    public void cPS() {
        this.kbJ.cPz().setText(R.string.group_create_modify_photo_tip);
    }

    public void cPT() {
        this.kbJ.cPx();
    }

    public void Mx() {
        this.kbH.cPw();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cHk = true;
        this.mIsLoading = false;
        this.kaN = null;
        this.kbA = null;
        this.progressBar = null;
        this.kbB = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fwY = null;
        this.kbC = null;
        this.kbD = null;
        this.kbE = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.kbF = null;
        this.kbG = null;
        this.kbH = null;
        this.kbI = null;
        this.kbJ = null;
        this.kbK = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.kbL = null;
        this.kbM = null;
        this.kbS = false;
        this.kbT = "";
        this.business = "";
        this.kbU = null;
        this.kbV = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.kbM = new com.baidu.tieba.im.util.b(this.kaN);
        this.kbM.setUniqueId(this.kaN.getUniqueId());
        if (!ae.c(this.kaN, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cPU();
        }
    }

    public void cPU() {
        this.kbM.startLoad();
    }

    public void cPV() {
        if (this.kbM != null) {
            this.kbM.cancelLoad();
        }
    }

    private void initListener() {
        this.fwY.setOnClickListener(this.kaN);
        this.kbC.setOnClickListener(this.kaN);
        this.kbH.cPu().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.kbH.cPu().addTextChangedListener(this.kaN);
        this.kbI.cPo().addTextChangedListener(this.kaN);
        this.kbJ.cPz().setOnClickListener(this.kaN);
        this.kbJ.cPy().setOnClickListener(this.kaN);
        this.kbK.cPd().setOnClickListener(this.kaN);
        if (this.kbG != null) {
            this.kbG.cPr().setOnClickListener(this.kaN);
        }
        if (this.kbF != null) {
            this.kbF.cPr().setOnClickListener(this.kaN);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.kaN = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.kbL = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.kbA = new CreateGroupStepAdapter(this.kaN);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.kbL.setAdapter(this.kbA);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.fwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cQc();
        this.kbC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.kbC.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.kbC, R.drawable.s_navbar_button_bg);
        rL(false);
        cQd();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.kbR = 1;
            this.kbQ = 2;
            this.kbN = 3;
            this.kbO = 4;
            this.kbP = 5;
            this.kbF = new e(createGroupStepActivity, this.kbR, i2);
            this.kbK = new b(createGroupStepActivity, this.kbQ, 1, 5);
            this.kbH = new g(createGroupStepActivity, this.kbN, 2, 5);
            this.kbI = new d(createGroupStepActivity, this.kbO, 3, 5);
            this.kbJ = new i(createGroupStepActivity, this.kbP, 4, 5);
            this.kbA.a(this.kbF);
            this.kbA.a(this.kbK);
            this.kbA.a(this.kbH);
            this.kbA.a(this.kbI);
            this.kbA.a(this.kbJ);
            this.kaR = 5;
        } else if (i == 2) {
            this.kbR = 1;
            this.kbN = 2;
            this.kbO = 3;
            this.kbP = 4;
            this.kbQ = 5;
            this.kbG = new h(createGroupStepActivity, this.kbR, i3);
            this.kbH = new g(createGroupStepActivity, this.kbN, 1, 5);
            this.kbI = new d(createGroupStepActivity, this.kbO, 2, 5);
            this.kbJ = new i(createGroupStepActivity, this.kbP, 3, 5);
            this.kbK = new b(createGroupStepActivity, this.kbQ, 4, 5);
            this.kbA.a(this.kbG);
            this.kbA.a(this.kbH);
            this.kbA.a(this.kbI);
            this.kbA.a(this.kbJ);
            this.kbA.a(this.kbK);
            this.kaR = 5;
        } else {
            this.kbN = 1;
            this.kbO = 2;
            this.kbP = 3;
            this.kbQ = 4;
            this.kbH = new g(createGroupStepActivity, this.kbN, 1, 4);
            this.kbI = new d(createGroupStepActivity, this.kbO, 2, 4);
            this.kbJ = new i(createGroupStepActivity, this.kbP, 3, 4);
            this.kbK = new b(createGroupStepActivity, this.kbQ, 4, 4);
            this.kbA.a(this.kbH);
            this.kbA.a(this.kbI);
            this.kbA.a(this.kbJ);
            this.kbA.a(this.kbK);
            this.kaR = 4;
        }
    }

    private void rL(boolean z) {
        this.cHk = z;
        cPX();
    }

    public boolean cPW() {
        return this.cHk;
    }

    private void cPX() {
        this.kbC.setEnabled(this.cHk);
        ap.setBackgroundResource(this.kbC, R.drawable.s_navbar_button_bg);
    }

    public void cPY() {
        if (this.kbB > 1) {
            this.kbB--;
            cQa();
        }
    }

    public void cPZ() {
        if (this.kbB < this.kaR) {
            this.kbB++;
            cQa();
        }
    }

    public void cQa() {
        this.kbL.setCurrentItem(this.kbB - 1);
        cQc();
        cQd();
        cQe();
        this.kbH.cPu().clearFocus();
        this.kbI.cPo().clearFocus();
        d(this.kbH.cPu());
        d(this.kbI.cPo());
        if (cPP() && cPJ()) {
            cPF().setEnabled(false);
        } else {
            cPF().setEnabled(true);
        }
    }

    public void cQb() {
        String[] strArr = {this.kaN.getResources().getString(R.string.take_photo), this.kaN.getResources().getString(R.string.album)};
        if (this.kbD == null) {
            this.kbD = new com.baidu.tbadk.core.dialog.i(this.kaN.getPageContext());
            this.kbD.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.kbD != null && j.this.kbD.isShowing() && j.this.kaN != null) {
                        j.this.kbD.dismiss();
                    }
                    Activity pageActivity = j.this.kaN.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.kaN.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.kaN.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.kbD.PA();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.kaN.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.kaN.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void LS(String str) {
        if (!this.kbC.getText().toString().equals(str)) {
            this.kbC.setText(str);
        }
    }

    private void cQc() {
        if (this.kbA.Df(this.kbB - 1) != null) {
            this.mNavigationBar.setTitleText(this.kbA.Df(this.kbB - 1).getTitle());
        }
    }

    public void cQd() {
        for (o oVar : this.kbA.getList()) {
            if (oVar.cPc() == this.kbB) {
                oVar.cPj();
                if (!oVar.cPn()) {
                    this.kbC.setVisibility(8);
                } else {
                    this.kbC.setVisibility(0);
                }
                LS(oVar.cPl());
            } else {
                oVar.cPi();
            }
        }
        if (this.kbA.Df(this.kbB - 1) != null && this.kbA.Df(this.kbB - 1).cPm()) {
            rL(true);
        }
    }

    public void cQe() {
        if (cPN()) {
            a(this.kbH.cPu().getText().length(), this.kbH.wo() / 2, 2, 20);
        } else if (cPO()) {
            int wo = this.kbI.wo() / 2;
            V(wo, 15, 300);
            int i = 300 - wo;
            this.kbI.cPp().setText(String.valueOf(i));
            if (i <= 50) {
                this.kbI.cPp().setVisibility(0);
            } else {
                this.kbI.cPp().setVisibility(8);
            }
            if (i == 0) {
                this.kbI.cPp().setTextColor(this.kaN.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.kbI.De(300);
            } else {
                this.kbI.cPq();
            }
        } else if (cPQ()) {
            if (this.kbK.cPe() != 3) {
                rL(true);
            } else {
                rL(false);
            }
        }
    }

    private void V(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            rL(true);
        } else {
            rL(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            rL(false);
        } else if (f >= i2 && f <= i3) {
            rL(true);
        } else {
            rL(false);
        }
        if (i < 1) {
            this.kbH.rJ(false);
        } else {
            this.kbH.rJ(true);
        }
    }

    public void setData(int i, int i2) {
        this.kbE = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.kaN.getLayoutMode().setNightMode(i == 1);
        this.kaN.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cPX();
        ap.setViewTextColor(this.kbC, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.kaN.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
