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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes17.dex */
public class j extends com.baidu.adp.base.c {
    private String business;
    private boolean cgg;
    private View eUm;
    CreateGroupStepAdapter jkN;
    private int jkO;
    private TextView jkP;
    private com.baidu.tbadk.core.dialog.i jkQ;
    int jkR;
    e jkS;
    h jkT;
    g jkU;
    d jkV;
    i jkW;
    b jkX;
    private NoSwipeableViewPager jkY;
    private com.baidu.tieba.im.util.b jkZ;
    CreateGroupStepActivity jka;
    private int jke;
    private int jla;
    private int jlb;
    private int jlc;
    private int jld;
    private int jle;
    private boolean jlf;
    private String jlg;
    private String jlh;
    private String jli;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Kg(String str) {
        this.jlh = str;
    }

    public void Kh(String str) {
        this.jli = str;
    }

    public String cCY() {
        return this.jlh;
    }

    public String beT() {
        return this.jli;
    }

    public View cCZ() {
        return this.eUm;
    }

    public int cDa() {
        return this.jkO;
    }

    public View cDb() {
        return this.jkP;
    }

    public View cDc() {
        if (this.jkS != null) {
            return this.jkS.cCN();
        }
        if (this.jkT != null) {
            return this.jkT.cCN();
        }
        return null;
    }

    public View cDd() {
        return this.jkW.cCV();
    }

    public View cDe() {
        return this.jkW.cCU();
    }

    public boolean cDf() {
        return this.mIsLoading;
    }

    public void cCB() {
        this.jkX.cCB();
        cDA();
    }

    public void Ki(String str) {
        this.jlg = str;
    }

