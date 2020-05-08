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
    private boolean bLl;
    private String business;
    private View efZ;
    CreateGroupStepActivity ihv;
    private int ihz;
    private boolean iiA;
    private String iiB;
    private String iiC;
    private String iiD;
    CreateGroupStepAdapter iii;
    private int iij;
    private TextView iik;
    private com.baidu.tbadk.core.dialog.i iil;
    int iim;
    e iin;
    h iio;
    g iip;
    d iiq;
    i iir;
    b iis;
    private NoSwipeableViewPager iit;
    private com.baidu.tieba.im.util.b iiu;
    private int iiv;
    private int iiw;
    private int iix;
    private int iiy;
    private int iiz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void Ep(String str) {
        this.iiC = str;
    }

    public void Eq(String str) {
        this.iiD = str;
    }

    public String cee() {
        return this.iiC;
    }

    public String cef() {
        return this.iiD;
    }

    public View ceg() {
        return this.efZ;
    }

    public int ceh() {
        return this.iij;
    }

    public View cei() {
        return this.iik;
    }

    public View cej() {
        if (this.iin != null) {
            return this.iin.cdT();
        }
        if (this.iio != null) {
            return this.iio.cdT();
        }
        return null;
    }

    public View cek() {
        return this.iir.ceb();
    }

    public View cel() {
        return this.iir.cea();
    }

    public boolean cem() {
        return this.mIsLoading;
    }

    public void cdG() {
        this.iis.cdG();
        ceH();
    }

    public void Er(String str) {
        this.iiB = str;
    }

    public String UA() {
        return this.iiB;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.iis.setBusiness(str);
        ceH();
    }

    public String getBusiness() {
        return this.business;
    }

    public void Es(String str) {
        this.iis.setAddress(str);
        ceH();
    }

    public boolean cen() {
        return this.iiA;
    }

    public void oy(boolean z) {
        this.iiA = z;
    }

    public void cdH() {
        this.iis.cdH();
        ceH();
    }

    public void cdI() {
        this.iis.cdI();
        ceH();
    }

    public View ceo() {
        return this.iis.cdE();
    }

    public int cdF() {
        return this.iis.cdF();
    }

    public View cep() {
        return this.iip.cdX();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.iip.cdW().getText().toString();
    }

    public String getIntro() {
        return this.iiq.cdP().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.iim;
    }

    public boolean ceq() {
        return this.iip != null && this.iij == this.iip.cdD();
    }

    public boolean cer() {
        return this.iiq != null && this.iij == this.iiq.cdD();
    }

    public boolean ces() {
        return this.iir != null && this.iij == this.iir.cdD();
    }

    public boolean cet() {
        return this.iis != null && this.iij == this.iis.cdD();
    }

    public boolean ceu() {
        return this.iii != null && this.iij == this.iii.getCount();
    }

    public String getErrMsg() {
        if (this.iii.wN(this.iij - 1) != null) {
            return this.iii.wN(this.iij - 1).getErrMsg();
        }
        return null;
    }

    public void cev() {
        this.iir.ceb().setText(R.string.group_create_modify_photo_tip);
    }

    public void cew() {
        this.iir.cdZ();
    }

    public void CO() {
        this.iip.cdY();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bLl = true;
        this.mIsLoading = false;
        this.ihv = null;
        this.iii = null;
        this.progressBar = null;
        this.iij = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.efZ = null;
        this.iik = null;
        this.iil = null;
        this.iim = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.iin = null;
        this.iio = null;
        this.iip = null;
        this.iiq = null;
        this.iir = null;
        this.iis = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.iit = null;
        this.iiu = null;
        this.iiA = false;
        this.iiB = "";
        this.business = "";
        this.iiC = null;
        this.iiD = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.iiu = new com.baidu.tieba.im.util.b(this.ihv);
        this.iiu.setUniqueId(this.ihv.getUniqueId());
        if (!ab.d(this.ihv, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cex();
        }
    }

    public void cex() {
        this.iiu.startLoad();
    }

    public void cey() {
        if (this.iiu != null) {
            this.iiu.cancelLoad();
        }
    }

    private void initListener() {
        this.efZ.setOnClickListener(this.ihv);
        this.iik.setOnClickListener(this.ihv);
        this.iip.cdW().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.iip.cdW().addTextChangedListener(this.ihv);
        this.iiq.cdP().addTextChangedListener(this.ihv);
        this.iir.ceb().setOnClickListener(this.ihv);
        this.iir.cea().setOnClickListener(this.ihv);
        this.iis.cdE().setOnClickListener(this.ihv);
        if (this.iio != null) {
            this.iio.cdT().setOnClickListener(this.ihv);
        }
        if (this.iin != null) {
            this.iin.cdT().setOnClickListener(this.ihv);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.ihv = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.iit = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.iii = new CreateGroupStepAdapter(this.ihv);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.iit.setAdapter(this.iii);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.efZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ceF();
        this.iik = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.iik.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.iik, R.drawable.s_navbar_button_bg);
        oz(false);
        ceG();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.iiz = 1;
            this.iiy = 2;
            this.iiv = 3;
            this.iiw = 4;
            this.iix = 5;
            this.iin = new e(createGroupStepActivity, this.iiz, i2);
            this.iis = new b(createGroupStepActivity, this.iiy, 1, 5);
            this.iip = new g(createGroupStepActivity, this.iiv, 2, 5);
            this.iiq = new d(createGroupStepActivity, this.iiw, 3, 5);
            this.iir = new i(createGroupStepActivity, this.iix, 4, 5);
            this.iii.a(this.iin);
            this.iii.a(this.iis);
            this.iii.a(this.iip);
            this.iii.a(this.iiq);
            this.iii.a(this.iir);
            this.ihz = 5;
        } else if (i == 2) {
            this.iiz = 1;
            this.iiv = 2;
            this.iiw = 3;
            this.iix = 4;
            this.iiy = 5;
            this.iio = new h(createGroupStepActivity, this.iiz, i3);
            this.iip = new g(createGroupStepActivity, this.iiv, 1, 5);
            this.iiq = new d(createGroupStepActivity, this.iiw, 2, 5);
            this.iir = new i(createGroupStepActivity, this.iix, 3, 5);
            this.iis = new b(createGroupStepActivity, this.iiy, 4, 5);
            this.iii.a(this.iio);
            this.iii.a(this.iip);
            this.iii.a(this.iiq);
            this.iii.a(this.iir);
            this.iii.a(this.iis);
            this.ihz = 5;
        } else {
            this.iiv = 1;
            this.iiw = 2;
            this.iix = 3;
            this.iiy = 4;
            this.iip = new g(createGroupStepActivity, this.iiv, 1, 4);
            this.iiq = new d(createGroupStepActivity, this.iiw, 2, 4);
            this.iir = new i(createGroupStepActivity, this.iix, 3, 4);
            this.iis = new b(createGroupStepActivity, this.iiy, 4, 4);
            this.iii.a(this.iip);
            this.iii.a(this.iiq);
            this.iii.a(this.iir);
            this.iii.a(this.iis);
            this.ihz = 4;
        }
    }

    private void oz(boolean z) {
        this.bLl = z;
        ceA();
    }

    public boolean cez() {
        return this.bLl;
    }

    private void ceA() {
        this.iik.setEnabled(this.bLl);
        am.setBackgroundResource(this.iik, R.drawable.s_navbar_button_bg);
    }

    public void ceB() {
        if (this.iij > 1) {
            this.iij--;
            ceD();
        }
    }

    public void ceC() {
        if (this.iij < this.ihz) {
            this.iij++;
            ceD();
        }
    }

    public void ceD() {
        this.iit.setCurrentItem(this.iij - 1);
        ceF();
        ceG();
        ceH();
        this.iip.cdW().clearFocus();
        this.iiq.cdP().clearFocus();
        c(this.iip.cdW());
        c(this.iiq.cdP());
        if (ces() && cem()) {
            cei().setEnabled(false);
        } else {
            cei().setEnabled(true);
        }
    }

    public void ceE() {
        String[] strArr = {this.ihv.getResources().getString(R.string.take_photo), this.ihv.getResources().getString(R.string.album)};
        if (this.iil == null) {
            this.iil = new com.baidu.tbadk.core.dialog.i(this.ihv.getPageContext());
            this.iil.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.iil != null && j.this.iil.isShowing() && j.this.ihv != null) {
                        j.this.iil.dismiss();
                    }
                    Activity pageActivity = j.this.ihv.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.ihv.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.ihv.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.iil.showDialog();
    }

    public void aa(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.ihv.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ihv.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void Et(String str) {
        if (!this.iik.getText().toString().equals(str)) {
            this.iik.setText(str);
        }
    }

    private void ceF() {
        if (this.iii.wN(this.iij - 1) != null) {
            this.mNavigationBar.setTitleText(this.iii.wN(this.iij - 1).getTitle());
        }
    }

    public void ceG() {
        for (o oVar : this.iii.getList()) {
            if (oVar.cdD() == this.iij) {
                oVar.cdK();
                if (!oVar.cdO()) {
                    this.iik.setVisibility(8);
                } else {
                    this.iik.setVisibility(0);
                }
                Et(oVar.cdM());
            } else {
                oVar.cdJ();
            }
        }
        if (this.iii.wN(this.iij - 1) != null && this.iii.wN(this.iij - 1).cdN()) {
            oz(true);
        }
    }

    public void ceH() {
        if (ceq()) {
            a(this.iip.cdW().getText().length(), this.iip.cdR() / 2, 2, 20);
        } else if (cer()) {
            int cdR = this.iiq.cdR() / 2;
            S(cdR, 15, 300);
            int i = 300 - cdR;
            this.iiq.cdQ().setText(String.valueOf(i));
            if (i <= 50) {
                this.iiq.cdQ().setVisibility(0);
            } else {
                this.iiq.cdQ().setVisibility(8);
            }
            if (i == 0) {
                this.iiq.cdQ().setTextColor(this.ihv.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.iiq.wM(300);
            } else {
                this.iiq.cdS();
            }
        } else if (cet()) {
            if (this.iis.cdF() != 3) {
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
            this.iip.ox(false);
        } else {
            this.iip.ox(true);
        }
    }

    public void setData(int i, int i2) {
        this.iim = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.ihv.getLayoutMode().setNightMode(i == 1);
        this.ihv.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ceA();
        am.setViewTextColor(this.iik, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.ihv.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
