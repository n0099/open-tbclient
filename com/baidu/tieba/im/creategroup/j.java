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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes5.dex */
public class j extends com.baidu.adp.base.c {
    private boolean apF;
    private String business;
    private View cAO;
    CreateGroupStepAdapter gwR;
    private int gwS;
    private TextView gwT;
    private com.baidu.tbadk.core.dialog.i gwU;
    int gwV;
    e gwW;
    h gwX;
    g gwY;
    d gwZ;
    CreateGroupStepActivity gwe;
    private int gwi;
    i gxa;
    b gxb;
    private NoSwipeableViewPager gxc;
    private com.baidu.tieba.im.util.b gxd;
    private int gxe;
    private int gxf;
    private int gxg;
    private int gxh;
    private int gxi;
    private boolean gxj;
    private String gxk;
    private String gxl;
    private String gxm;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void xR(String str) {
        this.gxl = str;
    }

    public void xS(String str) {
        this.gxm = str;
    }

    public String byU() {
        return this.gxl;
    }

    public String byV() {
        return this.gxm;
    }

    public View byW() {
        return this.cAO;
    }

    public int byX() {
        return this.gwS;
    }

    public View byY() {
        return this.gwT;
    }

    public View byZ() {
        if (this.gwW != null) {
            return this.gwW.byJ();
        }
        if (this.gwX != null) {
            return this.gwX.byJ();
        }
        return null;
    }

    public View bza() {
        return this.gxa.byR();
    }

    public View bzb() {
        return this.gxa.byQ();
    }

    public boolean bzc() {
        return this.mIsLoading;
    }

    public void byx() {
        this.gxb.byx();
        bzx();
    }

    public void xT(String str) {
        this.gxk = str;
    }

    public String yg() {
        return this.gxk;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gxb.setBusiness(str);
        bzx();
    }

    public String getBusiness() {
        return this.business;
    }

    public void xU(String str) {
        this.gxb.setAddress(str);
        bzx();
    }

    public boolean bzd() {
        return this.gxj;
    }

    public void lH(boolean z) {
        this.gxj = z;
    }

    public void byy() {
        this.gxb.byy();
        bzx();
    }

    public void byz() {
        this.gxb.byz();
        bzx();
    }

    public View bze() {
        return this.gxb.byv();
    }

    public int byw() {
        return this.gxb.byw();
    }

    public View bzf() {
        return this.gwY.byN();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gwY.byM().getText().toString();
    }

    public String getIntro() {
        return this.gwZ.byG().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gwV;
    }

    public boolean bzg() {
        return this.gwY != null && this.gwS == this.gwY.byu();
    }

    public boolean bzh() {
        return this.gwZ != null && this.gwS == this.gwZ.byu();
    }

    public boolean bzi() {
        return this.gxa != null && this.gwS == this.gxa.byu();
    }

    public boolean bzj() {
        return this.gxb != null && this.gwS == this.gxb.byu();
    }

    public boolean bzk() {
        return this.gwR != null && this.gwS == this.gwR.getCount();
    }

    public String getErrMsg() {
        if (this.gwR.uJ(this.gwS - 1) != null) {
            return this.gwR.uJ(this.gwS - 1).getErrMsg();
        }
        return null;
    }

    public void bzl() {
        this.gxa.byR().setText(R.string.group_create_modify_photo_tip);
    }

    public void bzm() {
        this.gxa.byP();
    }

    public void clearText() {
        this.gwY.byO();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.apF = true;
        this.mIsLoading = false;
        this.gwe = null;
        this.gwR = null;
        this.progressBar = null;
        this.gwS = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cAO = null;
        this.gwT = null;
        this.gwU = null;
        this.gwV = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gwW = null;
        this.gwX = null;
        this.gwY = null;
        this.gwZ = null;
        this.gxa = null;
        this.gxb = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gxc = null;
        this.gxd = null;
        this.gxj = false;
        this.gxk = "";
        this.business = "";
        this.gxl = null;
        this.gxm = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gxd = new com.baidu.tieba.im.util.b(this.gwe);
        this.gxd.setUniqueId(this.gwe.getUniqueId());
        bzn();
    }

    public void bzn() {
        this.gxd.awO();
    }

    public void bzo() {
        if (this.gxd != null) {
            this.gxd.cancelLoad();
        }
    }

