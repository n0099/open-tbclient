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
    private CreateGroupStepActivity gwb;
    private TbImageView gwn;
    private Button gwo;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gwb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.gwo = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gwn = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gwo.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gwb.getPageContext().getPageActivity(), c.gwg, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gwb.getPageContext().getPageActivity(), c.gwj, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gwb.getPageContext().getPageActivity(), c.gwh, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byw() {
        this.gwn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwb.getLayoutMode().setNightMode(z);
        this.gwb.getLayoutMode().onModeChanged(this.mView);
        this.gwn.startLoad(c.a(this.gwb.getPageContext().getPageActivity(), c.gwk, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byq() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gwb.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byz() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byA() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byB() {
        return false;
    }

    public Button byF() {
        return this.gwo;
    }
}
