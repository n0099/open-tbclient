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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.worldcup.talkball.b.e;
import com.baidu.tieba.view.ScrollItemView;
/* loaded from: classes3.dex */
public class a {
    private TextView awW;
    private TextView dMs;
    private ImageView dMt;
    private ScrollItemView dMu;
    private ImageView dMv;
    private com.baidu.tieba.frs.worldcup.talkball.a.a dMw;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private int mSkinType = 3;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ap.isEmpty(a.this.mUrl)) {
                TiebaStatic.log(new an("c13082"));
                az.zI().c(a.this.mTbPageContext, new String[]{a.this.mUrl});
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        aG(viewGroup);
    }

    private void aG(ViewGroup viewGroup) {
        this.mRootView = this.mTbPageContext.getPageActivity().getLayoutInflater().inflate(f.h.guess_competition_layout, viewGroup, false);
        this.mRootView.findViewById(f.g.container).setOnClickListener(this.mClickListener);
        this.dMs = (TextView) this.mRootView.findViewById(f.g.competition_text);
        this.dMt = (ImageView) this.mRootView.findViewById(f.g.prise_icon);
        this.dMu = (ScrollItemView) this.mRootView.findViewById(f.g.prise_text);
        this.dMu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.mClickListener != null) {
                    a.this.mClickListener.onClick(view);
                }
            }
        });
        this.awW = (TextView) this.mRootView.findViewById(f.g.more);
        this.dMv = (ImageView) this.mRootView.findViewById(f.g.right_arrow);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(f.g.recycler_view);
        this.dMw = new com.baidu.tieba.frs.worldcup.talkball.a.a(this.mTbPageContext);
        this.dMw.setOnClickListener(this.mClickListener);
        recyclerView.setAdapter(this.dMw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(e eVar) {
        if (eVar != null) {
            this.mUrl = eVar.aBD();
            c(eVar);
            this.dMw.setData(eVar.aBC());
            this.dMw.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(e eVar) {
        this.dMu.setData(eVar.aBE());
        if (w.z(eVar.aBE())) {
            this.dMt.setVisibility(8);
        } else {
            this.dMt.setVisibility(0);
        }
    }

    public void fA(boolean z) {
        if (this.dMu != null) {
            if (z) {
                this.dMu.aBo();
            } else {
                this.dMu.stopScroll();
            }
        }
    }

    public void onDestroy() {
        if (this.dMu != null) {
            this.dMu.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dMs, f.d.cp_cont_f);
            am.h(this.awW, f.d.cp_cont_j);
            am.c(this.dMt, f.C0146f.icon_front_worldcup_jiang_n);
            am.c(this.dMv, f.C0146f.icon_arrow_gray_right_n);
            if (this.dMw != null) {
                this.dMw.notifyDataSetChanged();
            }
        }
    }
}
