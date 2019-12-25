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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes7.dex */
public class j extends com.baidu.adp.base.c {
    private boolean bhI;
    private String business;
    private View dBy;
    CreateGroupStepAdapter hqZ;
    CreateGroupStepActivity hqm;
    private int hqq;
    private int hra;
    private TextView hrb;
    private com.baidu.tbadk.core.dialog.i hrc;
    int hrd;
    e hre;
    h hrf;
    g hrg;
    d hrh;
    i hri;
    b hrj;
    private NoSwipeableViewPager hrk;
    private com.baidu.tieba.im.util.b hrl;
    private int hrm;
    private int hrn;
    private int hro;
    private int hrp;
    private int hrq;
    private boolean hrr;
    private String hrs;
    private String hrt;
    private String hru;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Cd(String str) {
        this.hrt = str;
    }

    public void Ce(String str) {
        this.hru = str;
    }

    public String bQA() {
        return this.hrt;
    }

    public String bQB() {
        return this.hru;
    }

    public View bQC() {
        return this.dBy;
    }

    public int bQD() {
        return this.hra;
    }

    public View bQE() {
        return this.hrb;
    }

    public View bQF() {
        if (this.hre != null) {
            return this.hre.bQq();
        }
        if (this.hrf != null) {
            return this.hrf.bQq();
        }
        return null;
    }

    public View bQG() {
        return this.hri.bQy();
    }

    public View bQH() {
        return this.hri.bQx();
    }

    public boolean bQI() {
        return this.mIsLoading;
    }

    public void bQd() {
        this.hrj.bQd();
        bRd();
    }

    public void Cf(String str) {
        this.hrs = str;
    }

