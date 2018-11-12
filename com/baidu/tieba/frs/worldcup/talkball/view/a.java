package com.baidu.tieba.frs.worldcup.talkball.view;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.view.ScrollItemView;
/* loaded from: classes3.dex */
public class a {
    private TextView aFF;
    private TextView ecY;
    private ImageView ecZ;
    private ScrollItemView eda;
    private ImageView edb;
    private com.baidu.tieba.frs.worldcup.talkball.a.a edc;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private int mSkinType = 3;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ao.isEmpty(a.this.mUrl)) {
                TiebaStatic.log(new am("c13082"));
                ay.Db().c(a.this.mTbPageContext, new String[]{a.this.mUrl});
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        aH(viewGroup);
    }

    private void aH(ViewGroup viewGroup) {
        this.mRootView = this.mTbPageContext.getPageActivity().getLayoutInflater().inflate(e.h.guess_competition_layout, viewGroup, false);
        this.mRootView.findViewById(e.g.container).setOnClickListener(this.mClickListener);
        this.ecY = (TextView) this.mRootView.findViewById(e.g.competition_text);
        this.ecZ = (ImageView) this.mRootView.findViewById(e.g.prise_icon);
        this.eda = (ScrollItemView) this.mRootView.findViewById(e.g.prise_text);
        this.eda.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.mClickListener != null) {
                    a.this.mClickListener.onClick(view);
                }
            }
        });
        this.aFF = (TextView) this.mRootView.findViewById(e.g.more);
        this.edb = (ImageView) this.mRootView.findViewById(e.g.right_arrow);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(e.g.recycler_view);
        this.edc = new com.baidu.tieba.frs.worldcup.talkball.a.a(this.mTbPageContext);
        this.edc.setOnClickListener(this.mClickListener);
        recyclerView.setAdapter(this.edc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar != null) {
            this.mUrl = eVar.aGG();
            c(eVar);
            this.edc.setData(eVar.aGF());
            this.edc.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        this.eda.setData(eVar.aGH());
        if (v.I(eVar.aGH())) {
            this.ecZ.setVisibility(8);
        } else {
            this.ecZ.setVisibility(0);
        }
    }

    public void gt(boolean z) {
        if (this.eda != null) {
            if (z) {
                this.eda.aGp();
            } else {
                this.eda.stopScroll();
            }
        }
    }

    public void onDestroy() {
        if (this.eda != null) {
            this.eda.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.ecY, e.d.cp_cont_f);
            al.h(this.aFF, e.d.cp_cont_j);
            al.c(this.ecZ, e.f.icon_front_worldcup_jiang_n);
            al.c(this.edb, e.f.icon_arrow_gray_right_n);
            if (this.edc != null) {
                this.edc.notifyDataSetChanged();
            }
        }
    }
}
