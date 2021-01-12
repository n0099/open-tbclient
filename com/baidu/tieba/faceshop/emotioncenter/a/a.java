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
/* loaded from: classes8.dex */
public class a extends PopupWindow implements View.OnClickListener {
    private TextView bUf;
    private TextView iSF;
    private TextView iSG;
    private View iSH;
    private View iSI;
    private View iSJ;
    private LinearLayout iSK;
    private c iSL;
    private Context mContext;

    public a(Context context, int i) {
        super(context);
        w(context, i);
        this.mContext = context;
        cyK();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iSF.setOnClickListener(this);
        this.iSG.setOnClickListener(this);
        this.bUf.setOnClickListener(this);
    }

    public void a(c cVar) {
        this.iSL = cVar;
    }

    private void w(Context context, int i) {
        this.iSH = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
        this.iSF = (TextView) this.iSH.findViewById(R.id.tv_single_bar);
        this.iSG = (TextView) this.iSH.findViewById(R.id.tv_my_emotion);
        this.bUf = (TextView) this.iSH.findViewById(R.id.tv_cancel);
        this.iSK = (LinearLayout) this.iSH.findViewById(R.id.id_pop_layout);
        this.iSI = this.iSH.findViewById(R.id.line1);
        this.iSJ = this.iSH.findViewById(R.id.line2);
        if (i == 1) {
            ao.setViewTextColor(this.iSF, R.color.CAM_X0105);
        } else {
            ao.setViewTextColor(this.iSF, R.color.CAM_X0204);
        }
    }

    public void onChangeSkin(int i) {
        ao.setBackgroundResource(this.iSK, R.color.CAM_X0201);
        ao.setBackgroundResource(this.iSI, R.color.CAM_X0204);
        ao.setBackgroundResource(this.iSJ, R.color.CAM_X0204);
        ao.setViewTextColor(this.iSG, R.color.CAM_X0105);
        ao.setViewTextColor(this.bUf, R.color.CAM_X0107);
    }

    private void cyK() {
        if (Build.VERSION.SDK_INT >= 22) {
            setAttachedInDecor(false);
        }
        setContentView(this.iSH);
        setWidth(-1);
        setHeight(l.getEquipmentHeight(this.mContext));
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
        this.iSH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = a.this.iSH.findViewById(R.id.id_pop_layout).getTop();
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
        if (this.iSL != null) {
            if (view == this.iSF) {
                this.iSL.cyF();
            } else if (view == this.iSG) {
                this.iSL.cyG();
            }
        }
    }
}
