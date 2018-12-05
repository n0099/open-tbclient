package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int cuF;
    private b dEh;
    private ArrayList<i> dEj = new ArrayList<>();
    private p dEk;
    private int dEl;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void nO(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cuF = 0;
        this.dEl = 0;
        this.mContext = tbPageContext;
        this.cuF = l.h(tbPageContext.getPageActivity(), e.C0210e.ds24);
        this.dEl = l.h(tbPageContext.getPageActivity(), e.C0210e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dEj != null) {
            return this.dEj.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lJ */
    public i getItem(int i) {
        if (this.dEj == null || i >= this.dEj.size()) {
            return null;
        }
        return this.dEj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).azi();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(e.g.text_view_title);
                dVar2.mLine = view.findViewById(e.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.dEo.setVisibility(0);
                cVar2.dEp.setVisibility(8);
                cVar2.dEq.setVisibility(8);
                cVar2.dEr.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dEn = (RelativeLayout) view.findViewById(e.g.bawu_item_member_root);
                cVar3.dEo = (BawuMemberInfoView) view.findViewById(e.g.left_member);
                cVar3.dEp = (BawuMemberInfoView) view.findViewById(e.g.right_member);
                cVar3.dEq = (BawuManagerApplyInfoView) view.findViewById(e.g.left_manager_apply);
                cVar3.dEr = (BawuManagerApplyInfoView) view.findViewById(e.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.azj() != null && bVar.azj().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dEn.setPadding(this.cuF, 0, this.cuF, this.dEl);
                    if (this.dEk != null && !this.dEk.isEmpty()) {
                        if (bVar.azj().size() == 2) {
                            if (bVar.azk().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                                cVar.dEr.setVisibility(8);
                                cVar.dEq.setVisibility(0);
                                cVar.dEq.ab(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dEk.azv());
                                cVar.dEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dEh != null) {
                                            h.this.dEh.nO(h.this.dEk.azy());
                                        }
                                    }
                                });
                            } else if (bVar.azk().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                                cVar.dEr.setVisibility(8);
                                cVar.dEq.setVisibility(0);
                                cVar.dEq.ab(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dEk.azx());
                                cVar.dEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dEh != null) {
                                            h.this.dEh.nO(h.this.dEk.azz());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.azk().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                            cVar.dEp.setVisibility(8);
                            cVar.dEr.setVisibility(0);
                            cVar.dEq.setVisibility(8);
                            cVar.dEr.ab(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dEk.azv());
                            cVar.dEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dEh != null) {
                                        h.this.dEh.nO(h.this.dEk.azy());
                                    }
                                }
                            });
                        } else if (bVar.azk().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                            cVar.dEp.setVisibility(8);
                            cVar.dEr.setVisibility(0);
                            cVar.dEq.setVisibility(8);
                            cVar.dEr.ab(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dEk.azx());
                            cVar.dEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dEh != null) {
                                        h.this.dEh.nO(h.this.dEk.azz());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dEn.setPadding(this.cuF, 0, this.cuF, 0);
                    cVar.dEq.setVisibility(8);
                    cVar.dEr.setVisibility(8);
                }
                cVar.dEo.a(bVar.azj().get(0));
                if (bVar.azj().size() >= 2) {
                    cVar.dEp.a(bVar.azj().get(1));
                    cVar.dEp.setVisibility(0);
                } else {
                    cVar.dEp.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.mDividerView = view.findViewById(e.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.dEj = arrayList;
    }

    public void a(p pVar) {
        this.dEk = pVar;
    }

    public void a(b bVar) {
        this.dEh = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout dEn;
        BawuMemberInfoView dEo;
        BawuMemberInfoView dEp;
        BawuManagerApplyInfoView dEq;
        BawuManagerApplyInfoView dEr;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        View mLine;
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View mDividerView;

        public a() {
        }
    }
}
