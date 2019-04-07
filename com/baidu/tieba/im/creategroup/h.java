package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class h implements o {
    private CreateGroupStepActivity geP;
    private TbImageView gfb;
    private Button gfc;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.geP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_normal_tips, (ViewGroup) null);
        this.gfc = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.gfb = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.gfc.setText(String.format(createGroupStepActivity.getPageContext().getString(d.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.geP.getPageContext().getPageActivity(), c.geU, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.geP.getPageContext().getPageActivity(), c.geX, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.geP.getPageContext().getPageActivity(), c.geV, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqK() {
        this.gfb.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.geP.getLayoutMode().setNightMode(z);
        this.geP.getLayoutMode().onModeChanged(this.mView);
        this.gfb.startLoad(c.a(this.geP.getPageContext().getPageActivity(), c.geY, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqE() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.geP.getPageContext().getString(d.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqN() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqO() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqP() {
        return false;
    }

    public Button bqT() {
        return this.gfc;
    }
}
