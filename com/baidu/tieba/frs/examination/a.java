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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.x;
import com.google.gson.Gson;
/* loaded from: classes22.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected View iDR;
    protected final ForumWriteData iOm;
    protected TextView iOn;
    protected SerializableItemInfo iOo;
    protected final c iOp;
    private i iOq;
    private SaveDraftDialogView iOr;
    protected final BaseFragmentActivity ifx;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void byd();

    protected abstract void czR();

    public abstract void czT();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.ifx = baseFragmentActivity;
        this.iOm = forumWriteData;
        this.iOo = serializableItemInfo;
        this.iOp = new c(this.ifx, this.ifx.getUniqueId(), this.iOm, this.iOo);
        initUI();
        bAw();
        czR();
    }

    protected void bAw() {
        if (this.mNavigationBar != null) {
            this.iOn = new TextView(this.ifx);
            this.iOn.setAlpha(0.5f);
            this.iOn.setText(this.ifx.getString(R.string.send_post));
            this.iOn.setTextSize(0, l.getDimens(this.ifx, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.ifx, R.dimen.tbds44);
            this.iOn.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iOn, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.ifx.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.ifx, R.dimen.tbds44));
            this.iDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czS() {
        if (this.iOr == null) {
            this.iOr = new SaveDraftDialogView(this.ifx);
            this.iOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.czU();
                            a.this.ifx.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.byd();
                            a.this.ifx.finish();
                        }
                        a.this.iOq.dismiss();
                    }
                }
            });
        }
        if (this.iOq == null) {
            this.iOq = new i(this.ifx.getPageContext());
            this.iOq.setContentView(this.iOr);
        }
        this.iOr.setText(this.ifx.getString(R.string.write_save_draft_dialog_normal_title), null, this.ifx.getString(R.string.save));
        this.iOq.PJ();
    }

    protected void czU() {
        if (this.iOm != null) {
            x.c(String.valueOf(this.iOm.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.iOq, this.ifx);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.iOn != null) {
            ap.setViewTextColor(this.iOn, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
