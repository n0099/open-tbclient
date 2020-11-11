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
    private boolean cIU;
    private View fxJ;
    CreateGroupStepAdapter kaQ;
    private int kaR;
    private TextView kaS;
    private com.baidu.tbadk.core.dialog.i kaT;
    int kaU;
    e kaV;
    h kaW;
    g kaX;
    d kaY;
    i kaZ;
    CreateGroupStepActivity kac;
    private int kag;
    b kba;
    private NoSwipeableViewPager kbb;
    private com.baidu.tieba.im.util.b kbc;
    private int kbd;
    private int kbe;
    private int kbf;
    private int kbg;
    private int kbh;
    private boolean kbi;
    private String kbj;
    private String kbk;
    private String kbl;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Mn(String str) {
        this.kbk = str;
    }

    public void Mo(String str) {
        this.kbl = str;
    }

    public String cPW() {
        return this.kbk;
    }

    public String bmP() {
        return this.kbl;
    }

    public View cPX() {
        return this.fxJ;
    }

    public int cPY() {
        return this.kaR;
    }

    public View cPZ() {
        return this.kaS;
    }

    public View cQa() {
        if (this.kaV != null) {
            return this.kaV.cPL();
        }
        if (this.kaW != null) {
            return this.kaW.cPL();
        }
        return null;
    }

    public View cQb() {
        return this.kaZ.cPT();
    }

    public View cQc() {
        return this.kaZ.cPS();
    }

    public boolean cQd() {
        return this.mIsLoading;
    }

    public void cPz() {
        this.kba.cPz();
        cQy();
    }

    public void Mp(String str) {
        this.kbj = str;
    }

    public String amN() {
        return this.kbj;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.kba.setBusiness(str);
        cQy();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Mq(String str) {
        this.kba.setAddress(str);
        cQy();
    }

    public boolean cQe() {
        return this.kbi;
    }

    public void rH(boolean z) {
        this.kbi = z;
    }

    public void cPA() {
        this.kba.cPA();
        cQy();
    }

    public void cPB() {
        this.kba.cPB();
        cQy();
    }

    public View cQf() {
        return this.kba.cPx();
    }

    public int cPy() {
        return this.kba.cPy();
    }

    public View cQg() {
        return this.kaX.cPP();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.kaX.cPO().getText().toString();
    }

    public String getIntro() {
        return this.kaY.cPI().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.kaU;
    }

    public boolean cQh() {
        return this.kaX != null && this.kaR == this.kaX.cPw();
    }

    public boolean cQi() {
        return this.kaY != null && this.kaR == this.kaY.cPw();
    }

    public boolean cQj() {
        return this.kaZ != null && this.kaR == this.kaZ.cPw();
    }

    public boolean cQk() {
        return this.kba != null && this.kaR == this.kba.cPw();
    }

    public boolean cQl() {
        return this.kaQ != null && this.kaR == this.kaQ.getCount();
    }

    public String getErrMsg() {
        if (this.kaQ.CH(this.kaR - 1) != null) {
            return this.kaQ.CH(this.kaR - 1).getErrMsg();
        }
        return null;
    }

    public void cQm() {
        this.kaZ.cPT().setText(R.string.group_create_modify_photo_tip);
    }

    public void cQn() {
        this.kaZ.cPR();
    }

    public void Ng() {
        this.kaX.cPQ();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.cIU = true;
        this.mIsLoading = false;
        this.kac = null;
        this.kaQ = null;
        this.progressBar = null;
        this.kaR = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fxJ = null;
        this.kaS = null;
        this.kaT = null;
        this.kaU = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.kaV = null;
        this.kaW = null;
        this.kaX = null;
        this.kaY = null;
        this.kaZ = null;
        this.kba = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.kbb = null;
        this.kbc = null;
        this.kbi = false;
        this.kbj = "";
        this.business = "";
        this.kbk = null;
        this.kbl = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.kbc = new com.baidu.tieba.im.util.b(this.kac);
        this.kbc.setUniqueId(this.kac.getUniqueId());
        if (!ae.c(this.kac, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cQo();
        }
    }

    public void cQo() {
        this.kbc.startLoad();
    }

    public void cQp() {
        if (this.kbc != null) {
            this.kbc.cancelLoad();
        }
    }

    private void initListener() {
        this.fxJ.setOnClickListener(this.kac);
        this.kaS.setOnClickListener(this.kac);
        this.kaX.cPO().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.kaX.cPO().addTextChangedListener(this.kac);
        this.kaY.cPI().addTextChangedListener(this.kac);
        this.kaZ.cPT().setOnClickListener(this.kac);
        this.kaZ.cPS().setOnClickListener(this.kac);
        this.kba.cPx().setOnClickListener(this.kac);
        if (this.kaW != null) {
            this.kaW.cPL().setOnClickListener(this.kac);
        }
        if (this.kaV != null) {
            this.kaV.cPL().setOnClickListener(this.kac);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.kac = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.kbb = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.kaQ = new CreateGroupStepAdapter(this.kac);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.kbb.setAdapter(this.kaQ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cQw();
        this.kaS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.kaS.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.kaS, R.drawable.s_navbar_button_bg);
        rI(false);
        cQx();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.kbh = 1;
            this.kbg = 2;
            this.kbd = 3;
            this.kbe = 4;
            this.kbf = 5;
            this.kaV = new e(createGroupStepActivity, this.kbh, i2);
            this.kba = new b(createGroupStepActivity, this.kbg, 1, 5);
            this.kaX = new g(createGroupStepActivity, this.kbd, 2, 5);
            this.kaY = new d(createGroupStepActivity, this.kbe, 3, 5);
            this.kaZ = new i(createGroupStepActivity, this.kbf, 4, 5);
            this.kaQ.a(this.kaV);
            this.kaQ.a(this.kba);
            this.kaQ.a(this.kaX);
            this.kaQ.a(this.kaY);
            this.kaQ.a(this.kaZ);
            this.kag = 5;
        } else if (i == 2) {
            this.kbh = 1;
            this.kbd = 2;
            this.kbe = 3;
            this.kbf = 4;
            this.kbg = 5;
            this.kaW = new h(createGroupStepActivity, this.kbh, i3);
            this.kaX = new g(createGroupStepActivity, this.kbd, 1, 5);
            this.kaY = new d(createGroupStepActivity, this.kbe, 2, 5);
            this.kaZ = new i(createGroupStepActivity, this.kbf, 3, 5);
            this.kba = new b(createGroupStepActivity, this.kbg, 4, 5);
            this.kaQ.a(this.kaW);
            this.kaQ.a(this.kaX);
            this.kaQ.a(this.kaY);
            this.kaQ.a(this.kaZ);
            this.kaQ.a(this.kba);
            this.kag = 5;
        } else {
            this.kbd = 1;
            this.kbe = 2;
            this.kbf = 3;
            this.kbg = 4;
            this.kaX = new g(createGroupStepActivity, this.kbd, 1, 4);
            this.kaY = new d(createGroupStepActivity, this.kbe, 2, 4);
            this.kaZ = new i(createGroupStepActivity, this.kbf, 3, 4);
            this.kba = new b(createGroupStepActivity, this.kbg, 4, 4);
            this.kaQ.a(this.kaX);
            this.kaQ.a(this.kaY);
            this.kaQ.a(this.kaZ);
            this.kaQ.a(this.kba);
            this.kag = 4;
        }
    }

    private void rI(boolean z) {
        this.cIU = z;
        cQr();
    }

    public boolean cQq() {
        return this.cIU;
    }

    private void cQr() {
        this.kaS.setEnabled(this.cIU);
        ap.setBackgroundResource(this.kaS, R.drawable.s_navbar_button_bg);
    }

    public void cQs() {
        if (this.kaR > 1) {
            this.kaR--;
            cQu();
        }
    }

    public void cQt() {
        if (this.kaR < this.kag) {
            this.kaR++;
            cQu();
        }
    }

    public void cQu() {
        this.kbb.setCurrentItem(this.kaR - 1);
        cQw();
        cQx();
        cQy();
        this.kaX.cPO().clearFocus();
        this.kaY.cPI().clearFocus();
        d(this.kaX.cPO());
        d(this.kaY.cPI());
        if (cQj() && cQd()) {
            cPZ().setEnabled(false);
        } else {
            cPZ().setEnabled(true);
        }
    }

    public void cQv() {
        String[] strArr = {this.kac.getResources().getString(R.string.take_photo), this.kac.getResources().getString(R.string.album)};
        if (this.kaT == null) {
            this.kaT = new com.baidu.tbadk.core.dialog.i(this.kac.getPageContext());
            this.kaT.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.kaT != null && j.this.kaT.isShowing() && j.this.kac != null) {
                        j.this.kaT.dismiss();
                    }
                    Activity pageActivity = j.this.kac.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.kac.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.kac.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.kaT.Qj();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.kac.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.kac.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Mr(String str) {
        if (!this.kaS.getText().toString().equals(str)) {
            this.kaS.setText(str);
        }
    }

    private void cQw() {
        if (this.kaQ.CH(this.kaR - 1) != null) {
            this.mNavigationBar.setTitleText(this.kaQ.CH(this.kaR - 1).getTitle());
        }
    }

    public void cQx() {
        for (o oVar : this.kaQ.getList()) {
            if (oVar.cPw() == this.kaR) {
                oVar.cPD();
                if (!oVar.cPH()) {
                    this.kaS.setVisibility(8);
                } else {
                    this.kaS.setVisibility(0);
                }
                Mr(oVar.cPF());
            } else {
                oVar.cPC();
            }
        }
        if (this.kaQ.CH(this.kaR - 1) != null && this.kaQ.CH(this.kaR - 1).cPG()) {
            rI(true);
        }
    }

    public void cQy() {
        if (cQh()) {
            a(this.kaX.cPO().getText().length(), this.kaX.wp() / 2, 2, 20);
        } else if (cQi()) {
            int wp = this.kaY.wp() / 2;
            T(wp, 15, 300);
            int i = 300 - wp;
            this.kaY.cPJ().setText(String.valueOf(i));
            if (i <= 50) {
                this.kaY.cPJ().setVisibility(0);
            } else {
                this.kaY.cPJ().setVisibility(8);
            }
            if (i == 0) {
                this.kaY.cPJ().setTextColor(this.kac.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.kaY.CG(300);
            } else {
                this.kaY.cPK();
            }
        } else if (cQk()) {
            if (this.kba.cPy() != 3) {
                rI(true);
            } else {
                rI(false);
            }
        }
    }

    private void T(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            rI(true);
        } else {
            rI(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            rI(false);
        } else if (f >= i2 && f <= i3) {
            rI(true);
        } else {
            rI(false);
        }
        if (i < 1) {
            this.kaX.rG(false);
        } else {
            this.kaX.rG(true);
        }
    }

    public void setData(int i, int i2) {
        this.kaU = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.kac.getLayoutMode().setNightMode(i == 1);
        this.kac.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cQr();
        ap.setViewTextColor(this.kaS, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.kac.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
