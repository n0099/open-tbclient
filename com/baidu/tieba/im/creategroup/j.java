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
    private View biG;
    private String business;
    private com.baidu.tbadk.core.dialog.b dNq;
    CreateGroupStepActivity eOX;
    private boolean ePK;
    CreateGroupStepAdapter ePL;
    private int ePM;
    private TextView ePN;
    int ePO;
    e ePP;
    h ePQ;
    g ePR;
    d ePS;
    i ePT;
    b ePU;
    private NoSwipeableViewPager ePV;
    private com.baidu.tieba.im.util.b ePW;
    private int ePX;
    private int ePY;
    private int ePZ;
    private int ePb;
    private int eQa;
    private int eQb;
    private boolean eQc;
    private String eQd;
    private String eQe;
    private String eQf;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void pX(String str) {
        this.eQe = str;
    }

    public void pY(String str) {
        this.eQf = str;
    }

    public String aQC() {
        return this.eQe;
    }

    public String aQD() {
        return this.eQf;
    }

    public View aQE() {
        return this.biG;
    }

    public int aQF() {
        return this.ePM;
    }

    public View aQG() {
        return this.ePN;
    }

    public View aQH() {
        if (this.ePP != null) {
            return this.ePP.aQr();
        }
        if (this.ePQ != null) {
            return this.ePQ.aQr();
        }
        return null;
    }

    public View aQI() {
        return this.ePT.aQz();
    }

    public View aQJ() {
        return this.ePT.aQy();
    }

    public boolean aQK() {
        return this.mIsLoading;
    }

    public void aQf() {
        this.ePU.aQf();
        aRf();
    }

    public void pZ(String str) {
        this.eQd = str;
    }

    public String getAddressName() {
        return this.eQd;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.ePU.setBusiness(str);
        aRf();
    }

    public String getBusiness() {
        return this.business;
    }

    public void qa(String str) {
        this.ePU.setAddress(str);
        aRf();
    }

    public boolean aQL() {
        return this.eQc;
    }

    public void ir(boolean z) {
        this.eQc = z;
    }

    public void aQg() {
        this.ePU.aQg();
        aRf();
    }

    public void aQh() {
        this.ePU.aQh();
        aRf();
    }

    public View aQM() {
        return this.ePU.aQd();
    }

    public int aQe() {
        return this.ePU.aQe();
    }

    public View aQN() {
        return this.ePR.aQv();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.ePR.aQu().getText().toString();
    }

    public String getIntro() {
        return this.ePS.aQo().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.ePO;
    }

    public boolean aQO() {
        return this.ePR != null && this.ePM == this.ePR.aQc();
    }

    public boolean aQP() {
        return this.ePS != null && this.ePM == this.ePS.aQc();
    }

    public boolean aQQ() {
        return this.ePT != null && this.ePM == this.ePT.aQc();
    }

    public boolean aQR() {
        return this.ePU != null && this.ePM == this.ePU.aQc();
    }

    public boolean aQS() {
        return this.ePL != null && this.ePM == this.ePL.getCount();
    }

    public String getErrMsg() {
        if (this.ePL.pW(this.ePM - 1) != null) {
            return this.ePL.pW(this.ePM - 1).getErrMsg();
        }
        return null;
    }

    public void aQT() {
        this.ePT.aQz().setText(e.j.group_create_modify_photo_tip);
    }

    public void aQU() {
        this.ePT.aQx();
    }

    public void clearText() {
        this.ePR.aQw();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.ePK = true;
        this.mIsLoading = false;
        this.eOX = null;
        this.ePL = null;
        this.progressBar = null;
        this.ePM = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.biG = null;
        this.ePN = null;
        this.dNq = null;
        this.ePO = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.ePP = null;
        this.ePQ = null;
        this.ePR = null;
        this.ePS = null;
        this.ePT = null;
        this.ePU = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ePV = null;
        this.ePW = null;
        this.eQc = false;
        this.eQd = "";
        this.business = "";
        this.eQe = null;
        this.eQf = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.ePW = new com.baidu.tieba.im.util.b(this.eOX);
        this.ePW.setUniqueId(this.eOX.getUniqueId());
        aQV();
    }

    public void aQV() {
        this.ePW.RP();
    }

    public void aQW() {
        if (this.ePW != null) {
            this.ePW.cancelLoad();
        }
    }

    private void initListener() {
        this.biG.setOnClickListener(this.eOX);
        this.ePN.setOnClickListener(this.eOX);
        this.ePR.aQu().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.ePR.aQu().addTextChangedListener(this.eOX);
        this.ePS.aQo().addTextChangedListener(this.eOX);
        this.ePT.aQz().setOnClickListener(this.eOX);
        this.ePT.aQy().setOnClickListener(this.eOX);
        this.ePU.aQd().setOnClickListener(this.eOX);
        if (this.ePQ != null) {
            this.ePQ.aQr().setOnClickListener(this.eOX);
        }
        if (this.ePP != null) {
            this.ePP.aQr().setOnClickListener(this.eOX);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eOX = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.ePV = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.ePL = new CreateGroupStepAdapter(this.eOX);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ePV.setAdapter(this.ePL);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.biG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aRd();
        this.ePN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.ePN.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        al.i(this.ePN, e.f.s_navbar_button_bg);
        is(false);
        aRe();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eQb = 1;
            this.eQa = 2;
            this.ePX = 3;
            this.ePY = 4;
            this.ePZ = 5;
            this.ePP = new e(createGroupStepActivity, this.eQb, i2);
            this.ePU = new b(createGroupStepActivity, this.eQa, 1, 5);
            this.ePR = new g(createGroupStepActivity, this.ePX, 2, 5);
            this.ePS = new d(createGroupStepActivity, this.ePY, 3, 5);
            this.ePT = new i(createGroupStepActivity, this.ePZ, 4, 5);
            this.ePL.a(this.ePP);
            this.ePL.a(this.ePU);
            this.ePL.a(this.ePR);
            this.ePL.a(this.ePS);
            this.ePL.a(this.ePT);
            this.ePb = 5;
        } else if (i == 2) {
            this.eQb = 1;
            this.ePX = 2;
            this.ePY = 3;
            this.ePZ = 4;
            this.eQa = 5;
            this.ePQ = new h(createGroupStepActivity, this.eQb, i3);
            this.ePR = new g(createGroupStepActivity, this.ePX, 1, 5);
            this.ePS = new d(createGroupStepActivity, this.ePY, 2, 5);
            this.ePT = new i(createGroupStepActivity, this.ePZ, 3, 5);
            this.ePU = new b(createGroupStepActivity, this.eQa, 4, 5);
            this.ePL.a(this.ePQ);
            this.ePL.a(this.ePR);
            this.ePL.a(this.ePS);
            this.ePL.a(this.ePT);
            this.ePL.a(this.ePU);
            this.ePb = 5;
        } else {
            this.ePX = 1;
            this.ePY = 2;
            this.ePZ = 3;
            this.eQa = 4;
            this.ePR = new g(createGroupStepActivity, this.ePX, 1, 4);
            this.ePS = new d(createGroupStepActivity, this.ePY, 2, 4);
            this.ePT = new i(createGroupStepActivity, this.ePZ, 3, 4);
            this.ePU = new b(createGroupStepActivity, this.eQa, 4, 4);
            this.ePL.a(this.ePR);
            this.ePL.a(this.ePS);
            this.ePL.a(this.ePT);
            this.ePL.a(this.ePU);
            this.ePb = 4;
        }
    }

    private void is(boolean z) {
        this.ePK = z;
        aQY();
    }

    public boolean aQX() {
        return this.ePK;
    }

    private void aQY() {
        this.ePN.setEnabled(this.ePK);
        al.i(this.ePN, e.f.s_navbar_button_bg);
    }

    public void aQZ() {
        if (this.ePM > 1) {
            this.ePM--;
            aRb();
        }
    }

    public void aRa() {
        if (this.ePM < this.ePb) {
            this.ePM++;
            aRb();
        }
    }

    public void aRb() {
        this.ePV.setCurrentItem(this.ePM - 1);
        aRd();
        aRe();
        aRf();
        this.ePR.aQu().clearFocus();
        this.ePS.aQo().clearFocus();
        c(this.ePR.aQu());
        c(this.ePS.aQo());
        if (aQQ() && aQK()) {
            aQG().setEnabled(false);
        } else {
            aQG().setEnabled(true);
        }
    }

    public void aRc() {
        String[] strArr = {this.eOX.getResources().getString(e.j.take_photo), this.eOX.getResources().getString(e.j.album)};
        if (this.dNq == null) {
            this.dNq = new com.baidu.tbadk.core.dialog.b(this.eOX.getPageContext().getPageActivity());
            this.dNq.eL(this.eOX.getResources().getString(e.j.operation));
            this.dNq.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eOX.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.EG();
                    j.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.B(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.eOX.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eOX.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dNq.d(this.eOX.getPageContext());
        }
        this.dNq.BV();
    }

    public void R(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eOX.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.EG();
        this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.B(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eOX.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void qb(String str) {
        if (!this.ePN.getText().toString().equals(str)) {
            this.ePN.setText(str);
        }
    }

    private void aRd() {
        if (this.ePL.pW(this.ePM - 1) != null) {
            this.mNavigationBar.setTitleText(this.ePL.pW(this.ePM - 1).getTitle());
        }
    }

    public void aRe() {
        for (o oVar : this.ePL.getList()) {
            if (oVar.aQc() == this.ePM) {
                oVar.aQj();
                if (!oVar.aQn()) {
                    this.ePN.setVisibility(8);
                } else {
                    this.ePN.setVisibility(0);
                }
                qb(oVar.aQl());
            } else {
                oVar.aQi();
            }
        }
        if (this.ePL.pW(this.ePM - 1) != null && this.ePL.pW(this.ePM - 1).aQm()) {
            is(true);
        }
    }

    public void aRf() {
        if (aQO()) {
            a(this.ePR.aQu().getText().length(), this.ePR.getLength() / 2, 2, 20);
        } else if (aQP()) {
            int length = this.ePS.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.ePS.aQp().setText(String.valueOf(i));
            if (i <= 50) {
                this.ePS.aQp().setVisibility(0);
            } else {
                this.ePS.aQp().setVisibility(8);
            }
            if (i == 0) {
                this.ePS.aQp().setTextColor(this.eOX.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.ePS.pV(300);
            } else {
                this.ePS.aQq();
            }
        } else if (aQR()) {
            if (this.ePU.aQe() != 3) {
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
            this.ePR.iq(false);
        } else {
            this.ePR.iq(true);
        }
    }

    public void setData(int i, int i2) {
        this.ePO = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eOX.getLayoutMode().setNightMode(i == 1);
        this.eOX.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aQY();
        al.c(this.ePN, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.ln()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eOX.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
