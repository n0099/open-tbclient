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
    private CreateGroupStepActivity gwc;
    private TbImageView gwo;
    private Button gwp;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.gwp = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gwo = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gwp.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gwc.getPageContext().getPageActivity(), c.gwh, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gwc.getPageContext().getPageActivity(), c.gwk, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gwc.getPageContext().getPageActivity(), c.gwi, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byz() {
        this.gwo.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwc.getLayoutMode().setNightMode(z);
        this.gwc.getLayoutMode().onModeChanged(this.mView);
        this.gwo.startLoad(c.a(this.gwc.getPageContext().getPageActivity(), c.gwl, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byt() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gwc.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byC() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byD() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return false;
    }

    public Button byI() {
        return this.gwp;
    }
}
