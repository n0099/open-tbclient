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
    private TbImageView koD;
    private Button koE;
    private CreateGroupStepActivity kor;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.kor = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.koE = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.koD = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.koE.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.kor.getPageContext().getPageActivity(), c.kow, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kor.getPageContext().getPageActivity(), c.koz, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kor.getPageContext().getPageActivity(), c.kox, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUw() {
        this.koD.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kor.getLayoutMode().setNightMode(z);
        this.kor.getLayoutMode().onModeChanged(this.mView);
        this.koD.startLoad(c.a(this.kor.getPageContext().getPageActivity(), c.koA, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUq() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.kor.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUz() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUA() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return false;
    }

    public Button cUF() {
        return this.koE;
    }
}
