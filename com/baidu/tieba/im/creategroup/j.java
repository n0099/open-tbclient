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
    private View fEN;
    CreateGroupStepActivity kot;
    private int kox;
    private String kpA;
    private String kpB;
    CreateGroupStepAdapter kpg;
    private int kph;
    private TextView kpi;
    private com.baidu.tbadk.core.dialog.i kpj;
    int kpk;
    e kpl;
    h kpm;
    g kpn;
    d kpo;
    i kpp;
    b kpq;
    private NoSwipeableViewPager kpr;
    private com.baidu.tieba.im.util.b kps;
    private int kpt;
    private int kpu;
    private int kpv;
    private int kpw;
    private int kpx;
    private boolean kpy;
    private String kpz;
    int mForumId;
    private boolean mIsEnabled;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void MW(String str) {
        this.kpA = str;
    }

    public void MX(String str) {
        this.kpB = str;
    }

    public String cUR() {
        return this.kpA;
    }

    public String bpe() {
        return this.kpB;
    }

    public View cUS() {
        return this.fEN;
    }

    public int cUT() {
        return this.kph;
    }

    public View cUU() {
        return this.kpi;
    }

    public View cUV() {
        if (this.kpl != null) {
            return this.kpl.cUG();
        }
        if (this.kpm != null) {
            return this.kpm.cUG();
        }
        return null;
    }

    public View cUW() {
        return this.kpp.cUO();
    }

    public View cUX() {
        return this.kpp.cUN();
    }

    public boolean cUY() {
        return this.mIsLoading;
    }

    public void cUu() {
        this.kpq.cUu();
        cVt();
    }

    public void MY(String str) {
        this.kpz = str;
    }

    public String apo() {
        return this.kpz;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.kpq.setBusiness(str);
        cVt();
    }

    public String getBusiness() {
        return this.business;
    }

    public void MZ(String str) {
        this.kpq.setAddress(str);
        cVt();
    }

    public boolean cUZ() {
        return this.kpy;
    }

    public void sm(boolean z) {
        this.kpy = z;
    }

    public void cUv() {
        this.kpq.cUv();
        cVt();
    }

    public void cUw() {
        this.kpq.cUw();
        cVt();
    }

    public View cVa() {
        return this.kpq.cUs();
    }

    public int cUt() {
        return this.kpq.cUt();
    }

    public View cVb() {
        return this.kpn.cUK();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.kpn.cUJ().getText().toString();
    }

    public String getIntro() {
        return this.kpo.cUD().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.kpk;
    }

    public boolean cVc() {
        return this.kpn != null && this.kph == this.kpn.cUr();
    }

    public boolean cVd() {
        return this.kpo != null && this.kph == this.kpo.cUr();
    }

    public boolean cVe() {
        return this.kpp != null && this.kph == this.kpp.cUr();
    }

    public boolean cVf() {
        return this.kpq != null && this.kph == this.kpq.cUr();
    }

    public boolean cVg() {
        return this.kpg != null && this.kph == this.kpg.getCount();
    }

    public String getErrMsg() {
        if (this.kpg.DU(this.kph - 1) != null) {
            return this.kpg.DU(this.kph - 1).getErrMsg();
        }
        return null;
    }

    public void cVh() {
        this.kpp.cUO().setText(R.string.group_create_modify_photo_tip);
    }

    public void cVi() {
        this.kpp.cUM();
    }

    public void OS() {
        this.kpn.cUL();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.mIsEnabled = true;
        this.mIsLoading = false;
        this.kot = null;
        this.kpg = null;
        this.progressBar = null;
        this.kph = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fEN = null;
        this.kpi = null;
        this.kpj = null;
        this.kpk = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.kpl = null;
        this.kpm = null;
        this.kpn = null;
        this.kpo = null;
        this.kpp = null;
        this.kpq = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.kpr = null;
        this.kps = null;
        this.kpy = false;
        this.kpz = "";
        this.business = "";
        this.kpA = null;
        this.kpB = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.kps = new com.baidu.tieba.im.util.b(this.kot);
        this.kps.setUniqueId(this.kot.getUniqueId());
        if (!ae.c(this.kot, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cVj();
        }
    }

    public void cVj() {
        this.kps.startLoad();
    }

    public void cVk() {
        if (this.kps != null) {
            this.kps.cancelLoad();
        }
    }

    private void initListener() {
        this.fEN.setOnClickListener(this.kot);
        this.kpi.setOnClickListener(this.kot);
        this.kpn.cUJ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.kpn.cUJ().addTextChangedListener(this.kot);
        this.kpo.cUD().addTextChangedListener(this.kot);
        this.kpp.cUO().setOnClickListener(this.kot);
        this.kpp.cUN().setOnClickListener(this.kot);
        this.kpq.cUs().setOnClickListener(this.kot);
        if (this.kpm != null) {
            this.kpm.cUG().setOnClickListener(this.kot);
        }
        if (this.kpl != null) {
            this.kpl.cUG().setOnClickListener(this.kot);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.kot = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.kpr = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.kpg = new CreateGroupStepAdapter(this.kot);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.kpr.setAdapter(this.kpg);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cVr();
        this.kpi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.kpi.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.kpi, R.drawable.s_navbar_button_bg);
        sn(false);
        cVs();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.kpx = 1;
            this.kpw = 2;
            this.kpt = 3;
            this.kpu = 4;
            this.kpv = 5;
            this.kpl = new e(createGroupStepActivity, this.kpx, i2);
            this.kpq = new b(createGroupStepActivity, this.kpw, 1, 5);
            this.kpn = new g(createGroupStepActivity, this.kpt, 2, 5);
            this.kpo = new d(createGroupStepActivity, this.kpu, 3, 5);
            this.kpp = new i(createGroupStepActivity, this.kpv, 4, 5);
            this.kpg.a(this.kpl);
            this.kpg.a(this.kpq);
            this.kpg.a(this.kpn);
            this.kpg.a(this.kpo);
            this.kpg.a(this.kpp);
            this.kox = 5;
        } else if (i == 2) {
            this.kpx = 1;
            this.kpt = 2;
            this.kpu = 3;
            this.kpv = 4;
            this.kpw = 5;
            this.kpm = new h(createGroupStepActivity, this.kpx, i3);
            this.kpn = new g(createGroupStepActivity, this.kpt, 1, 5);
            this.kpo = new d(createGroupStepActivity, this.kpu, 2, 5);
            this.kpp = new i(createGroupStepActivity, this.kpv, 3, 5);
            this.kpq = new b(createGroupStepActivity, this.kpw, 4, 5);
            this.kpg.a(this.kpm);
            this.kpg.a(this.kpn);
            this.kpg.a(this.kpo);
            this.kpg.a(this.kpp);
            this.kpg.a(this.kpq);
            this.kox = 5;
        } else {
            this.kpt = 1;
            this.kpu = 2;
            this.kpv = 3;
            this.kpw = 4;
            this.kpn = new g(createGroupStepActivity, this.kpt, 1, 4);
            this.kpo = new d(createGroupStepActivity, this.kpu, 2, 4);
            this.kpp = new i(createGroupStepActivity, this.kpv, 3, 4);
            this.kpq = new b(createGroupStepActivity, this.kpw, 4, 4);
            this.kpg.a(this.kpn);
            this.kpg.a(this.kpo);
            this.kpg.a(this.kpp);
            this.kpg.a(this.kpq);
            this.kox = 4;
        }
    }

    private void sn(boolean z) {
        this.mIsEnabled = z;
        cVm();
    }

    public boolean cVl() {
        return this.mIsEnabled;
    }

    private void cVm() {
        this.kpi.setEnabled(this.mIsEnabled);
        ap.setBackgroundResource(this.kpi, R.drawable.s_navbar_button_bg);
    }

    public void cVn() {
        if (this.kph > 1) {
            this.kph--;
            cVp();
        }
    }

    public void cVo() {
        if (this.kph < this.kox) {
            this.kph++;
            cVp();
        }
    }

    public void cVp() {
        this.kpr.setCurrentItem(this.kph - 1);
        cVr();
        cVs();
        cVt();
        this.kpn.cUJ().clearFocus();
        this.kpo.cUD().clearFocus();
        d(this.kpn.cUJ());
        d(this.kpo.cUD());
        if (cVe() && cUY()) {
            cUU().setEnabled(false);
        } else {
            cUU().setEnabled(true);
        }
    }

    public void cVq() {
        String[] strArr = {this.kot.getResources().getString(R.string.take_photo), this.kot.getResources().getString(R.string.album)};
        if (this.kpj == null) {
            this.kpj = new com.baidu.tbadk.core.dialog.i(this.kot.getPageContext());
            this.kpj.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.kpj != null && j.this.kpj.isShowing() && j.this.kot != null) {
                        j.this.kpj.dismiss();
                    }
                    Activity pageActivity = j.this.kot.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.kot.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.kot.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.kpj.RU();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.kot.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.kot.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Na(String str) {
        if (!this.kpi.getText().toString().equals(str)) {
            this.kpi.setText(str);
        }
    }

    private void cVr() {
        if (this.kpg.DU(this.kph - 1) != null) {
            this.mNavigationBar.setTitleText(this.kpg.DU(this.kph - 1).getTitle());
        }
    }

    public void cVs() {
        for (o oVar : this.kpg.getList()) {
            if (oVar.cUr() == this.kph) {
                oVar.cUy();
                if (!oVar.cUC()) {
                    this.kpi.setVisibility(8);
                } else {
                    this.kpi.setVisibility(0);
                }
                Na(oVar.cUA());
            } else {
                oVar.cUx();
            }
        }
        if (this.kpg.DU(this.kph - 1) != null && this.kpg.DU(this.kph - 1).cUB()) {
            sn(true);
        }
    }

    public void cVt() {
        if (cVc()) {
            a(this.kpn.cUJ().getText().length(), this.kpn.wg() / 2, 2, 20);
        } else if (cVd()) {
            int wg = this.kpo.wg() / 2;
            U(wg, 15, 300);
            int i = 300 - wg;
            this.kpo.cUE().setText(String.valueOf(i));
            if (i <= 50) {
                this.kpo.cUE().setVisibility(0);
            } else {
                this.kpo.cUE().setVisibility(8);
            }
            if (i == 0) {
                this.kpo.cUE().setTextColor(this.kot.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.kpo.DT(300);
            } else {
                this.kpo.cUF();
            }
        } else if (cVf()) {
            if (this.kpq.cUt() != 3) {
                sn(true);
            } else {
                sn(false);
            }
        }
    }

    private void U(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            sn(true);
        } else {
            sn(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            sn(false);
        } else if (f >= i2 && f <= i3) {
            sn(true);
        } else {
            sn(false);
        }
        if (i < 1) {
            this.kpn.sl(false);
        } else {
            this.kpn.sl(true);
        }
    }

    public void setData(int i, int i2) {
        this.kpk = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.kot.getLayoutMode().setNightMode(i == 1);
        this.kot.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cVm();
        ap.setViewTextColor(this.kpi, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.kot.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
