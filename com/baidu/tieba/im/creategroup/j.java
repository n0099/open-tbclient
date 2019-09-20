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
    private boolean aqG;
    private String business;
    private View cDi;
    CreateGroupStepActivity gEY;
    CreateGroupStepAdapter gFL;
    ProgressBar gFM;
    private int gFN;
    private TextView gFO;
    private com.baidu.tbadk.core.dialog.i gFP;
    int gFQ;
    e gFR;
    h gFS;
    g gFT;
    d gFU;
    i gFV;
    b gFW;
    private NoSwipeableViewPager gFX;
    private com.baidu.tieba.im.util.b gFY;
    private int gFZ;
    private int gFc;
    private int gGa;
    private int gGb;
    private int gGc;
    private int gGd;
    private boolean gGe;
    private String gGf;
    private String gGg;
    private String gGh;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    String mPortrait;
    private final WriteImagesInfo writeImagesInfo;

    public void zb(String str) {
        this.gGg = str;
    }

    public void zc(String str) {
        this.gGh = str;
    }

    public String bCB() {
        return this.gGg;
    }

    public String bCC() {
        return this.gGh;
    }

    public View bCD() {
        return this.cDi;
    }

    public int bCE() {
        return this.gFN;
    }

    public View bCF() {
        return this.gFO;
    }

    public View bCG() {
        if (this.gFR != null) {
            return this.gFR.bCq();
        }
        if (this.gFS != null) {
            return this.gFS.bCq();
        }
        return null;
    }

    public View bCH() {
        return this.gFV.bCy();
    }

    public View bCI() {
        return this.gFV.bCx();
    }

    public boolean bCJ() {
        return this.mIsLoading;
    }

    public void bCd() {
        this.gFW.bCd();
        bDe();
    }

    public void zd(String str) {
        this.gGf = str;
    }

    public String yP() {
        return this.gGf;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gFW.setBusiness(str);
        bDe();
    }

    public String getBusiness() {
        return this.business;
    }

    public void ze(String str) {
        this.gFW.setAddress(str);
        bDe();
    }

    public boolean bCK() {
        return this.gGe;
    }

    public void lY(boolean z) {
        this.gGe = z;
    }

    public void bCe() {
        this.gFW.bCe();
        bDe();
    }

    public void bCf() {
        this.gFW.bCf();
        bDe();
    }

    public View bCL() {
        return this.gFW.bCb();
    }

    public int bCc() {
        return this.gFW.bCc();
    }

    public View bCM() {
        return this.gFT.bCu();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gFT.bCt().getText().toString();
    }

    public String getIntro() {
        return this.gFU.bCm().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gFQ;
    }

    public boolean bCN() {
        return this.gFT != null && this.gFN == this.gFT.bCa();
    }

    public boolean bCO() {
        return this.gFU != null && this.gFN == this.gFU.bCa();
    }

    public boolean bCP() {
        return this.gFV != null && this.gFN == this.gFV.bCa();
    }

    public boolean bCQ() {
        return this.gFW != null && this.gFN == this.gFW.bCa();
    }

    public boolean bCR() {
        return this.gFL != null && this.gFN == this.gFL.getCount();
    }

    public String getErrMsg() {
        if (this.gFL.vq(this.gFN - 1) != null) {
            return this.gFL.vq(this.gFN - 1).getErrMsg();
        }
        return null;
    }

    public void bCS() {
        this.gFV.bCy().setText(R.string.group_create_modify_photo_tip);
    }

    public void bCT() {
        this.gFV.bCw();
    }

    public void clearText() {
        this.gFT.bCv();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.aqG = true;
        this.mIsLoading = false;
        this.gEY = null;
        this.gFL = null;
        this.gFM = null;
        this.gFN = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cDi = null;
        this.gFO = null;
        this.gFP = null;
        this.gFQ = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gFR = null;
        this.gFS = null;
        this.gFT = null;
        this.gFU = null;
        this.gFV = null;
        this.gFW = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gFX = null;
        this.gFY = null;
        this.gGe = false;
        this.gGf = "";
        this.business = "";
        this.gGg = null;
        this.gGh = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gFY = new com.baidu.tieba.im.util.b(this.gEY);
        this.gFY.setUniqueId(this.gEY.getUniqueId());
        bCU();
    }

    public void bCU() {
        this.gFY.ayo();
    }

    public void bCV() {
        if (this.gFY != null) {
            this.gFY.cancelLoad();
        }
    }

    private void initListener() {
        this.cDi.setOnClickListener(this.gEY);
        this.gFO.setOnClickListener(this.gEY);
        this.gFT.bCt().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gFT.bCt().addTextChangedListener(this.gEY);
        this.gFU.bCm().addTextChangedListener(this.gEY);
        this.gFV.bCy().setOnClickListener(this.gEY);
        this.gFV.bCx().setOnClickListener(this.gEY);
        this.gFW.bCb().setOnClickListener(this.gEY);
        if (this.gFS != null) {
            this.gFS.bCq().setOnClickListener(this.gEY);
        }
        if (this.gFR != null) {
            this.gFR.bCq().setOnClickListener(this.gEY);
        }
    }

    public void setIsLoading(boolean z) {
        this.gFM.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gEY = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.gFM = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gFX = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gFL = new CreateGroupStepAdapter(this.gEY);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gFX.setAdapter(this.gFL);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cDi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bDc();
        this.gFO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gFO.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        am.k(this.gFO, R.drawable.s_navbar_button_bg);
        lZ(false);
        bDd();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gGd = 1;
            this.gGc = 2;
            this.gFZ = 3;
            this.gGa = 4;
            this.gGb = 5;
            this.gFR = new e(createGroupStepActivity, this.gGd, i2);
            this.gFW = new b(createGroupStepActivity, this.gGc, 1, 5);
            this.gFT = new g(createGroupStepActivity, this.gFZ, 2, 5);
            this.gFU = new d(createGroupStepActivity, this.gGa, 3, 5);
            this.gFV = new i(createGroupStepActivity, this.gGb, 4, 5);
            this.gFL.a(this.gFR);
            this.gFL.a(this.gFW);
            this.gFL.a(this.gFT);
            this.gFL.a(this.gFU);
            this.gFL.a(this.gFV);
            this.gFc = 5;
        } else if (i == 2) {
            this.gGd = 1;
            this.gFZ = 2;
            this.gGa = 3;
            this.gGb = 4;
            this.gGc = 5;
            this.gFS = new h(createGroupStepActivity, this.gGd, i3);
            this.gFT = new g(createGroupStepActivity, this.gFZ, 1, 5);
            this.gFU = new d(createGroupStepActivity, this.gGa, 2, 5);
            this.gFV = new i(createGroupStepActivity, this.gGb, 3, 5);
            this.gFW = new b(createGroupStepActivity, this.gGc, 4, 5);
            this.gFL.a(this.gFS);
            this.gFL.a(this.gFT);
            this.gFL.a(this.gFU);
            this.gFL.a(this.gFV);
            this.gFL.a(this.gFW);
            this.gFc = 5;
        } else {
            this.gFZ = 1;
            this.gGa = 2;
            this.gGb = 3;
            this.gGc = 4;
            this.gFT = new g(createGroupStepActivity, this.gFZ, 1, 4);
            this.gFU = new d(createGroupStepActivity, this.gGa, 2, 4);
            this.gFV = new i(createGroupStepActivity, this.gGb, 3, 4);
            this.gFW = new b(createGroupStepActivity, this.gGc, 4, 4);
            this.gFL.a(this.gFT);
            this.gFL.a(this.gFU);
            this.gFL.a(this.gFV);
            this.gFL.a(this.gFW);
            this.gFc = 4;
        }
    }

    private void lZ(boolean z) {
        this.aqG = z;
        bCX();
    }

    public boolean bCW() {
        return this.aqG;
    }

    private void bCX() {
        this.gFO.setEnabled(this.aqG);
        am.k(this.gFO, R.drawable.s_navbar_button_bg);
    }

    public void bCY() {
        if (this.gFN > 1) {
            this.gFN--;
            bDa();
        }
    }

    public void bCZ() {
        if (this.gFN < this.gFc) {
            this.gFN++;
            bDa();
        }
    }

    public void bDa() {
        this.gFX.setCurrentItem(this.gFN - 1);
        bDc();
        bDd();
        bDe();
        this.gFT.bCt().clearFocus();
        this.gFU.bCm().clearFocus();
        g(this.gFT.bCt());
        g(this.gFU.bCm());
        if (bCP() && bCJ()) {
            bCF().setEnabled(false);
        } else {
            bCF().setEnabled(true);
        }
    }

    public void bDb() {
        String[] strArr = {this.gEY.getResources().getString(R.string.take_photo), this.gEY.getResources().getString(R.string.album)};
        if (this.gFP == null) {
            this.gFP = new com.baidu.tbadk.core.dialog.i(this.gEY.getPageContext());
            this.gFP.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gFP != null && j.this.gFP.isShowing() && j.this.gEY != null) {
                        j.this.gFP.dismiss();
                    }
                    Activity pageActivity = j.this.gEY.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    j.this.mPermissionJudgement.ake();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.ad(pageActivity)) {
                        if (i == 0) {
                            al.c(j.this.gEY.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gEY.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gFP.showDialog();
    }

    public void an(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gEY.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgement.ake();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gEY.getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void zf(String str) {
        if (!this.gFO.getText().toString().equals(str)) {
            this.gFO.setText(str);
        }
    }

    private void bDc() {
        if (this.gFL.vq(this.gFN - 1) != null) {
            this.mNavigationBar.setTitleText(this.gFL.vq(this.gFN - 1).getTitle());
        }
    }

    public void bDd() {
        for (o oVar : this.gFL.getList()) {
            if (oVar.bCa() == this.gFN) {
                oVar.bCh();
                if (!oVar.bCl()) {
                    this.gFO.setVisibility(8);
                } else {
                    this.gFO.setVisibility(0);
                }
                zf(oVar.bCj());
            } else {
                oVar.bCg();
            }
        }
        if (this.gFL.vq(this.gFN - 1) != null && this.gFL.vq(this.gFN - 1).bCk()) {
            lZ(true);
        }
    }

    public void bDe() {
        if (bCN()) {
            a(this.gFT.bCt().getText().length(), this.gFT.bCo() / 2, 2, 20);
        } else if (bCO()) {
            int bCo = this.gFU.bCo() / 2;
            X(bCo, 15, 300);
            int i = 300 - bCo;
            this.gFU.bCn().setText(String.valueOf(i));
            if (i <= 50) {
                this.gFU.bCn().setVisibility(0);
            } else {
                this.gFU.bCn().setVisibility(8);
            }
            if (i == 0) {
                this.gFU.bCn().setTextColor(this.gEY.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gFU.vp(300);
            } else {
                this.gFU.bCp();
            }
        } else if (bCQ()) {
            if (this.gFW.bCc() != 3) {
                lZ(true);
            } else {
                lZ(false);
            }
        }
    }

    private void X(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            lZ(true);
        } else {
            lZ(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            lZ(false);
        } else if (f >= i2 && f <= i3) {
            lZ(true);
        } else {
            lZ(false);
        }
        if (i < 1) {
            this.gFT.lX(false);
        } else {
            this.gFT.lX(true);
        }
    }

    public void setData(int i, int i2) {
        this.gFQ = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gEY.getLayoutMode().setNightMode(i == 1);
        this.gEY.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bCX();
        am.f(this.gFO, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.kw()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.l(viewGroup, R.color.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gEY.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
