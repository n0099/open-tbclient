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
    private TextView iFV;
    private TextView jOg;
    private TbImageView jOh;
    private TextView jiT;

    public FrsForumToolDialogView(Context context) {
        super(context);
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jiT.setOnClickListener(onClickListener);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jOg.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.jOh = (TbImageView) findViewById(R.id.iv_image);
        this.iFV = (TextView) findViewById(R.id.tv_content);
        this.jOg = (TextView) findViewById(R.id.btn_cancle);
        this.jiT = (TextView) findViewById(R.id.btn_more);
        this.jOg.setText(R.string.cancel);
        this.jiT.setText(R.string.know_more);
        this.jOh.setPlaceHolder(3);
        this.jOh.setDrawCorner(true);
        this.jOh.setAutoChangeStyle(true);
        this.jOh.setConrers(3);
        this.jOh.setRadiusById(R.string.J_X06);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iFV).pC(R.color.CAM_X0107).pF(R.dimen.M_T_X001).pD(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jOg).pC(R.color.CAM_X0105).pK(R.string.J_X07).pN(R.dimen.L_X02).pD(R.dimen.T_X08).pM(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jiT).pC(R.color.CAM_X0302).pK(R.string.J_X07).pD(R.dimen.T_X08).pN(R.dimen.L_X02).pO(R.string.A_X07).pM(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this).pK(R.string.J_X06).pJ(0).setBackGroundColor(R.color.CAM_X0201);
    }

    public void setContent(String str) {
        this.iFV.setText(str);
    }

    public void setStartLoadUrl(int i, String str) {
        if (i == 1 || i == 2) {
            this.jOh.startLoad(str, 24, false);
        } else {
            this.jOh.startLoad(str, 10, false);
        }
    }
}
