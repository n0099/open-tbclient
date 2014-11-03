package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class h implements y {
    private CreateGroupStepActivity aTd;
    private TbImageView aTq;
    private Button aTr;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.aTd = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_normal_tips, null);
        this.aTr = (Button) this.mView.findViewById(com.baidu.tieba.v.create_group_tips_btn);
        this.aTq = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.create_group_tips_image);
        this.mIndex = i;
        this.aTr.setText(String.format(createGroupStepActivity.getString(com.baidu.tieba.y.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.aTd, c.aTj, TbadkApplication.m251getInst().getSkinType() == 1);
        c.b(this.aTd, c.aTm, TbadkApplication.m251getInst().getSkinType() == 1);
        c.b(this.aTd, c.aTk, TbadkApplication.m251getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KZ() {
        this.aTq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void La() {
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        this.aTd.getLayoutMode().L(z);
        this.aTd.getLayoutMode().h(this.mView);
        this.aTq.c(c.a(this.aTd, c.aTn, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KT() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return this.aTd.getString(com.baidu.tieba.y.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String Lc() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Ld() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Le() {
        return false;
    }

    public Button Li() {
        return this.aTr;
    }
}
