package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class h implements y {
    private CreateGroupStepActivity aSP;
    private TbImageView aTc;
    private Button aTd;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.aSP = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_normal_tips, null);
        this.aTd = (Button) this.mView.findViewById(com.baidu.tieba.v.create_group_tips_btn);
        this.aTc = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.create_group_tips_image);
        this.mIndex = i;
        this.aTd.setText(String.format(createGroupStepActivity.getString(com.baidu.tieba.y.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.aSP, c.aSV, TbadkApplication.m251getInst().getSkinType() == 1);
        c.b(this.aSP, c.aSY, TbadkApplication.m251getInst().getSkinType() == 1);
        c.b(this.aSP, c.aSW, TbadkApplication.m251getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KV() {
        this.aTc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KW() {
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        this.aSP.getLayoutMode().L(z);
        this.aSP.getLayoutMode().h(this.mView);
        this.aTc.c(c.a(this.aSP, c.aSZ, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KP() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return this.aSP.getString(com.baidu.tieba.y.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String KY() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean KZ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean La() {
        return false;
    }

    public Button Le() {
        return this.aTd;
    }
}
