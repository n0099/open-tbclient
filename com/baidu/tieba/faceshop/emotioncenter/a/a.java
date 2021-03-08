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
/* loaded from: classes8.dex */
public class a extends PopupWindow implements View.OnClickListener {
    private TextView bZE;
    private TextView jaj;
    private TextView jak;
    private View jal;
    private View jam;
    private View jan;
    private LinearLayout jao;
    private c jap;
    private Context mContext;

    public a(Context context, int i) {
        super(context);
        w(context, i);
        this.mContext = context;
        cAi();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.jaj.setOnClickListener(this);
        this.jak.setOnClickListener(this);
        this.bZE.setOnClickListener(this);
    }

    public void a(c cVar) {
        this.jap = cVar;
    }

    private void w(Context context, int i) {
        this.jal = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
        this.jaj = (TextView) this.jal.findViewById(R.id.tv_single_bar);
        this.jak = (TextView) this.jal.findViewById(R.id.tv_my_emotion);
        this.bZE = (TextView) this.jal.findViewById(R.id.tv_cancel);
        this.jao = (LinearLayout) this.jal.findViewById(R.id.id_pop_layout);
        this.jam = this.jal.findViewById(R.id.line1);
        this.jan = this.jal.findViewById(R.id.line2);
        if (i == 1) {
            ap.setViewTextColor(this.jaj, R.color.CAM_X0105);
        } else {
            ap.setViewTextColor(this.jaj, R.color.CAM_X0204);
        }
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundResource(this.jao, R.color.CAM_X0201);
        ap.setBackgroundResource(this.jam, R.color.CAM_X0204);
        ap.setBackgroundResource(this.jan, R.color.CAM_X0204);
        ap.setViewTextColor(this.jak, R.color.CAM_X0105);
        ap.setViewTextColor(this.bZE, R.color.CAM_X0107);
    }

    private void cAi() {
        if (Build.VERSION.SDK_INT >= 22) {
            setAttachedInDecor(false);
        }
        setContentView(this.jal);
        setWidth(-1);
        setHeight(l.getEquipmentHeight(this.mContext));
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
        this.jal.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = a.this.jal.findViewById(R.id.id_pop_layout).getTop();
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
        if (this.jap != null) {
            if (view == this.jaj) {
                this.jap.cAd();
            } else if (view == this.jak) {
                this.jap.cAe();
            }
        }
    }
}
