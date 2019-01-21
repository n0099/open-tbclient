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
    private TextView aJJ;
    private TextView emY;
    private ImageView emZ;
    private ScrollItemView ena;
    private ImageView enb;
    private com.baidu.tieba.frs.worldcup.talkball.a.a enc;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private int mSkinType = 3;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ao.isEmpty(a.this.mUrl)) {
                TiebaStatic.log(new am("c13082"));
                ay.Es().c(a.this.mTbPageContext, new String[]{a.this.mUrl});
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        aI(viewGroup);
    }

    private void aI(ViewGroup viewGroup) {
        this.mRootView = this.mTbPageContext.getPageActivity().getLayoutInflater().inflate(e.h.guess_competition_layout, viewGroup, false);
        this.mRootView.findViewById(e.g.container).setOnClickListener(this.mClickListener);
        this.emY = (TextView) this.mRootView.findViewById(e.g.competition_text);
        this.emZ = (ImageView) this.mRootView.findViewById(e.g.prise_icon);
        this.ena = (ScrollItemView) this.mRootView.findViewById(e.g.prise_text);
        this.ena.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.mClickListener != null) {
                    a.this.mClickListener.onClick(view);
                }
            }
        });
        this.aJJ = (TextView) this.mRootView.findViewById(e.g.more);
        this.enb = (ImageView) this.mRootView.findViewById(e.g.right_arrow);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(e.g.recycler_view);
        this.enc = new com.baidu.tieba.frs.worldcup.talkball.a.a(this.mTbPageContext);
        this.enc.setOnClickListener(this.mClickListener);
        recyclerView.setAdapter(this.enc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar != null) {
            this.mUrl = eVar.aJF();
            c(eVar);
            this.enc.setData(eVar.aJE());
            this.enc.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        this.ena.setData(eVar.aJG());
        if (v.I(eVar.aJG())) {
            this.emZ.setVisibility(8);
        } else {
            this.emZ.setVisibility(0);
        }
    }

    public void gA(boolean z) {
        if (this.ena != null) {
            if (z) {
                this.ena.aJo();
            } else {
                this.ena.stopScroll();
            }
        }
    }

    public void onDestroy() {
        if (this.ena != null) {
            this.ena.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.emY, e.d.cp_cont_f);
            al.h(this.aJJ, e.d.cp_cont_j);
            al.c(this.emZ, e.f.icon_front_worldcup_jiang_n);
            al.c(this.enb, e.f.icon_arrow_gray_right_n);
            if (this.enc != null) {
                this.enc.notifyDataSetChanged();
            }
        }
    }
}
