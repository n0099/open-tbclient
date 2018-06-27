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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View aVN;
    private com.baidu.tbadk.core.util.b.a bkp;
    private String business;
    private com.baidu.tbadk.core.dialog.b dlp;
    CreateGroupStepActivity ekp;
    private int ekt;
    private boolean elc;
    CreateGroupStepAdapter eld;
    private int ele;
    private TextView elf;
    int elg;
    e elh;
    h eli;
    g elj;
    d elk;
    i ell;
    b elm;
    private NoSwipeableViewPager eln;
    private com.baidu.tieba.im.util.b elo;
    private int elp;
    private int elq;
    private int elr;
    private int els;
    private int elt;
    private boolean elu;
    private String elv;
    private String elw;
    private String elx;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void nO(String str) {
        this.elw = str;
    }

    public void nP(String str) {
        this.elx = str;
    }

    public String aHy() {
        return this.elw;
    }

    public String aHz() {
        return this.elx;
    }

    public View aHA() {
        return this.aVN;
    }

    public int aHB() {
        return this.ele;
    }

    public View aHC() {
        return this.elf;
    }

    public View aHD() {
        if (this.elh != null) {
            return this.elh.aHn();
        }
        if (this.eli != null) {
            return this.eli.aHn();
        }
        return null;
    }

    public View aHE() {
        return this.ell.aHv();
    }

    public View aHF() {
        return this.ell.aHu();
    }

    public boolean aHG() {
        return this.mIsLoading;
    }

    public void aHb() {
        this.elm.aHb();
        aIb();
    }

    public void nQ(String str) {
        this.elv = str;
    }

    public String aHH() {
        return this.elv;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.elm.setBusiness(str);
        aIb();
    }

    public String getBusiness() {
        return this.business;
    }

    public void nR(String str) {
        this.elm.setAddress(str);
        aIb();
    }

    public boolean aHI() {
        return this.elu;
    }

    public void hj(boolean z) {
        this.elu = z;
    }

    public void aHc() {
        this.elm.aHc();
        aIb();
    }

    public void aHd() {
        this.elm.aHd();
        aIb();
    }

    public View aHJ() {
        return this.elm.aGZ();
    }

    public int aHa() {
        return this.elm.aHa();
    }

    public View aHK() {
        return this.elj.aHr();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.elj.aHq().getText().toString();
    }

    public String getIntro() {
        return this.elk.aHk().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.elg;
    }

    public boolean aHL() {
        return this.elj != null && this.ele == this.elj.aGY();
    }

    public boolean aHM() {
        return this.elk != null && this.ele == this.elk.aGY();
    }

    public boolean aHN() {
        return this.ell != null && this.ele == this.ell.aGY();
    }

    public boolean aHO() {
        return this.elm != null && this.ele == this.elm.aGY();
    }

    public boolean aHP() {
        return this.eld != null && this.ele == this.eld.getCount();
    }

    public String getErrMsg() {
        if (this.eld.nF(this.ele - 1) != null) {
            return this.eld.nF(this.ele - 1).getErrMsg();
        }
        return null;
    }

    public void aHQ() {
        this.ell.aHv().setText(d.k.group_create_modify_photo_tip);
    }

    public void aHR() {
        this.ell.aHt();
    }

    public void clearText() {
        this.elj.aHs();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.elc = true;
        this.mIsLoading = false;
        this.ekp = null;
        this.eld = null;
        this.progressBar = null;
        this.ele = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aVN = null;
        this.elf = null;
        this.dlp = null;
        this.elg = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.elh = null;
        this.eli = null;
        this.elj = null;
        this.elk = null;
        this.ell = null;
        this.elm = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eln = null;
        this.elo = null;
        this.elu = false;
        this.elv = "";
        this.business = "";
        this.elw = null;
        this.elx = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.elo = new com.baidu.tieba.im.util.b(this.ekp);
        this.elo.setUniqueId(this.ekp.getUniqueId());
        aHS();
    }

    public void aHS() {
        this.elo.MO();
    }

    public void aHT() {
        if (this.elo != null) {
            this.elo.cancelLoad();
        }
    }

    private void initListener() {
        this.aVN.setOnClickListener(this.ekp);
        this.elf.setOnClickListener(this.ekp);
        this.elj.aHq().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.elj.aHq().addTextChangedListener(this.ekp);
        this.elk.aHk().addTextChangedListener(this.ekp);
        this.ell.aHv().setOnClickListener(this.ekp);
        this.ell.aHu().setOnClickListener(this.ekp);
        this.elm.aGZ().setOnClickListener(this.ekp);
        if (this.eli != null) {
            this.eli.aHn().setOnClickListener(this.ekp);
        }
        if (this.elh != null) {
            this.elh.aHn().setOnClickListener(this.ekp);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.ekp = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.i.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.eln = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.eld = new CreateGroupStepAdapter(this.ekp);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eln.setAdapter(this.eld);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aVN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        updateTitle();
        this.elf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.k.next_step));
        ((LinearLayout.LayoutParams) this.elf.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.e(getPageContext().getPageActivity(), d.e.ds16);
        am.i(this.elf, d.f.s_navbar_button_bg);
        hk(false);
        aIa();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.elt = 1;
            this.els = 2;
            this.elp = 3;
            this.elq = 4;
            this.elr = 5;
            this.elh = new e(createGroupStepActivity, this.elt, i2);
            this.elm = new b(createGroupStepActivity, this.els, 1, 5);
            this.elj = new g(createGroupStepActivity, this.elp, 2, 5);
            this.elk = new d(createGroupStepActivity, this.elq, 3, 5);
            this.ell = new i(createGroupStepActivity, this.elr, 4, 5);
            this.eld.a(this.elh);
            this.eld.a(this.elm);
            this.eld.a(this.elj);
            this.eld.a(this.elk);
            this.eld.a(this.ell);
            this.ekt = 5;
        } else if (i == 2) {
            this.elt = 1;
            this.elp = 2;
            this.elq = 3;
            this.elr = 4;
            this.els = 5;
            this.eli = new h(createGroupStepActivity, this.elt, i3);
            this.elj = new g(createGroupStepActivity, this.elp, 1, 5);
            this.elk = new d(createGroupStepActivity, this.elq, 2, 5);
            this.ell = new i(createGroupStepActivity, this.elr, 3, 5);
            this.elm = new b(createGroupStepActivity, this.els, 4, 5);
            this.eld.a(this.eli);
            this.eld.a(this.elj);
            this.eld.a(this.elk);
            this.eld.a(this.ell);
            this.eld.a(this.elm);
            this.ekt = 5;
        } else {
            this.elp = 1;
            this.elq = 2;
            this.elr = 3;
            this.els = 4;
            this.elj = new g(createGroupStepActivity, this.elp, 1, 4);
            this.elk = new d(createGroupStepActivity, this.elq, 2, 4);
            this.ell = new i(createGroupStepActivity, this.elr, 3, 4);
            this.elm = new b(createGroupStepActivity, this.els, 4, 4);
            this.eld.a(this.elj);
            this.eld.a(this.elk);
            this.eld.a(this.ell);
            this.eld.a(this.elm);
            this.ekt = 4;
        }
    }

    private void hk(boolean z) {
        this.elc = z;
        aHV();
    }

    public boolean aHU() {
        return this.elc;
    }

    private void aHV() {
        this.elf.setEnabled(this.elc);
        am.i(this.elf, d.f.s_navbar_button_bg);
    }

    public void aHW() {
        if (this.ele > 1) {
            this.ele--;
            aHY();
        }
    }

    public void aHX() {
        if (this.ele < this.ekt) {
            this.ele++;
            aHY();
        }
    }

    public void aHY() {
        this.eln.setCurrentItem(this.ele - 1);
        updateTitle();
        aIa();
        aIb();
        this.elj.aHq().clearFocus();
        this.elk.aHk().clearFocus();
        c(this.elj.aHq());
        c(this.elk.aHk());
        if (aHN() && aHG()) {
            aHC().setEnabled(false);
        } else {
            aHC().setEnabled(true);
        }
    }

    public void aHZ() {
        String[] strArr = {this.ekp.getResources().getString(d.k.take_photo), this.ekp.getResources().getString(d.k.album)};
        if (this.dlp == null) {
            this.dlp = new com.baidu.tbadk.core.dialog.b(this.ekp.getPageContext().getPageActivity());
            this.dlp.dF(this.ekp.getResources().getString(d.k.operation));
            this.dlp.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.ekp.getPageContext().getPageActivity();
                    if (j.this.bkp == null) {
                        j.this.bkp = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bkp.Aj();
                    j.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bkp.u(pageActivity)) {
                        if (i == 0) {
                            al.b(j.this.ekp.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.ekp.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dlp.d(this.ekp.getPageContext());
        }
        this.dlp.xq();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.ekp.getPageContext().getPageActivity();
        if (this.bkp == null) {
            this.bkp = new com.baidu.tbadk.core.util.b.a();
        }
        this.bkp.Aj();
        this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkp.u(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.ekp.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nS(String str) {
        if (!this.elf.getText().toString().equals(str)) {
            this.elf.setText(str);
        }
    }

    private void updateTitle() {
        if (this.eld.nF(this.ele - 1) != null) {
            this.mNavigationBar.setTitleText(this.eld.nF(this.ele - 1).getTitle());
        }
    }

    public void aIa() {
        for (o oVar : this.eld.getList()) {
            if (oVar.aGY() == this.ele) {
                oVar.aHf();
                if (!oVar.aHj()) {
                    this.elf.setVisibility(8);
                } else {
                    this.elf.setVisibility(0);
                }
                nS(oVar.aHh());
            } else {
                oVar.aHe();
            }
        }
        if (this.eld.nF(this.ele - 1) != null && this.eld.nF(this.ele - 1).aHi()) {
            hk(true);
        }
    }

    public void aIb() {
        if (aHL()) {
            a(this.elj.aHq().getText().length(), this.elj.getLength() / 2, 2, 20);
        } else if (aHM()) {
            int length = this.elk.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.elk.aHl().setText(String.valueOf(i));
            if (i <= 50) {
                this.elk.aHl().setVisibility(0);
            } else {
                this.elk.aHl().setVisibility(8);
            }
            if (i == 0) {
                this.elk.aHl().setTextColor(this.ekp.getResources().getColor(d.C0142d.common_color_10170));
            } else if (i < 0) {
                this.elk.nE(300);
            } else {
                this.elk.aHm();
            }
        } else if (aHO()) {
            if (this.elm.aHa() != 3) {
                hk(true);
            } else {
                hk(false);
            }
        }
    }

    private void M(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            hk(true);
        } else {
            hk(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            hk(false);
        } else if (f >= i2 && f <= i3) {
            hk(true);
        } else {
            hk(false);
        }
        if (i < 1) {
            this.elj.hi(false);
        } else {
            this.elj.hi(true);
        }
    }

    public void bc(int i, int i2) {
        this.elg = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.ekp.getLayoutMode().setNightMode(i == 1);
        this.ekp.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aHV();
        am.c(this.elf, d.C0142d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.jX()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.j(viewGroup, d.C0142d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.ekp.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
