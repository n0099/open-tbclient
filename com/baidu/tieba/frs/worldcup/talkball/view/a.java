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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.e;
import com.baidu.tieba.view.ScrollItemView;
/* loaded from: classes2.dex */
public class a {
    private TextView awK;
    private View cUg;
    private TextView dGn;
    private ImageView dGo;
    private ScrollItemView dGp;
    private ImageView dGq;
    private com.baidu.tieba.frs.worldcup.talkball.a.a dGr;
    private RecyclerView mRecyclerView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private int mSkinType = 3;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ao.isEmpty(a.this.mUrl)) {
                TiebaStatic.log(new am("c13082"));
                ay.zG().c(a.this.mTbPageContext, new String[]{a.this.mUrl});
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        aI(viewGroup);
    }

    private void aI(ViewGroup viewGroup) {
        this.mRootView = this.mTbPageContext.getPageActivity().getLayoutInflater().inflate(d.i.guess_competition_layout, viewGroup, false);
        this.cUg = this.mRootView.findViewById(d.g.container);
        this.cUg.setOnClickListener(this.mClickListener);
        this.dGn = (TextView) this.mRootView.findViewById(d.g.competition_text);
        this.dGo = (ImageView) this.mRootView.findViewById(d.g.prise_icon);
        this.dGp = (ScrollItemView) this.mRootView.findViewById(d.g.prise_text);
        this.dGp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.mClickListener != null) {
                    a.this.mClickListener.onClick(view);
                }
            }
        });
        this.awK = (TextView) this.mRootView.findViewById(d.g.more);
        this.dGq = (ImageView) this.mRootView.findViewById(d.g.right_arrow);
        this.mRecyclerView = (RecyclerView) this.mRootView.findViewById(d.g.recycler_view);
        this.dGr = new com.baidu.tieba.frs.worldcup.talkball.a.a(this.mTbPageContext);
        this.dGr.setOnClickListener(this.mClickListener);
        this.mRecyclerView.setAdapter(this.dGr);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(e eVar) {
        if (eVar != null) {
            this.mUrl = eVar.aAq();
            c(eVar);
            this.dGr.setData(eVar.aAp());
            this.dGr.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(e eVar) {
        this.dGp.setData(eVar.aAr());
        if (w.z(eVar.aAr())) {
            this.dGo.setVisibility(8);
        } else {
            this.dGo.setVisibility(0);
        }
    }

    public void fw(boolean z) {
        if (this.dGp != null) {
            if (z) {
                this.dGp.aAb();
            } else {
                this.dGp.stopScroll();
            }
        }
    }

    public void onDestroy() {
        if (this.dGp != null) {
            this.dGp.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dGn, d.C0141d.cp_cont_f);
            al.h(this.awK, d.C0141d.cp_cont_j);
            al.c(this.dGo, d.f.icon_front_worldcup_jiang_n);
            al.c(this.dGq, d.f.icon_arrow_gray_right_n);
            if (this.dGr != null) {
                this.dGr.notifyDataSetChanged();
            }
        }
    }
}
