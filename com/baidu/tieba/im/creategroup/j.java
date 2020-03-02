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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c {
    private boolean bmL;
    private String business;
    private View dFK;
    CreateGroupStepActivity hvQ;
    private int hvU;
    CreateGroupStepAdapter hwD;
    private int hwE;
    private TextView hwF;
    private com.baidu.tbadk.core.dialog.i hwG;
    int hwH;
    e hwI;
    h hwJ;
    g hwK;
    d hwL;
    i hwM;
    b hwN;
    private NoSwipeableViewPager hwO;
    private com.baidu.tieba.im.util.b hwP;
    private int hwQ;
    private int hwR;
    private int hwS;
    private int hwT;
    private int hwU;
    private boolean hwV;
    private String hwW;
    private String hwX;
    private String hwY;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void CD(String str) {
        this.hwX = str;
    }

    public void CE(String str) {
        this.hwY = str;
    }

    public String bTm() {
        return this.hwX;
    }

    public String bTn() {
        return this.hwY;
    }

    public View bTo() {
        return this.dFK;
    }

    public int bTp() {
        return this.hwE;
    }

    public View bTq() {
        return this.hwF;
    }

    public View bTr() {
        if (this.hwI != null) {
            return this.hwI.bTc();
        }
        if (this.hwJ != null) {
            return this.hwJ.bTc();
        }
        return null;
    }

    public View bTs() {
        return this.hwM.bTk();
    }

    public View bTt() {
        return this.hwM.bTj();
    }

    public boolean bTu() {
        return this.mIsLoading;
    }

    public void bSP() {
        this.hwN.bSP();
        bTP();
    }

    public void CF(String str) {
        this.hwW = str;
    }

    public String ML() {
        return this.hwW;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.hwN.setBusiness(str);
        bTP();
    }

    public String getBusiness() {
        return this.business;
    }

    public void CG(String str) {
        this.hwN.setAddress(str);
        bTP();
    }

    public boolean bTv() {
        return this.hwV;
    }

    public void no(boolean z) {
        this.hwV = z;
    }

    public void bSQ() {
        this.hwN.bSQ();
        bTP();
    }

    public void bSR() {
        this.hwN.bSR();
        bTP();
    }

    public View bTw() {
        return this.hwN.bSN();
    }

    public int bSO() {
        return this.hwN.bSO();
    }

    public View bTx() {
        return this.hwK.bTg();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.hwK.bTf().getText().toString();
    }

    public String getIntro() {
        return this.hwL.bSY().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.hwH;
    }

    public boolean bTy() {
        return this.hwK != null && this.hwE == this.hwK.bSM();
    }

    public boolean bTz() {
        return this.hwL != null && this.hwE == this.hwL.bSM();
    }

    public boolean bTA() {
        return this.hwM != null && this.hwE == this.hwM.bSM();
    }

    public boolean bTB() {
        return this.hwN != null && this.hwE == this.hwN.bSM();
    }

    public boolean bTC() {
        return this.hwD != null && this.hwE == this.hwD.getCount();
    }

    public String getErrMsg() {
        if (this.hwD.wh(this.hwE - 1) != null) {
            return this.hwD.wh(this.hwE - 1).getErrMsg();
        }
        return null;
    }

    public void bTD() {
        this.hwM.bTk().setText(R.string.group_create_modify_photo_tip);
    }

    public void bTE() {
        this.hwM.bTi();
    }

    public void xS() {
        this.hwK.bTh();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bmL = true;
        this.mIsLoading = false;
        this.hvQ = null;
        this.hwD = null;
        this.progressBar = null;
        this.hwE = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dFK = null;
        this.hwF = null;
        this.hwG = null;
        this.hwH = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.hwI = null;
        this.hwJ = null;
        this.hwK = null;
        this.hwL = null;
        this.hwM = null;
        this.hwN = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.hwO = null;
        this.hwP = null;
        this.hwV = false;
        this.hwW = "";
        this.business = "";
        this.hwX = null;
        this.hwY = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.hwP = new com.baidu.tieba.im.util.b(this.hvQ);
        this.hwP.setUniqueId(this.hvQ.getUniqueId());
        bTF();
    }

    public void bTF() {
        this.hwP.startLoad();
    }

    public void bTG() {
        if (this.hwP != null) {
            this.hwP.cancelLoad();
        }
    }

    private void initListener() {
        this.dFK.setOnClickListener(this.hvQ);
        this.hwF.setOnClickListener(this.hvQ);
        this.hwK.bTf().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.hwK.bTf().addTextChangedListener(this.hvQ);
        this.hwL.bSY().addTextChangedListener(this.hvQ);
        this.hwM.bTk().setOnClickListener(this.hvQ);
        this.hwM.bTj().setOnClickListener(this.hvQ);
        this.hwN.bSN().setOnClickListener(this.hvQ);
        if (this.hwJ != null) {
            this.hwJ.bTc().setOnClickListener(this.hvQ);
        }
        if (this.hwI != null) {
            this.hwI.bTc().setOnClickListener(this.hvQ);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.hvQ = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.hwO = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.hwD = new CreateGroupStepAdapter(this.hvQ);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.hwO.setAdapter(this.hwD);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.dFK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bTN();
        this.hwF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.hwF.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.hwF, R.drawable.s_navbar_button_bg);
        np(false);
        bTO();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.hwU = 1;
            this.hwT = 2;
            this.hwQ = 3;
            this.hwR = 4;
            this.hwS = 5;
            this.hwI = new e(createGroupStepActivity, this.hwU, i2);
            this.hwN = new b(createGroupStepActivity, this.hwT, 1, 5);
            this.hwK = new g(createGroupStepActivity, this.hwQ, 2, 5);
            this.hwL = new d(createGroupStepActivity, this.hwR, 3, 5);
            this.hwM = new i(createGroupStepActivity, this.hwS, 4, 5);
            this.hwD.a(this.hwI);
            this.hwD.a(this.hwN);
            this.hwD.a(this.hwK);
            this.hwD.a(this.hwL);
            this.hwD.a(this.hwM);
            this.hvU = 5;
        } else if (i == 2) {
            this.hwU = 1;
            this.hwQ = 2;
            this.hwR = 3;
            this.hwS = 4;
            this.hwT = 5;
            this.hwJ = new h(createGroupStepActivity, this.hwU, i3);
            this.hwK = new g(createGroupStepActivity, this.hwQ, 1, 5);
            this.hwL = new d(createGroupStepActivity, this.hwR, 2, 5);
            this.hwM = new i(createGroupStepActivity, this.hwS, 3, 5);
            this.hwN = new b(createGroupStepActivity, this.hwT, 4, 5);
            this.hwD.a(this.hwJ);
            this.hwD.a(this.hwK);
            this.hwD.a(this.hwL);
            this.hwD.a(this.hwM);
            this.hwD.a(this.hwN);
            this.hvU = 5;
        } else {
            this.hwQ = 1;
            this.hwR = 2;
            this.hwS = 3;
            this.hwT = 4;
            this.hwK = new g(createGroupStepActivity, this.hwQ, 1, 4);
            this.hwL = new d(createGroupStepActivity, this.hwR, 2, 4);
            this.hwM = new i(createGroupStepActivity, this.hwS, 3, 4);
            this.hwN = new b(createGroupStepActivity, this.hwT, 4, 4);
            this.hwD.a(this.hwK);
            this.hwD.a(this.hwL);
            this.hwD.a(this.hwM);
            this.hwD.a(this.hwN);
            this.hvU = 4;
        }
    }

    private void np(boolean z) {
        this.bmL = z;
        bTI();
    }

    public boolean bTH() {
        return this.bmL;
    }

    private void bTI() {
        this.hwF.setEnabled(this.bmL);
        am.setBackgroundResource(this.hwF, R.drawable.s_navbar_button_bg);
    }

    public void bTJ() {
        if (this.hwE > 1) {
            this.hwE--;
            bTL();
        }
    }

    public void bTK() {
        if (this.hwE < this.hvU) {
            this.hwE++;
            bTL();
        }
    }

    public void bTL() {
        this.hwO.setCurrentItem(this.hwE - 1);
        bTN();
        bTO();
        bTP();
        this.hwK.bTf().clearFocus();
        this.hwL.bSY().clearFocus();
        d(this.hwK.bTf());
        d(this.hwL.bSY());
        if (bTA() && bTu()) {
            bTq().setEnabled(false);
        } else {
            bTq().setEnabled(true);
        }
    }

    public void bTM() {
        String[] strArr = {this.hvQ.getResources().getString(R.string.take_photo), this.hvQ.getResources().getString(R.string.album)};
        if (this.hwG == null) {
            this.hwG = new com.baidu.tbadk.core.dialog.i(this.hvQ.getPageContext());
            this.hwG.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.hwG != null && j.this.hwG.isShowing() && j.this.hvQ != null) {
                        j.this.hwG.dismiss();
                    }
                    Activity pageActivity = j.this.hvQ.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.hvQ.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.hvQ.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.hwG.showDialog();
    }

    public void ao(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.hvQ.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.hvQ.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void CH(String str) {
        if (!this.hwF.getText().toString().equals(str)) {
            this.hwF.setText(str);
        }
    }

    private void bTN() {
        if (this.hwD.wh(this.hwE - 1) != null) {
            this.mNavigationBar.setTitleText(this.hwD.wh(this.hwE - 1).getTitle());
        }
    }

    public void bTO() {
        for (o oVar : this.hwD.getList()) {
            if (oVar.bSM() == this.hwE) {
                oVar.bST();
                if (!oVar.bSX()) {
                    this.hwF.setVisibility(8);
                } else {
                    this.hwF.setVisibility(0);
                }
                CH(oVar.bSV());
            } else {
                oVar.bSS();
            }
        }
        if (this.hwD.wh(this.hwE - 1) != null && this.hwD.wh(this.hwE - 1).bSW()) {
            np(true);
        }
    }

    public void bTP() {
        if (bTy()) {
            a(this.hwK.bTf().getText().length(), this.hwK.bTa() / 2, 2, 20);
        } else if (bTz()) {
            int bTa = this.hwL.bTa() / 2;
            P(bTa, 15, 300);
            int i = 300 - bTa;
            this.hwL.bSZ().setText(String.valueOf(i));
            if (i <= 50) {
                this.hwL.bSZ().setVisibility(0);
            } else {
                this.hwL.bSZ().setVisibility(8);
            }
            if (i == 0) {
                this.hwL.bSZ().setTextColor(this.hvQ.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.hwL.wg(300);
            } else {
                this.hwL.bTb();
            }
        } else if (bTB()) {
            if (this.hwN.bSO() != 3) {
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
            this.hwK.nn(false);
        } else {
            this.hwK.nn(true);
        }
    }

    public void setData(int i, int i2) {
        this.hwH = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.hvQ.getLayoutMode().setNightMode(i == 1);
        this.hvQ.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bTI();
        am.setViewTextColor(this.hwF, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.hvQ.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
