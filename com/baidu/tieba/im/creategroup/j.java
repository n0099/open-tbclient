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
    private View aVP;
    private com.baidu.tbadk.core.util.b.a bkU;
    private String business;
    private com.baidu.tbadk.core.dialog.b doh;
    private boolean eoV;
    CreateGroupStepAdapter eoW;
    private int eoX;
    private TextView eoY;
    int eoZ;
    CreateGroupStepActivity eoi;
    private int eom;
    e epa;
    h epb;
    g epc;
    d epd;
    i epe;
    b epf;
    private NoSwipeableViewPager epg;
    private com.baidu.tieba.im.util.b eph;
    private int epi;
    private int epj;
    private int epk;
    private int epl;
    private int epm;
    private boolean epn;
    private String epo;
    private String epp;
    private String epq;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void nQ(String str) {
        this.epp = str;
    }

    public void nR(String str) {
        this.epq = str;
    }

    public String aIy() {
        return this.epp;
    }

    public String aIz() {
        return this.epq;
    }

    public View aIA() {
        return this.aVP;
    }

    public int aIB() {
        return this.eoX;
    }

    public View aIC() {
        return this.eoY;
    }

    public View aID() {
        if (this.epa != null) {
            return this.epa.aIn();
        }
        if (this.epb != null) {
            return this.epb.aIn();
        }
        return null;
    }

    public View aIE() {
        return this.epe.aIv();
    }

    public View aIF() {
        return this.epe.aIu();
    }

    public boolean aIG() {
        return this.mIsLoading;
    }

    public void aIb() {
        this.epf.aIb();
        aJc();
    }

    public void nS(String str) {
        this.epo = str;
    }

    public String aIH() {
        return this.epo;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.epf.setBusiness(str);
        aJc();
    }

    public String getBusiness() {
        return this.business;
    }

    public void nT(String str) {
        this.epf.setAddress(str);
        aJc();
    }

    public boolean aII() {
        return this.epn;
    }

    public void hm(boolean z) {
        this.epn = z;
    }

    public void aIc() {
        this.epf.aIc();
        aJc();
    }

    public void aId() {
        this.epf.aId();
        aJc();
    }

    public View aIJ() {
        return this.epf.aHZ();
    }

    public int aIa() {
        return this.epf.aIa();
    }

    public View aIK() {
        return this.epc.aIr();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.epc.aIq().getText().toString();
    }

    public String getIntro() {
        return this.epd.aIk().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.eoZ;
    }

    public boolean aIL() {
        return this.epc != null && this.eoX == this.epc.aHY();
    }

    public boolean aIM() {
        return this.epd != null && this.eoX == this.epd.aHY();
    }

    public boolean aIN() {
        return this.epe != null && this.eoX == this.epe.aHY();
    }

    public boolean aIO() {
        return this.epf != null && this.eoX == this.epf.aHY();
    }

    public boolean aIP() {
        return this.eoW != null && this.eoX == this.eoW.getCount();
    }

    public String getErrMsg() {
        if (this.eoW.nT(this.eoX - 1) != null) {
            return this.eoW.nT(this.eoX - 1).getErrMsg();
        }
        return null;
    }

    public void aIQ() {
        this.epe.aIv().setText(d.j.group_create_modify_photo_tip);
    }

    public void aIR() {
        this.epe.aIt();
    }

    public void clearText() {
        this.epc.aIs();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.eoV = true;
        this.mIsLoading = false;
        this.eoi = null;
        this.eoW = null;
        this.progressBar = null;
        this.eoX = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aVP = null;
        this.eoY = null;
        this.doh = null;
        this.eoZ = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.epa = null;
        this.epb = null;
        this.epc = null;
        this.epd = null;
        this.epe = null;
        this.epf = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.epg = null;
        this.eph = null;
        this.epn = false;
        this.epo = "";
        this.business = "";
        this.epp = null;
        this.epq = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eph = new com.baidu.tieba.im.util.b(this.eoi);
        this.eph.setUniqueId(this.eoi.getUniqueId());
        aIS();
    }

    public void aIS() {
        this.eph.MK();
    }

    public void aIT() {
        if (this.eph != null) {
            this.eph.cancelLoad();
        }
    }

    private void initListener() {
        this.aVP.setOnClickListener(this.eoi);
        this.eoY.setOnClickListener(this.eoi);
        this.epc.aIq().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.epc.aIq().addTextChangedListener(this.eoi);
        this.epd.aIk().addTextChangedListener(this.eoi);
        this.epe.aIv().setOnClickListener(this.eoi);
        this.epe.aIu().setOnClickListener(this.eoi);
        this.epf.aHZ().setOnClickListener(this.eoi);
        if (this.epb != null) {
            this.epb.aIn().setOnClickListener(this.eoi);
        }
        if (this.epa != null) {
            this.epa.aIn().setOnClickListener(this.eoi);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.eoi = createGroupStepActivity;
        createGroupStepActivity.setContentView(d.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(d.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(d.g.progress);
        this.epg = (NoSwipeableViewPager) createGroupStepActivity.findViewById(d.g.pagercontent);
        this.eoW = new CreateGroupStepAdapter(this.eoi);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.epg.setAdapter(this.eoW);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aJa();
        this.eoY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(d.j.next_step));
        ((LinearLayout.LayoutParams) this.eoY.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), d.e.ds16);
        am.i(this.eoY, d.f.s_navbar_button_bg);
        hn(false);
        aJb();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.epm = 1;
            this.epl = 2;
            this.epi = 3;
            this.epj = 4;
            this.epk = 5;
            this.epa = new e(createGroupStepActivity, this.epm, i2);
            this.epf = new b(createGroupStepActivity, this.epl, 1, 5);
            this.epc = new g(createGroupStepActivity, this.epi, 2, 5);
            this.epd = new d(createGroupStepActivity, this.epj, 3, 5);
            this.epe = new i(createGroupStepActivity, this.epk, 4, 5);
            this.eoW.a(this.epa);
            this.eoW.a(this.epf);
            this.eoW.a(this.epc);
            this.eoW.a(this.epd);
            this.eoW.a(this.epe);
            this.eom = 5;
        } else if (i == 2) {
            this.epm = 1;
            this.epi = 2;
            this.epj = 3;
            this.epk = 4;
            this.epl = 5;
            this.epb = new h(createGroupStepActivity, this.epm, i3);
            this.epc = new g(createGroupStepActivity, this.epi, 1, 5);
            this.epd = new d(createGroupStepActivity, this.epj, 2, 5);
            this.epe = new i(createGroupStepActivity, this.epk, 3, 5);
            this.epf = new b(createGroupStepActivity, this.epl, 4, 5);
            this.eoW.a(this.epb);
            this.eoW.a(this.epc);
            this.eoW.a(this.epd);
            this.eoW.a(this.epe);
            this.eoW.a(this.epf);
            this.eom = 5;
        } else {
            this.epi = 1;
            this.epj = 2;
            this.epk = 3;
            this.epl = 4;
            this.epc = new g(createGroupStepActivity, this.epi, 1, 4);
            this.epd = new d(createGroupStepActivity, this.epj, 2, 4);
            this.epe = new i(createGroupStepActivity, this.epk, 3, 4);
            this.epf = new b(createGroupStepActivity, this.epl, 4, 4);
            this.eoW.a(this.epc);
            this.eoW.a(this.epd);
            this.eoW.a(this.epe);
            this.eoW.a(this.epf);
            this.eom = 4;
        }
    }

    private void hn(boolean z) {
        this.eoV = z;
        aIV();
    }

    public boolean aIU() {
        return this.eoV;
    }

    private void aIV() {
        this.eoY.setEnabled(this.eoV);
        am.i(this.eoY, d.f.s_navbar_button_bg);
    }

    public void aIW() {
        if (this.eoX > 1) {
            this.eoX--;
            aIY();
        }
    }

    public void aIX() {
        if (this.eoX < this.eom) {
            this.eoX++;
            aIY();
        }
    }

    public void aIY() {
        this.epg.setCurrentItem(this.eoX - 1);
        aJa();
        aJb();
        aJc();
        this.epc.aIq().clearFocus();
        this.epd.aIk().clearFocus();
        c(this.epc.aIq());
        c(this.epd.aIk());
        if (aIN() && aIG()) {
            aIC().setEnabled(false);
        } else {
            aIC().setEnabled(true);
        }
    }

    public void aIZ() {
        String[] strArr = {this.eoi.getResources().getString(d.j.take_photo), this.eoi.getResources().getString(d.j.album)};
        if (this.doh == null) {
            this.doh = new com.baidu.tbadk.core.dialog.b(this.eoi.getPageContext().getPageActivity());
            this.doh.dC(this.eoi.getResources().getString(d.j.operation));
            this.doh.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.eoi.getPageContext().getPageActivity();
                    if (j.this.bkU == null) {
                        j.this.bkU = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bkU.zY();
                    j.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bkU.u(pageActivity)) {
                        if (i == 0) {
                            al.b(j.this.eoi.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.eoi.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.doh.d(this.eoi.getPageContext());
        }
        this.doh.xi();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.eoi.getPageContext().getPageActivity();
        if (this.bkU == null) {
            this.bkU = new com.baidu.tbadk.core.util.b.a();
        }
        this.bkU.zY();
        this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkU.u(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.eoi.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void nU(String str) {
        if (!this.eoY.getText().toString().equals(str)) {
            this.eoY.setText(str);
        }
    }

    private void aJa() {
        if (this.eoW.nT(this.eoX - 1) != null) {
            this.mNavigationBar.setTitleText(this.eoW.nT(this.eoX - 1).getTitle());
        }
    }

    public void aJb() {
        for (o oVar : this.eoW.getList()) {
            if (oVar.aHY() == this.eoX) {
                oVar.aIf();
                if (!oVar.aIj()) {
                    this.eoY.setVisibility(8);
                } else {
                    this.eoY.setVisibility(0);
                }
                nU(oVar.aIh());
            } else {
                oVar.aIe();
            }
        }
        if (this.eoW.nT(this.eoX - 1) != null && this.eoW.nT(this.eoX - 1).aIi()) {
            hn(true);
        }
    }

    public void aJc() {
        if (aIL()) {
            a(this.epc.aIq().getText().length(), this.epc.getLength() / 2, 2, 20);
        } else if (aIM()) {
            int length = this.epd.getLength() / 2;
            M(length, 15, 300);
            int i = 300 - length;
            this.epd.aIl().setText(String.valueOf(i));
            if (i <= 50) {
                this.epd.aIl().setVisibility(0);
            } else {
                this.epd.aIl().setVisibility(8);
            }
            if (i == 0) {
                this.epd.aIl().setTextColor(this.eoi.getResources().getColor(d.C0140d.common_color_10170));
            } else if (i < 0) {
                this.epd.nS(300);
            } else {
                this.epd.aIm();
            }
        } else if (aIO()) {
            if (this.epf.aIa() != 3) {
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
            this.epc.hl(false);
        } else {
            this.epc.hl(true);
        }
    }

    public void setData(int i, int i2) {
        this.eoZ = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.eoi.getLayoutMode().setNightMode(i == 1);
        this.eoi.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aIV();
        am.c(this.eoY, d.C0140d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.jY()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.j(viewGroup, d.C0140d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.eoi.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
