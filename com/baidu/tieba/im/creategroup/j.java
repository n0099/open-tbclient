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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View biH;
    private String business;
    private com.baidu.tbadk.core.dialog.b dNr;
    CreateGroupStepActivity eOY;
    private boolean ePL;
    CreateGroupStepAdapter ePM;
    private int ePN;
    private TextView ePO;
    int ePP;
    e ePQ;
    h ePR;
    g ePS;
    d ePT;
    i ePU;
    b ePV;
    private NoSwipeableViewPager ePW;
    private com.baidu.tieba.im.util.b ePX;
    private int ePY;
    private int ePZ;
    private int ePc;
    private int eQa;
    private int eQb;
    private int eQc;
    private boolean eQd;
    private String eQe;
    private String eQf;
    private String eQg;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pX(String str) {
        this.eQf = str;
    }

    public void pY(String str) {
        this.eQg = str;
    }

    public String aQC() {
        return this.eQf;
    }

    public String aQD() {
        return this.eQg;
    }

    public View aQE() {
        return this.biH;
    }

    public int aQF() {
        return this.ePN;
    }

    public View aQG() {
        return this.ePO;
    }

    public View aQH() {
        if (this.ePQ != null) {
            return this.ePQ.aQr();
        }
        if (this.ePR != null) {
            return this.ePR.aQr();
        }
        return null;
    }

    public View aQI() {
        return this.ePU.aQz();
    }

    public View aQJ() {
        return this.ePU.aQy();
    }

    public boolean aQK() {
        return this.mIsLoading;
    }

    public void aQf() {
        this.ePV.aQf();
        aRf();
    }

    public void pZ(String str) {
        this.eQe = str;
    }

    public String getAddressName() {
        return this.eQe;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.ePV.setBusiness(str);
        aRf();
    }

    public String getBusiness() {
        return this.business;
    }

    public void qa(String str) {
        this.ePV.setAddress(str);
        aRf();
    }

    public boolean aQL() {
        return this.eQd;
    }

    public void ir(boolean z) {
        this.eQd = z;
    }

    public void aQg() {
        this.ePV.aQg();
        aRf();
    }

    public void aQh() {
        this.ePV.aQh();
        aRf();
    }

    public View aQM() {
        return this.ePV.aQd();
    }

    public int aQe() {
        return this.ePV.aQe();
    }

    public View aQN() {
        return this.ePS.aQv();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.ePS.aQu().getText().toString();
    }

    public String getIntro() {
        return this.ePT.aQo().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.ePP;
    }

    public boolean aQO() {
        return this.ePS != null && this.ePN == this.ePS.aQc();
    }

    public boolean aQP() {
        return this.ePT != null && this.ePN == this.ePT.aQc();
    }

    public boolean aQQ() {
        return this.ePU != null && this.ePN == this.ePU.aQc();
    }

    public boolean aQR() {
        return this.ePV != null && this.ePN == this.ePV.aQc();
    }

    public boolean aQS() {
        return this.ePM != null && this.ePN == this.ePM.getCount();
    }

    public String getErrMsg() {
        if (this.ePM.pW(this.ePN - 1) != null) {
            return this.ePM.pW(this.ePN - 1).getErrMsg();
        }
        return null;
    }

    public void aQT() {
        this.ePU.aQz().setText(e.j.group_create_modify_photo_tip);
    }

    public void aQU() {
        this.ePU.aQx();
    }

    public void clearText() {
        this.ePS.aQw();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.ePL = true;
        this.mIsLoading = false;
        this.eOY = null;
        this.ePM = null;
        this.progressBar = null;
        this.ePN = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.biH = null;
        this.ePO = null;
        this.dNr = null;
        this.ePP = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.ePQ = null;
        this.ePR = null;
        this.ePS = null;
        this.ePT = null;
        this.ePU = null;
        this.ePV = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ePW = null;
        this.ePX = null;
        this.eQd = false;
        this.eQe = "";
        this.business = "";
        this.eQf = null;
        this.eQg = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.ePX = new com.baidu.tieba.im.util.b(this.eOY);
        this.ePX.setUniqueId(this.eOY.getUniqueId());
        aQV();
    }

    public void aQV() {
        this.ePX.RP();
    }

    public void aQW() {
        if (this.ePX != null) {
            this.ePX.cancelLoad();
        }
    }

    private void initListener() {
        this.biH.setOnClickListener(this.eOY);
        this.ePO.setOnClickListener(this.eOY);
        this.ePS.aQu().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.ePS.aQu().addTextChangedListener(this.eOY);
        this.ePT.aQo().addTextChangedListener(this.eOY);
        this.ePU.aQz().setOnClickListener(this.eOY);
        this.ePU.aQy().setOnClickListener(this.eOY);
        this.ePV.aQd().setOnClickListener(this.eOY);
        if (this.ePR != null) {
            this.ePR.aQr().setOnClickListener(this.eOY);
        }
        if (this.ePQ != null) {
            this.ePQ.aQr().setOnClickListener(this.eOY);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eOY = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.ePW = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.ePM = new CreateGroupStepAdapter(this.eOY);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ePW.setAdapter(this.ePM);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.biH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aRd();
        this.ePO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.ePO.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        al.i(this.ePO, e.f.s_navbar_button_bg);
        is(false);
        aRe();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eQc = 1;
            this.eQb = 2;
            this.ePY = 3;
            this.ePZ = 4;
            this.eQa = 5;
            this.ePQ = new e(createGroupStepActivity, this.eQc, i2);
            this.ePV = new b(createGroupStepActivity, this.eQb, 1, 5);
            this.ePS = new g(createGroupStepActivity, this.ePY, 2, 5);
            this.ePT = new d(createGroupStepActivity, this.ePZ, 3, 5);
            this.ePU = new i(createGroupStepActivity, this.eQa, 4, 5);
            this.ePM.a(this.ePQ);
            this.ePM.a(this.ePV);
            this.ePM.a(this.ePS);
            this.ePM.a(this.ePT);
            this.ePM.a(this.ePU);
            this.ePc = 5;
        } else if (i == 2) {
            this.eQc = 1;
            this.ePY = 2;
            this.ePZ = 3;
            this.eQa = 4;
            this.eQb = 5;
            this.ePR = new h(createGroupStepActivity, this.eQc, i3);
            this.ePS = new g(createGroupStepActivity, this.ePY, 1, 5);
            this.ePT = new d(createGroupStepActivity, this.ePZ, 2, 5);
            this.ePU = new i(createGroupStepActivity, this.eQa, 3, 5);
            this.ePV = new b(createGroupStepActivity, this.eQb, 4, 5);
            this.ePM.a(this.ePR);
            this.ePM.a(this.ePS);
            this.ePM.a(this.ePT);
            this.ePM.a(this.ePU);
            this.ePM.a(this.ePV);
            this.ePc = 5;
        } else {
            this.ePY = 1;
            this.ePZ = 2;
            this.eQa = 3;
            this.eQb = 4;
            this.ePS = new g(createGroupStepActivity, this.ePY, 1, 4);
            this.ePT = new d(createGroupStepActivity, this.ePZ, 2, 4);
            this.ePU = new i(createGroupStepActivity, this.eQa, 3, 4);
            this.ePV = new b(createGroupStepActivity, this.eQb, 4, 4);
            this.ePM.a(this.ePS);
            this.ePM.a(this.ePT);
            this.ePM.a(this.ePU);
            this.ePM.a(this.ePV);
            this.ePc = 4;
        }
    }

    private void is(boolean z) {
        this.ePL = z;
        aQY();
    }

    public boolean aQX() {
        return this.ePL;
    }

    private void aQY() {
        this.ePO.setEnabled(this.ePL);
        al.i(this.ePO, e.f.s_navbar_button_bg);
    }

    public void aQZ() {
        if (this.ePN > 1) {
            this.ePN--;
            aRb();
        }
    }

    public void aRa() {
        if (this.ePN < this.ePc) {
            this.ePN++;
            aRb();
        }
    }

    public void aRb() {
        this.ePW.setCurrentItem(this.ePN - 1);
        aRd();
        aRe();
        aRf();
        this.ePS.aQu().clearFocus();
        this.ePT.aQo().clearFocus();
        c(this.ePS.aQu());
        c(this.ePT.aQo());
        if (aQQ() && aQK()) {
            aQG().setEnabled(false);
        } else {
            aQG().setEnabled(true);
        }
    }

    public void aRc() {
        String[] strArr = {this.eOY.getResources().getString(e.j.take_photo), this.eOY.getResources().getString(e.j.album)};
        if (this.dNr == null) {
            this.dNr = new com.baidu.tbadk.core.dialog.b(this.eOY.getPageContext().getPageActivity());
            this.dNr.eL(this.eOY.getResources().getString(e.j.operation));
            this.dNr.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eOY.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.EG();
                    j.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.B(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eOY.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eOY.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dNr.d(this.eOY.getPageContext());
        }
        this.dNr.BV();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eOY.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.EG();
        this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.B(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eOY.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void qb(String str) {
        if (!this.ePO.getText().toString().equals(str)) {
            this.ePO.setText(str);
        }
    }

    private void aRd() {
        if (this.ePM.pW(this.ePN - 1) != null) {
            this.mNavigationBar.setTitleText(this.ePM.pW(this.ePN - 1).getTitle());
        }
    }

    public void aRe() {
        for (o oVar : this.ePM.getList()) {
            if (oVar.aQc() == this.ePN) {
                oVar.aQj();
                if (!oVar.aQn()) {
                    this.ePO.setVisibility(8);
                } else {
                    this.ePO.setVisibility(0);
                }
                qb(oVar.aQl());
            } else {
                oVar.aQi();
            }
        }
        if (this.ePM.pW(this.ePN - 1) != null && this.ePM.pW(this.ePN - 1).aQm()) {
            is(true);
        }
    }

    public void aRf() {
        if (aQO()) {
            a(this.ePS.aQu().getText().length(), this.ePS.getLength() / 2, 2, 20);
        } else if (aQP()) {
            int length = this.ePT.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.ePT.aQp().setText(String.valueOf(i));
            if (i <= 50) {
                this.ePT.aQp().setVisibility(0);
            } else {
                this.ePT.aQp().setVisibility(8);
            }
            if (i == 0) {
                this.ePT.aQp().setTextColor(this.eOY.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.ePT.pV(300);
            } else {
                this.ePT.aQq();
            }
        } else if (aQR()) {
            if (this.ePV.aQe() != 3) {
                is(true);
            } else {
                is(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            is(true);
        } else {
            is(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            is(false);
        } else if (f >= i2 && f <= i3) {
            is(true);
        } else {
            is(false);
        }
        if (i < 1) {
            this.ePS.iq(false);
        } else {
            this.ePS.iq(true);
        }
    }

    public void setData(int i, int i2) {
        this.ePP = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eOY.getLayoutMode().setNightMode(i == 1);
        this.eOY.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aQY();
        al.c(this.ePO, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.ln()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eOY.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
