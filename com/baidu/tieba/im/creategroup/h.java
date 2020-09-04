package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class h implements o {
    private CreateGroupStepActivity jkg;
    private TbImageView jks;
    private Button jkt;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.jkg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.jkt = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.jks = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.jkt.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.jkg.getPageContext().getPageActivity(), c.jkl, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jkg.getPageContext().getPageActivity(), c.jko, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jkg.getPageContext().getPageActivity(), c.jkm, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        this.jks.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCG() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jkg.getLayoutMode().setNightMode(z);
        this.jkg.getLayoutMode().onModeChanged(this.mView);
        this.jks.startLoad(c.a(this.jkg.getPageContext().getPageActivity(), c.jkp, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCz() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.jkg.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCI() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCK() {
        return false;
    }

    public Button cCO() {
        return this.jkt;
    }
}
