package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class f extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.e> {
    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_replay_title;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.e eVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public f hYA;

        public a(f fVar) {
            super(fVar.getView());
            this.hYA = fVar;
        }
    }
}
