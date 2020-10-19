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
/* loaded from: classes23.dex */
public class j extends com.baidu.adp.base.c {
    private String business;
    private boolean cuF;
    private View fjs;
    CreateGroupStepActivity jHH;
    private int jHL;
    h jIA;
    g jIB;
    d jIC;
    i jID;
    b jIE;
    private NoSwipeableViewPager jIF;
    private com.baidu.tieba.im.util.b jIG;
    private int jIH;
    private int jII;
    private int jIJ;
    private int jIK;
    private int jIL;
    private boolean jIM;
    private String jIN;
    private String jIO;
    private String jIP;
    CreateGroupStepAdapter jIu;
    private int jIv;
    private TextView jIw;
    private com.baidu.tbadk.core.dialog.i jIx;
    int jIy;
    e jIz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Ly(String str) {
        this.jIO = str;
    }

    public void Lz(String str) {
        this.jIP = str;
    }

    public String cKo() {
        return this.jIO;
    }

    public String biw() {
        return this.jIP;
    }

    public View cKp() {
        return this.fjs;
    }

    public int cKq() {
        return this.jIv;
    }

    public View cKr() {
        return this.jIw;
    }

    public View cKs() {
        if (this.jIz != null) {
            return this.jIz.cKd();
        }
        if (this.jIA != null) {
            return this.jIA.cKd();
        }
        return null;
    }

    public View cKt() {
        return this.jID.cKl();
    }

    public View cKu() {
        return this.jID.cKk();
    }

    public boolean cKv() {
        return this.mIsLoading;
    }

    public void cJR() {
        this.jIE.cJR();
        cKQ();
    }

    public void LA(String str) {
        this.jIN = str;
    }

    public String ait() {
        return this.jIN;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.jIE.setBusiness(str);
        cKQ();
    }

    public String getBusiness() {
        return this.business;
    }

    public void LB(String str) {
        this.jIE.setAddress(str);
        cKQ();
    }

    public boolean cKw() {
        return this.jIM;
    }

    public void rg(boolean z) {
        this.jIM = z;
    }

    public void cJS() {
        this.jIE.cJS();
        cKQ();
    }

    public void cJT() {
        this.jIE.cJT();
        cKQ();
    }

    public View cKx() {
        return this.jIE.cJP();
    }

    public int cJQ() {
        return this.jIE.cJQ();
    }

    public View cKy() {
        return this.jIB.cKh();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.jIB.cKg().getText().toString();
    }

    public String getIntro() {
        return this.jIC.cKa().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.jIy;
    }

    public boolean cKz() {
        return this.jIB != null && this.jIv == this.jIB.cJO();
    }

    public boolean cKA() {
        return this.jIC != null && this.jIv == this.jIC.cJO();
    }

    public boolean cKB() {
        return this.jID != null && this.jIv == this.jID.cJO();
    }

    public boolean cKC() {
        return this.jIE != null && this.jIv == this.jIE.cJO();
    }

    public boolean cKD() {
        return this.jIu != null && this.jIv == this.jIu.getCount();
    }

    public String getErrMsg() {
        if (this.jIu.Cb(this.jIv - 1) != null) {
            return this.jIu.Cb(this.jIv - 1).getErrMsg();
        }
        return null;
    }

    public void cKE() {
        this.jID.cKl().setText(R.string.group_create_modify_photo_tip);
    }

    public void cKF() {
        this.jID.cKj();
    }

    public void Mm() {
        this.jIB.cKi();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cuF = true;
        this.mIsLoading = false;
        this.jHH = null;
        this.jIu = null;
        this.progressBar = null;
        this.jIv = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fjs = null;
        this.jIw = null;
        this.jIx = null;
        this.jIy = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.jIz = null;
        this.jIA = null;
        this.jIB = null;
        this.jIC = null;
        this.jID = null;
        this.jIE = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.jIF = null;
        this.jIG = null;
        this.jIM = false;
        this.jIN = "";
        this.business = "";
        this.jIO = null;
        this.jIP = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.jIG = new com.baidu.tieba.im.util.b(this.jHH);
        this.jIG.setUniqueId(this.jHH.getUniqueId());
        if (!ae.c(this.jHH, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cKG();
        }
    }

    public void cKG() {
        this.jIG.startLoad();
    }

    public void cKH() {
        if (this.jIG != null) {
            this.jIG.cancelLoad();
        }
    }

    private void initListener() {
        this.fjs.setOnClickListener(this.jHH);
        this.jIw.setOnClickListener(this.jHH);
        this.jIB.cKg().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.jIB.cKg().addTextChangedListener(this.jHH);
        this.jIC.cKa().addTextChangedListener(this.jHH);
        this.jID.cKl().setOnClickListener(this.jHH);
        this.jID.cKk().setOnClickListener(this.jHH);
        this.jIE.cJP().setOnClickListener(this.jHH);
        if (this.jIA != null) {
            this.jIA.cKd().setOnClickListener(this.jHH);
        }
        if (this.jIz != null) {
            this.jIz.cKd().setOnClickListener(this.jHH);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.jHH = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.jIF = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.jIu = new CreateGroupStepAdapter(this.jHH);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.jIF.setAdapter(this.jIu);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.fjs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cKO();
        this.jIw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.jIw.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.jIw, R.drawable.s_navbar_button_bg);
        rh(false);
        cKP();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.jIL = 1;
            this.jIK = 2;
            this.jIH = 3;
            this.jII = 4;
            this.jIJ = 5;
            this.jIz = new e(createGroupStepActivity, this.jIL, i2);
            this.jIE = new b(createGroupStepActivity, this.jIK, 1, 5);
            this.jIB = new g(createGroupStepActivity, this.jIH, 2, 5);
            this.jIC = new d(createGroupStepActivity, this.jII, 3, 5);
            this.jID = new i(createGroupStepActivity, this.jIJ, 4, 5);
            this.jIu.a(this.jIz);
            this.jIu.a(this.jIE);
            this.jIu.a(this.jIB);
            this.jIu.a(this.jIC);
            this.jIu.a(this.jID);
            this.jHL = 5;
        } else if (i == 2) {
            this.jIL = 1;
            this.jIH = 2;
            this.jII = 3;
            this.jIJ = 4;
            this.jIK = 5;
            this.jIA = new h(createGroupStepActivity, this.jIL, i3);
            this.jIB = new g(createGroupStepActivity, this.jIH, 1, 5);
            this.jIC = new d(createGroupStepActivity, this.jII, 2, 5);
            this.jID = new i(createGroupStepActivity, this.jIJ, 3, 5);
            this.jIE = new b(createGroupStepActivity, this.jIK, 4, 5);
            this.jIu.a(this.jIA);
            this.jIu.a(this.jIB);
            this.jIu.a(this.jIC);
            this.jIu.a(this.jID);
            this.jIu.a(this.jIE);
            this.jHL = 5;
        } else {
            this.jIH = 1;
            this.jII = 2;
            this.jIJ = 3;
            this.jIK = 4;
            this.jIB = new g(createGroupStepActivity, this.jIH, 1, 4);
            this.jIC = new d(createGroupStepActivity, this.jII, 2, 4);
            this.jID = new i(createGroupStepActivity, this.jIJ, 3, 4);
            this.jIE = new b(createGroupStepActivity, this.jIK, 4, 4);
            this.jIu.a(this.jIB);
            this.jIu.a(this.jIC);
            this.jIu.a(this.jID);
            this.jIu.a(this.jIE);
            this.jHL = 4;
        }
    }

