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
    private View aMT;
    private com.baidu.tbadk.core.util.b.a baE;
    private String business;
    private com.baidu.tbadk.core.dialog.b cZW;
    private boolean dVW;
    CreateGroupStepAdapter dVX;
    private int dVY;
    private TextView dVZ;
    CreateGroupStepActivity dVj;
    private int dVn;
    int dWa;
    e dWb;
    h dWc;
    g dWd;
    d dWe;
    i dWf;
    b dWg;
    private NoSwipeableViewPager dWh;
    private com.baidu.tieba.im.util.b dWi;
    private int dWj;
    private int dWk;
    private int dWl;
    private int dWm;
    private int dWn;
    private boolean dWo;
    private String dWp;
    private String dWq;
    private String dWr;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void nb(String str) {
        this.dWq = str;
    }

    public void nc(String str) {
        this.dWr = str;
    }

    public String aBW() {
        return this.dWq;
    }

    public String aBX() {
        return this.dWr;
    }

    public View aBY() {
        return this.aMT;
    }

    public int aBZ() {
        return this.dVY;
    }

    public View aCa() {
        return this.dVZ;
    }

    public View aCb() {
        if (this.dWb != null) {
            return this.dWb.aBL();
        }
        if (this.dWc != null) {
            return this.dWc.aBL();
        }
        return null;
    }

    public View aCc() {
        return this.dWf.aBT();
    }

    public View aCd() {
        return this.dWf.aBS();
    }

    public boolean aCe() {
        return this.mIsLoading;
    }

    public void aBz() {
        this.dWg.aBz();
        aCz();
    }

    public void nd(String str) {
        this.dWp = str;
    }

    public String aCf() {
        return this.dWp;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.dWg.setBusiness(str);
        aCz();
    }

    public String getBusiness() {
        return this.business;
    }

    public void ne(String str) {
        this.dWg.setAddress(str);
        aCz();
    }

    public boolean aCg() {
        return this.dWo;
    }

    public void gT(boolean z) {
        this.dWo = z;
    }

    public void aBA() {
        this.dWg.aBA();
        aCz();
    }

    public void aBB() {
        this.dWg.aBB();
        aCz();
    }

    public View aCh() {
        return this.dWg.aBx();
    }

    public int aBy() {
        return this.dWg.aBy();
    }

    public View aCi() {
        return this.dWd.aBP();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.dWd.aBO().getText().toString();
    }

    public String getIntro() {
        return this.dWe.aBI().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.dWa;
    }

    public boolean aCj() {
        return this.dWd != null && this.dVY == this.dWd.aBw();
    }

    public boolean aCk() {
        return this.dWe != null && this.dVY == this.dWe.aBw();
    }

    public boolean aCl() {
        return this.dWf != null && this.dVY == this.dWf.aBw();
    }

    public boolean aCm() {
        return this.dWg != null && this.dVY == this.dWg.aBw();
    }

    public boolean aCn() {
        return this.dVX != null && this.dVY == this.dVX.getCount();
    }

    public String getErrMsg() {
        if (this.dVX.nm(this.dVY - 1) != null) {
            return this.dVX.nm(this.dVY - 1).getErrMsg();
        }
        return null;
    }

    public void aCo() {
        this.dWf.aBT().setText(d.k.group_create_modify_photo_tip);
    }

    public void aCp() {
        this.dWf.aBR();
    }

    public void clearText() {
        this.dWd.aBQ();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.dVW = true;
        this.mIsLoading = false;
        this.dVj = null;
        this.dVX = null;
        this.progressBar = null;
        this.dVY = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aMT = null;
        this.dVZ = null;
        this.cZW = null;
        this.dWa = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.dWb = null;
        this.dWc = null;
        this.dWd = null;
        this.dWe = null;
        this.dWf = null;
        this.dWg = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.dWh = null;
        this.dWi = null;
        this.dWo = false;
        this.dWp = "";
        this.business = "";
        this.dWq = null;
        this.dWr = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.dWi = new com.baidu.tieba.im.util.b(this.dVj);
        this.dWi.setUniqueId(this.dVj.getUniqueId());
        aCq();
    }

    public void aCq() {
        this.dWi.Ja();
    }

    public void aCr() {
        if (this.dWi != null) {
            this.dWi.cancelLoad();
        }
    }

    private void initListener() {
        this.aMT.setOnClickListener(this.dVj);
        this.dVZ.setOnClickListener(this.dVj);
        this.dWd.aBO().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.dWd.aBO().addTextChangedListener(this.dVj);
        this.dWe.aBI().addTextChangedListener(this.dVj);
        this.dWf.aBT().setOnClickListener(this.dVj);
        this.dWf.aBS().setOnClickListener(this.dVj);
        this.dWg.aBx().setOnClickListener(this.dVj);
        if (this.dWc != null) {
            this.dWc.aBL().setOnClickListener(this.dVj);
        }
        if (this.dWb != null) {
            this.dWb.aBL().setOnClickListener(this.dVj);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.dVj = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.i.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.dWh = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.dVX = new CreateGroupStepAdapter(this.dVj);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.dWh.setAdapter(this.dVX);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aMT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        updateTitle();
        this.dVZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.k.next_step));
        ((LinearLayout.LayoutParams) this.dVZ.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.e(getPageContext().getPageActivity(), d.e.ds16);
        ak.i(this.dVZ, d.f.s_navbar_button_bg);
        gU(false);
        aCy();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.dWn = 1;
            this.dWm = 2;
            this.dWj = 3;
            this.dWk = 4;
            this.dWl = 5;
            this.dWb = new e(createGroupStepActivity, this.dWn, i2);
            this.dWg = new b(createGroupStepActivity, this.dWm, 1, 5);
            this.dWd = new g(createGroupStepActivity, this.dWj, 2, 5);
            this.dWe = new d(createGroupStepActivity, this.dWk, 3, 5);
            this.dWf = new i(createGroupStepActivity, this.dWl, 4, 5);
            this.dVX.a(this.dWb);
            this.dVX.a(this.dWg);
            this.dVX.a(this.dWd);
            this.dVX.a(this.dWe);
            this.dVX.a(this.dWf);
            this.dVn = 5;
        } else if (i == 2) {
            this.dWn = 1;
            this.dWj = 2;
            this.dWk = 3;
            this.dWl = 4;
            this.dWm = 5;
            this.dWc = new h(createGroupStepActivity, this.dWn, i3);
            this.dWd = new g(createGroupStepActivity, this.dWj, 1, 5);
            this.dWe = new d(createGroupStepActivity, this.dWk, 2, 5);
            this.dWf = new i(createGroupStepActivity, this.dWl, 3, 5);
            this.dWg = new b(createGroupStepActivity, this.dWm, 4, 5);
            this.dVX.a(this.dWc);
            this.dVX.a(this.dWd);
            this.dVX.a(this.dWe);
            this.dVX.a(this.dWf);
            this.dVX.a(this.dWg);
            this.dVn = 5;
        } else {
            this.dWj = 1;
            this.dWk = 2;
            this.dWl = 3;
            this.dWm = 4;
            this.dWd = new g(createGroupStepActivity, this.dWj, 1, 4);
            this.dWe = new d(createGroupStepActivity, this.dWk, 2, 4);
            this.dWf = new i(createGroupStepActivity, this.dWl, 3, 4);
            this.dWg = new b(createGroupStepActivity, this.dWm, 4, 4);
            this.dVX.a(this.dWd);
            this.dVX.a(this.dWe);
            this.dVX.a(this.dWf);
            this.dVX.a(this.dWg);
            this.dVn = 4;
        }
    }

    private void gU(boolean z) {
        this.dVW = z;
        aCt();
    }

    public boolean aCs() {
        return this.dVW;
    }

    private void aCt() {
        this.dVZ.setEnabled(this.dVW);
        ak.i(this.dVZ, d.f.s_navbar_button_bg);
    }

    public void aCu() {
        if (this.dVY > 1) {
            this.dVY--;
            aCw();
        }
    }

    public void aCv() {
        if (this.dVY < this.dVn) {
            this.dVY++;
            aCw();
        }
    }

    public void aCw() {
        this.dWh.setCurrentItem(this.dVY - 1);
        updateTitle();
        aCy();
        aCz();
        this.dWd.aBO().clearFocus();
        this.dWe.aBI().clearFocus();
        c(this.dWd.aBO());
        c(this.dWe.aBI());
        if (aCl() && aCe()) {
            aCa().setEnabled(false);
        } else {
            aCa().setEnabled(true);
        }
    }

    public void aCx() {
        String[] strArr = {this.dVj.getResources().getString(d.k.take_photo), this.dVj.getResources().getString(d.k.album)};
        if (this.cZW == null) {
            this.cZW = new com.baidu.tbadk.core.dialog.b(this.dVj.getPageContext().getPageActivity());
            this.cZW.dd(this.dVj.getResources().getString(d.k.operation));
            this.cZW.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.dVj.getPageContext().getPageActivity();
                    if (j.this.baE == null) {
                        j.this.baE = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.baE.wt();
                    j.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.baE.v(pageActivity)) {
                        if (i == 0) {
                            aj.b(j.this.dVj.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.dVj.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.cZW.d(this.dVj.getPageContext());
        }
        this.cZW.tF();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.dVj.getPageContext().getPageActivity();
        if (this.baE == null) {
            this.baE = new com.baidu.tbadk.core.util.b.a();
        }
        this.baE.wt();
        this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.baE.v(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.dVj.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nf(String str) {
        if (!this.dVZ.getText().toString().equals(str)) {
            this.dVZ.setText(str);
        }
    }

    private void updateTitle() {
        if (this.dVX.nm(this.dVY - 1) != null) {
            this.mNavigationBar.setTitleText(this.dVX.nm(this.dVY - 1).getTitle());
        }
    }

    public void aCy() {
        for (o oVar : this.dVX.getList()) {
            if (oVar.aBw() == this.dVY) {
                oVar.aBD();
                if (!oVar.aBH()) {
                    this.dVZ.setVisibility(8);
                } else {
                    this.dVZ.setVisibility(0);
                }
                nf(oVar.aBF());
            } else {
                oVar.aBC();
            }
        }
        if (this.dVX.nm(this.dVY - 1) != null && this.dVX.nm(this.dVY - 1).aBG()) {
            gU(true);
        }
    }

    public void aCz() {
        if (aCj()) {
            b(this.dWd.aBO().getText().length(), this.dWd.getLength() / 2, 2, 20);
        } else if (aCk()) {
            int length = this.dWe.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.dWe.aBJ().setText(String.valueOf(i));
            if (i <= 50) {
                this.dWe.aBJ().setVisibility(0);
            } else {
                this.dWe.aBJ().setVisibility(8);
            }
            if (i == 0) {
                this.dWe.aBJ().setTextColor(this.dVj.getResources().getColor(d.C0126d.common_color_10170));
            } else if (i < 0) {
                this.dWe.nl(300);
            } else {
                this.dWe.aBK();
            }
        } else if (aCm()) {
            if (this.dWg.aBy() != 3) {
                gU(true);
            } else {
                gU(false);
            }
        }
    }

    private void M(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            gU(true);
        } else {
            gU(false);
        }
    }

    private void b(int i, float f, int i2, int i3) {
        if (i == 1) {
            gU(false);
        } else if (f >= i2 && f <= i3) {
            gU(true);
        } else {
            gU(false);
        }
        if (i < 1) {
            this.dWd.gS(false);
        } else {
            this.dWd.gS(true);
        }
    }

    public void bb(int i, int i2) {
        this.dWa = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.dVj.getLayoutMode().setNightMode(i == 1);
        this.dVj.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aCt();
        ak.c(this.dVZ, d.C0126d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.hj()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        ak.j(viewGroup, d.C0126d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.dVj.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
