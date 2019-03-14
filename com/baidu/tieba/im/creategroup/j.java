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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes5.dex */
public class j extends com.baidu.adp.base.c {
    private boolean apn;
    private String business;
    private View csB;
    CreateGroupStepAdapter gfO;
    private int gfP;
    private TextView gfQ;
    private com.baidu.tbadk.core.dialog.g gfR;
    int gfS;
    e gfT;
    h gfU;
    g gfV;
    d gfW;
    i gfX;
    b gfY;
    private NoSwipeableViewPager gfZ;
    CreateGroupStepActivity gfb;
    private int gff;
    private com.baidu.tieba.im.util.b gga;
    private int ggb;
    private int ggc;
    private int ggd;
    private int gge;
    private int ggf;
    private boolean ggg;
    private String ggh;
    private String ggi;
    private String ggj;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void wB(String str) {
        this.ggi = str;
    }

    public void wC(String str) {
        this.ggj = str;
    }

    public String brh() {
        return this.ggi;
    }

    public String bri() {
        return this.ggj;
    }

    public View brj() {
        return this.csB;
    }

    public int brk() {
        return this.gfP;
    }

    public View brl() {
        return this.gfQ;
    }

    public View brm() {
        if (this.gfT != null) {
            return this.gfT.bqW();
        }
        if (this.gfU != null) {
            return this.gfU.bqW();
        }
        return null;
    }

    public View brn() {
        return this.gfX.bre();
    }

    public View bro() {
        return this.gfX.brd();
    }

    public boolean brp() {
        return this.mIsLoading;
    }

    public void bqK() {
        this.gfY.bqK();
        brK();
    }

    public void wD(String str) {
        this.ggh = str;
    }

    public String xp() {
        return this.ggh;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gfY.setBusiness(str);
        brK();
    }

    public String getBusiness() {
        return this.business;
    }

    public void wE(String str) {
        this.gfY.setAddress(str);
        brK();
    }

    public boolean brq() {
        return this.ggg;
    }

    public void kR(boolean z) {
        this.ggg = z;
    }

    public void bqL() {
        this.gfY.bqL();
        brK();
    }

    public void bqM() {
        this.gfY.bqM();
        brK();
    }

    public View brr() {
        return this.gfY.bqI();
    }

    public int bqJ() {
        return this.gfY.bqJ();
    }

    public View brs() {
        return this.gfV.bra();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gfV.bqZ().getText().toString();
    }

    public String getIntro() {
        return this.gfW.bqT().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gfS;
    }

    public boolean brt() {
        return this.gfV != null && this.gfP == this.gfV.bqH();
    }

    public boolean bru() {
        return this.gfW != null && this.gfP == this.gfW.bqH();
    }

    public boolean brv() {
        return this.gfX != null && this.gfP == this.gfX.bqH();
    }

    public boolean brw() {
        return this.gfY != null && this.gfP == this.gfY.bqH();
    }

    public boolean brx() {
        return this.gfO != null && this.gfP == this.gfO.getCount();
    }

    public String getErrMsg() {
        if (this.gfO.tG(this.gfP - 1) != null) {
            return this.gfO.tG(this.gfP - 1).getErrMsg();
        }
        return null;
    }

    public void bry() {
        this.gfX.bre().setText(d.j.group_create_modify_photo_tip);
    }

    public void brz() {
        this.gfX.brc();
    }

    public void clearText() {
        this.gfV.brb();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.apn = true;
        this.mIsLoading = false;
        this.gfb = null;
        this.gfO = null;
        this.progressBar = null;
        this.gfP = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.csB = null;
        this.gfQ = null;
        this.gfR = null;
        this.gfS = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gfT = null;
        this.gfU = null;
        this.gfV = null;
        this.gfW = null;
        this.gfX = null;
        this.gfY = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gfZ = null;
        this.gga = null;
        this.ggg = false;
        this.ggh = "";
        this.business = "";
        this.ggi = null;
        this.ggj = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gga = new com.baidu.tieba.im.util.b(this.gfb);
        this.gga.setUniqueId(this.gfb.getUniqueId());
        brA();
    }

    public void brA() {
        this.gga.arK();
    }

    public void brB() {
        if (this.gga != null) {
            this.gga.cancelLoad();
        }
    }

