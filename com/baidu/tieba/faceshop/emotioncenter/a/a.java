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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends PopupWindow implements View.OnClickListener {
    private TextView bYR;
    private TextView iXm;
    private TextView iXn;
    private View iXo;
    private View iXp;
    private View iXq;
    private LinearLayout iXr;
    private c iXs;
    private Context mContext;

    public a(Context context, int i) {
        super(context);
        w(context, i);
        this.mContext = context;
        cCC();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iXm.setOnClickListener(this);
        this.iXn.setOnClickListener(this);
        this.bYR.setOnClickListener(this);
    }

    public void a(c cVar) {
        this.iXs = cVar;
    }

    private void w(Context context, int i) {
        this.iXo = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
        this.iXm = (TextView) this.iXo.findViewById(R.id.tv_single_bar);
        this.iXn = (TextView) this.iXo.findViewById(R.id.tv_my_emotion);
        this.bYR = (TextView) this.iXo.findViewById(R.id.tv_cancel);
        this.iXr = (LinearLayout) this.iXo.findViewById(R.id.id_pop_layout);
        this.iXp = this.iXo.findViewById(R.id.line1);
        this.iXq = this.iXo.findViewById(R.id.line2);
        if (i == 1) {
            ao.setViewTextColor(this.iXm, R.color.CAM_X0105);
        } else {
            ao.setViewTextColor(this.iXm, R.color.CAM_X0204);
        }
    }

    public void onChangeSkin(int i) {
        ao.setBackgroundResource(this.iXr, R.color.CAM_X0201);
        ao.setBackgroundResource(this.iXp, R.color.CAM_X0204);
        ao.setBackgroundResource(this.iXq, R.color.CAM_X0204);
        ao.setViewTextColor(this.iXn, R.color.CAM_X0105);
        ao.setViewTextColor(this.bYR, R.color.CAM_X0107);
    }

    private void cCC() {
        if (Build.VERSION.SDK_INT >= 22) {
            setAttachedInDecor(false);
        }
        setContentView(this.iXo);
        setWidth(-1);
        setHeight(l.getEquipmentHeight(this.mContext));
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
        this.iXo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = a.this.iXo.findViewById(R.id.id_pop_layout).getTop();
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
        if (this.iXs != null) {
            if (view == this.iXm) {
                this.iXs.cCx();
            } else if (view == this.iXn) {
                this.iXs.cCy();
            }
        }
    }
}
