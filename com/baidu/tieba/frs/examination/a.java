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
    protected final BaseFragmentActivity hSW;
    protected final ForumWriteData iBQ;
    protected TextView iBR;
    protected SerializableItemInfo iBS;
    protected final c iBT;
    private i iBU;
    private SaveDraftDialogView iBV;
    protected View irv;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bwk();

    protected abstract void cwK();

    public abstract void cwM();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.hSW = baseFragmentActivity;
        this.iBQ = forumWriteData;
        this.iBS = serializableItemInfo;
        this.iBT = new c(this.hSW, this.hSW.getUniqueId(), this.iBQ, this.iBS);
        initUI();
        byD();
        cwK();
    }

    protected void byD() {
        if (this.mNavigationBar != null) {
            this.iBR = new TextView(this.hSW);
            this.iBR.setAlpha(0.5f);
            this.iBR.setText(this.hSW.getString(R.string.send_post));
            this.iBR.setTextSize(0, l.getDimens(this.hSW, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.hSW, R.dimen.tbds44);
            this.iBR.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iBR, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.hSW.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.hSW, R.dimen.tbds44));
            this.irv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cwL() {
        if (this.iBV == null) {
            this.iBV = new SaveDraftDialogView(this.hSW);
            this.iBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cwN();
                            a.this.hSW.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bwk();
                            a.this.hSW.finish();
                        }
                        a.this.iBU.dismiss();
                    }
                }
            });
        }
        if (this.iBU == null) {
            this.iBU = new i(this.hSW.getPageContext());
            this.iBU.setContentView(this.iBV);
        }
        this.iBV.setText(this.hSW.getString(R.string.write_save_draft_dialog_normal_title), null, this.hSW.getString(R.string.save));
        this.iBU.Pd();
    }

    protected void cwN() {
        if (this.iBQ != null) {
            x.c(String.valueOf(this.iBQ.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.iBU, this.hSW);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.iBR != null) {
            ap.setViewTextColor(this.iBR, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
