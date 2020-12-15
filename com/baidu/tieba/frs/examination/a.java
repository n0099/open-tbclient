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
import com.baidu.tieba.tbadkCore.y;
import com.google.gson.Gson;
/* loaded from: classes22.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected View iVw;
    protected final BaseFragmentActivity ixe;
    protected final ForumWriteData jfT;
    protected TextView jfU;
    protected SerializableItemInfo jfV;
    protected final c jfW;
    private i jfX;
    private SaveDraftDialogView jfY;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bDs();

    protected abstract void cGq();

    public abstract void cGs();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.ixe = baseFragmentActivity;
        this.jfT = forumWriteData;
        this.jfV = serializableItemInfo;
        this.jfW = new c(this.ixe, this.ixe.getUniqueId(), this.jfT, this.jfV);
        initUI();
        bFP();
        cGq();
    }

    protected void bFP() {
        if (this.mNavigationBar != null) {
            this.jfU = new TextView(this.ixe);
            this.jfU.setAlpha(0.5f);
            this.jfU.setText(this.ixe.getString(R.string.send_post));
            this.jfU.setTextSize(0, l.getDimens(this.ixe, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.ixe, R.dimen.tbds44);
            this.jfU.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jfU, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.ixe.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.ixe, R.dimen.tbds44));
            this.iVw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cGr() {
        if (this.jfY == null) {
            this.jfY = new SaveDraftDialogView(this.ixe);
            this.jfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cGt();
                            a.this.ixe.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bDs();
                            a.this.ixe.finish();
                        }
                        a.this.jfX.dismiss();
                    }
                }
            });
        }
        if (this.jfX == null) {
            this.jfX = new i(this.ixe.getPageContext());
            this.jfX.setContentView(this.jfY);
        }
        this.jfY.setText(this.ixe.getString(R.string.write_save_draft_dialog_normal_title), null, this.ixe.getString(R.string.save));
        this.jfX.RU();
    }

    protected void cGt() {
        if (this.jfT != null) {
            y.c(String.valueOf(this.jfT.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jfX, this.ixe);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jfU != null) {
            ap.setViewTextColor(this.jfU, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
