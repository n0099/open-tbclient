package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> eCn;
    private b iwW;
    private ArrayList<i> iwY = new ArrayList<>();
    private p iwZ;
    private int ixa;
    private int ixb;

    /* loaded from: classes23.dex */
    public interface b {
        void JQ(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.ixa = 0;
        this.ixb = 0;
        this.eCn = tbPageContext;
        this.ixa = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.ixb = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iwY != null) {
            return this.iwY.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ya */
    public i getItem(int i) {
        if (this.iwY == null || i >= this.iwY.size()) {
            return null;
        }
        return this.iwY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).ctV();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        d dVar;
        if (getItemViewType(i) == 0) {
            if (view != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eCn.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.ixd.setVisibility(0);
                cVar2.ixe.setVisibility(8);
                cVar2.ixf.setVisibility(8);
                cVar2.ixg.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.ixd = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.ixe = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.ixf = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.ixg = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.ctW() != null && bVar.ctW().size() > 0) {
                if (bVar.isLast() && bVar.ctX()) {
                    cVar.mRoot.setPadding(this.ixa, 0, this.ixa, this.ixb);
                    if (this.iwZ != null && !this.iwZ.isEmpty()) {
                        if (bVar.ctW().size() == 2) {
                            if (bVar.ctY().equals(this.eCn.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.ixg.setVisibility(8);
                                cVar.ixf.setVisibility(8);
                            } else if (bVar.ctY().equals(this.eCn.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.ixg.setVisibility(8);
                                cVar.ixf.setVisibility(0);
                                cVar.ixf.aM(this.eCn.getResources().getString(R.string.tip_assist_apply), this.iwZ.cuh());
                                cVar.ixf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.iwW != null) {
                                            h.this.iwW.JQ(h.this.iwZ.cui());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.ctY().equals(this.eCn.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.ixe.setVisibility(8);
                            cVar.ixg.setVisibility(8);
                            cVar.ixf.setVisibility(8);
                        } else if (bVar.ctY().equals(this.eCn.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.ixe.setVisibility(8);
                            cVar.ixg.setVisibility(0);
                            cVar.ixf.setVisibility(8);
                            cVar.ixg.aM(this.eCn.getResources().getString(R.string.tip_assist_apply), this.iwZ.cuh());
                            cVar.ixg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.iwW != null) {
                                        h.this.iwW.JQ(h.this.iwZ.cui());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.ixa, 0, this.ixa, 0);
                    cVar.ixf.setVisibility(8);
                    cVar.ixg.setVisibility(8);
                }
                cVar.ixd.a(bVar.ctW().get(0));
                if (bVar.ctW().size() >= 2) {
                    cVar.ixe.a(bVar.ctW().get(1));
                    cVar.ixe.setVisibility(0);
                } else {
                    cVar.ixe.setVisibility(8);
                }
                this.eCn.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.dZZ = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eCn.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void aw(ArrayList<i> arrayList) {
        this.iwY = arrayList;
    }

    public void a(p pVar) {
        this.iwZ = pVar;
    }

    public void a(b bVar) {
        this.iwW = bVar;
    }

    /* loaded from: classes23.dex */
    public class c {
        BawuMemberInfoView ixd;
        BawuMemberInfoView ixe;
        BawuManagerApplyInfoView ixf;
        BawuManagerApplyInfoView ixg;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes23.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes23.dex */
    public class a {
        View dZZ;

        public a() {
        }
    }
}
