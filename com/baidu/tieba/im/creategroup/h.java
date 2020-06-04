package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class h implements o {
    private CreateGroupStepActivity iwR;
    private TbImageView ixd;
    private Button ixe;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.iwR = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.ixe = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.ixd = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.ixe.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.iwR.getPageContext().getPageActivity(), c.iwW, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iwR.getPageContext().getPageActivity(), c.iwZ, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iwR.getPageContext().getPageActivity(), c.iwX, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckr() {
        this.ixd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cks() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwR.getLayoutMode().setNightMode(z);
        this.iwR.getLayoutMode().onModeChanged(this.mView);
        this.ixd.startLoad(c.a(this.iwR.getPageContext().getPageActivity(), c.ixa, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckl() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.iwR.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cku() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckv() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckw() {
        return false;
    }

    public Button ckB() {
        return this.ixe;
    }
}
