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
    CreateGroupStepAdapter iVO;
    private int iVP;
    private TextView iVQ;
    private com.baidu.tbadk.core.dialog.i iVR;
    int iVS;
    e iVT;
    h iVU;
    g iVV;
    d iVW;
    i iVX;
    b iVY;
    private NoSwipeableViewPager iVZ;
    CreateGroupStepActivity iVb;
    private int iVf;
    private com.baidu.tieba.im.util.b iWa;
    private int iWb;
    private int iWc;
    private int iWd;
    private int iWe;
    private int iWf;
    private boolean iWg;
    private String iWh;
    private String iWi;
    private String iWj;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Ho(String str) {
        this.iWi = str;
    }

    public void Hp(String str) {
        this.iWj = str;
    }

    public String csh() {
        return this.iWi;
    }

    public String aWA() {
        return this.iWj;
    }

    public View csi() {
        return this.eJG;
    }

    public int csj() {
        return this.iVP;
    }

    public View csk() {
        return this.iVQ;
    }

    public View csl() {
        if (this.iVT != null) {
            return this.iVT.crW();
        }
        if (this.iVU != null) {
            return this.iVU.crW();
        }
        return null;
    }

    public View csm() {
        return this.iVX.cse();
    }

    public View csn() {
        return this.iVX.csd();
    }

    public boolean cso() {
        return this.mIsLoading;
    }

    public void crJ() {
        this.iVY.crJ();
        csJ();
    }

    public void Hq(String str) {
        this.iWh = str;
    }

    public String YS() {
        return this.iWh;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.iVY.setBusiness(str);
        csJ();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Hr(String str) {
        this.iVY.setAddress(str);
        csJ();
    }

    public boolean csp() {
        return this.iWg;
    }

    public void pK(boolean z) {
        this.iWg = z;
    }

    public void crK() {
        this.iVY.crK();
        csJ();
    }

    public void crL() {
        this.iVY.crL();
        csJ();
    }

    public View csq() {
        return this.iVY.crH();
    }

    public int crI() {
        return this.iVY.crI();
    }

    public View csr() {
        return this.iVV.csa();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.iVV.crZ().getText().toString();
    }

    public String getIntro() {
        return this.iVW.crS().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.iVS;
    }

    public boolean css() {
        return this.iVV != null && this.iVP == this.iVV.crG();
    }

    public boolean cst() {
        return this.iVW != null && this.iVP == this.iVW.crG();
    }

    public boolean csu() {
        return this.iVX != null && this.iVP == this.iVX.crG();
    }

    public boolean csv() {
        return this.iVY != null && this.iVP == this.iVY.crG();
    }

    public boolean csw() {
        return this.iVO != null && this.iVP == this.iVO.getCount();
    }

    public String getErrMsg() {
        if (this.iVO.yA(this.iVP - 1) != null) {
            return this.iVO.yA(this.iVP - 1).getErrMsg();
        }
        return null;
    }

    public void csx() {
        this.iVX.cse().setText(R.string.group_create_modify_photo_tip);
    }

    public void csy() {
        this.iVX.csc();
    }

    public void EV() {
        this.iVV.csb();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.can = true;
        this.mIsLoading = false;
        this.iVb = null;
        this.iVO = null;
        this.progressBar = null;
        this.iVP = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eJG = null;
        this.iVQ = null;
        this.iVR = null;
        this.iVS = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.iVT = null;
        this.iVU = null;
        this.iVV = null;
        this.iVW = null;
        this.iVX = null;
        this.iVY = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.iVZ = null;
        this.iWa = null;
        this.iWg = false;
        this.iWh = "";
        this.business = "";
        this.iWi = null;
        this.iWj = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.iWa = new com.baidu.tieba.im.util.b(this.iVb);
        this.iWa.setUniqueId(this.iVb.getUniqueId());
        if (!ad.d(this.iVb, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            csz();
        }
    }

    public void csz() {
        this.iWa.startLoad();
    }

    public void csA() {
        if (this.iWa != null) {
            this.iWa.cancelLoad();
        }
    }

    private void initListener() {
        this.eJG.setOnClickListener(this.iVb);
        this.iVQ.setOnClickListener(this.iVb);
        this.iVV.crZ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.iVV.crZ().addTextChangedListener(this.iVb);
        this.iVW.crS().addTextChangedListener(this.iVb);
        this.iVX.cse().setOnClickListener(this.iVb);
        this.iVX.csd().setOnClickListener(this.iVb);
        this.iVY.crH().setOnClickListener(this.iVb);
        if (this.iVU != null) {
            this.iVU.crW().setOnClickListener(this.iVb);
        }
        if (this.iVT != null) {
            this.iVT.crW().setOnClickListener(this.iVb);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.iVb = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.iVZ = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.iVO = new CreateGroupStepAdapter(this.iVb);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.iVZ.setAdapter(this.iVO);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        csH();
        this.iVQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.iVQ.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ao.setBackgroundResource(this.iVQ, R.drawable.s_navbar_button_bg);
        pL(false);
        csI();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.iWf = 1;
            this.iWe = 2;
            this.iWb = 3;
            this.iWc = 4;
            this.iWd = 5;
            this.iVT = new e(createGroupStepActivity, this.iWf, i2);
            this.iVY = new b(createGroupStepActivity, this.iWe, 1, 5);
            this.iVV = new g(createGroupStepActivity, this.iWb, 2, 5);
            this.iVW = new d(createGroupStepActivity, this.iWc, 3, 5);
            this.iVX = new i(createGroupStepActivity, this.iWd, 4, 5);
            this.iVO.a(this.iVT);
            this.iVO.a(this.iVY);
            this.iVO.a(this.iVV);
            this.iVO.a(this.iVW);
            this.iVO.a(this.iVX);
            this.iVf = 5;
        } else if (i == 2) {
            this.iWf = 1;
            this.iWb = 2;
            this.iWc = 3;
            this.iWd = 4;
            this.iWe = 5;
            this.iVU = new h(createGroupStepActivity, this.iWf, i3);
            this.iVV = new g(createGroupStepActivity, this.iWb, 1, 5);
            this.iVW = new d(createGroupStepActivity, this.iWc, 2, 5);
            this.iVX = new i(createGroupStepActivity, this.iWd, 3, 5);
            this.iVY = new b(createGroupStepActivity, this.iWe, 4, 5);
            this.iVO.a(this.iVU);
            this.iVO.a(this.iVV);
            this.iVO.a(this.iVW);
            this.iVO.a(this.iVX);
            this.iVO.a(this.iVY);
            this.iVf = 5;
        } else {
            this.iWb = 1;
            this.iWc = 2;
            this.iWd = 3;
            this.iWe = 4;
            this.iVV = new g(createGroupStepActivity, this.iWb, 1, 4);
            this.iVW = new d(createGroupStepActivity, this.iWc, 2, 4);
            this.iVX = new i(createGroupStepActivity, this.iWd, 3, 4);
            this.iVY = new b(createGroupStepActivity, this.iWe, 4, 4);
            this.iVO.a(this.iVV);
            this.iVO.a(this.iVW);
            this.iVO.a(this.iVX);
            this.iVO.a(this.iVY);
            this.iVf = 4;
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
        this.iVQ.setEnabled(this.can);
        ao.setBackgroundResource(this.iVQ, R.drawable.s_navbar_button_bg);
    }

    public void csD() {
        if (this.iVP > 1) {
            this.iVP--;
            csF();
        }
    }

    public void csE() {
        if (this.iVP < this.iVf) {
            this.iVP++;
            csF();
        }
    }

    public void csF() {
        this.iVZ.setCurrentItem(this.iVP - 1);
        csH();
        csI();
        csJ();
        this.iVV.crZ().clearFocus();
        this.iVW.crS().clearFocus();
        d(this.iVV.crZ());
        d(this.iVW.crS());
        if (csu() && cso()) {
            csk().setEnabled(false);
        } else {
            csk().setEnabled(true);
        }
    }

    public void csG() {
        String[] strArr = {this.iVb.getResources().getString(R.string.take_photo), this.iVb.getResources().getString(R.string.album)};
        if (this.iVR == null) {
            this.iVR = new com.baidu.tbadk.core.dialog.i(this.iVb.getPageContext());
            this.iVR.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.iVR != null && j.this.iVR.isShowing() && j.this.iVb != null) {
                        j.this.iVR.dismiss();
                    }
                    Activity pageActivity = j.this.iVb.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            an.g(j.this.iVb.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.iVb.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.iVR.showDialog();
    }

    public void Y(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.iVb.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.iVb.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Hs(String str) {
        if (!this.iVQ.getText().toString().equals(str)) {
            this.iVQ.setText(str);
        }
    }

    private void csH() {
        if (this.iVO.yA(this.iVP - 1) != null) {
            this.mNavigationBar.setTitleText(this.iVO.yA(this.iVP - 1).getTitle());
        }
    }

    public void csI() {
        for (o oVar : this.iVO.getList()) {
            if (oVar.crG() == this.iVP) {
                oVar.crN();
                if (!oVar.crR()) {
                    this.iVQ.setVisibility(8);
                } else {
                    this.iVQ.setVisibility(0);
                }
                Hs(oVar.crP());
            } else {
                oVar.crM();
            }
        }
        if (this.iVO.yA(this.iVP - 1) != null && this.iVO.yA(this.iVP - 1).crQ()) {
            pL(true);
        }
    }

    public void csJ() {
        if (css()) {
            a(this.iVV.crZ().getText().length(), this.iVV.crU() / 2, 2, 20);
        } else if (cst()) {
            int crU = this.iVW.crU() / 2;
            R(crU, 15, 300);
            int i = 300 - crU;
            this.iVW.crT().setText(String.valueOf(i));
            if (i <= 50) {
                this.iVW.crT().setVisibility(0);
            } else {
                this.iVW.crT().setVisibility(8);
            }
            if (i == 0) {
                this.iVW.crT().setTextColor(this.iVb.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.iVW.yz(300);
            } else {
                this.iVW.crV();
            }
        } else if (csv()) {
            if (this.iVY.crI() != 3) {
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
            this.iVV.pJ(false);
        } else {
            this.iVV.pJ(true);
        }
    }

    public void setData(int i, int i2) {
        this.iVS = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.iVb.getLayoutMode().setNightMode(i == 1);
        this.iVb.getLayoutMode().onModeChanged(this.mParent);
        ao.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        csC();
        ao.setViewTextColor(this.iVQ, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ao.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.iVb.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
