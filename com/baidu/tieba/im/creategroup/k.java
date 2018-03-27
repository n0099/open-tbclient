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
    private View bCs;
    private com.baidu.tbadk.core.util.b.a bQG;
    private String business;
    private com.baidu.tbadk.core.dialog.b dFU;
    private com.baidu.tieba.im.util.b eAA;
    private int eAB;
    private int eAC;
    private int eAD;
    private int eAE;
    private int eAF;
    private boolean eAG;
    private String eAH;
    private String eAI;
    private String eAJ;
    private boolean eAo;
    j eAp;
    private int eAq;
    private TextView eAr;
    int eAs;
    e eAt;
    h eAu;
    g eAv;
    d eAw;
    i eAx;
    b eAy;
    private NoSwipeableViewPager eAz;
    CreateGroupStepActivity ezB;
    private int ezF;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void mU(String str) {
        this.eAI = str;
    }

    public void mV(String str) {
        this.eAJ = str;
    }

    public String aGY() {
        return this.eAI;
    }

    public String aGZ() {
        return this.eAJ;
    }

    public View aHa() {
        return this.bCs;
    }

    public int aHb() {
        return this.eAq;
    }

    public View aHc() {
        return this.eAr;
    }

    public View aHd() {
        if (this.eAt != null) {
            return this.eAt.aGN();
        }
        if (this.eAu != null) {
            return this.eAu.aGN();
        }
        return null;
    }

    public View aHe() {
        return this.eAx.aGV();
    }

    public View aHf() {
        return this.eAx.aGU();
    }

    public boolean aHg() {
        return this.mIsLoading;
    }

    public void aGB() {
        this.eAy.aGB();
        aHC();
    }

    public void mW(String str) {
        this.eAH = str;
    }

    public String aHh() {
        return this.eAH;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eAy.setBusiness(str);
        aHC();
    }

    public String getBusiness() {
        return this.business;
    }

    public void mX(String str) {
        this.eAy.setAddress(str);
        aHC();
    }

    public boolean aHi() {
        return this.eAG;
    }

    public void hs(boolean z) {
        this.eAG = z;
    }

    public void aGC() {
        this.eAy.aGC();
        aHC();
    }

    public void aGD() {
        this.eAy.aGD();
        aHC();
    }

    public View aHj() {
        return this.eAy.aGz();
    }

    public int aGA() {
        return this.eAy.aGA();
    }

    public View aHk() {
        return this.eAv.aGR();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eAv.aGQ().getText().toString();
    }

    public String getIntro() {
        return this.eAw.aGK().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eAs;
    }

    public boolean aHl() {
        return this.eAv != null && this.eAq == this.eAv.aGy();
    }

    public boolean aHm() {
        return this.eAw != null && this.eAq == this.eAw.aGy();
    }

    public boolean aHn() {
        return this.eAx != null && this.eAq == this.eAx.aGy();
    }

    public boolean aHo() {
        return this.eAy != null && this.eAq == this.eAy.aGy();
    }

    public boolean aHp() {
        return this.eAp != null && this.eAq == this.eAp.getCount();
    }

    public String getErrMsg() {
        if (this.eAp.pQ(this.eAq - 1) != null) {
            return this.eAp.pQ(this.eAq - 1).getErrMsg();
        }
        return null;
    }

    public void aHq() {
        this.eAx.aGV().setText(d.j.group_create_modify_photo_tip);
    }

    public void aHr() {
        this.eAx.aGT();
    }

    public void clearText() {
        this.eAv.aGS();
    }

    public k(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eAo = true;
        this.mIsLoading = false;
        this.ezB = null;
        this.eAp = null;
        this.progressBar = null;
        this.eAq = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bCs = null;
        this.eAr = null;
        this.dFU = null;
        this.eAs = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eAt = null;
        this.eAu = null;
        this.eAv = null;
        this.eAw = null;
        this.eAx = null;
        this.eAy = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eAz = null;
        this.eAA = null;
        this.eAG = false;
        this.eAH = "";
        this.business = "";
        this.eAI = null;
        this.eAJ = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eAA = new com.baidu.tieba.im.util.b(this.ezB);
        this.eAA.setUniqueId(this.ezB.getUniqueId());
        aHs();
    }

    public void aHs() {
        this.eAA.QA();
    }

    public void aHt() {
        if (this.eAA != null) {
            this.eAA.dE();
        }
    }

    private void initListener() {
        this.bCs.setOnClickListener(this.ezB);
        this.eAr.setOnClickListener(this.ezB);
        this.eAv.aGQ().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eAv.aGQ().addTextChangedListener(this.ezB);
        this.eAw.aGK().addTextChangedListener(this.ezB);
        this.eAx.aGV().setOnClickListener(this.ezB);
        this.eAx.aGU().setOnClickListener(this.ezB);
        this.eAy.aGz().setOnClickListener(this.ezB);
        if (this.eAu != null) {
            this.eAu.aGN().setOnClickListener(this.ezB);
        }
        if (this.eAt != null) {
            this.eAt.aGN().setOnClickListener(this.ezB);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.ezB = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.eAz = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.eAp = new j(this.ezB);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eAz.setAdapter(this.eAp);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aHA();
        this.eAr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.j.next_step));
        ((LinearLayout.LayoutParams) this.eAr.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.t(getPageContext().getPageActivity(), d.e.ds16);
        aj.s(this.eAr, d.f.s_navbar_button_bg);
        ht(false);
        aHB();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eAF = 1;
            this.eAE = 2;
            this.eAB = 3;
            this.eAC = 4;
            this.eAD = 5;
            this.eAt = new e(createGroupStepActivity, this.eAF, i2);
            this.eAy = new b(createGroupStepActivity, this.eAE, 1, 5);
            this.eAv = new g(createGroupStepActivity, this.eAB, 2, 5);
            this.eAw = new d(createGroupStepActivity, this.eAC, 3, 5);
            this.eAx = new i(createGroupStepActivity, this.eAD, 4, 5);
            this.eAp.a(this.eAt);
            this.eAp.a(this.eAy);
            this.eAp.a(this.eAv);
            this.eAp.a(this.eAw);
            this.eAp.a(this.eAx);
            this.ezF = 5;
        } else if (i == 2) {
            this.eAF = 1;
            this.eAB = 2;
            this.eAC = 3;
            this.eAD = 4;
            this.eAE = 5;
            this.eAu = new h(createGroupStepActivity, this.eAF, i3);
            this.eAv = new g(createGroupStepActivity, this.eAB, 1, 5);
            this.eAw = new d(createGroupStepActivity, this.eAC, 2, 5);
            this.eAx = new i(createGroupStepActivity, this.eAD, 3, 5);
            this.eAy = new b(createGroupStepActivity, this.eAE, 4, 5);
            this.eAp.a(this.eAu);
            this.eAp.a(this.eAv);
            this.eAp.a(this.eAw);
            this.eAp.a(this.eAx);
            this.eAp.a(this.eAy);
            this.ezF = 5;
        } else {
            this.eAB = 1;
            this.eAC = 2;
            this.eAD = 3;
            this.eAE = 4;
            this.eAv = new g(createGroupStepActivity, this.eAB, 1, 4);
            this.eAw = new d(createGroupStepActivity, this.eAC, 2, 4);
            this.eAx = new i(createGroupStepActivity, this.eAD, 3, 4);
            this.eAy = new b(createGroupStepActivity, this.eAE, 4, 4);
            this.eAp.a(this.eAv);
            this.eAp.a(this.eAw);
            this.eAp.a(this.eAx);
            this.eAp.a(this.eAy);
            this.ezF = 4;
        }
    }

    private void ht(boolean z) {
        this.eAo = z;
        aHv();
    }

    public boolean aHu() {
        return this.eAo;
    }

    private void aHv() {
        this.eAr.setEnabled(this.eAo);
        aj.s(this.eAr, d.f.s_navbar_button_bg);
    }

    public void aHw() {
        if (this.eAq > 1) {
            this.eAq--;
            aHy();
        }
    }

    public void aHx() {
        if (this.eAq < this.ezF) {
            this.eAq++;
            aHy();
        }
    }

    public void aHy() {
        this.eAz.setCurrentItem(this.eAq - 1);
        aHA();
        aHB();
        aHC();
        this.eAv.aGQ().clearFocus();
        this.eAw.aGK().clearFocus();
        c(this.eAv.aGQ());
        c(this.eAw.aGK());
        if (aHn() && aHg()) {
            aHc().setEnabled(false);
        } else {
            aHc().setEnabled(true);
        }
    }

    public void aHz() {
        String[] strArr = {this.ezB.getResources().getString(d.j.take_photo), this.ezB.getResources().getString(d.j.album)};
        if (this.dFU == null) {
            this.dFU = new com.baidu.tbadk.core.dialog.b(this.ezB.getPageContext().getPageActivity());
            this.dFU.dl(this.ezB.getResources().getString(d.j.operation));
            this.dFU.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.creategroup.k.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = k.this.ezB.getPageContext().getPageActivity();
                    if (k.this.bQG == null) {
                        k.this.bQG = new com.baidu.tbadk.core.util.b.a();
                    }
                    k.this.bQG.DI();
                    k.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!k.this.bQG.v(pageActivity)) {
                        if (i == 0) {
                            ai.b(k.this.ezB.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(k.this.ezB.getPageContext().getPageActivity(), k.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dFU.d(this.ezB.getPageContext());
        }
        this.dFU.AY();
    }

    public void O(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.ezB.getPageContext().getPageActivity();
        if (this.bQG == null) {
            this.bQG = new com.baidu.tbadk.core.util.b.a();
        }
        this.bQG.DI();
        this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bQG.v(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.ezB.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void mY(String str) {
        if (!this.eAr.getText().toString().equals(str)) {
            this.eAr.setText(str);
        }
    }

    private void aHA() {
        if (this.eAp.pQ(this.eAq - 1) != null) {
            this.mNavigationBar.setTitleText(this.eAp.pQ(this.eAq - 1).getTitle());
        }
    }

    public void aHB() {
        for (p pVar : this.eAp.getList()) {
            if (pVar.aGy() == this.eAq) {
                pVar.aGF();
                if (!pVar.aGJ()) {
                    this.eAr.setVisibility(8);
                } else {
                    this.eAr.setVisibility(0);
                }
                mY(pVar.aGH());
            } else {
                pVar.aGE();
            }
        }
        if (this.eAp.pQ(this.eAq - 1) != null && this.eAp.pQ(this.eAq - 1).aGI()) {
            ht(true);
        }
    }

    public void aHC() {
        if (aHl()) {
            b(this.eAv.aGQ().getText().length(), this.eAv.getLength() / 2, 2, 20);
        } else if (aHm()) {
            int length = this.eAw.getLength() / 2;
            Y(length, 15, 300);
            int i = 300 - length;
            this.eAw.aGL().setText(String.valueOf(i));
            if (i <= 50) {
                this.eAw.aGL().setVisibility(0);
            } else {
                this.eAw.aGL().setVisibility(8);
            }
            if (i == 0) {
                this.eAw.aGL().setTextColor(this.ezB.getResources().getColor(d.C0141d.common_color_10170));
            } else if (i < 0) {
                this.eAw.pP(300);
            } else {
                this.eAw.aGM();
            }
        } else if (aHo()) {
            if (this.eAy.aGA() != 3) {
                ht(true);
            } else {
                ht(false);
            }
        }
    }

    private void Y(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            ht(true);
        } else {
            ht(false);
        }
    }

    private void b(int i, float f, int i2, int i3) {
        if (i == 1) {
            ht(false);
        } else if (f >= i2 && f <= i3) {
            ht(true);
        } else {
            ht(false);
        }
        if (i < 1) {
            this.eAv.hr(false);
        } else {
            this.eAv.hr(true);
        }
    }

    public void ca(int i, int i2) {
        this.eAs = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.ezB.getLayoutMode().aQ(i == 1);
        this.ezB.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aHv();
        aj.e(this.eAr, d.C0141d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.pd()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        aj.t(viewGroup, d.C0141d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.ezB.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
