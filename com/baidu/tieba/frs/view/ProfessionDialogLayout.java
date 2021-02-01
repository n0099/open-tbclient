package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ProfessionDialogLayout extends LinearLayout {
    private View.OnClickListener jSi;
    private View.OnClickListener jSj;
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
        ap.setViewTextColor((TextView) findViewById(R.id.desc_1), R.color.CAM_X0107);
        ap.setViewTextColor((TextView) findViewById(R.id.desc_2), R.color.CAM_X0107);
        ap.setViewTextColor((TextView) findViewById(R.id.button), R.color.CAM_X0302);
        setImageAttribute(tbImageView);
        ap.setImageResource(tbImageView, R.drawable.img_frs_professinal_popup);
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.close_btn);
        ap.setImageResource(tbImageView2, R.drawable.icon_prefession_popup_close_n);
        tbImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ProfessionDialogLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfessionDialogLayout.this.jSj != null) {
                    ProfessionDialogLayout.this.jSj.onClick(view);
                }
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ProfessionDialogLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfessionDialogLayout.this.jSi != null) {
                    ProfessionDialogLayout.this.jSi.onClick(view);
                }
            }
        });
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.jSi = onClickListener;
    }

    public void setCloseViewClickListener(View.OnClickListener onClickListener) {
        this.jSj = onClickListener;
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
