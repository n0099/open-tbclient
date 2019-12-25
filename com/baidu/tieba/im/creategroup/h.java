package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class h implements o {
    private CreateGroupStepActivity hqm;
    private TbImageView hqy;
    private Button hqz;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.hqm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.hqz = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.hqy = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.hqz.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.hqm.getPageContext().getPageActivity(), c.hqr, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hqm.getPageContext().getPageActivity(), c.hqu, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hqm.getPageContext().getPageActivity(), c.hqs, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQg() {
        this.hqy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hqm.getLayoutMode().setNightMode(z);
        this.hqm.getLayoutMode().onModeChanged(this.mView);
        this.hqy.startLoad(c.a(this.hqm.getPageContext().getPageActivity(), c.hqv, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bQa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.hqm.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bQj() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQk() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQl() {
        return false;
    }

    public Button bQq() {
        return this.hqz;
    }
}
