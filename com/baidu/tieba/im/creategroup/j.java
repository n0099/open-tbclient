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
/* loaded from: classes5.dex */
public class j extends com.baidu.adp.base.c {
    private boolean aJE;
    private String business;
    private View cNA;
    CreateGroupStepAdapter gCU;
    private int gCV;
    private TextView gCW;
    private com.baidu.tbadk.core.dialog.i gCX;
    int gCY;
    e gCZ;
    CreateGroupStepActivity gCh;
    private int gCl;
    h gDa;
    g gDb;
    d gDc;
    i gDd;
    b gDe;
    private NoSwipeableViewPager gDf;
    private com.baidu.tieba.im.util.b gDg;
    private int gDh;
    private int gDi;
    private int gDj;
    private int gDk;
    private int gDl;
    private boolean gDm;
    private String gDn;
    private String gDo;
    private String gDp;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void xu(String str) {
        this.gDo = str;
    }

    public void xv(String str) {
        this.gDp = str;
    }

    public String bzk() {
        return this.gDo;
    }

    public String bzl() {
        return this.gDp;
    }

    public View bzm() {
        return this.cNA;
    }

    public int bzn() {
        return this.gCV;
    }

    public View bzo() {
        return this.gCW;
    }

    public View bzp() {
        if (this.gCZ != null) {
            return this.gCZ.byZ();
        }
        if (this.gDa != null) {
            return this.gDa.byZ();
        }
        return null;
    }

    public View bzq() {
        return this.gDd.bzh();
    }

    public View bzr() {
        return this.gDd.bzg();
    }

    public boolean bzs() {
        return this.mIsLoading;
    }

    public void byM() {
        this.gDe.byM();
        bzN();
    }

    public void xw(String str) {
        this.gDn = str;
    }

    public String DL() {
        return this.gDn;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gDe.setBusiness(str);
        bzN();
    }

    public String getBusiness() {
        return this.business;
    }

    public void xx(String str) {
        this.gDe.setAddress(str);
        bzN();
    }

    public boolean bzt() {
        return this.gDm;
    }

    public void lM(boolean z) {
        this.gDm = z;
    }

    public void byN() {
        this.gDe.byN();
        bzN();
    }

    public void byO() {
        this.gDe.byO();
        bzN();
    }

    public View bzu() {
        return this.gDe.byK();
    }

    public int byL() {
        return this.gDe.byL();
    }

    public View bzv() {
        return this.gDb.bzd();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gDb.bzc().getText().toString();
    }

    public String getIntro() {
        return this.gDc.byV().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gCY;
    }

    public boolean bzw() {
        return this.gDb != null && this.gCV == this.gDb.byJ();
    }

    public boolean bzx() {
        return this.gDc != null && this.gCV == this.gDc.byJ();
    }

    public boolean bzy() {
        return this.gDd != null && this.gCV == this.gDd.byJ();
    }

    public boolean bzz() {
        return this.gDe != null && this.gCV == this.gDe.byJ();
    }

    public boolean bzA() {
        return this.gCU != null && this.gCV == this.gCU.getCount();
    }

    public String getErrMsg() {
        if (this.gCU.tU(this.gCV - 1) != null) {
            return this.gCU.tU(this.gCV - 1).getErrMsg();
        }
        return null;
    }

    public void bzB() {
        this.gDd.bzh().setText(R.string.group_create_modify_photo_tip);
    }

    public void bzC() {
        this.gDd.bzf();
    }

    public void tI() {
        this.gDb.bze();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.aJE = true;
        this.mIsLoading = false;
        this.gCh = null;
        this.gCU = null;
        this.progressBar = null;
        this.gCV = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cNA = null;
        this.gCW = null;
        this.gCX = null;
        this.gCY = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gCZ = null;
        this.gDa = null;
        this.gDb = null;
        this.gDc = null;
        this.gDd = null;
        this.gDe = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gDf = null;
        this.gDg = null;
        this.gDm = false;
        this.gDn = "";
        this.business = "";
        this.gDo = null;
        this.gDp = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gDg = new com.baidu.tieba.im.util.b(this.gCh);
        this.gDg.setUniqueId(this.gCh.getUniqueId());
        bzD();
    }

