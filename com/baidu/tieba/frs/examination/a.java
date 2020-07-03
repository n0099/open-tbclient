package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.w;
import com.google.gson.Gson;
/* loaded from: classes9.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected View hCa;
    protected final ForumWriteData hLG;
    protected TextView hLH;
    protected SerializableItemInfo hLI;
    protected final c hLJ;
    private i hLK;
    private SaveDraftDialogView hLL;
    protected final BaseFragmentActivity hep;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bfY();

    protected abstract void cbV();

    public abstract void cbX();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.hep = baseFragmentActivity;
        this.hLG = forumWriteData;
        this.hLI = serializableItemInfo;
        this.hLJ = new c(this.hep, this.hep.getUniqueId(), this.hLG, this.hLI);
        initUI();
        biq();
        cbV();
    }

    protected void biq() {
        if (this.mNavigationBar != null) {
            this.hLH = new TextView(this.hep);
            this.hLH.setAlpha(0.5f);
            this.hLH.setText(this.hep.getString(R.string.send_post));
            this.hLH.setTextSize(0, l.getDimens(this.hep, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.hep, R.dimen.tbds44);
            this.hLH.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hLH, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.hep.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.hep, R.dimen.tbds44));
            this.hCa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbW() {
        if (this.hLL == null) {
            this.hLL = new SaveDraftDialogView(this.hep);
            this.hLL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cbY();
                            a.this.hep.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bfY();
                            a.this.hep.finish();
                        }
                        a.this.hLK.dismiss();
                    }
                }
            });
        }
        if (this.hLK == null) {
            this.hLK = new i(this.hep.getPageContext());
            this.hLK.setContentView(this.hLL);
        }
        this.hLL.setText(this.hep.getString(R.string.write_save_draft_dialog_normal_title), null, this.hep.getString(R.string.save));
        this.hLK.showDialog();
    }

    protected void cbY() {
        if (this.hLG != null) {
            w.c(String.valueOf(this.hLG.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.hLK, this.hep);
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            an.setViewTextColor(this.mCenterText, (int) R.color.cp_cont_b);
        }
        if (this.hLH != null) {
            an.setViewTextColor(this.hLH, (int) R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
