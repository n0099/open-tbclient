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
    CreateGroupStepAdapter gwO;
    private int gwP;
    private TextView gwQ;
    private com.baidu.tbadk.core.dialog.i gwR;
    int gwS;
    e gwT;
    h gwU;
    g gwV;
    d gwW;
    i gwX;
    b gwY;
    private NoSwipeableViewPager gwZ;
    CreateGroupStepActivity gwb;
    private int gwf;
    private com.baidu.tieba.im.util.b gxa;
    private int gxb;
    private int gxc;
    private int gxd;
    private int gxe;
    private int gxf;
    private boolean gxg;
    private String gxh;
    private String gxi;
    private String gxj;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void xP(String str) {
        this.gxi = str;
    }

    public void xQ(String str) {
        this.gxj = str;
    }

    public String byQ() {
        return this.gxi;
    }

    public String byR() {
        return this.gxj;
    }

    public View byS() {
        return this.cAN;
    }

    public int byT() {
        return this.gwP;
    }

    public View byU() {
        return this.gwQ;
    }

    public View byV() {
        if (this.gwT != null) {
            return this.gwT.byF();
        }
        if (this.gwU != null) {
            return this.gwU.byF();
        }
        return null;
    }

    public View byW() {
        return this.gwX.byN();
    }

    public View byX() {
        return this.gwX.byM();
    }

    public boolean byY() {
        return this.mIsLoading;
    }

    public void byt() {
        this.gwY.byt();
        bzt();
    }

    public void xR(String str) {
        this.gxh = str;
    }

    public String yg() {
        return this.gxh;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gwY.setBusiness(str);
        bzt();
    }

    public String getBusiness() {
        return this.business;
    }

    public void xS(String str) {
        this.gwY.setAddress(str);
        bzt();
    }

    public boolean byZ() {
        return this.gxg;
    }

    public void lG(boolean z) {
        this.gxg = z;
    }

    public void byu() {
        this.gwY.byu();
        bzt();
    }

    public void byv() {
        this.gwY.byv();
        bzt();
    }

    public View bza() {
        return this.gwY.byr();
    }

    public int bys() {
        return this.gwY.bys();
    }

    public View bzb() {
        return this.gwV.byJ();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gwV.byI().getText().toString();
    }

    public String getIntro() {
        return this.gwW.byC().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gwS;
    }

    public boolean bzc() {
        return this.gwV != null && this.gwP == this.gwV.byq();
    }

    public boolean bzd() {
        return this.gwW != null && this.gwP == this.gwW.byq();
    }

    public boolean bze() {
        return this.gwX != null && this.gwP == this.gwX.byq();
    }

    public boolean bzf() {
        return this.gwY != null && this.gwP == this.gwY.byq();
    }

    public boolean bzg() {
        return this.gwO != null && this.gwP == this.gwO.getCount();
    }

    public String getErrMsg() {
        if (this.gwO.uJ(this.gwP - 1) != null) {
            return this.gwO.uJ(this.gwP - 1).getErrMsg();
        }
        return null;
    }

    public void bzh() {
        this.gwX.byN().setText(R.string.group_create_modify_photo_tip);
    }

    public void bzi() {
        this.gwX.byL();
    }

    public void clearText() {
        this.gwV.byK();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.apF = true;
        this.mIsLoading = false;
        this.gwb = null;
        this.gwO = null;
        this.progressBar = null;
        this.gwP = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cAN = null;
        this.gwQ = null;
        this.gwR = null;
        this.gwS = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gwT = null;
        this.gwU = null;
        this.gwV = null;
        this.gwW = null;
        this.gwX = null;
        this.gwY = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gwZ = null;
        this.gxa = null;
        this.gxg = false;
        this.gxh = "";
        this.business = "";
        this.gxi = null;
        this.gxj = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gxa = new com.baidu.tieba.im.util.b(this.gwb);
        this.gxa.setUniqueId(this.gwb.getUniqueId());
        bzj();
    }

    public void bzj() {
        this.gxa.awN();
    }

    public void bzk() {
        if (this.gxa != null) {
            this.gxa.cancelLoad();
        }
    }

    private void initListener() {
        this.cAN.setOnClickListener(this.gwb);
        this.gwQ.setOnClickListener(this.gwb);
        this.gwV.byI().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gwV.byI().addTextChangedListener(this.gwb);
        this.gwW.byC().addTextChangedListener(this.gwb);
        this.gwX.byN().setOnClickListener(this.gwb);
        this.gwX.byM().setOnClickListener(this.gwb);
        this.gwY.byr().setOnClickListener(this.gwb);
        if (this.gwU != null) {
            this.gwU.byF().setOnClickListener(this.gwb);
        }
        if (this.gwT != null) {
            this.gwT.byF().setOnClickListener(this.gwb);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gwb = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gwZ = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gwO = new CreateGroupStepAdapter(this.gwb);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gwZ.setAdapter(this.gwO);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bzr();
        this.gwQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gwQ.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        al.k(this.gwQ, R.drawable.s_navbar_button_bg);
        lH(false);
        bzs();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gxf = 1;
            this.gxe = 2;
            this.gxb = 3;
            this.gxc = 4;
            this.gxd = 5;
            this.gwT = new e(createGroupStepActivity, this.gxf, i2);
            this.gwY = new b(createGroupStepActivity, this.gxe, 1, 5);
            this.gwV = new g(createGroupStepActivity, this.gxb, 2, 5);
            this.gwW = new d(createGroupStepActivity, this.gxc, 3, 5);
            this.gwX = new i(createGroupStepActivity, this.gxd, 4, 5);
            this.gwO.a(this.gwT);
            this.gwO.a(this.gwY);
            this.gwO.a(this.gwV);
            this.gwO.a(this.gwW);
            this.gwO.a(this.gwX);
            this.gwf = 5;
        } else if (i == 2) {
            this.gxf = 1;
            this.gxb = 2;
            this.gxc = 3;
            this.gxd = 4;
            this.gxe = 5;
            this.gwU = new h(createGroupStepActivity, this.gxf, i3);
            this.gwV = new g(createGroupStepActivity, this.gxb, 1, 5);
            this.gwW = new d(createGroupStepActivity, this.gxc, 2, 5);
            this.gwX = new i(createGroupStepActivity, this.gxd, 3, 5);
            this.gwY = new b(createGroupStepActivity, this.gxe, 4, 5);
            this.gwO.a(this.gwU);
            this.gwO.a(this.gwV);
            this.gwO.a(this.gwW);
            this.gwO.a(this.gwX);
            this.gwO.a(this.gwY);
            this.gwf = 5;
        } else {
            this.gxb = 1;
            this.gxc = 2;
            this.gxd = 3;
            this.gxe = 4;
            this.gwV = new g(createGroupStepActivity, this.gxb, 1, 4);
            this.gwW = new d(createGroupStepActivity, this.gxc, 2, 4);
            this.gwX = new i(createGroupStepActivity, this.gxd, 3, 4);
            this.gwY = new b(createGroupStepActivity, this.gxe, 4, 4);
            this.gwO.a(this.gwV);
            this.gwO.a(this.gwW);
            this.gwO.a(this.gwX);
            this.gwO.a(this.gwY);
            this.gwf = 4;
        }
    }

    private void lH(boolean z) {
        this.apF = z;
        bzm();
    }

    public boolean bzl() {
        return this.apF;
    }

    private void bzm() {
        this.gwQ.setEnabled(this.apF);
        al.k(this.gwQ, R.drawable.s_navbar_button_bg);
    }

    public void bzn() {
        if (this.gwP > 1) {
            this.gwP--;
            bzp();
        }
    }

    public void bzo() {
        if (this.gwP < this.gwf) {
            this.gwP++;
            bzp();
        }
    }

    public void bzp() {
        this.gwZ.setCurrentItem(this.gwP - 1);
        bzr();
        bzs();
        bzt();
        this.gwV.byI().clearFocus();
        this.gwW.byC().clearFocus();
        g(this.gwV.byI());
        g(this.gwW.byC());
        if (bze() && byY()) {
            byU().setEnabled(false);
        } else {
            byU().setEnabled(true);
        }
    }

    public void bzq() {
        String[] strArr = {this.gwb.getResources().getString(R.string.take_photo), this.gwb.getResources().getString(R.string.album)};
        if (this.gwR == null) {
            this.gwR = new com.baidu.tbadk.core.dialog.i(this.gwb.getPageContext());
            this.gwR.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gwR != null && j.this.gwR.isShowing() && j.this.gwb != null) {
                        j.this.gwR.dismiss();
                    }
                    Activity pageActivity = j.this.gwb.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.aiM();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.aa(pageActivity)) {
                        if (i == 0) {
                            ak.c(j.this.gwb.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gwb.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gwR.showDialog();
    }

    public void al(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gwb.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.aa(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gwb.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void xT(String str) {
        if (!this.gwQ.getText().toString().equals(str)) {
            this.gwQ.setText(str);
        }
    }

    private void bzr() {
        if (this.gwO.uJ(this.gwP - 1) != null) {
            this.mNavigationBar.setTitleText(this.gwO.uJ(this.gwP - 1).getTitle());
        }
    }

    public void bzs() {
        for (o oVar : this.gwO.getList()) {
            if (oVar.byq() == this.gwP) {
                oVar.byx();
                if (!oVar.byB()) {
                    this.gwQ.setVisibility(8);
                } else {
                    this.gwQ.setVisibility(0);
                }
                xT(oVar.byz());
            } else {
                oVar.byw();
            }
        }
        if (this.gwO.uJ(this.gwP - 1) != null && this.gwO.uJ(this.gwP - 1).byA()) {
            lH(true);
        }
    }

    public void bzt() {
        if (bzc()) {
            a(this.gwV.byI().getText().length(), this.gwV.getLength() / 2, 2, 20);
        } else if (bzd()) {
            int length = this.gwW.getLength() / 2;
            V(length, 15, 300);
            int i = 300 - length;
            this.gwW.byD().setText(String.valueOf(i));
            if (i <= 50) {
                this.gwW.byD().setVisibility(0);
            } else {
                this.gwW.byD().setVisibility(8);
            }
            if (i == 0) {
                this.gwW.byD().setTextColor(this.gwb.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gwW.uI(300);
            } else {
                this.gwW.byE();
            }
        } else if (bzf()) {
            if (this.gwY.bys() != 3) {
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
            this.gwV.lF(false);
        } else {
            this.gwV.lF(true);
        }
    }

    public void setData(int i, int i2) {
        this.gwS = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gwb.getLayoutMode().setNightMode(i == 1);
        this.gwb.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bzm();
        al.f(this.gwQ, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.kl()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.l(viewGroup, R.color.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gwb.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
