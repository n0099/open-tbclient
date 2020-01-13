package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class h implements o {
    private CreateGroupStepActivity htP;
    private TbImageView hub;
    private Button huc;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.htP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.huc = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.hub = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.huc.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.htP.getPageContext().getPageActivity(), c.htU, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.htP.getPageContext().getPageActivity(), c.htX, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.htP.getPageContext().getPageActivity(), c.htV, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRp() {
        this.hub.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRq() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.htP.getLayoutMode().setNightMode(z);
        this.htP.getLayoutMode().onModeChanged(this.mView);
        this.hub.startLoad(c.a(this.htP.getPageContext().getPageActivity(), c.htY, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bRj() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.htP.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bRs() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRt() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRu() {
        return false;
    }

    public Button bRz() {
        return this.huc;
    }
}
