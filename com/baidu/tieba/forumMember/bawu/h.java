package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class h extends BaseAdapter {
    private int dKL;
    private b eUS;
    private ArrayList<i> eUU = new ArrayList<>();
    private p eUV;
    private int eUW;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void uM(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.dKL = 0;
        this.eUW = 0;
        this.mContext = tbPageContext;
        this.dKL = l.h(tbPageContext.getPageActivity(), d.e.tbds31);
        this.eUW = l.h(tbPageContext.getPageActivity(), d.e.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUU != null) {
            return this.eUU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pG */
    public i getItem(int i) {
        if (this.eUU == null || i >= this.eUU.size()) {
            return null;
        }
        return this.eUU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).baT();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(d.g.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.eUZ.setVisibility(0);
                cVar2.eVa.setVisibility(8);
                cVar2.eVb.setVisibility(8);
                cVar2.eVc.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.eUY = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                cVar3.eUZ = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                cVar3.eVa = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                cVar3.eVb = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                cVar3.eVc = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.baU() != null && bVar.baU().size() > 0) {
                if (bVar.isLast() && bVar.baV()) {
                    cVar.eUY.setPadding(this.dKL, 0, this.dKL, this.eUW);
                    if (this.eUV != null && !this.eUV.isEmpty()) {
                        if (bVar.baU().size() == 2) {
                            if (bVar.baW().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                cVar.eVc.setVisibility(8);
                                cVar.eVb.setVisibility(0);
                                cVar.eVb.aw(this.mContext.getResources().getString(d.j.tip_manager_apply), this.eUV.bbg());
                                cVar.eVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.eUS != null) {
                                            h.this.eUS.uM(h.this.eUV.bbj());
                                        }
                                    }
                                });
                            } else if (bVar.baW().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                cVar.eVc.setVisibility(8);
                                cVar.eVb.setVisibility(0);
                                cVar.eVb.aw(this.mContext.getResources().getString(d.j.tip_assist_apply), this.eUV.bbi());
                                cVar.eVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.eUS != null) {
                                            h.this.eUS.uM(h.this.eUV.bbk());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.baW().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            cVar.eVa.setVisibility(8);
                            cVar.eVc.setVisibility(0);
                            cVar.eVb.setVisibility(8);
                            cVar.eVc.aw(this.mContext.getResources().getString(d.j.tip_manager_apply), this.eUV.bbg());
                            cVar.eVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.eUS != null) {
                                        h.this.eUS.uM(h.this.eUV.bbj());
                                    }
                                }
                            });
                        } else if (bVar.baW().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            cVar.eVa.setVisibility(8);
                            cVar.eVc.setVisibility(0);
                            cVar.eVb.setVisibility(8);
                            cVar.eVc.aw(this.mContext.getResources().getString(d.j.tip_assist_apply), this.eUV.bbi());
                            cVar.eVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.eUS != null) {
                                        h.this.eUS.uM(h.this.eUV.bbk());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.eUY.setPadding(this.dKL, 0, this.dKL, 0);
                    cVar.eVb.setVisibility(8);
                    cVar.eVc.setVisibility(8);
                }
                cVar.eUZ.a(bVar.baU().get(0));
                if (bVar.baU().size() >= 2) {
                    cVar.eVa.a(bVar.baU().get(1));
                    cVar.eVa.setVisibility(0);
                } else {
                    cVar.eVa.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bjK = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void Q(ArrayList<i> arrayList) {
        this.eUU = arrayList;
    }

    public void a(p pVar) {
        this.eUV = pVar;
    }

    public void a(b bVar) {
        this.eUS = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout eUY;
        BawuMemberInfoView eUZ;
        BawuMemberInfoView eVa;
        BawuManagerApplyInfoView eVb;
        BawuManagerApplyInfoView eVc;

        public c() {
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        View bjK;

        public a() {
        }
    }
}
