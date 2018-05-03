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
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View aMS;
    private com.baidu.tbadk.core.util.b.a baD;
    private String business;
    private com.baidu.tbadk.core.dialog.b cYP;
    private boolean dUP;
    CreateGroupStepAdapter dUQ;
    private int dUR;
    private TextView dUS;
    int dUT;
    e dUU;
    h dUV;
    g dUW;
    d dUX;
    i dUY;
    b dUZ;
    CreateGroupStepActivity dUc;
    private int dUg;
    private NoSwipeableViewPager dVa;
    private com.baidu.tieba.im.util.b dVb;
    private int dVc;
    private int dVd;
    private int dVe;
    private int dVf;
    private int dVg;
    private boolean dVh;
    private String dVi;
    private String dVj;
    private String dVk;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void mY(String str) {
        this.dVj = str;
    }

    public void mZ(String str) {
        this.dVk = str;
    }

    public String aBY() {
        return this.dVj;
    }

    public String aBZ() {
        return this.dVk;
    }

    public View aCa() {
        return this.aMS;
    }

    public int aCb() {
        return this.dUR;
    }

    public View aCc() {
        return this.dUS;
    }

    public View aCd() {
        if (this.dUU != null) {
            return this.dUU.aBN();
        }
        if (this.dUV != null) {
            return this.dUV.aBN();
        }
        return null;
    }

    public View aCe() {
        return this.dUY.aBV();
    }

    public View aCf() {
        return this.dUY.aBU();
    }

    public boolean aCg() {
        return this.mIsLoading;
    }

    public void aBB() {
        this.dUZ.aBB();
        aCB();
    }

    public void na(String str) {
        this.dVi = str;
    }

    public String aCh() {
        return this.dVi;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.dUZ.setBusiness(str);
        aCB();
    }

    public String getBusiness() {
        return this.business;
    }

    public void nb(String str) {
        this.dUZ.setAddress(str);
        aCB();
    }

    public boolean aCi() {
        return this.dVh;
    }

    public void gS(boolean z) {
        this.dVh = z;
    }

    public void aBC() {
        this.dUZ.aBC();
        aCB();
    }

    public void aBD() {
        this.dUZ.aBD();
        aCB();
    }

    public View aCj() {
        return this.dUZ.aBz();
    }

    public int aBA() {
        return this.dUZ.aBA();
    }

    public View aCk() {
        return this.dUW.aBR();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.dUW.aBQ().getText().toString();
    }

    public String getIntro() {
        return this.dUX.aBK().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.dUT;
    }

    public boolean aCl() {
        return this.dUW != null && this.dUR == this.dUW.aBy();
    }

    public boolean aCm() {
        return this.dUX != null && this.dUR == this.dUX.aBy();
    }

    public boolean aCn() {
        return this.dUY != null && this.dUR == this.dUY.aBy();
    }

    public boolean aCo() {
        return this.dUZ != null && this.dUR == this.dUZ.aBy();
    }

    public boolean aCp() {
        return this.dUQ != null && this.dUR == this.dUQ.getCount();
    }

    public String getErrMsg() {
        if (this.dUQ.nn(this.dUR - 1) != null) {
            return this.dUQ.nn(this.dUR - 1).getErrMsg();
        }
        return null;
    }

    public void aCq() {
        this.dUY.aBV().setText(d.k.group_create_modify_photo_tip);
    }

    public void aCr() {
        this.dUY.aBT();
    }

    public void clearText() {
        this.dUW.aBS();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.dUP = true;
        this.mIsLoading = false;
        this.dUc = null;
        this.dUQ = null;
        this.progressBar = null;
        this.dUR = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aMS = null;
        this.dUS = null;
        this.cYP = null;
        this.dUT = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.dUU = null;
        this.dUV = null;
        this.dUW = null;
        this.dUX = null;
        this.dUY = null;
        this.dUZ = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.dVa = null;
        this.dVb = null;
        this.dVh = false;
        this.dVi = "";
        this.business = "";
        this.dVj = null;
        this.dVk = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.dVb = new com.baidu.tieba.im.util.b(this.dUc);
        this.dVb.setUniqueId(this.dUc.getUniqueId());
        aCs();
    }

    public void aCs() {
        this.dVb.Jc();
    }

    public void aCt() {
        if (this.dVb != null) {
            this.dVb.cancelLoad();
        }
    }

    private void initListener() {
        this.aMS.setOnClickListener(this.dUc);
        this.dUS.setOnClickListener(this.dUc);
        this.dUW.aBQ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.dUW.aBQ().addTextChangedListener(this.dUc);
        this.dUX.aBK().addTextChangedListener(this.dUc);
        this.dUY.aBV().setOnClickListener(this.dUc);
        this.dUY.aBU().setOnClickListener(this.dUc);
        this.dUZ.aBz().setOnClickListener(this.dUc);
        if (this.dUV != null) {
            this.dUV.aBN().setOnClickListener(this.dUc);
        }
        if (this.dUU != null) {
            this.dUU.aBN().setOnClickListener(this.dUc);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.dUc = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.i.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.dVa = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.dUQ = new CreateGroupStepAdapter(this.dUc);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.dVa.setAdapter(this.dUQ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        updateTitle();
        this.dUS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.k.next_step));
        ((LinearLayout.LayoutParams) this.dUS.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.e(getPageContext().getPageActivity(), d.e.ds16);
        ak.i(this.dUS, d.f.s_navbar_button_bg);
        gT(false);
        aCA();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.dVg = 1;
            this.dVf = 2;
            this.dVc = 3;
            this.dVd = 4;
            this.dVe = 5;
            this.dUU = new e(createGroupStepActivity, this.dVg, i2);
            this.dUZ = new b(createGroupStepActivity, this.dVf, 1, 5);
            this.dUW = new g(createGroupStepActivity, this.dVc, 2, 5);
            this.dUX = new d(createGroupStepActivity, this.dVd, 3, 5);
            this.dUY = new i(createGroupStepActivity, this.dVe, 4, 5);
            this.dUQ.a(this.dUU);
            this.dUQ.a(this.dUZ);
            this.dUQ.a(this.dUW);
            this.dUQ.a(this.dUX);
            this.dUQ.a(this.dUY);
            this.dUg = 5;
        } else if (i == 2) {
            this.dVg = 1;
            this.dVc = 2;
            this.dVd = 3;
            this.dVe = 4;
            this.dVf = 5;
            this.dUV = new h(createGroupStepActivity, this.dVg, i3);
            this.dUW = new g(createGroupStepActivity, this.dVc, 1, 5);
            this.dUX = new d(createGroupStepActivity, this.dVd, 2, 5);
            this.dUY = new i(createGroupStepActivity, this.dVe, 3, 5);
            this.dUZ = new b(createGroupStepActivity, this.dVf, 4, 5);
            this.dUQ.a(this.dUV);
            this.dUQ.a(this.dUW);
            this.dUQ.a(this.dUX);
            this.dUQ.a(this.dUY);
            this.dUQ.a(this.dUZ);
            this.dUg = 5;
        } else {
            this.dVc = 1;
            this.dVd = 2;
            this.dVe = 3;
            this.dVf = 4;
            this.dUW = new g(createGroupStepActivity, this.dVc, 1, 4);
            this.dUX = new d(createGroupStepActivity, this.dVd, 2, 4);
            this.dUY = new i(createGroupStepActivity, this.dVe, 3, 4);
            this.dUZ = new b(createGroupStepActivity, this.dVf, 4, 4);
            this.dUQ.a(this.dUW);
            this.dUQ.a(this.dUX);
            this.dUQ.a(this.dUY);
            this.dUQ.a(this.dUZ);
            this.dUg = 4;
        }
    }

    private void gT(boolean z) {
        this.dUP = z;
        aCv();
    }

    public boolean aCu() {
        return this.dUP;
    }

    private void aCv() {
        this.dUS.setEnabled(this.dUP);
        ak.i(this.dUS, d.f.s_navbar_button_bg);
    }

    public void aCw() {
        if (this.dUR > 1) {
            this.dUR--;
            aCy();
        }
    }

    public void aCx() {
        if (this.dUR < this.dUg) {
            this.dUR++;
            aCy();
        }
    }

    public void aCy() {
        this.dVa.setCurrentItem(this.dUR - 1);
        updateTitle();
        aCA();
        aCB();
        this.dUW.aBQ().clearFocus();
        this.dUX.aBK().clearFocus();
        c(this.dUW.aBQ());
        c(this.dUX.aBK());
        if (aCn() && aCg()) {
            aCc().setEnabled(false);
        } else {
            aCc().setEnabled(true);
        }
    }

    public void aCz() {
        String[] strArr = {this.dUc.getResources().getString(d.k.take_photo), this.dUc.getResources().getString(d.k.album)};
        if (this.cYP == null) {
            this.cYP = new com.baidu.tbadk.core.dialog.b(this.dUc.getPageContext().getPageActivity());
            this.cYP.dd(this.dUc.getResources().getString(d.k.operation));
            this.cYP.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.dUc.getPageContext().getPageActivity();
                    if (j.this.baD == null) {
                        j.this.baD = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.baD.wu();
                    j.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.baD.v(pageActivity)) {
                        if (i == 0) {
                            aj.b(j.this.dUc.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.dUc.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.cYP.d(this.dUc.getPageContext());
        }
        this.cYP.tG();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.dUc.getPageContext().getPageActivity();
        if (this.baD == null) {
            this.baD = new com.baidu.tbadk.core.util.b.a();
        }
        this.baD.wu();
        this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.baD.v(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.dUc.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nc(String str) {
        if (!this.dUS.getText().toString().equals(str)) {
            this.dUS.setText(str);
        }
    }

    private void updateTitle() {
        if (this.dUQ.nn(this.dUR - 1) != null) {
            this.mNavigationBar.setTitleText(this.dUQ.nn(this.dUR - 1).getTitle());
        }
    }

    public void aCA() {
        for (o oVar : this.dUQ.getList()) {
            if (oVar.aBy() == this.dUR) {
                oVar.aBF();
                if (!oVar.aBJ()) {
                    this.dUS.setVisibility(8);
                } else {
                    this.dUS.setVisibility(0);
                }
                nc(oVar.aBH());
            } else {
                oVar.aBE();
            }
        }
        if (this.dUQ.nn(this.dUR - 1) != null && this.dUQ.nn(this.dUR - 1).aBI()) {
            gT(true);
        }
    }

    public void aCB() {
        if (aCl()) {
            b(this.dUW.aBQ().getText().length(), this.dUW.getLength() / 2, 2, 20);
        } else if (aCm()) {
            int length = this.dUX.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.dUX.aBL().setText(String.valueOf(i));
            if (i <= 50) {
                this.dUX.aBL().setVisibility(0);
            } else {
                this.dUX.aBL().setVisibility(8);
            }
            if (i == 0) {
                this.dUX.aBL().setTextColor(this.dUc.getResources().getColor(d.C0126d.common_color_10170));
            } else if (i < 0) {
                this.dUX.nm(300);
            } else {
                this.dUX.aBM();
            }
        } else if (aCo()) {
            if (this.dUZ.aBA() != 3) {
                gT(true);
            } else {
                gT(false);
            }
        }
    }

    private void M(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            gT(true);
        } else {
            gT(false);
        }
    }

    private void b(int i, float f, int i2, int i3) {
        if (i == 1) {
            gT(false);
        } else if (f >= i2 && f <= i3) {
            gT(true);
        } else {
            gT(false);
        }
        if (i < 1) {
            this.dUW.gR(false);
        } else {
            this.dUW.gR(true);
        }
    }

    public void bb(int i, int i2) {
        this.dUT = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.dUc.getLayoutMode().setNightMode(i == 1);
        this.dUc.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aCv();
        ak.c(this.dUS, d.C0126d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.hj()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ak.j(viewGroup, d.C0126d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.dUc.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
