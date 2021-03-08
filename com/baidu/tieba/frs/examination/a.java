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
    protected final BaseFragmentActivity iMq;
    protected View jkF;
    protected final ForumWriteData jvq;
    protected TextView jvr;
    protected SerializableItemInfo jvs;
    protected final c jvt;
    private i jvu;
    private SaveDraftDialogView jvv;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bCq();

    protected abstract void cGY();

    public abstract void cHa();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.iMq = baseFragmentActivity;
        this.jvq = forumWriteData;
        this.jvs = serializableItemInfo;
        this.jvt = new c(this.iMq, this.iMq.getUniqueId(), this.jvq, this.jvs);
        initUI();
        bEP();
        cGY();
    }

    protected void bEP() {
        if (this.mNavigationBar != null) {
            this.jvr = new TextView(this.iMq);
            this.jvr.setAlpha(0.5f);
            this.jvr.setText(this.iMq.getString(R.string.send_post));
            this.jvr.setTextSize(0, l.getDimens(this.iMq, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.iMq, R.dimen.tbds44);
            this.jvr.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jvr, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.iMq.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.iMq, R.dimen.tbds44));
            this.jkF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cGZ() {
        if (this.jvv == null) {
            this.jvv = new SaveDraftDialogView(this.iMq);
            this.jvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cHb();
                            a.this.iMq.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bCq();
                            a.this.iMq.finish();
                        }
                        a.this.jvu.dismiss();
                    }
                }
            });
        }
        if (this.jvu == null) {
            this.jvu = new i(this.iMq.getPageContext());
            this.jvu.setContentView(this.jvv);
        }
        this.jvv.setText(this.iMq.getString(R.string.write_save_draft_dialog_normal_title), null, this.iMq.getString(R.string.save));
        this.jvu.QH();
    }

    protected void cHb() {
        if (this.jvq != null) {
            y.g(String.valueOf(this.jvq.forumId), null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jvu, this.iMq);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jvr != null) {
            ap.setViewTextColor(this.jvr, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
