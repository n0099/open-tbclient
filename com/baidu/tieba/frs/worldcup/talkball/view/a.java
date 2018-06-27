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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.e;
import com.baidu.tieba.view.ScrollItemView;
/* loaded from: classes2.dex */
public class a {
    private TextView axt;
    private TextView dJG;
    private ImageView dJH;
    private ScrollItemView dJI;
    private ImageView dJJ;
    private com.baidu.tieba.frs.worldcup.talkball.a.a dJK;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private int mSkinType = 3;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ap.isEmpty(a.this.mUrl)) {
                TiebaStatic.log(new an("c13082"));
                az.zV().c(a.this.mTbPageContext, new String[]{a.this.mUrl});
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        aG(viewGroup);
    }

    private void aG(ViewGroup viewGroup) {
        this.mRootView = this.mTbPageContext.getPageActivity().getLayoutInflater().inflate(d.i.guess_competition_layout, viewGroup, false);
        this.mRootView.findViewById(d.g.container).setOnClickListener(this.mClickListener);
        this.dJG = (TextView) this.mRootView.findViewById(d.g.competition_text);
        this.dJH = (ImageView) this.mRootView.findViewById(d.g.prise_icon);
        this.dJI = (ScrollItemView) this.mRootView.findViewById(d.g.prise_text);
        this.dJI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.mClickListener != null) {
                    a.this.mClickListener.onClick(view);
                }
            }
        });
        this.axt = (TextView) this.mRootView.findViewById(d.g.more);
        this.dJJ = (ImageView) this.mRootView.findViewById(d.g.right_arrow);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(d.g.recycler_view);
        this.dJK = new com.baidu.tieba.frs.worldcup.talkball.a.a(this.mTbPageContext);
        this.dJK.setOnClickListener(this.mClickListener);
        recyclerView.setAdapter(this.dJK);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(e eVar) {
        if (eVar != null) {
            this.mUrl = eVar.aAX();
            c(eVar);
            this.dJK.setData(eVar.aAW());
            this.dJK.notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(e eVar) {
        this.dJI.setData(eVar.aAY());
        if (w.A(eVar.aAY())) {
            this.dJH.setVisibility(8);
        } else {
            this.dJH.setVisibility(0);
        }
    }

    public void fy(boolean z) {
        if (this.dJI != null) {
            if (z) {
                this.dJI.aAI();
            } else {
                this.dJI.stopScroll();
            }
        }
    }

    public void onDestroy() {
        if (this.dJI != null) {
            this.dJI.onDestroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dJG, d.C0142d.cp_cont_f);
            am.h(this.axt, d.C0142d.cp_cont_j);
            am.c(this.dJH, d.f.icon_front_worldcup_jiang_n);
            am.c(this.dJJ, d.f.icon_arrow_gray_right_n);
            if (this.dJK != null) {
                this.dJK.notifyDataSetChanged();
            }
        }
    }
}
