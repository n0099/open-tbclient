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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes17.dex */
public class j extends com.baidu.adp.base.c {
    private String business;
    private boolean can;
    private View eJG;
    CreateGroupStepActivity iUZ;
    CreateGroupStepAdapter iVM;
    private int iVN;
    private TextView iVO;
    private com.baidu.tbadk.core.dialog.i iVP;
    int iVQ;
    e iVR;
    h iVS;
    g iVT;
    d iVU;
    i iVV;
    b iVW;
    private NoSwipeableViewPager iVX;
    private com.baidu.tieba.im.util.b iVY;
    private int iVZ;
    private int iVd;
    private int iWa;
    private int iWb;
    private int iWc;
    private int iWd;
    private boolean iWe;
    private String iWf;
    private String iWg;
    private String iWh;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Ho(String str) {
        this.iWg = str;
    }

    public void Hp(String str) {
        this.iWh = str;
    }

    public String csh() {
        return this.iWg;
    }

    public String aWA() {
        return this.iWh;
    }

    public View csi() {
        return this.eJG;
    }

    public int csj() {
        return this.iVN;
    }

    public View csk() {
        return this.iVO;
    }

    public View csl() {
        if (this.iVR != null) {
            return this.iVR.crW();
        }
        if (this.iVS != null) {
            return this.iVS.crW();
        }
        return null;
    }

    public View csm() {
        return this.iVV.cse();
    }

    public View csn() {
        return this.iVV.csd();
    }

    public boolean cso() {
        return this.mIsLoading;
    }

    public void crJ() {
        this.iVW.crJ();
        csJ();
    }

    public void Hq(String str) {
        this.iWf = str;
    }

