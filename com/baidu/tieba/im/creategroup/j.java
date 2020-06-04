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
    private boolean bUi;
    private String business;
    private View eun;
    CreateGroupStepActivity iwR;
    private int iwV;
    CreateGroupStepAdapter ixE;
    private int ixF;
    private TextView ixG;
    private com.baidu.tbadk.core.dialog.i ixH;
    int ixI;
    e ixJ;
    h ixK;
    g ixL;
    d ixM;
    i ixN;
    b ixO;
    private NoSwipeableViewPager ixP;
    private com.baidu.tieba.im.util.b ixQ;
    private int ixR;
    private int ixS;
    private int ixT;
    private int ixU;
    private int ixV;
    private boolean ixW;
    private String ixX;
    private String ixY;
    private String ixZ;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void FY(String str) {
        this.ixY = str;
    }

    public void FZ(String str) {
        this.ixZ = str;
    }

    public String ckM() {
        return this.ixY;
    }

    public String aQN() {
        return this.ixZ;
    }

    public View ckN() {
        return this.eun;
    }

    public int ckO() {
        return this.ixF;
    }

    public View ckP() {
        return this.ixG;
    }

    public View ckQ() {
        if (this.ixJ != null) {
            return this.ixJ.ckB();
        }
        if (this.ixK != null) {
            return this.ixK.ckB();
        }
        return null;
    }

    public View ckR() {
        return this.ixN.ckJ();
    }

    public View ckS() {
        return this.ixN.ckI();
    }

    public boolean ckT() {
        return this.mIsLoading;
    }

    public void cko() {
        this.ixO.cko();
        clo();
    }

    public void Ga(String str) {
        this.ixX = str;
    }

    public String Xg() {
        return this.ixX;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.ixO.setBusiness(str);
        clo();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Gb(String str) {
        this.ixO.setAddress(str);
        clo();
    }

    public boolean ckU() {
        return this.ixW;
    }

    public void oU(boolean z) {
        this.ixW = z;
    }

    public void ckp() {
        this.ixO.ckp();
        clo();
    }

    public void ckq() {
        this.ixO.ckq();
        clo();
    }

    public View ckV() {
        return this.ixO.ckm();
    }

    public int ckn() {
        return this.ixO.ckn();
    }

    public View ckW() {
        return this.ixL.ckF();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.ixL.ckE().getText().toString();
    }

    public String getIntro() {
        return this.ixM.ckx().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.ixI;
    }

    public boolean ckX() {
        return this.ixL != null && this.ixF == this.ixL.ckl();
    }

    public boolean ckY() {
        return this.ixM != null && this.ixF == this.ixM.ckl();
    }

    public boolean ckZ() {
        return this.ixN != null && this.ixF == this.ixN.ckl();
    }

    public boolean cla() {
        return this.ixO != null && this.ixF == this.ixO.ckl();
    }

    public boolean clb() {
        return this.ixE != null && this.ixF == this.ixE.getCount();
    }

    public String getErrMsg() {
        if (this.ixE.xv(this.ixF - 1) != null) {
            return this.ixE.xv(this.ixF - 1).getErrMsg();
        }
        return null;
    }

    public void clc() {
        this.ixN.ckJ().setText(R.string.group_create_modify_photo_tip);
    }

    public void cld() {
        this.ixN.ckH();
    }

    public void El() {
        this.ixL.ckG();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bUi = true;
        this.mIsLoading = false;
        this.iwR = null;
        this.ixE = null;
        this.progressBar = null;
        this.ixF = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eun = null;
        this.ixG = null;
        this.ixH = null;
        this.ixI = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.ixJ = null;
        this.ixK = null;
        this.ixL = null;
        this.ixM = null;
        this.ixN = null;
        this.ixO = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ixP = null;
        this.ixQ = null;
        this.ixW = false;
        this.ixX = "";
        this.business = "";
        this.ixY = null;
        this.ixZ = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.ixQ = new com.baidu.tieba.im.util.b(this.iwR);
        this.ixQ.setUniqueId(this.iwR.getUniqueId());
        if (!ab.d(this.iwR, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cle();
        }
    }

    public void cle() {
        this.ixQ.startLoad();
    }

    public void clf() {
        if (this.ixQ != null) {
            this.ixQ.cancelLoad();
        }
    }

    private void initListener() {
        this.eun.setOnClickListener(this.iwR);
        this.ixG.setOnClickListener(this.iwR);
        this.ixL.ckE().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.ixL.ckE().addTextChangedListener(this.iwR);
        this.ixM.ckx().addTextChangedListener(this.iwR);
        this.ixN.ckJ().setOnClickListener(this.iwR);
        this.ixN.ckI().setOnClickListener(this.iwR);
        this.ixO.ckm().setOnClickListener(this.iwR);
        if (this.ixK != null) {
            this.ixK.ckB().setOnClickListener(this.iwR);
        }
        if (this.ixJ != null) {
            this.ixJ.ckB().setOnClickListener(this.iwR);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.iwR = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.ixP = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.ixE = new CreateGroupStepAdapter(this.iwR);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ixP.setAdapter(this.ixE);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        clm();
        this.ixG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.ixG.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.ixG, R.drawable.s_navbar_button_bg);
        oV(false);
        cln();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.ixV = 1;
            this.ixU = 2;
            this.ixR = 3;
            this.ixS = 4;
            this.ixT = 5;
            this.ixJ = new e(createGroupStepActivity, this.ixV, i2);
            this.ixO = new b(createGroupStepActivity, this.ixU, 1, 5);
            this.ixL = new g(createGroupStepActivity, this.ixR, 2, 5);
            this.ixM = new d(createGroupStepActivity, this.ixS, 3, 5);
            this.ixN = new i(createGroupStepActivity, this.ixT, 4, 5);
            this.ixE.a(this.ixJ);
            this.ixE.a(this.ixO);
            this.ixE.a(this.ixL);
            this.ixE.a(this.ixM);
            this.ixE.a(this.ixN);
            this.iwV = 5;
        } else if (i == 2) {
            this.ixV = 1;
            this.ixR = 2;
            this.ixS = 3;
            this.ixT = 4;
            this.ixU = 5;
            this.ixK = new h(createGroupStepActivity, this.ixV, i3);
            this.ixL = new g(createGroupStepActivity, this.ixR, 1, 5);
            this.ixM = new d(createGroupStepActivity, this.ixS, 2, 5);
            this.ixN = new i(createGroupStepActivity, this.ixT, 3, 5);
            this.ixO = new b(createGroupStepActivity, this.ixU, 4, 5);
            this.ixE.a(this.ixK);
            this.ixE.a(this.ixL);
            this.ixE.a(this.ixM);
            this.ixE.a(this.ixN);
            this.ixE.a(this.ixO);
            this.iwV = 5;
        } else {
            this.ixR = 1;
            this.ixS = 2;
            this.ixT = 3;
            this.ixU = 4;
            this.ixL = new g(createGroupStepActivity, this.ixR, 1, 4);
            this.ixM = new d(createGroupStepActivity, this.ixS, 2, 4);
            this.ixN = new i(createGroupStepActivity, this.ixT, 3, 4);
            this.ixO = new b(createGroupStepActivity, this.ixU, 4, 4);
            this.ixE.a(this.ixL);
            this.ixE.a(this.ixM);
            this.ixE.a(this.ixN);
            this.ixE.a(this.ixO);
            this.iwV = 4;
        }
    }

    private void oV(boolean z) {
        this.bUi = z;
        clh();
    }

    public boolean clg() {
        return this.bUi;
    }

    private void clh() {
        this.ixG.setEnabled(this.bUi);
        am.setBackgroundResource(this.ixG, R.drawable.s_navbar_button_bg);
    }

    public void cli() {
        if (this.ixF > 1) {
            this.ixF--;
            clk();
        }
    }

    public void clj() {
        if (this.ixF < this.iwV) {
            this.ixF++;
            clk();
        }
    }

    public void clk() {
        this.ixP.setCurrentItem(this.ixF - 1);
        clm();
        cln();
        clo();
        this.ixL.ckE().clearFocus();
        this.ixM.ckx().clearFocus();
        d(this.ixL.ckE());
        d(this.ixM.ckx());
        if (ckZ() && ckT()) {
            ckP().setEnabled(false);
        } else {
            ckP().setEnabled(true);
        }
    }

    public void cll() {
        String[] strArr = {this.iwR.getResources().getString(R.string.take_photo), this.iwR.getResources().getString(R.string.album)};
        if (this.ixH == null) {
            this.ixH = new com.baidu.tbadk.core.dialog.i(this.iwR.getPageContext());
            this.ixH.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.ixH != null && j.this.ixH.isShowing() && j.this.iwR != null) {
                        j.this.ixH.dismiss();
                    }
                    Activity pageActivity = j.this.iwR.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.d(j.this.iwR.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.iwR.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.ixH.showDialog();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.iwR.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.iwR.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Gc(String str) {
        if (!this.ixG.getText().toString().equals(str)) {
            this.ixG.setText(str);
        }
    }

    private void clm() {
        if (this.ixE.xv(this.ixF - 1) != null) {
            this.mNavigationBar.setTitleText(this.ixE.xv(this.ixF - 1).getTitle());
        }
    }

    public void cln() {
        for (o oVar : this.ixE.getList()) {
            if (oVar.ckl() == this.ixF) {
                oVar.cks();
                if (!oVar.ckw()) {
                    this.ixG.setVisibility(8);
                } else {
                    this.ixG.setVisibility(0);
                }
                Gc(oVar.cku());
            } else {
                oVar.ckr();
            }
        }
        if (this.ixE.xv(this.ixF - 1) != null && this.ixE.xv(this.ixF - 1).ckv()) {
            oV(true);
        }
    }

    public void clo() {
        if (ckX()) {
            a(this.ixL.ckE().getText().length(), this.ixL.ckz() / 2, 2, 20);
        } else if (ckY()) {
            int ckz = this.ixM.ckz() / 2;
            S(ckz, 15, 300);
            int i = 300 - ckz;
            this.ixM.cky().setText(String.valueOf(i));
            if (i <= 50) {
                this.ixM.cky().setVisibility(0);
            } else {
                this.ixM.cky().setVisibility(8);
            }
            if (i == 0) {
                this.ixM.cky().setTextColor(this.iwR.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.ixM.xu(300);
            } else {
                this.ixM.ckA();
            }
        } else if (cla()) {
            if (this.ixO.ckn() != 3) {
                oV(true);
            } else {
                oV(false);
            }
        }
    }

    private void S(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            oV(true);
        } else {
            oV(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            oV(false);
        } else if (f >= i2 && f <= i3) {
            oV(true);
        } else {
            oV(false);
        }
        if (i < 1) {
            this.ixL.oT(false);
        } else {
            this.ixL.oT(true);
        }
    }

    public void setData(int i, int i2) {
        this.ixI = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.iwR.getLayoutMode().setNightMode(i == 1);
        this.iwR.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        clh();
        am.setViewTextColor(this.ixG, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.iwR.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
