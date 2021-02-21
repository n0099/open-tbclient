package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.y;
import com.google.gson.Gson;
/* loaded from: classes2.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected final BaseFragmentActivity iKH;
    protected View jiW;
    protected final ForumWriteData jtH;
    protected TextView jtI;
    protected SerializableItemInfo jtJ;
    protected final c jtK;
    private i jtL;
    private SaveDraftDialogView jtM;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bCn();

    protected abstract void cGS();

    public abstract void cGU();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.iKH = baseFragmentActivity;
        this.jtH = forumWriteData;
        this.jtJ = serializableItemInfo;
        this.jtK = new c(this.iKH, this.iKH.getUniqueId(), this.jtH, this.jtJ);
        initUI();
        bEL();
        cGS();
    }

    protected void bEL() {
        if (this.mNavigationBar != null) {
            this.jtI = new TextView(this.iKH);
            this.jtI.setAlpha(0.5f);
            this.jtI.setText(this.iKH.getString(R.string.send_post));
            this.jtI.setTextSize(0, l.getDimens(this.iKH, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.iKH, R.dimen.tbds44);
            this.jtI.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jtI, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.iKH.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.iKH, R.dimen.tbds44));
            this.jiW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cGT() {
        if (this.jtM == null) {
            this.jtM = new SaveDraftDialogView(this.iKH);
            this.jtM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cGV();
                            a.this.iKH.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bCn();
                            a.this.iKH.finish();
                        }
                        a.this.jtL.dismiss();
                    }
                }
            });
        }
        if (this.jtL == null) {
            this.jtL = new i(this.iKH.getPageContext());
            this.jtL.setContentView(this.jtM);
        }
        this.jtM.setText(this.iKH.getString(R.string.write_save_draft_dialog_normal_title), null, this.iKH.getString(R.string.save));
        this.jtL.QE();
    }

    protected void cGV() {
        if (this.jtH != null) {
            y.g(String.valueOf(this.jtH.forumId), null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jtL, this.iKH);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jtI != null) {
            ap.setViewTextColor(this.jtI, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