    public void bzD() {
        this.gDg.startLoad();
    }

    public void bzE() {
        if (this.gDg != null) {
            this.gDg.cancelLoad();
        }
    }

    private void initListener() {
        this.cNA.setOnClickListener(this.gCh);
        this.gCW.setOnClickListener(this.gCh);
        this.gDb.bzc().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gDb.bzc().addTextChangedListener(this.gCh);
        this.gDc.byV().addTextChangedListener(this.gCh);
        this.gDd.bzh().setOnClickListener(this.gCh);
        this.gDd.bzg().setOnClickListener(this.gCh);
        this.gDe.byK().setOnClickListener(this.gCh);
        if (this.gDa != null) {
            this.gDa.byZ().setOnClickListener(this.gCh);
        }
        if (this.gCZ != null) {
            this.gCZ.byZ().setOnClickListener(this.gCh);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gCh = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gDf = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gCU = new CreateGroupStepAdapter(this.gCh);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gDf.setAdapter(this.gCU);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cNA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bzL();
        this.gCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gCW.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        am.setBackgroundResource(this.gCW, R.drawable.s_navbar_button_bg);
        lN(false);
        bzM();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gDl = 1;
            this.gDk = 2;
            this.gDh = 3;
            this.gDi = 4;
            this.gDj = 5;
            this.gCZ = new e(createGroupStepActivity, this.gDl, i2);
            this.gDe = new b(createGroupStepActivity, this.gDk, 1, 5);
            this.gDb = new g(createGroupStepActivity, this.gDh, 2, 5);
            this.gDc = new d(createGroupStepActivity, this.gDi, 3, 5);
            this.gDd = new i(createGroupStepActivity, this.gDj, 4, 5);
            this.gCU.a(this.gCZ);
            this.gCU.a(this.gDe);
            this.gCU.a(this.gDb);
            this.gCU.a(this.gDc);
            this.gCU.a(this.gDd);
            this.gCl = 5;
        } else if (i == 2) {
            this.gDl = 1;
            this.gDh = 2;
            this.gDi = 3;
            this.gDj = 4;
            this.gDk = 5;
            this.gDa = new h(createGroupStepActivity, this.gDl, i3);
            this.gDb = new g(createGroupStepActivity, this.gDh, 1, 5);
            this.gDc = new d(createGroupStepActivity, this.gDi, 2, 5);
            this.gDd = new i(createGroupStepActivity, this.gDj, 3, 5);
            this.gDe = new b(createGroupStepActivity, this.gDk, 4, 5);
            this.gCU.a(this.gDa);
            this.gCU.a(this.gDb);
            this.gCU.a(this.gDc);
            this.gCU.a(this.gDd);
            this.gCU.a(this.gDe);
            this.gCl = 5;
        } else {
            this.gDh = 1;
            this.gDi = 2;
            this.gDj = 3;
            this.gDk = 4;
            this.gDb = new g(createGroupStepActivity, this.gDh, 1, 4);
            this.gDc = new d(createGroupStepActivity, this.gDi, 2, 4);
            this.gDd = new i(createGroupStepActivity, this.gDj, 3, 4);
            this.gDe = new b(createGroupStepActivity, this.gDk, 4, 4);
            this.gCU.a(this.gDb);
            this.gCU.a(this.gDc);
            this.gCU.a(this.gDd);
            this.gCU.a(this.gDe);
            this.gCl = 4;
        }
    }

    private void lN(boolean z) {
        this.aJE = z;
        bzG();
    }

    public boolean bzF() {
        return this.aJE;
    }

