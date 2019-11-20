package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ProfessionDialogLayout extends LinearLayout {
    private View.OnClickListener fXh;
    private View.OnClickListener fXi;
    private Context mContext;

    public ProfessionDialogLayout(Context context) {
        super(context);
        init(context);
    }

    public ProfessionDialogLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ProfessionDialogLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.profession_dialog_layout, this);
        setOrientation(1);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.img_bg);
        am.setViewTextColor((TextView) findViewById(R.id.desc_1), (int) R.color.cp_cont_j);
        am.setViewTextColor((TextView) findViewById(R.id.desc_2), (int) R.color.cp_cont_j);
        am.setViewTextColor((TextView) findViewById(R.id.button), (int) R.color.cp_link_tip_a);
        setImageAttribute(tbImageView);
        am.setImageResource(tbImageView, R.drawable.img_frs_professinal_popup);
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.close_btn);
        am.setImageResource(tbImageView2, R.drawable.icon_prefession_popup_close_n);
        tbImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ProfessionDialogLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfessionDialogLayout.this.fXi != null) {
                    ProfessionDialogLayout.this.fXi.onClick(view);
                }
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ProfessionDialogLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfessionDialogLayout.this.fXh != null) {
                    ProfessionDialogLayout.this.fXh.onClick(view);
                }
            }
        });
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.fXh = onClickListener;
    }

    public void setCloseViewClickListener(View.OnClickListener onClickListener) {
        this.fXi = onClickListener;
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int equipmentWidth;
        int dimens = l.getDimens(this.mContext, R.dimen.ds40);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            equipmentWidth = l.getEquipmentHeight(this.mContext) - (dimens * 2);
        } else {
            equipmentWidth = l.getEquipmentWidth(this.mContext) - (dimens * 2);
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (equipmentWidth * 558) / 992;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(l.getDimens(this.mContext, R.dimen.ds16));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
