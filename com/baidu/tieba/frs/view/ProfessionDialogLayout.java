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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ProfessionDialogLayout extends LinearLayout {
    private View.OnClickListener fAm;
    private View.OnClickListener fAn;
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
        LayoutInflater.from(context).inflate(d.h.profession_dialog_layout, this);
        setOrientation(1);
        TbImageView tbImageView = (TbImageView) findViewById(d.g.img_bg);
        al.j((TextView) findViewById(d.g.desc_1), d.C0236d.cp_cont_j);
        al.j((TextView) findViewById(d.g.desc_2), d.C0236d.cp_cont_j);
        al.j((TextView) findViewById(d.g.button), d.C0236d.cp_link_tip_a);
        setImageAttribute(tbImageView);
        al.c(tbImageView, d.f.img_frs_professinal_popup);
        TbImageView tbImageView2 = (TbImageView) findViewById(d.g.close_btn);
        al.c(tbImageView2, d.f.icon_prefession_popup_close_n);
        tbImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ProfessionDialogLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfessionDialogLayout.this.fAn != null) {
                    ProfessionDialogLayout.this.fAn.onClick(view);
                }
            }
        });
        findViewById(d.g.button).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ProfessionDialogLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfessionDialogLayout.this.fAm != null) {
                    ProfessionDialogLayout.this.fAm.onClick(view);
                }
            }
        });
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.fAm = onClickListener;
    }

    public void setCloseViewClickListener(View.OnClickListener onClickListener) {
        this.fAn = onClickListener;
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int aO;
        int h = l.h(this.mContext, d.e.ds40);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aO = l.aQ(this.mContext) - (h * 2);
        } else {
            aO = l.aO(this.mContext) - (h * 2);
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (aO * 558) / 992;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(l.h(this.mContext, d.e.ds16));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
