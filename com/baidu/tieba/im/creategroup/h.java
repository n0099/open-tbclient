package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class h implements o {
    private TbImageView gCB;
    private Button gCC;
    private CreateGroupStepActivity gCp;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gCp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.gCC = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gCB = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gCC.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gCp.getPageContext().getPageActivity(), c.gCu, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gCp.getPageContext().getPageActivity(), c.gCx, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gCp.getPageContext().getPageActivity(), c.gCv, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBe() {
        this.gCB.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCp.getLayoutMode().setNightMode(z);
        this.gCp.getLayoutMode().onModeChanged(this.mView);
        this.gCB.startLoad(c.a(this.gCp.getPageContext().getPageActivity(), c.gCy, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bAY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gCp.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBh() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBj() {
        return false;
    }

    public Button bBo() {
        return this.gCC;
    }
}
