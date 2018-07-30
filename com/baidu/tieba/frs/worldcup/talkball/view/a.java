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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.e;
import com.baidu.tieba.view.ScrollItemView;
/* loaded from: classes3.dex */
public class a {
    private TextView awZ;
    private com.baidu.tieba.frs.worldcup.talkball.a.a dMA;
    private TextView dMw;
    private ImageView dMx;
    private ScrollItemView dMy;
    private ImageView dMz;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private int mSkinType = 3;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ap.isEmpty(a.this.mUrl)) {
                TiebaStatic.log(new an("c13082"));
                ay.zK().c(a.this.mTbPageContext, new String[]{a.this.mUrl});
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        aG(viewGroup);
    }

    private void aG(ViewGroup viewGroup) {
        this.mRootView = this.mTbPageContext.getPageActivity().getLayoutInflater().inflate(d.h.guess_competition_layout, viewGroup, false);
        this.mRootView.findViewById(d.g.container).setOnClickListener(this.mClickListener);
        this.dMw = (TextView) this.mRootView.findViewById(d.g.competition_text);
        this.dMx = (ImageView) this.mRootView.findViewById(d.g.prise_icon);
        this.dMy = (ScrollItemView) this.mRootView.findViewById(d.g.prise_text);
        this.dMy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.mClickListener != null) {
                    a.this.mClickListener.onClick(view);
                }
            }
        });
        this.awZ = (TextView) this.mRootView.findViewById(d.g.more);
        this.dMz = (ImageView) this.mRootView.findViewById(d.g.right_arrow);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(d.g.recycler_view);
        this.dMA = new com.baidu.tieba.frs.worldcup.talkball.a.a(this.mTbPageContext);
        this.dMA.setOnClickListener(this.mClickListener);
        recyclerView.setAdapter(this.dMA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(e eVar) {
        if (eVar != null) {
            this.mUrl = eVar.aBG();
            c(eVar);
            this.dMA.setData(eVar.aBF());
            this.dMA.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(e eVar) {
        this.dMy.setData(eVar.aBH());
        if (w.z(eVar.aBH())) {
            this.dMx.setVisibility(8);
        } else {
            this.dMx.setVisibility(0);
        }
    }

    public void fA(boolean z) {
        if (this.dMy != null) {
            if (z) {
                this.dMy.aBr();
            } else {
                this.dMy.stopScroll();
            }
        }
    }

    public void onDestroy() {
        if (this.dMy != null) {
            this.dMy.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dMw, d.C0140d.cp_cont_f);
            am.h(this.awZ, d.C0140d.cp_cont_j);
            am.c(this.dMx, d.f.icon_front_worldcup_jiang_n);
            am.c(this.dMz, d.f.icon_arrow_gray_right_n);
            if (this.dMA != null) {
                this.dMA.notifyDataSetChanged();
            }
        }
    }
}
