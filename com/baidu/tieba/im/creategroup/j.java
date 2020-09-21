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
/* loaded from: classes22.dex */
public class j extends com.baidu.adp.base.c {
    private String business;
    private boolean cim;
    private View eXg;
    CreateGroupStepActivity jsK;
    private int jsO;
    private com.baidu.tbadk.core.dialog.i jtA;
    int jtB;
    e jtC;
    h jtD;
    g jtE;
    d jtF;
    i jtG;
    b jtH;
    private NoSwipeableViewPager jtI;
    private com.baidu.tieba.im.util.b jtJ;
    private int jtK;
    private int jtL;
    private int jtM;
    private int jtN;
    private int jtO;
    private boolean jtP;
    private String jtQ;
    private String jtR;
    private String jtS;
    CreateGroupStepAdapter jtx;
    private int jty;
    private TextView jtz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void KJ(String str) {
        this.jtR = str;
    }

    public void KK(String str) {
        this.jtS = str;
    }

    public String cGF() {
        return this.jtR;
    }

    public String bfN() {
        return this.jtS;
    }

    public View cGG() {
        return this.eXg;
    }

    public int cGH() {
        return this.jty;
    }

    public View cGI() {
        return this.jtz;
    }

    public View cGJ() {
        if (this.jtC != null) {
            return this.jtC.cGu();
        }
        if (this.jtD != null) {
            return this.jtD.cGu();
        }
        return null;
    }

    public View cGK() {
        return this.jtG.cGC();
    }

    public View cGL() {
        return this.jtG.cGB();
    }

    public boolean cGM() {
        return this.mIsLoading;
    }

    public void cGi() {
        this.jtH.cGi();
        cHh();
    }

    public void KL(String str) {
        this.jtQ = str;
    }

    public String afI() {
        return this.jtQ;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.jtH.setBusiness(str);
        cHh();
    }

    public String getBusiness() {
        return this.business;
    }

    public void KM(String str) {
        this.jtH.setAddress(str);
        cHh();
    }

    public boolean cGN() {
        return this.jtP;
    }

    public void qA(boolean z) {
        this.jtP = z;
    }

    public void cGj() {
        this.jtH.cGj();
        cHh();
    }

    public void cGk() {
        this.jtH.cGk();
        cHh();
    }

    public View cGO() {
        return this.jtH.cGg();
    }

    public int cGh() {
        return this.jtH.cGh();
    }

    public View cGP() {
        return this.jtE.cGy();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.jtE.cGx().getText().toString();
    }

    public String getIntro() {
        return this.jtF.cGr().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.jtB;
    }

    public boolean cGQ() {
        return this.jtE != null && this.jty == this.jtE.cGf();
    }

    public boolean cGR() {
        return this.jtF != null && this.jty == this.jtF.cGf();
    }

    public boolean cGS() {
        return this.jtG != null && this.jty == this.jtG.cGf();
    }

    public boolean cGT() {
        return this.jtH != null && this.jty == this.jtH.cGf();
    }

    public boolean cGU() {
        return this.jtx != null && this.jty == this.jtx.getCount();
    }

    public String getErrMsg() {
        if (this.jtx.Bv(this.jty - 1) != null) {
            return this.jtx.Bv(this.jty - 1).getErrMsg();
        }
        return null;
    }

    public void cGV() {
        this.jtG.cGC().setText(R.string.group_create_modify_photo_tip);
    }

    public void cGW() {
        this.jtG.cGA();
    }

    public void Lh() {
        this.jtE.cGz();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cim = true;
        this.mIsLoading = false;
        this.jsK = null;
        this.jtx = null;
        this.progressBar = null;
        this.jty = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eXg = null;
        this.jtz = null;
        this.jtA = null;
        this.jtB = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.jtC = null;
        this.jtD = null;
        this.jtE = null;
        this.jtF = null;
        this.jtG = null;
        this.jtH = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.jtI = null;
        this.jtJ = null;
        this.jtP = false;
        this.jtQ = "";
        this.business = "";
        this.jtR = null;
        this.jtS = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.jtJ = new com.baidu.tieba.im.util.b(this.jsK);
        this.jtJ.setUniqueId(this.jsK.getUniqueId());
        if (!ae.c(this.jsK, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cGX();
        }
    }

    public void cGX() {
        this.jtJ.startLoad();
    }

    public void cGY() {
        if (this.jtJ != null) {
            this.jtJ.cancelLoad();
        }
    }

    private void initListener() {
        this.eXg.setOnClickListener(this.jsK);
        this.jtz.setOnClickListener(this.jsK);
        this.jtE.cGx().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.jtE.cGx().addTextChangedListener(this.jsK);
        this.jtF.cGr().addTextChangedListener(this.jsK);
        this.jtG.cGC().setOnClickListener(this.jsK);
        this.jtG.cGB().setOnClickListener(this.jsK);
        this.jtH.cGg().setOnClickListener(this.jsK);
        if (this.jtD != null) {
            this.jtD.cGu().setOnClickListener(this.jsK);
        }
        if (this.jtC != null) {
            this.jtC.cGu().setOnClickListener(this.jsK);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.jsK = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.jtI = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.jtx = new CreateGroupStepAdapter(this.jsK);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.jtI.setAdapter(this.jtx);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cHf();
        this.jtz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.jtz.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.jtz, R.drawable.s_navbar_button_bg);
        qB(false);
        cHg();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.jtO = 1;
            this.jtN = 2;
            this.jtK = 3;
            this.jtL = 4;
            this.jtM = 5;
            this.jtC = new e(createGroupStepActivity, this.jtO, i2);
            this.jtH = new b(createGroupStepActivity, this.jtN, 1, 5);
            this.jtE = new g(createGroupStepActivity, this.jtK, 2, 5);
            this.jtF = new d(createGroupStepActivity, this.jtL, 3, 5);
            this.jtG = new i(createGroupStepActivity, this.jtM, 4, 5);
            this.jtx.a(this.jtC);
            this.jtx.a(this.jtH);
            this.jtx.a(this.jtE);
            this.jtx.a(this.jtF);
            this.jtx.a(this.jtG);
            this.jsO = 5;
        } else if (i == 2) {
            this.jtO = 1;
            this.jtK = 2;
            this.jtL = 3;
            this.jtM = 4;
            this.jtN = 5;
            this.jtD = new h(createGroupStepActivity, this.jtO, i3);
            this.jtE = new g(createGroupStepActivity, this.jtK, 1, 5);
            this.jtF = new d(createGroupStepActivity, this.jtL, 2, 5);
            this.jtG = new i(createGroupStepActivity, this.jtM, 3, 5);
            this.jtH = new b(createGroupStepActivity, this.jtN, 4, 5);
            this.jtx.a(this.jtD);
            this.jtx.a(this.jtE);
            this.jtx.a(this.jtF);
            this.jtx.a(this.jtG);
            this.jtx.a(this.jtH);
            this.jsO = 5;
        } else {
            this.jtK = 1;
            this.jtL = 2;
            this.jtM = 3;
            this.jtN = 4;
            this.jtE = new g(createGroupStepActivity, this.jtK, 1, 4);
            this.jtF = new d(createGroupStepActivity, this.jtL, 2, 4);
            this.jtG = new i(createGroupStepActivity, this.jtM, 3, 4);
            this.jtH = new b(createGroupStepActivity, this.jtN, 4, 4);
            this.jtx.a(this.jtE);
            this.jtx.a(this.jtF);
            this.jtx.a(this.jtG);
            this.jtx.a(this.jtH);
            this.jsO = 4;
        }
    }

