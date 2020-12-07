package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class g implements o {
    EditText koO;
    private ImageButton koP;
    private int koQ;
    CreateGroupStepActivity kor;
    TbImageView kos;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cUI() {
        return this.koO;
    }

    public View cUJ() {
        return this.koP;
    }

    public void cUK() {
        this.koO.setText("");
    }

    public int wg() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.koO);
    }

    public void sl(boolean z) {
        if (z) {
            this.koP.setVisibility(0);
        } else {
            this.koP.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kor = null;
        this.mView = null;
        this.kos = null;
        this.koO = null;
        this.koP = null;
        this.kor = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.koO = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.kos = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.koP = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.koP.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.koQ = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUq() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kor.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUw() {
        this.kos.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kor.getLayoutMode().setNightMode(z);
        this.kor.getLayoutMode().onModeChanged(this.mView);
        this.kos.startLoad(c.a(this.kor.getPageContext().getPageActivity(), c.koz, z), 29, false);
        this.koO.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kor.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUz() {
        if (this.mIndex != this.koQ) {
            return this.kor.getPageContext().getString(R.string.next_step);
        }
        return this.kor.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUA() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kor.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return true;
    }
}
