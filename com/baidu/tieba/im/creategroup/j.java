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
    private View cAN;
    CreateGroupStepAdapter gwP;
    private int gwQ;
    private TextView gwR;
    private com.baidu.tbadk.core.dialog.i gwS;
    int gwT;
    e gwU;
    h gwV;
    g gwW;
    d gwX;
    i gwY;
    b gwZ;
    CreateGroupStepActivity gwc;
    private int gwg;
    private NoSwipeableViewPager gxa;
    private com.baidu.tieba.im.util.b gxb;
    private int gxc;
    private int gxd;
    private int gxe;
    private int gxf;
    private int gxg;
    private boolean gxh;
    private String gxi;
    private String gxj;
    private String gxk;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void xP(String str) {
        this.gxj = str;
    }

    public void xQ(String str) {
        this.gxk = str;
    }

    public String byT() {
        return this.gxj;
    }

    public String byU() {
        return this.gxk;
    }

    public View byV() {
        return this.cAN;
    }

    public int byW() {
        return this.gwQ;
    }

    public View byX() {
        return this.gwR;
    }

    public View byY() {
        if (this.gwU != null) {
            return this.gwU.byI();
        }
        if (this.gwV != null) {
            return this.gwV.byI();
        }
        return null;
    }

    public View byZ() {
        return this.gwY.byQ();
    }

    public View bza() {
        return this.gwY.byP();
    }

    public boolean bzb() {
        return this.mIsLoading;
    }

    public void byw() {
        this.gwZ.byw();
        bzw();
    }

    public void xR(String str) {
        this.gxi = str;
    }

    public String yg() {
        return this.gxi;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gwZ.setBusiness(str);
        bzw();
    }

    public String getBusiness() {
        return this.business;
    }

    public void xS(String str) {
        this.gwZ.setAddress(str);
        bzw();
    }

    public boolean bzc() {
        return this.gxh;
    }

    public void lG(boolean z) {
        this.gxh = z;
    }

    public void byx() {
        this.gwZ.byx();
        bzw();
    }

    public void byy() {
        this.gwZ.byy();
        bzw();
    }

    public View bzd() {
        return this.gwZ.byu();
    }

    public int byv() {
        return this.gwZ.byv();
    }

    public View bze() {
        return this.gwW.byM();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gwW.byL().getText().toString();
    }

    public String getIntro() {
        return this.gwX.byF().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gwT;
    }

    public boolean bzf() {
        return this.gwW != null && this.gwQ == this.gwW.byt();
    }

    public boolean bzg() {
        return this.gwX != null && this.gwQ == this.gwX.byt();
    }

    public boolean bzh() {
        return this.gwY != null && this.gwQ == this.gwY.byt();
    }

    public boolean bzi() {
        return this.gwZ != null && this.gwQ == this.gwZ.byt();
    }

    public boolean bzj() {
        return this.gwP != null && this.gwQ == this.gwP.getCount();
    }

    public String getErrMsg() {
        if (this.gwP.uJ(this.gwQ - 1) != null) {
            return this.gwP.uJ(this.gwQ - 1).getErrMsg();
        }
        return null;
    }

    public void bzk() {
        this.gwY.byQ().setText(R.string.group_create_modify_photo_tip);
    }

    public void bzl() {
        this.gwY.byO();
    }

    public void clearText() {
        this.gwW.byN();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.apF = true;
        this.mIsLoading = false;
        this.gwc = null;
        this.gwP = null;
        this.progressBar = null;
        this.gwQ = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cAN = null;
        this.gwR = null;
        this.gwS = null;
        this.gwT = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gwU = null;
        this.gwV = null;
        this.gwW = null;
        this.gwX = null;
        this.gwY = null;
        this.gwZ = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gxa = null;
        this.gxb = null;
        this.gxh = false;
        this.gxi = "";
        this.business = "";
        this.gxj = null;
        this.gxk = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gxb = new com.baidu.tieba.im.util.b(this.gwc);
        this.gxb.setUniqueId(this.gwc.getUniqueId());
        bzm();
    }

    public void bzm() {
        this.gxb.awO();
    }

    public void bzn() {
        if (this.gxb != null) {
            this.gxb.cancelLoad();
        }
    }

    private void initListener() {
        this.cAN.setOnClickListener(this.gwc);
        this.gwR.setOnClickListener(this.gwc);
        this.gwW.byL().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gwW.byL().addTextChangedListener(this.gwc);
        this.gwX.byF().addTextChangedListener(this.gwc);
        this.gwY.byQ().setOnClickListener(this.gwc);
        this.gwY.byP().setOnClickListener(this.gwc);
        this.gwZ.byu().setOnClickListener(this.gwc);
        if (this.gwV != null) {
            this.gwV.byI().setOnClickListener(this.gwc);
        }
        if (this.gwU != null) {
            this.gwU.byI().setOnClickListener(this.gwc);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gwc = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gxa = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gwP = new CreateGroupStepAdapter(this.gwc);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gxa.setAdapter(this.gwP);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bzu();
        this.gwR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gwR.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        al.k(this.gwR, R.drawable.s_navbar_button_bg);
        lH(false);
        bzv();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gxg = 1;
            this.gxf = 2;
            this.gxc = 3;
            this.gxd = 4;
            this.gxe = 5;
            this.gwU = new e(createGroupStepActivity, this.gxg, i2);
            this.gwZ = new b(createGroupStepActivity, this.gxf, 1, 5);
            this.gwW = new g(createGroupStepActivity, this.gxc, 2, 5);
            this.gwX = new d(createGroupStepActivity, this.gxd, 3, 5);
            this.gwY = new i(createGroupStepActivity, this.gxe, 4, 5);
            this.gwP.a(this.gwU);
            this.gwP.a(this.gwZ);
            this.gwP.a(this.gwW);
            this.gwP.a(this.gwX);
            this.gwP.a(this.gwY);
            this.gwg = 5;
        } else if (i == 2) {
            this.gxg = 1;
            this.gxc = 2;
            this.gxd = 3;
            this.gxe = 4;
            this.gxf = 5;
            this.gwV = new h(createGroupStepActivity, this.gxg, i3);
            this.gwW = new g(createGroupStepActivity, this.gxc, 1, 5);
            this.gwX = new d(createGroupStepActivity, this.gxd, 2, 5);
            this.gwY = new i(createGroupStepActivity, this.gxe, 3, 5);
            this.gwZ = new b(createGroupStepActivity, this.gxf, 4, 5);
            this.gwP.a(this.gwV);
            this.gwP.a(this.gwW);
            this.gwP.a(this.gwX);
            this.gwP.a(this.gwY);
            this.gwP.a(this.gwZ);
            this.gwg = 5;
        } else {
            this.gxc = 1;
            this.gxd = 2;
            this.gxe = 3;
            this.gxf = 4;
            this.gwW = new g(createGroupStepActivity, this.gxc, 1, 4);
            this.gwX = new d(createGroupStepActivity, this.gxd, 2, 4);
            this.gwY = new i(createGroupStepActivity, this.gxe, 3, 4);
            this.gwZ = new b(createGroupStepActivity, this.gxf, 4, 4);
            this.gwP.a(this.gwW);
            this.gwP.a(this.gwX);
            this.gwP.a(this.gwY);
            this.gwP.a(this.gwZ);
            this.gwg = 4;
        }
    }

    private void lH(boolean z) {
        this.apF = z;
        bzp();
    }

    public boolean bzo() {
        return this.apF;
    }

    private void bzp() {
        this.gwR.setEnabled(this.apF);
        al.k(this.gwR, R.drawable.s_navbar_button_bg);
    }

    public void bzq() {
        if (this.gwQ > 1) {
            this.gwQ--;
            bzs();
        }
    }

    public void bzr() {
        if (this.gwQ < this.gwg) {
            this.gwQ++;
            bzs();
        }
    }

    public void bzs() {
        this.gxa.setCurrentItem(this.gwQ - 1);
        bzu();
        bzv();
        bzw();
        this.gwW.byL().clearFocus();
        this.gwX.byF().clearFocus();
        g(this.gwW.byL());
        g(this.gwX.byF());
        if (bzh() && bzb()) {
            byX().setEnabled(false);
        } else {
            byX().setEnabled(true);
        }
    }

    public void bzt() {
        String[] strArr = {this.gwc.getResources().getString(R.string.take_photo), this.gwc.getResources().getString(R.string.album)};
        if (this.gwS == null) {
            this.gwS = new com.baidu.tbadk.core.dialog.i(this.gwc.getPageContext());
            this.gwS.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gwS != null && j.this.gwS.isShowing() && j.this.gwc != null) {
                        j.this.gwS.dismiss();
                    }
                    Activity pageActivity = j.this.gwc.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.aiM();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.aa(pageActivity)) {
                        if (i == 0) {
                            ak.c(j.this.gwc.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gwc.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gwS.showDialog();
    }

    public void al(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gwc.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.aa(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gwc.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void xT(String str) {
        if (!this.gwR.getText().toString().equals(str)) {
            this.gwR.setText(str);
        }
    }

    private void bzu() {
        if (this.gwP.uJ(this.gwQ - 1) != null) {
            this.mNavigationBar.setTitleText(this.gwP.uJ(this.gwQ - 1).getTitle());
        }
    }

    public void bzv() {
        for (o oVar : this.gwP.getList()) {
            if (oVar.byt() == this.gwQ) {
                oVar.byA();
                if (!oVar.byE()) {
                    this.gwR.setVisibility(8);
                } else {
                    this.gwR.setVisibility(0);
                }
                xT(oVar.byC());
            } else {
                oVar.byz();
            }
        }
        if (this.gwP.uJ(this.gwQ - 1) != null && this.gwP.uJ(this.gwQ - 1).byD()) {
            lH(true);
        }
    }

    public void bzw() {
        if (bzf()) {
            a(this.gwW.byL().getText().length(), this.gwW.getLength() / 2, 2, 20);
        } else if (bzg()) {
            int length = this.gwX.getLength() / 2;
            V(length, 15, 300);
            int i = 300 - length;
            this.gwX.byG().setText(String.valueOf(i));
            if (i <= 50) {
                this.gwX.byG().setVisibility(0);
            } else {
                this.gwX.byG().setVisibility(8);
            }
            if (i == 0) {
                this.gwX.byG().setTextColor(this.gwc.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gwX.uI(300);
            } else {
                this.gwX.byH();
            }
        } else if (bzi()) {
            if (this.gwZ.byv() != 3) {
                lH(true);
            } else {
                lH(false);
            }
        }
    }

    private void V(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            lH(true);
        } else {
            lH(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            lH(false);
        } else if (f >= i2 && f <= i3) {
            lH(true);
        } else {
            lH(false);
        }
        if (i < 1) {
            this.gwW.lF(false);
        } else {
            this.gwW.lF(true);
        }
    }

    public void setData(int i, int i2) {
        this.gwT = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gwc.getLayoutMode().setNightMode(i == 1);
        this.gwc.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bzp();
        al.f(this.gwR, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.kl()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.l(viewGroup, R.color.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gwc.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
