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
    private boolean cgk;
    private View eUq;
    CreateGroupStepAdapter jkT;
    private int jkU;
    private TextView jkV;
    private com.baidu.tbadk.core.dialog.i jkW;
    int jkX;
    e jkY;
    h jkZ;
    CreateGroupStepActivity jkg;
    private int jkk;
    g jla;
    d jlb;
    i jlc;
    b jld;
    private NoSwipeableViewPager jle;
    private com.baidu.tieba.im.util.b jlf;
    private int jlg;
    private int jlh;
    private int jli;
    private int jlj;
    private int jlk;
    private boolean jll;
    private String jlm;
    private String jln;
    private String jlo;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Kh(String str) {
        this.jln = str;
    }

    public void Ki(String str) {
        this.jlo = str;
    }

    public String cCZ() {
        return this.jln;
    }

    public String beT() {
        return this.jlo;
    }

    public View cDa() {
        return this.eUq;
    }

    public int cDb() {
        return this.jkU;
    }

    public View cDc() {
        return this.jkV;
    }

    public View cDd() {
        if (this.jkY != null) {
            return this.jkY.cCO();
        }
        if (this.jkZ != null) {
            return this.jkZ.cCO();
        }
        return null;
    }

    public View cDe() {
        return this.jlc.cCW();
    }

    public View cDf() {
        return this.jlc.cCV();
    }

    public boolean cDg() {
        return this.mIsLoading;
    }

    public void cCC() {
        this.jld.cCC();
        cDB();
    }

    public void Kj(String str) {
        this.jlm = str;
    }

    public String aeY() {
        return this.jlm;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.jld.setBusiness(str);
        cDB();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Kk(String str) {
        this.jld.setAddress(str);
        cDB();
    }

    public boolean cDh() {
        return this.jll;
    }

    public void qs(boolean z) {
        this.jll = z;
    }

    public void cCD() {
        this.jld.cCD();
        cDB();
    }

    public void cCE() {
        this.jld.cCE();
        cDB();
    }

    public View cDi() {
        return this.jld.cCA();
    }

    public int cCB() {
        return this.jld.cCB();
    }

    public View cDj() {
        return this.jla.cCS();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.jla.cCR().getText().toString();
    }

    public String getIntro() {
        return this.jlb.cCL().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.jkX;
    }

    public boolean cDk() {
        return this.jla != null && this.jkU == this.jla.cCz();
    }

    public boolean cDl() {
        return this.jlb != null && this.jkU == this.jlb.cCz();
    }

    public boolean cDm() {
        return this.jlc != null && this.jkU == this.jlc.cCz();
    }

    public boolean cDn() {
        return this.jld != null && this.jkU == this.jld.cCz();
    }

    public boolean cDo() {
        return this.jkT != null && this.jkU == this.jkT.getCount();
    }

    public String getErrMsg() {
        if (this.jkT.AU(this.jkU - 1) != null) {
            return this.jkT.AU(this.jkU - 1).getErrMsg();
        }
        return null;
    }

    public void cDp() {
        this.jlc.cCW().setText(R.string.group_create_modify_photo_tip);
    }

    public void cDq() {
        this.jlc.cCU();
    }

    public void KA() {
        this.jla.cCT();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cgk = true;
        this.mIsLoading = false;
        this.jkg = null;
        this.jkT = null;
        this.progressBar = null;
        this.jkU = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eUq = null;
        this.jkV = null;
        this.jkW = null;
        this.jkX = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.jkY = null;
        this.jkZ = null;
        this.jla = null;
        this.jlb = null;
        this.jlc = null;
        this.jld = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.jle = null;
        this.jlf = null;
        this.jll = false;
        this.jlm = "";
        this.business = "";
        this.jln = null;
        this.jlo = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.jlf = new com.baidu.tieba.im.util.b(this.jkg);
        this.jlf.setUniqueId(this.jkg.getUniqueId());
        if (!ae.d(this.jkg, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cDr();
        }
    }

    public void cDr() {
        this.jlf.startLoad();
    }

    public void cDs() {
        if (this.jlf != null) {
            this.jlf.cancelLoad();
        }
    }

    private void initListener() {
        this.eUq.setOnClickListener(this.jkg);
        this.jkV.setOnClickListener(this.jkg);
        this.jla.cCR().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.jla.cCR().addTextChangedListener(this.jkg);
        this.jlb.cCL().addTextChangedListener(this.jkg);
        this.jlc.cCW().setOnClickListener(this.jkg);
        this.jlc.cCV().setOnClickListener(this.jkg);
        this.jld.cCA().setOnClickListener(this.jkg);
        if (this.jkZ != null) {
            this.jkZ.cCO().setOnClickListener(this.jkg);
        }
        if (this.jkY != null) {
            this.jkY.cCO().setOnClickListener(this.jkg);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.jkg = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.jle = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.jkT = new CreateGroupStepAdapter(this.jkg);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.jle.setAdapter(this.jkT);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eUq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cDz();
        this.jkV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.jkV.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.jkV, R.drawable.s_navbar_button_bg);
        qt(false);
        cDA();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.jlk = 1;
            this.jlj = 2;
            this.jlg = 3;
            this.jlh = 4;
            this.jli = 5;
            this.jkY = new e(createGroupStepActivity, this.jlk, i2);
            this.jld = new b(createGroupStepActivity, this.jlj, 1, 5);
            this.jla = new g(createGroupStepActivity, this.jlg, 2, 5);
            this.jlb = new d(createGroupStepActivity, this.jlh, 3, 5);
            this.jlc = new i(createGroupStepActivity, this.jli, 4, 5);
            this.jkT.a(this.jkY);
            this.jkT.a(this.jld);
            this.jkT.a(this.jla);
            this.jkT.a(this.jlb);
            this.jkT.a(this.jlc);
            this.jkk = 5;
        } else if (i == 2) {
            this.jlk = 1;
            this.jlg = 2;
            this.jlh = 3;
            this.jli = 4;
            this.jlj = 5;
            this.jkZ = new h(createGroupStepActivity, this.jlk, i3);
            this.jla = new g(createGroupStepActivity, this.jlg, 1, 5);
            this.jlb = new d(createGroupStepActivity, this.jlh, 2, 5);
            this.jlc = new i(createGroupStepActivity, this.jli, 3, 5);
            this.jld = new b(createGroupStepActivity, this.jlj, 4, 5);
            this.jkT.a(this.jkZ);
            this.jkT.a(this.jla);
            this.jkT.a(this.jlb);
            this.jkT.a(this.jlc);
            this.jkT.a(this.jld);
            this.jkk = 5;
        } else {
            this.jlg = 1;
            this.jlh = 2;
            this.jli = 3;
            this.jlj = 4;
            this.jla = new g(createGroupStepActivity, this.jlg, 1, 4);
            this.jlb = new d(createGroupStepActivity, this.jlh, 2, 4);
            this.jlc = new i(createGroupStepActivity, this.jli, 3, 4);
            this.jld = new b(createGroupStepActivity, this.jlj, 4, 4);
            this.jkT.a(this.jla);
            this.jkT.a(this.jlb);
            this.jkT.a(this.jlc);
            this.jkT.a(this.jld);
            this.jkk = 4;
        }
    }

    private void qt(boolean z) {
        this.cgk = z;
        cDu();
    }

    public boolean cDt() {
        return this.cgk;
    }

    private void cDu() {
        this.jkV.setEnabled(this.cgk);
        ap.setBackgroundResource(this.jkV, R.drawable.s_navbar_button_bg);
    }

    public void cDv() {
        if (this.jkU > 1) {
            this.jkU--;
            cDx();
        }
    }

    public void cDw() {
        if (this.jkU < this.jkk) {
            this.jkU++;
            cDx();
        }
    }

    public void cDx() {
        this.jle.setCurrentItem(this.jkU - 1);
        cDz();
        cDA();
        cDB();
        this.jla.cCR().clearFocus();
        this.jlb.cCL().clearFocus();
        e(this.jla.cCR());
        e(this.jlb.cCL());
        if (cDm() && cDg()) {
            cDc().setEnabled(false);
        } else {
            cDc().setEnabled(true);
        }
    }

    public void cDy() {
        String[] strArr = {this.jkg.getResources().getString(R.string.take_photo), this.jkg.getResources().getString(R.string.album)};
        if (this.jkW == null) {
            this.jkW = new com.baidu.tbadk.core.dialog.i(this.jkg.getPageContext());
            this.jkW.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.jkW != null && j.this.jkW.isShowing() && j.this.jkg != null) {
                        j.this.jkW.dismiss();
                    }
                    Activity pageActivity = j.this.jkg.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.jkg.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.jkg.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.jkW.Nv();
    }

    public void aa(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.jkg.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.jkg.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Kl(String str) {
        if (!this.jkV.getText().toString().equals(str)) {
            this.jkV.setText(str);
        }
    }

    private void cDz() {
        if (this.jkT.AU(this.jkU - 1) != null) {
            this.mNavigationBar.setTitleText(this.jkT.AU(this.jkU - 1).getTitle());
        }
    }

    public void cDA() {
        for (o oVar : this.jkT.getList()) {
            if (oVar.cCz() == this.jkU) {
                oVar.cCG();
                if (!oVar.cCK()) {
                    this.jkV.setVisibility(8);
                } else {
                    this.jkV.setVisibility(0);
                }
                Kl(oVar.cCI());
            } else {
                oVar.cCF();
            }
        }
        if (this.jkT.AU(this.jkU - 1) != null && this.jkT.AU(this.jkU - 1).cCJ()) {
            qt(true);
        }
    }

    public void cDB() {
        if (cDk()) {
            a(this.jla.cCR().getText().length(), this.jla.vS() / 2, 2, 20);
        } else if (cDl()) {
            int vS = this.jlb.vS() / 2;
            Q(vS, 15, 300);
            int i = 300 - vS;
            this.jlb.cCM().setText(String.valueOf(i));
            if (i <= 50) {
                this.jlb.cCM().setVisibility(0);
            } else {
                this.jlb.cCM().setVisibility(8);
            }
            if (i == 0) {
                this.jlb.cCM().setTextColor(this.jkg.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.jlb.AT(300);
            } else {
                this.jlb.cCN();
            }
        } else if (cDn()) {
            if (this.jld.cCB() != 3) {
                qt(true);
            } else {
                qt(false);
            }
        }
    }

    private void Q(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            qt(true);
        } else {
            qt(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            qt(false);
        } else if (f >= i2 && f <= i3) {
            qt(true);
        } else {
            qt(false);
        }
        if (i < 1) {
            this.jla.qr(false);
        } else {
            this.jla.qr(true);
        }
    }

    public void setData(int i, int i2) {
        this.jkX = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.jkg.getLayoutMode().setNightMode(i == 1);
        this.jkg.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cDu();
        ap.setViewTextColor(this.jkV, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void e(EditText editText) {
        ((InputMethodManager) this.jkg.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
