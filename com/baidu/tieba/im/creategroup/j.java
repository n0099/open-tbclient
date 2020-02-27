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
    private boolean bmK;
    private String business;
    private View dFJ;
    CreateGroupStepActivity hvO;
    private int hvS;
    CreateGroupStepAdapter hwB;
    private int hwC;
    private TextView hwD;
    private com.baidu.tbadk.core.dialog.i hwE;
    int hwF;
    e hwG;
    h hwH;
    g hwI;
    d hwJ;
    i hwK;
    b hwL;
    private NoSwipeableViewPager hwM;
    private com.baidu.tieba.im.util.b hwN;
    private int hwO;
    private int hwP;
    private int hwQ;
    private int hwR;
    private int hwS;
    private boolean hwT;
    private String hwU;
    private String hwV;
    private String hwW;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void CD(String str) {
        this.hwV = str;
    }

    public void CE(String str) {
        this.hwW = str;
    }

    public String bTk() {
        return this.hwV;
    }

    public String bTl() {
        return this.hwW;
    }

    public View bTm() {
        return this.dFJ;
    }

    public int bTn() {
        return this.hwC;
    }

    public View bTo() {
        return this.hwD;
    }

    public View bTp() {
        if (this.hwG != null) {
            return this.hwG.bTa();
        }
        if (this.hwH != null) {
            return this.hwH.bTa();
        }
        return null;
    }

    public View bTq() {
        return this.hwK.bTi();
    }

    public View bTr() {
        return this.hwK.bTh();
    }

    public boolean bTs() {
        return this.mIsLoading;
    }

    public void bSN() {
        this.hwL.bSN();
        bTN();
    }

    public void CF(String str) {
        this.hwU = str;
    }

    public String MJ() {
        return this.hwU;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.hwL.setBusiness(str);
        bTN();
    }

    public String getBusiness() {
        return this.business;
    }

    public void CG(String str) {
        this.hwL.setAddress(str);
        bTN();
    }

    public boolean bTt() {
        return this.hwT;
    }

    public void no(boolean z) {
        this.hwT = z;
    }

    public void bSO() {
        this.hwL.bSO();
        bTN();
    }

    public void bSP() {
        this.hwL.bSP();
        bTN();
    }

    public View bTu() {
        return this.hwL.bSL();
    }

    public int bSM() {
        return this.hwL.bSM();
    }

    public View bTv() {
        return this.hwI.bTe();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.hwI.bTd().getText().toString();
    }

    public String getIntro() {
        return this.hwJ.bSW().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.hwF;
    }

    public boolean bTw() {
        return this.hwI != null && this.hwC == this.hwI.bSK();
    }

    public boolean bTx() {
        return this.hwJ != null && this.hwC == this.hwJ.bSK();
    }

    public boolean bTy() {
        return this.hwK != null && this.hwC == this.hwK.bSK();
    }

    public boolean bTz() {
        return this.hwL != null && this.hwC == this.hwL.bSK();
    }

    public boolean bTA() {
        return this.hwB != null && this.hwC == this.hwB.getCount();
    }

    public String getErrMsg() {
        if (this.hwB.wh(this.hwC - 1) != null) {
            return this.hwB.wh(this.hwC - 1).getErrMsg();
        }
        return null;
    }

    public void bTB() {
        this.hwK.bTi().setText(R.string.group_create_modify_photo_tip);
    }

    public void bTC() {
        this.hwK.bTg();
    }

    public void xS() {
        this.hwI.bTf();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bmK = true;
        this.mIsLoading = false;
        this.hvO = null;
        this.hwB = null;
        this.progressBar = null;
        this.hwC = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dFJ = null;
        this.hwD = null;
        this.hwE = null;
        this.hwF = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.hwG = null;
        this.hwH = null;
        this.hwI = null;
        this.hwJ = null;
        this.hwK = null;
        this.hwL = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.hwM = null;
        this.hwN = null;
        this.hwT = false;
        this.hwU = "";
        this.business = "";
        this.hwV = null;
        this.hwW = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.hwN = new com.baidu.tieba.im.util.b(this.hvO);
        this.hwN.setUniqueId(this.hvO.getUniqueId());
        bTD();
    }

    public void bTD() {
        this.hwN.startLoad();
    }

    public void bTE() {
        if (this.hwN != null) {
            this.hwN.cancelLoad();
        }
    }

    private void initListener() {
        this.dFJ.setOnClickListener(this.hvO);
        this.hwD.setOnClickListener(this.hvO);
        this.hwI.bTd().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.hwI.bTd().addTextChangedListener(this.hvO);
        this.hwJ.bSW().addTextChangedListener(this.hvO);
        this.hwK.bTi().setOnClickListener(this.hvO);
        this.hwK.bTh().setOnClickListener(this.hvO);
        this.hwL.bSL().setOnClickListener(this.hvO);
        if (this.hwH != null) {
            this.hwH.bTa().setOnClickListener(this.hvO);
        }
        if (this.hwG != null) {
            this.hwG.bTa().setOnClickListener(this.hvO);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.hvO = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.hwM = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.hwB = new CreateGroupStepAdapter(this.hvO);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.hwM.setAdapter(this.hwB);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.dFJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bTL();
        this.hwD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.hwD.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.hwD, R.drawable.s_navbar_button_bg);
        np(false);
        bTM();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.hwS = 1;
            this.hwR = 2;
            this.hwO = 3;
            this.hwP = 4;
            this.hwQ = 5;
            this.hwG = new e(createGroupStepActivity, this.hwS, i2);
            this.hwL = new b(createGroupStepActivity, this.hwR, 1, 5);
            this.hwI = new g(createGroupStepActivity, this.hwO, 2, 5);
            this.hwJ = new d(createGroupStepActivity, this.hwP, 3, 5);
            this.hwK = new i(createGroupStepActivity, this.hwQ, 4, 5);
            this.hwB.a(this.hwG);
            this.hwB.a(this.hwL);
            this.hwB.a(this.hwI);
            this.hwB.a(this.hwJ);
            this.hwB.a(this.hwK);
            this.hvS = 5;
        } else if (i == 2) {
            this.hwS = 1;
            this.hwO = 2;
            this.hwP = 3;
            this.hwQ = 4;
            this.hwR = 5;
            this.hwH = new h(createGroupStepActivity, this.hwS, i3);
            this.hwI = new g(createGroupStepActivity, this.hwO, 1, 5);
            this.hwJ = new d(createGroupStepActivity, this.hwP, 2, 5);
            this.hwK = new i(createGroupStepActivity, this.hwQ, 3, 5);
            this.hwL = new b(createGroupStepActivity, this.hwR, 4, 5);
            this.hwB.a(this.hwH);
            this.hwB.a(this.hwI);
            this.hwB.a(this.hwJ);
            this.hwB.a(this.hwK);
            this.hwB.a(this.hwL);
            this.hvS = 5;
        } else {
            this.hwO = 1;
            this.hwP = 2;
            this.hwQ = 3;
            this.hwR = 4;
            this.hwI = new g(createGroupStepActivity, this.hwO, 1, 4);
            this.hwJ = new d(createGroupStepActivity, this.hwP, 2, 4);
            this.hwK = new i(createGroupStepActivity, this.hwQ, 3, 4);
            this.hwL = new b(createGroupStepActivity, this.hwR, 4, 4);
            this.hwB.a(this.hwI);
            this.hwB.a(this.hwJ);
            this.hwB.a(this.hwK);
            this.hwB.a(this.hwL);
            this.hvS = 4;
        }
    }

    private void np(boolean z) {
        this.bmK = z;
        bTG();
    }

    public boolean bTF() {
        return this.bmK;
    }

    private void bTG() {
        this.hwD.setEnabled(this.bmK);
        am.setBackgroundResource(this.hwD, R.drawable.s_navbar_button_bg);
    }

    public void bTH() {
        if (this.hwC > 1) {
            this.hwC--;
            bTJ();
        }
    }

    public void bTI() {
        if (this.hwC < this.hvS) {
            this.hwC++;
            bTJ();
        }
    }

    public void bTJ() {
        this.hwM.setCurrentItem(this.hwC - 1);
        bTL();
        bTM();
        bTN();
        this.hwI.bTd().clearFocus();
        this.hwJ.bSW().clearFocus();
        d(this.hwI.bTd());
        d(this.hwJ.bSW());
        if (bTy() && bTs()) {
            bTo().setEnabled(false);
        } else {
            bTo().setEnabled(true);
        }
    }

    public void bTK() {
        String[] strArr = {this.hvO.getResources().getString(R.string.take_photo), this.hvO.getResources().getString(R.string.album)};
        if (this.hwE == null) {
            this.hwE = new com.baidu.tbadk.core.dialog.i(this.hvO.getPageContext());
            this.hwE.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.hwE != null && j.this.hwE.isShowing() && j.this.hvO != null) {
                        j.this.hwE.dismiss();
                    }
                    Activity pageActivity = j.this.hvO.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.hvO.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.hvO.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.hwE.showDialog();
    }

    public void ao(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.hvO.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.hvO.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void CH(String str) {
        if (!this.hwD.getText().toString().equals(str)) {
            this.hwD.setText(str);
        }
    }

    private void bTL() {
        if (this.hwB.wh(this.hwC - 1) != null) {
            this.mNavigationBar.setTitleText(this.hwB.wh(this.hwC - 1).getTitle());
        }
    }

    public void bTM() {
        for (o oVar : this.hwB.getList()) {
            if (oVar.bSK() == this.hwC) {
                oVar.bSR();
                if (!oVar.bSV()) {
                    this.hwD.setVisibility(8);
                } else {
                    this.hwD.setVisibility(0);
                }
                CH(oVar.bST());
            } else {
                oVar.bSQ();
            }
        }
        if (this.hwB.wh(this.hwC - 1) != null && this.hwB.wh(this.hwC - 1).bSU()) {
            np(true);
        }
    }

    public void bTN() {
        if (bTw()) {
            a(this.hwI.bTd().getText().length(), this.hwI.bSY() / 2, 2, 20);
        } else if (bTx()) {
            int bSY = this.hwJ.bSY() / 2;
            P(bSY, 15, 300);
            int i = 300 - bSY;
            this.hwJ.bSX().setText(String.valueOf(i));
            if (i <= 50) {
                this.hwJ.bSX().setVisibility(0);
            } else {
                this.hwJ.bSX().setVisibility(8);
            }
            if (i == 0) {
                this.hwJ.bSX().setTextColor(this.hvO.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.hwJ.wg(300);
            } else {
                this.hwJ.bSZ();
            }
        } else if (bTz()) {
            if (this.hwL.bSM() != 3) {
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
            this.hwI.nn(false);
        } else {
            this.hwI.nn(true);
        }
    }

    public void setData(int i, int i2) {
        this.hwF = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.hvO.getLayoutMode().setNightMode(i == 1);
        this.hvO.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bTG();
        am.setViewTextColor(this.hwD, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.hvO.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
