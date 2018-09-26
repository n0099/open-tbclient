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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c {
    private View aZe;
    private com.baidu.tbadk.core.util.b.a bqO;
    private String business;
    private com.baidu.tbadk.core.dialog.b duc;
    private int evB;
    CreateGroupStepActivity evx;
    private int ewA;
    private int ewB;
    private boolean ewC;
    private String ewD;
    private String ewE;
    private String ewF;
    private boolean ewk;
    CreateGroupStepAdapter ewl;
    private int ewm;
    private TextView ewn;
    int ewo;
    e ewp;
    h ewq;
    g ewr;
    d ews;
    i ewt;
    b ewu;
    private NoSwipeableViewPager ewv;
    private com.baidu.tieba.im.util.b eww;
    private int ewx;
    private int ewy;
    private int ewz;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void oz(String str) {
        this.ewE = str;
    }

    public void oA(String str) {
        this.ewF = str;
    }

    public String aKK() {
        return this.ewE;
    }

    public String aKL() {
        return this.ewF;
    }

    public View aKM() {
        return this.aZe;
    }

    public int aKN() {
        return this.ewm;
    }

    public View aKO() {
        return this.ewn;
    }

    public View aKP() {
        if (this.ewp != null) {
            return this.ewp.aKz();
        }
        if (this.ewq != null) {
            return this.ewq.aKz();
        }
        return null;
    }

    public View aKQ() {
        return this.ewt.aKH();
    }

    public View aKR() {
        return this.ewt.aKG();
    }

    public boolean aKS() {
        return this.mIsLoading;
    }

    public void aKn() {
        this.ewu.aKn();
        aLo();
    }

    public void oB(String str) {
        this.ewD = str;
    }

    public String aKT() {
        return this.ewD;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.ewu.setBusiness(str);
        aLo();
    }

    public String getBusiness() {
        return this.business;
    }

    public void oC(String str) {
        this.ewu.setAddress(str);
        aLo();
    }

    public boolean aKU() {
        return this.ewC;
    }

    public void hK(boolean z) {
        this.ewC = z;
    }

    public void aKo() {
        this.ewu.aKo();
        aLo();
    }

    public void aKp() {
        this.ewu.aKp();
        aLo();
    }

    public View aKV() {
        return this.ewu.aKl();
    }

    public int aKm() {
        return this.ewu.aKm();
    }

    public View aKW() {
        return this.ewr.aKD();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.ewr.aKC().getText().toString();
    }

    public String getIntro() {
        return this.ews.aKw().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.ewo;
    }

    public boolean aKX() {
        return this.ewr != null && this.ewm == this.ewr.aKk();
    }

    public boolean aKY() {
        return this.ews != null && this.ewm == this.ews.aKk();
    }

    public boolean aKZ() {
        return this.ewt != null && this.ewm == this.ewt.aKk();
    }

    public boolean aLa() {
        return this.ewu != null && this.ewm == this.ewu.aKk();
    }

    public boolean aLb() {
        return this.ewl != null && this.ewm == this.ewl.getCount();
    }

    public String getErrMsg() {
        if (this.ewl.ox(this.ewm - 1) != null) {
            return this.ewl.ox(this.ewm - 1).getErrMsg();
        }
        return null;
    }

    public void aLc() {
        this.ewt.aKH().setText(e.j.group_create_modify_photo_tip);
    }

    public void aLd() {
        this.ewt.aKF();
    }

    public void clearText() {
        this.ewr.aKE();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.ewk = true;
        this.mIsLoading = false;
        this.evx = null;
        this.ewl = null;
        this.progressBar = null;
        this.ewm = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aZe = null;
        this.ewn = null;
        this.duc = null;
        this.ewo = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.ewp = null;
        this.ewq = null;
        this.ewr = null;
        this.ews = null;
        this.ewt = null;
        this.ewu = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ewv = null;
        this.eww = null;
        this.ewC = false;
        this.ewD = "";
        this.business = "";
        this.ewE = null;
        this.ewF = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.eww = new com.baidu.tieba.im.util.b(this.evx);
        this.eww.setUniqueId(this.evx.getUniqueId());
        aLe();
    }

    public void aLe() {
        this.eww.Og();
    }

    public void aLf() {
        if (this.eww != null) {
            this.eww.cancelLoad();
        }
    }

    private void initListener() {
        this.aZe.setOnClickListener(this.evx);
        this.ewn.setOnClickListener(this.evx);
        this.ewr.aKC().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.ewr.aKC().addTextChangedListener(this.evx);
        this.ews.aKw().addTextChangedListener(this.evx);
        this.ewt.aKH().setOnClickListener(this.evx);
        this.ewt.aKG().setOnClickListener(this.evx);
        this.ewu.aKl().setOnClickListener(this.evx);
        if (this.ewq != null) {
            this.ewq.aKz().setOnClickListener(this.evx);
        }
        if (this.ewp != null) {
            this.ewp.aKz().setOnClickListener(this.evx);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.evx = createGroupStepActivity;
        createGroupStepActivity.setContentView(e.h.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(e.g.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(e.g.progress);
        this.ewv = (NoSwipeableViewPager) createGroupStepActivity.findViewById(e.g.pagercontent);
        this.ewl = new CreateGroupStepAdapter(this.evx);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.ewv.setAdapter(this.ewl);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.aZe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        aLm();
        this.ewn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(e.j.next_step));
        ((LinearLayout.LayoutParams) this.ewn.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.h(getPageContext().getPageActivity(), e.C0141e.ds16);
        al.i(this.ewn, e.f.s_navbar_button_bg);
        hL(false);
        aLn();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.ewB = 1;
            this.ewA = 2;
            this.ewx = 3;
            this.ewy = 4;
            this.ewz = 5;
            this.ewp = new e(createGroupStepActivity, this.ewB, i2);
            this.ewu = new b(createGroupStepActivity, this.ewA, 1, 5);
            this.ewr = new g(createGroupStepActivity, this.ewx, 2, 5);
            this.ews = new d(createGroupStepActivity, this.ewy, 3, 5);
            this.ewt = new i(createGroupStepActivity, this.ewz, 4, 5);
            this.ewl.a(this.ewp);
            this.ewl.a(this.ewu);
            this.ewl.a(this.ewr);
            this.ewl.a(this.ews);
            this.ewl.a(this.ewt);
            this.evB = 5;
        } else if (i == 2) {
            this.ewB = 1;
            this.ewx = 2;
            this.ewy = 3;
            this.ewz = 4;
            this.ewA = 5;
            this.ewq = new h(createGroupStepActivity, this.ewB, i3);
            this.ewr = new g(createGroupStepActivity, this.ewx, 1, 5);
            this.ews = new d(createGroupStepActivity, this.ewy, 2, 5);
            this.ewt = new i(createGroupStepActivity, this.ewz, 3, 5);
            this.ewu = new b(createGroupStepActivity, this.ewA, 4, 5);
            this.ewl.a(this.ewq);
            this.ewl.a(this.ewr);
            this.ewl.a(this.ews);
            this.ewl.a(this.ewt);
            this.ewl.a(this.ewu);
            this.evB = 5;
        } else {
            this.ewx = 1;
            this.ewy = 2;
            this.ewz = 3;
            this.ewA = 4;
            this.ewr = new g(createGroupStepActivity, this.ewx, 1, 4);
            this.ews = new d(createGroupStepActivity, this.ewy, 2, 4);
            this.ewt = new i(createGroupStepActivity, this.ewz, 3, 4);
            this.ewu = new b(createGroupStepActivity, this.ewA, 4, 4);
            this.ewl.a(this.ewr);
            this.ewl.a(this.ews);
            this.ewl.a(this.ewt);
            this.ewl.a(this.ewu);
            this.evB = 4;
        }
    }

    private void hL(boolean z) {
        this.ewk = z;
        aLh();
    }

    public boolean aLg() {
        return this.ewk;
    }

    private void aLh() {
        this.ewn.setEnabled(this.ewk);
        al.i(this.ewn, e.f.s_navbar_button_bg);
    }

    public void aLi() {
        if (this.ewm > 1) {
            this.ewm--;
            aLk();
        }
    }

    public void aLj() {
        if (this.ewm < this.evB) {
            this.ewm++;
            aLk();
        }
    }

    public void aLk() {
        this.ewv.setCurrentItem(this.ewm - 1);
        aLm();
        aLn();
        aLo();
        this.ewr.aKC().clearFocus();
        this.ews.aKw().clearFocus();
        c(this.ewr.aKC());
        c(this.ews.aKw());
        if (aKZ() && aKS()) {
            aKO().setEnabled(false);
        } else {
            aKO().setEnabled(true);
        }
    }

    public void aLl() {
        String[] strArr = {this.evx.getResources().getString(e.j.take_photo), this.evx.getResources().getString(e.j.album)};
        if (this.duc == null) {
            this.duc = new com.baidu.tbadk.core.dialog.b(this.evx.getPageContext().getPageActivity());
            this.duc.dU(this.evx.getResources().getString(e.j.operation));
            this.duc.a(strArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    Activity pageActivity = j.this.evx.getPageContext().getPageActivity();
                    if (j.this.bqO == null) {
                        j.this.bqO = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.bqO.Bb();
                    j.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.bqO.x(pageActivity)) {
                        if (i == 0) {
                            ak.b(j.this.evx.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.evx.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
            this.duc.d(this.evx.getPageContext());
        }
        this.duc.yo();
    }

    public void N(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.evx.getPageContext().getPageActivity();
        if (this.bqO == null) {
            this.bqO = new com.baidu.tbadk.core.util.b.a();
        }
        this.bqO.Bb();
        this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bqO.x(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.evx.getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void oD(String str) {
        if (!this.ewn.getText().toString().equals(str)) {
            this.ewn.setText(str);
        }
    }

    private void aLm() {
        if (this.ewl.ox(this.ewm - 1) != null) {
            this.mNavigationBar.setTitleText(this.ewl.ox(this.ewm - 1).getTitle());
        }
    }

    public void aLn() {
        for (o oVar : this.ewl.getList()) {
            if (oVar.aKk() == this.ewm) {
                oVar.aKr();
                if (!oVar.aKv()) {
                    this.ewn.setVisibility(8);
                } else {
                    this.ewn.setVisibility(0);
                }
                oD(oVar.aKt());
            } else {
                oVar.aKq();
            }
        }
        if (this.ewl.ox(this.ewm - 1) != null && this.ewl.ox(this.ewm - 1).aKu()) {
            hL(true);
        }
    }

    public void aLo() {
        if (aKX()) {
            a(this.ewr.aKC().getText().length(), this.ewr.getLength() / 2, 2, 20);
        } else if (aKY()) {
            int length = this.ews.getLength() / 2;
            R(length, 15, 300);
            int i = 300 - length;
            this.ews.aKx().setText(String.valueOf(i));
            if (i <= 50) {
                this.ews.aKx().setVisibility(0);
            } else {
                this.ews.aKx().setVisibility(8);
            }
            if (i == 0) {
                this.ews.aKx().setTextColor(this.evx.getResources().getColor(e.d.common_color_10170));
            } else if (i < 0) {
                this.ews.ow(300);
            } else {
                this.ews.aKy();
            }
        } else if (aLa()) {
            if (this.ewu.aKm() != 3) {
                hL(true);
            } else {
                hL(false);
            }
        }
    }

    private void R(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            hL(true);
        } else {
            hL(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            hL(false);
        } else if (f >= i2 && f <= i3) {
            hL(true);
        } else {
            hL(false);
        }
        if (i < 1) {
            this.ewr.hJ(false);
        } else {
            this.ewr.hJ(true);
        }
    }

    public void setData(int i, int i2) {
        this.ewo = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.evx.getLayoutMode().setNightMode(i == 1);
        this.evx.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aLh();
        al.c(this.ewn, e.d.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.le()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        al.j(viewGroup, e.d.common_color_10041);
    }

    public void c(EditText editText) {
        ((InputMethodManager) this.evx.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
