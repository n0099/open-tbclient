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
    private CreateGroupStepActivity eDl;
    private TbImageView eDx;
    private Button eDy;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eDl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.eDy = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.eDx = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.eDy.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eDl.getPageContext().getPageActivity(), c.eDq, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eDl.getPageContext().getPageActivity(), c.eDt, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eDl.getPageContext().getPageActivity(), c.eDr, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDx.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDl.getLayoutMode().setNightMode(z);
        this.eDl.getLayoutMode().onModeChanged(this.mView);
        this.eDx.startLoad(c.a(this.eDl.getPageContext().getPageActivity(), c.eDu, z), 29, false);
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
        return this.eDl.getPageContext().getString(e.j.group_create_tips_normal);
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
        return this.eDy;
    }
}
