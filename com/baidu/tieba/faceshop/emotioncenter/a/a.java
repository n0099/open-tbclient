package com.baidu.tieba.faceshop.emotioncenter.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends PopupWindow implements View.OnClickListener {
    private TextView bYe;
    private TextView iYA;
    private TextView iYB;
    private View iYC;
    private View iYD;
    private View iYE;
    private LinearLayout iYF;
    private c iYG;
    private Context mContext;

    public a(Context context, int i) {
        super(context);
        w(context, i);
        this.mContext = context;
        cAc();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYA.setOnClickListener(this);
        this.iYB.setOnClickListener(this);
        this.bYe.setOnClickListener(this);
    }

    public void a(c cVar) {
        this.iYG = cVar;
    }

    private void w(Context context, int i) {
        this.iYC = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
        this.iYA = (TextView) this.iYC.findViewById(R.id.tv_single_bar);
        this.iYB = (TextView) this.iYC.findViewById(R.id.tv_my_emotion);
        this.bYe = (TextView) this.iYC.findViewById(R.id.tv_cancel);
        this.iYF = (LinearLayout) this.iYC.findViewById(R.id.id_pop_layout);
        this.iYD = this.iYC.findViewById(R.id.line1);
        this.iYE = this.iYC.findViewById(R.id.line2);
        if (i == 1) {
            ap.setViewTextColor(this.iYA, R.color.CAM_X0105);
        } else {
            ap.setViewTextColor(this.iYA, R.color.CAM_X0204);
        }
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundResource(this.iYF, R.color.CAM_X0201);
        ap.setBackgroundResource(this.iYD, R.color.CAM_X0204);
        ap.setBackgroundResource(this.iYE, R.color.CAM_X0204);
        ap.setViewTextColor(this.iYB, R.color.CAM_X0105);
        ap.setViewTextColor(this.bYe, R.color.CAM_X0107);
    }

    private void cAc() {
        if (Build.VERSION.SDK_INT >= 22) {
            setAttachedInDecor(false);
        }
        setContentView(this.iYC);
        setWidth(-1);
        setHeight(l.getEquipmentHeight(this.mContext));
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
        this.iYC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = a.this.iYC.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    a.this.dismiss();
                }
                return true;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.iYG != null) {
            if (view == this.iYA) {
                this.iYG.czX();
            } else if (view == this.iYB) {
                this.iYG.czY();
            }
        }
    }
}
