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
    protected View iJO;
    protected final ForumWriteData iUj;
    protected TextView iUk;
    protected SerializableItemInfo iUl;
    protected final c iUm;
    private i iUn;
    private SaveDraftDialogView iUo;
    protected final BaseFragmentActivity ilu;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bAC();

    protected abstract void cCs();

    public abstract void cCu();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.ilu = baseFragmentActivity;
        this.iUj = forumWriteData;
        this.iUl = serializableItemInfo;
        this.iUm = new c(this.ilu, this.ilu.getUniqueId(), this.iUj, this.iUl);
        initUI();
        bCV();
        cCs();
    }

    protected void bCV() {
        if (this.mNavigationBar != null) {
            this.iUk = new TextView(this.ilu);
            this.iUk.setAlpha(0.5f);
            this.iUk.setText(this.ilu.getString(R.string.send_post));
            this.iUk.setTextSize(0, l.getDimens(this.ilu, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.ilu, R.dimen.tbds44);
            this.iUk.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iUk, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.ilu.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.ilu, R.dimen.tbds44));
            this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cCt() {
        if (this.iUo == null) {
            this.iUo = new SaveDraftDialogView(this.ilu);
            this.iUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cCv();
                            a.this.ilu.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bAC();
                            a.this.ilu.finish();
                        }
                        a.this.iUn.dismiss();
                    }
                }
            });
        }
        if (this.iUn == null) {
            this.iUn = new i(this.ilu.getPageContext());
            this.iUn.setContentView(this.iUo);
        }
        this.iUo.setText(this.ilu.getString(R.string.write_save_draft_dialog_normal_title), null, this.ilu.getString(R.string.save));
        this.iUn.Qj();
    }

    protected void cCv() {
        if (this.iUj != null) {
            x.c(String.valueOf(this.iUj.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.iUn, this.ilu);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.iUk != null) {
            ap.setViewTextColor(this.iUk, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
