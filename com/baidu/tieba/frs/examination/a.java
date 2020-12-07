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
    protected View iVu;
    protected final BaseFragmentActivity ixc;
    protected final ForumWriteData jfR;
    protected TextView jfS;
    protected SerializableItemInfo jfT;
    protected final c jfU;
    private i jfV;
    private SaveDraftDialogView jfW;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bDs();

    protected abstract void cGp();

    public abstract void cGr();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.ixc = baseFragmentActivity;
        this.jfR = forumWriteData;
        this.jfT = serializableItemInfo;
        this.jfU = new c(this.ixc, this.ixc.getUniqueId(), this.jfR, this.jfT);
        initUI();
        bFP();
        cGp();
    }

    protected void bFP() {
        if (this.mNavigationBar != null) {
            this.jfS = new TextView(this.ixc);
            this.jfS.setAlpha(0.5f);
            this.jfS.setText(this.ixc.getString(R.string.send_post));
            this.jfS.setTextSize(0, l.getDimens(this.ixc, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.ixc, R.dimen.tbds44);
            this.jfS.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jfS, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.ixc.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.ixc, R.dimen.tbds44));
            this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cGq() {
        if (this.jfW == null) {
            this.jfW = new SaveDraftDialogView(this.ixc);
            this.jfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cGs();
                            a.this.ixc.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bDs();
                            a.this.ixc.finish();
                        }
                        a.this.jfV.dismiss();
                    }
                }
            });
        }
        if (this.jfV == null) {
            this.jfV = new i(this.ixc.getPageContext());
            this.jfV.setContentView(this.jfW);
        }
        this.jfW.setText(this.ixc.getString(R.string.write_save_draft_dialog_normal_title), null, this.ixc.getString(R.string.save));
        this.jfV.RU();
    }

    protected void cGs() {
        if (this.jfR != null) {
            y.c(String.valueOf(this.jfR.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jfV, this.ixc);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jfS != null) {
            ap.setViewTextColor(this.jfS, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