    private void qB(boolean z) {
        this.cim = z;
        cHa();
    }

    public boolean cGZ() {
        return this.cim;
    }

    private void cHa() {
        this.jtz.setEnabled(this.cim);
        ap.setBackgroundResource(this.jtz, R.drawable.s_navbar_button_bg);
    }

    public void cHb() {
        if (this.jty > 1) {
            this.jty--;
            cHd();
        }
    }

    public void cHc() {
        if (this.jty < this.jsO) {
            this.jty++;
            cHd();
        }
    }

    public void cHd() {
        this.jtI.setCurrentItem(this.jty - 1);
        cHf();
        cHg();
        cHh();
        this.jtE.cGx().clearFocus();
        this.jtF.cGr().clearFocus();
        d(this.jtE.cGx());
        d(this.jtF.cGr());
        if (cGS() && cGM()) {
            cGI().setEnabled(false);
        } else {
            cGI().setEnabled(true);
        }
    }

    public void cHe() {
        String[] strArr = {this.jsK.getResources().getString(R.string.take_photo), this.jsK.getResources().getString(R.string.album)};
        if (this.jtA == null) {
            this.jtA = new com.baidu.tbadk.core.dialog.i(this.jsK.getPageContext());
            this.jtA.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.jtA != null && j.this.jtA.isShowing() && j.this.jsK != null) {
                        j.this.jtA.dismiss();
                    }
                    Activity pageActivity = j.this.jsK.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.jsK.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.jsK.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.jtA.NY();
    }

    public void Z(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.jsK.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.jsK.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void KN(String str) {
        if (!this.jtz.getText().toString().equals(str)) {
            this.jtz.setText(str);
        }
    }

    private void cHf() {
        if (this.jtx.Bv(this.jty - 1) != null) {
            this.mNavigationBar.setTitleText(this.jtx.Bv(this.jty - 1).getTitle());
        }
    }

    public void cHg() {
        for (o oVar : this.jtx.getList()) {
            if (oVar.cGf() == this.jty) {
                oVar.cGm();
                if (!oVar.cGq()) {
                    this.jtz.setVisibility(8);
                } else {
                    this.jtz.setVisibility(0);
                }
                KN(oVar.cGo());
            } else {
                oVar.cGl();
            }
        }
        if (this.jtx.Bv(this.jty - 1) != null && this.jtx.Bv(this.jty - 1).cGp()) {
            qB(true);
        }
    }

    public void cHh() {
        if (cGQ()) {
            a(this.jtE.cGx().getText().length(), this.jtE.wg() / 2, 2, 20);
        } else if (cGR()) {
            int wg = this.jtF.wg() / 2;
            S(wg, 15, 300);
            int i = 300 - wg;
            this.jtF.cGs().setText(String.valueOf(i));
            if (i <= 50) {
                this.jtF.cGs().setVisibility(0);
            } else {
                this.jtF.cGs().setVisibility(8);
            }
            if (i == 0) {
                this.jtF.cGs().setTextColor(this.jsK.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.jtF.Bu(300);
            } else {
                this.jtF.cGt();
            }
        } else if (cGT()) {
            if (this.jtH.cGh() != 3) {
                qB(true);
            } else {
                qB(false);
            }
        }
    }

    private void S(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            qB(true);
        } else {
            qB(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            qB(false);
        } else if (f >= i2 && f <= i3) {
            qB(true);
        } else {
            qB(false);
        }
        if (i < 1) {
            this.jtE.qz(false);
        } else {
            this.jtE.qz(true);
        }
    }

    public void setData(int i, int i2) {
        this.jtB = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.jsK.getLayoutMode().setNightMode(i == 1);
        this.jsK.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cHa();
        ap.setViewTextColor(this.jtz, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.jsK.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
