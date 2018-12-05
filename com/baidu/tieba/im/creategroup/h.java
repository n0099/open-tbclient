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
    private TbImageView eLG;
    private Button eLH;
    private CreateGroupStepActivity eLu;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eLu = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.eLH = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.eLG = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.eLH.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eLu.getPageContext().getPageActivity(), c.eLz, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eLu.getPageContext().getPageActivity(), c.eLC, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eLu.getPageContext().getPageActivity(), c.eLA, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOV() {
        this.eLG.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOW() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eLu.getLayoutMode().setNightMode(z);
        this.eLu.getLayoutMode().onModeChanged(this.mView);
        this.eLG.startLoad(c.a(this.eLu.getPageContext().getPageActivity(), c.eLD, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aOP() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eLu.getPageContext().getString(e.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aOY() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aOZ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPa() {
        return false;
    }

    public Button aPe() {
        return this.eLH;
    }
}