    private void bzG() {
        this.gCW.setEnabled(this.aJE);
        am.setBackgroundResource(this.gCW, R.drawable.s_navbar_button_bg);
    }

    public void bzH() {
        if (this.gCV > 1) {
            this.gCV--;
            bzJ();
        }
    }

    public void bzI() {
        if (this.gCV < this.gCl) {
            this.gCV++;
            bzJ();
        }
    }

    public void bzJ() {
        this.gDf.setCurrentItem(this.gCV - 1);
        bzL();
        bzM();
        bzN();
        this.gDb.bzc().clearFocus();
        this.gDc.byV().clearFocus();
        f(this.gDb.bzc());
        f(this.gDc.byV());
        if (bzy() && bzs()) {
            bzo().setEnabled(false);
        } else {
            bzo().setEnabled(true);
        }
    }

    public void bzK() {
        String[] strArr = {this.gCh.getResources().getString(R.string.take_photo), this.gCh.getResources().getString(R.string.album)};
        if (this.gCX == null) {
            this.gCX = new com.baidu.tbadk.core.dialog.i(this.gCh.getPageContext());
            this.gCX.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gCX != null && j.this.gCX.isShowing() && j.this.gCh != null) {
                        j.this.gCX.dismiss();
                    }
                    Activity pageActivity = j.this.gCh.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    j.this.mPermissionJudgement.clearRequestPermissionList();
                    j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                        if (i == 0) {
                            al.c(j.this.gCh.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gCh.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gCX.showDialog();
    }

    public void av(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gCh.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.gCh.getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void xy(String str) {
        if (!this.gCW.getText().toString().equals(str)) {
            this.gCW.setText(str);
        }
    }

    private void bzL() {
        if (this.gCU.tU(this.gCV - 1) != null) {
            this.mNavigationBar.setTitleText(this.gCU.tU(this.gCV - 1).getTitle());
        }
    }

    public void bzM() {
        for (o oVar : this.gCU.getList()) {
            if (oVar.byJ() == this.gCV) {
                oVar.byQ();
                if (!oVar.byU()) {
                    this.gCW.setVisibility(8);
                } else {
                    this.gCW.setVisibility(0);
                }
                xy(oVar.byS());
            } else {
                oVar.byP();
            }
        }
        if (this.gCU.tU(this.gCV - 1) != null && this.gCU.tU(this.gCV - 1).byT()) {
            lN(true);
        }
    }

    public void bzN() {
        if (bzw()) {
            a(this.gDb.bzc().getText().length(), this.gDb.byX() / 2, 2, 20);
        } else if (bzx()) {
            int byX = this.gDc.byX() / 2;
            O(byX, 15, 300);
            int i = 300 - byX;
            this.gDc.byW().setText(String.valueOf(i));
            if (i <= 50) {
                this.gDc.byW().setVisibility(0);
            } else {
                this.gDc.byW().setVisibility(8);
            }
            if (i == 0) {
                this.gDc.byW().setTextColor(this.gCh.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gDc.tT(300);
            } else {
                this.gDc.byY();
            }
        } else if (bzz()) {
            if (this.gDe.byL() != 3) {
                lN(true);
            } else {
                lN(false);
            }
        }
    }

    private void O(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            lN(true);
        } else {
            lN(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            lN(false);
        } else if (f >= i2 && f <= i3) {
            lN(true);
        } else {
            lN(false);
        }
        if (i < 1) {
            this.gDb.lL(false);
        } else {
            this.gDb.lL(true);
        }
    }

    public void setData(int i, int i2) {
        this.gCY = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gCh.getLayoutMode().setNightMode(i == 1);
        this.gCh.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bzG();
        am.setViewTextColor(this.gCW, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.isFlymeOsAbove35()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.setBackgroundColor(viewGroup, R.color.common_color_10041);
    }

    public void f(EditText editText) {
        ((InputMethodManager) this.gCh.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
