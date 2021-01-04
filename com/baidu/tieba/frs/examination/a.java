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
    protected final BaseFragmentActivity iJr;
    protected View jhI;
    protected final ForumWriteData jst;
    protected TextView jsu;
    protected SerializableItemInfo jsv;
    protected final c jsw;
    private i jsx;
    private SaveDraftDialogView jsy;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bFN();

    protected abstract void cJp();

    public abstract void cJr();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.iJr = baseFragmentActivity;
        this.jst = forumWriteData;
        this.jsv = serializableItemInfo;
        this.jsw = new c(this.iJr, this.iJr.getUniqueId(), this.jst, this.jsv);
        initUI();
        bIk();
        cJp();
    }

    protected void bIk() {
        if (this.mNavigationBar != null) {
            this.jsu = new TextView(this.iJr);
            this.jsu.setAlpha(0.5f);
            this.jsu.setText(this.iJr.getString(R.string.send_post));
            this.jsu.setTextSize(0, l.getDimens(this.iJr, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.iJr, R.dimen.tbds44);
            this.jsu.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jsu, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.iJr.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.iJr, R.dimen.tbds44));
            this.jhI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJq() {
        if (this.jsy == null) {
            this.jsy = new SaveDraftDialogView(this.iJr);
            this.jsy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cJs();
                            a.this.iJr.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bFN();
                            a.this.iJr.finish();
                        }
                        a.this.jsx.dismiss();
                    }
                }
            });
        }
        if (this.jsx == null) {
            this.jsx = new i(this.iJr.getPageContext());
            this.jsx.setContentView(this.jsy);
        }
        this.jsy.setText(this.iJr.getString(R.string.write_save_draft_dialog_normal_title), null, this.iJr.getString(R.string.save));
        this.jsx.SY();
    }

    protected void cJs() {
        if (this.jst != null) {
            y.g(String.valueOf(this.jst.forumId), null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jsx, this.iJr);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ao.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jsu != null) {
            ao.setViewTextColor(this.jsu, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
