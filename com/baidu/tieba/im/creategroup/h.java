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
    private CreateGroupStepActivity eOl;
    private TbImageView eOx;
    private Button eOy;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eOl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.eOy = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.eOx = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.eOy.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eOl.getPageContext().getPageActivity(), c.eOq, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eOl.getPageContext().getPageActivity(), c.eOt, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eOl.getPageContext().getPageActivity(), c.eOr, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPI() {
        this.eOx.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPJ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOl.getLayoutMode().setNightMode(z);
        this.eOl.getLayoutMode().onModeChanged(this.mView);
        this.eOx.startLoad(c.a(this.eOl.getPageContext().getPageActivity(), c.eOu, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aPC() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eOl.getPageContext().getString(e.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aPL() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPM() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPN() {
        return false;
    }

    public Button aPR() {
        return this.eOy;
    }
}
