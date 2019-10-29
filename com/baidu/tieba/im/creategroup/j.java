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
/* loaded from: classes5.dex */
public class j extends com.baidu.adp.base.c {
    private boolean aJW;
    private String business;
    private View cOr;
    CreateGroupStepActivity gCY;
    CreateGroupStepAdapter gDL;
    private int gDM;
    private TextView gDN;
    private com.baidu.tbadk.core.dialog.i gDO;
    int gDP;
    e gDQ;
    h gDR;
    g gDS;
    d gDT;
    i gDU;
    b gDV;
    private NoSwipeableViewPager gDW;
    private com.baidu.tieba.im.util.b gDX;
    private int gDY;
    private int gDZ;
    private int gDc;
    private int gEa;
    private int gEb;
    private int gEc;
    private boolean gEd;
    private String gEe;
    private String gEf;
    private String gEg;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void xu(String str) {
        this.gEf = str;
    }

    public void xv(String str) {
        this.gEg = str;
    }

    public String bzm() {
        return this.gEf;
    }

    public String bzn() {
        return this.gEg;
    }

    public View bzo() {
        return this.cOr;
    }

    public int bzp() {
        return this.gDM;
    }

    public View bzq() {
        return this.gDN;
    }

    public View bzr() {
        if (this.gDQ != null) {
            return this.gDQ.bzb();
        }
        if (this.gDR != null) {
            return this.gDR.bzb();
        }
        return null;
    }

    public View bzs() {
        return this.gDU.bzj();
    }

    public View bzt() {
        return this.gDU.bzi();
    }

    public boolean bzu() {
        return this.mIsLoading;
    }

    public void byO() {
        this.gDV.byO();
        bzP();
    }

    public void xw(String str) {
        this.gEe = str;
    }

    public String DK() {
        return this.gEe;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gDV.setBusiness(str);
        bzP();
    }

    public String getBusiness() {
        return this.business;
    }

    public void xx(String str) {
        this.gDV.setAddress(str);
        bzP();
    }

    public boolean bzv() {
        return this.gEd;
    }

    public void lM(boolean z) {
        this.gEd = z;
    }

    public void byP() {
        this.gDV.byP();
        bzP();
    }

    public void byQ() {
        this.gDV.byQ();
        bzP();
    }

    public View bzw() {
        return this.gDV.byM();
    }

    public int byN() {
        return this.gDV.byN();
    }

    public View bzx() {
        return this.gDS.bzf();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gDS.bze().getText().toString();
    }

    public String getIntro() {
        return this.gDT.byX().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gDP;
    }

    public boolean bzy() {
        return this.gDS != null && this.gDM == this.gDS.byL();
    }

    public boolean bzz() {
        return this.gDT != null && this.gDM == this.gDT.byL();
    }

    public boolean bzA() {
        return this.gDU != null && this.gDM == this.gDU.byL();
    }

    public boolean bzB() {
        return this.gDV != null && this.gDM == this.gDV.byL();
    }

    public boolean bzC() {
        return this.gDL != null && this.gDM == this.gDL.getCount();
    }

    public String getErrMsg() {
        if (this.gDL.tV(this.gDM - 1) != null) {
            return this.gDL.tV(this.gDM - 1).getErrMsg();
        }
        return null;
    }

    public void bzD() {
        this.gDU.bzj().setText(R.string.group_create_modify_photo_tip);
    }

    public void bzE() {
        this.gDU.bzh();
    }

    public void tH() {
        this.gDS.bzg();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.aJW = true;
        this.mIsLoading = false;
        this.gCY = null;
        this.gDL = null;
        this.progressBar = null;
        this.gDM = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cOr = null;
        this.gDN = null;
        this.gDO = null;
        this.gDP = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gDQ = null;
        this.gDR = null;
        this.gDS = null;
        this.gDT = null;
        this.gDU = null;
        this.gDV = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gDW = null;
        this.gDX = null;
        this.gEd = false;
        this.gEe = "";
        this.business = "";
        this.gEf = null;
        this.gEg = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gDX = new com.baidu.tieba.im.util.b(this.gCY);
        this.gDX.setUniqueId(this.gCY.getUniqueId());
        bzF();
    }

    public void bzF() {
        this.gDX.startLoad();
    }

    public void bzG() {
        if (this.gDX != null) {
            this.gDX.cancelLoad();
        }
    }

