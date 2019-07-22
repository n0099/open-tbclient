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
    private View cCf;
    CreateGroupStepActivity gCp;
    private int gCt;
    CreateGroupStepAdapter gDc;
    private int gDd;
    private TextView gDe;
    private com.baidu.tbadk.core.dialog.i gDf;
    int gDg;
    e gDh;
    h gDi;
    g gDj;
    d gDk;
    i gDl;
    b gDm;
    private NoSwipeableViewPager gDn;
    private com.baidu.tieba.im.util.b gDo;
    private int gDp;
    private int gDq;
    private int gDr;
    private int gDs;
    private int gDt;
    private boolean gDu;
    private String gDv;
    private String gDw;
    private String gDx;
    int mForumId;
    private boolean mIsLoading;
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    String mPortrait;
    ProgressBar progressBar;
    private final WriteImagesInfo writeImagesInfo;

    public void yB(String str) {
        this.gDw = str;
    }

    public void yC(String str) {
        this.gDx = str;
    }

    public String bBz() {
        return this.gDw;
    }

    public String bBA() {
        return this.gDx;
    }

    public View bBB() {
        return this.cCf;
    }

    public int bBC() {
        return this.gDd;
    }

    public View bBD() {
        return this.gDe;
    }

    public View bBE() {
        if (this.gDh != null) {
            return this.gDh.bBo();
        }
        if (this.gDi != null) {
            return this.gDi.bBo();
        }
        return null;
    }

    public View bBF() {
        return this.gDl.bBw();
    }

    public View bBG() {
        return this.gDl.bBv();
    }

    public boolean bBH() {
        return this.mIsLoading;
    }

    public void bBb() {
        this.gDm.bBb();
        bCc();
    }

    public void yD(String str) {
        this.gDv = str;
    }

    public String yL() {
        return this.gDv;
    }

    public void setBusiness(String str) {
        this.business = str;
        this.gDm.setBusiness(str);
        bCc();
    }

    public String getBusiness() {
        return this.business;
    }

    public void yE(String str) {
        this.gDm.setAddress(str);
        bCc();
    }

    public boolean bBI() {
        return this.gDu;
    }

    public void lV(boolean z) {
        this.gDu = z;
    }

    public void bBc() {
        this.gDm.bBc();
        bCc();
    }

    public void bBd() {
        this.gDm.bBd();
        bCc();
    }

    public View bBJ() {
        return this.gDm.bAZ();
    }

    public int bBa() {
        return this.gDm.bBa();
    }

    public View bBK() {
        return this.gDj.bBs();
    }

    public int getForumId() {
        return this.mForumId;
    }

    public String getName() {
        return this.gDj.bBr().getText().toString();
    }

    public String getIntro() {
        return this.gDk.bBk().getText().toString();
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getGroupType() {
        return this.gDg;
    }

    public boolean bBL() {
        return this.gDj != null && this.gDd == this.gDj.bAY();
    }

    public boolean bBM() {
        return this.gDk != null && this.gDd == this.gDk.bAY();
    }

    public boolean bBN() {
        return this.gDl != null && this.gDd == this.gDl.bAY();
    }

    public boolean bBO() {
        return this.gDm != null && this.gDd == this.gDm.bAY();
    }

    public boolean bBP() {
        return this.gDc != null && this.gDd == this.gDc.getCount();
    }

    public String getErrMsg() {
        if (this.gDc.vk(this.gDd - 1) != null) {
            return this.gDc.vk(this.gDd - 1).getErrMsg();
        }
        return null;
    }

    public void bBQ() {
        this.gDl.bBw().setText(R.string.group_create_modify_photo_tip);
    }

    public void bBR() {
        this.gDl.bBu();
    }

    public void clearText() {
        this.gDj.bBt();
    }

    public j(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity.getPageContext());
        this.aqi = true;
        this.mIsLoading = false;
        this.gCp = null;
        this.gDc = null;
        this.progressBar = null;
        this.gDd = 1;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cCf = null;
        this.gDe = null;
        this.gDf = null;
        this.gDg = 4;
        this.mForumId = 0;
        this.mPortrait = null;
        this.gDh = null;
        this.gDi = null;
        this.gDj = null;
        this.gDk = null;
        this.gDl = null;
        this.gDm = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.gDn = null;
        this.gDo = null;
        this.gDu = false;
        this.gDv = "";
        this.business = "";
        this.gDw = null;
        this.gDx = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        initData();
        initListener();
    }

    private void initData() {
        this.gDo = new com.baidu.tieba.im.util.b(this.gCp);
        this.gDo.setUniqueId(this.gCp.getUniqueId());
        bBS();
    }

    public void bBS() {
        this.gDo.aya();
    }

    public void bBT() {
        if (this.gDo != null) {
            this.gDo.cancelLoad();
        }
    }

    private void initListener() {
        this.cCf.setOnClickListener(this.gCp);
        this.gDe.setOnClickListener(this.gCp);
        this.gDj.bBr().setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.gDj.bBr().addTextChangedListener(this.gCp);
        this.gDk.bBk().addTextChangedListener(this.gCp);
        this.gDl.bBw().setOnClickListener(this.gCp);
        this.gDl.bBv().setOnClickListener(this.gCp);
        this.gDm.bAZ().setOnClickListener(this.gCp);
        if (this.gDi != null) {
            this.gDi.bBo().setOnClickListener(this.gCp);
        }
        if (this.gDh != null) {
            this.gDh.bBo().setOnClickListener(this.gCp);
        }
    }

    public void setIsLoading(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
        this.mIsLoading = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.gCp = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.mParent = createGroupStepActivity.findViewById(R.id.parent);
        this.progressBar = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.gDn = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.gDc = new CreateGroupStepAdapter(this.gCp);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.gDn.setAdapter(this.gDc);
        this.mNavigationBar = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.cCf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        bCa();
        this.gDe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.next_step));
        ((LinearLayout.LayoutParams) this.gDe.getLayoutParams()).rightMargin = com.baidu.adp.lib.util.l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        am.k(this.gDe, R.drawable.s_navbar_button_bg);
        lW(false);
        bCb();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.gDt = 1;
            this.gDs = 2;
            this.gDp = 3;
            this.gDq = 4;
            this.gDr = 5;
            this.gDh = new e(createGroupStepActivity, this.gDt, i2);
            this.gDm = new b(createGroupStepActivity, this.gDs, 1, 5);
            this.gDj = new g(createGroupStepActivity, this.gDp, 2, 5);
            this.gDk = new d(createGroupStepActivity, this.gDq, 3, 5);
            this.gDl = new i(createGroupStepActivity, this.gDr, 4, 5);
            this.gDc.a(this.gDh);
            this.gDc.a(this.gDm);
            this.gDc.a(this.gDj);
            this.gDc.a(this.gDk);
            this.gDc.a(this.gDl);
            this.gCt = 5;
        } else if (i == 2) {
            this.gDt = 1;
            this.gDp = 2;
            this.gDq = 3;
            this.gDr = 4;
            this.gDs = 5;
            this.gDi = new h(createGroupStepActivity, this.gDt, i3);
            this.gDj = new g(createGroupStepActivity, this.gDp, 1, 5);
            this.gDk = new d(createGroupStepActivity, this.gDq, 2, 5);
            this.gDl = new i(createGroupStepActivity, this.gDr, 3, 5);
            this.gDm = new b(createGroupStepActivity, this.gDs, 4, 5);
            this.gDc.a(this.gDi);
            this.gDc.a(this.gDj);
            this.gDc.a(this.gDk);
            this.gDc.a(this.gDl);
            this.gDc.a(this.gDm);
            this.gCt = 5;
        } else {
            this.gDp = 1;
            this.gDq = 2;
            this.gDr = 3;
            this.gDs = 4;
            this.gDj = new g(createGroupStepActivity, this.gDp, 1, 4);
            this.gDk = new d(createGroupStepActivity, this.gDq, 2, 4);
            this.gDl = new i(createGroupStepActivity, this.gDr, 3, 4);
            this.gDm = new b(createGroupStepActivity, this.gDs, 4, 4);
            this.gDc.a(this.gDj);
            this.gDc.a(this.gDk);
            this.gDc.a(this.gDl);
            this.gDc.a(this.gDm);
            this.gCt = 4;
        }
    }

    private void lW(boolean z) {
        this.aqi = z;
        bBV();
    }

    public boolean bBU() {
        return this.aqi;
    }

    private void bBV() {
        this.gDe.setEnabled(this.aqi);
        am.k(this.gDe, R.drawable.s_navbar_button_bg);
    }

    public void bBW() {
        if (this.gDd > 1) {
            this.gDd--;
            bBY();
        }
    }

    public void bBX() {
        if (this.gDd < this.gCt) {
            this.gDd++;
            bBY();
        }
    }

    public void bBY() {
        this.gDn.setCurrentItem(this.gDd - 1);
        bCa();
        bCb();
        bCc();
        this.gDj.bBr().clearFocus();
        this.gDk.bBk().clearFocus();
        g(this.gDj.bBr());
        g(this.gDk.bBk());
        if (bBN() && bBH()) {
            bBD().setEnabled(false);
        } else {
            bBD().setEnabled(true);
        }
    }

    public void bBZ() {
        String[] strArr = {this.gCp.getResources().getString(R.string.take_photo), this.gCp.getResources().getString(R.string.album)};
        if (this.gDf == null) {
            this.gDf = new com.baidu.tbadk.core.dialog.i(this.gCp.getPageContext());
            this.gDf.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.creategroup.j.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    if (j.this.gDf != null && j.this.gDf.isShowing() && j.this.gCp != null) {
                        j.this.gDf.dismiss();
                    }
                    Activity pageActivity = j.this.gCp.getPageContext().getPageActivity();
                    if (j.this.mPermissionJudgement == null) {
                        j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    j.this.mPermissionJudgement.ajQ();
                    j.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!j.this.mPermissionJudgement.ad(pageActivity)) {
                        if (i == 0) {
                            al.c(j.this.gCp.getPageContext());
                        } else if (i == 1) {
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(j.this.gCp.getPageContext().getPageActivity(), j.this.writeImagesInfo.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            albumActivityConfig.setResourceType(2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                }
            });
        }
        this.gDf.showDialog();
    }

    public void al(Intent intent) {
        String stringExtra;
        Activity pageActivity = this.gCp.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.ajQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.gCp.getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void yF(String str) {
        if (!this.gDe.getText().toString().equals(str)) {
            this.gDe.setText(str);
        }
    }

    private void bCa() {
        if (this.gDc.vk(this.gDd - 1) != null) {
            this.mNavigationBar.setTitleText(this.gDc.vk(this.gDd - 1).getTitle());
        }
    }

    public void bCb() {
        for (o oVar : this.gDc.getList()) {
            if (oVar.bAY() == this.gDd) {
                oVar.bBf();
                if (!oVar.bBj()) {
                    this.gDe.setVisibility(8);
                } else {
                    this.gDe.setVisibility(0);
                }
                yF(oVar.bBh());
            } else {
                oVar.bBe();
            }
        }
        if (this.gDc.vk(this.gDd - 1) != null && this.gDc.vk(this.gDd - 1).bBi()) {
            lW(true);
        }
    }

    public void bCc() {
        if (bBL()) {
            a(this.gDj.bBr().getText().length(), this.gDj.bBm() / 2, 2, 20);
        } else if (bBM()) {
            int bBm = this.gDk.bBm() / 2;
            W(bBm, 15, 300);
            int i = 300 - bBm;
            this.gDk.bBl().setText(String.valueOf(i));
            if (i <= 50) {
                this.gDk.bBl().setVisibility(0);
            } else {
                this.gDk.bBl().setVisibility(8);
            }
            if (i == 0) {
                this.gDk.bBl().setTextColor(this.gCp.getResources().getColor(R.color.common_color_10170));
            } else if (i < 0) {
                this.gDk.vj(300);
            } else {
                this.gDk.bBn();
            }
        } else if (bBO()) {
            if (this.gDm.bBa() != 3) {
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
            this.gDj.lU(false);
        } else {
            this.gDj.lU(true);
        }
    }

    public void setData(int i, int i2) {
        this.gDg = i;
        this.mForumId = i2;
    }

    public void onChangeSkinType(int i) {
        this.gCp.getLayoutMode().setNightMode(i == 1);
        this.gCp.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        bBV();
        am.f(this.gDe, R.color.navbar_btn_color, 1);
        ViewGroup viewGroup = (ViewGroup) this.mParent.getParent().getParent();
        if (com.baidu.adp.lib.util.l.kw()) {
            viewGroup = (ViewGroup) this.mParent.getParent();
        }
        am.l(viewGroup, R.color.common_color_10041);
    }

    public void g(EditText editText) {
        ((InputMethodManager) this.gCp.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
