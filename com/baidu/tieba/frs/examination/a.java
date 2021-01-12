package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.ao;
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
    protected final BaseFragmentActivity iEK;
    protected View jdb;
    protected final ForumWriteData jnN;
    protected TextView jnO;
    protected SerializableItemInfo jnP;
    protected final c jnQ;
    private i jnR;
    private SaveDraftDialogView jnS;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bBV();

    public abstract void cFA();

    protected abstract void cFy();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.iEK = baseFragmentActivity;
        this.jnN = forumWriteData;
        this.jnP = serializableItemInfo;
        this.jnQ = new c(this.iEK, this.iEK.getUniqueId(), this.jnN, this.jnP);
        initUI();
        bEt();
        cFy();
    }

    protected void bEt() {
        if (this.mNavigationBar != null) {
            this.jnO = new TextView(this.iEK);
            this.jnO.setAlpha(0.5f);
            this.jnO.setText(this.iEK.getString(R.string.send_post));
            this.jnO.setTextSize(0, l.getDimens(this.iEK, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.iEK, R.dimen.tbds44);
            this.jnO.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jnO, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.iEK.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.iEK, R.dimen.tbds44));
            this.jdb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cFz() {
        if (this.jnS == null) {
            this.jnS = new SaveDraftDialogView(this.iEK);
            this.jnS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cFB();
                            a.this.iEK.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bBV();
                            a.this.iEK.finish();
                        }
                        a.this.jnR.dismiss();
                    }
                }
            });
        }
        if (this.jnR == null) {
            this.jnR = new i(this.iEK.getPageContext());
            this.jnR.setContentView(this.jnS);
        }
        this.jnS.setText(this.iEK.getString(R.string.write_save_draft_dialog_normal_title), null, this.iEK.getString(R.string.save));
        this.jnR.Pd();
    }

    protected void cFB() {
        if (this.jnN != null) {
            y.g(String.valueOf(this.jnN.forumId), null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jnR, this.iEK);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ao.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jnO != null) {
            ao.setViewTextColor(this.jnO, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
