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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c {
    private boolean bmM;
    private String business;
    private View dFX;
    CreateGroupStepAdapter hwP;
    private int hwQ;
    private TextView hwR;
    private com.baidu.tbadk.core.dialog.i hwS;
    int hwT;
    e hwU;
    h hwV;
    g hwW;
    d hwX;
    i hwY;
    b hwZ;
    CreateGroupStepActivity hwc;
    private int hwg;
    private NoSwipeableViewPager hxa;
    private com.baidu.tieba.im.util.b hxb;
    private int hxc;
    private int hxd;
    private int hxe;
    private int hxf;
    private int hxg;
    private boolean hxh;
    private String hxi;
    private String hxj;
    private String hxk;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void CE(String str) {
        this.hxj = str;
    }

    public void CF(String str) {
        this.hxk = str;
    }

    public String bTn() {
        return this.hxj;
    }

    public String bTo() {
        return this.hxk;
    }

    public View bTp() {
        return this.dFX;
    }

    public int bTq() {
        return this.hwQ;
    }

    public View bTr() {
        return this.hwR;
    }

    public View bTs() {
        if (this.hwU != null) {
            return this.hwU.bTd();
        }
        if (this.hwV != null) {
            return this.hwV.bTd();
        }
        return null;
    }

    public View bTt() {
        return this.hwY.bTl();
    }

    public View bTu() {
        return this.hwY.bTk();
    }

    public boolean bTv() {
        return this.mIsLoading;
    }

    public void bSQ() {
        this.hwZ.bSQ();
        bTQ();
    }

    public void CG(String str) {
        this.hxi = str;
    }

    public String ML() {
        return this.hxi;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.hwZ.setBusiness(str);
        bTQ();
    }

    public String getBusiness() {
        return this.business;
    }

    public void CH(String str) {
        this.hwZ.setAddress(str);
        bTQ();
    }

    public boolean bTw() {
        return this.hxh;
    }

    public void no(boolean z) {
        this.hxh = z;
    }

    public void bSR() {
        this.hwZ.bSR();
        bTQ();
    }

    public void bSS() {
        this.hwZ.bSS();
        bTQ();
    }

    public View bTx() {
        return this.hwZ.bSO();
    }

    public int bSP() {
        return this.hwZ.bSP();
    }

    public View bTy() {
        return this.hwW.bTh();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.hwW.bTg().getText().toString();
    }

    public String getIntro() {
        return this.hwX.bSZ().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.hwT;
    }

    public boolean bTz() {
        return this.hwW != null && this.hwQ == this.hwW.bSN();
    }

    public boolean bTA() {
        return this.hwX != null && this.hwQ == this.hwX.bSN();
    }

    public boolean bTB() {
        return this.hwY != null && this.hwQ == this.hwY.bSN();
    }

    public boolean bTC() {
        return this.hwZ != null && this.hwQ == this.hwZ.bSN();
    }

    public boolean bTD() {
        return this.hwP != null && this.hwQ == this.hwP.getCount();
    }

    public String getErrMsg() {
        if (this.hwP.wh(this.hwQ - 1) != null) {
            return this.hwP.wh(this.hwQ - 1).getErrMsg();
        }
        return null;
    }

    public void bTE() {
        this.hwY.bTl().setText(R.string.group_create_modify_photo_tip);
    }

    public void bTF() {
        this.hwY.bTj();
    }

    public void xS() {
        this.hwW.bTi();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bmM = true;
        this.mIsLoading = false;
        this.hwc = null;
        this.hwP = null;
        this.progressBar = null;
        this.hwQ = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dFX = null;
        this.hwR = null;
        this.hwS = null;
        this.hwT = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.hwU = null;
        this.hwV = null;
        this.hwW = null;
        this.hwX = null;
        this.hwY = null;
        this.hwZ = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.hxa = null;
        this.hxb = null;
        this.hxh = false;
        this.hxi = "";
        this.business = "";
        this.hxj = null;
        this.hxk = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.hxb = new com.baidu.tieba.im.util.b(this.hwc);
        this.hxb.setUniqueId(this.hwc.getUniqueId());
        if (!ab.e(this.hwc, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            bTG();
        }
    }

    public void bTG() {
        this.hxb.startLoad();
    }

    public void bTH() {
        if (this.hxb != null) {
            this.hxb.cancelLoad();
        }
    }

    private void initListener() {
        this.dFX.setOnClickListener(this.hwc);
        this.hwR.setOnClickListener(this.hwc);
        this.hwW.bTg().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.hwW.bTg().addTextChangedListener(this.hwc);
        this.hwX.bSZ().addTextChangedListener(this.hwc);
        this.hwY.bTl().setOnClickListener(this.hwc);
        this.hwY.bTk().setOnClickListener(this.hwc);
        this.hwZ.bSO().setOnClickListener(this.hwc);
        if (this.hwV != null) {
            this.hwV.bTd().setOnClickListener(this.hwc);
        }
        if (this.hwU != null) {
            this.hwU.bTd().setOnClickListener(this.hwc);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.hwc = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.hxa = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.hwP = new CreateGroupStepAdapter(this.hwc);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.hxa.setAdapter(this.hwP);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.dFX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bTO();
        this.hwR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.hwR.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.hwR, R.drawable.s_navbar_button_bg);
        np(false);
        bTP();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.hxg = 1;
            this.hxf = 2;
            this.hxc = 3;
            this.hxd = 4;
            this.hxe = 5;
            this.hwU = new e(createGroupStepActivity, this.hxg, i2);
            this.hwZ = new b(createGroupStepActivity, this.hxf, 1, 5);
            this.hwW = new g(createGroupStepActivity, this.hxc, 2, 5);
            this.hwX = new d(createGroupStepActivity, this.hxd, 3, 5);
            this.hwY = new i(createGroupStepActivity, this.hxe, 4, 5);
            this.hwP.a(this.hwU);
            this.hwP.a(this.hwZ);
            this.hwP.a(this.hwW);
            this.hwP.a(this.hwX);
            this.hwP.a(this.hwY);
            this.hwg = 5;
        } else if (i == 2) {
            this.hxg = 1;
            this.hxc = 2;
            this.hxd = 3;
            this.hxe = 4;
            this.hxf = 5;
            this.hwV = new h(createGroupStepActivity, this.hxg, i3);
            this.hwW = new g(createGroupStepActivity, this.hxc, 1, 5);
            this.hwX = new d(createGroupStepActivity, this.hxd, 2, 5);
            this.hwY = new i(createGroupStepActivity, this.hxe, 3, 5);
            this.hwZ = new b(createGroupStepActivity, this.hxf, 4, 5);
            this.hwP.a(this.hwV);
            this.hwP.a(this.hwW);
            this.hwP.a(this.hwX);
            this.hwP.a(this.hwY);
            this.hwP.a(this.hwZ);
            this.hwg = 5;
        } else {
            this.hxc = 1;
            this.hxd = 2;
            this.hxe = 3;
            this.hxf = 4;
            this.hwW = new g(createGroupStepActivity, this.hxc, 1, 4);
            this.hwX = new d(createGroupStepActivity, this.hxd, 2, 4);
            this.hwY = new i(createGroupStepActivity, this.hxe, 3, 4);
            this.hwZ = new b(createGroupStepActivity, this.hxf, 4, 4);
            this.hwP.a(this.hwW);
            this.hwP.a(this.hwX);
            this.hwP.a(this.hwY);
            this.hwP.a(this.hwZ);
            this.hwg = 4;
        }
    }

    private void np(boolean z) {
        this.bmM = z;
        bTJ();
    }

    public boolean bTI() {
        return this.bmM;
    }

    private void bTJ() {
        this.hwR.setEnabled(this.bmM);
        am.setBackgroundResource(this.hwR, R.drawable.s_navbar_button_bg);
    }

    public void bTK() {
        if (this.hwQ > 1) {
            this.hwQ--;
            bTM();
        }
    }

    public void bTL() {
        if (this.hwQ < this.hwg) {
            this.hwQ++;
            bTM();
        }
    }

    public void bTM() {
        this.hxa.setCurrentItem(this.hwQ - 1);
        bTO();
        bTP();
        bTQ();
        this.hwW.bTg().clearFocus();
        this.hwX.bSZ().clearFocus();
        d(this.hwW.bTg());
        d(this.hwX.bSZ());
        if (bTB() && bTv()) {
            bTr().setEnabled(false);
        } else {
            bTr().setEnabled(true);
        }
    }

    public void bTN() {
        String[] strArr = {this.hwc.getResources().getString(R.string.take_photo), this.hwc.getResources().getString(R.string.album)};
        if (this.hwS == null) {
            this.hwS = new com.baidu.tbadk.core.dialog.i(this.hwc.getPageContext());
            this.hwS.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.hwS != null && j.this.hwS.isShowing() && j.this.hwc != null) {
                        j.this.hwS.dismiss();
                    }
                    Activity pageActivity = j.this.hwc.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.hwc.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.hwc.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.hwS.showDialog();
    }

    public void ao(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.hwc.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.hwc.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void CI(String str) {
        if (!this.hwR.getText().toString().equals(str)) {
            this.hwR.setText(str);
        }
    }

    private void bTO() {
        if (this.hwP.wh(this.hwQ - 1) != null) {
            this.mNavigationBar.setTitleText(this.hwP.wh(this.hwQ - 1).getTitle());
        }
    }

    public void bTP() {
        for (o oVar : this.hwP.getList()) {
            if (oVar.bSN() == this.hwQ) {
                oVar.bSU();
                if (!oVar.bSY()) {
                    this.hwR.setVisibility(8);
                } else {
                    this.hwR.setVisibility(0);
                }
                CI(oVar.bSW());
            } else {
                oVar.bST();
            }
        }
        if (this.hwP.wh(this.hwQ - 1) != null && this.hwP.wh(this.hwQ - 1).bSX()) {
            np(true);
        }
    }

    public void bTQ() {
        if (bTz()) {
            a(this.hwW.bTg().getText().length(), this.hwW.bTb() / 2, 2, 20);
        } else if (bTA()) {
            int bTb = this.hwX.bTb() / 2;
            P(bTb, 15, 300);
            int i = 300 - bTb;
            this.hwX.bTa().setText(String.valueOf(i));
            if (i <= 50) {
                this.hwX.bTa().setVisibility(0);
            } else {
                this.hwX.bTa().setVisibility(8);
            }
            if (i == 0) {
                this.hwX.bTa().setTextColor(this.hwc.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.hwX.wg(300);
            } else {
                this.hwX.bTc();
            }
        } else if (bTC()) {
            if (this.hwZ.bSP() != 3) {
                np(true);
            } else {
                np(false);
            }
        }
    }

    private void P(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            np(true);
        } else {
            np(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            np(false);
        } else if (f >= i2 && f <= i3) {
            np(true);
        } else {
            np(false);
        }
        if (i < 1) {
            this.hwW.nn(false);
        } else {
            this.hwW.nn(true);
        }
    }

    public void setData(int i, int i2) {
        this.hwT = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.hwc.getLayoutMode().setNightMode(i == 1);
        this.hwc.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bTJ();
        am.setViewTextColor(this.hwR, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.hwc.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
