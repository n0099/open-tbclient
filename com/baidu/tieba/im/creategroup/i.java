package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class i implements y {
    CreateGroupStepActivity aSP;
    private int aSU;
    HeadImageView aTq;
    ImageView aTr;
    TextView aTs;
    private com.baidu.adp.widget.a.a aTt = null;
    private j aTu = null;
    private int mIndex;
    View mView;
    private int vp;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aSP = null;
        this.mView = null;
        this.aTq = null;
        this.aTr = null;
        this.aTs = null;
        this.aSP = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step3_view, null);
        this.aTr = (ImageView) this.mView.findViewById(com.baidu.tieba.v.step3_img_bg);
        this.aTq = (HeadImageView) this.mView.findViewById(com.baidu.tieba.v.step3_img_scr);
        this.aTs = (TextView) this.mView.findViewById(com.baidu.tieba.v.create_group3);
        this.mIndex = i;
        this.vp = i2;
        this.aSU = i3;
    }

    public void Lk() {
        if (this.aTu != null) {
            this.aTu.cancel();
        }
        this.aTt = null;
        this.aTu = new j(this, null);
        this.aTu.execute(new Object[0]);
    }

    public ImageView Ll() {
        return this.aTr;
    }

    public TextView Lm() {
        return this.aTs;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KV() {
        this.aTr.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KW() {
        this.aSP.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aSP.getLayoutMode().h(this.mView);
        this.aTq.refresh();
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aSP.getString(com.baidu.tieba.y.group_create_step_photo), Integer.valueOf(this.vp));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String KY() {
        if (this.mIndex != this.aSU) {
            return this.aSP.getString(com.baidu.tieba.y.group_create_step_tip);
        }
        return this.aSP.getString(com.baidu.tieba.y.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean KZ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KP() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean La() {
        return true;
    }
}
