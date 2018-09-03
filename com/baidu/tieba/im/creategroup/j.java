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
import com.baidu.tieba.f;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View aVP;
    private com.baidu.tbadk.core.util.b.a bkZ;
    private String business;
    private com.baidu.tbadk.core.dialog.b dof;
    private boolean eoR;
    CreateGroupStepAdapter eoS;
    private int eoT;
    private TextView eoU;
    int eoV;
    e eoW;
    h eoX;
    g eoY;
    d eoZ;
    CreateGroupStepActivity eod;
    private int eoi;
    i epa;
    b epb;
    private NoSwipeableViewPager epc;
    private com.baidu.tieba.im.util.b epd;
    private int epe;
    private int epf;
    private int epg;
    private int eph;
    private int epi;
    private boolean epj;
    private String epk;
    private String epl;
    private String epm;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void nS(String str) {
        this.epl = str;
    }

    public void nT(String str) {
        this.epm = str;
    }

    public String aIv() {
        return this.epl;
    }

    public String aIw() {
        return this.epm;
    }

    public View aIx() {
        return this.aVP;
    }

    public int aIy() {
        return this.eoT;
    }

    public View aIz() {
        return this.eoU;
    }

    public View aIA() {
        if (this.eoW != null) {
            return this.eoW.aIk();
        }
        if (this.eoX != null) {
            return this.eoX.aIk();
        }
        return null;
    }

    public View aIB() {
        return this.epa.aIs();
    }

    public View aIC() {
        return this.epa.aIr();
    }

    public boolean aID() {
        return this.mIsLoading;
    }

    public void aHY() {
        this.epb.aHY();
        aIZ();
    }

    public void nU(String str) {
        this.epk = str;
    }

    public String aIE() {
        return this.epk;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.epb.setBusiness(str);
        aIZ();
    }

    public String getBusiness() {
        return this.business;
    }

    public void nV(String str) {
        this.epb.setAddress(str);
        aIZ();
    }

    public boolean aIF() {
        return this.epj;
    }

    public void hm(boolean z) {
        this.epj = z;
    }

    public void aHZ() {
        this.epb.aHZ();
        aIZ();
    }

    public void aIa() {
        this.epb.aIa();
        aIZ();
    }

    public View aIG() {
        return this.epb.aHW();
    }

    public int aHX() {
        return this.epb.aHX();
    }

    public View aIH() {
        return this.eoY.aIo();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.eoY.aIn().getText().toString();
    }

    public String getIntro() {
        return this.eoZ.aIh().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eoV;
    }

    public boolean aII() {
        return this.eoY != null && this.eoT == this.eoY.aHV();
    }

    public boolean aIJ() {
        return this.eoZ != null && this.eoT == this.eoZ.aHV();
    }

    public boolean aIK() {
        return this.epa != null && this.eoT == this.epa.aHV();
    }

    public boolean aIL() {
        return this.epb != null && this.eoT == this.epb.aHV();
    }

    public boolean aIM() {
        return this.eoS != null && this.eoT == this.eoS.getCount();
    }

    public String getErrMsg() {
        if (this.eoS.nT(this.eoT - 1) != null) {
            return this.eoS.nT(this.eoT - 1).getErrMsg();
        }
        return null;
    }

    public void aIN() {
        this.epa.aIs().setText(f.j.group_create_modify_photo_tip);
    }

    public void aIO() {
        this.epa.aIq();
    }

    public void clearText() {
        this.eoY.aIp();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eoR = true;
        this.mIsLoading = false;
        this.eod = null;
        this.eoS = null;
        this.progressBar = null;
        this.eoT = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aVP = null;
        this.eoU = null;
        this.dof = null;
        this.eoV = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.eoW = null;
        this.eoX = null;
        this.eoY = null;
        this.eoZ = null;
        this.epa = null;
        this.epb = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.epc = null;
        this.epd = null;
        this.epj = false;
        this.epk = "";
        this.business = "";
        this.epl = null;
        this.epm = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.epd = new com.baidu.tieba.im.util.b(this.eod);
        this.epd.setUniqueId(this.eod.getUniqueId());
        aIP();
    }

    public void aIP() {
        this.epd.MO();
    }

    public void aIQ() {
        if (this.epd != null) {
            this.epd.cancelLoad();
        }
    }

    private void initListener() {
        this.aVP.setOnClickListener(this.eod);
        this.eoU.setOnClickListener(this.eod);
        this.eoY.aIn().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.eoY.aIn().addTextChangedListener(this.eod);
        this.eoZ.aIh().addTextChangedListener(this.eod);
        this.epa.aIs().setOnClickListener(this.eod);
        this.epa.aIr().setOnClickListener(this.eod);
        this.epb.aHW().setOnClickListener(this.eod);
        if (this.eoX != null) {
            this.eoX.aIk().setOnClickListener(this.eod);
        }
        if (this.eoW != null) {
            this.eoW.aIk().setOnClickListener(this.eod);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eod = createGroupStepActivity;
        createGroupStepActivity.setContentView(f.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(f.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(f.g.progress);
        this.epc = (NoSwipeableViewPager) createGroupStepActivity.findViewById(f.g.pagercontent);
        this.eoS = new CreateGroupStepAdapter(this.eod);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.epc.setAdapter(this.eoS);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aIX();
        this.eoU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(f.j.next_step));
        ((LinearLayout.LayoutParams) this.eoU.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), f.e.ds16);
        am.i(this.eoU, f.C0146f.s_navbar_button_bg);
        hn(false);
        aIY();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.epi = 1;
            this.eph = 2;
            this.epe = 3;
            this.epf = 4;
            this.epg = 5;
            this.eoW = new e(createGroupStepActivity, this.epi, i2);
            this.epb = new b(createGroupStepActivity, this.eph, 1, 5);
            this.eoY = new g(createGroupStepActivity, this.epe, 2, 5);
            this.eoZ = new d(createGroupStepActivity, this.epf, 3, 5);
            this.epa = new i(createGroupStepActivity, this.epg, 4, 5);
            this.eoS.a(this.eoW);
            this.eoS.a(this.epb);
            this.eoS.a(this.eoY);
            this.eoS.a(this.eoZ);
            this.eoS.a(this.epa);
            this.eoi = 5;
        } else if (i == 2) {
            this.epi = 1;
            this.epe = 2;
            this.epf = 3;
            this.epg = 4;
            this.eph = 5;
            this.eoX = new h(createGroupStepActivity, this.epi, i3);
            this.eoY = new g(createGroupStepActivity, this.epe, 1, 5);
            this.eoZ = new d(createGroupStepActivity, this.epf, 2, 5);
            this.epa = new i(createGroupStepActivity, this.epg, 3, 5);
            this.epb = new b(createGroupStepActivity, this.eph, 4, 5);
            this.eoS.a(this.eoX);
            this.eoS.a(this.eoY);
            this.eoS.a(this.eoZ);
            this.eoS.a(this.epa);
            this.eoS.a(this.epb);
            this.eoi = 5;
        } else {
            this.epe = 1;
            this.epf = 2;
            this.epg = 3;
            this.eph = 4;
            this.eoY = new g(createGroupStepActivity, this.epe, 1, 4);
            this.eoZ = new d(createGroupStepActivity, this.epf, 2, 4);
            this.epa = new i(createGroupStepActivity, this.epg, 3, 4);
            this.epb = new b(createGroupStepActivity, this.eph, 4, 4);
            this.eoS.a(this.eoY);
            this.eoS.a(this.eoZ);
            this.eoS.a(this.epa);
            this.eoS.a(this.epb);
            this.eoi = 4;
        }
    }

    private void hn(boolean z) {
        this.eoR = z;
        aIS();
    }

    public boolean aIR() {
        return this.eoR;
    }

    private void aIS() {
        this.eoU.setEnabled(this.eoR);
        am.i(this.eoU, f.C0146f.s_navbar_button_bg);
    }

    public void aIT() {
        if (this.eoT > 1) {
            this.eoT--;
            aIV();
        }
    }

    public void aIU() {
        if (this.eoT < this.eoi) {
            this.eoT++;
            aIV();
        }
    }

    public void aIV() {
        this.epc.setCurrentItem(this.eoT - 1);
        aIX();
        aIY();
        aIZ();
        this.eoY.aIn().clearFocus();
        this.eoZ.aIh().clearFocus();
        c(this.eoY.aIn());
        c(this.eoZ.aIh());
        if (aIK() && aID()) {
            aIz().setEnabled(false);
        } else {
            aIz().setEnabled(true);
        }
    }

    public void aIW() {
        String[] strArr = {this.eod.getResources().getString(f.j.take_photo), this.eod.getResources().getString(f.j.album)};
        if (this.dof == null) {
            this.dof = new com.baidu.tbadk.core.dialog.b(this.eod.getPageContext().getPageActivity());
            this.dof.dC(this.eod.getResources().getString(f.j.operation));
            this.dof.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eod.getPageContext().getPageActivity();
                    if (j.this.bkZ == null) {
                        j.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bkZ.zW();
                    j.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bkZ.u(pageActivity)) {
                        if (i == 0) {
                            al.b(j.this.eod.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eod.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.dof.d(this.eod.getPageContext());
        }
        this.dof.xh();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eod.getPageContext().getPageActivity();
        if (this.bkZ == null) {
            this.bkZ = new com.baidu.tbadk.core.util.b.a();
        }
        this.bkZ.zW();
        this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkZ.u(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eod.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nW(String str) {
        if (!this.eoU.getText().toString().equals(str)) {
            this.eoU.setText(str);
        }
    }

    private void aIX() {
        if (this.eoS.nT(this.eoT - 1) != null) {
            this.mNavigationBar.setTitleText(this.eoS.nT(this.eoT - 1).getTitle());
        }
    }

    public void aIY() {
        for (o oVar : this.eoS.getList()) {
            if (oVar.aHV() == this.eoT) {
                oVar.aIc();
                if (!oVar.aIg()) {
                    this.eoU.setVisibility(8);
                } else {
                    this.eoU.setVisibility(0);
                }
                nW(oVar.aIe());
            } else {
                oVar.aIb();
            }
        }
        if (this.eoS.nT(this.eoT - 1) != null && this.eoS.nT(this.eoT - 1).aIf()) {
            hn(true);
        }
    }

    public void aIZ() {
        if (aII()) {
            a(this.eoY.aIn().getText().length(), this.eoY.getLength() / 2, 2, 20);
        } else if (aIJ()) {
            int length = this.eoZ.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.eoZ.aIi().setText(String.valueOf(i));
            if (i <= 50) {
                this.eoZ.aIi().setVisibility(0);
            } else {
                this.eoZ.aIi().setVisibility(8);
            }
            if (i == 0) {
                this.eoZ.aIi().setTextColor(this.eod.getResources().getColor(f.d.common_color_10170));
            } else if (i < 0) {
                this.eoZ.nS(300);
            } else {
                this.eoZ.aIj();
            }
        } else if (aIL()) {
            if (this.epb.aHX() != 3) {
                hn(true);
            } else {
                hn(false);
            }
        }
    }

    private void M(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            hn(true);
        } else {
            hn(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            hn(false);
        } else if (f >= i2 && f <= i3) {
            hn(true);
        } else {
            hn(false);
        }
        if (i < 1) {
            this.eoY.hl(false);
        } else {
            this.eoY.hl(true);
        }
    }

    public void setData(int i, int i2) {
        this.eoV = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eod.getLayoutMode().setNightMode(i == 1);
        this.eod.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aIS();
        am.c(this.eoU, f.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.jY()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.j(viewGroup, f.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eod.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
