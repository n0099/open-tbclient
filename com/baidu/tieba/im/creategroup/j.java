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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c {
    private boolean bYW;
    private String business;
    private View eDr;
    CreateGroupStepActivity iNW;
    CreateGroupStepAdapter iOJ;
    private int iOK;
    private TextView iOL;
    private com.baidu.tbadk.core.dialog.i iOM;
    int iON;
    e iOO;
    h iOP;
    g iOQ;
    d iOR;
    i iOS;
    b iOT;
    private NoSwipeableViewPager iOU;
    private com.baidu.tieba.im.util.b iOV;
    private int iOW;
    private int iOX;
    private int iOY;
    private int iOZ;
    private int iOa;
    private int iPa;
    private boolean iPb;
    private String iPc;
    private String iPd;
    private String iPe;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void GA(String str) {
        this.iPd = str;
    }

    public void GB(String str) {
        this.iPe = str;
    }

    public String coB() {
        return this.iPd;
    }

    public String aSE() {
        return this.iPe;
    }

    public View coC() {
        return this.eDr;
    }

    public int coD() {
        return this.iOK;
    }

    public View coE() {
        return this.iOL;
    }

    public View coF() {
        if (this.iOO != null) {
            return this.iOO.coq();
        }
        if (this.iOP != null) {
            return this.iOP.coq();
        }
        return null;
    }

    public View coG() {
        return this.iOS.coy();
    }

    public View coH() {
        return this.iOS.cox();
    }

    public boolean coI() {
        return this.mIsLoading;
    }

    public void cod() {
        this.iOT.cod();
        cpd();
    }

    public void GC(String str) {
        this.iPc = str;
    }

    public String Ym() {
        return this.iPc;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.iOT.setBusiness(str);
        cpd();
    }

    public String getBusiness() {
        return this.business;
    }

    public void GD(String str) {
        this.iOT.setAddress(str);
        cpd();
    }

    public boolean coJ() {
        return this.iPb;
    }

    public void pe(boolean z) {
        this.iPb = z;
    }

    public void coe() {
        this.iOT.coe();
        cpd();
    }

    public void cof() {
        this.iOT.cof();
        cpd();
    }

    public View coK() {
        return this.iOT.cob();
    }

    public int coc() {
        return this.iOT.coc();
    }

    public View coL() {
        return this.iOQ.cou();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.iOQ.cot().getText().toString();
    }

    public String getIntro() {
        return this.iOR.com().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.iON;
    }

    public boolean coM() {
        return this.iOQ != null && this.iOK == this.iOQ.coa();
    }

    public boolean coN() {
        return this.iOR != null && this.iOK == this.iOR.coa();
    }

    public boolean coO() {
        return this.iOS != null && this.iOK == this.iOS.coa();
    }

    public boolean coP() {
        return this.iOT != null && this.iOK == this.iOT.coa();
    }

    public boolean coQ() {
        return this.iOJ != null && this.iOK == this.iOJ.getCount();
    }

    public String getErrMsg() {
        if (this.iOJ.yf(this.iOK - 1) != null) {
            return this.iOJ.yf(this.iOK - 1).getErrMsg();
        }
        return null;
    }

    public void coR() {
        this.iOS.coy().setText(R.string.group_create_modify_photo_tip);
    }

    public void coS() {
        this.iOS.cow();
    }

    public void EO() {
        this.iOQ.cov();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bYW = true;
        this.mIsLoading = false;
        this.iNW = null;
        this.iOJ = null;
        this.progressBar = null;
        this.iOK = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eDr = null;
        this.iOL = null;
        this.iOM = null;
        this.iON = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.iOO = null;
        this.iOP = null;
        this.iOQ = null;
        this.iOR = null;
        this.iOS = null;
        this.iOT = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.iOU = null;
        this.iOV = null;
        this.iPb = false;
        this.iPc = "";
        this.business = "";
        this.iPd = null;
        this.iPe = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.iOV = new com.baidu.tieba.im.util.b(this.iNW);
        this.iOV.setUniqueId(this.iNW.getUniqueId());
        if (!ac.d(this.iNW, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            coT();
        }
    }

    public void coT() {
        this.iOV.startLoad();
    }

    public void coU() {
        if (this.iOV != null) {
            this.iOV.cancelLoad();
        }
    }

    private void initListener() {
        this.eDr.setOnClickListener(this.iNW);
        this.iOL.setOnClickListener(this.iNW);
        this.iOQ.cot().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.iOQ.cot().addTextChangedListener(this.iNW);
        this.iOR.com().addTextChangedListener(this.iNW);
        this.iOS.coy().setOnClickListener(this.iNW);
        this.iOS.cox().setOnClickListener(this.iNW);
        this.iOT.cob().setOnClickListener(this.iNW);
        if (this.iOP != null) {
            this.iOP.coq().setOnClickListener(this.iNW);
        }
        if (this.iOO != null) {
            this.iOO.coq().setOnClickListener(this.iNW);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.iNW = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.iOU = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.iOJ = new CreateGroupStepAdapter(this.iNW);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.iOU.setAdapter(this.iOJ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.eDr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cpb();
        this.iOL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.iOL.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        an.setBackgroundResource(this.iOL, R.drawable.s_navbar_button_bg);
        pf(false);
        cpc();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.iPa = 1;
            this.iOZ = 2;
            this.iOW = 3;
            this.iOX = 4;
            this.iOY = 5;
            this.iOO = new e(createGroupStepActivity, this.iPa, i2);
            this.iOT = new b(createGroupStepActivity, this.iOZ, 1, 5);
            this.iOQ = new g(createGroupStepActivity, this.iOW, 2, 5);
            this.iOR = new d(createGroupStepActivity, this.iOX, 3, 5);
            this.iOS = new i(createGroupStepActivity, this.iOY, 4, 5);
            this.iOJ.a(this.iOO);
            this.iOJ.a(this.iOT);
            this.iOJ.a(this.iOQ);
            this.iOJ.a(this.iOR);
            this.iOJ.a(this.iOS);
            this.iOa = 5;
        } else if (i == 2) {
            this.iPa = 1;
            this.iOW = 2;
            this.iOX = 3;
            this.iOY = 4;
            this.iOZ = 5;
            this.iOP = new h(createGroupStepActivity, this.iPa, i3);
            this.iOQ = new g(createGroupStepActivity, this.iOW, 1, 5);
            this.iOR = new d(createGroupStepActivity, this.iOX, 2, 5);
            this.iOS = new i(createGroupStepActivity, this.iOY, 3, 5);
            this.iOT = new b(createGroupStepActivity, this.iOZ, 4, 5);
            this.iOJ.a(this.iOP);
            this.iOJ.a(this.iOQ);
            this.iOJ.a(this.iOR);
            this.iOJ.a(this.iOS);
            this.iOJ.a(this.iOT);
            this.iOa = 5;
        } else {
            this.iOW = 1;
            this.iOX = 2;
            this.iOY = 3;
            this.iOZ = 4;
            this.iOQ = new g(createGroupStepActivity, this.iOW, 1, 4);
            this.iOR = new d(createGroupStepActivity, this.iOX, 2, 4);
            this.iOS = new i(createGroupStepActivity, this.iOY, 3, 4);
            this.iOT = new b(createGroupStepActivity, this.iOZ, 4, 4);
            this.iOJ.a(this.iOQ);
            this.iOJ.a(this.iOR);
            this.iOJ.a(this.iOS);
            this.iOJ.a(this.iOT);
            this.iOa = 4;
        }
    }

    private void pf(boolean z) {
        this.bYW = z;
        coW();
    }

    public boolean coV() {
        return this.bYW;
    }

    private void coW() {
        this.iOL.setEnabled(this.bYW);
        an.setBackgroundResource(this.iOL, R.drawable.s_navbar_button_bg);
    }

    public void coX() {
        if (this.iOK > 1) {
            this.iOK--;
            coZ();
        }
    }

    public void coY() {
        if (this.iOK < this.iOa) {
            this.iOK++;
            coZ();
        }
    }

    public void coZ() {
        this.iOU.setCurrentItem(this.iOK - 1);
        cpb();
        cpc();
        cpd();
        this.iOQ.cot().clearFocus();
        this.iOR.com().clearFocus();
        d(this.iOQ.cot());
        d(this.iOR.com());
        if (coO() && coI()) {
            coE().setEnabled(false);
        } else {
            coE().setEnabled(true);
        }
    }

    public void cpa() {
        String[] strArr = {this.iNW.getResources().getString(R.string.take_photo), this.iNW.getResources().getString(R.string.album)};
        if (this.iOM == null) {
            this.iOM = new com.baidu.tbadk.core.dialog.i(this.iNW.getPageContext());
            this.iOM.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.iOM != null && j.this.iOM.isShowing() && j.this.iNW != null) {
                        j.this.iOM.dismiss();
                    }
                    Activity pageActivity = j.this.iNW.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            am.g(j.this.iNW.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.iNW.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.iOM.showDialog();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.iNW.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.iNW.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void GE(String str) {
        if (!this.iOL.getText().toString().equals(str)) {
            this.iOL.setText(str);
        }
    }

    private void cpb() {
        if (this.iOJ.yf(this.iOK - 1) != null) {
            this.mNavigationBar.setTitleText(this.iOJ.yf(this.iOK - 1).getTitle());
        }
    }

    public void cpc() {
        for (o oVar : this.iOJ.getList()) {
            if (oVar.coa() == this.iOK) {
                oVar.coh();
                if (!oVar.col()) {
                    this.iOL.setVisibility(8);
                } else {
                    this.iOL.setVisibility(0);
                }
                GE(oVar.coj());
            } else {
                oVar.cog();
            }
        }
        if (this.iOJ.yf(this.iOK - 1) != null && this.iOJ.yf(this.iOK - 1).cok()) {
            pf(true);
        }
    }

    public void cpd() {
        if (coM()) {
            a(this.iOQ.cot().getText().length(), this.iOQ.coo() / 2, 2, 20);
        } else if (coN()) {
            int coo = this.iOR.coo() / 2;
            S(coo, 15, 300);
            int i = 300 - coo;
            this.iOR.con().setText(String.valueOf(i));
            if (i <= 50) {
                this.iOR.con().setVisibility(0);
            } else {
                this.iOR.con().setVisibility(8);
            }
            if (i == 0) {
                this.iOR.con().setTextColor(this.iNW.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.iOR.ye(300);
            } else {
                this.iOR.cop();
            }
        } else if (coP()) {
            if (this.iOT.coc() != 3) {
                pf(true);
            } else {
                pf(false);
            }
        }
    }

    private void S(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            pf(true);
        } else {
            pf(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            pf(false);
        } else if (f >= i2 && f <= i3) {
            pf(true);
        } else {
            pf(false);
        }
        if (i < 1) {
            this.iOQ.pd(false);
        } else {
            this.iOQ.pd(true);
        }
    }

    public void setData(int i, int i2) {
        this.iON = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.iNW.getLayoutMode().setNightMode(i == 1);
        this.iNW.getLayoutMode().onModeChanged(this.mParent);
        an.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        coW();
        an.setViewTextColor(this.iOL, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        an.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.iNW.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
