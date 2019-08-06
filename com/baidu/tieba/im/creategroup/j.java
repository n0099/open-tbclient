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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes5.dex */
public class j extends com.baidu.adp.base.c {
    private boolean aqi;
    private String business;
    private View cCm;
    CreateGroupStepAdapter gDU;
    private int gDV;
    private TextView gDW;
    private com.baidu.tbadk.core.dialog.i gDX;
    int gDY;
    e gDZ;
    CreateGroupStepActivity gDh;
    private int gDl;
    h gEa;
    g gEb;
    d gEc;
    i gEd;
    b gEe;
    private NoSwipeableViewPager gEf;
    private com.baidu.tieba.im.util.b gEg;
    private int gEh;
    private int gEi;
    private int gEj;
    private int gEk;
    private int gEl;
    private boolean gEm;
    private String gEn;
    private String gEo;
    private String gEp;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void yC(String str) {
        this.gEo = str;
    }

    public void yD(String str) {
        this.gEp = str;
    }

    public String bBN() {
        return this.gEo;
    }

    public String bBO() {
        return this.gEp;
    }

    public View bBP() {
        return this.cCm;
    }

    public int bBQ() {
        return this.gDV;
    }

    public View bBR() {
        return this.gDW;
    }

    public View bBS() {
        if (this.gDZ != null) {
            return this.gDZ.bBC();
        }
        if (this.gEa != null) {
            return this.gEa.bBC();
        }
        return null;
    }

    public View bBT() {
        return this.gEd.bBK();
    }

    public View bBU() {
        return this.gEd.bBJ();
    }

    public boolean bBV() {
        return this.mIsLoading;
    }

    public void bBp() {
        this.gEe.bBp();
        bCq();
    }

    public void yE(String str) {
        this.gEn = str;
    }

    public String yL() {
        return this.gEn;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gEe.setBusiness(str);
        bCq();
    }

    public String getBusiness() {
        return this.business;
    }

    public void yF(String str) {
        this.gEe.setAddress(str);
        bCq();
    }

    public boolean bBW() {
        return this.gEm;
    }

    public void lV(boolean z) {
        this.gEm = z;
    }

    public void bBq() {
        this.gEe.bBq();
        bCq();
    }

    public void bBr() {
        this.gEe.bBr();
        bCq();
    }

    public View bBX() {
        return this.gEe.bBn();
    }

    public int bBo() {
        return this.gEe.bBo();
    }

    public View bBY() {
        return this.gEb.bBG();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gEb.bBF().getText().toString();
    }

    public String getIntro() {
        return this.gEc.bBy().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gDY;
    }

    public boolean bBZ() {
        return this.gEb != null && this.gDV == this.gEb.bBm();
    }

    public boolean bCa() {
        return this.gEc != null && this.gDV == this.gEc.bBm();
    }

    public boolean bCb() {
        return this.gEd != null && this.gDV == this.gEd.bBm();
    }

    public boolean bCc() {
        return this.gEe != null && this.gDV == this.gEe.bBm();
    }

    public boolean bCd() {
        return this.gDU != null && this.gDV == this.gDU.getCount();
    }

    public String getErrMsg() {
        if (this.gDU.vm(this.gDV - 1) != null) {
            return this.gDU.vm(this.gDV - 1).getErrMsg();
        }
        return null;
    }

    public void bCe() {
        this.gEd.bBK().setText(R.string.group_create_modify_photo_tip);
    }

    public void bCf() {
        this.gEd.bBI();
    }

    public void clearText() {
        this.gEb.bBH();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.aqi = true;
        this.mIsLoading = false;
        this.gDh = null;
        this.gDU = null;
        this.progressBar = null;
        this.gDV = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cCm = null;
        this.gDW = null;
        this.gDX = null;
        this.gDY = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gDZ = null;
        this.gEa = null;
        this.gEb = null;
        this.gEc = null;
        this.gEd = null;
        this.gEe = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gEf = null;
        this.gEg = null;
        this.gEm = false;
        this.gEn = "";
        this.business = "";
        this.gEo = null;
        this.gEp = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gEg = new com.baidu.tieba.im.util.b(this.gDh);
        this.gEg.setUniqueId(this.gDh.getUniqueId());
        bCg();
    }

    public void bCg() {
        this.gEg.ayc();
    }

    public void bCh() {
        if (this.gEg != null) {
            this.gEg.cancelLoad();
        }
    }

