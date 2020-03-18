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
    private boolean bmZ;
    private String business;
    private View dGn;
    CreateGroupStepActivity hxC;
    private int hxG;
    private NoSwipeableViewPager hyA;
    private com.baidu.tieba.im.util.b hyB;
    private int hyC;
    private int hyD;
    private int hyE;
    private int hyF;
    private int hyG;
    private boolean hyH;
    private String hyI;
    private String hyJ;
    private String hyK;
    CreateGroupStepAdapter hyp;
    private int hyq;
    private TextView hyr;
    private com.baidu.tbadk.core.dialog.i hys;
    int hyt;
    e hyu;
    h hyv;
    g hyw;
    d hyx;
    i hyy;
    b hyz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private PermissionJudgePolicy mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void CD(String str) {
        this.hyJ = str;
    }

    public void CE(String str) {
        this.hyK = str;
    }

    public String bTF() {
        return this.hyJ;
    }

    public String bTG() {
        return this.hyK;
    }

    public View bTH() {
        return this.dGn;
    }

    public int bTI() {
        return this.hyq;
    }

    public View bTJ() {
        return this.hyr;
    }

    public View bTK() {
        if (this.hyu != null) {
            return this.hyu.bTv();
        }
        if (this.hyv != null) {
            return this.hyv.bTv();
        }
        return null;
    }

    public View bTL() {
        return this.hyy.bTD();
    }

    public View bTM() {
        return this.hyy.bTC();
    }

    public boolean bTN() {
        return this.mIsLoading;
    }

    public void bTi() {
        this.hyz.bTi();
        bUi();
    }

    public void CF(String str) {
        this.hyI = str;
    }

    public String MO() {
        return this.hyI;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.hyz.setBusiness(str);
        bUi();
    }

    public String getBusiness() {
        return this.business;
    }

    public void CG(String str) {
        this.hyz.setAddress(str);
        bUi();
    }

    public boolean bTO() {
        return this.hyH;
    }

    public void nu(boolean z) {
        this.hyH = z;
    }

    public void bTj() {
        this.hyz.bTj();
        bUi();
    }

    public void bTk() {
        this.hyz.bTk();
        bUi();
    }

    public View bTP() {
        return this.hyz.bTg();
    }

    public int bTh() {
        return this.hyz.bTh();
    }

    public View bTQ() {
        return this.hyw.bTz();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.hyw.bTy().getText().toString();
    }

    public String getIntro() {
        return this.hyx.bTr().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.hyt;
    }

    public boolean bTR() {
        return this.hyw != null && this.hyq == this.hyw.bTf();
    }

    public boolean bTS() {
        return this.hyx != null && this.hyq == this.hyx.bTf();
    }

    public boolean bTT() {
        return this.hyy != null && this.hyq == this.hyy.bTf();
    }

    public boolean bTU() {
        return this.hyz != null && this.hyq == this.hyz.bTf();
    }

    public boolean bTV() {
        return this.hyp != null && this.hyq == this.hyp.getCount();
    }

    public String getErrMsg() {
        if (this.hyp.wp(this.hyq - 1) != null) {
            return this.hyp.wp(this.hyq - 1).getErrMsg();
        }
        return null;
    }

    public void bTW() {
        this.hyy.bTD().setText(R.string.group_create_modify_photo_tip);
    }

    public void bTX() {
        this.hyy.bTB();
    }

    public void xX() {
        this.hyw.bTA();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.bmZ = true;
        this.mIsLoading = false;
        this.hxC = null;
        this.hyp = null;
        this.progressBar = null;
        this.hyq = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dGn = null;
        this.hyr = null;
        this.hys = null;
        this.hyt = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.hyu = null;
        this.hyv = null;
        this.hyw = null;
        this.hyx = null;
        this.hyy = null;
        this.hyz = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.hyA = null;
        this.hyB = null;
        this.hyH = false;
        this.hyI = "";
        this.business = "";
        this.hyJ = null;
        this.hyK = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.hyB = new com.baidu.tieba.im.util.b(this.hxC);
        this.hyB.setUniqueId(this.hxC.getUniqueId());
        if (!ab.e(this.hxC, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            bTY();
        }
    }

    public void bTY() {
        this.hyB.startLoad();
    }

    public void bTZ() {
        if (this.hyB != null) {
            this.hyB.cancelLoad();
        }
    }

    private void initListener() {
        this.dGn.setOnClickListener(this.hxC);
        this.hyr.setOnClickListener(this.hxC);
        this.hyw.bTy().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.hyw.bTy().addTextChangedListener(this.hxC);
        this.hyx.bTr().addTextChangedListener(this.hxC);
        this.hyy.bTD().setOnClickListener(this.hxC);
        this.hyy.bTC().setOnClickListener(this.hxC);
        this.hyz.bTg().setOnClickListener(this.hxC);
        if (this.hyv != null) {
            this.hyv.bTv().setOnClickListener(this.hxC);
        }
        if (this.hyu != null) {
            this.hyu.bTv().setOnClickListener(this.hxC);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.hxC = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.hyA = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.hyp = new CreateGroupStepAdapter(this.hxC);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.hyA.setAdapter(this.hyp);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.dGn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bUg();
        this.hyr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.hyr.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.hyr, R.drawable.s_navbar_button_bg);
        nv(false);
        bUh();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.hyG = 1;
            this.hyF = 2;
            this.hyC = 3;
            this.hyD = 4;
            this.hyE = 5;
            this.hyu = new e(createGroupStepActivity, this.hyG, i2);
            this.hyz = new b(createGroupStepActivity, this.hyF, 1, 5);
            this.hyw = new g(createGroupStepActivity, this.hyC, 2, 5);
            this.hyx = new d(createGroupStepActivity, this.hyD, 3, 5);
            this.hyy = new i(createGroupStepActivity, this.hyE, 4, 5);
            this.hyp.a(this.hyu);
            this.hyp.a(this.hyz);
            this.hyp.a(this.hyw);
            this.hyp.a(this.hyx);
            this.hyp.a(this.hyy);
            this.hxG = 5;
        } else if (i == 2) {
            this.hyG = 1;
            this.hyC = 2;
            this.hyD = 3;
            this.hyE = 4;
            this.hyF = 5;
            this.hyv = new h(createGroupStepActivity, this.hyG, i3);
            this.hyw = new g(createGroupStepActivity, this.hyC, 1, 5);
            this.hyx = new d(createGroupStepActivity, this.hyD, 2, 5);
            this.hyy = new i(createGroupStepActivity, this.hyE, 3, 5);
            this.hyz = new b(createGroupStepActivity, this.hyF, 4, 5);
            this.hyp.a(this.hyv);
            this.hyp.a(this.hyw);
            this.hyp.a(this.hyx);
            this.hyp.a(this.hyy);
            this.hyp.a(this.hyz);
            this.hxG = 5;
        } else {
            this.hyC = 1;
            this.hyD = 2;
            this.hyE = 3;
            this.hyF = 4;
            this.hyw = new g(createGroupStepActivity, this.hyC, 1, 4);
            this.hyx = new d(createGroupStepActivity, this.hyD, 2, 4);
            this.hyy = new i(createGroupStepActivity, this.hyE, 3, 4);
            this.hyz = new b(createGroupStepActivity, this.hyF, 4, 4);
            this.hyp.a(this.hyw);
            this.hyp.a(this.hyx);
            this.hyp.a(this.hyy);
            this.hyp.a(this.hyz);
            this.hxG = 4;
        }
    }

    private void nv(boolean z) {
        this.bmZ = z;
        bUb();
    }

    public boolean bUa() {
        return this.bmZ;
    }

    private void bUb() {
        this.hyr.setEnabled(this.bmZ);
        am.setBackgroundResource(this.hyr, R.drawable.s_navbar_button_bg);
    }

    public void bUc() {
        if (this.hyq > 1) {
            this.hyq--;
            bUe();
        }
    }

    public void bUd() {
        if (this.hyq < this.hxG) {
            this.hyq++;
            bUe();
        }
    }

    public void bUe() {
        this.hyA.setCurrentItem(this.hyq - 1);
        bUg();
        bUh();
        bUi();
        this.hyw.bTy().clearFocus();
        this.hyx.bTr().clearFocus();
        d(this.hyw.bTy());
        d(this.hyx.bTr());
        if (bTT() && bTN()) {
            bTJ().setEnabled(false);
        } else {
            bTJ().setEnabled(true);
        }
    }

    public void bUf() {
        String[] strArr = {this.hxC.getResources().getString(R.string.take_photo), this.hxC.getResources().getString(R.string.album)};
        if (this.hys == null) {
            this.hys = new com.baidu.tbadk.core.dialog.i(this.hxC.getPageContext());
            this.hys.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.hys != null && j.this.hys.isShowing() && j.this.hxC != null) {
                        j.this.hys.dismiss();
                    }
                    Activity pageActivity = j.this.hxC.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.e(j.this.hxC.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.hxC.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.hys.showDialog();
    }

    public void ao(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.hxC.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.hxC.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void CH(String str) {
        if (!this.hyr.getText().toString().equals(str)) {
            this.hyr.setText(str);
        }
    }

    private void bUg() {
        if (this.hyp.wp(this.hyq - 1) != null) {
            this.mNavigationBar.setTitleText(this.hyp.wp(this.hyq - 1).getTitle());
        }
    }

    public void bUh() {
        for (o oVar : this.hyp.getList()) {
            if (oVar.bTf() == this.hyq) {
                oVar.bTm();
                if (!oVar.bTq()) {
                    this.hyr.setVisibility(8);
                } else {
                    this.hyr.setVisibility(0);
                }
                CH(oVar.bTo());
            } else {
                oVar.bTl();
            }
        }
        if (this.hyp.wp(this.hyq - 1) != null && this.hyp.wp(this.hyq - 1).bTp()) {
            nv(true);
        }
    }

    public void bUi() {
        if (bTR()) {
            a(this.hyw.bTy().getText().length(), this.hyw.bTt() / 2, 2, 20);
        } else if (bTS()) {
            int bTt = this.hyx.bTt() / 2;
            P(bTt, 15, 300);
            int i = 300 - bTt;
            this.hyx.bTs().setText(String.valueOf(i));
            if (i <= 50) {
                this.hyx.bTs().setVisibility(0);
            } else {
                this.hyx.bTs().setVisibility(8);
            }
            if (i == 0) {
                this.hyx.bTs().setTextColor(this.hxC.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.hyx.wo(300);
            } else {
                this.hyx.bTu();
            }
        } else if (bTU()) {
            if (this.hyz.bTh() != 3) {
                nv(true);
            } else {
                nv(false);
            }
        }
    }

    private void P(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            nv(true);
        } else {
            nv(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            nv(false);
        } else if (f >= i2 && f <= i3) {
            nv(true);
        } else {
            nv(false);
        }
        if (i < 1) {
            this.hyw.nt(false);
        } else {
            this.hyw.nt(true);
        }
    }

    public void setData(int i, int i2) {
        this.hyt = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.hxC.getLayoutMode().setNightMode(i == 1);
        this.hxC.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bUb();
        am.setViewTextColor(this.hyr, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void d(EditText editText) {
        ((InputMethodManager) this.hxC.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
