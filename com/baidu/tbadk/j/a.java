package com.baidu.tbadk.j;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends j.a {
    public HeadImageViewGroup aFq;
    private f aFr;
    public TextView mName;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        View findViewById = view.findViewById(d.h.add_pic_root);
        this.mName = (TextView) findViewById.findViewById(d.h.name_tv);
        this.aFq = (HeadImageViewGroup) findViewById.findViewById(d.h.img);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tbadk.data.d) {
            this.aFr = fVar;
            this.aFq.getInnerImg().setIsRound(true);
            this.aFq.getInnerImg().setVisibility(0);
            this.aFq.getInnerImg().setTag(null);
            this.aFq.getInnerImg().setImageResource(d.g.btn_story_release);
            this.aFq.setOuterColor(d.e.cp_link_tip_g);
            getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.j.a.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        view.setScaleX(0.8f);
                        view.setScaleY(0.8f);
                    } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                    }
                    return view.onTouchEvent(motionEvent);
                }
            });
            this.mName.setText(((com.baidu.tbadk.data.d) fVar).getName());
            getView().setOnClickListener(this.mOnClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.mName, d.e.cp_cont_f, 1);
            this.aFq.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
