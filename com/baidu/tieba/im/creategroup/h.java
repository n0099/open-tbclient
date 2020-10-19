package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class h implements o {
    private CreateGroupStepActivity jHH;
    private TbImageView jHT;
    private Button jHU;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.jHH = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.jHU = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.jHT = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.jHU.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.jHH.getPageContext().getPageActivity(), c.jHM, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jHH.getPageContext().getPageActivity(), c.jHP, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jHH.getPageContext().getPageActivity(), c.jHN, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJU() {
        this.jHT.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJV() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jHH.getLayoutMode().setNightMode(z);
        this.jHH.getLayoutMode().onModeChanged(this.mView);
        this.jHT.startLoad(c.a(this.jHH.getPageContext().getPageActivity(), c.jHQ, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cJO() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.jHH.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cJX() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJY() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJZ() {
        return false;
    }

    public Button cKd() {
        return this.jHU;
    }
}
