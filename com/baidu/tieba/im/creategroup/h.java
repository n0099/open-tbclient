package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h implements o {
    private CreateGroupStepActivity eDm;
    private TbImageView eDy;
    private Button eDz;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eDm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.eDz = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.eDy = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.eDz.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eDm.getPageContext().getPageActivity(), c.eDr, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eDm.getPageContext().getPageActivity(), c.eDu, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eDm.getPageContext().getPageActivity(), c.eDs, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDm.getLayoutMode().setNightMode(z);
        this.eDm.getLayoutMode().onModeChanged(this.mView);
        this.eDy.startLoad(c.a(this.eDm.getPageContext().getPageActivity(), c.eDv, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eDm.getPageContext().getString(e.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return false;
    }

    public Button aNP() {
        return this.eDz;
    }
}
