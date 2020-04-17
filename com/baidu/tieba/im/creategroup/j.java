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
    private boolean bLg;
    private String business;
    private View efU;
    CreateGroupStepActivity ihp;
    private int iht;
    CreateGroupStepAdapter iic;
    private int iid;
    private TextView iie;
    private com.baidu.tbadk.core.dialog.i iif;
    int iig;
    e iih;
    h iii;
    g iij;
    d iik;
    i iil;
    b iim;
    private NoSwipeableViewPager iin;
    private com.baidu.tieba.im.util.b iio;
    private int iip;
    private int iiq;
    private int iir;
    private int iis;
    private int iit;
    private boolean iiu;
    private String iiv;
    private String iiw;
    private String iix;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Em(String str) {
        this.iiw = str;
    }

    public void En(String str) {
        this.iix = str;
    }

    public String ceg() {
        return this.iiw;
    }

    public String ceh() {
        return this.iix;
    }

    public View cei() {
        return this.efU;
    }

    public int cej() {
        return this.iid;
    }

    public View cek() {
        return this.iie;
    }

    public View cel() {
        if (this.iih != null) {
            return this.iih.cdV();
        }
        if (this.iii != null) {
            return this.iii.cdV();
        }
        return null;
    }

    public View cem() {
        return this.iil.ced();
    }

    public View cen() {
        return this.iil.cec();
    }

    public boolean ceo() {
        return this.mIsLoading;
    }

    public void cdI() {
        this.iim.cdI();
        ceJ();
    }

    public void Eo(String str) {
        this.iiv = str;
    }

    public String UB() {
        return this.iiv;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.iim.setBusiness(str);
        ceJ();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Ep(String str) {
        this.iim.setAddress(str);
        ceJ();
    }

    public boolean cep() {
        return this.iiu;
    }

    public void oy(boolean z) {
        this.iiu = z;
    }

    public void cdJ() {
        this.iim.cdJ();
        ceJ();
    }

    public void cdK() {
        this.iim.cdK();
        ceJ();
    }

    public View ceq() {
        return this.iim.cdG();
    }

    public int cdH() {
        return this.iim.cdH();
    }

    public View cer() {
        return this.iij.cdZ();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.iij.cdY().getText().toString();
    }

    public String getIntro() {
        return this.iik.cdR().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.iig;
    }

    public boolean ces() {
        return this.iij != null && this.iid == this.iij.cdF();
    }

    public boolean cet() {
        return this.iik != null && this.iid == this.iik.cdF();
    }

    public boolean ceu() {
        return this.iil != null && this.iid == this.iil.cdF();
    }

    public boolean cev() {
        return this.iim != null && this.iid == this.iim.cdF();
    }

    public boolean cew() {
        return this.iic != null && this.iid == this.iic.getCount();
    }

    public String getErrMsg() {
        if (this.iic.wN(this.iid - 1) != null) {
            return this.iic.wN(this.iid - 1).getErrMsg();
        }
        return null;
    }

    public void cex() {
        this.iil.ced().setText(R.string.group_create_modify_photo_tip);
    }

    public void cey() {
        this.iil.ceb();
    }

    public void CP() {
        this.iij.cea();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bLg = true;
        this.mIsLoading = false;
        this.ihp = null;
        this.iic = null;
        this.progressBar = null;
        this.iid = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.efU = null;
        this.iie = null;
        this.iif = null;
        this.iig = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.iih = null;
        this.iii = null;
        this.iij = null;
        this.iik = null;
        this.iil = null;
        this.iim = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.iin = null;
        this.iio = null;
        this.iiu = false;
        this.iiv = "";
        this.business = "";
        this.iiw = null;
        this.iix = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.iio = new com.baidu.tieba.im.util.b(this.ihp);
        this.iio.setUniqueId(this.ihp.getUniqueId());
        if (!ab.d(this.ihp, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cez();
        }
    }

    public void cez() {
        this.iio.startLoad();
    }

    public void ceA() {
        if (this.iio != null) {
            this.iio.cancelLoad();
        }
    }

    private void initListener() {
        this.efU.setOnClickListener(this.ihp);
        this.iie.setOnClickListener(this.ihp);
        this.iij.cdY().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.iij.cdY().addTextChangedListener(this.ihp);
        this.iik.cdR().addTextChangedListener(this.ihp);
        this.iil.ced().setOnClickListener(this.ihp);
        this.iil.cec().setOnClickListener(this.ihp);
        this.iim.cdG().setOnClickListener(this.ihp);
        if (this.iii != null) {
            this.iii.cdV().setOnClickListener(this.ihp);
        }
        if (this.iih != null) {
            this.iih.cdV().setOnClickListener(this.ihp);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.ihp = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.iin = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.iic = new CreateGroupStepAdapter(this.ihp);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.iin.setAdapter(this.iic);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.efU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ceH();
        this.iie = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.iie.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.iie, R.drawable.s_navbar_button_bg);
        oz(false);
        ceI();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.iit = 1;
            this.iis = 2;
            this.iip = 3;
            this.iiq = 4;
            this.iir = 5;
            this.iih = new e(createGroupStepActivity, this.iit, i2);
            this.iim = new b(createGroupStepActivity, this.iis, 1, 5);
            this.iij = new g(createGroupStepActivity, this.iip, 2, 5);
            this.iik = new d(createGroupStepActivity, this.iiq, 3, 5);
            this.iil = new i(createGroupStepActivity, this.iir, 4, 5);
            this.iic.a(this.iih);
            this.iic.a(this.iim);
            this.iic.a(this.iij);
            this.iic.a(this.iik);
            this.iic.a(this.iil);
            this.iht = 5;
        } else if (i == 2) {
            this.iit = 1;
            this.iip = 2;
            this.iiq = 3;
            this.iir = 4;
            this.iis = 5;
            this.iii = new h(createGroupStepActivity, this.iit, i3);
            this.iij = new g(createGroupStepActivity, this.iip, 1, 5);
            this.iik = new d(createGroupStepActivity, this.iiq, 2, 5);
            this.iil = new i(createGroupStepActivity, this.iir, 3, 5);
            this.iim = new b(createGroupStepActivity, this.iis, 4, 5);
            this.iic.a(this.iii);
            this.iic.a(this.iij);
            this.iic.a(this.iik);
            this.iic.a(this.iil);
            this.iic.a(this.iim);
            this.iht = 5;
        } else {
            this.iip = 1;
            this.iiq = 2;
            this.iir = 3;
            this.iis = 4;
            this.iij = new g(createGroupStepActivity, this.iip, 1, 4);
            this.iik = new d(createGroupStepActivity, this.iiq, 2, 4);
            this.iil = new i(createGroupStepActivity, this.iir, 3, 4);
            this.iim = new b(createGroupStepActivity, this.iis, 4, 4);
            this.iic.a(this.iij);
            this.iic.a(this.iik);
            this.iic.a(this.iil);
            this.iic.a(this.iim);
            this.iht = 4;
        }
    }

    private void oz(boolean z) {
        this.bLg = z;
        ceC();
    }

    public boolean ceB() {
        return this.bLg;
    }

    private void ceC() {
        this.iie.setEnabled(this.bLg);
        am.setBackgroundResource(this.iie, R.drawable.s_navbar_button_bg);
    }

    public void ceD() {
        if (this.iid > 1) {
            this.iid--;
            ceF();
        }
    }

    public void ceE() {
        if (this.iid < this.iht) {
            this.iid++;
            ceF();
        }
    }

    public void ceF() {
        this.iin.setCurrentItem(this.iid - 1);
        ceH();
        ceI();
        ceJ();
        this.iij.cdY().clearFocus();
        this.iik.cdR().clearFocus();
        c(this.iij.cdY());
        c(this.iik.cdR());
        if (ceu() && ceo()) {
            cek().setEnabled(false);
        } else {
            cek().setEnabled(true);
        }
    }

    public void ceG() {
        String[] strArr = {this.ihp.getResources().getString(R.string.take_photo), this.ihp.getResources().getString(R.string.album)};
        if (this.iif == null) {
            this.iif = new com.baidu.tbadk.core.dialog.i(this.ihp.getPageContext());
            this.iif.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.iif != null && j.this.iif.isShowing() && j.this.ihp != null) {
                        j.this.iif.dismiss();
                    }
                    Activity pageActivity = j.this.ihp.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.ihp.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.ihp.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.iif.showDialog();
    }

    public void an(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.ihp.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ihp.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Eq(String str) {
        if (!this.iie.getText().toString().equals(str)) {
            this.iie.setText(str);
        }
    }

    private void ceH() {
        if (this.iic.wN(this.iid - 1) != null) {
            this.mNavigationBar.setTitleText(this.iic.wN(this.iid - 1).getTitle());
        }
    }

    public void ceI() {
        for (o oVar : this.iic.getList()) {
            if (oVar.cdF() == this.iid) {
                oVar.cdM();
                if (!oVar.cdQ()) {
                    this.iie.setVisibility(8);
                } else {
                    this.iie.setVisibility(0);
                }
                Eq(oVar.cdO());
            } else {
                oVar.cdL();
            }
        }
        if (this.iic.wN(this.iid - 1) != null && this.iic.wN(this.iid - 1).cdP()) {
            oz(true);
        }
    }

    public void ceJ() {
        if (ces()) {
            a(this.iij.cdY().getText().length(), this.iij.cdT() / 2, 2, 20);
        } else if (cet()) {
            int cdT = this.iik.cdT() / 2;
            S(cdT, 15, 300);
            int i = 300 - cdT;
            this.iik.cdS().setText(String.valueOf(i));
            if (i <= 50) {
                this.iik.cdS().setVisibility(0);
            } else {
                this.iik.cdS().setVisibility(8);
            }
            if (i == 0) {
                this.iik.cdS().setTextColor(this.ihp.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.iik.wM(300);
            } else {
                this.iik.cdU();
            }
        } else if (cev()) {
            if (this.iim.cdH() != 3) {
                oz(true);
            } else {
                oz(false);
            }
        }
    }

    private void S(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            oz(true);
        } else {
            oz(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            oz(false);
        } else if (f >= i2 && f <= i3) {
            oz(true);
        } else {
            oz(false);
        }
        if (i < 1) {
            this.iij.ox(false);
        } else {
            this.iij.ox(true);
        }
    }

    public void setData(int i, int i2) {
        this.iig = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.ihp.getLayoutMode().setNightMode(i == 1);
        this.ihp.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ceC();
        am.setViewTextColor(this.iie, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.ihp.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
