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
    private TextView iIV;
    private TextView jSu;
    private TbImageView jSv;
    private TextView jlP;

    public FrsForumToolDialogView(Context context) {
        super(context);
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jlP.setOnClickListener(onClickListener);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jSu.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.jSv = (TbImageView) findViewById(R.id.iv_image);
        this.iIV = (TextView) findViewById(R.id.tv_content);
        this.jSu = (TextView) findViewById(R.id.btn_cancle);
        this.jlP = (TextView) findViewById(R.id.btn_more);
        this.jSu.setText(R.string.cancel);
        this.jlP.setText(R.string.know_more);
        this.jSv.setPlaceHolder(3);
        this.jSv.setDrawCorner(true);
        this.jSv.setAutoChangeStyle(true);
        this.jSv.setConrers(3);
        this.jSv.setRadiusById(R.string.J_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iIV).nZ(R.color.CAM_X0107).oc(R.dimen.M_T_X001).oa(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jSu).nZ(R.color.CAM_X0105).oh(R.string.J_X07).ol(R.dimen.L_X02).oa(R.dimen.T_X08).ok(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jlP).nZ(R.color.CAM_X0302).oh(R.string.J_X07).oa(R.dimen.T_X08).ol(R.dimen.L_X02).om(R.string.A_X07).ok(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this).oh(R.string.J_X06).og(0).setBackGroundColor(R.color.CAM_X0201);
    }

    public void setContent(String str) {
        this.iIV.setText(str);
    }

    public void setStartLoadUrl(int i, String str) {
        if (i == 1 || i == 2) {
            this.jSv.startLoad(str, 24, false);
        } else {
            this.jSv.startLoad(str, 10, false);
        }
    }
}
