package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h implements o {
    private CreateGroupStepActivity eEF;
    private TbImageView eER;
    private Button eES;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eEF = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.eES = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.eER = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.eES.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eEF.getPageContext().getPageActivity(), c.eEK, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eEF.getPageContext().getPageActivity(), c.eEN, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eEF.getPageContext().getPageActivity(), c.eEL, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNd() {
        this.eER.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNe() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eEF.getLayoutMode().setNightMode(z);
        this.eEF.getLayoutMode().onModeChanged(this.mView);
        this.eER.startLoad(c.a(this.eEF.getPageContext().getPageActivity(), c.eEO, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aMX() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eEF.getPageContext().getString(e.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNg() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNh() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNi() {
        return false;
    }

    public Button aNm() {
        return this.eES;
    }
}
