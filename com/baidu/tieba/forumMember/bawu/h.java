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
    private int cqH;
    private b dwq;
    private ArrayList<i> dws = new ArrayList<>();
    private p dwt;
    private int dwu;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void no(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cqH = 0;
        this.dwu = 0;
        this.mContext = tbPageContext;
        this.cqH = l.h(tbPageContext.getPageActivity(), e.C0175e.ds24);
        this.dwu = l.h(tbPageContext.getPageActivity(), e.C0175e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dws != null) {
            return this.dws.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lb */
    public i getItem(int i) {
        if (this.dws == null || i >= this.dws.size()) {
            return null;
        }
        return this.dws.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).aya();
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
                cVar2.dwx.setVisibility(0);
                cVar2.dwy.setVisibility(8);
                cVar2.dwz.setVisibility(8);
                cVar2.dwA.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dww = (RelativeLayout) view.findViewById(e.g.bawu_item_member_root);
                cVar3.dwx = (BawuMemberInfoView) view.findViewById(e.g.left_member);
                cVar3.dwy = (BawuMemberInfoView) view.findViewById(e.g.right_member);
                cVar3.dwz = (BawuManagerApplyInfoView) view.findViewById(e.g.left_manager_apply);
                cVar3.dwA = (BawuManagerApplyInfoView) view.findViewById(e.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.ayb() != null && bVar.ayb().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dww.setPadding(this.cqH, 0, this.cqH, this.dwu);
                    if (this.dwt != null && !this.dwt.isEmpty()) {
                        if (bVar.ayb().size() == 2) {
                            if (bVar.ayc().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                                cVar.dwA.setVisibility(8);
                                cVar.dwz.setVisibility(0);
                                cVar.dwz.aa(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dwt.ayn());
                                cVar.dwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dwq != null) {
                                            h.this.dwq.no(h.this.dwt.ayq());
                                        }
                                    }
                                });
                            } else if (bVar.ayc().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                                cVar.dwA.setVisibility(8);
                                cVar.dwz.setVisibility(0);
                                cVar.dwz.aa(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dwt.ayp());
                                cVar.dwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.dwq != null) {
                                            h.this.dwq.no(h.this.dwt.ayr());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.ayc().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                            cVar.dwy.setVisibility(8);
                            cVar.dwA.setVisibility(0);
                            cVar.dwz.setVisibility(8);
                            cVar.dwA.aa(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dwt.ayn());
                            cVar.dwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dwq != null) {
                                        h.this.dwq.no(h.this.dwt.ayq());
                                    }
                                }
                            });
                        } else if (bVar.ayc().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                            cVar.dwy.setVisibility(8);
                            cVar.dwA.setVisibility(0);
                            cVar.dwz.setVisibility(8);
                            cVar.dwA.aa(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dwt.ayp());
                            cVar.dwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.dwq != null) {
                                        h.this.dwq.no(h.this.dwt.ayr());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dww.setPadding(this.cqH, 0, this.cqH, 0);
                    cVar.dwz.setVisibility(8);
                    cVar.dwA.setVisibility(8);
                }
                cVar.dwx.a(bVar.ayb().get(0));
                if (bVar.ayb().size() >= 2) {
                    cVar.dwy.a(bVar.ayb().get(1));
                    cVar.dwy.setVisibility(0);
                } else {
                    cVar.dwy.setVisibility(8);
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
        this.dws = arrayList;
    }

    public void a(p pVar) {
        this.dwt = pVar;
    }

    public void a(b bVar) {
        this.dwq = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        BawuManagerApplyInfoView dwA;
        RelativeLayout dww;
        BawuMemberInfoView dwx;
        BawuMemberInfoView dwy;
        BawuManagerApplyInfoView dwz;

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
