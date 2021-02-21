package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsForumToolDialogView extends LinearLayout {
    private TextView iHm;
    private TextView jQL;
    private TbImageView jQM;
    private TextView jkg;

    public FrsForumToolDialogView(Context context) {
        super(context);
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jkg.setOnClickListener(onClickListener);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jQL.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.jQM = (TbImageView) findViewById(R.id.iv_image);
        this.iHm = (TextView) findViewById(R.id.tv_content);
        this.jQL = (TextView) findViewById(R.id.btn_cancle);
        this.jkg = (TextView) findViewById(R.id.btn_more);
        this.jQL.setText(R.string.cancel);
        this.jkg.setText(R.string.know_more);
        this.jQM.setPlaceHolder(3);
        this.jQM.setDrawCorner(true);
        this.jQM.setAutoChangeStyle(true);
        this.jQM.setConrers(3);
        this.jQM.setRadiusById(R.string.J_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iHm).nY(R.color.CAM_X0107).ob(R.dimen.M_T_X001).nZ(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jQL).nY(R.color.CAM_X0105).og(R.string.J_X07).ok(R.dimen.L_X02).nZ(R.dimen.T_X08).oj(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jkg).nY(R.color.CAM_X0302).og(R.string.J_X07).nZ(R.dimen.T_X08).ok(R.dimen.L_X02).ol(R.string.A_X07).oj(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this).og(R.string.J_X06).of(0).setBackGroundColor(R.color.CAM_X0201);
    }

    public void setContent(String str) {
        this.iHm.setText(str);
    }

    public void setStartLoadUrl(int i, String str) {
        if (i == 1 || i == 2) {
            this.jQM.startLoad(str, 24, false);
        } else {
            this.jQM.startLoad(str, 10, false);
        }
    }
}
