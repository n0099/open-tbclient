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
    private TextView iYm;
    private TextView iYn;
    private View iYo;
    private View iYp;
    private View iYq;
    private LinearLayout iYr;
    private c iYs;
    private Context mContext;

    public a(Context context, int i) {
        super(context);
        w(context, i);
        this.mContext = context;
        czV();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYm.setOnClickListener(this);
        this.iYn.setOnClickListener(this);
        this.bYe.setOnClickListener(this);
    }

    public void a(c cVar) {
        this.iYs = cVar;
    }

    private void w(Context context, int i) {
        this.iYo = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
        this.iYm = (TextView) this.iYo.findViewById(R.id.tv_single_bar);
        this.iYn = (TextView) this.iYo.findViewById(R.id.tv_my_emotion);
        this.bYe = (TextView) this.iYo.findViewById(R.id.tv_cancel);
        this.iYr = (LinearLayout) this.iYo.findViewById(R.id.id_pop_layout);
        this.iYp = this.iYo.findViewById(R.id.line1);
        this.iYq = this.iYo.findViewById(R.id.line2);
        if (i == 1) {
            ap.setViewTextColor(this.iYm, R.color.CAM_X0105);
        } else {
            ap.setViewTextColor(this.iYm, R.color.CAM_X0204);
        }
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundResource(this.iYr, R.color.CAM_X0201);
        ap.setBackgroundResource(this.iYp, R.color.CAM_X0204);
        ap.setBackgroundResource(this.iYq, R.color.CAM_X0204);
        ap.setViewTextColor(this.iYn, R.color.CAM_X0105);
        ap.setViewTextColor(this.bYe, R.color.CAM_X0107);
    }

    private void czV() {
        if (Build.VERSION.SDK_INT >= 22) {
            setAttachedInDecor(false);
        }
        setContentView(this.iYo);
        setWidth(-1);
        setHeight(l.getEquipmentHeight(this.mContext));
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
        this.iYo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = a.this.iYo.findViewById(R.id.id_pop_layout).getTop();
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
        if (this.iYs != null) {
            if (view == this.iYm) {
                this.iYs.czQ();
            } else if (view == this.iYn) {
                this.iYs.czR();
            }
        }
    }
}