    private void initListener() {
        this.cCm.setOnClickListener(this.gDh);
        this.gDW.setOnClickListener(this.gDh);
        this.gEb.bBF().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gEb.bBF().addTextChangedListener(this.gDh);
        this.gEc.bBy().addTextChangedListener(this.gDh);
        this.gEd.bBK().setOnClickListener(this.gDh);
        this.gEd.bBJ().setOnClickListener(this.gDh);
        this.gEe.bBn().setOnClickListener(this.gDh);
        if (this.gEa != null) {
            this.gEa.bBC().setOnClickListener(this.gDh);
        }
        if (this.gDZ != null) {
            this.gDZ.bBC().setOnClickListener(this.gDh);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gDh = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gEf = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gDU = new CreateGroupStepAdapter(this.gDh);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gEf.setAdapter(this.gDU);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cCm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bCo();
        this.gDW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gDW.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        am.k(this.gDW, R.drawable.s_navbar_button_bg);
        lW(false);
        bCp();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gEl = 1;
            this.gEk = 2;
            this.gEh = 3;
            this.gEi = 4;
            this.gEj = 5;
            this.gDZ = new e(createGroupStepActivity, this.gEl, i2);
            this.gEe = new b(createGroupStepActivity, this.gEk, 1, 5);
            this.gEb = new g(createGroupStepActivity, this.gEh, 2, 5);
            this.gEc = new d(createGroupStepActivity, this.gEi, 3, 5);
            this.gEd = new i(createGroupStepActivity, this.gEj, 4, 5);
            this.gDU.a(this.gDZ);
            this.gDU.a(this.gEe);
            this.gDU.a(this.gEb);
            this.gDU.a(this.gEc);
            this.gDU.a(this.gEd);
            this.gDl = 5;
        } else if (i == 2) {
            this.gEl = 1;
            this.gEh = 2;
            this.gEi = 3;
            this.gEj = 4;
            this.gEk = 5;
            this.gEa = new h(createGroupStepActivity, this.gEl, i3);
            this.gEb = new g(createGroupStepActivity, this.gEh, 1, 5);
            this.gEc = new d(createGroupStepActivity, this.gEi, 2, 5);
            this.gEd = new i(createGroupStepActivity, this.gEj, 3, 5);
            this.gEe = new b(createGroupStepActivity, this.gEk, 4, 5);
            this.gDU.a(this.gEa);
            this.gDU.a(this.gEb);
            this.gDU.a(this.gEc);
            this.gDU.a(this.gEd);
            this.gDU.a(this.gEe);
            this.gDl = 5;
        } else {
            this.gEh = 1;
            this.gEi = 2;
            this.gEj = 3;
            this.gEk = 4;
            this.gEb = new g(createGroupStepActivity, this.gEh, 1, 4);
            this.gEc = new d(createGroupStepActivity, this.gEi, 2, 4);
            this.gEd = new i(createGroupStepActivity, this.gEj, 3, 4);
            this.gEe = new b(createGroupStepActivity, this.gEk, 4, 4);
            this.gDU.a(this.gEb);
            this.gDU.a(this.gEc);
            this.gDU.a(this.gEd);
            this.gDU.a(this.gEe);
            this.gDl = 4;
        }
    }

    private void lW(boolean z) {
        this.aqi = z;
        bCj();
    }

    public boolean bCi() {
        return this.aqi;
    }

    private void bCj() {
        this.gDW.setEnabled(this.aqi);
        am.k(this.gDW, R.drawable.s_navbar_button_bg);
    }

    public void bCk() {
        if (this.gDV > 1) {
            this.gDV--;
            bCm();
        }
    }

    public void bCl() {
        if (this.gDV < this.gDl) {
            this.gDV++;
            bCm();
        }
    }

    public void bCm() {
        this.gEf.setCurrentItem(this.gDV - 1);
        bCo();
        bCp();
        bCq();
        this.gEb.bBF().clearFocus();
        this.gEc.bBy().clearFocus();
        g(this.gEb.bBF());
        g(this.gEc.bBy());
        if (bCb() && bBV()) {
            bBR().setEnabled(false);
        } else {
            bBR().setEnabled(true);
        }
    }

    public void bCn() {
        String[] strArr = {this.gDh.getResources().getString(R.string.take_photo), this.gDh.getResources().getString(R.string.album)};
        if (this.gDX == null) {
            this.gDX = new com.baidu.tbadk.core.dialog.i(this.gDh.getPageContext());
            this.gDX.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gDX != null && j.this.gDX.isShowing() && j.this.gDh != null) {
                        j.this.gDX.dismiss();
                    }
                    Activity pageActivity = j.this.gDh.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.ajS();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.ad(pageActivity)) {
                        if (i == 0) {
                            al.c(j.this.gDh.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gDh.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gDX.showDialog();
    }

    public void an(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gDh.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.ajS();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gDh.getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void yG(String str) {
        if (!this.gDW.getText().toString().equals(str)) {
            this.gDW.setText(str);
        }
    }

    private void bCo() {
        if (this.gDU.vm(this.gDV - 1) != null) {
            this.mNavigationBar.setTitleText(this.gDU.vm(this.gDV - 1).getTitle());
        }
    }

    public void bCp() {
        for (o oVar : this.gDU.getList()) {
            if (oVar.bBm() == this.gDV) {
                oVar.bBt();
                if (!oVar.bBx()) {
                    this.gDW.setVisibility(8);
                } else {
                    this.gDW.setVisibility(0);
                }
                yG(oVar.bBv());
            } else {
                oVar.bBs();
            }
        }
        if (this.gDU.vm(this.gDV - 1) != null && this.gDU.vm(this.gDV - 1).bBw()) {
            lW(true);
        }
    }

    public void bCq() {
        if (bBZ()) {
            a(this.gEb.bBF().getText().length(), this.gEb.bBA() / 2, 2, 20);
        } else if (bCa()) {
            int bBA = this.gEc.bBA() / 2;
            W(bBA, 15, 300);
            int i = 300 - bBA;
            this.gEc.bBz().setText(String.valueOf(i));
            if (i <= 50) {
                this.gEc.bBz().setVisibility(0);
            } else {
                this.gEc.bBz().setVisibility(8);
            }
            if (i == 0) {
                this.gEc.bBz().setTextColor(this.gDh.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gEc.vl(300);
            } else {
                this.gEc.bBB();
            }
        } else if (bCc()) {
            if (this.gEe.bBo() != 3) {
                lW(true);
            } else {
                lW(false);
            }
        }
    }

    private void W(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            lW(true);
        } else {
            lW(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            lW(false);
        } else if (f >= i2 && f <= i3) {
            lW(true);
        } else {
            lW(false);
        }
        if (i < 1) {
            this.gEb.lU(false);
        } else {
            this.gEb.lU(true);
        }
    }

    public void setData(int i, int i2) {
        this.gDY = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gDh.getLayoutMode().setNightMode(i == 1);
        this.gDh.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bCj();
        am.f(this.gDW, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.kw()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.l(viewGroup, R.color.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gDh.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