    private void initListener() {
        this.cOr.setOnClickListener(this.gCY);
        this.gDN.setOnClickListener(this.gCY);
        this.gDS.bze().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gDS.bze().addTextChangedListener(this.gCY);
        this.gDT.byX().addTextChangedListener(this.gCY);
        this.gDU.bzj().setOnClickListener(this.gCY);
        this.gDU.bzi().setOnClickListener(this.gCY);
        this.gDV.byM().setOnClickListener(this.gCY);
        if (this.gDR != null) {
            this.gDR.bzb().setOnClickListener(this.gCY);
        }
        if (this.gDQ != null) {
            this.gDQ.bzb().setOnClickListener(this.gCY);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gCY = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gDW = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gDL = new CreateGroupStepAdapter(this.gCY);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gDW.setAdapter(this.gDL);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cOr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bzN();
        this.gDN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gDN.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.gDN, R.drawable.s_navbar_button_bg);
        lN(false);
        bzO();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gEc = 1;
            this.gEb = 2;
            this.gDY = 3;
            this.gDZ = 4;
            this.gEa = 5;
            this.gDQ = new e(createGroupStepActivity, this.gEc, i2);
            this.gDV = new b(createGroupStepActivity, this.gEb, 1, 5);
            this.gDS = new g(createGroupStepActivity, this.gDY, 2, 5);
            this.gDT = new d(createGroupStepActivity, this.gDZ, 3, 5);
            this.gDU = new i(createGroupStepActivity, this.gEa, 4, 5);
            this.gDL.a(this.gDQ);
            this.gDL.a(this.gDV);
            this.gDL.a(this.gDS);
            this.gDL.a(this.gDT);
            this.gDL.a(this.gDU);
            this.gDc = 5;
        } else if (i == 2) {
            this.gEc = 1;
            this.gDY = 2;
            this.gDZ = 3;
            this.gEa = 4;
            this.gEb = 5;
            this.gDR = new h(createGroupStepActivity, this.gEc, i3);
            this.gDS = new g(createGroupStepActivity, this.gDY, 1, 5);
            this.gDT = new d(createGroupStepActivity, this.gDZ, 2, 5);
            this.gDU = new i(createGroupStepActivity, this.gEa, 3, 5);
            this.gDV = new b(createGroupStepActivity, this.gEb, 4, 5);
            this.gDL.a(this.gDR);
            this.gDL.a(this.gDS);
            this.gDL.a(this.gDT);
            this.gDL.a(this.gDU);
            this.gDL.a(this.gDV);
            this.gDc = 5;
        } else {
            this.gDY = 1;
            this.gDZ = 2;
            this.gEa = 3;
            this.gEb = 4;
            this.gDS = new g(createGroupStepActivity, this.gDY, 1, 4);
            this.gDT = new d(createGroupStepActivity, this.gDZ, 2, 4);
            this.gDU = new i(createGroupStepActivity, this.gEa, 3, 4);
            this.gDV = new b(createGroupStepActivity, this.gEb, 4, 4);
            this.gDL.a(this.gDS);
            this.gDL.a(this.gDT);
            this.gDL.a(this.gDU);
            this.gDL.a(this.gDV);
            this.gDc = 4;
        }
    }

    private void lN(boolean z) {
        this.aJW = z;
        bzI();
    }

    public boolean bzH() {
        return this.aJW;
    }

    private void bzI() {
        this.gDN.setEnabled(this.aJW);
        am.setBackgroundResource(this.gDN, R.drawable.s_navbar_button_bg);
    }

    public void bzJ() {
        if (this.gDM > 1) {
            this.gDM--;
            bzL();
        }
    }

    public void bzK() {
        if (this.gDM < this.gDc) {
            this.gDM++;
            bzL();
        }
    }

    public void bzL() {
        this.gDW.setCurrentItem(this.gDM - 1);
        bzN();
        bzO();
        bzP();
        this.gDS.bze().clearFocus();
        this.gDT.byX().clearFocus();
        f(this.gDS.bze());
        f(this.gDT.byX());
        if (bzA() && bzu()) {
            bzq().setEnabled(false);
        } else {
            bzq().setEnabled(true);
        }
    }

    public void bzM() {
        String[] strArr = {this.gCY.getResources().getString(R.string.take_photo), this.gCY.getResources().getString(R.string.album)};
        if (this.gDO == null) {
            this.gDO = new com.baidu.tbadk.core.dialog.i(this.gCY.getPageContext());
            this.gDO.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gDO != null && j.this.gDO.isShowing() && j.this.gCY != null) {
                        j.this.gDO.dismiss();
                    }
                    Activity pageActivity = j.this.gCY.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.c(j.this.gCY.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gCY.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gDO.showDialog();
    }

    public void av(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gCY.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.gCY.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void xy(String str) {
        if (!this.gDN.getText().toString().equals(str)) {
            this.gDN.setText(str);
        }
    }

    private void bzN() {
        if (this.gDL.tV(this.gDM - 1) != null) {
            this.mNavigationBar.setTitleText(this.gDL.tV(this.gDM - 1).getTitle());
        }
    }

    public void bzO() {
        for (o oVar : this.gDL.getList()) {
            if (oVar.byL() == this.gDM) {
                oVar.byS();
                if (!oVar.byW()) {
                    this.gDN.setVisibility(8);
                } else {
                    this.gDN.setVisibility(0);
                }
                xy(oVar.byU());
            } else {
                oVar.byR();
            }
        }
        if (this.gDL.tV(this.gDM - 1) != null && this.gDL.tV(this.gDM - 1).byV()) {
            lN(true);
        }
    }

    public void bzP() {
        if (bzy()) {
            a(this.gDS.bze().getText().length(), this.gDS.byZ() / 2, 2, 20);
        } else if (bzz()) {
            int byZ = this.gDT.byZ() / 2;
            O(byZ, 15, 300);
            int i = 300 - byZ;
            this.gDT.byY().setText(String.valueOf(i));
            if (i <= 50) {
                this.gDT.byY().setVisibility(0);
            } else {
                this.gDT.byY().setVisibility(8);
            }
            if (i == 0) {
                this.gDT.byY().setTextColor(this.gCY.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gDT.tU(300);
            } else {
                this.gDT.bza();
            }
        } else if (bzB()) {
            if (this.gDV.byN() != 3) {
                lN(true);
            } else {
                lN(false);
            }
        }
    }

    private void O(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            lN(true);
        } else {
            lN(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            lN(false);
        } else if (f >= i2 && f <= i3) {
            lN(true);
        } else {
            lN(false);
        }
        if (i < 1) {
            this.gDS.lL(false);
        } else {
            this.gDS.lL(true);
        }
    }

    public void setData(int i, int i2) {
        this.gDP = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gCY.getLayoutMode().setNightMode(i == 1);
        this.gCY.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bzI();
        am.setViewTextColor(this.gDN, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void f(EditText editText) {
        ((InputMethodManager) this.gCY.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
