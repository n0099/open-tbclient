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
    private CreateGroupStepActivity gwe;
    private TbImageView gwq;
    private Button gwr;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.gwr = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gwq = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gwr.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gwe.getPageContext().getPageActivity(), c.gwj, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gwe.getPageContext().getPageActivity(), c.gwm, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gwe.getPageContext().getPageActivity(), c.gwk, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        this.gwq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byB() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwe.getLayoutMode().setNightMode(z);
        this.gwe.getLayoutMode().onModeChanged(this.mView);
        this.gwq.startLoad(c.a(this.gwe.getPageContext().getPageActivity(), c.gwn, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byu() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gwe.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byD() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byF() {
        return false;
    }

    public Button byJ() {
        return this.gwr;
    }
}
