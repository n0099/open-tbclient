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
    private CreateGroupStepActivity gDh;
    private TbImageView gDt;
    private Button gDu;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gDh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.gDu = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gDt = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gDu.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gDh.getPageContext().getPageActivity(), c.gDm, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gDh.getPageContext().getPageActivity(), c.gDp, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gDh.getPageContext().getPageActivity(), c.gDn, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBs() {
        this.gDt.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBt() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gDh.getLayoutMode().setNightMode(z);
        this.gDh.getLayoutMode().onModeChanged(this.mView);
        this.gDt.startLoad(c.a(this.gDh.getPageContext().getPageActivity(), c.gDq, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bBm() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gDh.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBv() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBw() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBx() {
        return false;
    }

    public Button bBC() {
        return this.gDu;
    }
}
