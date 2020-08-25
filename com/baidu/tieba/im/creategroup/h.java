package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class h implements o {
    private CreateGroupStepActivity jka;
    private TbImageView jkm;
    private Button jkn;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.jka = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.jkn = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.jkm = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.jkn.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.jka.getPageContext().getPageActivity(), c.jkf, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jka.getPageContext().getPageActivity(), c.jki, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jka.getPageContext().getPageActivity(), c.jkg, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCE() {
        this.jkm.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jka.getLayoutMode().setNightMode(z);
        this.jka.getLayoutMode().onModeChanged(this.mView);
        this.jkm.startLoad(c.a(this.jka.getPageContext().getPageActivity(), c.jkj, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.jka.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCH() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return false;
    }

    public Button cCN() {
        return this.jkn;
    }
}
