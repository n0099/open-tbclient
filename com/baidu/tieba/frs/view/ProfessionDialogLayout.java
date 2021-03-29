package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class ProfessionDialogLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f16787e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f16788f;

    /* renamed from: g  reason: collision with root package name */
    public Context f16789g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ProfessionDialogLayout.this.f16788f != null) {
                ProfessionDialogLayout.this.f16788f.onClick(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ProfessionDialogLayout.this.f16787e != null) {
                ProfessionDialogLayout.this.f16787e.onClick(view);
            }
        }
    }

    public ProfessionDialogLayout(Context context) {
        super(context);
        c(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        int g2 = l.g(this.f16789g, R.dimen.ds40);
        if (UtilHelper.getRealScreenOrientation(this.f16789g) == 2) {
            k = l.i(this.f16789g);
        } else {
            k = l.k(this.f16789g);
        }
        int i = k - (g2 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i * 558) / 992;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(l.g(this.f16789g, R.dimen.ds16));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }

    public final void c(Context context) {
        this.f16789g = context;
        LayoutInflater.from(context).inflate(R.layout.profession_dialog_layout, this);
        setOrientation(1);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.img_bg);
        SkinManager.setViewTextColor((TextView) findViewById(R.id.desc_1), R.color.CAM_X0107);
        SkinManager.setViewTextColor((TextView) findViewById(R.id.desc_2), R.color.CAM_X0107);
        SkinManager.setViewTextColor((TextView) findViewById(R.id.button), R.color.CAM_X0302);
        setImageAttribute(tbImageView);
        SkinManager.setImageResource(tbImageView, R.drawable.img_frs_professinal_popup);
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.close_btn);
        SkinManager.setImageResource(tbImageView2, R.drawable.icon_prefession_popup_close_n);
        tbImageView2.setOnClickListener(new a());
        findViewById(R.id.button).setOnClickListener(new b());
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f16787e = onClickListener;
    }

    public void setCloseViewClickListener(View.OnClickListener onClickListener) {
        this.f16788f = onClickListener;
    }

    public ProfessionDialogLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public ProfessionDialogLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
