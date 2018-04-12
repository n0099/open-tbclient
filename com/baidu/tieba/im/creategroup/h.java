package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h implements o {
    private CreateGroupStepActivity dUf;
    private TbImageView dUr;
    private Button dUs;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.dUf = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_normal_tips, (ViewGroup) null);
        this.dUs = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.dUr = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.dUs.setText(String.format(createGroupStepActivity.getPageContext().getString(d.k.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.dUf.getPageContext().getPageActivity(), c.dUk, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.dUf.getPageContext().getPageActivity(), c.dUn, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.dUf.getPageContext().getPageActivity(), c.dUl, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUr.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUf.getLayoutMode().setNightMode(z);
        this.dUf.getLayoutMode().u(this.mView);
        this.dUr.startLoad(c.a(this.dUf.getPageContext().getPageActivity(), c.dUo, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.dUf.getPageContext().getString(d.k.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return false;
    }

    public Button aBN() {
        return this.dUs;
    }
}
