package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class i implements y {
    HeadImageView aTE;
    ImageView aTF;
    TextView aTG;
    private com.baidu.adp.widget.a.a aTH = null;
    private j aTI = null;
    CreateGroupStepActivity aTd;
    private int aTi;
    private int mIndex;
    View mView;
    private int vp;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aTd = null;
        this.mView = null;
        this.aTE = null;
        this.aTF = null;
        this.aTG = null;
        this.aTd = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step3_view, null);
        this.aTF = (ImageView) this.mView.findViewById(com.baidu.tieba.v.step3_img_bg);
        this.aTE = (HeadImageView) this.mView.findViewById(com.baidu.tieba.v.step3_img_scr);
        this.aTG = (TextView) this.mView.findViewById(com.baidu.tieba.v.create_group3);
        this.mIndex = i;
        this.vp = i2;
        this.aTi = i3;
    }

    public void Lo() {
        if (this.aTI != null) {
            this.aTI.cancel();
        }
        this.aTH = null;
        this.aTI = new j(this, null);
        this.aTI.execute(new Object[0]);
    }

    public ImageView Lp() {
        return this.aTF;
    }

    public TextView Lq() {
        return this.aTG;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KZ() {
        this.aTF.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void La() {
        this.aTd.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aTd.getLayoutMode().h(this.mView);
        this.aTE.refresh();
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aTd.getString(com.baidu.tieba.y.group_create_step_photo), Integer.valueOf(this.vp));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String Lc() {
        if (this.mIndex != this.aTi) {
            return this.aTd.getString(com.baidu.tieba.y.group_create_step_tip);
        }
        return this.aTd.getString(com.baidu.tieba.y.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Ld() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KT() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Le() {
        return true;
    }
}