    private void initListener() {
        this.csB.setOnClickListener(this.gfb);
        this.gfQ.setOnClickListener(this.gfb);
        this.gfV.bqZ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gfV.bqZ().addTextChangedListener(this.gfb);
        this.gfW.bqT().addTextChangedListener(this.gfb);
        this.gfX.bre().setOnClickListener(this.gfb);
        this.gfX.brd().setOnClickListener(this.gfb);
        this.gfY.bqI().setOnClickListener(this.gfb);
        if (this.gfU != null) {
            this.gfU.bqW().setOnClickListener(this.gfb);
        }
        if (this.gfT != null) {
            this.gfT.bqW().setOnClickListener(this.gfb);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gfb = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.gfZ = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.gfO = new CreateGroupStepAdapter(this.gfb);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gfZ.setAdapter(this.gfO);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        brI();
        this.gfQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.j.next_step));
        ((LinearLayout.LayoutParams) this.gfQ.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), d.e.ds16);
        al.k(this.gfQ, d.f.s_navbar_button_bg);
        kS(false);
        brJ();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.ggf = 1;
            this.gge = 2;
            this.ggb = 3;
            this.ggc = 4;
            this.ggd = 5;
            this.gfT = new e(createGroupStepActivity, this.ggf, i2);
            this.gfY = new b(createGroupStepActivity, this.gge, 1, 5);
            this.gfV = new g(createGroupStepActivity, this.ggb, 2, 5);
            this.gfW = new d(createGroupStepActivity, this.ggc, 3, 5);
            this.gfX = new i(createGroupStepActivity, this.ggd, 4, 5);
            this.gfO.a(this.gfT);
            this.gfO.a(this.gfY);
            this.gfO.a(this.gfV);
            this.gfO.a(this.gfW);
            this.gfO.a(this.gfX);
            this.gff = 5;
        } else if (i == 2) {
            this.ggf = 1;
            this.ggb = 2;
            this.ggc = 3;
            this.ggd = 4;
            this.gge = 5;
            this.gfU = new h(createGroupStepActivity, this.ggf, i3);
            this.gfV = new g(createGroupStepActivity, this.ggb, 1, 5);
            this.gfW = new d(createGroupStepActivity, this.ggc, 2, 5);
            this.gfX = new i(createGroupStepActivity, this.ggd, 3, 5);
            this.gfY = new b(createGroupStepActivity, this.gge, 4, 5);
            this.gfO.a(this.gfU);
            this.gfO.a(this.gfV);
            this.gfO.a(this.gfW);
            this.gfO.a(this.gfX);
            this.gfO.a(this.gfY);
            this.gff = 5;
        } else {
            this.ggb = 1;
            this.ggc = 2;
            this.ggd = 3;
            this.gge = 4;
            this.gfV = new g(createGroupStepActivity, this.ggb, 1, 4);
            this.gfW = new d(createGroupStepActivity, this.ggc, 2, 4);
            this.gfX = new i(createGroupStepActivity, this.ggd, 3, 4);
            this.gfY = new b(createGroupStepActivity, this.gge, 4, 4);
            this.gfO.a(this.gfV);
            this.gfO.a(this.gfW);
            this.gfO.a(this.gfX);
            this.gfO.a(this.gfY);
            this.gff = 4;
        }
    }

    private void kS(boolean z) {
        this.apn = z;
        brD();
    }

    public boolean brC() {
        return this.apn;
    }

    private void brD() {
        this.gfQ.setEnabled(this.apn);
        al.k(this.gfQ, d.f.s_navbar_button_bg);
    }

    public void brE() {
        if (this.gfP > 1) {
            this.gfP--;
            brG();
        }
    }

    public void brF() {
        if (this.gfP < this.gff) {
            this.gfP++;
            brG();
        }
    }

    public void brG() {
        this.gfZ.setCurrentItem(this.gfP - 1);
        brI();
        brJ();
        brK();
        this.gfV.bqZ().clearFocus();
        this.gfW.bqT().clearFocus();
        g(this.gfV.bqZ());
        g(this.gfW.bqT());
        if (brv() && brp()) {
            brl().setEnabled(false);
        } else {
            brl().setEnabled(true);
        }
    }

    public void brH() {
        String[] strArr = {this.gfb.getResources().getString(d.j.take_photo), this.gfb.getResources().getString(d.j.album)};
        if (this.gfR == null) {
            this.gfR = new com.baidu.tbadk.core.dialog.g(this.gfb.getPageContext());
            this.gfR.a(null, strArr, new i.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                    if (j.this.gfR != null && j.this.gfR.isShowing() && j.this.gfb != null) {
                        j.this.gfR.dismiss();
                    }
                    Activity pageActivity = j.this.gfb.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.adQ();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.Y(pageActivity)) {
                        if (i == 0) {
                            ak.c(j.this.gfb.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gfb.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gfR.showDialog();
    }

    public void ai(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gfb.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.adQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.Y(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gfb.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void wF(String str) {
        if (!this.gfQ.getText().toString().equals(str)) {
            this.gfQ.setText(str);
        }
    }

    private void brI() {
        if (this.gfO.tG(this.gfP - 1) != null) {
            this.mNavigationBar.setTitleText(this.gfO.tG(this.gfP - 1).getTitle());
        }
    }

    public void brJ() {
        for (o oVar : this.gfO.getList()) {
            if (oVar.bqH() == this.gfP) {
                oVar.bqO();
                if (!oVar.bqS()) {
                    this.gfQ.setVisibility(8);
                } else {
                    this.gfQ.setVisibility(0);
                }
                wF(oVar.bqQ());
            } else {
                oVar.bqN();
            }
        }
        if (this.gfO.tG(this.gfP - 1) != null && this.gfO.tG(this.gfP - 1).bqR()) {
            kS(true);
        }
    }

    public void brK() {
        if (brt()) {
            a(this.gfV.bqZ().getText().length(), this.gfV.getLength() / 2, 2, 20);
        } else if (bru()) {
            int length = this.gfW.getLength() / 2;
            U(length, 15, 300);
            int i = 300 - length;
            this.gfW.bqU().setText(String.valueOf(i));
            if (i <= 50) {
                this.gfW.bqU().setVisibility(0);
            } else {
                this.gfW.bqU().setVisibility(8);
            }
            if (i == 0) {
                this.gfW.bqU().setTextColor(this.gfb.getResources().getColor(d.C0277d.common_color_10170));
            } else if (i < 0) {
                this.gfW.tF(300);
            } else {
                this.gfW.bqV();
            }
        } else if (brw()) {
            if (this.gfY.bqJ() != 3) {
                kS(true);
            } else {
                kS(false);
            }
        }
    }

    private void U(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            kS(true);
        } else {
            kS(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            kS(false);
        } else if (f >= i2 && f <= i3) {
            kS(true);
        } else {
            kS(false);
        }
        if (i < 1) {
            this.gfV.kQ(false);
        } else {
            this.gfV.kQ(true);
        }
    }

    public void setData(int i, int i2) {
        this.gfS = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gfb.getLayoutMode().setNightMode(i == 1);
        this.gfb.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        brD();
        al.d(this.gfQ, d.C0277d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.lr()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.l(viewGroup, d.C0277d.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gfb.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
