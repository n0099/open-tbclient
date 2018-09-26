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
    private int cif;
    private b doo;
    private ArrayList<i> doq = new ArrayList<>();
    private p dor;
    private int dos;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void mM(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cif = 0;
        this.dos = 0;
        this.mContext = tbPageContext;
        this.cif = l.h(tbPageContext.getPageActivity(), e.C0141e.ds24);
        this.dos = l.h(tbPageContext.getPageActivity(), e.C0141e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.doq != null) {
            return this.doq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kD */
    public i getItem(int i) {
        if (this.doq == null || i >= this.doq.size()) {
            return null;
        }
        return this.doq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).auE();
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
                cVar2.dov.setVisibility(0);
                cVar2.dow.setVisibility(8);
                cVar2.dox.setVisibility(8);
                cVar2.doy.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.dou = (RelativeLayout) view.findViewById(e.g.bawu_item_member_root);
                cVar3.dov = (BawuMemberInfoView) view.findViewById(e.g.left_member);
                cVar3.dow = (BawuMemberInfoView) view.findViewById(e.g.right_member);
                cVar3.dox = (BawuManagerApplyInfoView) view.findViewById(e.g.left_manager_apply);
                cVar3.doy = (BawuManagerApplyInfoView) view.findViewById(e.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.auF() != null && bVar.auF().size() > 0) {
                if (bVar.isLast()) {
                    cVar.dou.setPadding(this.cif, 0, this.cif, this.dos);
                    if (this.dor != null && !this.dor.isEmpty()) {
                        if (bVar.auF().size() == 2) {
                            if (bVar.auG().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                                cVar.doy.setVisibility(8);
                                cVar.dox.setVisibility(0);
                                cVar.dox.W(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dor.auR());
                                cVar.dox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.doo != null) {
                                            h.this.doo.mM(h.this.dor.auU());
                                        }
                                    }
                                });
                            } else if (bVar.auG().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                                cVar.doy.setVisibility(8);
                                cVar.dox.setVisibility(0);
                                cVar.dox.W(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dor.auT());
                                cVar.dox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.doo != null) {
                                            h.this.doo.mM(h.this.dor.auV());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.auG().equals(this.mContext.getResources().getString(e.j.bawu_member_bazhu_tip))) {
                            cVar.dow.setVisibility(8);
                            cVar.doy.setVisibility(0);
                            cVar.dox.setVisibility(8);
                            cVar.doy.W(this.mContext.getResources().getString(e.j.tip_manager_apply), this.dor.auR());
                            cVar.doy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.doo != null) {
                                        h.this.doo.mM(h.this.dor.auU());
                                    }
                                }
                            });
                        } else if (bVar.auG().equals(this.mContext.getResources().getString(e.j.bawu_member_xbazhu_tip))) {
                            cVar.dow.setVisibility(8);
                            cVar.doy.setVisibility(0);
                            cVar.dox.setVisibility(8);
                            cVar.doy.W(this.mContext.getResources().getString(e.j.tip_assist_apply), this.dor.auT());
                            cVar.doy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.doo != null) {
                                        h.this.doo.mM(h.this.dor.auV());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.dou.setPadding(this.cif, 0, this.cif, 0);
                    cVar.dox.setVisibility(8);
                    cVar.doy.setVisibility(8);
                }
                cVar.dov.a(bVar.auF().get(0));
                if (bVar.auF().size() >= 2) {
                    cVar.dow.a(bVar.auF().get(1));
                    cVar.dow.setVisibility(0);
                } else {
                    cVar.dow.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.daE = view.findViewById(e.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void N(ArrayList<i> arrayList) {
        this.doq = arrayList;
    }

    public void a(p pVar) {
        this.dor = pVar;
    }

    public void a(b bVar) {
        this.doo = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout dou;
        BawuMemberInfoView dov;
        BawuMemberInfoView dow;
        BawuManagerApplyInfoView dox;
        BawuManagerApplyInfoView doy;

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
        View daE;

        public a() {
        }
    }
}