    public String JY() {
        return this.hrs;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.hrj.setBusiness(str);
        bRd();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Cg(String str) {
        this.hrj.setAddress(str);
        bRd();
    }

    public boolean bQJ() {
        return this.hrr;
    }

    public void na(boolean z) {
        this.hrr = z;
    }

    public void bQe() {
        this.hrj.bQe();
        bRd();
    }

    public void bQf() {
        this.hrj.bQf();
        bRd();
    }

    public View bQK() {
        return this.hrj.bQb();
    }

    public int bQc() {
        return this.hrj.bQc();
    }

    public View bQL() {
        return this.hrg.bQu();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.hrg.bQt().getText().toString();
    }

    public String getIntro() {
        return this.hrh.bQm().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.hrd;
    }

    public boolean bQM() {
        return this.hrg != null && this.hra == this.hrg.bQa();
    }

    public boolean bQN() {
        return this.hrh != null && this.hra == this.hrh.bQa();
    }

    public boolean bQO() {
        return this.hri != null && this.hra == this.hri.bQa();
    }

    public boolean bQP() {
        return this.hrj != null && this.hra == this.hrj.bQa();
    }

    public boolean bQQ() {
        return this.hqZ != null && this.hra == this.hqZ.getCount();
    }

    public String getErrMsg() {
        if (this.hqZ.vW(this.hra - 1) != null) {
            return this.hqZ.vW(this.hra - 1).getErrMsg();
        }
        return null;
    }

    public void bQR() {
        this.hri.bQy().setText(R.string.group_create_modify_photo_tip);
    }

    public void bQS() {
        this.hri.bQw();
    }

    public void vC() {
        this.hrg.bQv();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bhI = true;
        this.mIsLoading = false;
        this.hqm = null;
        this.hqZ = null;
        this.progressBar = null;
        this.hra = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dBy = null;
        this.hrb = null;
        this.hrc = null;
        this.hrd = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.hre = null;
        this.hrf = null;
        this.hrg = null;
        this.hrh = null;
        this.hri = null;
        this.hrj = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.hrk = null;
        this.hrl = null;
        this.hrr = false;
        this.hrs = "";
        this.business = "";
        this.hrt = null;
        this.hru = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.hrl = new com.baidu.tieba.im.util.b(this.hqm);
        this.hrl.setUniqueId(this.hqm.getUniqueId());
        bQT();
    }

    public void bQT() {
        this.hrl.startLoad();
    }

    public void bQU() {
        if (this.hrl != null) {
            this.hrl.cancelLoad();
        }
    }

    private void initListener() {
        this.dBy.setOnClickListener(this.hqm);
        this.hrb.setOnClickListener(this.hqm);
        this.hrg.bQt().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.hrg.bQt().addTextChangedListener(this.hqm);
        this.hrh.bQm().addTextChangedListener(this.hqm);
        this.hri.bQy().setOnClickListener(this.hqm);
        this.hri.bQx().setOnClickListener(this.hqm);
        this.hrj.bQb().setOnClickListener(this.hqm);
        if (this.hrf != null) {
            this.hrf.bQq().setOnClickListener(this.hqm);
        }
        if (this.hre != null) {
            this.hre.bQq().setOnClickListener(this.hqm);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.hqm = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.hrk = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.hqZ = new CreateGroupStepAdapter(this.hqm);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.hrk.setAdapter(this.hqZ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.dBy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bRb();
        this.hrb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.hrb.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.hrb, R.drawable.s_navbar_button_bg);
        nb(false);
        bRc();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.hrq = 1;
            this.hrp = 2;
            this.hrm = 3;
            this.hrn = 4;
            this.hro = 5;
            this.hre = new e(createGroupStepActivity, this.hrq, i2);
            this.hrj = new b(createGroupStepActivity, this.hrp, 1, 5);
            this.hrg = new g(createGroupStepActivity, this.hrm, 2, 5);
            this.hrh = new d(createGroupStepActivity, this.hrn, 3, 5);
            this.hri = new i(createGroupStepActivity, this.hro, 4, 5);
            this.hqZ.a(this.hre);
            this.hqZ.a(this.hrj);
            this.hqZ.a(this.hrg);
            this.hqZ.a(this.hrh);
            this.hqZ.a(this.hri);
            this.hqq = 5;
        } else if (i == 2) {
            this.hrq = 1;
            this.hrm = 2;
            this.hrn = 3;
            this.hro = 4;
            this.hrp = 5;
            this.hrf = new h(createGroupStepActivity, this.hrq, i3);
            this.hrg = new g(createGroupStepActivity, this.hrm, 1, 5);
            this.hrh = new d(createGroupStepActivity, this.hrn, 2, 5);
            this.hri = new i(createGroupStepActivity, this.hro, 3, 5);
            this.hrj = new b(createGroupStepActivity, this.hrp, 4, 5);
            this.hqZ.a(this.hrf);
            this.hqZ.a(this.hrg);
            this.hqZ.a(this.hrh);
            this.hqZ.a(this.hri);
            this.hqZ.a(this.hrj);
            this.hqq = 5;
        } else {
            this.hrm = 1;
            this.hrn = 2;
            this.hro = 3;
            this.hrp = 4;
            this.hrg = new g(createGroupStepActivity, this.hrm, 1, 4);
            this.hrh = new d(createGroupStepActivity, this.hrn, 2, 4);
            this.hri = new i(createGroupStepActivity, this.hro, 3, 4);
            this.hrj = new b(createGroupStepActivity, this.hrp, 4, 4);
            this.hqZ.a(this.hrg);
            this.hqZ.a(this.hrh);
            this.hqZ.a(this.hri);
            this.hqZ.a(this.hrj);
            this.hqq = 4;
        }
    }

    private void nb(boolean z) {
        this.bhI = z;
        bQW();
    }

    public boolean bQV() {
        return this.bhI;
    }

    private void bQW() {
        this.hrb.setEnabled(this.bhI);
        am.setBackgroundResource(this.hrb, R.drawable.s_navbar_button_bg);
    }

    public void bQX() {
        if (this.hra > 1) {
            this.hra--;
            bQZ();
        }
    }

    public void bQY() {
        if (this.hra < this.hqq) {
            this.hra++;
            bQZ();
        }
    }

    public void bQZ() {
        this.hrk.setCurrentItem(this.hra - 1);
        bRb();
        bRc();
        bRd();
        this.hrg.bQt().clearFocus();
        this.hrh.bQm().clearFocus();
        d(this.hrg.bQt());
        d(this.hrh.bQm());
        if (bQO() && bQI()) {
            bQE().setEnabled(false);
        } else {
            bQE().setEnabled(true);
        }
    }

    public void bRa() {
        String[] strArr = {this.hqm.getResources().getString(R.string.take_photo), this.hqm.getResources().getString(R.string.album)};
        if (this.hrc == null) {
            this.hrc = new com.baidu.tbadk.core.dialog.i(this.hqm.getPageContext());
            this.hrc.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.hrc != null && j.this.hrc.isShowing() && j.this.hqm != null) {
                        j.this.hrc.dismiss();
                    }
                    Activity pageActivity = j.this.hqm.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.hqm.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.hqm.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.hrc.showDialog();
    }

    public void ao(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.hqm.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.hqm.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Ch(String str) {
        if (!this.hrb.getText().toString().equals(str)) {
            this.hrb.setText(str);
        }
    }

    private void bRb() {
        if (this.hqZ.vW(this.hra - 1) != null) {
            this.mNavigationBar.setTitleText(this.hqZ.vW(this.hra - 1).getTitle());
        }
    }

    public void bRc() {
        for (o oVar : this.hqZ.getList()) {
            if (oVar.bQa() == this.hra) {
                oVar.bQh();
                if (!oVar.bQl()) {
                    this.hrb.setVisibility(8);
                } else {
                    this.hrb.setVisibility(0);
                }
                Ch(oVar.bQj());
            } else {
                oVar.bQg();
            }
        }
        if (this.hqZ.vW(this.hra - 1) != null && this.hqZ.vW(this.hra - 1).bQk()) {
            nb(true);
        }
    }

    public void bRd() {
        if (bQM()) {
            a(this.hrg.bQt().getText().length(), this.hrg.bQo() / 2, 2, 20);
        } else if (bQN()) {
            int bQo = this.hrh.bQo() / 2;
            O(bQo, 15, 300);
            int i = 300 - bQo;
            this.hrh.bQn().setText(String.valueOf(i));
            if (i <= 50) {
                this.hrh.bQn().setVisibility(0);
            } else {
                this.hrh.bQn().setVisibility(8);
            }
            if (i == 0) {
                this.hrh.bQn().setTextColor(this.hqm.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.hrh.vV(300);
            } else {
                this.hrh.bQp();
            }
        } else if (bQP()) {
            if (this.hrj.bQc() != 3) {
                nb(true);
            } else {
                nb(false);
            }
        }
    }

    private void O(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            nb(true);
        } else {
            nb(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            nb(false);
        } else if (f >= i2 && f <= i3) {
            nb(true);
        } else {
            nb(false);
        }
        if (i < 1) {
            this.hrg.mZ(false);
        } else {
            this.hrg.mZ(true);
        }
    }

    public void setData(int i, int i2) {
        this.hrd = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.hqm.getLayoutMode().setNightMode(i == 1);
        this.hqm.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bQW();
        am.setViewTextColor(this.hrb, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.hqm.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
