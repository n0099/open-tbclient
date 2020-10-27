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
    private CreateGroupStepActivity jUg;
    private TbImageView jUs;
    private Button jUt;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.jUg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.jUt = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.jUs = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.jUt.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.jUg.getPageContext().getPageActivity(), c.jUl, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jUg.getPageContext().getPageActivity(), c.jUo, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jUg.getPageContext().getPageActivity(), c.jUm, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNb() {
        this.jUs.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jUg.getLayoutMode().setNightMode(z);
        this.jUg.getLayoutMode().onModeChanged(this.mView);
        this.jUs.startLoad(c.a(this.jUg.getPageContext().getPageActivity(), c.jUp, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cMV() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.jUg.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cNe() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNf() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNg() {
        return false;
    }

    public Button cNk() {
        return this.jUt;
    }
}
