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
    private TextView iBo;
    private TextView jJA;
    private TbImageView jJB;
    private TextView jel;

    public FrsForumToolDialogView(Context context) {
        super(context);
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jel.setOnClickListener(onClickListener);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jJA.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.jJB = (TbImageView) findViewById(R.id.iv_image);
        this.iBo = (TextView) findViewById(R.id.tv_content);
        this.jJA = (TextView) findViewById(R.id.btn_cancle);
        this.jel = (TextView) findViewById(R.id.btn_more);
        this.jJA.setText(R.string.cancel);
        this.jel.setText(R.string.know_more);
        this.jJB.setPlaceHolder(3);
        this.jJB.setDrawCorner(true);
        this.jJB.setAutoChangeStyle(true);
        this.jJB.setConrers(3);
        this.jJB.setRadiusById(R.string.J_X06);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iBo).nV(R.color.CAM_X0107).nY(R.dimen.M_T_X001).nW(R.dimen.T_X06);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jJA).nV(R.color.CAM_X0105).od(R.string.J_X07).og(R.dimen.L_X02).nW(R.dimen.T_X08).of(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jel).nV(R.color.CAM_X0302).od(R.string.J_X07).nW(R.dimen.T_X08).og(R.dimen.L_X02).oh(R.string.A_X07).of(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this).od(R.string.J_X06).oc(0).setBackGroundColor(R.color.CAM_X0201);
    }

    public void setContent(String str) {
        this.iBo.setText(str);
    }

    public void setStartLoadUrl(int i, String str) {
        if (i == 1 || i == 2) {
            this.jJB.startLoad(str, 24, false);
        } else {
            this.jJB.startLoad(str, 10, false);
        }
    }
}
