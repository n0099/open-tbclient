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
    private int dKd;
    private b eUF;
    private ArrayList<i> eUH = new ArrayList<>();
    private p eUI;
    private int eUJ;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void uL(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.dKd = 0;
        this.eUJ = 0;
        this.mContext = tbPageContext;
        this.dKd = l.h(tbPageContext.getPageActivity(), d.e.tbds31);
        this.eUJ = l.h(tbPageContext.getPageActivity(), d.e.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUH != null) {
            return this.eUH.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pC */
    public i getItem(int i) {
        if (this.eUH == null || i >= this.eUH.size()) {
            return null;
        }
        return this.eUH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).baR();
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
                cVar2.eUM.setVisibility(0);
                cVar2.eUN.setVisibility(8);
                cVar2.eUO.setVisibility(8);
                cVar2.eUP.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.eUL = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                cVar3.eUM = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                cVar3.eUN = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                cVar3.eUO = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                cVar3.eUP = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.baS() != null && bVar.baS().size() > 0) {
                if (bVar.isLast() && bVar.baT()) {
                    cVar.eUL.setPadding(this.dKd, 0, this.dKd, this.eUJ);
                    if (this.eUI != null && !this.eUI.isEmpty()) {
                        if (bVar.baS().size() == 2) {
                            if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                cVar.eUP.setVisibility(8);
                                cVar.eUO.setVisibility(0);
                                cVar.eUO.aw(this.mContext.getResources().getString(d.j.tip_manager_apply), this.eUI.bbe());
                                cVar.eUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.eUF != null) {
                                            h.this.eUF.uL(h.this.eUI.bbh());
                                        }
                                    }
                                });
                            } else if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                cVar.eUP.setVisibility(8);
                                cVar.eUO.setVisibility(0);
                                cVar.eUO.aw(this.mContext.getResources().getString(d.j.tip_assist_apply), this.eUI.bbg());
                                cVar.eUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.eUF != null) {
                                            h.this.eUF.uL(h.this.eUI.bbi());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            cVar.eUN.setVisibility(8);
                            cVar.eUP.setVisibility(0);
                            cVar.eUO.setVisibility(8);
                            cVar.eUP.aw(this.mContext.getResources().getString(d.j.tip_manager_apply), this.eUI.bbe());
                            cVar.eUP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.eUF != null) {
                                        h.this.eUF.uL(h.this.eUI.bbh());
                                    }
                                }
                            });
                        } else if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            cVar.eUN.setVisibility(8);
                            cVar.eUP.setVisibility(0);
                            cVar.eUO.setVisibility(8);
                            cVar.eUP.aw(this.mContext.getResources().getString(d.j.tip_assist_apply), this.eUI.bbg());
                            cVar.eUP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.eUF != null) {
                                        h.this.eUF.uL(h.this.eUI.bbi());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.eUL.setPadding(this.dKd, 0, this.dKd, 0);
                    cVar.eUO.setVisibility(8);
                    cVar.eUP.setVisibility(8);
                }
                cVar.eUM.a(bVar.baS().get(0));
                if (bVar.baS().size() >= 2) {
                    cVar.eUN.a(bVar.baS().get(1));
                    cVar.eUN.setVisibility(0);
                } else {
                    cVar.eUN.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bjO = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void Q(ArrayList<i> arrayList) {
        this.eUH = arrayList;
    }

    public void a(p pVar) {
        this.eUI = pVar;
    }

    public void a(b bVar) {
        this.eUF = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout eUL;
        BawuMemberInfoView eUM;
        BawuMemberInfoView eUN;
        BawuManagerApplyInfoView eUO;
        BawuManagerApplyInfoView eUP;

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
        View bjO;

        public a() {
        }
    }
}