    public String YS() {
        return this.iWf;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.iVW.setBusiness(str);
        csJ();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Hr(String str) {
        this.iVW.setAddress(str);
        csJ();
    }

    public boolean csp() {
        return this.iWe;
    }

    public void pK(boolean z) {
        this.iWe = z;
    }

    public void crK() {
        this.iVW.crK();
        csJ();
    }

    public void crL() {
        this.iVW.crL();
        csJ();
    }

    public View csq() {
        return this.iVW.crH();
    }

    public int crI() {
        return this.iVW.crI();
    }

    public View csr() {
        return this.iVT.csa();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.iVT.crZ().getText().toString();
    }

    public String getIntro() {
        return this.iVU.crS().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.iVQ;
    }

    public boolean css() {
        return this.iVT != null && this.iVN == this.iVT.crG();
    }

    public boolean cst() {
        return this.iVU != null && this.iVN == this.iVU.crG();
    }

    public boolean csu() {
        return this.iVV != null && this.iVN == this.iVV.crG();
    }

    public boolean csv() {
        return this.iVW != null && this.iVN == this.iVW.crG();
    }

    public boolean csw() {
        return this.iVM != null && this.iVN == this.iVM.getCount();
    }

    public String getErrMsg() {
        if (this.iVM.yA(this.iVN - 1) != null) {
            return this.iVM.yA(this.iVN - 1).getErrMsg();
        }
        return null;
    }

    public void csx() {
        this.iVV.cse().setText(R.string.group_create_modify_photo_tip);
    }

    public void csy() {
        this.iVV.csc();
    }

    public void EV() {
        this.iVT.csb();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.can = true;
        this.mIsLoading = false;
        this.iUZ = null;
        this.iVM = null;
        this.progressBar = null;
        this.iVN = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eJG = null;
        this.iVO = null;
        this.iVP = null;
        this.iVQ = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.iVR = null;
        this.iVS = null;
        this.iVT = null;
        this.iVU = null;
        this.iVV = null;
        this.iVW = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.iVX = null;
        this.iVY = null;
        this.iWe = false;
        this.iWf = "";
        this.business = "";
        this.iWg = null;
        this.iWh = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.iVY = new com.baidu.tieba.im.util.b(this.iUZ);
        this.iVY.setUniqueId(this.iUZ.getUniqueId());
        if (!ad.d(this.iUZ, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            csz();
        }
    }

    public void csz() {
        this.iVY.startLoad();
    }

    public void csA() {
        if (this.iVY != null) {
            this.iVY.cancelLoad();
        }
    }

    private void initListener() {
        this.eJG.setOnClickListener(this.iUZ);
        this.iVO.setOnClickListener(this.iUZ);
        this.iVT.crZ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.iVT.crZ().addTextChangedListener(this.iUZ);
        this.iVU.crS().addTextChangedListener(this.iUZ);
        this.iVV.cse().setOnClickListener(this.iUZ);
        this.iVV.csd().setOnClickListener(this.iUZ);
        this.iVW.crH().setOnClickListener(this.iUZ);
        if (this.iVS != null) {
            this.iVS.crW().setOnClickListener(this.iUZ);
        }
        if (this.iVR != null) {
            this.iVR.crW().setOnClickListener(this.iUZ);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.iUZ = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.iVX = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.iVM = new CreateGroupStepAdapter(this.iUZ);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.iVX.setAdapter(this.iVM);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        csH();
        this.iVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.iVO.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ao.setBackgroundResource(this.iVO, R.drawable.s_navbar_button_bg);
        pL(false);
        csI();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.iWd = 1;
            this.iWc = 2;
            this.iVZ = 3;
            this.iWa = 4;
            this.iWb = 5;
            this.iVR = new e(createGroupStepActivity, this.iWd, i2);
            this.iVW = new b(createGroupStepActivity, this.iWc, 1, 5);
            this.iVT = new g(createGroupStepActivity, this.iVZ, 2, 5);
            this.iVU = new d(createGroupStepActivity, this.iWa, 3, 5);
            this.iVV = new i(createGroupStepActivity, this.iWb, 4, 5);
            this.iVM.a(this.iVR);
            this.iVM.a(this.iVW);
            this.iVM.a(this.iVT);
            this.iVM.a(this.iVU);
            this.iVM.a(this.iVV);
            this.iVd = 5;
        } else if (i == 2) {
            this.iWd = 1;
            this.iVZ = 2;
            this.iWa = 3;
            this.iWb = 4;
            this.iWc = 5;
            this.iVS = new h(createGroupStepActivity, this.iWd, i3);
            this.iVT = new g(createGroupStepActivity, this.iVZ, 1, 5);
            this.iVU = new d(createGroupStepActivity, this.iWa, 2, 5);
            this.iVV = new i(createGroupStepActivity, this.iWb, 3, 5);
            this.iVW = new b(createGroupStepActivity, this.iWc, 4, 5);
            this.iVM.a(this.iVS);
            this.iVM.a(this.iVT);
            this.iVM.a(this.iVU);
            this.iVM.a(this.iVV);
            this.iVM.a(this.iVW);
            this.iVd = 5;
        } else {
            this.iVZ = 1;
            this.iWa = 2;
            this.iWb = 3;
            this.iWc = 4;
            this.iVT = new g(createGroupStepActivity, this.iVZ, 1, 4);
            this.iVU = new d(createGroupStepActivity, this.iWa, 2, 4);
            this.iVV = new i(createGroupStepActivity, this.iWb, 3, 4);
            this.iVW = new b(createGroupStepActivity, this.iWc, 4, 4);
            this.iVM.a(this.iVT);
            this.iVM.a(this.iVU);
            this.iVM.a(this.iVV);
            this.iVM.a(this.iVW);
            this.iVd = 4;
        }
    }

    private void pL(boolean z) {
        this.can = z;
        csC();
    }

    public boolean csB() {
        return this.can;
    }

    private void csC() {
        this.iVO.setEnabled(this.can);
        ao.setBackgroundResource(this.iVO, R.drawable.s_navbar_button_bg);
    }

    public void csD() {
        if (this.iVN > 1) {
            this.iVN--;
            csF();
        }
    }

    public void csE() {
        if (this.iVN < this.iVd) {
            this.iVN++;
            csF();
        }
    }

    public void csF() {
        this.iVX.setCurrentItem(this.iVN - 1);
        csH();
        csI();
        csJ();
        this.iVT.crZ().clearFocus();
        this.iVU.crS().clearFocus();
        d(this.iVT.crZ());
        d(this.iVU.crS());
        if (csu() && cso()) {
            csk().setEnabled(false);
        } else {
            csk().setEnabled(true);
        }
    }

    public void csG() {
        String[] strArr = {this.iUZ.getResources().getString(R.string.take_photo), this.iUZ.getResources().getString(R.string.album)};
        if (this.iVP == null) {
            this.iVP = new com.baidu.tbadk.core.dialog.i(this.iUZ.getPageContext());
            this.iVP.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.iVP != null && j.this.iVP.isShowing() && j.this.iUZ != null) {
                        j.this.iVP.dismiss();
                    }
                    Activity pageActivity = j.this.iUZ.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            an.g(j.this.iUZ.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.iUZ.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.iVP.showDialog();
    }

    public void Y(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.iUZ.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.iUZ.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Hs(String str) {
        if (!this.iVO.getText().toString().equals(str)) {
            this.iVO.setText(str);
        }
    }

    private void csH() {
        if (this.iVM.yA(this.iVN - 1) != null) {
            this.mNavigationBar.setTitleText(this.iVM.yA(this.iVN - 1).getTitle());
        }
    }

    public void csI() {
        for (o oVar : this.iVM.getList()) {
            if (oVar.crG() == this.iVN) {
                oVar.crN();
                if (!oVar.crR()) {
                    this.iVO.setVisibility(8);
                } else {
                    this.iVO.setVisibility(0);
                }
                Hs(oVar.crP());
            } else {
                oVar.crM();
            }
        }
        if (this.iVM.yA(this.iVN - 1) != null && this.iVM.yA(this.iVN - 1).crQ()) {
            pL(true);
        }
    }

    public void csJ() {
        if (css()) {
            a(this.iVT.crZ().getText().length(), this.iVT.crU() / 2, 2, 20);
        } else if (cst()) {
            int crU = this.iVU.crU() / 2;
            R(crU, 15, 300);
            int i = 300 - crU;
            this.iVU.crT().setText(String.valueOf(i));
            if (i <= 50) {
                this.iVU.crT().setVisibility(0);
            } else {
                this.iVU.crT().setVisibility(8);
            }
            if (i == 0) {
                this.iVU.crT().setTextColor(this.iUZ.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.iVU.yz(300);
            } else {
                this.iVU.crV();
            }
        } else if (csv()) {
            if (this.iVW.crI() != 3) {
                pL(true);
            } else {
                pL(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            pL(true);
        } else {
            pL(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            pL(false);
        } else if (f >= i2 && f <= i3) {
            pL(true);
        } else {
            pL(false);
        }
        if (i < 1) {
            this.iVT.pJ(false);
        } else {
            this.iVT.pJ(true);
        }
    }

    public void setData(int i, int i2) {
        this.iVQ = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.iUZ.getLayoutMode().setNightMode(i == 1);
        this.iUZ.getLayoutMode().onModeChanged(this.mParent);
        ao.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        csC();
        ao.setViewTextColor(this.iVO, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ao.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.iUZ.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
