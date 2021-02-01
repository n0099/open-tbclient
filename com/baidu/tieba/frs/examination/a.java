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
    protected final BaseFragmentActivity iKt;
    protected View jiI;
    protected final ForumWriteData jtt;
    protected TextView jtu;
    protected SerializableItemInfo jtv;
    protected final c jtw;
    private i jtx;
    private SaveDraftDialogView jty;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bCn();

    protected abstract void cGL();

    public abstract void cGN();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.iKt = baseFragmentActivity;
        this.jtt = forumWriteData;
        this.jtv = serializableItemInfo;
        this.jtw = new c(this.iKt, this.iKt.getUniqueId(), this.jtt, this.jtv);
        initUI();
        bEL();
        cGL();
    }

    protected void bEL() {
        if (this.mNavigationBar != null) {
            this.jtu = new TextView(this.iKt);
            this.jtu.setAlpha(0.5f);
            this.jtu.setText(this.iKt.getString(R.string.send_post));
            this.jtu.setTextSize(0, l.getDimens(this.iKt, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.iKt, R.dimen.tbds44);
            this.jtu.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jtu, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.iKt.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.iKt, R.dimen.tbds44));
            this.jiI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cGM() {
        if (this.jty == null) {
            this.jty = new SaveDraftDialogView(this.iKt);
            this.jty.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cGO();
                            a.this.iKt.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bCn();
                            a.this.iKt.finish();
                        }
                        a.this.jtx.dismiss();
                    }
                }
            });
        }
        if (this.jtx == null) {
            this.jtx = new i(this.iKt.getPageContext());
            this.jtx.setContentView(this.jty);
        }
        this.jty.setText(this.iKt.getString(R.string.write_save_draft_dialog_normal_title), null, this.iKt.getString(R.string.save));
        this.jtx.QE();
    }

    protected void cGO() {
        if (this.jtt != null) {
            y.g(String.valueOf(this.jtt.forumId), null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.jtx, this.iKt);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.jtu != null) {
            ap.setViewTextColor(this.jtu, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
