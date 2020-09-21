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
/* loaded from: classes21.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected final BaseFragmentActivity hEa;
    protected View icu;
    protected final ForumWriteData imW;
    protected TextView imX;
    protected SerializableItemInfo imY;
    protected final c imZ;
    private i ina;
    private SaveDraftDialogView inb;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void btA();

    protected abstract void ctn();

    public abstract void ctp();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.hEa = baseFragmentActivity;
        this.imW = forumWriteData;
        this.imY = serializableItemInfo;
        this.imZ = new c(this.hEa, this.hEa.getUniqueId(), this.imW, this.imY);
        initUI();
        bvT();
        ctn();
    }

    protected void bvT() {
        if (this.mNavigationBar != null) {
            this.imX = new TextView(this.hEa);
            this.imX.setAlpha(0.5f);
            this.imX.setText(this.hEa.getString(R.string.send_post));
            this.imX.setTextSize(0, l.getDimens(this.hEa, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.hEa, R.dimen.tbds44);
            this.imX.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.imX, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.hEa.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.hEa, R.dimen.tbds44));
            this.icu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cto() {
        if (this.inb == null) {
            this.inb = new SaveDraftDialogView(this.hEa);
            this.inb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.ctq();
                            a.this.hEa.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.btA();
                            a.this.hEa.finish();
                        }
                        a.this.ina.dismiss();
                    }
                }
            });
        }
        if (this.ina == null) {
            this.ina = new i(this.hEa.getPageContext());
            this.ina.setContentView(this.inb);
        }
        this.inb.setText(this.hEa.getString(R.string.write_save_draft_dialog_normal_title), null, this.hEa.getString(R.string.save));
        this.ina.NY();
    }

    protected void ctq() {
        if (this.imW != null) {
            x.c(String.valueOf(this.imW.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.ina, this.hEa);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.imX != null) {
            ap.setViewTextColor(this.imX, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
