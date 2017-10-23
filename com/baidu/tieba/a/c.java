package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.c, com.baidu.tbadk.i.a> {
    private View.OnClickListener baf;
    private TbPageContext mH;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.c.ayN, bdUniqueId);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public com.baidu.tbadk.i.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.i.a(LayoutInflater.from(this.mH.getPageActivity()).inflate(d.j.entrance_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.c cVar, com.baidu.tbadk.i.a aVar) {
        if (aVar == null || cVar == null) {
            return null;
        }
        aVar.aEx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view2.setScaleX(0.8f);
                    view2.setScaleY(0.8f);
                } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    view2.setScaleX(1.0f);
                    view2.setScaleY(1.0f);
                }
                return view2.onTouchEvent(motionEvent);
            }
        });
        aVar.setOnClick(this.baf);
        aVar.c(cVar);
        return aVar.getView();
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.baf = onClickListener;
    }
}
