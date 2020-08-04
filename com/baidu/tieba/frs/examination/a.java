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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.w;
import com.google.gson.Gson;
/* loaded from: classes16.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected View hHY;
    protected final ForumWriteData hRH;
    protected TextView hRI;
    protected SerializableItemInfo hRJ;
    protected final c hRK;
    private i hRL;
    private SaveDraftDialogView hRM;
    protected final BaseFragmentActivity hjZ;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bjJ();

    protected abstract void cfu();

    public abstract void cfw();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.hjZ = baseFragmentActivity;
        this.hRH = forumWriteData;
        this.hRJ = serializableItemInfo;
        this.hRK = new c(this.hjZ, this.hjZ.getUniqueId(), this.hRH, this.hRJ);
        initUI();
        bmb();
        cfu();
    }

    protected void bmb() {
        if (this.mNavigationBar != null) {
            this.hRI = new TextView(this.hjZ);
            this.hRI.setAlpha(0.5f);
            this.hRI.setText(this.hjZ.getString(R.string.send_post));
            this.hRI.setTextSize(0, l.getDimens(this.hjZ, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.hjZ, R.dimen.tbds44);
            this.hRI.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hRI, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.hjZ.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.hjZ, R.dimen.tbds44));
            this.hHY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cfv() {
        if (this.hRM == null) {
            this.hRM = new SaveDraftDialogView(this.hjZ);
            this.hRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cfx();
                            a.this.hjZ.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bjJ();
                            a.this.hjZ.finish();
                        }
                        a.this.hRL.dismiss();
                    }
                }
            });
        }
        if (this.hRL == null) {
            this.hRL = new i(this.hjZ.getPageContext());
            this.hRL.setContentView(this.hRM);
        }
        this.hRM.setText(this.hjZ.getString(R.string.write_save_draft_dialog_normal_title), null, this.hjZ.getString(R.string.save));
        this.hRL.showDialog();
    }

    protected void cfx() {
        if (this.hRH != null) {
            w.c(String.valueOf(this.hRH.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.hRL, this.hjZ);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ao.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.hRI != null) {
            ao.setViewTextColor(this.hRI, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
