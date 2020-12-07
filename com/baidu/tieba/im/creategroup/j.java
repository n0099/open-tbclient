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
    CreateGroupStepActivity kor;
    private int kov;
    CreateGroupStepAdapter kpe;
    private int kpf;
    private TextView kpg;
    private com.baidu.tbadk.core.dialog.i kph;
    int kpi;
    e kpj;
    h kpk;
    g kpl;
    d kpm;
    i kpn;
    b kpo;
    private NoSwipeableViewPager kpp;
    private com.baidu.tieba.im.util.b kpq;
    private int kpr;
    private int kps;
    private int kpt;
    private int kpu;
    private int kpv;
    private boolean kpw;
    private String kpx;
    private String kpy;
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
        this.kpy = str;
    }

    public void MX(String str) {
        this.kpz = str;
    }

    public String cUQ() {
        return this.kpy;
    }

    public String bpe() {
        return this.kpz;
    }

    public View cUR() {
        return this.fEN;
    }

    public int cUS() {
        return this.kpf;
    }

    public View cUT() {
        return this.kpg;
    }

    public View cUU() {
        if (this.kpj != null) {
            return this.kpj.cUF();
        }
        if (this.kpk != null) {
            return this.kpk.cUF();
        }
        return null;
    }

    public View cUV() {
        return this.kpn.cUN();
    }

    public View cUW() {
        return this.kpn.cUM();
    }

    public boolean cUX() {
        return this.mIsLoading;
    }

    public void cUt() {
        this.kpo.cUt();
        cVs();
    }

    public void MY(String str) {
        this.kpx = str;
    }

    public String apo() {
        return this.kpx;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.kpo.setBusiness(str);
        cVs();
    }

    public String getBusiness() {
        return this.business;
    }

    public void MZ(String str) {
        this.kpo.setAddress(str);
        cVs();
    }

    public boolean cUY() {
        return this.kpw;
    }

    public void sm(boolean z) {
        this.kpw = z;
    }

    public void cUu() {
        this.kpo.cUu();
        cVs();
    }

    public void cUv() {
        this.kpo.cUv();
        cVs();
    }

    public View cUZ() {
        return this.kpo.cUr();
    }

    public int cUs() {
        return this.kpo.cUs();
    }

    public View cVa() {
        return this.kpl.cUJ();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.kpl.cUI().getText().toString();
    }

    public String getIntro() {
        return this.kpm.cUC().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.kpi;
    }

    public boolean cVb() {
        return this.kpl != null && this.kpf == this.kpl.cUq();
    }

    public boolean cVc() {
        return this.kpm != null && this.kpf == this.kpm.cUq();
    }

    public boolean cVd() {
        return this.kpn != null && this.kpf == this.kpn.cUq();
    }

    public boolean cVe() {
        return this.kpo != null && this.kpf == this.kpo.cUq();
    }

    public boolean cVf() {
        return this.kpe != null && this.kpf == this.kpe.getCount();
    }

    public String getErrMsg() {
        if (this.kpe.DU(this.kpf - 1) != null) {
            return this.kpe.DU(this.kpf - 1).getErrMsg();
        }
        return null;
    }

    public void cVg() {
        this.kpn.cUN().setText(R.string.group_create_modify_photo_tip);
    }

    public void cVh() {
        this.kpn.cUL();
    }

    public void OS() {
        this.kpl.cUK();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.mIsEnabled = true;
        this.mIsLoading = false;
        this.kor = null;
        this.kpe = null;
        this.progressBar = null;
        this.kpf = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fEN = null;
        this.kpg = null;
        this.kph = null;
        this.kpi = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.kpj = null;
        this.kpk = null;
        this.kpl = null;
        this.kpm = null;
        this.kpn = null;
        this.kpo = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.kpp = null;
        this.kpq = null;
        this.kpw = false;
        this.kpx = "";
        this.business = "";
        this.kpy = null;
        this.kpz = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.kpq = new com.baidu.tieba.im.util.b(this.kor);
        this.kpq.setUniqueId(this.kor.getUniqueId());
        if (!ae.c(this.kor, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cVi();
        }
    }

    public void cVi() {
        this.kpq.startLoad();
    }

    public void cVj() {
        if (this.kpq != null) {
            this.kpq.cancelLoad();
        }
    }

    private void initListener() {
        this.fEN.setOnClickListener(this.kor);
        this.kpg.setOnClickListener(this.kor);
        this.kpl.cUI().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.kpl.cUI().addTextChangedListener(this.kor);
        this.kpm.cUC().addTextChangedListener(this.kor);
        this.kpn.cUN().setOnClickListener(this.kor);
        this.kpn.cUM().setOnClickListener(this.kor);
        this.kpo.cUr().setOnClickListener(this.kor);
        if (this.kpk != null) {
            this.kpk.cUF().setOnClickListener(this.kor);
        }
        if (this.kpj != null) {
            this.kpj.cUF().setOnClickListener(this.kor);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.kor = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.kpp = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.kpe = new CreateGroupStepAdapter(this.kor);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.kpp.setAdapter(this.kpe);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        cVq();
        this.kpg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.kpg.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        ap.setBackgroundResource(this.kpg, R.drawable.s_navbar_button_bg);
        sn(false);
        cVr();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.kpv = 1;
            this.kpu = 2;
            this.kpr = 3;
            this.kps = 4;
            this.kpt = 5;
            this.kpj = new e(createGroupStepActivity, this.kpv, i2);
            this.kpo = new b(createGroupStepActivity, this.kpu, 1, 5);
            this.kpl = new g(createGroupStepActivity, this.kpr, 2, 5);
            this.kpm = new d(createGroupStepActivity, this.kps, 3, 5);
            this.kpn = new i(createGroupStepActivity, this.kpt, 4, 5);
            this.kpe.a(this.kpj);
            this.kpe.a(this.kpo);
            this.kpe.a(this.kpl);
            this.kpe.a(this.kpm);
            this.kpe.a(this.kpn);
            this.kov = 5;
        } else if (i == 2) {
            this.kpv = 1;
            this.kpr = 2;
            this.kps = 3;
            this.kpt = 4;
            this.kpu = 5;
            this.kpk = new h(createGroupStepActivity, this.kpv, i3);
            this.kpl = new g(createGroupStepActivity, this.kpr, 1, 5);
            this.kpm = new d(createGroupStepActivity, this.kps, 2, 5);
            this.kpn = new i(createGroupStepActivity, this.kpt, 3, 5);
            this.kpo = new b(createGroupStepActivity, this.kpu, 4, 5);
            this.kpe.a(this.kpk);
            this.kpe.a(this.kpl);
            this.kpe.a(this.kpm);
            this.kpe.a(this.kpn);
            this.kpe.a(this.kpo);
            this.kov = 5;
        } else {
            this.kpr = 1;
            this.kps = 2;
            this.kpt = 3;
            this.kpu = 4;
            this.kpl = new g(createGroupStepActivity, this.kpr, 1, 4);
            this.kpm = new d(createGroupStepActivity, this.kps, 2, 4);
            this.kpn = new i(createGroupStepActivity, this.kpt, 3, 4);
            this.kpo = new b(createGroupStepActivity, this.kpu, 4, 4);
            this.kpe.a(this.kpl);
            this.kpe.a(this.kpm);
            this.kpe.a(this.kpn);
            this.kpe.a(this.kpo);
            this.kov = 4;
        }
    }

    private void sn(boolean z) {
        this.mIsEnabled = z;
        cVl();
    }

    public boolean cVk() {
        return this.mIsEnabled;
    }

    private void cVl() {
        this.kpg.setEnabled(this.mIsEnabled);
        ap.setBackgroundResource(this.kpg, R.drawable.s_navbar_button_bg);
    }

    public void cVm() {
        if (this.kpf > 1) {
            this.kpf--;
            cVo();
        }
    }

    public void cVn() {
        if (this.kpf < this.kov) {
            this.kpf++;
            cVo();
        }
    }

    public void cVo() {
        this.kpp.setCurrentItem(this.kpf - 1);
        cVq();
        cVr();
        cVs();
        this.kpl.cUI().clearFocus();
        this.kpm.cUC().clearFocus();
        d(this.kpl.cUI());
        d(this.kpm.cUC());
        if (cVd() && cUX()) {
            cUT().setEnabled(false);
        } else {
            cUT().setEnabled(true);
        }
    }

    public void cVp() {
        String[] strArr = {this.kor.getResources().getString(R.string.take_photo), this.kor.getResources().getString(R.string.album)};
        if (this.kph == null) {
            this.kph = new com.baidu.tbadk.core.dialog.i(this.kor.getPageContext());
            this.kph.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.kph != null && j.this.kph.isShowing() && j.this.kor != null) {
                        j.this.kph.dismiss();
                    }
                    Activity pageActivity = j.this.kor.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            ao.g(j.this.kor.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.kor.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.kph.RU();
    }

    public void X(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.kor.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.kor.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Na(String str) {
        if (!this.kpg.getText().toString().equals(str)) {
            this.kpg.setText(str);
        }
    }

    private void cVq() {
        if (this.kpe.DU(this.kpf - 1) != null) {
            this.mNavigationBar.setTitleText(this.kpe.DU(this.kpf - 1).getTitle());
        }
    }

    public void cVr() {
        for (o oVar : this.kpe.getList()) {
            if (oVar.cUq() == this.kpf) {
                oVar.cUx();
                if (!oVar.cUB()) {
                    this.kpg.setVisibility(8);
                } else {
                    this.kpg.setVisibility(0);
                }
                Na(oVar.cUz());
            } else {
                oVar.cUw();
            }
        }
        if (this.kpe.DU(this.kpf - 1) != null && this.kpe.DU(this.kpf - 1).cUA()) {
            sn(true);
        }
    }

    public void cVs() {
        if (cVb()) {
            a(this.kpl.cUI().getText().length(), this.kpl.wg() / 2, 2, 20);
        } else if (cVc()) {
            int wg = this.kpm.wg() / 2;
            U(wg, 15, 300);
            int i = 300 - wg;
            this.kpm.cUD().setText(String.valueOf(i));
            if (i <= 50) {
                this.kpm.cUD().setVisibility(0);
            } else {
                this.kpm.cUD().setVisibility(8);
            }
            if (i == 0) {
                this.kpm.cUD().setTextColor(this.kor.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.kpm.DT(300);
            } else {
                this.kpm.cUE();
            }
        } else if (cVe()) {
            if (this.kpo.cUs() != 3) {
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
            this.kpl.sl(false);
        } else {
            this.kpl.sl(true);
        }
    }

    public void setData(int i, int i2) {
        this.kpi = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.kor.getLayoutMode().setNightMode(i == 1);
        this.kor.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        cVl();
        ap.setViewTextColor(this.kpg, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ap.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.kor.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
