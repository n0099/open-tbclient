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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c {
    private View bCC;
    private com.baidu.tbadk.core.util.b.a bQQ;
    private String business;
    private com.baidu.tbadk.core.dialog.b dGc;
    private int eAA;
    private int eAB;
    private boolean eAC;
    private String eAD;
    private String eAE;
    private String eAF;
    private boolean eAk;
    j eAl;
    private int eAm;
    private TextView eAn;
    int eAo;
    e eAp;
    h eAq;
    g eAr;
    d eAs;
    i eAt;
    b eAu;
    private NoSwipeableViewPager eAv;
    private com.baidu.tieba.im.util.b eAw;
    private int eAx;
    private int eAy;
    private int eAz;
    private int ezB;
    CreateGroupStepActivity ezx;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void mU(String str) {
        this.eAE = str;
    }

    public void mV(String str) {
        this.eAF = str;
    }

    public String aGY() {
        return this.eAE;
    }

    public String aGZ() {
        return this.eAF;
    }

    public View aHa() {
        return this.bCC;
    }

    public int aHb() {
        return this.eAm;
    }

    public View aHc() {
        return this.eAn;
    }

    public View aHd() {
        if (this.eAp != null) {
            return this.eAp.aGN();
        }
        if (this.eAq != null) {
            return this.eAq.aGN();
        }
        return null;
    }

    public View aHe() {
        return this.eAt.aGV();
    }

    public View aHf() {
        return this.eAt.aGU();
    }

    public boolean aHg() {
        return this.mIsLoading;
    }

    public void aGB() {
        this.eAu.aGB();
        aHC();
    }

    public void mW(String str) {
        this.eAD = str;
    }

    public String aHh() {
        return this.eAD;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eAu.setBusiness(str);
        aHC();
    }

    public String getBusiness() {
        return this.business;
    }

    public void mX(String str) {
        this.eAu.setAddress(str);
        aHC();
    }

    public boolean aHi() {
        return this.eAC;
    }

    public void hn(boolean z) {
        this.eAC = z;
    }

    public void aGC() {
        this.eAu.aGC();
        aHC();
    }

    public void aGD() {
        this.eAu.aGD();
        aHC();
    }

    public View aHj() {
        return this.eAu.aGz();
    }

    public int aGA() {
        return this.eAu.aGA();
    }

    public View aHk() {
        return this.eAr.aGR();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eAr.aGQ().getText().toString();
    }

    public String getIntro() {
        return this.eAs.aGK().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eAo;
    }

    public boolean aHl() {
        return this.eAr != null && this.eAm == this.eAr.aGy();
    }

    public boolean aHm() {
        return this.eAs != null && this.eAm == this.eAs.aGy();
    }

    public boolean aHn() {
        return this.eAt != null && this.eAm == this.eAt.aGy();
    }

    public boolean aHo() {
        return this.eAu != null && this.eAm == this.eAu.aGy();
    }

    public boolean aHp() {
        return this.eAl != null && this.eAm == this.eAl.getCount();
    }

    public String getErrMsg() {
        if (this.eAl.pP(this.eAm - 1) != null) {
            return this.eAl.pP(this.eAm - 1).getErrMsg();
        }
        return null;
    }

    public void aHq() {
        this.eAt.aGV().setText(d.j.group_create_modify_photo_tip);
    }

    public void aHr() {
        this.eAt.aGT();
    }

    public void clearText() {
        this.eAr.aGS();
    }

    public k(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eAk = true;
        this.mIsLoading = false;
        this.ezx = null;
        this.eAl = null;
        this.progressBar = null;
        this.eAm = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bCC = null;
        this.eAn = null;
        this.dGc = null;
        this.eAo = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eAp = null;
        this.eAq = null;
        this.eAr = null;
        this.eAs = null;
        this.eAt = null;
        this.eAu = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eAv = null;
        this.eAw = null;
        this.eAC = false;
        this.eAD = "";
        this.business = "";
        this.eAE = null;
        this.eAF = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eAw = new com.baidu.tieba.im.util.b(this.ezx);
        this.eAw.setUniqueId(this.ezx.getUniqueId());
        aHs();
    }

    public void aHs() {
        this.eAw.QA();
    }

    public void aHt() {
        if (this.eAw != null) {
            this.eAw.dE();
        }
    }

    private void initListener() {
        this.bCC.setOnClickListener(this.ezx);
        this.eAn.setOnClickListener(this.ezx);
        this.eAr.aGQ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eAr.aGQ().addTextChangedListener(this.ezx);
        this.eAs.aGK().addTextChangedListener(this.ezx);
        this.eAt.aGV().setOnClickListener(this.ezx);
        this.eAt.aGU().setOnClickListener(this.ezx);
        this.eAu.aGz().setOnClickListener(this.ezx);
        if (this.eAq != null) {
            this.eAq.aGN().setOnClickListener(this.ezx);
        }
        if (this.eAp != null) {
            this.eAp.aGN().setOnClickListener(this.ezx);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.ezx = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.eAv = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.eAl = new j(this.ezx);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eAv.setAdapter(this.eAl);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aHA();
        this.eAn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.j.next_step));
        ((LinearLayout.LayoutParams) this.eAn.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.t(getPageContext().getPageActivity(), d.e.ds16);
        aj.s(this.eAn, d.f.s_navbar_button_bg);
        ho(false);
        aHB();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eAB = 1;
            this.eAA = 2;
            this.eAx = 3;
            this.eAy = 4;
            this.eAz = 5;
            this.eAp = new e(createGroupStepActivity, this.eAB, i2);
            this.eAu = new b(createGroupStepActivity, this.eAA, 1, 5);
            this.eAr = new g(createGroupStepActivity, this.eAx, 2, 5);
            this.eAs = new d(createGroupStepActivity, this.eAy, 3, 5);
            this.eAt = new i(createGroupStepActivity, this.eAz, 4, 5);
            this.eAl.a(this.eAp);
            this.eAl.a(this.eAu);
            this.eAl.a(this.eAr);
            this.eAl.a(this.eAs);
            this.eAl.a(this.eAt);
            this.ezB = 5;
        } else if (i == 2) {
            this.eAB = 1;
            this.eAx = 2;
            this.eAy = 3;
            this.eAz = 4;
            this.eAA = 5;
            this.eAq = new h(createGroupStepActivity, this.eAB, i3);
            this.eAr = new g(createGroupStepActivity, this.eAx, 1, 5);
            this.eAs = new d(createGroupStepActivity, this.eAy, 2, 5);
            this.eAt = new i(createGroupStepActivity, this.eAz, 3, 5);
            this.eAu = new b(createGroupStepActivity, this.eAA, 4, 5);
            this.eAl.a(this.eAq);
            this.eAl.a(this.eAr);
            this.eAl.a(this.eAs);
            this.eAl.a(this.eAt);
            this.eAl.a(this.eAu);
            this.ezB = 5;
        } else {
            this.eAx = 1;
            this.eAy = 2;
            this.eAz = 3;
            this.eAA = 4;
            this.eAr = new g(createGroupStepActivity, this.eAx, 1, 4);
            this.eAs = new d(createGroupStepActivity, this.eAy, 2, 4);
            this.eAt = new i(createGroupStepActivity, this.eAz, 3, 4);
            this.eAu = new b(createGroupStepActivity, this.eAA, 4, 4);
            this.eAl.a(this.eAr);
            this.eAl.a(this.eAs);
            this.eAl.a(this.eAt);
            this.eAl.a(this.eAu);
            this.ezB = 4;
        }
    }

    private void ho(boolean z) {
        this.eAk = z;
        aHv();
    }

    public boolean aHu() {
        return this.eAk;
    }

    private void aHv() {
        this.eAn.setEnabled(this.eAk);
        aj.s(this.eAn, d.f.s_navbar_button_bg);
    }

    public void aHw() {
        if (this.eAm > 1) {
            this.eAm--;
            aHy();
        }
    }

    public void aHx() {
        if (this.eAm < this.ezB) {
            this.eAm++;
            aHy();
        }
    }

    public void aHy() {
        this.eAv.setCurrentItem(this.eAm - 1);
        aHA();
        aHB();
        aHC();
        this.eAr.aGQ().clearFocus();
        this.eAs.aGK().clearFocus();
        c(this.eAr.aGQ());
        c(this.eAs.aGK());
        if (aHn() && aHg()) {
            aHc().setEnabled(false);
        } else {
            aHc().setEnabled(true);
        }
    }

    public void aHz() {
        String[] strArr = {this.ezx.getResources().getString(d.j.take_photo), this.ezx.getResources().getString(d.j.album)};
        if (this.dGc == null) {
            this.dGc = new com.baidu.tbadk.core.dialog.b(this.ezx.getPageContext().getPageActivity());
            this.dGc.dl(this.ezx.getResources().getString(d.j.operation));
            this.dGc.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.creategroup.k.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = k.this.ezx.getPageContext().getPageActivity();
                    if (k.this.bQQ == null) {
                        k.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                    }
                    k.this.bQQ.DI();
                    k.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!k.this.bQQ.v(pageActivity)) {
                        if (i == 0) {
                            ai.b(k.this.ezx.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(k.this.ezx.getPageContext().getPageActivity(), k.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dGc.d(this.ezx.getPageContext());
        }
        this.dGc.AX();
    }

    public void O(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.ezx.getPageContext().getPageActivity();
        if (this.bQQ == null) {
            this.bQQ = new com.baidu.tbadk.core.util.b.a();
        }
        this.bQQ.DI();
        this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bQQ.v(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.ezx.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void mY(String str) {
        if (!this.eAn.getText().toString().equals(str)) {
            this.eAn.setText(str);
        }
    }

    private void aHA() {
        if (this.eAl.pP(this.eAm - 1) != null) {
            this.mNavigationBar.setTitleText(this.eAl.pP(this.eAm - 1).getTitle());
        }
    }

    public void aHB() {
        for (p pVar : this.eAl.getList()) {
            if (pVar.aGy() == this.eAm) {
                pVar.aGF();
                if (!pVar.aGJ()) {
                    this.eAn.setVisibility(8);
                } else {
                    this.eAn.setVisibility(0);
                }
                mY(pVar.aGH());
            } else {
                pVar.aGE();
            }
        }
        if (this.eAl.pP(this.eAm - 1) != null && this.eAl.pP(this.eAm - 1).aGI()) {
            ho(true);
        }
    }

    public void aHC() {
        if (aHl()) {
            b(this.eAr.aGQ().getText().length(), this.eAr.getLength() / 2, 2, 20);
        } else if (aHm()) {
            int length = this.eAs.getLength() / 2;
            Y(length, 15, 300);
            int i = 300 - length;
            this.eAs.aGL().setText(String.valueOf(i));
            if (i <= 50) {
                this.eAs.aGL().setVisibility(0);
            } else {
                this.eAs.aGL().setVisibility(8);
            }
            if (i == 0) {
                this.eAs.aGL().setTextColor(this.ezx.getResources().getColor(d.C0140d.common_color_10170));
            } else if (i < 0) {
                this.eAs.pO(300);
            } else {
                this.eAs.aGM();
            }
        } else if (aHo()) {
            if (this.eAu.aGA() != 3) {
                ho(true);
            } else {
                ho(false);
            }
        }
    }

    private void Y(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            ho(true);
        } else {
            ho(false);
        }
    }

    private void b(int i, float f, int i2, int i3) {
        if (i == 1) {
            ho(false);
        } else if (f >= i2 && f <= i3) {
            ho(true);
        } else {
            ho(false);
        }
        if (i < 1) {
            this.eAr.hm(false);
        } else {
            this.eAr.hm(true);
        }
    }

    public void ca(int i, int i2) {
        this.eAo = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.ezx.getLayoutMode().aQ(i == 1);
        this.ezx.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aHv();
        aj.e(this.eAn, d.C0140d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.pd()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        aj.t(viewGroup, d.C0140d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.ezx.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
