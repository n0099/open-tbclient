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
    private boolean aps;
    private String business;
    private View csD;
    CreateGroupStepActivity geP;
    private int geT;
    CreateGroupStepAdapter gfC;
    private int gfD;
    private TextView gfE;
    private com.baidu.tbadk.core.dialog.g gfF;
    int gfG;
    e gfH;
    h gfI;
    g gfJ;
    d gfK;
    i gfL;
    b gfM;
    private NoSwipeableViewPager gfN;
    private com.baidu.tieba.im.util.b gfO;
    private int gfP;
    private int gfQ;
    private int gfR;
    private int gfS;
    private int gfT;
    private boolean gfU;
    private String gfV;
    private String gfW;
    private String gfX;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void wA(String str) {
        this.gfW = str;
    }

    public void wB(String str) {
        this.gfX = str;
    }

    public String bre() {
        return this.gfW;
    }

    public String brf() {
        return this.gfX;
    }

    public View brg() {
        return this.csD;
    }

    public int brh() {
        return this.gfD;
    }

    public View bri() {
        return this.gfE;
    }

    public View brj() {
        if (this.gfH != null) {
            return this.gfH.bqT();
        }
        if (this.gfI != null) {
            return this.gfI.bqT();
        }
        return null;
    }

    public View brk() {
        return this.gfL.brb();
    }

    public View brl() {
        return this.gfL.bra();
    }

    public boolean brm() {
        return this.mIsLoading;
    }

    public void bqH() {
        this.gfM.bqH();
        brH();
    }

    public void wC(String str) {
        this.gfV = str;
    }

    public String xo() {
        return this.gfV;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gfM.setBusiness(str);
        brH();
    }

    public String getBusiness() {
        return this.business;
    }

    public void wD(String str) {
        this.gfM.setAddress(str);
        brH();
    }

    public boolean brn() {
        return this.gfU;
    }

    public void kR(boolean z) {
        this.gfU = z;
    }

    public void bqI() {
        this.gfM.bqI();
        brH();
    }

    public void bqJ() {
        this.gfM.bqJ();
        brH();
    }

    public View bro() {
        return this.gfM.bqF();
    }

    public int bqG() {
        return this.gfM.bqG();
    }

    public View brp() {
        return this.gfJ.bqX();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gfJ.bqW().getText().toString();
    }

    public String getIntro() {
        return this.gfK.bqQ().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gfG;
    }

    public boolean brq() {
        return this.gfJ != null && this.gfD == this.gfJ.bqE();
    }

    public boolean brr() {
        return this.gfK != null && this.gfD == this.gfK.bqE();
    }

    public boolean brs() {
        return this.gfL != null && this.gfD == this.gfL.bqE();
    }

    public boolean brt() {
        return this.gfM != null && this.gfD == this.gfM.bqE();
    }

    public boolean bru() {
        return this.gfC != null && this.gfD == this.gfC.getCount();
    }

    public String getErrMsg() {
        if (this.gfC.tC(this.gfD - 1) != null) {
            return this.gfC.tC(this.gfD - 1).getErrMsg();
        }
        return null;
    }

    public void brv() {
        this.gfL.brb().setText(d.j.group_create_modify_photo_tip);
    }

    public void brw() {
        this.gfL.bqZ();
    }

    public void clearText() {
        this.gfJ.bqY();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.aps = true;
        this.mIsLoading = false;
        this.geP = null;
        this.gfC = null;
        this.progressBar = null;
        this.gfD = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.csD = null;
        this.gfE = null;
        this.gfF = null;
        this.gfG = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gfH = null;
        this.gfI = null;
        this.gfJ = null;
        this.gfK = null;
        this.gfL = null;
        this.gfM = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gfN = null;
        this.gfO = null;
        this.gfU = false;
        this.gfV = "";
        this.business = "";
        this.gfW = null;
        this.gfX = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gfO = new com.baidu.tieba.im.util.b(this.geP);
        this.gfO.setUniqueId(this.geP.getUniqueId());
        brx();
    }

    public void brx() {
        this.gfO.arH();
    }

    public void bry() {
        if (this.gfO != null) {
            this.gfO.cancelLoad();
        }
    }

    private void initListener() {
        this.csD.setOnClickListener(this.geP);
        this.gfE.setOnClickListener(this.geP);
        this.gfJ.bqW().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gfJ.bqW().addTextChangedListener(this.geP);
        this.gfK.bqQ().addTextChangedListener(this.geP);
        this.gfL.brb().setOnClickListener(this.geP);
        this.gfL.bra().setOnClickListener(this.geP);
        this.gfM.bqF().setOnClickListener(this.geP);
        if (this.gfI != null) {
            this.gfI.bqT().setOnClickListener(this.geP);
        }
        if (this.gfH != null) {
            this.gfH.bqT().setOnClickListener(this.geP);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.geP = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.gfN = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.gfC = new CreateGroupStepAdapter(this.geP);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gfN.setAdapter(this.gfC);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.csD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        brF();
        this.gfE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.j.next_step));
        ((LinearLayout.LayoutParams) this.gfE.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), d.e.ds16);
        al.k(this.gfE, d.f.s_navbar_button_bg);
        kS(false);
        brG();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gfT = 1;
            this.gfS = 2;
            this.gfP = 3;
            this.gfQ = 4;
            this.gfR = 5;
            this.gfH = new e(createGroupStepActivity, this.gfT, i2);
            this.gfM = new b(createGroupStepActivity, this.gfS, 1, 5);
            this.gfJ = new g(createGroupStepActivity, this.gfP, 2, 5);
            this.gfK = new d(createGroupStepActivity, this.gfQ, 3, 5);
            this.gfL = new i(createGroupStepActivity, this.gfR, 4, 5);
            this.gfC.a(this.gfH);
            this.gfC.a(this.gfM);
            this.gfC.a(this.gfJ);
            this.gfC.a(this.gfK);
            this.gfC.a(this.gfL);
            this.geT = 5;
        } else if (i == 2) {
            this.gfT = 1;
            this.gfP = 2;
            this.gfQ = 3;
            this.gfR = 4;
            this.gfS = 5;
            this.gfI = new h(createGroupStepActivity, this.gfT, i3);
            this.gfJ = new g(createGroupStepActivity, this.gfP, 1, 5);
            this.gfK = new d(createGroupStepActivity, this.gfQ, 2, 5);
            this.gfL = new i(createGroupStepActivity, this.gfR, 3, 5);
            this.gfM = new b(createGroupStepActivity, this.gfS, 4, 5);
            this.gfC.a(this.gfI);
            this.gfC.a(this.gfJ);
            this.gfC.a(this.gfK);
            this.gfC.a(this.gfL);
            this.gfC.a(this.gfM);
            this.geT = 5;
        } else {
            this.gfP = 1;
            this.gfQ = 2;
            this.gfR = 3;
            this.gfS = 4;
            this.gfJ = new g(createGroupStepActivity, this.gfP, 1, 4);
            this.gfK = new d(createGroupStepActivity, this.gfQ, 2, 4);
            this.gfL = new i(createGroupStepActivity, this.gfR, 3, 4);
            this.gfM = new b(createGroupStepActivity, this.gfS, 4, 4);
            this.gfC.a(this.gfJ);
            this.gfC.a(this.gfK);
            this.gfC.a(this.gfL);
            this.gfC.a(this.gfM);
            this.geT = 4;
        }
    }

    private void kS(boolean z) {
        this.aps = z;
        brA();
    }

    public boolean brz() {
        return this.aps;
    }

    private void brA() {
        this.gfE.setEnabled(this.aps);
        al.k(this.gfE, d.f.s_navbar_button_bg);
    }

    public void brB() {
        if (this.gfD > 1) {
            this.gfD--;
            brD();
        }
    }

    public void brC() {
        if (this.gfD < this.geT) {
            this.gfD++;
            brD();
        }
    }

    public void brD() {
        this.gfN.setCurrentItem(this.gfD - 1);
        brF();
        brG();
        brH();
        this.gfJ.bqW().clearFocus();
        this.gfK.bqQ().clearFocus();
        g(this.gfJ.bqW());
        g(this.gfK.bqQ());
        if (brs() && brm()) {
            bri().setEnabled(false);
        } else {
            bri().setEnabled(true);
        }
    }

    public void brE() {
        String[] strArr = {this.geP.getResources().getString(d.j.take_photo), this.geP.getResources().getString(d.j.album)};
        if (this.gfF == null) {
            this.gfF = new com.baidu.tbadk.core.dialog.g(this.geP.getPageContext());
            this.gfF.a(null, strArr, new i.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                    if (j.this.gfF != null && j.this.gfF.isShowing() && j.this.geP != null) {
                        j.this.gfF.dismiss();
                    }
                    Activity pageActivity = j.this.geP.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.adN();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.Y(pageActivity)) {
                        if (i == 0) {
                            ak.c(j.this.geP.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.geP.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gfF.showDialog();
    }

    public void ai(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.geP.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.adN();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.Y(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.geP.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void wE(String str) {
        if (!this.gfE.getText().toString().equals(str)) {
            this.gfE.setText(str);
        }
    }

    private void brF() {
        if (this.gfC.tC(this.gfD - 1) != null) {
            this.mNavigationBar.setTitleText(this.gfC.tC(this.gfD - 1).getTitle());
        }
    }

    public void brG() {
        for (o oVar : this.gfC.getList()) {
            if (oVar.bqE() == this.gfD) {
                oVar.bqL();
                if (!oVar.bqP()) {
                    this.gfE.setVisibility(8);
                } else {
                    this.gfE.setVisibility(0);
                }
                wE(oVar.bqN());
            } else {
                oVar.bqK();
            }
        }
        if (this.gfC.tC(this.gfD - 1) != null && this.gfC.tC(this.gfD - 1).bqO()) {
            kS(true);
        }
    }

    public void brH() {
        if (brq()) {
            a(this.gfJ.bqW().getText().length(), this.gfJ.getLength() / 2, 2, 20);
        } else if (brr()) {
            int length = this.gfK.getLength() / 2;
            U(length, 15, 300);
            int i = 300 - length;
            this.gfK.bqR().setText(String.valueOf(i));
            if (i <= 50) {
                this.gfK.bqR().setVisibility(0);
            } else {
                this.gfK.bqR().setVisibility(8);
            }
            if (i == 0) {
                this.gfK.bqR().setTextColor(this.geP.getResources().getColor(d.C0277d.common_color_10170));
            } else if (i < 0) {
                this.gfK.tB(300);
            } else {
                this.gfK.bqS();
            }
        } else if (brt()) {
            if (this.gfM.bqG() != 3) {
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
            this.gfJ.kQ(false);
        } else {
            this.gfJ.kQ(true);
        }
    }

    public void setData(int i, int i2) {
        this.gfG = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.geP.getLayoutMode().setNightMode(i == 1);
        this.geP.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        brA();
        al.d(this.gfE, d.C0277d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.lr()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.l(viewGroup, d.C0277d.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.geP.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
