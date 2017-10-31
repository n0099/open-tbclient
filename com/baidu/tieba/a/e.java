package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.c, com.baidu.tbadk.j.a> {
    private View.OnClickListener baM;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.c.azr, bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public com.baidu.tbadk.j.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.j.a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.entrance_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.c cVar, com.baidu.tbadk.j.a aVar) {
        if (aVar == null || cVar == null) {
            return null;
        }
        aVar.aFg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.e.1
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
        aVar.setOnClick(this.baM);
        aVar.c(cVar);
        return aVar.getView();
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.baM = onClickListener;
    }
}
