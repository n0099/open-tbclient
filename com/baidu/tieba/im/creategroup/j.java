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
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.c {
    private boolean biA;
    private String business;
    private View dBI;
    CreateGroupStepActivity htP;
    private int htT;
    CreateGroupStepAdapter huC;
    private int huD;
    private TextView huE;
    private com.baidu.tbadk.core.dialog.i huF;
    int huG;
    e huH;
    h huI;
    g huJ;
    d huK;
    i huL;
    b huM;
    private NoSwipeableViewPager huN;
    private com.baidu.tieba.im.util.b huO;
    private int huP;
    private int huQ;
    private int huR;
    private int huS;
    private int huT;
    private boolean huU;
    private String huV;
    private String huW;
    private String huX;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Cn(String str) {
        this.huW = str;
    }

    public void Co(String str) {
        this.huX = str;
    }

    public String bRJ() {
        return this.huW;
    }

    public String bRK() {
        return this.huX;
    }

    public View bRL() {
        return this.dBI;
    }

    public int bRM() {
        return this.huD;
    }

    public View bRN() {
        return this.huE;
    }

    public View bRO() {
        if (this.huH != null) {
            return this.huH.bRz();
        }
        if (this.huI != null) {
            return this.huI.bRz();
        }
        return null;
    }

    public View bRP() {
        return this.huL.bRH();
    }

    public View bRQ() {
        return this.huL.bRG();
    }

    public boolean bRR() {
        return this.mIsLoading;
    }

    public void bRm() {
        this.huM.bRm();
        bSm();
    }

    public void Cp(String str) {
        this.huV = str;
    }

    public String Ku() {
        return this.huV;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.huM.setBusiness(str);
        bSm();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Cq(String str) {
        this.huM.setAddress(str);
        bSm();
    }

    public boolean bRS() {
        return this.huU;
    }

    public void nm(boolean z) {
        this.huU = z;
    }

    public void bRn() {
        this.huM.bRn();
        bSm();
    }

    public void bRo() {
        this.huM.bRo();
        bSm();
    }

    public View bRT() {
        return this.huM.bRk();
    }

    public int bRl() {
        return this.huM.bRl();
    }

    public View bRU() {
        return this.huJ.bRD();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.huJ.bRC().getText().toString();
    }

    public String getIntro() {
        return this.huK.bRv().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.huG;
    }

    public boolean bRV() {
        return this.huJ != null && this.huD == this.huJ.bRj();
    }

    public boolean bRW() {
        return this.huK != null && this.huD == this.huK.bRj();
    }

    public boolean bRX() {
        return this.huL != null && this.huD == this.huL.bRj();
    }

    public boolean bRY() {
        return this.huM != null && this.huD == this.huM.bRj();
    }

    public boolean bRZ() {
        return this.huC != null && this.huD == this.huC.getCount();
    }

    public String getErrMsg() {
        if (this.huC.wb(this.huD - 1) != null) {
            return this.huC.wb(this.huD - 1).getErrMsg();
        }
        return null;
    }

    public void bSa() {
        this.huL.bRH().setText(R.string.group_create_modify_photo_tip);
    }

    public void bSb() {
        this.huL.bRF();
    }

    public void vT() {
        this.huJ.bRE();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.biA = true;
        this.mIsLoading = false;
        this.htP = null;
        this.huC = null;
        this.progressBar = null;
        this.huD = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dBI = null;
        this.huE = null;
        this.huF = null;
        this.huG = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.huH = null;
        this.huI = null;
        this.huJ = null;
        this.huK = null;
        this.huL = null;
        this.huM = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.huN = null;
        this.huO = null;
        this.huU = false;
        this.huV = "";
        this.business = "";
        this.huW = null;
        this.huX = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.huO = new com.baidu.tieba.im.util.b(this.htP);
        this.huO.setUniqueId(this.htP.getUniqueId());
        bSc();
    }

    public void bSc() {
        this.huO.startLoad();
    }

    public void bSd() {
        if (this.huO != null) {
            this.huO.cancelLoad();
        }
    }

    private void initListener() {
        this.dBI.setOnClickListener(this.htP);
        this.huE.setOnClickListener(this.htP);
        this.huJ.bRC().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.huJ.bRC().addTextChangedListener(this.htP);
        this.huK.bRv().addTextChangedListener(this.htP);
        this.huL.bRH().setOnClickListener(this.htP);
        this.huL.bRG().setOnClickListener(this.htP);
        this.huM.bRk().setOnClickListener(this.htP);
        if (this.huI != null) {
            this.huI.bRz().setOnClickListener(this.htP);
        }
        if (this.huH != null) {
            this.huH.bRz().setOnClickListener(this.htP);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.htP = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.huN = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.huC = new CreateGroupStepAdapter(this.htP);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.huN.setAdapter(this.huC);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.dBI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bSk();
        this.huE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.huE.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.huE, R.drawable.s_navbar_button_bg);
        nn(false);
        bSl();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.huT = 1;
            this.huS = 2;
            this.huP = 3;
            this.huQ = 4;
            this.huR = 5;
            this.huH = new e(createGroupStepActivity, this.huT, i2);
            this.huM = new b(createGroupStepActivity, this.huS, 1, 5);
            this.huJ = new g(createGroupStepActivity, this.huP, 2, 5);
            this.huK = new d(createGroupStepActivity, this.huQ, 3, 5);
            this.huL = new i(createGroupStepActivity, this.huR, 4, 5);
            this.huC.a(this.huH);
            this.huC.a(this.huM);
            this.huC.a(this.huJ);
            this.huC.a(this.huK);
            this.huC.a(this.huL);
            this.htT = 5;
        } else if (i == 2) {
            this.huT = 1;
            this.huP = 2;
            this.huQ = 3;
            this.huR = 4;
            this.huS = 5;
            this.huI = new h(createGroupStepActivity, this.huT, i3);
            this.huJ = new g(createGroupStepActivity, this.huP, 1, 5);
            this.huK = new d(createGroupStepActivity, this.huQ, 2, 5);
            this.huL = new i(createGroupStepActivity, this.huR, 3, 5);
            this.huM = new b(createGroupStepActivity, this.huS, 4, 5);
            this.huC.a(this.huI);
            this.huC.a(this.huJ);
            this.huC.a(this.huK);
            this.huC.a(this.huL);
            this.huC.a(this.huM);
            this.htT = 5;
        } else {
            this.huP = 1;
            this.huQ = 2;
            this.huR = 3;
            this.huS = 4;
            this.huJ = new g(createGroupStepActivity, this.huP, 1, 4);
            this.huK = new d(createGroupStepActivity, this.huQ, 2, 4);
            this.huL = new i(createGroupStepActivity, this.huR, 3, 4);
            this.huM = new b(createGroupStepActivity, this.huS, 4, 4);
            this.huC.a(this.huJ);
            this.huC.a(this.huK);
            this.huC.a(this.huL);
            this.huC.a(this.huM);
            this.htT = 4;
        }
    }

    private void nn(boolean z) {
        this.biA = z;
        bSf();
    }

    public boolean bSe() {
        return this.biA;
    }

    private void bSf() {
        this.huE.setEnabled(this.biA);
        am.setBackgroundResource(this.huE, R.drawable.s_navbar_button_bg);
    }

    public void bSg() {
        if (this.huD > 1) {
            this.huD--;
            bSi();
        }
    }

    public void bSh() {
        if (this.huD < this.htT) {
            this.huD++;
            bSi();
        }
    }

    public void bSi() {
        this.huN.setCurrentItem(this.huD - 1);
        bSk();
        bSl();
        bSm();
        this.huJ.bRC().clearFocus();
        this.huK.bRv().clearFocus();
        d(this.huJ.bRC());
        d(this.huK.bRv());
        if (bRX() && bRR()) {
            bRN().setEnabled(false);
        } else {
            bRN().setEnabled(true);
        }
    }

    public void bSj() {
        String[] strArr = {this.htP.getResources().getString(R.string.take_photo), this.htP.getResources().getString(R.string.album)};
        if (this.huF == null) {
            this.huF = new com.baidu.tbadk.core.dialog.i(this.htP.getPageContext());
            this.huF.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.huF != null && j.this.huF.isShowing() && j.this.htP != null) {
                        j.this.huF.dismiss();
                    }
                    Activity pageActivity = j.this.htP.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.htP.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.htP.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.huF.showDialog();
    }

    public void ao(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.htP.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.htP.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Cr(String str) {
        if (!this.huE.getText().toString().equals(str)) {
            this.huE.setText(str);
        }
    }

    private void bSk() {
        if (this.huC.wb(this.huD - 1) != null) {
            this.mNavigationBar.setTitleText(this.huC.wb(this.huD - 1).getTitle());
        }
    }

    public void bSl() {
        for (o oVar : this.huC.getList()) {
            if (oVar.bRj() == this.huD) {
                oVar.bRq();
                if (!oVar.bRu()) {
                    this.huE.setVisibility(8);
                } else {
                    this.huE.setVisibility(0);
                }
                Cr(oVar.bRs());
            } else {
                oVar.bRp();
            }
        }
        if (this.huC.wb(this.huD - 1) != null && this.huC.wb(this.huD - 1).bRt()) {
            nn(true);
        }
    }

    public void bSm() {
        if (bRV()) {
            a(this.huJ.bRC().getText().length(), this.huJ.bRx() / 2, 2, 20);
        } else if (bRW()) {
            int bRx = this.huK.bRx() / 2;
            O(bRx, 15, 300);
            int i = 300 - bRx;
            this.huK.bRw().setText(String.valueOf(i));
            if (i <= 50) {
                this.huK.bRw().setVisibility(0);
            } else {
                this.huK.bRw().setVisibility(8);
            }
            if (i == 0) {
                this.huK.bRw().setTextColor(this.htP.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.huK.wa(300);
            } else {
                this.huK.bRy();
            }
        } else if (bRY()) {
            if (this.huM.bRl() != 3) {
                nn(true);
            } else {
                nn(false);
            }
        }
    }

    private void O(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            nn(true);
        } else {
            nn(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            nn(false);
        } else if (f >= i2 && f <= i3) {
            nn(true);
        } else {
            nn(false);
        }
        if (i < 1) {
            this.huJ.nl(false);
        } else {
            this.huJ.nl(true);
        }
    }

    public void setData(int i, int i2) {
        this.huG = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.htP.getLayoutMode().setNightMode(i == 1);
        this.htP.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bSf();
        am.setViewTextColor(this.huE, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.htP.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
