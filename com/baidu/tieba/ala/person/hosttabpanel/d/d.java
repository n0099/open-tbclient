package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.c> {
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_replay_no_data;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.c cVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public d glC;

        public a(d dVar) {
            super(dVar.getView());
            this.glC = dVar;
        }
    }
}