    private void initListener() {
        this.cAO.setOnClickListener(this.gwe);
        this.gwT.setOnClickListener(this.gwe);
        this.gwY.byM().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gwY.byM().addTextChangedListener(this.gwe);
        this.gwZ.byG().addTextChangedListener(this.gwe);
        this.gxa.byR().setOnClickListener(this.gwe);
        this.gxa.byQ().setOnClickListener(this.gwe);
        this.gxb.byv().setOnClickListener(this.gwe);
        if (this.gwX != null) {
            this.gwX.byJ().setOnClickListener(this.gwe);
        }
        if (this.gwW != null) {
            this.gwW.byJ().setOnClickListener(this.gwe);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gwe = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gxc = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gwR = new CreateGroupStepAdapter(this.gwe);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gxc.setAdapter(this.gwR);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cAO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bzv();
        this.gwT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gwT.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        al.k(this.gwT, R.drawable.s_navbar_button_bg);
        lI(false);
        bzw();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gxi = 1;
            this.gxh = 2;
            this.gxe = 3;
            this.gxf = 4;
            this.gxg = 5;
            this.gwW = new e(createGroupStepActivity, this.gxi, i2);
            this.gxb = new b(createGroupStepActivity, this.gxh, 1, 5);
            this.gwY = new g(createGroupStepActivity, this.gxe, 2, 5);
            this.gwZ = new d(createGroupStepActivity, this.gxf, 3, 5);
            this.gxa = new i(createGroupStepActivity, this.gxg, 4, 5);
            this.gwR.a(this.gwW);
            this.gwR.a(this.gxb);
            this.gwR.a(this.gwY);
            this.gwR.a(this.gwZ);
            this.gwR.a(this.gxa);
            this.gwi = 5;
        } else if (i == 2) {
            this.gxi = 1;
            this.gxe = 2;
            this.gxf = 3;
            this.gxg = 4;
            this.gxh = 5;
            this.gwX = new h(createGroupStepActivity, this.gxi, i3);
            this.gwY = new g(createGroupStepActivity, this.gxe, 1, 5);
            this.gwZ = new d(createGroupStepActivity, this.gxf, 2, 5);
            this.gxa = new i(createGroupStepActivity, this.gxg, 3, 5);
            this.gxb = new b(createGroupStepActivity, this.gxh, 4, 5);
            this.gwR.a(this.gwX);
            this.gwR.a(this.gwY);
            this.gwR.a(this.gwZ);
            this.gwR.a(this.gxa);
            this.gwR.a(this.gxb);
            this.gwi = 5;
        } else {
            this.gxe = 1;
            this.gxf = 2;
            this.gxg = 3;
            this.gxh = 4;
            this.gwY = new g(createGroupStepActivity, this.gxe, 1, 4);
            this.gwZ = new d(createGroupStepActivity, this.gxf, 2, 4);
            this.gxa = new i(createGroupStepActivity, this.gxg, 3, 4);
            this.gxb = new b(createGroupStepActivity, this.gxh, 4, 4);
            this.gwR.a(this.gwY);
            this.gwR.a(this.gwZ);
            this.gwR.a(this.gxa);
            this.gwR.a(this.gxb);
            this.gwi = 4;
        }
    }

    private void lI(boolean z) {
        this.apF = z;
        bzq();
    }

    public boolean bzp() {
        return this.apF;
    }

    private void bzq() {
        this.gwT.setEnabled(this.apF);
        al.k(this.gwT, R.drawable.s_navbar_button_bg);
    }

    public void bzr() {
        if (this.gwS > 1) {
            this.gwS--;
            bzt();
        }
    }

    public void bzs() {
        if (this.gwS < this.gwi) {
            this.gwS++;
            bzt();
        }
    }

    public void bzt() {
        this.gxc.setCurrentItem(this.gwS - 1);
        bzv();
        bzw();
        bzx();
        this.gwY.byM().clearFocus();
        this.gwZ.byG().clearFocus();
        g(this.gwY.byM());
        g(this.gwZ.byG());
        if (bzi() && bzc()) {
            byY().setEnabled(false);
        } else {
            byY().setEnabled(true);
        }
    }

    public void bzu() {
        String[] strArr = {this.gwe.getResources().getString(R.string.take_photo), this.gwe.getResources().getString(R.string.album)};
        if (this.gwU == null) {
            this.gwU = new com.baidu.tbadk.core.dialog.i(this.gwe.getPageContext());
            this.gwU.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gwU != null && j.this.gwU.isShowing() && j.this.gwe != null) {
                        j.this.gwU.dismiss();
                    }
                    Activity pageActivity = j.this.gwe.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.aiM();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.aa(pageActivity)) {
                        if (i == 0) {
                            ak.c(j.this.gwe.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gwe.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gwU.showDialog();
    }

    public void al(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gwe.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.aa(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gwe.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void xV(String str) {
        if (!this.gwT.getText().toString().equals(str)) {
            this.gwT.setText(str);
        }
    }

    private void bzv() {
        if (this.gwR.uJ(this.gwS - 1) != null) {
            this.mNavigationBar.setTitleText(this.gwR.uJ(this.gwS - 1).getTitle());
        }
    }

    public void bzw() {
        for (o oVar : this.gwR.getList()) {
            if (oVar.byu() == this.gwS) {
                oVar.byB();
                if (!oVar.byF()) {
                    this.gwT.setVisibility(8);
                } else {
                    this.gwT.setVisibility(0);
                }
                xV(oVar.byD());
            } else {
                oVar.byA();
            }
        }
        if (this.gwR.uJ(this.gwS - 1) != null && this.gwR.uJ(this.gwS - 1).byE()) {
            lI(true);
        }
    }

    public void bzx() {
        if (bzg()) {
            a(this.gwY.byM().getText().length(), this.gwY.getLength() / 2, 2, 20);
        } else if (bzh()) {
            int length = this.gwZ.getLength() / 2;
            V(length, 15, 300);
            int i = 300 - length;
            this.gwZ.byH().setText(String.valueOf(i));
            if (i <= 50) {
                this.gwZ.byH().setVisibility(0);
            } else {
                this.gwZ.byH().setVisibility(8);
            }
            if (i == 0) {
                this.gwZ.byH().setTextColor(this.gwe.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gwZ.uI(300);
            } else {
                this.gwZ.byI();
            }
        } else if (bzj()) {
            if (this.gxb.byw() != 3) {
                lI(true);
            } else {
                lI(false);
            }
        }
    }

    private void V(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            lI(true);
        } else {
            lI(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            lI(false);
        } else if (f >= i2 && f <= i3) {
            lI(true);
        } else {
            lI(false);
        }
        if (i < 1) {
            this.gwY.lG(false);
        } else {
            this.gwY.lG(true);
        }
    }

    public void setData(int i, int i2) {
        this.gwV = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gwe.getLayoutMode().setNightMode(i == 1);
        this.gwe.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bzq();
        al.f(this.gwT, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.kl()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.l(viewGroup, R.color.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gwe.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