    private void rh(boolean z) {
        this.cuF = z;
        cKJ();
    }

    public boolean cKI() {
        return this.cuF;
    }

    private void cKJ() {
        this.jIw.setEnabled(this.cuF);
        ap.setBackgroundResource(this.jIw, R.drawable.s_navbar_button_bg);
    }

    public void cKK() {
        if (this.jIv > 1) {
            this.jIv--;
            cKM();
        }
    }

    public void cKL() {
        if (this.jIv < this.jHL) {
            this.jIv++;
            cKM();
        }
    }

    public void cKM() {
        this.jIF.setCurrentItem(this.jIv - 1);
        cKO();
        cKP();
        cKQ();
        this.jIB.cKg().clearFocus();
        this.jIC.cKa().clearFocus();
        d(this.jIB.cKg());
        d(this.jIC.cKa());
        if (cKB() && cKv()) {
            cKr().setEnabled(false);
        } else {
            cKr().setEnabled(true);
        }
    }

    public void cKN() {
        String[] strArr = {this.jHH.getResources().getString(R.string.take_photo), this.jHH.getResources().getString(R.string.album)};
        if (this.jIx == null) {
            this.jIx = new com.baidu.tbadk.core.dialog.i(this.jHH.getPageContext());
            this.jIx.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.jIx != null && j.this.jIx.isShowing() && j.this.jHH != null) {
                        j.this.jIx.dismiss();
                    }
                    Activity pageActivity = j.this.jHH.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.jHH.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.jHH.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.jIx.Pd();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.jHH.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.jHH.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void LC(String str) {
        if (!this.jIw.getText().toString().equals(str)) {
            this.jIw.setText(str);
        }
    }

    private void cKO() {
        if (this.jIu.Cb(this.jIv - 1) != null) {
            this.mNavigationBar.setTitleText(this.jIu.Cb(this.jIv - 1).getTitle());
        }
    }

    public void cKP() {
        for (o oVar : this.jIu.getList()) {
            if (oVar.cJO() == this.jIv) {
                oVar.cJV();
                if (!oVar.cJZ()) {
                    this.jIw.setVisibility(8);
                } else {
                    this.jIw.setVisibility(0);
                }
                LC(oVar.cJX());
            } else {
                oVar.cJU();
            }
        }
        if (this.jIu.Cb(this.jIv - 1) != null && this.jIu.Cb(this.jIv - 1).cJY()) {
            rh(true);
        }
    }

    public void cKQ() {
        if (cKz()) {
            a(this.jIB.cKg().getText().length(), this.jIB.wp() / 2, 2, 20);
        } else if (cKA()) {
            int wp = this.jIC.wp() / 2;
            S(wp, 15, 300);
            int i = 300 - wp;
            this.jIC.cKb().setText(String.valueOf(i));
            if (i <= 50) {
                this.jIC.cKb().setVisibility(0);
            } else {
                this.jIC.cKb().setVisibility(8);
            }
            if (i == 0) {
                this.jIC.cKb().setTextColor(this.jHH.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.jIC.Ca(300);
            } else {
                this.jIC.cKc();
            }
        } else if (cKC()) {
            if (this.jIE.cJQ() != 3) {
                rh(true);
            } else {
                rh(false);
            }
        }
    }

    private void S(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            rh(true);
        } else {
            rh(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            rh(false);
        } else if (f >= i2 && f <= i3) {
            rh(true);
        } else {
            rh(false);
        }
        if (i < 1) {
            this.jIB.rf(false);
        } else {
            this.jIB.rf(true);
        }
    }

    public void setData(int i, int i2) {
        this.jIy = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.jHH.getLayoutMode().setNightMode(i == 1);
        this.jHH.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cKJ();
        ap.setViewTextColor(this.jIw, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.jHH.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