    public String aeY() {
        return this.jlg;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.jkX.setBusiness(str);
        cDA();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Kj(String str) {
        this.jkX.setAddress(str);
        cDA();
    }

    public boolean cDg() {
        return this.jlf;
    }

    public void qq(boolean z) {
        this.jlf = z;
    }

    public void cCC() {
        this.jkX.cCC();
        cDA();
    }

    public void cCD() {
        this.jkX.cCD();
        cDA();
    }

    public View cDh() {
        return this.jkX.cCz();
    }

    public int cCA() {
        return this.jkX.cCA();
    }

    public View cDi() {
        return this.jkU.cCR();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.jkU.cCQ().getText().toString();
    }

    public String getIntro() {
        return this.jkV.cCK().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.jkR;
    }

    public boolean cDj() {
        return this.jkU != null && this.jkO == this.jkU.cCy();
    }

    public boolean cDk() {
        return this.jkV != null && this.jkO == this.jkV.cCy();
    }

    public boolean cDl() {
        return this.jkW != null && this.jkO == this.jkW.cCy();
    }

    public boolean cDm() {
        return this.jkX != null && this.jkO == this.jkX.cCy();
    }

    public boolean cDn() {
        return this.jkN != null && this.jkO == this.jkN.getCount();
    }

    public String getErrMsg() {
        if (this.jkN.AU(this.jkO - 1) != null) {
            return this.jkN.AU(this.jkO - 1).getErrMsg();
        }
        return null;
    }

    public void cDo() {
        this.jkW.cCV().setText(R.string.group_create_modify_photo_tip);
    }

    public void cDp() {
        this.jkW.cCT();
    }

    public void KA() {
        this.jkU.cCS();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cgg = true;
        this.mIsLoading = false;
        this.jka = null;
        this.jkN = null;
        this.progressBar = null;
        this.jkO = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eUm = null;
        this.jkP = null;
        this.jkQ = null;
        this.jkR = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.jkS = null;
        this.jkT = null;
        this.jkU = null;
        this.jkV = null;
        this.jkW = null;
        this.jkX = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.jkY = null;
        this.jkZ = null;
        this.jlf = false;
        this.jlg = "";
        this.business = "";
        this.jlh = null;
        this.jli = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.jkZ = new com.baidu.tieba.im.util.b(this.jka);
        this.jkZ.setUniqueId(this.jka.getUniqueId());
        if (!ae.d(this.jka, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cDq();
        }
    }

    public void cDq() {
        this.jkZ.startLoad();
    }

    public void cDr() {
        if (this.jkZ != null) {
            this.jkZ.cancelLoad();
        }
    }

    private void initListener() {
        this.eUm.setOnClickListener(this.jka);
        this.jkP.setOnClickListener(this.jka);
        this.jkU.cCQ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.jkU.cCQ().addTextChangedListener(this.jka);
        this.jkV.cCK().addTextChangedListener(this.jka);
        this.jkW.cCV().setOnClickListener(this.jka);
        this.jkW.cCU().setOnClickListener(this.jka);
        this.jkX.cCz().setOnClickListener(this.jka);
        if (this.jkT != null) {
            this.jkT.cCN().setOnClickListener(this.jka);
        }
        if (this.jkS != null) {
            this.jkS.cCN().setOnClickListener(this.jka);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.jka = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.jkY = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.jkN = new CreateGroupStepAdapter(this.jka);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.jkY.setAdapter(this.jkN);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eUm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cDy();
        this.jkP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.jkP.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.jkP, R.drawable.s_navbar_button_bg);
        qr(false);
        cDz();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.jle = 1;
            this.jld = 2;
            this.jla = 3;
            this.jlb = 4;
            this.jlc = 5;
            this.jkS = new e(createGroupStepActivity, this.jle, i2);
            this.jkX = new b(createGroupStepActivity, this.jld, 1, 5);
            this.jkU = new g(createGroupStepActivity, this.jla, 2, 5);
            this.jkV = new d(createGroupStepActivity, this.jlb, 3, 5);
            this.jkW = new i(createGroupStepActivity, this.jlc, 4, 5);
            this.jkN.a(this.jkS);
            this.jkN.a(this.jkX);
            this.jkN.a(this.jkU);
            this.jkN.a(this.jkV);
            this.jkN.a(this.jkW);
            this.jke = 5;
        } else if (i == 2) {
            this.jle = 1;
            this.jla = 2;
            this.jlb = 3;
            this.jlc = 4;
            this.jld = 5;
            this.jkT = new h(createGroupStepActivity, this.jle, i3);
            this.jkU = new g(createGroupStepActivity, this.jla, 1, 5);
            this.jkV = new d(createGroupStepActivity, this.jlb, 2, 5);
            this.jkW = new i(createGroupStepActivity, this.jlc, 3, 5);
            this.jkX = new b(createGroupStepActivity, this.jld, 4, 5);
            this.jkN.a(this.jkT);
            this.jkN.a(this.jkU);
            this.jkN.a(this.jkV);
            this.jkN.a(this.jkW);
            this.jkN.a(this.jkX);
            this.jke = 5;
        } else {
            this.jla = 1;
            this.jlb = 2;
            this.jlc = 3;
            this.jld = 4;
            this.jkU = new g(createGroupStepActivity, this.jla, 1, 4);
            this.jkV = new d(createGroupStepActivity, this.jlb, 2, 4);
            this.jkW = new i(createGroupStepActivity, this.jlc, 3, 4);
            this.jkX = new b(createGroupStepActivity, this.jld, 4, 4);
            this.jkN.a(this.jkU);
            this.jkN.a(this.jkV);
            this.jkN.a(this.jkW);
            this.jkN.a(this.jkX);
            this.jke = 4;
        }
    }

    private void qr(boolean z) {
        this.cgg = z;
        cDt();
    }

    public boolean cDs() {
        return this.cgg;
    }

    private void cDt() {
        this.jkP.setEnabled(this.cgg);
        ap.setBackgroundResource(this.jkP, R.drawable.s_navbar_button_bg);
    }

    public void cDu() {
        if (this.jkO > 1) {
            this.jkO--;
            cDw();
        }
    }

    public void cDv() {
        if (this.jkO < this.jke) {
            this.jkO++;
            cDw();
        }
    }

    public void cDw() {
        this.jkY.setCurrentItem(this.jkO - 1);
        cDy();
        cDz();
        cDA();
        this.jkU.cCQ().clearFocus();
        this.jkV.cCK().clearFocus();
        e(this.jkU.cCQ());
        e(this.jkV.cCK());
        if (cDl() && cDf()) {
            cDb().setEnabled(false);
        } else {
            cDb().setEnabled(true);
        }
    }

    public void cDx() {
        String[] strArr = {this.jka.getResources().getString(R.string.take_photo), this.jka.getResources().getString(R.string.album)};
        if (this.jkQ == null) {
            this.jkQ = new com.baidu.tbadk.core.dialog.i(this.jka.getPageContext());
            this.jkQ.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.jkQ != null && j.this.jkQ.isShowing() && j.this.jka != null) {
                        j.this.jkQ.dismiss();
                    }
                    Activity pageActivity = j.this.jka.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.jka.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.jka.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.jkQ.Nv();
    }

    public void aa(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.jka.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.jka.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Kk(String str) {
        if (!this.jkP.getText().toString().equals(str)) {
            this.jkP.setText(str);
        }
    }

    private void cDy() {
        if (this.jkN.AU(this.jkO - 1) != null) {
            this.mNavigationBar.setTitleText(this.jkN.AU(this.jkO - 1).getTitle());
        }
    }

    public void cDz() {
        for (o oVar : this.jkN.getList()) {
            if (oVar.cCy() == this.jkO) {
                oVar.cCF();
                if (!oVar.cCJ()) {
                    this.jkP.setVisibility(8);
                } else {
                    this.jkP.setVisibility(0);
                }
                Kk(oVar.cCH());
            } else {
                oVar.cCE();
            }
        }
        if (this.jkN.AU(this.jkO - 1) != null && this.jkN.AU(this.jkO - 1).cCI()) {
            qr(true);
        }
    }

    public void cDA() {
        if (cDj()) {
            a(this.jkU.cCQ().getText().length(), this.jkU.vS() / 2, 2, 20);
        } else if (cDk()) {
            int vS = this.jkV.vS() / 2;
            Q(vS, 15, 300);
            int i = 300 - vS;
            this.jkV.cCL().setText(String.valueOf(i));
            if (i <= 50) {
                this.jkV.cCL().setVisibility(0);
            } else {
                this.jkV.cCL().setVisibility(8);
            }
            if (i == 0) {
                this.jkV.cCL().setTextColor(this.jka.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.jkV.AT(300);
            } else {
                this.jkV.cCM();
            }
        } else if (cDm()) {
            if (this.jkX.cCA() != 3) {
                qr(true);
            } else {
                qr(false);
            }
        }
    }

    private void Q(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            qr(true);
        } else {
            qr(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            qr(false);
        } else if (f >= i2 && f <= i3) {
            qr(true);
        } else {
            qr(false);
        }
        if (i < 1) {
            this.jkU.qp(false);
        } else {
            this.jkU.qp(true);
        }
    }

    public void setData(int i, int i2) {
        this.jkR = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.jka.getLayoutMode().setNightMode(i == 1);
        this.jka.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cDt();
        ap.setViewTextColor(this.jkP, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void e(EditText editText) {
        ((InputMethodManager) this.jka.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
