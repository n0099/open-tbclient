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
    private int dKc;
    private b eUE;
    private ArrayList<i> eUG = new ArrayList<>();
    private p eUH;
    private int eUI;
    private TbPageContext<?> mContext;

    /* loaded from: classes5.dex */
    public interface b {
        void uL(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.dKc = 0;
        this.eUI = 0;
        this.mContext = tbPageContext;
        this.dKc = l.h(tbPageContext.getPageActivity(), d.e.tbds31);
        this.eUI = l.h(tbPageContext.getPageActivity(), d.e.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUG != null) {
            return this.eUG.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pC */
    public i getItem(int i) {
        if (this.eUG == null || i >= this.eUG.size()) {
            return null;
        }
        return this.eUG.get(i);
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
                cVar2.eUL.setVisibility(0);
                cVar2.eUM.setVisibility(8);
                cVar2.eUN.setVisibility(8);
                cVar2.eUO.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.eUK = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                cVar3.eUL = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                cVar3.eUM = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                cVar3.eUN = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                cVar3.eUO = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.baS() != null && bVar.baS().size() > 0) {
                if (bVar.isLast() && bVar.baT()) {
                    cVar.eUK.setPadding(this.dKc, 0, this.dKc, this.eUI);
                    if (this.eUH != null && !this.eUH.isEmpty()) {
                        if (bVar.baS().size() == 2) {
                            if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                cVar.eUO.setVisibility(8);
                                cVar.eUN.setVisibility(0);
                                cVar.eUN.aw(this.mContext.getResources().getString(d.j.tip_manager_apply), this.eUH.bbe());
                                cVar.eUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.eUE != null) {
                                            h.this.eUE.uL(h.this.eUH.bbh());
                                        }
                                    }
                                });
                            } else if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                cVar.eUO.setVisibility(8);
                                cVar.eUN.setVisibility(0);
                                cVar.eUN.aw(this.mContext.getResources().getString(d.j.tip_assist_apply), this.eUH.bbg());
                                cVar.eUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.eUE != null) {
                                            h.this.eUE.uL(h.this.eUH.bbi());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            cVar.eUM.setVisibility(8);
                            cVar.eUO.setVisibility(0);
                            cVar.eUN.setVisibility(8);
                            cVar.eUO.aw(this.mContext.getResources().getString(d.j.tip_manager_apply), this.eUH.bbe());
                            cVar.eUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.eUE != null) {
                                        h.this.eUE.uL(h.this.eUH.bbh());
                                    }
                                }
                            });
                        } else if (bVar.baU().equals(this.mContext.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            cVar.eUM.setVisibility(8);
                            cVar.eUO.setVisibility(0);
                            cVar.eUN.setVisibility(8);
                            cVar.eUO.aw(this.mContext.getResources().getString(d.j.tip_assist_apply), this.eUH.bbg());
                            cVar.eUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.eUE != null) {
                                        h.this.eUE.uL(h.this.eUH.bbi());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.eUK.setPadding(this.dKc, 0, this.dKc, 0);
                    cVar.eUN.setVisibility(8);
                    cVar.eUO.setVisibility(8);
                }
                cVar.eUL.a(bVar.baS().get(0));
                if (bVar.baS().size() >= 2) {
                    cVar.eUM.a(bVar.baS().get(1));
                    cVar.eUM.setVisibility(0);
                } else {
                    cVar.eUM.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.bjN = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void Q(ArrayList<i> arrayList) {
        this.eUG = arrayList;
    }

    public void a(p pVar) {
        this.eUH = pVar;
    }

    public void a(b bVar) {
        this.eUE = bVar;
    }

    /* loaded from: classes5.dex */
    public class c {
        RelativeLayout eUK;
        BawuMemberInfoView eUL;
        BawuMemberInfoView eUM;
        BawuManagerApplyInfoView eUN;
        BawuManagerApplyInfoView eUO;

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
        View bjN;

        public a() {
        }
    }
}
