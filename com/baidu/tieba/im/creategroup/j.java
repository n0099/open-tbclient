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
    CreateGroupStepAdapter iwR;
    private int iwS;
    private TextView iwT;
    private com.baidu.tbadk.core.dialog.i iwU;
    int iwV;
    e iwW;
    h iwX;
    g iwY;
    d iwZ;
    CreateGroupStepActivity iwe;
    private int iwi;
    i ixa;
    b ixb;
    private NoSwipeableViewPager ixc;
    private com.baidu.tieba.im.util.b ixd;
    private int ixe;
    private int ixf;
    private int ixg;
    private int ixh;
    private int ixi;
    private boolean ixj;
    private String ixk;
    private String ixl;
    private String ixm;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void FY(String str) {
        this.ixl = str;
    }

    public void FZ(String str) {
        this.ixm = str;
    }

    public String ckD() {
        return this.ixl;
    }

    public String aQN() {
        return this.ixm;
    }

    public View ckE() {
        return this.eun;
    }

    public int ckF() {
        return this.iwS;
    }

    public View ckG() {
        return this.iwT;
    }

    public View ckH() {
        if (this.iwW != null) {
            return this.iwW.cks();
        }
        if (this.iwX != null) {
            return this.iwX.cks();
        }
        return null;
    }

    public View ckI() {
        return this.ixa.ckA();
    }

    public View ckJ() {
        return this.ixa.ckz();
    }

    public boolean ckK() {
        return this.mIsLoading;
    }

    public void ckf() {
        this.ixb.ckf();
        clf();
    }

    public void Ga(String str) {
        this.ixk = str;
    }

    public String Xg() {
        return this.ixk;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.ixb.setBusiness(str);
        clf();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Gb(String str) {
        this.ixb.setAddress(str);
        clf();
    }

    public boolean ckL() {
        return this.ixj;
    }

    public void oU(boolean z) {
        this.ixj = z;
    }

    public void ckg() {
        this.ixb.ckg();
        clf();
    }

    public void ckh() {
        this.ixb.ckh();
        clf();
    }

    public View ckM() {
        return this.ixb.ckd();
    }

    public int cke() {
        return this.ixb.cke();
    }

    public View ckN() {
        return this.iwY.ckw();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.iwY.ckv().getText().toString();
    }

    public String getIntro() {
        return this.iwZ.cko().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.iwV;
    }

    public boolean ckO() {
        return this.iwY != null && this.iwS == this.iwY.ckc();
    }

    public boolean ckP() {
        return this.iwZ != null && this.iwS == this.iwZ.ckc();
    }

    public boolean ckQ() {
        return this.ixa != null && this.iwS == this.ixa.ckc();
    }

    public boolean ckR() {
        return this.ixb != null && this.iwS == this.ixb.ckc();
    }

    public boolean ckS() {
        return this.iwR != null && this.iwS == this.iwR.getCount();
    }

    public String getErrMsg() {
        if (this.iwR.xt(this.iwS - 1) != null) {
            return this.iwR.xt(this.iwS - 1).getErrMsg();
        }
        return null;
    }

    public void ckT() {
        this.ixa.ckA().setText(R.string.group_create_modify_photo_tip);
    }

    public void ckU() {
        this.ixa.cky();
    }

    public void El() {
        this.iwY.ckx();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bUi = true;
        this.mIsLoading = false;
        this.iwe = null;
        this.iwR = null;
        this.progressBar = null;
        this.iwS = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eun = null;
        this.iwT = null;
        this.iwU = null;
        this.iwV = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.iwW = null;
        this.iwX = null;
        this.iwY = null;
        this.iwZ = null;
        this.ixa = null;
        this.ixb = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ixc = null;
        this.ixd = null;
        this.ixj = false;
        this.ixk = "";
        this.business = "";
        this.ixl = null;
        this.ixm = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.ixd = new com.baidu.tieba.im.util.b(this.iwe);
        this.ixd.setUniqueId(this.iwe.getUniqueId());
        if (!ab.d(this.iwe, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            ckV();
        }
    }

    public void ckV() {
        this.ixd.startLoad();
    }

    public void ckW() {
        if (this.ixd != null) {
            this.ixd.cancelLoad();
        }
    }

    private void initListener() {
        this.eun.setOnClickListener(this.iwe);
        this.iwT.setOnClickListener(this.iwe);
        this.iwY.ckv().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.iwY.ckv().addTextChangedListener(this.iwe);
        this.iwZ.cko().addTextChangedListener(this.iwe);
        this.ixa.ckA().setOnClickListener(this.iwe);
        this.ixa.ckz().setOnClickListener(this.iwe);
        this.ixb.ckd().setOnClickListener(this.iwe);
        if (this.iwX != null) {
            this.iwX.cks().setOnClickListener(this.iwe);
        }
        if (this.iwW != null) {
            this.iwW.cks().setOnClickListener(this.iwe);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.iwe = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.ixc = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.iwR = new CreateGroupStepAdapter(this.iwe);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ixc.setAdapter(this.iwR);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cld();
        this.iwT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.iwT.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.iwT, R.drawable.s_navbar_button_bg);
        oV(false);
        cle();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.ixi = 1;
            this.ixh = 2;
            this.ixe = 3;
            this.ixf = 4;
            this.ixg = 5;
            this.iwW = new e(createGroupStepActivity, this.ixi, i2);
            this.ixb = new b(createGroupStepActivity, this.ixh, 1, 5);
            this.iwY = new g(createGroupStepActivity, this.ixe, 2, 5);
            this.iwZ = new d(createGroupStepActivity, this.ixf, 3, 5);
            this.ixa = new i(createGroupStepActivity, this.ixg, 4, 5);
            this.iwR.a(this.iwW);
            this.iwR.a(this.ixb);
            this.iwR.a(this.iwY);
            this.iwR.a(this.iwZ);
            this.iwR.a(this.ixa);
            this.iwi = 5;
        } else if (i == 2) {
            this.ixi = 1;
            this.ixe = 2;
            this.ixf = 3;
            this.ixg = 4;
            this.ixh = 5;
            this.iwX = new h(createGroupStepActivity, this.ixi, i3);
            this.iwY = new g(createGroupStepActivity, this.ixe, 1, 5);
            this.iwZ = new d(createGroupStepActivity, this.ixf, 2, 5);
            this.ixa = new i(createGroupStepActivity, this.ixg, 3, 5);
            this.ixb = new b(createGroupStepActivity, this.ixh, 4, 5);
            this.iwR.a(this.iwX);
            this.iwR.a(this.iwY);
            this.iwR.a(this.iwZ);
            this.iwR.a(this.ixa);
            this.iwR.a(this.ixb);
            this.iwi = 5;
        } else {
            this.ixe = 1;
            this.ixf = 2;
            this.ixg = 3;
            this.ixh = 4;
            this.iwY = new g(createGroupStepActivity, this.ixe, 1, 4);
            this.iwZ = new d(createGroupStepActivity, this.ixf, 2, 4);
            this.ixa = new i(createGroupStepActivity, this.ixg, 3, 4);
            this.ixb = new b(createGroupStepActivity, this.ixh, 4, 4);
            this.iwR.a(this.iwY);
            this.iwR.a(this.iwZ);
            this.iwR.a(this.ixa);
            this.iwR.a(this.ixb);
            this.iwi = 4;
        }
    }

    private void oV(boolean z) {
        this.bUi = z;
        ckY();
    }

    public boolean ckX() {
        return this.bUi;
    }

    private void ckY() {
        this.iwT.setEnabled(this.bUi);
        am.setBackgroundResource(this.iwT, R.drawable.s_navbar_button_bg);
    }

    public void ckZ() {
        if (this.iwS > 1) {
            this.iwS--;
            clb();
        }
    }

    public void cla() {
        if (this.iwS < this.iwi) {
            this.iwS++;
            clb();
        }
    }

    public void clb() {
        this.ixc.setCurrentItem(this.iwS - 1);
        cld();
        cle();
        clf();
        this.iwY.ckv().clearFocus();
        this.iwZ.cko().clearFocus();
        c(this.iwY.ckv());
        c(this.iwZ.cko());
        if (ckQ() && ckK()) {
            ckG().setEnabled(false);
        } else {
            ckG().setEnabled(true);
        }
    }

    public void clc() {
        String[] strArr = {this.iwe.getResources().getString(R.string.take_photo), this.iwe.getResources().getString(R.string.album)};
        if (this.iwU == null) {
            this.iwU = new com.baidu.tbadk.core.dialog.i(this.iwe.getPageContext());
            this.iwU.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.iwU != null && j.this.iwU.isShowing() && j.this.iwe != null) {
                        j.this.iwU.dismiss();
                    }
                    Activity pageActivity = j.this.iwe.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.d(j.this.iwe.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.iwe.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.iwU.showDialog();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.iwe.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.iwe.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Gc(String str) {
        if (!this.iwT.getText().toString().equals(str)) {
            this.iwT.setText(str);
        }
    }

    private void cld() {
        if (this.iwR.xt(this.iwS - 1) != null) {
            this.mNavigationBar.setTitleText(this.iwR.xt(this.iwS - 1).getTitle());
        }
    }

    public void cle() {
        for (o oVar : this.iwR.getList()) {
            if (oVar.ckc() == this.iwS) {
                oVar.ckj();
                if (!oVar.ckn()) {
                    this.iwT.setVisibility(8);
                } else {
                    this.iwT.setVisibility(0);
                }
                Gc(oVar.ckl());
            } else {
                oVar.cki();
            }
        }
        if (this.iwR.xt(this.iwS - 1) != null && this.iwR.xt(this.iwS - 1).ckm()) {
            oV(true);
        }
    }

    public void clf() {
        if (ckO()) {
            a(this.iwY.ckv().getText().length(), this.iwY.ckq() / 2, 2, 20);
        } else if (ckP()) {
            int ckq = this.iwZ.ckq() / 2;
            S(ckq, 15, 300);
            int i = 300 - ckq;
            this.iwZ.ckp().setText(String.valueOf(i));
            if (i <= 50) {
                this.iwZ.ckp().setVisibility(0);
            } else {
                this.iwZ.ckp().setVisibility(8);
            }
            if (i == 0) {
                this.iwZ.ckp().setTextColor(this.iwe.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.iwZ.xs(300);
            } else {
                this.iwZ.ckr();
            }
        } else if (ckR()) {
            if (this.ixb.cke() != 3) {
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
            this.iwY.oT(false);
        } else {
            this.iwY.oT(true);
        }
    }

    public void setData(int i, int i2) {
        this.iwV = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.iwe.getLayoutMode().setNightMode(i == 1);
        this.iwe.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ckY();
        am.setViewTextColor(this.iwT, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.iwe.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
