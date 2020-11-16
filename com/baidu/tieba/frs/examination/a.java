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
    protected View iKB;
    protected final ForumWriteData iUV;
    protected TextView iUW;
    protected SerializableItemInfo iUX;
    protected final c iUY;
    private i iUZ;
    private SaveDraftDialogView iVa;
    protected final BaseFragmentActivity imj;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bzS();

    protected abstract void cBW();

    public abstract void cBY();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.imj = baseFragmentActivity;
        this.iUV = forumWriteData;
        this.iUX = serializableItemInfo;
        this.iUY = new c(this.imj, this.imj.getUniqueId(), this.iUV, this.iUX);
        initUI();
        bCo();
        cBW();
    }

    protected void bCo() {
        if (this.mNavigationBar != null) {
            this.iUW = new TextView(this.imj);
            this.iUW.setAlpha(0.5f);
            this.iUW.setText(this.imj.getString(R.string.send_post));
            this.iUW.setTextSize(0, l.getDimens(this.imj, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.imj, R.dimen.tbds44);
            this.iUW.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iUW, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.imj.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.imj, R.dimen.tbds44));
            this.iKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cBX() {
        if (this.iVa == null) {
            this.iVa = new SaveDraftDialogView(this.imj);
            this.iVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cBZ();
                            a.this.imj.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bzS();
                            a.this.imj.finish();
                        }
                        a.this.iUZ.dismiss();
                    }
                }
            });
        }
        if (this.iUZ == null) {
            this.iUZ = new i(this.imj.getPageContext());
            this.iUZ.setContentView(this.iVa);
        }
        this.iVa.setText(this.imj.getString(R.string.write_save_draft_dialog_normal_title), null, this.imj.getString(R.string.save));
        this.iUZ.PA();
    }

    protected void cBZ() {
        if (this.iUV != null) {
            x.c(String.valueOf(this.iUV.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.iUZ, this.imj);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.CAM_X0105);
        }
        if (this.iUW != null) {
            ap.setViewTextColor(this.iUW, R.color.CAM_X0304);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
