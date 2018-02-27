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
    private View bCp;
    private com.baidu.tbadk.core.util.b.a bQD;
    private String business;
    private com.baidu.tbadk.core.dialog.b dFQ;
    private int eAa;
    private TextView eAb;
    int eAc;
    e eAd;
    h eAe;
    g eAf;
    d eAg;
    i eAh;
    b eAi;
    private NoSwipeableViewPager eAj;
    private com.baidu.tieba.im.util.b eAk;
    private int eAl;
    private int eAm;
    private int eAn;
    private int eAo;
    private int eAp;
    private boolean eAq;
    private String eAr;
    private String eAs;
    private String eAt;
    private boolean ezY;
    j ezZ;
    CreateGroupStepActivity ezl;
    private int ezp;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void mU(String str) {
        this.eAs = str;
    }

    public void mV(String str) {
        this.eAt = str;
    }

    public String aGX() {
        return this.eAs;
    }

    public String aGY() {
        return this.eAt;
    }

    public View aGZ() {
        return this.bCp;
    }

    public int aHa() {
        return this.eAa;
    }

    public View aHb() {
        return this.eAb;
    }

    public View aHc() {
        if (this.eAd != null) {
            return this.eAd.aGM();
        }
        if (this.eAe != null) {
            return this.eAe.aGM();
        }
        return null;
    }

    public View aHd() {
        return this.eAh.aGU();
    }

    public View aHe() {
        return this.eAh.aGT();
    }

    public boolean aHf() {
        return this.mIsLoading;
    }

    public void aGA() {
        this.eAi.aGA();
        aHB();
    }

    public void mW(String str) {
        this.eAr = str;
    }

    public String aHg() {
        return this.eAr;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.eAi.setBusiness(str);
        aHB();
    }

    public String getBusiness() {
        return this.business;
    }

    public void mX(String str) {
        this.eAi.setAddress(str);
        aHB();
    }

    public boolean aHh() {
        return this.eAq;
    }

    public void hn(boolean z) {
        this.eAq = z;
    }

    public void aGB() {
        this.eAi.aGB();
        aHB();
    }

    public void aGC() {
        this.eAi.aGC();
        aHB();
    }

    public View aHi() {
        return this.eAi.aGy();
    }

    public int aGz() {
        return this.eAi.aGz();
    }

    public View aHj() {
        return this.eAf.aGQ();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eAf.aGP().getText().toString();
    }

    public String getIntro() {
        return this.eAg.aGJ().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eAc;
    }

    public boolean aHk() {
        return this.eAf != null && this.eAa == this.eAf.aGx();
    }

    public boolean aHl() {
        return this.eAg != null && this.eAa == this.eAg.aGx();
    }

    public boolean aHm() {
        return this.eAh != null && this.eAa == this.eAh.aGx();
    }

    public boolean aHn() {
        return this.eAi != null && this.eAa == this.eAi.aGx();
    }

    public boolean aHo() {
        return this.ezZ != null && this.eAa == this.ezZ.getCount();
    }

    public String getErrMsg() {
        if (this.ezZ.pP(this.eAa - 1) != null) {
            return this.ezZ.pP(this.eAa - 1).getErrMsg();
        }
        return null;
    }

    public void aHp() {
        this.eAh.aGU().setText(d.j.group_create_modify_photo_tip);
    }

    public void aHq() {
        this.eAh.aGS();
    }

    public void clearText() {
        this.eAf.aGR();
    }

    public k(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.ezY = true;
        this.mIsLoading = false;
        this.ezl = null;
        this.ezZ = null;
        this.progressBar = null;
        this.eAa = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bCp = null;
        this.eAb = null;
        this.dFQ = null;
        this.eAc = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eAd = null;
        this.eAe = null;
        this.eAf = null;
        this.eAg = null;
        this.eAh = null;
        this.eAi = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eAj = null;
        this.eAk = null;
        this.eAq = false;
        this.eAr = "";
        this.business = "";
        this.eAs = null;
        this.eAt = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eAk = new com.baidu.tieba.im.util.b(this.ezl);
        this.eAk.setUniqueId(this.ezl.getUniqueId());
        aHr();
    }

    public void aHr() {
        this.eAk.Qz();
    }

    public void aHs() {
        if (this.eAk != null) {
            this.eAk.dE();
        }
    }

    private void initListener() {
        this.bCp.setOnClickListener(this.ezl);
        this.eAb.setOnClickListener(this.ezl);
        this.eAf.aGP().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eAf.aGP().addTextChangedListener(this.ezl);
        this.eAg.aGJ().addTextChangedListener(this.ezl);
        this.eAh.aGU().setOnClickListener(this.ezl);
        this.eAh.aGT().setOnClickListener(this.ezl);
        this.eAi.aGy().setOnClickListener(this.ezl);
        if (this.eAe != null) {
            this.eAe.aGM().setOnClickListener(this.ezl);
        }
        if (this.eAd != null) {
            this.eAd.aGM().setOnClickListener(this.ezl);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.ezl = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.eAj = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.ezZ = new j(this.ezl);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.eAj.setAdapter(this.ezZ);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.bCp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aHz();
        this.eAb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.j.next_step));
        ((LinearLayout.LayoutParams) this.eAb.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.t(getPageContext().getPageActivity(), d.e.ds16);
        aj.s(this.eAb, d.f.s_navbar_button_bg);
        ho(false);
        aHA();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.eAp = 1;
            this.eAo = 2;
            this.eAl = 3;
            this.eAm = 4;
            this.eAn = 5;
            this.eAd = new e(createGroupStepActivity, this.eAp, i2);
            this.eAi = new b(createGroupStepActivity, this.eAo, 1, 5);
            this.eAf = new g(createGroupStepActivity, this.eAl, 2, 5);
            this.eAg = new d(createGroupStepActivity, this.eAm, 3, 5);
            this.eAh = new i(createGroupStepActivity, this.eAn, 4, 5);
            this.ezZ.a(this.eAd);
            this.ezZ.a(this.eAi);
            this.ezZ.a(this.eAf);
            this.ezZ.a(this.eAg);
            this.ezZ.a(this.eAh);
            this.ezp = 5;
        } else if (i == 2) {
            this.eAp = 1;
            this.eAl = 2;
            this.eAm = 3;
            this.eAn = 4;
            this.eAo = 5;
            this.eAe = new h(createGroupStepActivity, this.eAp, i3);
            this.eAf = new g(createGroupStepActivity, this.eAl, 1, 5);
            this.eAg = new d(createGroupStepActivity, this.eAm, 2, 5);
            this.eAh = new i(createGroupStepActivity, this.eAn, 3, 5);
            this.eAi = new b(createGroupStepActivity, this.eAo, 4, 5);
            this.ezZ.a(this.eAe);
            this.ezZ.a(this.eAf);
            this.ezZ.a(this.eAg);
            this.ezZ.a(this.eAh);
            this.ezZ.a(this.eAi);
            this.ezp = 5;
        } else {
            this.eAl = 1;
            this.eAm = 2;
            this.eAn = 3;
            this.eAo = 4;
            this.eAf = new g(createGroupStepActivity, this.eAl, 1, 4);
            this.eAg = new d(createGroupStepActivity, this.eAm, 2, 4);
            this.eAh = new i(createGroupStepActivity, this.eAn, 3, 4);
            this.eAi = new b(createGroupStepActivity, this.eAo, 4, 4);
            this.ezZ.a(this.eAf);
            this.ezZ.a(this.eAg);
            this.ezZ.a(this.eAh);
            this.ezZ.a(this.eAi);
            this.ezp = 4;
        }
    }

    private void ho(boolean z) {
        this.ezY = z;
        aHu();
    }

    public boolean aHt() {
        return this.ezY;
    }

    private void aHu() {
        this.eAb.setEnabled(this.ezY);
        aj.s(this.eAb, d.f.s_navbar_button_bg);
    }

    public void aHv() {
        if (this.eAa > 1) {
            this.eAa--;
            aHx();
        }
    }

    public void aHw() {
        if (this.eAa < this.ezp) {
            this.eAa++;
            aHx();
        }
    }

    public void aHx() {
        this.eAj.setCurrentItem(this.eAa - 1);
        aHz();
        aHA();
        aHB();
        this.eAf.aGP().clearFocus();
        this.eAg.aGJ().clearFocus();
        c(this.eAf.aGP());
        c(this.eAg.aGJ());
        if (aHm() && aHf()) {
            aHb().setEnabled(false);
        } else {
            aHb().setEnabled(true);
        }
    }

    public void aHy() {
        String[] strArr = {this.ezl.getResources().getString(d.j.take_photo), this.ezl.getResources().getString(d.j.album)};
        if (this.dFQ == null) {
            this.dFQ = new com.baidu.tbadk.core.dialog.b(this.ezl.getPageContext().getPageActivity());
            this.dFQ.dl(this.ezl.getResources().getString(d.j.operation));
            this.dFQ.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.creategroup.k.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = k.this.ezl.getPageContext().getPageActivity();
                    if (k.this.bQD == null) {
                        k.this.bQD = new com.baidu.tbadk.core.util.b.a();
                    }
                    k.this.bQD.DH();
                    k.this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!k.this.bQD.v(pageActivity)) {
                        if (i == 0) {
                            ai.b(k.this.ezl.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(k.this.ezl.getPageContext().getPageActivity(), k.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dFQ.d(this.ezl.getPageContext());
        }
        this.dFQ.AX();
    }

    public void O(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.ezl.getPageContext().getPageActivity();
        if (this.bQD == null) {
            this.bQD = new com.baidu.tbadk.core.util.b.a();
        }
        this.bQD.DH();
        this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bQD.v(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.ezl.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void mY(String str) {
        if (!this.eAb.getText().toString().equals(str)) {
            this.eAb.setText(str);
        }
    }

    private void aHz() {
        if (this.ezZ.pP(this.eAa - 1) != null) {
            this.mNavigationBar.setTitleText(this.ezZ.pP(this.eAa - 1).getTitle());
        }
    }

    public void aHA() {
        for (p pVar : this.ezZ.getList()) {
            if (pVar.aGx() == this.eAa) {
                pVar.aGE();
                if (!pVar.aGI()) {
                    this.eAb.setVisibility(8);
                } else {
                    this.eAb.setVisibility(0);
                }
                mY(pVar.aGG());
            } else {
                pVar.aGD();
            }
        }
        if (this.ezZ.pP(this.eAa - 1) != null && this.ezZ.pP(this.eAa - 1).aGH()) {
            ho(true);
        }
    }

    public void aHB() {
        if (aHk()) {
            b(this.eAf.aGP().getText().length(), this.eAf.getLength() / 2, 2, 20);
        } else if (aHl()) {
            int length = this.eAg.getLength() / 2;
            Y(length, 15, 300);
            int i = 300 - length;
            this.eAg.aGK().setText(String.valueOf(i));
            if (i <= 50) {
                this.eAg.aGK().setVisibility(0);
            } else {
                this.eAg.aGK().setVisibility(8);
            }
            if (i == 0) {
                this.eAg.aGK().setTextColor(this.ezl.getResources().getColor(d.C0141d.common_color_10170));
            } else if (i < 0) {
                this.eAg.pO(300);
            } else {
                this.eAg.aGL();
            }
        } else if (aHn()) {
            if (this.eAi.aGz() != 3) {
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
            this.eAf.hm(false);
        } else {
            this.eAf.hm(true);
        }
    }

    public void ca(int i, int i2) {
        this.eAc = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.ezl.getLayoutMode().aQ(i == 1);
        this.ezl.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aHu();
        aj.e(this.eAb, d.C0141d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.pd()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        aj.t(viewGroup, d.C0141d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.ezl.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
